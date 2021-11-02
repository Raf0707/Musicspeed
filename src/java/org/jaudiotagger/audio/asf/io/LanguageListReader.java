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
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.LanguageList;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

public class LanguageListReader
implements ChunkReader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final GUID[] APPLYING;

    static {
        GUID[] arrgUID = new GUID[]{GUID.GUID_LANGUAGE_LIST};
        APPLYING = arrgUID;
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
        int n2 = Utils.readUINT16(inputStream);
        LanguageList languageList = new LanguageList(l2, bigInteger);
        for (int i2 = 0; i2 < n2; ++i2) {
            languageList.addLanguage(Utils.readFixedSizeUTF16Str(inputStream, 255 & inputStream.read()));
        }
        return languageList;
    }
}

