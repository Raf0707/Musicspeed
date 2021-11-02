/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.jaudiotagger.audio.flac;

import org.jaudiotagger.audio.generic.GenericAudioHeader;

public class FlacAudioHeader
extends GenericAudioHeader {
    private String md5;

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String string2) {
        this.md5 = string2;
    }
}

