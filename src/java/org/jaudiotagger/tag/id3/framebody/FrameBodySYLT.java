/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Number
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
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.StringHashMap;
import org.jaudiotagger.tag.datatype.StringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodySYLT
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodySYLT() {
    }

    public FrameBodySYLT(int n2, String string2, int n3, int n4, String string3, byte[] arrby) {
        this.setObjectValue("TextEncoding", n2);
        this.setObjectValue("Language", string2);
        this.setObjectValue("TimeStampFormat", n3);
        this.setObjectValue("contentType", n4);
        this.setObjectValue("Description", string3);
        this.setObjectValue("Data", arrby);
    }

    public FrameBodySYLT(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodySYLT(FrameBodySYLT frameBodySYLT) {
        super(frameBodySYLT);
    }

    public int getContentType() {
        return ((Number)this.getObjectValue("contentType")).intValue();
    }

    public String getDescription() {
        return (String)this.getObjectValue("Description");
    }

    @Override
    public String getIdentifier() {
        return "SYLT";
    }

    public String getLanguage() {
        return (String)this.getObjectValue("Language");
    }

    public byte[] getLyrics() {
        return (byte[])this.getObjectValue("Data");
    }

    public int getTimeStampFormat() {
        return ((Number)this.getObjectValue("TimeStampFormat")).intValue();
    }

    public void setLyrics(byte[] arrby) {
        this.setObjectValue("Data", arrby);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new StringHashMap("Language", this, 3));
        this.objectList.add((Object)new NumberHashMap("TimeStampFormat", this, 1));
        this.objectList.add((Object)new NumberHashMap("contentType", this, 1));
        this.objectList.add((Object)new StringNullTerminated("Description", this));
        this.objectList.add((Object)new ByteArraySizeTerminated("Data", this));
    }
}

