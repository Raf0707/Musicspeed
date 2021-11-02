/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
 *  com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil
 *  com.esotericsoftware.kryo.serializers.UnsafeCacheFields
 *  com.esotericsoftware.kryo.util.IntArray
 *  com.esotericsoftware.kryo.util.UnsafeUtil
 *  com.esotericsoftware.minlog.Log
 *  com.esotericsoftware.reflectasm.FieldAccess
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
 *  java.lang.StringBuilder
 *  java.lang.reflect.Field
 *  java.util.List
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil;
import com.esotericsoftware.kryo.serializers.UnsafeCacheFields;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.FieldAccess;
import java.lang.reflect.Field;
import java.util.List;

final class FieldSerializerUnsafeUtilImpl
implements FieldSerializerUnsafeUtil {
    private FieldSerializer serializer;

    public FieldSerializerUnsafeUtilImpl(FieldSerializer fieldSerializer) {
        this.serializer = fieldSerializer;
    }

    private int fieldSizeOf(Class<?> class_) {
        if (class_ != Integer.TYPE && class_ != Float.TYPE) {
            if (class_ != Long.TYPE && class_ != Double.TYPE) {
                if (class_ != Byte.TYPE && class_ != Boolean.TYPE) {
                    if (class_ != Short.TYPE && class_ != Character.TYPE) {
                        return UnsafeUtil.unsafe().addressSize();
                    }
                    return 2;
                }
                return 1;
            }
            return 8;
        }
        return 4;
    }

    public void createUnsafeCacheFieldsAndRegions(List<Field> list, List<FieldSerializer.CachedField> list2, int n2, IntArray intArray) {
        Field field;
        int n3;
        int n4 = list.size();
        long l2 = 0L;
        Field field2 = null;
        long l3 = -1L;
        int n5 = 0;
        boolean bl = false;
        int n6 = 0;
        int n7 = -1;
        do {
            List<FieldSerializer.CachedField> list3;
            Field field3;
            int n8;
            int n9;
            int n10;
            block17 : {
                block16 : {
                    block15 : {
                        n3 = n7;
                        field = field2;
                        if (n5 >= n4) break;
                        Object object = list.get(n5);
                        n10 = n4;
                        field3 = (Field)object;
                        if (this.serializer.access == null) break block15;
                        int n11 = n2 + n5;
                        n9 = n5;
                        if (intArray.get(n11) != 1) break block16;
                        n8 = ((FieldAccess)this.serializer.access).getIndex(field3.getName());
                        break block17;
                    }
                    n9 = n5;
                }
                n8 = -1;
            }
            long l4 = UnsafeUtil.unsafe().objectFieldOffset(field3);
            long l5 = l4 + (long)this.fieldSizeOf(field3.getType());
            if (!field3.getType().isPrimitive() && bl) {
                if (n6 > 1) {
                    if (Log.TRACE) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Class ");
                        stringBuilder.append(this.serializer.getType().getName());
                        stringBuilder.append(". Found a set of consecutive primitive fields. Number of fields = ");
                        stringBuilder.append(n6);
                        stringBuilder.append(". Byte length = ");
                        stringBuilder.append(l3 - l2);
                        stringBuilder.append(" Start offset = ");
                        stringBuilder.append(l2);
                        stringBuilder.append(" endOffset=");
                        stringBuilder.append(l3);
                        Log.trace((String)"kryo", (String)stringBuilder.toString());
                    }
                    UnsafeCacheFields.UnsafeRegionField unsafeRegionField = new UnsafeCacheFields.UnsafeRegionField(l2, l3 - l2);
                    unsafeRegionField.field = field;
                    list3 = list2;
                    list3.add((Object)unsafeRegionField);
                } else {
                    list3 = list2;
                    if (field != null) {
                        list3.add((Object)this.serializer.newCachedField(field, list2.size(), n3));
                    }
                }
                list3.add((Object)this.serializer.newCachedField(field3, list2.size(), n8));
                bl = false;
            } else {
                list3 = list2;
                if (!field3.getType().isPrimitive()) {
                    list3.add((Object)this.serializer.newCachedField(field3, list2.size(), n8));
                } else if (!bl) {
                    l2 = l4;
                    bl = true;
                    n6 = 1;
                } else {
                    ++n6;
                }
            }
            n5 = n9 + 1;
            n7 = n8;
            l3 = l5;
            field2 = field3;
            n4 = n10;
        } while (true);
        if (!this.serializer.getUseAsmEnabled() && this.serializer.getUseMemRegions() && bl) {
            if (n6 > 1) {
                if (Log.TRACE) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Class ");
                    stringBuilder.append(this.serializer.getType().getName());
                    stringBuilder.append(". Found a set of consecutive primitive fields. Number of fields = ");
                    stringBuilder.append(n6);
                    stringBuilder.append(". Byte length = ");
                    stringBuilder.append(l3 - l2);
                    stringBuilder.append(" Start offset = ");
                    stringBuilder.append(l2);
                    stringBuilder.append(" endOffset=");
                    stringBuilder.append(l3);
                    Log.trace((String)"kryo", (String)stringBuilder.toString());
                }
                UnsafeCacheFields.UnsafeRegionField unsafeRegionField = new UnsafeCacheFields.UnsafeRegionField(l2, l3 - l2);
                unsafeRegionField.field = field;
                list2.add((Object)unsafeRegionField);
                return;
            }
            if (field != null) {
                list2.add((Object)this.serializer.newCachedField(field, list2.size(), n3));
            }
        }
    }

    public long getObjectFieldOffset(Field field) {
        return UnsafeUtil.unsafe().objectFieldOffset(field);
    }
}

