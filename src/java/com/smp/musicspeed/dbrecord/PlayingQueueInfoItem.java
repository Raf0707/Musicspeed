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

public final class PlayingQueueInfoItem {
    private final int currentlyPlaying;
    private final long playingQueueInfoId;

    public PlayingQueueInfoItem(long l2, int n2) {
        this.playingQueueInfoId = l2;
        this.currentlyPlaying = n2;
    }

    public /* synthetic */ PlayingQueueInfoItem(long l2, int n2, int n3, g g2) {
        if ((n3 & 1) != 0) {
            l2 = 0L;
        }
        this(l2, n2);
    }

    public static /* synthetic */ PlayingQueueInfoItem copy$default(PlayingQueueInfoItem playingQueueInfoItem, long l2, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            l2 = playingQueueInfoItem.playingQueueInfoId;
        }
        if ((n3 & 2) != 0) {
            n2 = playingQueueInfoItem.currentlyPlaying;
        }
        return playingQueueInfoItem.copy(l2, n2);
    }

    public final long component1() {
        return this.playingQueueInfoId;
    }

    public final int component2() {
        return this.currentlyPlaying;
    }

    public final PlayingQueueInfoItem copy(long l2, int n2) {
        return new PlayingQueueInfoItem(l2, n2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayingQueueInfoItem)) {
            return false;
        }
        PlayingQueueInfoItem playingQueueInfoItem = (PlayingQueueInfoItem)object;
        if (this.playingQueueInfoId != playingQueueInfoItem.playingQueueInfoId) {
            return false;
        }
        return this.currentlyPlaying == playingQueueInfoItem.currentlyPlaying;
    }

    public final int getCurrentlyPlaying() {
        return this.currentlyPlaying;
    }

    public final long getPlayingQueueInfoId() {
        return this.playingQueueInfoId;
    }

    public int hashCode() {
        return 31 * d0.a((long)this.playingQueueInfoId) + this.currentlyPlaying;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayingQueueInfoItem(playingQueueInfoId=");
        stringBuilder.append(this.playingQueueInfoId);
        stringBuilder.append(", currentlyPlaying=");
        stringBuilder.append(this.currentlyPlaying);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

