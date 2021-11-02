/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Byte
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
import org.jaudiotagger.tag.datatype.NumberFixedLength;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodySIGN
extends AbstractID3v2FrameBody
implements ID3v24FrameBody {
    public FrameBodySIGN() {
    }

    public FrameBodySIGN(byte by, byte[] arrby) {
        this.setObjectValue("GroupSymbol", by);
        this.setObjectValue("Signature", arrby);
    }

    public FrameBodySIGN(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodySIGN(FrameBodySIGN frameBodySIGN) {
        super(frameBodySIGN);
    }

    public byte getGroupSymbol() {
        if (this.getObjectValue("GroupSymbol") != null) {
            return (Byte)this.getObjectValue("GroupSymbol");
        }
        return 0;
    }

    @Override
    public String getIdentifier() {
        return "SIGN";
    }

    public byte[] getSignature() {
        return (byte[])this.getObjectValue("Signature");
    }

    public void setGroupSymbol(byte by) {
        this.setObjectValue("GroupSymbol", by);
    }

    public void setSignature(byte[] arrby) {
        this.setObjectValue("Signature", arrby);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberFixedLength("GroupSymbol", this, 1));
        this.objectList.add((Object)new ByteArraySizeTerminated("Signature", this));
    }
}

