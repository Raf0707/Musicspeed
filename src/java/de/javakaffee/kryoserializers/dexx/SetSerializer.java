/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.github.andrewoma.dexx.collection.Builder
 *  com.github.andrewoma.dexx.collection.Set
 *  com.github.andrewoma.dexx.collection.Sets
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
import com.github.andrewoma.dexx.collection.Builder;
import com.github.andrewoma.dexx.collection.Set;
import com.github.andrewoma.dexx.collection.Sets;
import java.util.Iterator;

public class SetSerializer
extends Serializer<Set<Object>> {
    private static final boolean DOES_NOT_ACCEPT_NULL = false;
    private static final boolean IMMUTABLE = true;

    public SetSerializer() {
        super(false, true);
    }

    public static void registerSerializers(Kryo kryo) {
        SetSerializer setSerializer = new SetSerializer();
        kryo.register(Set.class, (Serializer)setSerializer);
        kryo.register(Sets.of().getClass(), (Serializer)setSerializer);
        Integer n2 = 1;
        kryo.register(Sets.of((Object)n2).getClass(), (Serializer)setSerializer);
        Integer n3 = 2;
        Integer n4 = 3;
        kryo.register(Sets.of((Object)n2, (Object)n3, (Object)n4).getClass(), (Serializer)setSerializer);
        Integer n5 = 4;
        kryo.register(Sets.of((Object)n2, (Object)n3, (Object)n4, (Object)n5).getClass(), (Serializer)setSerializer);
        Integer n6 = 5;
        kryo.register(Sets.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6).getClass(), (Serializer)setSerializer);
        Integer n7 = 6;
        kryo.register(Sets.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7).getClass(), (Serializer)setSerializer);
        Integer n8 = 7;
        kryo.register(Sets.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7, (Object)n8).getClass(), (Serializer)setSerializer);
        Integer n9 = 8;
        kryo.register(Sets.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7, (Object)n8, (Object)n9).getClass(), (Serializer)setSerializer);
        Integer n10 = 9;
        kryo.register(Sets.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7, (Object)n8, (Object)n9, (Object)n10).getClass(), (Serializer)setSerializer);
        Integer n11 = 10;
        kryo.register(Sets.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7, (Object)n8, (Object)n9, (Object)n10, (Object)n11).getClass(), (Serializer)setSerializer);
        Object[] arrobject = new Integer[]{11};
        kryo.register(Sets.of((Object)n2, (Object)n3, (Object)n4, (Object)n5, (Object)n6, (Object)n7, (Object)n8, (Object)n9, (Object)n10, (Object)n11, (Object[])arrobject).getClass(), (Serializer)setSerializer);
    }

    public Set<Object> read(Kryo kryo, Input input, Class<Set<Object>> class_) {
        int n2 = input.readInt(true);
        Builder builder = Sets.builder();
        for (int i2 = 0; i2 < n2; ++i2) {
            builder.add(kryo.readClassAndObject(input));
        }
        return (Set)builder.build();
    }

    public void write(Kryo kryo, Output output, Set<Object> set) {
        output.writeInt(set.size(), true);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            kryo.writeClassAndObject(output, iterator.next());
        }
    }
}

