/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.dbrecord.InternalPlaylist
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  f.u.l
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.smp.musicspeed.dbrecord;

import com.smp.musicspeed.dbrecord.InternalPlaylist;
import com.smp.musicspeed.dbrecord.InternalPlaylistItem;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import f.u.l;
import f.z.d.g;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface InternalPlaylistDao {
    public void deleteInternalPlaylist(InternalPlaylist var1);

    public void deleteInternalPlaylistItems(List<InternalPlaylistItem> var1);

    public List<InternalPlaylist> getAllPlaylists();

    public long getHighestOrderNumber(long var1);

    public InternalPlaylistItem getItemFromOrderNumber(long var1, long var3);

    public List<InternalPlaylistItem> getItemsFromIds(long var1, List<Long> var3);

    public long insertInternalPlaylist(InternalPlaylist var1);

    public /* varargs */ void insertInternalPlaylistItems(InternalPlaylistItem ... var1);

    public InternalPlaylist internalPlaylistFromId(long var1);

    public List<InternalPlaylist> internalPlaylistFromName(String var1);

    public List<InternalPlaylistItem> loadAllPlaylistItems(long var1);

    public int moveItem(long var1, int var3, int var4);

    public void removeTracksFromPlaylist(long var1, List<MediaTrack> var3);

    public void renamePlaylist(long var1, String var3);

    public int updatePlaylist(InternalPlaylist var1);

    public int updatePlaylistItems(List<InternalPlaylistItem> var1);

    public static final class DefaultImpls {
        public static int moveItem(InternalPlaylistDao internalPlaylistDao, long l2, int n2, int n3) {
            k.g((Object)internalPlaylistDao, (String)"this");
            InternalPlaylistItem internalPlaylistItem = internalPlaylistDao.getItemFromOrderNumber(l2, n2);
            InternalPlaylistItem internalPlaylistItem2 = internalPlaylistDao.getItemFromOrderNumber(l2, n3);
            InternalPlaylistItem internalPlaylistItem3 = new InternalPlaylistItem(internalPlaylistItem.getInternalPlaylistItemId(), internalPlaylistItem.getInternalPlaylistId(), internalPlaylistItem2.getOrderInPlaylist(), internalPlaylistItem.getMediaTrack());
            InternalPlaylistItem internalPlaylistItem4 = new InternalPlaylistItem(internalPlaylistItem2.getInternalPlaylistItemId(), internalPlaylistItem2.getInternalPlaylistId(), internalPlaylistItem.getOrderInPlaylist(), internalPlaylistItem2.getMediaTrack());
            return internalPlaylistDao.updatePlaylistItems((List<InternalPlaylistItem>)l.g((Object[])new InternalPlaylistItem[]{internalPlaylistItem3, internalPlaylistItem4}));
        }

        public static void removeTracksFromPlaylist(InternalPlaylistDao internalPlaylistDao, long l2, List<MediaTrack> list) {
            k.g((Object)internalPlaylistDao, (String)"this");
            k.g(list, (String)"tracks");
            ArrayList arrayList = new ArrayList(l.j(list, (int)10));
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)((MediaTrack)iterator.next()).getIdInPlaylist());
            }
            internalPlaylistDao.deleteInternalPlaylistItems(internalPlaylistDao.getItemsFromIds(l2, (List<Long>)arrayList));
            List<InternalPlaylistItem> list2 = internalPlaylistDao.loadAllPlaylistItems(l2);
            ArrayList arrayList2 = new ArrayList(l.j(list2, (int)10));
            int n2 = 0;
            for (Object object : list2) {
                int n3 = n2 + 1;
                if (n2 < 0) {
                    l.i();
                }
                InternalPlaylistItem internalPlaylistItem = (InternalPlaylistItem)object;
                InternalPlaylistItem internalPlaylistItem2 = new InternalPlaylistItem(internalPlaylistItem.getInternalPlaylistItemId(), internalPlaylistItem.getInternalPlaylistId(), n2, internalPlaylistItem.getMediaTrack());
                arrayList2.add((Object)internalPlaylistItem2);
                n2 = n3;
            }
            internalPlaylistDao.updatePlaylistItems((List<InternalPlaylistItem>)arrayList2);
        }

        public static void renamePlaylist(InternalPlaylistDao internalPlaylistDao, long l2, String string) {
            k.g((Object)internalPlaylistDao, (String)"this");
            k.g((Object)string, (String)"newName");
            InternalPlaylist internalPlaylist = internalPlaylistDao.internalPlaylistFromId(l2);
            InternalPlaylist internalPlaylist2 = new InternalPlaylist(internalPlaylist.getInternalPlaylistId(), string, null, 4, null);
            internalPlaylistDao.updatePlaylist(internalPlaylist2);
        }
    }

}

