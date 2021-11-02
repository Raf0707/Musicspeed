/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package org.jaudiotagger.tag.id3.valuepair;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.datatype.AbstractIntStringValuePair;
import org.jaudiotagger.tag.datatype.AbstractValuePair;

public class TextEncoding
extends AbstractIntStringValuePair {
    public static final byte ISO_8859_1 = 0;
    public static final int TEXT_ENCODING_FIELD_SIZE = 1;
    public static final byte UTF_16 = 1;
    public static final byte UTF_16BE = 2;
    public static final byte UTF_8 = 3;
    private static TextEncoding textEncodings;
    private final Map<Integer, Charset> idToCharset;

    private TextEncoding() {
        HashMap hashMap;
        this.idToCharset = hashMap = new HashMap();
        hashMap.put((Object)0, (Object)StandardCharsets.ISO_8859_1);
        hashMap.put((Object)1, (Object)StandardCharsets.UTF_16);
        hashMap.put((Object)2, (Object)StandardCharsets.UTF_16BE);
        hashMap.put((Object)3, (Object)StandardCharsets.UTF_8);
        for (Map.Entry entry : hashMap.entrySet()) {
            this.idToValue.put((Object)((Integer)entry.getKey()), (Object)((Charset)entry.getValue()).name());
        }
        this.createMaps();
    }

    public static TextEncoding getInstanceOf() {
        Class<TextEncoding> class_ = TextEncoding.class;
        synchronized (TextEncoding.class) {
            if (textEncodings == null) {
                textEncodings = new TextEncoding();
            }
            TextEncoding textEncoding = textEncodings;
            // ** MonitorExit[var2] (shouldn't be in output)
            return textEncoding;
        }
    }

    public Charset getCharsetForId(int n2) {
        return (Charset)this.idToCharset.get((Object)n2);
    }

    public Integer getIdForCharset(Charset charset) {
        return (Integer)this.valueToId.get((Object)charset.name());
    }
}

