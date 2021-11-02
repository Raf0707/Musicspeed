/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.e0
 *  androidx.lifecycle.h0
 *  androidx.lifecycle.h0$d
 *  java.lang.Class
 *  java.lang.Object
 */
package com.smp.musicspeed.tag_editor;

import android.content.Context;
import androidx.lifecycle.e0;
import androidx.lifecycle.h0;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.tag_editor.k;

public final class l
extends h0.d {
    private final Context b;
    private final MediaTrack c;

    public l(Context context, MediaTrack mediaTrack) {
        f.z.d.k.g((Object)context, "context");
        f.z.d.k.g(mediaTrack, "track");
        this.b = context;
        this.c = mediaTrack;
    }

    public <T extends e0> T a(Class<T> class_) {
        f.z.d.k.g(class_, "modelClass");
        return (T)((Object)new k(this.b, this.c));
    }
}

