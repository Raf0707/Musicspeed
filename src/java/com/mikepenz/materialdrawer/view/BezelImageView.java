/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.ColorMatrix
 *  android.graphics.ColorMatrixColorFilter
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  android.widget.ImageView
 *  androidx.appcompat.widget.AppCompatImageView
 *  b.i.q.w
 *  java.lang.Object
 *  java.lang.String
 */
package com.mikepenz.materialdrawer.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import b.i.q.w;
import c.i.c.m;
import c.i.c.n;
import c.i.c.s.b;

public class BezelImageView
extends AppCompatImageView {
    private Paint h;
    private Paint i;
    private Rect j;
    private RectF k;
    private Drawable l;
    private boolean m = true;
    private ColorMatrixColorFilter n;
    private int o = 150;
    private int p;
    private ColorFilter q;
    private boolean r = false;
    private Bitmap s;
    private int t;
    private int u;
    private boolean v = false;
    private boolean w;

    public BezelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezelImageView(Context context, AttributeSet attributeSet, int n2) {
        Paint paint;
        Paint paint2;
        Drawable drawable;
        super(context, attributeSet, n2);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, n.s, n2, m.a);
        this.l = drawable = typedArray.getDrawable(n.u);
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
        }
        this.m = typedArray.getBoolean(n.t, true);
        this.p = typedArray.getColor(n.v, 0);
        typedArray.recycle();
        this.h = paint2 = new Paint();
        paint2.setColor(-16777216);
        this.i = paint = new Paint();
        paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.s = Bitmap.createBitmap((int)1, (int)1, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.n = new ColorMatrixColorFilter(colorMatrix);
        if (this.p != 0) {
            this.q = new PorterDuffColorFilter(Color.argb((int)this.o, (int)Color.red((int)this.p), (int)Color.green((int)this.p), (int)Color.blue((int)this.p)), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.isClickable()) {
            this.w = false;
            return ImageView.super.onTouchEvent(motionEvent);
        }
        int n2 = motionEvent.getAction();
        if (n2 != 0) {
            if (n2 == 1 || n2 == 3 || n2 == 4 || n2 == 8) {
                this.w = false;
            }
        } else {
            this.w = true;
        }
        this.invalidate();
        return ImageView.super.dispatchTouchEvent(motionEvent);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.l;
        if (drawable != null && drawable.isStateful()) {
            this.l.setState(this.getDrawableState());
        }
        if (this.isDuplicateParentStateEnabled()) {
            w.h0((View)this);
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.l) {
            this.invalidate();
            return;
        }
        ImageView.super.invalidateDrawable(drawable);
    }

    protected void onDraw(Canvas canvas) {
        Rect rect = this.j;
        if (rect == null) {
            return;
        }
        int n2 = rect.width();
        int n3 = this.j.height();
        if (n2 != 0) {
            if (n3 == 0) {
                return;
            }
            if (!this.r || n2 != this.t || n3 != this.u || this.w != this.v) {
                if (n2 == this.t && n3 == this.u) {
                    this.s.eraseColor(0);
                } else {
                    this.s.recycle();
                    this.s = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                    this.t = n2;
                    this.u = n3;
                }
                Canvas canvas2 = new Canvas(this.s);
                if (this.l != null) {
                    int n4 = canvas2.save();
                    this.l.draw(canvas2);
                    if (this.w) {
                        ColorFilter colorFilter = this.q;
                        if (colorFilter != null) {
                            this.i.setColorFilter(colorFilter);
                        } else {
                            this.i.setColorFilter((ColorFilter)this.n);
                        }
                    } else {
                        this.i.setColorFilter(null);
                    }
                    canvas2.saveLayer(this.k, this.i, 31);
                    ImageView.super.onDraw(canvas2);
                    canvas2.restoreToCount(n4);
                } else if (this.w) {
                    int n5 = canvas2.save();
                    canvas2.drawRect(0.0f, 0.0f, (float)this.t, (float)this.u, this.h);
                    ColorFilter colorFilter = this.q;
                    if (colorFilter != null) {
                        this.i.setColorFilter(colorFilter);
                    } else {
                        this.i.setColorFilter((ColorFilter)this.n);
                    }
                    canvas2.saveLayer(this.k, this.i, 31);
                    ImageView.super.onDraw(canvas2);
                    canvas2.restoreToCount(n5);
                } else {
                    ImageView.super.onDraw(canvas2);
                }
            }
            Bitmap bitmap = this.s;
            Rect rect2 = this.j;
            canvas.drawBitmap(bitmap, (float)rect2.left, (float)rect2.top, null);
            this.v = this.isPressed();
        }
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        if (Build.VERSION.SDK_INT >= 21 && this.m) {
            this.setOutlineProvider(new ViewOutlineProvider(n2, n3){
                int a;
                int b;
                {
                    this.a = n2;
                    this.b = n3;
                }

                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, this.a, this.b);
                }
            });
        }
    }

    protected boolean setFrame(int n2, int n3, int n4, int n5) {
        boolean bl = ImageView.super.setFrame(n2, n3, n4, n5);
        this.j = new Rect(0, 0, n4 - n2, n5 - n3);
        this.k = new RectF(this.j);
        Drawable drawable = this.l;
        if (drawable != null) {
            drawable.setBounds(this.j);
        }
        if (bl) {
            this.r = false;
        }
        return bl;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int n2) {
        super.setImageResource(n2);
    }

    public void setImageURI(Uri uri) {
        if (!"http".equals((Object)uri.getScheme()) && !"https".equals((Object)uri.getScheme())) {
            super.setImageURI(uri);
            return;
        }
        b.a().b((ImageView)this, uri, null);
    }

    public void setSelectorColor(int n2) {
        this.p = n2;
        this.q = new PorterDuffColorFilter(Color.argb((int)this.o, (int)Color.red((int)this.p), (int)Color.green((int)this.p), (int)Color.blue((int)this.p)), PorterDuff.Mode.SRC_ATOP);
        this.invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.l || ImageView.super.verifyDrawable(drawable);
        {
        }
    }

}

