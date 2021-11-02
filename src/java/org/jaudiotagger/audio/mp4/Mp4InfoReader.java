/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.exceptions.CannotReadVideoException
 *  org.jaudiotagger.audio.generic.GenericAudioHeader
 *  org.jaudiotagger.audio.mp4.Mp4AudioHeader
 *  org.jaudiotagger.audio.mp4.atom.Mp4AlacBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4DrmsBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4EsdsBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4FtypBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4MdhdBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4Mp4aBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4MvhdBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4StcoBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4StsdBox
 */
package org.jaudiotagger.audio.mp4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotReadVideoException;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.mp4.EncoderType;
import org.jaudiotagger.audio.mp4.Mp4AtomIdentifier;
import org.jaudiotagger.audio.mp4.Mp4AtomTree;
import org.jaudiotagger.audio.mp4.Mp4AudioHeader;
import org.jaudiotagger.audio.mp4.atom.Mp4AlacBox;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.audio.mp4.atom.Mp4DrmsBox;
import org.jaudiotagger.audio.mp4.atom.Mp4EsdsBox;
import org.jaudiotagger.audio.mp4.atom.Mp4FtypBox;
import org.jaudiotagger.audio.mp4.atom.Mp4MdhdBox;
import org.jaudiotagger.audio.mp4.atom.Mp4Mp4aBox;
import org.jaudiotagger.audio.mp4.atom.Mp4MvhdBox;
import org.jaudiotagger.audio.mp4.atom.Mp4StcoBox;
import org.jaudiotagger.audio.mp4.atom.Mp4StsdBox;
import org.jaudiotagger.logging.ErrorMessage;

public class Mp4InfoReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.mp4.atom");

    private boolean isTrackAtomVideo(Mp4FtypBox mp4FtypBox, Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) throws IOException {
        if (Mp4BoxHeader.seekWithinLevel(byteBuffer, Mp4AtomIdentifier.MDIA.getFieldName()) == null) {
            return false;
        }
        Mp4BoxHeader mp4BoxHeader2 = Mp4BoxHeader.seekWithinLevel(byteBuffer, Mp4AtomIdentifier.MDHD.getFieldName());
        if (mp4BoxHeader2 == null) {
            return false;
        }
        byteBuffer.position(byteBuffer.position() + mp4BoxHeader2.getDataLength());
        if (Mp4BoxHeader.seekWithinLevel(byteBuffer, Mp4AtomIdentifier.MINF.getFieldName()) == null) {
            return false;
        }
        return Mp4BoxHeader.seekWithinLevel(byteBuffer, Mp4AtomIdentifier.VMHD.getFieldName()) != null;
    }

    public GenericAudioHeader read(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        FileChannel fileChannel = randomAccessFile.getChannel();
        Mp4AudioHeader mp4AudioHeader = new Mp4AudioHeader();
        Mp4BoxHeader mp4BoxHeader = Mp4BoxHeader.seekWithinLevel(fileChannel, Mp4AtomIdentifier.FTYP.getFieldName());
        if (mp4BoxHeader != null) {
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)(-8 + mp4BoxHeader.getLength()));
            fileChannel.read(byteBuffer);
            byteBuffer.rewind();
            Mp4FtypBox mp4FtypBox = new Mp4FtypBox(mp4BoxHeader, byteBuffer);
            mp4FtypBox.processData();
            mp4AudioHeader.setBrand(mp4FtypBox.getMajorBrand());
            Mp4BoxHeader mp4BoxHeader2 = Mp4BoxHeader.seekWithinLevel(fileChannel, Mp4AtomIdentifier.MOOV.getFieldName());
            if (mp4BoxHeader2 != null) {
                ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)(-8 + mp4BoxHeader2.getLength()));
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
                fileChannel.read(byteBuffer2);
                byteBuffer2.rewind();
                Mp4BoxHeader mp4BoxHeader3 = Mp4BoxHeader.seekWithinLevel(byteBuffer2, Mp4AtomIdentifier.MVHD.getFieldName());
                if (mp4BoxHeader3 != null) {
                    ByteBuffer byteBuffer3 = byteBuffer2.slice();
                    mp4AudioHeader.setPreciseLength((double)new Mp4MvhdBox(mp4BoxHeader3, byteBuffer3).getLength());
                    byteBuffer3.position(byteBuffer3.position() + mp4BoxHeader3.getDataLength());
                    Mp4BoxHeader mp4BoxHeader4 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.TRAK.getFieldName());
                    int n2 = byteBuffer3.position() + mp4BoxHeader4.getDataLength();
                    if (Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.MDIA.getFieldName()) != null) {
                        Mp4BoxHeader mp4BoxHeader5 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.MDHD.getFieldName());
                        if (mp4BoxHeader5 != null) {
                            mp4AudioHeader.setSamplingRate(new Mp4MdhdBox(mp4BoxHeader5, byteBuffer3.slice()).getSampleRate());
                            byteBuffer3.position(byteBuffer3.position() + mp4BoxHeader5.getDataLength());
                            if (Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.MINF.getFieldName()) != null) {
                                int n3 = byteBuffer3.position();
                                Mp4BoxHeader mp4BoxHeader6 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.SMHD.getFieldName());
                                if (mp4BoxHeader6 == null) {
                                    byteBuffer3.position(n3);
                                    if (Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.VMHD.getFieldName()) != null) {
                                        throw new CannotReadVideoException(ErrorMessage.MP4_FILE_IS_VIDEO.getMsg());
                                    }
                                    throw new CannotReadException(ErrorMessage.MP4_FILE_NOT_AUDIO.getMsg());
                                }
                                byteBuffer3.position(byteBuffer3.position() + mp4BoxHeader6.getDataLength());
                                if (Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.STBL.getFieldName()) != null) {
                                    Mp4BoxHeader mp4BoxHeader7;
                                    int n4 = byteBuffer3.position();
                                    Mp4BoxHeader mp4BoxHeader8 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.STSD.getFieldName());
                                    if (mp4BoxHeader8 != null) {
                                        new Mp4StsdBox(mp4BoxHeader8, byteBuffer3).processData();
                                        int n5 = byteBuffer3.position();
                                        Mp4BoxHeader mp4BoxHeader9 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.MP4A.getFieldName());
                                        if (mp4BoxHeader9 != null) {
                                            ByteBuffer byteBuffer4 = byteBuffer3.slice();
                                            new Mp4Mp4aBox(mp4BoxHeader9, byteBuffer4).processData();
                                            Mp4BoxHeader mp4BoxHeader10 = Mp4BoxHeader.seekWithinLevel(byteBuffer4, Mp4AtomIdentifier.ESDS.getFieldName());
                                            if (mp4BoxHeader10 != null) {
                                                Mp4EsdsBox mp4EsdsBox = new Mp4EsdsBox(mp4BoxHeader10, byteBuffer4.slice());
                                                mp4AudioHeader.setBitRate(mp4EsdsBox.getAvgBitrate() / 1000);
                                                mp4AudioHeader.setChannelNumber(mp4EsdsBox.getNumberOfChannels());
                                                mp4AudioHeader.setKind(mp4EsdsBox.getKind());
                                                mp4AudioHeader.setProfile(mp4EsdsBox.getAudioProfile());
                                                mp4AudioHeader.setEncodingType(EncoderType.AAC.getDescription());
                                            }
                                        } else {
                                            byteBuffer3.position(n5);
                                            Mp4BoxHeader mp4BoxHeader11 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.DRMS.getFieldName());
                                            if (mp4BoxHeader11 != null) {
                                                new Mp4DrmsBox(mp4BoxHeader11, byteBuffer3).processData();
                                                Mp4BoxHeader mp4BoxHeader12 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.ESDS.getFieldName());
                                                if (mp4BoxHeader12 != null) {
                                                    Mp4EsdsBox mp4EsdsBox = new Mp4EsdsBox(mp4BoxHeader12, byteBuffer3.slice());
                                                    mp4AudioHeader.setBitRate(mp4EsdsBox.getAvgBitrate() / 1000);
                                                    mp4AudioHeader.setChannelNumber(mp4EsdsBox.getNumberOfChannels());
                                                    mp4AudioHeader.setKind(mp4EsdsBox.getKind());
                                                    mp4AudioHeader.setProfile(mp4EsdsBox.getAudioProfile());
                                                    mp4AudioHeader.setEncodingType(EncoderType.DRM_AAC.getDescription());
                                                }
                                            } else {
                                                byteBuffer3.position(n5);
                                                Mp4AtomIdentifier mp4AtomIdentifier = Mp4AtomIdentifier.ALAC;
                                                Mp4BoxHeader mp4BoxHeader13 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, mp4AtomIdentifier.getFieldName());
                                                if (mp4BoxHeader13 != null) {
                                                    new Mp4AlacBox(mp4BoxHeader13, byteBuffer3).processData();
                                                    Mp4BoxHeader mp4BoxHeader14 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, mp4AtomIdentifier.getFieldName());
                                                    if (mp4BoxHeader14 != null) {
                                                        Mp4AlacBox mp4AlacBox = new Mp4AlacBox(mp4BoxHeader14, byteBuffer3);
                                                        mp4AlacBox.processData();
                                                        mp4AudioHeader.setEncodingType(EncoderType.APPLE_LOSSLESS.getDescription());
                                                        mp4AudioHeader.setChannelNumber(mp4AlacBox.getChannels());
                                                        mp4AudioHeader.setBitRate(mp4AlacBox.getBitRate() / 1000);
                                                        mp4AudioHeader.setBitsPerSample(mp4AlacBox.getSampleSize());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    byteBuffer3.position(n4);
                                    Mp4BoxHeader mp4BoxHeader15 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.STCO.getFieldName());
                                    if (mp4BoxHeader15 != null) {
                                        Mp4StcoBox mp4StcoBox = new Mp4StcoBox(mp4BoxHeader15, byteBuffer3);
                                        mp4AudioHeader.setAudioDataStartPosition(Long.valueOf((long)mp4StcoBox.getFirstOffSet()));
                                        mp4AudioHeader.setAudioDataEndPosition(Long.valueOf((long)fileChannel.size()));
                                        mp4AudioHeader.setAudioDataLength(fileChannel.size() - (long)mp4StcoBox.getFirstOffSet());
                                    }
                                    if (mp4AudioHeader.getChannelNumber() == -1) {
                                        mp4AudioHeader.setChannelNumber(2);
                                    }
                                    if (mp4AudioHeader.getBitRateAsNumber() == -1L) {
                                        mp4AudioHeader.setBitRate(128);
                                    }
                                    if (mp4AudioHeader.getBitsPerSample() == -1) {
                                        mp4AudioHeader.setBitsPerSample(16);
                                    }
                                    if (mp4AudioHeader.getEncodingType().equals((Object)"")) {
                                        mp4AudioHeader.setEncodingType(EncoderType.AAC.getDescription());
                                    }
                                    logger.config(mp4AudioHeader.toString());
                                    byteBuffer3.position(n2);
                                    while (byteBuffer3.hasRemaining() && (mp4BoxHeader7 = Mp4BoxHeader.seekWithinLevel(byteBuffer3, Mp4AtomIdentifier.TRAK.getFieldName())) != null) {
                                        if (!this.isTrackAtomVideo(mp4FtypBox, mp4BoxHeader7, byteBuffer3)) continue;
                                        throw new CannotReadVideoException(ErrorMessage.MP4_FILE_IS_VIDEO.getMsg());
                                    }
                                    new Mp4AtomTree(randomAccessFile, false);
                                    return mp4AudioHeader;
                                }
                                throw new CannotReadException(ErrorMessage.MP4_FILE_NOT_AUDIO.getMsg());
                            }
                            throw new CannotReadException(ErrorMessage.MP4_FILE_NOT_AUDIO.getMsg());
                        }
                        throw new CannotReadException(ErrorMessage.MP4_FILE_NOT_AUDIO.getMsg());
                    }
                    throw new CannotReadException(ErrorMessage.MP4_FILE_NOT_AUDIO.getMsg());
                }
                throw new CannotReadException(ErrorMessage.MP4_FILE_NOT_AUDIO.getMsg());
            }
            throw new CannotReadException(ErrorMessage.MP4_FILE_NOT_AUDIO.getMsg());
        }
        throw new CannotReadException(ErrorMessage.MP4_FILE_NOT_CONTAINER.getMsg());
    }
}

