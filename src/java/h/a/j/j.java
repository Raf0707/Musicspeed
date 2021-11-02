/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Error
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package h.a.j;

import java.io.UnsupportedEncodingException;

public final class j {
    public static String a(byte[] arrby) {
        if (arrby != null) {
            try {
                String string2 = new String(arrby, "UTF-8");
                return string2;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new Error((Throwable)unsupportedEncodingException);
            }
        }
        return null;
    }

    public static byte[] b(String string2) {
        if (string2 != null) {
            try {
                byte[] arrby = string2.getBytes("UTF-8");
                return arrby;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new Error((Throwable)unsupportedEncodingException);
            }
        }
        return null;
    }

    public static int c(String string2) {
        if (string2 != null) {
            try {
                int n2 = string2.getBytes("UTF-8").length;
                return n2;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new RuntimeException();
            }
        }
        return 0;
    }
}

