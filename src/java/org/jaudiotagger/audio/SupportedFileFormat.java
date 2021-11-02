/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio;

public final class SupportedFileFormat
extends Enum<SupportedFileFormat> {
    private static final /* synthetic */ SupportedFileFormat[] $VALUES;
    public static final /* enum */ SupportedFileFormat AIF;
    public static final /* enum */ SupportedFileFormat AIFC;
    public static final /* enum */ SupportedFileFormat AIFF;
    public static final /* enum */ SupportedFileFormat DSF;
    public static final /* enum */ SupportedFileFormat FLAC;
    public static final /* enum */ SupportedFileFormat M4A;
    public static final /* enum */ SupportedFileFormat M4B;
    public static final /* enum */ SupportedFileFormat M4P;
    public static final /* enum */ SupportedFileFormat MP3;
    public static final /* enum */ SupportedFileFormat MP4;
    public static final /* enum */ SupportedFileFormat OGG;
    public static final /* enum */ SupportedFileFormat RA;
    public static final /* enum */ SupportedFileFormat RM;
    public static final /* enum */ SupportedFileFormat WAV;
    public static final /* enum */ SupportedFileFormat WMA;
    private String filesuffix;

    static {
        SupportedFileFormat supportedFileFormat;
        SupportedFileFormat supportedFileFormat2;
        SupportedFileFormat supportedFileFormat3;
        SupportedFileFormat supportedFileFormat4;
        SupportedFileFormat supportedFileFormat5;
        SupportedFileFormat supportedFileFormat6;
        SupportedFileFormat supportedFileFormat7;
        SupportedFileFormat supportedFileFormat8;
        SupportedFileFormat supportedFileFormat9;
        SupportedFileFormat supportedFileFormat10;
        SupportedFileFormat supportedFileFormat11;
        SupportedFileFormat supportedFileFormat12;
        SupportedFileFormat supportedFileFormat13;
        SupportedFileFormat supportedFileFormat14;
        SupportedFileFormat supportedFileFormat15;
        OGG = supportedFileFormat11 = new SupportedFileFormat("ogg");
        MP3 = supportedFileFormat6 = new SupportedFileFormat("mp3");
        FLAC = supportedFileFormat = new SupportedFileFormat("flac");
        MP4 = supportedFileFormat10 = new SupportedFileFormat("mp4");
        M4A = supportedFileFormat5 = new SupportedFileFormat("m4a");
        M4P = supportedFileFormat2 = new SupportedFileFormat("m4p");
        WMA = supportedFileFormat9 = new SupportedFileFormat("wma");
        WAV = supportedFileFormat7 = new SupportedFileFormat("wav");
        RA = supportedFileFormat3 = new SupportedFileFormat("ra");
        RM = supportedFileFormat14 = new SupportedFileFormat("rm");
        M4B = supportedFileFormat4 = new SupportedFileFormat("m4b");
        AIF = supportedFileFormat8 = new SupportedFileFormat("aif");
        AIFF = supportedFileFormat13 = new SupportedFileFormat("aiff");
        AIFC = supportedFileFormat15 = new SupportedFileFormat("aifc");
        DSF = supportedFileFormat12 = new SupportedFileFormat("dsf");
        $VALUES = new SupportedFileFormat[]{supportedFileFormat11, supportedFileFormat6, supportedFileFormat, supportedFileFormat10, supportedFileFormat5, supportedFileFormat2, supportedFileFormat9, supportedFileFormat7, supportedFileFormat3, supportedFileFormat14, supportedFileFormat4, supportedFileFormat8, supportedFileFormat13, supportedFileFormat15, supportedFileFormat12};
    }

    private SupportedFileFormat(String string3) {
        this.filesuffix = string3;
    }

    public static SupportedFileFormat valueOf(String string2) {
        return (SupportedFileFormat)Enum.valueOf(SupportedFileFormat.class, (String)string2);
    }

    public static SupportedFileFormat[] values() {
        return (SupportedFileFormat[])$VALUES.clone();
    }

    public String getFilesuffix() {
        return this.filesuffix;
    }
}

