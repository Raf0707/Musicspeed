/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.ClassResolver
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.util.IdentityObjectIntMap
 *  com.esotericsoftware.kryo.util.IntMap
 *  com.esotericsoftware.kryo.util.ObjectMap
 *  com.esotericsoftware.kryo.util.Util
 *  com.esotericsoftware.minlog.Log
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.ClassResolver;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.IdentityObjectIntMap;
import com.esotericsoftware.kryo.util.IntMap;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;

public class DefaultClassResolver
implements ClassResolver {
    public static final byte NAME = -1;
    protected IdentityObjectIntMap<Class> classToNameId;
    protected final ObjectMap<Class, Registration> classToRegistration = new ObjectMap();
    protected final IntMap<Registration> idToRegistration = new IntMap();
    protected Kryo kryo;
    private Class memoizedClass;
    private int memoizedClassId = -1;
    private Registration memoizedClassIdValue;
    private Registration memoizedClassValue;
    protected IntMap<Class> nameIdToClass;
    protected ObjectMap<String, Class> nameToClass;
    protected int nextNameId;

    public Registration getRegistration(int n2) {
        return (Registration)this.idToRegistration.get(n2);
    }

    public Registration getRegistration(Class class_) {
        if (class_ == this.memoizedClass) {
            return this.memoizedClassValue;
        }
        Registration registration = (Registration)this.classToRegistration.get((Object)class_);
        if (registration != null) {
            this.memoizedClass = class_;
            this.memoizedClassValue = registration;
        }
        return registration;
    }

    protected Class<?> getTypeByName(String string) {
        ObjectMap<String, Class> objectMap = this.nameToClass;
        if (objectMap != null) {
            return (Class)objectMap.get((Object)string);
        }
        return null;
    }

    public Registration readClass(Input input) {
        int n2 = input.readVarInt(true);
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 == this.memoizedClassId) {
                    return this.memoizedClassIdValue;
                }
                IntMap<Registration> intMap = this.idToRegistration;
                int n3 = n2 - 2;
                Registration registration = (Registration)intMap.get(n3);
                if (registration != null) {
                    if (Log.TRACE) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Read class ");
                        stringBuilder.append(n3);
                        stringBuilder.append(": ");
                        stringBuilder.append(Util.className((Class)registration.getType()));
                        Log.trace((String)"kryo", (String)stringBuilder.toString());
                    }
                    this.memoizedClassId = n2;
                    this.memoizedClassIdValue = registration;
                    return registration;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Encountered unregistered class ID: ");
                stringBuilder.append(n3);
                throw new KryoException(stringBuilder.toString());
            }
            return this.readName(input);
        }
        if (Log.TRACE || Log.DEBUG && this.kryo.getDepth() == 1) {
            Util.log((String)"Read", null);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected Registration readName(Input input) {
        int n2;
        String string;
        Class class_;
        block8 : {
            n2 = input.readVarInt(true);
            if (this.nameIdToClass == null) {
                this.nameIdToClass = new IntMap();
            }
            if ((class_ = (Class)this.nameIdToClass.get(n2)) != null) {
                if (!Log.TRACE) return this.kryo.getRegistration(class_);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Read class name reference ");
                stringBuilder.append(n2);
                stringBuilder.append(": ");
                stringBuilder.append(Util.className((Class)class_));
                Log.trace((String)"kryo", (String)stringBuilder.toString());
                return this.kryo.getRegistration(class_);
            }
            string = input.readString();
            class_ = this.getTypeByName(string);
            if (class_ != null) break block8;
            try {
                class_ = Class.forName((String)string, (boolean)false, (ClassLoader)this.kryo.getClassLoader());
            }
            catch (ClassNotFoundException classNotFoundException) {
                if (Log.WARN) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to load class ");
                    stringBuilder.append(string);
                    stringBuilder.append(" with kryo's ClassLoader. Retrying with current..");
                    Log.warn((String)"kryo", (String)stringBuilder.toString());
                }
                try {
                    class_ = Class.forName((String)string);
                }
                catch (ClassNotFoundException classNotFoundException2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to find class: ");
                    stringBuilder.append(string);
                    throw new KryoException(stringBuilder.toString(), (Throwable)classNotFoundException);
                }
            }
            if (this.nameToClass == null) {
                this.nameToClass = new ObjectMap();
            }
            this.nameToClass.put((Object)string, (Object)class_);
        }
        this.nameIdToClass.put(n2, class_);
        if (!Log.TRACE) return this.kryo.getRegistration(class_);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Read class name: ");
        stringBuilder.append(string);
        Log.trace((String)"kryo", (String)stringBuilder.toString());
        return this.kryo.getRegistration(class_);
    }

    public Registration register(Registration registration) {
        if (registration != null) {
            if (registration.getId() != -1) {
                if (Log.TRACE) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Register class ID ");
                    stringBuilder.append(registration.getId());
                    stringBuilder.append(": ");
                    stringBuilder.append(Util.className((Class)registration.getType()));
                    stringBuilder.append(" (");
                    stringBuilder.append(registration.getSerializer().getClass().getName());
                    stringBuilder.append(")");
                    Log.trace((String)"kryo", (String)stringBuilder.toString());
                }
                this.idToRegistration.put(registration.getId(), (Object)registration);
            } else if (Log.TRACE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Register class name: ");
                stringBuilder.append(Util.className((Class)registration.getType()));
                stringBuilder.append(" (");
                stringBuilder.append(registration.getSerializer().getClass().getName());
                stringBuilder.append(")");
                Log.trace((String)"kryo", (String)stringBuilder.toString());
            }
            this.classToRegistration.put((Object)registration.getType(), (Object)registration);
            if (registration.getType().isPrimitive()) {
                this.classToRegistration.put((Object)Util.getWrapperClass((Class)registration.getType()), (Object)registration);
            }
            return registration;
        }
        throw new IllegalArgumentException("registration cannot be null.");
    }

    public Registration registerImplicit(Class class_) {
        return this.register(new Registration(class_, this.kryo.getDefaultSerializer(class_), -1));
    }

    public void reset() {
        if (!this.kryo.isRegistrationRequired()) {
            IntMap<Class> intMap;
            IdentityObjectIntMap<Class> identityObjectIntMap = this.classToNameId;
            if (identityObjectIntMap != null) {
                identityObjectIntMap.clear();
            }
            if ((intMap = this.nameIdToClass) != null) {
                intMap.clear();
            }
            this.nextNameId = 0;
        }
    }

    public void setKryo(Kryo kryo) {
        this.kryo = kryo;
    }

    public Registration writeClass(Output output, Class class_) {
        if (class_ == null) {
            if (Log.TRACE || Log.DEBUG && this.kryo.getDepth() == 1) {
                Util.log((String)"Write", null);
            }
            output.writeVarInt(0, true);
            return null;
        }
        Registration registration = this.kryo.getRegistration(class_);
        if (registration.getId() == -1) {
            this.writeName(output, class_, registration);
            return registration;
        }
        if (Log.TRACE) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Write class ");
            stringBuilder.append(registration.getId());
            stringBuilder.append(": ");
            stringBuilder.append(Util.className((Class)class_));
            Log.trace((String)"kryo", (String)stringBuilder.toString());
        }
        output.writeVarInt(2 + registration.getId(), true);
        return registration;
    }

    protected void writeName(Output output, Class class_, Registration registration) {
        int n2;
        output.writeVarInt(1, true);
        IdentityObjectIntMap<Class> identityObjectIntMap = this.classToNameId;
        if (identityObjectIntMap != null && (n2 = identityObjectIntMap.get((Object)class_, -1)) != -1) {
            if (Log.TRACE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Write class name reference ");
                stringBuilder.append(n2);
                stringBuilder.append(": ");
                stringBuilder.append(Util.className((Class)class_));
                Log.trace((String)"kryo", (String)stringBuilder.toString());
            }
            output.writeVarInt(n2, true);
            return;
        }
        if (Log.TRACE) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Write class name: ");
            stringBuilder.append(Util.className((Class)class_));
            Log.trace((String)"kryo", (String)stringBuilder.toString());
        }
        int n3 = this.nextNameId;
        this.nextNameId = n3 + 1;
        if (this.classToNameId == null) {
            this.classToNameId = new IdentityObjectIntMap();
        }
        this.classToNameId.put((Object)class_, n3);
        output.writeVarInt(n3, true);
        output.writeString(class_.getName());
    }
}

