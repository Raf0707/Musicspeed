/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 */
package org.jaudiotagger.audio.mp4;

import java.io.IOException;
import java.io.RandomAccessFile;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.AudioFileWriter;
import org.jaudiotagger.audio.mp4.Mp4TagWriter;
import org.jaudiotagger.tag.Tag;

public class Mp4FileWriter
extends AudioFileWriter {
    private Mp4TagWriter tw = new Mp4TagWriter();

    @Override
    protected void deleteTag(Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws IOException {
        this.tw.delete(randomAccessFile, randomAccessFile2);
    }

    @Override
    protected void writeTag(AudioFile audioFile, Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotWriteException, IOException {
        this.tw.write(tag, randomAccessFile, randomAccessFile2);
    }
}

