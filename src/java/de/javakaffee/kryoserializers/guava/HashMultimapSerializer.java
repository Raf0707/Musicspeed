/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  java.lang.Class
 *  java.lang.Object
 */
package de.javakaffee.kryoserializers.guava;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import de.javakaffee.kryoserializers.guava.MultimapSerializerBase;

public class HashMultimapSerializer
extends MultimapSerializerBase<Object, Object, HashMultimap<Object, Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL;
    private static final boolean IMMUTABLE;

    public HashMultimapSerializer() {
        super(false, false);
    }

    public static void registerSerializers(Kryo kryo) {
        kryo.register(HashMultimap.class, (Serializer)new HashMultimapSerializer());
    }

    public HashMultimap<Object, Object> read(Kryo kryo, Input input, Class<HashMultimap<Object, Object>> class_) {
        HashMultimap hashMultimap = HashMultimap.create();
        this.readMultimap(kryo, input, hashMultimap);
        return hashMultimap;
    }

    public void write(Kryo kryo, Output output, HashMultimap<Object, Object> hashMultimap) {
        this.writeMultimap(kryo, output, hashMultimap);
    }
}

