/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.Map
 */
package org.jaudiotagger.tag.datatype;

import java.util.Iterator;
import java.util.Map;

public interface HashMapInterface<K, V> {
    public Map<K, V> getKeyToValue();

    public Map<V, K> getValueToKey();

    public Iterator<V> iterator();
}

