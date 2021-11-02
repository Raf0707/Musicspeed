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
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyTDEN
extends AbstractFrameBodyTextInfo
implements ID3v24FrameBody {
    public FrameBodyTDEN() {
    }

    public FrameBodyTDEN(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTDEN(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTDEN(FrameBodyTDEN frameBodyTDEN) {
        super(frameBodyTDEN);
    }

    @Override
    public String getIdentifier() {
        return "TDEN";
    }
}

