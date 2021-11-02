/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  com.bumptech.glide.c
 *  com.bumptech.glide.j
 *  com.bumptech.glide.k
 *  com.bumptech.glide.o.h
 *  com.bumptech.glide.o.m
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.f
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.playingqueue;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.o.h;
import com.bumptech.glide.r.a;
import com.bumptech.glide.r.f;
import com.smp.musicspeed.playingqueue.m;
import com.smp.musicspeed.playingqueue.n;

public class o
extends k {
    public o(c c2, h h2, com.bumptech.glide.o.m m2, Context context) {
        super(c2, h2, m2, context);
    }

    public <ResourceType> n<ResourceType> C(Class<ResourceType> class_) {
        return new n<ResourceType>(this.i, this, class_, this.j);
    }

    public n<Bitmap> D() {
        return (n)super.f();
    }

    public n<Drawable> E() {
        return (n)super.k();
    }

    public n<Drawable> F(Drawable drawable) {
        return (n)super.p(drawable);
    }

    public n<Drawable> G(Uri uri) {
        return (n)super.q(uri);
    }

    public n<Drawable> H(Integer n2) {
        return (n)super.r(n2);
    }

    public n<Drawable> I(Object object) {
        return (n)super.s(object);
    }

    public n<Drawable> J(String string) {
        return (n)super.t(string);
    }

    protected void y(f f2) {
        if (f2 instanceof m) {
            super.y(f2);
            return;
        }
        super.y((f)new m().i0((a<?>)f2));
    }
}

