/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.tag.datatype;

import java.nio.charset.Charset;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.datatype.TextEncodedStringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public class StringNullTerminated
extends TextEncodedStringNullTerminated {
    public StringNullTerminated(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public StringNullTerminated(StringNullTerminated stringNullTerminated) {
        super(stringNullTerminated);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof StringNullTerminated && super.equals(object);
    }

    @Override
    protected Charset getTextEncodingCharSet() {
        return StandardCharsets.ISO_8859_1;
    }
}

