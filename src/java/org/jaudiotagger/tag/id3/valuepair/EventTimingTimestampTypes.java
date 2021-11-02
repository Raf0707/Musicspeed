/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Map
 */
package org.jaudiotagger.tag.id3.valuepair;

import java.util.Map;
import org.jaudiotagger.tag.datatype.AbstractIntStringValuePair;
import org.jaudiotagger.tag.datatype.AbstractValuePair;

public class EventTimingTimestampTypes
extends AbstractIntStringValuePair {
    public static final int TIMESTAMP_KEY_FIELD_SIZE = 1;
    private static EventTimingTimestampTypes eventTimingTimestampTypes;

    private EventTimingTimestampTypes() {
        this.idToValue.put((Object)1, (Object)"Absolute time using MPEG [MPEG] frames as unit");
        this.idToValue.put((Object)2, (Object)"Absolute time using milliseconds as unit");
        this.createMaps();
    }

    public static EventTimingTimestampTypes getInstanceOf() {
        if (eventTimingTimestampTypes == null) {
            eventTimingTimestampTypes = new EventTimingTimestampTypes();
        }
        return eventTimingTimestampTypes;
    }
}

