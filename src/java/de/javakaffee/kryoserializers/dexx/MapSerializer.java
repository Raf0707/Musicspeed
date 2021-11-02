/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.github.andrewoma.dexx.collection.Map
 *  com.github.andrewoma.dexx.collection.Maps
 *  com.github.andrewoma.dexx.collection.Pair
 *  java.lang.Class
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package de.javakaffee.kryoserializers.dexx;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.github.andrewoma.dexx.collection.Maps;
import com.github.andrewoma.dexx.collection.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSerializer
extends Serializer<com.github.andrewoma.dexx.collection.Map<Object, ? extends Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL = true;
    private static final boolean IMMUTABLE = true;

    public MapSerializer() {
        super(true, true);
    }

    public static void registerSerializers(Kryo kryo) {
        MapSerializer mapSerializer = new MapSerializer();
        kryo.register(com.github.andrewoma.dexx.collection.Map.class, (Serializer)mapSerializer);
        kryo.register(Maps.of().getClass(), (Serializer)mapSerializer);
        Object object = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        Object object4 = new Object();
        Object object5 = new Object();
        kryo.register(Maps.of((Object)object, (Object)object).getClass(), (Serializer)mapSerializer);
        kryo.register(Maps.of((Object)object, (Object)object, (Object)object2, (Object)object2).getClass(), (Serializer)mapSerializer);
        kryo.register(Maps.of((Object)object, (Object)object, (Object)object2, (Object)object2, (Object)object3, (Object)object3).getClass(), (Serializer)mapSerializer);
        kryo.register(Maps.of((Object)object, (Object)object, (Object)object2, (Object)object2, (Object)object3, (Object)object3, (Object)object4, (Object)object4).getClass(), (Serializer)mapSerializer);
        kryo.register(Maps.of((Object)object, (Object)object, (Object)object2, (Object)object2, (Object)object3, (Object)object3, (Object)object4, (Object)object4, (Object)object5, (Object)object5).getClass(), (Serializer)mapSerializer);
    }

    public com.github.andrewoma.dexx.collection.Map<Object, Object> read(Kryo kryo, Input input, Class<com.github.andrewoma.dexx.collection.Map<Object, ? extends Object>> class_) {
        HashMap hashMap = (HashMap)kryo.readObject(input, HashMap.class);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add((Object)new Pair(entry.getKey(), entry.getValue()));
        }
        return Maps.copyOf((Iterable)arrayList);
    }

    public void write(Kryo kryo, Output output, com.github.andrewoma.dexx.collection.Map<Object, ? extends Object> map) {
        kryo.writeObject(output, (Object)map.asMap());
    }
}

