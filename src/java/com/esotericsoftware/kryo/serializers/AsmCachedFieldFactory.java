/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.ReferenceResolver
 *  com.esotericsoftware.kryo.serializers.AsmCacheFields
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
 *  java.lang.String
 *  java.lang.reflect.Field
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import com.esotericsoftware.kryo.serializers.AsmCacheFields;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import java.lang.reflect.Field;

class AsmCachedFieldFactory
implements FieldSerializer.CachedFieldFactory {
    AsmCachedFieldFactory() {
    }

    public FieldSerializer.CachedField createCachedField(Class class_, Field field, FieldSerializer fieldSerializer) {
        if (class_.isPrimitive()) {
            if (class_ == Boolean.TYPE) {
                return new AsmCacheFields.AsmBooleanField();
            }
            if (class_ == Byte.TYPE) {
                return new AsmCacheFields.AsmByteField();
            }
            if (class_ == Character.TYPE) {
                return new AsmCacheFields.AsmCharField();
            }
            if (class_ == Short.TYPE) {
                return new AsmCacheFields.AsmShortField();
            }
            if (class_ == Integer.TYPE) {
                return new AsmCacheFields.AsmIntField();
            }
            if (class_ == Long.TYPE) {
                return new AsmCacheFields.AsmLongField();
            }
            if (class_ == Float.TYPE) {
                return new AsmCacheFields.AsmFloatField();
            }
            if (class_ == Double.TYPE) {
                return new AsmCacheFields.AsmDoubleField();
            }
            return new AsmCacheFields.AsmObjectField(fieldSerializer);
        }
        if (!(class_ != String.class || fieldSerializer.kryo.getReferences() && fieldSerializer.kryo.getReferenceResolver().useReferences(String.class))) {
            return new AsmCacheFields.AsmStringField();
        }
        return new AsmCacheFields.AsmObjectField(fieldSerializer);
    }
}

