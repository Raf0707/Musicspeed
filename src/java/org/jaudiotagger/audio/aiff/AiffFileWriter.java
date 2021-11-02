/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 */
package org.jaudiotagger.audio.aiff;

import java.io.File;
import org.jaudiotagger.audio.aiff.AiffTagWriter;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.AudioFileWriter2;
import org.jaudiotagger.tag.Tag;

public class AiffFileWriter
extends AudioFileWriter2 {
    private AiffTagWriter tw = new AiffTagWriter();

    @Override
    protected void deleteTag(Tag tag, File file) throws CannotWriteException {
        this.tw.delete(tag, file);
    }

    @Override
    protected void writeTag(Tag tag, File file) throws CannotWriteException {
        this.tw.write(tag, file);
    }
}

