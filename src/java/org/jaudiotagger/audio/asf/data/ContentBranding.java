/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.nio.charset.Charset
 *  java.util.HashSet
 *  java.util.Set
 */
package org.jaudiotagger.audio.asf.data;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.MetadataContainer;
import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.audio.asf.util.Utils;

public final class ContentBranding
extends MetadataContainer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Set<String> ALLOWED;
    public static final String KEY_BANNER_IMAGE = "BANNER_IMAGE";
    public static final String KEY_BANNER_TYPE = "BANNER_IMAGE_TYPE";
    public static final String KEY_BANNER_URL = "BANNER_IMAGE_URL";
    public static final String KEY_COPYRIGHT_URL = "COPYRIGHT_URL";

    static {
        HashSet hashSet;
        ALLOWED = hashSet = new HashSet();
        hashSet.add((Object)KEY_BANNER_IMAGE);
        hashSet.add((Object)KEY_BANNER_TYPE);
        hashSet.add((Object)KEY_BANNER_URL);
        hashSet.add((Object)KEY_COPYRIGHT_URL);
    }

    public ContentBranding() {
        this(0L, BigInteger.ZERO);
    }

    public ContentBranding(long l2, BigInteger bigInteger) {
        super(ContainerType.CONTENT_BRANDING, l2, bigInteger);
    }

    public String getBannerImageURL() {
        return this.getValueFor(KEY_BANNER_URL);
    }

    public String getCopyRightURL() {
        return this.getValueFor(KEY_COPYRIGHT_URL);
    }

    @Override
    public long getCurrentAsfChunkSize() {
        return 40L + (long)this.assertDescriptor(KEY_BANNER_IMAGE, 1).getRawDataSize() + (long)this.getBannerImageURL().length() + (long)this.getCopyRightURL().length();
    }

    public byte[] getImageData() {
        return this.assertDescriptor(KEY_BANNER_IMAGE, 1).getRawData();
    }

    public long getImageType() {
        if (!this.hasDescriptor(KEY_BANNER_TYPE)) {
            MetadataDescriptor metadataDescriptor = new MetadataDescriptor(ContainerType.CONTENT_BRANDING, KEY_BANNER_TYPE, 3);
            metadataDescriptor.setDWordValue(0L);
            this.addDescriptor(metadataDescriptor);
        }
        return this.assertDescriptor(KEY_BANNER_TYPE).getNumber();
    }

    @Override
    public boolean isAddSupported(MetadataDescriptor metadataDescriptor) {
        return ALLOWED.contains((Object)metadataDescriptor.getName()) && super.isAddSupported(metadataDescriptor);
    }

    public void setBannerImageURL(String string2) {
        if (Utils.isBlank(string2)) {
            this.removeDescriptorsByName(KEY_BANNER_URL);
            return;
        }
        this.assertDescriptor(KEY_BANNER_URL).setStringValue(string2);
    }

    public void setCopyRightURL(String string2) {
        if (Utils.isBlank(string2)) {
            this.removeDescriptorsByName(KEY_COPYRIGHT_URL);
            return;
        }
        this.assertDescriptor(KEY_COPYRIGHT_URL).setStringValue(string2);
    }

    public void setImage(long l2, byte[] arrby) {
        this.assertDescriptor(KEY_BANNER_TYPE, 3).setDWordValue(l2);
        this.assertDescriptor(KEY_BANNER_IMAGE, 1).setBinaryValue(arrby);
    }

    @Override
    public long writeInto(OutputStream outputStream) throws IOException {
        long l2 = this.getCurrentAsfChunkSize();
        outputStream.write(this.getGuid().getBytes());
        Utils.writeUINT64(l2, outputStream);
        Utils.writeUINT32(this.getImageType(), outputStream);
        byte[] arrby = this.getImageData();
        Utils.writeUINT32(arrby.length, outputStream);
        outputStream.write(arrby);
        Utils.writeUINT32(this.getBannerImageURL().length(), outputStream);
        String string2 = this.getBannerImageURL();
        Charset charset = StandardCharsets.US_ASCII;
        outputStream.write(string2.getBytes(charset));
        Utils.writeUINT32(this.getCopyRightURL().length(), outputStream);
        outputStream.write(this.getCopyRightURL().getBytes(charset));
        return l2;
    }
}

