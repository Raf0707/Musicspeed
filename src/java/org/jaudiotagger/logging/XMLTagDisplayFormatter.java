/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.text.StringCharacterIterator
 */
package org.jaudiotagger.logging;

import java.text.StringCharacterIterator;
import org.jaudiotagger.logging.AbstractTagDisplayFormatter;

public class XMLTagDisplayFormatter
extends AbstractTagDisplayFormatter {
    private static XMLTagDisplayFormatter formatter;
    protected static final String xmlCDataTagClose = "]]>";
    protected static final String xmlCDataTagOpen = "<![CDATA[";
    protected static final String xmlCloseEnd = ">";
    protected static final String xmlCloseStart = "</";
    protected static final String xmlOpenEnd = ">";
    protected static final String xmlOpenStart = "<";
    protected static final String xmlSingleTagClose = " />";
    StringBuffer sb = new StringBuffer();

    public static String replaceXMLCharacters(String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(string2);
        char c2 = stringCharacterIterator.first();
        while (c2 != '\uffff') {
            if (c2 != '\"') {
                if (c2 != '<') {
                    if (c2 != '>') {
                        if (c2 != '&') {
                            if (c2 != '\'') {
                                stringBuffer.append(c2);
                            } else {
                                stringBuffer.append("&apos;");
                            }
                        } else {
                            stringBuffer.append("&amp;");
                        }
                    } else {
                        stringBuffer.append("&gt;");
                    }
                } else {
                    stringBuffer.append("&lt;");
                }
            } else {
                stringBuffer.append("&quot;");
            }
            c2 = stringCharacterIterator.next();
        }
        return stringBuffer.toString();
    }

    public static String xmlCData(String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            char c2 = string2.charAt(i2);
            if (!Character.isLetterOrDigit((char)c2) && !Character.isSpaceChar((char)c2)) {
                stringBuffer.append("&#x");
                stringBuffer.append(Integer.toString((int)Character.codePointAt((CharSequence)string2, (int)i2), (int)16));
                continue;
            }
            stringBuffer.append(c2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlCDataTagOpen);
        stringBuilder.append((Object)stringBuffer);
        stringBuilder.append(xmlCDataTagClose);
        return stringBuilder.toString();
    }

    public static String xmlClose(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlCloseStart);
        stringBuilder.append(string2);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    public static String xmlFullTag(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(XMLTagDisplayFormatter.xmlOpen(string2));
        stringBuilder.append(XMLTagDisplayFormatter.xmlCData(string3));
        stringBuilder.append(XMLTagDisplayFormatter.xmlClose(string2));
        return stringBuilder.toString();
    }

    public static String xmlOpen(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlOpenStart);
        stringBuilder.append(string2);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    public static String xmlOpenHeading(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" id=\"");
        stringBuilder.append(string3);
        stringBuilder.append("\"");
        return XMLTagDisplayFormatter.xmlOpen(stringBuilder.toString());
    }

    public static String xmlSingleTag(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlOpenStart);
        stringBuilder.append(string2);
        stringBuilder.append(xmlSingleTagClose);
        return stringBuilder.toString();
    }

    @Override
    public void addElement(String string2, int n2) {
        this.addElement(string2, String.valueOf((int)n2));
    }

    @Override
    public void addElement(String string2, String string3) {
        this.sb.append(XMLTagDisplayFormatter.xmlFullTag(string2, XMLTagDisplayFormatter.replaceXMLCharacters(string3)));
    }

    @Override
    public void addElement(String string2, boolean bl) {
        this.addElement(string2, String.valueOf((boolean)bl));
    }

    @Override
    public void closeHeadingElement(String string2) {
        this.sb.append(XMLTagDisplayFormatter.xmlClose(string2));
    }

    @Override
    public void openHeadingElement(String string2, int n2) {
        this.openHeadingElement(string2, String.valueOf((int)n2));
    }

    @Override
    public void openHeadingElement(String string2, String string3) {
        if (string3.length() == 0) {
            this.sb.append(XMLTagDisplayFormatter.xmlOpen(string2));
            return;
        }
        this.sb.append(XMLTagDisplayFormatter.xmlOpenHeading(string2, XMLTagDisplayFormatter.replaceXMLCharacters(string3)));
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

