/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.serializers.CollectionSerializer
 *  com.google.common.collect.Lists
 *  de.javakaffee.kryoserializers.guava.ReverseListSerializer$RandomAccessReverseList
 *  de.javakaffee.kryoserializers.guava.ReverseListSerializer$ReverseList
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.List
 */
package de.javakaffee.kryoserializers.guava;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.google.common.collect.Lists;
import de.javakaffee.kryoserializers.guava.ReverseListSerializer;
import java.util.Collection;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public abstract class ReverseListSerializer
extends Serializer<List<Object>> {
    private static final CollectionSerializer serializer;

    static {
        serializer = new CollectionSerializer();
    }

    static /* synthetic */ CollectionSerializer access$200() {
        return serializer;
    }

    public static ReverseListSerializer forRandomAccessReverseList() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static ReverseListSerializer forReverseList() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static void registerSerializers(Kryo kryo) {
        kryo.register(Lists.reverse((List)Lists.newLinkedList()).getClass(), (Serializer)ReverseListSerializer.forReverseList());
        kryo.register(Lists.reverse((List)Lists.newArrayList()).getClass(), (Serializer)ReverseListSerializer.forRandomAccessReverseList());
    }

    public List<Object> copy(Kryo kryo, List<Object> list) {
        List list2 = Lists.reverse(list);
        return Lists.reverse((List)((List)serializer.copy(kryo, (Collection)list2)));
    }

    public void write(Kryo kryo, Output output, List<Object> list) {
        List list2 = Lists.reverse(list);
        serializer.write(kryo, output, (Collection)list2);
    }
}

