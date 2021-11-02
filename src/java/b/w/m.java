/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.graphics.Path
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  b.i.q.w
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package b.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListAdapter;
import android.widget.ListView;
import b.i.q.w;
import b.w.c0;
import b.w.g;
import b.w.m0;
import b.w.p;
import b.w.q;
import b.w.s;
import b.w.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class m
implements Cloneable {
    private static final int[] f = new int[]{2, 1, 3, 4};
    private static final g g = new g(){

        @Override
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    private static ThreadLocal<b.e.a<Animator, d>> h = new ThreadLocal();
    private int[] A = f;
    private ArrayList<s> B;
    private ArrayList<s> C;
    private ViewGroup D = null;
    boolean E = false;
    ArrayList<Animator> F = new ArrayList();
    private int G = 0;
    private boolean H = false;
    private boolean I = false;
    private ArrayList<f> J = null;
    private ArrayList<Animator> K = new ArrayList();
    p L;
    private e M;
    private b.e.a<String, String> N;
    private g O = g;
    private String i = this.getClass().getName();
    private long j = -1L;
    long k = -1L;
    private TimeInterpolator l = null;
    ArrayList<Integer> m = new ArrayList();
    ArrayList<View> n = new ArrayList();
    private ArrayList<String> o = null;
    private ArrayList<Class<?>> p = null;
    private ArrayList<Integer> q = null;
    private ArrayList<View> r = null;
    private ArrayList<Class<?>> s = null;
    private ArrayList<String> t = null;
    private ArrayList<Integer> u = null;
    private ArrayList<View> v = null;
    private ArrayList<Class<?>> w = null;
    private t x = new t();
    private t y = new t();
    q z = null;

    private static boolean H(s s2, s s3, String string) {
        Object object = s2.a.get((Object)string);
        Object object2 = s3.a.get((Object)string);
        boolean bl = true;
        if (object == null && object2 == null) {
            return false;
        }
        if (object != null) {
            if (object2 == null) {
                return bl;
            }
            bl ^= object.equals(object2);
        }
        return bl;
    }

    private void I(b.e.a<View, s> a2, b.e.a<View, s> a3, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int n2 = sparseArray.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view;
            View view2 = (View)sparseArray.valueAt(i2);
            if (view2 == null || !this.G(view2) || (view = (View)sparseArray2.get(sparseArray.keyAt(i2))) == null || !this.G(view)) continue;
            s s2 = (s)a2.get((Object)view2);
            s s3 = (s)a3.get((Object)view);
            if (s2 == null || s3 == null) continue;
            this.B.add((Object)s2);
            this.C.add((Object)s3);
            a2.remove((Object)view2);
            a3.remove((Object)view);
        }
    }

    private void J(b.e.a<View, s> a2, b.e.a<View, s> a3) {
        for (int i2 = -1 + a2.size(); i2 >= 0; --i2) {
            s s2;
            View view = (View)a2.j(i2);
            if (view == null || !this.G(view) || (s2 = (s)a3.remove((Object)view)) == null || !this.G(s2.b)) continue;
            s s3 = (s)a2.l(i2);
            this.B.add((Object)s3);
            this.C.add((Object)s2);
        }
    }

    private void K(b.e.a<View, s> a2, b.e.a<View, s> a3, b.e.d<View> d2, b.e.d<View> d3) {
        int n2 = d2.l();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view;
            View view2 = d2.m(i2);
            if (view2 == null || !this.G(view2) || (view = d3.e(d2.h(i2))) == null || !this.G(view)) continue;
            s s2 = (s)a2.get((Object)view2);
            s s3 = (s)a3.get((Object)view);
            if (s2 == null || s3 == null) continue;
            this.B.add((Object)s2);
            this.C.add((Object)s3);
            a2.remove((Object)view2);
            a3.remove((Object)view);
        }
    }

    private void L(b.e.a<View, s> a2, b.e.a<View, s> a3, b.e.a<String, View> a4, b.e.a<String, View> a5) {
        int n2 = a4.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view;
            View view2 = (View)a4.n(i2);
            if (view2 == null || !this.G(view2) || (view = (View)a5.get(a4.j(i2))) == null || !this.G(view)) continue;
            s s2 = (s)a2.get((Object)view2);
            s s3 = (s)a3.get((Object)view);
            if (s2 == null || s3 == null) continue;
            this.B.add((Object)s2);
            this.C.add((Object)s3);
            a2.remove((Object)view2);
            a3.remove((Object)view);
        }
    }

    private void M(t t2, t t3) {
        int[] arrn;
        b.e.a<View, s> a2 = new b.e.a<View, s>(t2.a);
        b.e.a<View, s> a3 = new b.e.a<View, s>(t3.a);
        for (int i2 = 0; i2 < (arrn = this.A).length; ++i2) {
            int n2 = arrn[i2];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) continue;
                        this.K(a2, a3, t2.c, t3.c);
                        continue;
                    }
                    this.I(a2, a3, t2.b, t3.b);
                    continue;
                }
                this.L(a2, a3, t2.d, t3.d);
                continue;
            }
            this.J(a2, a3);
        }
        this.c(a2, a3);
    }

    private void S(Animator animator, final b.e.a<Animator, d> a2) {
        if (animator != null) {
            animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationEnd(Animator animator) {
                    a2.remove((Object)animator);
                    m.this.F.remove((Object)animator);
                }

                public void onAnimationStart(Animator animator) {
                    m.this.F.add((Object)animator);
                }
            });
            this.e(animator);
        }
    }

    private void c(b.e.a<View, s> a2, b.e.a<View, s> a3) {
        int n2 = 0;
        do {
            int n3 = a2.size();
            if (n2 >= n3) break;
            s s2 = (s)a2.n(n2);
            if (this.G(s2.b)) {
                this.B.add((Object)s2);
                this.C.add(null);
            }
            ++n2;
        } while (true);
        for (int i2 = 0; i2 < a3.size(); ++i2) {
            s s3 = (s)a3.n(i2);
            if (!this.G(s3.b)) continue;
            this.C.add((Object)s3);
            this.B.add(null);
        }
    }

    private static void d(t t2, View view, s s2) {
        ListView listView;
        String string;
        t2.a.put(view, s2);
        int n2 = view.getId();
        if (n2 >= 0) {
            if (t2.b.indexOfKey(n2) >= 0) {
                t2.b.put(n2, null);
            } else {
                t2.b.put(n2, (Object)view);
            }
        }
        if ((string = w.M((View)view)) != null) {
            if (t2.d.containsKey(string)) {
                t2.d.put(string, null);
            } else {
                t2.d.put(string, view);
            }
        }
        if (view.getParent() instanceof ListView && (listView = (ListView)view.getParent()).getAdapter().hasStableIds()) {
            long l2 = listView.getItemIdAtPosition(listView.getPositionForView(view));
            if (t2.c.g(l2) >= 0) {
                View view2 = t2.c.e(l2);
                if (view2 != null) {
                    w.B0((View)view2, (boolean)false);
                    t2.c.i(l2, null);
                    return;
                }
            } else {
                w.B0((View)view, (boolean)true);
                t2.c.i(l2, view);
            }
        }
    }

    private void h(View view, boolean bl) {
        if (view == null) {
            return;
        }
        int n2 = view.getId();
        ArrayList<Integer> arrayList = this.q;
        if (arrayList != null && arrayList.contains((Object)n2)) {
            return;
        }
        ArrayList<View> arrayList2 = this.r;
        if (arrayList2 != null && arrayList2.contains((Object)view)) {
            return;
        }
        ArrayList<Class<?>> arrayList3 = this.s;
        int n3 = 0;
        if (arrayList3 != null) {
            int n4 = arrayList3.size();
            for (int i2 = 0; i2 < n4; ++i2) {
                if (!((Class)this.s.get(i2)).isInstance((Object)view)) continue;
                return;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            s s2 = new s(view);
            if (bl) {
                this.j(s2);
            } else {
                this.g(s2);
            }
            s2.c.add((Object)this);
            this.i(s2);
            if (bl) {
                m.d(this.x, view, s2);
            } else {
                m.d(this.y, view, s2);
            }
        }
        if (view instanceof ViewGroup) {
            ArrayList<Integer> arrayList4 = this.u;
            if (arrayList4 != null && arrayList4.contains((Object)n2)) {
                return;
            }
            ArrayList<View> arrayList5 = this.v;
            if (arrayList5 != null && arrayList5.contains((Object)view)) {
                return;
            }
            ArrayList<Class<?>> arrayList6 = this.w;
            if (arrayList6 != null) {
                int n5 = arrayList6.size();
                for (int i3 = 0; i3 < n5; ++i3) {
                    if (!((Class)this.w.get(i3)).isInstance((Object)view)) continue;
                    return;
                }
            }
            ViewGroup viewGroup = (ViewGroup)view;
            while (n3 < viewGroup.getChildCount()) {
                this.h(viewGroup.getChildAt(n3), bl);
                ++n3;
            }
        }
    }

    private static b.e.a<Animator, d> x() {
        b.e.a a2 = (b.e.a)h.get();
        if (a2 == null) {
            a2 = new b.e.a();
            h.set(a2);
        }
        return a2;
    }

    public List<String> A() {
        return this.o;
    }

    public List<Class<?>> B() {
        return this.p;
    }

    public List<View> C() {
        return this.n;
    }

    public String[] D() {
        return null;
    }

    public s E(View view, boolean bl) {
        q q2 = this.z;
        if (q2 != null) {
            return q2.E(view, bl);
        }
        t t2 = bl ? this.x : this.y;
        return (s)t2.a.get((Object)view);
    }

    public boolean F(s s2, s s3) {
        boolean bl;
        block6 : {
            bl = false;
            if (s2 != null) {
                bl = false;
                if (s3 != null) {
                    block7 : {
                        String[] arrstring = this.D();
                        if (arrstring != null) {
                            int n2 = arrstring.length;
                            int n3 = 0;
                            do {
                                bl = false;
                                if (n3 >= n2) break block6;
                                if (!m.H(s2, s3, arrstring[n3])) {
                                    ++n3;
                                    continue;
                                }
                                break block7;
                                break;
                            } while (true);
                        }
                        Iterator iterator = s2.a.keySet().iterator();
                        do {
                            boolean bl2 = iterator.hasNext();
                            bl = false;
                            if (!bl2) break block6;
                        } while (!m.H(s2, s3, (String)iterator.next()));
                    }
                    bl = true;
                }
            }
        }
        return bl;
    }

    boolean G(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int n2 = view.getId();
        ArrayList<Integer> arrayList3 = this.q;
        if (arrayList3 != null && arrayList3.contains((Object)n2)) {
            return false;
        }
        ArrayList<View> arrayList4 = this.r;
        if (arrayList4 != null && arrayList4.contains((Object)view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.s;
        if (arrayList5 != null) {
            int n3 = arrayList5.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                if (!((Class)this.s.get(i2)).isInstance((Object)view)) continue;
                return false;
            }
        }
        if (this.t != null && w.M((View)view) != null && this.t.contains((Object)w.M((View)view))) {
            return false;
        }
        if (this.m.size() == 0 && this.n.size() == 0 && ((arrayList = this.p) == null || arrayList.isEmpty()) && ((arrayList2 = this.o) == null || arrayList2.isEmpty())) {
            return true;
        }
        if (!this.m.contains((Object)n2)) {
            if (this.n.contains((Object)view)) {
                return true;
            }
            ArrayList<String> arrayList6 = this.o;
            if (arrayList6 != null && arrayList6.contains((Object)w.M((View)view))) {
                return true;
            }
            if (this.p != null) {
                for (int i3 = 0; i3 < this.p.size(); ++i3) {
                    if (!((Class)this.p.get(i3)).isInstance((Object)view)) continue;
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void N(View view) {
        if (!this.I) {
            b.e.a<Animator, d> a2 = m.x();
            int n2 = a2.size();
            m0 m02 = c0.d(view);
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                d d2 = (d)a2.n(i2);
                if (d2.a == null || !m02.equals((Object)d2.d)) continue;
                b.w.a.b((Animator)a2.j(i2));
            }
            ArrayList<f> arrayList = this.J;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList)this.J.clone();
                int n3 = arrayList2.size();
                for (int i3 = 0; i3 < n3; ++i3) {
                    ((f)arrayList2.get(i3)).b(this);
                }
            }
            this.H = true;
        }
    }

    void O(ViewGroup viewGroup) {
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.M(this.x, this.y);
        b.e.a<Animator, d> a2 = m.x();
        int n2 = a2.size();
        m0 m02 = c0.d((View)viewGroup);
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            boolean bl;
            d d2;
            Animator animator = (Animator)a2.j(i2);
            if (animator == null || (d2 = (d)a2.get((Object)animator)) == null || d2.a == null || !m02.equals((Object)d2.d)) continue;
            s s2 = d2.c;
            View view = d2.a;
            s s3 = this.E(view, true);
            s s4 = this.t(view, true);
            if (s3 == null && s4 == null) {
                s4 = (s)this.y.a.get((Object)view);
            }
            if (!(bl = (s3 != null || s4 != null) && d2.e.F(s2, s4))) continue;
            if (!animator.isRunning() && !animator.isStarted()) {
                a2.remove((Object)animator);
                continue;
            }
            animator.cancel();
        }
        this.o(viewGroup, this.x, this.y, this.B, this.C);
        this.T();
    }

    public m P(f f2) {
        ArrayList<f> arrayList = this.J;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove((Object)f2);
        if (this.J.size() == 0) {
            this.J = null;
        }
        return this;
    }

    public m Q(View view) {
        this.n.remove((Object)view);
        return this;
    }

    public void R(View view) {
        if (this.H) {
            if (!this.I) {
                b.e.a<Animator, d> a2 = m.x();
                int n2 = a2.size();
                m0 m02 = c0.d(view);
                for (int i2 = n2 - 1; i2 >= 0; --i2) {
                    d d2 = (d)a2.n(i2);
                    if (d2.a == null || !m02.equals((Object)d2.d)) continue;
                    b.w.a.c((Animator)a2.j(i2));
                }
                ArrayList<f> arrayList = this.J;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList)this.J.clone();
                    int n3 = arrayList2.size();
                    for (int i3 = 0; i3 < n3; ++i3) {
                        ((f)arrayList2.get(i3)).e(this);
                    }
                }
            }
            this.H = false;
        }
    }

    protected void T() {
        this.a0();
        b.e.a<Animator, d> a2 = m.x();
        for (Animator animator : this.K) {
            if (!a2.containsKey((Object)animator)) continue;
            this.a0();
            this.S(animator, a2);
        }
        this.K.clear();
        this.p();
    }

    public m U(long l2) {
        this.k = l2;
        return this;
    }

    public void V(e e2) {
        this.M = e2;
    }

    public m W(TimeInterpolator timeInterpolator) {
        this.l = timeInterpolator;
        return this;
    }

    public void X(g g2) {
        if (g2 == null) {
            this.O = g;
            return;
        }
        this.O = g2;
    }

    public void Y(p p2) {
    }

    public m Z(long l2) {
        this.j = l2;
        return this;
    }

    public m a(f f2) {
        if (this.J == null) {
            this.J = new ArrayList();
        }
        this.J.add((Object)f2);
        return this;
    }

    protected void a0() {
        if (this.G == 0) {
            ArrayList<f> arrayList = this.J;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList)this.J.clone();
                int n2 = arrayList2.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ((f)arrayList2.get(i2)).a(this);
                }
            }
            this.I = false;
        }
        this.G = 1 + this.G;
    }

    public m b(View view) {
        this.n.add((Object)view);
        return this;
    }

    String b0(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString((int)this.hashCode()));
        stringBuilder.append(": ");
        String string2 = stringBuilder.toString();
        if (this.k != -1L) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append("dur(");
            stringBuilder2.append(this.k);
            stringBuilder2.append(") ");
            string2 = stringBuilder2.toString();
        }
        if (this.j != -1L) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string2);
            stringBuilder3.append("dly(");
            stringBuilder3.append(this.j);
            stringBuilder3.append(") ");
            string2 = stringBuilder3.toString();
        }
        if (this.l != null) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string2);
            stringBuilder4.append("interp(");
            stringBuilder4.append((Object)this.l);
            stringBuilder4.append(") ");
            string2 = stringBuilder4.toString();
        }
        if (this.m.size() > 0 || this.n.size() > 0) {
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(string2);
            stringBuilder5.append("tgts(");
            String string3 = stringBuilder5.toString();
            if (this.m.size() > 0) {
                for (int i2 = 0; i2 < this.m.size(); ++i2) {
                    if (i2 > 0) {
                        StringBuilder stringBuilder6 = new StringBuilder();
                        stringBuilder6.append(string3);
                        stringBuilder6.append(", ");
                        string3 = stringBuilder6.toString();
                    }
                    StringBuilder stringBuilder7 = new StringBuilder();
                    stringBuilder7.append(string3);
                    stringBuilder7.append(this.m.get(i2));
                    string3 = stringBuilder7.toString();
                }
            }
            int n2 = this.n.size();
            if (n2 > 0) {
                for (int i3 = 0; i3 < this.n.size(); ++i3) {
                    if (i3 > 0) {
                        StringBuilder stringBuilder8 = new StringBuilder();
                        stringBuilder8.append(string3);
                        stringBuilder8.append(", ");
                        string3 = stringBuilder8.toString();
                    }
                    StringBuilder stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(string3);
                    stringBuilder9.append(this.n.get(i3));
                    string3 = stringBuilder9.toString();
                }
            }
            StringBuilder stringBuilder10 = new StringBuilder();
            stringBuilder10.append(string3);
            stringBuilder10.append(")");
            string2 = stringBuilder10.toString();
        }
        return string2;
    }

    protected void e(Animator animator) {
        if (animator == null) {
            this.p();
            return;
        }
        if (this.q() >= 0L) {
            animator.setDuration(this.q());
        }
        if (this.y() >= 0L) {
            animator.setStartDelay(this.y() + animator.getStartDelay());
        }
        if (this.s() != null) {
            animator.setInterpolator(this.s());
        }
        animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                m.this.p();
                animator.removeListener((Animator.AnimatorListener)this);
            }
        });
        animator.start();
    }

    protected void f() {
        for (int i2 = -1 + this.F.size(); i2 >= 0; --i2) {
            ((Animator)this.F.get(i2)).cancel();
        }
        ArrayList<f> arrayList = this.J;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList)this.J.clone();
            int n2 = arrayList2.size();
            for (int i3 = 0; i3 < n2; ++i3) {
                ((f)arrayList2.get(i3)).d(this);
            }
        }
    }

    public abstract void g(s var1);

    void i(s s2) {
        if (this.L != null) {
            if (s2.a.isEmpty()) {
                return;
            }
            throw null;
        }
    }

    public abstract void j(s var1);

    void k(ViewGroup viewGroup, boolean bl) {
        ArrayList<Class<?>> arrayList;
        b.e.a<String, String> a2;
        ArrayList<String> arrayList2;
        this.l(bl);
        if (this.m.size() <= 0 && this.n.size() <= 0 || (arrayList2 = this.o) != null && !arrayList2.isEmpty() || (arrayList = this.p) != null && !arrayList.isEmpty()) {
            this.h((View)viewGroup, bl);
        } else {
            for (int i2 = 0; i2 < this.m.size(); ++i2) {
                View view = viewGroup.findViewById(((Integer)this.m.get(i2)).intValue());
                if (view == null) continue;
                s s2 = new s(view);
                if (bl) {
                    this.j(s2);
                } else {
                    this.g(s2);
                }
                s2.c.add((Object)this);
                this.i(s2);
                if (bl) {
                    m.d(this.x, view, s2);
                    continue;
                }
                m.d(this.y, view, s2);
            }
            for (int i3 = 0; i3 < this.n.size(); ++i3) {
                View view = (View)this.n.get(i3);
                s s3 = new s(view);
                if (bl) {
                    this.j(s3);
                } else {
                    this.g(s3);
                }
                s3.c.add((Object)this);
                this.i(s3);
                if (bl) {
                    m.d(this.x, view, s3);
                    continue;
                }
                m.d(this.y, view, s3);
            }
        }
        if (!bl && (a2 = this.N) != null) {
            int n2 = a2.size();
            ArrayList arrayList3 = new ArrayList(n2);
            int n3 = 0;
            do {
                if (n3 >= n2) break;
                String string = (String)this.N.j(n3);
                arrayList3.add(this.x.d.remove(string));
                ++n3;
            } while (true);
            for (int i4 = 0; i4 < n2; ++i4) {
                View view = (View)arrayList3.get(i4);
                if (view == null) continue;
                String string = (String)this.N.n(i4);
                this.x.d.put(string, view);
            }
        }
    }

    void l(boolean bl) {
        if (bl) {
            this.x.a.clear();
            this.x.b.clear();
            this.x.c.b();
            return;
        }
        this.y.a.clear();
        this.y.b.clear();
        this.y.c.b();
    }

    public m m() {
        try {
            m m2 = (m)super.clone();
            m2.K = new ArrayList();
            m2.x = new t();
            m2.y = new t();
            m2.B = null;
            m2.C = null;
            return m2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public Animator n(ViewGroup viewGroup, s s2, s s3) {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void o(ViewGroup viewGroup, t t2, t t3, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        b.e.a<Animator, d> a2 = m.x();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int n2 = arrayList.size();
        int n3 = 0;
        do {
            int n4;
            block15 : {
                s s2;
                View view;
                Animator animator;
                block17 : {
                    s s3;
                    View view2;
                    Animator animator2;
                    block9 : {
                        int n5;
                        Animator animator3;
                        block16 : {
                            block10 : {
                                Animator animator4;
                                s s4;
                                block12 : {
                                    block13 : {
                                        block14 : {
                                            block11 : {
                                                if (n3 >= n2) break block10;
                                                s4 = (s)arrayList.get(n3);
                                                s s5 = (s)arrayList2.get(n3);
                                                if (s4 != null && !s4.c.contains((Object)this)) {
                                                    s4 = null;
                                                }
                                                if (s5 != null && !s5.c.contains((Object)this)) {
                                                    s5 = null;
                                                }
                                                if (s4 == null && s5 == null) break block11;
                                                boolean bl = s4 == null || s5 == null || this.F(s4, s5);
                                                if (!bl || (animator4 = this.n(viewGroup, s4, s5)) == null) break block11;
                                                if (s5 == null) break block12;
                                                view2 = s5.b;
                                                String[] arrstring = this.D();
                                                if (arrstring == null || arrstring.length <= 0) break block13;
                                                s3 = new s(view2);
                                                s s6 = (s)t3.a.get((Object)view2);
                                                if (s6 == null) break block14;
                                                for (int i2 = 0; i2 < arrstring.length; ++i2) {
                                                    Map<String, Object> map = s3.a;
                                                    Animator animator5 = animator4;
                                                    String string = arrstring[i2];
                                                    int n6 = n2;
                                                    Map<String, Object> map2 = s6.a;
                                                    s s7 = s6;
                                                    map.put((Object)string, map2.get((Object)arrstring[i2]));
                                                    animator4 = animator5;
                                                    n2 = n6;
                                                    s6 = s7;
                                                }
                                                break block14;
                                            }
                                            n4 = n2;
                                            break block15;
                                        }
                                        animator3 = animator4;
                                        n4 = n2;
                                        n5 = a2.size();
                                        break block16;
                                    }
                                    Animator animator6 = animator4;
                                    n4 = n2;
                                    animator2 = animator6;
                                    s3 = null;
                                    break block9;
                                }
                                Animator animator7 = animator4;
                                n4 = n2;
                                view = s4.b;
                                animator = animator7;
                                s2 = null;
                                break block17;
                            }
                            if (sparseIntArray.size() != 0) {
                                for (int i3 = 0; i3 < sparseIntArray.size(); ++i3) {
                                    int n7 = sparseIntArray.keyAt(i3);
                                    Animator animator8 = (Animator)this.K.get(n7);
                                    animator8.setStartDelay((long)sparseIntArray.valueAt(i3) - Long.MAX_VALUE + animator8.getStartDelay());
                                }
                            }
                            return;
                        }
                        for (int i4 = 0; i4 < n5; ++i4) {
                            d d2 = (d)a2.get((Object)((Animator)a2.j(i4)));
                            if (d2.c == null || d2.a != view2 || !d2.b.equals((Object)this.u()) || !d2.c.equals(s3)) continue;
                            animator2 = null;
                            break block9;
                        }
                        animator2 = animator3;
                    }
                    view = view2;
                    animator = animator2;
                    s2 = s3;
                }
                if (animator != null) {
                    if (this.L != null) {
                        throw null;
                    }
                    d d3 = new d(view, this.u(), this, c0.d((View)viewGroup), s2);
                    a2.put(animator, d3);
                    this.K.add((Object)animator);
                }
            }
            ++n3;
            n2 = n4;
        } while (true);
    }

    protected void p() {
        int n2;
        this.G = n2 = this.G - 1;
        if (n2 == 0) {
            ArrayList<f> arrayList = this.J;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList)this.J.clone();
                int n3 = arrayList2.size();
                for (int i2 = 0; i2 < n3; ++i2) {
                    ((f)arrayList2.get(i2)).c(this);
                }
            }
            for (int i3 = 0; i3 < this.x.c.l(); ++i3) {
                View view = this.x.c.m(i3);
                if (view == null) continue;
                w.B0((View)view, (boolean)false);
            }
            for (int i4 = 0; i4 < this.y.c.l(); ++i4) {
                View view = this.y.c.m(i4);
                if (view == null) continue;
                w.B0((View)view, (boolean)false);
            }
            this.I = true;
        }
    }

    public long q() {
        return this.k;
    }

    public e r() {
        return this.M;
    }

    public TimeInterpolator s() {
        return this.l;
    }

    s t(View view, boolean bl) {
        q q2 = this.z;
        if (q2 != null) {
            return q2.t(view, bl);
        }
        ArrayList<s> arrayList = bl ? this.B : this.C;
        if (arrayList == null) {
            return null;
        }
        int n2 = arrayList.size();
        int n3 = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            s s2 = (s)arrayList.get(i2);
            if (s2 == null) {
                return null;
            }
            if (s2.b != view) continue;
            n3 = i2;
            break;
        }
        s s3 = null;
        if (n3 >= 0) {
            ArrayList<s> arrayList2 = bl ? this.C : this.B;
            s3 = (s)arrayList2.get(n3);
        }
        return s3;
    }

    public String toString() {
        return this.b0("");
    }

    public String u() {
        return this.i;
    }

    public g v() {
        return this.O;
    }

    public p w() {
        return this.L;
    }

    public long y() {
        return this.j;
    }

    public List<Integer> z() {
        return this.m;
    }

    private static class d {
        View a;
        String b;
        s c;
        m0 d;
        m e;

        d(View view, String string, m m2, m0 m02, s s2) {
            this.a = view;
            this.b = string;
            this.c = s2;
            this.d = m02;
            this.e = m2;
        }
    }

    public static abstract class e {
    }

    public static interface f {
        public void a(m var1);

        public void b(m var1);

        public void c(m var1);

        public void d(m var1);

        public void e(m var1);
    }

}

