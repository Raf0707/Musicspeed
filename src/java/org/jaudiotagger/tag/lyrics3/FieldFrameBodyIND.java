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
import org.jaudiotagger.tag.datatype.BooleanString;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.lyrics3.AbstractLyrics3v2FieldFrameBody;

public class FieldFrameBodyIND
extends AbstractLyrics3v2FieldFrameBody {
    public FieldFrameBodyIND() {
    }

    public FieldFrameBodyIND(ByteBuffer byteBuffer) throws InvalidTagException {
        this.read(byteBuffer);
    }

    public FieldFrameBodyIND(FieldFrameBodyIND fieldFrameBodyIND) {
        super(fieldFrameBodyIND);
    }

    public FieldFrameBodyIND(boolean bl, boolean bl2) {
        this.setObjectValue("Lyrics Present", bl);
        this.setObjectValue("Timestamp Present", bl2);
    }

    public String getAuthor() {
        return (String)this.getObjectValue("Author");
    }

    @Override
    public String getIdentifier() {
        return "IND";
    }

    public void setAuthor(String string2) {
        this.setObjectValue("Author", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new BooleanString("Lyrics Present", this));
        this.objectList.add((Object)new BooleanString("Timestamp Present", this));
    }
}

