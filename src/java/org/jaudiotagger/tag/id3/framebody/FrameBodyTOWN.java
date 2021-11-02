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
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyTOWN
extends AbstractFrameBodyTextInfo
implements ID3v23FrameBody,
ID3v24FrameBody {
    public FrameBodyTOWN() {
    }

    public FrameBodyTOWN(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTOWN(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTOWN(FrameBodyTOWN frameBodyTOWN) {
        super(frameBodyTOWN);
    }

    @Override
    public String getIdentifier() {
        return "TOWN";
    }
}

