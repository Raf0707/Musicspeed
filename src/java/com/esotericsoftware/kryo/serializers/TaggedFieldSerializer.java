/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
 *  com.esotericsoftware.kryo.serializers.FieldSerializerConfig
 *  com.esotericsoftware.kryo.serializers.TaggedFieldSerializer$1
 *  com.esotericsoftware.kryo.serializers.TaggedFieldSerializer$Tag
 *  com.esotericsoftware.minlog.Log
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.HashSet
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.InputChunked;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import com.esotericsoftware.kryo.serializers.TaggedFieldSerializer;
import com.esotericsoftware.kryo.serializers.TaggedFieldSerializerConfig;
import com.esotericsoftware.minlog.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class TaggedFieldSerializer<T>
extends FieldSerializer<T> {
    private static final Comparator<FieldSerializer.CachedField> TAGGED_VALUE_COMPARATOR = new 1();
    private boolean[] annexed;
    private boolean[] deprecated;
    private int[] tags;
    private int writeFieldCount;

    public TaggedFieldSerializer(Kryo kryo, Class class_) {
        super(kryo, class_, null, kryo.getTaggedFieldSerializerConfig().clone());
    }

    @Override
    protected void initializeCachedFields() {
        FieldSerializer.CachedField[] arrcachedField = this.getFields();
        int n2 = arrcachedField.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrcachedField[i2].getField().getAnnotation(Tag.class) != null) continue;
            if (Log.TRACE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Ignoring field without tag: ");
                stringBuilder.append((Object)arrcachedField[i2]);
                Log.trace((String)"kryo", (String)stringBuilder.toString());
            }
            super.removeField(arrcachedField[i2]);
        }
        Object[] arrobject = this.getFields();
        this.tags = new int[arrobject.length];
        this.deprecated = new boolean[arrobject.length];
        this.annexed = new boolean[arrobject.length];
        this.writeFieldCount = arrobject.length;
        Arrays.sort((Object[])arrobject, TAGGED_VALUE_COMPARATOR);
        int n3 = arrobject.length;
        for (int i3 = 0; i3 < n3; ++i3) {
            int[] arrn;
            int n4;
            int n5;
            Field field = arrobject[i3].getField();
            this.tags[i3] = (field.getAnnotation(Tag.class)).value();
            if (i3 > 0 && (n4 = (arrn = this.tags)[i3]) == arrn[n5 = i3 - 1]) {
                Object[] arrobject2 = new Object[]{field, arrobject[n5].getField(), this.tags[i3]};
                throw new KryoException(String.format((String)"The fields [%s] and [%s] both have a Tag value of %d.", (Object[])arrobject2));
            }
            if (field.getAnnotation(Deprecated.class) != null) {
                this.deprecated[i3] = true;
                --this.writeFieldCount;
            }
            if (!(field.getAnnotation(Tag.class)).annexed()) continue;
            this.annexed[i3] = true;
        }
        this.removedFields.clear();
    }

    @Deprecated
    public boolean isIgnoreUnkownTags() {
        return false;
    }

    public boolean isSkipUnknownTags() {
        return ((TaggedFieldSerializerConfig)this.config).isSkipUnknownTags();
    }

    @Override
    public T read(Kryo kryo, Input input, Class<T> class_) {
        T t2 = this.create(kryo, input, class_);
        kryo.reference(t2);
        int n2 = input.readVarInt(true);
        int[] arrn = this.tags;
        FieldSerializer.CachedField[] arrcachedField = this.getFields();
        InputChunked inputChunked = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            boolean bl;
            FieldSerializer.CachedField cachedField;
            block7 : {
                n3 = input.readVarInt(true);
                int n4 = arrn.length;
                for (int i3 = 0; i3 < n4; ++i3) {
                    if (arrn[i3] != n3) continue;
                    cachedField = arrcachedField[i3];
                    bl = this.annexed[i3];
                    break block7;
                }
                cachedField = null;
                bl = false;
            }
            if (cachedField == null) {
                if (this.isSkipUnknownTags()) {
                    if (inputChunked == null) {
                        inputChunked = new InputChunked((InputStream)input, 1024);
                    }
                    inputChunked.nextChunks();
                    if (!Log.TRACE) continue;
                    Object[] arrobject = new Object[]{n3, this.getType().getName()};
                    Log.trace((String)String.format((String)"Unknown field tag: %d (%s) encountered. Assuming a future annexed tag with chunked encoding and skipping.", (Object[])arrobject));
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown field tag: ");
                stringBuilder.append(n3);
                stringBuilder.append(" (");
                stringBuilder.append(this.getType().getName());
                stringBuilder.append(")");
                throw new KryoException(stringBuilder.toString());
            }
            if (bl) {
                if (inputChunked == null) {
                    inputChunked = new InputChunked((InputStream)input, 1024);
                }
                cachedField.read((Input)inputChunked, t2);
                inputChunked.nextChunks();
                continue;
            }
            cachedField.read(input, t2);
        }
        return t2;
    }

    @Override
    public void removeField(FieldSerializer.CachedField cachedField) {
        super.removeField(cachedField);
        this.initializeCachedFields();
    }

    @Override
    public void removeField(String string) {
        super.removeField(string);
        this.initializeCachedFields();
    }

    @Deprecated
    public void setIgnoreUnknownTags(boolean bl) {
    }

    public void setSkipUnknownTags(boolean bl) {
        ((TaggedFieldSerializerConfig)this.config).setSkipUnknownTags(bl);
        this.rebuildCachedFields();
    }

    @Override
    public void write(Kryo kryo, Output output, T t2) {
        FieldSerializer.CachedField[] arrcachedField = this.getFields();
        output.writeVarInt(this.writeFieldCount, true);
        int n2 = arrcachedField.length;
        OutputChunked outputChunked = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.deprecated[i2]) continue;
            output.writeVarInt(this.tags[i2], true);
            if (this.annexed[i2]) {
                if (outputChunked == null) {
                    outputChunked = new OutputChunked((OutputStream)output, 1024);
                }
                arrcachedField[i2].write((Output)outputChunked, t2);
                outputChunked.endChunks();
                continue;
            }
            arrcachedField[i2].write(output, t2);
        }
    }
}

