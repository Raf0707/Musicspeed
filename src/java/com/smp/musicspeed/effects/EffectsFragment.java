/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.LayoutTransition
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
 *  android.widget.LinearLayout
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.Spinner
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatImageButton
 *  androidx.appcompat.widget.SwitchCompat
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  androidx.fragment.app.x
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.h0
 *  androidx.lifecycle.h0$b
 *  androidx.lifecycle.i0
 *  androidx.lifecycle.p
 *  androidx.lifecycle.x
 *  com.smp.musicspeed.MainActivity
 *  com.smp.musicspeed.effects.EffectsFragment$b
 *  com.smp.musicspeed.i0.l
 *  com.smp.musicspeed.l0.q
 *  f.u.g0
 *  f.u.l
 *  f.u.m0
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 */
package com.smp.musicspeed.effects;

import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.d0;
import com.smp.musicspeed.dbrecord.BeatStartRecord;
import com.smp.musicspeed.effects.EffectPrefModel;
import com.smp.musicspeed.effects.EffectsFragment;
import com.smp.musicspeed.effects.g;
import com.smp.musicspeed.effects.h;
import com.smp.musicspeed.effects.i;
import com.smp.musicspeed.effects.j;
import com.smp.musicspeed.effects.k;
import com.smp.musicspeed.effects.l;
import com.smp.musicspeed.effects.m;
import com.smp.musicspeed.effects.n;
import com.smp.musicspeed.effects.o;
import com.smp.musicspeed.effects.q;
import com.smp.musicspeed.effects.r;
import com.smp.musicspeed.effects.t;
import com.smp.musicspeed.effects.u;
import com.smp.musicspeed.effects.v;
import com.smp.musicspeed.effects.w;
import com.smp.musicspeed.l0.q;
import com.smp.musicspeed.utils.AppPrefs;
import f.p;
import f.u.g0;
import f.u.m0;
import f.z.d.x;
import f.z.d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

public final class EffectsFragment
extends Fragment
implements k0 {
    private final /* synthetic */ k0 f;
    private final f.f g = androidx.fragment.app.x.a((Fragment)this, (f.e0.b)z.b(v.class), (f.z.c.a)new f.z.c.a<i0>(){

        public final i0 a() {
            androidx.fragment.app.d d2 = this.requireActivity();
            f.z.d.k.f((Object)d2, "requireActivity()");
            i0 i02 = d2.getViewModelStore();
            f.z.d.k.f((Object)i02, "requireActivity().viewModelStore");
            return i02;
        }
    }, (f.z.c.a)new f.z.c.a<h0.b>(){

        public final h0.b a() {
            androidx.fragment.app.d d2 = this.requireActivity();
            f.z.d.k.f((Object)d2, "requireActivity()");
            return d2.getDefaultViewModelProviderFactory();
        }
    });
    private final f.f h = androidx.fragment.app.x.a((Fragment)this, (f.e0.b)z.b(com.smp.musicspeed.bpmkey.b.class), (f.z.c.a)new f.z.c.a<i0>(){

        public final i0 a() {
            androidx.fragment.app.d d2 = this.requireActivity();
            f.z.d.k.f((Object)d2, "requireActivity()");
            i0 i02 = d2.getViewModelStore();
            f.z.d.k.f((Object)i02, "requireActivity().viewModelStore");
            return i02;
        }
    }, (f.z.c.a)new f.z.c.a<h0.b>(){

        public final h0.b a() {
            androidx.fragment.app.d d2 = this.requireActivity();
            f.z.d.k.f((Object)d2, "requireActivity()");
            return d2.getDefaultViewModelProviderFactory();
        }
    });
    public Set<r> i;

    public EffectsFragment() {
        this.f = l0.b();
    }

    public static /* synthetic */ void A(EffectsFragment effectsFragment, Boolean bl) {
        EffectsFragment.g0(effectsFragment, bl);
    }

    public static /* synthetic */ void B(EffectsFragment effectsFragment, r r2, View view) {
        EffectsFragment.Z(effectsFragment, r2, view);
    }

    public static /* synthetic */ void C(r r2, EffectsFragment effectsFragment, q q2) {
        EffectsFragment.e0(r2, effectsFragment, q2);
    }

    public static /* synthetic */ void D(x x2, EffectsFragment effectsFragment, int n2, r r2, View view) {
        EffectsFragment.W(x2, effectsFragment, n2, r2, view);
    }

    public static /* synthetic */ void F(AppCompatImageButton appCompatImageButton, Boolean bl) {
        EffectsFragment.d0(appCompatImageButton, bl);
    }

    public static /* synthetic */ void G(x x2, EffectsFragment effectsFragment, r r2, View view) {
        EffectsFragment.X(x2, effectsFragment, r2, view);
    }

    public static /* synthetic */ void H(x x2, r r2, EffectsFragment effectsFragment, View view) {
        EffectsFragment.Y(x2, r2, effectsFragment, view);
    }

    public static /* synthetic */ void J(EffectsFragment effectsFragment, com.smp.musicspeed.utils.r r2) {
        EffectsFragment.h0(effectsFragment, r2);
    }

    public static /* synthetic */ void K(EffectsFragment effectsFragment, r r2, int n2, View view) {
        EffectsFragment.b0(effectsFragment, r2, n2, view);
    }

    public static /* synthetic */ void M(EffectsFragment effectsFragment, r r2, CompoundButton compoundButton, boolean bl) {
        EffectsFragment.T(effectsFragment, r2, compoundButton, bl);
    }

    public static /* synthetic */ void N(EffectsFragment effectsFragment, BeatStartRecord beatStartRecord) {
        EffectsFragment.f0(effectsFragment, beatStartRecord);
    }

    public static /* synthetic */ void O(EffectsFragment effectsFragment, r r2, int n2, View view) {
        EffectsFragment.a0(effectsFragment, r2, n2, view);
    }

    private final void P() {
        Object[] arrobject = new r[]{EffectsFragment.Q(this, 4), EffectsFragment.Q(this, 1), EffectsFragment.Q(this, 0), EffectsFragment.Q(this, 5), EffectsFragment.Q(this, 6), EffectsFragment.Q(this, 7), EffectsFragment.Q(this, 8)};
        this.R((Set<r>)m0.d((Object[])arrobject));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static final r Q(EffectsFragment var0, int var1_1) {
        block36 : {
            block34 : {
                block35 : {
                    if (var1_1 == 0) break block34;
                    if (var1_1 == 1) break block35;
                    switch (var1_1) {
                        default: {
                            throw new IllegalArgumentException();
                        }
                        case 8: {
                            var87_2 = var0.getView();
                            if (var87_2 != null) {
                                var3_3 = var87_2.findViewById(d0.F);
                                ** break;
                            }
                            ** GOTO lbl-1000
                        }
                        case 7: {
                            var86_4 = var0.getView();
                            if (var86_4 != null) {
                                var3_3 = var86_4.findViewById(d0.E);
                                ** break;
                            }
                            ** GOTO lbl-1000
                        }
                        case 6: {
                            var85_5 = var0.getView();
                            if (var85_5 != null) {
                                var3_3 = var85_5.findViewById(d0.H);
                                ** break;
                            }
                            ** GOTO lbl-1000
                        }
                        case 5: {
                            var84_6 = var0.getView();
                            if (var84_6 != null) {
                                var3_3 = var84_6.findViewById(d0.D);
                                ** break;
                            }
                            ** GOTO lbl-1000
                        }
                        case 4: {
                            var83_7 = var0.getView();
                            if (var83_7 != null) {
                                var3_3 = var83_7.findViewById(d0.J);
                                ** break;
                            }
                            ** GOTO lbl-1000
lbl36: // 5 sources:
                            break;
                        }
                    }
                    break block36;
                }
                var82_8 = var0.getView();
                if (var82_8 == null) ** GOTO lbl-1000
                var3_3 = var82_8.findViewById(d0.C);
                break block36;
            }
            var2_9 = var0.getView();
            if (var2_9 == null) lbl-1000: // 7 sources:
            {
                var3_3 = null;
            } else {
                var3_3 = var2_9.findViewById(d0.I);
            }
        }
        var4_10 = (EffectPrefModel)g0.h(u.a(), (Object)var1_1);
        var5_11 = var0.requireContext().getString(var4_10.I());
        f.z.d.k.f(var5_11, "requireContext().getString(effect.nameLabel)");
        var6_12 = (LinearLayout)var3_3.findViewById(2131296780);
        var7_13 = var0.w().j(var1_1).f();
        f.z.d.k.e(var7_13);
        var8_14 = ((q)var7_13).c().keySet();
        var9_15 = var0.w().j(var1_1).f();
        f.z.d.k.e(var9_15);
        var10_16 = ((q)var9_15).e().keySet();
        var11_17 = new ArrayList(f.u.l.j((Iterable)var8_14, (int)10));
        var12_18 = var8_14.iterator();
        var13_19 = null;
        while (var12_18.hasNext()) {
            var78_20 = ((Number)var12_18.next()).intValue();
            var79_21 = var0.getLayoutInflater().inflate(2131492990, null);
            var80_22 = var4_10.K();
            if (var80_22 != null && var78_20 == var80_22) {
                var13_19 = var79_21.findViewById(2131296532);
            }
            var11_17.add((Object)var79_21);
        }
        var14_23 = new ArrayList(f.u.l.j((Iterable)var10_16, (int)10));
        var15_24 = var10_16.iterator();
        while (var15_24.hasNext()) {
            ((Number)var15_24.next()).intValue();
            var14_23.add((Object)var0.getLayoutInflater().inflate(2131492991, null));
        }
        var16_25 = var11_17.iterator();
        while (var16_25.hasNext()) {
            var6_12.addView((View)var16_25.next());
        }
        var17_26 = var14_23.iterator();
        while (var17_26.hasNext()) {
            var6_12.addView((View)var17_26.next());
        }
        var6_12.addView(var0.getLayoutInflater().inflate(2131492996, null));
        var18_27 = new ArrayList(f.u.l.j((Iterable)var8_14, (int)10));
        var19_28 = var8_14.iterator();
        var20_29 = 0;
        while (var19_28.hasNext()) {
            var73_30 = var19_28.next();
            var74_31 = var20_29 + 1;
            if (var20_29 < 0) {
                f.u.l.i();
            }
            var18_27.add(p.a((int)((Number)var73_30).intValue(), ((View)var11_17.get(var20_29)).findViewById(2131297207)));
            var20_29 = var74_31;
        }
        var21_32 = g0.n((Iterable)var18_27);
        var22_33 = new ArrayList(f.u.l.j((Iterable)var8_14, (int)10));
        var23_34 = var8_14.iterator();
        var24_35 = 0;
        while (var23_34.hasNext()) {
            var70_36 = var23_34.next();
            var71_37 = var24_35 + 1;
            if (var24_35 < 0) {
                f.u.l.i();
            }
            var22_33.add(p.a((int)((Number)var70_36).intValue(), ((View)var11_17.get(var24_35)).findViewById(2131297208)));
            var24_35 = var71_37;
        }
        var25_38 = g0.n((Iterable)var22_33);
        var26_39 = new ArrayList(f.u.l.j((Iterable)var8_14, (int)10));
        var27_40 = var8_14.iterator();
        var28_41 = 0;
        while (var27_40.hasNext()) {
            var67_42 = var27_40.next();
            var68_43 = var28_41 + 1;
            if (var28_41 < 0) {
                f.u.l.i();
            }
            var26_39.add(p.a((int)((Number)var67_42).intValue(), ((View)var11_17.get(var28_41)).findViewById(2131297100)));
            var28_41 = var68_43;
        }
        var29_44 = g0.n((Iterable)var26_39);
        var30_45 = new ArrayList(f.u.l.j((Iterable)var10_16, (int)10));
        var31_46 = var10_16.iterator();
        var32_47 = 0;
        while (var31_46.hasNext()) {
            var64_48 = var31_46.next();
            var65_49 = var32_47 + 1;
            if (var32_47 < 0) {
                f.u.l.i();
            }
            var30_45.add(p.a((int)((Number)var64_48).intValue(), ((View)var14_23.get(var32_47)).findViewById(2131297207)));
            var32_47 = var65_49;
        }
        var33_50 = g0.n((Iterable)var30_45);
        var34_51 = new ArrayList(f.u.l.j((Iterable)var10_16, (int)10));
        var35_52 = var10_16.iterator();
        var36_53 = 0;
        while (var35_52.hasNext()) {
            var61_54 = var35_52.next();
            var62_55 = var36_53 + 1;
            if (var36_53 < 0) {
                f.u.l.i();
            }
            var34_51.add(p.a((int)((Number)var61_54).intValue(), ((View)var14_23.get(var36_53)).findViewById(2131297138)));
            var36_53 = var62_55;
        }
        var37_56 = g0.n((Iterable)var34_51);
        var38_57 = new ArrayList(f.u.l.j((Iterable)var8_14, (int)10));
        var39_58 = var8_14.iterator();
        var40_59 = 0;
        while (var39_58.hasNext()) {
            var58_60 = var39_58.next();
            var59_61 = var40_59 + 1;
            if (var40_59 < 0) {
                f.u.l.i();
            }
            var38_57.add(p.a((int)((Number)var58_60).intValue(), ((View)var11_17.get(var40_59)).findViewById(2131296509)));
            var40_59 = var59_61;
        }
        var41_62 = g0.n((Iterable)var38_57);
        var42_63 = new ArrayList(f.u.l.j((Iterable)var8_14, (int)10));
        var43_64 = var8_14.iterator();
        var44_65 = 0;
        do {
            if (!var43_64.hasNext()) {
                var45_68 = g0.n((Iterable)var42_63);
                var46_69 = (TextView)var3_3.findViewById(2131297213);
                var47_70 = (SwitchCompat)var3_3.findViewById(2131297166);
                var48_71 = (AppCompatImageButton)var3_3.findViewById(2131296524);
                var49_72 = (LinearLayout)var3_3.findViewById(2131296780);
                var50_73 = (Button)var3_3.findViewById(2131296515);
                var51_74 = (Button)var3_3.findViewById(2131296516);
                var52_75 = (AppCompatImageButton)var3_3.findViewById(2131296484);
                f.z.d.k.f((Object)var46_69, "findViewById(R.id.text_label)");
                f.z.d.k.f((Object)var47_70, "findViewById(R.id.switch_on)");
                f.z.d.k.f((Object)var48_71, "findViewById(R.id.button_reset)");
                f.z.d.k.f((Object)var52_75, "findViewById(R.id.button_expand)");
                f.z.d.k.f((Object)var50_73, "findViewById(R.id.button_preset_load)");
                f.z.d.k.f((Object)var51_74, "findViewById(R.id.button_preset_save)");
                var53_76 = (AppCompatImageButton)var13_19;
                f.z.d.k.f((Object)var49_72, "findViewById(R.id.layout_effect_controls)");
                return new r(var1_1, var5_11, var46_69, var47_70, (Map<Integer, ? extends AppCompatImageButton>)var41_62, (Map<Integer, ? extends AppCompatImageButton>)var45_68, var48_71, var52_75, var50_73, var51_74, var53_76, var49_72, (Map<Integer, ? extends TextView>)var21_32, (Map<Integer, ? extends TextView>)var25_38, (Map<Integer, ? extends SeekBar>)var29_44, (Map<Integer, ? extends TextView>)var33_50, (Map<Integer, ? extends Spinner>)var37_56);
            }
            var55_66 = var43_64.next();
            var56_67 = var44_65 + 1;
            if (var44_65 < 0) {
                f.u.l.i();
            }
            var42_63.add(p.a((int)((Number)var55_66).intValue(), ((View)var11_17.get(var44_65)).findViewById(2131296501)));
            var44_65 = var56_67;
        } while (true);
    }

    private final void S() {
        for (r r2 : this.v()) {
            r2.q().setText((CharSequence)r2.p());
            r2.j().setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new m(this, r2));
            r2.m().setOnClickListener((View.OnClickListener)new com.smp.musicspeed.effects.b(this, r2));
            r2.c().setOnClickListener((View.OnClickListener)new com.smp.musicspeed.effects.c(this, r2));
            for (Map.Entry entry : r2.f().entrySet()) {
                int n2 = ((Number)entry.getKey()).intValue();
                TextView textView = (TextView)entry.getValue();
                String string = this.getString(((Number)g0.h(this.w().g(r2.b()), (Object)n2)).intValue());
                f.z.d.k.f(string, "getString(effectsViewModel.getControlLabels(effectId).getValue(controlId))");
                textView.setText((CharSequence)string);
            }
            for (Map.Entry entry : r2.h().entrySet()) {
                int n3 = ((Number)entry.getKey()).intValue();
                ((TextView)entry.getValue()).setOnClickListener((View.OnClickListener)new g(new x(), this, n3, r2));
            }
            for (Map.Entry entry : r2.g().entrySet()) {
                int n4 = ((Number)entry.getKey()).intValue();
                ((SeekBar)entry.getValue()).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this, r2, n4){
                    final /* synthetic */ EffectsFragment a;
                    final /* synthetic */ r b;
                    final /* synthetic */ int c;
                    {
                        this.a = effectsFragment;
                        this.b = r2;
                        this.c = n2;
                    }

                    public void onProgressChanged(SeekBar seekBar, int n2, boolean bl) {
                        f.z.d.k.g((Object)seekBar, "seekBar");
                        if (bl) {
                            EffectsFragment.t(this.a).o(this.b.b(), this.c, (float)n2 / (float)seekBar.getMax());
                        }
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });
            }
            for (Map.Entry entry : r2.k().entrySet()) {
                int n5 = ((Number)entry.getKey()).intValue();
                TextView textView = (TextView)entry.getValue();
                String string = this.getString(((Number)g0.h(this.w().g(r2.b()), (Object)n5)).intValue());
                f.z.d.k.f(string, "getString(effectsViewModel.getControlLabels(effectId).getValue(controlId))");
                textView.setText((CharSequence)string);
            }
            for (Map.Entry entry : r2.l().entrySet()) {
                ((Number)entry.getKey()).intValue();
                (Spinner)entry.getValue();
            }
            x x2 = new x();
            r2.i().setOnClickListener((View.OnClickListener)new i(x2, this, r2));
            r2.n().setOnClickListener((View.OnClickListener)new j(x2, r2, this));
            AppCompatImageButton appCompatImageButton = r2.o();
            if (appCompatImageButton != null) {
                appCompatImageButton.setVisibility(0);
                appCompatImageButton.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.effects.e(this, r2));
            }
            for (Map.Entry entry : r2.e().entrySet()) {
                int n6 = ((Number)entry.getKey()).intValue();
                ((AppCompatImageButton)entry.getValue()).setOnClickListener((View.OnClickListener)new o(this, r2, n6));
            }
            for (Map.Entry entry : r2.d().entrySet()) {
                int n7 = ((Number)entry.getKey()).intValue();
                ((AppCompatImageButton)entry.getValue()).setOnClickListener((View.OnClickListener)new l(this, r2, n7));
            }
        }
    }

    private static final void T(EffectsFragment effectsFragment, r r2, CompoundButton compoundButton, boolean bl) {
        f.z.d.k.g((Object)effectsFragment, "this$0");
        f.z.d.k.g(r2, "$this_apply");
        effectsFragment.w().p(r2.b(), bl);
    }

    private static final void U(EffectsFragment effectsFragment, r r2, View view) {
        f.z.d.k.g((Object)effectsFragment, "this$0");
        f.z.d.k.g(r2, "$this_apply");
        effectsFragment.w().m(r2.b());
        if (r2.o() != null && AppPrefs.k.A()) {
            String string = effectsFragment.x().getFileName();
            if (string == null) {
                return;
            }
            effectsFragment.u().h(r2.b(), string);
        }
    }

    private static final void V(EffectsFragment effectsFragment, r r2, View view) {
        f.z.d.k.g((Object)effectsFragment, "this$0");
        f.z.d.k.g(r2, "$this_apply");
        effectsFragment.w().q(r2.b());
    }

    private static final void W(x x2, EffectsFragment effectsFragment, int n2, r r2, View view) {
        f.z.d.k.g(x2, "$lastTime");
        f.z.d.k.g((Object)effectsFragment, "this$0");
        f.z.d.k.g(r2, "$this_apply");
        if (SystemClock.elapsedRealtime() - x2.f < 1000L) {
            return;
        }
        x2.f = SystemClock.elapsedRealtime();
        com.smp.musicspeed.i0.l l2 = new com.smp.musicspeed.i0.l();
        Bundle bundle = new Bundle();
        bundle.putInt("controlId", n2);
        bundle.putInt("effectId", r2.b());
        l2.setArguments(bundle);
        l2.M(effectsFragment.requireActivity().R(), "adjustmentFragmentEffects");
    }

    private static final void X(x x2, EffectsFragment effectsFragment, r r2, View view) {
        f.z.d.k.g(x2, "$lastTime");
        f.z.d.k.g((Object)effectsFragment, "this$0");
        f.z.d.k.g(r2, "$this_apply");
        if (SystemClock.elapsedRealtime() - x2.f < 1000L) {
            return;
        }
        x2.f = SystemClock.elapsedRealtime();
        kotlinx.coroutines.e.d((k0)effectsFragment, null, null, (f.z.c.p)new b(r2, effectsFragment, null), (int)3, null);
    }

    private static final void Y(x x2, r r2, EffectsFragment effectsFragment, View view) {
        f.z.d.k.g(x2, "$lastTime");
        f.z.d.k.g(r2, "$this_apply");
        f.z.d.k.g((Object)effectsFragment, "this$0");
        if (SystemClock.elapsedRealtime() - x2.f < 1000L) {
            return;
        }
        x2.f = SystemClock.elapsedRealtime();
        com.smp.musicspeed.l0.q.v.a(r2.b()).M(effectsFragment.requireActivity().R(), "SavePresetDialogFragment");
    }

    private static final void Z(EffectsFragment effectsFragment, r r2, View view) {
        f.z.d.k.g((Object)effectsFragment, "this$0");
        f.z.d.k.g(r2, "$this_apply");
        String string = effectsFragment.x().getFileName();
        if (string == null) {
            return;
        }
        effectsFragment.u().h(r2.b(), string);
    }

    private static final void a0(EffectsFragment effectsFragment, r r2, int n2, View view) {
        f.z.d.k.g((Object)effectsFragment, "this$0");
        f.z.d.k.g(r2, "$this_apply");
        effectsFragment.w().l(r2.b(), n2, 1);
    }

    private static final void b0(EffectsFragment effectsFragment, r r2, int n2, View view) {
        f.z.d.k.g((Object)effectsFragment, "this$0");
        f.z.d.k.g(r2, "$this_apply");
        effectsFragment.w().l(r2.b(), n2, -1);
    }

    private final void c0() {
        com.smp.musicspeed.utils.c.a.b().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new k(this));
        for (r r2 : this.v()) {
            this.w().j(r2.b()).i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new com.smp.musicspeed.effects.f(r2, this));
            AppCompatImageButton appCompatImageButton = r2.o();
            if (appCompatImageButton == null) continue;
            ((LiveData)g0.h(this.u().g(), (Object)r2.b())).i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new h(appCompatImageButton));
        }
        com.smp.musicspeed.bpmkey.a a2 = com.smp.musicspeed.bpmkey.a.f;
        a2.d().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new n(this));
        a2.g().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new com.smp.musicspeed.effects.d(this));
    }

    private static final void d0(AppCompatImageButton appCompatImageButton, Boolean bl) {
        f.z.d.k.g((Object)appCompatImageButton, "$button");
        f.z.d.k.f((Object)bl, "syncing");
        t.a((View)appCompatImageButton, bl);
    }

    private static final void e0(r r2, EffectsFragment effectsFragment, q q2) {
        f.z.d.k.g(r2, "$effect");
        f.z.d.k.g((Object)effectsFragment, "this$0");
        for (Map.Entry entry : r2.h().entrySet()) {
            int n2 = ((Number)entry.getKey()).intValue();
            TextView textView = (TextView)entry.getValue();
            Context context = effectsFragment.requireContext();
            f.z.d.k.f((Object)context, "requireContext()");
            textView.setText((CharSequence)q2.b(context, n2));
        }
        for (Map.Entry entry : r2.g().entrySet()) {
            boolean bl;
            Object object;
            Object object2;
            int n3 = ((Number)entry.getKey()).intValue();
            SeekBar seekBar = (SeekBar)entry.getValue();
            seekBar.setEnabled(q2.d());
            float f2 = ((Number)g0.h(q2.f(), (Object)n3)).floatValue();
            List<Float> list = ((w)g0.h(q2.g(), (Object)n3)).a();
            float f3 = (float)seekBar.getProgress() / (float)seekBar.getMax();
            float f4 = ((Number)g0.h(q2.c(), (Object)n3)).floatValue();
            float f5 = effectsFragment.w().f(r2.b(), n3, f3);
            Iterator iterator = list.iterator();
            if (!iterator.hasNext()) {
                object2 = null;
            } else {
                object2 = iterator.next();
                if (iterator.hasNext()) {
                    float f6 = Math.abs((float)(f4 - ((Number)object2).floatValue()));
                    do {
                        float f7;
                        Object object3;
                        if (Float.compare((float)f6, (float)(f7 = Math.abs((float)(f4 - ((Number)(object3 = iterator.next())).floatValue())))) <= 0) continue;
                        object2 = object3;
                        f6 = f7;
                    } while (iterator.hasNext());
                }
            }
            Float f8 = (Float)object2;
            if (f8 != null) {
                f4 = f8.floatValue();
            }
            float f9 = f4;
            Iterator iterator2 = list.iterator();
            if (!iterator2.hasNext()) {
                object = null;
            } else {
                object = iterator2.next();
                if (iterator2.hasNext()) {
                    float f10 = Math.abs((float)(f5 - ((Number)object).floatValue()));
                    do {
                        float f11;
                        Object object4;
                        if (Float.compare((float)f10, (float)(f11 = Math.abs((float)(f5 - ((Number)(object4 = iterator2.next())).floatValue())))) <= 0) continue;
                        object = object4;
                        f10 = f11;
                    } while (iterator2.hasNext());
                }
            }
            Float f12 = (Float)object;
            if (f12 != null) {
                f5 = f12.floatValue();
            }
            if (bl = f9 == f5) continue;
            seekBar.setProgress((int)(f2 * (float)seekBar.getMax()));
        }
        r2.j().setChecked(q2.d());
        if (r2.a().getVisibility() != EffectsFragment.i0(q2.a())) {
            r2.a().setVisibility(EffectsFragment.i0(q2.a()));
            int n4 = q2.a() ? 2131230955 : 2131230953;
            r2.c().setImageResource(n4);
        }
    }

    private static final void f0(EffectsFragment effectsFragment, BeatStartRecord beatStartRecord) {
        f.z.d.k.g((Object)effectsFragment, "this$0");
        if (beatStartRecord != null && f.z.d.k.c(effectsFragment.x().getFileName(), beatStartRecord.filename) && AppPrefs.k.A()) {
            Set<r> set = effectsFragment.v();
            ArrayList arrayList = new ArrayList();
            for (Object object : set) {
                boolean bl = ((r)object).o() != null;
                if (!bl) continue;
                arrayList.add(object);
            }
            for (r r2 : arrayList) {
                v v2 = effectsFragment.w();
                int n2 = r2.b();
                Integer n3 = ((EffectPrefModel)((Object)g0.h(u.a(), (Object)r2.b()))).K();
                f.z.d.k.e((Object)n3);
                v2.n(n2, n3, beatStartRecord.bpmoriginal);
            }
        }
    }

    private static final void g0(EffectsFragment effectsFragment, Boolean bl) {
        f.z.d.k.g((Object)effectsFragment, "this$0");
        f.z.d.k.f((Object)bl, "syncing");
        if (bl.booleanValue() && !AppPrefs.k.A()) {
            return;
        }
        Set<r> set = effectsFragment.v();
        ArrayList arrayList = new ArrayList();
        for (Object object : set) {
            boolean bl2 = ((r)object).o() != null;
            if (!bl2) continue;
            arrayList.add(object);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            AppCompatImageButton appCompatImageButton = ((r)iterator.next()).o();
            f.z.d.k.e((Object)appCompatImageButton);
            t.a((View)appCompatImageButton, bl);
        }
    }

    private static final void h0(EffectsFragment effectsFragment, com.smp.musicspeed.utils.r r2) {
        f.z.d.k.g((Object)effectsFragment, "this$0");
        View view = effectsFragment.getView();
        View view2 = view == null ? null : view.findViewById(d0.I);
        view2.setVisibility(EffectsFragment.i0(r2.o()));
        View view3 = effectsFragment.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.C);
        view4.setVisibility(EffectsFragment.i0(r2.c()));
        View view5 = effectsFragment.getView();
        View view6 = view5 == null ? null : view5.findViewById(d0.J);
        view6.setVisibility(EffectsFragment.i0(r2.p()));
        View view7 = effectsFragment.getView();
        View view8 = view7 == null ? null : view7.findViewById(d0.D);
        view8.setVisibility(EffectsFragment.i0(r2.d()));
        View view9 = effectsFragment.getView();
        View view10 = view9 == null ? null : view9.findViewById(d0.H);
        view10.setVisibility(EffectsFragment.i0(r2.k()));
        View view11 = effectsFragment.getView();
        View view12 = view11 == null ? null : view11.findViewById(d0.F);
        view12.setVisibility(EffectsFragment.i0(r2.h()));
        View view13 = effectsFragment.getView();
        View view14 = view13 == null ? null : view13.findViewById(d0.E);
        view14.setVisibility(EffectsFragment.i0(r2.f()));
        for (r r3 : effectsFragment.v()) {
            Iterator iterator = r3.e().values().iterator();
            while (iterator.hasNext()) {
                ((AppCompatImageButton)iterator.next()).setVisibility(EffectsFragment.i0(r2.m()));
            }
            Iterator iterator2 = r3.d().values().iterator();
            while (iterator2.hasNext()) {
                ((AppCompatImageButton)iterator2.next()).setVisibility(EffectsFragment.i0(r2.m()));
            }
        }
    }

    private static final int i0(boolean bl) {
        if (bl) {
            return 0;
        }
        return 8;
    }

    public static final /* synthetic */ v t(EffectsFragment effectsFragment) {
        return effectsFragment.w();
    }

    private final com.smp.musicspeed.bpmkey.b u() {
        return (com.smp.musicspeed.bpmkey.b)((Object)this.h.getValue());
    }

    private final v w() {
        return (v)((Object)this.g.getValue());
    }

    private final MainActivity x() {
        return (MainActivity)this.requireActivity();
    }

    public static /* synthetic */ void y(EffectsFragment effectsFragment, r r2, View view) {
        EffectsFragment.U(effectsFragment, r2, view);
    }

    public static /* synthetic */ void z(EffectsFragment effectsFragment, r r2, View view) {
        EffectsFragment.V(effectsFragment, r2, view);
    }

    public f.w.g L() {
        return this.f.L();
    }

    public final void R(Set<r> set) {
        f.z.d.k.g(set, "<set-?>");
        this.i = set;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.z.d.k.g((Object)layoutInflater, "inflater");
        return layoutInflater.inflate(2131492963, viewGroup, false);
    }

    public void onDestroyView() {
        super.onDestroyView();
        l0.d((k0)this, null, (int)1, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        f.z.d.k.g((Object)view, "view");
        super.onViewCreated(view, bundle);
        this.P();
        this.c0();
        this.S();
        View view2 = this.getView();
        View view3 = view2 == null ? null : view2.findViewById(d0.T);
        ((LinearLayout)view3).getLayoutTransition().enableTransitionType(4);
    }

    public final Set<r> v() {
        Set<r> set = this.i;
        if (set != null) {
            return set;
        }
        f.z.d.k.s("effectViews");
        throw null;
    }

}

