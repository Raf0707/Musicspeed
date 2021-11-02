/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 */
package org.jaudiotagger.audio.aiff;

public class ExtDouble {
    byte[] _rawData;

    public ExtDouble(byte[] arrby) {
        this._rawData = arrby;
    }

    public double toDouble() {
        byte[] arrby = this._rawData;
        int n2 = arrby[0] >> 7;
        int n3 = -16445 + (32767 & (arrby[0] << 8 | arrby[1]));
        long l2 = 0L;
        int n4 = 55;
        for (int i2 = 2; i2 < 9; ++i2) {
            l2 |= (255L & (long)this._rawData[i2]) << n4;
            n4 -= 8;
        }
        long l3 = l2 | (long)(this._rawData[9] >>> 1);
        double d2 = Math.pow((double)2.0, (double)n3) * (double)l3;
        if (n2 != 0) {
            d2 = -d2;
        }
        return d2;
    }
}

