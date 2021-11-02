/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.ArrayListMultimap
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
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import de.javakaffee.kryoserializers.guava.MultimapSerializerBase;

public class ArrayListMultimapSerializer
extends MultimapSerializerBase<Object, Object, ArrayListMultimap<Object, Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL;
    private static final boolean IMMUTABLE;

    public ArrayListMultimapSerializer() {
        super(false, false);
    }

    public static void registerSerializers(Kryo kryo) {
        kryo.register(ArrayListMultimap.class, (Serializer)new ArrayListMultimapSerializer());
    }

    public ArrayListMultimap<Object, Object> read(Kryo kryo, Input input, Class<ArrayListMultimap<Object, Object>> class_) {
        ArrayListMultimap arrayListMultimap = ArrayListMultimap.create();
        this.readMultimap(kryo, input, arrayListMultimap);
        return arrayListMultimap;
    }

    public void write(Kryo kryo, Output output, ArrayListMultimap<Object, Object> arrayListMultimap) {
        this.writeMultimap(kryo, output, arrayListMultimap);
    }
}

