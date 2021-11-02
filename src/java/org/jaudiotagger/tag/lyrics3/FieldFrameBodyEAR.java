/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 */
package org.jaudiotagger.tag.lyrics3;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.StringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.lyrics3.AbstractLyrics3v2FieldFrameBody;

public class FieldFrameBodyEAR
extends AbstractLyrics3v2FieldFrameBody {
    public FieldFrameBodyEAR() {
    }

    public FieldFrameBodyEAR(String string2) {
        this.setObjectValue("Artist", string2);
    }

    public FieldFrameBodyEAR(ByteBuffer byteBuffer) throws InvalidTagException {
        this.read(byteBuffer);
    }

    public FieldFrameBodyEAR(FieldFrameBodyEAR fieldFrameBodyEAR) {
        super(fieldFrameBodyEAR);
    }

    public String getArtist() {
        return (String)this.getObjectValue("Artist");
    }

    @Override
    public String getIdentifier() {
        return "EAR";
    }

    public void setArtist(String string2) {
        this.setObjectValue("Artist", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringSizeTerminated("Artist", this));
    }
}

