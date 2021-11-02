/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.StreamChunk;
import org.jaudiotagger.audio.asf.util.Utils;

public class VideoStreamChunk
extends StreamChunk {
    private byte[] codecId = new byte[0];
    private long pictureHeight;
    private long pictureWidth;

    public VideoStreamChunk(BigInteger bigInteger) {
        super(GUID.GUID_VIDEOSTREAM, bigInteger);
    }

    public byte[] getCodecId() {
        return (byte[])this.codecId.clone();
    }

    public String getCodecIdAsString() {
        if (this.codecId == null) {
            return "Unknown";
        }
        return new String(this.getCodecId());
    }

    public long getPictureHeight() {
        return this.pictureHeight;
    }

    public long getPictureWidth() {
        return this.pictureWidth;
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        StringBuilder stringBuilder2 = new StringBuilder();
        String string3 = Utils.LINE_SEPARATOR;
        stringBuilder2.append(string3);
        stringBuilder2.append(string2);
        stringBuilder2.append("|->VideoStream");
        stringBuilder.insert(0, stringBuilder2.toString());
        stringBuilder.append(string2);
        stringBuilder.append("Video info:");
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("      |->Width  : ");
        stringBuilder.append(this.getPictureWidth());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("      |->Heigth : ");
        stringBuilder.append(this.getPictureHeight());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("      |->Codec  : ");
        stringBuilder.append(this.getCodecIdAsString());
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void setCodecId(byte[] arrby) {
        this.codecId = (byte[])arrby.clone();
    }

    public void setPictureHeight(long l2) {
        this.pictureHeight = l2;
    }

    public void setPictureWidth(long l2) {
        this.pictureWidth = l2;
    }
}

