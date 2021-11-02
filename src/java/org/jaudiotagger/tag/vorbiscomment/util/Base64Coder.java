/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.tag.vorbiscomment.util;

import java.nio.charset.Charset;
import org.jaudiotagger.StandardCharsets;

public class Base64Coder {
    private static final char[] map1 = new char[64];
    private static final byte[] map2;

    static {
        int n2 = 0;
        for (int n3 = 65; n3 <= 90; n3 = (int)((char)(n3 + 1))) {
            char[] arrc = map1;
            int n4 = n2 + 1;
            arrc[n2] = n3;
            n2 = n4;
        }
        for (int n5 = 97; n5 <= 122; n5 = (int)((char)(n5 + 1))) {
            char[] arrc = map1;
            int n6 = n2 + 1;
            arrc[n2] = n5;
            n2 = n6;
        }
        for (int n7 = 48; n7 <= 57; n7 = (int)((char)(n7 + 1))) {
            char[] arrc = map1;
            int n8 = n2 + 1;
            arrc[n2] = n7;
            n2 = n8;
        }
        char[] arrc = map1;
        int n9 = n2 + 1;
        arrc[n2] = 43;
        arrc[n9] = 47;
        map2 = new byte[128];
        int n10 = 0;
        do {
            byte[] arrby = map2;
            int n11 = arrby.length;
            if (n10 >= n11) break;
            arrby[n10] = -1;
            ++n10;
        } while (true);
        for (int i2 = 0; i2 < 64; ++i2) {
            Base64Coder.map2[Base64Coder.map1[i2]] = (byte)i2;
        }
    }

    public static byte[] decode(String string2) {
        return Base64Coder.decode(string2.toCharArray());
    }

    public static byte[] decode(char[] arrc) {
        int n2 = arrc.length;
        if (n2 % 4 == 0) {
            while (n2 > 0 && arrc[n2 - 1] == '=') {
                --n2;
            }
            int n3 = n2 * 3 / 4;
            byte[] arrby = new byte[n3];
            int n4 = 0;
            int n5 = 0;
            while (n4 < n2) {
                int n6;
                int n7;
                int n8;
                int n9;
                int n10 = n4 + 1;
                char c2 = arrc[n4];
                int n11 = n10 + 1;
                char c3 = arrc[n10];
                if (c2 == '\r' && c3 == '\n') {
                    n4 = n11;
                    continue;
                }
                if (n11 < n2) {
                    n7 = n11 + 1;
                    n9 = arrc[n11];
                } else {
                    n7 = n11;
                    n9 = 65;
                }
                if (n7 < n2) {
                    n8 = n7 + 1;
                    n6 = arrc[n7];
                } else {
                    n8 = n7;
                    n6 = 65;
                }
                if (c2 <= '' && c3 <= '' && n9 <= 127 && n6 <= 127) {
                    byte[] arrby2 = map2;
                    byte by = arrby2[c2];
                    byte by2 = arrby2[c3];
                    byte by3 = arrby2[n9];
                    byte by4 = arrby2[n6];
                    if (by >= 0 && by2 >= 0 && by3 >= 0 && by4 >= 0) {
                        int n12 = by << 2 | by2 >>> 4;
                        int n13 = (by2 & 15) << 4 | by3 >>> 2;
                        int n14 = by4 | (by3 & 3) << 6;
                        int n15 = n5 + 1;
                        arrby[n5] = (byte)n12;
                        if (n15 < n3) {
                            int n16 = n15 + 1;
                            arrby[n15] = (byte)n13;
                            n15 = n16;
                        }
                        if (n15 < n3) {
                            int n17 = n15 + 1;
                            arrby[n15] = (byte)n14;
                            n5 = n17;
                        } else {
                            n5 = n15;
                        }
                        n4 = n8;
                        continue;
                    }
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            return arrby;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static String encode(String string2) {
        return new String(Base64Coder.encode(string2.getBytes(StandardCharsets.ISO_8859_1)));
    }

    public static char[] encode(byte[] arrby) {
        int n2 = arrby.length;
        int n3 = (2 + n2 * 4) / 3;
        char[] arrc = new char[4 * ((n2 + 2) / 3)];
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            int n6;
            int n7;
            int n8;
            int n9 = n4 + 1;
            int n10 = 255 & arrby[n4];
            if (n9 < n2) {
                n8 = n9 + 1;
                n7 = 255 & arrby[n9];
            } else {
                n8 = n9;
                n7 = 0;
            }
            if (n8 < n2) {
                int n11 = n8 + 1;
                n6 = 255 & arrby[n8];
                n8 = n11;
            } else {
                n6 = 0;
            }
            int n12 = n10 >>> 2;
            int n13 = (n10 & 3) << 4 | n7 >>> 4;
            int n14 = (n7 & 15) << 2 | n6 >>> 6;
            int n15 = n6 & 63;
            int n16 = n5 + 1;
            char[] arrc2 = map1;
            arrc[n5] = arrc2[n12];
            int n17 = n16 + 1;
            arrc[n16] = arrc2[n13];
            int n18 = 61;
            int n19 = n17 < n3 ? arrc2[n14] : 61;
            arrc[n17] = n19;
            int n20 = n17 + 1;
            if (n20 < n3) {
                n18 = arrc2[n15];
            }
            arrc[n20] = n18;
            n5 = n20 + 1;
            n4 = n8;
        }
        return arrc;
    }
}

