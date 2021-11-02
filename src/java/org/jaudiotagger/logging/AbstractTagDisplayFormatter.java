/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.StringIndexOutOfBoundsException
 *  java.util.HashMap
 */
package org.jaudiotagger.logging;

import java.util.HashMap;

public abstract class AbstractTagDisplayFormatter {
    private static HashMap<String, String> hexBinaryMap;
    protected int level;

    static {
        HashMap hashMap;
        hexBinaryMap = hashMap = new HashMap();
        hashMap.put((Object)"0", (Object)"0000");
        hexBinaryMap.put((Object)"1", (Object)"0001");
        hexBinaryMap.put((Object)"2", (Object)"0010");
        hexBinaryMap.put((Object)"3", (Object)"0011");
        hexBinaryMap.put((Object)"4", (Object)"0100");
        hexBinaryMap.put((Object)"5", (Object)"0101");
        hexBinaryMap.put((Object)"6", (Object)"0110");
        hexBinaryMap.put((Object)"7", (Object)"0111");
        hexBinaryMap.put((Object)"8", (Object)"1000");
        hexBinaryMap.put((Object)"9", (Object)"1001");
        hexBinaryMap.put((Object)"a", (Object)"1010");
        hexBinaryMap.put((Object)"b", (Object)"1011");
        hexBinaryMap.put((Object)"c", (Object)"1100");
        hexBinaryMap.put((Object)"d", (Object)"1101");
        hexBinaryMap.put((Object)"e", (Object)"1110");
        hexBinaryMap.put((Object)"f", (Object)"1111");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String displayAsBinary(byte by) {
        String string2;
        String string3;
        block6 : {
            String string4;
            String string5;
            block5 : {
                string2 = "";
                String string6 = Integer.toHexString((int)by);
                try {
                    if (string6.length() == 8) {
                        string4 = string6.substring(6, 7);
                        string5 = string6.substring(7, 8);
                        break block5;
                    }
                    if (string6.length() == 2) {
                        string4 = string6.substring(0, 1);
                        string5 = string6.substring(1, 2);
                        break block5;
                    }
                    if (string6.length() == 1) {
                        string4 = "0";
                        string5 = string6.substring(0, 1);
                        break block5;
                    }
                    string3 = string2;
                    break block6;
                }
                catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                    return string2;
                }
            }
            string3 = string5;
            string2 = string4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)hexBinaryMap.get((Object)string2));
        stringBuilder.append((String)hexBinaryMap.get((Object)string3));
        return stringBuilder.toString();
    }

    public abstract void addElement(String var1, int var2);

    public abstract void addElement(String var1, String var2);

    public abstract void addElement(String var1, boolean var2);

    public abstract void closeHeadingElement(String var1);

    public abstract void openHeadingElement(String var1, int var2);

    public abstract void openHeadingElement(String var1, String var2);

    public abstract void openHeadingElement(String var1, boolean var2);

    public abstract String toString();
}

