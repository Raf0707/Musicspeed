/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.TreeSet
 */
package org.jaudiotagger.tag.id3;

import java.util.Map;
import java.util.TreeSet;
import org.jaudiotagger.tag.datatype.AbstractValuePair;
import org.jaudiotagger.tag.id3.ID3Frames;

public class ID3v2ChapterFrames
extends ID3Frames {
    public static final String FRAME_ID_CHAPTER = "CHAP";
    public static final String FRAME_ID_TABLE_OF_CONTENT = "CTOC";
    private static ID3v2ChapterFrames id3v2ChapterFrames;

    private ID3v2ChapterFrames() {
        this.idToValue.put((Object)FRAME_ID_CHAPTER, (Object)"Chapter");
        this.idToValue.put((Object)FRAME_ID_TABLE_OF_CONTENT, (Object)"Table of content");
        this.createMaps();
        this.multipleFrames = new TreeSet();
        this.discardIfFileAlteredFrames = new TreeSet();
    }

    public static ID3v2ChapterFrames getInstanceOf() {
        if (id3v2ChapterFrames == null) {
            id3v2ChapterFrames = new ID3v2ChapterFrames();
        }
        return id3v2ChapterFrames;
    }
}

