/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMultimap
 *  com.google.common.collect.ImmutableMultimap$Builder
 *  java.lang.Class
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package de.javakaffee.kryoserializers.guava;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import de.javakaffee.kryoserializers.guava.ImmutableListSerializer;
import de.javakaffee.kryoserializers.guava.ImmutableMapSerializer;
import java.util.Map;
import java.util.Set;

public class ImmutableMultimapSerializer
extends Serializer<ImmutableMultimap<Object, Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL = true;
    private static final boolean IMMUTABLE = true;

    public ImmutableMultimapSerializer() {
        super(true, true);
    }

    public static void registerSerializers(Kryo kryo) {
        if (!(kryo.getSerializer(ImmutableList.class) instanceof ImmutableListSerializer)) {
            ImmutableListSerializer.registerSerializers(kryo);
        }
        if (!(kryo.getSerializer(ImmutableMap.class) instanceof ImmutableMapSerializer)) {
            ImmutableMapSerializer.registerSerializers(kryo);
        }
        ImmutableMultimapSerializer immutableMultimapSerializer = new ImmutableMultimapSerializer();
        kryo.register(ImmutableMultimap.class, (Serializer)immutableMultimapSerializer);
        kryo.register(ImmutableMultimap.of().getClass(), (Serializer)immutableMultimapSerializer);
        Object object = new Object();
        kryo.register(ImmutableMultimap.of((Object)object, (Object)object).getClass(), (Serializer)immutableMultimapSerializer);
    }

    public ImmutableMultimap<Object, Object> read(Kryo kryo, Input input, Class<ImmutableMultimap<Object, Object>> class_) {
        Set set = ((Map)kryo.readObject(input, ImmutableMap.class)).entrySet();
        ImmutableMultimap.Builder builder = ImmutableMultimap.builder();
        for (Map.Entry entry : set) {
            builder.putAll(entry.getKey(), (Iterable)entry.getValue());
        }
        return builder.build();
    }

    public void write(Kryo kryo, Output output, ImmutableMultimap<Object, Object> immutableMultimap) {
        kryo.writeObject(output, (Object)ImmutableMap.copyOf((Map)immutableMultimap.asMap()));
    }
}

