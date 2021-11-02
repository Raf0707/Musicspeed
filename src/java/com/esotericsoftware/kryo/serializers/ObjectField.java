/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
 *  com.esotericsoftware.minlog.Log
 *  com.esotericsoftware.reflectasm.FieldAccess
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.FieldAccess;
import java.lang.reflect.Field;

class ObjectField
extends FieldSerializer.CachedField {
    final FieldSerializer fieldSerializer;
    public Class[] generics;
    final Kryo kryo;
    final Class type;

    ObjectField(FieldSerializer fieldSerializer) {
        this.fieldSerializer = fieldSerializer;
        this.kryo = fieldSerializer.kryo;
        this.type = fieldSerializer.type;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void copy(Object object, Object object2) {
        try {
            int n2 = this.accessIndex;
            if (n2 != -1) {
                FieldAccess fieldAccess = (FieldAccess)this.fieldSerializer.access;
                fieldAccess.set(object2, n2, this.kryo.copy(fieldAccess.get(object, n2)));
                return;
            }
            this.setField(object2, this.kryo.copy(this.getField(object)));
            return;
        }
        catch (RuntimeException runtimeException) {
            KryoException kryoException = new KryoException((Throwable)runtimeException);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)this);
            stringBuilder.append(" (");
            stringBuilder.append(this.type.getName());
            stringBuilder.append(")");
            kryoException.addTrace(stringBuilder.toString());
            throw kryoException;
        }
        catch (KryoException kryoException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)this);
            stringBuilder.append(" (");
            stringBuilder.append(this.type.getName());
            stringBuilder.append(")");
            kryoException.addTrace(stringBuilder.toString());
            throw kryoException;
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error accessing field: ");
            stringBuilder.append((Object)this);
            stringBuilder.append(" (");
            stringBuilder.append(this.type.getName());
            stringBuilder.append(")");
            throw new KryoException(stringBuilder.toString(), (Throwable)illegalAccessException);
        }
    }

    public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
        return this.field.get(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void read(Input input, Object object) {
        try {
            Object object2;
            if (Log.TRACE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Read field: ");
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(") pos=");
                stringBuilder.append(input.position());
                Log.trace((String)"kryo", (String)stringBuilder.toString());
            }
            Class class_ = this.valueClass;
            Serializer serializer = this.serializer;
            if (class_ == null) {
                Registration registration = this.kryo.readClass(input);
                if (registration == null) {
                    object2 = null;
                } else {
                    if (serializer == null) {
                        serializer = registration.getSerializer();
                    }
                    serializer.setGenerics(this.kryo, this.generics);
                    object2 = this.kryo.readObject(input, registration.getType(), serializer);
                }
            } else {
                if (serializer == null) {
                    this.serializer = serializer = this.kryo.getSerializer(class_);
                }
                serializer.setGenerics(this.kryo, this.generics);
                object2 = this.canBeNull ? this.kryo.readObjectOrNull(input, class_, serializer) : this.kryo.readObject(input, class_, serializer);
            }
            this.setField(object, object2);
            return;
        }
        catch (RuntimeException runtimeException) {
            KryoException kryoException = new KryoException((Throwable)runtimeException);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)this);
            stringBuilder.append(" (");
            stringBuilder.append(this.type.getName());
            stringBuilder.append(")");
            kryoException.addTrace(stringBuilder.toString());
            throw kryoException;
        }
        catch (KryoException kryoException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)this);
            stringBuilder.append(" (");
            stringBuilder.append(this.type.getName());
            stringBuilder.append(")");
            kryoException.addTrace(stringBuilder.toString());
            throw kryoException;
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error accessing field: ");
            stringBuilder.append((Object)this);
            stringBuilder.append(" (");
            stringBuilder.append(this.type.getName());
            stringBuilder.append(")");
            throw new KryoException(stringBuilder.toString(), (Throwable)illegalAccessException);
        }
    }

    public void setField(Object object, Object object2) throws IllegalArgumentException, IllegalAccessException {
        this.field.set(object, object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(Output output, Object object) {
        try {
            if (Log.TRACE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Write field: ");
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(object.getClass().getName());
                stringBuilder.append(") pos=");
                stringBuilder.append(output.position());
                Log.trace((String)"kryo", (String)stringBuilder.toString());
            }
            Object object2 = this.getField(object);
            Serializer serializer = this.serializer;
            Class class_ = this.valueClass;
            if (class_ == null) {
                if (object2 == null) {
                    this.kryo.writeClass(output, null);
                    return;
                }
                Registration registration = this.kryo.writeClass(output, object2.getClass());
                if (serializer == null) {
                    serializer = registration.getSerializer();
                }
                serializer.setGenerics(this.kryo, this.generics);
                this.kryo.writeObject(output, object2, serializer);
                return;
            }
            if (serializer == null) {
                this.serializer = serializer = this.kryo.getSerializer(class_);
            }
            serializer.setGenerics(this.kryo, this.generics);
            if (this.canBeNull) {
                this.kryo.writeObjectOrNull(output, object2, serializer);
                return;
            }
            if (object2 != null) {
                this.kryo.writeObject(output, object2, serializer);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field value is null but canBeNull is false: ");
            stringBuilder.append((Object)this);
            stringBuilder.append(" (");
            stringBuilder.append(object.getClass().getName());
            stringBuilder.append(")");
            throw new KryoException(stringBuilder.toString());
        }
        catch (RuntimeException runtimeException) {
            KryoException kryoException = new KryoException((Throwable)runtimeException);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append((Object)this);
            stringBuilder2.append(" (");
            stringBuilder2.append(object.getClass().getName());
            stringBuilder2.append(")");
            kryoException.addTrace(stringBuilder2.toString());
            throw kryoException;
        }
        catch (KryoException kryoException) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append((Object)this);
            stringBuilder3.append(" (");
            stringBuilder3.append(object.getClass().getName());
            stringBuilder3.append(")");
            kryoException.addTrace(stringBuilder3.toString());
            throw kryoException;
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Error accessing field: ");
            stringBuilder4.append((Object)this);
            stringBuilder4.append(" (");
            stringBuilder4.append(object.getClass().getName());
            stringBuilder4.append(")");
            throw new KryoException(stringBuilder4.toString(), (Throwable)illegalAccessException);
        }
    }

    static final class ObjectBooleanField
    extends ObjectField {
        public ObjectBooleanField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                Field field = this.field;
                field.setBoolean(object2, field.getBoolean(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return this.field.getBoolean(object);
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setBoolean(object, input.readBoolean());
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeBoolean(this.field.getBoolean(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }
    }

    static final class ObjectByteField
    extends ObjectField {
        public ObjectByteField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                Field field = this.field;
                field.setByte(object2, field.getByte(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return this.field.getByte(object);
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setByte(object, input.readByte());
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeByte(this.field.getByte(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }
    }

    static final class ObjectCharField
    extends ObjectField {
        public ObjectCharField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                Field field = this.field;
                field.setChar(object2, field.getChar(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return Character.valueOf((char)this.field.getChar(object));
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setChar(object, input.readChar());
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeChar(this.field.getChar(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }
    }

    static final class ObjectDoubleField
    extends ObjectField {
        public ObjectDoubleField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                Field field = this.field;
                field.setDouble(object2, field.getDouble(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return this.field.getDouble(object);
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setDouble(object, input.readDouble());
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeDouble(this.field.getDouble(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }
    }

    static final class ObjectFloatField
    extends ObjectField {
        public ObjectFloatField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                Field field = this.field;
                field.setFloat(object2, field.getFloat(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return Float.valueOf((float)this.field.getFloat(object));
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setFloat(object, input.readFloat());
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeFloat(this.field.getFloat(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }
    }

    static final class ObjectIntField
    extends ObjectField {
        public ObjectIntField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                Field field = this.field;
                field.setInt(object2, field.getInt(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return this.field.getInt(object);
        }

        @Override
        public void read(Input input, Object object) {
            try {
                if (this.varIntsEnabled) {
                    this.field.setInt(object, input.readInt(false));
                    return;
                }
                this.field.setInt(object, input.readInt());
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public void write(Output output, Object object) {
            try {
                if (this.varIntsEnabled) {
                    output.writeInt(this.field.getInt(object), false);
                    return;
                }
                output.writeInt(this.field.getInt(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }
    }

    static final class ObjectLongField
    extends ObjectField {
        public ObjectLongField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                Field field = this.field;
                field.setLong(object2, field.getLong(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return this.field.getLong(object);
        }

        @Override
        public void read(Input input, Object object) {
            try {
                if (this.varIntsEnabled) {
                    this.field.setLong(object, input.readLong(false));
                    return;
                }
                this.field.setLong(object, input.readLong());
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public void write(Output output, Object object) {
            try {
                if (this.varIntsEnabled) {
                    output.writeLong(this.field.getLong(object), false);
                    return;
                }
                output.writeLong(this.field.getLong(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }
    }

    static final class ObjectShortField
    extends ObjectField {
        public ObjectShortField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                Field field = this.field;
                field.setShort(object2, field.getShort(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return this.field.getShort(object);
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setShort(object, input.readShort());
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeShort((int)this.field.getShort(object));
                return;
            }
            catch (Exception exception) {
                KryoException kryoException = new KryoException((Throwable)exception);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" (");
                stringBuilder.append(this.type.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }
    }

}

