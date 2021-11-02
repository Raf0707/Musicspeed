/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package org.jaudiotagger.tag.id3.framebody;

import java.util.ArrayList;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.ByteArraySizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;

public class FrameBodyEQUA
extends AbstractID3v2FrameBody
implements ID3v23FrameBody {
    public FrameBodyEQUA() {
    }

    public FrameBodyEQUA(FrameBodyEQUA frameBodyEQUA) {
        super(frameBodyEQUA);
    }

    @Override
    public String getIdentifier() {
        return "EQUA";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new ByteArraySizeTerminated("Data", this));
    }
}

