/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.ByteArraySizeTerminated;
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyPRIV
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyPRIV() {
        this.setObjectValue("Owner", "");
        this.setObjectValue("Data", new byte[0]);
    }

    public FrameBodyPRIV(String string2, byte[] arrby) {
        this.setObjectValue("Owner", string2);
        this.setObjectValue("Data", arrby);
    }

    public FrameBodyPRIV(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyPRIV(FrameBodyPRIV frameBodyPRIV) {
        super(frameBodyPRIV);
    }

    public byte[] getData() {
        return (byte[])this.getObjectValue("Data");
    }

    @Override
    public String getIdentifier() {
        return "PRIV";
    }

    public String getOwner() {
        return (String)this.getObjectValue("Owner");
    }

    public void setData(byte[] arrby) {
        this.setObjectValue("Data", arrby);
    }

    public void setOwner(String string2) {
        this.setObjectValue("Owner", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringNullTerminated("Owner", this));
        this.objectList.add((Object)new ByteArraySizeTerminated("Data", this));
    }
}

