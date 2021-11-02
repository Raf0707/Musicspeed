/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 */
package org.jaudiotagger.audio.flac;

import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.flac.FlacAudioHeader;
import org.jaudiotagger.audio.flac.FlacInfoReader;
import org.jaudiotagger.audio.flac.FlacTagReader;
import org.jaudiotagger.audio.generic.AudioFileReader2;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.flac.FlacTag;

public class FlacFileReader
extends AudioFileReader2 {
    private FlacInfoReader ir = new FlacInfoReader();
    private FlacTagReader tr = new FlacTagReader();

    @Override
    protected GenericAudioHeader getEncodingInfo(File file) throws CannotReadException, IOException {
        return this.ir.read(file);
    }

    @Override
    protected Tag getTag(File file) throws CannotReadException, IOException {
        return this.tr.read(file);
    }
}

