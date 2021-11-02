/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.StateSet
 *  java.lang.Object
 *  java.lang.System
 */
package b.a.l.a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import b.a.l.a.b;

@SuppressLint(value={"RestrictedAPI"})
class e
extends b {
    private a r;
    private boolean s;

    e(a a2) {
        if (a2 != null) {
            this.h(a2);
        }
    }

    e(a a2, Resources resources) {
        this.h(new a(a2, this, resources));
        this.onStateChange(this.getState());
    }

    @Override
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        this.onStateChange(this.getState());
    }

    @Override
    void h(b.c c2) {
        super.h(c2);
        if (c2 instanceof a) {
            this.r = (a)c2;
        }
    }

    public boolean isStateful() {
        return true;
    }

    a j() {
        return new a(this.r, this, null);
    }

    int[] k(AttributeSet attributeSet) {
        int n2 = attributeSet.getAttributeCount();
        int[] arrn = new int[n2];
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = attributeSet.getAttributeNameResource(i2);
            if (n4 == 0 || n4 == 16842960 || n4 == 16843161) continue;
            int n5 = n3 + 1;
            if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                n4 = -n4;
            }
            arrn[n3] = n4;
            n3 = n5;
        }
        return StateSet.trimStateSet((int[])arrn, (int)n3);
    }

    @Override
    public Drawable mutate() {
        if (!this.s && super.mutate() == this) {
            this.r.r();
            this.s = true;
        }
        return this;
    }

    @Override
    protected boolean onStateChange(int[] arrn) {
        boolean bl = super.onStateChange(arrn);
        int n2 = this.r.A(arrn);
        if (n2 < 0) {
            n2 = this.r.A(StateSet.WILD_CARD);
        }
        return this.g(n2) || bl;
        {
        }
    }

    static class a
    extends b.c {
        int[][] J;

        a(a a2, e e2, Resources resources) {
            super(a2, e2, resources);
            if (a2 != null) {
                this.J = a2.J;
                return;
            }
            this.J = new int[this.f()][];
        }

        int A(int[] arrn) {
            int[][] arrn2 = this.J;
            int n2 = this.h();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!StateSet.stateSetMatches((int[])arrn2[i2], (int[])arrn)) continue;
                return i2;
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new e(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }

        @Override
        public void o(int n2, int n3) {
            super.o(n2, n3);
            int[][] arrarrn = new int[n3][];
            System.arraycopy((Object)this.J, (int)0, (Object)arrarrn, (int)0, (int)n2);
            this.J = arrarrn;
        }

        @Override
        void r() {
            int[][] arrn = this.J;
            int[][] arrarrn = new int[arrn.length][];
            for (int i2 = -1 + arrn.length; i2 >= 0; --i2) {
                int[][] arrn2 = this.J;
                int[] arrn3 = arrn2[i2] != null ? (int[])arrn2[i2].clone() : null;
                arrarrn[i2] = arrn3;
            }
            this.J = arrarrn;
        }

        int z(int[] arrn, Drawable drawable) {
            int n2 = this.a(drawable);
            this.J[n2] = arrn;
            return n2;
        }
    }

}

