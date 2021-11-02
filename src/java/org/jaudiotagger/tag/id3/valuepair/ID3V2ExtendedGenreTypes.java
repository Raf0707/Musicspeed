/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.id3.valuepair;

public final class ID3V2ExtendedGenreTypes
extends Enum<ID3V2ExtendedGenreTypes> {
    private static final /* synthetic */ ID3V2ExtendedGenreTypes[] $VALUES;
    public static final /* enum */ ID3V2ExtendedGenreTypes CR;
    public static final /* enum */ ID3V2ExtendedGenreTypes RX;
    private String description;

    static {
        ID3V2ExtendedGenreTypes iD3V2ExtendedGenreTypes;
        ID3V2ExtendedGenreTypes iD3V2ExtendedGenreTypes2;
        RX = iD3V2ExtendedGenreTypes2 = new ID3V2ExtendedGenreTypes("Remix");
        CR = iD3V2ExtendedGenreTypes = new ID3V2ExtendedGenreTypes("Cover");
        $VALUES = new ID3V2ExtendedGenreTypes[]{iD3V2ExtendedGenreTypes2, iD3V2ExtendedGenreTypes};
    }

    private ID3V2ExtendedGenreTypes(String string3) {
        this.description = string3;
    }

    public static ID3V2ExtendedGenreTypes valueOf(String string2) {
        return (ID3V2ExtendedGenreTypes)Enum.valueOf(ID3V2ExtendedGenreTypes.class, (String)string2);
    }

    public static ID3V2ExtendedGenreTypes[] values() {
        return (ID3V2ExtendedGenreTypes[])$VALUES.clone();
    }

    public String getDescription() {
        return this.description;
    }
}

