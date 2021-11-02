/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package org.jaudiotagger.tag.reference;

import java.util.Map;
import org.jaudiotagger.tag.datatype.AbstractIntStringValuePair;
import org.jaudiotagger.tag.datatype.AbstractValuePair;

public class PictureTypes
extends AbstractIntStringValuePair {
    public static final Integer DEFAULT_ID = 3;
    public static final String DEFAULT_VALUE = "Cover (front)";
    public static final int PICTURE_TYPE_FIELD_SIZE = 1;
    private static PictureTypes pictureTypes;

    private PictureTypes() {
        this.idToValue.put((Object)0, (Object)"Other");
        this.idToValue.put((Object)1, (Object)"32x32 pixels 'file icon' (PNG only)");
        this.idToValue.put((Object)2, (Object)"Other file icon");
        this.idToValue.put((Object)3, (Object)DEFAULT_VALUE);
        this.idToValue.put((Object)4, (Object)"Cover (back)");
        this.idToValue.put((Object)5, (Object)"Leaflet page");
        this.idToValue.put((Object)6, (Object)"Media (e.g. label side of CD)");
        this.idToValue.put((Object)7, (Object)"Lead artist/lead performer/soloist");
        this.idToValue.put((Object)8, (Object)"Artist/performer");
        this.idToValue.put((Object)9, (Object)"Conductor");
        this.idToValue.put((Object)10, (Object)"Band/Orchestra");
        this.idToValue.put((Object)11, (Object)"Composer");
        this.idToValue.put((Object)12, (Object)"Lyricist/text writer");
        this.idToValue.put((Object)13, (Object)"Recording Location");
        this.idToValue.put((Object)14, (Object)"During recording");
        this.idToValue.put((Object)15, (Object)"During performance");
        this.idToValue.put((Object)16, (Object)"Movie/video screen capture");
        this.idToValue.put((Object)17, (Object)"A bright coloured fish");
        this.idToValue.put((Object)18, (Object)"Illustration");
        this.idToValue.put((Object)19, (Object)"Band/artist logotype");
        this.idToValue.put((Object)20, (Object)"Publisher/Studio logotype");
        this.createMaps();
    }

    public static PictureTypes getInstanceOf() {
        if (pictureTypes == null) {
            pictureTypes = new PictureTypes();
        }
        return pictureTypes;
    }
}

