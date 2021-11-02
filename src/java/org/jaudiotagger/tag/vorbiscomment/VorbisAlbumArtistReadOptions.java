/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.vorbiscomment;

public final class VorbisAlbumArtistReadOptions
extends Enum<VorbisAlbumArtistReadOptions> {
    private static final /* synthetic */ VorbisAlbumArtistReadOptions[] $VALUES;
    public static final /* enum */ VorbisAlbumArtistReadOptions READ_ALBUMARTIST;
    public static final /* enum */ VorbisAlbumArtistReadOptions READ_ALBUMARTIST_THEN_JRIVER;
    public static final /* enum */ VorbisAlbumArtistReadOptions READ_JRIVER_ALBUMARTIST;
    public static final /* enum */ VorbisAlbumArtistReadOptions READ_JRIVER_THEN_ALBUMARTIST;

    static {
        VorbisAlbumArtistReadOptions vorbisAlbumArtistReadOptions;
        VorbisAlbumArtistReadOptions vorbisAlbumArtistReadOptions2;
        VorbisAlbumArtistReadOptions vorbisAlbumArtistReadOptions3;
        VorbisAlbumArtistReadOptions vorbisAlbumArtistReadOptions4;
        READ_ALBUMARTIST = vorbisAlbumArtistReadOptions2 = new VorbisAlbumArtistReadOptions();
        READ_JRIVER_ALBUMARTIST = vorbisAlbumArtistReadOptions3 = new VorbisAlbumArtistReadOptions();
        READ_ALBUMARTIST_THEN_JRIVER = vorbisAlbumArtistReadOptions4 = new VorbisAlbumArtistReadOptions();
        READ_JRIVER_THEN_ALBUMARTIST = vorbisAlbumArtistReadOptions = new VorbisAlbumArtistReadOptions();
        $VALUES = new VorbisAlbumArtistReadOptions[]{vorbisAlbumArtistReadOptions2, vorbisAlbumArtistReadOptions3, vorbisAlbumArtistReadOptions4, vorbisAlbumArtistReadOptions};
    }

    public static VorbisAlbumArtistReadOptions valueOf(String string2) {
        return (VorbisAlbumArtistReadOptions)Enum.valueOf(VorbisAlbumArtistReadOptions.class, (String)string2);
    }

    public static VorbisAlbumArtistReadOptions[] values() {
        return (VorbisAlbumArtistReadOptions[])$VALUES.clone();
    }
}

