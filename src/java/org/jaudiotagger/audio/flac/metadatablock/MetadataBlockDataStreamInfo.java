/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.flac.metadatablock;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockData;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockHeader;
import org.jaudiotagger.audio.generic.Utils;

public class MetadataBlockDataStreamInfo
implements MetadataBlockData {
    public static final int STREAM_INFO_DATA_LENGTH = 34;
    private static final char[] hexArray;
    public static Logger logger;
    private int bitsPerSample;
    private boolean isValid = true;
    private int maxBlockSize;
    private int maxFrameSize;
    private String md5;
    private int minBlockSize;
    private int minFrameSize;
    private int noOfChannels;
    private int noOfSamples;
    private ByteBuffer rawdata;
    private int samplingRate;
    private int samplingRatePerChannel;
    private float trackLength;

    static {
        logger = Logger.getLogger((String)"org.jaudiotagger.audio.flac.MetadataBlockDataStreamInfo");
        hexArray = "0123456789abcdef".toCharArray();
    }

    public MetadataBlockDataStreamInfo(MetadataBlockHeader metadataBlockHeader, FileChannel fileChannel) throws IOException {
        ByteBuffer byteBuffer;
        this.rawdata = byteBuffer = ByteBuffer.allocate((int)metadataBlockHeader.getDataLength());
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        int n2 = fileChannel.read(this.rawdata);
        if (n2 >= metadataBlockHeader.getDataLength()) {
            this.rawdata.flip();
            this.minBlockSize = Utils.u(this.rawdata.getShort());
            this.maxBlockSize = Utils.u(this.rawdata.getShort());
            this.minFrameSize = this.readThreeByteInteger(this.rawdata.get(), this.rawdata.get(), this.rawdata.get());
            this.maxFrameSize = this.readThreeByteInteger(this.rawdata.get(), this.rawdata.get(), this.rawdata.get());
            this.samplingRate = this.readSamplingRate();
            this.noOfChannels = this.readNoOfChannels();
            this.bitsPerSample = this.readBitsPerSample();
            this.noOfSamples = this.readTotalNumberOfSamples();
            this.md5 = this.readMd5();
            double d2 = this.noOfSamples;
            int n3 = this.samplingRate;
            this.trackLength = (float)(d2 / (double)n3);
            this.samplingRatePerChannel = n3 / this.noOfChannels;
            this.rawdata.rewind();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to read required number of bytes, read:");
        stringBuilder.append(n2);
        stringBuilder.append(":required:");
        stringBuilder.append(metadataBlockHeader.getDataLength());
        throw new IOException(stringBuilder.toString());
    }

    private int readBitsPerSample() {
        return 1 + (((1 & Utils.u(this.rawdata.get(12))) << 4) + ((240 & Utils.u(this.rawdata.get(13))) >>> 4));
    }

    private String readMd5() {
        char[] arrc = new char[32];
        if (this.rawdata.limit() >= 34) {
            for (int i2 = 0; i2 < 16; ++i2) {
                int n2 = 255 & this.rawdata.get(i2 + 18);
                int n3 = i2 * 2;
                char[] arrc2 = hexArray;
                arrc[n3] = arrc2[n2 >>> 4];
                arrc[n3 + 1] = arrc2[n2 & 15];
            }
        }
        return new String(arrc);
    }

    private int readNoOfChannels() {
        return 1 + ((14 & Utils.u(this.rawdata.get(12))) >>> 1);
    }

    private int readSamplingRate() {
        return (Utils.u(this.rawdata.get(10)) << 12) + (Utils.u(this.rawdata.get(11)) << 4) + ((240 & Utils.u(this.rawdata.get(12))) >>> 4);
    }

    private int readThreeByteInteger(byte by, byte by2, byte by3) {
        return (Utils.u(by) << 16) + (Utils.u(by2) << 8) + Utils.u(by3);
    }

    private int readTotalNumberOfSamples() {
        return Utils.u(this.rawdata.get(17)) + (Utils.u(this.rawdata.get(16)) << 8) + (Utils.u(this.rawdata.get(15)) << 16) + (Utils.u(this.rawdata.get(14)) << 24) + ((15 & Utils.u(this.rawdata.get(13))) << 32);
    }

    public int getBitsPerSample() {
        return this.bitsPerSample;
    }

    @Override
    public ByteBuffer getBytes() {
        return this.rawdata;
    }

    public String getEncodingType() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FLAC ");
        stringBuilder.append(this.bitsPerSample);
        stringBuilder.append(" bits");
        return stringBuilder.toString();
    }

    @Override
    public int getLength() {
        return this.rawdata.limit();
    }

    public String getMD5Signature() {
        return this.md5;
    }

    public int getNoOfChannels() {
        return this.noOfChannels;
    }

    public long getNoOfSamples() {
        return this.noOfSamples;
    }

    public float getPreciseLength() {
        return this.trackLength;
    }

    public int getSamplingRate() {
        return this.samplingRate;
    }

    public int getSamplingRatePerChannel() {
        return this.samplingRatePerChannel;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MinBlockSize:");
        stringBuilder.append(this.minBlockSize);
        stringBuilder.append("MaxBlockSize:");
        stringBuilder.append(this.maxBlockSize);
        stringBuilder.append("MinFrameSize:");
        stringBuilder.append(this.minFrameSize);
        stringBuilder.append("MaxFrameSize:");
        stringBuilder.append(this.maxFrameSize);
        stringBuilder.append("SampleRateTotal:");
        stringBuilder.append(this.samplingRate);
        stringBuilder.append("SampleRatePerChannel:");
        stringBuilder.append(this.samplingRatePerChannel);
        stringBuilder.append(":Channel number:");
        stringBuilder.append(this.noOfChannels);
        stringBuilder.append(":Bits per sample: ");
        stringBuilder.append(this.bitsPerSample);
        stringBuilder.append(":TotalNumberOfSamples: ");
        stringBuilder.append(this.noOfSamples);
        stringBuilder.append(":Length: ");
        stringBuilder.append(this.trackLength);
        return stringBuilder.toString();
    }
}

