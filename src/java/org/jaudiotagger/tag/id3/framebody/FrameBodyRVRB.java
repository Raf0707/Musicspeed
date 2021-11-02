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
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyRVRB
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyRVRB() {
    }

    public FrameBodyRVRB(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyRVRB(FrameBodyRVRB frameBodyRVRB) {
        super(frameBodyRVRB);
    }

    public FrameBodyRVRB(short s2, short s3, byte by, byte by2, byte by3, byte by4, byte by5, byte by6, byte by7, byte by8) {
        this.setObjectValue("ReverbLeft", s2);
        this.setObjectValue("ReverbRight", s3);
        this.setObjectValue("ReverbBounceLeft", by);
        this.setObjectValue("ReverbBounceRight", by2);
        this.setObjectValue("ReverbFeedbackLeftToLeft", by3);
        this.setObjectValue("ReverbFeedbackLeftToRight", by4);
        this.setObjectValue("ReverbFeedbackRightToRight", by5);
        this.setObjectValue("ReverbFeedbackRightToLeft", by6);
        this.setObjectValue("PremixLeftToRight", by7);
        this.setObjectValue("PremixRightToLeft", by8);
    }

    @Override
    public String getIdentifier() {
        return "RVRB";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberFixedLength("ReverbLeft", this, 2));
        this.objectList.add((Object)new NumberFixedLength("ReverbRight", this, 2));
        this.objectList.add((Object)new NumberFixedLength("ReverbBounceLeft", this, 1));
        this.objectList.add((Object)new NumberFixedLength("ReverbBounceRight", this, 1));
        this.objectList.add((Object)new NumberFixedLength("ReverbFeedbackLeftToLeft", this, 1));
        this.objectList.add((Object)new NumberFixedLength("ReverbFeedbackLeftToRight", this, 1));
        this.objectList.add((Object)new NumberFixedLength("ReverbFeedbackRightToRight", this, 1));
        this.objectList.add((Object)new NumberFixedLength("ReverbFeedbackRightToLeft", this, 1));
        this.objectList.add((Object)new NumberFixedLength("PremixLeftToRight", this, 1));
        this.objectList.add((Object)new NumberFixedLength("PremixRightToLeft", this, 1));
    }
}

