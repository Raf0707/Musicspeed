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

public class FrameBodyTRDA
extends AbstractFrameBodyTextInfo
implements ID3v23FrameBody {
    public FrameBodyTRDA() {
    }

    public FrameBodyTRDA(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTRDA(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTRDA(FrameBodyTRDA frameBodyTRDA) {
        super(frameBodyTRDA);
    }

    @Override
    public String getIdentifier() {
        return "TRDA";
    }
}

