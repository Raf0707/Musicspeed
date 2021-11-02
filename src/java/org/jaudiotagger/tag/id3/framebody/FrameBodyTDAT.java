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

public class FrameBodyTDAT
extends AbstractFrameBodyTextInfo
implements ID3v23FrameBody {
    public static final int DATA_SIZE = 4;
    public static final int DAY_END = 2;
    public static final int DAY_START = 0;
    public static final int MONTH_END = 4;
    public static final int MONTH_START = 2;
    private boolean monthOnly;

    public FrameBodyTDAT() {
    }

    public FrameBodyTDAT(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTDAT(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTDAT(FrameBodyTDAT frameBodyTDAT) {
        super(frameBodyTDAT);
    }

    @Override
    public String getIdentifier() {
        return "TDAT";
    }

    public boolean isMonthOnly() {
        return this.monthOnly;
    }

    public void setMonthOnly(boolean bl) {
        this.monthOnly = bl;
    }
}

