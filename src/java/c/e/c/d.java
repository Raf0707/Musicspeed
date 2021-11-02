/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.c.e
 *  java.lang.Character
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Field
 *  java.util.Locale
 */
package c.e.c;

import java.lang.reflect.Field;
import java.util.Locale;

public abstract class d
extends Enum<d>
implements c.e.c.e {
    public static final /* enum */ d f;
    public static final /* enum */ d g;
    public static final /* enum */ d h;
    public static final /* enum */ d i;
    public static final /* enum */ d j;
    public static final /* enum */ d k;
    private static final /* synthetic */ d[] l;

    static {
        d d2;
        d d3;
        d d4;
        d d5;
        d d6;
        d d7;
        f = d6 = new d(){

            public String a(Field field) {
                return field.getName();
            }
        };
        g = d5 = new d(){

            public String a(Field field) {
                return d.c(field.getName());
            }
        };
        h = d3 = new d(){

            public String a(Field field) {
                return d.c(d.b(field.getName(), " "));
            }
        };
        i = d2 = new d(){

            public String a(Field field) {
                return d.b(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        j = d4 = new d(){

            public String a(Field field) {
                return d.b(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        k = d7 = new d(){

            public String a(Field field) {
                return d.b(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        };
        l = new d[]{d6, d5, d3, d2, d4, d7};
    }

    private d() {
    }

    static String b(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            if (Character.isUpperCase((char)c2) && stringBuilder.length() != 0) {
                stringBuilder.append(string2);
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    static String c(String string) {
        int n2;
        int n3 = string.length() - 1;
        for (n2 = 0; !Character.isLetter((char)string.charAt(n2)) && n2 < n3; ++n2) {
        }
        char c2 = string.charAt(n2);
        if (Character.isUpperCase((char)c2)) {
            return string;
        }
        char c3 = Character.toUpperCase((char)c2);
        if (n2 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c3);
            stringBuilder.append(string.substring(1));
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(0, n2));
        stringBuilder.append(c3);
        stringBuilder.append(string.substring(n2 + 1));
        return stringBuilder.toString();
    }

    public static d valueOf(String string) {
        return (d)Enum.valueOf(d.class, (String)string);
    }

    public static d[] values() {
        return (d[])l.clone();
    }

}

