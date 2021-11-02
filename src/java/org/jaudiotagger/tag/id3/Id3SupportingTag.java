/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 */
package org.jaudiotagger.tag.id3;

import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

public interface Id3SupportingTag {
    public AbstractID3v2Tag getID3Tag();

    public void setID3Tag(AbstractID3v2Tag var1);
}

