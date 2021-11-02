/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.String
 */
package org.jaudiotagger.audio.wav;

import java.io.File;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.AudioFileWriter2;
import org.jaudiotagger.audio.wav.WavTagWriter;
import org.jaudiotagger.tag.Tag;

public class WavFileWriter
extends AudioFileWriter2 {
    @Override
    protected void deleteTag(Tag tag, File file) throws CannotWriteException {
        new WavTagWriter(file.getPath()).delete(tag, file);
    }

    @Override
    protected void writeTag(Tag tag, File file) throws CannotWriteException {
        new WavTagWriter(file.getPath()).write(tag, file);
    }
}

