/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package h.a.g.d;

import java.nio.ByteBuffer;

public abstract class a {
    public abstract ByteBuffer a();

    public abstract String b();

    public abstract void c(ByteBuffer var1);

    public int d() {
        return this.a().limit();
    }
}

