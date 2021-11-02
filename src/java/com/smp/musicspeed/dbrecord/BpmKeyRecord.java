/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.dbrecord;

public class BpmKeyRecord {
    public boolean analyzed;
    public float bpmcurrent;
    public float bpmoriginal;
    public String filename;
    public int keycurrent;
    public int keyoriginal;
    public long size;

    public BpmKeyRecord() {
    }

    public BpmKeyRecord(String string, long l2) {
        this.filename = string;
        this.size = l2;
    }
}

