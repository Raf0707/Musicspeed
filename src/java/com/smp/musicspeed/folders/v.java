/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Environment
 *  android.os.Parcelable
 *  android.text.Html
 *  android.util.SparseBooleanArray
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.MimeTypeMap
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.app.e
 *  androidx.appcompat.widget.Toolbar
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.core.graphics.drawable.a
 *  androidx.core.widget.ContentLoadingProgressBar
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.p
 *  androidx.lifecycle.w
 *  androidx.lifecycle.x
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$i
 *  androidx.recyclerview.widget.RecyclerView$n
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.f
 *  androidx.recyclerview.widget.f$c
 *  b.i.h.a
 *  b.o.a.a
 *  b.o.a.a$a
 *  b.o.b.b
 *  c.a.a.b
 *  c.a.a.b$a
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$e
 *  com.google.android.material.snackbar.Snackbar
 *  com.smp.musicspeed.MainActivity
 *  java.io.File
 *  java.io.FileFilter
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.m
 */
package com.smp.musicspeed.folders;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.text.Html;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import b.o.a.a;
import c.a.a.b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.ads.AdsProvider;
import com.smp.musicspeed.ads.r;
import com.smp.musicspeed.c0;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.folders.BreadCrumbLayout;
import com.smp.musicspeed.folders.e;
import com.smp.musicspeed.folders.f;
import com.smp.musicspeed.folders.g;
import com.smp.musicspeed.folders.h;
import com.smp.musicspeed.folders.i;
import com.smp.musicspeed.folders.j;
import com.smp.musicspeed.folders.k;
import com.smp.musicspeed.folders.l;
import com.smp.musicspeed.folders.m;
import com.smp.musicspeed.folders.s;
import com.smp.musicspeed.folders.t;
import com.smp.musicspeed.folders.u;
import com.smp.musicspeed.folders.v;
import com.smp.musicspeed.folders.w;
import com.smp.musicspeed.folders.x;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.utils.AppPrefs;
import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;

public class v
extends Fragment
implements BreadCrumbLayout.a,
AppBarLayout.e,
a.a<Map<File, MediaTrack>>,
s.a,
com.smp.musicspeed.k0.u {
    public static final FileFilter f = com.smp.musicspeed.folders.d.a;
    protected SparseBooleanArray g = new SparseBooleanArray();
    CoordinatorLayout h;
    View i;
    View j;
    Toolbar k;
    ContentLoadingProgressBar l;
    BreadCrumbLayout m;
    AppBarLayout n;
    FastScrollRecyclerView o;
    private Context p;
    private s q;
    private com.smp.musicspeed.ads.m r;
    private int s = -1;
    private HashMap<MenuItem, String> t = new HashMap();
    private w u;
    AsyncTask<Void, Void, f.c> v;

    private void A() {
        boolean bl;
        block4 : {
            block3 : {
                for (int i2 = 0; i2 < this.q.v().size(); ++i2) {
                    this.g.put(i2, true);
                }
                if (z.b()) break block3;
                boolean bl2 = u.d(this.B().l());
                bl = false;
                if (!bl2) break block4;
            }
            bl = true;
        }
        int n2 = bl ? 2131558402 : 2131558403;
        com.smp.musicspeed.k0.t.a((androidx.appcompat.app.e)this.requireActivity(), this.x(), this.q.v().size(), this, n2);
        this.q.notifyDataSetChanged();
    }

    public static File C() {
        File file = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_MUSIC);
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        File file2 = Environment.getExternalStorageDirectory();
        if (file2.exists() && file2.isDirectory()) {
            return file2;
        }
        return new File("/");
    }

    private String F() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager)this.o.getLayoutManager();
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            if (!this.g.valueAt(i2)) continue;
            return this.s0(linearLayoutManager.D(this.f0(this.g.keyAt(i2))));
        }
        return null;
    }

    private /* synthetic */ boolean H(File file, MenuItem menuItem) {
        w w2;
        int n2 = menuItem.getItemId();
        switch (n2) {
            default: {
                return false;
            }
            case 2131296309: 
            case 2131296310: 
            case 2131296333: 
            case 2131296335: 
            case 2131296339: 
            case 2131296340: 
            case 2131296353: 
            case 2131296367: 
            case 2131296376: 
        }
        w w3 = this.u;
        if (w3 != null) {
            w3.cancel(false);
        }
        this.u = w2 = new w((Context)this.getActivity(), new m(this, n2, file));
        Object[] arrobject = new w.a[]{new Object((List<File>)this.t0(file), f, this.D(this.requireContext())){
            public final Comparator<File> a;
            public final FileFilter b;
            public final List<File> c;
            {
                this.a = comparator;
                this.b = fileFilter;
                this.c = list;
            }
        }};
        w2.execute(arrobject);
        return true;
    }

    private /* synthetic */ void K(int n2, List list, List list2) {
        if (!list.isEmpty()) {
            f0.n((Context)this.getActivity(), n2, (List<? extends com.smp.musicspeed.k0.m0.e>)list, true);
        }
    }

    private /* synthetic */ boolean N(File file, MenuItem menuItem) {
        w w2;
        int n2 = menuItem.getItemId();
        switch (n2) {
            default: {
                return false;
            }
            case 2131296365: {
                com.smp.musicspeed.utils.k.O(this.requireContext(), file);
                androidx.fragment.app.d d2 = this.getActivity();
                String string = this.getString(2131821358);
                Object[] arrobject = new Object[]{file.getPath()};
                Toast.makeText((Context)d2, (CharSequence)String.format((String)string, (Object[])arrobject), (int)0).show();
                return true;
            }
            case 2131296309: 
            case 2131296310: 
            case 2131296351: 
            case 2131296353: 
        }
        w w3 = this.u;
        if (w3 != null) {
            w3.cancel(false);
        }
        this.u = w2 = new w((Context)this.getActivity(), new l(this, n2));
        Object[] arrobject = new w.a[]{new /* invalid duplicate definition of identical inner class */};
        w2.execute(arrobject);
        return true;
    }

    private /* synthetic */ void P(int n2, File file, List list, List list2) {
        if (!list.isEmpty()) {
            Context context = this.requireContext();
            Object[] arrobject = new MediaTrack[]{(MediaTrack)list.get(0)};
            f0.n(context, n2, (List<? extends com.smp.musicspeed.k0.m0.e>)Arrays.asList((Object[])arrobject), true);
            return;
        }
        CoordinatorLayout coordinatorLayout = this.h;
        String string = this.getString(2131821296);
        Object[] arrobject = new Object[]{file.getName()};
        Snackbar snackbar = Snackbar.c0((View)coordinatorLayout, (CharSequence)Html.fromHtml((String)String.format((String)string, (Object[])arrobject)), (int)0);
        z.g(snackbar, b.i.h.a.c((Context)this.requireActivity(), (int)2131100320));
        snackbar.R();
    }

    static /* synthetic */ boolean R(File file) {
        return !file.isDirectory() && f.accept(file);
    }

    private /* synthetic */ void S(File file, List list, List list2) {
        int n2;
        block3 : {
            for (n2 = 0; n2 < list.size(); ++n2) {
                if (!file.getPath().equals((Object)((MediaTrack)list.get(n2)).getLocation())) {
                    continue;
                }
                break block3;
            }
            n2 = -1;
        }
        if (n2 > -1) {
            org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.k0.l0.h((List<MediaTrack>)list, n2, false, true));
            return;
        }
        CoordinatorLayout coordinatorLayout = this.h;
        String string = this.getString(2131821296);
        Object[] arrobject = new Object[]{file.getName()};
        Snackbar snackbar = Snackbar.c0((View)coordinatorLayout, (CharSequence)Html.fromHtml((String)String.format((String)string, (Object[])arrobject)), (int)0);
        z.g(snackbar, b.i.h.a.c((Context)this.requireActivity(), (int)2131100320));
        snackbar.R();
    }

    private /* synthetic */ void U(int n2, List list, List list2) {
        if (!list.isEmpty()) {
            f0.n((Context)this.getActivity(), n2, (List<? extends com.smp.musicspeed.k0.m0.e>)list, true);
        }
        if (list.size() < list2.size()) {
            Snackbar snackbar = Snackbar.b0((View)this.h, (int)2131821356, (int)0);
            z.g(snackbar, b.i.h.a.c((Context)this.requireActivity(), (int)2131100320));
            snackbar.R();
        }
    }

    private /* synthetic */ void W(Boolean bl) {
        Context context;
        if (bl.booleanValue() && !AppPrefs.k.D() && (context = this.getContext()) != null) {
            ((r)r.f.a(context)).c();
        }
    }

    private /* synthetic */ void Y(Boolean bl) {
        com.smp.musicspeed.ads.m m2;
        if (bl.booleanValue() && (m2 = this.r) != null) {
            m2.clearAds();
        }
    }

    private /* synthetic */ void a0(Boolean bl) {
        com.smp.musicspeed.ads.m m2;
        if (bl.booleanValue() && (m2 = this.r) != null) {
            m2.clearAds();
        }
    }

    static /* synthetic */ boolean c0(File file) {
        return !file.isHidden() && (file.isDirectory() || u.a(file, "audio/*", MimeTypeMap.getSingleton()) && !u.a(file, "audio/mpegurl", MimeTypeMap.getSingleton()) && !u.a(file, "audio/x-mpegurl", MimeTypeMap.getSingleton()) || u.a(file, "application/ogg", MimeTypeMap.getSingleton()) || u.a(file, "application/flac", MimeTypeMap.getSingleton()) || u.a(file, "application/x-flac", MimeTypeMap.getSingleton()) || u.a(file, "application/ogg", MimeTypeMap.getSingleton()) || u.a(file, "video/mp4", MimeTypeMap.getSingleton()) || u.a(file, "video/3gpp", MimeTypeMap.getSingleton()) || u.a(file, "application/x-ogg", MimeTypeMap.getSingleton()) || file.getName().toLowerCase().endsWith(".opus"));
    }

    public static v d0(Context context) {
        return v.e0(com.smp.musicspeed.utils.k.k(context));
    }

    public static v e0(File file) {
        v v2 = new v();
        Bundle bundle = new Bundle();
        bundle.putSerializable("path", (Serializable)file);
        v2.setArguments(bundle);
        return v2;
    }

    private int f0(int n2) {
        com.smp.musicspeed.ads.m m2 = this.r;
        if (m2 == null) {
            return n2;
        }
        return m2.getAdjustedPosition(n2);
    }

    private void j0() {
        BreadCrumbLayout.Crumb crumb = this.B();
        if (crumb != null) {
            crumb.o(((LinearLayoutManager)this.o.getLayoutManager()).b2());
        }
    }

    private List<File> k0() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            SparseBooleanArray sparseBooleanArray = this.g;
            if (!sparseBooleanArray.get(sparseBooleanArray.keyAt(i2))) continue;
            arrayList.add((Object)((File)this.q.v().get(this.g.keyAt(i2))));
        }
        return arrayList;
    }

    private void n0() {
        s s2;
        this.q = s2 = new s((androidx.appcompat.app.e)this.requireActivity(), (Map<File, MediaTrack>)new LinkedHashMap(), 2131492999, this, this);
        RecyclerView.i i2 = new RecyclerView.i(this){
            final /* synthetic */ v a;
            {
                this.a = v2;
            }

            public void onChanged() {
                super.onChanged();
                v.u(this.a);
            }
        };
        if (!AppPrefs.k.D()) {
            com.smp.musicspeed.ads.m m2;
            this.r = m2 = c0.c((Activity)this.requireActivity(), i2, this.q, this.s);
            this.s = m2.y();
            this.o.setAdapter(this.r);
        } else {
            this.q.registerAdapterDataObserver(i2);
            this.o.setAdapter(this.q);
        }
        this.y();
    }

    private void o0() {
        this.m.setCallback(this);
    }

    private void p0() {
        this.o.setLayoutManager((RecyclerView.o)new LinearLayoutManager((Context)this.getActivity()));
        this.n.b((AppBarLayout.e)this);
        int n2 = com.smp.musicspeed.utils.t.w(this.requireContext()) ? 2131231023 : 2131231024;
        com.smp.musicspeed.utils.i i2 = new com.smp.musicspeed.utils.i(b.i.h.a.e((Context)this.requireContext(), (int)n2), 72);
        this.o.k((RecyclerView.n)i2);
        AppPrefs appPrefs = AppPrefs.k;
        if (!appPrefs.D()) {
            AdsProvider.a.e().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new h(this));
            appPrefs.E().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new com.smp.musicspeed.folders.c(this));
            com.smp.musicspeed.ads.x.f.b().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new k(this));
        }
    }

    private void q0() {
        this.getActivity().setTitle(2131820625);
        ((androidx.appcompat.app.e)this.requireActivity()).i0(this.k);
    }

    private String r0(int n2) {
        switch (n2) {
            default: {
                return "";
            }
            case 2131296374: {
                return "title_key DESC";
            }
            case 2131296373: {
                return "title_key";
            }
            case 2131296372: {
                return "date_modified DESC";
            }
            case 2131296371: 
        }
        return "date_modified";
    }

    private String s0(View view) {
        if (view == null) {
            return null;
        }
        return ((TextView)view.findViewById(2131297235)).getText().toString();
    }

    static /* synthetic */ HashMap t(v v2) {
        return v2.t;
    }

    private ArrayList<File> t0(File file) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add((Object)file);
        return arrayList;
    }

    static /* synthetic */ void u(v v2) {
        v2.y();
    }

    @SuppressLint(value={"StaticFieldLeak"})
    private void u0(Map<File, MediaTrack> map) {
        AsyncTask<Void, Void, f.c> asyncTask = this.v;
        if (asyncTask != null) {
            asyncTask.cancel(false);
        }
        this.v = new AsyncTask<Void, Void, f.c>(this, map){
            final /* synthetic */ Map a;
            final /* synthetic */ v b;
            {
                this.b = v2;
                this.a = map;
            }

            protected /* varargs */ f.c a(Void ... arrvoid) {
                return androidx.recyclerview.widget.f.a((androidx.recyclerview.widget.f$b)new com.smp.musicspeed.k0.b0(v.v(this.b).s(), (Map<? extends Object, ? extends Object>)this.a));
            }

            protected void b(f.c c2) {
                if (this.isCancelled()) {
                    return;
                }
                if (c2 != null) {
                    FastScrollRecyclerView fastScrollRecyclerView;
                    v.v(this.b).A((Map<File, MediaTrack>)this.a);
                    c2.e((RecyclerView.g)v.v(this.b));
                    BreadCrumbLayout.Crumb crumb = this.b.B();
                    if (crumb != null && (fastScrollRecyclerView = this.b.o) != null) {
                        ((LinearLayoutManager)fastScrollRecyclerView.getLayoutManager()).H2(crumb.m(), 0);
                    }
                }
                v.u(this.b);
            }

            protected void onPreExecute() {
                FastScrollRecyclerView fastScrollRecyclerView;
                if (this.b.B() != null && (fastScrollRecyclerView = this.b.o) != null && fastScrollRecyclerView.getLayoutManager() != null && v.v(this.b).getItemCount() > 0) {
                    v.w(this.b);
                }
            }
        }.execute((Object[])new Void[0]);
    }

    static /* synthetic */ s v(v v2) {
        return v2.q;
    }

    static /* synthetic */ void w(v v2) {
        v2.j0();
    }

    private String x() {
        if (this.g0() == 1) {
            return this.F();
        }
        return "";
    }

    private void y() {
        View view = this.j;
        if (view != null) {
            s s2 = this.q;
            int n2 = s2 != null && s2.getItemCount() != 0 ? 8 : 0;
            view.setVisibility(n2);
        }
    }

    private void z(View view, int n2) {
        block5 : {
            String string;
            boolean bl;
            block7 : {
                block6 : {
                    if (view.isActivated()) {
                        this.g.put(n2, false);
                    } else {
                        this.g.put(n2, true);
                    }
                    string = this.x();
                    if (string == null) break block5;
                    if (z.b()) break block6;
                    boolean bl2 = u.d(this.B().l());
                    bl = false;
                    if (!bl2) break block7;
                }
                bl = true;
            }
            int n3 = bl ? 2131558402 : 2131558403;
            com.smp.musicspeed.k0.t.a((androidx.appcompat.app.e)this.requireActivity(), string, this.g0(), this, n3);
            this.q.notifyItemChanged(n2);
            return;
        }
        c.a.a.b.b.a();
    }

    BreadCrumbLayout.Crumb B() {
        BreadCrumbLayout breadCrumbLayout = this.m;
        if (breadCrumbLayout != null && breadCrumbLayout.o() > 0) {
            BreadCrumbLayout breadCrumbLayout2 = this.m;
            return breadCrumbLayout2.f(breadCrumbLayout2.getActiveIndex());
        }
        return null;
    }

    Comparator<File> D(Context context) {
        return new Comparator<File>(context){
            Context f;
            {
                this.f = context.getApplicationContext();
            }

            public int a(File file, File file2) {
                boolean bl = file.isDirectory();
                int n2 = -1;
                if (bl && !file2.isDirectory()) {
                    return n2;
                }
                if (!file.isDirectory() && file2.isDirectory()) {
                    return 1;
                }
                String string = com.smp.musicspeed.utils.k.w(this.f, n2);
                int n3 = file.getName().compareToIgnoreCase(file2.getName());
                int n4 = Long.valueOf((long)file.lastModified()).compareTo(Long.valueOf((long)file2.lastModified()));
                string.hashCode();
                switch (string.hashCode()) {
                    default: {
                        break;
                    }
                    case 1301476023: {
                        if (!string.equals((Object)"date_modified DESC")) break;
                        n2 = 3;
                        break;
                    }
                    case -102326855: {
                        if (!string.equals((Object)"title_key DESC")) break;
                        n2 = 2;
                        break;
                    }
                    case -825358278: {
                        if (!string.equals((Object)"date_modified")) break;
                        n2 = 1;
                        break;
                    }
                    case -2135424008: {
                        if (!string.equals((Object)"title_key")) break;
                        n2 = 0;
                    }
                }
                switch (n2) {
                    default: {
                        return 0;
                    }
                    case 3: {
                        return -n4;
                    }
                    case 2: {
                        n4 = -n3;
                    }
                    case 1: {
                        return n4;
                    }
                    case 0: 
                }
                return n3;
            }
        };
    }

    public boolean G() {
        if (this.m.k()) {
            this.l0(this.m.j(), false);
            return true;
        }
        return false;
    }

    public void I(b.o.b.b<Map<File, MediaTrack>> b2) {
        this.u0((Map<File, MediaTrack>)new LinkedHashMap());
    }

    public /* synthetic */ boolean J(File file, MenuItem menuItem) {
        return this.H(file, menuItem);
    }

    public /* synthetic */ void M(int n2, List list, List list2) {
        this.K(n2, list, list2);
    }

    public /* synthetic */ boolean O(File file, MenuItem menuItem) {
        return this.N(file, menuItem);
    }

    public /* synthetic */ void Q(int n2, File file, List list, List list2) {
        this.P(n2, file, list, list2);
    }

    public /* synthetic */ void T(File file, List list, List list2) {
        this.S(file, list, list2);
    }

    public /* synthetic */ void V(int n2, List list, List list2) {
        this.U(n2, list, list2);
    }

    public /* synthetic */ void X(Boolean bl) {
        this.W(bl);
    }

    public /* synthetic */ void Z(Boolean bl) {
        this.Y(bl);
    }

    @Override
    public int a(int n2) {
        com.smp.musicspeed.ads.m m2 = this.r;
        if (m2 == null) {
            return n2;
        }
        if (n2 < m2.getItemCount() && n2 >= 0) {
            return this.r.getOriginalPosition(n2);
        }
        return -1;
    }

    @Override
    public void b(File file) {
        w w2;
        if (file.isDirectory()) {
            com.smp.musicspeed.utils.k.I(this.requireContext(), file);
            this.l0(new BreadCrumbLayout.Crumb(file), true);
            return;
        }
        (MediaTrack)this.q.s().get((Object)file);
        f f2 = f.a;
        w w3 = this.u;
        if (w3 != null) {
            w3.cancel(false);
        }
        this.u = w2 = new w((Context)this.getActivity(), new e(this, file));
        Object[] arrobject = new w.a[]{new /* invalid duplicate definition of identical inner class */};
        w2.execute(arrobject);
    }

    public /* synthetic */ void b0(Boolean bl) {
        this.a0(bl);
    }

    @Override
    public void d(File file, I i2, boolean bl, View view) {
        PopupMenu popupMenu = new PopupMenu((Context)this.getActivity(), view);
        if (file.isDirectory()) {
            popupMenu.inflate(2131558411);
            popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new j(this, file));
        } else {
            popupMenu.inflate(2131558412);
            Menu menu = popupMenu.getMenu();
            if (i2 != I.a) {
                menu.findItem(2131296339).setEnabled(false);
                menu.findItem(2131296340).setEnabled(false);
            }
            if (!z.b() && !bl) {
                menu.findItem(2131296333).setEnabled(false);
            }
            if (!com.smp.musicspeed.tag_editor.m.c(file)) {
                menu.findItem(2131296376).setEnabled(false);
            }
            popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new i(this, file));
        }
        popupMenu.show();
    }

    public void f(AppBarLayout appBarLayout, int n2) {
        View view = this.i;
        view.setPadding(view.getPaddingLeft(), this.i.getPaddingTop(), this.i.getPaddingRight(), n2 + this.n.getTotalScrollRange());
    }

    @Override
    public void g(BreadCrumbLayout.Crumb crumb, int n2) {
        this.l0(crumb, true);
        com.smp.musicspeed.utils.k.I(this.requireContext(), crumb.l());
    }

    public int g0() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            if (!this.g.valueAt(i2)) continue;
            ++n2;
        }
        return n2;
    }

    @Override
    public void h(View view, int n2) {
        this.z(view, n2);
    }

    public void h0(b.o.b.b<Map<File, MediaTrack>> b2, Map<File, MediaTrack> map) {
        this.u0(map);
        this.l.a();
    }

    public void i0(int n2, List<File> list) {
        w w2;
        w w3 = this.u;
        if (w3 != null) {
            w3.cancel(false);
        }
        this.u = w2 = new w((Context)this.getActivity(), new g(this, n2));
        Object[] arrobject = new w.a[]{new /* invalid duplicate definition of identical inner class */};
        w2.execute(arrobject);
    }

    @Override
    public int j() {
        return 2131297244;
    }

    public void l0(BreadCrumbLayout.Crumb crumb, boolean bl) {
        this.l.c();
        c.a.a.b.b.a();
        if (crumb == null) {
            this.l.a();
            return;
        }
        this.j0();
        this.m.n(crumb, false);
        if (bl) {
            this.m.d(crumb);
        }
        this.getLoaderManager().g(533, null, (a.a)this);
    }

    @Override
    public void m(View view, int n2) {
        this.z(view, n2);
    }

    public void m0(int n2) {
        switch (n2) {
            default: {
                this.o.setPopupTextSize(com.smp.musicspeed.k0.p.f0(42.0f, this.requireContext()));
                return;
            }
            case 2131296371: 
            case 2131296372: 
        }
        this.o.setPopupTextSize(com.smp.musicspeed.k0.p.f0(32.0f, this.requireContext()));
    }

    @Override
    public void o() {
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            int n2 = this.g.keyAt(i2);
            if (!this.q(n2)) continue;
            this.g.put(n2, false);
            this.q.notifyItemChanged(n2);
        }
        this.g.clear();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        MainActivity mainActivity = (MainActivity)this.requireActivity();
        if (!mainActivity.Q2()) {
            mainActivity.I2();
        }
        if (bundle == null) {
            this.l0(new BreadCrumbLayout.Crumb(u.g((File)this.getArguments().getSerializable("path"))), true);
        } else {
            this.m.l((BreadCrumbLayout.SavedStateWrapper)bundle.getParcelable("crumbs"));
            this.getLoaderManager().e(533, null, (a.a)this);
        }
        z.h((Activity)this.requireActivity(), this.k);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @SuppressLint(value={"StaticFieldLeak"})
    public void onCreateOptionsMenu(Menu var1_1, MenuInflater var2_2) {
        block13 : {
            super.onCreateOptionsMenu(var1_1, var2_2);
            var2_2.inflate(2131558406, var1_1);
            new AsyncTask<Void, Void, String[]>(this, var1_1.findItem(2131296375).getSubMenu()){
                final /* synthetic */ SubMenu a;
                final /* synthetic */ v b;
                {
                    this.b = v2;
                    this.a = subMenu;
                }

                protected /* varargs */ String[] a(Void ... arrvoid) {
                    Context context = this.b.getContext();
                    if (context != null) {
                        return u.b(context);
                    }
                    return new String[0];
                }

                protected void b(String[] arrstring) {
                    if (arrstring.length > 0) {
                        for (int i2 = 0; i2 < arrstring.length; ++i2) {
                            String string;
                            Context context = this.b.getContext();
                            if (context == null) continue;
                            if (i2 == 0) {
                                string = context.getString(2131820630);
                            } else {
                                java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                                stringBuilder.append(context.getString(2131820650));
                                stringBuilder.append(" ");
                                Object[] arrobject = new Object[]{i2};
                                stringBuilder.append(String.format((String)"%d", (Object[])arrobject));
                                string = stringBuilder.toString();
                            }
                            this.a.add(1, 0, i2, (CharSequence)string);
                            v.t(this.b).put((Object)this.a.getItem(i2), (Object)arrstring[i2]);
                        }
                    }
                }
            }.execute((Object[])new Void[0]);
            if (AppPrefs.k.D()) {
                var1_1.removeItem(2131296356);
            }
            var4_3 = com.smp.musicspeed.utils.k.w(this.requireContext(), -1);
            var4_3.hashCode();
            switch (var4_3.hashCode()) {
                case 1301476023: {
                    if (!var4_3.equals((Object)"date_modified DESC")) break;
                    var7_4 = 3;
                    ** break;
                }
                case -102326855: {
                    if (!var4_3.equals((Object)"title_key DESC")) break;
                    var7_4 = 2;
                    ** break;
                }
                case -825358278: {
                    if (!var4_3.equals((Object)"date_modified")) break;
                    var7_4 = 1;
                    ** break;
                }
                case -2135424008: {
                    var6_5 = var4_3.equals((Object)"title_key");
                    var7_4 = 0;
                    if (var6_5) break block13;
                }
            }
            var7_4 = -1;
            ** break;
        }
        switch (var7_4) {
            default: {
                return;
            }
            case 3: {
                var1_1.findItem(2131296372).setChecked(true);
                this.m0(2131296372);
                return;
            }
            case 2: {
                var1_1.findItem(2131296374).setChecked(true);
                this.m0(2131296374);
                return;
            }
            case 1: {
                var1_1.findItem(2131296371).setChecked(true);
                this.m0(2131296371);
                return;
            }
            case 0: 
        }
        var1_1.findItem(2131296373).setChecked(true);
        this.m0(2131296373);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2131492965, viewGroup, false);
        this.h = (CoordinatorLayout)view.findViewById(2131296601);
        this.i = view.findViewById(2131296587);
        this.k = (Toolbar)view.findViewById(2131297243);
        this.j = view.findViewById(16908292);
        this.m = (BreadCrumbLayout)view.findViewById(2131296461);
        this.n = (AppBarLayout)view.findViewById(2131296425);
        this.o = (FastScrollRecyclerView)view.findViewById(2131297063);
        this.p = this.requireContext().getApplicationContext();
        this.l = (ContentLoadingProgressBar)view.findViewById(2131297041);
        return view;
    }

    public void onDestroyView() {
        AsyncTask<Void, Void, f.c> asyncTask;
        com.smp.musicspeed.ads.m m2;
        this.n.p((AppBarLayout.e)this);
        w w2 = this.u;
        if (w2 != null) {
            w2.cancel(false);
        }
        if ((asyncTask = this.v) != null) {
            asyncTask.cancel(false);
        }
        if ((m2 = this.r) != null) {
            m2.x();
            this.r = null;
        }
        org.greenrobot.eventbus.c.d().v((Object)this);
        super.onDestroyView();
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(g.c c2) {
        this.getLoaderManager().g(533, null, (a.a)this);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getGroupId() == 1) {
            String string = (String)this.t.get((Object)menuItem);
            this.l0(new BreadCrumbLayout.Crumb(u.g(new File(string))), true);
            File file = u.g(new File(string));
            com.smp.musicspeed.utils.k.I(this.requireContext(), file);
            return true;
        }
        int n2 = menuItem.getItemId();
        if (n2 != 2131296341) {
            if (n2 != 2131296365) {
                switch (n2) {
                    default: {
                        return super.onOptionsItemSelected(menuItem);
                    }
                    case 2131296371: 
                    case 2131296372: 
                    case 2131296373: 
                    case 2131296374: 
                }
                com.smp.musicspeed.utils.k.N(this.requireContext(), -1, this.r0(menuItem.getItemId()));
                com.smp.musicspeed.k0.m0.h.a(this.requireContext());
                menuItem.setChecked(true);
                this.m0(menuItem.getItemId());
                return true;
            }
            BreadCrumbLayout breadCrumbLayout = this.m;
            File file = breadCrumbLayout.f(breadCrumbLayout.getActiveIndex()).l();
            com.smp.musicspeed.utils.k.O(this.requireContext(), file);
            androidx.fragment.app.d d2 = this.getActivity();
            String string = this.getString(2131821358);
            Object[] arrobject = new Object[]{file.getPath()};
            Toast.makeText((Context)d2, (CharSequence)String.format((String)string, (Object[])arrobject), (int)0).show();
            return true;
        }
        this.l0(new BreadCrumbLayout.Crumb(u.g(com.smp.musicspeed.utils.k.x(this.requireContext()))), true);
        Toast.makeText((Context)this.getActivity(), (int)2131821324, (int)0).show();
        return true;
    }

    public void onPause() {
        super.onPause();
        this.j0();
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("crumbs", (Parcelable)this.m.getStateWrapper());
    }

    public void onViewCreated(View view, Bundle bundle) {
        if (bundle != null) {
            this.s = bundle.getInt("adFirstPosition", -1);
        }
        this.setHasOptionsMenu(true);
        this.q0();
        this.o0();
        this.p0();
        this.n0();
        org.greenrobot.eventbus.c.d().r((Object)this);
        if (Build.VERSION.SDK_INT < 21) {
            Drawable drawable = androidx.core.graphics.drawable.a.r((Drawable)this.l.getIndeterminateDrawable());
            androidx.core.graphics.drawable.a.n((Drawable)drawable, (int)com.smp.musicspeed.utils.t.c((Context)this.requireActivity()));
            this.l.setIndeterminateDrawable(androidx.core.graphics.drawable.a.q((Drawable)drawable));
        }
    }

    @Override
    public boolean q(int n2) {
        return this.g.get(n2);
    }

    @Override
    public void r(int n2) {
        if (n2 != 2131296364) {
            this.i0(n2, this.k0());
            c.a.a.b.b.a();
            return;
        }
        this.A();
    }

    public b.o.b.b<Map<File, MediaTrack>> s(int n2, Bundle bundle) {
        return new t(this, this.p);
    }

}

