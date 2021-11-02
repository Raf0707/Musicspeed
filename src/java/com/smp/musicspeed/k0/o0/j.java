/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.k0.o0;

import android.content.Context;
import android.os.Bundle;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.o0.h;
import com.smp.musicspeed.k0.o0.j;
import com.smp.musicspeed.library.playlists.i;
import f.f;
import f.t;
import f.z.d.g;
import f.z.d.k;

public final class j
extends h {
    public static final a w = new Object(null){
        {
            this();
        }

        public final j a(MediaTrack[] arrmediaTrack) {
            k.g(arrmediaTrack, "items");
            j j2 = new j();
            j2.setArguments(h.N(arrmediaTrack));
            return j2;
        }
    };
    private final int A = 2131820736;
    private final f.z.c.a<t> B = new f.z.c.a<t>(this){

        public final void e() {
            ((j)((Object)this.g)).Z();
        }
    };
    private final f x = f.g.a(new f.z.c.a<MediaTrack[]>(this){
        final /* synthetic */ j g;
        {
            this.g = j2;
            super(0);
        }

        public final MediaTrack[] a() {
            Bundle bundle = this.g.getArguments();
            android.os.Parcelable[] arrparcelable = bundle == null ? null : bundle.getParcelableArray("tracks");
            java.util.Objects.requireNonNull((Object)arrparcelable, (String)"null cannot be cast to non-null type kotlin.Array<com.smp.musicspeed.dbrecord.MediaTrack>");
            return (MediaTrack[])arrparcelable;
        }
    });
    private final int y = 2131820787;
    private final int z = 2131820732;

    private final void Z() {
        Context context = this.requireContext();
        k.f((Object)context, "requireContext()");
        i.b(context, this.Q(), this.a0(), false, 8, null);
    }

    private final MediaTrack[] a0() {
        return (MediaTrack[])this.x.getValue();
    }

    @Override
    public f.z.c.a<t> O() {
        return this.B;
    }

    @Override
    protected int R() {
        return this.z;
    }

    @Override
    protected int S() {
        return this.A;
    }

    @Override
    protected int T() {
        return this.y;
    }

}

