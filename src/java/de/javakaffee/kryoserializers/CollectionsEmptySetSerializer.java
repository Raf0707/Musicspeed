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
 *  java.util.Set
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Collections;
import java.util.Set;

public class CollectionsEmptySetSerializer
extends Serializer<Set<?>> {
    public CollectionsEmptySetSerializer() {
        this.setImmutable(true);
    }

    public Set<?> read(Kryo kryo, Input input, Class<Set<?>> class_) {
        return Collections.EMPTY_SET;
    }

    public void write(Kryo kryo, Output output, Set<?> set) {
    }
}

