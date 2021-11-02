/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.audio.exceptions;

public class ReadOnlyFileException
extends Exception {
    public ReadOnlyFileException() {
    }

    public ReadOnlyFileException(String string2) {
        super(string2);
    }

    public ReadOnlyFileException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public ReadOnlyFileException(Throwable throwable) {
        super(throwable);
    }
}

