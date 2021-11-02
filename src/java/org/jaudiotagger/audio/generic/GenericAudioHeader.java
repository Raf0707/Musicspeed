/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.audio.generic;

import org.jaudiotagger.audio.AudioHeader;

public class GenericAudioHeader
implements AudioHeader {
    private Long audioDataEndPosition;
    private Long audioDataLength;
    private Long audioDataStartPosition;
    private Integer bitRate;
    private Integer bitsPerSample;
    private Integer byteRate;
    private String encodingType;
    private Boolean isLossless;
    private Boolean isVbr = Boolean.TRUE;
    private Integer noOfChannels;
    private Long noOfSamples;
    private Integer samplingRate;
    private Double trackLength;

    @Override
    public Long getAudioDataEndPosition() {
        return this.audioDataEndPosition;
    }

    @Override
    public Long getAudioDataLength() {
        return this.audioDataLength;
    }

    @Override
    public Long getAudioDataStartPosition() {
        return this.audioDataStartPosition;
    }

    @Override
    public String getBitRate() {
        return String.valueOf((Object)this.bitRate);
    }

    @Override
    public long getBitRateAsNumber() {
        return this.bitRate.intValue();
    }

    @Override
    public int getBitsPerSample() {
        Integer n2 = this.bitsPerSample;
        if (n2 == null) {
            return -1;
        }
        return n2;
    }

    @Override
    public Integer getByteRate() {
        return this.byteRate;
    }

    public int getChannelNumber() {
        return this.noOfChannels;
    }

    @Override
    public String getChannels() {
        return String.valueOf((int)this.getChannelNumber());
    }

    @Override
    public String getEncodingType() {
        return this.encodingType;
    }

    @Override
    public String getFormat() {
        return this.encodingType;
    }

    @Override
    public Long getNoOfSamples() {
        return this.noOfSamples;
    }

    @Override
    public double getPreciseTrackLength() {
        return this.trackLength;
    }

    @Override
    public String getSampleRate() {
        return String.valueOf((Object)this.samplingRate);
    }

    @Override
    public int getSampleRateAsNumber() {
        return this.samplingRate;
    }

    @Override
    public int getTrackLength() {
        return (int)Math.round((double)this.getPreciseTrackLength());
    }

    @Override
    public boolean isLossless() {
        Boolean bl = this.isLossless;
        if (bl == null) {
            return false;
        }
        return bl;
    }

    @Override
    public boolean isVariableBitRate() {
        Boolean bl = this.isVbr;
        if (bl == null) {
            return false;
        }
        return bl;
    }

    public void setAudioDataEndPosition(Long l2) {
        this.audioDataEndPosition = l2;
    }

    public void setAudioDataLength(long l2) {
        this.audioDataLength = l2;
    }

    public void setAudioDataStartPosition(Long l2) {
        this.audioDataStartPosition = l2;
    }

    public void setBitRate(int n2) {
        this.bitRate = n2;
    }

    public void setBitsPerSample(int n2) {
        this.bitsPerSample = n2;
    }

    public void setByteRate(int n2) {
        this.byteRate = n2;
    }

    public void setChannelNumber(int n2) {
        this.noOfChannels = n2;
    }

    public void setEncodingType(String string2) {
        this.encodingType = string2;
    }

    public void setLossless(boolean bl) {
        this.isLossless = bl;
    }

    public void setNoOfSamples(Long l2) {
        this.noOfSamples = l2;
    }

    public void setPreciseLength(double d2) {
        this.trackLength = d2;
    }

    public void setSamplingRate(int n2) {
        this.samplingRate = n2;
    }

    public void setVariableBitRate(boolean bl) {
        this.isVbr = bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Audio Header content:\n");
        if (this.audioDataLength != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("\taudioDataLength:");
            stringBuilder2.append((Object)this.audioDataLength);
            stringBuilder2.append("\n");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (this.audioDataStartPosition != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("\taudioDataStartPosition:");
            stringBuilder3.append((Object)this.audioDataStartPosition);
            stringBuilder3.append("\n");
            stringBuilder.append(stringBuilder3.toString());
        }
        if (this.audioDataEndPosition != null) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("\taudioDataEndPosition:");
            stringBuilder4.append((Object)this.audioDataEndPosition);
            stringBuilder4.append("\n");
            stringBuilder.append(stringBuilder4.toString());
        }
        if (this.byteRate != null) {
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("\tbyteRate:");
            stringBuilder5.append((Object)this.byteRate);
            stringBuilder5.append("\n");
            stringBuilder.append(stringBuilder5.toString());
        }
        if (this.bitRate != null) {
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("\tbitRate:");
            stringBuilder6.append((Object)this.bitRate);
            stringBuilder6.append("\n");
            stringBuilder.append(stringBuilder6.toString());
        }
        if (this.samplingRate != null) {
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append("\tsamplingRate:");
            stringBuilder7.append((Object)this.samplingRate);
            stringBuilder7.append("\n");
            stringBuilder.append(stringBuilder7.toString());
        }
        if (this.bitsPerSample != null) {
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append("\tbitsPerSample:");
            stringBuilder8.append((Object)this.bitsPerSample);
            stringBuilder8.append("\n");
            stringBuilder.append(stringBuilder8.toString());
        }
        if (this.noOfSamples != null) {
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append("\ttotalNoSamples:");
            stringBuilder9.append((Object)this.noOfSamples);
            stringBuilder9.append("\n");
            stringBuilder.append(stringBuilder9.toString());
        }
        if (this.noOfChannels != null) {
            StringBuilder stringBuilder10 = new StringBuilder();
            stringBuilder10.append("\tnumberOfChannels:");
            stringBuilder10.append((Object)this.noOfChannels);
            stringBuilder10.append("\n");
            stringBuilder.append(stringBuilder10.toString());
        }
        if (this.encodingType != null) {
            StringBuilder stringBuilder11 = new StringBuilder();
            stringBuilder11.append("\tencodingType:");
            stringBuilder11.append(this.encodingType);
            stringBuilder11.append("\n");
            stringBuilder.append(stringBuilder11.toString());
        }
        if (this.isVbr != null) {
            StringBuilder stringBuilder12 = new StringBuilder();
            stringBuilder12.append("\tisVbr:");
            stringBuilder12.append((Object)this.isVbr);
            stringBuilder12.append("\n");
            stringBuilder.append(stringBuilder12.toString());
        }
        if (this.isLossless != null) {
            StringBuilder stringBuilder13 = new StringBuilder();
            stringBuilder13.append("\tisLossless:");
            stringBuilder13.append((Object)this.isLossless);
            stringBuilder13.append("\n");
            stringBuilder.append(stringBuilder13.toString());
        }
        if (this.trackLength != null) {
            StringBuilder stringBuilder14 = new StringBuilder();
            stringBuilder14.append("\ttrackDuration:");
            stringBuilder14.append((Object)this.trackLength);
            stringBuilder14.append("\n");
            stringBuilder.append(stringBuilder14.toString());
        }
        return stringBuilder.toString();
    }
}

