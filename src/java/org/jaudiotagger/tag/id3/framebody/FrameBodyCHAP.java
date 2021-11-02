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
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v2ChapterFrameBody;

public class FrameBodyCHAP
extends AbstractID3v2FrameBody
implements ID3v2ChapterFrameBody {
    public FrameBodyCHAP() {
    }

    public FrameBodyCHAP(String string2, int n2, int n3, int n4, int n5) {
        this.setObjectValue("ElementID", string2);
        this.setObjectValue("StartTime", n2);
        this.setObjectValue("EndTime", n3);
        this.setObjectValue("StartOffset", n4);
        this.setObjectValue("EndOffset", n5);
    }

    public FrameBodyCHAP(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyCHAP(FrameBodyCHAP frameBodyCHAP) {
        super(frameBodyCHAP);
    }

    @Override
    public String getIdentifier() {
        return "CHAP";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringNullTerminated("ElementID", this));
        this.objectList.add((Object)new NumberFixedLength("StartTime", this, 4));
        this.objectList.add((Object)new NumberFixedLength("EndTime", this, 4));
        this.objectList.add((Object)new NumberFixedLength("StartOffset", this, 4));
        this.objectList.add((Object)new NumberFixedLength("EndOffset", this, 4));
    }
}

