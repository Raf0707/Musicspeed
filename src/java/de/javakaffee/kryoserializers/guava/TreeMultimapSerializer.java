/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.collect.Multimap
 *  com.google.common.collect.TreeMultimap
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Object
 */
package de.javakaffee.kryoserializers.guava;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import de.javakaffee.kryoserializers.guava.MultimapSerializerBase;

public class TreeMultimapSerializer
extends MultimapSerializerBase<Comparable, Comparable, TreeMultimap<Comparable, Comparable>> {
    private static final boolean DOES_NOT_ACCEPT_NULL = true;
    private static final boolean IMMUTABLE;

    public TreeMultimapSerializer() {
        super(true, false);
    }

    public static void registerSerializers(Kryo kryo) {
        kryo.register(TreeMultimap.class, (Serializer)new TreeMultimapSerializer());
    }

    public TreeMultimap<Comparable, Comparable> read(Kryo kryo, Input input, Class<TreeMultimap<Comparable, Comparable>> class_) {
        TreeMultimap treeMultimap = TreeMultimap.create();
        this.readMultimap(kryo, input, treeMultimap);
        return treeMultimap;
    }

    public void write(Kryo kryo, Output output, TreeMultimap<Comparable, Comparable> treeMultimap) {
        this.writeMultimap(kryo, output, treeMultimap);
    }
}

