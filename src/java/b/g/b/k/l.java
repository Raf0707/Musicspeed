/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 */
package b.g.b.k;

import b.g.b.c;
import b.g.b.k.e;
import java.util.ArrayList;

public class l
extends e {
    public ArrayList<e> D0 = new ArrayList();

    public void a(e e2) {
        this.D0.add((Object)e2);
        if (e2.I() != null) {
            ((l)e2.I()).c1(e2);
        }
        e2.M0(this);
    }

    public ArrayList<e> a1() {
        return this.D0;
    }

    public void b1() {
        ArrayList<e> arrayList = this.D0;
        if (arrayList == null) {
            return;
        }
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)this.D0.get(i2);
            if (!(e2 instanceof l)) continue;
            ((l)e2).b1();
        }
    }

    public void c1(e e2) {
        this.D0.remove((Object)e2);
        e2.h0();
    }

    public void d1() {
        this.D0.clear();
    }

    @Override
    public void h0() {
        this.D0.clear();
        super.h0();
    }

    @Override
    public void j0(c c2) {
        super.j0(c2);
        int n2 = this.D0.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((e)this.D0.get(i2)).j0(c2);
        }
    }
}

