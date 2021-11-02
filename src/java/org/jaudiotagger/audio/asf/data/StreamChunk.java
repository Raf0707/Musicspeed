/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.util.Utils;

public abstract class StreamChunk
extends Chunk {
    static final /* synthetic */ boolean $assertionsDisabled;
    private boolean contentEncrypted;
    private int streamNumber;
    private long streamSpecificDataSize;
    private long timeOffset;
    private final GUID type;
    private long typeSpecificDataSize;

    public StreamChunk(GUID gUID, BigInteger bigInteger) {
        super(GUID.GUID_STREAM, bigInteger);
        this.type = gUID;
    }

    public int getStreamNumber() {
        return this.streamNumber;
    }

    public long getStreamSpecificDataSize() {
        return this.streamSpecificDataSize;
    }

    public GUID getStreamType() {
        return this.type;
    }

    public long getTimeOffset() {
        return this.timeOffset;
    }

    public long getTypeSpecificDataSize() {
        return this.typeSpecificDataSize;
    }

    public boolean isContentEncrypted() {
        return this.contentEncrypted;
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        stringBuilder.append(string2);
        stringBuilder.append("  |-> Stream number: ");
        stringBuilder.append(this.getStreamNumber());
        String string3 = Utils.LINE_SEPARATOR;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |-> Type specific data size  : ");
        stringBuilder.append(this.getTypeSpecificDataSize());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |-> Stream specific data size: ");
        stringBuilder.append(this.getStreamSpecificDataSize());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |-> Time Offset              : ");
        stringBuilder.append(this.getTimeOffset());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |-> Content Encryption       : ");
        stringBuilder.append(this.isContentEncrypted());
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void setContentEncrypted(boolean bl) {
        this.contentEncrypted = bl;
    }

    public void setStreamNumber(int n2) {
        this.streamNumber = n2;
    }

    public void setStreamSpecificDataSize(long l2) {
        this.streamSpecificDataSize = l2;
    }

    public void setTimeOffset(long l2) {
        this.timeOffset = l2;
    }

    public void setTypeSpecificDataSize(long l2) {
        this.typeSpecificDataSize = l2;
    }
}

