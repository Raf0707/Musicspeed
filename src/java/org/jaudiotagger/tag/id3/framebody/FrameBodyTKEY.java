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
import org.jaudiotagger.tag.reference.MusicalKey;

public class FrameBodyTKEY
extends AbstractFrameBodyTextInfo
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyTKEY() {
    }

    public FrameBodyTKEY(byte by, String string2) {
        super(by, string2);
    }

    public FrameBodyTKEY(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyTKEY(FrameBodyTKEY frameBodyTKEY) {
        super(frameBodyTKEY);
    }

    @Override
    public String getIdentifier() {
        return "TKEY";
    }

    public boolean isValid() {
        return MusicalKey.isValid(this.getFirstTextValue());
    }
}

