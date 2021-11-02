/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.io.UnsupportedEncodingException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.charset.Charset
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.mp4.atom.Mp4MetaBox
 *  org.jaudiotagger.tag.mp4.Mp4Tag
 *  org.jaudiotagger.tag.mp4.field.Mp4DiscNoField
 *  org.jaudiotagger.tag.mp4.field.Mp4GenreField
 *  org.jaudiotagger.tag.mp4.field.Mp4TagBinaryField
 *  org.jaudiotagger.tag.mp4.field.Mp4TagByteField
 *  org.jaudiotagger.tag.mp4.field.Mp4TagCoverField
 *  org.jaudiotagger.tag.mp4.field.Mp4TagRawBinaryField
 *  org.jaudiotagger.tag.mp4.field.Mp4TagReverseDnsField
 *  org.jaudiotagger.tag.mp4.field.Mp4TagTextField
 *  org.jaudiotagger.tag.mp4.field.Mp4TagTextNumberField
 *  org.jaudiotagger.tag.mp4.field.Mp4TrackField
 */
package org.jaudiotagger.audio.mp4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.Mp4AtomIdentifier;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.audio.mp4.atom.Mp4MetaBox;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.mp4.Mp4FieldKey;
import org.jaudiotagger.tag.mp4.Mp4NonStandardFieldKey;
import org.jaudiotagger.tag.mp4.Mp4Tag;
import org.jaudiotagger.tag.mp4.field.Mp4DiscNoField;
import org.jaudiotagger.tag.mp4.field.Mp4FieldType;
import org.jaudiotagger.tag.mp4.field.Mp4GenreField;
import org.jaudiotagger.tag.mp4.field.Mp4TagBinaryField;
import org.jaudiotagger.tag.mp4.field.Mp4TagByteField;
import org.jaudiotagger.tag.mp4.field.Mp4TagCoverField;
import org.jaudiotagger.tag.mp4.field.Mp4TagRawBinaryField;
import org.jaudiotagger.tag.mp4.field.Mp4TagReverseDnsField;
import org.jaudiotagger.tag.mp4.field.Mp4TagTextField;
import org.jaudiotagger.tag.mp4.field.Mp4TagTextNumberField;
import org.jaudiotagger.tag.mp4.field.Mp4TrackField;

public class Mp4TagReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.mp4");

    private void createMp4Field(Mp4Tag mp4Tag, Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        if (mp4BoxHeader.getDataLength() == 0) {
            return;
        }
        boolean bl = mp4BoxHeader.getId().equals((Object)"----");
        int n2 = 0;
        if (bl) {
            try {
                mp4Tag.addField((TagField)new Mp4TagReverseDnsField(mp4BoxHeader, byteBuffer));
                return;
            }
            catch (Exception exception) {
                Logger logger = Mp4TagReader.logger;
                ErrorMessage errorMessage = ErrorMessage.MP4_UNABLE_READ_REVERSE_DNS_FIELD;
                Object[] arrobject = new Object[]{exception.getMessage()};
                logger.warning(errorMessage.getMsg(arrobject));
                mp4Tag.addField((TagField)new Mp4TagRawBinaryField(mp4BoxHeader, byteBuffer));
                return;
            }
        }
        int n3 = byteBuffer.position();
        boolean bl2 = Utils.getString(byteBuffer, 4, 4, StandardCharsets.ISO_8859_1).equals((Object)"data");
        byteBuffer.position(n3);
        if (bl2) {
            int n4 = Utils.getIntBE(byteBuffer, 9, 11);
            Mp4FieldType mp4FieldType = Mp4FieldType.getFieldType(n4);
            Logger logger = Mp4TagReader.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Box Type id:");
            stringBuilder.append(mp4BoxHeader.getId());
            stringBuilder.append(":type:");
            stringBuilder.append((Object)mp4FieldType);
            logger.config(stringBuilder.toString());
            if (mp4BoxHeader.getId().equals((Object)Mp4FieldKey.TRACK.getFieldName())) {
                mp4Tag.addField((TagField)new Mp4TrackField(mp4BoxHeader.getId(), byteBuffer));
                return;
            }
            if (mp4BoxHeader.getId().equals((Object)Mp4FieldKey.DISCNUMBER.getFieldName())) {
                mp4Tag.addField((TagField)new Mp4DiscNoField(mp4BoxHeader.getId(), byteBuffer));
                return;
            }
            if (mp4BoxHeader.getId().equals((Object)Mp4FieldKey.GENRE.getFieldName())) {
                mp4Tag.addField((TagField)new Mp4GenreField(mp4BoxHeader.getId(), byteBuffer));
                return;
            }
            if (!mp4BoxHeader.getId().equals((Object)Mp4FieldKey.ARTWORK.getFieldName()) && !Mp4FieldType.isCoverArtType(mp4FieldType)) {
                boolean bl3;
                if (mp4FieldType == Mp4FieldType.TEXT) {
                    mp4Tag.addField((TagField)new Mp4TagTextField(mp4BoxHeader.getId(), byteBuffer));
                    return;
                }
                if (mp4FieldType == Mp4FieldType.IMPLICIT) {
                    mp4Tag.addField((TagField)new Mp4TagTextNumberField(mp4BoxHeader.getId(), byteBuffer));
                    return;
                }
                if (mp4FieldType == Mp4FieldType.INTEGER) {
                    mp4Tag.addField((TagField)new Mp4TagByteField(mp4BoxHeader.getId(), byteBuffer));
                    return;
                }
                Mp4FieldKey[] arrmp4FieldKey = Mp4FieldKey.values();
                int n5 = arrmp4FieldKey.length;
                int n6 = 0;
                do {
                    bl3 = false;
                    if (n6 >= n5) break;
                    if (arrmp4FieldKey[n6].getFieldName().equals((Object)mp4BoxHeader.getId())) {
                        Logger logger2 = Mp4TagReader.logger;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Known Field:");
                        stringBuilder2.append(mp4BoxHeader.getId());
                        stringBuilder2.append(" with invalid field type of:");
                        stringBuilder2.append(n4);
                        stringBuilder2.append(" is ignored");
                        logger2.warning(stringBuilder2.toString());
                        bl3 = true;
                        break;
                    }
                    ++n6;
                } while (true);
                if (!bl3) {
                    Logger logger3 = Mp4TagReader.logger;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("UnKnown Field:");
                    stringBuilder3.append(mp4BoxHeader.getId());
                    stringBuilder3.append(" with invalid field type of:");
                    stringBuilder3.append(n4);
                    stringBuilder3.append(" created as binary");
                    logger3.warning(stringBuilder3.toString());
                    mp4Tag.addField((TagField)new Mp4TagBinaryField(mp4BoxHeader.getId(), byteBuffer));
                    return;
                }
            } else {
                int n7 = 0;
                while (n2 < mp4BoxHeader.getDataLength()) {
                    if (n7 > 0) {
                        int n8 = n2 + 9;
                        mp4FieldType = Mp4FieldType.getFieldType(Utils.getIntBE(byteBuffer, n8, n8 + 3 - 1));
                    }
                    Mp4TagCoverField mp4TagCoverField = new Mp4TagCoverField(byteBuffer, mp4FieldType);
                    mp4Tag.addField((TagField)mp4TagCoverField);
                    n2 += mp4TagCoverField.getDataAndHeaderSize();
                    ++n7;
                }
            }
        } else {
            if (mp4BoxHeader.getId().equals((Object)Mp4NonStandardFieldKey.AAPR.getFieldName())) {
                mp4Tag.addField((TagField)new Mp4TagRawBinaryField(mp4BoxHeader, byteBuffer));
                return;
            }
            mp4Tag.addField((TagField)new Mp4TagRawBinaryField(mp4BoxHeader, byteBuffer));
        }
    }

    public Mp4Tag read(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        FileChannel fileChannel = randomAccessFile.getChannel();
        Mp4Tag mp4Tag = new Mp4Tag();
        Mp4BoxHeader mp4BoxHeader = Mp4BoxHeader.seekWithinLevel(fileChannel, Mp4AtomIdentifier.MOOV.getFieldName());
        if (mp4BoxHeader != null) {
            Mp4BoxHeader mp4BoxHeader2;
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)(-8 + mp4BoxHeader.getLength()));
            randomAccessFile.getChannel().read(byteBuffer);
            byteBuffer.rewind();
            if (Mp4BoxHeader.seekWithinLevel(byteBuffer, Mp4AtomIdentifier.UDTA.getFieldName()) != null) {
                Mp4BoxHeader mp4BoxHeader3 = Mp4BoxHeader.seekWithinLevel(byteBuffer, Mp4AtomIdentifier.META.getFieldName());
                if (mp4BoxHeader3 == null) {
                    logger.warning(ErrorMessage.MP4_FILE_HAS_NO_METADATA.getMsg());
                    return mp4Tag;
                }
                new Mp4MetaBox(mp4BoxHeader3, byteBuffer).processData();
                mp4BoxHeader2 = Mp4BoxHeader.seekWithinLevel(byteBuffer, Mp4AtomIdentifier.ILST.getFieldName());
                if (mp4BoxHeader2 == null) {
                    logger.warning(ErrorMessage.MP4_FILE_HAS_NO_METADATA.getMsg());
                    return mp4Tag;
                }
            } else {
                Mp4BoxHeader mp4BoxHeader4 = Mp4BoxHeader.seekWithinLevel(byteBuffer, Mp4AtomIdentifier.META.getFieldName());
                if (mp4BoxHeader4 == null) {
                    logger.warning(ErrorMessage.MP4_FILE_HAS_NO_METADATA.getMsg());
                    return mp4Tag;
                }
                new Mp4MetaBox(mp4BoxHeader4, byteBuffer).processData();
                mp4BoxHeader2 = Mp4BoxHeader.seekWithinLevel(byteBuffer, Mp4AtomIdentifier.ILST.getFieldName());
                if (mp4BoxHeader2 == null) {
                    logger.warning(ErrorMessage.MP4_FILE_HAS_NO_METADATA.getMsg());
                    return mp4Tag;
                }
            }
            int n2 = -8 + mp4BoxHeader2.getLength();
            ByteBuffer byteBuffer2 = byteBuffer.slice();
            Logger logger = Mp4TagReader.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("headerlengthsays:");
            stringBuilder.append(n2);
            stringBuilder.append("datalength:");
            stringBuilder.append(byteBuffer2.limit());
            logger.config(stringBuilder.toString());
            Logger logger2 = Mp4TagReader.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Started to read metadata fields at position is in metadata buffer:");
            stringBuilder2.append(byteBuffer2.position());
            logger2.config(stringBuilder2.toString());
            for (int i2 = 0; i2 < n2; i2 += mp4BoxHeader2.getLength()) {
                mp4BoxHeader2.update(byteBuffer2);
                Logger logger3 = Mp4TagReader.logger;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Next position is at:");
                stringBuilder3.append(byteBuffer2.position());
                logger3.config(stringBuilder3.toString());
                this.createMp4Field(mp4Tag, mp4BoxHeader2, byteBuffer2.slice());
                byteBuffer2.position(byteBuffer2.position() + mp4BoxHeader2.getDataLength());
            }
            return mp4Tag;
        }
        throw new CannotReadException(ErrorMessage.MP4_FILE_NOT_CONTAINER.getMsg());
    }
}

