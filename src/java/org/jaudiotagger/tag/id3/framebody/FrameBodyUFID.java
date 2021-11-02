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
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyUFID
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public static final String UFID_ID3TEST = "http://www.id3.org/dummy/ufid.html";
    public static final String UFID_MUSICBRAINZ = "http://musicbrainz.org";

    public FrameBodyUFID() {
        this.setOwner("");
        this.setUniqueIdentifier(new byte[0]);
    }

    public FrameBodyUFID(String string2, byte[] arrby) {
        this.setOwner(string2);
        this.setUniqueIdentifier(arrby);
    }

    public FrameBodyUFID(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyUFID(FrameBodyUFID frameBodyUFID) {
        super(frameBodyUFID);
    }

    @Override
    public String getIdentifier() {
        return "UFID";
    }

    public String getOwner() {
        return (String)this.getObjectValue("Owner");
    }

    public byte[] getUniqueIdentifier() {
        return (byte[])this.getObjectValue("Data");
    }

    public void setOwner(String string2) {
        this.setObjectValue("Owner", string2);
    }

    public void setUniqueIdentifier(byte[] arrby) {
        this.setObjectValue("Data", arrby);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringNullTerminated("Owner", this));
        this.objectList.add((Object)new ByteArraySizeTerminated("Data", this));
    }
}

