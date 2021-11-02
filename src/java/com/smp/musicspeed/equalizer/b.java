/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.x
 *  com.smp.musicspeed.equalizer.EqualizerFragment
 *  java.lang.Object
 *  java.util.List
 */
package com.smp.musicspeed.equalizer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import com.smp.musicspeed.equalizer.EqualizerFragment;
import java.util.List;

public final class b
implements x {
    public final /* synthetic */ EqualizerFragment a;
    public final /* synthetic */ LiveData b;

    public /* synthetic */ b(EqualizerFragment equalizerFragment, LiveData liveData) {
        this.a = equalizerFragment;
        this.b = liveData;
    }

    public final void a(Object object) {
        this.a.S(this.b, (List)object);
    }
}

