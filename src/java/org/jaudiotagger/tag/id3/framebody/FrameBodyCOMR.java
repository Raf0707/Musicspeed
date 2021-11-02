/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 */
package org.jaudiotagger.tag.id3.framebody;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractString;
import org.jaudiotagger.tag.datatype.ByteArraySizeTerminated;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.StringDate;
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.datatype.TextEncodedStringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyCOMR
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyCOMR() {
    }

    public FrameBodyCOMR(byte by, String string2, String string3, String string4, byte by2, String string5, String string6, String string7, byte[] arrby) {
        this.setObjectValue("TextEncoding", by);
        this.setObjectValue("PriceString", string2);
        this.setObjectValue("ValidUntil", string3);
        this.setObjectValue("ContactURL", string4);
        this.setObjectValue("RecievedAs", by2);
        this.setObjectValue("SellerName", string5);
        this.setObjectValue("Description", string6);
        this.setObjectValue("MIMEType", string7);
        this.setObjectValue("SellerLogo", arrby);
    }

    public FrameBodyCOMR(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyCOMR(FrameBodyCOMR frameBodyCOMR) {
        super(frameBodyCOMR);
    }

    @Override
    public String getIdentifier() {
        return "COMR";
    }

    public String getOwner() {
        return (String)this.getObjectValue("Owner");
    }

    public void getOwner(String string2) {
        this.setObjectValue("Owner", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new StringNullTerminated("PriceString", this));
        this.objectList.add((Object)new StringDate("ValidUntil", this));
        this.objectList.add((Object)new StringNullTerminated("ContactURL", this));
        this.objectList.add((Object)new NumberHashMap("RecievedAs", this, 1));
        this.objectList.add((Object)new TextEncodedStringNullTerminated("SellerName", this));
        this.objectList.add((Object)new TextEncodedStringNullTerminated("Description", this));
        this.objectList.add((Object)new StringNullTerminated("MIMEType", this));
        this.objectList.add((Object)new ByteArraySizeTerminated("SellerLogo", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        if (!((AbstractString)this.getObject("SellerName")).canBeEncoded()) {
            this.setTextEncoding((byte)1);
        }
        if (!((AbstractString)this.getObject("Description")).canBeEncoded()) {
            this.setTextEncoding((byte)1);
        }
        super.write(byteArrayOutputStream);
    }
}

