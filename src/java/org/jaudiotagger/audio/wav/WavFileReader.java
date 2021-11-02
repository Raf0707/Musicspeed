/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.lang.String
 */
package org.jaudiotagger.audio.wav;

import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.AudioFileReader2;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.wav.WavFileReader;
import org.jaudiotagger.audio.wav.WavInfoReader;
import org.jaudiotagger.audio.wav.WavOptions;
import org.jaudiotagger.audio.wav.WavTagReader;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.wav.WavTag;

public class WavFileReader
extends AudioFileReader2 {
    @Override
    protected GenericAudioHeader getEncodingInfo(File file) throws CannotReadException, IOException {
        return new WavInfoReader(file.getPath()).read(file);
    }

    @Override
    protected Tag getTag(File file) throws IOException, CannotReadException {
        WavTag wavTag = new WavTagReader(file.getPath()).read(file);
        int n2 = 1.$SwitchMap$org$jaudiotagger$audio$wav$WavOptions[TagOptionSingleton.getInstance().getWavOptions().ordinal()];
        if (n2 != 1 && n2 != 2 && n2 != 3 && n2 != 4) {
            return wavTag;
        }
        wavTag.syncTagsAfterRead();
        return wavTag;
    }
}

