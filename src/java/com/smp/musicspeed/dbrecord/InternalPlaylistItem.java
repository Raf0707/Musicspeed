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

public final class InternalPlaylistItem {
    private final long internalPlaylistId;
    private final long internalPlaylistItemId;
    private final MediaTrack mediaTrack;
    private final long orderInPlaylist;

    public InternalPlaylistItem(long l2, long l3, long l4, MediaTrack mediaTrack) {
        k.g((Object)mediaTrack, (String)"mediaTrack");
        this.internalPlaylistItemId = l2;
        this.internalPlaylistId = l3;
        this.orderInPlaylist = l4;
        this.mediaTrack = mediaTrack;
    }

    public /* synthetic */ InternalPlaylistItem(long l2, long l3, long l4, MediaTrack mediaTrack, int n2, g g2) {
        long l5 = (n2 & 1) != 0 ? 0L : l2;
        this(l5, l3, l4, mediaTrack);
    }

    public static /* synthetic */ InternalPlaylistItem copy$default(InternalPlaylistItem internalPlaylistItem, long l2, long l3, long l4, MediaTrack mediaTrack, int n2, Object object) {
        long l5 = (n2 & 1) != 0 ? internalPlaylistItem.internalPlaylistItemId : l2;
        long l6 = (n2 & 2) != 0 ? internalPlaylistItem.internalPlaylistId : l3;
        long l7 = (n2 & 4) != 0 ? internalPlaylistItem.orderInPlaylist : l4;
        MediaTrack mediaTrack2 = (n2 & 8) != 0 ? internalPlaylistItem.mediaTrack : mediaTrack;
        return internalPlaylistItem.copy(l5, l6, l7, mediaTrack2);
    }

    public final long component1() {
        return this.internalPlaylistItemId;
    }

    public final long component2() {
        return this.internalPlaylistId;
    }

    public final long component3() {
        return this.orderInPlaylist;
    }

    public final MediaTrack component4() {
        return this.mediaTrack;
    }

    public final InternalPlaylistItem copy(long l2, long l3, long l4, MediaTrack mediaTrack) {
        k.g((Object)mediaTrack, (String)"mediaTrack");
        InternalPlaylistItem internalPlaylistItem = new InternalPlaylistItem(l2, l3, l4, mediaTrack);
        return internalPlaylistItem;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof InternalPlaylistItem)) {
            return false;
        }
        InternalPlaylistItem internalPlaylistItem = (InternalPlaylistItem)object;
        if (this.internalPlaylistItemId != internalPlaylistItem.internalPlaylistItemId) {
            return false;
        }
        if (this.internalPlaylistId != internalPlaylistItem.internalPlaylistId) {
            return false;
        }
        if (this.orderInPlaylist != internalPlaylistItem.orderInPlaylist) {
            return false;
        }
        return k.c((Object)this.mediaTrack, (Object)internalPlaylistItem.mediaTrack);
    }

    public final long getInternalPlaylistId() {
        return this.internalPlaylistId;
    }

    public final long getInternalPlaylistItemId() {
        return this.internalPlaylistItemId;
    }

    public final MediaTrack getMediaTrack() {
        return this.mediaTrack;
    }

    public final long getOrderInPlaylist() {
        return this.orderInPlaylist;
    }

    public int hashCode() {
        return 31 * (31 * (31 * d0.a((long)this.internalPlaylistItemId) + d0.a((long)this.internalPlaylistId)) + d0.a((long)this.orderInPlaylist)) + this.mediaTrack.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InternalPlaylistItem(internalPlaylistItemId=");
        stringBuilder.append(this.internalPlaylistItemId);
        stringBuilder.append(", internalPlaylistId=");
        stringBuilder.append(this.internalPlaylistId);
        stringBuilder.append(", orderInPlaylist=");
        stringBuilder.append(this.orderInPlaylist);
        stringBuilder.append(", mediaTrack=");
        stringBuilder.append((Object)this.mediaTrack);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

