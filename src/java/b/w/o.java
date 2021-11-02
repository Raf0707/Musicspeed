/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  b.i.q.w
 *  b.w.b
 *  b.w.o$a$a
 *  java.lang.Object
 *  java.lang.ThreadLocal
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 */
package b.w;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import b.i.q.w;
import b.w.b;
import b.w.l;
import b.w.m;
import b.w.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class o {
    private static m a = new b();
    private static ThreadLocal<WeakReference<b.e.a<ViewGroup, ArrayList<m>>>> b = new ThreadLocal();
    static ArrayList<ViewGroup> c = new ArrayList();

    public static void a(ViewGroup viewGroup, m m2) {
        if (!c.contains((Object)viewGroup) && w.W((View)viewGroup)) {
            c.add((Object)viewGroup);
            if (m2 == null) {
                m2 = a;
            }
            m m3 = m2.m();
            o.d(viewGroup, m3);
            l.c(viewGroup, null);
            o.c(viewGroup, m3);
        }
    }

    static b.e.a<ViewGroup, ArrayList<m>> b() {
        b.e.a a2;
        WeakReference weakReference = (WeakReference)b.get();
        if (weakReference != null && (a2 = (b.e.a)weakReference.get()) != null) {
            return a2;
        }
        b.e.a<ViewGroup, ArrayList<m>> a3 = new b.e.a<ViewGroup, ArrayList<m>>();
        WeakReference weakReference2 = new WeakReference(a3);
        b.set((Object)weakReference2);
        return a3;
    }

    private static void c(ViewGroup viewGroup, m m2) {
        if (m2 != null && viewGroup != null) {
            a a2 = new a(m2, viewGroup);
            viewGroup.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)a2);
            viewGroup.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)a2);
        }
    }

    private static void d(ViewGroup viewGroup, m m2) {
        l l2;
        ArrayList arrayList = (ArrayList)o.b().get((Object)viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                ((m)iterator.next()).N((View)viewGroup);
            }
        }
        if (m2 != null) {
            m2.k(viewGroup, true);
        }
        if ((l2 = l.b(viewGroup)) != null) {
            l2.a();
        }
    }

    private static class b.w.o$a
    implements ViewTreeObserver.OnPreDrawListener,
    View.OnAttachStateChangeListener {
        m f;
        ViewGroup g;

        b.w.o$a(m m2, ViewGroup viewGroup) {
            this.f = m2;
            this.g = viewGroup;
        }

        private void a() {
            this.g.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
            this.g.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        }

        public boolean onPreDraw() {
            ArrayList arrayList;
            this.a();
            if (!o.c.remove((Object)this.g)) {
                return true;
            }
            b.e.a<ViewGroup, ArrayList<m>> a2 = o.b();
            ArrayList arrayList2 = (ArrayList)a2.get((Object)this.g);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                a2.put(this.g, (ArrayList<m>)arrayList2);
                arrayList = null;
            } else {
                int n2 = arrayList2.size();
                arrayList = null;
                if (n2 > 0) {
                    arrayList = new ArrayList((Collection)arrayList2);
                }
            }
            arrayList2.add((Object)this.f);
            this.f.a((m.f)new a(this, a2));
            this.f.k(this.g, false);
            if (arrayList != null) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    ((m)iterator.next()).R((View)this.g);
                }
            }
            this.f.O(this.g);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.a();
            o.c.remove((Object)this.g);
            ArrayList arrayList = (ArrayList)o.b().get((Object)this.g);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    ((m)iterator.next()).R((View)this.g);
                }
            }
            this.f.l(true);
        }
    }

}

