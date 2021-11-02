/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  java.util.zip.DataFormatException
 *  java.util.zip.Inflater
 *  org.jaudiotagger.tag.InvalidFrameException
 */
package org.jaudiotagger.tag.id3;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.InvalidFrameException;

public class ID3Compression {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.id3");

    protected static ByteBuffer uncompress(String string2, String string3, ByteBuffer byteBuffer, int n2, int n3) throws InvalidFrameException {
        Logger logger = ID3Compression.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(":About to decompress ");
        stringBuilder.append(n3);
        stringBuilder.append(" bytes, expect result to be:");
        stringBuilder.append(n2);
        stringBuilder.append(" bytes");
        logger.config(stringBuilder.toString());
        byte[] arrby = new byte[n2];
        byte[] arrby2 = new byte[n3];
        int n4 = byteBuffer.position();
        byteBuffer.get(arrby2, 0, n3);
        byteBuffer.position(n4);
        Inflater inflater = new Inflater();
        inflater.setInput(arrby2);
        try {
            int n5 = inflater.inflate(arrby);
            Logger logger2 = ID3Compression.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string3);
            stringBuilder2.append(":Decompressed to ");
            stringBuilder2.append(n5);
            stringBuilder2.append(" bytes");
            logger2.config(stringBuilder2.toString());
        }
        catch (DataFormatException dataFormatException) {
            Logger logger3 = ID3Compression.logger;
            Level level = Level.CONFIG;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Unable to decompress this frame:");
            stringBuilder3.append(string2);
            logger3.log(level, stringBuilder3.toString(), (Throwable)dataFormatException);
            byteBuffer.position(n3 + byteBuffer.position());
            ErrorMessage errorMessage = ErrorMessage.ID3_UNABLE_TO_DECOMPRESS_FRAME;
            Object[] arrobject = new Object[]{string2, string3, dataFormatException.getMessage()};
            throw new InvalidFrameException(errorMessage.getMsg(arrobject));
        }
        inflater.end();
        return ByteBuffer.wrap((byte[])arrby);
    }
}

