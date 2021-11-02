/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.audio.iff;

import org.jaudiotagger.logging.Hex;

public class ChunkSummary {
    private String chunkId;
    private long chunkSize;
    private long fileStartLocation;

    public ChunkSummary(String string2, long l2, long l3) {
        this.chunkId = string2;
        this.fileStartLocation = l2;
        this.chunkSize = l3;
    }

    public String getChunkId() {
        return this.chunkId;
    }

    public long getChunkSize() {
        return this.chunkSize;
    }

    public long getEndLocation() {
        return 8L + (this.fileStartLocation + this.chunkSize);
    }

    public long getFileStartLocation() {
        return this.fileStartLocation;
    }

    public void setChunkId(String string2) {
        this.chunkId = string2;
    }

    public void setChunkSize(long l2) {
        this.chunkSize = l2;
    }

    public void setFileStartLocation(long l2) {
        this.fileStartLocation = l2;
    }

    public String toString() {
        long l2 = 8L + (this.fileStartLocation + this.chunkSize);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.chunkId);
        stringBuilder.append(":StartLocation:");
        stringBuilder.append(Hex.asDecAndHex(this.fileStartLocation));
        stringBuilder.append(":SizeIncHeader:");
        stringBuilder.append(this.chunkSize);
        stringBuilder.append(8);
        stringBuilder.append(":EndLocation:");
        stringBuilder.append(Hex.asDecAndHex(l2));
        return stringBuilder.toString();
    }
}

