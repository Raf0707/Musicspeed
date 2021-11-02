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

public class FrameBodyTSIZ
extends AbstractFrameBodyTextInfo
implements ID3v23FrameBody {
    public FrameBodyTSIZ() {
    }

    public FrameBodyTSIZ(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTSIZ(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTSIZ(FrameBodyTSIZ frameBodyTSIZ) {
        super(frameBodyTSIZ);
    }

    @Override
    public String getIdentifier() {
        return "TSIZ";
    }
}

