/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashSet
 *  java.util.Hashtable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.util.ChunkPositionComparator;
import org.jaudiotagger.audio.asf.util.Utils;

public class ChunkContainer
extends Chunk {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Set<GUID> MULTI_CHUNKS;
    private final Map<GUID, List<Chunk>> chunkTable = new Hashtable();

    static {
        HashSet hashSet;
        MULTI_CHUNKS = hashSet = new HashSet();
        hashSet.add((Object)GUID.GUID_STREAM);
    }

    public ChunkContainer(GUID gUID, long l2, BigInteger bigInteger) {
        super(gUID, l2, bigInteger);
    }

    protected static boolean chunkstartsUnique(ChunkContainer chunkContainer) {
        HashSet hashSet = new HashSet();
        Iterator iterator = chunkContainer.getChunks().iterator();
        boolean bl = true;
        while (iterator.hasNext()) {
            bl &= hashSet.add((Object)((Chunk)iterator.next()).getPosition());
        }
        return bl;
    }

    public void addChunk(Chunk chunk) {
        List<Chunk> list = this.assertChunkList(chunk.getGuid());
        if (!list.isEmpty() && !MULTI_CHUNKS.contains((Object)chunk.getGuid())) {
            throw new IllegalArgumentException("The GUID of the given chunk indicates, that there is no more instance allowed.");
        }
        list.add((Object)chunk);
    }

    protected List<Chunk> assertChunkList(GUID gUID) {
        List list = (List)this.chunkTable.get((Object)gUID);
        if (list == null) {
            list = new ArrayList();
            this.chunkTable.put((Object)gUID, (Object)list);
        }
        return list;
    }

    public Collection<Chunk> getChunks() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.chunkTable.values().iterator();
        while (iterator.hasNext()) {
            arrayList.addAll((Collection)((List)iterator.next()));
        }
        return arrayList;
    }

    protected Chunk getFirst(GUID gUID, Class<? extends Chunk> class_) {
        Chunk chunk;
        List list = (List)this.chunkTable.get((Object)gUID);
        if (list != null && !list.isEmpty() && class_.isAssignableFrom((chunk = (Chunk)list.get(0)).getClass())) {
            return chunk;
        }
        return null;
    }

    public boolean hasChunkByGUID(GUID gUID) {
        return this.chunkTable.containsKey((Object)gUID);
    }

    @Override
    public String prettyPrint(String string2) {
        return this.prettyPrint(string2, "");
    }

    public String prettyPrint(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder(super.prettyPrint(string2));
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("  |");
        stringBuilder.append(Utils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList(this.getChunks());
        Collections.sort((List)arrayList, (Comparator)new ChunkPositionComparator());
        for (Chunk chunk : arrayList) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append("  |");
            stringBuilder.append(chunk.prettyPrint(stringBuilder2.toString()));
            stringBuilder.append(string2);
            stringBuilder.append("  |");
            stringBuilder.append(Utils.LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}

