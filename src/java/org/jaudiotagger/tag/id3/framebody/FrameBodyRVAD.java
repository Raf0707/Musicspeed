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
import org.jaudiotagger.tag.id3.framebody.FrameBodyRVA2;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;

public class FrameBodyRVAD
extends AbstractID3v2FrameBody
implements ID3v23FrameBody {
    public FrameBodyRVAD() {
    }

    public FrameBodyRVAD(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyRVAD(FrameBodyRVA2 frameBodyRVA2) {
        this.setObjectValue("Data", frameBodyRVA2.getObjectValue("Data"));
    }

    public FrameBodyRVAD(FrameBodyRVAD frameBodyRVAD) {
        super(frameBodyRVAD);
    }

    @Override
    public String getIdentifier() {
        return "RVAD";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new ByteArraySizeTerminated("Data", this));
    }
}

