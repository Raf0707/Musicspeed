/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package org.jaudiotagger;

import java.nio.charset.Charset;

public final class StandardCharsets {
    public static final Charset ISO_8859_1;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;

    static {
        US_ASCII = Charset.forName((String)"US-ASCII");
        ISO_8859_1 = Charset.forName((String)"ISO-8859-1");
        UTF_8 = Charset.forName((String)"UTF-8");
        UTF_16BE = Charset.forName((String)"UTF-16BE");
        UTF_16LE = Charset.forName((String)"UTF-16LE");
        UTF_16 = Charset.forName((String)"UTF-16");
    }

    private StandardCharsets() {
        throw new AssertionError((Object)"No org.jaudiotagger.StandardCharsets instances for you!");
    }
}

