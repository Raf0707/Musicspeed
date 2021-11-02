/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.view.Menu
 *  b.i.h.a
 *  com.smp.musicspeed.folders.v
 *  com.smp.musicspeed.utils.AppPrefs
 *  com.smp.musicspeed.utils.k$a
 *  f.z.d.k
 *  java.io.File
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import com.smp.musicspeed.folders.u;
import com.smp.musicspeed.folders.v;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.k;
import com.smp.musicspeed.utils.t;
import java.io.File;

public final class k {
    private static int a;

    public static final boolean A() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 4) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.V();
        }
        return true;
    }

    public static final void B(int n2, Menu menu) {
        int n3;
        f.z.d.k.g((Object)menu, (String)"menu");
        AppPrefs appPrefs = AppPrefs.k;
        if (appPrefs.b0() != 5) {
            appPrefs.H0(appPrefs.b0());
        }
        switch (n2) {
            default: {
                throw new IllegalArgumentException();
            }
            case 2131296331: {
                n3 = 0;
                break;
            }
            case 2131296330: {
                n3 = 2;
                break;
            }
            case 2131296329: {
                n3 = 3;
                break;
            }
            case 2131296328: {
                n3 = 4;
                break;
            }
            case 2131296327: {
                n3 = 5;
                break;
            }
            case 2131296326: {
                n3 = 1;
            }
        }
        appPrefs.K0(n3);
        int n4 = appPrefs.b0();
        boolean bl = false;
        if (n4 == 5) {
            bl = true;
        }
        appPrefs.u0(bl);
        k.F(menu);
    }

    public static final boolean C(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        return t.o(context).getBoolean("prefs_never_changed_accent", false);
    }

    public static final boolean D(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        return t.o(context).getBoolean("playing queue open", false);
    }

    public static final boolean E(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        return t.o(context).getBoolean("prefs_sliding_panel_open", false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final void F(Menu menu) {
        int n2;
        f.z.d.k.g((Object)menu, (String)"menu");
        a a2 = new a(menu);
        int n3 = AppPrefs.k.b0();
        if (n3 != 0) {
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 3) {
                        if (n3 != 4) {
                            if (n3 != 5) throw new IllegalArgumentException();
                            n2 = 2131296327;
                        } else {
                            n2 = 2131296328;
                        }
                    } else {
                        n2 = 2131296329;
                    }
                } else {
                    n2 = 2131296330;
                }
            } else {
                n2 = 2131296326;
            }
        } else {
            n2 = 2131296331;
        }
        a2.g((Object)n2);
    }

    public static final void G(Context context, int n2) {
        f.z.d.k.g((Object)context, (String)"context");
        t.p(context).putInt("preferences_accent_color_dark", n2).apply();
    }

    public static final void H(Context context, boolean bl) {
        f.z.d.k.g((Object)context, (String)"context");
        t.p(context).putBoolean("prefs_never_changed_accent", bl).apply();
    }

    public static final void I(Context context, File file) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)file, (String)"file");
        t.p(context).putString("prefs_last_directory", u.h(file)).apply();
    }

    public static final void J(Context context, int n2) {
        f.z.d.k.g((Object)context, (String)"context");
        t.p(context).putInt("preferences_accent_color", n2).apply();
    }

    public static final void K(int n2) {
        a = n2;
    }

    public static final void L(Context context, boolean bl) {
        f.z.d.k.g((Object)context, (String)"context");
        t.p(context).putBoolean("playing queue open", bl).apply();
    }

    public static final void M(Context context, boolean bl) {
        f.z.d.k.g((Object)context, (String)"context");
        t.p(context).putBoolean("prefs_sliding_panel_open", bl).apply();
    }

    public static final void N(Context context, int n2, String string2) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"order");
        t.p(context).putString(f.z.d.k.m((String)"prefs_sort_order", (Object)n2), string2).apply();
    }

    public static final void O(Context context, File file) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)file, (String)"file");
        t.p(context).putString("prefs_start_directory", u.h(file)).apply();
    }

    public static final void P(Context context, int n2) {
        f.z.d.k.g((Object)context, (String)"context");
        t.p(context).putInt("prefs_starting_frag", n2).apply();
    }

    public static final void Q(Context context, String string2, int n2) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"id");
        t.p(context).putInt(string2, n2).apply();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final String a(int n2) {
        String string2 = "title_key";
        if (n2 == -1) return string2;
        if (n2 == 0) return string2;
        if (n2 == 1) return "album_key";
        if (n2 == 2) return "artist_key";
        if (n2 == 3) return string2;
        if (n2 == 4) return "name";
        return string2;
    }

    public static final int b(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        String string2 = t.w(context) && z.c() ? "preferences_accent_color_dark" : "preferences_accent_color";
        int n2 = t.w(context) && z.c() ? 2131099733 : 2131099703;
        return t.o(context).getInt(string2, b.i.h.a.c((Context)context, (int)n2));
    }

    public static final boolean c() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 3) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.G();
        }
        return true;
    }

    public static final boolean d() {
        int n2;
        AppPrefs appPrefs = AppPrefs.k;
        int n3 = appPrefs.b0();
        if (n3 != (n2 = 1)) {
            if (n3 != 5) {
                return false;
            }
            n2 = appPrefs.H() ? 1 : 0;
        }
        return (boolean)n2;
    }

    public static final boolean e() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 4) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.I();
        }
        return true;
    }

    public static final int f(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        return t.o(context).getInt("preferences_accent_color_dark", b.i.h.a.c((Context)context, (int)2131099733));
    }

    public static final boolean g() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 4) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.J();
        }
        return true;
    }

    public static final boolean h() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 3) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.L();
        }
        return true;
    }

    public static final boolean i() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 4) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.M();
        }
        return true;
    }

    public static final boolean j() {
        int n2;
        AppPrefs appPrefs = AppPrefs.k;
        int n3 = appPrefs.b0();
        if (n3 != (n2 = 1)) {
            if (n3 != 5) {
                return false;
            }
            n2 = appPrefs.N() ? 1 : 0;
        }
        return (boolean)n2;
    }

    public static final File k(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        return new File(t.o(context).getString("prefs_last_directory", v.C().getPath()));
    }

    public static final int l(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        return t.o(context).getInt("preferences_accent_color", b.i.h.a.c((Context)context, (int)2131099703));
    }

    public static final boolean m() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 4) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.O();
        }
        return true;
    }

    public static final boolean n() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        int n3 = 1;
        if (n2 != 0 && n2 != n3 && n2 != 2) {
            if (n2 != 5) {
                return false;
            }
            n3 = appPrefs.P() ? 1 : 0;
        }
        return (boolean)n3;
    }

    public static final boolean o(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        return t.o(context).getBoolean("preferences_low_latency", false);
    }

    public static final boolean p() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 2) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.Q();
        }
        return true;
    }

    public static final boolean q() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 4) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.R();
        }
        return true;
    }

    public static final int r() {
        return a;
    }

    public static final boolean s() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        int n3 = 1;
        if (n2 != 0 && n2 != n3 && n2 != 2) {
            if (n2 != 5) {
                return false;
            }
            n3 = appPrefs.S() ? 1 : 0;
        }
        return (boolean)n3;
    }

    public static final boolean t() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 3) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.T();
        }
        return true;
    }

    public static final String u(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        return t.o(context).getString("preferences_recorder_kbps", context.getString(2131820710));
    }

    public static final boolean v() {
        AppPrefs appPrefs = AppPrefs.k;
        int n2 = appPrefs.b0();
        if (n2 != 4) {
            if (n2 != 5) {
                return false;
            }
            return appPrefs.U();
        }
        return true;
    }

    public static final String w(Context context, int n2) {
        f.z.d.k.g((Object)context, (String)"context");
        String string2 = t.o(context).getString(f.z.d.k.m((String)"prefs_sort_order", (Object)n2), k.a(n2));
        if (string2 == null) {
            string2 = k.a(n2);
        }
        return string2;
    }

    public static final File x(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        return new File(t.o(context).getString("prefs_start_directory", v.C().getPath()));
    }

    public static final int y(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        return t.o(context).getInt("prefs_starting_frag", 0);
    }

    public static final int z(Context context, String string2) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"id");
        int n2 = t.o(context).getInt(string2, 0);
        k.K(n2);
        return n2;
    }
}

