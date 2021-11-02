/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.minlog.Log
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.EnumSet
 *  java.util.Iterator
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetSerializer
extends Serializer<EnumSet<? extends Enum<?>>> {
    private static final Field TYPE_FIELD;

    static {
        try {
            Field field;
            TYPE_FIELD = field = EnumSet.class.getDeclaredField("elementType");
            field.setAccessible(true);
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException("The EnumSet class seems to have changed, could not access expected field.", (Throwable)exception);
        }
    }

    private Class<? extends Enum<?>> getElementType(EnumSet<? extends Enum<?>> enumSet) {
        try {
            Class class_ = (Class)TYPE_FIELD.get(enumSet);
            return class_;
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not access keys field.", (Throwable)exception);
        }
    }

    public EnumSet<? extends Enum<?>> copy(Kryo kryo, EnumSet<? extends Enum<?>> enumSet) {
        return enumSet.clone();
    }

    public EnumSet read(Kryo kryo, Input input, Class<EnumSet<? extends Enum<?>>> class_) {
        Class class_2 = kryo.readClass(input).getType();
        EnumSet enumSet = EnumSet.noneOf((Class)class_2);
        int n2 = input.readInt(true);
        Enum[] arrenum = (Enum[])class_2.getEnumConstants();
        for (int i2 = 0; i2 < n2; ++i2) {
            enumSet.add((Object)arrenum[input.readInt(true)]);
        }
        return enumSet;
    }

    public void write(Kryo kryo, Output output, EnumSet<? extends Enum<?>> enumSet) {
        kryo.writeClass(output, this.getElementType(enumSet));
        output.writeInt(enumSet.size(), true);
        Iterator iterator = enumSet.iterator();
        while (iterator.hasNext()) {
            output.writeInt(((Enum)iterator.next()).ordinal(), true);
        }
        if (Log.TRACE) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Wrote EnumSet: ");
            stringBuilder.append(enumSet);
            Log.trace((String)"kryo", (String)stringBuilder.toString());
        }
    }
}

