/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  b.i.q.w
 *  java.lang.Object
 */
package com.smp.musicspeed.playingqueue;

import android.view.View;
import b.i.q.w;

class d0 {
    public static boolean a(View view, int n2, int n3) {
        int n4 = (int)(0.5f + w.N((View)view));
        int n5 = (int)(0.5f + w.O((View)view));
        int n6 = n4 + view.getLeft();
        int n7 = n4 + view.getRight();
        int n8 = n5 + view.getTop();
        int n9 = n5 + view.getBottom();
        return n2 >= n6 && n2 <= n7 && n3 >= n8 && n3 <= n9;
    }
}

