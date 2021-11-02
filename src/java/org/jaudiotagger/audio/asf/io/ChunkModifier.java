/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ModificationResult;

public interface ChunkModifier {
    public boolean isApplicable(GUID var1);

    public ModificationResult modify(GUID var1, InputStream var2, OutputStream var3) throws IOException;
}

