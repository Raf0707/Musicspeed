/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.github.andrewoma.dexx.collection.IndexedLists
 *  com.github.andrewoma.dexx.collection.List
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Iterator
 */
package de.javakaffee.kryoserializers.dexx;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.github.andrewoma.dexx.collection.IndexedLists;
import com.github.andrewoma.dexx.collection.List;
import java.util.Iterator;

public class ListSerializer
extends Serializer<List> {
    private static final boolean DOES_NOT_ACCEPT_NULL = true;
    private static final boolean IMMUTABLE = true;

    public ListSerializer() {
        super(true, true);
    }

    public static void registerSerializers(Kryo kryo) {
        ListSerializer listSerializer = new ListSerializer();
        kryo.register(List.class, (Serializer)listSerializer);
        kryo.register(IndexedLists.of().getClass(), (Serializer)listSerializer);
        Integer n2 = 1;
        kryo.register(IndexedLists.of((Object)n2).getClass(), (Serializer)listSerializer);
        Integer n3 = 2;
        kryo.register(IndexedLists.of((Object)n2, (Object)n3).getClass(), (Serializer)listSerializer);
        Integer n4 = 3;
        kryo.register(IndexedLists.of((Object)n2, (Object)n3, (Object)n4).getClass(), (Serializer)listSerializer);
        Integer n5 = 4;
        kryo.register(IndexedLists.of((Object)n2, (Object)n3, (Object)n4, (Object)n5).getClass(), (Serializer)listSerializer);
        Integer n6 = 5;
        kryo.register(IndexedLists.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6).getClass(), (Serializer)listSerializer);
        Integer n7 = 6;
        kryo.register(IndexedLists.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7).getClass(), (Serializer)listSerializer);
        Integer n8 = 7;
        kryo.register(IndexedLists.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7, (Object)n8).getClass(), (Serializer)listSerializer);
        Integer n9 = 8;
        kryo.register(IndexedLists.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7, (Object)n8, (Object)n9).getClass(), (Serializer)listSerializer);
        kryo.register(IndexedLists.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7, (Object)n8, (Object)n9, (Object)9).getClass(), (Serializer)listSerializer);
        Integer n10 = 10;
        kryo.register(IndexedLists.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7, (Object)n8, (Object)n9, (Object)n10).getClass(), (Serializer)listSerializer);
        kryo.register(IndexedLists.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7, (Object)n8, (Object)n9, (Object)n10, (Object)11).getClass(), (Serializer)listSerializer);
    }

    public List<Object> read(Kryo kryo, Input input, Class<List> class_) {
        int n2 = input.readInt(true);
        Object[] arrobject = new Object[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            arrobject[i2] = kryo.readClassAndObject(input);
        }
        return IndexedLists.copyOf((Object[])arrobject);
    }

    public void write(Kryo kryo, Output output, List list) {
        output.writeInt(list.size(), true);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            kryo.writeClassAndObject(output, iterator.next());
        }
    }
}

