/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  androidx.core.app.a
 *  com.smp.musicspeed.MainActivity
 *  com.smp.musicspeed.b0$b
 *  com.smp.musicspeed.b0$c
 *  com.smp.musicspeed.b0$d
 *  i.a.a
 *  i.a.b
 *  i.a.c
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.b0;

/*
 * Exception performing whole class analysis.
 */
final class b0 {
    private static final String[] a;
    private static final String[] b;
    private static i.a.a c;
    private static final String[] d;
    private static i.a.a e;
    private static final String[] f;
    private static i.a.a g;
    private static final String[] h;

    static {
        a = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        b = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        d = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        f = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        h = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    static /* synthetic */ String[] a() {
        return h;
    }

    static /* synthetic */ String[] b() {
        return b;
    }

    static /* synthetic */ String[] c() {
        return d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void d(MainActivity mainActivity, int n2, int[] arrn) {
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            return;
                        }
                        if (i.a.c.f((int[])arrn)) {
                            mainActivity.m5();
                            return;
                        }
                        if (i.a.c.d((Activity)mainActivity, (String[])h)) return;
                        mainActivity.a4();
                        return;
                    }
                    if (i.a.c.f((int[])arrn)) {
                        i.a.a a2 = g;
                        if (a2 != null) {
                            a2.a();
                        }
                    } else if (!i.a.c.d((Activity)mainActivity, (String[])f)) {
                        mainActivity.a4();
                    }
                    g = null;
                    return;
                }
                if (i.a.c.f((int[])arrn)) {
                    i.a.a a3 = e;
                    if (a3 != null) {
                        a3.a();
                    }
                } else if (!i.a.c.d((Activity)mainActivity, (String[])d)) {
                    mainActivity.a4();
                }
                e = null;
                return;
            }
            if (i.a.c.f((int[])arrn)) {
                i.a.a a4 = c;
                if (a4 != null) {
                    a4.a();
                }
            } else if (!i.a.c.d((Activity)mainActivity, (String[])b)) {
                mainActivity.a4();
            }
            c = null;
            return;
        }
        if (i.a.c.f((int[])arrn)) {
            mainActivity.W1();
            return;
        }
        if (i.a.c.d((Activity)mainActivity, (String[])a)) return;
        mainActivity.a4();
    }

    static void e(MainActivity mainActivity, Intent intent) {
        String[] arrstring = b;
        if (i.a.c.b((Context)mainActivity, (String[])arrstring)) {
            mainActivity.e4(intent);
            return;
        }
        c = new /* Unavailable Anonymous Inner Class!! */;
        if (i.a.c.d((Activity)mainActivity, (String[])arrstring)) {
            mainActivity.e5((i.a.b)c);
            return;
        }
        androidx.core.app.a.l((Activity)mainActivity, (String[])arrstring, (int)2);
    }

    static void f(MainActivity mainActivity, Intent intent) {
        String[] arrstring = d;
        if (i.a.c.b((Context)mainActivity, (String[])arrstring)) {
            mainActivity.g4(intent);
            return;
        }
        e = new /* Unavailable Anonymous Inner Class!! */;
        if (i.a.c.d((Activity)mainActivity, (String[])arrstring)) {
            mainActivity.e5((i.a.b)e);
            return;
        }
        androidx.core.app.a.l((Activity)mainActivity, (String[])arrstring, (int)3);
    }

    static void g(MainActivity mainActivity) {
        String[] arrstring = h;
        if (i.a.c.b((Context)mainActivity, (String[])arrstring)) {
            mainActivity.m5();
            return;
        }
        if (i.a.c.d((Activity)mainActivity, (String[])arrstring)) {
            mainActivity.e5((i.a.b)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        androidx.core.app.a.l((Activity)mainActivity, (String[])arrstring, (int)5);
    }

}

