/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  java.lang.Object
 */
package me.zhanghai.android.materialprogressbar.internal;

import android.graphics.PorterDuff;

public class DrawableCompat {
    public static PorterDuff.Mode parseTintMode(int n2, PorterDuff.Mode mode) {
        if (n2 != 3) {
            if (n2 != 5) {
                if (n2 != 9) {
                    switch (n2) {
                        default: {
                            return mode;
                        }
                        case 16: {
                            return PorterDuff.Mode.ADD;
                        }
                        case 15: {
                            return PorterDuff.Mode.SCREEN;
                        }
                        case 14: 
                    }
                    return PorterDuff.Mode.MULTIPLY;
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}

