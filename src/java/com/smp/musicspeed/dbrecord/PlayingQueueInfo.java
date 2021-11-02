/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  f.z.d.k
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.smp.musicspeed.dbrecord;

import com.smp.musicspeed.dbrecord.MediaTrack;
import f.z.d.k;
import java.util.List;

public final class PlayingQueueInfo {
    private final int currentlyPlaying;
    private final List<MediaTrack> items;
    private final List<Integer> shuffleMap;

    public PlayingQueueInfo(List<MediaTrack> list, List<Integer> list2, int n2) {
        k.g(list, (String)"items");
        k.g(list2, (String)"shuffleMap");
        this.items = list;
        this.shuffleMap = list2;
        this.currentlyPlaying = n2;
    }

    public static /* synthetic */ PlayingQueueInfo copy$default(PlayingQueueInfo playingQueueInfo, List list, List list2, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            list = playingQueueInfo.items;
        }
        if ((n3 & 2) != 0) {
            list2 = playingQueueInfo.shuffleMap;
        }
        if ((n3 & 4) != 0) {
            n2 = playingQueueInfo.currentlyPlaying;
        }
        return playingQueueInfo.copy(list, list2, n2);
    }

    public final List<MediaTrack> component1() {
        return this.items;
    }

    public final List<Integer> component2() {
        return this.shuffleMap;
    }

    public final int component3() {
        return this.currentlyPlaying;
    }

    public final PlayingQueueInfo copy(List<MediaTrack> list, List<Integer> list2, int n2) {
        k.g(list, (String)"items");
        k.g(list2, (String)"shuffleMap");
        return new PlayingQueueInfo(list, list2, n2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayingQueueInfo)) {
            return false;
        }
        PlayingQueueInfo playingQueueInfo = (PlayingQueueInfo)object;
        if (!k.c(this.items, playingQueueInfo.items)) {
            return false;
        }
        if (!k.c(this.shuffleMap, playingQueueInfo.shuffleMap)) {
            return false;
        }
        return this.currentlyPlaying == playingQueueInfo.currentlyPlaying;
    }

    public final int getCurrentlyPlaying() {
        return this.currentlyPlaying;
    }

    public final List<MediaTrack> getItems() {
        return this.items;
    }

    public final List<Integer> getShuffleMap() {
        return this.shuffleMap;
    }

    public int hashCode() {
        return 31 * (31 * this.items.hashCode() + this.shuffleMap.hashCode()) + this.currentlyPlaying;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayingQueueInfo(items=");
        stringBuilder.append(this.items);
        stringBuilder.append(", shuffleMap=");
        stringBuilder.append(this.shuffleMap);
        stringBuilder.append(", currentlyPlaying=");
        stringBuilder.append(this.currentlyPlaying);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

