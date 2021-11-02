/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 */
package f.y;

import f.z.d.k;
import java.io.ByteArrayOutputStream;

final class d
extends ByteArrayOutputStream {
    public d(int n2) {
        super(n2);
    }

    public final byte[] a() {
        byte[] arrby = this.buf;
        k.f(arrby, "buf");
        return arrby;
    }
}

