/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.tag;

import org.jaudiotagger.tag.TagException;

public class FieldDataInvalidException
extends TagException {
    public FieldDataInvalidException() {
    }

    public FieldDataInvalidException(String string2) {
        super(string2);
    }

    public FieldDataInvalidException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public FieldDataInvalidException(Throwable throwable) {
        super(throwable);
    }
}

