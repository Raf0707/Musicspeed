/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
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
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyGRID
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyGRID() {
    }

    public FrameBodyGRID(String string2, byte by, byte[] arrby) {
        this.setObjectValue("Owner", string2);
        this.setObjectValue("GroupSymbol", by);
        this.setObjectValue("GroupData", arrby);
    }

    public FrameBodyGRID(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyGRID(FrameBodyGRID frameBodyGRID) {
        super(frameBodyGRID);
    }

    public byte getGroupSymbol() {
        if (this.getObjectValue("GroupSymbol") != null) {
            return ((Long)this.getObjectValue("GroupSymbol")).byteValue();
        }
        return 0;
    }

    @Override
    public String getIdentifier() {
        return "GRID";
    }

    public String getOwner() {
        return (String)this.getObjectValue("Owner");
    }

    public void setGroupSymbol(byte by) {
        this.setObjectValue("GroupSymbol", by);
    }

    public void setOwner(String string2) {
        this.setObjectValue("Owner", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringNullTerminated("Owner", this));
        this.objectList.add((Object)new NumberFixedLength("GroupSymbol", this, 1));
        this.objectList.add((Object)new ByteArraySizeTerminated("GroupData", this));
    }
}

