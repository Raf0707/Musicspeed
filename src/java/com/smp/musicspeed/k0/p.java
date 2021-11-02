/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.util.SparseBooleanArray
 *  android.util.TypedValue
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.TextView
 *  androidx.appcompat.app.e
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.p
 *  androidx.lifecycle.w
 *  androidx.lifecycle.x
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$i
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.f
 *  androidx.recyclerview.widget.f$c
 *  b.i.h.a
 *  c.a.a.b
 *  c.a.a.b$a
 *  com.smp.musicspeed.k0.d0
 *  com.smp.musicspeed.k0.h0.j
 *  com.smp.musicspeed.k0.h0.k
 *  com.smp.musicspeed.k0.p0.i
 *  com.smp.musicspeed.library.artistsongs.f
 *  com.smp.musicspeed.library.playlists.j
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.List
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.m
 */
package com.smp.musicspeed.k0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import c.a.a.b;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.smp.musicspeed.ads.AdsProvider;
import com.smp.musicspeed.ads.r;
import com.smp.musicspeed.ads.x;
import com.smp.musicspeed.c0;
import com.smp.musicspeed.k0.d0;
import com.smp.musicspeed.k0.f;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.h0.j;
import com.smp.musicspeed.k0.h0.k;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.n;
import com.smp.musicspeed.k0.p;
import com.smp.musicspeed.k0.p0.i;
import com.smp.musicspeed.k0.t;
import com.smp.musicspeed.k0.u;
import com.smp.musicspeed.utils.AppPrefs;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public abstract class p<MT extends com.smp.musicspeed.k0.m0.e, VH extends RecyclerView.c0, AT extends m<VH, MT>>
extends Fragment
implements u,
g0 {
    protected SparseBooleanArray f = new SparseBooleanArray();
    private e.b.g.b g;
    protected RecyclerView h;
    private TextView i;
    private Button j;
    protected com.smp.musicspeed.ads.m k;
    protected AT l;
    protected RecyclerView.o m;
    private boolean n;
    private int o = -1;
    AsyncTask<Void, Void, f.c> p;
    protected boolean q = true;

    private void B(View view, int n2) {
        if (view.isActivated()) {
            this.f.put(n2, false);
        } else {
            this.f.put(n2, true);
        }
        String string = this.x();
        if (string != null) {
            t.a((androidx.appcompat.app.e)this.requireActivity(), string, this.U(), this, this.w());
            this.l.notifyItemChanged(n2);
            return;
        }
        c.a.a.b.b.a();
    }

    private void C() {
        for (int i2 = 0; i2 < ((m)this.l).q().size(); ++i2) {
            this.f.put(i2, true);
        }
        t.a((androidx.appcompat.app.e)this.requireActivity(), this.x(), ((m)this.l).q().size(), this, this.w());
        this.l.notifyDataSetChanged();
    }

    private String H() {
        for (int i2 = 0; i2 < this.f.size(); ++i2) {
            if (!this.f.valueAt(i2)) continue;
            int n2 = this.T(this.f.keyAt(i2));
            return this.h0(this.m.D(n2));
        }
        return null;
    }

    private /* synthetic */ void M(Boolean bl) {
        Context context;
        if (bl.booleanValue() && !AppPrefs.k.D() && (context = this.getContext()) != null) {
            ((r)r.f.a(context)).c();
        }
    }

    private /* synthetic */ void O(Boolean bl) {
        com.smp.musicspeed.ads.m m2;
        if (bl.booleanValue() && (m2 = this.k) != null) {
            m2.clearAds();
        }
    }

    private /* synthetic */ void Q(Boolean bl) {
        com.smp.musicspeed.ads.m m2;
        if (bl.booleanValue() && (m2 = this.k) != null) {
            m2.clearAds();
        }
    }

    private int T(int n2) {
        com.smp.musicspeed.ads.m m2 = this.k;
        if (m2 == null) {
            return n2;
        }
        return m2.getAdjustedPosition(n2);
    }

    private List<MT> Z() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f.size(); ++i2) {
            SparseBooleanArray sparseBooleanArray = this.f;
            boolean bl = sparseBooleanArray.get(sparseBooleanArray.keyAt(i2));
            if (this.f.keyAt(i2) < 0 || this.f.keyAt(i2) > -1 + ((m)this.l).q().size() || !bl) continue;
            arrayList.add((Object)((com.smp.musicspeed.k0.m0.e)((m)this.l).q().get(this.f.keyAt(i2))));
        }
        return arrayList;
    }

    private void b0(List<MT> list) {
        AT AT = this.z();
        this.l = AT;
        if (list != null && this.q) {
            ((m)AT).s(list);
        }
        RecyclerView.i i2 = new RecyclerView.i(this){
            final /* synthetic */ p a;
            {
                this.a = p2;
            }

            public void onChanged() {
                super.onChanged();
                this.a.y();
            }
        };
        if (!AppPrefs.k.D() && this.J()) {
            com.smp.musicspeed.ads.m m2;
            boolean bl = !(this instanceof k) && !(this instanceof j);
            this.k = m2 = c0.a((Activity)this.requireActivity(), i2, this.l, false, this.o, bl);
            this.o = m2.y();
            return;
        }
        this.l.registerAdapterDataObserver(i2);
    }

    private void d0() {
        Button button = this.j;
        if (button == null) {
            return;
        }
        button.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ p f;
            {
                this.f = p2;
            }

            public void onClick(View view) {
                org.greenrobot.eventbus.c.d().m(new Object(){});
            }
        });
    }

    public static int f0(float f2, Context context) {
        return (int)TypedValue.applyDimension((int)2, (float)f2, (DisplayMetrics)context.getResources().getDisplayMetrics());
    }

    private String h0(View view) {
        if (view == null) {
            return null;
        }
        return ((TextView)view.findViewById(2131297235)).getText().toString();
    }

    static /* synthetic */ e.b.g.b t(p p2, e.b.g.b b2) {
        p2.g = b2;
        return b2;
    }

    static /* synthetic */ boolean u(p p2) {
        return p2.n;
    }

    static /* synthetic */ boolean v(p p2, boolean bl) {
        p2.n = bl;
        return bl;
    }

    private int w() {
        if (this instanceof com.smp.musicspeed.library.playlists.j) {
            return 2131558403;
        }
        if (this instanceof i) {
            return 2131558404;
        }
        return 2131558402;
    }

    private String x() {
        if (this.U() == 1) {
            return this.H();
        }
        return "";
    }

    public abstract RecyclerView.o A();

    protected AT D() {
        return this.l;
    }

    protected int F() {
        return 2131820809;
    }

    protected abstract g.b G();

    protected boolean J() {
        return false;
    }

    public abstract int K();

    public /* synthetic */ void N(Boolean bl) {
        this.M(bl);
    }

    public /* synthetic */ void P(Boolean bl) {
        this.O(bl);
    }

    public /* synthetic */ void R(Boolean bl) {
        this.Q(bl);
    }

    public g S() {
        return (g)g.a.a(this.getActivity().getApplicationContext());
    }

    public int U() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.f.size(); ++i2) {
            if (!this.f.valueAt(i2)) continue;
            ++n2;
        }
        return n2;
    }

    protected void V() {
    }

    protected void W() {
    }

    public void X() {
        if (this.g != null) {
            this.S().r(this.G());
        }
    }

    public void Y() {
        if (this.g != null) {
            this.S().x(this.G());
        }
    }

    @Override
    public int a(int n2) {
        com.smp.musicspeed.ads.m m2 = this.k;
        if (m2 == null) {
            return n2;
        }
        if (n2 < m2.getItemCount() && n2 >= 0) {
            return this.k.getOriginalPosition(n2);
        }
        return -1;
    }

    public void a0(int n2) {
        RecyclerView recyclerView = this.h;
        if (!(recyclerView instanceof FastScrollRecyclerView)) {
            return;
        }
        FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView)recyclerView;
        switch (n2) {
            default: {
                fastScrollRecyclerView.setPopupTextSize(p.f0(42.0f, this.requireContext()));
                return;
            }
            case 2131296371: 
            case 2131296372: 
        }
        fastScrollRecyclerView.setPopupTextSize(p.f0(32.0f, this.requireContext()));
    }

    protected List<MT> c0() {
        e.b.d<List<MT>> d2 = new e.b.d<List<MT>>(this){
            final /* synthetic */ p f;
            {
                this.f = p2;
            }

            public void a(List<MT> list) {
                this.f.V();
                this.f.g0(list);
            }

            public void b() {
            }

            public void c(e.b.g.b b2) {
                p.t(this.f, b2);
                if (p.u(this.f)) {
                    p.v(this.f, false);
                    this.f.S().x(this.f.G());
                }
            }

            public void d(java.lang.Throwable throwable) {
                if (!(throwable instanceof java.lang.Error)) {
                    if (!(throwable instanceof java.lang.SecurityException) && !(throwable instanceof java.lang.IllegalStateException)) {
                        if (!(throwable instanceof java.lang.RuntimeException)) {
                            return;
                        }
                        throw (java.lang.RuntimeException)throwable;
                    }
                    android.widget.Toast.makeText((Context)this.f.requireContext(), (int)2131821349, (int)0).show();
                    throwable.printStackTrace();
                    return;
                }
                throw (java.lang.Error)throwable;
            }
        };
        return this.S().E(this.G(), d2);
    }

    protected void e0() {
        this.h.setLayoutManager(this.m);
        AppPrefs appPrefs = AppPrefs.k;
        if (!appPrefs.D() && this.J()) {
            this.h.setAdapter((RecyclerView.g)this.k);
            AdsProvider.a.e().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new com.smp.musicspeed.k0.e(this));
            appPrefs.E().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new com.smp.musicspeed.k0.d(this));
            x.f.b().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new f(this));
        } else {
            this.h.setAdapter(this.l);
        }
        this.h.setHasFixedSize(true);
    }

    @SuppressLint(value={"StaticFieldLeak"})
    protected void g0(List<MT> list) {
        AsyncTask<Void, Void, f.c> asyncTask = this.p;
        if (asyncTask != null) {
            asyncTask.cancel(false);
        }
        this.p = new AsyncTask<Void, Void, f.c>(this, list){
            final /* synthetic */ List a;
            final /* synthetic */ p b;
            {
                this.b = p2;
                this.a = list;
            }

            protected /* varargs */ f.c a(Void ... arrvoid) {
                if (!this.a.equals(((m)this.b.D()).q())) {
                    return androidx.recyclerview.widget.f.a((androidx.recyclerview.widget.f$b)new com.smp.musicspeed.k0.a0(((m)this.b.D()).q(), (List<? extends Object>)this.a));
                }
                return null;
            }

            protected void b(f.c c2) {
                if (this.isCancelled()) {
                    return;
                }
                if (c2 != null) {
                    ((m)this.b.D()).s(this.a);
                    c2.e(this.b.D());
                    if (this.b.U() > 0) {
                        c.a.a.b.b.a();
                    }
                }
                this.b.y();
                this.b.W();
            }
        }.execute((Object[])new Void[0]);
    }

    @Override
    public void h(View view, int n2) {
        this.B(view, n2);
    }

    @Override
    public int j() {
        if (!(this instanceof d0) && !(this instanceof com.smp.musicspeed.library.artistsongs.f)) {
            return 2131297244;
        }
        return 2131297245;
    }

    @Override
    public void m(View view, int n2) {
        this.B(view, n2);
    }

    @Override
    public void o() {
        for (int i2 = 0; i2 < this.f.size(); ++i2) {
            int n2 = this.f.keyAt(i2);
            if (!this.q(n2)) continue;
            this.f.put(n2, false);
            this.l.notifyItemChanged(n2);
        }
        this.f.clear();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(this.K(), viewGroup, false);
        this.h = (RecyclerView)view.findViewById(2131297063);
        this.i = (TextView)view.findViewById(16908292);
        this.j = (Button)view.findViewById(2131297018);
        return view;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        e.b.g.b b2;
        AsyncTask<Void, Void, f.c> asyncTask;
        super.onDestroyView();
        com.smp.musicspeed.ads.m m2 = this.k;
        if (m2 != null) {
            m2.x();
            this.k = null;
        }
        if ((b2 = this.g) != null) {
            b2.a();
        }
        if ((asyncTask = this.p) != null) {
            asyncTask.cancel(false);
        }
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onPermissionEvent(n.a a2) {
        if (a2.a) {
            this.n = true;
            this.c0();
            return;
        }
        this.y();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        RecyclerView recyclerView = this.h;
        if (recyclerView != null && this.k != null) {
            int n2;
            int n3 = ((LinearLayoutManager)recyclerView.getLayoutManager()).W1();
            com.smp.musicspeed.ads.m m2 = this.k;
            if (m2 != null) {
                int n4;
                n2 = m2.getOriginalPosition(n3);
                if (n2 == -1 && (n4 = n3 + 1) < this.k.getItemCount()) {
                    n2 = this.k.getOriginalPosition(n4);
                }
            } else {
                n2 = -1;
            }
            if (n2 != -1) {
                n3 = n2;
            }
            bundle.putInt("adjustedPosition", n3);
            bundle.putInt("adFirstPosition", this.o);
        }
    }

    public void onStart() {
        super.onStart();
        org.greenrobot.eventbus.c.d().r((Object)this);
        this.Y();
    }

    public void onStop() {
        org.greenrobot.eventbus.c.d().v((Object)this);
        this.X();
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.m = this.A();
        List<MT> list = b.i.h.a.a((Context)this.getActivity(), (String)"android.permission.WRITE_EXTERNAL_STORAGE") == 0 ? this.c0() : null;
        if (bundle != null) {
            this.o = bundle.getInt("adFirstPosition", -1);
        }
        this.b0(list);
        this.e0();
        this.d0();
        this.registerForContextMenu((View)this.h);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            bundle.getInt("adjustedPosition", -1);
        }
    }

    @Override
    public boolean q(int n2) {
        return this.f.get(n2);
    }

    @Override
    public void r(int n2) {
        if (n2 != 2131296364) {
            f0.n(this.requireContext(), n2, this.Z(), true);
            c.a.a.b.b.a();
            return;
        }
        this.C();
    }

    protected void y() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(this.F());
            TextView textView2 = this.i;
            AT AT = this.l;
            int n2 = AT != null && AT.getItemCount() != 0 ? 8 : 0;
            textView2.setVisibility(n2);
            if (this.j == null) {
                return;
            }
            if (this.getActivity() == null) {
                return;
            }
            if (b.i.h.a.a((Context)this.getActivity(), (String)"android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                this.j.setVisibility(0);
                return;
            }
            this.j.setVisibility(8);
        }
    }

    protected abstract AT z();

}

