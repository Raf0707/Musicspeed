/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.ImmutableSortedSet
 *  com.google.common.collect.ImmutableSortedSet$Builder
 *  com.google.common.collect.UnmodifiableIterator
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.util.Comparator
 */
package de.javakaffee.kryoserializers.guava;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;

public class ImmutableSortedSetSerializer
extends Serializer<ImmutableSortedSet<Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL = false;
    private static final boolean IMMUTABLE = true;

    public ImmutableSortedSetSerializer() {
        super(false, true);
    }

    public static void registerSerializers(Kryo kryo) {
        ImmutableSortedSetSerializer immutableSortedSetSerializer = new ImmutableSortedSetSerializer();
        kryo.register(ImmutableSortedSet.class, (Serializer)immutableSortedSetSerializer);
        kryo.register(ImmutableSortedSet.of().getClass(), (Serializer)immutableSortedSetSerializer);
        kryo.register(ImmutableSortedSet.of((Comparable)"").getClass(), (Serializer)immutableSortedSetSerializer);
        kryo.register(ImmutableSortedSet.of().descendingSet().getClass(), (Serializer)immutableSortedSetSerializer);
    }

    public ImmutableSortedSet<Object> read(Kryo kryo, Input input, Class<ImmutableSortedSet<Object>> class_) {
        ImmutableSortedSet.Builder builder = ImmutableSortedSet.orderedBy((Comparator)((Comparator)kryo.readClassAndObject(input)));
        int n2 = input.readInt(true);
        for (int i2 = 0; i2 < n2; ++i2) {
            builder.add(kryo.readClassAndObject(input));
        }
        return builder.build();
    }

    public void write(Kryo kryo, Output output, ImmutableSortedSet<Object> immutableSortedSet) {
        kryo.writeClassAndObject(output, (Object)immutableSortedSet.comparator());
        output.writeInt(immutableSortedSet.size(), true);
        UnmodifiableIterator unmodifiableIterator = immutableSortedSet.iterator();
        while (unmodifiableIterator.hasNext()) {
            kryo.writeClassAndObject(output, unmodifiableIterator.next());
        }
    }
}

