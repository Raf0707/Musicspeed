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
 *  java.util.Iterator
 *  java.util.Set
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class CollectionsSingletonSetSerializer
extends Serializer<Set<?>> {
    public CollectionsSingletonSetSerializer() {
        this.setImmutable(true);
    }

    public Set<?> read(Kryo kryo, Input input, Class<Set<?>> class_) {
        return Collections.singleton((Object)kryo.readClassAndObject(input));
    }

    public void write(Kryo kryo, Output output, Set<?> set) {
        kryo.writeClassAndObject(output, set.iterator().next());
    }
}

