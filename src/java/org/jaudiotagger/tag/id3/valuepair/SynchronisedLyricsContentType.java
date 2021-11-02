/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Map
 */
package org.jaudiotagger.tag.id3.valuepair;

import java.util.Map;
import org.jaudiotagger.tag.datatype.AbstractIntStringValuePair;
import org.jaudiotagger.tag.datatype.AbstractValuePair;

public class SynchronisedLyricsContentType
extends AbstractIntStringValuePair {
    public static final int CONTENT_KEY_FIELD_SIZE = 1;
    private static SynchronisedLyricsContentType eventTimingTypes;

    private SynchronisedLyricsContentType() {
        this.idToValue.put((Object)0, (Object)"other");
        this.idToValue.put((Object)1, (Object)"lyrics");
        this.idToValue.put((Object)2, (Object)"text transcription");
        this.idToValue.put((Object)3, (Object)"movement/part name");
        this.idToValue.put((Object)4, (Object)"events");
        this.idToValue.put((Object)5, (Object)"chord");
        this.idToValue.put((Object)6, (Object)"trivia");
        this.idToValue.put((Object)7, (Object)"URLs to webpages");
        this.idToValue.put((Object)8, (Object)"URLs to images");
        this.createMaps();
    }

    public static SynchronisedLyricsContentType getInstanceOf() {
        if (eventTimingTypes == null) {
            eventTimingTypes = new SynchronisedLyricsContentType();
        }
        return eventTimingTypes;
    }
}

