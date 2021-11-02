/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.ImageButton
 *  android.widget.LinearLayout
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.widget.AppCompatSeekBar
 *  androidx.appcompat.widget.SwitchCompat
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.p
 *  androidx.lifecycle.x
 *  com.smp.musicspeed.MainActivity
 *  com.smp.musicspeed.i0.l
 *  com.smp.musicspeed.l0.n
 *  com.smp.musicspeed.l0.q
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.equalizer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.dbrecord.AppDatabaseKt;
import com.smp.musicspeed.dbrecord.PresetItem;
import com.smp.musicspeed.equalizer.EqualizerFragment;
import com.smp.musicspeed.equalizer.EqualizerModel;
import com.smp.musicspeed.equalizer.f;
import com.smp.musicspeed.equalizer.g;
import com.smp.musicspeed.equalizer.h;
import com.smp.musicspeed.equalizer.i;
import com.smp.musicspeed.equalizer.j;
import com.smp.musicspeed.equalizer.k;
import com.smp.musicspeed.equalizer.l;
import com.smp.musicspeed.equalizer.m;
import com.smp.musicspeed.l0.n;
import com.smp.musicspeed.l0.q;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.n;
import com.smp.musicspeed.utils.r;
import java.util.List;

public class EqualizerFragment
extends Fragment {
    private static int f = 1500;
    public static String[] g = new String[8];
    ImageButton A;
    ImageButton B;
    AppCompatSeekBar C;
    AppCompatSeekBar D;
    TextView E;
    TextView F;
    Button G;
    Button H;
    private long I = 0L;
    View h;
    View i;
    View j;
    SwitchCompat k;
    SwitchCompat l;
    SwitchCompat m;
    ImageButton n;
    ImageButton o;
    ImageButton p;
    ImageButton q;
    LinearLayout r;
    LinearLayout s;
    private e t;
    AppCompatSeekBar[] u = new AppCompatSeekBar[8];
    TextView[] v = new TextView[8];
    ImageButton[] w = new ImageButton[8];
    ImageButton[] x = new ImageButton[8];
    ImageButton y;
    ImageButton z;

    private /* synthetic */ void A(int n2, View view) {
        this.w(n2);
    }

    private /* synthetic */ void C(Boolean bl) {
        int n2;
        int n3;
        if (bl.booleanValue()) {
            n2 = 2131230955;
            n3 = 0;
        } else {
            n3 = 8;
            n2 = 2131230953;
        }
        this.s.setVisibility(n3);
        this.q.setImageResource(n2);
    }

    public static /* synthetic */ void F(EqualizerFragment equalizerFragment, r r2) {
        equalizerFragment.z(r2);
    }

    private /* synthetic */ void G(CompoundButton compoundButton, boolean bl) {
        this.e0();
        org.greenrobot.eventbus.c.d().m((Object)new m());
        if (compoundButton == this.k) {
            this.m0(bl);
            return;
        }
        if (compoundButton == this.l) {
            this.g0(bl);
            return;
        }
        this.i0(bl);
    }

    private /* synthetic */ void J(View view) {
        if (view == this.n) {
            this.c0();
        } else if (view == this.o) {
            this.a0();
        } else if (view == this.p) {
            this.b0();
        }
        this.e0();
        org.greenrobot.eventbus.c.d().m((Object)new m());
    }

    private /* synthetic */ void M(int n2, View view) {
        this.X((SeekBar)this.u[n2], 0.2f);
    }

    private /* synthetic */ void O(int n2, View view) {
        this.X((SeekBar)this.u[n2], -0.2f);
    }

    static /* synthetic */ void Q(View view) {
        EqualizerModel equalizerModel = EqualizerModel.k;
        equalizerModel.B(true ^ equalizerModel.z());
    }

    private /* synthetic */ void R(LiveData liveData, List list) {
        liveData.o(this.getViewLifecycleOwner());
        if (list.size() == 0) {
            Toast.makeText((Context)this.requireContext(), (CharSequence)this.getString(2131821326), (int)1).show();
            return;
        }
        com.smp.musicspeed.l0.n.w.a(2).M(this.requireActivity().R(), "LoadPresetDialogFragment");
    }

    private /* synthetic */ void T(View view) {
        if (SystemClock.elapsedRealtime() - this.I < 1000L) {
            return;
        }
        this.I = SystemClock.elapsedRealtime();
        LiveData<List<PresetItem>> liveData = AppDatabaseKt.getPresetsDao().getPresetItemsObservable(2);
        liveData.i(this.getViewLifecycleOwner(), (x)new com.smp.musicspeed.equalizer.b(this, liveData));
    }

    private /* synthetic */ void V(View view) {
        if (SystemClock.elapsedRealtime() - this.I < 1000L) {
            return;
        }
        this.I = SystemClock.elapsedRealtime();
        q.v.a(2).M(this.requireActivity().R(), "SavePresetDialogFragment");
    }

    private void X(SeekBar seekBar, float f2) {
        if (!seekBar.isEnabled()) {
            return;
        }
        int n2 = this.Y(f2 + this.v(seekBar.getProgress()));
        if (n2 > seekBar.getMax()) {
            n2 = seekBar.getMax();
        } else if (n2 < 0) {
            n2 = 0;
        }
        seekBar.setProgress(n2);
        this.e0();
        org.greenrobot.eventbus.c.d().m((Object)new m());
    }

    private int Y(float f2) {
        return Math.round((float)(f2 * 100.0f + (float)this.x()));
    }

    private void Z() {
        for (int i2 = 0; i2 < 8; ++i2) {
            this.u[i2].setOnSeekBarChangeListener(null);
        }
        this.m.setOnCheckedChangeListener(null);
        this.p.setOnClickListener(null);
        this.k.setOnCheckedChangeListener(null);
        this.C.setOnSeekBarChangeListener(null);
        this.n.setOnClickListener(null);
        this.l.setOnCheckedChangeListener(null);
        this.D.setOnSeekBarChangeListener(null);
        this.o.setOnClickListener(null);
    }

    private void a0() {
        this.D.setProgress(this.Y(0.0f));
    }

    private void b0() {
        for (int i2 = 0; i2 < 8; ++i2) {
            this.u[i2].setProgress(this.x());
        }
    }

    private void c0() {
        this.C.setProgress(this.Y(-3.0f));
    }

    private void d0() {
        androidx.fragment.app.d d2 = this.getActivity();
        if (d2 != null) {
            boolean bl = l.e((Context)d2);
            boolean bl2 = l.c((Context)d2);
            boolean bl3 = l.a((Context)d2);
            float[] arrf = l.d((Context)d2);
            float f2 = l.f((Context)d2);
            float f3 = l.b((Context)d2);
            this.m.setChecked(bl2);
            this.k.setChecked(bl);
            this.l.setChecked(bl3);
            this.i0(bl2);
            this.m0(bl);
            this.g0(bl3);
            for (int i2 = 0; i2 < 8; ++i2) {
                this.u[i2].setProgress(this.Y(arrf[i2]));
                this.v[i2].setText((CharSequence)n.d(arrf[i2]));
            }
            this.C.setProgress(this.Y(f2));
            this.D.setProgress(this.Y(f3));
            this.n0(f2);
            this.h0(f3);
        }
    }

    @SuppressLint(value={"SetTextI18n"})
    private void e0() {
        androidx.fragment.app.d d2 = this.getActivity();
        if (d2 != null) {
            float[] arrf = new float[8];
            for (int i2 = 0; i2 < 8; ++i2) {
                arrf[i2] = this.v(this.u[i2].getProgress());
                this.v[i2].setText((CharSequence)n.d(arrf[i2]));
            }
            boolean bl = this.m.isChecked();
            boolean bl2 = this.k.isChecked();
            float f2 = this.v(this.C.getProgress());
            this.n0(f2);
            boolean bl3 = this.l.isChecked();
            float f3 = this.v(this.D.getProgress());
            this.h0(f3);
            l.g((Context)d2, bl2, f2, bl, arrf, bl3, f3);
        }
    }

    private void g0(boolean bl) {
        this.D.setEnabled(bl);
    }

    private void h0(float f2) {
        if (this.D.getProgress() == 0) {
            this.F.setText((CharSequence)this.getActivity().getString(2131820942));
            return;
        }
        if (this.D.getProgress() == this.D.getMax()) {
            this.F.setText((CharSequence)this.getActivity().getString(2131820959));
            return;
        }
        this.F.setText((CharSequence)n.d(f2));
    }

    private void i0(boolean bl) {
        for (int i2 = 0; i2 < 8; ++i2) {
            this.u[i2].setEnabled(bl);
        }
    }

    private void k0() {
        this.t = new SeekBar.OnSeekBarChangeListener(){

            public void onProgressChanged(SeekBar seekBar, int n2, boolean bl) {
                if (bl) {
                    EqualizerFragment.this.e0();
                    org.greenrobot.eventbus.c.d().m((Object)new m());
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        };
        com.smp.musicspeed.equalizer.a a2 = new com.smp.musicspeed.equalizer.a(this);
        g g2 = new g(this);
        for (int i2 = 0; i2 < 8; ++i2) {
            this.u[i2].setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this.t);
            this.w[i2].setOnClickListener((View.OnClickListener)new i(this, i2));
            this.x[i2].setOnClickListener((View.OnClickListener)new com.smp.musicspeed.equalizer.d(this, i2));
        }
        this.m.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)a2);
        this.p.setOnClickListener((View.OnClickListener)g2);
        this.q.setOnClickListener((View.OnClickListener)com.smp.musicspeed.equalizer.e.f);
        this.k.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)a2);
        this.C.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this.t);
        this.n.setOnClickListener((View.OnClickListener)g2);
        this.y.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ EqualizerFragment f;
            {
                this.f = equalizerFragment;
            }

            public void onClick(View view) {
                EqualizerFragment equalizerFragment = this.f;
                EqualizerFragment.t(equalizerFragment, (SeekBar)equalizerFragment.C, 0.2f);
            }
        });
        this.z.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ EqualizerFragment f;
            {
                this.f = equalizerFragment;
            }

            public void onClick(View view) {
                EqualizerFragment equalizerFragment = this.f;
                EqualizerFragment.t(equalizerFragment, (SeekBar)equalizerFragment.C, -0.2f);
            }
        });
        this.A.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ EqualizerFragment f;
            {
                this.f = equalizerFragment;
            }

            public void onClick(View view) {
                EqualizerFragment equalizerFragment = this.f;
                EqualizerFragment.t(equalizerFragment, (SeekBar)equalizerFragment.D, 0.2f);
            }
        });
        this.B.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ EqualizerFragment f;
            {
                this.f = equalizerFragment;
            }

            public void onClick(View view) {
                EqualizerFragment equalizerFragment = this.f;
                EqualizerFragment.t(equalizerFragment, (SeekBar)equalizerFragment.D, -0.2f);
            }
        });
        this.l.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)a2);
        this.D.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this.t);
        this.o.setOnClickListener((View.OnClickListener)g2);
        this.G.setOnClickListener((View.OnClickListener)new f(this));
        this.H.setOnClickListener((View.OnClickListener)new j(this));
    }

    private void m0(boolean bl) {
        this.C.setEnabled(bl);
    }

    private void n0(float f2) {
        this.E.setText((CharSequence)n.d(f2));
    }

    private void o0(int n2) {
        if (MainActivity.F && this.getActivity() instanceof MainActivity) {
            com.smp.musicspeed.i0.l l2 = new com.smp.musicspeed.i0.l();
            Bundle bundle = new Bundle();
            bundle.putInt("com.smp.musicspeed.BUNDLE_ADJUSTMENT", n2);
            l2.setArguments(bundle);
            l2.M(this.requireActivity().R(), "Adjustment Fragment3");
        }
    }

    static /* synthetic */ void t(EqualizerFragment equalizerFragment, SeekBar seekBar, float f2) {
        equalizerFragment.X(seekBar, f2);
    }

    private float v(int n2) {
        return (float)(n2 - this.x()) / 100.0f;
    }

    private void w(int n2) {
        this.o0(n2 + 100);
    }

    private int x() {
        return f;
    }

    private void y() {
        int n2;
        if (this.getActivity() == null) {
            return;
        }
        boolean bl = AppPrefs.k.h0();
        for (int i2 = 0; i2 < (n2 = 8); ++i2) {
            ImageButton imageButton = this.w[i2];
            int n3 = bl ? 0 : 8;
            imageButton.setVisibility(n3);
            ImageButton imageButton2 = this.x[i2];
            if (bl) {
                n2 = 0;
            }
            imageButton2.setVisibility(n2);
        }
        ImageButton imageButton = this.y;
        int n4 = bl ? 0 : 8;
        imageButton.setVisibility(n4);
        ImageButton imageButton3 = this.z;
        int n5 = bl ? 0 : 8;
        imageButton3.setVisibility(n5);
        ImageButton imageButton4 = this.A;
        int n6 = bl ? 0 : 8;
        imageButton4.setVisibility(n6);
        ImageButton imageButton5 = this.B;
        int n7 = bl ? 0 : 8;
        imageButton5.setVisibility(n7);
    }

    private void z(r r2) {
        boolean bl = r2.n();
        boolean bl2 = r2.a();
        boolean bl3 = r2.e();
        if (bl) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
        if (bl2) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        if (bl3) {
            this.j.setVisibility(0);
            return;
        }
        this.j.setVisibility(8);
    }

    public /* synthetic */ void B(int n2, View view) {
        this.A(n2, view);
    }

    public /* synthetic */ void D(Boolean bl) {
        this.C(bl);
    }

    public /* synthetic */ void H(CompoundButton compoundButton, boolean bl) {
        this.G(compoundButton, bl);
    }

    public /* synthetic */ void K(View view) {
        this.J(view);
    }

    public /* synthetic */ void N(int n2, View view) {
        this.M(n2, view);
    }

    public /* synthetic */ void P(int n2, View view) {
        this.O(n2, view);
    }

    public /* synthetic */ void S(LiveData liveData, List list) {
        this.R(liveData, list);
    }

    public /* synthetic */ void U(View view) {
        this.T(view);
    }

    public /* synthetic */ void W(View view) {
        this.V(view);
    }

    public void f0(float f2) {
        this.D.setProgress(this.Y(f2));
        this.h0(f2);
        this.e0();
        org.greenrobot.eventbus.c.d().m((Object)new m());
    }

    public void j0(int n2, float f2) {
        this.u[n2].setProgress(this.Y(f2));
        this.v[n2].setText((CharSequence)n.d(f2));
        this.e0();
        org.greenrobot.eventbus.c.d().m((Object)new m());
    }

    public void l0(float f2) {
        this.C.setProgress(this.Y(f2));
        this.n0(f2);
        this.e0();
        org.greenrobot.eventbus.c.d().m((Object)new m());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2131492964, viewGroup, false);
        this.k = (SwitchCompat)view.findViewById(2131297167);
        this.C = (AppCompatSeekBar)view.findViewById(2131297104);
        this.n = (ImageButton)view.findViewById(2131296528);
        this.E = (TextView)view.findViewById(2131297037);
        this.n0(-3.0f);
        this.l = (SwitchCompat)view.findViewById(2131297164);
        this.D = (AppCompatSeekBar)view.findViewById(2131297101);
        this.o = (ImageButton)view.findViewById(2131296525);
        this.F = (TextView)view.findViewById(2131296439);
        this.h0(0.0f);
        this.m = (SwitchCompat)view.findViewById(2131297165);
        this.p = (ImageButton)view.findViewById(2131296526);
        this.q = (ImageButton)view.findViewById(2131296677);
        this.r = (LinearLayout)view.findViewById(2131296678);
        this.s = (LinearLayout)view.findViewById(2131296679);
        this.h = view.findViewById(2131296548);
        this.i = view.findViewById(2131296538);
        this.j = view.findViewById(2131296541);
        for (int i2 = 0; i2 < 8; ++i2) {
            LinearLayout linearLayout = (LinearLayout)this.r.getChildAt(i2);
            AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar)((ViewGroup)((ViewGroup)linearLayout.getChildAt(3)).getChildAt(0)).getChildAt(0);
            TextView textView = (TextView)linearLayout.getChildAt(0);
            this.w[i2] = (ImageButton)linearLayout.getChildAt(2);
            this.x[i2] = (ImageButton)linearLayout.getChildAt(4);
            this.v[i2] = textView;
            TextView textView2 = (TextView)linearLayout.getChildAt(5);
            EqualizerFragment.g[i2] = (String)textView2.getText();
            textView.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.equalizer.c(this, i2));
            this.u[i2] = appCompatSeekBar;
            appCompatSeekBar.setTag((Object)i2);
        }
        this.y = (ImageButton)view.findViewById(2131296514);
        this.z = (ImageButton)view.findViewById(2131296513);
        this.A = (ImageButton)view.findViewById(2131296479);
        this.B = (ImageButton)view.findViewById(2131296478);
        this.G = (Button)view.findViewById(2131296515);
        this.H = (Button)view.findViewById(2131296516);
        return view;
    }

    public void onPause() {
        this.Z();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.d0();
        this.k0();
        this.y();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.smp.musicspeed.utils.c.a.b().i(this.getViewLifecycleOwner(), (x)new h(this));
        EqualizerModel.k.A().i(this.getViewLifecycleOwner(), (x)new k(this));
    }

}

