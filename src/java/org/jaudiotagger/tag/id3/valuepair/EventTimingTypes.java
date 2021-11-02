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

public class EventTimingTypes
extends AbstractIntStringValuePair {
    private static EventTimingTypes eventTimingTypes;

    private EventTimingTypes() {
        this.idToValue.put((Object)0, (Object)"Padding (has no meaning)");
        this.idToValue.put((Object)1, (Object)"End of initial silence");
        this.idToValue.put((Object)2, (Object)"Intro start");
        this.idToValue.put((Object)3, (Object)"Main part start");
        this.idToValue.put((Object)4, (Object)"Outro start");
        this.idToValue.put((Object)5, (Object)"Outro end");
        this.idToValue.put((Object)6, (Object)"Verse start");
        this.idToValue.put((Object)7, (Object)"Refrain start");
        this.idToValue.put((Object)8, (Object)"Interlude start");
        this.idToValue.put((Object)9, (Object)"Theme start");
        this.idToValue.put((Object)10, (Object)"Variation start");
        this.idToValue.put((Object)11, (Object)"Key change");
        this.idToValue.put((Object)12, (Object)"Time change");
        this.idToValue.put((Object)13, (Object)"Momentary unwanted noise (Snap, Crackle & Pop)");
        this.idToValue.put((Object)14, (Object)"Sustained noise");
        this.idToValue.put((Object)15, (Object)"Sustained noise end");
        this.idToValue.put((Object)16, (Object)"Intro end");
        this.idToValue.put((Object)17, (Object)"Main part end");
        this.idToValue.put((Object)18, (Object)"Verse end");
        this.idToValue.put((Object)19, (Object)"Refrain end");
        this.idToValue.put((Object)20, (Object)"Theme end");
        this.idToValue.put((Object)21, (Object)"Profanity");
        this.idToValue.put((Object)22, (Object)"Profanity end");
        this.idToValue.put((Object)224, (Object)"Not predefined synch 0");
        this.idToValue.put((Object)225, (Object)"Not predefined synch 1");
        this.idToValue.put((Object)226, (Object)"Not predefined synch 2");
        this.idToValue.put((Object)227, (Object)"Not predefined synch 3");
        this.idToValue.put((Object)228, (Object)"Not predefined synch 4");
        this.idToValue.put((Object)229, (Object)"Not predefined synch 5");
        this.idToValue.put((Object)230, (Object)"Not predefined synch 6");
        this.idToValue.put((Object)231, (Object)"Not predefined synch 7");
        this.idToValue.put((Object)232, (Object)"Not predefined synch 8");
        this.idToValue.put((Object)233, (Object)"Not predefined synch 9");
        this.idToValue.put((Object)234, (Object)"Not predefined synch A");
        this.idToValue.put((Object)235, (Object)"Not predefined synch B");
        this.idToValue.put((Object)236, (Object)"Not predefined synch C");
        this.idToValue.put((Object)237, (Object)"Not predefined synch D");
        this.idToValue.put((Object)238, (Object)"Not predefined synch E");
        this.idToValue.put((Object)239, (Object)"Not predefined synch F");
        this.idToValue.put((Object)253, (Object)"Audio end (start of silence)");
        this.idToValue.put((Object)254, (Object)"Audio file ends");
        this.createMaps();
    }

    public static EventTimingTypes getInstanceOf() {
        if (eventTimingTypes == null) {
            eventTimingTypes = new EventTimingTypes();
        }
        return eventTimingTypes;
    }
}

