/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.aiff;

public final class AiffType
extends Enum<AiffType> {
    private static final /* synthetic */ AiffType[] $VALUES;
    public static final /* enum */ AiffType AIFC;
    public static final /* enum */ AiffType AIFF;
    String code;

    static {
        AiffType aiffType;
        AiffType aiffType2;
        AIFF = aiffType = new AiffType("AIFF");
        AIFC = aiffType2 = new AiffType("AIFC");
        $VALUES = new AiffType[]{aiffType, aiffType2};
    }

    private AiffType(String string3) {
        this.code = string3;
    }

    public static AiffType valueOf(String string2) {
        return (AiffType)Enum.valueOf(AiffType.class, (String)string2);
    }

    public static AiffType[] values() {
        return (AiffType[])$VALUES.clone();
    }

    public String getCode() {
        return this.code;
    }
}

