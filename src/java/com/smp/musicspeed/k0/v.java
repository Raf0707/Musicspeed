/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  com.smp.musicspeed.f0.c
 *  com.smp.musicspeed.f0.e
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.k0;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.smp.musicspeed.f0.c;
import com.smp.musicspeed.f0.e;
import com.smp.musicspeed.k0.q;
import f.z.d.k;

public final class v
extends q {
    public v(Context context, FragmentManager fragmentManager) {
        k.g((Object)context, "context");
        k.g((Object)fragmentManager, "fm");
        super(context, fragmentManager);
    }

    public int c() {
        return 2;
    }

    public CharSequence e(int n2) {
        if (n2 != 0) {
            if (n2 == 1) {
                String string = this.t().getResources().getString(2131820705);
                k.f(string, "mContext.resources.getString(R.string.creations_tab_recordings)");
                return string;
            }
            throw new IllegalArgumentException();
        }
        String string = this.t().getResources().getString(2131820704);
        k.f(string, "mContext.resources.getString(R.string.creations_tab_edited)");
        return string;
    }

    public Fragment q(int n2) {
        if (n2 != 0) {
            if (n2 == 1) {
                return new e();
            }
            throw new IllegalArgumentException();
        }
        return new c();
    }
}

