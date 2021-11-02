/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.tag;

import org.jaudiotagger.tag.InvalidFrameIdentifierException;

public class PaddingException
extends InvalidFrameIdentifierException {
    public PaddingException() {
    }

    public PaddingException(String string2) {
        super(string2);
    }

    public PaddingException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public PaddingException(Throwable throwable) {
        super(throwable);
    }
}

