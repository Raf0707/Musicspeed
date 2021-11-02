/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.id3;

import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AbstractTagItem;
import org.jaudiotagger.tag.id3.ID3Tags;
import org.jaudiotagger.utils.EqualsUtil;

public abstract class AbstractTagFrame
extends AbstractTagItem {
    protected AbstractTagFrameBody frameBody;

    public AbstractTagFrame() {
    }

    public AbstractTagFrame(AbstractTagFrame abstractTagFrame) {
        AbstractTagFrameBody abstractTagFrameBody;
        this.frameBody = abstractTagFrameBody = (AbstractTagFrameBody)ID3Tags.copyObject(abstractTagFrame.frameBody);
        abstractTagFrameBody.setHeader(this);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AbstractTagFrame)) {
            return false;
        }
        AbstractTagFrame abstractTagFrame = (AbstractTagFrame)object;
        return EqualsUtil.areEqual(this.getIdentifier(), abstractTagFrame.getIdentifier()) && EqualsUtil.areEqual(this.frameBody, abstractTagFrame.frameBody) && super.equals(abstractTagFrame);
    }

    public AbstractTagFrameBody getBody() {
        return this.frameBody;
    }

    @Override
    public boolean isSubsetOf(Object object) {
        if (!(object instanceof AbstractTagFrame)) {
            return false;
        }
        AbstractTagFrameBody abstractTagFrameBody = this.frameBody;
        if (abstractTagFrameBody == null && ((AbstractTagFrame)object).frameBody == null) {
            return true;
        }
        boolean bl = false;
        if (abstractTagFrameBody != null) {
            AbstractTagFrameBody abstractTagFrameBody2 = ((AbstractTagFrame)object).frameBody;
            if (abstractTagFrameBody2 == null) {
                return false;
            }
            boolean bl2 = abstractTagFrameBody.isSubsetOf(abstractTagFrameBody2);
            bl = false;
            if (bl2) {
                boolean bl3 = super.isSubsetOf(object);
                bl = false;
                if (bl3) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    public void setBody(AbstractTagFrameBody abstractTagFrameBody) {
        this.frameBody = abstractTagFrameBody;
        abstractTagFrameBody.setHeader(this);
    }

    public String toString() {
        return this.getBody().toString();
    }
}

