/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package org.jaudiotagger.audio.asf.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkModifier;
import org.jaudiotagger.audio.asf.io.ModificationResult;
import org.jaudiotagger.audio.asf.util.Utils;

public class AsfStreamer {
    private void copyChunk(GUID gUID, InputStream inputStream, OutputStream outputStream) throws IOException {
        long l2 = Utils.readUINT64(inputStream);
        outputStream.write(gUID.getBytes());
        Utils.writeUINT64(l2, outputStream);
        Utils.copy(inputStream, outputStream, l2 - 24L);
    }

    private void modifyFileHeader(InputStream inputStream, OutputStream outputStream, long l2) throws IOException {
        outputStream.write(GUID.GUID_FILE.getBytes());
        long l3 = Utils.readUINT64(inputStream);
        Utils.writeUINT64(l3, outputStream);
        outputStream.write(Utils.readGUID(inputStream).getBytes());
        Utils.writeUINT64(l2 + Utils.readUINT64(inputStream), outputStream);
        Utils.copy(inputStream, outputStream, l3 - 48L);
    }

    public void createModifiedCopy(InputStream inputStream, OutputStream outputStream, List<ChunkModifier> list) throws IOException {
        GUID gUID;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if (GUID.GUID_HEADER.equals(gUID = Utils.readGUID(inputStream))) {
            long l2;
            long l3;
            long l4 = Utils.readUINT64(inputStream);
            long l5 = Utils.readUINT32(inputStream);
            byte[] arrby = new byte[]{(byte)(255 & inputStream.read()), (byte)(255 & inputStream.read())};
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            long l6 = l3 = (l2 = 0L);
            byte[] arrby2 = null;
            while (l2 < l5) {
                byte[] arrby3;
                long l7;
                GUID gUID2 = Utils.readGUID(inputStream);
                if (GUID.GUID_FILE.equals(gUID2)) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    long l8 = Utils.readUINT64(inputStream);
                    Utils.writeUINT64(l8, (OutputStream)byteArrayOutputStream2);
                    Utils.copy(inputStream, (OutputStream)byteArrayOutputStream2, l8 - 24L);
                    arrby2 = byteArrayOutputStream2.toByteArray();
                    l7 = l5;
                    arrby3 = arrby;
                } else {
                    byte[] arrby4 = arrby2;
                    boolean bl = false;
                    for (int i2 = 0; i2 < arrayList.size() && !bl; ++i2) {
                        byte[] arrby5;
                        long l9;
                        if (((ChunkModifier)arrayList.get(i2)).isApplicable(gUID2)) {
                            ModificationResult modificationResult = ((ChunkModifier)arrayList.get(i2)).modify(gUID2, inputStream, (OutputStream)byteArrayOutputStream);
                            arrby5 = arrby;
                            int n2 = modificationResult.getChunkCountDifference();
                            l9 = l5;
                            l6 += (long)n2;
                            l3 += modificationResult.getByteDifference();
                            arrayList.remove(i2);
                            bl = true;
                        } else {
                            l9 = l5;
                            arrby5 = arrby;
                        }
                        arrby = arrby5;
                        l5 = l9;
                    }
                    l7 = l5;
                    arrby3 = arrby;
                    if (!bl) {
                        this.copyChunk(gUID2, inputStream, (OutputStream)byteArrayOutputStream);
                    }
                    arrby2 = arrby4;
                }
                ++l2;
                arrby = arrby3;
                l5 = l7;
            }
            long l10 = l5;
            byte[] arrby6 = arrby;
            byte[] arrby7 = arrby2;
            Iterator iterator = arrayList.iterator();
            long l11 = l3;
            while (iterator.hasNext()) {
                ModificationResult modificationResult = ((ChunkModifier)iterator.next()).modify(null, null, (OutputStream)byteArrayOutputStream);
                l6 += (long)modificationResult.getChunkCountDifference();
                l11 += modificationResult.getByteDifference();
            }
            outputStream.write(gUID.getBytes());
            Utils.writeUINT64(l4 + l11, outputStream);
            Utils.writeUINT32(l10 + l6, outputStream);
            outputStream.write(arrby6);
            this.modifyFileHeader((InputStream)new ByteArrayInputStream(arrby7), outputStream, l11);
            outputStream.write(byteArrayOutputStream.toByteArray());
            Utils.flush(inputStream, outputStream);
            return;
        }
        throw new IllegalArgumentException("No ASF header object.");
    }
}

