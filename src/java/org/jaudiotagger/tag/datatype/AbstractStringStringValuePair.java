/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package org.jaudiotagger.tag.datatype;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jaudiotagger.tag.datatype.AbstractValuePair;

public class AbstractStringStringValuePair
extends AbstractValuePair<String, String> {
    protected String lkey = null;

    protected void createMaps() {
        this.iterator = this.idToValue.keySet().iterator();
        while (this.iterator.hasNext()) {
            String string2;
            String string3;
            this.lkey = string2 = (String)this.iterator.next();
            this.value = string3 = (String)this.idToValue.get((Object)string2);
            this.valueToId.put((Object)string3, (Object)this.lkey);
        }
        this.iterator = this.idToValue.keySet().iterator();
        while (this.iterator.hasNext()) {
            this.valueList.add((Object)((String)this.idToValue.get(this.iterator.next())));
        }
        Collections.sort(this.valueList);
    }

    public String getIdForValue(String string2) {
        return (String)this.valueToId.get((Object)string2);
    }

    public String getValueForId(String string2) {
        return (String)this.idToValue.get((Object)string2);
    }
}

