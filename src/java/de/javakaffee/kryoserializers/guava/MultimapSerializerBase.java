/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.Multimap
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Map$Entry
 */
package de.javakaffee.kryoserializers.guava;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Map;

public abstract class MultimapSerializerBase<K, V, T extends Multimap<K, V>>
extends Serializer<T> {
    public MultimapSerializerBase(boolean bl, boolean bl2) {
        super(bl, bl2);
    }

    protected void readMultimap(Kryo kryo, Input input, Multimap<K, V> multimap) {
        int n2 = input.readInt(true);
        for (int i2 = 0; i2 < n2; ++i2) {
            multimap.put(kryo.readClassAndObject(input), kryo.readClassAndObject(input));
        }
    }

    protected void writeMultimap(Kryo kryo, Output output, Multimap<K, V> multimap) {
        output.writeInt(multimap.size(), true);
        for (Map.Entry entry : multimap.entries()) {
            kryo.writeClassAndObject(output, entry.getKey());
            kryo.writeClassAndObject(output, entry.getValue());
        }
    }
}

