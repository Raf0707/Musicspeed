/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.v
 *  b.w.e$c
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package b.w;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.v;
import b.w.e;
import b.w.m;
import b.w.o;
import b.w.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressLint(value={"RestrictedApi"})
public class e
extends v {
    private static boolean C(m m2) {
        return !v.l(m2.z()) || !v.l(m2.A()) || !v.l(m2.B());
        {
        }
    }

    public void A(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q q2 = (q)object;
        if (q2 != null) {
            q2.C().clear();
            q2.C().addAll(arrayList2);
            this.q(q2, arrayList, arrayList2);
        }
    }

    public Object B(Object object) {
        if (object == null) {
            return null;
        }
        q q2 = new q();
        q2.e0((m)object);
        return q2;
    }

    public void a(Object object, View view) {
        if (object != null) {
            ((m)object).b(view);
        }
    }

    public void b(Object object, ArrayList<View> arrayList) {
        block4 : {
            m m2;
            int n2;
            block3 : {
                m2 = (m)object;
                if (m2 == null) {
                    return;
                }
                boolean bl = m2 instanceof q;
                if (!bl) break block3;
                q q2 = (q)m2;
                int n3 = q2.h0();
                for (n2 = 0; n2 < n3; ++n2) {
                    this.b(q2.g0(n2), arrayList);
                }
                break block4;
            }
            if (e.C(m2) || !v.l(m2.C())) break block4;
            int n4 = arrayList.size();
            while (n2 < n4) {
                m2.b((View)arrayList.get(n2));
                ++n2;
            }
        }
    }

    public void c(ViewGroup viewGroup, Object object) {
        o.a(viewGroup, (m)object);
    }

    public boolean e(Object object) {
        return object instanceof m;
    }

    public Object g(Object object) {
        if (object != null) {
            return ((m)object).m();
        }
        return null;
    }

    public Object m(Object object, Object object2, Object object3) {
        m m2 = (m)object;
        m m3 = (m)object2;
        m m4 = (m)object3;
        if (m2 != null && m3 != null) {
            m2 = new q().e0(m2).e0(m3).m0(1);
        } else if (m2 == null) {
            m2 = m3 != null ? m3 : null;
        }
        if (m4 != null) {
            q q2 = new q();
            if (m2 != null) {
                q2.e0(m2);
            }
            q2.e0(m4);
            return q2;
        }
        return m2;
    }

    public Object n(Object object, Object object2, Object object3) {
        q q2 = new q();
        if (object != null) {
            q2.e0((m)object);
        }
        if (object2 != null) {
            q2.e0((m)object2);
        }
        if (object3 != null) {
            q2.e0((m)object3);
        }
        return q2;
    }

    public void p(Object object, View view) {
        if (object != null) {
            ((m)object).Q(view);
        }
    }

    public void q(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        block6 : {
            List<View> list;
            int n2;
            m m2;
            int n3;
            block5 : {
                m2 = (m)object;
                boolean bl = m2 instanceof q;
                if (!bl) break block5;
                q q2 = (q)m2;
                int n4 = q2.h0();
                for (n2 = 0; n2 < n4; ++n2) {
                    this.q(q2.g0(n2), arrayList, arrayList2);
                }
                break block6;
            }
            if (e.C(m2) || (list = m2.C()).size() != arrayList.size() || !list.containsAll(arrayList)) break block6;
            if (arrayList2 == null) {
                n3 = 0;
                n2 = 0;
            } else {
                n3 = arrayList2.size();
            }
            while (n2 < n3) {
                m2.b((View)arrayList2.get(n2));
                ++n2;
            }
            for (int i2 = -1 + arrayList.size(); i2 >= 0; --i2) {
                m2.Q((View)arrayList.get(i2));
            }
        }
    }

    public void r(Object object, final View view, final ArrayList<View> arrayList) {
        ((m)object).a(new m.f(){

            @Override
            public void a(m m2) {
            }

            @Override
            public void b(m m2) {
            }

            @Override
            public void c(m m2) {
                m2.P(this);
                view.setVisibility(8);
                int n2 = arrayList.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ((View)arrayList.get(i2)).setVisibility(0);
                }
            }

            @Override
            public void d(m m2) {
            }

            @Override
            public void e(m m2) {
            }
        });
    }

    public void t(Object object, Object object2, ArrayList<View> arrayList, Object object3, ArrayList<View> arrayList2, Object object4, ArrayList<View> arrayList3) {
        m m2 = (m)object;
        c c2 = new c(this, object2, arrayList, object3, arrayList2, object4, arrayList3);
        m2.a((m.f)c2);
    }

    public void u(Object object, final Rect rect) {
        if (object != null) {
            ((m)object).V(new m.e(){});
        }
    }

    public void v(Object object, View view) {
        if (view != null) {
            m m2 = (m)object;
            final Rect rect = new Rect();
            this.k(view, rect);
            m2.V(new m.e(){});
        }
    }

    public void z(Object object, View view, ArrayList<View> arrayList) {
        q q2 = (q)object;
        List<View> list = q2.C();
        list.clear();
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            v.d(list, (View)((View)arrayList.get(i2)));
        }
        list.add((Object)view);
        arrayList.add((Object)view);
        this.b(q2, arrayList);
    }

}

