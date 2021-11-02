/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.BufferUnderflowException
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.FieldDataInvalidException
 *  org.jaudiotagger.tag.wav.WavInfoTag
 *  org.jaudiotagger.tag.wav.WavTag
 */
package org.jaudiotagger.audio.wav.chunk;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.IffHeaderChunk;
import org.jaudiotagger.audio.wav.chunk.WavInfoIdentifier;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.wav.WavInfoTag;
import org.jaudiotagger.tag.wav.WavTag;

public class WavInfoChunk {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.wav.WavInfoChunk");
    private String loggingName;
    private WavInfoTag wavInfoTag;

    public WavInfoChunk(WavTag wavTag, String string2) {
        WavInfoTag wavInfoTag;
        this.loggingName = string2;
        this.wavInfoTag = wavInfoTag = new WavInfoTag();
        wavTag.setInfoTag(wavInfoTag);
    }

    private static boolean isAlphabetic(int n2) {
        return (1 & 1086 >> Character.getType((int)n2)) != 0;
    }

    public boolean readChunks(ByteBuffer byteBuffer) {
        while (byteBuffer.remaining() >= IffHeaderChunk.TYPE_LENGTH) {
            String string2 = Utils.readFourBytesAsChars(byteBuffer);
            if (string2.trim().isEmpty()) {
                return true;
            }
            int n2 = byteBuffer.getInt();
            if (WavInfoChunk.isAlphabetic(string2.charAt(0)) && WavInfoChunk.isAlphabetic(string2.charAt(1)) && WavInfoChunk.isAlphabetic(string2.charAt(2)) && WavInfoChunk.isAlphabetic(string2.charAt(3))) {
                String string3;
                Logger logger;
                try {
                    string3 = Utils.getString(byteBuffer, 0, n2, StandardCharsets.UTF_8);
                    logger = WavInfoChunk.logger;
                }
                catch (BufferUnderflowException bufferUnderflowException) {
                    Logger logger2 = WavInfoChunk.logger;
                    Level level = Level.SEVERE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.loggingName);
                    stringBuilder.append("LISTINFO appears corrupt, ignoring:");
                    stringBuilder.append(bufferUnderflowException.getMessage());
                    logger2.log(level, stringBuilder.toString(), (Throwable)bufferUnderflowException);
                    return false;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.loggingName);
                stringBuilder.append("Result:");
                stringBuilder.append(string2);
                stringBuilder.append(":");
                stringBuilder.append(n2);
                stringBuilder.append(":");
                stringBuilder.append(string3);
                stringBuilder.append(":");
                logger.config(stringBuilder.toString());
                WavInfoIdentifier wavInfoIdentifier = WavInfoIdentifier.getByCode(string2);
                if (wavInfoIdentifier != null && wavInfoIdentifier.getFieldKey() != null) {
                    try {
                        this.wavInfoTag.setField(wavInfoIdentifier.getFieldKey(), new String[]{string3});
                    }
                    catch (FieldDataInvalidException fieldDataInvalidException) {
                        Logger logger3 = WavInfoChunk.logger;
                        Level level = Level.SEVERE;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(this.loggingName);
                        stringBuilder2.append(fieldDataInvalidException.getMessage());
                        logger3.log(level, stringBuilder2.toString(), (Throwable)fieldDataInvalidException);
                    }
                } else if (!string2.trim().isEmpty()) {
                    this.wavInfoTag.addUnRecognizedField(string2, string3);
                }
                if (!Utils.isOddLength(n2) || !byteBuffer.hasRemaining()) continue;
                byteBuffer.get();
                continue;
            }
            Logger logger = WavInfoChunk.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.loggingName);
            stringBuilder.append("LISTINFO appears corrupt, ignoring:");
            stringBuilder.append(string2);
            stringBuilder.append(":");
            stringBuilder.append(n2);
            logger.severe(stringBuilder.toString());
            return false;
        }
        return true;
    }
}

