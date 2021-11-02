/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.jaudiotagger.tag.id3.ID3v22Tag
 *  org.jaudiotagger.tag.id3.ID3v23Tag
 *  org.jaudiotagger.tag.id3.ID3v24Tag
 */
package org.jaudiotagger.audio.dsf;

import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.reference.ID3V2Version;

public class Dsf {
    public static Tag createDefaultTag() {
        if (TagOptionSingleton.getInstance().getID3V2Version() == ID3V2Version.ID3_V24) {
            return new ID3v24Tag();
        }
        if (TagOptionSingleton.getInstance().getID3V2Version() == ID3V2Version.ID3_V23) {
            return new ID3v23Tag();
        }
        if (TagOptionSingleton.getInstance().getID3V2Version() == ID3V2Version.ID3_V22) {
            return new ID3v22Tag();
        }
        return new ID3v24Tag();
    }
}

