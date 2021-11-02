/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 */
package org.jaudiotagger.audio.generic;

import java.io.IOException;
import java.io.RandomAccessFile;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.tag.Tag;

public interface TagWriter {
    public void delete(Tag var1, RandomAccessFile var2, RandomAccessFile var3) throws IOException, CannotWriteException;

    public void write(AudioFile var1, Tag var2, RandomAccessFile var3, RandomAccessFile var4) throws CannotWriteException, IOException;
}

