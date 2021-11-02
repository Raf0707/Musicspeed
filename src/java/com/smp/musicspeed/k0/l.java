/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 *  f.z.c.q
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.k0;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import com.smp.musicspeed.k0.f0;
import f.z.c.q;

public final class l
implements MediaScannerConnection.OnScanCompletedListener {
    public final /* synthetic */ q a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;

    public /* synthetic */ l(q q2, Context context, String string2) {
        this.a = q2;
        this.b = context;
        this.c = string2;
    }

    public final void onScanCompleted(String string2, Uri uri) {
        f0.p(this.a, this.b, this.c, string2, uri);
    }
}

