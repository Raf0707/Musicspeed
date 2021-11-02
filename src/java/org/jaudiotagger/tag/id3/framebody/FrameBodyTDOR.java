/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.tag.id3.framebody;

import java.nio.ByteBuffer;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTORY;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyTDOR
extends AbstractFrameBodyTextInfo
implements ID3v24FrameBody {
    public FrameBodyTDOR() {
    }

    public FrameBodyTDOR(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTDOR(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTDOR(FrameBodyTDOR frameBodyTDOR) {
        super(frameBodyTDOR);
    }

    public FrameBodyTDOR(FrameBodyTORY frameBodyTORY) {
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Text", frameBodyTORY.getText());
    }

    @Override
    public String getIdentifier() {
        return "TDOR";
    }
}

