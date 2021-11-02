/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.Maps
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumMap
 *  java.util.HashMap
 *  java.util.Map
 */
package de.javakaffee.kryoserializers.guava;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapSerializer
extends Serializer<ImmutableMap<Object, ? extends Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL = true;
    private static final boolean IMMUTABLE = true;

    public ImmutableMapSerializer() {
        super(true, true);
    }

    public static void registerSerializers(Kryo kryo) {
        ImmutableMapSerializer immutableMapSerializer = new ImmutableMapSerializer();
        kryo.register(ImmutableMap.class, (Serializer)immutableMapSerializer);
        kryo.register(ImmutableMap.of().getClass(), (Serializer)immutableMapSerializer);
        Object object = new Object();
        Object object2 = new Object();
        kryo.register(ImmutableMap.of((Object)object, (Object)object).getClass(), (Serializer)immutableMapSerializer);
        kryo.register(ImmutableMap.of((Object)object, (Object)object, (Object)object2, (Object)object2).getClass(), (Serializer)immutableMapSerializer);
        EnumMap enumMap = new EnumMap(DummyEnum.class);
        DummyEnum[] arrdummyEnum = DummyEnum.values();
        int n2 = arrdummyEnum.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            enumMap.put((Object)arrdummyEnum[i2], object);
        }
        kryo.register(ImmutableMap.copyOf((Map)enumMap).getClass(), (Serializer)immutableMapSerializer);
    }

    public ImmutableMap<Object, Object> read(Kryo kryo, Input input, Class<ImmutableMap<Object, ? extends Object>> class_) {
        return ImmutableMap.copyOf((Map)((Map)kryo.readObject(input, HashMap.class)));
    }

    public void write(Kryo kryo, Output output, ImmutableMap<Object, ? extends Object> immutableMap) {
        kryo.writeObject(output, (Object)Maps.newHashMap(immutableMap));
    }

}

