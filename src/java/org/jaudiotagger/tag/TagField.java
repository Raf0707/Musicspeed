/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag;

import java.io.UnsupportedEncodingException;

public interface TagField {
    public void copyContent(TagField var1);

    public String getId();

    public byte[] getRawContent() throws UnsupportedEncodingException;

    public void isBinary(boolean var1);

    public boolean isBinary();

    public boolean isCommon();

    public boolean isEmpty();

    public String toString();
}

