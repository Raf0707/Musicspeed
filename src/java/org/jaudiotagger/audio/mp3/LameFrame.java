/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.audio.mp3;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.generic.Utils;

public class LameFrame {
    public static final int ENCODER_SIZE = 9;
    public static final int LAME_HEADER_BUFFER_SIZE = 36;
    public static final String LAME_ID = "LAME";
    public static final int LAME_ID_SIZE = 4;
    private String encoder;

    private LameFrame(ByteBuffer byteBuffer) {
        this.encoder = Utils.getString(byteBuffer, 0, 9, StandardCharsets.ISO_8859_1);
    }

    public static LameFrame parseLameFrame(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer.slice();
        String string2 = Utils.getString(byteBuffer2, 0, 4, StandardCharsets.ISO_8859_1);
        byteBuffer2.rewind();
        if (string2.equals((Object)LAME_ID)) {
            return new LameFrame(byteBuffer2);
        }
        return null;
    }

    public String getEncoder() {
        return this.encoder;
    }
}

