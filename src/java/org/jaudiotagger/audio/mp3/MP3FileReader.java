/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package org.jaudiotagger.audio.mp3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.generic.AudioFileReader;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class MP3FileReader
extends AudioFileReader {
    @Override
    protected GenericAudioHeader getEncodingInfo(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        throw new RuntimeException("MP3FileReader.getEncodingInfo should be called");
    }

    @Override
    protected Tag getTag(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        throw new RuntimeException("MP3FileReader.getEncodingInfo should be called");
    }

    @Override
    public AudioFile read(File file) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        return new MP3File(file, 6, true);
    }

    public AudioFile readMustBeWritable(File file) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        return new MP3File(file, 6, false);
    }
}

