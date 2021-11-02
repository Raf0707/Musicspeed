/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  I
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Array
 *  java.util.ArrayList
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package c.g.a.a.a;

import c.g.a.a.a.j.e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class i {
    private static final Pattern a = Pattern.compile((String)"<(head)( [^>]*)?>", (int)2);
    private static final Pattern b = Pattern.compile((String)"<(head)( [^>]*)?/>", (int)2);
    private static final Pattern c = Pattern.compile((String)"<(body)( [^>]*?)?>", (int)2);
    private static final Pattern d = Pattern.compile((String)"<(body)( [^>]*?)?/>", (int)2);
    private static final Pattern e = Pattern.compile((String)"<(html)( [^>]*?)?>", (int)2);
    private static final Pattern f = Pattern.compile((String)"<(html)( [^>]*?)?/>", (int)2);
    private static final Pattern g = Pattern.compile((String)"<!DOCTYPE [^>]*>", (int)2);

    static String a(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<script type=\"text/javascript\">");
        stringBuilder.append(string);
        stringBuilder.append("</script>");
        return i.e(string2, stringBuilder.toString());
    }

    private static boolean b(int n2, int[][] arrn) {
        if (arrn != null) {
            for (int[] arrn2 : arrn) {
                if (n2 < arrn2[0] || n2 > arrn2[1]) continue;
                return true;
            }
        }
        return false;
    }

    private static boolean c(String string, StringBuilder stringBuilder, Pattern pattern, String string2, int[][] arrn) {
        Matcher matcher = pattern.matcher((CharSequence)string);
        int n2 = 0;
        while (matcher.find(n2)) {
            int n3 = matcher.start();
            int n4 = matcher.end();
            if (!i.b(n3, arrn)) {
                stringBuilder.append(string.substring(0, matcher.end()));
                stringBuilder.append(string2);
                stringBuilder.append(string.substring(matcher.end()));
                return true;
            }
            n2 = n4;
        }
        return false;
    }

    private static int[][] d(String string) {
        ArrayList arrayList = new ArrayList();
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            int n4 = string.indexOf("<!--", n3);
            if (n4 >= 0) {
                int n5 = string.indexOf("-->", n4);
                int[] arrn = new int[2];
                if (n5 >= 0) {
                    arrn[0] = n4;
                    arrn[1] = n5;
                    arrayList.add((Object)arrn);
                    n3 = n5 + 3;
                    continue;
                }
                arrn[0] = n4;
                arrn[1] = n2;
                arrayList.add((Object)arrn);
            }
            n3 = n2;
        }
        return (int[][])arrayList.toArray((Object[])((int[][])Array.newInstance(I.class, (int[])new int[]{0, 2})));
    }

    static String e(String string, String string2) {
        e.f(string, "HTML is null or empty");
        int[][] arrn = i.d(string);
        StringBuilder stringBuilder = new StringBuilder(16 + (string.length() + string2.length()));
        if (i.f(string, stringBuilder, b, string2, arrn)) {
            return stringBuilder.toString();
        }
        if (i.c(string, stringBuilder, a, string2, arrn)) {
            return stringBuilder.toString();
        }
        if (i.f(string, stringBuilder, d, string2, arrn)) {
            return stringBuilder.toString();
        }
        if (i.c(string, stringBuilder, c, string2, arrn)) {
            return stringBuilder.toString();
        }
        if (i.f(string, stringBuilder, f, string2, arrn)) {
            return stringBuilder.toString();
        }
        if (i.c(string, stringBuilder, e, string2, arrn)) {
            return stringBuilder.toString();
        }
        if (i.c(string, stringBuilder, g, string2, arrn)) {
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append(string);
        return stringBuilder2.toString();
    }

    private static boolean f(String string, StringBuilder stringBuilder, Pattern pattern, String string2, int[][] arrn) {
        Matcher matcher = pattern.matcher((CharSequence)string);
        int n2 = 0;
        while (matcher.find(n2)) {
            int n3 = matcher.start();
            int n4 = matcher.end();
            if (!i.b(n3, arrn)) {
                stringBuilder.append(string.substring(0, -2 + matcher.end()));
                stringBuilder.append(">");
                stringBuilder.append(string2);
                stringBuilder.append("</");
                stringBuilder.append(matcher.group(1));
                stringBuilder.append(">");
                stringBuilder.append(string.substring(matcher.end()));
                return true;
            }
            n2 = n4;
        }
        return false;
    }
}

