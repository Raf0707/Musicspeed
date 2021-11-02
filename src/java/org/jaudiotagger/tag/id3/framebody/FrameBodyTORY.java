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
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDOR;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;

public class FrameBodyTORY
extends AbstractFrameBodyTextInfo
implements ID3v23FrameBody {
    private static final int NUMBER_OF_DIGITS_IN_YEAR = 4;

    public FrameBodyTORY() {
    }

    public FrameBodyTORY(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTORY(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTORY(FrameBodyTDOR frameBodyTDOR) {
        this.setObjectValue("TextEncoding", (byte)0);
        String string2 = frameBodyTDOR.getText();
        if (frameBodyTDOR.getText().length() > 4) {
            string2 = frameBodyTDOR.getText().substring(0, 4);
        }
        this.setObjectValue("Text", string2);
    }

    public FrameBodyTORY(FrameBodyTORY frameBodyTORY) {
        super(frameBodyTORY);
    }

    @Override
    public String getIdentifier() {
        return "TORY";
    }
}

