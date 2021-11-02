/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.mp4.field;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.id3.valuepair.ImageFormats;
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.Mp4TagField;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;
import org.jaudiotagger.tag.mp4.field.Mp4TagBinaryField;

public class Mp4TagCoverField
extends Mp4TagBinaryField {
    private int dataAndHeaderSize;
    private Mp4FieldType imageType;

    public Mp4TagCoverField() {
        super(Mp4FieldKey.ARTWORK.getFieldName());
    }

    public Mp4TagCoverField(ByteBuffer byteBuffer, Mp4FieldType mp4FieldType) throws UnsupportedEncodingException {
        super(Mp4FieldKey.ARTWORK.getFieldName(), byteBuffer);
        this.imageType = mp4FieldType;
        if (!Mp4FieldType.isCoverArtType(mp4FieldType)) {
            Mp4TagField.logger.warning(ErrorMessage.MP4_IMAGE_FORMAT_IS_NOT_TO_EXPECTED_TYPE.getMsg(new Object[]{mp4FieldType}));
        }
    }

    public Mp4TagCoverField(byte[] arrby) {
        super(Mp4FieldKey.ARTWORK.getFieldName(), arrby);
        if (ImageFormats.binaryDataIsPngFormat(arrby)) {
            this.imageType = Mp4FieldType.COVERART_PNG;
            return;
        }
        if (ImageFormats.binaryDataIsJpgFormat(arrby)) {
            this.imageType = Mp4FieldType.COVERART_JPEG;
            return;
        }
        if (ImageFormats.binaryDataIsGifFormat(arrby)) {
            this.imageType = Mp4FieldType.COVERART_GIF;
            return;
        }
        if (ImageFormats.binaryDataIsBmpFormat(arrby)) {
            this.imageType = Mp4FieldType.COVERART_BMP;
            return;
        }
        Mp4TagField.logger.warning(ErrorMessage.GENERAL_UNIDENITIFED_IMAGE_FORMAT.getMsg());
        this.imageType = Mp4FieldType.COVERART_PNG;
    }

    public static String getMimeTypeForImageType(Mp4FieldType mp4FieldType) {
        if (mp4FieldType == Mp4FieldType.COVERART_PNG) {
            return "image/png";
        }
        if (mp4FieldType == Mp4FieldType.COVERART_JPEG) {
            return "image/jpeg";
        }
        if (mp4FieldType == Mp4FieldType.COVERART_GIF) {
            return "image/gif";
        }
        if (mp4FieldType == Mp4FieldType.COVERART_BMP) {
            return "image/bmp";
        }
        return null;
    }

    @Override
    protected void build(ByteBuffer byteBuffer) {
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader(byteBuffer);
        this.dataSize = mp4BoxHeader.getDataLength();
        this.dataAndHeaderSize = mp4BoxHeader.getLength();
        byteBuffer.position(8 + byteBuffer.position());
        byte[] arrby = new byte[-8 + this.dataSize];
        this.dataBytes = arrby;
        byteBuffer.get(arrby, 0, arrby.length);
        int n2 = byteBuffer.position();
        if (8 + byteBuffer.position() <= byteBuffer.limit()) {
            Mp4BoxHeader mp4BoxHeader2 = new Mp4BoxHeader(byteBuffer);
            if (mp4BoxHeader2.getId().equals((Object)"name")) {
                this.dataSize += mp4BoxHeader2.getDataLength();
                this.dataAndHeaderSize += mp4BoxHeader2.getLength();
                return;
            }
            byteBuffer.position(n2);
        }
    }

    public int getDataAndHeaderSize() {
        return this.dataAndHeaderSize;
    }

    @Override
    public Mp4FieldType getFieldType() {
        return this.imageType;
    }

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.imageType);
        stringBuilder.append(":");
        stringBuilder.append(this.dataBytes.length);
        stringBuilder.append("bytes");
        return stringBuilder.toString();
    }
}

