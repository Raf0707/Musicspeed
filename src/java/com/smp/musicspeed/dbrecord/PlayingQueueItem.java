/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.mopub.mobileads.d0
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.dbrecord;

import com.mopub.mobileads.d0;
import com.smp.musicspeed.dbrecord.MediaTrack;
import f.z.d.g;
import f.z.d.k;

public final class PlayingQueueItem {
    private final MediaTrack mediaTrack;
    private final long orderInPlayingQueue;
    private final long playingQueueItemId;

    public PlayingQueueItem(long l2, long l3, MediaTrack mediaTrack) {
        k.g((Object)mediaTrack, (String)"mediaTrack");
        this.playingQueueItemId = l2;
        this.orderInPlayingQueue = l3;
        this.mediaTrack = mediaTrack;
    }

    public /* synthetic */ PlayingQueueItem(long l2, long l3, MediaTrack mediaTrack, int n2, g g2) {
        if ((n2 & 1) != 0) {
            l2 = 0L;
        }
        this(l2, l3, mediaTrack);
    }

    public static /* synthetic */ PlayingQueueItem copy$default(PlayingQueueItem playingQueueItem, long l2, long l3, MediaTrack mediaTrack, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = playingQueueItem.playingQueueItemId;
        }
        long l4 = l2;
        if ((n2 & 2) != 0) {
            l3 = playingQueueItem.orderInPlayingQueue;
        }
        long l5 = l3;
        if ((n2 & 4) != 0) {
            mediaTrack = playingQueueItem.mediaTrack;
        }
        return playingQueueItem.copy(l4, l5, mediaTrack);
    }

    public final long component1() {
        return this.playingQueueItemId;
    }

    public final long component2() {
        return this.orderInPlayingQueue;
    }

    public final MediaTrack component3() {
        return this.mediaTrack;
    }

    public final PlayingQueueItem copy(long l2, long l3, MediaTrack mediaTrack) {
        k.g((Object)mediaTrack, (String)"mediaTrack");
        PlayingQueueItem playingQueueItem = new PlayingQueueItem(l2, l3, mediaTrack);
        return playingQueueItem;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayingQueueItem)) {
            return false;
        }
        PlayingQueueItem playingQueueItem = (PlayingQueueItem)object;
        if (this.playingQueueItemId != playingQueueItem.playingQueueItemId) {
            return false;
        }
        if (this.orderInPlayingQueue != playingQueueItem.orderInPlayingQueue) {
            return false;
        }
        return k.c((Object)this.mediaTrack, (Object)playingQueueItem.mediaTrack);
    }

    public final MediaTrack getMediaTrack() {
        return this.mediaTrack;
    }

    public final long getOrderInPlayingQueue() {
        return this.orderInPlayingQueue;
    }

    public final long getPlayingQueueItemId() {
        return this.playingQueueItemId;
    }

    public int hashCode() {
        return 31 * (31 * d0.a((long)this.playingQueueItemId) + d0.a((long)this.orderInPlayingQueue)) + this.mediaTrack.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayingQueueItem(playingQueueItemId=");
        stringBuilder.append(this.playingQueueItemId);
        stringBuilder.append(", orderInPlayingQueue=");
        stringBuilder.append(this.orderInPlayingQueue);
        stringBuilder.append(", mediaTrack=");
        stringBuilder.append((Object)this.mediaTrack);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

