/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package org.jaudiotagger.tag.lyrics3;

import java.util.Map;
import org.jaudiotagger.tag.datatype.AbstractStringStringValuePair;
import org.jaudiotagger.tag.datatype.AbstractValuePair;

public class Lyrics3v2Fields
extends AbstractStringStringValuePair {
    public static final String CRLF;
    public static final String FIELD_V2_ADDITIONAL_MULTI_LINE_TEXT = "INF";
    public static final String FIELD_V2_ALBUM = "EAL";
    public static final String FIELD_V2_ARTIST = "EAR";
    public static final String FIELD_V2_AUTHOR = "AUT";
    public static final String FIELD_V2_IMAGE = "IMG";
    public static final String FIELD_V2_INDICATIONS = "IND";
    public static final String FIELD_V2_LYRICS_MULTI_LINE_TEXT = "LYR";
    public static final String FIELD_V2_TRACK = "ETT";
    private static final byte[] crlfByte;
    private static Lyrics3v2Fields lyrics3Fields;

    static {
        byte[] arrby = new byte[]{13, 10};
        crlfByte = arrby;
        CRLF = new String(arrby);
    }

    private Lyrics3v2Fields() {
        this.idToValue.put((Object)FIELD_V2_INDICATIONS, (Object)"Indications field");
        this.idToValue.put((Object)FIELD_V2_LYRICS_MULTI_LINE_TEXT, (Object)"Lyrics multi line text");
        this.idToValue.put((Object)FIELD_V2_ADDITIONAL_MULTI_LINE_TEXT, (Object)"Additional information multi line text");
        this.idToValue.put((Object)FIELD_V2_AUTHOR, (Object)"Lyrics/Music Author name");
        this.idToValue.put((Object)FIELD_V2_ALBUM, (Object)"Extended Album name");
        this.idToValue.put((Object)FIELD_V2_ARTIST, (Object)"Extended Artist name");
        this.idToValue.put((Object)FIELD_V2_TRACK, (Object)"Extended Track Title");
        this.idToValue.put((Object)FIELD_V2_IMAGE, (Object)"Link to an image files");
        this.createMaps();
    }

    public static Lyrics3v2Fields getInstanceOf() {
        if (lyrics3Fields == null) {
            lyrics3Fields = new Lyrics3v2Fields();
        }
        return lyrics3Fields;
    }

    public static boolean isLyrics3v2FieldIdentifier(String string2) {
        int n2 = string2.length();
        boolean bl = false;
        if (n2 >= 3) {
            boolean bl2 = Lyrics3v2Fields.getInstanceOf().getIdToValueMap().containsKey((Object)string2.substring(0, 3));
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }
}

