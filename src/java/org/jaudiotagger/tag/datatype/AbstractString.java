/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetDecoder
 *  java.nio.charset.CharsetEncoder
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.valuepair.TextEncoding;

public abstract class AbstractString
extends AbstractDataType {
    protected AbstractString(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public AbstractString(String string2, AbstractTagFrameBody abstractTagFrameBody, String string3) {
        super(string2, abstractTagFrameBody, string3);
    }

    protected AbstractString(AbstractString abstractString) {
        super(abstractString);
    }

    public boolean canBeEncoded() {
        byte by = this.getBody().getTextEncoding();
        CharsetEncoder charsetEncoder = TextEncoding.getInstanceOf().getCharsetForId(by).newEncoder();
        if (charsetEncoder.canEncode((CharSequence)((String)this.value))) {
            return true;
        }
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed Trying to decode");
        stringBuilder.append(this.value);
        stringBuilder.append("with");
        stringBuilder.append(charsetEncoder.toString());
        logger.finest(stringBuilder.toString());
        return false;
    }

    protected CharsetDecoder getCorrectDecoder(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 2) {
            CharsetDecoder charsetDecoder = this.getTextEncodingCharSet().newDecoder();
            charsetDecoder.reset();
            return charsetDecoder;
        }
        if (this.getTextEncodingCharSet() == StandardCharsets.UTF_16) {
            if (byteBuffer.getChar(0) != '\ufffe' && byteBuffer.getChar(0) != '\ufeff') {
                if (byteBuffer.get(0) == 0) {
                    CharsetDecoder charsetDecoder = StandardCharsets.UTF_16BE.newDecoder();
                    charsetDecoder.reset();
                    return charsetDecoder;
                }
                CharsetDecoder charsetDecoder = StandardCharsets.UTF_16LE.newDecoder();
                charsetDecoder.reset();
                return charsetDecoder;
            }
            CharsetDecoder charsetDecoder = this.getTextEncodingCharSet().newDecoder();
            charsetDecoder.reset();
            return charsetDecoder;
        }
        CharsetDecoder charsetDecoder = this.getTextEncodingCharSet().newDecoder();
        charsetDecoder.reset();
        return charsetDecoder;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    protected Charset getTextEncodingCharSet() {
        byte by = this.getBody().getTextEncoding();
        Charset charset = TextEncoding.getInstanceOf().getCharsetForId(by);
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("text encoding:");
        stringBuilder.append((int)by);
        stringBuilder.append(" charset:");
        stringBuilder.append(charset.name());
        logger.finest(stringBuilder.toString());
        return charset;
    }

    protected void setSize(int n2) {
        this.size = n2;
    }

    public String toString() {
        return (String)this.value;
    }
}

