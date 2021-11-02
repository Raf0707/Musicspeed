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
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.NumberVariableLength;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyPOSS
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyPOSS() {
    }

    public FrameBodyPOSS(byte by, long l2) {
        this.setObjectValue("TimeStampFormat", by);
        this.setObjectValue("Position", l2);
    }

    public FrameBodyPOSS(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyPOSS(FrameBodyPOSS frameBodyPOSS) {
        super(frameBodyPOSS);
    }

    @Override
    public String getIdentifier() {
        return "POSS";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TimeStampFormat", this, 1));
        this.objectList.add((Object)new NumberVariableLength("Position", this, 1));
    }
}

