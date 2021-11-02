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

public class FrameBodyMVIN
extends AbstractFrameBodyNumberTotal
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyMVIN() {
    }

    public FrameBodyMVIN(byte by, Integer n2, Integer n3) {
        super(by, n2, n3);
    }

    public FrameBodyMVIN(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyMVIN(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyMVIN(FrameBodyMVIN frameBodyMVIN) {
        super(frameBodyMVIN);
    }

    @Override
    public String getIdentifier() {
        return "MVIN";
    }
}

