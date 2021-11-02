/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.jaudiotagger.audio.mp4;

import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.mp4.atom.Mp4EsdsBox;

public class Mp4AudioHeader
extends GenericAudioHeader {
    private String brand;
    private Mp4EsdsBox.Kind kind;
    private Mp4EsdsBox.AudioProfile profile;

    public String getBrand() {
        return this.brand;
    }

    public Mp4EsdsBox.Kind getKind() {
        return this.kind;
    }

    public Mp4EsdsBox.AudioProfile getProfile() {
        return this.profile;
    }

    public void setBrand(String string2) {
        this.brand = string2;
    }

    public void setKind(Mp4EsdsBox.Kind kind) {
        this.kind = kind;
    }

    public void setProfile(Mp4EsdsBox.AudioProfile audioProfile) {
        this.profile = audioProfile;
    }
}

