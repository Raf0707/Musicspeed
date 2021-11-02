/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  org.jaudiotagger.tag.id3.framebody.FrameBodyETCO
 */
package org.jaudiotagger.tag.datatype;

import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.AbstractDataTypeList;
import org.jaudiotagger.tag.datatype.EventTimingCode;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodyETCO;

public class EventTimingCodeList
extends AbstractDataTypeList<EventTimingCode> {
    public EventTimingCodeList(EventTimingCodeList eventTimingCodeList) {
        super(eventTimingCodeList);
    }

    public EventTimingCodeList(FrameBodyETCO frameBodyETCO) {
        super("TimedEventList", (AbstractTagFrameBody)frameBodyETCO);
    }

    @Override
    protected EventTimingCode createListElement() {
        return new EventTimingCode("TimedEvent", this.frameBody);
    }
}

