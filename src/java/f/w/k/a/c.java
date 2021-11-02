/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package f.w.k.a;

import f.w.d;
import f.w.g;

public final class c
implements d<Object> {
    public static final c f = new c();

    private c() {
    }

    @Override
    public void e(Object object) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override
    public g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}

