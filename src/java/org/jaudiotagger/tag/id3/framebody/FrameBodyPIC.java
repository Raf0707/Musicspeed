/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 */
package org.jaudiotagger.tag.id3.framebody;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractString;
import org.jaudiotagger.tag.datatype.ByteArraySizeTerminated;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.StringFixedLength;
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;
import org.jaudiotagger.tag.id3.framebody.ID3v22FrameBody;
import org.jaudiotagger.tag.id3.valuepair.ImageFormats;

public class FrameBodyPIC
extends AbstractID3v2FrameBody
implements ID3v22FrameBody {
    public static final String IMAGE_IS_URL = "-->";

    public FrameBodyPIC() {
        this.setObjectValue("TextEncoding", (byte)0);
    }

    public FrameBodyPIC(byte by, String string2, byte by2, String string3, byte[] arrby) {
        this.setObjectValue("TextEncoding", by);
        this.setObjectValue("ImageType", string2);
        this.setPictureType(by2);
        this.setDescription(string3);
        this.setImageData(arrby);
    }

    public FrameBodyPIC(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyPIC(FrameBodyAPIC frameBodyAPIC) {
        this.setObjectValue("TextEncoding", frameBodyAPIC.getTextEncoding());
        this.setObjectValue("ImageType", ImageFormats.getFormatForMimeType((String)frameBodyAPIC.getObjectValue("MIMEType")));
        this.setObjectValue("PictureData", frameBodyAPIC.getObjectValue("PictureData"));
        this.setDescription(frameBodyAPIC.getDescription());
        this.setImageData(frameBodyAPIC.getImageData());
    }

    public FrameBodyPIC(FrameBodyPIC frameBodyPIC) {
        super(frameBodyPIC);
    }

    public String getDescription() {
        return (String)this.getObjectValue("Description");
    }

    public String getFormatType() {
        return (String)this.getObjectValue("ImageType");
    }

    @Override
    public String getIdentifier() {
        return "PIC";
    }

    public byte[] getImageData() {
        return (byte[])this.getObjectValue("PictureData");
    }

    public String getImageUrl() {
        if (this.isImageUrl()) {
            return new String((byte[])this.getObjectValue("PictureData"), 0, ((byte[])this.getObjectValue("PictureData")).length, StandardCharsets.ISO_8859_1);
        }
        return "";
    }

    public String getMimeType() {
        return (String)this.getObjectValue("MIMEType");
    }

    public int getPictureType() {
        return ((Long)this.getObjectValue("PictureType")).intValue();
    }

    public boolean isImageUrl() {
        return this.getFormatType() != null && this.getFormatType().equals((Object)IMAGE_IS_URL);
    }

    public void setDescription(String string2) {
        this.setObjectValue("Description", string2);
    }

    public void setImageData(byte[] arrby) {
        this.setObjectValue("PictureData", arrby);
    }

    public void setPictureType(byte by) {
        this.setObjectValue("PictureType", by);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new StringFixedLength("ImageType", this, 3));
        this.objectList.add((Object)new NumberHashMap("PictureType", this, 1));
        this.objectList.add((Object)new StringNullTerminated("Description", this));
        this.objectList.add((Object)new ByteArraySizeTerminated("PictureData", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        if (!((AbstractString)this.getObject("Description")).canBeEncoded()) {
            this.setTextEncoding((byte)1);
        }
        super.write(byteArrayOutputStream);
    }
}

