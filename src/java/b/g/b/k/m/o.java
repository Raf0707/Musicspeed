/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.f
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 */
package b.g.b.k.m;

import b.g.b.k.b;
import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class o {
    static int a;
    ArrayList<e> b = new ArrayList();
    int c = -1;
    boolean d = false;
    int e = 0;
    ArrayList<a> f = null;
    private int g = -1;

    public o(int n2) {
        int n3 = a;
        a = n3 + 1;
        this.c = n3;
        this.e = n2;
    }

    private String e() {
        int n2 = this.e;
        if (n2 == 0) {
            return "Horizontal";
        }
        if (n2 == 1) {
            return "Vertical";
        }
        if (n2 == 2) {
            return "Both";
        }
        return "Unknown";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int j(b.g.b.d d2, ArrayList<e> arrayList, int n2) {
        int n3;
        int n4;
        int n5 = 0;
        f f2 = (f)((e)arrayList.get(0)).I();
        d2.D();
        f2.g(d2, false);
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            ((e)arrayList.get(i2)).g(d2, false);
        }
        if (n2 == 0 && f2.O0 > 0) {
            b.b(f2, d2, arrayList, 0);
        }
        if (n2 == 1 && f2.P0 > 0) {
            b.b(f2, d2, arrayList, 1);
        }
        try {
            d2.z();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.f = new ArrayList();
        while (n5 < arrayList.size()) {
            a a2 = new a((e)arrayList.get(n5), d2, n2);
            this.f.add((Object)a2);
            ++n5;
        }
        if (n2 == 0) {
            n4 = d2.x(f2.I);
            n3 = d2.x(f2.K);
            d2.D();
            do {
                return n3 - n4;
                break;
            } while (true);
        }
        n4 = d2.x(f2.J);
        n3 = d2.x(f2.L);
        d2.D();
        return n3 - n4;
    }

    public boolean a(e e2) {
        if (this.b.contains((Object)e2)) {
            return false;
        }
        this.b.add((Object)e2);
        return true;
    }

    public void b(ArrayList<o> arrayList) {
        int n2 = this.b.size();
        if (this.g != -1 && n2 > 0) {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                o o2 = (o)arrayList.get(i2);
                if (this.g != o2.c) continue;
                this.g(this.e, o2);
            }
        }
        if (n2 == 0) {
            arrayList.remove((Object)this);
        }
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.e;
    }

    public int f(b.g.b.d d2, int n2) {
        if (this.b.size() == 0) {
            return 0;
        }
        return this.j(d2, this.b, n2);
    }

    public void g(int n2, o o2) {
        for (e e2 : this.b) {
            o2.a(e2);
            if (n2 == 0) {
                e2.B0 = o2.c();
                continue;
            }
            e2.C0 = o2.c();
        }
        this.g = o2.c;
    }

    public void h(boolean bl) {
        this.d = bl;
    }

    public void i(int n2) {
        this.e = n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e());
        stringBuilder.append(" [");
        stringBuilder.append(this.c);
        stringBuilder.append("] <");
        String string = stringBuilder.toString();
        for (e e2 : this.b) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(" ");
            stringBuilder2.append(e2.r());
            string = stringBuilder2.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string);
        stringBuilder3.append(" >");
        return stringBuilder3.toString();
    }

    class a {
        WeakReference<e> a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;

        public a(e e2, b.g.b.d d2, int n2) {
            this.a = new WeakReference((Object)e2);
            this.b = d2.x(e2.I);
            this.c = d2.x(e2.J);
            this.d = d2.x(e2.K);
            this.e = d2.x(e2.L);
            this.f = d2.x(e2.M);
            this.g = n2;
        }
    }

}

