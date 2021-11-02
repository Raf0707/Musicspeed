/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;

public class FrameBodyTIME
extends AbstractFrameBodyTextInfo
implements ID3v23FrameBody {
    private boolean hoursOnly;

    public FrameBodyTIME() {
    }

    public FrameBodyTIME(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTIME(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTIME(FrameBodyTIME frameBodyTIME) {
        super(frameBodyTIME);
    }

    @Override
    public String getIdentifier() {
        return "TIME";
    }

    public boolean isHoursOnly() {
        return this.hoursOnly;
    }

    public void setHoursOnly(boolean bl) {
        this.hoursOnly = bl;
    }
}

