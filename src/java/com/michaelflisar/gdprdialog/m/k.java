/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  androidx.appcompat.app.e
 *  java.lang.Boolean
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.michaelflisar.gdprdialog.m;

import android.content.Context;
import android.os.AsyncTask;
import com.michaelflisar.gdprdialog.GDPRSetup;
import com.michaelflisar.gdprdialog.GDPRSubNetwork;
import com.michaelflisar.gdprdialog.c;
import com.michaelflisar.gdprdialog.d;
import com.michaelflisar.gdprdialog.e;
import com.michaelflisar.gdprdialog.m.h;
import com.michaelflisar.gdprdialog.m.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class k<T extends androidx.appcompat.app.e>
extends AsyncTask<Object, Void, h> {
    private WeakReference<T> a;
    private GDPRSetup b;

    public k(T t2, GDPRSetup gDPRSetup) {
        this.a = new WeakReference(t2);
        this.b = gDPRSetup;
    }

    protected /* varargs */ h a(Object ... arrobject) {
        com.michaelflisar.gdprdialog.i[] arri;
        h h2;
        boolean bl;
        androidx.appcompat.app.e e2;
        boolean bl2;
        block14 : {
            h2 = new h();
            arri = this.b.E();
            e2 = (androidx.appcompat.app.e)this.a.get();
            bl = this.b.y().size() > 0;
            for (int i2 = 0; i2 < arri.length; ++i2) {
                if (arri[i2] != com.michaelflisar.gdprdialog.i.f) continue;
                bl2 = true;
                break block14;
            }
            bl2 = false;
        }
        if (e2 != null) {
            h h3 = new h();
            if (bl || bl2) {
                h3.d((Context)e2, this.b.y(), this.b.o(), this.b.n());
                if (!bl2) {
                    h3.j(com.michaelflisar.gdprdialog.h.f);
                }
                h2.b().clear();
                h2.b().addAll(h3.b());
            }
            for (int i3 = 0; i3 < arri.length; ++i3) {
                int n2 = a.a[arri[i3].ordinal()];
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 == 4) {
                                h2.h(i.d());
                            }
                        } else {
                            h2.h(i.f());
                        }
                    } else {
                        h2.h(i.e((Context)e2));
                    }
                } else if (!h3.c()) {
                    h2.j(h3.a());
                } else {
                    h2.h(null);
                }
                if (h2.a() == com.michaelflisar.gdprdialog.h.g) break;
            }
        }
        c.d d2 = c.e().f();
        Object[] arrobject2 = new Object[]{h2.f()};
        d2.a("PreperationAsyncTask", String.format((String)"GDPRPreperationData: %s", (Object[])arrobject2));
        return h2;
    }

    protected void b(h h2) {
        if (this.isCancelled()) {
            return;
        }
        androidx.appcompat.app.e e2 = (androidx.appcompat.app.e)this.a.get();
        if (e2 != null && !e2.isFinishing()) {
            if (this.b.E().length > 0 && h2.a() == com.michaelflisar.gdprdialog.h.h) {
                e e3 = new e((Context)e2, d.j, h2.a());
                c.e().i(e3);
                ((c.c)e2).h(e3, true);
                return;
            }
            ((c.c)e2).t(h2);
        }
    }

}

