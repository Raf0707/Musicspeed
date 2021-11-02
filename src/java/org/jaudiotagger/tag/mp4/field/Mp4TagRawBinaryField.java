/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.mp4.field;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.mp4.Mp4TagField;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;

public class Mp4TagRawBinaryField
extends Mp4TagField {
    protected byte[] dataBytes;
    protected int dataSize;

    public Mp4TagRawBinaryField(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        super(mp4BoxHeader.getId());
        this.dataSize = mp4BoxHeader.getDataLength();
        this.build(byteBuffer);
    }

    @Override
    protected void build(ByteBuffer byteBuffer) {
        byte[] arrby;
        this.dataBytes = new byte[this.dataSize];
        for (int i2 = 0; i2 < (arrby = this.dataBytes).length; ++i2) {
            arrby[i2] = byteBuffer.get();
        }
    }

    @Override
    public void copyContent(TagField tagField) {
        throw new UnsupportedOperationException("not done");
    }

    public byte[] getData() {
        return this.dataBytes;
    }

    @Override
    protected byte[] getDataBytes() throws UnsupportedEncodingException {
        return this.dataBytes;
    }

    public int getDataSize() {
        return this.dataSize;
    }

    @Override
    public Mp4FieldType getFieldType() {
        return Mp4FieldType.IMPLICIT;
    }

    @Override
    public byte[] getRawContent() throws UnsupportedEncodingException {
        Logger logger = Mp4TagField.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Getting Raw data for:");
        stringBuilder.append(this.getId());
        logger.fine(stringBuilder.toString());
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(Utils.getSizeBEInt32(8 + this.dataSize));
            byteArrayOutputStream.write(this.getId().getBytes(StandardCharsets.ISO_8859_1));
            byteArrayOutputStream.write(this.dataBytes);
            byte[] arrby = byteArrayOutputStream.toByteArray();
            return arrby;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.dataBytes.length == 0;
    }

    public void setData(byte[] arrby) {
        this.dataBytes = arrby;
    }
}

