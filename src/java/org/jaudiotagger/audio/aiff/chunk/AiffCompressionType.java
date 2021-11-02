/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.util.HashMap;
import java.util.Map;

public final class AiffCompressionType
extends Enum<AiffCompressionType> {
    private static final /* synthetic */ AiffCompressionType[] $VALUES;
    public static final /* enum */ AiffCompressionType ALAW;
    public static final /* enum */ AiffCompressionType FL32;
    public static final /* enum */ AiffCompressionType IN24;
    public static final /* enum */ AiffCompressionType IN32;
    public static final /* enum */ AiffCompressionType MAC3;
    public static final /* enum */ AiffCompressionType MAC6;
    public static final /* enum */ AiffCompressionType NONE;
    public static final /* enum */ AiffCompressionType RAW;
    public static final /* enum */ AiffCompressionType SOWT;
    public static final /* enum */ AiffCompressionType TWOS;
    public static final /* enum */ AiffCompressionType ULAW;
    public static final /* enum */ AiffCompressionType alaw;
    public static final /* enum */ AiffCompressionType fl32;
    public static final /* enum */ AiffCompressionType ll64;
    private static final Map<String, AiffCompressionType> lookup;
    public static final /* enum */ AiffCompressionType rt24;
    public static final /* enum */ AiffCompressionType rt29;
    public static final /* enum */ AiffCompressionType ulaw;
    private final String code;
    private final String compression;
    private final String dataType;
    private final boolean isLossless;
    private final String provider;

    static {
        AiffCompressionType aiffCompressionType;
        AiffCompressionType aiffCompressionType2;
        AiffCompressionType aiffCompressionType3;
        AiffCompressionType aiffCompressionType4;
        AiffCompressionType aiffCompressionType5;
        AiffCompressionType aiffCompressionType6;
        AiffCompressionType aiffCompressionType7;
        AiffCompressionType aiffCompressionType8;
        AiffCompressionType aiffCompressionType9;
        AiffCompressionType aiffCompressionType10;
        AiffCompressionType aiffCompressionType11;
        AiffCompressionType aiffCompressionType12;
        AiffCompressionType aiffCompressionType13;
        AiffCompressionType aiffCompressionType14;
        AiffCompressionType aiffCompressionType15;
        AiffCompressionType aiffCompressionType16;
        AiffCompressionType aiffCompressionType17;
        NONE = aiffCompressionType13 = new AiffCompressionType("NONE", "not compressed", "big-endian", "Apple", true);
        RAW = aiffCompressionType11 = new AiffCompressionType("raw ", "PCM 8-bit", "offset-binary", "Apple", false);
        TWOS = aiffCompressionType9 = new AiffCompressionType("twos", "PCM 16-bit", "twos-complement little-endian", "Apple", false);
        SOWT = aiffCompressionType = new AiffCompressionType("sowt", "not compressed", "little-endian", "Apple", true);
        fl32 = aiffCompressionType15 = new AiffCompressionType("fl32", "PCM 32-bit", "floating point,", "Apple", false);
        ll64 = aiffCompressionType12 = new AiffCompressionType("fl64", "PCM 64-bit", "floating point", "Apple", false);
        IN24 = aiffCompressionType7 = new AiffCompressionType("in24", "PCM 24-bit", "integer", "Apple", false);
        IN32 = aiffCompressionType8 = new AiffCompressionType("in32", "PCM 32-bit", "integer", "Apple", false);
        alaw = aiffCompressionType14 = new AiffCompressionType("alaw", "Alaw 2:1", "8-bit ITU-T G.711 A-law", "Apple", false);
        ulaw = aiffCompressionType4 = new AiffCompressionType("ulaw", "\u00b5law 2:1", "8-bit ITU-T G.711 \u00b5-law", "Apple", false);
        MAC3 = aiffCompressionType16 = new AiffCompressionType("MAC3", "MACE 3-to-1", "", "Apple", false);
        MAC6 = aiffCompressionType3 = new AiffCompressionType("MAC6", "MACE 6-to-1", "", "Apple", false);
        ALAW = aiffCompressionType6 = new AiffCompressionType("ALAW", "CCITT G.711 A-law", "8-bit ITU-T G.711 A-law (64 kbit/s)", "SGI", false);
        ULAW = aiffCompressionType5 = new AiffCompressionType("ULAW", "CCITT G.711 u-law", "8-bit ITU-T G.711 A-law (64 kbit/s)", "SGI", false);
        FL32 = aiffCompressionType10 = new AiffCompressionType("FL32", "Float 32", "IEEE 32-bit float", "SoundHack & Csound", false);
        rt24 = aiffCompressionType17 = new AiffCompressionType("rt24", "RT24 50:1", "", "Voxware", false);
        rt29 = aiffCompressionType2 = new AiffCompressionType("rt29", "RT29 50:1", "", "Voxware", false);
        $VALUES = new AiffCompressionType[]{aiffCompressionType13, aiffCompressionType11, aiffCompressionType9, aiffCompressionType, aiffCompressionType15, aiffCompressionType12, aiffCompressionType7, aiffCompressionType8, aiffCompressionType14, aiffCompressionType4, aiffCompressionType16, aiffCompressionType3, aiffCompressionType6, aiffCompressionType5, aiffCompressionType10, aiffCompressionType17, aiffCompressionType2};
        lookup = new HashMap();
        for (AiffCompressionType aiffCompressionType18 : AiffCompressionType.values()) {
            lookup.put((Object)aiffCompressionType18.getCode(), (Object)aiffCompressionType18);
        }
    }

    private AiffCompressionType(String string3, String string4, String string5, String string6, boolean bl) {
        this.code = string3;
        this.compression = string4;
        this.dataType = string5;
        this.provider = string6;
        this.isLossless = bl;
    }

    public static AiffCompressionType getByCode(String string2) {
        return (AiffCompressionType)((Object)lookup.get((Object)string2));
    }

    public static AiffCompressionType valueOf(String string2) {
        return (AiffCompressionType)Enum.valueOf(AiffCompressionType.class, (String)string2);
    }

    public static AiffCompressionType[] values() {
        return (AiffCompressionType[])$VALUES.clone();
    }

    public String getCode() {
        return this.code;
    }

    public String getCompression() {
        return this.compression;
    }

    public String getDataType() {
        return this.dataType;
    }

    public String getProvider() {
        return this.provider;
    }

    public boolean isLossless() {
        return this.isLossless;
    }
}

