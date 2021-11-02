/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  org.jaudiotagger.tag.id3.framebody.FrameBodySYTC
 */
package org.jaudiotagger.tag.datatype;

import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractDataTypeList;
import org.jaudiotagger.tag.datatype.SynchronisedTempoCode;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodySYTC;

public class SynchronisedTempoCodeList
extends AbstractDataTypeList<SynchronisedTempoCode> {
    public SynchronisedTempoCodeList(SynchronisedTempoCodeList synchronisedTempoCodeList) {
        super(synchronisedTempoCodeList);
    }

    public SynchronisedTempoCodeList(FrameBodySYTC frameBodySYTC) {
        super("SynchronisedTempoList", (AbstractTagFrameBody)frameBodySYTC);
    }

    @Override
    protected SynchronisedTempoCode createListElement() {
        return new SynchronisedTempoCode("SynchronisedTempo", this.frameBody);
    }
}

