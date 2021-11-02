/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.view.View
 *  android.widget.FrameLayout
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$f
 *  com.smp.musicspeed.i0.n$a
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.i0;

import android.app.Dialog;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.smp.musicspeed.i0.n;
import f.z.d.k;

public final class n {
    public static final void a(Dialog dialog) {
        k.g((Object)dialog, (String)"dialog");
        FrameLayout frameLayout = (FrameLayout)dialog.findViewById(2131296627);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.W((View)frameLayout);
        k.f((Object)bottomSheetBehavior, (String)"from(bottomSheet)");
        bottomSheetBehavior.M((BottomSheetBehavior.f)new a(dialog, frameLayout));
    }
}

