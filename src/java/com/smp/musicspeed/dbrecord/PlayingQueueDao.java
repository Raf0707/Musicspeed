/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  f.u.l
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.smp.musicspeed.dbrecord;

import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.dbrecord.PlayingQueueInfo;
import com.smp.musicspeed.dbrecord.PlayingQueueInfoItem;
import com.smp.musicspeed.dbrecord.PlayingQueueItem;
import com.smp.musicspeed.dbrecord.PlayingQueueShuffleItem;
import f.u.l;
import f.z.d.g;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface PlayingQueueDao {
    public void deletePlayingQueueInfoItems(List<PlayingQueueInfoItem> var1);

    public void deletePlayingQueueItems(List<PlayingQueueItem> var1);

    public void deletePlayingQueueShuffleItems(List<PlayingQueueShuffleItem> var1);

    public List<PlayingQueueInfoItem> getAllPlayingQueueInfoItems();

    public List<PlayingQueueItem> getAllPlayingQueueItems();

    public List<PlayingQueueShuffleItem> getAllPlayingQueueShuffleItems();

    public void insertPlayingQueueInfoItems(List<PlayingQueueInfoItem> var1);

    public void insertPlayingQueueItems(List<PlayingQueueItem> var1);

    public void insertPlayingQueueShuffleItems(List<PlayingQueueShuffleItem> var1);

    public PlayingQueueInfo loadPlayingQueue();

    public void savePlayingQueue(PlayingQueueInfo var1);

    public static final class DefaultImpls {
        public static PlayingQueueInfo loadPlayingQueue(PlayingQueueDao playingQueueDao) {
            k.g((Object)playingQueueDao, (String)"this");
            List<PlayingQueueInfoItem> list = playingQueueDao.getAllPlayingQueueInfoItems();
            int n2 = true ^ list.isEmpty() ? ((PlayingQueueInfoItem)list.get(0)).getCurrentlyPlaying() : -1;
            List<PlayingQueueItem> list2 = playingQueueDao.getAllPlayingQueueItems();
            ArrayList arrayList = new ArrayList(l.j(list2, (int)10));
            Iterator iterator = list2.iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)((PlayingQueueItem)iterator.next()).getMediaTrack());
            }
            List<PlayingQueueShuffleItem> list3 = playingQueueDao.getAllPlayingQueueShuffleItems();
            ArrayList arrayList2 = new ArrayList(l.j(list3, (int)10));
            Iterator iterator2 = list3.iterator();
            while (iterator2.hasNext()) {
                arrayList2.add((Object)((PlayingQueueShuffleItem)iterator2.next()).getMapNumber());
            }
            return new PlayingQueueInfo((List<MediaTrack>)arrayList, (List<Integer>)arrayList2, n2);
        }

        public static void savePlayingQueue(PlayingQueueDao playingQueueDao, PlayingQueueInfo playingQueueInfo) {
            k.g((Object)playingQueueDao, (String)"this");
            k.g((Object)playingQueueInfo, (String)"info");
            playingQueueDao.deletePlayingQueueItems(playingQueueDao.getAllPlayingQueueItems());
            List<MediaTrack> list = playingQueueInfo.getItems();
            ArrayList arrayList = new ArrayList(l.j(list, (int)10));
            Iterator iterator = list.iterator();
            int n2 = 0;
            int n3 = 0;
            while (iterator.hasNext()) {
                Object object = iterator.next();
                int n4 = n3 + 1;
                if (n3 < 0) {
                    l.i();
                }
                MediaTrack mediaTrack = (MediaTrack)object;
                PlayingQueueItem playingQueueItem = new PlayingQueueItem(0L, n3, mediaTrack, 1, null);
                arrayList.add((Object)playingQueueItem);
                n3 = n4;
            }
            playingQueueDao.insertPlayingQueueItems((List<PlayingQueueItem>)arrayList);
            playingQueueDao.deletePlayingQueueShuffleItems(playingQueueDao.getAllPlayingQueueShuffleItems());
            List<Integer> list2 = playingQueueInfo.getShuffleMap();
            ArrayList arrayList2 = new ArrayList(l.j(list2, (int)10));
            for (Object object : list2) {
                int n5 = n2 + 1;
                if (n2 < 0) {
                    l.i();
                }
                int n6 = ((Number)object).intValue();
                PlayingQueueShuffleItem playingQueueShuffleItem = new PlayingQueueShuffleItem(0L, n2, n6, 1, null);
                arrayList2.add((Object)playingQueueShuffleItem);
                n2 = n5;
            }
            playingQueueDao.insertPlayingQueueShuffleItems((List<PlayingQueueShuffleItem>)arrayList2);
            playingQueueDao.deletePlayingQueueInfoItems(playingQueueDao.getAllPlayingQueueInfoItems());
            PlayingQueueInfoItem playingQueueInfoItem = new PlayingQueueInfoItem(0L, playingQueueInfo.getCurrentlyPlaying(), 1, null);
            playingQueueDao.insertPlayingQueueInfoItems((List<PlayingQueueInfoItem>)l.b((Object)playingQueueInfoItem));
        }
    }

}

