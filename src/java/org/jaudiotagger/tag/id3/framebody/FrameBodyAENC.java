/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Short
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
import org.jaudiotagger.tag.datatype.NumberFixedLength;
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyAENC
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyAENC() {
        this.setObjectValue("Owner", "");
        Short s2 = 0;
        this.setObjectValue("PreviewStart", (Object)s2);
        this.setObjectValue("PreviewLength", (Object)s2);
        this.setObjectValue("EncryptionInfo", new byte[0]);
    }

    public FrameBodyAENC(String string2, short s2, short s3, byte[] arrby) {
        this.setObjectValue("Owner", string2);
        this.setObjectValue("PreviewStart", s2);
        this.setObjectValue("PreviewLength", s3);
        this.setObjectValue("EncryptionInfo", arrby);
    }

    public FrameBodyAENC(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyAENC(FrameBodyAENC frameBodyAENC) {
        super(frameBodyAENC);
    }

    @Override
    public String getIdentifier() {
        return "AENC";
    }

    public String getOwner() {
        return (String)this.getObjectValue("Owner");
    }

    public void getOwner(String string2) {
        this.setObjectValue("Owner", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringNullTerminated("Owner", this));
        this.objectList.add((Object)new NumberFixedLength("PreviewStart", this, 2));
        this.objectList.add((Object)new NumberFixedLength("PreviewLength", this, 2));
        this.objectList.add((Object)new ByteArraySizeTerminated("EncryptionInfo", this));
    }
}

