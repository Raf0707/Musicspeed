/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package f.z.d;

import f.z.b;
import f.z.d.z;
import java.io.Serializable;

public abstract class c
implements f.e0.a,
Serializable {
    public static final Object NO_RECEIVER = a.a();
    private transient f.e0.a f;
    protected final Object g;
    private final Class h;
    private final String i;
    private final String j;
    private final boolean k;

    public c() {
        this(NO_RECEIVER);
    }

    protected c(Object object) {
        this(object, null, null, null, false);
    }

    protected c(Object object, Class class_, String string2, String string3, boolean bl) {
        this.g = object;
        this.h = class_;
        this.i = string2;
        this.j = string3;
        this.k = bl;
    }

    protected abstract f.e0.a c();

    public f.e0.a compute() {
        f.e0.a a2 = this.f;
        if (a2 == null) {
            this.f = a2 = this.c();
        }
        return a2;
    }

    protected f.e0.a d() {
        f.e0.a a2 = this.compute();
        if (a2 != this) {
            return a2;
        }
        throw new b();
    }

    public Object getBoundReceiver() {
        return this.g;
    }

    @Override
    public String getName() {
        return this.i;
    }

    public f.e0.c getOwner() {
        Class class_ = this.h;
        if (class_ == null) {
            return null;
        }
        if (this.k) {
            return z.c(class_);
        }
        return z.b(class_);
    }

    public String getSignature() {
        return this.j;
    }

}

