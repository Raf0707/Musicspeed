/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.player;

import com.smp.musicspeed.player.k;

public interface g {
    public void clearLoopPoints();

    public String getAlbum();

    public String getArtist();

    public long getDuration();

    public String getFileName();

    public long getLoopEnd();

    public long getLoopStart();

    public float getPitchSemi();

    public long getPlayedDuration();

    public float getRate();

    public float getTempo();

    public String getTitle();

    public boolean isFinished();

    public boolean isPaused();

    public void pause();

    public void play();

    public void seekTo(double var1, boolean var3);

    public void seekTo(long var1);

    public void setEffectsLevels(boolean var1, float var2, float var3, float var4, float var5, float var6, float var7, boolean var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, boolean var17, float var18, float var19, boolean var20, float var21, float var22, float var23, float var24, float var25, boolean var26, float var27, float var28, boolean var29, float var30, float var31, float var32, boolean var33, float var34, float var35, float var36, float var37, float var38, float var39);

    public void setEqualizerLevels(boolean var1, float var2, boolean var3, float[] var4, boolean var5, float var6);

    public void setLoopEnd(long var1);

    public void setLoopStart(long var1);

    public void setOnProgressChangedListener(k var1);

    public void setPitchSemi(float var1);

    public void setRate(float var1);

    public void setRepeat(boolean var1);

    public void setTempo(float var1);

    public void setVolume(float var1, float var2);

    public void start();

    public void stop();

    public void toForeground(boolean var1);
}

