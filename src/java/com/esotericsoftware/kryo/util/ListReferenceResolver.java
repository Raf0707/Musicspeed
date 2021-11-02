/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.ReferenceResolver
 *  com.esotericsoftware.kryo.util.Util
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import com.esotericsoftware.kryo.util.Util;
import java.util.ArrayList;

public class ListReferenceResolver
implements ReferenceResolver {
    protected Kryo kryo;
    protected final ArrayList seenObjects = new ArrayList();

    public int addWrittenObject(Object object) {
        int n2 = this.seenObjects.size();
        this.seenObjects.add(object);
        return n2;
    }

    public Object getReadObject(Class class_, int n2) {
        return this.seenObjects.get(n2);
    }

    public int getWrittenId(Object object) {
        int n2 = this.seenObjects.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.seenObjects.get(i2) != object) continue;
            return i2;
        }
        return -1;
    }

    public int nextReadId(Class class_) {
        int n2 = this.seenObjects.size();
        this.seenObjects.add(null);
        return n2;
    }

    public void reset() {
        this.seenObjects.clear();
    }

    public void setKryo(Kryo kryo) {
        this.kryo = kryo;
    }

    public void setReadObject(int n2, Object object) {
        this.seenObjects.set(n2, object);
    }

    public boolean useReferences(Class class_) {
        return true ^ Util.isWrapperClass((Class)class_);
    }
}

