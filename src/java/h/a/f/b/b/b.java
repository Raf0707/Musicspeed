/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.a.f.a.d.a
 *  h.a.f.b.b.c
 *  h.a.f.b.b.c$a
 *  h.a.f.b.b.e
 *  h.a.f.b.b.g
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NoClassDefFoundError
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.Void
 *  java.util.Hashtable
 *  java.util.StringTokenizer
 */
package h.a.f.b.b;

import h.a.f.a.a;
import h.a.f.a.d.a;
import h.a.f.b.b.c;
import h.a.f.b.b.e;
import h.a.f.b.b.g;
import java.util.Hashtable;
import java.util.StringTokenizer;

public final class b {
    private static final Class[] a;
    private static final String[] b;
    static Hashtable c;
    private static Object[] d;
    static /* synthetic */ Class e;
    Class f;
    ClassLoader g;
    String h;
    int i;

    static {
        Hashtable hashtable;
        a = new Class[0];
        b = new String[0];
        c = hashtable = new Hashtable();
        hashtable.put((Object)"void", (Object)Void.TYPE);
        c.put((Object)"boolean", (Object)Boolean.TYPE);
        c.put((Object)"byte", (Object)Byte.TYPE);
        c.put((Object)"char", (Object)Character.TYPE);
        c.put((Object)"short", (Object)Short.TYPE);
        c.put((Object)"int", (Object)Integer.TYPE);
        c.put((Object)"long", (Object)Long.TYPE);
        c.put((Object)"float", (Object)Float.TYPE);
        c.put((Object)"double", (Object)Double.TYPE);
        d = new Object[0];
    }

    public b(String string2, Class class_) {
        this.h = string2;
        this.f = class_;
        this.i = 0;
        this.g = class_.getClassLoader();
    }

    static /* synthetic */ Class a(String string2) {
        try {
            Class class_ = Class.forName((String)string2);
            return class_;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static Class b(String string2, ClassLoader classLoader) {
        if (string2.equals((Object)"*")) {
            return null;
        }
        Class class_ = (Class)c.get((Object)string2);
        if (class_ != null) {
            return class_;
        }
        if (classLoader != null) return Class.forName((String)string2, (boolean)false, (ClassLoader)classLoader);
        try {
            return Class.forName((String)string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            Class class_2 = e;
            if (class_2 != null) return class_2;
            e = class_2 = b.a("java.lang.ClassNotFoundException");
            return class_2;
        }
    }

    public static h.a.f.a.a c(a.a a2, Object object, Object object2) {
        return new c(a2, object, object2, d);
    }

    public static h.a.f.a.a d(a.a a2, Object object, Object object2, Object object3) {
        return new c(a2, object, object2, new Object[]{object3});
    }

    public a e(String string2, String string3, Class class_, String string4, String string5, String string6, String string7) {
        int n2 = Integer.parseInt((String)string2, (int)16);
        StringTokenizer stringTokenizer = new StringTokenizer(string4, ":");
        int n3 = stringTokenizer.countTokens();
        Class[] arrclass = new Class[n3];
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            arrclass[i2] = b.b(stringTokenizer.nextToken(), this.g);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(string5, ":");
        int n5 = stringTokenizer2.countTokens();
        String[] arrstring = new String[n5];
        for (int i3 = 0; i3 < n5; ++i3) {
            arrstring[i3] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(string6, ":");
        int n6 = stringTokenizer3.countTokens();
        Class[] arrclass2 = new Class[n6];
        while (n4 < n6) {
            arrclass2[n4] = b.b(stringTokenizer3.nextToken(), this.g);
            ++n4;
        }
        Class class_2 = b.b(string7, this.g);
        e e2 = new e(n2, string3, class_, arrclass, arrstring, arrclass2, class_2);
        return e2;
    }

    public a f(String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        return this.e(string2, string3, b.b(string4, this.g), string5, string6, string7, string8);
    }

    public a.a g(String string2, h.a.f.a.c c2, int n2) {
        int n3 = this.i;
        this.i = n3 + 1;
        return new c.a(n3, string2, c2, this.h(n2, -1));
    }

    public h.a.f.a.d.b h(int n2, int n3) {
        return new g(this.f, this.h, n2);
    }
}

