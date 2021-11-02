/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.ogg.util;

import java.nio.charset.Charset;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.ogg.VorbisVersion;
import org.jaudiotagger.audio.ogg.util.VorbisHeader;
import org.jaudiotagger.audio.ogg.util.VorbisPacketType;

public class VorbisIdentificationHeader
implements VorbisHeader {
    public static final int FIELD_AUDIO_CHANNELS_LENGTH = 1;
    public static final int FIELD_AUDIO_CHANNELS_POS = 11;
    public static final int FIELD_AUDIO_SAMPLE_RATE_LENGTH = 4;
    public static final int FIELD_AUDIO_SAMPLE_RATE_POS = 12;
    public static final int FIELD_BITRATE_MAX_LENGTH = 4;
    public static final int FIELD_BITRATE_MAX_POS = 16;
    public static final int FIELD_BITRATE_MIN_LENGTH = 4;
    public static final int FIELD_BITRATE_MIN_POS = 24;
    public static final int FIELD_BITRATE_NOMAIML_LENGTH = 4;
    public static final int FIELD_BITRATE_NOMAIML_POS = 20;
    public static final int FIELD_BLOCKSIZE_LENGTH = 1;
    public static final int FIELD_BLOCKSIZE_POS = 28;
    public static final int FIELD_FRAMING_FLAG_LENGTH = 1;
    public static final int FIELD_FRAMING_FLAG_POS = 29;
    public static final int FIELD_VORBIS_VERSION_LENGTH = 4;
    public static final int FIELD_VORBIS_VERSION_POS = 7;
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.ogg.atom");
    private int audioChannels;
    private int audioSampleRate;
    private int bitrateMaximal;
    private int bitrateMinimal;
    private int bitrateNominal;
    private boolean isValid = false;
    private int vorbisVersion;

    public VorbisIdentificationHeader(byte[] arrby) {
        this.decodeHeader(arrby);
    }

    private int u(int n2) {
        return n2 & 255;
    }

    public void decodeHeader(byte[] arrby) {
        byte by = arrby[0];
        Logger logger = VorbisIdentificationHeader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("packetType");
        stringBuilder.append((int)by);
        logger.fine(stringBuilder.toString());
        String string2 = new String(arrby, 1, 6, StandardCharsets.ISO_8859_1);
        if (by == VorbisPacketType.IDENTIFICATION_HEADER.getType() && string2.equals((Object)"vorbis")) {
            this.vorbisVersion = arrby[7] + (arrby[8] << 8) + (arrby[9] << 16) + (arrby[10] << 24);
            Logger logger2 = VorbisIdentificationHeader.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("vorbisVersion");
            stringBuilder2.append(this.vorbisVersion);
            logger2.fine(stringBuilder2.toString());
            this.audioChannels = this.u(arrby[11]);
            Logger logger3 = VorbisIdentificationHeader.logger;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("audioChannels");
            stringBuilder3.append(this.audioChannels);
            logger3.fine(stringBuilder3.toString());
            this.audioSampleRate = this.u(arrby[12]) + (this.u(arrby[13]) << 8) + (this.u(arrby[14]) << 16) + (this.u(arrby[15]) << 24);
            Logger logger4 = VorbisIdentificationHeader.logger;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("audioSampleRate");
            stringBuilder4.append(this.audioSampleRate);
            logger4.fine(stringBuilder4.toString());
            Logger logger5 = VorbisIdentificationHeader.logger;
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("audioSampleRate");
            stringBuilder5.append((int)arrby[12]);
            stringBuilder5.append(" ");
            stringBuilder5.append((int)arrby[13]);
            stringBuilder5.append(" ");
            stringBuilder5.append((int)arrby[14]);
            logger5.fine(stringBuilder5.toString());
            this.bitrateMinimal = this.u(arrby[16]) + (this.u(arrby[17]) << 8) + (this.u(arrby[18]) << 16) + (this.u(arrby[19]) << 24);
            this.bitrateNominal = this.u(arrby[20]) + (this.u(arrby[21]) << 8) + (this.u(arrby[22]) << 16) + (this.u(arrby[23]) << 24);
            this.bitrateMaximal = this.u(arrby[24]) + (this.u(arrby[25]) << 8) + (this.u(arrby[26]) << 16) + (this.u(arrby[27]) << 24);
            byte by2 = arrby[29];
            Logger logger6 = VorbisIdentificationHeader.logger;
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("framingFlag");
            stringBuilder6.append((int)by2);
            logger6.fine(stringBuilder6.toString());
            if (by2 != 0) {
                this.isValid = true;
            }
        }
    }

    public int getChannelNumber() {
        return this.audioChannels;
    }

    public String getEncodingType() {
        return VorbisVersion.values()[this.vorbisVersion].toString();
    }

    public int getMaxBitrate() {
        return this.bitrateMaximal;
    }

    public int getMinBitrate() {
        return this.bitrateMinimal;
    }

    public int getNominalBitrate() {
        return this.bitrateNominal;
    }

    public int getSamplingRate() {
        return this.audioSampleRate;
    }

    public boolean isValid() {
        return this.isValid;
    }
}

