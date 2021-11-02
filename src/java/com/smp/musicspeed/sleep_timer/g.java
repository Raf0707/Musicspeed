/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.widget.Toast
 *  androidx.lifecycle.w
 *  b.i.h.a
 *  com.smp.musicspeed.player.PlayFileService
 *  com.smp.musicspeed.sleep_timer.g$a
 *  com.smp.musicspeed.sleep_timer.g$b
 *  com.smp.musicspeed.sleep_timer.g$c
 *  f.b0.d
 *  f.e0.i
 *  f.z.d.g
 *  f.z.d.k
 *  f.z.d.o
 *  f.z.d.p
 *  f.z.d.z
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.sleep_timer;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.lifecycle.w;
import com.smp.musicspeed.player.PlayFileService;
import com.smp.musicspeed.sleep_timer.g;
import f.b0.d;
import f.e0.i;
import f.z.d.k;
import f.z.d.o;
import f.z.d.p;
import f.z.d.z;

/*
 * Exception performing whole class analysis.
 */
public final class g {
    public static final a a;
    static final /* synthetic */ i<Object>[] b;
    private final Context c;
    private final w<Long> d;
    private final w<Boolean> e;
    private final d f;

    static {
        i[] arri = new i[]{z.e((o)new p((f.e0.c)z.b(g.class), "currentCountdown", "getCurrentCountdown()Lcom/smp/musicspeed/sleep_timer/SleepTimer$Countdown;"))};
        b = arri;
        a = new /* Unavailable Anonymous Inner Class!! */;
    }

    private g(Context context) {
        Context context2 = context.getApplicationContext();
        k.f((Object)context2, (String)"context.applicationContext");
        this.c = context2;
        this.d = new w((Object)0L);
        this.e = new w((Object)Boolean.FALSE);
        this.f = new c(null, null, this);
    }

    public /* synthetic */ g(Context context, f.z.d.g g2) {
        this(context);
    }

    public static final /* synthetic */ void a(g g2) {
        g2.f();
    }

    private final b c() {
        return this.f.a((Object)this, b[0]);
    }

    private final void f() {
        this.h(null);
        Context context = this.c;
        Toast.makeText((Context)context, (CharSequence)context.getString(2131821315), (int)1).show();
        if (PlayFileService.g) {
            this.g();
        }
    }

    private final void g() {
        Intent intent = new Intent(this.c, PlayFileService.class);
        intent.setAction("com.smp.musicspeed.ACTION_PLAY");
        intent.putExtra("com.smp.musicspeed.FROM_SLEEP_TIMER", true);
        b.i.h.a.i((Context)this.c, (Intent)intent);
    }

    private final void h(b b2) {
        this.f.b((Object)this, b[0], (Object)b2);
    }

    public final void b(long l2) {
        b b2 = this.c();
        if (b2 != null) {
            b2.h();
        }
        Long l3 = (Long)this.d.f();
        if (l3 == null) {
            l3 = 0L;
        }
        this.h(new /* Unavailable Anonymous Inner Class!! */);
    }

    public final w<Long> d() {
        return this.d;
    }

    public final w<Boolean> e() {
        return this.e;
    }

    public final void i(long l2) {
        this.j();
        this.h(new /* Unavailable Anonymous Inner Class!! */);
    }

    public final void j() {
        b b2 = this.c();
        if (b2 != null) {
            b2.h();
        }
        this.h(null);
    }
}

