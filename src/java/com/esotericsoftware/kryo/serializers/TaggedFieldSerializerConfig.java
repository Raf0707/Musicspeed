/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.serializers.FieldSerializerConfig
 *  com.esotericsoftware.minlog.Log
 *  java.lang.CloneNotSupportedException
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import com.esotericsoftware.minlog.Log;

public class TaggedFieldSerializerConfig
extends FieldSerializerConfig {
    private boolean skipUnknownTags = false;

    protected TaggedFieldSerializerConfig clone() {
        return (TaggedFieldSerializerConfig)super.clone();
    }

    @Deprecated
    public boolean isIgnoreUnknownTags() {
        return false;
    }

    public boolean isSkipUnknownTags() {
        return this.skipUnknownTags;
    }

    @Deprecated
    public void setIgnoreUnknownTags(boolean bl) {
    }

    public void setSkipUnknownTags(boolean bl) {
        this.skipUnknownTags = bl;
        if (Log.TRACE) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setSkipUnknownTags: ");
            stringBuilder.append(bl);
            Log.trace((String)"kryo.TaggedFieldSerializerConfig", (String)stringBuilder.toString());
        }
    }
}

