/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.id3;

public final class Id3FieldType
extends Enum<Id3FieldType> {
    private static final /* synthetic */ Id3FieldType[] $VALUES;
    public static final /* enum */ Id3FieldType BINARY;
    public static final /* enum */ Id3FieldType TEXT;
    public static final /* enum */ Id3FieldType USER_DEFINED_TEXT;

    static {
        Id3FieldType id3FieldType;
        Id3FieldType id3FieldType2;
        Id3FieldType id3FieldType3;
        TEXT = id3FieldType3 = new Id3FieldType();
        USER_DEFINED_TEXT = id3FieldType2 = new Id3FieldType();
        BINARY = id3FieldType = new Id3FieldType();
        $VALUES = new Id3FieldType[]{id3FieldType3, id3FieldType2, id3FieldType};
    }

    public static Id3FieldType valueOf(String string2) {
        return (Id3FieldType)Enum.valueOf(Id3FieldType.class, (String)string2);
    }

    public static Id3FieldType[] values() {
        return (Id3FieldType[])$VALUES.clone();
    }
}

