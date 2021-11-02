/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  com.smp.musicspeed.k0.n0.b
 *  com.smp.musicspeed.k0.r0.b
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
import com.smp.musicspeed.k0.i0.g;
import com.smp.musicspeed.k0.q;
import com.smp.musicspeed.k0.r0.b;
import com.smp.musicspeed.library.album.f;
import com.smp.musicspeed.library.playlists.j;
import f.z.d.k;

public final class y
extends q {
    public y(Context context, FragmentManager fragmentManager) {
        k.g((Object)context, "context");
        k.g((Object)fragmentManager, "fm");
        super(context, fragmentManager);
    }

    public int c() {
        return 5;
    }

    public CharSequence e(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 == 4) {
                            String string = this.t().getString(2131821046);
                            k.f(string, "mContext.getString(R.string.library_tab_playlists)");
                            return string;
                        }
                        throw new IllegalArgumentException();
                    }
                    String string = this.t().getString(2131821045);
                    k.f(string, "mContext.getString(R.string.library_tab_other)");
                    return string;
                }
                String string = this.t().getString(2131821044);
                k.f(string, "mContext.getString(R.string.library_tab_artists)");
                return string;
            }
            String string = this.t().getResources().getString(2131821043);
            k.f(string, "mContext.resources.getString(R.string.library_tab_albums)");
            return string;
        }
        String string = this.t().getResources().getString(2131821047);
        k.f(string, "mContext.resources.getString(R.string.library_tab_songs)");
        return string;
    }

    public Fragment q(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 == 4) {
                            return new j();
                        }
                        throw new IllegalArgumentException();
                    }
                    return new com.smp.musicspeed.k0.n0.b();
                }
                return new g();
            }
            return new f();
        }
        return new b();
    }
}

