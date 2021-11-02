/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.ogg.util;

import java.nio.charset.Charset;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.ogg.util.VorbisHeader;
import org.jaudiotagger.audio.ogg.util.VorbisPacketType;

public class VorbisSetupHeader
implements VorbisHeader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.ogg.atom");
    private boolean isValid = false;

    public VorbisSetupHeader(byte[] arrby) {
        this.decodeHeader(arrby);
    }

    public void decodeHeader(byte[] arrby) {
        byte by = arrby[0];
        Logger logger = VorbisSetupHeader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("packetType");
        stringBuilder.append((int)by);
        logger.fine(stringBuilder.toString());
        String string2 = new String(arrby, 1, 6, StandardCharsets.ISO_8859_1);
        if (by == VorbisPacketType.SETUP_HEADER.getType() && string2.equals((Object)"vorbis")) {
            this.isValid = true;
        }
    }

    public boolean isValid() {
        return this.isValid;
    }
}

