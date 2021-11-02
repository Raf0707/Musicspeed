/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.paperdb;

public class PaperDbException
extends RuntimeException {
    public PaperDbException(String string2) {
        super(string2);
    }

    public PaperDbException(String string2, Throwable throwable) {
        super(string2, throwable);
    }
}

