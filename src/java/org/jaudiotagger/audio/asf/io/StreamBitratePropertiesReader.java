/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.math.BigInteger
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.StreamBitratePropertiesChunk;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

public class StreamBitratePropertiesReader
implements ChunkReader {
    private static final GUID[] APPLYING;

    static {
        GUID[] arrgUID = new GUID[]{GUID.GUID_STREAM_BITRATE_PROPERTIES};
        APPLYING = arrgUID;
    }

    protected StreamBitratePropertiesReader() {
    }

    @Override
    public boolean canFail() {
        return false;
    }

    @Override
    public GUID[] getApplyingIds() {
        return (GUID[])APPLYING.clone();
    }

    @Override
    public Chunk read(GUID gUID, InputStream inputStream, long l2) throws IOException {
        StreamBitratePropertiesChunk streamBitratePropertiesChunk = new StreamBitratePropertiesChunk(Utils.readBig64(inputStream));
        long l3 = Utils.readUINT16(inputStream);
        int n2 = 0;
        while ((long)n2 < l3) {
            int n3 = Utils.readUINT16(inputStream);
            long l4 = Utils.readUINT32(inputStream);
            streamBitratePropertiesChunk.addBitrateRecord(n3 & 255, l4);
            ++n2;
        }
        streamBitratePropertiesChunk.setPosition(l2);
        return streamBitratePropertiesChunk;
    }
}

