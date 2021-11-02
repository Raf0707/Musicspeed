/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.serializers.CollectionSerializer
 *  java.lang.Class
 *  java.util.ArrayList
 *  java.util.Collection
 */
package io.paperdb.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import java.util.ArrayList;
import java.util.Collection;

public class NoArgCollectionSerializer
extends CollectionSerializer {
    protected Collection create(Kryo kryo, Input input, Class<Collection> class_) {
        return new ArrayList();
    }
}

