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

public class FieldFrameBodyAUT
extends AbstractLyrics3v2FieldFrameBody {
    public FieldFrameBodyAUT() {
    }

    public FieldFrameBodyAUT(String string2) {
        this.setObjectValue("Author", string2);
    }

    public FieldFrameBodyAUT(ByteBuffer byteBuffer) throws InvalidTagException {
        this.read(byteBuffer);
    }

    public FieldFrameBodyAUT(FieldFrameBodyAUT fieldFrameBodyAUT) {
        super(fieldFrameBodyAUT);
    }

    public String getAuthor() {
        return (String)this.getObjectValue("Author");
    }

    @Override
    public String getIdentifier() {
        return "AUT";
    }

    public void setAuthor(String string2) {
        this.setObjectValue("Author", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringSizeTerminated("Author", this));
    }
}

