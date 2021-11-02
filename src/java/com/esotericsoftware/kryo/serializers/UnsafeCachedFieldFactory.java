/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.ReferenceResolver
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedFieldFactory
 *  com.esotericsoftware.kryo.serializers.UnsafeCacheFields
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
 *  java.lang.String
 *  java.lang.reflect.Field
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.UnsafeCacheFields;
import java.lang.reflect.Field;

class UnsafeCachedFieldFactory
implements FieldSerializer.CachedFieldFactory {
    UnsafeCachedFieldFactory() {
    }

    public FieldSerializer.CachedField createCachedField(Class class_, Field field, FieldSerializer fieldSerializer) {
        if (class_.isPrimitive()) {
            if (class_ == Boolean.TYPE) {
                return new UnsafeCacheFields.UnsafeBooleanField(field);
            }
            if (class_ == Byte.TYPE) {
                return new UnsafeCacheFields.UnsafeByteField(field);
            }
            if (class_ == Character.TYPE) {
                return new UnsafeCacheFields.UnsafeCharField(field);
            }
            if (class_ == Short.TYPE) {
                return new UnsafeCacheFields.UnsafeShortField(field);
            }
            if (class_ == Integer.TYPE) {
                return new UnsafeCacheFields.UnsafeIntField(field);
            }
            if (class_ == Long.TYPE) {
                return new UnsafeCacheFields.UnsafeLongField(field);
            }
            if (class_ == Float.TYPE) {
                return new UnsafeCacheFields.UnsafeFloatField(field);
            }
            if (class_ == Double.TYPE) {
                return new UnsafeCacheFields.UnsafeDoubleField(field);
            }
            return new UnsafeCacheFields.UnsafeObjectField(fieldSerializer);
        }
        if (!(class_ != String.class || fieldSerializer.kryo.getReferences() && fieldSerializer.kryo.getReferenceResolver().useReferences(String.class))) {
            return new UnsafeCacheFields.UnsafeStringField(field);
        }
        return new UnsafeCacheFields.UnsafeObjectField(fieldSerializer);
    }
}

