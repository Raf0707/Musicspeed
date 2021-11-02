/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio;

public interface AudioHeader {
    public Long getAudioDataEndPosition();

    public Long getAudioDataLength();

    public Long getAudioDataStartPosition();

    public String getBitRate();

    public long getBitRateAsNumber();

    public int getBitsPerSample();

    public Integer getByteRate();

    public String getChannels();

    public String getEncodingType();

    public String getFormat();

    public Long getNoOfSamples();

    public double getPreciseTrackLength();

    public String getSampleRate();

    public int getSampleRateAsNumber();

    public int getTrackLength();

    public boolean isLossless();

    public boolean isVariableBitRate();
}

