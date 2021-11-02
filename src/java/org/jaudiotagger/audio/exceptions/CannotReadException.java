/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.audio.exceptions;

public class CannotReadException
extends Exception {
    public CannotReadException() {
    }

    public CannotReadException(String string2) {
        super(string2);
    }

    public CannotReadException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public CannotReadException(Throwable throwable) {
        super(throwable);
    }
}

