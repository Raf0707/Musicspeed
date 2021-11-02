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

public class FieldFrameBodyINF
extends AbstractLyrics3v2FieldFrameBody {
    public FieldFrameBodyINF() {
    }

    public FieldFrameBodyINF(String string2) {
        this.setObjectValue("Additional Information", string2);
    }

    public FieldFrameBodyINF(ByteBuffer byteBuffer) throws InvalidTagException {
        this.read(byteBuffer);
    }

    public FieldFrameBodyINF(FieldFrameBodyINF fieldFrameBodyINF) {
        super(fieldFrameBodyINF);
    }

    public String getAdditionalInformation() {
        return (String)this.getObjectValue("Additional Information");
    }

    @Override
    public String getIdentifier() {
        return "INF";
    }

    public void setAdditionalInformation(String string2) {
        this.setObjectValue("Additional Information", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new StringSizeTerminated("Additional Information", this));
    }
}

