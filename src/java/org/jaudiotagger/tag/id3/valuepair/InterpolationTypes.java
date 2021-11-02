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

public class InterpolationTypes
extends AbstractIntStringValuePair {
    private static InterpolationTypes interpolationTypes;

    private InterpolationTypes() {
        this.idToValue.put((Object)0, (Object)"Band");
        this.idToValue.put((Object)1, (Object)"Linear");
        this.createMaps();
    }

    public static InterpolationTypes getInstanceOf() {
        if (interpolationTypes == null) {
            interpolationTypes = new InterpolationTypes();
        }
        return interpolationTypes;
    }
}

