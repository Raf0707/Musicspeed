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
 *  org.jaudiotagger.audio.aiff.AiffAudioHeader
 */
package org.jaudiotagger.audio.aiff;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;
import org.jaudiotagger.audio.aiff.AiffAudioHeader;
import org.jaudiotagger.audio.aiff.AiffType;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.IffHeaderChunk;
import org.jaudiotagger.logging.Hex;

public class AiffFileHeader {
    private static final String FORM = "FORM";
    private static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.aiff.AudioFileHeader");

    private void readFileType(ByteBuffer byteBuffer, AiffAudioHeader aiffAudioHeader) throws IOException, CannotReadException {
        String string2 = Utils.readFourBytesAsChars(byteBuffer);
        AiffType aiffType = AiffType.AIFF;
        if (aiffType.getCode().equals((Object)string2)) {
            aiffAudioHeader.setFileType(aiffType);
            return;
        }
        AiffType aiffType2 = AiffType.AIFC;
        if (aiffType2.getCode().equals((Object)string2)) {
            aiffAudioHeader.setFileType(aiffType2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid AIFF file: Incorrect file type info ");
        stringBuilder.append(string2);
        throw new CannotReadException(stringBuilder.toString());
    }

    public long readHeader(FileChannel fileChannel, AiffAudioHeader aiffAudioHeader, String string2) throws IOException, CannotReadException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)IffHeaderChunk.HEADER_LENGTH);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        int n2 = fileChannel.read(byteBuffer);
        byteBuffer.position(0);
        if (n2 >= IffHeaderChunk.HEADER_LENGTH) {
            String string3 = Utils.readFourBytesAsChars(byteBuffer);
            if (FORM.equals((Object)string3)) {
                long l2 = byteBuffer.getInt();
                Logger logger = AiffFileHeader.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(" Reading AIFF header size:");
                stringBuilder.append(Hex.asDecAndHex(l2));
                logger.severe(stringBuilder.toString());
                this.readFileType(byteBuffer, aiffAudioHeader);
                return l2 - (long)IffHeaderChunk.TYPE_LENGTH;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("Not an AIFF file: incorrect signature ");
            stringBuilder.append(string3);
            throw new CannotReadException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" AIFF:Unable to read required number of databytes read:");
        stringBuilder.append(n2);
        stringBuilder.append(":required:");
        stringBuilder.append(IffHeaderChunk.HEADER_LENGTH);
        throw new IOException(stringBuilder.toString());
    }
}

