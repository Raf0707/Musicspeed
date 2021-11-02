/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.l
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  rm.com.audiowave.AudioWaveView
 *  rm.com.audiowave.AudioWaveView$a
 */
package com.smp.musicspeed.markers;

import com.smp.musicspeed.dbrecord.MarkerItem;
import f.u.l;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rm.com.audiowave.AudioWaveView;

public final class h0 {
    public static final List<AudioWaveView.a> a(AudioWaveView audioWaveView, List<MarkerItem> list) {
        k.g((Object)audioWaveView, (String)"audioWaveView");
        k.g(list, (String)"markerItems");
        ArrayList arrayList = new ArrayList(l.j(list, (int)10));
        Iterator iterator = list.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            Object object = iterator.next();
            int n3 = n2 + 1;
            if (n2 < 0) {
                l.i();
            }
            MarkerItem markerItem = (MarkerItem)object;
            AudioWaveView.a a2 = new AudioWaveView.a(audioWaveView, String.valueOf((int)n3), markerItem.getPosition(), markerItem.isA(), markerItem.isB());
            arrayList.add((Object)a2);
            n2 = n3;
        }
        return arrayList;
    }
}

