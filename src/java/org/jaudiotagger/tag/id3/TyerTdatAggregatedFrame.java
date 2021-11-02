/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.Set
 */
package org.jaudiotagger.tag.id3;

import java.util.Iterator;
import java.util.Set;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AggregatedFrame;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDAT;

public class TyerTdatAggregatedFrame
extends AggregatedFrame {
    public static final String ID_TYER_TDAT = "TYERTDAT";

    @Override
    public String getContent() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.frames.iterator();
        stringBuilder.append(((AbstractID3v2Frame)iterator.next()).getContent());
        AbstractID3v2Frame abstractID3v2Frame = (AbstractID3v2Frame)iterator.next();
        if (abstractID3v2Frame.getContent().length() == 4) {
            stringBuilder.append("-");
            stringBuilder.append(abstractID3v2Frame.getContent().substring(2, 4));
            if (!((FrameBodyTDAT)abstractID3v2Frame.getBody()).isMonthOnly()) {
                stringBuilder.append("-");
                stringBuilder.append(abstractID3v2Frame.getContent().substring(0, 2));
            }
        }
        return stringBuilder.toString();
    }
}

