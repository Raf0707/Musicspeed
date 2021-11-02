/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.ImmutableSet
 *  com.google.common.collect.ImmutableSet$Builder
 *  com.google.common.collect.Sets
 *  com.google.common.collect.UnmodifiableIterator
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package de.javakaffee.kryoserializers.guava;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;

public class ImmutableSetSerializer
extends Serializer<ImmutableSet<Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL = false;
    private static final boolean IMMUTABLE = true;

    public ImmutableSetSerializer() {
        super(false, true);
    }

    public static void registerSerializers(Kryo kryo) {
        ImmutableSetSerializer immutableSetSerializer = new ImmutableSetSerializer();
        kryo.register(ImmutableSet.class, (Serializer)immutableSetSerializer);
        kryo.register(ImmutableSet.of().getClass(), (Serializer)immutableSetSerializer);
        Integer n2 = 1;
        kryo.register(ImmutableSet.of((Object)n2).getClass(), (Serializer)immutableSetSerializer);
        kryo.register(ImmutableSet.of((Object)n2, (Object)2, (Object)3).getClass(), (Serializer)immutableSetSerializer);
        SomeEnum someEnum = SomeEnum.A;
        Enum[] arrenum = new SomeEnum[]{SomeEnum.B, SomeEnum.C};
        kryo.register(Sets.immutableEnumSet((Enum)someEnum, (Enum[])arrenum).getClass(), (Serializer)immutableSetSerializer);
    }

    public ImmutableSet<Object> read(Kryo kryo, Input input, Class<ImmutableSet<Object>> class_) {
        int n2 = input.readInt(true);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (int i2 = 0; i2 < n2; ++i2) {
            builder.add(kryo.readClassAndObject(input));
        }
        return builder.build();
    }

    public void write(Kryo kryo, Output output, ImmutableSet<Object> immutableSet) {
        output.writeInt(immutableSet.size(), true);
        UnmodifiableIterator unmodifiableIterator = immutableSet.iterator();
        while (unmodifiableIterator.hasNext()) {
            kryo.writeClassAndObject(output, unmodifiableIterator.next());
        }
    }

}

