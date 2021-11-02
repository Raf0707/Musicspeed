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
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDRC;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;

public class FrameBodyTYER
extends AbstractFrameBodyTextInfo
implements ID3v23FrameBody {
    public FrameBodyTYER() {
    }

    public FrameBodyTYER(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTYER(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTYER(FrameBodyTDRC frameBodyTDRC) {
        this.setObjectValue("TextEncoding", (byte)0);
        this.setObjectValue("Text", frameBodyTDRC.getText());
    }

    public FrameBodyTYER(FrameBodyTYER frameBodyTYER) {
        super(frameBodyTYER);
    }

    @Override
    public String getIdentifier() {
        return "TYER";
    }
}

