/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.mp4.atom;

import java.nio.ByteBuffer;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;

public class AbstractMp4Box {
    protected ByteBuffer dataBuffer;
    protected Mp4BoxHeader header;

    public ByteBuffer getData() {
        return this.dataBuffer;
    }

    public Mp4BoxHeader getHeader() {
        return this.header;
    }
}

