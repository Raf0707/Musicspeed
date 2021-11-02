/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.k0.o0;

import android.os.Bundle;
import com.smp.musicspeed.k0.o0.h;
import com.smp.musicspeed.k0.o0.o;
import f.f;
import f.t;
import f.z.d.g;

public final class o
extends h {
    public static final a w = new Object(null){
        {
            this();
        }

        public final o a(long l2) {
            o o2 = new o();
            Bundle bundle = new Bundle();
            bundle.putLong("playlistId", l2);
            o2.setArguments(bundle);
            return o2;
        }
    };
    private final int A = 2131820737;
    private final f.z.c.a<t> B = new f.z.c.a<t>(this){
        final /* synthetic */ o g;
        {
            this.g = o2;
            super(0);
        }

        public final void a() {
            com.smp.musicspeed.dbrecord.AppDatabaseKt.getInternalPlaylistDao().renamePlaylist(o.Y(this.g), this.g.Q());
            o o2 = this.g;
            Object[] arrobject = new Object[]{o2.Q()};
            String string = o2.getString(2131821335, arrobject);
            f.z.d.k.f(string, "getString(R.string.toast_playlist_renamed, enteredText)");
            android.content.Context context = this.g.requireContext();
            f.z.d.k.f((Object)context, "requireContext()");
            com.smp.musicspeed.k0.z.n(string, context, 0, 2, null);
            org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.k0.o0.m(this.g.Q()));
            android.content.Context context2 = this.g.requireContext();
            f.z.d.k.f((Object)context2, "requireContext()");
            com.smp.musicspeed.k0.m0.h.a(context2);
        }
    };
    private final f x = f.g.a(new f.z.c.a<Long>(this){
        final /* synthetic */ o g;
        {
            this.g = o2;
            super(0);
        }

        public final long a() {
            Bundle bundle = this.g.getArguments();
            Long l2 = bundle == null ? null : Long.valueOf((long)bundle.getLong("playlistId"));
            java.util.Objects.requireNonNull((Object)l2, (String)"null cannot be cast to non-null type kotlin.Long");
            return l2;
        }
    });
    private final int y = 2131820791;
    private final int z = 2131820734;

    public static final /* synthetic */ long Y(o o2) {
        return o2.Z();
    }

    private final long Z() {
        return ((Number)this.x.getValue()).longValue();
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

