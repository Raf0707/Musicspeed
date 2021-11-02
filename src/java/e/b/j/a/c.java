/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package e.b.j.a;

import e.b.j.c.a;

public final class c
extends Enum<c>
implements a<Object> {
    public static final /* enum */ c f;
    public static final /* enum */ c g;
    private static final /* synthetic */ c[] h;

    static {
        c c2;
        c c3;
        f = c2 = new c();
        g = c3 = new c();
        h = new c[]{c2, c3};
    }

    public static c valueOf(String string) {
        return (c)Enum.valueOf(c.class, (String)string);
    }

    public static c[] values() {
        return (c[])h.clone();
    }

    @Override
    public void a() {
    }

    @Override
    public void clear() {
    }

    @Override
    public int f(int n2) {
        return n2 & 2;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean offer(Object object) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override
    public Object poll() throws Exception {
        return null;
    }
}

