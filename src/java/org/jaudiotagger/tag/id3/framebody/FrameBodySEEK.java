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
import org.jaudiotagger.tag.datatype.NumberFixedLength;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodySEEK
extends AbstractID3v2FrameBody
implements ID3v24FrameBody {
    public FrameBodySEEK() {
    }

    public FrameBodySEEK(int n2) {
        this.setObjectValue("Offset", n2);
    }

    public FrameBodySEEK(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodySEEK(FrameBodySEEK frameBodySEEK) {
        super(frameBodySEEK);
    }

    @Override
    public String getIdentifier() {
        return "ASPI";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberFixedLength("Offset", this, 4));
    }
}

