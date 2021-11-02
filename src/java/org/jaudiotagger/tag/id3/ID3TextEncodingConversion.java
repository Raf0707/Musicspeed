/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.id3.AbstractTagFrame
 *  org.jaudiotagger.tag.id3.ID3v24Frame
 */
package org.jaudiotagger.tag.id3;

import java.util.logging.Logger;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.AbstractTagFrame;
import org.jaudiotagger.tag.id3.ID3v24Frame;

public class ID3TextEncodingConversion {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.id3");

    private static byte convertV24textEncodingToV23textEncoding(byte by) {
        if (by == 2) {
            return 1;
        }
        if (by == 3) {
            by = 0;
        }
        return by;
    }

    public static byte getTextEncoding(AbstractTagFrame abstractTagFrame, byte by) {
        if (abstractTagFrame == null) {
            logger.warning("Header has not yet been set for this framebody");
            if (TagOptionSingleton.getInstance().isResetTextEncodingForExistingFrames()) {
                return TagOptionSingleton.getInstance().getId3v23DefaultTextEncoding();
            }
            return ID3TextEncodingConversion.convertV24textEncodingToV23textEncoding(by);
        }
        if (abstractTagFrame instanceof ID3v24Frame) {
            if (TagOptionSingleton.getInstance().isResetTextEncodingForExistingFrames()) {
                return TagOptionSingleton.getInstance().getId3v24DefaultTextEncoding();
            }
            return by;
        }
        if (TagOptionSingleton.getInstance().isResetTextEncodingForExistingFrames()) {
            return TagOptionSingleton.getInstance().getId3v23DefaultTextEncoding();
        }
        return ID3TextEncodingConversion.convertV24textEncodingToV23textEncoding(by);
    }

    public static byte getUnicodeTextEncoding(AbstractTagFrame abstractTagFrame) {
        if (abstractTagFrame == null) {
            logger.warning("Header has not yet been set for this framebody");
            return 1;
        }
        if (abstractTagFrame instanceof ID3v24Frame) {
            return TagOptionSingleton.getInstance().getId3v24UnicodeTextEncoding();
        }
        return 1;
    }
}

