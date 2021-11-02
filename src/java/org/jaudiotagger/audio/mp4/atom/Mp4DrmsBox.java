/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.mp4.atom;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.mp4.atom.AbstractMp4Box;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;

public class Mp4DrmsBox
extends AbstractMp4Box {
    public Mp4DrmsBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) {
        this.header = mp4BoxHeader;
        this.dataBuffer = byteBuffer;
    }

    public void processData() throws CannotReadException {
        while (this.dataBuffer.hasRemaining()) {
            if (this.dataBuffer.get() != 101) continue;
            ByteBuffer byteBuffer = this.dataBuffer.slice();
            boolean bl = byteBuffer.get() == 115;
            boolean bl2 = byteBuffer.get() == 100;
            boolean bl3 = bl & bl2;
            byte by = byteBuffer.get();
            boolean bl4 = false;
            if (by == 115) {
                bl4 = true;
            }
            if (!(bl3 & bl4)) continue;
            ByteBuffer byteBuffer2 = this.dataBuffer;
            byteBuffer2.position(-4 + (byteBuffer2.position() - 1));
            break;
        }
    }
}

