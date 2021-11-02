/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.ogg.util;

public final class VorbisPacketType
extends Enum<VorbisPacketType> {
    private static final /* synthetic */ VorbisPacketType[] $VALUES;
    public static final /* enum */ VorbisPacketType AUDIO;
    public static final /* enum */ VorbisPacketType COMMENT_HEADER;
    public static final /* enum */ VorbisPacketType IDENTIFICATION_HEADER;
    public static final /* enum */ VorbisPacketType SETUP_HEADER;
    int type;

    static {
        VorbisPacketType vorbisPacketType;
        VorbisPacketType vorbisPacketType2;
        VorbisPacketType vorbisPacketType3;
        VorbisPacketType vorbisPacketType4;
        AUDIO = vorbisPacketType3 = new VorbisPacketType(0);
        IDENTIFICATION_HEADER = vorbisPacketType2 = new VorbisPacketType(1);
        COMMENT_HEADER = vorbisPacketType = new VorbisPacketType(3);
        SETUP_HEADER = vorbisPacketType4 = new VorbisPacketType(5);
        $VALUES = new VorbisPacketType[]{vorbisPacketType3, vorbisPacketType2, vorbisPacketType, vorbisPacketType4};
    }

    private VorbisPacketType(int n3) {
        this.type = n3;
    }

    public static VorbisPacketType valueOf(String string2) {
        return (VorbisPacketType)Enum.valueOf(VorbisPacketType.class, (String)string2);
    }

    public static VorbisPacketType[] values() {
        return (VorbisPacketType[])$VALUES.clone();
    }

    public int getType() {
        return this.type;
    }
}

