/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.ChunkContainer;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkHeaderReader;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.io.CountingInputStream;
import org.jaudiotagger.audio.asf.util.Utils;

abstract class ChunkContainerReader<ChunkType extends ChunkContainer>
implements ChunkReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final Logger LOGGER = Logger.getLogger((String)"org.jaudiotabgger.audio");
    public static final int READ_LIMIT = 8192;
    protected final boolean eachChunkOnce;
    protected boolean hasFailingReaders = false;
    protected final Map<GUID, ChunkReader> readerMap = new HashMap();

    protected ChunkContainerReader(List<Class<? extends ChunkReader>> list, boolean bl) {
        this.eachChunkOnce = bl;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            this.register((Class)iterator.next());
        }
    }

    private <T extends ChunkReader> void register(Class<T> class_) {
        ChunkReader chunkReader = (ChunkReader)class_.newInstance();
        GUID[] arrgUID = chunkReader.getApplyingIds();
        int n2 = arrgUID.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            try {
                GUID gUID = arrgUID[i2];
                this.readerMap.put((Object)gUID, (Object)chunkReader);
            }
            catch (IllegalAccessException illegalAccessException) {
                LOGGER.severe(illegalAccessException.getMessage());
                return;
            }
            catch (InstantiationException instantiationException) {
                LOGGER.severe(instantiationException.getMessage());
                break;
            }
            continue;
        }
    }

    protected void checkStream(InputStream inputStream) throws IllegalArgumentException {
        if (this.hasFailingReaders) {
            if (inputStream.markSupported()) {
                return;
            }
            throw new IllegalArgumentException("Stream has to support mark/reset.");
        }
    }

    protected abstract ChunkType createContainer(long var1, BigInteger var3, InputStream var4) throws IOException;

    protected ChunkReader getReader(GUID gUID) {
        return (ChunkReader)this.readerMap.get((Object)gUID);
    }

    protected boolean isReaderAvailable(GUID gUID) {
        return this.readerMap.containsKey((Object)gUID);
    }

    public ChunkType read(GUID gUID, InputStream inputStream, long l2) throws IOException, IllegalArgumentException {
        this.checkStream(inputStream);
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        if (Arrays.asList((Object[])this.getApplyingIds()).contains((Object)gUID)) {
            ChunkType ChunkType = this.createContainer(l2, Utils.readBig64((InputStream)countingInputStream), (InputStream)countingInputStream);
            long l3 = 16L + (l2 + countingInputStream.getReadCount());
            HashSet hashSet = new HashSet();
            while (l3 < ((Chunk)ChunkType).getChunkEnd()) {
                Chunk chunk;
                GUID gUID2 = Utils.readGUID((InputStream)countingInputStream);
                boolean bl = this.eachChunkOnce && (!this.isReaderAvailable(gUID2) || !hashSet.add((Object)gUID2));
                if (!bl && this.isReaderAvailable(gUID2)) {
                    if (this.getReader(gUID2).canFail()) {
                        countingInputStream.mark(8192);
                    }
                    chunk = this.getReader(gUID2).read(gUID2, (InputStream)countingInputStream, l3);
                } else {
                    chunk = ChunkHeaderReader.getInstance().read(gUID2, (InputStream)countingInputStream, l3);
                }
                if (chunk == null) {
                    countingInputStream.reset();
                    continue;
                }
                if (!bl) {
                    ((ChunkContainer)ChunkType).addChunk(chunk);
                }
                l3 = chunk.getChunkEnd();
            }
            return ChunkType;
        }
        throw new IllegalArgumentException("provided GUID is not supported by this reader.");
    }
}

