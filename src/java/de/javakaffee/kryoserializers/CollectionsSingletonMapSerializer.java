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
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CollectionsSingletonMapSerializer
extends Serializer<Map<?, ?>> {
    public CollectionsSingletonMapSerializer() {
        this.setImmutable(true);
    }

    public Map<?, ?> read(Kryo kryo, Input input, Class<Map<?, ?>> class_) {
        return Collections.singletonMap((Object)kryo.readClassAndObject(input), (Object)kryo.readClassAndObject(input));
    }

    public void write(Kryo kryo, Output output, Map<?, ?> map) {
        Map.Entry entry = (Map.Entry)map.entrySet().iterator().next();
        kryo.writeClassAndObject(output, entry.getKey());
        kryo.writeClassAndObject(output, entry.getValue());
    }
}

