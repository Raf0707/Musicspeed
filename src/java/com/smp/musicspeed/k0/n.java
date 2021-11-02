/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.appcompat.app.e
 *  androidx.appcompat.widget.Toolbar
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  androidx.viewpager.widget.ViewPager
 *  androidx.viewpager.widget.ViewPager$j
 *  androidx.viewpager.widget.a
 *  b.i.h.a
 *  c.a.a.b
 *  c.a.a.b$a
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$e
 *  com.google.android.material.tabs.TabLayout
 *  com.smp.musicspeed.MainActivity
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.m
 */
package com.smp.musicspeed.k0;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import androidx.appcompat.app.e;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import c.a.a.b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.k0.b;
import com.smp.musicspeed.k0.c;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.l0.d;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.m0.h;
import com.smp.musicspeed.k0.o;
import com.smp.musicspeed.k0.p;
import com.smp.musicspeed.k0.q;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.library.playlists.k;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public abstract class n
extends Fragment
implements ViewPager.j,
AppBarLayout.e {
    Toolbar f;
    TabLayout g;
    AppBarLayout h;
    ViewPager i;
    private q j;

    private void A(int n2) {
        this.j.u(this.g.getSelectedTabPosition()).a0(n2);
    }

    private void B() {
        this.getActivity().setTitle(this.v());
        this.u().i0(this.f);
    }

    private void C() {
        q q2;
        this.j = q2 = this.t();
        this.i.setAdapter((androidx.viewpager.widget.a)q2);
        this.i.setOffscreenPageLimit(-1 + this.j.c());
        this.g.setupWithViewPager(this.i);
        this.i.c((ViewPager.j)this);
        this.j.i();
        this.i.setCurrentItem(com.smp.musicspeed.utils.k.z(this.requireContext(), this.H()));
    }

    static /* synthetic */ void x(i.a.b b2, DialogInterface dialogInterface, int n2) {
        b2.b();
    }

    static /* synthetic */ void y(i.a.b b2, DialogInterface dialogInterface, int n2) {
        b2.cancel();
    }

    static /* synthetic */ void z(DialogInterface dialogInterface) {
        org.greenrobot.eventbus.c.d().m(new Object(false){
            public final boolean a;
            {
                this.a = bl;
            }
        });
    }

    void D() {
        org.greenrobot.eventbus.c.d().m(new /* invalid duplicate definition of identical inner class */);
    }

    void F(i.a.b b2) {
        new d.a((Context)this.requireActivity()).g(2131821183).o(2131820678, (DialogInterface.OnClickListener)new com.smp.musicspeed.k0.a(b2)).j(2131820679, (DialogInterface.OnClickListener)new b(b2)).m((DialogInterface.OnDismissListener)c.f).v();
    }

    protected abstract String G(int var1, int var2);

    protected abstract String H();

    public void c(int n2, float f2, int n3) {
    }

    public void f(AppBarLayout appBarLayout, int n2) {
        ViewPager viewPager = this.i;
        viewPager.setPadding(viewPager.getPaddingLeft(), this.i.getPaddingTop(), this.i.getPaddingRight(), n2 + this.h.getTotalScrollRange());
    }

    public void k(int n2) {
    }

    public void l(int n2) {
        p<?, ?, ?> p2 = this.j.u(n2);
        if (p2 == null) {
            return;
        }
        c.a.a.b.b.a();
        p2.o();
        com.smp.musicspeed.utils.k.Q(this.requireContext(), this.H(), n2);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.setHasOptionsMenu(true);
        z.h((Activity)this.requireActivity(), this.f);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        org.greenrobot.eventbus.c.d().r((Object)((Object)this));
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2131492967, viewGroup, false);
        this.f = (Toolbar)view.findViewById(2131297246);
        this.g = (TabLayout)view.findViewById(2131297169);
        this.h = (AppBarLayout)view.findViewById(2131296426);
        this.i = (ViewPager)view.findViewById(2131297005);
        this.h.b((AppBarLayout.e)this);
        ((e)this.getActivity()).i0(this.f);
        return view;
    }

    public void onDestroy() {
        org.greenrobot.eventbus.c.d().v((Object)((Object)this));
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.i.J((ViewPager.j)this);
        c.a.a.b.b.a();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int n2 = menuItem.getItemId();
        if (n2 != 2131296356) {
            if (n2 != 2131296363) {
                if (n2 != 2131296368) {
                    switch (n2) {
                        default: {
                            return false;
                        }
                        case 2131296371: 
                        case 2131296372: 
                        case 2131296373: 
                        case 2131296374: 
                    }
                    p<?, ?, ?> p2 = this.j.u(this.g.getSelectedTabPosition());
                    int n3 = 0;
                    if (p2 != null) {
                        n3 = p2.G().ordinal();
                    }
                    com.smp.musicspeed.utils.k.N(this.requireContext(), n3, this.G(n3, menuItem.getItemId()));
                    h.a(this.requireContext());
                    menuItem.setChecked(true);
                    this.A(menuItem.getItemId());
                    return true;
                }
                int n4 = this.i.getCurrentItem();
                List<MT> list = ((m)this.j.u(n4).D()).q();
                f0.n(this.requireContext(), menuItem.getItemId(), list, true);
                return true;
            }
            org.greenrobot.eventbus.c.d().m((Object)new d());
            return true;
        }
        this.requireActivity().onOptionsItemSelected(menuItem);
        return true;
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onPermissionEvent(p.e e2) {
        o.b(this);
    }

    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        super.onRequestPermissionsResult(n2, arrstring, arrn);
        o.c(this, n2, arrn);
    }

    public void onStart() {
        super.onStart();
        if (b.i.h.a.a((Context)this.getActivity(), (String)"android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            o.b(this);
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.B();
        this.C();
    }

    protected abstract q t();

    public MainActivity u() {
        return (MainActivity)this.getActivity();
    }

    protected abstract int v();

    public void w() {
        Context context = this.getContext();
        if (context != null) {
            k.a(context);
        }
        org.greenrobot.eventbus.c.d().m(new /* invalid duplicate definition of identical inner class */);
    }

}

