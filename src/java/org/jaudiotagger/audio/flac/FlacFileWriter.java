/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 */
package org.jaudiotagger.audio.flac;

import java.io.File;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.flac.FlacTagWriter;
import org.jaudiotagger.audio.generic.AudioFileWriter2;
import org.jaudiotagger.tag.Tag;

public class FlacFileWriter
extends AudioFileWriter2 {
    private FlacTagWriter tw = new FlacTagWriter();

    @Override
    protected void deleteTag(Tag tag, File file) throws CannotWriteException {
        this.tw.delete(tag, file);
    }

    @Override
    protected void writeTag(Tag tag, File file) throws CannotWriteException {
        this.tw.write(tag, file);
    }
}

