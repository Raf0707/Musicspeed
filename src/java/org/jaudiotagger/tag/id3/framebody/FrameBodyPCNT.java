/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Number
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
import org.jaudiotagger.tag.datatype.NumberVariableLength;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyPCNT
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    private static final int COUNTER_MINIMUM_FIELD_SIZE = 4;

    public FrameBodyPCNT() {
        this.setObjectValue("Number", 0L);
    }

    public FrameBodyPCNT(long l2) {
        this.setObjectValue("Number", l2);
    }

    public FrameBodyPCNT(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyPCNT(FrameBodyPCNT frameBodyPCNT) {
        super(frameBodyPCNT);
    }

    public long getCounter() {
        return ((Number)this.getObjectValue("Number")).longValue();
    }

    @Override
    public String getIdentifier() {
        return "PCNT";
    }

    public void setCounter(long l2) {
        this.setObjectValue("Number", l2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberVariableLength("Number", this, 4));
    }
}

