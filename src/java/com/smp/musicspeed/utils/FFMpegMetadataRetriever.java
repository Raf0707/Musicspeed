/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.player.ElastiquePlayer
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.utils;

import com.smp.musicspeed.player.ElastiquePlayer;

public class FFMpegMetadataRetriever {
    static {
        ElastiquePlayer.init();
    }

    public static native String[] retrieveMetadata(String var0);
}

