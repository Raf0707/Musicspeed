/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.bpmkey;

public class g {
    public static final String[] a = new String[]{"A", "B\u266d", "B", "C", "D\u266d", "D", "E\u266d", "E", "F", "G\u266d", "G", "A\u266d", "Am", "B\u266dm", "Bm", "Cm", "D\u266dm", "Dm", "E\u266dm", "Em", "Fm", "G\u266dm", "Gm", "A\u266dm"};
    public static final String[] b = new String[]{"A", "B\u266d", "B", "C", "D\u266d", "D", "E\u266d", "E", "F", "G\u266d", "G", "A\u266d"};

    public static String a(int n2, float f2) {
        int n3;
        boolean bl = n2 <= 11;
        if (bl) {
            for (n3 = java.lang.Math.round((float)(f2 + (float)n2)); n3 < 0; n3 += 12) {
            }
            while (n3 > 11) {
                n3 -= 12;
            }
        } else {
            while (n3 < 11) {
                n3 += 12;
            }
            while (n3 > 23) {
                n3 -= 12;
            }
        }
        return a[n3];
    }

    public static String b(int n2) {
        return a[n2];
    }
}

