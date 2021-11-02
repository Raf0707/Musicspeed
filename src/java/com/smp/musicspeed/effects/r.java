/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.SeekBar
 *  android.widget.Spinner
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatImageButton
 *  androidx.appcompat.widget.SwitchCompat
 *  f.z.d.k
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package com.smp.musicspeed.effects;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.SwitchCompat;
import f.z.d.k;
import java.util.Map;

public final class r {
    private final int a;
    private final String b;
    private final TextView c;
    private final SwitchCompat d;
    private final Map<Integer, AppCompatImageButton> e;
    private final Map<Integer, AppCompatImageButton> f;
    private final AppCompatImageButton g;
    private final AppCompatImageButton h;
    private final Button i;
    private final Button j;
    private final AppCompatImageButton k;
    private final LinearLayout l;
    private final Map<Integer, TextView> m;
    private final Map<Integer, TextView> n;
    private final Map<Integer, SeekBar> o;
    private final Map<Integer, TextView> p;
    private final Map<Integer, Spinner> q;

    public r(int n2, String string, TextView textView, SwitchCompat switchCompat, Map<Integer, ? extends AppCompatImageButton> map, Map<Integer, ? extends AppCompatImageButton> map2, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, Button button, Button button2, AppCompatImageButton appCompatImageButton3, LinearLayout linearLayout, Map<Integer, ? extends TextView> map3, Map<Integer, ? extends TextView> map4, Map<Integer, ? extends SeekBar> map5, Map<Integer, ? extends TextView> map6, Map<Integer, ? extends Spinner> map7) {
        k.g((Object)string, (String)"title");
        k.g((Object)textView, (String)"titleView");
        k.g((Object)switchCompat, (String)"onSwitch");
        k.g(map, (String)"incrementPlus");
        k.g(map2, (String)"incrementMinus");
        k.g((Object)appCompatImageButton, (String)"resetButton");
        k.g((Object)appCompatImageButton2, (String)"expandButton");
        k.g((Object)button, (String)"loadPresetButton");
        k.g((Object)button2, (String)"savePresetButton");
        k.g((Object)linearLayout, (String)"controlsLayout");
        k.g(map3, (String)"levelLabels");
        k.g(map4, (String)"levelValues");
        k.g(map5, (String)"levelSeekbars");
        k.g(map6, (String)"optionLabels");
        k.g(map7, (String)"optionSpinners");
        this.a = n2;
        this.b = string;
        this.c = textView;
        this.d = switchCompat;
        this.e = map;
        this.f = map2;
        this.g = appCompatImageButton;
        this.h = appCompatImageButton2;
        this.i = button;
        this.j = button2;
        this.k = appCompatImageButton3;
        this.l = linearLayout;
        this.m = map3;
        this.n = map4;
        this.o = map5;
        this.p = map6;
        this.q = map7;
    }

    public final LinearLayout a() {
        return this.l;
    }

    public final int b() {
        return this.a;
    }

    public final AppCompatImageButton c() {
        return this.h;
    }

    public final Map<Integer, AppCompatImageButton> d() {
        return this.f;
    }

    public final Map<Integer, AppCompatImageButton> e() {
        return this.e;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof r)) {
            return false;
        }
        r r2 = (r)object;
        if (this.a != r2.a) {
            return false;
        }
        if (!k.c((Object)this.b, (Object)r2.b)) {
            return false;
        }
        if (!k.c((Object)this.c, (Object)r2.c)) {
            return false;
        }
        if (!k.c((Object)this.d, (Object)r2.d)) {
            return false;
        }
        if (!k.c(this.e, r2.e)) {
            return false;
        }
        if (!k.c(this.f, r2.f)) {
            return false;
        }
        if (!k.c((Object)this.g, (Object)r2.g)) {
            return false;
        }
        if (!k.c((Object)this.h, (Object)r2.h)) {
            return false;
        }
        if (!k.c((Object)this.i, (Object)r2.i)) {
            return false;
        }
        if (!k.c((Object)this.j, (Object)r2.j)) {
            return false;
        }
        if (!k.c((Object)this.k, (Object)r2.k)) {
            return false;
        }
        if (!k.c((Object)this.l, (Object)r2.l)) {
            return false;
        }
        if (!k.c(this.m, r2.m)) {
            return false;
        }
        if (!k.c(this.n, r2.n)) {
            return false;
        }
        if (!k.c(this.o, r2.o)) {
            return false;
        }
        if (!k.c(this.p, r2.p)) {
            return false;
        }
        return k.c(this.q, r2.q);
    }

    public final Map<Integer, TextView> f() {
        return this.m;
    }

    public final Map<Integer, SeekBar> g() {
        return this.o;
    }

    public final Map<Integer, TextView> h() {
        return this.n;
    }

    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * this.a + this.b.hashCode()) + this.c.hashCode()) + this.d.hashCode()) + this.e.hashCode()) + this.f.hashCode()) + this.g.hashCode()) + this.h.hashCode()) + this.i.hashCode()) + this.j.hashCode());
        AppCompatImageButton appCompatImageButton = this.k;
        int n3 = appCompatImageButton == null ? 0 : appCompatImageButton.hashCode();
        return 31 * (31 * (31 * (31 * (31 * (31 * (n2 + n3) + this.l.hashCode()) + this.m.hashCode()) + this.n.hashCode()) + this.o.hashCode()) + this.p.hashCode()) + this.q.hashCode();
    }

    public final Button i() {
        return this.i;
    }

    public final SwitchCompat j() {
        return this.d;
    }

    public final Map<Integer, TextView> k() {
        return this.p;
    }

    public final Map<Integer, Spinner> l() {
        return this.q;
    }

    public final AppCompatImageButton m() {
        return this.g;
    }

    public final Button n() {
        return this.j;
    }

    public final AppCompatImageButton o() {
        return this.k;
    }

    public final String p() {
        return this.b;
    }

    public final TextView q() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EffectView(effectId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", title=");
        stringBuilder.append(this.b);
        stringBuilder.append(", titleView=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", onSwitch=");
        stringBuilder.append((Object)this.d);
        stringBuilder.append(", incrementPlus=");
        stringBuilder.append(this.e);
        stringBuilder.append(", incrementMinus=");
        stringBuilder.append(this.f);
        stringBuilder.append(", resetButton=");
        stringBuilder.append((Object)this.g);
        stringBuilder.append(", expandButton=");
        stringBuilder.append((Object)this.h);
        stringBuilder.append(", loadPresetButton=");
        stringBuilder.append((Object)this.i);
        stringBuilder.append(", savePresetButton=");
        stringBuilder.append((Object)this.j);
        stringBuilder.append(", syncButton=");
        stringBuilder.append((Object)this.k);
        stringBuilder.append(", controlsLayout=");
        stringBuilder.append((Object)this.l);
        stringBuilder.append(", levelLabels=");
        stringBuilder.append(this.m);
        stringBuilder.append(", levelValues=");
        stringBuilder.append(this.n);
        stringBuilder.append(", levelSeekbars=");
        stringBuilder.append(this.o);
        stringBuilder.append(", optionLabels=");
        stringBuilder.append(this.p);
        stringBuilder.append(", optionSpinners=");
        stringBuilder.append(this.q);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

