/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag
 */
package org.jaudiotagger.audio.ogg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.ogg.util.OggPageHeader;
import org.jaudiotagger.audio.ogg.util.VorbisPacketType;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentReader;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;

public class OggVorbisTagReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.ogg");
    private VorbisCommentReader vorbisCommentReader = new VorbisCommentReader();

    private byte[] convertToVorbisCommentPacket(OggPageHeader oggPageHeader, RandomAccessFile randomAccessFile) throws IOException, CannotReadException {
        OggPageHeader oggPageHeader2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[-7 + ((OggPageHeader.PacketStartAndLength)oggPageHeader.getPacketList().get(0)).getLength()];
        randomAccessFile.read(arrby);
        byteArrayOutputStream.write(arrby);
        if (oggPageHeader.getPacketList().size() > 1) {
            logger.config("Comments finish on 2nd Page because there is another packet on this page");
            return byteArrayOutputStream.toByteArray();
        }
        if (!oggPageHeader.isLastPacketIncomplete()) {
            logger.config("Comments finish on 2nd Page because this packet is complete");
            return byteArrayOutputStream.toByteArray();
        }
        do {
            logger.config("Reading next page");
            oggPageHeader2 = OggPageHeader.read(randomAccessFile);
            byte[] arrby2 = new byte[((OggPageHeader.PacketStartAndLength)oggPageHeader2.getPacketList().get(0)).getLength()];
            randomAccessFile.read(arrby2);
            byteArrayOutputStream.write(arrby2);
            if (oggPageHeader2.getPacketList().size() <= 1) continue;
            logger.config("Comments finish on Page because there is another packet on this page");
            return byteArrayOutputStream.toByteArray();
        } while (oggPageHeader2.isLastPacketIncomplete());
        logger.config("Comments finish on Page because this packet is complete");
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] convertToVorbisSetupHeaderPacket(long l2, RandomAccessFile randomAccessFile) throws IOException, CannotReadException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        randomAccessFile.seek(l2);
        OggPageHeader oggPageHeader = OggPageHeader.read(randomAccessFile);
        if (oggPageHeader.getPacketList().size() > 1) {
            randomAccessFile.skipBytes(((OggPageHeader.PacketStartAndLength)oggPageHeader.getPacketList().get(0)).getLength());
        }
        byte[] arrby = new byte[7];
        randomAccessFile.read(arrby);
        if (this.isVorbisSetupHeader(arrby)) {
            randomAccessFile.seek(randomAccessFile.getFilePointer() - 7L);
            if (oggPageHeader.getPacketList().size() > 1) {
                byte[] arrby2 = new byte[((OggPageHeader.PacketStartAndLength)oggPageHeader.getPacketList().get(1)).getLength()];
                randomAccessFile.read(arrby2);
                byteArrayOutputStream.write(arrby2);
            } else {
                byte[] arrby3 = new byte[((OggPageHeader.PacketStartAndLength)oggPageHeader.getPacketList().get(0)).getLength()];
                randomAccessFile.read(arrby3);
                byteArrayOutputStream.write(arrby3);
            }
            if (oggPageHeader.isLastPacketIncomplete() && oggPageHeader.getPacketList().size() <= 2) {
                OggPageHeader oggPageHeader2;
                do {
                    logger.config("Reading another page");
                    oggPageHeader2 = OggPageHeader.read(randomAccessFile);
                    byte[] arrby4 = new byte[((OggPageHeader.PacketStartAndLength)oggPageHeader2.getPacketList().get(0)).getLength()];
                    randomAccessFile.read(arrby4);
                    byteArrayOutputStream.write(arrby4);
                    if (oggPageHeader2.getPacketList().size() <= 1) continue;
                    logger.config("Setupheader finishes on this page");
                    return byteArrayOutputStream.toByteArray();
                } while (oggPageHeader2.isLastPacketIncomplete());
                logger.config("Setupheader finish on Page because this packet is complete");
                return byteArrayOutputStream.toByteArray();
            }
            logger.config("Setupheader finishes on this page");
            return byteArrayOutputStream.toByteArray();
        }
        throw new CannotReadException("Unable to find setup header(2), unable to write ogg file");
    }

    public byte[] convertToVorbisSetupHeaderPacketAndAdditionalPackets(long l2, RandomAccessFile randomAccessFile) throws IOException, CannotReadException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        randomAccessFile.seek(l2);
        OggPageHeader oggPageHeader = OggPageHeader.read(randomAccessFile);
        if (oggPageHeader.getPacketList().size() > 1) {
            randomAccessFile.skipBytes(((OggPageHeader.PacketStartAndLength)oggPageHeader.getPacketList().get(0)).getLength());
        }
        byte[] arrby = new byte[7];
        randomAccessFile.read(arrby);
        if (this.isVorbisSetupHeader(arrby)) {
            int n2;
            randomAccessFile.seek(randomAccessFile.getFilePointer() - 7L);
            if (oggPageHeader.getPacketList().size() > 1) {
                byte[] arrby2 = new byte[((OggPageHeader.PacketStartAndLength)oggPageHeader.getPacketList().get(1)).getLength()];
                randomAccessFile.read(arrby2);
                byteArrayOutputStream.write(arrby2);
            } else {
                byte[] arrby3 = new byte[((OggPageHeader.PacketStartAndLength)oggPageHeader.getPacketList().get(0)).getLength()];
                randomAccessFile.read(arrby3);
                byteArrayOutputStream.write(arrby3);
            }
            boolean bl = oggPageHeader.isLastPacketIncomplete();
            if (bl && oggPageHeader.getPacketList().size() <= n2) {
                OggPageHeader oggPageHeader2;
                do {
                    logger.config("Reading another page");
                    oggPageHeader2 = OggPageHeader.read(randomAccessFile);
                    byte[] arrby4 = new byte[((OggPageHeader.PacketStartAndLength)oggPageHeader2.getPacketList().get(0)).getLength()];
                    randomAccessFile.read(arrby4);
                    byteArrayOutputStream.write(arrby4);
                    if (oggPageHeader2.getPacketList().size() <= 1) continue;
                    logger.config("Setupheader finishes on this page");
                    return byteArrayOutputStream.toByteArray();
                } while (oggPageHeader2.isLastPacketIncomplete());
                logger.config("Setupheader finish on Page because this packet is complete");
                return byteArrayOutputStream.toByteArray();
            }
            logger.config("Setupheader finishes on this page");
            if (oggPageHeader.getPacketList().size() > n2) {
                for (n2 = 2; n2 < oggPageHeader.getPacketList().size(); ++n2) {
                    byte[] arrby5 = new byte[((OggPageHeader.PacketStartAndLength)oggPageHeader.getPacketList().get(n2)).getLength()];
                    randomAccessFile.read(arrby5);
                    byteArrayOutputStream.write(arrby5);
                }
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new CannotReadException("Unable to find setup header(2), unable to write ogg file");
    }

    public boolean isVorbisCommentHeader(byte[] arrby) {
        String string2 = new String(arrby, 1, 6, StandardCharsets.ISO_8859_1);
        return arrby[0] == VorbisPacketType.COMMENT_HEADER.getType() && string2.equals((Object)"vorbis");
    }

    public boolean isVorbisSetupHeader(byte[] arrby) {
        String string2 = new String(arrby, 1, 6, StandardCharsets.ISO_8859_1);
        return arrby[0] == VorbisPacketType.SETUP_HEADER.getType() && string2.equals((Object)"vorbis");
    }

    public Tag read(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        logger.config("Starting to read ogg vorbis tag from file:");
        byte[] arrby = this.readRawPacketData(randomAccessFile);
        VorbisCommentTag vorbisCommentTag = this.vorbisCommentReader.read(arrby, true);
        logger.fine("CompletedReadCommentTag");
        return vorbisCommentTag;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public OggVorbisHeaderSizes readOggVorbisHeaderSizes(RandomAccessFile var1_1) throws CannotReadException, IOException {
        block11 : {
            block10 : {
                block9 : {
                    block8 : {
                        OggVorbisTagReader.logger.fine("Started to read comment and setup header sizes:");
                        var2_2 = var1_1.getFilePointer();
                        var4_3 = new ArrayList();
                        var5_4 = OggPageHeader.read(var1_1);
                        var1_1.seek(var1_1.getFilePointer() + (long)var5_4.getPageLength());
                        var6_5 = OggPageHeader.read(var1_1);
                        var7_6 = var1_1.getFilePointer() - (long)(27 + var6_5.getSegmentTable().length);
                        var9_7 = new byte[7];
                        var1_1.read(var9_7);
                        if (this.isVorbisCommentHeader(var9_7) == false) throw new CannotReadException("Cannot find comment block (no vorbiscomment header)");
                        var1_1.seek(var1_1.getFilePointer() - 7L);
                        var11_8 = OggVorbisTagReader.logger;
                        var12_9 = new StringBuilder();
                        var12_9.append("Found start of comment header at:");
                        var12_9.append(var1_1.getFilePointer());
                        var11_8.config(var12_9.toString());
                        var15_10 = 0;
                        do {
                            var16_11 = var6_5.getPacketList();
                            var15_10 += ((OggPageHeader.PacketStartAndLength)var16_11.get(0)).getLength();
                            var1_1.skipBytes(((OggPageHeader.PacketStartAndLength)var16_11.get(0)).getLength());
                            if (var16_11.size() > 1 || !var6_5.isLastPacketIncomplete()) break;
                            var6_5 = OggPageHeader.read(var1_1);
                        } while (true);
                        var18_12 = OggVorbisTagReader.logger;
                        var19_13 = new StringBuilder();
                        var19_13.append("Found end of comment:size:");
                        var19_13.append(var15_10);
                        var19_13.append("finishes at file position:");
                        var19_13.append(var1_1.getFilePointer());
                        var18_12.config(var19_13.toString());
                        if (var6_5.getPacketList().size() != 1) break block8;
                        var77_14 = OggPageHeader.read(var1_1);
                        var78_15 = var77_14.getPacketList();
                        var79_16 = (OggPageHeader.PacketStartAndLength)var77_14.getPacketList().get(0);
                        var80_17 = new byte[7];
                        var1_1.read(var80_17);
                        if (this.isVorbisSetupHeader(var80_17) == false) throw new CannotReadException(ErrorMessage.OGG_VORBIS_NO_VORBIS_HEADER_FOUND.getMsg());
                        var82_18 = var1_1.getFilePointer();
                        var26_19 = var7_6;
                        var1_1.seek(var82_18 - 7L);
                        var84_20 = OggVorbisTagReader.logger;
                        var85_21 = new StringBuilder();
                        var85_21.append("Found start of vorbis setup header at file position:");
                        var24_22 = var2_2;
                        var85_21.append(var1_1.getFilePointer());
                        var84_20.config(var85_21.toString());
                        var88_23 = var1_1.getFilePointer() - (long)(27 + var77_14.getSegmentTable().length);
                        var90_24 = var79_16.getLength();
                        var91_25 = OggVorbisTagReader.logger;
                        var92_26 = new StringBuilder();
                        var92_26.append("Adding:");
                        var92_26.append(var79_16.getLength());
                        var92_26.append(" to setup header size");
                        var91_25.fine(var92_26.toString());
                        var1_1.skipBytes(var79_16.getLength());
                        if (var78_15.size() <= 1 && var77_14.isLastPacketIncomplete()) break block9;
                        var97_34 = OggVorbisTagReader.logger;
                        var98_35 = new StringBuilder();
                        var98_35.append("Found end of setupheader:size:");
                        var98_35.append(var90_24);
                        var98_35.append("finishes at:");
                        var98_35.append(var1_1.getFilePointer());
                        var97_34.config(var98_35.toString());
                        if (var78_15.size() <= 1) ** GOTO lbl-1000
                        var105_33 = var78_15.subList(1, var78_15.size());
                        ** GOTO lbl134
                    }
                    var24_22 = var2_2;
                    var26_19 = var7_6;
                    var28_42 = (OggPageHeader.PacketStartAndLength)var6_5.getPacketList().get(1);
                    var29_43 = var6_5.getPacketList();
                    var30_44 = new byte[7];
                    var1_1.read(var30_44);
                    if (!this.isVorbisSetupHeader(var30_44)) {
                        var32_61 = OggVorbisTagReader.logger;
                        var33_62 = new StringBuilder();
                        var33_62.append("Expecting but got:");
                        var33_62.append(new String(var30_44));
                        var33_62.append("at ");
                        var33_62.append(var1_1.getFilePointer() - (long)7);
                        var32_61.warning(var33_62.toString());
                        throw new CannotReadException(ErrorMessage.OGG_VORBIS_NO_VORBIS_HEADER_FOUND.getMsg());
                    }
                    var1_1.seek(var1_1.getFilePointer() - 7L);
                    var38_45 = OggVorbisTagReader.logger;
                    var39_46 = new StringBuilder();
                    var39_46.append("Found start of vorbis setup header at file position:");
                    var39_46.append(var1_1.getFilePointer());
                    var38_45.config(var39_46.toString());
                    var42_47 = var1_1.getFilePointer() - (long)(27 + var6_5.getSegmentTable().length) - (long)((OggPageHeader.PacketStartAndLength)var6_5.getPacketList().get(0)).getLength();
                    var44_48 = var28_42.getLength();
                    var45_49 = OggVorbisTagReader.logger;
                    var46_50 = new StringBuilder();
                    var46_50.append("Adding:");
                    var46_50.append(var28_42.getLength());
                    var46_50.append(" to setup header size");
                    var45_49.fine(var46_50.toString());
                    var1_1.skipBytes(var28_42.getLength());
                    if (var29_43.size() <= 2 && var6_5.isLastPacketIncomplete()) break block10;
                    var51_58 = OggVorbisTagReader.logger;
                    var52_59 = new StringBuilder();
                    var52_59.append("Found end of setupheader:size:");
                    var52_59.append(var44_48);
                    var52_59.append("finishes at:");
                    var52_59.append(var1_1.getFilePointer());
                    var51_58.fine(var52_59.toString());
                    if (var29_43.size() <= 2) ** GOTO lbl-1000
                    var62_57 = var29_43.subList(2, var29_43.size());
                    ** GOTO lbl168
                }
                var107_27 = OggPageHeader.read(var1_1);
                var108_28 = var107_27.getPacketList();
                do {
                    var90_24 += ((OggPageHeader.PacketStartAndLength)var108_28.get(0)).getLength();
                    var109_29 = OggVorbisTagReader.logger;
                    var110_30 = new StringBuilder();
                    var110_30.append("Adding:");
                    var110_30.append(((OggPageHeader.PacketStartAndLength)var108_28.get(0)).getLength());
                    var110_30.append(" to setup header size");
                    var109_29.fine(var110_30.toString());
                    var1_1.skipBytes(((OggPageHeader.PacketStartAndLength)var108_28.get(0)).getLength());
                    if (var108_28.size() > 1 || !var107_27.isLastPacketIncomplete()) break;
                    var107_27 = OggPageHeader.read(var1_1);
                } while (true);
                var115_31 = OggVorbisTagReader.logger;
                var116_32 = new StringBuilder();
                var116_32.append("Found end of setupheader:size:");
                var116_32.append(var90_24);
                var116_32.append("finishes at:");
                var116_32.append(var1_1.getFilePointer());
                var115_31.fine(var116_32.toString());
                if (var108_28.size() > 1) {
                    var105_33 = var108_28.subList(1, var108_28.size());
lbl134: // 2 sources:
                    var106_36 = var105_33;
                    var103_37 = var90_24;
                    var104_38 = var106_36;
                } else lbl-1000: // 2 sources:
                {
                    var103_37 = var90_24;
                    var104_38 = var4_3;
                }
                var58_39 = var88_23;
                var60_40 = var104_38;
                var57_41 = var103_37;
                break block11;
            }
            var63_51 = OggPageHeader.read(var1_1);
            var64_52 = var63_51.getPacketList();
            do {
                var44_48 += ((OggPageHeader.PacketStartAndLength)var64_52.get(0)).getLength();
                var65_53 = OggVorbisTagReader.logger;
                var66_54 = new StringBuilder();
                var66_54.append("Adding:");
                var66_54.append(((OggPageHeader.PacketStartAndLength)var64_52.get(0)).getLength());
                var66_54.append(" to setup header size");
                var65_53.fine(var66_54.toString());
                var1_1.skipBytes(((OggPageHeader.PacketStartAndLength)var64_52.get(0)).getLength());
                if (var64_52.size() > 1 || !var63_51.isLastPacketIncomplete()) break;
                var63_51 = OggPageHeader.read(var1_1);
            } while (true);
            var71_55 = OggVorbisTagReader.logger;
            var72_56 = new StringBuilder();
            var72_56.append("Found end of setupheader:size:");
            var72_56.append(var44_48);
            var72_56.append("finishes at:");
            var72_56.append(var1_1.getFilePointer());
            var71_55.fine(var72_56.toString());
            if (var64_52.size() > 1) {
                var62_57 = var64_52.subList(1, var64_52.size());
lbl168: // 2 sources:
                var60_40 = var62_57;
                var57_41 = var44_48;
                var58_39 = var42_47;
            } else lbl-1000: // 2 sources:
            {
                var57_41 = var44_48;
                var58_39 = var42_47;
                var60_40 = var4_3;
            }
        }
        var1_1.seek(var24_22);
        return new OggVorbisHeaderSizes(var26_19, var58_39, var15_10, var57_41, (List<OggPageHeader.PacketStartAndLength>)var60_40);
    }

    public int readOggVorbisRawSize(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        return 6 + (1 + this.readRawPacketData(randomAccessFile).length);
    }

    public byte[] readRawPacketData(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        logger.fine("Read 1st page");
        OggPageHeader oggPageHeader = OggPageHeader.read(randomAccessFile);
        randomAccessFile.seek(randomAccessFile.getFilePointer() + (long)oggPageHeader.getPageLength());
        logger.fine("Read 2nd page");
        OggPageHeader oggPageHeader2 = OggPageHeader.read(randomAccessFile);
        byte[] arrby = new byte[7];
        randomAccessFile.read(arrby);
        if (this.isVorbisCommentHeader(arrby)) {
            return this.convertToVorbisCommentPacket(oggPageHeader2, randomAccessFile);
        }
        throw new CannotReadException("Cannot find comment block (no vorbiscomment header)");
    }

    public static class OggVorbisHeaderSizes {
        private int commentHeaderSize;
        private long commentHeaderStartPosition;
        private List<OggPageHeader.PacketStartAndLength> packetList;
        private int setupHeaderSize;
        private long setupHeaderStartPosition;

        OggVorbisHeaderSizes(long l2, long l3, int n2, int n3, List<OggPageHeader.PacketStartAndLength> list) {
            this.packetList = list;
            this.commentHeaderStartPosition = l2;
            this.setupHeaderStartPosition = l3;
            this.commentHeaderSize = n2;
            this.setupHeaderSize = n3;
        }

        public int getCommentHeaderSize() {
            return this.commentHeaderSize;
        }

        public long getCommentHeaderStartPosition() {
            return this.commentHeaderStartPosition;
        }

        public int getExtraPacketDataSize() {
            Iterator iterator = this.packetList.iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                n2 += ((OggPageHeader.PacketStartAndLength)iterator.next()).getLength();
            }
            return n2;
        }

        public List<OggPageHeader.PacketStartAndLength> getExtraPacketList() {
            return this.packetList;
        }

        public int getSetupHeaderSize() {
            return this.setupHeaderSize;
        }

        public long getSetupHeaderStartPosition() {
            return this.setupHeaderStartPosition;
        }
    }

}

