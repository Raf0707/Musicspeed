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

public class ChannelTypes
extends AbstractIntStringValuePair {
    private static ChannelTypes channelTypes;

    private ChannelTypes() {
        this.idToValue.put((Object)0, (Object)"Other");
        this.idToValue.put((Object)1, (Object)"Master volume");
        this.idToValue.put((Object)2, (Object)"Front right");
        this.idToValue.put((Object)3, (Object)"Front left");
        this.idToValue.put((Object)4, (Object)"Back right");
        this.idToValue.put((Object)5, (Object)"Back left");
        this.idToValue.put((Object)6, (Object)"Front centre");
        this.idToValue.put((Object)7, (Object)"Back centre");
        this.idToValue.put((Object)8, (Object)"Subwoofer");
        this.createMaps();
    }

    public static ChannelTypes getInstanceOf() {
        if (channelTypes == null) {
            channelTypes = new ChannelTypes();
        }
        return channelTypes;
    }
}

