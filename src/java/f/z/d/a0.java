/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.e0.b
 *  f.e0.d
 *  f.e0.e
 *  f.e0.f
 *  f.e0.h
 *  f.z.d.e
 *  f.z.d.h
 *  f.z.d.i
 *  f.z.d.l
 *  f.z.d.m
 *  f.z.d.o
 *  f.z.d.r
 *  f.z.d.s
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 */
package f.z.d;

import f.e0.b;
import f.e0.c;
import f.e0.d;
import f.e0.f;
import f.z.d.e;
import f.z.d.h;
import f.z.d.i;
import f.z.d.l;
import f.z.d.m;
import f.z.d.o;
import f.z.d.r;
import f.z.d.s;
import java.lang.reflect.Type;

public class a0 {
    public d a(i i2) {
        return i2;
    }

    public b b(Class class_) {
        return new e(class_);
    }

    public c c(Class class_, String string2) {
        return new r(class_, string2);
    }

    public f.e0.e d(m m2) {
        return m2;
    }

    public f e(o o2) {
        return o2;
    }

    public f.e0.h f(s s2) {
        return s2;
    }

    public String g(h h2) {
        String string2 = h2.getClass().getGenericInterfaces()[0].toString();
        if (string2.startsWith("kotlin.jvm.functions.")) {
            string2 = string2.substring(21);
        }
        return string2;
    }

    public String h(l l2) {
        return this.g((h)l2);
    }
}

