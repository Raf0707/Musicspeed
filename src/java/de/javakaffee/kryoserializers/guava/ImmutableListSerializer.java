/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableTable
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Table
 *  com.google.common.collect.UnmodifiableIterator
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 */
package de.javakaffee.kryoserializers.guava;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;

public class ImmutableListSerializer
extends Serializer<ImmutableList<Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL = false;
    private static final boolean IMMUTABLE = true;

    public ImmutableListSerializer() {
        super(false, true);
    }

    public static void registerSerializers(Kryo kryo) {
        ImmutableListSerializer immutableListSerializer = new ImmutableListSerializer();
        kryo.register(ImmutableList.class, (Serializer)immutableListSerializer);
        kryo.register(ImmutableList.of().getClass(), (Serializer)immutableListSerializer);
        Integer n2 = 1;
        kryo.register(ImmutableList.of((Object)n2).getClass(), (Serializer)immutableListSerializer);
        Integer n3 = 2;
        Integer n4 = 3;
        kryo.register(ImmutableList.of((Object)n2, (Object)n3, (Object)n4).subList(1, 2).getClass(), (Serializer)immutableListSerializer);
        kryo.register(ImmutableList.of().reverse().getClass(), (Serializer)immutableListSerializer);
        kryo.register(Lists.charactersOf((String)"KryoRocks").getClass(), (Serializer)immutableListSerializer);
        HashBasedTable hashBasedTable = HashBasedTable.create();
        hashBasedTable.put((Object)n2, (Object)n3, (Object)n4);
        hashBasedTable.put((Object)4, (Object)5, (Object)6);
        kryo.register(ImmutableTable.copyOf((Table)hashBasedTable).values().getClass(), (Serializer)immutableListSerializer);
    }

    public ImmutableList<Object> read(Kryo kryo, Input input, Class<ImmutableList<Object>> class_) {
        int n2 = input.readInt(true);
        Object[] arrobject = new Object[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            arrobject[i2] = kryo.readClassAndObject(input);
        }
        return ImmutableList.copyOf((Object[])arrobject);
    }

    public void write(Kryo kryo, Output output, ImmutableList<Object> immutableList) {
        output.writeInt(immutableList.size(), true);
        UnmodifiableIterator unmodifiableIterator = immutableList.iterator();
        while (unmodifiableIterator.hasNext()) {
            kryo.writeClassAndObject(output, unmodifiableIterator.next());
        }
    }
}

