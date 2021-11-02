/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.mopub.mobileads.d0
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.dbrecord;

import com.mopub.mobileads.d0;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.library.playlists.Playlist;
import f.z.d.g;
import f.z.d.k;

public final class InternalPlaylist
extends Playlist {
    private final long internalPlaylistId;
    private final String internalPlaylistName;
    private final I mediaType;

    public InternalPlaylist(long l2, String string, I i2) {
        k.g(string, "internalPlaylistName");
        k.g((Object)i2, "mediaType");
        super(string, l2, i2);
        this.internalPlaylistId = l2;
        this.internalPlaylistName = string;
        this.mediaType = i2;
    }

    public /* synthetic */ InternalPlaylist(long l2, String string, I i2, int n2, g g2) {
        if ((n2 & 1) != 0) {
            l2 = 0L;
        }
        if ((n2 & 4) != 0) {
            i2 = I.j;
        }
        this(l2, string, i2);
    }

    public static /* synthetic */ InternalPlaylist copy$default(InternalPlaylist internalPlaylist, long l2, String string, I i2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = internalPlaylist.internalPlaylistId;
        }
        if ((n2 & 2) != 0) {
            string = internalPlaylist.internalPlaylistName;
        }
        if ((n2 & 4) != 0) {
            i2 = internalPlaylist.getMediaType();
        }
        return internalPlaylist.copy(l2, string, i2);
    }

    public final long component1() {
        return this.internalPlaylistId;
    }

    public final String component2() {
        return this.internalPlaylistName;
    }

    public final I component3() {
        return this.getMediaType();
    }

    public final InternalPlaylist copy(long l2, String string, I i2) {
        k.g(string, "internalPlaylistName");
        k.g((Object)i2, "mediaType");
        return new InternalPlaylist(l2, string, i2);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof InternalPlaylist)) {
            return false;
        }
        InternalPlaylist internalPlaylist = (InternalPlaylist)object;
        if (this.internalPlaylistId != internalPlaylist.internalPlaylistId) {
            return false;
        }
        if (!k.c(this.internalPlaylistName, internalPlaylist.internalPlaylistName)) {
            return false;
        }
        return this.getMediaType() == internalPlaylist.getMediaType();
    }

    public final long getInternalPlaylistId() {
        return this.internalPlaylistId;
    }

    public final String getInternalPlaylistName() {
        return this.internalPlaylistName;
    }

    @Override
    public I getMediaType() {
        return this.mediaType;
    }

    public int hashCode() {
        return 31 * (31 * d0.a((long)this.internalPlaylistId) + this.internalPlaylistName.hashCode()) + this.getMediaType().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InternalPlaylist(internalPlaylistId=");
        stringBuilder.append(this.internalPlaylistId);
        stringBuilder.append(", internalPlaylistName=");
        stringBuilder.append(this.internalPlaylistName);
        stringBuilder.append(", mediaType=");
        stringBuilder.append((Object)this.getMediaType());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

