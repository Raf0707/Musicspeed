/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.audio.exceptions;

import org.jaudiotagger.audio.exceptions.CannotWriteException;

public class NoWritePermissionsException
extends CannotWriteException {
    public NoWritePermissionsException() {
    }

    public NoWritePermissionsException(String string2) {
        super(string2);
    }

    public NoWritePermissionsException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public NoWritePermissionsException(Throwable throwable) {
        super(throwable);
    }
}

