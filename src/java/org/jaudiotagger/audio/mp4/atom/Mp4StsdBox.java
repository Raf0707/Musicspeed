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

public class Mp4StsdBox
extends AbstractMp4Box {
    public static final int NO_OF_DESCRIPTIONS_POS = 4;
    public static final int NO_OF_DESCRIPTIONS_POS_LENGTH = 4;
    public static final int OTHER_FLAG_LENGTH = 3;
    public static final int OTHER_FLAG_POS = 1;
    public static final int VERSION_FLAG_LENGTH = 1;
    public static final int VERSION_FLAG_POS;

    public Mp4StsdBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) {
        this.header = mp4BoxHeader;
        this.dataBuffer = byteBuffer;
    }

    public void processData() throws CannotReadException {
        ByteBuffer byteBuffer = this.dataBuffer;
        byteBuffer.position(4 + (3 + (1 + byteBuffer.position())));
    }
}

