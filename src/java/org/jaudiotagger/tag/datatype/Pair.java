/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.tag.datatype;

public class Pair {
    private String key;
    private String value;

    public Pair(String string2, String string3) {
        this.setKey(string2);
        this.setValue(string3);
    }

    public String getKey() {
        return this.key;
    }

    public String getPairValue() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getKey());
        stringBuilder.append('\u0000');
        stringBuilder.append(this.getValue());
        return stringBuilder.toString();
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(String string2) {
        this.key = string2;
    }

    public void setValue(String string2) {
        this.value = string2;
    }
}

