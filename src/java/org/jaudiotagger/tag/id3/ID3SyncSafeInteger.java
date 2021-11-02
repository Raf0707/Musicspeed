/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.tag.id3;

import java.nio.ByteBuffer;

public class ID3SyncSafeInteger {
    public static final int INTEGRAL_SIZE = 4;
    public static final int MAX_SAFE_SIZE = 127;

    public static int bufferToValue(ByteBuffer byteBuffer) {
        byte[] arrby = new byte[4];
        byteBuffer.get(arrby, 0, 4);
        return ID3SyncSafeInteger.bufferToValue(arrby);
    }

    public static int bufferToValue(byte[] arrby) {
        return ((255 & arrby[0]) << 21) + ((255 & arrby[1]) << 14) + ((255 & arrby[2]) << 7) + (255 & arrby[3]);
    }

    protected static boolean isBufferEmpty(byte[] arrby) {
        int n2 = arrby.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrby[i2] == 0) continue;
            return false;
        }
        return true;
    }

    protected static boolean isBufferNotSyncSafe(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.position();
        for (int i2 = 0; i2 < 4; ++i2) {
            if ((128 & byteBuffer.get(n2 + i2)) <= 0) continue;
            return true;
        }
        return false;
    }

    protected static byte[] valueToBuffer(int n2) {
        byte[] arrby = new byte[]{(byte)((266338304 & n2) >> 21), (byte)((2080768 & n2) >> 14), (byte)((n2 & 16256) >> 7), (byte)(n2 & 127)};
        return arrby;
    }
}

