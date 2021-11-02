/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;

public interface ChunkReader {
    public boolean canFail();

    public GUID[] getApplyingIds();

    public Chunk read(GUID var1, InputStream var2, long var3) throws IOException;
}

