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
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.StringDate;
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.datatype.TextEncodedStringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrame;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3TextEncodingConversion;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyOWNE
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyOWNE() {
    }

    public FrameBodyOWNE(byte by, String string2, String string3, String string4) {
        this.setObjectValue("TextEncoding", by);
        this.setObjectValue("PricePaid", string2);
        this.setObjectValue("PurchaseDate", string3);
        this.setObjectValue("SellerName", string4);
    }

    public FrameBodyOWNE(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyOWNE(FrameBodyOWNE frameBodyOWNE) {
        super(frameBodyOWNE);
    }

    @Override
    public String getIdentifier() {
        return "OWNE";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new StringNullTerminated("PricePaid", this));
        this.objectList.add((Object)new StringDate("PurchaseDate", this));
        this.objectList.add((Object)new TextEncodedStringSizeTerminated("SellerName", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        this.setTextEncoding(ID3TextEncodingConversion.getTextEncoding(this.getHeader(), this.getTextEncoding()));
        if (!((AbstractString)this.getObject("SellerName")).canBeEncoded()) {
            this.setTextEncoding(ID3TextEncodingConversion.getUnicodeTextEncoding(this.getHeader()));
        }
        super.write(byteArrayOutputStream);
    }
}

