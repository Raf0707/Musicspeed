/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.tag;

import org.jaudiotagger.tag.TagException;

public class TagNotFoundException
extends TagException {
    public TagNotFoundException() {
    }

    public TagNotFoundException(String string2) {
        super(string2);
    }

    public TagNotFoundException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public TagNotFoundException(Throwable throwable) {
        super(throwable);
    }
}

