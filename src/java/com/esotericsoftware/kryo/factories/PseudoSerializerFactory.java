/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.factories.SerializerFactory
 *  java.lang.Class
 *  java.lang.Object
 */
package com.esotericsoftware.kryo.factories;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.factories.SerializerFactory;

public class PseudoSerializerFactory
implements SerializerFactory {
    private final Serializer<?> serializer;

    public PseudoSerializerFactory(Serializer<?> serializer) {
        this.serializer = serializer;
    }

    public Serializer makeSerializer(Kryo kryo, Class<?> class_) {
        return this.serializer;
    }
}

