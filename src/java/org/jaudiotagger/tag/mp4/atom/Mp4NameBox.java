/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.tag.mp4.atom;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.atom.AbstractMp4Box;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;

public class Mp4NameBox
extends AbstractMp4Box {
    public static final int FLAGS_LENGTH = 3;
    public static final String IDENTIFIER = "name";
    public static final int PRE_DATA_LENGTH = 4;
    public static final int VERSION_LENGTH = 1;
    private String name;

    public Mp4NameBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) {
        this.header = mp4BoxHeader;
        if (mp4BoxHeader.getId().equals((Object)IDENTIFIER)) {
            ByteBuffer byteBuffer2;
            this.dataBuffer = byteBuffer2 = byteBuffer.slice();
            this.name = Utils.getString(byteBuffer2, 4, mp4BoxHeader.getDataLength() - 4, mp4BoxHeader.getEncoding());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to process name box because identifier is:");
        stringBuilder.append(mp4BoxHeader.getId());
        throw new RuntimeException(stringBuilder.toString());
    }

    public String getName() {
        return this.name;
    }
}

