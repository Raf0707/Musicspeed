/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 */
package h.c.c;

import h.c.a;
import java.lang.reflect.Field;

public final class c {
    public static final String a = System.getProperty((String)"java.specification.version");
    public static final String b = System.getProperty((String)"java.runtime.version");
    public static final String c = System.getProperty((String)"java.vm.info");
    public static final String d = System.getProperty((String)"java.vm.version");
    public static final String e = System.getProperty((String)"java.vm.vendor");
    public static final String f = System.getProperty((String)"java.vm.name");
    public static final int g = c.a();
    public static final boolean h = c.d();
    public static final String i = c.c();

    private static int a() {
        if (!c.h("Dalvik")) {
            return 0;
        }
        return c.b();
    }

    private static int b() {
        Class class_;
        Field field;
        try {
            class_ = Class.forName((String)"android.os.Build$VERSION");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new a(classNotFoundException);
        }
        try {
            field = class_.getField("SDK_INT");
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return c.e(class_);
        }
        try {
            int n2 = (Integer)field.get(null);
            return n2;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException((Throwable)illegalAccessException);
        }
    }

    private static String c() {
        return System.getProperty((String)"com.google.appengine.runtime.version");
    }

    private static boolean d() {
        if (c.a() == 0) {
            return false;
        }
        String string2 = System.getProperty((String)"java.boot.class.path");
        boolean bl = false;
        if (string2 != null) {
            boolean bl2 = string2.toLowerCase().contains((CharSequence)"core-oj.jar");
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    private static int e(Class<?> class_) {
        Field field;
        String string2;
        try {
            field = class_.getField("SDK");
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new a(noSuchFieldException);
        }
        try {
            string2 = (String)field.get(null);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException((Throwable)illegalAccessException);
        }
        return Integer.parseInt((String)string2);
    }

    public static boolean f() {
        return h;
    }

    public static boolean g() {
        return i != null;
    }

    public static boolean h(String string2) {
        return f.startsWith(string2);
    }
}

