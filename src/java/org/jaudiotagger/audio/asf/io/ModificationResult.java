/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 */
package org.jaudiotagger.audio.asf.io;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.jaudiotagger.audio.asf.data.GUID;

final class ModificationResult {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final long byteDifference;
    private final int chunkDifference;
    private final Set<GUID> occuredGUIDs;

    public ModificationResult(int n2, long l2, Set<GUID> set) {
        HashSet hashSet;
        this.occuredGUIDs = hashSet = new HashSet();
        this.chunkDifference = n2;
        this.byteDifference = l2;
        hashSet.addAll(set);
    }

    public /* varargs */ ModificationResult(int n2, long l2, GUID ... arrgUID) {
        HashSet hashSet;
        this.occuredGUIDs = hashSet = new HashSet();
        this.chunkDifference = n2;
        this.byteDifference = l2;
        hashSet.addAll((Collection)Arrays.asList((Object[])arrgUID));
    }

    public long getByteDifference() {
        return this.byteDifference;
    }

    public int getChunkCountDifference() {
        return this.chunkDifference;
    }

    public Set<GUID> getOccuredGUIDs() {
        return new HashSet(this.occuredGUIDs);
    }
}

