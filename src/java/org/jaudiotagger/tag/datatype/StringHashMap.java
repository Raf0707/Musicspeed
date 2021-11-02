/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.TreeSet
 */
package org.jaudiotagger.tag.datatype;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.HashMapInterface;
import org.jaudiotagger.tag.datatype.StringFixedLength;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.reference.Languages;

public class StringHashMap
extends StringFixedLength
implements HashMapInterface<String, String> {
    boolean hasEmptyValue = false;
    Map<String, String> keyToValue = null;
    Map<String, String> valueToKey = null;

    public StringHashMap(String string2, AbstractTagFrameBody abstractTagFrameBody, int n2) {
        super(string2, abstractTagFrameBody, n2);
        if (string2.equals((Object)"Language")) {
            this.valueToKey = Languages.getInstanceOf().getValueToIdMap();
            this.keyToValue = Languages.getInstanceOf().getIdToValueMap();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hashmap identifier not defined in this class: ");
        stringBuilder.append(string2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public StringHashMap(StringHashMap stringHashMap) {
        super(stringHashMap);
        this.hasEmptyValue = stringHashMap.hasEmptyValue;
        this.keyToValue = stringHashMap.keyToValue;
        this.valueToKey = stringHashMap.valueToKey;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StringHashMap)) {
            return false;
        }
        StringHashMap stringHashMap = (StringHashMap)object;
        if (this.hasEmptyValue != stringHashMap.hasEmptyValue) {
            return false;
        }
        Map<String, String> map = this.keyToValue;
        if (map == null ? stringHashMap.keyToValue != null : !map.equals(stringHashMap.keyToValue)) {
            return false;
        }
        if (this.keyToValue == null ? stringHashMap.keyToValue != null : !this.valueToKey.equals(stringHashMap.valueToKey)) {
            return false;
        }
        return super.equals(object);
    }

    @Override
    public Map<String, String> getKeyToValue() {
        return this.keyToValue;
    }

    @Override
    protected Charset getTextEncodingCharSet() {
        return StandardCharsets.ISO_8859_1;
    }

    @Override
    public Map<String, String> getValueToKey() {
        return this.valueToKey;
    }

    @Override
    public Iterator<String> iterator() {
        if (this.keyToValue == null) {
            return null;
        }
        TreeSet treeSet = new TreeSet(this.keyToValue.values());
        if (this.hasEmptyValue) {
            treeSet.add((Object)"");
        }
        return treeSet.iterator();
    }

    @Override
    public void setValue(Object object) {
        if (object instanceof String) {
            if (object.equals((Object)"XXX")) {
                this.value = object.toString();
                return;
            }
            this.value = ((String)object).toLowerCase();
            return;
        }
        this.value = object;
    }

    @Override
    public String toString() {
        Object object = this.value;
        if (object != null && this.keyToValue.get(object) != null) {
            return (String)this.keyToValue.get(this.value);
        }
        return "";
    }
}

