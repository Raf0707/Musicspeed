/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 *  com.smp.musicspeed.importfile.h
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package com.smp.musicspeed.importfile;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import com.smp.musicspeed.importfile.h;
import java.util.List;
import java.util.Map;

public final class d
implements MediaScannerConnection.OnScanCompletedListener {
    public final /* synthetic */ h.b a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ Map d;

    public /* synthetic */ d(h.b b2, List list, Context context, Map map) {
        this.a = b2;
        this.b = list;
        this.c = context;
        this.d = map;
    }

    public final void onScanCompleted(String string2, Uri uri) {
        this.a.d(this.b, this.c, this.d, string2, uri);
    }
}

