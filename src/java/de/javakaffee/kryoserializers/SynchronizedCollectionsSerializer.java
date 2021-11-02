/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.SortedMap
 *  java.util.SortedSet
 *  java.util.TreeMap
 *  java.util.TreeSet
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import de.javakaffee.kryoserializers.SynchronizedCollectionsSerializer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class SynchronizedCollectionsSerializer
extends Serializer<Object> {
    private static final Field SOURCE_COLLECTION_FIELD;
    private static final Field SOURCE_MAP_FIELD;

    static {
        try {
            Field field;
            Field field2;
            SOURCE_COLLECTION_FIELD = field2 = Class.forName((String)"java.util.Collections$SynchronizedCollection").getDeclaredField("c");
            field2.setAccessible(true);
            SOURCE_MAP_FIELD = field = Class.forName((String)"java.util.Collections$SynchronizedMap").getDeclaredField("m");
            field.setAccessible(true);
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not access source collection field in java.util.Collections$SynchronizedCollection.", (Throwable)exception);
        }
    }

    public static void registerSerializers(Kryo kryo) {
        SynchronizedCollectionsSerializer synchronizedCollectionsSerializer = new SynchronizedCollectionsSerializer();
        SynchronizedCollection.values();
        SynchronizedCollection[] arrsynchronizedCollection = SynchronizedCollection.values();
        int n2 = arrsynchronizedCollection.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            kryo.register(arrsynchronizedCollection[i2].type, (Serializer)synchronizedCollectionsSerializer);
        }
    }

    public Object copy(Kryo kryo, Object object) {
        try {
            SynchronizedCollection synchronizedCollection = SynchronizedCollection.valueOfType(object.getClass());
            Object object2 = synchronizedCollection.create(kryo.copy(synchronizedCollection.sourceCollectionField.get(object)));
            return object2;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
    }

    public Object read(Kryo kryo, Input input, Class<Object> class_) {
        int n2 = input.readInt(true);
        return SynchronizedCollection.values()[n2].create(kryo.readClassAndObject(input));
    }

    public void write(Kryo kryo, Output output, Object object) {
        try {
            SynchronizedCollection synchronizedCollection = SynchronizedCollection.valueOfType(object.getClass());
            output.writeInt(synchronizedCollection.ordinal(), true);
            kryo.writeClassAndObject(output, synchronizedCollection.sourceCollectionField.get(object));
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
    }

}

