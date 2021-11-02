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
import org.jaudiotagger.tag.datatype.AbstractString;
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

public class FrameBodyCOMM
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    public static final String DEFAULT = "";
    public static final String ITUNES_NORMALIZATION = "iTunNORM";
    public static final String MM_CUSTOM1 = "Songs-DB_Custom1";
    public static final String MM_CUSTOM2 = "Songs-DB_Custom2";
    public static final String MM_CUSTOM3 = "Songs-DB_Custom3";
    public static final String MM_CUSTOM4 = "Songs-DB_Custom4";
    public static final String MM_CUSTOM5 = "Songs-DB_Custom5";
    public static final String MM_OCCASION = "Songs-DB_Occasion";
    private static final String MM_PREFIX = "Songs-DB";
    public static final String MM_QUALITY = "Songs-DB_Preference";
    public static final String MM_TEMPO = "Songs-DB_Tempo";

    public FrameBodyCOMM() {
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Language", "eng");
        this.setObjectValue("Description", DEFAULT);
        this.setObjectValue("Text", DEFAULT);
    }

    public FrameBodyCOMM(byte by, String string2, String string3, String string4) {
        this.setObjectValue("TextEncoding", by);
        this.setObjectValue("Language", string2);
        this.setObjectValue("Description", string3);
        this.setObjectValue("Text", string4);
    }

    public FrameBodyCOMM(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyCOMM(FrameBodyCOMM frameBodyCOMM) {
        super(frameBodyCOMM);
    }

    public void addTextValue(String string2) {
        ((TextEncodedStringSizeTerminated)this.getObject("Text")).addValue(string2);
    }

    public String getDescription() {
        return (String)this.getObjectValue("Description");
    }

    public String getFirstTextValue() {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getValueAtIndex(0);
    }

    @Override
    public String getIdentifier() {
        return "COMM";
    }

    public String getLanguage() {
        return (String)this.getObjectValue("Language");
    }

    public int getNumberOfValues() {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getNumberOfValues();
    }

    public String getText() {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getValueAtIndex(0);
    }

    public String getTextWithoutTrailingNulls() {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getValueWithoutTrailingNull();
    }

    @Override
    public String getUserFriendlyValue() {
        return this.getText();
    }

    public String getValueAtIndex(int n2) {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getValueAtIndex(n2);
    }

    public List<String> getValues() {
        return ((TextEncodedStringSizeTerminated)this.getObject("Text")).getValues();
    }

    public boolean isItunesFrame() {
        String string2 = this.getDescription();
        return string2 != null && string2.length() != 0 && string2.equals((Object)ITUNES_NORMALIZATION);
    }

    public boolean isMediaMonkeyFrame() {
        String string2 = this.getDescription();
        return string2 != null && string2.length() != 0 && string2.startsWith(MM_PREFIX);
    }

    public void setDescription(String string2) {
        if (string2 != null) {
            this.setObjectValue("Description", string2);
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    public void setLanguage(String string2) {
        this.setObjectValue("Language", string2);
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
        this.objectList.add((Object)new StringHashMap("Language", this, 3));
        this.objectList.add((Object)new TextEncodedStringNullTerminated("Description", this));
        this.objectList.add((Object)new TextEncodedStringSizeTerminated("Text", this));
    }

    @Override
    public void write(ByteArrayOutputStream byteArrayOutputStream) {
        this.setTextEncoding(ID3TextEncodingConversion.getTextEncoding(this.getHeader(), this.getTextEncoding()));
        if (!((AbstractString)this.getObject("Text")).canBeEncoded()) {
            this.setTextEncoding(ID3TextEncodingConversion.getUnicodeTextEncoding(this.getHeader()));
        }
        if (!((AbstractString)this.getObject("Description")).canBeEncoded()) {
            this.setTextEncoding(ID3TextEncodingConversion.getUnicodeTextEncoding(this.getHeader()));
        }
        super.write(byteArrayOutputStream);
    }
}

