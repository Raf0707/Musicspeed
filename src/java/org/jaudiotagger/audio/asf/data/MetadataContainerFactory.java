/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.math.BigInteger
 *  org.jaudiotagger.audio.asf.data.ContentBranding
 *  org.jaudiotagger.audio.asf.data.ContentDescription
 *  org.jaudiotagger.audio.asf.data.MetadataContainer
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.ContentBranding;
import org.jaudiotagger.audio.asf.data.ContentDescription;
import org.jaudiotagger.audio.asf.data.MetadataContainer;

public final class MetadataContainerFactory {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final MetadataContainerFactory INSTANCE = new MetadataContainerFactory();

    private MetadataContainerFactory() {
    }

    public static MetadataContainerFactory getInstance() {
        return INSTANCE;
    }

    public MetadataContainer createContainer(ContainerType containerType) {
        return this.createContainer(containerType, 0L, BigInteger.ZERO);
    }

    public MetadataContainer createContainer(ContainerType containerType, long l2, BigInteger bigInteger) {
        if (containerType == ContainerType.CONTENT_DESCRIPTION) {
            return new ContentDescription(l2, bigInteger);
        }
        if (containerType == ContainerType.CONTENT_BRANDING) {
            return new ContentBranding(l2, bigInteger);
        }
        return new MetadataContainer(containerType, l2, bigInteger);
    }

    public MetadataContainer[] createContainers(ContainerType[] arrcontainerType) {
        int n2 = arrcontainerType.length;
        MetadataContainer[] arrmetadataContainer = new MetadataContainer[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            arrmetadataContainer[i2] = this.createContainer(arrcontainerType[i2]);
        }
        return arrmetadataContainer;
    }
}

