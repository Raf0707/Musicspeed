/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 */
package com.smp.musicspeed.dbrecord;

import androidx.lifecycle.LiveData;
import com.smp.musicspeed.dbrecord.PresetItem;
import f.z.d.k;
import java.util.Iterator;
import java.util.List;

public interface PresetsDao {
    public void deletePresetItems(List<PresetItem> var1);

    public void deletePresetItemsWithNames(int var1, List<String> var2);

    public List<PresetItem> getPresetItems(int var1);

    public LiveData<List<PresetItem>> getPresetItemsObservable(int var1);

    public List<PresetItem> getPresetItemsWithName(int var1, String var2);

    public void insertPresetItems(List<PresetItem> var1);

    public static final class DefaultImpls {
        public static void deletePresetItemsWithNames(PresetsDao presetsDao, int n2, List<String> list) {
            k.g((Object)presetsDao, (String)"this");
            k.g(list, (String)"names");
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                presetsDao.deletePresetItems(presetsDao.getPresetItemsWithName(n2, (String)iterator.next()));
            }
        }
    }

}

