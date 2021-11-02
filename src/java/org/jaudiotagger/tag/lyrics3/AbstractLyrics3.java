/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  org.jaudiotagger.tag.id3.ID3v1Tag
 */
package org.jaudiotagger.tag.lyrics3;

import java.io.IOException;
import java.io.RandomAccessFile;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.ID3v1Tag;

public abstract class AbstractLyrics3
extends AbstractTag {
    public AbstractLyrics3() {
    }

    public AbstractLyrics3(AbstractLyrics3 abstractLyrics3) {
        super(abstractLyrics3);
    }

    @Override
    public void delete(RandomAccessFile randomAccessFile) throws IOException {
        new ID3v1Tag();
    }
}

