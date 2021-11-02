/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Collections;
import java.util.List;

public class CollectionsSingletonListSerializer
extends Serializer<List<?>> {
    public CollectionsSingletonListSerializer() {
        this.setImmutable(true);
    }

    public List<?> read(Kryo kryo, Input input, Class<List<?>> class_) {
        return Collections.singletonList((Object)kryo.readClassAndObject(input));
    }

    public void write(Kryo kryo, Output output, List<?> list) {
        kryo.writeClassAndObject(output, list.get(0));
    }
}

