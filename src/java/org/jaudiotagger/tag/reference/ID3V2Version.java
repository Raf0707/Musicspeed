/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.reference;

public final class ID3V2Version
extends Enum<ID3V2Version> {
    private static final /* synthetic */ ID3V2Version[] $VALUES;
    public static final /* enum */ ID3V2Version ID3_V22;
    public static final /* enum */ ID3V2Version ID3_V23;
    public static final /* enum */ ID3V2Version ID3_V24;

    static {
        ID3V2Version iD3V2Version;
        ID3V2Version iD3V2Version2;
        ID3V2Version iD3V2Version3;
        ID3_V22 = iD3V2Version2 = new ID3V2Version();
        ID3_V23 = iD3V2Version = new ID3V2Version();
        ID3_V24 = iD3V2Version3 = new ID3V2Version();
        $VALUES = new ID3V2Version[]{iD3V2Version2, iD3V2Version, iD3V2Version3};
    }

    public static ID3V2Version valueOf(String string2) {
        return (ID3V2Version)Enum.valueOf(ID3V2Version.class, (String)string2);
    }

    public static ID3V2Version[] values() {
        return (ID3V2Version[])$VALUES.clone();
    }
}

