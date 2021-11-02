/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.audio.exceptions;

import org.jaudiotagger.audio.exceptions.CannotReadException;

public class CannotReadVideoException
extends CannotReadException {
    public CannotReadVideoException() {
    }

    public CannotReadVideoException(String string2) {
        super(string2);
    }

    public CannotReadVideoException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public CannotReadVideoException(Throwable throwable) {
        super(throwable);
    }
}

