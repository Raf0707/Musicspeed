/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
package org.jaudiotagger.audio.asf.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkModifier;
import org.jaudiotagger.audio.asf.io.CountingInputStream;
import org.jaudiotagger.audio.asf.io.ModificationResult;
import org.jaudiotagger.audio.asf.util.Utils;

public class AsfExtHeaderModifier
implements ChunkModifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final List<ChunkModifier> modifierList;

    public AsfExtHeaderModifier(List<ChunkModifier> list) {
        this.modifierList = new ArrayList(list);
    }

    private void copyChunk(GUID gUID, InputStream inputStream, OutputStream outputStream) throws IOException {
        long l2 = Utils.readUINT64(inputStream);
        outputStream.write(gUID.getBytes());
        Utils.writeUINT64(l2, outputStream);
        Utils.copy(inputStream, outputStream, l2 - 24L);
    }

    @Override
    public boolean isApplicable(GUID gUID) {
        return GUID.GUID_HEADER_EXTENSION.equals(gUID);
    }

    @Override
    public ModificationResult modify(GUID gUID, InputStream inputStream, OutputStream outputStream) throws IOException {
        long l2 = 0L;
        ArrayList arrayList = new ArrayList(this.modifierList);
        HashSet hashSet = new HashSet();
        hashSet.add((Object)gUID);
        BigInteger bigInteger = Utils.readBig64(inputStream);
        GUID gUID2 = Utils.readGUID(inputStream);
        int n2 = Utils.readUINT16(inputStream);
        long l3 = Utils.readUINT32(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        do {
            long l4 = countingInputStream.getReadCount();
            if (l4 >= l3) break;
            GUID gUID3 = Utils.readGUID((InputStream)countingInputStream);
            long l5 = l3;
            boolean bl = false;
            for (int i2 = 0; i2 < arrayList.size() && !bl; ++i2) {
                if (!((ChunkModifier)arrayList.get(i2)).isApplicable(gUID3)) continue;
                ModificationResult modificationResult = ((ChunkModifier)arrayList.get(i2)).modify(gUID3, (InputStream)countingInputStream, (OutputStream)byteArrayOutputStream);
                l2 += modificationResult.getByteDifference();
                hashSet.addAll(modificationResult.getOccuredGUIDs());
                arrayList.remove(i2);
                bl = true;
            }
            if (!bl) {
                hashSet.add((Object)gUID3);
                this.copyChunk(gUID3, (InputStream)countingInputStream, (OutputStream)byteArrayOutputStream);
            }
            l3 = l5;
        } while (true);
        long l6 = l3;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ModificationResult modificationResult = ((ChunkModifier)iterator.next()).modify(null, null, (OutputStream)byteArrayOutputStream);
            l2 += modificationResult.getByteDifference();
            hashSet.addAll(modificationResult.getOccuredGUIDs());
        }
        outputStream.write(GUID.GUID_HEADER_EXTENSION.getBytes());
        Utils.writeUINT64(bigInteger.add(BigInteger.valueOf((long)l2)).longValue(), outputStream);
        outputStream.write(gUID2.getBytes());
        Utils.writeUINT16(n2, outputStream);
        Utils.writeUINT32(l6 + l2, outputStream);
        outputStream.write(byteArrayOutputStream.toByteArray());
        return new ModificationResult(0, l2, (Set<GUID>)hashSet);
    }
}

