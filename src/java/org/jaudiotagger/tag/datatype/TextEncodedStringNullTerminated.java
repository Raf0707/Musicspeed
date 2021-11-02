/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.CharBuffer
 *  java.nio.charset.CharacterCodingException
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetDecoder
 *  java.nio.charset.CharsetEncoder
 *  java.nio.charset.CoderResult
 *  java.nio.charset.CodingErrorAction
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractString;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.valuepair.TextEncoding;

public class TextEncodedStringNullTerminated
extends AbstractString {
    public TextEncodedStringNullTerminated(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public TextEncodedStringNullTerminated(String string2, AbstractTagFrameBody abstractTagFrameBody, String string3) {
        super(string2, abstractTagFrameBody, string3);
    }

    public TextEncodedStringNullTerminated(TextEncodedStringNullTerminated textEncodedStringNullTerminated) {
        super(textEncodedStringNullTerminated);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof TextEncodedStringNullTerminated && AbstractDataType.super.equals(object);
    }

    @Override
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

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        int n3;
        boolean bl;
        boolean bl2;
        block12 : {
            if (n2 >= arrby.length) {
                throw new InvalidDataTypeException("Unable to find null terminated string");
            }
            Logger logger = AbstractDataType.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Reading from array starting from offset:");
            stringBuilder.append(n2);
            logger.finer(stringBuilder.toString());
            Charset charset = this.getTextEncodingCharSet();
            ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])arrby, (int)n2, (int)(arrby.length - n2));
            Charset charset2 = StandardCharsets.ISO_8859_1;
            bl2 = false;
            bl = charset2 == charset || StandardCharsets.UTF_8 == charset;
            while (byteBuffer.hasRemaining()) {
                if (byteBuffer.get() == 0) {
                    int n4;
                    if (bl) {
                        byteBuffer.mark();
                        byteBuffer.reset();
                        n4 = -1 + byteBuffer.position();
                        Logger logger2 = AbstractDataType.logger;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Null terminator found starting at:");
                        stringBuilder2.append(n4);
                        logger2.finest(stringBuilder2.toString());
                    } else if (byteBuffer.hasRemaining()) {
                        if (byteBuffer.get() != 0) continue;
                        byteBuffer.mark();
                        byteBuffer.reset();
                        n4 = -2 + byteBuffer.position();
                        Logger logger3 = AbstractDataType.logger;
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("UTF16:Null terminator found starting  at:");
                        stringBuilder3.append(n4);
                        logger3.finest(stringBuilder3.toString());
                    } else {
                        byteBuffer.mark();
                        byteBuffer.reset();
                        n4 = -1 + byteBuffer.position();
                        Logger logger4 = AbstractDataType.logger;
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("UTF16:Should be two null terminator marks but only found one starting at:");
                        stringBuilder4.append(n4);
                        logger4.warning(stringBuilder4.toString());
                    }
                    n3 = n4;
                    bl2 = true;
                    break block12;
                }
                if (bl || !byteBuffer.hasRemaining()) continue;
                byteBuffer.get();
            }
            n3 = 0;
        }
        if (!bl2) {
            throw new InvalidDataTypeException("Unable to find null terminated string");
        }
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("End Position is:");
        stringBuilder.append(n3);
        stringBuilder.append("Offset:");
        stringBuilder.append(n2);
        logger.finest(stringBuilder.toString());
        int n5 = n3 - n2;
        int n6 = n5 + 1;
        if (!bl) {
            ++n6;
        }
        this.setSize(n6);
        Logger logger5 = AbstractDataType.logger;
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("Text size is:");
        stringBuilder5.append(n5);
        logger5.finest(stringBuilder5.toString());
        if (n5 == 0) {
            this.value = "";
        } else {
            ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])arrby, (int)n2, (int)n5).slice();
            CharBuffer charBuffer = CharBuffer.allocate((int)n5);
            CharsetDecoder charsetDecoder = this.getCorrectDecoder(byteBuffer);
            CoderResult coderResult = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (coderResult.isError()) {
                Logger logger6 = AbstractDataType.logger;
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append("Problem decoding text encoded null terminated string:");
                stringBuilder6.append(coderResult.toString());
                logger6.warning(stringBuilder6.toString());
            }
            charsetDecoder.flush(charBuffer);
            charBuffer.flip();
            this.value = charBuffer.toString();
        }
        Logger logger7 = AbstractDataType.logger;
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append("Read NullTerminatedString:");
        stringBuilder7.append(this.value);
        stringBuilder7.append(" size inc terminator:");
        stringBuilder7.append(n6);
        logger7.config(stringBuilder7.toString());
    }

    @Override
    public byte[] writeByteArray() {
        byte[] arrby;
        block5 : {
            Logger logger = AbstractDataType.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Writing NullTerminatedString.");
            stringBuilder.append(this.value);
            logger.config(stringBuilder.toString());
            Charset charset = this.getTextEncodingCharSet();
            try {
                if (StandardCharsets.UTF_16.equals((Object)charset)) {
                    if (TagOptionSingleton.getInstance().isEncodeUTF16BomAsLittleEndian()) {
                        CharsetEncoder charsetEncoder = StandardCharsets.UTF_16LE.newEncoder();
                        charsetEncoder.onMalformedInput(CodingErrorAction.IGNORE);
                        charsetEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append('\ufeff');
                        stringBuilder2.append((String)this.value);
                        stringBuilder2.append('\u0000');
                        ByteBuffer byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)stringBuilder2.toString()));
                        arrby = new byte[byteBuffer.limit()];
                        byteBuffer.get(arrby, 0, byteBuffer.limit());
                    } else {
                        CharsetEncoder charsetEncoder = StandardCharsets.UTF_16BE.newEncoder();
                        charsetEncoder.onMalformedInput(CodingErrorAction.IGNORE);
                        charsetEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append('\ufeff');
                        stringBuilder3.append((String)this.value);
                        stringBuilder3.append('\u0000');
                        ByteBuffer byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)stringBuilder3.toString()));
                        arrby = new byte[byteBuffer.limit()];
                        byteBuffer.get(arrby, 0, byteBuffer.limit());
                    }
                    break block5;
                }
                CharsetEncoder charsetEncoder = charset.newEncoder();
                charsetEncoder.onMalformedInput(CodingErrorAction.IGNORE);
                charsetEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append((String)this.value);
                stringBuilder4.append('\u0000');
                ByteBuffer byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)stringBuilder4.toString()));
                arrby = new byte[byteBuffer.limit()];
                byteBuffer.get(arrby, 0, byteBuffer.limit());
            }
            catch (CharacterCodingException characterCodingException) {
                Logger logger2 = AbstractDataType.logger;
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(characterCodingException.getMessage());
                stringBuilder5.append(":");
                stringBuilder5.append(charset.name());
                stringBuilder5.append(":");
                stringBuilder5.append(this.value);
                logger2.severe(stringBuilder5.toString());
                throw new RuntimeException((Throwable)characterCodingException);
            }
        }
        this.setSize(arrby.length);
        return arrby;
    }
}

