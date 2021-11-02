/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package org.jaudiotagger.audio.dsf;

import java.util.HashMap;
import java.util.Map;

public final class DsfChunkType
extends Enum<DsfChunkType> {
    private static final /* synthetic */ DsfChunkType[] $VALUES;
    private static final Map<String, DsfChunkType> CODE_TYPE_MAP;
    public static final /* enum */ DsfChunkType DATA;
    public static final /* enum */ DsfChunkType DSD;
    public static final /* enum */ DsfChunkType FORMAT;
    public static final /* enum */ DsfChunkType ID3;
    private String code;

    static {
        DsfChunkType dsfChunkType;
        DsfChunkType dsfChunkType2;
        DsfChunkType dsfChunkType3;
        DsfChunkType dsfChunkType4;
        DSD = dsfChunkType3 = new DsfChunkType("DSD ");
        FORMAT = dsfChunkType4 = new DsfChunkType("fmt ");
        DATA = dsfChunkType = new DsfChunkType("data");
        ID3 = dsfChunkType2 = new DsfChunkType("ID3");
        $VALUES = new DsfChunkType[]{dsfChunkType3, dsfChunkType4, dsfChunkType, dsfChunkType2};
        CODE_TYPE_MAP = new HashMap();
    }

    private DsfChunkType(String string3) {
        this.code = string3;
    }

    public static DsfChunkType get(String string2) {
        Class<DsfChunkType> class_ = DsfChunkType.class;
        synchronized (DsfChunkType.class) {
            block6 : {
                if (!CODE_TYPE_MAP.isEmpty()) break block6;
                DsfChunkType[] arrdsfChunkType = DsfChunkType.values();
                int n2 = arrdsfChunkType.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    DsfChunkType dsfChunkType = arrdsfChunkType[i2];
                    CODE_TYPE_MAP.put((Object)dsfChunkType.getCode(), (Object)dsfChunkType);
                }
            }
            DsfChunkType dsfChunkType = (DsfChunkType)((Object)CODE_TYPE_MAP.get((Object)string2));
            // ** MonitorExit[var8_1] (shouldn't be in output)
            return dsfChunkType;
        }
    }

    public static DsfChunkType valueOf(String string2) {
        return (DsfChunkType)Enum.valueOf(DsfChunkType.class, (String)string2);
    }

    public static DsfChunkType[] values() {
        return (DsfChunkType[])$VALUES.clone();
    }

    public String getCode() {
        return this.code;
    }
}

