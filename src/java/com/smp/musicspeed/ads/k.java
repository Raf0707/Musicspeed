/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.RatingBar
 *  android.widget.TextView
 *  android.widget.ViewFlipper
 *  com.google.android.gms.ads.nativead.NativeAdView
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.ads;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.google.android.gms.ads.nativead.NativeAdView;

public final class k {
    private final NativeAdView a;
    private final TextView b;
    private final TextView c;
    private final Button d;
    private final ImageView e;
    private final TextView f;
    private final RatingBar g;
    private final TextView h;
    private final ViewFlipper i;

    public k(NativeAdView nativeAdView, TextView textView, TextView textView2, Button button, ImageView imageView, TextView textView3, RatingBar ratingBar, TextView textView4, ViewFlipper viewFlipper) {
        f.z.d.k.g((Object)nativeAdView, (String)"adView");
        f.z.d.k.g((Object)textView, (String)"headline");
        f.z.d.k.g((Object)textView2, (String)"body");
        f.z.d.k.g((Object)button, (String)"cta");
        f.z.d.k.g((Object)imageView, (String)"icon");
        f.z.d.k.g((Object)textView3, (String)"price");
        f.z.d.k.g((Object)ratingBar, (String)"stars");
        f.z.d.k.g((Object)textView4, (String)"advertiser");
        f.z.d.k.g((Object)viewFlipper, (String)"flipper");
        this.a = nativeAdView;
        this.b = textView;
        this.c = textView2;
        this.d = button;
        this.e = imageView;
        this.f = textView3;
        this.g = ratingBar;
        this.h = textView4;
        this.i = viewFlipper;
    }

    public final NativeAdView a() {
        return this.a;
    }

    public final TextView b() {
        return this.h;
    }

    public final TextView c() {
        return this.c;
    }

    public final Button d() {
        return this.d;
    }

    public final ViewFlipper e() {
        return this.i;
    }

    public final TextView f() {
        return this.b;
    }

    public final ImageView g() {
        return this.e;
    }

    public final TextView h() {
        return this.f;
    }

    public final RatingBar i() {
        return this.g;
    }
}

