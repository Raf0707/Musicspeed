/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.ogg.util;

import java.util.logging.Logger;

public class OggCRCFactory {
    private static long[] crc_lookup;
    private static boolean init;
    public static Logger logger;

    static {
        logger = Logger.getLogger((String)"org.jaudiotagger.audio.ogg");
        crc_lookup = new long[256];
        init = false;
    }

    public static byte[] computeCRC(byte[] arrby) {
        if (!init) {
            OggCRCFactory.init();
        }
        long l2 = 0L;
        for (byte by : arrby) {
            int n2 = (int)(255L & l2 >>> 24 ^ (long)OggCRCFactory.u(by));
            l2 = -1L & (l2 << 8 ^ crc_lookup[n2]);
        }
        byte[] arrby2 = new byte[]{(byte)(l2 & 255L), (byte)(255L & l2 >>> 8), (byte)(255L & l2 >>> 16), (byte)(255L & l2 >>> 24)};
        return arrby2;
    }

    public static void init() {
        for (int i2 = 0; i2 < 256; ++i2) {
            long l2 = i2 << 24;
            for (int i3 = 0; i3 < 8; ++i3) {
                if ((0x80000000L & l2) != 0L) {
                    l2 = 79764919L ^ l2 << 1;
                    continue;
                }
                l2 <<= 1;
            }
            OggCRCFactory.crc_lookup[i2] = l2;
        }
        init = true;
    }

    private static int u(int n2) {
        return n2 & 255;
    }

    public boolean checkCRC(byte[] arrby, byte[] arrby2) {
        return new String(arrby2).equals((Object)new String(OggCRCFactory.computeCRC(arrby)));
    }
}

