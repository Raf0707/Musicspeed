/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.mp4;

public final class EncoderType
extends Enum<EncoderType> {
    private static final /* synthetic */ EncoderType[] $VALUES;
    public static final /* enum */ EncoderType AAC;
    public static final /* enum */ EncoderType APPLE_LOSSLESS;
    public static final /* enum */ EncoderType DRM_AAC;
    private String description;

    static {
        EncoderType encoderType;
        EncoderType encoderType2;
        EncoderType encoderType3;
        AAC = encoderType = new EncoderType("AAC");
        DRM_AAC = encoderType2 = new EncoderType("DRM AAC");
        APPLE_LOSSLESS = encoderType3 = new EncoderType("Apple Lossless");
        $VALUES = new EncoderType[]{encoderType, encoderType2, encoderType3};
    }

    private EncoderType(String string3) {
        this.description = string3;
    }

    public static EncoderType valueOf(String string2) {
        return (EncoderType)Enum.valueOf(EncoderType.class, (String)string2);
    }

    public static EncoderType[] values() {
        return (EncoderType[])$VALUES.clone();
    }

    public String getDescription() {
        return this.description;
    }
}

