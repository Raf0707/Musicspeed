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
import org.jaudiotagger.audio.asf.io.ChunkModifier;
import org.jaudiotagger.audio.asf.io.ModificationResult;
import org.jaudiotagger.audio.asf.io.WriteableChunk;
import org.jaudiotagger.audio.asf.util.Utils;

public class WriteableChunkModifer
implements ChunkModifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final WriteableChunk writableChunk;

    public WriteableChunkModifer(WriteableChunk writeableChunk) {
        this.writableChunk = writeableChunk;
    }

    @Override
    public boolean isApplicable(GUID gUID) {
        return gUID.equals(this.writableChunk.getGuid());
    }

    @Override
    public ModificationResult modify(GUID gUID, InputStream inputStream, OutputStream outputStream) throws IOException {
        long l2;
        int n2;
        long l3;
        block4 : {
            block3 : {
                block2 : {
                    boolean bl = this.writableChunk.isEmpty();
                    l3 = 0L;
                    if (bl) break block2;
                    l2 = this.writableChunk.writeInto(outputStream);
                    if (gUID != null) break block3;
                    n2 = 1;
                    break block4;
                }
                l2 = l3;
            }
            n2 = 0;
        }
        if (gUID != null) {
            if (this.writableChunk.isEmpty()) {
                --n2;
            }
            l3 = Utils.readUINT64(inputStream);
            inputStream.skip(l3 - 24L);
        }
        return new ModificationResult(n2, l2 - l3, gUID);
    }
}

