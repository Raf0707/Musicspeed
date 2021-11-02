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

public class FieldFrameBodyEAL
extends AbstractLyrics3v2FieldFrameBody {
    public FieldFrameBodyEAL() {
    }

    public FieldFrameBodyEAL(String string2) {
        this.setObjectValue("Album", string2);
    }

    public FieldFrameBodyEAL(ByteBuffer byteBuffer) throws InvalidTagException {
        this.read(byteBuffer);
    }

    public FieldFrameBodyEAL(FieldFrameBodyEAL fieldFrameBodyEAL) {
        super(fieldFrameBodyEAL);
    }

    public String getAlbum() {
        return (String)this.getObjectValue("Album");
    }

    @Override
    public String getIdentifier() {
        return "EAL";
    }

    public void setAlbum(String string2) {
        this.setObjectValue("Album", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringSizeTerminated("Album", this));
    }
}

