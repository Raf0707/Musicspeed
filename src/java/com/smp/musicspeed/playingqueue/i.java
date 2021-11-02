/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  com.smp.musicspeed.k0.i0.e
 *  com.smp.musicspeed.library.album.Album
 *  f.z.d.k
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package com.smp.musicspeed.playingqueue;

import android.content.Context;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.m0.e;
import com.smp.musicspeed.library.album.Album;
import f.z.d.k;
import java.util.Objects;

public final class i {
    private final Context a;
    private final e b;

    public i(Context context, e e2) {
        k.g((Object)context, (String)"context");
        k.g((Object)e2, (String)"item");
        this.b = e2;
        Context context2 = context.getApplicationContext();
        k.f((Object)context2, (String)"context.applicationContext");
        this.a = context2;
    }

    public i(Context context, String string2, String string3, String string4, String string5) {
        k.g((Object)context, (String)"context");
        k.g((Object)string2, (String)"trackName");
        k.g((Object)string3, (String)"albumName");
        k.g((Object)string4, (String)"artistName");
        k.g((Object)string5, (String)"fileName");
        Context context2 = context.getApplicationContext();
        k.f((Object)context2, (String)"context.applicationContext");
        this.a = context2;
        this.b = new MediaTrack(string2, string3, string4, string5);
    }

    public final Context a() {
        return this.a;
    }

    public final e b() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        Class class_ = object == null ? null : object.getClass();
        if (!k.c(i.class, (Object)class_)) {
            return false;
        }
        Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type com.smp.musicspeed.playingqueue.AudioCover");
        i i2 = (i)object;
        return k.c((Object)this.b.toString(), (Object)i2.b.toString());
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        e e2 = this.b;
        if (e2 instanceof Album) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((Album)this.b).m());
            stringBuilder.append(((Album)this.b).l());
            stringBuilder.append(((Album)this.b).q());
            return stringBuilder.toString();
        }
        if (e2 instanceof MediaTrack) {
            return k.m((String)((MediaTrack)e2).getLocation(), (Object)((MediaTrack)this.b).getDateModified());
        }
        if (e2 instanceof com.smp.musicspeed.k0.i0.e) {
            return ((com.smp.musicspeed.k0.i0.e)e2).b();
        }
        throw new IllegalArgumentException();
    }
}

