/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.ogg;

public final class VorbisVersion
extends Enum<VorbisVersion> {
    private static final /* synthetic */ VorbisVersion[] $VALUES;
    public static final /* enum */ VorbisVersion VERSION_ONE;
    private String displayName;

    static {
        VorbisVersion vorbisVersion;
        VERSION_ONE = vorbisVersion = new VorbisVersion("Ogg Vorbis v1");
        $VALUES = new VorbisVersion[]{vorbisVersion};
    }

    private VorbisVersion(String string3) {
        this.displayName = string3;
    }

    public static VorbisVersion valueOf(String string2) {
        return (VorbisVersion)Enum.valueOf(VorbisVersion.class, (String)string2);
    }

    public static VorbisVersion[] values() {
        return (VorbisVersion[])$VALUES.clone();
    }

    public String toString() {
        return this.displayName;
    }
}

