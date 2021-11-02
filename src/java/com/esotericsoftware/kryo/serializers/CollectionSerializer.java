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
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSerializer
extends Serializer<Collection> {
    private Class elementClass;
    private boolean elementsCanBeNull = true;
    private Class genericType;
    private Serializer serializer;

    public CollectionSerializer() {
    }

    public CollectionSerializer(Class class_, Serializer serializer) {
        this.setElementClass(class_, serializer);
    }

    public CollectionSerializer(Class class_, Serializer serializer, boolean bl) {
        this.setElementClass(class_, serializer);
        this.elementsCanBeNull = bl;
    }

    public Collection copy(Kryo kryo, Collection collection) {
        Collection collection2 = this.createCopy(kryo, collection);
        kryo.reference((Object)collection2);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            collection2.add(kryo.copy(iterator.next()));
        }
        return collection2;
    }

    protected Collection create(Kryo kryo, Input input, Class<Collection> class_) {
        return (Collection)kryo.newInstance(class_);
    }

    protected Collection createCopy(Kryo kryo, Collection collection) {
        return (Collection)kryo.newInstance(collection.getClass());
    }

    public Collection read(Kryo kryo, Input input, Class<Collection> class_) {
        Collection collection;
        collection = this.create(kryo, input, class_);
        kryo.reference((Object)collection);
        int n2 = input.readVarInt(true);
        if (collection instanceof ArrayList) {
            ((ArrayList)collection).ensureCapacity(n2);
        }
        Class class_2 = this.elementClass;
        Serializer serializer = this.serializer;
        Class class_3 = this.genericType;
        if (class_3 != null) {
            if (serializer == null) {
                serializer = kryo.getSerializer(class_3);
                class_2 = class_3;
            }
            this.genericType = null;
        }
        if (serializer != null) {
            int n3;
            boolean bl = this.elementsCanBeNull;
            if (bl) {
                for (n3 = 0; n3 < n2; ++n3) {
                    collection.add(kryo.readObjectOrNull(input, class_2, serializer));
                }
            } else {
                while (n3 < n2) {
                    collection.add(kryo.readObject(input, class_2, serializer));
                    ++n3;
                }
            }
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                collection.add(kryo.readClassAndObject(input));
            }
        }
        return collection;
    }

    public void setElementClass(Class class_, Serializer serializer) {
        this.elementClass = class_;
        this.serializer = serializer;
    }

    public void setElementsCanBeNull(boolean bl) {
        this.elementsCanBeNull = bl;
    }

    public void setGenerics(Kryo kryo, Class[] arrclass) {
        this.genericType = null;
        if (arrclass != null && arrclass.length > 0 && kryo.isFinal(arrclass[0])) {
            this.genericType = arrclass[0];
        }
    }

    public void write(Kryo kryo, Output output, Collection collection) {
        output.writeVarInt(collection.size(), true);
        Serializer serializer = this.serializer;
        Class class_ = this.genericType;
        if (class_ != null) {
            if (serializer == null) {
                serializer = kryo.getSerializer(class_);
            }
            this.genericType = null;
        }
        if (serializer != null) {
            if (this.elementsCanBeNull) {
                Iterator iterator = collection.iterator();
                while (iterator.hasNext()) {
                    kryo.writeObjectOrNull(output, iterator.next(), serializer);
                }
            } else {
                Iterator iterator = collection.iterator();
                while (iterator.hasNext()) {
                    kryo.writeObject(output, iterator.next(), serializer);
                }
            }
        } else {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                kryo.writeClassAndObject(output, iterator.next());
            }
        }
    }
}

