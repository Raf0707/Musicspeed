/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.audio.mp4.atom;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp4.Mp4AtomIdentifier;
import org.jaudiotagger.audio.mp4.atom.AbstractMp4Box;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;

public class Mp4FreeBox
extends AbstractMp4Box {
    public Mp4FreeBox(int n2) {
        this.header = new Mp4BoxHeader();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(Utils.getSizeBEInt32(n2 + 8));
        byteArrayOutputStream.write(Mp4AtomIdentifier.FREE.getFieldName().getBytes(StandardCharsets.ISO_8859_1));
        this.header.update(ByteBuffer.wrap((byte[])byteArrayOutputStream.toByteArray()));
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < n2; ++i2) {
            byteArrayOutputStream2.write(0);
        }
        try {
            this.dataBuffer = ByteBuffer.wrap((byte[])byteArrayOutputStream2.toByteArray());
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }
}

