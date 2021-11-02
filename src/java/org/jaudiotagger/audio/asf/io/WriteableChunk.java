/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.OutputStream;
import org.jaudiotagger.audio.asf.data.GUID;

public interface WriteableChunk {
    public long getCurrentAsfChunkSize();

    public GUID getGuid();

    public boolean isEmpty();

    public long writeInto(OutputStream var1) throws IOException;
}

