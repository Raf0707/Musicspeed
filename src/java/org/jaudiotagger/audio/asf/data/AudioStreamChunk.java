/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
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

public final class AudioStreamChunk
extends StreamChunk {
    public static final String[][] CODEC_DESCRIPTIONS = new String[][]{{"161", " (Windows Media Audio (ver 7,8,9))"}, {"162", " (Windows Media Audio 9 series (Professional))"}, {"163", "(Windows Media Audio 9 series (Lossless))"}, {"7A21", " (GSM-AMR (CBR))"}, {"7A22", " (GSM-AMR (VBR))"}};
    public static final long WMA = 353L;
    public static final long WMA_CBR = 31265L;
    public static final long WMA_LOSSLESS = 355L;
    public static final long WMA_PRO = 354L;
    public static final long WMA_VBR = 31266L;
    private long averageBytesPerSec;
    private int bitsPerSample;
    private long blockAlignment;
    private long channelCount;
    private byte[] codecData = new byte[0];
    private long compressionFormat;
    private GUID errorConcealment;
    private long samplingRate;

    public AudioStreamChunk(BigInteger bigInteger) {
        super(GUID.GUID_AUDIOSTREAM, bigInteger);
    }

    public long getAverageBytesPerSec() {
        return this.averageBytesPerSec;
    }

    public int getBitsPerSample() {
        return this.bitsPerSample;
    }

    public long getBlockAlignment() {
        return this.blockAlignment;
    }

    public long getChannelCount() {
        return this.channelCount;
    }

    public byte[] getCodecData() {
        return (byte[])this.codecData.clone();
    }

    public String getCodecDescription() {
        String string2;
        StringBuilder stringBuilder;
        block3 : {
            stringBuilder = new StringBuilder(Long.toHexString((long)this.getCompressionFormat()));
            for (String[] arrstring : CODEC_DESCRIPTIONS) {
                if (!arrstring[0].equalsIgnoreCase(stringBuilder.toString())) continue;
                string2 = arrstring[1];
                break block3;
            }
            string2 = " (Unknown)";
        }
        if (stringBuilder.length() % 2 == 0) {
            stringBuilder.insert(0, "0x");
        } else {
            stringBuilder.insert(0, "0x0");
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public long getCompressionFormat() {
        return this.compressionFormat;
    }

    public GUID getErrorConcealment() {
        return this.errorConcealment;
    }

    public int getKbps() {
        return 8 * (int)this.getAverageBytesPerSec() / 1000;
    }

    public long getSamplingRate() {
        return this.samplingRate;
    }

    public boolean isErrorConcealed() {
        return this.getErrorConcealment().equals(GUID.GUID_AUDIO_ERROR_CONCEALEMENT_INTERLEAVED);
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        stringBuilder.append(string2);
        stringBuilder.append("  |-> Audio info:");
        String string3 = Utils.LINE_SEPARATOR;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |  : Bitrate : ");
        stringBuilder.append(this.getKbps());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |  : Channels : ");
        stringBuilder.append(this.getChannelCount());
        stringBuilder.append(" at ");
        stringBuilder.append(this.getSamplingRate());
        stringBuilder.append(" Hz");
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |  : Bits per Sample: ");
        stringBuilder.append(this.getBitsPerSample());
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |  : Formatcode: ");
        stringBuilder.append(this.getCodecDescription());
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void setAverageBytesPerSec(long l2) {
        this.averageBytesPerSec = l2;
    }

    public void setBitsPerSample(int n2) {
        this.bitsPerSample = n2;
    }

    public void setBlockAlignment(long l2) {
        this.blockAlignment = l2;
    }

    public void setChannelCount(long l2) {
        this.channelCount = l2;
    }

    public void setCodecData(byte[] arrby) {
        if (arrby != null) {
            this.codecData = (byte[])arrby.clone();
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setCompressionFormat(long l2) {
        this.compressionFormat = l2;
    }

    public void setErrorConcealment(GUID gUID) {
        this.errorConcealment = gUID;
    }

    public void setSamplingRate(long l2) {
        this.samplingRate = l2;
    }
}

