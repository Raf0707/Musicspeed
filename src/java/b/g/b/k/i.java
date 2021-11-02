/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.f
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Arrays
 */
package b.g.b.k;

import b.g.b.k.e;
import b.g.b.k.f;
import b.g.b.k.h;
import b.g.b.k.m.o;
import java.util.ArrayList;
import java.util.Arrays;

public class i
extends e
implements h {
    public e[] D0 = new e[4];
    public int E0 = 0;

    @Override
    public void a(e e2) {
        if (e2 != this) {
            if (e2 == null) {
                return;
            }
            int n2 = 1 + this.E0;
            Object[] arrobject = this.D0;
            if (n2 > arrobject.length) {
                this.D0 = (e[])Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
            }
            e[] arre = this.D0;
            int n3 = this.E0;
            arre[n3] = e2;
            this.E0 = n3 + 1;
        }
    }

    public void a1(ArrayList<o> arrayList, int n2, o o2) {
        int n3 = 0;
        do {
            int n4 = this.E0;
            if (n3 >= n4) break;
            o2.a(this.D0[n3]);
            ++n3;
        } while (true);
        for (int i2 = 0; i2 < this.E0; ++i2) {
            b.g.b.k.m.i.a(this.D0[i2], n2, arrayList, o2);
        }
    }

    @Override
    public void b() {
        this.E0 = 0;
        Arrays.fill((Object[])this.D0, null);
    }

    public int b1(int n2) {
        for (int i2 = 0; i2 < this.E0; ++i2) {
            int n3;
            int n4;
            e e2 = this.D0[i2];
            if (n2 == 0 && (n4 = e2.B0) != -1) {
                return n4;
            }
            if (n2 != 1 || (n3 = e2.C0) == -1) continue;
            return n3;
        }
        return -1;
    }

    @Override
    public void c(f f2) {
    }
}

