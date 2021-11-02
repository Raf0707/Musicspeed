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

public class FieldFrameBodyETT
extends AbstractLyrics3v2FieldFrameBody {
    public FieldFrameBodyETT() {
    }

    public FieldFrameBodyETT(String string2) {
        this.setObjectValue("Title", string2);
    }

    public FieldFrameBodyETT(ByteBuffer byteBuffer) throws InvalidTagException {
        this.read(byteBuffer);
    }

    public FieldFrameBodyETT(FieldFrameBodyETT fieldFrameBodyETT) {
        super(fieldFrameBodyETT);
    }

    @Override
    public String getIdentifier() {
        return "ETT";
    }

    public String getTitle() {
        return (String)this.getObjectValue("Title");
    }

    public void setTitle(String string2) {
        this.setObjectValue("Title", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringSizeTerminated("Title", this));
    }
}

