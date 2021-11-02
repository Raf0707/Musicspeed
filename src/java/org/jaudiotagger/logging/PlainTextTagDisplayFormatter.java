/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.StringBuffer
 */
package org.jaudiotagger.logging;

import org.jaudiotagger.logging.AbstractTagDisplayFormatter;

public class PlainTextTagDisplayFormatter
extends AbstractTagDisplayFormatter {
    private static PlainTextTagDisplayFormatter formatter;
    StringBuffer indent = new StringBuffer();
    StringBuffer sb = new StringBuffer();

    public static AbstractTagDisplayFormatter getInstanceOf() {
        if (formatter == null) {
            formatter = new PlainTextTagDisplayFormatter();
        }
        return formatter;
    }

    @Override
    public void addElement(String string2, int n2) {
        this.addElement(string2, String.valueOf((int)n2));
    }

    @Override
    public void addElement(String string2, String string3) {
        StringBuffer stringBuffer = this.sb;
        stringBuffer.append(this.indent);
        stringBuffer.append(string2);
        stringBuffer.append(":");
        stringBuffer.append(string3);
        stringBuffer.append('\n');
    }

    @Override
    public void addElement(String string2, boolean bl) {
        this.addElement(string2, String.valueOf((boolean)bl));
    }

    @Override
    public void closeHeadingElement(String string2) {
        this.decreaseLevel();
    }

    public void decreaseLevel() {
        this.level = -1 + this.level;
        StringBuffer stringBuffer = this.indent;
        this.indent = new StringBuffer(stringBuffer.substring(0, -2 + stringBuffer.length()));
    }

    public void increaseLevel() {
        this.level = 1 + this.level;
        this.indent.append("  ");
    }

    @Override
    public void openHeadingElement(String string2, int n2) {
        this.openHeadingElement(string2, String.valueOf((int)n2));
    }

    @Override
    public void openHeadingElement(String string2, String string3) {
        this.addElement(string2, string3);
        this.increaseLevel();
    }

    @Override
    public void openHeadingElement(String string2, boolean bl) {
        this.openHeadingElement(string2, String.valueOf((boolean)bl));
    }

    @Override
    public String toString() {
        return this.sb.toString();
    }
}

