/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.lang.reflect.Field
 *  java.util.Arrays
 *  java.util.List
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListSerializer
extends Serializer<List<?>> {
    private Field _arrayField;

    public ArraysAsListSerializer() {
        try {
            Field field;
            this._arrayField = field = Class.forName((String)"java.util.Arrays$ArrayList").getDeclaredField("a");
            field.setAccessible(true);
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
        this.setImmutable(true);
    }

    private static Class<?> getPrimitiveWrapperClass(Class<?> object) {
        if (object.isPrimitive()) {
            if (object.equals((Object)Long.TYPE)) {
                return Long.class;
            }
            if (object.equals((Object)Integer.TYPE)) {
                return Integer.class;
            }
            if (object.equals((Object)Double.TYPE)) {
                return Double.class;
            }
            if (object.equals((Object)Float.TYPE)) {
                return Float.class;
            }
            if (object.equals((Object)Boolean.TYPE)) {
                return Boolean.class;
            }
            if (object.equals((Object)Character.TYPE)) {
                return Character.class;
            }
            if (object.equals((Object)Short.TYPE)) {
                return Short.class;
            }
            if (object.equals((Object)Byte.TYPE)) {
                object = Byte.class;
            }
        }
        return object;
    }

    public List<?> read(Kryo kryo, Input input, Class<List<?>> class_) {
        int n2 = input.readInt(true);
        Class<?> class_2 = kryo.readClass(input).getType();
        if (class_2.isPrimitive()) {
            class_2 = ArraysAsListSerializer.getPrimitiveWrapperClass(class_2);
        }
        Object object = Array.newInstance(class_2, (int)n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Array.set((Object)object, (int)i2, (Object)kryo.readClassAndObject(input));
        }
        try {
            List list = Arrays.asList((Object[])((Object[])object));
            return list;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
    }

    public void write(Kryo kryo, Output output, List<?> list) {
        int n2;
        Object[] arrobject;
        try {
            arrobject = (Object[])this._arrayField.get(list);
            output.writeInt(arrobject.length, true);
            kryo.writeClass(output, arrobject.getClass().getComponentType());
            n2 = arrobject.length;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            kryo.writeClassAndObject(output, arrobject[i2]);
        }
        return;
    }
}

