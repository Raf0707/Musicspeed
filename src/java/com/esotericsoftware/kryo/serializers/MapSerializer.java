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
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Map;
import java.util.Set;

public class MapSerializer
extends Serializer<Map> {
    private Class keyClass;
    private Class keyGenericType;
    private Serializer keySerializer;
    private boolean keysCanBeNull = true;
    private Class valueClass;
    private Class valueGenericType;
    private Serializer valueSerializer;
    private boolean valuesCanBeNull = true;

    public Map copy(Kryo kryo, Map map) {
        Map map2 = this.createCopy(kryo, map);
        for (Map.Entry entry : map.entrySet()) {
            map2.put(kryo.copy(entry.getKey()), kryo.copy(entry.getValue()));
        }
        return map2;
    }

    protected Map create(Kryo kryo, Input input, Class<Map> class_) {
        return (Map)kryo.newInstance(class_);
    }

    protected Map createCopy(Kryo kryo, Map map) {
        return (Map)kryo.newInstance(map.getClass());
    }

    public Map read(Kryo kryo, Input input, Class<Map> class_) {
        Map map = this.create(kryo, input, class_);
        int n2 = input.readInt(true);
        Class class_2 = this.keyClass;
        Class class_3 = this.valueClass;
        Serializer serializer = this.keySerializer;
        Class class_4 = this.keyGenericType;
        if (class_4 != null) {
            if (serializer == null) {
                serializer = kryo.getSerializer(class_4);
            }
            this.keyGenericType = null;
            class_2 = class_4;
        }
        Serializer serializer2 = this.valueSerializer;
        Class class_5 = this.valueGenericType;
        if (class_5 != null) {
            if (serializer2 == null) {
                serializer2 = kryo.getSerializer(class_5);
            }
            this.valueGenericType = null;
            class_3 = class_5;
        }
        kryo.reference((Object)map);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = serializer != null ? (this.keysCanBeNull ? kryo.readObjectOrNull(input, class_2, serializer) : kryo.readObject(input, class_2, serializer)) : kryo.readClassAndObject(input);
            Object object2 = serializer2 != null ? (this.valuesCanBeNull ? kryo.readObjectOrNull(input, class_3, serializer2) : kryo.readObject(input, class_3, serializer2)) : kryo.readClassAndObject(input);
            map.put(object, object2);
        }
        return map;
    }

    public void setGenerics(Kryo kryo, Class[] arrclass) {
        this.keyGenericType = null;
        this.valueGenericType = null;
        if (arrclass != null && arrclass.length > 0) {
            if (arrclass[0] != null && kryo.isFinal(arrclass[0])) {
                this.keyGenericType = arrclass[0];
            }
            if (arrclass.length > 1 && arrclass[1] != null && kryo.isFinal(arrclass[1])) {
                this.valueGenericType = arrclass[1];
            }
        }
    }

    public void setKeyClass(Class class_, Serializer serializer) {
        this.keyClass = class_;
        this.keySerializer = serializer;
    }

    public void setKeysCanBeNull(boolean bl) {
        this.keysCanBeNull = bl;
    }

    public void setValueClass(Class class_, Serializer serializer) {
        this.valueClass = class_;
        this.valueSerializer = serializer;
    }

    public void setValuesCanBeNull(boolean bl) {
        this.valuesCanBeNull = bl;
    }

    public void write(Kryo kryo, Output output, Map map) {
        output.writeInt(map.size(), true);
        Serializer serializer = this.keySerializer;
        Class class_ = this.keyGenericType;
        if (class_ != null) {
            if (serializer == null) {
                serializer = kryo.getSerializer(class_);
            }
            this.keyGenericType = null;
        }
        Serializer serializer2 = this.valueSerializer;
        Class class_2 = this.valueGenericType;
        if (class_2 != null) {
            if (serializer2 == null) {
                serializer2 = kryo.getSerializer(class_2);
            }
            this.valueGenericType = null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (serializer != null) {
                if (this.keysCanBeNull) {
                    kryo.writeObjectOrNull(output, entry.getKey(), serializer);
                } else {
                    kryo.writeObject(output, entry.getKey(), serializer);
                }
            } else {
                kryo.writeClassAndObject(output, entry.getKey());
            }
            if (serializer2 != null) {
                if (this.valuesCanBeNull) {
                    kryo.writeObjectOrNull(output, entry.getValue(), serializer2);
                    continue;
                }
                kryo.writeObject(output, entry.getValue(), serializer2);
                continue;
            }
            kryo.writeClassAndObject(output, entry.getValue());
        }
    }
}

