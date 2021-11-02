/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.vorbiscomment;

public final class VorbisAlbumArtistSaveOptions
extends Enum<VorbisAlbumArtistSaveOptions> {
    private static final /* synthetic */ VorbisAlbumArtistSaveOptions[] $VALUES;
    public static final /* enum */ VorbisAlbumArtistSaveOptions WRITE_ALBUMARTIST;
    public static final /* enum */ VorbisAlbumArtistSaveOptions WRITE_ALBUMARTIST_AND_DELETE_JRIVER_ALBUMARTIST;
    public static final /* enum */ VorbisAlbumArtistSaveOptions WRITE_BOTH;
    public static final /* enum */ VorbisAlbumArtistSaveOptions WRITE_JRIVER_ALBUMARTIST;
    public static final /* enum */ VorbisAlbumArtistSaveOptions WRITE_JRIVER_ALBUMARTIST_AND_DELETE_ALBUMARTIST;

    static {
        VorbisAlbumArtistSaveOptions vorbisAlbumArtistSaveOptions;
        VorbisAlbumArtistSaveOptions vorbisAlbumArtistSaveOptions2;
        VorbisAlbumArtistSaveOptions vorbisAlbumArtistSaveOptions3;
        VorbisAlbumArtistSaveOptions vorbisAlbumArtistSaveOptions4;
        VorbisAlbumArtistSaveOptions vorbisAlbumArtistSaveOptions5;
        WRITE_ALBUMARTIST = vorbisAlbumArtistSaveOptions2 = new VorbisAlbumArtistSaveOptions();
        WRITE_JRIVER_ALBUMARTIST = vorbisAlbumArtistSaveOptions5 = new VorbisAlbumArtistSaveOptions();
        WRITE_BOTH = vorbisAlbumArtistSaveOptions = new VorbisAlbumArtistSaveOptions();
        WRITE_ALBUMARTIST_AND_DELETE_JRIVER_ALBUMARTIST = vorbisAlbumArtistSaveOptions4 = new VorbisAlbumArtistSaveOptions();
        WRITE_JRIVER_ALBUMARTIST_AND_DELETE_ALBUMARTIST = vorbisAlbumArtistSaveOptions3 = new VorbisAlbumArtistSaveOptions();
        $VALUES = new VorbisAlbumArtistSaveOptions[]{vorbisAlbumArtistSaveOptions2, vorbisAlbumArtistSaveOptions5, vorbisAlbumArtistSaveOptions, vorbisAlbumArtistSaveOptions4, vorbisAlbumArtistSaveOptions3};
    }

    public static VorbisAlbumArtistSaveOptions valueOf(String string2) {
        return (VorbisAlbumArtistSaveOptions)Enum.valueOf(VorbisAlbumArtistSaveOptions.class, (String)string2);
    }

    public static VorbisAlbumArtistSaveOptions[] values() {
        return (VorbisAlbumArtistSaveOptions[])$VALUES.clone();
    }
}

