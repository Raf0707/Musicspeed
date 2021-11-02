/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.ogg.util;

public interface VorbisHeader {
    public static final String CAPTURE_PATTERN = "vorbis";
    public static final byte[] CAPTURE_PATTERN_AS_BYTES = new byte[]{118, 111, 114, 98, 105, 115};
    public static final String CHARSET_UTF_8 = "UTF-8";
    public static final int FIELD_CAPTURE_PATTERN_LENGTH = 6;
    public static final int FIELD_CAPTURE_PATTERN_POS = 1;
    public static final int FIELD_PACKET_TYPE_LENGTH = 1;
    public static final int FIELD_PACKET_TYPE_POS;
}

