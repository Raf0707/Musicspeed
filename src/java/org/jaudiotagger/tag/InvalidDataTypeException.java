/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.jaudiotagger.tag;

import org.jaudiotagger.tag.InvalidTagException;

public class InvalidDataTypeException
extends InvalidTagException {
    public InvalidDataTypeException() {
    }

    public InvalidDataTypeException(String string2) {
        super(string2);
    }

    public InvalidDataTypeException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public InvalidDataTypeException(Throwable throwable) {
        super(throwable);
    }
}

