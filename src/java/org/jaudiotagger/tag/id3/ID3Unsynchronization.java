/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ID3Unsynchronization {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.id3");

    public static boolean requiresUnsynchronization(byte[] arrby) {
        for (int i2 = 0; i2 < arrby.length - 1; ++i2) {
            if ((255 & arrby[i2]) != 255 || (224 & arrby[i2 + 1]) != 224) continue;
            if (logger.isLoggable(Level.FINEST)) {
                Logger logger = ID3Unsynchronization.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsynchronisation required found bit at:");
                stringBuilder.append(i2);
                logger.finest(stringBuilder.toString());
            }
            return true;
        }
        return false;
    }

    public static ByteBuffer synchronize(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining();
        byte[] arrby = new byte[n2 + 1];
        byteBuffer.get(arrby, 0, n2);
        int n3 = 0;
        int n4 = 0;
        boolean bl = true;
        while (n3 < n2) {
            int n5 = n3 + 1;
            byte by = arrby[n3];
            if (bl || by != 0) {
                int n6 = n4 + 1;
                arrby[n4] = by;
                n4 = n6;
            }
            bl = (by & 255) != 255;
            n3 = n5;
        }
        return ByteBuffer.wrap((byte[])arrby, (int)0, (int)n4);
    }

    public static byte[] unsynchronize(byte[] arrby) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(arrby.length);
        int n2 = 0;
        while (byteArrayInputStream.available() > 0) {
            int n3 = byteArrayInputStream.read();
            ++n2;
            byteArrayOutputStream.write(n3);
            if ((n3 & 255) != 255 || byteArrayInputStream.available() <= 0) continue;
            byteArrayInputStream.mark(1);
            int n4 = byteArrayInputStream.read();
            if ((n4 & 224) == 224) {
                if (logger.isLoggable(Level.FINEST)) {
                    Logger logger = ID3Unsynchronization.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Writing unsynchronisation bit at:");
                    stringBuilder.append(n2);
                    logger.finest(stringBuilder.toString());
                }
                byteArrayOutputStream.write(0);
            } else if (n4 == 0) {
                if (logger.isLoggable(Level.FINEST)) {
                    Logger logger = ID3Unsynchronization.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Inserting zero unsynchronisation bit at:");
                    stringBuilder.append(n2);
                    logger.finest(stringBuilder.toString());
                }
                byteArrayOutputStream.write(0);
            }
            byteArrayInputStream.reset();
        }
        if ((255 & arrby[arrby.length - 1]) == 255) {
            logger.finest("Adding unsynchronisation bit at end of stream");
            byteArrayOutputStream.write(0);
        }
        return byteArrayOutputStream.toByteArray();
    }
}

