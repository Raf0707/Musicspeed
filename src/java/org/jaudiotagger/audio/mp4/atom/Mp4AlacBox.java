/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 */
package org.jaudiotagger.audio.mp4.atom;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.atom.AbstractMp4Box;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;

public class Mp4AlacBox
extends AbstractMp4Box {
    public static final int OTHER_FLAG_LENGTH = 4;
    private int bitRate;
    private int channels;
    private int historyMult;
    private int initialHistory;
    private int kModifier;
    private int maxCodedFrameSize;
    private int maxSamplePerFrame;
    private int sampleRate;
    private int sampleSize;
    private int unknown1;
    private int unknown2;

    public Mp4AlacBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) {
        this.header = mp4BoxHeader;
        this.dataBuffer = byteBuffer;
    }

    public int getBitRate() {
        return this.bitRate;
    }

    public int getChannels() {
        return this.channels;
    }

    public int getHistoryMult() {
        return this.historyMult;
    }

    public int getInitialHistory() {
        return this.initialHistory;
    }

    public int getKModifier() {
        return this.kModifier;
    }

    public int getMaxCodedFrameSize() {
        return this.maxCodedFrameSize;
    }

    public int getMaxSamplePerFrame() {
        return this.maxSamplePerFrame;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    public int getUnknown1() {
        return this.unknown1;
    }

    public int getUnknown2() {
        return this.unknown2;
    }

    public void processData() throws CannotReadException {
        ByteBuffer byteBuffer = this.dataBuffer;
        byteBuffer.position(4 + byteBuffer.position());
        this.dataBuffer.order(ByteOrder.BIG_ENDIAN);
        this.maxSamplePerFrame = this.dataBuffer.getInt();
        this.unknown1 = Utils.u(this.dataBuffer.get());
        this.sampleSize = Utils.u(this.dataBuffer.get());
        this.historyMult = Utils.u(this.dataBuffer.get());
        this.initialHistory = Utils.u(this.dataBuffer.get());
        this.kModifier = Utils.u(this.dataBuffer.get());
        this.channels = Utils.u(this.dataBuffer.get());
        this.unknown2 = this.dataBuffer.getShort();
        this.maxCodedFrameSize = this.dataBuffer.getInt();
        this.bitRate = this.dataBuffer.getInt();
        this.sampleRate = this.dataBuffer.getInt();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("maxSamplePerFrame:");
        stringBuilder.append(this.maxSamplePerFrame);
        stringBuilder.append("unknown1:");
        stringBuilder.append(this.unknown1);
        stringBuilder.append("sampleSize:");
        stringBuilder.append(this.sampleSize);
        stringBuilder.append("historyMult:");
        stringBuilder.append(this.historyMult);
        stringBuilder.append("initialHistory:");
        stringBuilder.append(this.initialHistory);
        stringBuilder.append("kModifier:");
        stringBuilder.append(this.kModifier);
        stringBuilder.append("channels:");
        stringBuilder.append(this.channels);
        stringBuilder.append("unknown2 :");
        stringBuilder.append(this.unknown2);
        stringBuilder.append("maxCodedFrameSize:");
        stringBuilder.append(this.maxCodedFrameSize);
        stringBuilder.append("bitRate:");
        stringBuilder.append(this.bitRate);
        stringBuilder.append("sampleRate:");
        stringBuilder.append(this.sampleRate);
        return stringBuilder.toString();
    }
}

