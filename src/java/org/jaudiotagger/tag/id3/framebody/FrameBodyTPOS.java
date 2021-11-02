/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyNumberTotal;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyTPOS
extends AbstractFrameBodyNumberTotal
implements ID3v23FrameBody,
ID3v24FrameBody {
    public FrameBodyTPOS() {
    }

    public FrameBodyTPOS(byte by, Integer n2, Integer n3) {
        super(by, n2, n3);
    }

    public FrameBodyTPOS(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTPOS(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTPOS(FrameBodyTPOS frameBodyTPOS) {
        super(frameBodyTPOS);
    }

    public Integer getDiscNo() {
        return this.getNumber();
    }

    public String getDiscNoAsText() {
        return this.getNumberAsText();
    }

    public Integer getDiscTotal() {
        return this.getTotal();
    }

    public String getDiscTotalAsText() {
        return this.getTotalAsText();
    }

    @Override
    public String getIdentifier() {
        return "TPOS";
    }

    public void setDiscNo(Integer n2) {
        this.setNumber(n2);
    }

    public void setDiscNo(String string2) {
        this.setNumber(string2);
    }

    public void setDiscTotal(Integer n2) {
        this.setTotal(n2);
    }

    public void setDiscTotal(String string2) {
        this.setTotal(string2);
    }
}

