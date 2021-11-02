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
import org.jaudiotagger.tag.id3.framebody.FrameBodyRVAD;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyRVA2
extends AbstractID3v2FrameBody
implements ID3v24FrameBody {
    public FrameBodyRVA2() {
    }

    public FrameBodyRVA2(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyRVA2(FrameBodyRVA2 frameBodyRVA2) {
        super(frameBodyRVA2);
    }

    public FrameBodyRVA2(FrameBodyRVAD frameBodyRVAD) {
        this.setObjectValue("Data", frameBodyRVAD.getObjectValue("Data"));
    }

    @Override
    public String getIdentifier() {
        return "RVA2";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new ByteArraySizeTerminated("Data", this));
    }
}

