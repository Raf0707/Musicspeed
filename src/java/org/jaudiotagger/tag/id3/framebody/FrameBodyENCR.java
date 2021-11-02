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
import org.jaudiotagger.tag.datatype.NumberFixedLength;
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyENCR
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyENCR() {
        this.setObjectValue("Owner", "");
        this.setObjectValue("MethodSymbol", (byte)0);
        this.setObjectValue("EncryptionInfo", new byte[0]);
    }

    public FrameBodyENCR(String string2, byte by, byte[] arrby) {
        this.setObjectValue("Owner", string2);
        this.setObjectValue("MethodSymbol", by);
        this.setObjectValue("EncryptionInfo", arrby);
    }

    public FrameBodyENCR(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyENCR(FrameBodyENCR frameBodyENCR) {
        super(frameBodyENCR);
    }

    @Override
    public String getIdentifier() {
        return "ENCR";
    }

    public String getOwner() {
        return (String)this.getObjectValue("Owner");
    }

    public void setOwner(String string2) {
        this.setObjectValue("Owner", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringNullTerminated("Owner", this));
        this.objectList.add((Object)new NumberFixedLength("MethodSymbol", this, 1));
        this.objectList.add((Object)new ByteArraySizeTerminated("EncryptionInfo", this));
    }
}

