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

public class FrameBodyXSOA
extends AbstractFrameBodyTextInfo
implements ID3v23FrameBody {
    public FrameBodyXSOA() {
    }

    public FrameBodyXSOA(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyXSOA(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyXSOA(FrameBodyXSOA frameBodyXSOA) {
        super(frameBodyXSOA);
    }

    @Override
    public String getIdentifier() {
        return "XSOA";
    }
}

