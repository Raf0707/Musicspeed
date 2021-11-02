/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.util.NoSuchElementException
 */
package f.d0;

import f.u.e0;
import java.util.NoSuchElementException;

public final class e
extends e0 {
    private final int f;
    private boolean g;
    private int h;
    private final int i;

    public e(int n2, int n3, int n4) {
        this.i = n4;
        this.f = n3;
        boolean bl = true;
        if (!(n4 > 0 ? n2 <= n3 : n2 >= n3)) {
            bl = false;
        }
        this.g = bl;
        if (!bl) {
            n2 = n3;
        }
        this.h = n2;
    }

    @Override
    public int c() {
        int n2 = this.h;
        if (n2 == this.f) {
            if (this.g) {
                this.g = false;
                return n2;
            }
            throw new NoSuchElementException();
        }
        this.h = n2 + this.i;
        return n2;
    }

    public boolean hasNext() {
        return this.g;
    }
}

