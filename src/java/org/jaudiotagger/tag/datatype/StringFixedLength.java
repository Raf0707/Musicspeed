/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.CharBuffer
 *  java.nio.charset.CharacterCodingException
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetDecoder
 *  java.nio.charset.CharsetEncoder
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractString;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.valuepair.TextEncoding;

public class StringFixedLength
extends AbstractString {
    public StringFixedLength(String string2, AbstractTagFrameBody abstractTagFrameBody, int n2) {
        super(string2, abstractTagFrameBody);
        if (n2 >= 0) {
            this.setSize(n2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size is less than zero: ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public StringFixedLength(StringFixedLength stringFixedLength) {
        super(stringFixedLength);
        this.size = stringFixedLength.size;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StringFixedLength)) {
            return false;
        }
        StringFixedLength stringFixedLength = (StringFixedLength)object;
        int n2 = this.size;
        int n3 = stringFixedLength.size;
        boolean bl = false;
        if (n2 == n3) {
            boolean bl2 = AbstractDataType.super.equals(object);
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
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
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Reading from array from offset:");
        stringBuilder.append(n2);
        logger.config(stringBuilder.toString());
        try {
            CharsetDecoder charsetDecoder = this.getTextEncodingCharSet().newDecoder();
            Logger logger2 = AbstractDataType.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Array length is:");
            stringBuilder2.append(arrby.length);
            stringBuilder2.append("offset is:");
            stringBuilder2.append(n2);
            stringBuilder2.append("Size is:");
            stringBuilder2.append(this.size);
            logger2.finest(stringBuilder2.toString());
            int n3 = arrby.length - n2;
            int n4 = this.size;
            if (n3 < n4) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("byte array is to small to retrieve string of declared length:");
                stringBuilder3.append(this.size);
                throw new InvalidDataTypeException(stringBuilder3.toString());
            }
            String string2 = charsetDecoder.decode(ByteBuffer.wrap((byte[])arrby, (int)n2, (int)n4)).toString();
            if (string2 == null) {
                throw new NullPointerException("String is null");
            }
            this.value = string2;
        }
        catch (CharacterCodingException characterCodingException) {
            AbstractDataType.logger.severe(characterCodingException.getMessage());
            this.value = "";
        }
        Logger logger3 = AbstractDataType.logger;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("Read StringFixedLength:");
        stringBuilder4.append(this.value);
        logger3.config(stringBuilder4.toString());
    }

    @Override
    public byte[] writeByteArray() {
        int n2;
        block11 : {
            ByteBuffer byteBuffer;
            Object object = this.value;
            if (object == null) {
                AbstractDataType.logger.warning("Value of StringFixedlength Field is null using default value instead");
                byte[] arrby = new byte[this.size];
                for (n2 = 0; n2 < this.size; ++n2) {
                    arrby[n2] = 32;
                }
                return arrby;
            }
            try {
                Charset charset = this.getTextEncodingCharSet();
                if (StandardCharsets.UTF_16.equals((Object)charset)) {
                    CharsetEncoder charsetEncoder = StandardCharsets.UTF_16LE.newEncoder();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append('\ufeff');
                    stringBuilder.append((String)this.value);
                    byteBuffer = charsetEncoder.encode(CharBuffer.wrap((CharSequence)stringBuilder.toString()));
                } else {
                    byteBuffer = charset.newEncoder().encode(CharBuffer.wrap((CharSequence)((String)this.value)));
                }
                if (byteBuffer == null) break block11;
            }
            catch (CharacterCodingException characterCodingException) {
                Logger logger = AbstractDataType.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("There was a problem writing the following StringFixedlength Field:");
                stringBuilder.append(this.value);
                stringBuilder.append(":");
                stringBuilder.append(characterCodingException.getMessage());
                stringBuilder.append("using default value instead");
                logger.warning(stringBuilder.toString());
                byte[] arrby = new byte[this.size];
                while (n2 < this.size) {
                    arrby[n2] = 32;
                    ++n2;
                }
                return arrby;
            }
            if (byteBuffer.limit() == this.size) {
                byte[] arrby = new byte[byteBuffer.limit()];
                byteBuffer.get(arrby, 0, byteBuffer.limit());
                return arrby;
            }
            if (byteBuffer.limit() > this.size) {
                Logger logger = AbstractDataType.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("There was a problem writing the following StringFixedlength Field:");
                stringBuilder.append(this.value);
                stringBuilder.append(" when converted to bytes has length of:");
                stringBuilder.append(byteBuffer.limit());
                stringBuilder.append(" but field was defined with length of:");
                stringBuilder.append(this.size);
                stringBuilder.append(" too long so stripping extra length");
                logger.warning(stringBuilder.toString());
                int n3 = this.size;
                byte[] arrby = new byte[n3];
                byteBuffer.get(arrby, 0, n3);
                return arrby;
            }
            Logger logger = AbstractDataType.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("There was a problem writing the following StringFixedlength Field:");
            stringBuilder.append(this.value);
            stringBuilder.append(" when converted to bytes has length of:");
            stringBuilder.append(byteBuffer.limit());
            stringBuilder.append(" but field was defined with length of:");
            stringBuilder.append(this.size);
            stringBuilder.append(" too short so padding with spaces to make up extra length");
            logger.warning(stringBuilder.toString());
            byte[] arrby = new byte[this.size];
            byteBuffer.get(arrby, 0, byteBuffer.limit());
            for (int i2 = byteBuffer.limit(); i2 < this.size; ++i2) {
                arrby[i2] = 32;
            }
            return arrby;
        }
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There was a serious problem writing the following StringFixedlength Field:");
        stringBuilder.append(this.value);
        stringBuilder.append(":using default value instead");
        logger.warning(stringBuilder.toString());
        byte[] arrby = new byte[this.size];
        while (n2 < this.size) {
            arrby[n2] = 32;
            ++n2;
        }
        return arrby;
    }
}

