/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.fragment.app.Fragment
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.k0;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import f.f;
import f.z.d.g;
import f.z.d.l;

public final class e0
extends Fragment {
    public static final a f = new Object(null){
        {
            this();
        }
    };
    private final f g = f.g.a(new f.z.c.a<Boolean>(){

        public final boolean a() {
            Bundle bundle = this.getArguments();
            if (bundle == null) {
                return false;
            }
            return bundle.getBoolean("popAdditional");
        }
    });

}

