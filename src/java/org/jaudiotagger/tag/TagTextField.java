/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.tag;

import java.nio.charset.Charset;
import org.jaudiotagger.tag.TagField;

public interface TagTextField
extends TagField {
    public String getContent();

    public Charset getEncoding();

    public void setContent(String var1);

    public void setEncoding(Charset var1);
}

