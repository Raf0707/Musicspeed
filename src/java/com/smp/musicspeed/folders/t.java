/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.fragment.app.d
 *  f.u.g0
 *  java.io.File
 *  java.io.FileFilter
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 */
package com.smp.musicspeed.folders;

import android.content.Context;
import androidx.fragment.app.d;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.folders.BreadCrumbLayout;
import com.smp.musicspeed.folders.q;
import com.smp.musicspeed.folders.u;
import com.smp.musicspeed.folders.v;
import com.smp.musicspeed.k0.m0.f;
import f.u.g0;
import f.z.d.k;
import java.io.File;
import java.io.FileFilter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class t
extends q<Map<File, MediaTrack>> {
    private final WeakReference<v> q;
    private final Context r;

    public t(v v2, Context context) {
        k.g(v2, "foldersFragment");
        k.g((Object)context, "context");
        super((Context)v2.getActivity());
        this.q = new WeakReference((Object)v2);
        Context context2 = context.getApplicationContext();
        k.f((Object)context2, "context.applicationContext");
        this.r = context2;
    }

    public Map<File, MediaTrack> H() {
        BreadCrumbLayout.Crumb crumb;
        v v2 = (v)this.q.get();
        File file = v2 != null && (crumb = v2.B()) != null ? crumb.l() : null;
        if (file != null) {
            List<File> list = u.e(file, v.f);
            k.f(list, "listFiles(directory, FoldersFragment.AUDIO_FILE_FILTER)");
            k.e(v2);
            Collections.sort(list, v2.D(this.r));
            return g0.r(f.B(this.r, list));
        }
        return new LinkedHashMap();
    }
}

