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
 *  java.util.EnumMap
 *  java.util.Map$Entry
 *  java.util.Set
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class EnumMapSerializer
extends Serializer<EnumMap<? extends Enum<?>, ?>> {
    private static final Object FAKE_REFERENCE;
    private static final Field TYPE_FIELD;

    static {
        try {
            Field field;
            TYPE_FIELD = field = EnumMap.class.getDeclaredField("keyType");
            field.setAccessible(true);
        }
        catch (Exception exception) {
            throw new RuntimeException("The EnumMap class seems to have changed, could not access expected field.", (Throwable)exception);
        }
        FAKE_REFERENCE = new Object();
    }

    private EnumMap<? extends Enum<?>, ?> create(Kryo kryo, Input input, Class<EnumMap<? extends Enum<?>, ?>> class_) {
        return new EnumMap(kryo.readClass(input).getType());
    }

    private Class<Enum<?>> getKeyType(EnumMap<?, ?> enumMap) {
        try {
            Class class_ = (Class)TYPE_FIELD.get(enumMap);
            return class_;
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not access keys field.", (Throwable)exception);
        }
    }

    public EnumMap<? extends Enum<?>, ?> copy(Kryo kryo, EnumMap<? extends Enum<?>, ?> enumMap) {
        EnumMap enumMap2 = new EnumMap(enumMap);
        for (Map.Entry entry : enumMap.entrySet()) {
            enumMap2.put((Enum)entry.getKey(), kryo.copy(entry.getValue()));
        }
        return enumMap2;
    }

    public EnumMap<? extends Enum<?>, ?> read(Kryo kryo, Input input, Class<EnumMap<? extends Enum<?>, ?>> class_) {
        kryo.reference(FAKE_REFERENCE);
        EnumMap<? extends Enum<?>, ?> enumMap = this.create(kryo, input, class_);
        Enum[] arrenum = (Enum[])this.getKeyType(enumMap).getEnumConstants();
        int n2 = input.readInt(true);
        for (int i2 = 0; i2 < n2; ++i2) {
            enumMap.put(arrenum[input.readInt(true)], kryo.readClassAndObject(input));
        }
        return enumMap;
    }

    public void write(Kryo kryo, Output output, EnumMap<? extends Enum<?>, ?> enumMap) {
        kryo.writeClass(output, this.getKeyType(enumMap));
        output.writeInt(enumMap.size(), true);
        for (Map.Entry entry : enumMap.entrySet()) {
            output.writeInt(((Enum)entry.getKey()).ordinal(), true);
            kryo.writeClassAndObject(output, entry.getValue());
        }
        if (Log.TRACE) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Wrote EnumMap: ");
            stringBuilder.append(enumMap);
            Log.trace((String)"kryo", (String)stringBuilder.toString());
        }
    }
}

