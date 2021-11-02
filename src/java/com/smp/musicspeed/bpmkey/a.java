/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.w
 *  com.smp.musicspeed.bpmkey.a$a
 *  com.smp.musicspeed.bpmkey.a$b
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  kotlinx.coroutines.a1
 *  kotlinx.coroutines.b3.e
 *  kotlinx.coroutines.b3.y
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.k1
 *  kotlinx.coroutines.q2
 *  kotlinx.coroutines.u2
 */
package com.smp.musicspeed.bpmkey;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import com.smp.musicspeed.bpmkey.BpmKeyService;
import com.smp.musicspeed.bpmkey.a;
import com.smp.musicspeed.bpmkey.h;
import com.smp.musicspeed.bpmkey.i;
import com.smp.musicspeed.bpmkey.j;
import com.smp.musicspeed.dbrecord.BeatStartRecord;
import f.w.d;
import f.w.g;
import f.z.c.p;
import f.z.d.k;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.b3.y;
import kotlinx.coroutines.e;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.u2;

public final class a
implements k0 {
    public static final a f;
    private static final g g;
    private static final k1 h;
    private static volatile String i;
    private static final w<BeatStartRecord> j;
    private static final LiveData<BeatStartRecord> k;
    private static final w<Boolean> l;
    private static final LiveData<Boolean> m;
    private static final y<i> n;

    static {
        a a2;
        w w2;
        w w3;
        k1 k12;
        f = a2 = new a();
        g = q2.b(null, (int)1, null).plus((g)a1.c());
        h = k12 = u2.b((String)"syncThread");
        j = w3 = new w();
        k = w3;
        l = w2 = new w((Object)Boolean.FALSE);
        m = w2;
        n = kotlinx.coroutines.b3.e.b((k0)a2, (g)k12, (int)Integer.MAX_VALUE, null, null, (p)new a(null), (int)12, null);
    }

    private a() {
    }

    public static final /* synthetic */ w a() {
        return j;
    }

    public static final /* synthetic */ w b() {
        return l;
    }

    public g L() {
        return g;
    }

    public final Object c(String string, d<? super BeatStartRecord> d2) {
        return e.e((g)this.e(), (p)new b(string, null), d2);
    }

    public final LiveData<BeatStartRecord> d() {
        return k;
    }

    public final k1 e() {
        return h;
    }

    public final String f() {
        return i;
    }

    public final LiveData<Boolean> g() {
        return m;
    }

    public final void h(String string) {
        if (!k.c(i, string)) {
            BpmKeyService.cancelAnalyze();
            i = string;
            y<i> y2 = n;
            k.e(string);
            y2.offer((Object)new h(string));
        }
    }

    public final void i(String string, float f3, int n2) {
        k.g(string, "filename");
        n.offer((Object)new j(string, f3, n2));
    }
}

