/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.util.AndroidRuntimeException
 *  android.view.View
 *  android.view.ViewGroup
 *  b.w.q$a
 *  b.w.q$b
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package b.w;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import b.w.g;
import b.w.m;
import b.w.p;
import b.w.q;
import b.w.s;
import b.w.t;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Exception performing whole class analysis.
 */
public class q
extends m {
    private ArrayList<m> P;
    private boolean Q;
    int R;
    boolean S;
    private int T;

    public q() {
        this.P = new ArrayList();
        this.Q = true;
        this.S = false;
        this.T = 0;
    }

    private void f0(m m2) {
        this.P.add((Object)m2);
        m2.z = this;
    }

    private void o0() {
        b b2 = new /* Unavailable Anonymous Inner Class!! */;
        Iterator iterator = this.P.iterator();
        while (iterator.hasNext()) {
            ((m)iterator.next()).a((m.f)b2);
        }
        this.R = this.P.size();
    }

    @Override
    public void N(View view) {
        super.N(view);
        int n2 = this.P.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((m)this.P.get(i2)).N(view);
        }
    }

    @Override
    public void R(View view) {
        super.R(view);
        int n2 = this.P.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((m)this.P.get(i2)).R(view);
        }
    }

    @Override
    protected void T() {
        if (this.P.isEmpty()) {
            this.a0();
            this.p();
            return;
        }
        this.o0();
        if (!this.Q) {
            for (int i2 = 1; i2 < this.P.size(); ++i2) {
                ((m)this.P.get(i2 - 1)).a((m.f)new a(this, (m)this.P.get(i2)));
            }
            m m2 = (m)this.P.get(0);
            if (m2 != null) {
                m2.T();
                return;
            }
        } else {
            Iterator iterator = this.P.iterator();
            while (iterator.hasNext()) {
                ((m)iterator.next()).T();
            }
        }
    }

    @Override
    public void V(m.e e2) {
        super.V(e2);
        this.T = 8 | this.T;
        int n2 = this.P.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((m)this.P.get(i2)).V(e2);
        }
    }

    @Override
    public void X(g g2) {
        super.X(g2);
        this.T = 4 | this.T;
        if (this.P != null) {
            for (int i2 = 0; i2 < this.P.size(); ++i2) {
                ((m)this.P.get(i2)).X(g2);
            }
        }
    }

    @Override
    public void Y(p p2) {
        super.Y(p2);
        this.T = 2 | this.T;
        int n2 = this.P.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((m)this.P.get(i2)).Y(p2);
        }
    }

    @Override
    String b0(String string) {
        String string2 = super.b0(string);
        for (int i2 = 0; i2 < this.P.size(); ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("\n");
            m m2 = (m)this.P.get(i2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append("  ");
            stringBuilder.append(m2.b0(stringBuilder2.toString()));
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public q c0(m.f f2) {
        return (q)super.a(f2);
    }

    public q d0(View view) {
        for (int i2 = 0; i2 < this.P.size(); ++i2) {
            ((m)this.P.get(i2)).b(view);
        }
        return (q)super.b(view);
    }

    public q e0(m m2) {
        this.f0(m2);
        long l2 = this.k;
        if (l2 >= 0L) {
            m2.U(l2);
        }
        if ((1 & this.T) != 0) {
            m2.W(this.s());
        }
        if ((2 & this.T) != 0) {
            m2.Y(this.w());
        }
        if ((4 & this.T) != 0) {
            m2.X(this.v());
        }
        if ((8 & this.T) != 0) {
            m2.V(this.r());
        }
        return this;
    }

    @Override
    public void g(s s2) {
        if (this.G(s2.b)) {
            for (m m2 : this.P) {
                if (!m2.G(s2.b)) continue;
                m2.g(s2);
                s2.c.add((Object)m2);
            }
        }
    }

    public m g0(int n2) {
        if (n2 >= 0 && n2 < this.P.size()) {
            return (m)this.P.get(n2);
        }
        return null;
    }

    public int h0() {
        return this.P.size();
    }

    @Override
    void i(s s2) {
        super.i(s2);
        int n2 = this.P.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((m)this.P.get(i2)).i(s2);
        }
    }

    public q i0(m.f f2) {
        return (q)super.P(f2);
    }

    @Override
    public void j(s s2) {
        if (this.G(s2.b)) {
            for (m m2 : this.P) {
                if (!m2.G(s2.b)) continue;
                m2.j(s2);
                s2.c.add((Object)m2);
            }
        }
    }

    public q j0(View view) {
        for (int i2 = 0; i2 < this.P.size(); ++i2) {
            ((m)this.P.get(i2)).Q(view);
        }
        return (q)super.Q(view);
    }

    public q k0(long l2) {
        ArrayList<m> arrayList;
        super.U(l2);
        if (this.k >= 0L && (arrayList = this.P) != null) {
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                ((m)this.P.get(i2)).U(l2);
            }
        }
        return this;
    }

    public q l0(TimeInterpolator timeInterpolator) {
        this.T = 1 | this.T;
        ArrayList<m> arrayList = this.P;
        if (arrayList != null) {
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                ((m)this.P.get(i2)).W(timeInterpolator);
            }
        }
        return (q)super.W(timeInterpolator);
    }

    @Override
    public m m() {
        q q2 = (q)super.m();
        q2.P = new ArrayList();
        int n2 = this.P.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            q2.f0(((m)this.P.get(i2)).m());
        }
        return q2;
    }

    public q m0(int n2) {
        if (n2 != 0) {
            if (n2 == 1) {
                this.Q = false;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid parameter for TransitionSet ordering: ");
            stringBuilder.append(n2);
            throw new AndroidRuntimeException(stringBuilder.toString());
        }
        this.Q = true;
        return this;
    }

    public q n0(long l2) {
        return (q)super.Z(l2);
    }

    @Override
    protected void o(ViewGroup viewGroup, t t2, t t3, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long l2 = this.y();
        int n2 = this.P.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            m m2 = (m)this.P.get(i2);
            if (l2 > 0L && (this.Q || i2 == 0)) {
                long l3 = m2.y();
                if (l3 > 0L) {
                    m2.Z(l3 + l2);
                } else {
                    m2.Z(l2);
                }
            }
            m2.o(viewGroup, t2, t3, arrayList, arrayList2);
        }
    }
}

