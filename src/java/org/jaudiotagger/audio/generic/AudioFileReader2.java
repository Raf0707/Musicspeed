/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.generic;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.NoReadPermissionsException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.generic.AudioFileReader;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public abstract class AudioFileReader2
extends AudioFileReader {
    protected abstract GenericAudioHeader getEncodingInfo(File var1) throws CannotReadException, IOException;

    @Override
    protected GenericAudioHeader getEncodingInfo(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        throw new UnsupportedOperationException("Old method not used in version 2");
    }

    protected abstract Tag getTag(File var1) throws CannotReadException, IOException;

    @Override
    protected Tag getTag(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        throw new UnsupportedOperationException("Old method not used in version 2");
    }

    @Override
    public AudioFile read(File file) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        if (AudioFileReader.logger.isLoggable(Level.CONFIG)) {
            Logger logger = AudioFileReader.logger;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_READ;
            Object[] arrobject = new Object[]{file.getPath()};
            logger.config(errorMessage.getMsg(arrobject));
        }
        if (file.canRead()) {
            if (file.length() > 100L) {
                return new AudioFile(file, (AudioHeader)this.getEncodingInfo(file), this.getTag(file));
            }
            ErrorMessage errorMessage = ErrorMessage.GENERAL_READ_FAILED_FILE_TOO_SMALL;
            Object[] arrobject = new Object[]{file.getPath()};
            throw new CannotReadException(errorMessage.getMsg(arrobject));
        }
        ErrorMessage errorMessage = ErrorMessage.GENERAL_READ_FAILED_DO_NOT_HAVE_PERMISSION_TO_READ_FILE;
        Object[] arrobject = new Object[]{file.getPath()};
        throw new NoReadPermissionsException(errorMessage.getMsg(arrobject));
    }
}

