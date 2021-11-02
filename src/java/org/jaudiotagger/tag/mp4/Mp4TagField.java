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
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.mp4;

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
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;

public abstract class Mp4TagField
implements TagField {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.mp4");
    protected String id;
    protected Mp4BoxHeader parentHeader;

    protected Mp4TagField(String string2) {
        this.id = string2;
    }

    protected Mp4TagField(String string2, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        this(string2);
        this.build(byteBuffer);
    }

    protected Mp4TagField(ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        this.build(byteBuffer);
    }

    protected Mp4TagField(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        this.parentHeader = mp4BoxHeader;
        this.build(byteBuffer);
    }

    protected abstract void build(ByteBuffer var1) throws UnsupportedEncodingException;

    protected abstract byte[] getDataBytes() throws UnsupportedEncodingException;

    public abstract Mp4FieldType getFieldType();

    @Override
    public String getId() {
        return this.id;
    }

    protected byte[] getIdBytes() {
        return this.getId().getBytes(StandardCharsets.ISO_8859_1);
    }

    @Override
    public byte[] getRawContent() throws UnsupportedEncodingException {
        Logger logger = Mp4TagField.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Getting Raw data for:");
        stringBuilder.append(this.getId());
        logger.fine(stringBuilder.toString());
        try {
            byte[] arrby = this.getRawContentDataOnly();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(Utils.getSizeBEInt32(8 + arrby.length));
            byteArrayOutputStream.write(this.getId().getBytes(StandardCharsets.ISO_8859_1));
            byteArrayOutputStream.write(arrby);
            byte[] arrby2 = byteArrayOutputStream.toByteArray();
            return arrby2;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }

    public byte[] getRawContentDataOnly() throws UnsupportedEncodingException {
        Logger logger = Mp4TagField.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Getting Raw data for:");
        stringBuilder.append(this.getId());
        logger.fine(stringBuilder.toString());
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] arrby = this.getDataBytes();
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
    public void isBinary(boolean bl) {
    }

    @Override
    public boolean isCommon() {
        return this.id.equals((Object)Mp4FieldKey.ARTIST.getFieldName()) || this.id.equals((Object)Mp4FieldKey.ALBUM.getFieldName()) || this.id.equals((Object)Mp4FieldKey.TITLE.getFieldName()) || this.id.equals((Object)Mp4FieldKey.TRACK.getFieldName()) || this.id.equals((Object)Mp4FieldKey.DAY.getFieldName()) || this.id.equals((Object)Mp4FieldKey.COMMENT.getFieldName()) || this.id.equals((Object)Mp4FieldKey.GENRE.getFieldName());
        {
        }
    }
}

