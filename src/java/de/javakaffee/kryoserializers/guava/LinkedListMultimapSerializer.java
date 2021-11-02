/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.LinkedListMultimap
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
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import de.javakaffee.kryoserializers.guava.MultimapSerializerBase;

public class LinkedListMultimapSerializer
extends MultimapSerializerBase<Object, Object, LinkedListMultimap<Object, Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL;
    private static final boolean IMMUTABLE;

    public LinkedListMultimapSerializer() {
        super(false, false);
    }

    public static void registerSerializers(Kryo kryo) {
        kryo.register(LinkedListMultimap.class, (Serializer)new LinkedListMultimapSerializer());
    }

    public LinkedListMultimap<Object, Object> read(Kryo kryo, Input input, Class<LinkedListMultimap<Object, Object>> class_) {
        LinkedListMultimap linkedListMultimap = LinkedListMultimap.create();
        this.readMultimap(kryo, input, linkedListMultimap);
        return linkedListMultimap;
    }

    public void write(Kryo kryo, Output output, LinkedListMultimap<Object, Object> linkedListMultimap) {
        this.writeMultimap(kryo, output, linkedListMultimap);
    }
}

