/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.Iterator
 */
package org.jaudiotagger.tag.id3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.jaudiotagger.tag.id3.AbstractTagItem;

public abstract class AbstractTag
extends AbstractTagItem {
    protected static final String TYPE_TAG = "tag";

    public AbstractTag() {
    }

    public AbstractTag(AbstractTag abstractTag) {
        super(abstractTag);
    }

    public abstract void delete(RandomAccessFile var1) throws IOException;

    @Override
    public boolean equals(Object object) {
        return object instanceof AbstractTag && super.equals(object);
    }

    public abstract Iterator iterator();

    public abstract boolean seek(ByteBuffer var1);

    public abstract void write(RandomAccessFile var1) throws IOException;
}

