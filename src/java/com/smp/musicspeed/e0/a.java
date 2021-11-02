/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.android.billingclient.api.Purchase
 *  com.android.billingclient.api.Purchase$a
 *  com.android.billingclient.api.SkuDetails
 *  com.android.billingclient.api.c
 *  com.android.billingclient.api.c$a
 *  com.android.billingclient.api.f
 *  com.android.billingclient.api.g
 *  com.android.billingclient.api.g$a
 *  com.android.billingclient.api.h
 *  com.android.billingclient.api.j
 *  com.android.billingclient.api.k
 *  com.android.billingclient.api.k$a
 *  com.android.billingclient.api.l
 *  com.android.billingclient.api.m
 *  com.smp.musicspeed.e0.a$a$a
 *  com.smp.musicspeed.e0.a$a$b
 *  com.smp.musicspeed.e0.a$b
 *  com.smp.musicspeed.e0.a$c
 *  com.smp.musicspeed.e0.a$d
 *  f.w.j.b
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  kotlinx.coroutines.a1
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.f0
 *  kotlinx.coroutines.j
 *  kotlinx.coroutines.k
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 *  kotlinx.coroutines.x1
 */
package com.smp.musicspeed.e0;

import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.c;
import com.android.billingclient.api.f;
import com.android.billingclient.api.g;
import com.android.billingclient.api.j;
import com.android.billingclient.api.k;
import com.android.billingclient.api.l;
import com.smp.musicspeed.e0.a;
import com.smp.musicspeed.k0.z;
import f.m;
import f.n;
import f.t;
import f.w.k.a.h;
import f.z.c.p;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.x1;

public final class a
implements j,
k0 {
    public static final a f = new a();
    private static com.android.billingclient.api.c g;
    private static SkuDetails h;
    private final /* synthetic */ k0 i;

    private a() {
        this.i = l0.b();
    }

    public static final /* synthetic */ com.android.billingclient.api.c b() {
        return g;
    }

    public static final /* synthetic */ SkuDetails c() {
        return h;
    }

    public static final /* synthetic */ Object e(a a2, f.w.d d2) {
        return a2.m(d2);
    }

    public static final /* synthetic */ Object f(a a2, com.android.billingclient.api.c c2, com.android.billingclient.api.k k2, f.w.d d2) {
        return a2.n(c2, k2, d2);
    }

    public static final /* synthetic */ void g(SkuDetails skuDetails) {
        h = skuDetails;
    }

    private final void i(Purchase purchase) {
        kotlinx.coroutines.e.d((k0)this, null, null, (p)new b(purchase, null), (int)3, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void k() {
        com.android.billingclient.api.c c2 = g;
        if (c2 != null) {
            if (c2 == null) {
                k.s("billingClient");
                throw null;
            }
            if (c2.b()) {
                com.android.billingclient.api.c c3 = g;
                if (c3 == null) {
                    k.s("billingClient");
                    throw null;
                }
                Purchase.a a2 = c3.e("inapp");
                k.f((Object)a2, "billingClient.queryPurchases(BillingClient.SkuType.INAPP)");
                List list = a2.a();
                if (list == null) {
                    return;
                }
                for (Purchase purchase : list) {
                    if (purchase == null) continue;
                    f.i(purchase);
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final Object m(f.w.d<? super t> var1_1) {
        if (!(var1_1 instanceof c)) ** GOTO lbl-1000
        var2_2 = (c)var1_1;
        var13_3 = var2_2.k;
        if ((var13_3 & Integer.MIN_VALUE) != 0) {
            var2_2.k = var13_3 + Integer.MIN_VALUE;
        } else lbl-1000: // 2 sources:
        {
            var2_2 = new c(this, var1_1);
        }
        var3_4 = var2_2.i;
        var4_5 = f.w.j.b.c();
        var5_6 = var2_2.k;
        if (var5_6 != 0) {
            if (var5_6 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            n.b(var3_4);
        } else {
            n.b(var3_4);
            var6_7 = new ArrayList();
            var6_7.add((Object)"com.smp.removeads");
            var8_8 = com.android.billingclient.api.k.c();
            k.f((Object)var8_8, "newBuilder()");
            var8_8.b((List)var6_7).c("inapp");
            var10_9 = a1.b();
            var11_10 = new d(var8_8, null);
            var2_2.k = 1;
            var3_4 = kotlinx.coroutines.e.e((f.w.g)var10_9, (p)var11_10, (f.w.d)var2_2);
            if (var3_4 == var4_5) {
                return var4_5;
            }
        }
        var12_11 = ((com.android.billingclient.api.m)var3_4).a();
        if (var12_11 == null) {
            return t.a;
        }
        if ((true ^ var12_11.isEmpty()) == false) return t.a;
        a.h = (SkuDetails)var12_11.get(0);
        return t.a;
    }

    private final Object n(com.android.billingclient.api.c c2, com.android.billingclient.api.k k2, f.w.d<? super com.android.billingclient.api.m> d2) {
        kotlinx.coroutines.k k3 = new kotlinx.coroutines.k(f.w.j.b.b(d2), 1);
        k3.E();
        c2.f(k2, new l((kotlinx.coroutines.j<? super com.android.billingclient.api.m>)k3){
            final /* synthetic */ kotlinx.coroutines.j<com.android.billingclient.api.m> a;
            {
                this.a = j2;
            }

            public final void a(com.android.billingclient.api.h h2, List<? extends SkuDetails> list) {
                k.g((Object)h2, "billingResult");
                if (this.a.isActive()) {
                    kotlinx.coroutines.j<com.android.billingclient.api.m> j2 = this.a;
                    j2.e(m.b((Object)new com.android.billingclient.api.m(h2, list)));
                }
            }
        });
        Object object = k3.C();
        if (object == f.w.j.b.c()) {
            h.c(d2);
        }
        return object;
    }

    public f.w.g L() {
        return this.i.L();
    }

    public void a(com.android.billingclient.api.h h2, List<Purchase> list) {
        k.g((Object)h2, "billingResult");
        if (h2.a() == 0 && list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                this.i((Purchase)iterator.next());
            }
        }
    }

    public final void h(Context context) {
        k.g((Object)context, "context");
        if (g != null) {
            return;
        }
        com.android.billingclient.api.c c2 = com.android.billingclient.api.c.d((Context)context).c((j)this).b().a();
        k.f((Object)c2, "newBuilder(context)\n                        .setListener(this)\n                        .enablePendingPurchases()\n                        .build()");
        g = c2;
        if (c2 != null) {
            c2.g((f)new a());
            return;
        }
        k.s("billingClient");
        throw null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean j(Activity activity) {
        k.g((Object)activity, "activity");
        SkuDetails skuDetails = h;
        if (skuDetails == null) {
            String string = activity.getString(2131821361);
            k.f(string, "activity.getString(R.string.toast_try_purchase_again)");
            z.m(string, (Context)activity, 1);
            return false;
        }
        com.android.billingclient.api.c c2 = g;
        if (c2 != null) {
            if (c2.b()) {
                g g2 = g.e().b(skuDetails).a();
                k.f((Object)g2, "newBuilder()\n                        .setSkuDetails(it)\n                        .build()");
                com.android.billingclient.api.c c3 = g;
                if (c3 != null) {
                    if (c3.c(activity, g2).a() != 0) return false;
                    return true;
                }
                k.s("billingClient");
                throw null;
            }
            String string = activity.getString(2131821361);
            k.f(string, "activity.getString(R.string.toast_try_purchase_again)");
            z.m(string, (Context)activity, 1);
            return false;
        }
        k.s("billingClient");
        throw null;
    }

    public final void l(Context context) {
        k.g((Object)context, "context");
    }

    public static final class com.smp.musicspeed.e0.a$a
    implements f {
        public void a(com.android.billingclient.api.h h2) {
            k.g((Object)h2, "billingResult");
            if (h2.a() == 0) {
                com.smp.musicspeed.e0.a a2 = com.smp.musicspeed.e0.a.f;
                kotlinx.coroutines.e.d((k0)a2, null, null, (p)new a(null), (int)3, null);
                a2.k();
                return;
            }
            this.c();
        }

        public void b() {
            x1.f((f.w.g)com.smp.musicspeed.e0.a.f.L(), null, (int)1, null);
            com.smp.musicspeed.e0.a.g(null);
            this.c();
        }

        public final void c() {
            kotlinx.coroutines.e.d((k0)com.smp.musicspeed.e0.a.f, null, null, (p)new b(this, null), (int)3, null);
        }
    }

}

