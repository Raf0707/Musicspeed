/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.fragment.app.Fragment
 *  androidx.lifecycle.p
 *  androidx.lifecycle.w
 *  androidx.lifecycle.x
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.sleep_timer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.p;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shawnlin.numberpicker.NumberPicker;
import com.smp.musicspeed.d0;
import com.smp.musicspeed.sleep_timer.a;
import com.smp.musicspeed.sleep_timer.b;
import com.smp.musicspeed.sleep_timer.c;
import com.smp.musicspeed.sleep_timer.d;
import com.smp.musicspeed.sleep_timer.e;
import com.smp.musicspeed.sleep_timer.f;
import com.smp.musicspeed.sleep_timer.g;
import com.smp.musicspeed.sleep_timer.h;
import com.smp.musicspeed.sleep_timer.i;
import com.smp.musicspeed.utils.t;
import f.z.d.k;

public final class SleepTimerFragment
extends Fragment {
    public static /* synthetic */ void A(SleepTimerFragment sleepTimerFragment, Boolean bl) {
        SleepTimerFragment.H(sleepTimerFragment, bl);
    }

    private final void B() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.P);
        ((FloatingActionButton)view2).setOnClickListener((View.OnClickListener)new b(this));
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.o);
        ((ImageButton)view4).setOnClickListener((View.OnClickListener)new d(this));
        View view5 = this.getView();
        View view6 = view5 == null ? null : view5.findViewById(d0.y);
        ((ImageButton)view6).setOnClickListener((View.OnClickListener)new c(this));
    }

    private static final void C(SleepTimerFragment sleepTimerFragment, View view) {
        String string;
        k.g((Object)sleepTimerFragment, "this$0");
        long l2 = sleepTimerFragment.u();
        if (l2 != 0L) {
            g.a a2 = g.a;
            Context context = sleepTimerFragment.requireContext();
            k.f((Object)context, "requireContext()");
            ((g)a2.a(context)).i(l2);
            Object[] arrobject = new Object[]{t.r(l2)};
            string = sleepTimerFragment.getString(2131821359, arrobject);
        } else {
            string = sleepTimerFragment.getString(2131821364);
        }
        k.f(string, "if (totalMs != 0L) {\n                SleepTimer.getInstance(requireContext()).start(totalMs)\n                getString(R.string.toast_start_sleep_timer,\n                        getReadableDurationStringHoursMinutes(totalMs))\n            } else {\n                getString(R.string.toast_zero_sleep_timer)\n            }");
        Toast.makeText((Context)sleepTimerFragment.requireContext(), (CharSequence)string, (int)1).show();
    }

    private static final void D(SleepTimerFragment sleepTimerFragment, View view) {
        k.g((Object)sleepTimerFragment, "this$0");
        g.a a2 = g.a;
        Context context = sleepTimerFragment.requireContext();
        k.f((Object)context, "requireContext()");
        ((g)a2.a(context)).j();
    }

    private static final void F(SleepTimerFragment sleepTimerFragment, View view) {
        k.g((Object)sleepTimerFragment, "this$0");
        g.a a2 = g.a;
        Context context = sleepTimerFragment.requireContext();
        k.f((Object)context, "requireContext()");
        ((g)a2.a(context)).b(h.b(2));
    }

    private final void G() {
        g.a a2 = g.a;
        Context context = this.requireContext();
        k.f((Object)context, "requireContext()");
        g g2 = (g)a2.a(context);
        g2.e().i(this.getViewLifecycleOwner(), (x)new f(this));
        g2.d().i(this.getViewLifecycleOwner(), (x)new a(this));
    }

    private static final void H(SleepTimerFragment sleepTimerFragment, Boolean bl) {
        k.g((Object)sleepTimerFragment, "this$0");
        k.f((Object)bl, "isRunning");
        if (bl.booleanValue()) {
            View view = sleepTimerFragment.getView();
            View view2 = view == null ? null : view.findViewById(d0.j0);
            ((TextView)view2).setVisibility(0);
            View view3 = sleepTimerFragment.getView();
            View view4 = view3 == null ? null : view3.findViewById(d0.o);
            ((ImageButton)view4).setVisibility(0);
            View view5 = sleepTimerFragment.getView();
            View view6 = view5 == null ? null : view5.findViewById(d0.y);
            ((ImageButton)view6).setVisibility(0);
            return;
        }
        View view = sleepTimerFragment.getView();
        View view7 = view == null ? null : view.findViewById(d0.j0);
        ((TextView)view7).setVisibility(4);
        View view8 = sleepTimerFragment.getView();
        View view9 = view8 == null ? null : view8.findViewById(d0.o);
        ((ImageButton)view9).setVisibility(8);
        View view10 = sleepTimerFragment.getView();
        View view11 = view10 == null ? null : view10.findViewById(d0.y);
        ((ImageButton)view11).setVisibility(8);
    }

    private static final void J(SleepTimerFragment sleepTimerFragment, Long l2) {
        k.g((Object)sleepTimerFragment, "this$0");
        k.f((Object)l2, "timeRemaining");
        if (l2 <= 0L) {
            l2 = 0L;
        }
        View view = sleepTimerFragment.getView();
        View view2 = view == null ? null : view.findViewById(d0.j0);
        ((TextView)view2).setText((CharSequence)t.q(l2));
    }

    private final void K() {
        long l2 = t.o(this.requireContext()).getLong("com.smp.musicspeed.PREF_TIMER", this.t());
        i i2 = i.a.a(l2);
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.a0);
        ((NumberPicker)view2).setValue(i2.a());
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.b0);
        ((NumberPicker)view4).setValue(i2.b());
        e e2 = new e(this);
        View view5 = this.getView();
        View view6 = view5 == null ? null : view5.findViewById(d0.a0);
        ((NumberPicker)view6).setOnValueChangedListener(e2);
        View view7 = this.getView();
        View view8 = view7 == null ? null : view7.findViewById(d0.b0);
        ((NumberPicker)view8).setOnValueChangedListener(e2);
    }

    private static final void M(SleepTimerFragment sleepTimerFragment, NumberPicker numberPicker, int n2, int n3) {
        k.g((Object)sleepTimerFragment, "this$0");
        t.p(sleepTimerFragment.requireContext()).putLong("com.smp.musicspeed.PREF_TIMER", sleepTimerFragment.u()).apply();
    }

    public static /* synthetic */ void v(SleepTimerFragment sleepTimerFragment, Long l2) {
        SleepTimerFragment.J(sleepTimerFragment, l2);
    }

    public static /* synthetic */ void w(SleepTimerFragment sleepTimerFragment, View view) {
        SleepTimerFragment.C(sleepTimerFragment, view);
    }

    public static /* synthetic */ void x(SleepTimerFragment sleepTimerFragment, View view) {
        SleepTimerFragment.F(sleepTimerFragment, view);
    }

    public static /* synthetic */ void y(SleepTimerFragment sleepTimerFragment, View view) {
        SleepTimerFragment.D(sleepTimerFragment, view);
    }

    public static /* synthetic */ void z(SleepTimerFragment sleepTimerFragment, NumberPicker numberPicker, int n2, int n3) {
        SleepTimerFragment.M(sleepTimerFragment, numberPicker, n2, n3);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.g((Object)layoutInflater, "inflater");
        return layoutInflater.inflate(2131492977, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.g((Object)view, "view");
        super.onViewCreated(view, bundle);
        this.B();
        this.G();
        this.K();
    }

    public final long t() {
        return new i(0, 20).c();
    }

    public final long u() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.a0);
        int n2 = ((NumberPicker)view2).getValue();
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.b0);
        return new i(n2, ((NumberPicker)view4).getValue()).c();
    }
}

