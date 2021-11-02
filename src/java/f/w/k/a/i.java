/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.w.k.a.a
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
package f.w.k.a;

import f.z.d.k;
import java.lang.reflect.Method;

final class i {
    private static final a a;
    private static a b;
    public static final i c;

    static {
        c = new i();
        a = new a(null, null, null);
    }

    private i() {
    }

    private final a a(f.w.k.a.a a2) {
        try {
            a a3;
            b = a3 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), a2.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), a2.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            return a3;
        }
        catch (Exception exception) {
            a a4;
            b = a4 = a;
            return a4;
        }
    }

    public final String b(f.w.k.a.a a2) {
        k.g((Object)a2, "continuation");
        a a3 = b;
        if (a3 == null) {
            a3 = this.a(a2);
        }
        if (a3 == a) {
            return null;
        }
        Method method = a3.a;
        String string2 = null;
        if (method != null) {
            Object object = method.invoke((Object)a2.getClass(), new Object[0]);
            string2 = null;
            if (object != null) {
                Method method2 = a3.b;
                string2 = null;
                if (method2 != null) {
                    Object object2 = method2.invoke(object, new Object[0]);
                    string2 = null;
                    if (object2 != null) {
                        Method method3 = a3.c;
                        Object object3 = method3 != null ? method3.invoke(object2, new Object[0]) : null;
                        Object object4 = !(object3 instanceof String) ? null : object3;
                        string2 = (String)object4;
                    }
                }
            }
        }
        return string2;
    }

    private static final class a {
        public final Method a;
        public final Method b;
        public final Method c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

}

