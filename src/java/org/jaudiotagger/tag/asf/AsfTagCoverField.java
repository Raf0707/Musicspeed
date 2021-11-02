/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.asf;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import org.jaudiotagger.audio.asf.data.AsfHeader;
import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.asf.AbstractAsfTagImageField;
import org.jaudiotagger.tag.asf.AsfFieldKey;
import org.jaudiotagger.tag.asf.AsfTagField;
import org.jaudiotagger.tag.id3.valuepair.ImageFormats;

public class AsfTagCoverField
extends AbstractAsfTagImageField {
    public static final Logger LOGGER = Logger.getLogger((String)"org.jaudiotagger.audio.asf.tag");
    private String description;
    private int endOfName = 0;
    private int imageDataSize;
    private String mimeType;
    private int pictureType;

    public AsfTagCoverField(MetadataDescriptor metadataDescriptor) {
        super(metadataDescriptor);
        if (metadataDescriptor.getName().equals((Object)AsfFieldKey.COVER_ART.getFieldName())) {
            if (metadataDescriptor.getType() == 1) {
                try {
                    this.processRawContent();
                    return;
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    throw new RuntimeException((Throwable)unsupportedEncodingException);
                }
            }
            throw new IllegalArgumentException("Descriptor type must be binary");
        }
        throw new IllegalArgumentException("Descriptor description must be WM/Picture");
    }

    public AsfTagCoverField(byte[] arrby, int n2, String string2, String string3) {
        super(new MetadataDescriptor(AsfFieldKey.COVER_ART.getFieldName(), 1));
        this.getDescriptor().setBinaryValue(this.createRawContent(arrby, n2, string2, string3));
    }

    private byte[] createRawContent(byte[] arrby, int n2, String string2, String string3) {
        ByteArrayOutputStream byteArrayOutputStream;
        Charset charset;
        byte[] arrby2;
        this.description = string2;
        this.imageDataSize = arrby.length;
        this.pictureType = n2;
        this.mimeType = string3;
        if (string3 == null && (string3 = ImageFormats.getMimeTypeForBinarySignature(arrby)) == null) {
            LOGGER.warning(ErrorMessage.GENERAL_UNIDENITIFED_IMAGE_FORMAT.getMsg());
            string3 = "image/png";
        }
        byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(n2);
        byteArrayOutputStream.write(Utils.getSizeLEInt32(arrby.length), 0, 4);
        try {
            charset = AsfHeader.ASF_CHARSET;
            arrby2 = string3.getBytes(charset.name());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to find encoding:");
            stringBuilder.append(AsfHeader.ASF_CHARSET.name());
            throw new RuntimeException(stringBuilder.toString());
        }
        byteArrayOutputStream.write(arrby2, 0, arrby2.length);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        if (string2 != null && string2.length() > 0) {
            byte[] arrby3;
            try {
                arrby3 = string2.getBytes(charset.name());
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to find encoding:");
                stringBuilder.append(AsfHeader.ASF_CHARSET.name());
                throw new RuntimeException(stringBuilder.toString());
            }
            byteArrayOutputStream.write(arrby3, 0, arrby3.length);
        }
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(arrby, 0, arrby.length);
        return byteArrayOutputStream.toByteArray();
    }

    private void processRawContent() throws UnsupportedEncodingException {
        byte[] arrby = this.getRawContent();
        int n2 = 0;
        this.pictureType = arrby[0];
        this.imageDataSize = Utils.getIntLE(this.getRawContent(), 1, 2);
        this.mimeType = null;
        this.description = null;
        for (int i2 = 5; i2 < this.getRawContent().length - 1; i2 += 2) {
            if (this.getRawContent()[i2] != 0 || this.getRawContent()[i2 + 1] != 0) continue;
            if (this.mimeType == null) {
                this.mimeType = new String(this.getRawContent(), 5, i2 - 5, "UTF-16LE");
                n2 = i2 + 2;
                continue;
            }
            if (this.description != null) continue;
            this.description = new String(this.getRawContent(), n2, i2 - n2, "UTF-16LE");
            this.endOfName = i2 + 2;
            return;
        }
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public int getImageDataSize() {
        return this.imageDataSize;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getPictureType() {
        return this.pictureType;
    }

    @Override
    public byte[] getRawImageData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(this.getRawContent(), this.endOfName, this.toWrap.getRawDataSize() - this.endOfName);
        return byteArrayOutputStream.toByteArray();
    }
}

