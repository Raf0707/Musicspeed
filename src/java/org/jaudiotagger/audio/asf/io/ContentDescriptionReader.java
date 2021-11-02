/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.ContentDescription;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

public class ContentDescriptionReader
implements ChunkReader {
    private static final GUID[] APPLYING;

    static {
        GUID[] arrgUID = new GUID[]{GUID.GUID_CONTENTDESCRIPTION};
        APPLYING = arrgUID;
    }

    protected ContentDescriptionReader() {
    }

    private int[] getStringSizes(InputStream inputStream) throws IOException {
        int[] arrn = new int[5];
        for (int i2 = 0; i2 < 5; ++i2) {
            arrn[i2] = Utils.readUINT16(inputStream);
        }
        return arrn;
    }

    @Override
    public boolean canFail() {
        return false;
    }

    @Override
    public GUID[] getApplyingIds() {
        return (GUID[])APPLYING.clone();
    }

    @Override
    public Chunk read(GUID gUID, InputStream inputStream, long l2) throws IOException {
        BigInteger bigInteger = Utils.readBig64(inputStream);
        int[] arrn = this.getStringSizes(inputStream);
        int n2 = arrn.length;
        String[] arrstring = new String[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrn[i2] <= 0) continue;
            arrstring[i2] = Utils.readFixedSizeUTF16Str(inputStream, arrn[i2]);
        }
        ContentDescription contentDescription = new ContentDescription(l2, bigInteger);
        if (arrn[0] > 0) {
            contentDescription.setTitle(arrstring[0]);
        }
        if (arrn[1] > 0) {
            contentDescription.setAuthor(arrstring[1]);
        }
        if (arrn[2] > 0) {
            contentDescription.setCopyright(arrstring[2]);
        }
        if (arrn[3] > 0) {
            contentDescription.setComment(arrstring[3]);
        }
        if (arrn[4] > 0) {
            contentDescription.setRating(arrstring[4]);
        }
        return contentDescription;
    }
}

