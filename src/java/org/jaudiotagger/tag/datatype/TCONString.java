/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 */
package org.jaudiotagger.tag.datatype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.TextEncodedStringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public class TCONString
extends TextEncodedStringSizeTerminated {
    private boolean isNullSeperateMultipleValues = true;

    public TCONString(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public TCONString(TCONString tCONString) {
        super(tCONString);
    }

    public static List<String> splitV23(String string2) {
        List list = Arrays.asList((Object[])string2.replaceAll("(\\(\\d+\\)|\\(RX\\)|\\(CR\\)\\w*)", "$1\u0000").split("\u0000"));
        if (list.size() == 0) {
            list = new ArrayList(1);
            list.add((Object)"");
        }
        return list;
    }

    @Override
    public void addValue(String string2) {
        if (this.isNullSeperateMultipleValues()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.value);
            stringBuilder.append("\u0000");
            stringBuilder.append(string2);
            this.setValue(stringBuilder.toString());
            return;
        }
        if (string2.startsWith("(")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.value);
            stringBuilder.append(string2);
            this.setValue(stringBuilder.toString());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.value);
        stringBuilder.append("\u0000");
        stringBuilder.append(string2);
        this.setValue(stringBuilder.toString());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return object instanceof TCONString && super.equals(object);
    }

    @Override
    public int getNumberOfValues() {
        return this.getValues().size();
    }

    @Override
    public String getValueAtIndex(int n2) {
        return (String)this.getValues().get(n2);
    }

    @Override
    public String getValueWithoutTrailingNull() {
        List<String> list = this.getValues();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (i2 != 0) {
                stringBuffer.append("\u0000");
            }
            stringBuffer.append((String)list.get(i2));
        }
        return stringBuffer.toString();
    }

    @Override
    public List<String> getValues() {
        if (this.isNullSeperateMultipleValues()) {
            return TextEncodedStringSizeTerminated.splitByNullSeperator((String)this.value);
        }
        return TCONString.splitV23((String)this.value);
    }

    public boolean isNullSeperateMultipleValues() {
        return this.isNullSeperateMultipleValues;
    }

    public void setNullSeperateMultipleValues(boolean bl) {
        this.isNullSeperateMultipleValues = bl;
    }
}

