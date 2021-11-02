/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
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
import org.jaudiotagger.tag.datatype.NumberHashMap;
import org.jaudiotagger.tag.datatype.PartOfSet;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;

public abstract class AbstractFrameBodyNumberTotal
extends AbstractID3v2FrameBody {
    public AbstractFrameBodyNumberTotal() {
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Text", new PartOfSet.PartOfSetValue());
    }

    public AbstractFrameBodyNumberTotal(byte by, Integer n2, Integer n3) {
        this.setObjectValue("TextEncoding", by);
        this.setObjectValue("Text", new PartOfSet.PartOfSetValue(n2, n3));
    }

    public AbstractFrameBodyNumberTotal(byte by, String string2) {
        this.setObjectValue("TextEncoding", by);
        this.setObjectValue("Text", new PartOfSet.PartOfSetValue(string2));
    }

    public AbstractFrameBodyNumberTotal(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public AbstractFrameBodyNumberTotal(AbstractFrameBodyNumberTotal abstractFrameBodyNumberTotal) {
        super(abstractFrameBodyNumberTotal);
    }

    @Override
    public abstract String getIdentifier();

    public Integer getNumber() {
        return (this.getObjectValue("Text")).getCount();
    }

    public String getNumberAsText() {
        return (this.getObjectValue("Text")).getCountAsText();
    }

    public String getText() {
        return this.getObjectValue("Text").toString();
    }

    public Integer getTotal() {
        return (this.getObjectValue("Text")).getTotal();
    }

    public String getTotalAsText() {
        return (this.getObjectValue("Text")).getTotalAsText();
    }

    @Override
    public String getUserFriendlyValue() {
        return String.valueOf((Object)(this.getObjectValue("Text")).getCount());
    }

    public void setNumber(Integer n2) {
        (this.getObjectValue("Text")).setCount(n2);
    }

    public void setNumber(String string2) {
        (this.getObjectValue("Text")).setCount(string2);
    }

    public void setText(String string2) {
        this.setObjectValue("Text", new PartOfSet.PartOfSetValue(string2));
    }

    public void setTotal(Integer n2) {
        (this.getObjectValue("Text")).setTotal(n2);
    }

    public void setTotal(String string2) {
        (this.getObjectValue("Text")).setTotal(string2);
    }

    @Override
    protected void setupObjectList() {
        this.objectList.add((Object)new NumberHashMap("TextEncoding", this, 1));
        this.objectList.add((Object)new PartOfSet("Text", this));
    }
}

