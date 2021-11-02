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
import org.jaudiotagger.tag.id3.framebody.ID3v22FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyUnsupported
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody,
ID3v22FrameBody {
    private String identifier = "";

    public FrameBodyUnsupported() {
    }

    public FrameBodyUnsupported(String string2) {
        this.identifier = string2;
    }

    public FrameBodyUnsupported(String string2, byte[] arrby) {
        this.identifier = string2;
        this.setObjectValue("Data", arrby);
    }

    public FrameBodyUnsupported(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyUnsupported(FrameBodyUnsupported frameBodyUnsupported) {
        super(frameBodyUnsupported);
        this.identifier = frameBodyUnsupported.identifier;
    }

    public FrameBodyUnsupported(byte[] arrby) {
        this.setObjectValue("Data", arrby);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FrameBodyUnsupported)) {
            return false;
        }
        FrameBodyUnsupported frameBodyUnsupported = (FrameBodyUnsupported)object;
        boolean bl = this.identifier.equals((Object)frameBodyUnsupported.identifier);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = super.equals(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new ByteArraySizeTerminated("Data", this));
    }

    @Override
    public String toString() {
        return this.getIdentifier();
    }
}

