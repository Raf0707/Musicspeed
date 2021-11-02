/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.RatingBar
 *  android.widget.TextView
 *  android.widget.ViewFlipper
 *  com.bumptech.glide.c
 *  com.bumptech.glide.j
 *  com.bumptech.glide.load.o.j
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.j.j
 *  com.google.android.gms.ads.MediaContent
 *  com.google.android.gms.ads.nativead.MediaView
 *  com.google.android.gms.ads.nativead.NativeAd
 *  com.google.android.gms.ads.nativead.NativeAd$Image
 *  com.google.android.gms.ads.nativead.NativeAdView
 *  com.smp.musicspeed.ads.o
 *  f.g0.k
 *  f.z.d.k
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.smp.musicspeed.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.bumptech.glide.c;
import com.bumptech.glide.load.o.j;
import com.bumptech.glide.r.a;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.smp.musicspeed.ads.k;
import com.smp.musicspeed.ads.o;
import java.util.Objects;

public final class q {
    public static final boolean a(String string) {
        boolean bl = string == null || f.g0.k.h((CharSequence)string);
        return bl ^ true;
    }

    public static final void b(NativeAdView nativeAdView) {
        f.z.d.k.g((Object)nativeAdView, (String)"adView");
        if (nativeAdView.getPriceView() != null) {
            nativeAdView.getPriceView().setVisibility(4);
        }
        if (nativeAdView.getStarRatingView() != null) {
            nativeAdView.getStarRatingView().setVisibility(4);
        }
        if (nativeAdView.getAdvertiserView() != null) {
            nativeAdView.getAdvertiserView().setVisibility(4);
        }
        if (nativeAdView.getHeadlineView() != null) {
            nativeAdView.getHeadlineView().setVisibility(4);
        }
        if (nativeAdView.getBodyView() != null) {
            nativeAdView.getBodyView().setVisibility(4);
        }
        if (nativeAdView.getCallToActionView() != null) {
            nativeAdView.getCallToActionView().setVisibility(4);
        }
        if (nativeAdView.getIconView() != null) {
            nativeAdView.getIconView().setVisibility(4);
        }
    }

    public static final void c(NativeAd nativeAd, o o2) {
        f.z.d.k.g((Object)nativeAd, (String)"nativeAd");
        f.z.d.k.g((Object)o2, (String)"recyclerNativeAdViewHolder");
        NativeAdView nativeAdView = o2.a0();
        nativeAdView.setHeadlineView((View)o2.d0());
        nativeAdView.setBodyView((View)o2.c0());
        nativeAdView.setCallToActionView((View)o2.Z());
        nativeAdView.setIconView((View)o2.b0());
        nativeAdView.setMediaView(o2.e0());
        View view = nativeAdView.getHeadlineView();
        Objects.requireNonNull((Object)view, (String)"null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view).setText((CharSequence)nativeAd.getHeadline());
        nativeAdView.getHeadlineView().setVisibility(0);
        nativeAdView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(4);
        } else {
            nativeAdView.getBodyView().setVisibility(0);
            View view2 = nativeAdView.getBodyView();
            Objects.requireNonNull((Object)view2, (String)"null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view2).setText((CharSequence)nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(4);
        } else {
            nativeAdView.getCallToActionView().setVisibility(0);
            View view3 = nativeAdView.getCallToActionView();
            Objects.requireNonNull((Object)view3, (String)"null cannot be cast to non-null type android.widget.Button");
            ((Button)view3).setText((CharSequence)nativeAd.getCallToAction());
        }
        NativeAd.Image image = nativeAd.getIcon();
        Drawable drawable = image == null ? null : image.getDrawable();
        if (drawable == null) {
            nativeAdView.getIconView().setVisibility(8);
        } else {
            Context context = nativeAdView.getContext();
            boolean bl = context instanceof Activity;
            Activity activity = null;
            if (bl) {
                activity = (Activity)context;
            }
            if (activity != null && !activity.isDestroyed()) {
                nativeAdView.getIconView().setVisibility(0);
                com.bumptech.glide.j j2 = (com.bumptech.glide.j)((com.bumptech.glide.j)c.t((Activity)activity).p(nativeAd.getIcon().getDrawable()).Z(true)).e(j.b);
                View view4 = nativeAdView.getIconView();
                Objects.requireNonNull((Object)view4, (String)"null cannot be cast to non-null type android.widget.ImageView");
                j2.q0((ImageView)view4);
            }
        }
        nativeAd.getPrice();
        if (nativeAd.getStarRating() != null) {
            f.z.d.k.a((Double)nativeAd.getStarRating(), (double)0.0);
        }
        nativeAdView.setNativeAd(nativeAd);
    }

    public static final void d(NativeAd nativeAd, k k2) {
        boolean bl;
        f.z.d.k.g((Object)nativeAd, (String)"nativeAd");
        f.z.d.k.g((Object)k2, (String)"adViewHolderPlay");
        NativeAdView nativeAdView = k2.a();
        nativeAdView.setHeadlineView((View)k2.f());
        nativeAdView.getHeadlineView().setVisibility(0);
        nativeAdView.setBodyView((View)k2.c());
        nativeAdView.setCallToActionView((View)k2.d());
        nativeAdView.setIconView((View)k2.g());
        nativeAdView.setPriceView((View)k2.h());
        nativeAdView.setStarRatingView((View)k2.i());
        nativeAdView.setAdvertiserView((View)k2.b());
        ViewFlipper viewFlipper = k2.e();
        View view = nativeAdView.getHeadlineView();
        Objects.requireNonNull((Object)view, (String)"null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view).setText((CharSequence)nativeAd.getHeadline());
        if (nativeAd.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(4);
        } else {
            nativeAdView.getBodyView().setVisibility(0);
            View view2 = nativeAdView.getBodyView();
            Objects.requireNonNull((Object)view2, (String)"null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view2).setText((CharSequence)nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(4);
        } else {
            nativeAdView.getCallToActionView().setVisibility(0);
            View view3 = nativeAdView.getCallToActionView();
            Objects.requireNonNull((Object)view3, (String)"null cannot be cast to non-null type android.widget.Button");
            ((Button)view3).setText((CharSequence)nativeAd.getCallToAction());
        }
        NativeAd.Image image = nativeAd.getIcon();
        Drawable drawable = image == null ? null : image.getDrawable();
        boolean bl2 = true;
        if (drawable == null) {
            nativeAdView.getIconView().setVisibility(8);
        } else {
            Context context = nativeAdView.getContext();
            boolean bl3 = context instanceof Activity;
            Activity activity = null;
            if (bl3) {
                activity = (Activity)context;
            }
            if (activity != null && !activity.isDestroyed()) {
                nativeAdView.getIconView().setVisibility(0);
                com.bumptech.glide.j j2 = (com.bumptech.glide.j)((com.bumptech.glide.j)c.t((Activity)activity).p(nativeAd.getIcon().getDrawable()).Z(bl2)).e(j.b);
                View view4 = nativeAdView.getIconView();
                Objects.requireNonNull((Object)view4, (String)"null cannot be cast to non-null type android.widget.ImageView");
                j2.q0((ImageView)view4);
            }
        }
        if (!q.e(nativeAd.getPrice())) {
            nativeAdView.getPriceView().setVisibility(8);
            bl = false;
        } else {
            nativeAdView.getPriceView().setVisibility(0);
            View view5 = nativeAdView.getPriceView();
            Objects.requireNonNull((Object)view5, (String)"null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view5).setText((CharSequence)nativeAd.getPrice());
            bl = true;
        }
        if (!q.f(nativeAd.getStarRating())) {
            nativeAdView.getStarRatingView().setVisibility(8);
        } else {
            View view6 = nativeAdView.getStarRatingView();
            Objects.requireNonNull((Object)view6, (String)"null cannot be cast to non-null type android.widget.RatingBar");
            ((RatingBar)view6).setRating((float)nativeAd.getStarRating().doubleValue());
            nativeAdView.getStarRatingView().setVisibility(0);
            bl = true;
        }
        if (!q.a(nativeAd.getAdvertiser())) {
            nativeAdView.getAdvertiserView().setVisibility(8);
            bl2 = bl;
        } else {
            nativeAdView.getAdvertiserView().setVisibility(0);
            View view7 = nativeAdView.getAdvertiserView();
            Objects.requireNonNull((Object)view7, (String)"null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view7).setText((CharSequence)nativeAd.getAdvertiser());
        }
        viewFlipper.setAnimateFirstView(false);
        viewFlipper.stopFlipping();
        viewFlipper.setDisplayedChild(0);
        if (bl2) {
            viewFlipper.startFlipping();
        }
        nativeAdView.setNativeAd(nativeAd);
    }

    public static final boolean e(String string) {
        boolean bl = string == null || f.g0.k.h((CharSequence)string);
        return bl ^ true;
    }

    public static final boolean f(Double d2) {
        return d2 != null && !f.z.d.k.a((Double)d2, (double)0.0);
    }
}

