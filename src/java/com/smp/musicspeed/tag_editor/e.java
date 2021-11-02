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
import com.smp.musicspeed.library.album.Album;
import com.smp.musicspeed.tag_editor.d;
import f.z.d.k;

public final class e
extends h0.d {
    private final Context b;
    private final Album c;

    public e(Context context, Album album) {
        k.g((Object)context, "context");
        k.g(album, "album");
        this.b = context;
        this.c = album;
    }

    public <T extends e0> T a(Class<T> class_) {
        k.g(class_, "modelClass");
        return (T)((Object)new d(this.b, this.c));
    }
}

