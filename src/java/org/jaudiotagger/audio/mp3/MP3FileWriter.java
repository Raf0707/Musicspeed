/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.RuntimeException
 *  java.lang.String
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 *  org.jaudiotagger.tag.id3.ID3v1Tag
 */
package org.jaudiotagger.audio.mp3;

import java.io.IOException;
import java.io.RandomAccessFile;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.AudioFileWriter;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v1Tag;

public class MP3FileWriter
extends AudioFileWriter {
    @Override
    public void delete(AudioFile audioFile) throws CannotReadException, CannotWriteException {
        MP3FileWriter mP3FileWriter = this;
        synchronized (mP3FileWriter) {
            ((MP3File)audioFile).setID3v1Tag((ID3v1Tag)null);
            ((MP3File)audioFile).setID3v2Tag((AbstractID3v2Tag)null);
            audioFile.commit();
            return;
        }
    }

    public void deleteTag(AudioFile audioFile) throws CannotWriteException {
        audioFile.commit();
    }

    @Override
    protected void deleteTag(Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotWriteException, IOException {
        throw new RuntimeException("MP3FileReader.getEncodingInfo should be called");
    }

    public void writeFile(AudioFile audioFile) throws CannotWriteException {
        audioFile.commit();
    }

    @Override
    protected void writeTag(AudioFile audioFile, Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotWriteException, IOException {
        throw new RuntimeException("MP3FileReaderwriteTag should not be called");
    }
}

