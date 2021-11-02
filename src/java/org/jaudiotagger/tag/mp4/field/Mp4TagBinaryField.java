/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.tag.mp4.field;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.mp4.Mp4TagField;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;

public class Mp4TagBinaryField
extends Mp4TagField {
    protected byte[] dataBytes;
    protected int dataSize;
    protected boolean isBinary = false;

    public Mp4TagBinaryField(String string2) {
        super(string2);
    }

    public Mp4TagBinaryField(String string2, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        super(string2, byteBuffer);
    }

    public Mp4TagBinaryField(String string2, byte[] arrby) {
        super(string2);
        this.dataBytes = arrby;
    }

    @Override
    protected void build(ByteBuffer byteBuffer) {
        byte[] arrby;
        this.dataSize = new Mp4BoxHeader(byteBuffer).getDataLength();
        byteBuffer.position(8 + byteBuffer.position());
        this.dataBytes = new byte[-8 + this.dataSize];
        for (int i2 = 0; i2 < (arrby = this.dataBytes).length; ++i2) {
            arrby[i2] = byteBuffer.get();
        }
    }

    @Override
    public void copyContent(TagField tagField) {
        if (tagField instanceof Mp4TagBinaryField) {
            this.dataBytes = ((Mp4TagBinaryField)tagField).getData();
            this.isBinary = tagField.isBinary();
        }
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
    public boolean isBinary() {
        return this.isBinary;
    }

    @Override
    public boolean isEmpty() {
        return this.dataBytes.length == 0;
    }

    public void setData(byte[] arrby) {
        this.dataBytes = arrby;
    }
}

