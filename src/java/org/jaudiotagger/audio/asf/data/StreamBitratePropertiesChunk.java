/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.List
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.util.Utils;

public class StreamBitratePropertiesChunk
extends Chunk {
    private final List<Long> bitRates = new ArrayList();
    private final List<Integer> streamNumbers = new ArrayList();

    public StreamBitratePropertiesChunk(BigInteger bigInteger) {
        super(GUID.GUID_STREAM_BITRATE_PROPERTIES, bigInteger);
    }

    public void addBitrateRecord(int n2, long l2) {
        this.streamNumbers.add((Object)n2);
        this.bitRates.add((Object)l2);
    }

    public long getAvgBitrate(int n2) {
        Integer n3 = n2;
        int n4 = this.streamNumbers.indexOf((Object)n3);
        if (n4 == -1) {
            return -1L;
        }
        return (Long)this.bitRates.get(n4);
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        for (int i2 = 0; i2 < this.bitRates.size(); ++i2) {
            stringBuilder.append(string2);
            stringBuilder.append("  |-> Stream no. \"");
            stringBuilder.append(this.streamNumbers.get(i2));
            stringBuilder.append("\" has an average bitrate of \"");
            stringBuilder.append(this.bitRates.get(i2));
            stringBuilder.append('\"');
            stringBuilder.append(Utils.LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}

