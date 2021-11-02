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
import org.jaudiotagger.audio.asf.data.ContentBranding;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

public class ContentBrandingReader
implements ChunkReader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final GUID[] APPLYING;

    static {
        GUID[] arrgUID = new GUID[]{GUID.GUID_CONTENT_BRANDING};
        APPLYING = arrgUID;
    }

    protected ContentBrandingReader() {
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
        long l3 = Utils.readUINT32(inputStream);
        byte[] arrby = Utils.readBinary(inputStream, Utils.readUINT32(inputStream));
        String string2 = new String(Utils.readBinary(inputStream, Utils.readUINT32(inputStream)));
        String string3 = new String(Utils.readBinary(inputStream, Utils.readUINT32(inputStream)));
        ContentBranding contentBranding = new ContentBranding(l2, bigInteger);
        contentBranding.setImage(l3, arrby);
        contentBranding.setCopyRightURL(string2);
        contentBranding.setBannerImageURL(string3);
        return contentBranding;
    }
}

