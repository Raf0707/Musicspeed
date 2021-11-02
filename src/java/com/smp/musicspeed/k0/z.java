/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.widget.Toolbar
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  c.i.c.r.b
 *  c.i.c.r.g
 *  c.i.c.r.h
 *  c.i.c.r.i.a
 *  com.google.android.material.snackbar.Snackbar
 *  com.mikepenz.google_material_typeface_library.GoogleMaterial
 *  com.mikepenz.google_material_typeface_library.GoogleMaterial$a
 *  com.smp.musicspeed.MainActivity
 *  com.smp.musicspeed.folders.v
 *  com.smp.musicspeed.k0.k
 *  com.smp.musicspeed.k0.x
 *  com.smp.musicspeed.k0.z$a
 *  com.smp.musicspeed.recorder.x
 *  com.smp.musicspeed.utils.AppPrefs
 *  f.u.l
 *  f.z.d.k
 *  f.z.d.y
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 */
package com.smp.musicspeed.k0;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c.i.c.b;
import c.i.c.c;
import c.i.c.r.g;
import c.i.c.r.h;
import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.dbrecord.WaveformRecord;
import com.smp.musicspeed.folders.v;
import com.smp.musicspeed.k0.k;
import com.smp.musicspeed.k0.x;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.t;
import f.u.l;
import f.z.d.y;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class z {
    public static final /* synthetic */ long a(Activity activity) {
        return z.i(activity);
    }

    public static final boolean b() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static final boolean c() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static final boolean d() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static /* synthetic */ boolean e(Activity activity, MainActivity mainActivity, View view, int n2, c.i.c.r.i.a a2) {
        return z.j(activity, mainActivity, view, n2, a2);
    }

    public static final List<WaveformRecord> f(Context context, List<? extends WaveformRecord> list) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g(list, (String)"old");
        ArrayList arrayList = new ArrayList();
        for (Object object : list) {
            boolean bl = ((WaveformRecord)object).timestamp < System.currentTimeMillis() - (long)432000000;
            if (bl) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final void g(Snackbar snackbar, int n2) {
        f.z.d.k.g((Object)snackbar, (String)"snackbar");
        View view = snackbar.E().findViewById(2131297133);
        Objects.requireNonNull((Object)view, (String)"null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view).setTextColor(n2);
    }

    public static final void h(Activity activity, Toolbar toolbar) {
        f.z.d.k.g((Object)activity, (String)"activity");
        f.z.d.k.g((Object)toolbar, (String)"toolbar");
        boolean bl = t.w((Context)activity);
        h h2 = (h)((h)((h)new h().j(1L)).R(2131820632)).P((c.i.b.b.a)GoogleMaterial.a.X7);
        h h3 = (h)((h)((h)new h().j(2L)).R(2131820625)).P((c.i.b.b.a)GoogleMaterial.a.z5);
        h h4 = (h)((h)((h)new h().j(3L)).R(2131820621)).P((c.i.b.b.a)GoogleMaterial.a.m7);
        h h5 = (h)((h)new h().j(4L)).R(2131820642);
        int n2 = bl ? 2131231143 : 2131231144;
        h h6 = (h)h5.O(n2);
        h h7 = (h)((h)new h().j(5L)).R(2131820616);
        int n3 = bl ? 2131230821 : 2131230822;
        h h8 = (h)h7.O(n3);
        h h9 = (h)((h)new h().j(6L)).R(2131820643);
        int n4 = bl ? 2131230998 : 2131230999;
        h h10 = (h)h9.O(n4);
        h h11 = (h)((h)((h)new h().j(7L)).R(2131820600)).P((c.i.b.b.a)GoogleMaterial.a.h7);
        h h12 = (h)((h)((h)new h().j(8L)).R(2131820653)).P((c.i.b.b.a)GoogleMaterial.a.id);
        h h13 = (h)((h)((h)new h().j(9L)).R(2131820629)).P((c.i.b.b.a)GoogleMaterial.a.N6);
        MainActivity mainActivity = (MainActivity)activity;
        Object[] arrobject = new c.i.c.r.b[]{h2, h3, h4, h6, h8, new g(), h10, h11, h12, h13};
        Object[] arrobject2 = new c.i.c.r.b[]{h2, h3, h4, h6, h8, new g(), h11, h12, h13};
        y y2 = new y();
        c c2 = new c().n(activity).r(2131492952).u(z.i(activity)).t((b.c)new a(y2, activity)).v(toolbar).o(true).p(300).s((b.a)new k(activity, mainActivity));
        if (!AppPrefs.k.D()) {
            c2.a((c.i.c.r.i.a[])Arrays.copyOf((Object[])arrobject, (int)10));
        } else {
            c2.a((c.i.c.r.i.a[])Arrays.copyOf((Object[])arrobject2, (int)9));
        }
        y2.f = c2.b();
    }

    private static final long i(Activity activity) {
        Fragment fragment = ((MainActivity)activity).R().j0("fragment_library");
        if (fragment instanceof x) {
            return 1L;
        }
        if (fragment instanceof v) {
            return 2L;
        }
        if (fragment instanceof com.smp.musicspeed.recorder.x) {
            return 4L;
        }
        return 5L;
    }

    private static final boolean j(Activity activity, MainActivity mainActivity, View view, int n2, c.i.c.r.i.a a2) {
        f.z.d.k.g((Object)activity, (String)"$activity");
        f.z.d.k.g((Object)mainActivity, (String)"$mainActivity");
        long l2 = a2.h();
        if (l2 == 1L) {
            com.smp.musicspeed.utils.k.P((Context)activity, 0);
            mainActivity.I2();
            if (com.smp.musicspeed.utils.k.E((Context)mainActivity)) {
                mainActivity.Z3();
                return false;
            }
        } else if (l2 == 2L) {
            com.smp.musicspeed.utils.k.P((Context)activity, 1);
            mainActivity.I2();
            if (com.smp.musicspeed.utils.k.E((Context)mainActivity)) {
                mainActivity.Z3();
                return false;
            }
        } else {
            if (l2 == 3L) {
                mainActivity.W1();
                return false;
            }
            if (l2 == 4L) {
                com.smp.musicspeed.utils.k.P((Context)activity, 2);
                mainActivity.I2();
                if (com.smp.musicspeed.utils.k.E((Context)mainActivity)) {
                    mainActivity.Z3();
                    return false;
                }
            } else if (l2 == 5L) {
                com.smp.musicspeed.utils.k.P((Context)activity, 3);
                mainActivity.I2();
                if (com.smp.musicspeed.utils.k.E((Context)mainActivity)) {
                    mainActivity.Z3();
                    return false;
                }
            } else {
                if (l2 == 6L) {
                    mainActivity.f5(false);
                    return false;
                }
                if (l2 == 7L) {
                    mainActivity.X4();
                    return false;
                }
                if (l2 == 8L) {
                    mainActivity.g5(false);
                    return false;
                }
                if (l2 == 9L) {
                    mainActivity.a5();
                }
            }
        }
        return false;
    }

    public static final <T> List<T> k(List<? extends T> list, List<Integer> list2) {
        f.z.d.k.g(list, (String)"unshuffled");
        f.z.d.k.g(list2, (String)"map");
        ArrayList arrayList = new ArrayList(l.j(list2, (int)10));
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            arrayList.add(list.get(((Number)iterator.next()).intValue()));
        }
        return arrayList;
    }

    public static final String l(Throwable throwable) {
        f.z.d.k.g((Object)throwable, (String)"e");
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter((Writer)stringWriter));
        String string2 = stringWriter.toString();
        f.z.d.k.f((Object)string2, (String)"sw.toString()");
        return string2;
    }

    public static final Toast m(Object object, Context context, int n2) {
        f.z.d.k.g((Object)object, (String)"<this>");
        f.z.d.k.g((Object)context, (String)"context");
        Toast toast = Toast.makeText((Context)context, (CharSequence)object.toString(), (int)n2);
        toast.show();
        f.z.d.k.f((Object)toast, (String)"makeText(context, this.toString(), duration).apply { show() }");
        return toast;
    }

    public static /* synthetic */ Toast n(Object object, Context context, int n2, int n3, Object object2) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return z.m(object, context, n2);
    }
}

