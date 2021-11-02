/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.Rect
 *  java.lang.Object
 */
package com.wnafee.vector.compat;

import android.graphics.Path;
import android.graphics.Rect;

public final class Outline {
    public float mAlpha;
    public Path mPath;
    public float mRadius;
    public Rect mRect;

    public Outline() {
    }

    public Outline(Outline outline) {
        this.set(outline);
    }

    public boolean canClip() {
        return !this.isEmpty() && this.mRect != null;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public boolean isEmpty() {
        return this.mRect == null && this.mPath == null;
    }

    public void set(Outline outline) {
        if (outline.mPath != null) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            this.mPath.set(outline.mPath);
            this.mRect = null;
        }
        if (outline.mRect != null) {
            if (this.mRect == null) {
                this.mRect = new Rect();
            }
            this.mRect.set(outline.mRect);
        }
        this.mRadius = outline.mRadius;
        this.mAlpha = outline.mAlpha;
    }

    public void setAlpha(float f2) {
        this.mAlpha = f2;
    }

    public void setEmpty() {
        this.mPath = null;
        this.mRect = null;
        this.mRadius = 0.0f;
    }

    public void setRect(int n2, int n3, int n4, int n5) {
        this.setRoundRect(n2, n3, n4, n5, 0.0f);
    }

    public void setRect(Rect rect) {
        this.setRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setRoundRect(int n2, int n3, int n4, int n5, float f2) {
        if (n2 < n4 && n3 < n5) {
            if (this.mRect == null) {
                this.mRect = new Rect();
            }
            this.mRect.set(n2, n3, n4, n5);
            this.mRadius = f2;
            this.mPath = null;
            return;
        }
        this.setEmpty();
    }

    public void setRoundRect(Rect rect, float f2) {
        this.setRoundRect(rect.left, rect.top, rect.right, rect.bottom, f2);
    }
}

