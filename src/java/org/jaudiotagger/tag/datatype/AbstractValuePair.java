/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package org.jaudiotagger.tag.datatype;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractValuePair<I, V> {
    protected final Map<I, V> idToValue;
    protected Iterator<I> iterator;
    protected String value;
    protected final List<V> valueList;
    protected final Map<V, I> valueToId;

    public AbstractValuePair() {
        LinkedHashMap linkedHashMap;
        this.idToValue = linkedHashMap = new LinkedHashMap();
        this.valueToId = new LinkedHashMap();
        this.valueList = new ArrayList();
        this.iterator = linkedHashMap.keySet().iterator();
    }

    public List<V> getAlphabeticalValueList() {
        return this.valueList;
    }

    public Map<I, V> getIdToValueMap() {
        return this.idToValue;
    }

    public int getSize() {
        return this.valueList.size();
    }

    public Map<V, I> getValueToIdMap() {
        return this.valueToId;
    }
}

