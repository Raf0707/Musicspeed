/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 */
package c.i.d.j;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

@SuppressLint(value={"InlinedApi"})
public class a
extends StateListDrawable {
    private int f;
    private int g;

    public a(Drawable drawable, int n2, int n3) {
        Drawable drawable2 = drawable.mutate();
        this.addState(new int[]{16842913}, drawable2);
        this.addState(new int[0], drawable2);
        this.f = n2;
        this.g = n3;
    }

    public a(Drawable drawable, Drawable drawable2, int n2, int n3) {
        Drawable drawable3 = drawable.mutate();
        Drawable drawable4 = drawable2.mutate();
        this.addState(new int[]{16842913}, drawable4);
        this.addState(new int[0], drawable3);
        this.f = n2;
        this.g = n3;
    }

    public boolean isStateful() {
        return true;
    }

    protected boolean onStateChange(int[] arrn) {
        int n2 = arrn.length;
        boolean bl = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrn[i2] != 16842913) continue;
            bl = true;
        }
        if (bl) {
            super.setColorFilter(this.g, PorterDuff.Mode.SRC_IN);
        } else {
            super.setColorFilter(this.f, PorterDuff.Mode.SRC_IN);
        }
        return super.onStateChange(arrn);
    }
}

