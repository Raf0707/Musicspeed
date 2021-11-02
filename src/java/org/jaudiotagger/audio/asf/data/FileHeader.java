/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.Date
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import java.util.Date;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.util.Utils;

public class FileHeader
extends Chunk {
    private final BigInteger duration;
    private final Date fileCreationTime;
    private final BigInteger fileSize;
    private final long flags;
    private final long maxPackageSize;
    private final long minPackageSize;
    private final BigInteger packageCount;
    private final BigInteger timeEndPos;
    private final BigInteger timeStartPos;
    private final long uncompressedFrameSize;

    public FileHeader(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, long l2, long l3, long l4, long l5) {
        super(GUID.GUID_FILE, bigInteger);
        this.fileSize = bigInteger2;
        this.packageCount = bigInteger4;
        this.duration = bigInteger5;
        this.timeStartPos = bigInteger6;
        this.timeEndPos = bigInteger7;
        this.flags = l2;
        this.minPackageSize = l3;
        this.maxPackageSize = l4;
        this.uncompressedFrameSize = l5;
        this.fileCreationTime = Utils.getDateOf(bigInteger3).getTime();
    }

    public BigInteger getDuration() {
        return this.duration;
    }

    public int getDurationInSeconds() {
        return this.duration.divide(new BigInteger("10000000")).intValue();
    }

    public Date getFileCreationTime() {
        return new Date(this.fileCreationTime.getTime());
    }

    public BigInteger getFileSize() {
        return this.fileSize;
    }

    public long getFlags() {
        return this.flags;
    }

    public long getMaxPackageSize() {
        return this.maxPackageSize;
    }

    public long getMinPackageSize() {
        return this.minPackageSize;
    }

    public BigInteger getPackageCount() {
        return this.packageCount;
    }

    public float getPreciseDuration() {
        return (float)(this.getDuration().doubleValue() / 1.0E7);
    }

    public BigInteger getTimeEndPos() {
        return this.timeEndPos;
    }

    public BigInteger getTimeStartPos() {
        return this.timeStartPos;
    }

    public long getUncompressedFrameSize() {
        return this.uncompressedFrameSize;
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        stringBuilder.append(string2);
        stringBuilder.append("  |-> Filesize      = ");
        stringBuilder.append(this.getFileSize().toString());
        stringBuilder.append(" Bytes");
        String string3 = Utils.LINE_SEPARATOR;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |-> Media duration= ");
        stringBuilder.append(this.getDuration().divide(new BigInteger("10000")).toString());
        stringBuilder.append(" ms");
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |-> Created at    = ");
        stringBuilder.append((Object)this.getFileCreationTime());
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

