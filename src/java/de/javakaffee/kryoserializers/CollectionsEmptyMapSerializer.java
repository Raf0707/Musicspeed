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
 *  java.util.Map
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Collections;
import java.util.Map;

public class CollectionsEmptyMapSerializer
extends Serializer<Map<?, ?>> {
    public CollectionsEmptyMapSerializer() {
        this.setImmutable(true);
    }

    public Map<?, ?> read(Kryo kryo, Input input, Class<Map<?, ?>> class_) {
        return Collections.EMPTY_MAP;
    }

    public void write(Kryo kryo, Output output, Map<?, ?> map) {
    }
}

