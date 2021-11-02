/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.tag;

import org.jaudiotagger.tag.TagException;

public class InvalidTagException
extends TagException {
    public InvalidTagException() {
    }

    public InvalidTagException(String string2) {
        super(string2);
    }

    public InvalidTagException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public InvalidTagException(Throwable throwable) {
        super(throwable);
    }
}

