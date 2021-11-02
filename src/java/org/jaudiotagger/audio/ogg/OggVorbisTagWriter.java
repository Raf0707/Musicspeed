/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.nio.channels.ReadableByteChannel
 *  java.util.Iterator
 *  java.util.List
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag
 */
package org.jaudiotagger.audio.ogg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.ogg.OggVorbisCommentTagCreator;
import org.jaudiotagger.audio.ogg.OggVorbisTagReader;
import org.jaudiotagger.audio.ogg.util.OggCRCFactory;
import org.jaudiotagger.audio.ogg.util.OggPageHeader;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;

public class OggVorbisTagWriter {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.ogg");
    private OggVorbisTagReader reader = new OggVorbisTagReader();
    private OggVorbisCommentTagCreator tc = new OggVorbisCommentTagCreator();

    private void calculateChecksumOverPage(ByteBuffer byteBuffer) {
        byteBuffer.putInt(22, 0);
        byte[] arrby = OggCRCFactory.computeCRC(byteBuffer.array());
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            byteBuffer.put(i2 + 22, arrby[i2]);
        }
        byteBuffer.rewind();
    }

    private byte[] createSegmentTable(int n2, int n3, List<OggPageHeader.PacketStartAndLength> list) {
        ByteArrayOutputStream byteArrayOutputStream;
        block4 : {
            Logger logger = OggVorbisTagWriter.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Create SegmentTable CommentLength:");
            stringBuilder.append(n2);
            stringBuilder.append(":SetupHeaderLength:");
            stringBuilder.append(n3);
            logger.finest(stringBuilder.toString());
            byteArrayOutputStream = new ByteArrayOutputStream();
            if (n3 == 0) {
                return this.createSegments(n2, false);
            }
            byte[] arrby = this.createSegments(n2, true);
            byte[] arrby2 = list.size() > 0 ? this.createSegments(n3, true) : this.createSegments(n3, false);
            Logger logger2 = OggVorbisTagWriter.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Created ");
            stringBuilder2.append(arrby.length);
            stringBuilder2.append(" segments for header");
            logger2.finest(stringBuilder2.toString());
            Logger logger3 = OggVorbisTagWriter.logger;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Created ");
            stringBuilder3.append(arrby2.length);
            stringBuilder3.append(" segments for setup");
            logger3.finest(stringBuilder3.toString());
            try {
                byteArrayOutputStream.write(arrby);
                byteArrayOutputStream.write(arrby2);
                if (list.size() <= 0) break block4;
                Logger logger4 = OggVorbisTagWriter.logger;
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("Creating segments for ");
                stringBuilder4.append(list.size());
                stringBuilder4.append(" packets");
                logger4.finer(stringBuilder4.toString());
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    byteArrayOutputStream.write(this.createSegments(((OggPageHeader.PacketStartAndLength)iterator.next()).getLength(), false));
                }
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append("Unable to create segment table:");
                stringBuilder5.append(iOException.getMessage());
                throw new RuntimeException(stringBuilder5.toString());
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] createSegmentTable(int n2, List<OggPageHeader.PacketStartAndLength> list) {
        ByteArrayOutputStream byteArrayOutputStream;
        block3 : {
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] arrby = this.createSegments(n2, true);
            try {
                byteArrayOutputStream.write(arrby);
                if (list.size() <= 0) break block3;
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    byteArrayOutputStream.write(this.createSegments(((OggPageHeader.PacketStartAndLength)iterator.next()).getLength(), false));
                }
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to create segment table:");
                stringBuilder.append(iOException.getMessage());
                throw new RuntimeException(stringBuilder.toString());
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] createSegments(int n2, boolean bl) {
        int n3;
        int n4;
        Logger logger = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Create Segments for length:");
        stringBuilder.append(n2);
        stringBuilder.append(":QuitStream:");
        stringBuilder.append(bl);
        logger.finest(stringBuilder.toString());
        if (n2 == 0) {
            return new byte[]{0};
        }
        int n5 = n2 / 255;
        int n6 = n2 % 255 == 0 && !bl ? 0 : 1;
        int n7 = n5 + n6;
        byte[] arrby = new byte[n7];
        for (n4 = 0; n4 < (n3 = n7 - 1); ++n4) {
            arrby[n4] = -1;
        }
        arrby[n3] = (byte)(n2 - n4 * 255);
        return arrby;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean isCommentAndSetupHeaderFitsOnASinglePage(int n2, int n3, List<OggPageHeader.PacketStartAndLength> list) {
        int n4;
        int n5;
        if (n2 == 0) {
            n5 = 1;
        } else {
            n5 = 1 + n2 / 255;
            if (n2 % 255 == 0) {
                ++n5;
            }
        }
        Logger logger = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Require:");
        stringBuilder.append(n5);
        stringBuilder.append(" segments for comment");
        logger.finest(stringBuilder.toString());
        if (n3 == 0) {
            n4 = n5 + 1;
        } else {
            n4 = n5 + (1 + n3 / 255);
            if (n3 % 255 == 0) {
                ++n4;
            }
        }
        Logger logger2 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Require:");
        stringBuilder2.append(n4);
        stringBuilder2.append(" segments for comment plus setup");
        logger2.finest(stringBuilder2.toString());
        for (OggPageHeader.PacketStartAndLength packetStartAndLength : list) {
            if (packetStartAndLength.getLength() != 0) {
                n4 += 1 + packetStartAndLength.getLength() / 255;
                if (packetStartAndLength.getLength() % 255 != 0) continue;
            }
            ++n4;
        }
        Logger logger3 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Total No Of Segment If New Comment And Header Put On One Page:");
        stringBuilder3.append(n4);
        logger3.finest(stringBuilder3.toString());
        return n4 <= 255;
    }

    private void replacePagesAndRenumberPageSeqs(OggVorbisTagReader.OggVorbisHeaderSizes oggVorbisHeaderSizes, int n2, OggPageHeader oggPageHeader, ByteBuffer byteBuffer, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws IOException, CannotReadException, CannotWriteException {
        int n3;
        int n4;
        int n5 = oggPageHeader.getPageSequence();
        int n6 = n2 / 65025;
        Logger logger = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Comment requires:");
        stringBuilder.append(n6);
        stringBuilder.append(" complete pages");
        logger.config(stringBuilder.toString());
        int n7 = 26;
        int n8 = 0;
        if (n6 > 0) {
            n4 = 0;
            for (int i2 = 0; i2 < n6; ++i2) {
                byte[] arrby = this.createSegments(65025, false);
                ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)(65025 + (27 + arrby.length)));
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
                byteBuffer2.put(oggPageHeader.getRawHeaderData(), 0, n7);
                byteBuffer2.put((byte)arrby.length);
                int n9 = arrby.length;
                for (int i3 = 0; i3 < n9; ++i3) {
                    byteBuffer2.put(arrby[i3]);
                }
                ByteBuffer byteBuffer3 = byteBuffer.slice();
                byteBuffer3.limit(65025);
                byteBuffer2.put(byteBuffer3);
                byteBuffer2.putInt(18, n5);
                ++n5;
                if (i2 != 0) {
                    byteBuffer2.put(5, OggPageHeader.HeaderTypeFlag.CONTINUED_PACKET.getFileValue());
                }
                this.calculateChecksumOverPage(byteBuffer2);
                randomAccessFile2.getChannel().write(byteBuffer2);
                byteBuffer.position(n4 += 65025);
                n7 = 26;
            }
            n3 = n5;
        } else {
            n3 = n5;
            n4 = 0;
        }
        int n10 = n2 % 65025;
        Logger logger2 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Last comment packet size:");
        stringBuilder2.append(n10);
        logger2.fine(stringBuilder2.toString());
        if (!this.isCommentAndSetupHeaderFitsOnASinglePage(n10, oggVorbisHeaderSizes.getSetupHeaderSize(), oggVorbisHeaderSizes.getExtraPacketList())) {
            OggVorbisTagWriter.logger.fine("WriteOgg Type 3");
            byte[] arrby = this.createSegments(n10, true);
            ByteBuffer byteBuffer4 = ByteBuffer.allocate((int)(n10 + (27 + arrby.length)));
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer4.put(oggPageHeader.getRawHeaderData(), 0, 26);
            byteBuffer4.put((byte)arrby.length);
            int n11 = arrby.length;
            for (int i4 = 0; i4 < n11; ++i4) {
                byteBuffer4.put(arrby[i4]);
            }
            byteBuffer.position(n4);
            byteBuffer4.put(byteBuffer.slice());
            byteBuffer4.putInt(18, n3);
            if (n6 > 0) {
                byteBuffer4.put(5, OggPageHeader.HeaderTypeFlag.CONTINUED_PACKET.getFileValue());
            }
            Logger logger3 = OggVorbisTagWriter.logger;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Writing Last Comment Page ");
            stringBuilder3.append(n3);
            stringBuilder3.append(" to file");
            logger3.fine(stringBuilder3.toString());
            ++n3;
            this.calculateChecksumOverPage(byteBuffer4);
            randomAccessFile2.getChannel().write(byteBuffer4);
            byte[] arrby2 = this.createSegmentTable(oggVorbisHeaderSizes.getSetupHeaderSize(), oggVorbisHeaderSizes.getExtraPacketList());
            int n12 = 27 + arrby2.length;
            byte[] arrby3 = this.reader.convertToVorbisSetupHeaderPacketAndAdditionalPackets(oggVorbisHeaderSizes.getSetupHeaderStartPosition(), randomAccessFile);
            ByteBuffer byteBuffer5 = ByteBuffer.allocate((int)(n12 + arrby3.length));
            byteBuffer5.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer5.put(oggPageHeader.getRawHeaderData(), 0, 26);
            byteBuffer5.put((byte)arrby2.length);
            int n13 = arrby2.length;
            while (n8 < n13) {
                byteBuffer5.put(arrby2[n8]);
                ++n8;
            }
            byteBuffer5.put(arrby3);
            byteBuffer5.putInt(18, n3);
            Logger logger4 = OggVorbisTagWriter.logger;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Writing Setup Header and packets Page ");
            stringBuilder4.append(n3);
            stringBuilder4.append(" to file");
            logger4.fine(stringBuilder4.toString());
            this.calculateChecksumOverPage(byteBuffer5);
            randomAccessFile2.getChannel().write(byteBuffer5);
        } else {
            OggVorbisTagWriter.logger.fine("WriteOgg Type 4");
            int n14 = n10 + oggVorbisHeaderSizes.getSetupHeaderSize() + oggVorbisHeaderSizes.getExtraPacketDataSize();
            byteBuffer.position(n4);
            ByteBuffer byteBuffer6 = this.startCreateBasicSecondPage(oggVorbisHeaderSizes, n10, n14, oggPageHeader, byteBuffer.slice());
            randomAccessFile.seek(oggVorbisHeaderSizes.getSetupHeaderStartPosition());
            byteBuffer6.put(this.reader.convertToVorbisSetupHeaderPacketAndAdditionalPackets(oggVorbisHeaderSizes.getSetupHeaderStartPosition(), randomAccessFile));
            byteBuffer6.putInt(18, n3);
            byteBuffer6.put(5, OggPageHeader.HeaderTypeFlag.CONTINUED_PACKET.getFileValue());
            this.calculateChecksumOverPage(byteBuffer6);
            randomAccessFile2.getChannel().write(byteBuffer6);
        }
        this.writeRemainingPages(n3, randomAccessFile, randomAccessFile2);
    }

    private void replaceSecondPageAndRenumberPageSeqs(OggVorbisTagReader.OggVorbisHeaderSizes oggVorbisHeaderSizes, int n2, int n3, OggPageHeader oggPageHeader, ByteBuffer byteBuffer, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws IOException, CannotReadException, CannotWriteException {
        logger.fine("WriteOgg Type 2");
        ByteBuffer byteBuffer2 = this.startCreateBasicSecondPage(oggVorbisHeaderSizes, n2, n3, oggPageHeader, byteBuffer);
        int n4 = oggPageHeader.getPageSequence();
        byte[] arrby = this.reader.convertToVorbisSetupHeaderPacketAndAdditionalPackets(oggVorbisHeaderSizes.getSetupHeaderStartPosition(), randomAccessFile);
        Logger logger = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arrby.length);
        stringBuilder.append(":");
        stringBuilder.append(byteBuffer2.position());
        stringBuilder.append(":");
        stringBuilder.append(byteBuffer2.capacity());
        logger.finest(stringBuilder.toString());
        byteBuffer2.put(arrby);
        this.calculateChecksumOverPage(byteBuffer2);
        randomAccessFile2.getChannel().write(byteBuffer2);
        this.writeRemainingPages(n4, randomAccessFile, randomAccessFile2);
    }

    private void replaceSecondPageOnly(OggVorbisTagReader.OggVorbisHeaderSizes oggVorbisHeaderSizes, int n2, int n3, OggPageHeader oggPageHeader, ByteBuffer byteBuffer, long l2, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws IOException {
        logger.fine("WriteOgg Type 1");
        ByteBuffer byteBuffer2 = this.startCreateBasicSecondPage(oggVorbisHeaderSizes, n2, n3, oggPageHeader, byteBuffer);
        randomAccessFile.seek(l2);
        randomAccessFile.skipBytes(oggVorbisHeaderSizes.getCommentHeaderSize());
        randomAccessFile.getChannel().read(byteBuffer2);
        this.calculateChecksumOverPage(byteBuffer2);
        randomAccessFile2.getChannel().write(byteBuffer2);
        randomAccessFile2.getChannel().transferFrom((ReadableByteChannel)randomAccessFile.getChannel(), randomAccessFile2.getFilePointer(), randomAccessFile.length() - randomAccessFile.getFilePointer());
    }

    private ByteBuffer startCreateBasicSecondPage(OggVorbisTagReader.OggVorbisHeaderSizes oggVorbisHeaderSizes, int n2, int n3, OggPageHeader oggPageHeader, ByteBuffer byteBuffer) throws IOException {
        logger.fine("WriteOgg Type 1");
        byte[] arrby = this.createSegmentTable(n2, oggVorbisHeaderSizes.getSetupHeaderSize(), oggVorbisHeaderSizes.getExtraPacketList());
        int n4 = 27 + arrby.length;
        Logger logger = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("New second page header length:");
        stringBuilder.append(n4);
        logger.fine(stringBuilder.toString());
        Logger logger2 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("No of segments:");
        stringBuilder2.append(arrby.length);
        logger2.fine(stringBuilder2.toString());
        ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)(n3 + n4));
        byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        byte[] arrby2 = oggPageHeader.getRawHeaderData();
        byteBuffer2.put(arrby2, 0, 26);
        byteBuffer2.put((byte)arrby.length);
        int n5 = arrby.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            byteBuffer2.put(arrby[i2]);
        }
        byteBuffer2.put(byteBuffer);
        return byteBuffer2;
    }

    public void delete(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws IOException, CannotReadException, CannotWriteException {
        try {
            this.reader.read(randomAccessFile);
        }
        catch (CannotReadException cannotReadException) {
            this.write((Tag)VorbisCommentTag.createNewTag(), randomAccessFile, randomAccessFile2);
            return;
        }
        VorbisCommentTag vorbisCommentTag = VorbisCommentTag.createNewTag();
        randomAccessFile.seek(0L);
        this.write((Tag)vorbisCommentTag, randomAccessFile, randomAccessFile2);
    }

    public void write(Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotReadException, CannotWriteException, IOException {
        logger.config("Starting to write file:");
        logger.fine("Read 1st Page:identificationHeader:");
        OggPageHeader oggPageHeader = OggPageHeader.read(randomAccessFile);
        randomAccessFile.seek(oggPageHeader.getStartByte());
        randomAccessFile2.getChannel().transferFrom((ReadableByteChannel)randomAccessFile.getChannel(), 0L, (long)(27 + oggPageHeader.getPageLength() + oggPageHeader.getSegmentTable().length));
        randomAccessFile2.skipBytes(27 + oggPageHeader.getPageLength() + oggPageHeader.getSegmentTable().length);
        logger.fine("Written identificationHeader:");
        OggPageHeader oggPageHeader2 = OggPageHeader.read(randomAccessFile);
        long l2 = randomAccessFile.getFilePointer();
        Logger logger = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Read 2nd Page:comment and setup and possibly audio:Header finishes at file position:");
        stringBuilder.append(l2);
        logger.fine(stringBuilder.toString());
        randomAccessFile.seek(0L);
        OggVorbisTagReader.OggVorbisHeaderSizes oggVorbisHeaderSizes = this.reader.readOggVorbisHeaderSizes(randomAccessFile);
        ByteBuffer byteBuffer = this.tc.convert(tag);
        int n2 = byteBuffer.capacity();
        int n3 = n2 + oggVorbisHeaderSizes.getSetupHeaderSize() + oggVorbisHeaderSizes.getExtraPacketDataSize();
        Logger logger2 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Old 2nd Page no of packets: ");
        stringBuilder2.append(oggPageHeader2.getPacketList().size());
        logger2.fine(stringBuilder2.toString());
        Logger logger3 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Old 2nd Page size: ");
        stringBuilder3.append(oggPageHeader2.getPageLength());
        logger3.fine(stringBuilder3.toString());
        Logger logger4 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("Old last packet incomplete: ");
        stringBuilder4.append(oggPageHeader2.isLastPacketIncomplete());
        logger4.fine(stringBuilder4.toString());
        Logger logger5 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("Setup Header Size: ");
        stringBuilder5.append(oggVorbisHeaderSizes.getSetupHeaderSize());
        logger5.fine(stringBuilder5.toString());
        Logger logger6 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append("Extra Packets: ");
        stringBuilder6.append(oggVorbisHeaderSizes.getExtraPacketList().size());
        logger6.fine(stringBuilder6.toString());
        Logger logger7 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append("Extra Packet Data Size: ");
        stringBuilder7.append(oggVorbisHeaderSizes.getExtraPacketDataSize());
        logger7.fine(stringBuilder7.toString());
        Logger logger8 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder8 = new StringBuilder();
        stringBuilder8.append("Old comment: ");
        stringBuilder8.append(oggVorbisHeaderSizes.getCommentHeaderSize());
        logger8.fine(stringBuilder8.toString());
        Logger logger9 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder9 = new StringBuilder();
        stringBuilder9.append("New comment: ");
        stringBuilder9.append(n2);
        logger9.fine(stringBuilder9.toString());
        Logger logger10 = OggVorbisTagWriter.logger;
        StringBuilder stringBuilder10 = new StringBuilder();
        stringBuilder10.append("New Page Data Size: ");
        stringBuilder10.append(n3);
        logger10.fine(stringBuilder10.toString());
        if (this.isCommentAndSetupHeaderFitsOnASinglePage(n2, oggVorbisHeaderSizes.getSetupHeaderSize(), oggVorbisHeaderSizes.getExtraPacketList())) {
            if (oggPageHeader2.getPageLength() < 65025 && (oggPageHeader2.getPacketList().size() == 2 && !oggPageHeader2.isLastPacketIncomplete() || oggPageHeader2.getPacketList().size() > 2)) {
                OggVorbisTagWriter.logger.fine("Header and Setup remain on single page:");
                this.replaceSecondPageOnly(oggVorbisHeaderSizes, n2, n3, oggPageHeader2, byteBuffer, l2, randomAccessFile, randomAccessFile2);
                return;
            }
            OggVorbisTagWriter.logger.fine("Header and Setup now on single page:");
            this.replaceSecondPageAndRenumberPageSeqs(oggVorbisHeaderSizes, n2, n3, oggPageHeader2, byteBuffer, randomAccessFile, randomAccessFile2);
            return;
        }
        OggVorbisTagWriter.logger.fine("Header and Setup with shift audio:");
        this.replacePagesAndRenumberPageSeqs(oggVorbisHeaderSizes, n2, oggPageHeader2, byteBuffer, randomAccessFile, randomAccessFile2);
    }

    public void writeRemainingPages(int n2, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws IOException, CannotReadException, CannotWriteException {
        long l2;
        long l3;
        long l4;
        ByteBuffer byteBuffer;
        block5 : {
            l3 = randomAccessFile.getFilePointer();
            l4 = randomAccessFile2.getFilePointer();
            ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)((int)(randomAccessFile.length() - randomAccessFile.getFilePointer())));
            byteBuffer = ByteBuffer.allocate((int)((int)(randomAccessFile.length() - randomAccessFile.getFilePointer())));
            randomAccessFile.getChannel().read(byteBuffer2);
            byteBuffer2.rewind();
            while (byteBuffer2.hasRemaining()) {
                OggPageHeader oggPageHeader;
                try {
                    oggPageHeader = OggPageHeader.read(byteBuffer2);
                }
                catch (CannotReadException cannotReadException) {
                    byteBuffer2.position(byteBuffer2.position() - OggPageHeader.CAPTURE_PATTERN.length);
                    if (Utils.readThreeBytesAsChars(byteBuffer2).equals((Object)"TAG")) {
                        l2 = 3 + byteBuffer2.remaining();
                        break block5;
                    }
                    throw cannotReadException;
                }
                ByteBuffer byteBuffer3 = ByteBuffer.allocate((int)(oggPageHeader.getRawHeaderData().length + oggPageHeader.getPageLength()));
                byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
                byteBuffer3.put(oggPageHeader.getRawHeaderData());
                ByteBuffer byteBuffer4 = byteBuffer2.slice();
                byteBuffer4.limit(oggPageHeader.getPageLength());
                byteBuffer3.put(byteBuffer4);
                byteBuffer3.putInt(18, ++n2);
                this.calculateChecksumOverPage(byteBuffer3);
                byteBuffer2.position(byteBuffer2.position() + oggPageHeader.getPageLength());
                byteBuffer3.rewind();
                byteBuffer.put(byteBuffer3);
            }
            l2 = 0L;
        }
        byteBuffer.flip();
        randomAccessFile2.getChannel().write(byteBuffer);
        if (randomAccessFile.length() - l3 == l2 + randomAccessFile2.length() - l4) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File written counts don't match, file not written:origAudioLength:");
        stringBuilder.append(randomAccessFile.length() - l3);
        stringBuilder.append(":newAudioLength:");
        stringBuilder.append(l2 + randomAccessFile2.length() - l4);
        stringBuilder.append(":bytesDiscarded:");
        stringBuilder.append(l2);
        throw new CannotWriteException(stringBuilder.toString());
    }
}

