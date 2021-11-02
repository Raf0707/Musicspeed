/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.ViewGroup
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  android.widget.TextView
 *  androidx.appcompat.widget.SearchView
 *  androidx.appcompat.widget.SearchView$l
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.Toolbar$f
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$i
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.RecyclerView$t
 *  b.i.h.a
 *  com.bumptech.glide.c
 *  com.bumptech.glide.j
 *  com.bumptech.glide.k
 *  com.bumptech.glide.l
 *  com.bumptech.glide.load.g
 *  com.bumptech.glide.load.o.j
 *  com.bumptech.glide.load.q.f.c
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.j.j
 *  com.bumptech.glide.s.d
 *  f.g0.k
 *  f.u.l
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.k0.q0;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.d0;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.folders.u;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.q0.l;
import com.smp.musicspeed.k0.q0.m;
import com.smp.musicspeed.k0.q0.n;
import com.smp.musicspeed.k0.q0.o;
import com.smp.musicspeed.k0.q0.p;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.library.album.Album;
import e.a.a.a.b;
import f.z.d.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class p
extends Fragment {
    private e.b.g.b f;
    private final g.b g = g.b.o;
    private final int h = 2131821290;
    private final f.f i = f.g.a(new f.z.c.a<com.smp.musicspeed.k0.m0.g>(){

        public final com.smp.musicspeed.k0.m0.g a() {
            g.a a2 = com.smp.musicspeed.k0.m0.g.a;
            Context context = this.requireActivity().getApplicationContext();
            f.z.d.k.f((Object)context, "requireActivity().applicationContext");
            return (com.smp.musicspeed.k0.m0.g)a2.a(context);
        }
    });
    private final e j;
    private final a k;
    private final b l;
    private final c m;
    private final d<?>[] n;
    private e.a.a.a.c o;
    private final SearchView.l p;

    public p() {
        b b2;
        c c2;
        a a2;
        e e2;
        e.a.a.a.b b3 = this.x(2131492999, 2131492987);
        f.z.d.k.f(b3, "buildSection(R.layout.list_item_library, R.layout.header_song)");
        this.j = e2 = new e(b3);
        e.a.a.a.b b4 = this.x(2131492999, 2131492983);
        f.z.d.k.f(b4, "buildSection(R.layout.list_item_library, R.layout.header_album)");
        this.k = a2 = new a(b4);
        e.a.a.a.b b5 = this.x(2131492999, 2131492984);
        f.z.d.k.f(b5, "buildSection(R.layout.list_item_library, R.layout.header_artist)");
        this.l = b2 = new b(b5);
        e.a.a.a.b b6 = this.x(2131492999, 2131492985);
        f.z.d.k.f(b6, "buildSection(R.layout.list_item_library, R.layout.header_other)");
        this.m = c2 = new c(b6);
        this.n = new d[]{e2, a2, b2, c2};
        this.p = new SearchView.l(this){
            final /* synthetic */ p a;
            {
                this.a = p2;
            }

            public boolean a(String string) {
                f.z.d.k.g(string, "newText");
                p.v(this.a, string);
                return false;
            }

            public boolean b(String string) {
                f.z.d.k.g(string, "query");
                com.smp.musicspeed.utils.t.u((android.app.Activity)this.a.requireActivity());
                return false;
            }
        };
    }

    private final void A() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.n0);
        Toolbar toolbar = (Toolbar)view2;
        toolbar.setNavigationOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.q0.h(this));
        toolbar.x(2131558428);
        toolbar.setOnMenuItemClickListener((Toolbar.f)com.smp.musicspeed.k0.q0.g.a);
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.n0);
        MenuItem menuItem = ((Toolbar)view4).getMenu().findItem(2131297087);
        menuItem.expandActionView();
        menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener(this){
            final /* synthetic */ p a;
            {
                this.a = p2;
            }

            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                f.z.d.k.g((Object)menuItem, "item");
                this.a.requireActivity().onBackPressed();
                return false;
            }

            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                f.z.d.k.g((Object)menuItem, "item");
                return true;
            }
        });
        View view5 = menuItem.getActionView();
        Objects.requireNonNull((Object)view5, (String)"null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
        SearchView searchView = (SearchView)view5;
        searchView.setQueryHint((CharSequence)this.requireContext().getString(2131821288));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(this.H());
        searchView.setOnQueryTextFocusChangeListener((View.OnFocusChangeListener)new o(this));
    }

    private static final void B(p p2, View view) {
        f.z.d.k.g((Object)p2, "this$0");
        p2.requireActivity().onBackPressed();
    }

    private static final boolean C(MenuItem menuItem) {
        return false;
    }

    private static final void D(p p2, View view, boolean bl) {
        f.z.d.k.g((Object)p2, "this$0");
        if (bl) {
            View view2 = view.findFocus();
            f.z.d.k.f((Object)view2, "view.findFocus()");
            p2.T(view2);
        }
    }

    private final com.smp.musicspeed.k0.m0.g G() {
        return (com.smp.musicspeed.k0.m0.g)this.i.getValue();
    }

    public static /* synthetic */ boolean J(MenuItem menuItem) {
        return p.C(menuItem);
    }

    public static /* synthetic */ void K(p p2, View view) {
        p.B(p2, view);
    }

    public static /* synthetic */ void M(p p2, View view, boolean bl) {
        p.D(p2, view, bl);
    }

    private final void P(String string) {
        Objects.requireNonNull((Object)string, (String)"null cannot be cast to non-null type kotlin.CharSequence");
        if (!f.z.d.k.c(f.g0.k.b0((CharSequence)string).toString(), this.G().g())) {
            View view = this.getView();
            View view2 = view == null ? null : view.findViewById(d0.g0);
            ((RecyclerView)view2).q1(0);
        }
        this.G().C(f.g0.k.b0((CharSequence)string).toString());
    }

    private final void Q() {
        e.a.a.a.c c2;
        this.o = c2 = this.F();
        if (c2 != null) {
            c2.registerAdapterDataObserver(new RecyclerView.i(this){
                final /* synthetic */ p a;
                {
                    this.a = p2;
                }

                public void onChanged() {
                    super.onChanged();
                    p.t(this.a);
                }
            });
            return;
        }
        f.z.d.k.s("adapter");
        throw null;
    }

    private final void R() {
        e.b.d<List<? extends com.smp.musicspeed.k0.m0.e>> d2 = new e.b.d<List<? extends com.smp.musicspeed.k0.m0.e>>(this){
            final /* synthetic */ p f;
            {
                this.f = p2;
            }

            public void a(List<? extends com.smp.musicspeed.k0.m0.e> list) {
                f.z.d.k.g(list, "items");
                this.f.U(list);
            }

            public void b() {
            }

            public void c(e.b.g.b b2) {
                f.z.d.k.g(b2, "d");
                p.w(this.f, b2);
            }

            public void d(java.lang.Throwable throwable) {
                f.z.d.k.g((Object)throwable, "e");
                if (!(throwable instanceof java.lang.Error)) {
                    if (!(throwable instanceof java.lang.SecurityException) && !(throwable instanceof java.lang.IllegalStateException)) {
                        if (!(throwable instanceof java.lang.RuntimeException)) {
                            return;
                        }
                        throw throwable;
                    }
                    android.widget.Toast.makeText((Context)this.f.requireContext(), (int)2131821349, (int)0).show();
                    throwable.printStackTrace();
                    return;
                }
                throw throwable;
            }
        };
        this.G().E(this.g, d2);
    }

    private final void T(View view) {
        androidx.fragment.app.d d2 = this.getActivity();
        Object object = d2 == null ? null : d2.getSystemService("input_method");
        InputMethodManager inputMethodManager = (InputMethodManager)object;
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.showSoftInput(view, 0);
    }

    public static final /* synthetic */ void t(p p2) {
        p2.y();
    }

    public static final /* synthetic */ void v(p p2, String string) {
        p2.P(string);
    }

    public static final /* synthetic */ void w(p p2, e.b.g.b b2) {
        p2.f = b2;
    }

    private final e.a.a.a.b x(int n2, int n3) {
        return e.a.a.a.b.a().o(n2).n(n3).m();
    }

    private final void y() {
        this.z();
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.N);
        ((TextView)view2).setText(this.h);
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.O);
        LinearLayout linearLayout = (LinearLayout)view4;
        e.a.a.a.c c2 = this.o;
        if (c2 != null) {
            int n2 = c2.getItemCount() == 0 ? 0 : 8;
            linearLayout.setVisibility(n2);
            return;
        }
        f.z.d.k.s("adapter");
        throw null;
    }

    private final void z() {
        for (d<?> d2 : this.n) {
            boolean bl = d2.a() != 0;
            d2.L(bl);
        }
    }

    protected final e.a.a.a.c F() {
        e.a.a.a.c c2 = new e.a.a.a.c();
        d<?>[] arrd = this.n;
        int n2 = arrd.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            c2.o(arrd[i2]);
        }
        return c2;
    }

    public final SearchView.l H() {
        return this.p;
    }

    public final void N() {
        this.G().r(this.g);
    }

    public final void O() {
        this.G().x(this.g);
    }

    protected void S() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.g0);
        ((RecyclerView)view2).setLayoutManager((RecyclerView.o)new LinearLayoutManager((Context)this.requireActivity()));
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.g0);
        RecyclerView recyclerView = (RecyclerView)view4;
        e.a.a.a.c c2 = this.o;
        if (c2 != null) {
            recyclerView.setAdapter((RecyclerView.g)c2);
            View view5 = this.getView();
            View view6 = view5 == null ? null : view5.findViewById(d0.g0);
            ((RecyclerView)view6).o(new RecyclerView.t(this){
                final /* synthetic */ p a;
                {
                    this.a = p2;
                }

                public void a(RecyclerView recyclerView, int n2) {
                    f.z.d.k.g((Object)recyclerView, "recyclerView");
                    super.a(recyclerView, n2);
                    if (n2 == 1) {
                        com.smp.musicspeed.utils.t.u((android.app.Activity)this.a.requireActivity());
                    }
                }
            });
            return;
        }
        f.z.d.k.s("adapter");
        throw null;
    }

    protected final void U(List<? extends com.smp.musicspeed.k0.m0.e> list) {
        f.z.d.k.g(list, "items");
        e e2 = this.j;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        do {
            boolean bl = iterator.hasNext();
            boolean bl2 = true;
            if (!bl) break;
            Object object = iterator.next();
            com.smp.musicspeed.k0.m0.e e3 = (com.smp.musicspeed.k0.m0.e)object;
            if (!(e3 instanceof MediaTrack) || ((MediaTrack)e3).getMediaType() != I.a) {
                bl2 = false;
            }
            if (!bl2) continue;
            arrayList.add(object);
        } while (true);
        e2.N(arrayList);
        a a2 = this.k;
        ArrayList arrayList2 = new ArrayList();
        for (Object object : list) {
            if (!((com.smp.musicspeed.k0.m0.e)object instanceof Album)) continue;
            arrayList2.add(object);
        }
        a2.N(arrayList2);
        b b2 = this.l;
        ArrayList arrayList3 = new ArrayList();
        for (Object object : list) {
            if (!((com.smp.musicspeed.k0.m0.e)object instanceof com.smp.musicspeed.k0.i0.e)) continue;
            arrayList3.add(object);
        }
        b2.N(arrayList3);
        c c2 = this.m;
        ArrayList arrayList4 = new ArrayList();
        for (Object object : list) {
            com.smp.musicspeed.k0.m0.e e4 = (com.smp.musicspeed.k0.m0.e)object;
            boolean bl = e4 instanceof MediaTrack && ((MediaTrack)e4).getMediaType() != I.a;
            if (!bl) continue;
            arrayList4.add(object);
        }
        c2.N(arrayList4);
        e.a.a.a.c c3 = this.o;
        if (c3 != null) {
            c3.notifyDataSetChanged();
            this.y();
            return;
        }
        f.z.d.k.s("adapter");
        throw null;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.G().C("");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.z.d.k.g((Object)layoutInflater, "inflater");
        return layoutInflater.inflate(2131492976, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        e.b.g.b b2 = this.f;
        if (b2 != null) {
            b2.a();
            return;
        }
        f.z.d.k.s("observerDisposable");
        throw null;
    }

    public void onStart() {
        super.onStart();
        this.O();
    }

    public void onStop() {
        this.N();
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        f.z.d.k.g((Object)view, "view");
        super.onViewCreated(view, bundle);
        this.Q();
        this.S();
        this.R();
        this.A();
    }

    private final class com.smp.musicspeed.k0.q0.p$a
    extends d<Album> {
        public com.smp.musicspeed.k0.q0.p$a(e.a.a.a.b b2) {
            f.z.d.k.g((Object)p.this, "this$0");
            f.z.d.k.g(b2, "params");
            super(b2);
        }

        @Override
        public void J(RecyclerView.c0 c02, int n2) {
            f.z.d.k.g((Object)c02, "holder");
            if (c02 instanceof a) {
                Album album = (Album)this.M().get(n2);
                a a2 = c02;
                a2.c0().setText((CharSequence)album.m());
                a2.b0().setText((CharSequence)album.p());
                com.bumptech.glide.k k2 = com.bumptech.glide.c.u((Context)p.this.requireContext());
                Context context = p.this.requireContext();
                f.z.d.k.f((Object)context, "requireContext()");
                com.bumptech.glide.j j2 = (com.bumptech.glide.j)((com.bumptech.glide.j)k2.s((Object)new com.smp.musicspeed.playingqueue.i(context, album)).e(com.bumptech.glide.load.o.j.c)).X((com.bumptech.glide.load.g)new com.bumptech.glide.s.d((Object)album.q()));
                I i2 = album.getMediaType();
                Context context2 = p.this.requireContext();
                f.z.d.k.f((Object)context2, "requireContext()");
                com.bumptech.glide.j j3 = (com.bumptech.glide.j)j2.Q(i2.defaultResource(context2));
                I i3 = album.getMediaType();
                Context context3 = p.this.requireContext();
                f.z.d.k.f((Object)context3, "requireContext()");
                ((com.bumptech.glide.j)j3.g(i3.defaultResource(context3))).A0((com.bumptech.glide.l)com.bumptech.glide.load.q.f.c.h()).q0(a2.Z());
            }
        }

        @Override
        public RecyclerView.c0 p(View view) {
            f.z.d.k.g((Object)view, "view");
            d<Album> d2 = new d<Album>(view){
                {
                    f.z.d.k.g(a.this, "this$0");
                    f.z.d.k.g((Object)view, "v");
                    super(view);
                    view.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.q0.a(p.this, this, a.this));
                    this.h0();
                }

                private static final void d0(p p2, a a2, com.smp.musicspeed.k0.q0.p$a a3, View view) {
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(a3, "this$2");
                    e.a.a.a.c c2 = p2.o;
                    if (c2 != null) {
                        int n2 = c2.getItemCount();
                        int n3 = a2.getAdapterPosition();
                        boolean bl = false;
                        if (n3 >= 0) {
                            bl = false;
                            if (n3 < n2) {
                                bl = true;
                            }
                        }
                        if (!bl) {
                            return;
                        }
                        e.a.a.a.c c3 = p2.o;
                        if (c3 != null) {
                            int n4 = c3.w(a2.getAdapterPosition());
                            Album album = (Album)a3.M().get(n4);
                            org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.k0.l0.a(album));
                            return;
                        }
                        f.z.d.k.s("adapter");
                        throw null;
                    }
                    f.z.d.k.s("adapter");
                    throw null;
                }

                public static /* synthetic */ void e0(p p2, a a2, com.smp.musicspeed.k0.q0.p$a a3, View view) {
                    a.d0(p2, a2, a3, view);
                }

                public static /* synthetic */ boolean f0(p p2, a a2, com.smp.musicspeed.k0.q0.p$a a3, MenuItem menuItem) {
                    return a.j0(p2, a2, a3, menuItem);
                }

                public static /* synthetic */ void g0(x x2, p p2, a a2, com.smp.musicspeed.k0.q0.p$a a3, View view) {
                    a.i0(x2, p2, a2, a3, view);
                }

                private final void h0() {
                    x x2 = new x();
                    ImageButton imageButton = this.a0();
                    com.smp.musicspeed.k0.q0.p$a a2 = a.this;
                    imageButton.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.q0.c(x2, a2.p.this, this, a2));
                }

                private static final void i0(x x2, p p2, a a2, com.smp.musicspeed.k0.q0.p$a a3, View view) {
                    f.z.d.k.g(x2, "$lastClick");
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(a3, "this$2");
                    if (SystemClock.elapsedRealtime() - 1000L < x2.f) {
                        return;
                    }
                    x2.f = SystemClock.elapsedRealtime();
                    org.greenrobot.eventbus.c.d().m((Object)new c0());
                    PopupMenu popupMenu = new PopupMenu(p2.getContext(), (View)a2.a0());
                    popupMenu.inflate(2131558407);
                    popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new com.smp.musicspeed.k0.q0.b(p2, a2, a3));
                    popupMenu.show();
                }

                private static final boolean j0(p p2, a a2, com.smp.musicspeed.k0.q0.p$a a3, MenuItem menuItem) {
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(a3, "this$2");
                    e.a.a.a.c c2 = p2.o;
                    if (c2 != null) {
                        int n2 = c2.getItemCount();
                        int n3 = a2.getAdapterPosition();
                        boolean bl = false;
                        if (n3 >= 0) {
                            bl = false;
                            if (n3 < n2) {
                                bl = true;
                            }
                        }
                        if (!bl) {
                            return true;
                        }
                        e.a.a.a.c c3 = p2.o;
                        if (c3 != null) {
                            int n4 = c3.w(a2.getAdapterPosition());
                            List list = f.u.l.b((Object)a3.M().get(n4));
                            Context context = p2.requireContext();
                            f.z.d.k.f((Object)context, "requireContext()");
                            f0.o(context, menuItem.getItemId(), list, false, 8, null);
                            return true;
                        }
                        f.z.d.k.s("adapter");
                        throw null;
                    }
                    f.z.d.k.s("adapter");
                    throw null;
                }
            };
            view.findViewById(2131297191).setVisibility(0);
            return d2;
        }

    }

    private final class b
    extends d<com.smp.musicspeed.k0.i0.e> {
        public b(e.a.a.a.b b2) {
            f.z.d.k.g((Object)p.this, "this$0");
            f.z.d.k.g(b2, "params");
            super(b2);
        }

        @Override
        public void J(RecyclerView.c0 c02, int n2) {
            f.z.d.k.g((Object)c02, "holder");
            if (c02 instanceof a) {
                com.smp.musicspeed.k0.i0.e e2 = (com.smp.musicspeed.k0.i0.e)this.M().get(n2);
                long l2 = e2.c();
                String string = p.this.requireContext().getString(2131821043);
                f.z.d.k.f(string, "requireContext().getString(R.string.library_tab_albums)");
                String string2 = p.this.requireContext().getString(2131820806);
                f.z.d.k.f(string2, "requireContext().getString(R.string.dot)");
                long l3 = e2.d();
                String string3 = p.this.requireContext().getString(2131821047);
                f.z.d.k.f(string3, "requireContext().getString(R.string.library_tab_songs)");
                a a2 = c02;
                a2.c0().setText((CharSequence)e2.b());
                TextView textView = a2.b0();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(l2);
                stringBuilder.append(' ');
                stringBuilder.append(string);
                stringBuilder.append(' ');
                stringBuilder.append(string2);
                stringBuilder.append(' ');
                stringBuilder.append(l3);
                stringBuilder.append(' ');
                stringBuilder.append(string3);
                textView.setText((CharSequence)stringBuilder.toString());
                com.bumptech.glide.k k2 = com.bumptech.glide.c.u((Context)p.this.requireContext());
                Context context = p.this.requireContext();
                f.z.d.k.f((Object)context, "requireContext()");
                com.bumptech.glide.j j2 = k2.s((Object)new com.smp.musicspeed.playingqueue.i(context, e2));
                I i2 = e2.getMediaType();
                Context context2 = p.this.requireContext();
                f.z.d.k.f((Object)context2, "requireContext()");
                com.bumptech.glide.j j3 = (com.bumptech.glide.j)j2.Q(i2.defaultResource(context2));
                I i3 = e2.getMediaType();
                Context context3 = p.this.requireContext();
                f.z.d.k.f((Object)context3, "requireContext()");
                ((com.bumptech.glide.j)j3.g(i3.defaultResource(context3))).A0((com.bumptech.glide.l)com.bumptech.glide.load.q.f.c.h()).q0(a2.Z());
            }
        }

        @Override
        public RecyclerView.c0 p(View view) {
            f.z.d.k.g((Object)view, "view");
            d<com.smp.musicspeed.k0.i0.e> d2 = new d<com.smp.musicspeed.k0.i0.e>(view){
                {
                    f.z.d.k.g(b.this, "this$0");
                    f.z.d.k.g((Object)view, "v");
                    super(view);
                    view.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.q0.d(p.this, this, b.this));
                    this.h0();
                }

                private static final void d0(p p2, a a2, b b2, View view) {
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(b2, "this$2");
                    e.a.a.a.c c2 = p2.o;
                    if (c2 != null) {
                        int n2 = c2.getItemCount();
                        int n3 = a2.getAdapterPosition();
                        boolean bl = false;
                        if (n3 >= 0) {
                            bl = false;
                            if (n3 < n2) {
                                bl = true;
                            }
                        }
                        if (!bl) {
                            return;
                        }
                        e.a.a.a.c c3 = p2.o;
                        if (c3 != null) {
                            int n4 = c3.w(a2.getAdapterPosition());
                            com.smp.musicspeed.k0.i0.e e2 = (com.smp.musicspeed.k0.i0.e)b2.M().get(n4);
                            org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.k0.l0.b(e2));
                            return;
                        }
                        f.z.d.k.s("adapter");
                        throw null;
                    }
                    f.z.d.k.s("adapter");
                    throw null;
                }

                public static /* synthetic */ void e0(p p2, a a2, b b2, View view) {
                    a.d0(p2, a2, b2, view);
                }

                public static /* synthetic */ void f0(x x2, b b2, a a2, p p2, View view) {
                    a.i0(x2, b2, a2, p2, view);
                }

                public static /* synthetic */ boolean g0(p p2, a a2, b b2, MenuItem menuItem) {
                    return a.j0(p2, a2, b2, menuItem);
                }

                private final void h0() {
                    x x2 = new x();
                    ImageButton imageButton = this.a0();
                    b b2 = b.this;
                    imageButton.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.q0.e(x2, b2, this, b2.p.this));
                }

                private static final void i0(x x2, b b2, a a2, p p2, View view) {
                    f.z.d.k.g(x2, "$lastClick");
                    f.z.d.k.g(b2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g((Object)p2, "this$2");
                    if (SystemClock.elapsedRealtime() - 1000L < x2.f) {
                        return;
                    }
                    x2.f = SystemClock.elapsedRealtime();
                    int n2 = b2.M().size();
                    int n3 = a2.getAdapterPosition();
                    boolean bl = false;
                    if (n3 >= 0) {
                        bl = false;
                        if (n3 < n2) {
                            bl = true;
                        }
                    }
                    if (!bl) {
                        return;
                    }
                    org.greenrobot.eventbus.c.d().m((Object)new c0());
                    PopupMenu popupMenu = new PopupMenu(p2.getContext(), (View)a2.a0());
                    popupMenu.inflate(2131558409);
                    popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new com.smp.musicspeed.k0.q0.f(p2, a2, b2));
                    popupMenu.show();
                }

                private static final boolean j0(p p2, a a2, b b2, MenuItem menuItem) {
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(b2, "this$2");
                    e.a.a.a.c c2 = p2.o;
                    if (c2 != null) {
                        int n2 = c2.getItemCount();
                        int n3 = a2.getAdapterPosition();
                        boolean bl = false;
                        if (n3 >= 0) {
                            bl = false;
                            if (n3 < n2) {
                                bl = true;
                            }
                        }
                        if (!bl) {
                            return true;
                        }
                        e.a.a.a.c c3 = p2.o;
                        if (c3 != null) {
                            int n4 = c3.w(a2.getAdapterPosition());
                            List list = f.u.l.b((Object)b2.M().get(n4));
                            Context context = p2.requireContext();
                            f.z.d.k.f((Object)context, "requireContext()");
                            f0.o(context, menuItem.getItemId(), list, false, 8, null);
                            return true;
                        }
                        f.z.d.k.s("adapter");
                        throw null;
                    }
                    f.z.d.k.s("adapter");
                    throw null;
                }
            };
            view.findViewById(2131297191).setVisibility(0);
            return d2;
        }

    }

    private final class c
    extends d<MediaTrack> {
        public c(e.a.a.a.b b2) {
            f.z.d.k.g((Object)p.this, "this$0");
            f.z.d.k.g(b2, "params");
            super(b2);
        }

        @Override
        public void J(RecyclerView.c0 c02, int n2) {
            f.z.d.k.g((Object)c02, "holder");
            if (c02 instanceof a) {
                MediaTrack mediaTrack = (MediaTrack)this.M().get(n2);
                a a2 = c02;
                a2.c0().setText((CharSequence)mediaTrack.getTrackName());
                a2.b0().setText((CharSequence)mediaTrack.getArtistName());
                com.bumptech.glide.k k2 = com.bumptech.glide.c.u((Context)p.this.requireContext());
                Context context = p.this.requireContext();
                f.z.d.k.f((Object)context, "requireContext()");
                com.bumptech.glide.j j2 = (com.bumptech.glide.j)((com.bumptech.glide.j)k2.s((Object)new com.smp.musicspeed.playingqueue.i(context, mediaTrack)).R((Drawable)new ColorDrawable(b.i.h.a.c((Context)p.this.requireContext(), (int)17170445)))).X((com.bumptech.glide.load.g)new com.bumptech.glide.s.d((Object)mediaTrack.getDateModified()));
                I i2 = mediaTrack.getMediaType();
                Context context2 = p.this.requireContext();
                f.z.d.k.f((Object)context2, "requireContext()");
                ((com.bumptech.glide.j)j2.g(i2.defaultResource(context2))).A0((com.bumptech.glide.l)com.bumptech.glide.load.q.f.c.h()).q0(a2.Z());
            }
        }

        @Override
        public RecyclerView.c0 p(View view) {
            f.z.d.k.g((Object)view, "view");
            d<MediaTrack> d2 = new d<MediaTrack>(view){
                {
                    f.z.d.k.g(c.this, "this$0");
                    f.z.d.k.g((Object)view, "v");
                    super(view);
                    view.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.q0.j(p.this, this, c.this));
                    this.h0();
                }

                private static final void d0(p p2, a a2, c c2, View view) {
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(c2, "this$2");
                    e.a.a.a.c c3 = p2.o;
                    if (c3 != null) {
                        int n2 = c3.getItemCount();
                        int n3 = a2.getAdapterPosition();
                        boolean bl = false;
                        if (n3 >= 0) {
                            bl = false;
                            if (n3 < n2) {
                                bl = true;
                            }
                        }
                        if (!bl) {
                            return;
                        }
                        e.a.a.a.c c4 = p2.o;
                        if (c4 != null) {
                            int n4 = c4.w(a2.getAdapterPosition());
                            org.greenrobot.eventbus.c c5 = org.greenrobot.eventbus.c.d();
                            com.smp.musicspeed.k0.l0.h h2 = new com.smp.musicspeed.k0.l0.h(f.u.l.b((Object)c2.M().get(n4)), 0, false, false, 12, null);
                            c5.m((Object)h2);
                            return;
                        }
                        f.z.d.k.s("adapter");
                        throw null;
                    }
                    f.z.d.k.s("adapter");
                    throw null;
                }

                public static /* synthetic */ void e0(x x2, p p2, a a2, c c2, View view) {
                    a.i0(x2, p2, a2, c2, view);
                }

                public static /* synthetic */ void f0(p p2, a a2, c c2, View view) {
                    a.d0(p2, a2, c2, view);
                }

                public static /* synthetic */ boolean g0(p p2, a a2, c c2, MenuItem menuItem) {
                    return a.j0(p2, a2, c2, menuItem);
                }

                private final void h0() {
                    x x2 = new x();
                    ImageButton imageButton = this.a0();
                    c c2 = c.this;
                    imageButton.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.q0.i(x2, c2.p.this, this, c2));
                }

                private static final void i0(x x2, p p2, a a2, c c2, View view) {
                    f.z.d.k.g(x2, "$lastClick");
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(c2, "this$2");
                    if (SystemClock.elapsedRealtime() - 1000L < x2.f) {
                        return;
                    }
                    x2.f = SystemClock.elapsedRealtime();
                    org.greenrobot.eventbus.c.d().m((Object)new c0());
                    PopupMenu popupMenu = new PopupMenu(p2.getContext(), (View)a2.a0());
                    e.a.a.a.c c3 = p2.o;
                    if (c3 != null) {
                        int n2 = c3.getItemCount();
                        int n3 = a2.getAdapterPosition();
                        boolean bl = n3 >= 0 && n3 < n2;
                        if (!bl) {
                            return;
                        }
                        e.a.a.a.c c4 = p2.o;
                        if (c4 != null) {
                            int n4 = c4.w(a2.getAdapterPosition());
                            MediaTrack mediaTrack = (MediaTrack)c2.M().get(n4);
                            popupMenu.inflate(2131558414);
                            if (!com.smp.musicspeed.tag_editor.m.c(new File(mediaTrack.getLocation()))) {
                                popupMenu.getMenu().findItem(2131296376).setEnabled(false);
                            }
                            if (!u.d(new File(mediaTrack.getLocation())) && !z.b()) {
                                popupMenu.getMenu().findItem(2131296333).setEnabled(false);
                            }
                            popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new com.smp.musicspeed.k0.q0.k(p2, a2, c2));
                            popupMenu.show();
                            return;
                        }
                        f.z.d.k.s("adapter");
                        throw null;
                    }
                    f.z.d.k.s("adapter");
                    throw null;
                }

                private static final boolean j0(p p2, a a2, c c2, MenuItem menuItem) {
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(c2, "this$2");
                    e.a.a.a.c c3 = p2.o;
                    if (c3 != null) {
                        int n2 = c3.getItemCount();
                        int n3 = a2.getAdapterPosition();
                        boolean bl = false;
                        if (n3 >= 0) {
                            bl = false;
                            if (n3 < n2) {
                                bl = true;
                            }
                        }
                        if (!bl) {
                            return true;
                        }
                        e.a.a.a.c c4 = p2.o;
                        if (c4 != null) {
                            int n4 = c4.w(a2.getAdapterPosition());
                            List list = f.u.l.b((Object)c2.M().get(n4));
                            Context context = p2.requireContext();
                            f.z.d.k.f((Object)context, "requireContext()");
                            f0.o(context, menuItem.getItemId(), list, false, 8, null);
                            return true;
                        }
                        f.z.d.k.s("adapter");
                        throw null;
                    }
                    f.z.d.k.s("adapter");
                    throw null;
                }
            };
            view.findViewById(2131297191).setVisibility(0);
            return d2;
        }

    }

    private final class e
    extends d<MediaTrack> {
        public e(e.a.a.a.b b2) {
            f.z.d.k.g((Object)p.this, "this$0");
            f.z.d.k.g(b2, "params");
            super(b2);
        }

        @Override
        public void J(RecyclerView.c0 c02, int n2) {
            f.z.d.k.g((Object)c02, "holder");
            if (c02 instanceof a) {
                MediaTrack mediaTrack = (MediaTrack)this.M().get(n2);
                a a2 = c02;
                a2.c0().setText((CharSequence)mediaTrack.getTrackName());
                a2.b0().setText((CharSequence)mediaTrack.getArtistName());
                com.bumptech.glide.k k2 = com.bumptech.glide.c.u((Context)p.this.requireContext());
                Context context = p.this.requireContext();
                f.z.d.k.f((Object)context, "requireContext()");
                com.bumptech.glide.j j2 = (com.bumptech.glide.j)((com.bumptech.glide.j)k2.s((Object)new com.smp.musicspeed.playingqueue.i(context, mediaTrack)).R((Drawable)new ColorDrawable(b.i.h.a.c((Context)p.this.requireContext(), (int)17170445)))).X((com.bumptech.glide.load.g)new com.bumptech.glide.s.d((Object)mediaTrack.getDateModified()));
                I i2 = mediaTrack.getMediaType();
                Context context2 = p.this.requireContext();
                f.z.d.k.f((Object)context2, "requireContext()");
                ((com.bumptech.glide.j)j2.g(i2.defaultResource(context2))).A0((com.bumptech.glide.l)com.bumptech.glide.load.q.f.c.h()).q0(a2.Z());
            }
        }

        @Override
        public RecyclerView.c0 p(View view) {
            f.z.d.k.g((Object)view, "view");
            d<MediaTrack> d2 = new d<MediaTrack>(view){
                {
                    f.z.d.k.g(e.this, "this$0");
                    f.z.d.k.g((Object)view, "v");
                    super(view);
                    view.setOnClickListener((View.OnClickListener)new m(p.this, this, e.this));
                    this.h0();
                }

                private static final void d0(p p2, a a2, e e2, View view) {
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(e2, "this$2");
                    e.a.a.a.c c2 = p2.o;
                    if (c2 != null) {
                        int n2 = c2.getItemCount();
                        int n3 = a2.getAdapterPosition();
                        boolean bl = false;
                        if (n3 >= 0) {
                            bl = false;
                            if (n3 < n2) {
                                bl = true;
                            }
                        }
                        if (!bl) {
                            return;
                        }
                        e.a.a.a.c c3 = p2.o;
                        if (c3 != null) {
                            int n4 = c3.w(a2.getAdapterPosition());
                            org.greenrobot.eventbus.c c4 = org.greenrobot.eventbus.c.d();
                            com.smp.musicspeed.k0.l0.h h2 = new com.smp.musicspeed.k0.l0.h(f.u.l.b((Object)e2.M().get(n4)), 0, false, false, 12, null);
                            c4.m((Object)h2);
                            return;
                        }
                        f.z.d.k.s("adapter");
                        throw null;
                    }
                    f.z.d.k.s("adapter");
                    throw null;
                }

                public static /* synthetic */ boolean e0(p p2, a a2, e e2, MenuItem menuItem) {
                    return a.j0(p2, a2, e2, menuItem);
                }

                public static /* synthetic */ void f0(p p2, a a2, e e2, View view) {
                    a.d0(p2, a2, e2, view);
                }

                public static /* synthetic */ void g0(x x2, p p2, a a2, e e2, View view) {
                    a.i0(x2, p2, a2, e2, view);
                }

                private final void h0() {
                    x x2 = new x();
                    ImageButton imageButton = this.a0();
                    e e2 = e.this;
                    imageButton.setOnClickListener((View.OnClickListener)new n(x2, e2.p.this, this, e2));
                }

                private static final void i0(x x2, p p2, a a2, e e2, View view) {
                    f.z.d.k.g(x2, "$lastClick");
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(e2, "this$2");
                    if (SystemClock.elapsedRealtime() - 1000L < x2.f) {
                        return;
                    }
                    x2.f = SystemClock.elapsedRealtime();
                    org.greenrobot.eventbus.c.d().m((Object)new c0());
                    PopupMenu popupMenu = new PopupMenu(p2.getContext(), (View)a2.a0());
                    e.a.a.a.c c2 = p2.o;
                    if (c2 != null) {
                        int n2 = c2.getItemCount();
                        int n3 = a2.getAdapterPosition();
                        boolean bl = n3 >= 0 && n3 < n2;
                        if (!bl) {
                            return;
                        }
                        e.a.a.a.c c3 = p2.o;
                        if (c3 != null) {
                            int n4 = c3.w(a2.getAdapterPosition());
                            MediaTrack mediaTrack = (MediaTrack)e2.M().get(n4);
                            popupMenu.inflate(2131558420);
                            if (!com.smp.musicspeed.tag_editor.m.c(new File(mediaTrack.getLocation()))) {
                                popupMenu.getMenu().findItem(2131296376).setEnabled(false);
                            }
                            if (!u.d(new File(mediaTrack.getLocation())) && !z.b()) {
                                popupMenu.getMenu().findItem(2131296333).setEnabled(false);
                            }
                            popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new l(p2, a2, e2));
                            popupMenu.show();
                            return;
                        }
                        f.z.d.k.s("adapter");
                        throw null;
                    }
                    f.z.d.k.s("adapter");
                    throw null;
                }

                private static final boolean j0(p p2, a a2, e e2, MenuItem menuItem) {
                    f.z.d.k.g((Object)p2, "this$0");
                    f.z.d.k.g(a2, "this$1");
                    f.z.d.k.g(e2, "this$2");
                    e.a.a.a.c c2 = p2.o;
                    if (c2 != null) {
                        int n2 = c2.getItemCount();
                        int n3 = a2.getAdapterPosition();
                        boolean bl = false;
                        if (n3 >= 0) {
                            bl = false;
                            if (n3 < n2) {
                                bl = true;
                            }
                        }
                        if (!bl) {
                            return true;
                        }
                        e.a.a.a.c c3 = p2.o;
                        if (c3 != null) {
                            int n4 = c3.w(a2.getAdapterPosition());
                            List list = f.u.l.b((Object)e2.M().get(n4));
                            Context context = p2.requireContext();
                            f.z.d.k.f((Object)context, "requireContext()");
                            f0.o(context, menuItem.getItemId(), list, false, 8, null);
                            return true;
                        }
                        f.z.d.k.s("adapter");
                        throw null;
                    }
                    f.z.d.k.s("adapter");
                    throw null;
                }
            };
            view.findViewById(2131297191).setVisibility(0);
            return d2;
        }

    }

}

