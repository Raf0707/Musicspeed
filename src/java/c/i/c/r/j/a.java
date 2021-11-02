/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.util.StateSet
 *  b.a.k.a.a
 *  c.i.c.o.b
 *  c.i.c.o.c
 *  java.lang.Object
 */
package c.i.c.r.j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import c.i.c.o.b;
import c.i.c.o.c;

public class a {
    private c.i.c.o.a a;

    public a(c.i.c.o.a a2) {
        this.a = a2;
    }

    public StateListDrawable a(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = (GradientDrawable)b.a.k.a.a.d((Context)context, (int)this.a.d());
        GradientDrawable gradientDrawable2 = (GradientDrawable)gradientDrawable.getConstantState().newDrawable().mutate();
        c.i.d.k.a.b((c.i.d.k.a)this.a.a(), context, gradientDrawable);
        if (this.a.b() == null) {
            c.i.d.k.a.b((c.i.d.k.a)this.a.a(), context, gradientDrawable2);
        } else {
            c.i.d.k.a.b((c.i.d.k.a)this.a.b(), context, gradientDrawable2);
        }
        if (this.a.c() != null) {
            gradientDrawable.setCornerRadius((float)this.a.c().a(context));
            gradientDrawable2.setCornerRadius((float)this.a.c().a(context));
        }
        stateListDrawable.addState(new int[]{16842919}, (Drawable)gradientDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, (Drawable)gradientDrawable);
        return stateListDrawable;
    }
}

