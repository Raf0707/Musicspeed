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
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v22FrameBody;

public class FrameBodyCRM
extends AbstractID3v2FrameBody
implements ID3v22FrameBody {
    public FrameBodyCRM() {
    }

    public FrameBodyCRM(String string2, String string3, byte[] arrby) {
        this.setObjectValue("Owner", string2);
        this.setObjectValue("Description", string3);
        this.setObjectValue("EncryptedDataBlock", arrby);
    }

    public FrameBodyCRM(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyCRM(FrameBodyCRM frameBodyCRM) {
        super(frameBodyCRM);
    }

    @Override
    public String getIdentifier() {
        return "CRM";
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
        this.objectList.add((Object)new StringNullTerminated("Description", this));
        this.objectList.add((Object)new ByteArraySizeTerminated("EncryptedDataBlock", this));
    }
}

