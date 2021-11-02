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
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.generic;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.AudioFileWriter;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagOptionSingleton;

public abstract class AudioFileWriter2
extends AudioFileWriter {
    @Override
    public void delete(AudioFile audioFile) throws CannotReadException, CannotWriteException {
        File file = audioFile.getFile();
        if (TagOptionSingleton.getInstance().isCheckIsWritable() && !file.canWrite()) {
            throw new CannotWriteException(ErrorMessage.GENERAL_DELETE_FAILED.getMsg(new Object[]{file}));
        }
        if (audioFile.getFile().length() > 100L) {
            this.deleteTag(audioFile.getTag(), file);
            return;
        }
        throw new CannotWriteException(ErrorMessage.GENERAL_DELETE_FAILED_BECAUSE_FILE_IS_TOO_SMALL.getMsg(new Object[]{file}));
    }

    protected abstract void deleteTag(Tag var1, File var2) throws CannotReadException, CannotWriteException;

    @Override
    public void deleteTag(Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotReadException, CannotWriteException, IOException {
        throw new UnsupportedOperationException("Old method not used in version 2");
    }

    @Override
    public void write(AudioFile audioFile) throws CannotWriteException {
        File file = audioFile.getFile();
        if (TagOptionSingleton.getInstance().isCheckIsWritable() && !file.canWrite()) {
            Logger logger = AudioFileWriter.logger;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED;
            Object[] arrobject = new Object[]{audioFile.getFile().getPath()};
            logger.severe(errorMessage.getMsg(arrobject));
            throw new CannotWriteException(ErrorMessage.GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING.getMsg(new Object[]{file}));
        }
        if (audioFile.getFile().length() > 100L) {
            this.writeTag(audioFile.getTag(), file);
            return;
        }
        throw new CannotWriteException(ErrorMessage.GENERAL_WRITE_FAILED_BECAUSE_FILE_IS_TOO_SMALL.getMsg(new Object[]{file}));
    }

    @Override
    protected void writeTag(AudioFile audioFile, Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotReadException, CannotWriteException, IOException {
        throw new UnsupportedOperationException("Old method not used in version 2");
    }

    protected abstract void writeTag(Tag var1, File var2) throws CannotWriteException;
}

