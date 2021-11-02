/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.mp4.field;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.Mp4TagField;
import org.jaudiotagger.tag.mp4.atom.Mp4DataBox;
import org.jaudiotagger.tag.mp4.atom.Mp4MeanBox;
import org.jaudiotagger.tag.mp4.atom.Mp4NameBox;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;

public class Mp4TagReverseDnsField
extends Mp4TagField
implements TagTextField {
    public static final String IDENTIFIER = "----";
    protected String content;
    protected int dataSize;
    private String descriptor;
    private String issuer;

    public Mp4TagReverseDnsField(String string2, String string3, String string4, String string5) {
        super(string2);
        this.issuer = string3;
        this.descriptor = string4;
        this.content = string5;
    }

    public Mp4TagReverseDnsField(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        super(mp4BoxHeader, byteBuffer);
    }

    public Mp4TagReverseDnsField(Mp4FieldKey mp4FieldKey, String string2) {
        super(mp4FieldKey.getFieldName());
        this.issuer = mp4FieldKey.getIssuer();
        this.descriptor = mp4FieldKey.getIdentifier();
        this.content = string2;
    }

    @Override
    protected void build(ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader(byteBuffer);
        this.setIssuer(new Mp4MeanBox(mp4BoxHeader, byteBuffer).getIssuer());
        byteBuffer.position(byteBuffer.position() + mp4BoxHeader.getDataLength());
        Mp4BoxHeader mp4BoxHeader2 = new Mp4BoxHeader(byteBuffer);
        this.setDescriptor(new Mp4NameBox(mp4BoxHeader2, byteBuffer).getName());
        byteBuffer.position(byteBuffer.position() + mp4BoxHeader2.getDataLength());
        if (this.parentHeader.getDataLength() == mp4BoxHeader.getLength() + mp4BoxHeader2.getLength()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("----:");
            stringBuilder.append(this.issuer);
            stringBuilder.append(":");
            stringBuilder.append(this.descriptor);
            this.id = stringBuilder.toString();
            this.setContent("");
            Logger logger = Mp4TagField.logger;
            ErrorMessage errorMessage = ErrorMessage.MP4_REVERSE_DNS_FIELD_HAS_NO_DATA;
            Object[] arrobject = new Object[]{this.id};
            logger.warning(errorMessage.getMsg(arrobject));
            return;
        }
        Mp4BoxHeader mp4BoxHeader3 = new Mp4BoxHeader(byteBuffer);
        this.setContent(new Mp4DataBox(mp4BoxHeader3, byteBuffer).getContent());
        byteBuffer.position(byteBuffer.position() + mp4BoxHeader3.getDataLength());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("----:");
        stringBuilder.append(this.issuer);
        stringBuilder.append(":");
        stringBuilder.append(this.descriptor);
        this.id = stringBuilder.toString();
    }

    @Override
    public void copyContent(TagField tagField) {
        if (tagField instanceof Mp4TagReverseDnsField) {
            Mp4TagReverseDnsField mp4TagReverseDnsField = (Mp4TagReverseDnsField)tagField;
            this.issuer = mp4TagReverseDnsField.getIssuer();
            this.descriptor = mp4TagReverseDnsField.getDescriptor();
            this.content = mp4TagReverseDnsField.getContent();
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

    public String getDescriptor() {
        return this.descriptor;
    }

    @Override
    public Charset getEncoding() {
        return StandardCharsets.UTF_8;
    }

    @Override
    public Mp4FieldType getFieldType() {
        return Mp4FieldType.TEXT;
    }

    public String getIssuer() {
        return this.issuer;
    }

    @Override
    public byte[] getRawContent() throws UnsupportedEncodingException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] arrby = this.issuer.getBytes(this.getEncoding());
            byteArrayOutputStream.write(Utils.getSizeBEInt32(12 + arrby.length));
            Charset charset = StandardCharsets.ISO_8859_1;
            byteArrayOutputStream.write("mean".getBytes(charset));
            byteArrayOutputStream.write(new byte[]{0, 0, 0, 0});
            byteArrayOutputStream.write(arrby);
            byte[] arrby2 = this.descriptor.getBytes(this.getEncoding());
            byteArrayOutputStream.write(Utils.getSizeBEInt32(12 + arrby2.length));
            byteArrayOutputStream.write("name".getBytes(charset));
            byteArrayOutputStream.write(new byte[]{0, 0, 0, 0});
            byteArrayOutputStream.write(arrby2);
            if (this.content.length() > 0) {
                byteArrayOutputStream.write(this.getRawContentDataOnly());
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            byteArrayOutputStream2.write(Utils.getSizeBEInt32(8 + byteArrayOutputStream.size()));
            byteArrayOutputStream2.write(IDENTIFIER.getBytes(charset));
            byteArrayOutputStream2.write(byteArrayOutputStream.toByteArray());
            byte[] arrby3 = byteArrayOutputStream2.toByteArray();
            return arrby3;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }

    @Override
    public byte[] getRawContentDataOnly() throws UnsupportedEncodingException {
        Logger logger = Mp4TagField.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Getting Raw data for:");
        stringBuilder.append(this.getId());
        logger.fine(stringBuilder.toString());
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] arrby = this.content.getBytes(this.getEncoding());
            byteArrayOutputStream.write(Utils.getSizeBEInt32(16 + arrby.length));
            byteArrayOutputStream.write("data".getBytes(StandardCharsets.ISO_8859_1));
            byteArrayOutputStream.write(new byte[]{0});
            byte[] arrby2 = new byte[]{0, 0, (byte)this.getFieldType().getFileClassId()};
            byteArrayOutputStream.write(arrby2);
            byteArrayOutputStream.write(new byte[]{0, 0, 0, 0});
            byteArrayOutputStream.write(arrby);
            byte[] arrby3 = byteArrayOutputStream.toByteArray();
            return arrby3;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return "".equals((Object)this.content.trim());
    }

    @Override
    public void setContent(String string2) {
        this.content = string2;
    }

    public void setDescriptor(String string2) {
        this.descriptor = string2;
    }

    @Override
    public void setEncoding(Charset charset) {
    }

    public void setIssuer(String string2) {
        this.issuer = string2;
    }

    @Override
    public String toString() {
        return this.content;
    }
}

