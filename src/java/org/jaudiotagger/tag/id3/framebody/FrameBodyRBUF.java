/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
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
import org.jaudiotagger.tag.datatype.BooleanByte;
import org.jaudiotagger.tag.datatype.NumberFixedLength;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyRBUF
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    private static int BUFFER_FIELD_SIZE = 3;
    private static int EMBED_FLAG_BIT_POSITION = 1;
    private static int OFFSET_FIELD_SIZE = 4;

    public FrameBodyRBUF() {
        Byte by = 0;
        this.setObjectValue("BufferSize", (Object)by);
        this.setObjectValue("EmbedFlag", (Object)Boolean.FALSE);
        this.setObjectValue("Offset", (Object)by);
    }

    public FrameBodyRBUF(byte by, boolean bl, byte by2) {
        this.setObjectValue("BufferSize", by);
        this.setObjectValue("EmbedFlag", bl);
        this.setObjectValue("Offset", by2);
    }

    public FrameBodyRBUF(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyRBUF(FrameBodyRBUF frameBodyRBUF) {
        super(frameBodyRBUF);
    }

    @Override
    public String getIdentifier() {
        return "RBUF";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberFixedLength("BufferSize", this, BUFFER_FIELD_SIZE));
        this.objectList.add((Object)new BooleanByte("EmbedFlag", this, (byte)EMBED_FLAG_BIT_POSITION));
        this.objectList.add((Object)new NumberFixedLength("Offset", this, OFFSET_FIELD_SIZE));
    }
}

