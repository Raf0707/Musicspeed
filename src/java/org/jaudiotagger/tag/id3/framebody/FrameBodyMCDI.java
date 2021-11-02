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
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyMCDI
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyMCDI() {
        this.setObjectValue("Data", new byte[0]);
    }

    public FrameBodyMCDI(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyMCDI(FrameBodyMCDI frameBodyMCDI) {
        super(frameBodyMCDI);
    }

    public FrameBodyMCDI(byte[] arrby) {
        this.setObjectValue("Data", arrby);
    }

    @Override
    public String getIdentifier() {
        return "MCDI";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new ByteArraySizeTerminated("Data", this));
    }
}

