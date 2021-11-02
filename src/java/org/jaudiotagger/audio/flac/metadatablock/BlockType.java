/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.flac.metadatablock;

public final class BlockType
extends Enum<BlockType> {
    private static final /* synthetic */ BlockType[] $VALUES;
    public static final /* enum */ BlockType APPLICATION;
    public static final /* enum */ BlockType CUESHEET;
    public static final /* enum */ BlockType PADDING;
    public static final /* enum */ BlockType PICTURE;
    public static final /* enum */ BlockType SEEKTABLE;
    public static final /* enum */ BlockType STREAMINFO;
    public static final /* enum */ BlockType VORBIS_COMMENT;
    private int id;

    static {
        BlockType blockType;
        BlockType blockType2;
        BlockType blockType3;
        BlockType blockType4;
        BlockType blockType5;
        BlockType blockType6;
        BlockType blockType7;
        STREAMINFO = blockType4 = new BlockType(0);
        PADDING = blockType6 = new BlockType(1);
        APPLICATION = blockType5 = new BlockType(2);
        SEEKTABLE = blockType = new BlockType(3);
        VORBIS_COMMENT = blockType7 = new BlockType(4);
        CUESHEET = blockType2 = new BlockType(5);
        PICTURE = blockType3 = new BlockType(6);
        $VALUES = new BlockType[]{blockType4, blockType6, blockType5, blockType, blockType7, blockType2, blockType3};
    }

    private BlockType(int n3) {
        this.id = n3;
    }

    public static BlockType valueOf(String string2) {
        return (BlockType)Enum.valueOf(BlockType.class, (String)string2);
    }

    public static BlockType[] values() {
        return (BlockType[])$VALUES.clone();
    }

    public int getId() {
        return this.id;
    }
}

