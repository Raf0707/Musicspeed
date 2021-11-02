/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.io.RandomAccessFile
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 */
package org.jaudiotagger.audio.mp4.atom;

import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.Mp4AtomIdentifier;
import org.jaudiotagger.audio.mp4.atom.AbstractMp4Box;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.audio.mp4.atom.Mp4MvhdBox;

public class Mp4StcoBox
extends AbstractMp4Box {
    public static final int NO_OF_OFFSETS_LENGTH = 4;
    public static final int NO_OF_OFFSETS_POS = 4;
    public static final int OFFSET_LENGTH = 4;
    public static final int OTHER_FLAG_LENGTH = 3;
    public static final int OTHER_FLAG_POS = 1;
    public static final int VERSION_FLAG_LENGTH = 1;
    public static final int VERSION_FLAG_POS;
    private int firstOffSet;
    private int noOfOffSets = 0;

    public Mp4StcoBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        this.header = mp4BoxHeader;
        this.dataBuffer = byteBuffer2 = byteBuffer.slice();
        byteBuffer2.order(ByteOrder.BIG_ENDIAN);
        ByteBuffer byteBuffer3 = this.dataBuffer;
        byteBuffer3.position(3 + (1 + byteBuffer3.position()));
        this.noOfOffSets = this.dataBuffer.getInt();
        this.firstOffSet = this.dataBuffer.getInt();
    }

    public Mp4StcoBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer, int n2) {
        ByteBuffer byteBuffer2;
        this.header = mp4BoxHeader;
        this.dataBuffer = byteBuffer2 = byteBuffer.slice();
        byteBuffer2.position(3 + (1 + byteBuffer2.position()));
        ByteBuffer byteBuffer3 = this.dataBuffer;
        this.noOfOffSets = Utils.getIntBE(byteBuffer3, byteBuffer3.position(), -1 + (4 + this.dataBuffer.position()));
        ByteBuffer byteBuffer4 = this.dataBuffer;
        byteBuffer4.position(4 + byteBuffer4.position());
        for (int i2 = 0; i2 < this.noOfOffSets; ++i2) {
            ByteBuffer byteBuffer5 = this.dataBuffer;
            int n3 = n2 + Utils.getIntBE(byteBuffer5, byteBuffer5.position(), -1 + (4 + this.dataBuffer.position()));
            this.dataBuffer.put(Utils.getSizeBEInt32(n3));
        }
    }

    public static void debugShowStcoInfo(RandomAccessFile randomAccessFile) throws IOException, CannotReadException {
        Mp4StcoBox.getStco(randomAccessFile).printAllOffsets();
    }

    public static Mp4StcoBox getStco(RandomAccessFile randomAccessFile) throws IOException, CannotReadException {
        FileChannel fileChannel = randomAccessFile.getChannel();
        Mp4BoxHeader mp4BoxHeader = Mp4BoxHeader.seekWithinLevel(fileChannel, Mp4AtomIdentifier.MOOV.getFieldName());
        if (mp4BoxHeader != null) {
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)(-8 + mp4BoxHeader.getLength()));
            fileChannel.read(byteBuffer);
            byteBuffer.rewind();
            Mp4BoxHeader mp4BoxHeader2 = Mp4BoxHeader.seekWithinLevel(byteBuffer, Mp4AtomIdentifier.MVHD.getFieldName());
            if (mp4BoxHeader2 != null) {
                ByteBuffer byteBuffer2 = byteBuffer.slice();
                new Mp4MvhdBox(mp4BoxHeader2, byteBuffer2);
                byteBuffer2.position(byteBuffer2.position() + mp4BoxHeader2.getDataLength());
                Mp4BoxHeader mp4BoxHeader3 = Mp4BoxHeader.seekWithinLevel(byteBuffer2, Mp4AtomIdentifier.TRAK.getFieldName());
                byteBuffer2.position();
                mp4BoxHeader3.getDataLength();
                if (Mp4BoxHeader.seekWithinLevel(byteBuffer2, Mp4AtomIdentifier.MDIA.getFieldName()) != null) {
                    Mp4BoxHeader mp4BoxHeader4 = Mp4BoxHeader.seekWithinLevel(byteBuffer2, Mp4AtomIdentifier.MDHD.getFieldName());
                    if (mp4BoxHeader4 != null) {
                        byteBuffer2.position(byteBuffer2.position() + mp4BoxHeader4.getDataLength());
                        if (Mp4BoxHeader.seekWithinLevel(byteBuffer2, Mp4AtomIdentifier.MINF.getFieldName()) != null) {
                            Mp4BoxHeader mp4BoxHeader5 = Mp4BoxHeader.seekWithinLevel(byteBuffer2, Mp4AtomIdentifier.SMHD.getFieldName());
                            if (mp4BoxHeader5 != null) {
                                byteBuffer2.position(byteBuffer2.position() + mp4BoxHeader5.getDataLength());
                                if (Mp4BoxHeader.seekWithinLevel(byteBuffer2, Mp4AtomIdentifier.STBL.getFieldName()) != null) {
                                    Mp4BoxHeader mp4BoxHeader6 = Mp4BoxHeader.seekWithinLevel(byteBuffer2, Mp4AtomIdentifier.STCO.getFieldName());
                                    if (mp4BoxHeader6 != null) {
                                        return new Mp4StcoBox(mp4BoxHeader6, byteBuffer2);
                                    }
                                    throw new CannotReadException("This file does not appear to be an audio file");
                                }
                                throw new CannotReadException("This file does not appear to be an audio file");
                            }
                            throw new CannotReadException("This file does not appear to be an audio file");
                        }
                        throw new CannotReadException("This file does not appear to be an audio file");
                    }
                    throw new CannotReadException("This file does not appear to be an audio file");
                }
                throw new CannotReadException("This file does not appear to be an audio file");
            }
            throw new CannotReadException("This file does not appear to be an audio file");
        }
        throw new CannotReadException("This file does not appear to be an audio file");
    }

    public void adjustOffsets(int n2) {
        this.dataBuffer.rewind();
        ByteBuffer byteBuffer = this.dataBuffer;
        byteBuffer.position(4 + (3 + (1 + byteBuffer.position())));
        for (int i2 = 0; i2 < this.noOfOffSets; ++i2) {
            int n3 = n2 + this.dataBuffer.getInt();
            ByteBuffer byteBuffer2 = this.dataBuffer;
            byteBuffer2.position(-4 + byteBuffer2.position());
            this.dataBuffer.putInt(n3);
        }
    }

    public int getFirstOffSet() {
        return this.firstOffSet;
    }

    public int getNoOfOffSets() {
        return this.noOfOffSets;
    }

    public void printAllOffsets() {
        System.out.println("Print Offsets:start");
        this.dataBuffer.rewind();
        this.dataBuffer.position(8);
        for (int i2 = 0; i2 < -1 + this.noOfOffSets; ++i2) {
            int n2 = this.dataBuffer.getInt();
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("offset into audio data is:");
            stringBuilder.append(n2);
            printStream.println(stringBuilder.toString());
        }
        int n3 = this.dataBuffer.getInt();
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("offset into audio data is:");
        stringBuilder.append(n3);
        printStream.println(stringBuilder.toString());
        System.out.println("Print Offsets:end");
    }

    public void printTotalOffset() {
        this.dataBuffer.rewind();
        this.dataBuffer.position(8);
        int n2 = 0;
        for (int i2 = 0; i2 < -1 + this.noOfOffSets; ++i2) {
            ByteBuffer byteBuffer = this.dataBuffer;
            n2 += Utils.getIntBE(byteBuffer, byteBuffer.position(), -1 + (4 + this.dataBuffer.position()));
            ByteBuffer byteBuffer2 = this.dataBuffer;
            byteBuffer2.position(4 + byteBuffer2.position());
        }
        ByteBuffer byteBuffer = this.dataBuffer;
        int n3 = n2 + Utils.getIntBE(byteBuffer, byteBuffer.position(), -1 + (4 + this.dataBuffer.position()));
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Print Offset Total:");
        stringBuilder.append(n3);
        printStream.println(stringBuilder.toString());
    }
}

