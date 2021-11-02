/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.CharBuffer
 *  java.nio.charset.CharacterCodingException
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetDecoder
 *  java.util.HashMap
 *  java.util.Map
 */
package org.jaudiotagger.audio.mp4.atom;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.HashMap;
import java.util.Map;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.mp4.Mp4AtomIdentifier;
import org.jaudiotagger.audio.mp4.atom.AbstractMp4Box;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;

public class Mp4HdlrBox
extends AbstractMp4Box {
    public static final int HANDLER_LENGTH = 4;
    public static final int HANDLER_POS = 8;
    public static final int ITUNES_META_HDLR_DAT_LENGTH = 26;
    public static final int NAME_LENGTH = 2;
    public static final int OTHER_FLAG_LENGTH = 3;
    public static final int RESERVED1_LENGTH = 4;
    public static final int RESERVED1_POS = 12;
    public static final int RESERVED2_LENGTH = 4;
    public static final int RESERVED3_LENGTH = 4;
    public static final int RESERVED_FLAG_LENGTH = 4;
    public static final int VERSION_FLAG_LENGTH = 1;
    private static Map<String, MediaDataType> mediaDataTypeMap = new HashMap();
    private String handlerType;
    private MediaDataType mediaDataType;
    private String name;
    private int reserved;

    static {
        for (MediaDataType mediaDataType : MediaDataType.values()) {
            mediaDataTypeMap.put((Object)mediaDataType.getId(), (Object)mediaDataType);
        }
    }

    public Mp4HdlrBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) {
        this.header = mp4BoxHeader;
        this.dataBuffer = byteBuffer;
    }

    public static Mp4HdlrBox createiTunesStyleHdlrBox() {
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader(Mp4AtomIdentifier.HDLR.getFieldName());
        mp4BoxHeader.setLength(34);
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)26);
        byteBuffer.put(8, (byte)109);
        byteBuffer.put(9, (byte)100);
        byteBuffer.put(10, (byte)105);
        byteBuffer.put(11, (byte)114);
        byteBuffer.put(12, (byte)97);
        byteBuffer.put(13, (byte)112);
        byteBuffer.put(14, (byte)112);
        byteBuffer.put(15, (byte)108);
        byteBuffer.rewind();
        return new Mp4HdlrBox(mp4BoxHeader, byteBuffer);
    }

    public String getHandlerType() {
        return this.handlerType;
    }

    public MediaDataType getMediaDataType() {
        return this.mediaDataType;
    }

    public void processData() throws CannotReadException {
        ByteBuffer byteBuffer = this.dataBuffer;
        byteBuffer.position(4 + (3 + (1 + byteBuffer.position())));
        CharsetDecoder charsetDecoder = Charset.forName((String)"ISO-8859-1").newDecoder();
        try {
            this.handlerType = charsetDecoder.decode((ByteBuffer)this.dataBuffer.slice().limit(4)).toString();
        }
        catch (CharacterCodingException characterCodingException) {}
        this.mediaDataType = (Object)mediaDataTypeMap.get((Object)this.handlerType);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handlerType:");
        stringBuilder.append(this.handlerType);
        stringBuilder.append(":human readable:");
        stringBuilder.append(this.mediaDataType.getDescription());
        return stringBuilder.toString();
    }

}

