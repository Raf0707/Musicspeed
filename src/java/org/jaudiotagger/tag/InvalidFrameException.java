/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.tag;

import org.jaudiotagger.tag.InvalidTagException;

public class InvalidFrameException
extends InvalidTagException {
    public InvalidFrameException() {
    }

    public InvalidFrameException(String string2) {
        super(string2);
    }

    public InvalidFrameException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public InvalidFrameException(Throwable throwable) {
        super(throwable);
    }
}

