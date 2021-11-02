/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 */
package org.jaudiotagger.audio.wav;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.IffHeaderChunk;

public class WavRIFFHeader {
    public static final String RIFF_SIGNATURE = "RIFF";
    public static final String WAVE_SIGNATURE = "WAVE";

    public static boolean isValidHeader(FileChannel fileChannel) throws IOException, CannotReadException {
        int n2;
        long l2 = fileChannel.size() - fileChannel.position();
        if (l2 >= (long)(n2 = IffHeaderChunk.HEADER_LENGTH)) {
            ByteBuffer byteBuffer = Utils.readFileDataIntoBufferLE(fileChannel, n2);
            if (Utils.readFourBytesAsChars(byteBuffer).equals((Object)RIFF_SIGNATURE)) {
                byteBuffer.getInt();
                if (Utils.readFourBytesAsChars(byteBuffer).equals((Object)WAVE_SIGNATURE)) {
                    return true;
                }
            }
            return false;
        }
        throw new CannotReadException("This is not a WAV File (<12 bytes)");
    }
}

