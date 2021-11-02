/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.util.Utils;

public class Chunk {
    protected final BigInteger chunkLength;
    protected final GUID guid;
    protected long position;

    public Chunk(GUID gUID, long l2, BigInteger bigInteger) {
        if (gUID != null) {
            if (l2 >= 0L) {
                if (bigInteger != null && bigInteger.compareTo(BigInteger.ZERO) >= 0) {
                    this.guid = gUID;
                    this.position = l2;
                    this.chunkLength = bigInteger;
                    return;
                }
                throw new IllegalArgumentException("chunkLen must not be null nor negative.");
            }
            throw new IllegalArgumentException("Position of header can't be negative.");
        }
        throw new IllegalArgumentException("GUID must not be null");
    }

    public Chunk(GUID gUID, BigInteger bigInteger) {
        if (gUID != null) {
            if (bigInteger != null && bigInteger.compareTo(BigInteger.ZERO) >= 0) {
                this.guid = gUID;
                this.chunkLength = bigInteger;
                return;
            }
            throw new IllegalArgumentException("chunkLen must not be null nor negative.");
        }
        throw new IllegalArgumentException("GUID must not be null.");
    }

    @Deprecated
    public long getChunckEnd() {
        return this.position + this.chunkLength.longValue();
    }

    public long getChunkEnd() {
        return this.position + this.chunkLength.longValue();
    }

    public BigInteger getChunkLength() {
        return this.chunkLength;
    }

    public GUID getGuid() {
        return this.guid;
    }

    public long getPosition() {
        return this.position;
    }

    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("-> GUID: ");
        stringBuilder.append(GUID.getGuidDescription(this.guid));
        String string3 = Utils.LINE_SEPARATOR;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  | : Starts at position: ");
        stringBuilder.append(this.getPosition());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  | : Last byte at: ");
        stringBuilder.append(this.getChunkEnd() - 1L);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void setPosition(long l2) {
        this.position = l2;
    }

    public String toString() {
        return this.prettyPrint("");
    }
}

