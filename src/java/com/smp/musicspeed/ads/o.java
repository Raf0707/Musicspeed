/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.google.android.gms.ads.nativead.MediaView
 *  com.google.android.gms.ads.nativead.NativeAdView
 *  java.lang.Object
 */
package com.smp.musicspeed.ads;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.smp.musicspeed.ads.t;
import com.smp.musicspeed.utils.l;
import f.z.d.k;

public final class o
extends t {
    private final TextView A;
    private final Button B;
    private final MediaView C;
    private final NativeAdView x;
    private final ImageView y;
    private final TextView z;

    public o(View view, boolean bl) {
        MediaView mediaView;
        NativeAdView nativeAdView;
        k.g((Object)view, "view");
        super(view, bl);
        this.x = nativeAdView = (NativeAdView)view.findViewById(2131296405);
        this.y = (ImageView)view.findViewById(2131296383);
        this.z = (TextView)view.findViewById(2131296390);
        this.A = (TextView)view.findViewById(2131296384);
        this.B = (Button)view.findViewById(2131296388);
        this.C = mediaView = (MediaView)view.findViewById(2131296392);
        if (nativeAdView.getContext() != null) {
            if (com.smp.musicspeed.utils.t.M(nativeAdView.getContext(), l.b()) >= 721.0f && bl) {
                mediaView.setVisibility(0);
                return;
            }
            mediaView.setVisibility(8);
        }
    }

    @Override
    public Button Z() {
        return this.B;
    }

    public final NativeAdView a0() {
        return this.x;
    }

    public final ImageView b0() {
        return this.y;
    }

    public final TextView c0() {
        return this.A;
    }

    public final TextView d0() {
        return this.z;
    }

    public final MediaView e0() {
        return this.C;
    }
}

