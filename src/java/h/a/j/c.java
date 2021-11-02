/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package h.a.j;

public class c {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] arrby) {
        return c.b(arrby, 0);
    }

    public static String b(byte[] arrby, int n2) {
        int n3 = arrby.length;
        int n4 = n3 << 1;
        int n5 = 0;
        int n6 = n2 > 0 ? n3 / n2 : 0;
        char[] arrc = new char[n4 + n6];
        int n7 = 0;
        while (n5 < n3) {
            if (n2 > 0 && n5 % n2 == 0 && n7 > 0) {
                int n8 = n7 + 1;
                arrc[n7] = 45;
                n7 = n8;
            }
            int n9 = n7 + 1;
            char[] arrc2 = a;
            arrc[n7] = arrc2[(240 & arrby[n5]) >>> 4];
            n7 = n9 + 1;
            arrc[n9] = arrc2[15 & arrby[n5]];
            ++n5;
        }
        return new String(arrc);
    }
}

