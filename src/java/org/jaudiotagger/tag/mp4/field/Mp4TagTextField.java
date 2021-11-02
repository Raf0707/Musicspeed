/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.tag.mp4.field;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.mp4.Mp4TagField;
import org.jaudiotagger.tag.mp4.atom.Mp4DataBox;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;

public class Mp4TagTextField
extends Mp4TagField
implements TagTextField {
    protected String content;
    protected int dataSize;

    public Mp4TagTextField(String string2, String string3) {
        super(string2);
        this.content = string3;
    }

    public Mp4TagTextField(String string2, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        super(string2, byteBuffer);
    }

    @Override
    protected void build(ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader(byteBuffer);
        Mp4DataBox mp4DataBox = new Mp4DataBox(mp4BoxHeader, byteBuffer);
        this.dataSize = mp4BoxHeader.getDataLength();
        this.content = mp4DataBox.getContent();
    }

    @Override
    public void copyContent(TagField tagField) {
        if (tagField instanceof Mp4TagTextField) {
            this.content = ((Mp4TagTextField)tagField).getContent();
        }
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    protected byte[] getDataBytes() throws UnsupportedEncodingException {
        return this.content.getBytes(this.getEncoding());
    }

    @Override
    public Charset getEncoding() {
        return StandardCharsets.UTF_8;
    }

    @Override
    public Mp4FieldType getFieldType() {
        return Mp4FieldType.TEXT;
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.content.trim().equals((Object)"");
    }

    @Override
    public void setContent(String string2) {
        this.content = string2;
    }

    @Override
    public void setEncoding(Charset charset) {
    }

    @Override
    public String toString() {
        return this.content;
    }
}

