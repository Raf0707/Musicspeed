/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.fragment.app.Fragment
 */
package com.smp.musicspeed.playingqueue;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.smp.musicspeed.playingqueue.h;
import com.smp.musicspeed.playingqueue.q;

public class r
extends Fragment {
    private h f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setRetainInstance(true);
        this.f = new q();
    }

    public h t() {
        return this.f;
    }
}

