/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.HashMap
 *  java.util.Map
 */
package org.jaudiotagger.audio.mp4.atom;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.atom.AbstractMp4Box;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;

public class Mp4EsdsBox
extends AbstractMp4Box {
    public static final int AVERAGE_BITRATE_LENGTH = 4;
    public static final int BUFFER_SIZE_LENGTH = 3;
    public static final int CHANNEL_FLAGS_LENGTH = 1;
    public static final int CONFIG_TYPE_LENGTH = 1;
    public static final int DESCRIPTOR_OBJECT_TYPE_LENGTH = 1;
    public static final int DESCRIPTOR_TYPE_LENGTH = 1;
    public static final int ES_ID_LENGTH = 2;
    private static final int FILLER_END = 254;
    private static final int FILLER_OTHER = 129;
    private static final int FILLER_START = 128;
    public static final int MAX_BITRATE_LENGTH = 4;
    public static final int OBJECT_TYPE_LENGTH = 1;
    public static final int OTHER_FLAG_LENGTH = 3;
    private static final int SECTION_FIVE = 5;
    private static final int SECTION_FOUR = 4;
    private static final int SECTION_SIX = 6;
    private static final int SECTION_THREE = 3;
    public static final int STREAM_PRIORITY_LENGTH = 1;
    public static final int STREAM_TYPE_LENGTH = 1;
    public static final int VERSION_FLAG_LENGTH = 1;
    private static Map<Integer, AudioProfile> audioProfileMap;
    private static Map<Integer, Kind> kindMap;
    private AudioProfile audioProfile;
    private int avgBitrate;
    private Kind kind;
    private int maxBitrate;
    private int numberOfChannels;

    static {
        kindMap = new HashMap();
        Kind[] arrkind = Kind.values();
        int n2 = arrkind.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Kind kind = arrkind[i2];
            kindMap.put((Object)kind.getId(), (Object)kind);
        }
        audioProfileMap = new HashMap();
        AudioProfile[] arraudioProfile = AudioProfile.values();
        int n4 = arraudioProfile.length;
        while (n3 < n4) {
            AudioProfile audioProfile = arraudioProfile[n3];
            audioProfileMap.put((Object)audioProfile.getId(), (Object)audioProfile);
            ++n3;
        }
    }

    public Mp4EsdsBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) {
        this.header = mp4BoxHeader;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.position(3 + (1 + byteBuffer.position()));
        if (byteBuffer.get() == 3) {
            this.processSectionHeader(byteBuffer);
            byteBuffer.position(1 + (2 + byteBuffer.position()));
        }
        if (byteBuffer.get() == 4) {
            this.processSectionHeader(byteBuffer);
            this.kind = (Object)kindMap.get((Object)byteBuffer.get());
            byteBuffer.position(3 + (1 + byteBuffer.position()));
            this.maxBitrate = byteBuffer.getInt();
            this.avgBitrate = byteBuffer.getInt();
        }
        if (byteBuffer.get() == 5) {
            this.processSectionHeader(byteBuffer);
            this.audioProfile = (Object)audioProfileMap.get((Object)(byteBuffer.get() >> 3));
            this.numberOfChannels = byteBuffer.get() << 1 >> 4;
        }
    }

    public AudioProfile getAudioProfile() {
        return this.audioProfile;
    }

    public int getAvgBitrate() {
        return this.avgBitrate;
    }

    public Kind getKind() {
        return this.kind;
    }

    public int getMaxBitrate() {
        return this.maxBitrate;
    }

    public int getNumberOfChannels() {
        return this.numberOfChannels;
    }

    public int processSectionHeader(ByteBuffer byteBuffer) {
        byte by = byteBuffer.get();
        int n2 = by & 255;
        if (n2 != 128 && n2 != 129 && n2 != 254) {
            return Utils.u(by);
        }
        byteBuffer.get();
        byteBuffer.get();
        return Utils.u(byteBuffer.get());
    }

}

