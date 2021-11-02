/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.tag;

import org.jaudiotagger.tag.InvalidFrameException;

public class EmptyFrameException
extends InvalidFrameException {
    public EmptyFrameException() {
    }

    public EmptyFrameException(String string2) {
        super(string2);
    }

    public EmptyFrameException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public EmptyFrameException(Throwable throwable) {
        super(throwable);
    }
}

