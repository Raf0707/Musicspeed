/*
 * Decompiled with CFR 0.0.
 */
package org.jaudiotagger.audio.mp4.atom;

import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;

public class NullPadding
extends Mp4BoxHeader {
    public NullPadding(long l2, long l3) {
        this.setFilePos(l2);
        this.length = (int)(l3 - l2);
    }
}

