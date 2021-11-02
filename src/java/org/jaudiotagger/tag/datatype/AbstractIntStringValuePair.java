/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package org.jaudiotagger.tag.datatype;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jaudiotagger.tag.datatype.AbstractValuePair;

public class AbstractIntStringValuePair
extends AbstractValuePair<Integer, String> {
    protected Integer key = null;

    protected void createMaps() {
        for (Map.Entry entry : this.idToValue.entrySet()) {
            this.valueToId.put((Object)((String)entry.getValue()), (Object)((Integer)entry.getKey()));
        }
        this.valueList.addAll(this.idToValue.values());
        Collections.sort(this.valueList);
    }

    public Integer getIdForValue(String string2) {
        return (Integer)this.valueToId.get((Object)string2);
    }

    public String getValueForId(int n2) {
        return (String)this.idToValue.get((Object)n2);
    }
}

