/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.vorbiscomment.VorbisCommentCreator
 */
package org.jaudiotagger.audio.ogg;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.jaudiotagger.audio.ogg.util.VorbisHeader;
import org.jaudiotagger.audio.ogg.util.VorbisPacketType;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentCreator;

public class OggVorbisCommentTagCreator {
    public static final int FIELD_FRAMING_BIT_LENGTH = 1;
    public static final byte FRAMING_BIT_VALID_VALUE = 1;
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.ogg");
    private VorbisCommentCreator creator = new VorbisCommentCreator();

    public ByteBuffer convert(Tag tag) throws UnsupportedEncodingException {
        ByteBuffer byteBuffer = this.creator.convert(tag);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)(1 + (6 + (1 + byteBuffer.capacity()))));
        byteBuffer2.put((byte)VorbisPacketType.COMMENT_HEADER.getType());
        byteBuffer2.put(VorbisHeader.CAPTURE_PATTERN_AS_BYTES);
        byteBuffer2.put(byteBuffer);
        byteBuffer2.put((byte)1);
        byteBuffer2.rewind();
        return byteBuffer2;
    }
}

