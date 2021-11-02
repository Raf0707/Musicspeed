/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.io.PrintStream
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Proxy
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxySerializer
extends Serializer<Object> {
    public Object copy(Kryo kryo, Object object) {
        return Proxy.newProxyInstance((ClassLoader)kryo.getClassLoader(), (Class[])object.getClass().getInterfaces(), (InvocationHandler)Proxy.getInvocationHandler((Object)object));
    }

    public Object read(Kryo kryo, Input input, Class<Object> class_) {
        InvocationHandler invocationHandler = (InvocationHandler)kryo.readClassAndObject(input);
        Class[] arrclass = (Class[])kryo.readObject(input, Class[].class);
        ClassLoader classLoader = kryo.getClassLoader();
        try {
            Object object = Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])arrclass, (InvocationHandler)invocationHandler);
            return object;
        }
        catch (RuntimeException runtimeException) {
            PrintStream printStream = System.err;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getName());
            stringBuilder.append(".read:\nCould not create proxy using classLoader ");
            stringBuilder.append((Object)classLoader);
            stringBuilder.append(", have invocationhandler.classloader: ");
            stringBuilder.append((Object)invocationHandler.getClass().getClassLoader());
            stringBuilder.append(" have contextclassloader: ");
            stringBuilder.append((Object)Thread.currentThread().getContextClassLoader());
            printStream.println(stringBuilder.toString());
            throw runtimeException;
        }
    }

    public void write(Kryo kryo, Output output, Object object) {
        kryo.writeClassAndObject(output, (Object)Proxy.getInvocationHandler((Object)object));
        kryo.writeObject(output, (Object)object.getClass().getInterfaces());
    }
}

