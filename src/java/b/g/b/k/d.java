/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.g
 *  java.lang.AssertionError
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 */
package b.g.b.k;

import b.g.b.c;
import b.g.b.i;
import b.g.b.k.e;
import b.g.b.k.g;
import b.g.b.k.m.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class d {
    private HashSet<d> a = null;
    private int b;
    private boolean c;
    public final e d;
    public final b e;
    public d f;
    public int g = 0;
    int h = -1;
    i i;

    public d(e e2, b b2) {
        this.d = e2;
        this.e = b2;
    }

    public boolean a(d d2, int n2, int n3, boolean bl) {
        HashSet<d> hashSet;
        if (d2 == null) {
            this.p();
            return true;
        }
        if (!bl && !this.o(d2)) {
            return false;
        }
        this.f = d2;
        if (d2.a == null) {
            d2.a = new HashSet();
        }
        if ((hashSet = this.f.a) != null) {
            hashSet.add((Object)this);
        }
        this.g = n2 > 0 ? n2 : 0;
        this.h = n3;
        return true;
    }

    public void b(int n2, ArrayList<o> arrayList, o o2) {
        HashSet<d> hashSet = this.a;
        if (hashSet != null) {
            Iterator iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                b.g.b.k.m.i.a(((d)iterator.next()).d, n2, arrayList, o2);
            }
        }
    }

    public HashSet<d> c() {
        return this.a;
    }

    public int d() {
        if (!this.c) {
            return 0;
        }
        return this.b;
    }

    public int e() {
        d d2;
        if (this.d.Q() == 8) {
            return 0;
        }
        if (this.h > -1 && (d2 = this.f) != null && d2.d.Q() == 8) {
            return this.h;
        }
        return this.g;
    }

    public final d f() {
        switch (a.a[this.e.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.e.name());
            }
            case 5: {
                return this.d.J;
            }
            case 4: {
                return this.d.L;
            }
            case 3: {
                return this.d.I;
            }
            case 2: {
                return this.d.K;
            }
            case 1: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
        }
        return null;
    }

    public e g() {
        return this.d;
    }

    public i h() {
        return this.i;
    }

    public d i() {
        return this.f;
    }

    public b j() {
        return this.e;
    }

    public boolean k() {
        HashSet<d> hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            if (!((d)iterator.next()).f().n()) continue;
            return true;
        }
        return false;
    }

    public boolean l() {
        HashSet<d> hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        int n2 = hashSet.size();
        boolean bl = false;
        if (n2 > 0) {
            bl = true;
        }
        return bl;
    }

    public boolean m() {
        return this.c;
    }

    public boolean n() {
        return this.f != null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean o(d d2) {
        b b2;
        if (d2 == null) {
            return false;
        }
        b b3 = d2.j();
        if (b3 == (b2 = this.e)) {
            if (b2 != b.k) return true;
            if (!d2.g().U()) return false;
            if (this.g().U()) return true;
            return false;
        }
        switch (a.a[b2.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.e.name());
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return false;
            }
            case 4: 
            case 5: {
                boolean bl = b3 == b.h || b3 == b.j;
                if (!(d2.g() instanceof g)) return bl;
                if (bl) return true;
                b b4 = b.n;
                boolean bl2 = false;
                if (b3 != b4) return bl2;
                return true;
            }
            case 2: 
            case 3: {
                boolean bl = b3 == b.g || b3 == b.i;
                if (!(d2.g() instanceof g)) return bl;
                if (bl) return true;
                b b5 = b.m;
                boolean bl3 = false;
                if (b3 != b5) return bl3;
                return true;
            }
            case 1: 
        }
        b b6 = b.k;
        boolean bl = false;
        if (b3 == b6) return bl;
        b b7 = b.m;
        bl = false;
        if (b3 == b7) return bl;
        b b8 = b.n;
        bl = false;
        if (b3 == b8) return bl;
        return true;
    }

    public void p() {
        HashSet<d> hashSet;
        d d2 = this.f;
        if (d2 != null && (hashSet = d2.a) != null) {
            hashSet.remove((Object)this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = -1;
        this.c = false;
        this.b = 0;
    }

    public void q() {
        this.c = false;
        this.b = 0;
    }

    public void r(c c2) {
        i i2 = this.i;
        if (i2 == null) {
            this.i = new i(i.a.f, null);
            return;
        }
        i2.d();
    }

    public void s(int n2) {
        this.b = n2;
        this.c = true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d.r());
        stringBuilder.append(":");
        stringBuilder.append(this.e.toString());
        return stringBuilder.toString();
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b f;
        public static final /* enum */ b g;
        public static final /* enum */ b h;
        public static final /* enum */ b i;
        public static final /* enum */ b j;
        public static final /* enum */ b k;
        public static final /* enum */ b l;
        public static final /* enum */ b m;
        public static final /* enum */ b n;
        private static final /* synthetic */ b[] o;

        static {
            b b2;
            b b3;
            b b4;
            b b5;
            b b6;
            b b7;
            b b8;
            b b9;
            b b10;
            f = b4 = new b();
            g = b2 = new b();
            h = b9 = new b();
            i = b8 = new b();
            j = b5 = new b();
            k = b10 = new b();
            l = b6 = new b();
            m = b7 = new b();
            n = b3 = new b();
            o = new b[]{b4, b2, b9, b8, b5, b10, b6, b7, b3};
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])o.clone();
        }
    }

}

