/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3;

import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.jaudiotagger.tag.TagException;

public abstract class AbstractTagItem {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.id3");

    public AbstractTagItem() {
    }

    public AbstractTagItem(AbstractTagItem abstractTagItem) {
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return object instanceof AbstractTagItem;
    }

    public abstract String getIdentifier();

    public abstract int getSize();

    public boolean isSubsetOf(Object object) {
        return object instanceof AbstractTagItem;
    }

    public abstract void read(ByteBuffer var1) throws TagException;
}

