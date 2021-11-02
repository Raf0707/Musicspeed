/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.w.k.a.a
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 */
package f.w.k.a;

import f.w.k.a.a;
import f.w.k.a.f;
import f.w.k.a.i;
import f.z.d.k;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class g {
    private static final void a(int n2, int n3) {
        if (n3 <= n2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Debug metadata version mismatch. Expected: ");
        stringBuilder.append(n2);
        stringBuilder.append(", got ");
        stringBuilder.append(n3);
        stringBuilder.append(". Please update the Kotlin standard library.");
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private static final f b(a a2) {
        return (f)a2.getClass().getAnnotation(f.class);
    }

    private static final int c(a a2) {
        int n2;
        block6 : {
            block5 : {
                Object object;
                block4 : {
                    try {
                        Field field = a2.getClass().getDeclaredField("label");
                        k.f((Object)field, "field");
                        field.setAccessible(true);
                        object = field.get((Object)a2);
                        if (object instanceof Integer) break block4;
                        object = null;
                    }
                    catch (Exception exception) {
                        return -1;
                    }
                }
                Integer n3 = (Integer)object;
                if (n3 == null) break block5;
                n2 = n3;
                break block6;
            }
            n2 = 0;
        }
        return n2 - 1;
    }

    public static final StackTraceElement d(a a2) {
        k.g((Object)a2, "$this$getStackTraceElementImpl");
        f f2 = g.b(a2);
        if (f2 != null) {
            String string2;
            g.a(1, f2.v());
            int n2 = g.c(a2);
            int n3 = n2 < 0 ? -1 : f2.l()[n2];
            String string3 = i.c.b(a2);
            if (string3 == null) {
                string2 = f2.c();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append('/');
                stringBuilder.append(f2.c());
                string2 = stringBuilder.toString();
            }
            return new StackTraceElement(string2, f2.m(), f2.f(), n3);
        }
        return null;
    }
}

