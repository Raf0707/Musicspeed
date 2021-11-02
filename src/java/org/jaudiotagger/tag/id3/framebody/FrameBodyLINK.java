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
import org.jaudiotagger.tag.datatype.StringFixedLength;
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.datatype.StringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyLINK
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyLINK() {
    }

    public FrameBodyLINK(String string2, String string3, String string4) {
        this.setObjectValue("Description", string2);
        this.setObjectValue("URL", string3);
        this.setObjectValue("ID", string4);
    }

    public FrameBodyLINK(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyLINK(FrameBodyLINK frameBodyLINK) {
        super(frameBodyLINK);
    }

    public String getAdditionalData() {
        return (String)this.getObjectValue("ID");
    }

    public void getAdditionalData(String string2) {
        this.setObjectValue("ID", string2);
    }

    public String getFrameIdentifier() {
        return (String)this.getObjectValue("Description");
    }

    public void getFrameIdentifier(String string2) {
        this.setObjectValue("Description", string2);
    }

    @Override
    public String getIdentifier() {
        return "LINK";
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringFixedLength("Description", this, 4));
        this.objectList.add((Object)new StringNullTerminated("URL", this));
        this.objectList.add((Object)new StringSizeTerminated("ID", this));
    }
}

