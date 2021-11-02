/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.ReferenceResolver
 *  com.esotericsoftware.kryo.util.IdentityObjectIntMap
 *  com.esotericsoftware.kryo.util.Util
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import com.esotericsoftware.kryo.util.IdentityObjectIntMap;
import com.esotericsoftware.kryo.util.Util;
import java.util.ArrayList;

public class MapReferenceResolver
implements ReferenceResolver {
    protected Kryo kryo;
    protected final ArrayList readObjects = new ArrayList();
    protected final IdentityObjectIntMap writtenObjects = new IdentityObjectIntMap();

    public int addWrittenObject(Object object) {
        IdentityObjectIntMap identityObjectIntMap = this.writtenObjects;
        int n2 = identityObjectIntMap.size;
        identityObjectIntMap.put(object, n2);
        return n2;
    }

    public Object getReadObject(Class class_, int n2) {
        return this.readObjects.get(n2);
    }

    public int getWrittenId(Object object) {
        return this.writtenObjects.get(object, -1);
    }

    public int nextReadId(Class class_) {
        int n2 = this.readObjects.size();
        this.readObjects.add(null);
        return n2;
    }

    public void reset() {
        this.readObjects.clear();
        this.writtenObjects.clear();
    }

    public void setKryo(Kryo kryo) {
        this.kryo = kryo;
    }

    public void setReadObject(int n2, Object object) {
        this.readObjects.set(n2, object);
    }

    public boolean useReferences(Class class_) {
        return true ^ Util.isWrapperClass((Class)class_);
    }
}

