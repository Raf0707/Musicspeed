/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
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
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractString;
import org.jaudiotagger.tag.datatype.ByteArraySizeTerminated;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.datatype.TextEncodedStringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodyPIC;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;
import org.jaudiotagger.tag.id3.valuepair.ImageFormats;

public class FrameBodyAPIC
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public static final String IMAGE_IS_URL = "-->";

    public FrameBodyAPIC() {
        this.setObjectValue("TextEncoding", (byte)0);
    }

    public FrameBodyAPIC(byte by, String string2, byte by2, String string3, byte[] arrby) {
        this.setObjectValue("TextEncoding", by);
        this.setMimeType(string2);
        this.setPictureType(by2);
        this.setDescription(string3);
        this.setImageData(arrby);
    }

    public FrameBodyAPIC(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyAPIC(FrameBodyAPIC frameBodyAPIC) {
        super(frameBodyAPIC);
    }

    public FrameBodyAPIC(FrameBodyPIC frameBodyPIC) {
        this.setObjectValue("TextEncoding", frameBodyPIC.getTextEncoding());
        this.setObjectValue("MIMEType", ImageFormats.getMimeTypeForFormat((String)frameBodyPIC.getObjectValue("ImageType")));
        this.setObjectValue("PictureType", frameBodyPIC.getObjectValue("PictureType"));
        this.setObjectValue("Description", frameBodyPIC.getDescription());
        this.setObjectValue("PictureData", frameBodyPIC.getObjectValue("PictureData"));
    }

    public String getDescription() {
        return (String)this.getObjectValue("Description");
    }

    @Override
    public String getIdentifier() {
        return "APIC";
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

    @Override
    public String getUserFriendlyValue() {
        if (this.getImageData() != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getMimeType());
            stringBuilder.append(":");
            stringBuilder.append(this.getDescription());
            stringBuilder.append(":");
            stringBuilder.append(this.getImageData().length);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getMimeType());
        stringBuilder.append(":");
        stringBuilder.append(this.getDescription());
        stringBuilder.append(":0");
        return stringBuilder.toString();
    }

    public boolean isImageUrl() {
        return this.getMimeType() != null && this.getMimeType().equals((Object)IMAGE_IS_URL);
    }

    public void setDescription(String string2) {
        this.setObjectValue("Description", string2);
    }

    public void setImageData(byte[] arrby) {
        this.setObjectValue("PictureData", arrby);
    }

    public void setMimeType(String string2) {
        this.setObjectValue("MIMEType", string2);
    }

    public void setPictureType(byte by) {
        this.setObjectValue("PictureType", by);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new StringNullTerminated("MIMEType", this));
        this.objectList.add((Object)new NumberHashMap("PictureType", this, 1));
        this.objectList.add((Object)new TextEncodedStringNullTerminated("Description", this));
        this.objectList.add((Object)new ByteArraySizeTerminated("PictureData", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        if (TagOptionSingleton.getInstance().isAPICDescriptionITunesCompatible()) {
            this.setTextEncoding((byte)0);
            if (!((AbstractString)this.getObject("Description")).canBeEncoded()) {
                this.setDescription("");
            }
        } else if (!((AbstractString)this.getObject("Description")).canBeEncoded()) {
            this.setTextEncoding((byte)1);
        }
        super.write(byteArrayOutputStream);
    }
}

