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
import org.jaudiotagger.tag.id3.framebody.FrameBodyTXXX;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyTMOO
extends AbstractFrameBodyTextInfo
implements ID3v24FrameBody {
    public FrameBodyTMOO() {
    }

    public FrameBodyTMOO(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTMOO(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTMOO(FrameBodyTMOO frameBodyTMOO) {
        super(frameBodyTMOO);
    }

    public FrameBodyTMOO(FrameBodyTXXX frameBodyTXXX) {
        this.setObjectValue("TextEncoding", frameBodyTXXX.getTextEncoding());
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Text", frameBodyTXXX.getText());
    }

    @Override
    public String getIdentifier() {
        return "TMOO";
    }
}

