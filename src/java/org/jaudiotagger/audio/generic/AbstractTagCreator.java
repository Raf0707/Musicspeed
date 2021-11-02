/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.generic;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.jaudiotagger.tag.Tag;

public abstract class AbstractTagCreator {
    public ByteBuffer convert(Tag tag) throws UnsupportedEncodingException {
        return this.convert(tag, 0);
    }

    public abstract ByteBuffer convert(Tag var1, int var2) throws UnsupportedEncodingException;
}

