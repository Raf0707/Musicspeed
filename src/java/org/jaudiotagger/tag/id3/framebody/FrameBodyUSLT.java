/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 */
package org.jaudiotagger.tag.id3.framebody;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractString;
import org.jaudiotagger.tag.datatype.Lyrics3Line;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.StringHashMap;
import org.jaudiotagger.tag.datatype.TextEncodedStringNullTerminated;
import org.jaudiotagger.tag.datatype.TextEncodedStringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrame;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3TextEncodingConversion;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyUSLT
extends AbstractID3v2FrameBody
implements ID3v23FrameBody,
ID3v24FrameBody {
    public FrameBodyUSLT() {
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Language", "");
        this.setObjectValue("Description", "");
        this.setObjectValue("Lyrics", "");
    }

    public FrameBodyUSLT(byte by, String string2, String string3, String string4) {
        this.setObjectValue("TextEncoding", by);
        this.setObjectValue("Language", string2);
        this.setObjectValue("Description", string3);
        this.setObjectValue("Lyrics", string4);
    }

    public FrameBodyUSLT(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyUSLT(FrameBodyUSLT frameBodyUSLT) {
        super(frameBodyUSLT);
    }

    public void addLyric(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLyric());
        stringBuilder.append(string2);
        this.setLyric(stringBuilder.toString());
    }

    public void addLyric(Lyrics3Line lyrics3Line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLyric());
        stringBuilder.append(lyrics3Line.writeString());
        this.setLyric(stringBuilder.toString());
    }

    public String getDescription() {
        return (String)this.getObjectValue("Description");
    }

    public String getFirstTextValue() {
        return ((TextEncodedStringSizeTerminated)this.getObject("Lyrics")).getValueAtIndex(0);
    }

    @Override
    public String getIdentifier() {
        return "USLT";
    }

    public String getLanguage() {
        return (String)this.getObjectValue("Language");
    }

    public String getLyric() {
        return (String)this.getObjectValue("Lyrics");
    }

    @Override
    public String getUserFriendlyValue() {
        return this.getFirstTextValue();
    }

    public void setDescription(String string2) {
        this.setObjectValue("Description", string2);
    }

    public void setLanguage(String string2) {
        this.setObjectValue("Language", string2);
    }

    public void setLyric(String string2) {
        this.setObjectValue("Lyrics", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new StringHashMap("Language", this, 3));
        this.objectList.add((Object)new TextEncodedStringNullTerminated("Description", this));
        this.objectList.add((Object)new TextEncodedStringSizeTerminated("Lyrics", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        this.setTextEncoding(ID3TextEncodingConversion.getTextEncoding(this.getHeader(), this.getTextEncoding()));
        if (!((AbstractString)this.getObject("Description")).canBeEncoded()) {
            this.setTextEncoding(ID3TextEncodingConversion.getUnicodeTextEncoding(this.getHeader()));
        }
        if (!((AbstractString)this.getObject("Lyrics")).canBeEncoded()) {
            this.setTextEncoding(ID3TextEncodingConversion.getUnicodeTextEncoding(this.getHeader()));
        }
        super.write(byteArrayOutputStream);
    }
}

