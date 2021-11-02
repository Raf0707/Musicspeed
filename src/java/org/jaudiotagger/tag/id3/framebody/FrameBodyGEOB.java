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
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.datatype.TextEncodedStringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyGEOB
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyGEOB() {
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("MIMEType", "");
        this.setObjectValue("Filename", "");
        this.setObjectValue("Description", "");
        this.setObjectValue("Data", new byte[0]);
    }

    public FrameBodyGEOB(byte by, String string2, String string3, String string4, byte[] arrby) {
        this.setObjectValue("TextEncoding", by);
        this.setObjectValue("MIMEType", string2);
        this.setObjectValue("Filename", string3);
        this.setObjectValue("Description", string4);
        this.setObjectValue("Data", arrby);
    }

    public FrameBodyGEOB(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyGEOB(FrameBodyGEOB frameBodyGEOB) {
        super(frameBodyGEOB);
    }

    public String getDescription() {
        return (String)this.getObjectValue("Description");
    }

    @Override
    public String getIdentifier() {
        return "GEOB";
    }

    public void setDescription(String string2) {
        this.setObjectValue("Description", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new StringNullTerminated("MIMEType", this));
        this.objectList.add((Object)new TextEncodedStringNullTerminated("Filename", this));
        this.objectList.add((Object)new TextEncodedStringNullTerminated("Description", this));
        this.objectList.add((Object)new ByteArraySizeTerminated("Data", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        if (!((AbstractString)this.getObject("Filename")).canBeEncoded()) {
            this.setTextEncoding((byte)1);
        }
        if (!((AbstractString)this.getObject("Description")).canBeEncoded()) {
            this.setTextEncoding((byte)1);
        }
        super.write(byteArrayOutputStream);
    }
}

