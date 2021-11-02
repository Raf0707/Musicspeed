/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.mp4;

import org.jaudiotagger.tag.reference.Tagger;

public final class Mp4NonStandardFieldKey
extends Enum<Mp4NonStandardFieldKey> {
    private static final /* synthetic */ Mp4NonStandardFieldKey[] $VALUES;
    public static final /* enum */ Mp4NonStandardFieldKey AAPR;
    public static final /* enum */ Mp4NonStandardFieldKey ADCP;
    public static final /* enum */ Mp4NonStandardFieldKey ALFN;
    public static final /* enum */ Mp4NonStandardFieldKey AMIM;
    public static final /* enum */ Mp4NonStandardFieldKey APTY;
    private String description;
    private String fieldName;
    private Tagger tagger;

    static {
        Mp4NonStandardFieldKey mp4NonStandardFieldKey;
        Mp4NonStandardFieldKey mp4NonStandardFieldKey2;
        Mp4NonStandardFieldKey mp4NonStandardFieldKey3;
        Mp4NonStandardFieldKey mp4NonStandardFieldKey4;
        Mp4NonStandardFieldKey mp4NonStandardFieldKey5;
        Tagger tagger = Tagger.MEDIA_MONKEY;
        AAPR = mp4NonStandardFieldKey2 = new Mp4NonStandardFieldKey("AApr", "MM3 Album Art Attributes", tagger);
        ALFN = mp4NonStandardFieldKey5 = new Mp4NonStandardFieldKey("Alfn", "MM3 Album Art Unknown", tagger);
        AMIM = mp4NonStandardFieldKey3 = new Mp4NonStandardFieldKey("AMIM", "MM3 Album Art MimeType", tagger);
        ADCP = mp4NonStandardFieldKey4 = new Mp4NonStandardFieldKey("Adcp", "MM3 Album Art Description", tagger);
        APTY = mp4NonStandardFieldKey = new Mp4NonStandardFieldKey("Apty", "MM3 Album Art ID3 Picture Type", tagger);
        $VALUES = new Mp4NonStandardFieldKey[]{mp4NonStandardFieldKey2, mp4NonStandardFieldKey5, mp4NonStandardFieldKey3, mp4NonStandardFieldKey4, mp4NonStandardFieldKey};
    }

    private Mp4NonStandardFieldKey(String string3, String string4, Tagger tagger) {
        this.fieldName = string3;
        this.description = string4;
        this.tagger = tagger;
    }

    public static Mp4NonStandardFieldKey valueOf(String string2) {
        return (Mp4NonStandardFieldKey)Enum.valueOf(Mp4NonStandardFieldKey.class, (String)string2);
    }

    public static Mp4NonStandardFieldKey[] values() {
        return (Mp4NonStandardFieldKey[])$VALUES.clone();
    }

    public Tagger geTagger() {
        return this.tagger;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}

