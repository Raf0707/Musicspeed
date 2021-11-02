/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedFieldFactory
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.reflect.Field
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.ObjectField;
import java.lang.reflect.Field;

class ObjectCachedFieldFactory
implements FieldSerializer.CachedFieldFactory {
    ObjectCachedFieldFactory() {
    }

    public FieldSerializer.CachedField createCachedField(Class class_, Field field, FieldSerializer fieldSerializer) {
        if (class_.isPrimitive()) {
            if (class_ == Boolean.TYPE) {
                return new ObjectField.ObjectBooleanField(fieldSerializer);
            }
            if (class_ == Byte.TYPE) {
                return new ObjectField.ObjectByteField(fieldSerializer);
            }
            if (class_ == Character.TYPE) {
                return new ObjectField.ObjectCharField(fieldSerializer);
            }
            if (class_ == Short.TYPE) {
                return new ObjectField.ObjectShortField(fieldSerializer);
            }
            if (class_ == Integer.TYPE) {
                return new ObjectField.ObjectIntField(fieldSerializer);
            }
            if (class_ == Long.TYPE) {
                return new ObjectField.ObjectLongField(fieldSerializer);
            }
            if (class_ == Float.TYPE) {
                return new ObjectField.ObjectFloatField(fieldSerializer);
            }
            if (class_ == Double.TYPE) {
                return new ObjectField.ObjectDoubleField(fieldSerializer);
            }
            return new ObjectField(fieldSerializer);
        }
        return new ObjectField(fieldSerializer);
    }
}

