/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.String
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.ogg;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.AudioFileWriter;
import org.jaudiotagger.audio.ogg.OggVorbisTagWriter;
import org.jaudiotagger.tag.Tag;

public class OggFileWriter
extends AudioFileWriter {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.ogg");
    private OggVorbisTagWriter vtw = new OggVorbisTagWriter();

    @Override
    protected void deleteTag(Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotReadException, CannotWriteException, IOException {
        this.vtw.delete(randomAccessFile, randomAccessFile2);
    }

    @Override
    protected void writeTag(AudioFile audioFile, Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotReadException, CannotWriteException, IOException {
        this.vtw.write(tag, randomAccessFile, randomAccessFile2);
    }
}

