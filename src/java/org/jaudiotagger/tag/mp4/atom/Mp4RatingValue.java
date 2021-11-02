/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.mp4.atom;

public final class Mp4RatingValue
extends Enum<Mp4RatingValue> {
    private static final /* synthetic */ Mp4RatingValue[] $VALUES;
    public static final /* enum */ Mp4RatingValue CLEAN;
    public static final /* enum */ Mp4RatingValue EXPLICIT;
    private String description;
    private int id;

    static {
        Mp4RatingValue mp4RatingValue;
        Mp4RatingValue mp4RatingValue2;
        CLEAN = mp4RatingValue = new Mp4RatingValue("Clean", 2);
        EXPLICIT = mp4RatingValue2 = new Mp4RatingValue("Explicit", 4);
        $VALUES = new Mp4RatingValue[]{mp4RatingValue, mp4RatingValue2};
    }

    private Mp4RatingValue(String string3, int n3) {
        this.description = string3;
        this.id = n3;
    }

    public static Mp4RatingValue valueOf(String string2) {
        return (Mp4RatingValue)Enum.valueOf(Mp4RatingValue.class, (String)string2);
    }

    public static Mp4RatingValue[] values() {
        return (Mp4RatingValue[])$VALUES.clone();
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.id;
    }
}

