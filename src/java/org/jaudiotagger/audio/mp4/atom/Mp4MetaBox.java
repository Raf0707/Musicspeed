/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.mp4.atom;

import java.nio.ByteBuffer;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.mp4.Mp4AtomIdentifier;
import org.jaudiotagger.audio.mp4.atom.AbstractMp4Box;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.logging.ErrorMessage;

public class Mp4MetaBox
extends AbstractMp4Box {
    public static final int FLAGS_LENGTH = 4;

    public Mp4MetaBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) {
        this.header = mp4BoxHeader;
        this.dataBuffer = byteBuffer;
    }

    public static Mp4MetaBox createiTunesStyleMetaBox(int n2) {
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader(Mp4AtomIdentifier.META.getFieldName());
        mp4BoxHeader.setLength(n2 + 12);
        return new Mp4MetaBox(mp4BoxHeader, ByteBuffer.allocate((int)4));
    }

    public void processData() throws CannotReadException {
        byte[] arrby = new byte[4];
        this.dataBuffer.get(arrby);
        if (arrby[0] == 0) {
            return;
        }
        throw new CannotReadException(ErrorMessage.MP4_FILE_META_ATOM_CHILD_DATA_NOT_NULL.getMsg());
    }
}

