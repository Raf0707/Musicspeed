/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.effects.CompressorPrefModel
 *  com.smp.musicspeed.effects.EchoPrefModel
 *  com.smp.musicspeed.effects.EffectPrefModel
 *  com.smp.musicspeed.effects.FlangerPrefModel
 *  com.smp.musicspeed.effects.LimiterPrefModel
 *  com.smp.musicspeed.effects.MonoPrefModel
 *  com.smp.musicspeed.effects.ReverbPrefModel
 *  com.smp.musicspeed.effects.VocalPrefModel
 *  f.l
 *  f.p
 *  f.u.g0
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Map
 */
package com.smp.musicspeed.effects;

import com.smp.musicspeed.effects.CompressorPrefModel;
import com.smp.musicspeed.effects.EchoPrefModel;
import com.smp.musicspeed.effects.EffectPrefModel;
import com.smp.musicspeed.effects.FlangerPrefModel;
import com.smp.musicspeed.effects.LimiterPrefModel;
import com.smp.musicspeed.effects.MonoPrefModel;
import com.smp.musicspeed.effects.ReverbPrefModel;
import com.smp.musicspeed.effects.VocalPrefModel;
import f.l;
import f.p;
import f.u.g0;
import java.util.Map;

public final class u {
    private static final Map<Integer, EffectPrefModel> a;

    static {
        l[] arrl = new l[]{p.a((Object)0, (Object)ReverbPrefModel.m), p.a((Object)1, (Object)CompressorPrefModel.m), p.a((Object)4, (Object)VocalPrefModel.m), p.a((Object)5, (Object)EchoPrefModel.m), p.a((Object)6, (Object)MonoPrefModel.m), p.a((Object)7, (Object)FlangerPrefModel.m), p.a((Object)8, (Object)LimiterPrefModel.m)};
        a = g0.i((l[])arrl);
    }

    public static final Map<Integer, EffectPrefModel> a() {
        return a;
    }
}

