/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.smp.musicspeed.library.playlists;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.smp.musicspeed.library.playlists.h;
import java.io.File;
import java.util.List;

public final class e
implements MediaScannerConnection.OnScanCompletedListener {
    public final /* synthetic */ List a;
    public final /* synthetic */ File b;

    public /* synthetic */ e(List list, File file) {
        this.a = list;
        this.b = file;
    }

    public final void onScanCompleted(String string2, Uri uri) {
        h.c(this.a, this.b, string2, uri);
    }
}

