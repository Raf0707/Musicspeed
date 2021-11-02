/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.mopub.mobileads.d0
 *  f.z.d.g
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.dbrecord;

import com.mopub.mobileads.d0;
import f.z.d.g;

public final class PlayingQueueShuffleItem {
    private final int mapNumber;
    private final long orderInShuffleMap;
    private final long playingQueueShuffleItemId;

    public PlayingQueueShuffleItem(long l2, long l3, int n2) {
        this.playingQueueShuffleItemId = l2;
        this.orderInShuffleMap = l3;
        this.mapNumber = n2;
    }

    public /* synthetic */ PlayingQueueShuffleItem(long l2, long l3, int n2, int n3, g g2) {
        if ((n3 & 1) != 0) {
            l2 = 0L;
        }
        this(l2, l3, n2);
    }

    public static /* synthetic */ PlayingQueueShuffleItem copy$default(PlayingQueueShuffleItem playingQueueShuffleItem, long l2, long l3, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            l2 = playingQueueShuffleItem.playingQueueShuffleItemId;
        }
        long l4 = l2;
        if ((n3 & 2) != 0) {
            l3 = playingQueueShuffleItem.orderInShuffleMap;
        }
        long l5 = l3;
        if ((n3 & 4) != 0) {
            n2 = playingQueueShuffleItem.mapNumber;
        }
        return playingQueueShuffleItem.copy(l4, l5, n2);
    }

    public final long component1() {
        return this.playingQueueShuffleItemId;
    }

    public final long component2() {
        return this.orderInShuffleMap;
    }

    public final int component3() {
        return this.mapNumber;
    }

    public final PlayingQueueShuffleItem copy(long l2, long l3, int n2) {
        PlayingQueueShuffleItem playingQueueShuffleItem = new PlayingQueueShuffleItem(l2, l3, n2);
        return playingQueueShuffleItem;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayingQueueShuffleItem)) {
            return false;
        }
        PlayingQueueShuffleItem playingQueueShuffleItem = (PlayingQueueShuffleItem)object;
        if (this.playingQueueShuffleItemId != playingQueueShuffleItem.playingQueueShuffleItemId) {
            return false;
        }
        if (this.orderInShuffleMap != playingQueueShuffleItem.orderInShuffleMap) {
            return false;
        }
        return this.mapNumber == playingQueueShuffleItem.mapNumber;
    }

    public final int getMapNumber() {
        return this.mapNumber;
    }

    public final long getOrderInShuffleMap() {
        return this.orderInShuffleMap;
    }

    public final long getPlayingQueueShuffleItemId() {
        return this.playingQueueShuffleItemId;
    }

    public int hashCode() {
        return 31 * (31 * d0.a((long)this.playingQueueShuffleItemId) + d0.a((long)this.orderInShuffleMap)) + this.mapNumber;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayingQueueShuffleItem(playingQueueShuffleItemId=");
        stringBuilder.append(this.playingQueueShuffleItemId);
        stringBuilder.append(", orderInShuffleMap=");
        stringBuilder.append(this.orderInShuffleMap);
        stringBuilder.append(", mapNumber=");
        stringBuilder.append(this.mapNumber);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

