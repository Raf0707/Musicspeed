/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  java.lang.Object
 */
package c.i.d.k;

import android.content.Context;
import android.content.res.Resources;
import c.i.d.l.a;

public class b {
    private int a = Integer.MIN_VALUE;
    private int b = Integer.MIN_VALUE;
    private int c = Integer.MIN_VALUE;

    public int a(Context context) {
        int n2 = this.a;
        if (n2 != Integer.MIN_VALUE) {
            return n2;
        }
        int n3 = this.b;
        if (n3 != Integer.MIN_VALUE) {
            return (int)a.a(n3, context);
        }
        if (this.c != Integer.MIN_VALUE) {
            return context.getResources().getDimensionPixelSize(this.c);
        }
        return 0;
    }

    public void b(int n2) {
        this.b = n2;
    }
}

