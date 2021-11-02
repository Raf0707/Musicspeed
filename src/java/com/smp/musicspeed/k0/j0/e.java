/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.net.Uri
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Audio
 *  android.provider.MediaStore$Audio$Media
 *  com.smp.musicspeed.k0.j0.e$a
 *  com.smp.musicspeed.k0.j0.e$b
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 *  kotlinx.coroutines.a1
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.q2
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.k0.j0;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.provider.MediaStore;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.j0.e;
import com.smp.musicspeed.k0.j0.f;
import com.smp.musicspeed.k0.z;
import f.t;
import f.w.d;
import f.w.g;
import f.z.c.p;
import f.z.d.k;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.q2;
import org.greenrobot.eventbus.c;

public final class e
implements k0 {
    public static final e f = new e();
    private static final g g = q2.b(null, (int)1, null).plus((g)a1.b());
    private static f.z.c.a<t> h;

    private e() {
    }

    public static final /* synthetic */ void a(int n2, MediaTrack[] arrmediaTrack) {
        e.c(n2, arrmediaTrack);
    }

    private static final void c(int n2, MediaTrack[] arrmediaTrack) {
        if (n2 >= 0) {
            c.d().p((Object)new f(n2, arrmediaTrack[0]));
        }
    }

    private final void e(Activity activity, List<? extends Uri> list) {
        PendingIntent pendingIntent = MediaStore.createDeleteRequest((ContentResolver)activity.getContentResolver(), list);
        k.f((Object)pendingIntent, "createDeleteRequest(activity.contentResolver, uriList)");
        try {
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), 4569, null, 0, 0, 0);
        }
        catch (IntentSender.SendIntentException sendIntentException) {}
    }

    public g L() {
        return g;
    }

    public final void b(Activity activity, MediaTrack[] arrmediaTrack, int n2) {
        k.g((Object)activity, "activity");
        k.g(arrmediaTrack, "data");
        if (z.d()) {
            a a2 = n2 >= 0 ? new a(n2, arrmediaTrack) : null;
            h = a2;
            ArrayList arrayList = new ArrayList(arrmediaTrack.length);
            for (MediaTrack mediaTrack : arrmediaTrack) {
                arrayList.add((Object)ContentUris.withAppendedId((Uri)MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long)mediaTrack.getSongId()));
            }
            this.e(activity, (List<? extends Uri>)arrayList);
            return;
        }
        Context context = activity.getApplicationContext();
        b b2 = new b(arrmediaTrack, context, activity, n2, null);
        kotlinx.coroutines.e.d((k0)this, null, null, (p)b2, (int)3, null);
    }

    public final void d() {
        f.z.c.a<t> a2 = h;
        if (a2 == null) {
            return;
        }
        a2.invoke();
    }
}

