/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.LinkedHashMultimap
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
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import de.javakaffee.kryoserializers.guava.MultimapSerializerBase;

public class LinkedHashMultimapSerializer
extends MultimapSerializerBase<Object, Object, LinkedHashMultimap<Object, Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL;
    private static final boolean IMMUTABLE;

    public LinkedHashMultimapSerializer() {
        super(false, false);
    }

    public static void registerSerializers(Kryo kryo) {
        kryo.register(LinkedHashMultimap.class, (Serializer)new LinkedHashMultimapSerializer());
    }

    public LinkedHashMultimap<Object, Object> read(Kryo kryo, Input input, Class<LinkedHashMultimap<Object, Object>> class_) {
        LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create();
        this.readMultimap(kryo, input, linkedHashMultimap);
        return linkedHashMultimap;
    }

    public void write(Kryo kryo, Output output, LinkedHashMultimap<Object, Object> linkedHashMultimap) {
        this.writeMultimap(kryo, output, linkedHashMultimap);
    }
}

