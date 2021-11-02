/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 */
package org.jaudiotagger.audio.ogg.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

public class OggPageHeader {
    public static final byte[] CAPTURE_PATTERN;
    public static final int FIELD_ABSOLUTE_GRANULE_LENGTH = 8;
    public static final int FIELD_ABSOLUTE_GRANULE_POS = 6;
    public static final int FIELD_CAPTURE_PATTERN_LENGTH = 4;
    public static final int FIELD_CAPTURE_PATTERN_POS = 0;
    public static final int FIELD_HEADER_TYPE_FLAG_LENGTH = 1;
    public static final int FIELD_HEADER_TYPE_FLAG_POS = 5;
    public static final int FIELD_PAGE_CHECKSUM_LENGTH = 4;
    public static final int FIELD_PAGE_CHECKSUM_POS = 22;
    public static final int FIELD_PAGE_SEGMENTS_LENGTH = 1;
    public static final int FIELD_PAGE_SEGMENTS_POS = 26;
    public static final int FIELD_PAGE_SEQUENCE_NO_LENGTH = 4;
    public static final int FIELD_PAGE_SEQUENCE_NO_POS = 18;
    public static final int FIELD_SEGMENT_TABLE_POS = 27;
    public static final int FIELD_STREAM_SERIAL_NO_LENGTH = 4;
    public static final int FIELD_STREAM_SERIAL_NO_POS = 14;
    public static final int FIELD_STREAM_STRUCTURE_VERSION_LENGTH = 1;
    public static final int FIELD_STREAM_STRUCTURE_VERSION_POS = 4;
    public static final int MAXIMUM_NO_OF_SEGMENT_SIZE = 255;
    public static final int MAXIMUM_PAGE_DATA_SIZE = 65025;
    public static final int MAXIMUM_PAGE_HEADER_SIZE = 282;
    public static final int MAXIMUM_PAGE_SIZE = 65307;
    public static final int MAXIMUM_SEGMENT_SIZE = 255;
    public static final int OGG_PAGE_HEADER_FIXED_LENGTH = 27;
    public static Logger logger;
    private double absoluteGranulePosition;
    private int checksum;
    private byte headerTypeFlag;
    private boolean isValid = false;
    private boolean lastPacketIncomplete = false;
    private List<PacketStartAndLength> packetList = new ArrayList();
    private int pageLength = 0;
    private int pageSequenceNumber;
    private byte[] rawHeaderData;
    private byte[] segmentTable;
    private long startByte = 0L;
    private int streamSerialNumber;

    static {
        logger = Logger.getLogger((String)"org.jaudiotagger.audio.ogg.atom");
        CAPTURE_PATTERN = new byte[]{79, 103, 103, 83};
    }

    public OggPageHeader(byte[] arrby) {
        this.rawHeaderData = arrby;
        byte by = arrby[4];
        this.headerTypeFlag = arrby[5];
        if (by == 0) {
            byte[] arrby2;
            this.absoluteGranulePosition = 0.0;
            for (int i2 = 0; i2 < 8; ++i2) {
                this.absoluteGranulePosition += (double)this.u(arrby[i2 + 6]) * Math.pow((double)2.0, (double)(i2 * 8));
            }
            this.streamSerialNumber = Utils.getIntLE(arrby, 14, 17);
            this.pageSequenceNumber = Utils.getIntLE(arrby, 18, 21);
            this.checksum = Utils.getIntLE(arrby, 22, 25);
            this.u(arrby[26]);
            this.segmentTable = new byte[-27 + arrby.length];
            Integer n2 = null;
            int n3 = 0;
            for (int i3 = 0; i3 < (arrby2 = this.segmentTable).length; ++i3) {
                arrby2[i3] = arrby[i3 + 27];
                n2 = this.u(arrby2[i3]);
                this.pageLength += n2.intValue();
                n3 += n2.intValue();
                if (n2 >= 255) continue;
                this.packetList.add((Object)new PacketStartAndLength(this.pageLength - n3, n3));
                n3 = 0;
            }
            if (n2 != null && n2 == 255) {
                this.packetList.add((Object)new PacketStartAndLength(this.pageLength - n3, n3));
                this.lastPacketIncomplete = true;
            }
            this.isValid = true;
        }
        if (logger.isLoggable(Level.CONFIG)) {
            Logger logger = OggPageHeader.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Constructed OggPage:");
            stringBuilder.append(this.toString());
            logger.config(stringBuilder.toString());
        }
    }

    public static OggPageHeader read(RandomAccessFile randomAccessFile) throws IOException, CannotReadException {
        long l2 = randomAccessFile.getFilePointer();
        Logger logger = OggPageHeader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trying to read OggPage at:");
        stringBuilder.append(l2);
        logger.fine(stringBuilder.toString());
        byte[] arrby = CAPTURE_PATTERN;
        byte[] arrby2 = new byte[arrby.length];
        randomAccessFile.read(arrby2);
        if (!Arrays.equals((byte[])arrby2, (byte[])arrby)) {
            randomAccessFile.seek(l2);
            if (AbstractID3v2Tag.isId3Tag((RandomAccessFile)randomAccessFile)) {
                Logger logger2 = OggPageHeader.logger;
                ErrorMessage errorMessage = ErrorMessage.OGG_CONTAINS_ID3TAG;
                Object[] arrobject = new Object[]{randomAccessFile.getFilePointer() - l2};
                logger2.warning(errorMessage.getMsg(arrobject));
                randomAccessFile.read(arrby2);
                if (Arrays.equals((byte[])arrby2, (byte[])arrby)) {
                    l2 = randomAccessFile.getFilePointer() - (long)arrby.length;
                }
            } else {
                ErrorMessage errorMessage = ErrorMessage.OGG_HEADER_CANNOT_BE_FOUND;
                Object[] arrobject = new Object[]{new String(arrby2)};
                throw new CannotReadException(errorMessage.getMsg(arrobject));
            }
        }
        randomAccessFile.seek(26L + l2);
        int n2 = 255 & randomAccessFile.readByte();
        randomAccessFile.seek(l2);
        byte[] arrby3 = new byte[n2 + 27];
        randomAccessFile.read(arrby3);
        OggPageHeader oggPageHeader = new OggPageHeader(arrby3);
        oggPageHeader.setStartByte(l2);
        return oggPageHeader;
    }

    public static OggPageHeader read(ByteBuffer byteBuffer) throws IOException, CannotReadException {
        int n2 = byteBuffer.position();
        Logger logger = OggPageHeader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trying to read OggPage at:");
        stringBuilder.append(n2);
        logger.fine(stringBuilder.toString());
        byte[] arrby = CAPTURE_PATTERN;
        byte[] arrby2 = new byte[arrby.length];
        byteBuffer.get(arrby2);
        if (Arrays.equals((byte[])arrby2, (byte[])arrby)) {
            byteBuffer.position(n2 + 26);
            int n3 = 255 & byteBuffer.get();
            byteBuffer.position(n2);
            byte[] arrby3 = new byte[n3 + 27];
            byteBuffer.get(arrby3);
            return new OggPageHeader(arrby3);
        }
        ErrorMessage errorMessage = ErrorMessage.OGG_HEADER_CANNOT_BE_FOUND;
        Object[] arrobject = new Object[]{new String(arrby2)};
        throw new CannotReadException(errorMessage.getMsg(arrobject));
    }

    private int u(int n2) {
        return n2 & 255;
    }

    public double getAbsoluteGranulePosition() {
        Logger logger = OggPageHeader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Number Of Samples: ");
        stringBuilder.append(this.absoluteGranulePosition);
        logger.fine(stringBuilder.toString());
        return this.absoluteGranulePosition;
    }

    public int getCheckSum() {
        return this.checksum;
    }

    public byte getHeaderType() {
        return this.headerTypeFlag;
    }

    public List<PacketStartAndLength> getPacketList() {
        return this.packetList;
    }

    public int getPageLength() {
        Logger logger = OggPageHeader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("This page length: ");
        stringBuilder.append(this.pageLength);
        logger.finer(stringBuilder.toString());
        return this.pageLength;
    }

    public int getPageSequence() {
        return this.pageSequenceNumber;
    }

    public byte[] getRawHeaderData() {
        return this.rawHeaderData;
    }

    public byte[] getSegmentTable() {
        return this.segmentTable;
    }

    public int getSerialNumber() {
        return this.streamSerialNumber;
    }

    public long getStartByte() {
        return this.startByte;
    }

    public boolean isLastPacketIncomplete() {
        return this.lastPacketIncomplete;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setStartByte(long l2) {
        this.startByte = l2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ogg Page Header:isValid:");
        stringBuilder.append(this.isValid);
        stringBuilder.append(":type:");
        stringBuilder.append((int)this.headerTypeFlag);
        stringBuilder.append(":oggPageHeaderLength:");
        stringBuilder.append(this.rawHeaderData.length);
        stringBuilder.append(":length:");
        stringBuilder.append(this.pageLength);
        stringBuilder.append(":seqNo:");
        stringBuilder.append(this.getPageSequence());
        stringBuilder.append(":packetIncomplete:");
        stringBuilder.append(this.isLastPacketIncomplete());
        stringBuilder.append(":serNum:");
        stringBuilder.append(this.getSerialNumber());
        String string2 = stringBuilder.toString();
        for (PacketStartAndLength packetStartAndLength : this.getPacketList()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(packetStartAndLength.toString());
            string2 = stringBuilder2.toString();
        }
        return string2;
    }

    public static final class HeaderTypeFlag
    extends Enum<HeaderTypeFlag> {
        private static final /* synthetic */ HeaderTypeFlag[] $VALUES;
        public static final /* enum */ HeaderTypeFlag CONTINUED_PACKET;
        public static final /* enum */ HeaderTypeFlag END_OF_BITSTREAM;
        public static final /* enum */ HeaderTypeFlag FRESH_PACKET;
        public static final /* enum */ HeaderTypeFlag START_OF_BITSTREAM;
        byte fileValue;

        static {
            HeaderTypeFlag headerTypeFlag;
            HeaderTypeFlag headerTypeFlag2;
            HeaderTypeFlag headerTypeFlag3;
            HeaderTypeFlag headerTypeFlag4;
            FRESH_PACKET = headerTypeFlag4 = new HeaderTypeFlag(0);
            CONTINUED_PACKET = headerTypeFlag2 = new HeaderTypeFlag(1);
            START_OF_BITSTREAM = headerTypeFlag3 = new HeaderTypeFlag(2);
            END_OF_BITSTREAM = headerTypeFlag = new HeaderTypeFlag(4);
            $VALUES = new HeaderTypeFlag[]{headerTypeFlag4, headerTypeFlag2, headerTypeFlag3, headerTypeFlag};
        }

        private HeaderTypeFlag(byte by) {
            this.fileValue = by;
        }

        public static HeaderTypeFlag valueOf(String string2) {
            return (HeaderTypeFlag)Enum.valueOf(HeaderTypeFlag.class, (String)string2);
        }

        public static HeaderTypeFlag[] values() {
            return (HeaderTypeFlag[])$VALUES.clone();
        }

        public byte getFileValue() {
            return this.fileValue;
        }
    }

    public static class PacketStartAndLength {
        private Integer length;
        private Integer startPosition;

        public PacketStartAndLength(int n2, int n3) {
            Integer n4;
            this.startPosition = n4 = Integer.valueOf((int)0);
            this.length = n4;
            this.startPosition = n2;
            this.length = n3;
        }

        public int getLength() {
            return this.length;
        }

        public int getStartPosition() {
            return this.startPosition;
        }

        public void setLength(int n2) {
            this.length = n2;
        }

        public void setStartPosition(int n2) {
            this.startPosition = n2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NextPkt(start:");
            stringBuilder.append((Object)this.startPosition);
            stringBuilder.append(":length:");
            stringBuilder.append((Object)this.length);
            stringBuilder.append("),");
            return stringBuilder.toString();
        }
    }

}

