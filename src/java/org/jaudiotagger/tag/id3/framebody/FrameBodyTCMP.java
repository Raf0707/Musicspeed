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
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyTCMP
extends AbstractFrameBodyTextInfo
implements ID3v24FrameBody,
ID3v23FrameBody {
    static String IS_COMPILATION = "1\u0000";

    public FrameBodyTCMP() {
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Text", IS_COMPILATION);
    }

    public FrameBodyTCMP(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTCMP(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTCMP(FrameBodyTCMP frameBodyTCMP) {
        super(frameBodyTCMP);
    }

    @Override
    public String getIdentifier() {
        return "TCMP";
    }

    public boolean isCompilation() {
        return this.getText().equals((Object)IS_COMPILATION);
    }
}

