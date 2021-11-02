/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package b.i.p;

public class b {
    public static void a(Object object, StringBuilder stringBuilder) {
        int n2;
        if (object == null) {
            stringBuilder.append("null");
            return;
        }
        String string = object.getClass().getSimpleName();
        if (string.length() <= 0 && (n2 = (string = object.getClass().getName()).lastIndexOf(46)) > 0) {
            string = string.substring(n2 + 1);
        }
        stringBuilder.append(string);
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)object)));
    }
}

