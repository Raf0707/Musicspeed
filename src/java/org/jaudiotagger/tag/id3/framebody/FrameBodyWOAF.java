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
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyUrlLink;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyWOAF
extends AbstractFrameBodyUrlLink
implements ID3v24FrameBody,
ID3v23FrameBody {
    public FrameBodyWOAF() {
    }

    public FrameBodyWOAF(String string2) {
        super(string2);
    }

    public FrameBodyWOAF(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        super(byteBuffer, n2);
    }

    public FrameBodyWOAF(FrameBodyWOAF frameBodyWOAF) {
        super(frameBodyWOAF);
    }

    @Override
    public String getIdentifier() {
        return "WOAF";
    }
}

