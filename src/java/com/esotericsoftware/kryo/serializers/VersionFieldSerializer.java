/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
 *  com.esotericsoftware.kryo.serializers.VersionFieldSerializer$Since
 *  com.esotericsoftware.minlog.Log
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.util.HashSet
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.VersionFieldSerializer;
import com.esotericsoftware.minlog.Log;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;

public class VersionFieldSerializer<T>
extends FieldSerializer<T> {
    private boolean compatible = true;
    private int[] fieldVersion;
    private int typeVersion = 0;

    public VersionFieldSerializer(Kryo kryo, Class class_) {
        super(kryo, class_);
        this.initializeCachedFields();
    }

    public VersionFieldSerializer(Kryo kryo, Class class_, boolean bl) {
        this(kryo, class_);
        this.compatible = bl;
    }

    @Override
    protected void initializeCachedFields() {
        FieldSerializer.CachedField[] arrcachedField = this.getFields();
        this.fieldVersion = new int[arrcachedField.length];
        int n2 = arrcachedField.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Since since = arrcachedField[i2].getField().getAnnotation(Since.class);
            if (since != null) {
                this.fieldVersion[i2] = since.value();
                this.typeVersion = Math.max((int)this.fieldVersion[i2], (int)this.typeVersion);
                continue;
            }
            this.fieldVersion[i2] = 0;
        }
        this.removedFields.clear();
        if (Log.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Version for type ");
            stringBuilder.append(this.getType().getName());
            stringBuilder.append(" is ");
            stringBuilder.append(this.typeVersion);
            Log.debug((String)stringBuilder.toString());
        }
    }

    @Override
    public T read(Kryo kryo, Input input, Class<T> class_) {
        T t2 = this.create(kryo, input, class_);
        kryo.reference(t2);
        int n2 = input.readVarInt(true);
        if (!this.compatible && n2 != this.typeVersion) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Version not compatible: ");
            stringBuilder.append(n2);
            stringBuilder.append(" <-> ");
            stringBuilder.append(this.typeVersion);
            throw new KryoException(stringBuilder.toString());
        }
        FieldSerializer.CachedField[] arrcachedField = this.getFields();
        int n3 = arrcachedField.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (this.fieldVersion[i2] > n2) {
                if (!Log.DEBUG) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Skip field ");
                stringBuilder.append(arrcachedField[i2].getField().getName());
                Log.debug((String)stringBuilder.toString());
                continue;
            }
            arrcachedField[i2].read(input, t2);
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

    @Override
    public void write(Kryo kryo, Output output, T t2) {
        FieldSerializer.CachedField[] arrcachedField = this.getFields();
        output.writeVarInt(this.typeVersion, true);
        int n2 = arrcachedField.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrcachedField[i2].write(output, t2);
        }
    }
}

