/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class EnumNameSerializer
extends Serializer<Enum> {
    private final Class<? extends Enum> enumType;
    private final Serializer stringSerializer;

    public EnumNameSerializer(Kryo kryo, Class<? extends Enum> class_) {
        this.enumType = class_;
        this.stringSerializer = kryo.getSerializer(String.class);
        this.setImmutable(true);
    }

    public Enum read(Kryo kryo, Input input, Class<Enum> class_) {
        String string = (String)kryo.readObject(input, String.class, this.stringSerializer);
        try {
            Enum enum_ = Enum.valueOf(this.enumType, (String)string);
            return enum_;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid name for enum \"");
            stringBuilder.append(this.enumType.getName());
            stringBuilder.append("\": ");
            stringBuilder.append(string);
            throw new KryoException(stringBuilder.toString(), (Throwable)illegalArgumentException);
        }
    }

    public void write(Kryo kryo, Output output, Enum enum_) {
        kryo.writeObject(output, (Object)enum_.name(), this.stringSerializer);
    }
}

