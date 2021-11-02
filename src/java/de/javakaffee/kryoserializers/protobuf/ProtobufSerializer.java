/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.protobuf.GeneratedMessage
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package de.javakaffee.kryoserializers.protobuf;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.protobuf.GeneratedMessage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProtobufSerializer<T extends GeneratedMessage>
extends Serializer<T> {
    private Method parseFromMethod = null;

    private Method getParseFromMethod(Class<T> class_) throws NoSuchMethodException {
        if (this.parseFromMethod == null) {
            this.parseFromMethod = class_.getMethod("parseFrom", new Class[]{byte[].class});
        }
        return this.parseFromMethod;
    }

    public boolean getAcceptsNull() {
        return true;
    }

    public T read(Kryo kryo, Input input, Class<T> class_) {
        GeneratedMessage generatedMessage;
        int n2 = input.readInt(true);
        if (n2 == 0) {
            return null;
        }
        byte[] arrby = input.readBytes(n2 - 1);
        try {
            generatedMessage = (GeneratedMessage)this.getParseFromMethod(class_).invoke(class_, new Object[]{arrby});
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to deserialize protobuf ");
            stringBuilder.append(illegalAccessException.getMessage());
            throw new RuntimeException(stringBuilder.toString(), (Throwable)illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to deserialize protobuf ");
            stringBuilder.append(invocationTargetException.getMessage());
            throw new RuntimeException(stringBuilder.toString(), (Throwable)invocationTargetException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to deserialize protobuf ");
            stringBuilder.append(noSuchMethodException.getMessage());
            throw new RuntimeException(stringBuilder.toString(), (Throwable)noSuchMethodException);
        }
        return (T)generatedMessage;
    }

    public void write(Kryo kryo, Output output, T t2) {
        if (t2 == null) {
            output.writeByte((byte)0);
            output.flush();
            return;
        }
        byte[] arrby = t2.toByteArray();
        output.writeInt(1 + arrby.length, true);
        output.writeBytes(arrby);
        output.flush();
    }
}

