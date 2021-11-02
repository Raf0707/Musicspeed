/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.lang.IllegalArgumentException
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
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.TextEncodedStringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrame;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3TextEncodingConversion;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;

public abstract class AbstractFrameBodyTextInfo
extends AbstractID3v2FrameBody {
    protected AbstractFrameBodyTextInfo() {
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Text", "");
    }

    protected AbstractFrameBodyTextInfo(byte by, String string2) {
        this.setObjectValue("TextEncoding", by);
        this.setObjectValue("Text", string2);
    }

    protected AbstractFrameBodyTextInfo(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    protected AbstractFrameBodyTextInfo(AbstractFrameBodyTextInfo abstractFrameBodyTextInfo) {
        super(abstractFrameBodyTextInfo);
    }

    public void addTextValue(String string2) {
        ((TextEncodedStringSizeTerminated)this.getObject("Text")).addValue(string2);
    }

    public String getFirstTextValue() {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getValueAtIndex(0);
    }

    public int getNumberOfValues() {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getNumberOfValues();
    }

    public String getText() {
        return (String)this.getObjectValue("Text");
    }

    public String getTextWithoutTrailingNulls() {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getValueWithoutTrailingNull();
    }

    @Override
    public String getUserFriendlyValue() {
        return this.getTextWithoutTrailingNulls();
    }

    public String getValueAtIndex(int n2) {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getValueAtIndex(n2);
    }

    public List<String> getValues() {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getValues();
    }

    public void setText(String string2) {
        if (string2 != null) {
            this.setObjectValue("Text", string2);
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new TextEncodedStringSizeTerminated("Text", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        this.setTextEncoding(ID3TextEncodingConversion.getTextEncoding(this.getHeader(), this.getTextEncoding()));
        if (!((TextEncodedStringSizeTerminated)this.getObject("Text")).canBeEncoded()) {
            this.setTextEncoding(ID3TextEncodingConversion.getUnicodeTextEncoding(this.getHeader()));
        }
        super.write(byteArrayOutputStream);
    }
}

