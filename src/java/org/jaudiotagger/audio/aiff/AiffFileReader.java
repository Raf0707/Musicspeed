/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 */
package org.jaudiotagger.audio.aiff;

import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.aiff.AiffInfoReader;
import org.jaudiotagger.audio.aiff.AiffTagReader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.AudioFileReader2;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.aiff.AiffTag;

public class AiffFileReader
extends AudioFileReader2 {
    private AiffTagReader im = new AiffTagReader();
    private AiffInfoReader ir = new AiffInfoReader();

    @Override
    protected GenericAudioHeader getEncodingInfo(File file) throws CannotReadException, IOException {
        return this.ir.read(file);
    }

    @Override
    protected Tag getTag(File file) throws CannotReadException, IOException {
        return this.im.read(file);
    }
}

