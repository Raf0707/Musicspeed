/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  f.z.d.k
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 */
package com.smp.musicspeed.dbrecord;

import androidx.lifecycle.LiveData;
import com.smp.musicspeed.dbrecord.MarkerItem;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public interface MarkersDao {
    public void addMarkerItemDeleteClose(MarkerItem var1);

    public /* varargs */ void deleteMarkerItems(MarkerItem ... var1);

    public void deleteMarkerItemsForTrack(String var1, long var2);

    public /* varargs */ void insertMarkerItems(MarkerItem ... var1);

    public LiveData<List<MarkerItem>> loadAllMarkerItems(String var1, long var2);

    public List<MarkerItem> loadAllMarkerItemsList(String var1, long var2);

    public /* varargs */ void updateMarkerItems(MarkerItem ... var1);

    public static final class DefaultImpls {
        public static void addMarkerItemDeleteClose(MarkersDao markersDao, MarkerItem markerItem) {
            int n2;
            k.g((Object)markersDao, (String)"this");
            k.g((Object)markerItem, (String)"newMarkerItem");
            List<MarkerItem> list = markersDao.loadAllMarkerItemsList(markerItem.getFile(), markerItem.getDurationUs());
            long l2 = markerItem.getDurationUs() / (long)1000;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = list.iterator();
            do {
                double d2;
                boolean bl = iterator.hasNext();
                n2 = 1;
                if (!bl) break;
                Object object = iterator.next();
                double d3 = ((MarkerItem)object).getPosition();
                if (Math.abs((long)((long)(d3 * (d2 = (double)l2)) - (long)(d2 * (double)markerItem.getPosition()))) >= 100L) {
                    n2 = 0;
                }
                if (n2 == 0) continue;
                arrayList.add(object);
            } while (true);
            Object[] arrobject = arrayList.toArray((Object[])new MarkerItem[0]);
            Objects.requireNonNull((Object)arrobject, (String)"null cannot be cast to non-null type kotlin.Array<T>");
            Object[] arrobject2 = (MarkerItem[])arrobject;
            markersDao.deleteMarkerItems((MarkerItem[])Arrays.copyOf((Object[])arrobject2, (int)arrobject2.length));
            MarkerItem[] arrmarkerItem = new MarkerItem[n2];
            arrmarkerItem[0] = markerItem;
            markersDao.insertMarkerItems(arrmarkerItem);
        }

        public static void deleteMarkerItemsForTrack(MarkersDao markersDao, String string, long l2) {
            k.g((Object)markersDao, (String)"this");
            k.g((Object)string, (String)"file");
            Object[] arrobject = markersDao.loadAllMarkerItemsList(string, l2).toArray((Object[])new MarkerItem[0]);
            Objects.requireNonNull((Object)arrobject, (String)"null cannot be cast to non-null type kotlin.Array<T>");
            Object[] arrobject2 = (MarkerItem[])arrobject;
            markersDao.deleteMarkerItems((MarkerItem[])Arrays.copyOf((Object[])arrobject2, (int)arrobject2.length));
        }
    }

}

