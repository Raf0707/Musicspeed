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
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.AudioFileReader;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.mp4.Mp4InfoReader;
import org.jaudiotagger.audio.mp4.Mp4TagReader;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.mp4.Mp4Tag;

public class Mp4FileReader
extends AudioFileReader {
    private Mp4InfoReader ir = new Mp4InfoReader();
    private Mp4TagReader tr = new Mp4TagReader();

    @Override
    protected GenericAudioHeader getEncodingInfo(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        return this.ir.read(randomAccessFile);
    }

    @Override
    protected Tag getTag(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        return this.tr.read(randomAccessFile);
    }
}

