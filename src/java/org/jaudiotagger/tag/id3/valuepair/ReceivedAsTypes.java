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

public class ReceivedAsTypes
extends AbstractIntStringValuePair {
    public static final int RECEIVED_AS_FIELD_SIZE = 1;
    private static ReceivedAsTypes receivedAsTypes;

    private ReceivedAsTypes() {
        this.idToValue.put((Object)0, (Object)"Other");
        this.idToValue.put((Object)1, (Object)"Standard CD album with other songs");
        this.idToValue.put((Object)2, (Object)"Compressed audio on CD");
        this.idToValue.put((Object)3, (Object)"File over the Internet");
        this.idToValue.put((Object)4, (Object)"Stream over the Internet");
        this.idToValue.put((Object)5, (Object)"As note sheets");
        this.idToValue.put((Object)6, (Object)"As note sheets in a book with other sheets");
        this.idToValue.put((Object)7, (Object)"Music on other media");
        this.idToValue.put((Object)8, (Object)"Non-musical merchandise");
        this.createMaps();
    }

    public static ReceivedAsTypes getInstanceOf() {
        if (receivedAsTypes == null) {
            receivedAsTypes = new ReceivedAsTypes();
        }
        return receivedAsTypes;
    }
}

