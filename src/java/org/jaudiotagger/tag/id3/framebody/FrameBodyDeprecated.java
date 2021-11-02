/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.id3.framebody;

import org.jaudiotagger.tag.id3.framebody.AbstractID3v2FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v23FrameBody;
import org.jaudiotagger.tag.id3.framebody.ID3v24FrameBody;

public class FrameBodyDeprecated
extends AbstractID3v2FrameBody
implements ID3v24FrameBody,
ID3v23FrameBody {
    private AbstractID3v2FrameBody originalFrameBody;

    public FrameBodyDeprecated(AbstractID3v2FrameBody abstractID3v2FrameBody) {
        this.originalFrameBody = abstractID3v2FrameBody;
    }

    public FrameBodyDeprecated(FrameBodyDeprecated frameBodyDeprecated) {
        super(frameBodyDeprecated);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FrameBodyDeprecated)) {
            return false;
        }
        FrameBodyDeprecated frameBodyDeprecated = (FrameBodyDeprecated)object;
        boolean bl = this.getIdentifier().equals((Object)frameBodyDeprecated.getIdentifier());
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = super.equals(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public String getBriefDescription() {
        AbstractID3v2FrameBody abstractID3v2FrameBody = this.originalFrameBody;
        if (abstractID3v2FrameBody != null) {
            return abstractID3v2FrameBody.getBriefDescription();
        }
        return "";
    }

    @Override
    public String getIdentifier() {
        return this.originalFrameBody.getIdentifier();
    }

    public AbstractID3v2FrameBody getOriginalFrameBody() {
        return this.originalFrameBody;
    }

    @Override
    public int getSize() {
        return this.originalFrameBody.getSize();
    }

    @Override
    protected void setupObjectList() {
    }

    @Override
    public String toString() {
        return this.getIdentifier();
    }
}

