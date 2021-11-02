/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.util.Utils;

public class EncodingChunk
extends Chunk {
    private final List<String> strings = new ArrayList();

    public EncodingChunk(BigInteger bigInteger) {
        super(GUID.GUID_ENCODING, bigInteger);
    }

    public void addString(String string2) {
        this.strings.add((Object)string2);
    }

    public Collection<String> getStrings() {
        return new ArrayList(this.strings);
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        this.strings.iterator();
        for (String string3 : this.strings) {
            stringBuilder.append(string2);
            stringBuilder.append("  | : ");
            stringBuilder.append(string3);
            stringBuilder.append(Utils.LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}

