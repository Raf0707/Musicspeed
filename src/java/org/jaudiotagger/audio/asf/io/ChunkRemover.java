/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.util.HashSet
 *  java.util.Set
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkModifier;
import org.jaudiotagger.audio.asf.io.ModificationResult;
import org.jaudiotagger.audio.asf.util.Utils;

public class ChunkRemover
implements ChunkModifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Set<GUID> toRemove = new HashSet();

    public /* varargs */ ChunkRemover(GUID ... arrgUID) {
        for (GUID gUID : arrgUID) {
            this.toRemove.add((Object)gUID);
        }
    }

    @Override
    public boolean isApplicable(GUID gUID) {
        return this.toRemove.contains((Object)gUID);
    }

    @Override
    public ModificationResult modify(GUID gUID, InputStream inputStream, OutputStream outputStream) throws IOException {
        if (gUID == null) {
            return new ModificationResult(0, 0L, new GUID[0]);
        }
        long l2 = Utils.readUINT64(inputStream);
        inputStream.skip(l2 - 24L);
        return new ModificationResult(-1, l2 * -1L, gUID);
    }
}

