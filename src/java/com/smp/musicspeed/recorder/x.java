/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.text.Editable
 *  android.text.InputFilter
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.ImageButton
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.app.e
 *  androidx.appcompat.widget.Toolbar
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  androidx.fragment.app.s
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.i
 *  androidx.lifecycle.i$c
 *  androidx.lifecycle.p
 *  androidx.lifecycle.x
 *  b.i.h.a
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  f.u.l
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.LinkedList
 *  java.util.List
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.m
 */
package com.smp.musicspeed.recorder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.d0;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.recorder.RecorderService;
import com.smp.musicspeed.recorder.a0;
import com.smp.musicspeed.recorder.l;
import com.smp.musicspeed.recorder.m;
import com.smp.musicspeed.recorder.n;
import com.smp.musicspeed.recorder.o;
import com.smp.musicspeed.recorder.q;
import com.smp.musicspeed.recorder.r;
import com.smp.musicspeed.recorder.u;
import com.smp.musicspeed.recorder.v;
import com.smp.musicspeed.recorder.w;
import com.smp.musicspeed.recorder.x;
import com.smp.musicspeed.recorder.y;
import com.smp.musicspeed.recorder.z;
import com.smp.musicspeed.utils.h;
import com.smp.musicspeed.utils.t;
import f.u.f;
import f.z.d.g;
import f.z.d.k;
import java.util.LinkedList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import rm.com.audiowave.AudioWaveView;

public final class x
extends Fragment {
    public static final a f = new Object(null){
        {
            this();
        }

        public final x a() {
            return new x();
        }
    };
    private long g;
    private final f.f h = f.g.a(d.g);
    public byte[] i;
    private final c j = new Runnable(){
        {
            k.g((Object)x.this, "this$0");
        }

        public void run() {
            x.this.J();
            x.this.C().postDelayed((Runnable)this, 8L);
        }
    };
    private final b k = new Runnable(){
        {
            k.g((Object)x.this, "this$0");
        }

        public void run() {
            Fragment fragment = x.this.getChildFragmentManager().j0("recorded");
            if (fragment != null) {
                x.this.getChildFragmentManager().n().s(2130772001, 2130772002).p(fragment).j();
            }
        }
    };

    private final long A() {
        return RecorderService.f.b();
    }

    private final org.greenrobot.eventbus.c B() {
        org.greenrobot.eventbus.c c2 = org.greenrobot.eventbus.c.d();
        k.f((Object)c2, "getDefault()");
        return c2;
    }

    private final LiveData<LinkedList<Byte>> D() {
        return RecorderService.f.d();
    }

    private final int F() {
        return RecorderService.f.e();
    }

    private final void H() {
        int n2 = this.F() != 2 && this.F() != 3 ? 8 : 0;
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.n);
        ((ImageButton)view2).setVisibility(n2);
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.q);
        ((ImageButton)view4).setVisibility(n2);
    }

    private final void J() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.k0);
        if (view2 != null) {
            View view3 = this.getView();
            View view4 = view3 == null ? null : view3.findViewById(d0.k0);
            TextView textView = (TextView)view4;
            String string = this.F() != 2 && this.F() != 3 ? this.requireContext().getString(2131821279) : t.q(this.A());
            textView.setText((CharSequence)string);
        }
    }

    private final void K() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.M);
        EditText editText = (EditText)view2;
        if (this.F() == 2) {
            editText.clearFocus();
            editText.setEnabled(false);
            return;
        }
        editText.setEnabled(true);
    }

    private final void M() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.z);
        FloatingActionButton floatingActionButton = (FloatingActionButton)view2;
        if (this.F() == 2) {
            if (Build.VERSION.SDK_INT < 24) {
                floatingActionButton.l();
                return;
            }
            floatingActionButton.setImageResource(2131230977);
            return;
        }
        if (Build.VERSION.SDK_INT < 24) {
            floatingActionButton.t();
            return;
        }
        floatingActionButton.setImageResource(2131231103);
    }

    private final void N(String string) {
        this.j0();
        Context context = this.requireContext();
        k.f((Object)context, "requireContext()");
        List<MediaTrack> list = q.d(context, string);
        if (true ^ list.isEmpty()) {
            w w2 = w.f.a((MediaTrack)list.get(0));
            this.getChildFragmentManager().n().s(2130772001, 2130772002).r(2131297057, (Fragment)w2, "recorded").j();
        }
        i.c c2 = this.getLifecycle().b();
        k.f((Object)c2, "lifecycle.currentState");
        if (c2.a(i.c.j)) {
            this.h0();
        }
    }

    private final void O() {
        Context context = this.requireContext();
        k.f((Object)context, "requireContext()");
        String string = q.e(context);
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.M);
        ((EditText)view2).setText((CharSequence)string);
    }

    public static /* synthetic */ void P(x x2, View view) {
        x.e0(x2, view);
    }

    public static /* synthetic */ void Q(x x2, View view) {
        x.f0(x2, view);
    }

    public static /* synthetic */ void R(x x2, LinkedList linkedList) {
        x.U(x2, linkedList);
    }

    public static /* synthetic */ void S(x x2, View view) {
        x.d0(x2, view);
    }

    public static final x T() {
        return f.a();
    }

    private static final void U(x x2, LinkedList linkedList) {
        k.g((Object)x2, "this$0");
        x2.l0();
    }

    private final void V() {
        if (SystemClock.elapsedRealtime() - 500L < this.g) {
            return;
        }
        this.g = SystemClock.elapsedRealtime();
        this.B().m((Object)new u(0, null, 2, null));
    }

    private final void W() {
        if (SystemClock.elapsedRealtime() - 500L < this.g) {
            return;
        }
        this.g = SystemClock.elapsedRealtime();
        this.B().m((Object)new u(3, null, 2, null));
    }

    private final void Y() {
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        if (this.F() == 2 || this.F() == 3) {
            this.B().m((Object)new u(1, null, 2, null));
        }
    }

    private final void Z() {
        Toast.makeText((Context)this.requireContext(), (int)2131821342, (int)1).show();
    }

    private final void b0() {
        androidx.appcompat.app.e e2 = (androidx.appcompat.app.e)this.requireActivity();
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.n0);
        e2.i0((Toolbar)view2);
    }

    private final void c0() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.z);
        ((FloatingActionButton)view2).setOnClickListener((View.OnClickListener)new o(this));
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.n);
        ((ImageButton)view4).setOnClickListener((View.OnClickListener)new l(this));
        View view5 = this.getView();
        View view6 = view5 == null ? null : view5.findViewById(d0.q);
        ((ImageButton)view6).setOnClickListener((View.OnClickListener)new m(this));
        h h2 = new h();
        View view7 = this.getView();
        View view8 = view7 == null ? null : view7.findViewById(d0.M);
        ((EditText)view8).setFilters(new InputFilter[]{h2});
        this.M();
        this.H();
        this.O();
        this.K();
        this.J();
    }

    private static final void d0(x x2, View view) {
        k.g((Object)x2, "this$0");
        y.a(x2);
    }

    private static final void e0(x x2, View view) {
        k.g((Object)x2, "this$0");
        x2.V();
    }

    private static final void f0(x x2, View view) {
        k.g((Object)x2, "this$0");
        x2.W();
    }

    private final void g0() {
        Intent intent = new Intent(this.requireContext(), RecorderService.class);
        intent.setAction("com.smp.musicspeed.ACTION_RECORD_START");
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.M);
        intent.putExtra("extra_record_name", ((EditText)view2).getText().toString());
        b.i.h.a.i((Context)this.requireContext(), (Intent)intent);
    }

    private final void h0() {
        this.C().postDelayed((Runnable)this.k, 5000L);
    }

    private final void i0() {
        this.C().post((Runnable)this.j);
    }

    private final void j0() {
        this.C().removeCallbacks((Runnable)this.k);
    }

    private final void k0() {
        this.C().removeCallbacks((Runnable)this.j);
    }

    private final void l0() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.r0);
        if (view2 == null) {
            return;
        }
        LinkedList linkedList = (LinkedList)this.D().f();
        if (linkedList != null) {
            View view3;
            int n2;
            View view4;
            byte[] arrby = this.i;
            int n3 = 0;
            if (arrby == null || (n2 = this.G().length) != ((AudioWaveView)(view4 = (view3 = this.getView()) == null ? null : view3.findViewById(d0.r0))).getChunksCount()) {
                View view5 = this.getView();
                View view6 = view5 == null ? null : view5.findViewById(d0.r0);
                int n4 = ((AudioWaveView)view6).getChunksCount();
                byte[] arrby2 = new byte[n4];
                for (int i2 = 0; i2 < n4; ++i2) {
                    arrby2[i2] = 0;
                }
                this.a0(arrby2);
            }
            if (linkedList.size() < this.G().length) {
                for (Object object : f.u.l.p((List)linkedList)) {
                    byte by;
                    int n5 = n3 + 1;
                    if (n3 < 0) {
                        f.u.l.i();
                    }
                    this.G()[n3] = by = ((Number)object).byteValue();
                    n3 = n5;
                }
                View view7 = this.getView();
                View view8 = view7 == null ? null : view7.findViewById(d0.r0);
                ((AudioWaveView)view8).setProgress(100.0f * ((float)linkedList.size() / (float)this.G().length));
            } else {
                View view9;
                int n6 = -1 + this.G().length;
                if (n6 >= 0) {
                    do {
                        int n7 = n6 - 1;
                        byte[] arrby3 = this.G();
                        Object object = linkedList.get(-1 + this.G().length - n6);
                        k.f(object, "la[sampleArray.size - 1 - i]");
                        arrby3[n6] = ((Number)object).byteValue();
                        if (n7 < 0) break;
                        n6 = n7;
                    } while (true);
                }
                View view10 = (view9 = this.getView()) == null ? null : view9.findViewById(d0.r0);
                ((AudioWaveView)view10).setProgress(100.0f);
            }
            View view11 = this.getView();
            View view12 = view11 == null ? null : view11.findViewById(d0.r0);
            ((AudioWaveView)view12).setScaledData(this.G());
        }
    }

    private final void m0() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.r0);
        AudioWaveView audioWaveView = (AudioWaveView)view2;
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.r0);
        int n2 = ((AudioWaveView)view4).getChunksCount();
        byte[] arrby = new byte[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            arrby[i2] = 0;
        }
        audioWaveView.setScaledData(arrby);
        View view5 = this.getView();
        View view6 = view5 == null ? null : view5.findViewById(d0.r0);
        ((AudioWaveView)view6).setProgress(0.0f);
        f.e(this.G(), (byte)0, 0, this.G().length);
    }

    public static final /* synthetic */ void u(x x2) {
        x2.l0();
    }

    private final void v() {
        this.B().m((Object)new r());
    }

    private final void w(v v2) {
        this.H();
        this.M();
        this.O();
        this.K();
        this.k0();
        this.m0();
        this.J();
        if (v2.c() == 1) {
            this.Z();
        }
    }

    private final void x(v v2) {
        this.H();
        this.M();
        this.K();
        if (v2.c() == 1) {
            this.Z();
        }
        if (this.F() == 2) {
            this.i0();
        } else {
            this.k0();
        }
        this.J();
    }

    private final void y(v v2) {
        this.H();
        this.M();
        this.K();
        if (v2.c() == 1) {
            this.Z();
            return;
        }
        this.i0();
        this.J();
    }

    private final void z(v v2) {
        this.H();
        this.M();
        this.O();
        this.K();
        this.J();
        this.k0();
        this.m0();
        this.N(v2.b());
        if (v2.c() == 1) {
            this.Z();
        }
    }

    public final Handler C() {
        return (Handler)this.h.getValue();
    }

    public final byte[] G() {
        byte[] arrby = this.i;
        if (arrby != null) {
            return arrby;
        }
        k.s("sampleArray");
        throw null;
    }

    public final void X() {
        if (SystemClock.elapsedRealtime() - 500L < this.g) {
            return;
        }
        this.g = SystemClock.elapsedRealtime();
        int n2 = this.F();
        if (n2 != 0) {
            if (n2 != 2 && n2 != 3) {
                return;
            }
            this.Y();
            return;
        }
        this.g0();
    }

    public final void a0(byte[] arrby) {
        k.g(arrby, "<set-?>");
        this.i = arrby;
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN_ORDERED)
    public final void handlePopupClickedEvent(a0 a02) {
        k.g(a02, "event");
        this.h0();
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN_ORDERED)
    public final void handlePopupClickedEvent(z z2) {
        k.g(z2, "event");
        this.j0();
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN_ORDERED)
    public final void handleResponseRecordEvent(v v2) {
        k.g(v2, "event");
        int n2 = v2.a();
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return;
                    }
                    this.w(v2);
                    return;
                }
                this.y(v2);
                return;
            }
            this.x(v2);
            return;
        }
        this.z(v2);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        MainActivity mainActivity = (MainActivity)this.requireActivity();
        if (!mainActivity.Q2()) {
            mainActivity.I2();
            Toast.makeText((Context)this.requireContext(), (int)2131821336, (int)1).show();
            return;
        }
        androidx.fragment.app.d d2 = this.requireActivity();
        k.f((Object)d2, "requireActivity()");
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.n0);
        k.f((Object)view2, "toolbar");
        com.smp.musicspeed.k0.z.h((Activity)d2, (Toolbar)view2);
        this.D().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new n(this));
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        k.g((Object)menu, "menu");
        k.g((Object)menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(2131558401, menu);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.g((Object)layoutInflater, "inflater");
        View view = layoutInflater.inflate(2131492973, viewGroup, false);
        k.f((Object)view, "inflater.inflate(R.layout.fragment_recorder, container, false)");
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.B().v((Object)this);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        k.g((Object)menuItem, "item");
        if (menuItem.getItemId() == 2131296344) {
            this.v();
            return true;
        }
        return false;
    }

    public void onPause() {
        super.onPause();
        this.k0();
        this.j0();
    }

    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        k.g(arrstring, "permissions");
        k.g(arrn, "grantResults");
        super.onRequestPermissionsResult(n2, arrstring, arrn);
        y.b(this, n2, arrn);
    }

    public void onResume() {
        super.onResume();
        if (this.F() == 2) {
            this.i0();
        } else if (this.F() == 3) {
            View view = this.getView();
            View view2 = view == null ? null : view.findViewById(d0.r0);
            k.f((Object)view2, "wave");
            view2.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this){
                final /* synthetic */ x f;
                {
                    this.f = x2;
                }

                public void onLayoutChange(View view, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
                    k.g((Object)view, "view");
                    view.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
                    x.u(this.f);
                }
            });
        }
        if (this.getChildFragmentManager().j0("recorded") != null) {
            this.h0();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.g((Object)view, "view");
        super.onViewCreated(view, bundle);
        this.setHasOptionsMenu(true);
        this.B().r((Object)this);
        this.b0();
        this.c0();
    }

}

