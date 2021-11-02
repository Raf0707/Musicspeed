/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.factories.SerializerFactory
 *  com.esotericsoftware.kryo.util.Util
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 */
package com.esotericsoftware.kryo.factories;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.factories.SerializerFactory;
import com.esotericsoftware.kryo.util.Util;
import java.lang.reflect.Constructor;

public class ReflectionSerializerFactory
implements SerializerFactory {
    private final Class<? extends Serializer> serializerClass;

    public ReflectionSerializerFactory(Class<? extends Serializer> class_) {
        this.serializerClass = class_;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Serializer makeSerializer(Kryo kryo, Class<? extends Serializer> class_, Class<?> class_2) {
        Exception exception2222;
        block8 : {
            try {
                return (Serializer)class_.getConstructor(new Class[]{Kryo.class, Class.class}).newInstance(new Object[]{kryo, class_2});
            }
            catch (Exception exception2222) {
                break block8;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                try {
                    return (Serializer)class_.getConstructor(new Class[]{Kryo.class}).newInstance(new Object[]{kryo});
                }
                catch (NoSuchMethodException noSuchMethodException2) {
                    try {
                        return (Serializer)class_.getConstructor(new Class[]{Class.class}).newInstance(new Object[]{class_2});
                    }
                    catch (NoSuchMethodException noSuchMethodException3) {
                        return (Serializer)class_.newInstance();
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to create serializer \"");
        stringBuilder.append(class_.getName());
        stringBuilder.append("\" for class: ");
        stringBuilder.append(Util.className(class_2));
        throw new IllegalArgumentException(stringBuilder.toString(), (Throwable)exception2222);
    }

    public Serializer makeSerializer(Kryo kryo, Class<?> class_) {
        return ReflectionSerializerFactory.makeSerializer(kryo, this.serializerClass, class_);
    }
}

