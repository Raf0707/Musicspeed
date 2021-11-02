/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.generic.GenericAudioHeader
 *  org.jaudiotagger.audio.ogg.util.VorbisIdentificationHeader
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 */
package org.jaudiotagger.audio.ogg.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.ogg.util.OggPageHeader;
import org.jaudiotagger.audio.ogg.util.VorbisIdentificationHeader;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

public class OggInfoReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.ogg.atom");

    private int computeBitrate(int n2, long l2) {
        if (n2 == 0) {
            n2 = 1;
        }
        return (int)(l2 / (long)Utils.KILOBYTE_MULTIPLIER * (long)Utils.BITS_IN_BYTE_MULTIPLIER / (long)n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public GenericAudioHeader read(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        double d2;
        GenericAudioHeader genericAudioHeader;
        block10 : {
            long l2 = randomAccessFile.getFilePointer();
            genericAudioHeader = new GenericAudioHeader();
            logger.fine("Started");
            byte[] arrby = OggPageHeader.CAPTURE_PATTERN;
            byte[] arrby2 = new byte[arrby.length];
            randomAccessFile.read(arrby2);
            if (!Arrays.equals((byte[])arrby2, (byte[])arrby)) {
                randomAccessFile.seek(0L);
                if (AbstractID3v2Tag.isId3Tag((RandomAccessFile)randomAccessFile)) {
                    randomAccessFile.read(arrby2);
                    if (Arrays.equals((byte[])arrby2, (byte[])arrby)) {
                        l2 = randomAccessFile.getFilePointer();
                    }
                } else {
                    ErrorMessage errorMessage = ErrorMessage.OGG_HEADER_CANNOT_BE_FOUND;
                    Object[] arrobject = new Object[]{new String(arrby2)};
                    throw new CannotReadException(errorMessage.getMsg(arrobject));
                }
            }
            randomAccessFile.seek(l2);
            randomAccessFile.seek(randomAccessFile.length() - 2L);
            while (randomAccessFile.getFilePointer() >= 4L) {
                byte[] arrby3;
                int n2 = randomAccessFile.read();
                if (n2 == (arrby3 = OggPageHeader.CAPTURE_PATTERN)[3]) {
                    randomAccessFile.seek(randomAccessFile.getFilePointer() - 4L);
                    byte[] arrby4 = new byte[3];
                    randomAccessFile.readFully(arrby4);
                    if (arrby4[0] == arrby3[0] && arrby4[1] == arrby3[1] && arrby4[2] == arrby3[2]) {
                        randomAccessFile.seek(randomAccessFile.getFilePointer() - 3L);
                        long l3 = randomAccessFile.getFilePointer();
                        randomAccessFile.seek(26L + randomAccessFile.getFilePointer());
                        int n3 = 255 & randomAccessFile.readByte();
                        randomAccessFile.seek(l3);
                        byte[] arrby5 = new byte[n3 + 27];
                        randomAccessFile.readFully(arrby5);
                        OggPageHeader oggPageHeader = new OggPageHeader(arrby5);
                        randomAccessFile.seek(0L);
                        d2 = oggPageHeader.getAbsoluteGranulePosition();
                        break block10;
                    }
                }
                randomAccessFile.seek(randomAccessFile.getFilePointer() - 2L);
            }
            d2 = -1.0;
        }
        if (d2 == -1.0) throw new CannotReadException(ErrorMessage.OGG_VORBIS_NO_SETUP_BLOCK.getMsg());
        int n4 = OggPageHeader.read(randomAccessFile).getPageLength();
        byte[] arrby = new byte[n4];
        if (n4 < 27) throw new CannotReadException("Invalid Identification header for this Ogg File");
        randomAccessFile.read(arrby);
        VorbisIdentificationHeader vorbisIdentificationHeader = new VorbisIdentificationHeader(arrby);
        genericAudioHeader.setPreciseLength((double)((float)(d2 / (double)vorbisIdentificationHeader.getSamplingRate())));
        genericAudioHeader.setChannelNumber(vorbisIdentificationHeader.getChannelNumber());
        genericAudioHeader.setSamplingRate(vorbisIdentificationHeader.getSamplingRate());
        genericAudioHeader.setEncodingType(vorbisIdentificationHeader.getEncodingType());
        genericAudioHeader.setBitsPerSample(16);
        if (vorbisIdentificationHeader.getNominalBitrate() != 0 && vorbisIdentificationHeader.getMaxBitrate() == vorbisIdentificationHeader.getNominalBitrate() && vorbisIdentificationHeader.getMinBitrate() == vorbisIdentificationHeader.getNominalBitrate()) {
            genericAudioHeader.setBitRate(vorbisIdentificationHeader.getNominalBitrate() / 1000);
            genericAudioHeader.setVariableBitRate(false);
            do {
                return genericAudioHeader;
                break;
            } while (true);
        }
        if (vorbisIdentificationHeader.getNominalBitrate() != 0 && vorbisIdentificationHeader.getMaxBitrate() == 0 && vorbisIdentificationHeader.getMinBitrate() == 0) {
            genericAudioHeader.setBitRate(vorbisIdentificationHeader.getNominalBitrate() / 1000);
            genericAudioHeader.setVariableBitRate(true);
            return genericAudioHeader;
        }
        genericAudioHeader.setBitRate(this.computeBitrate(genericAudioHeader.getTrackLength(), randomAccessFile.length()));
        genericAudioHeader.setVariableBitRate(true);
        return genericAudioHeader;
    }
}

