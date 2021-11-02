/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.ogg;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.AudioFileReader;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.ogg.OggVorbisTagReader;
import org.jaudiotagger.audio.ogg.util.OggInfoReader;
import org.jaudiotagger.audio.ogg.util.OggPageHeader;
import org.jaudiotagger.tag.Tag;

public class OggFileReader
extends AudioFileReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.ogg");
    private OggInfoReader ir = new OggInfoReader();
    private OggVorbisTagReader vtr = new OggVorbisTagReader();

    @Override
    protected GenericAudioHeader getEncodingInfo(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        return this.ir.read(randomAccessFile);
    }

    @Override
    protected Tag getTag(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        return this.vtr.read(randomAccessFile);
    }

    public OggPageHeader readOggPageHeader(RandomAccessFile randomAccessFile, int n2) throws CannotReadException, IOException {
        OggPageHeader oggPageHeader = OggPageHeader.read(randomAccessFile);
        while (n2 > 0) {
            randomAccessFile.seek(randomAccessFile.getFilePointer() + (long)oggPageHeader.getPageLength());
            oggPageHeader = OggPageHeader.read(randomAccessFile);
            --n2;
        }
        return oggPageHeader;
    }

    public void shortSummarizeOggPageHeaders(File file) throws CannotReadException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        int n2 = 0;
        while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("pageHeader starts at absolute file position:");
            stringBuilder.append(randomAccessFile.getFilePointer());
            printStream.println(stringBuilder.toString());
            OggPageHeader oggPageHeader = OggPageHeader.read(randomAccessFile);
            PrintStream printStream2 = System.out;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("pageHeader finishes at absolute file position:");
            stringBuilder2.append(randomAccessFile.getFilePointer());
            printStream2.println(stringBuilder2.toString());
            PrintStream printStream3 = System.out;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append((Object)oggPageHeader);
            stringBuilder3.append("\n");
            printStream3.println(stringBuilder3.toString());
            randomAccessFile.seek(randomAccessFile.getFilePointer() + (long)oggPageHeader.getPageLength());
            if (++n2 < 5) continue;
        }
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Raf File Pointer at:");
        stringBuilder.append(randomAccessFile.getFilePointer());
        stringBuilder.append("File Size is:");
        stringBuilder.append(randomAccessFile.length());
        printStream.println(stringBuilder.toString());
        randomAccessFile.close();
    }

    public void summarizeOggPageHeaders(File file) throws CannotReadException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("pageHeader starts at absolute file position:");
            stringBuilder.append(randomAccessFile.getFilePointer());
            printStream.println(stringBuilder.toString());
            OggPageHeader oggPageHeader = OggPageHeader.read(randomAccessFile);
            PrintStream printStream2 = System.out;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("pageHeader finishes at absolute file position:");
            stringBuilder2.append(randomAccessFile.getFilePointer());
            printStream2.println(stringBuilder2.toString());
            PrintStream printStream3 = System.out;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append((Object)oggPageHeader);
            stringBuilder3.append("\n");
            printStream3.println(stringBuilder3.toString());
            randomAccessFile.seek(randomAccessFile.getFilePointer() + (long)oggPageHeader.getPageLength());
        }
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Raf File Pointer at:");
        stringBuilder.append(randomAccessFile.getFilePointer());
        stringBuilder.append("File Size is:");
        stringBuilder.append(randomAccessFile.length());
        printStream.println(stringBuilder.toString());
        randomAccessFile.close();
    }
}

