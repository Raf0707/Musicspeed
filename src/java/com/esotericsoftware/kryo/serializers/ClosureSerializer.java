/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.invoke.SerializedLambda
 *  java.lang.reflect.Method
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

public class ClosureSerializer
extends Serializer {
    private static Method readResolve;
    private static Class serializedLambda;

    static {
        serializedLambda = SerializedLambda.class;
        try {
            Method method;
            readResolve = method = SerializedLambda.class.getDeclaredMethod("readResolve", new Class[0]);
            method.setAccessible(true);
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not obtain SerializedLambda or its methods via reflection", (Throwable)exception);
        }
    }

    public Object copy(Kryo kryo, Object object) {
        try {
            Method method = object.getClass().getDeclaredMethod("writeReplace", new Class[0]);
            method.setAccessible(true);
            Object object2 = method.invoke(object, new Object[0]);
            if (serializedLambda.isInstance(object2)) {
                return readResolve.invoke(object2, new Object[0]);
            }
            throw new RuntimeException("Could not serialize lambda");
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not serialize lambda", (Throwable)exception);
        }
    }

    public Object read(Kryo kryo, Input input, Class class_) {
        try {
            Object object = kryo.readObject(input, serializedLambda);
            Object object2 = readResolve.invoke(object, new Object[0]);
            return object2;
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not serialize lambda", (Throwable)exception);
        }
    }

    public void write(Kryo kryo, Output output, Object object) {
        try {
            Method method = object.getClass().getDeclaredMethod("writeReplace", new Class[0]);
            method.setAccessible(true);
            Object object2 = method.invoke(object, new Object[0]);
            if (serializedLambda.isInstance(object2)) {
                kryo.writeObject(output, object2);
                return;
            }
            throw new RuntimeException("Could not serialize lambda");
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not serialize lambda", (Throwable)exception);
        }
    }
}

