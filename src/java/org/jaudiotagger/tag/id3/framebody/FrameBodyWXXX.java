/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.List
 */
package org.jaudiotagger.tag.id3.framebody;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractString;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.StringSizeTerminated;
import org.jaudiotagger.tag.datatype.TextEncodedStringNullTerminated;
import org.jaudiotagger.tag.datatype.TextEncodedStringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyUrlLink;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyWXXX
extends AbstractFrameBodyUrlLink
implements ID3v24FrameBody,
ID3v23FrameBody {
    public static final String URL_DISCOGS_ARTIST_SITE = "DISCOGS_ARTIST";
    public static final String URL_DISCOGS_RELEASE_SITE = "DISCOGS_RELEASE";
    public static final String URL_LYRICS_SITE = "LYRICS_SITE";
    public static final String URL_OFFICIAL_RELEASE_SITE = "OFFICIAL_RELEASE";
    public static final String URL_WIKIPEDIA_ARTIST_SITE = "WIKIPEDIA_ARTIST";
    public static final String URL_WIKIPEDIA_RELEASE_SITE = "WIKIPEDIA_RELEASE";

    public FrameBodyWXXX() {
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Description", "");
        this.setObjectValue("URLLink", "");
    }

    public FrameBodyWXXX(byte by, String string2, String string3) {
        this.setObjectValue("TextEncoding", by);
        this.setObjectValue("Description", string2);
        this.setObjectValue("URLLink", string3);
    }

    public FrameBodyWXXX(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyWXXX(FrameBodyWXXX frameBodyWXXX) {
        super(frameBodyWXXX);
    }

    public void addUrlLink(String string2) {
        ((TextEncodedStringSizeTerminated)this.getObject("URLLink")).addValue(string2);
    }

    public String getDescription() {
        return (String)this.getObjectValue("Description");
    }

    public String getFirstUrlLink() {
        return ((TextEncodedStringSizeTerminated)this.getObject("URLLink")).getValueAtIndex(0);
    }

    @Override
    public String getIdentifier() {
        return "WXXX";
    }

    public String getUrlLinkAtIndex(int n2) {
        return ((TextEncodedStringSizeTerminated)this.getObject("URLLink")).getValueAtIndex(n2);
    }

    public String getUrlLinkWithoutTrailingNulls() {
        return ((TextEncodedStringSizeTerminated)this.getObject("URLLink")).getValueWithoutTrailingNull();
    }

    public List<String> getUrlLinks() {
        return ((TextEncodedStringSizeTerminated)this.getObject("URLLink")).getValues();
    }

    public void setDescription(String string2) {
        this.setObjectValue("Description", string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new TextEncodedStringNullTerminated("Description", this));
        this.objectList.add((Object)new StringSizeTerminated("URLLink", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        if (!((AbstractString)this.getObject("Description")).canBeEncoded()) {
            this.setTextEncoding((byte)1);
        }
        super.write(byteArrayOutputStream);
    }
}

