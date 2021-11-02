/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.dbrecord;

public class WaveformRecord {
    public String file;
    public long size;
    public long timestamp;
    public byte[] waveForm;

    public WaveformRecord() {
    }

    public WaveformRecord(String string, long l2, byte[] arrby) {
        this.size = l2;
        this.file = string;
        this.waveForm = arrby;
    }
}

