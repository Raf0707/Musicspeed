/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.SecurityManager
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 */
package h.e.f;

import java.io.PrintStream;

public final class g {
    private static b a;
    private static boolean b;

    private g() {
    }

    public static Class<?> a() {
        int n2;
        int n3;
        b b2 = g.b();
        if (b2 == null) {
            return null;
        }
        Class<?>[] arrclass = b2.getClassContext();
        String string2 = g.class.getName();
        for (n2 = 0; n2 < arrclass.length && !string2.equals((Object)arrclass[n2].getName()); ++n2) {
        }
        if (n2 < arrclass.length && (n3 = n2 + 2) < arrclass.length) {
            return arrclass[n3];
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    private static b b() {
        b b2;
        b b3 = a;
        if (b3 != null) {
            return b3;
        }
        if (b) {
            return null;
        }
        a = b2 = g.e();
        b = true;
        return b2;
    }

    public static final void c(String string2) {
        PrintStream printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SLF4J: ");
        stringBuilder.append(string2);
        printStream.println(stringBuilder.toString());
    }

    public static final void d(String string2, Throwable throwable) {
        System.err.println(string2);
        System.err.println("Reported exception:");
        throwable.printStackTrace();
    }

    private static b e() {
        try {
            b b2 = new b();
            return b2;
        }
        catch (SecurityException securityException) {
            return null;
        }
    }

    public static boolean f(String string2) {
        String string3 = g.g(string2);
        if (string3 == null) {
            return false;
        }
        return string3.equalsIgnoreCase("true");
    }

    public static String g(String string2) {
        if (string2 != null) {
            String string3;
            string3 = null;
            try {
                string3 = System.getProperty((String)string2);
            }
            catch (SecurityException securityException) {}
            return string3;
        }
        throw new IllegalArgumentException("null input");
    }

    private static final class b
    extends SecurityManager {
        private b() {
        }

        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

}

