/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.dbrecord.DbLockKt$dbLock
 *  java.lang.Object
 */
package com.smp.musicspeed.dbrecord;

import com.smp.musicspeed.dbrecord.DbLockKt;

public final class DbLockKt {
    private static final Object dbLock = new Object(){};

    public static final Object getDbLock() {
        return dbLock;
    }
}

