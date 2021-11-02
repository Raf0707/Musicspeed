/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.MetadataContainer;
import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

public class MetadataReader
implements ChunkReader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final GUID[] APPLYING;

    static {
        GUID[] arrgUID = new GUID[]{ContainerType.EXTENDED_CONTENT.getContainerGUID(), ContainerType.METADATA_OBJECT.getContainerGUID(), ContainerType.METADATA_LIBRARY_OBJECT.getContainerGUID()};
        APPLYING = arrgUID;
    }

    private boolean readBoolean(InputStream inputStream, int n2) throws IOException {
        byte[] arrby = new byte[n2];
        inputStream.read(arrby);
        boolean bl = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 != n2 - 1) continue;
            bl = arrby[i2] == 1;
        }
        return bl;
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
        MetadataContainer metadataContainer = new MetadataContainer(gUID, l2, Utils.readBig64(inputStream));
        boolean bl = metadataContainer.getContainerType() == ContainerType.EXTENDED_CONTENT;
        int n2 = Utils.readUINT16(inputStream);
        int n3 = 0;
        while (n3 < n2) {
            int n4;
            int n5;
            if (!bl) {
                int n6 = Utils.readUINT16(inputStream);
                int n7 = Utils.readUINT16(inputStream);
                n4 = n6;
                n5 = n7;
            } else {
                n5 = 0;
                n4 = 0;
            }
            int n8 = Utils.readUINT16(inputStream);
            String string2 = null;
            if (bl) {
                string2 = Utils.readFixedSizeUTF16Str(inputStream, n8);
            }
            int n9 = Utils.readUINT16(inputStream);
            long l3 = bl ? (long)Utils.readUINT16(inputStream) : Utils.readUINT32(inputStream);
            long l4 = l3;
            String string3 = !bl ? Utils.readFixedSizeUTF16Str(inputStream, n8) : string2;
            ContainerType containerType = metadataContainer.getContainerType();
            int n10 = n3;
            MetadataDescriptor metadataDescriptor = new MetadataDescriptor(containerType, string3, n9, n5, n4);
            switch (n9) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid datatype: ");
                    stringBuilder.append(new String(Utils.readBinary(inputStream, l4)));
                    metadataDescriptor.setStringValue(stringBuilder.toString());
                    break;
                }
                case 6: {
                    metadataDescriptor.setGUIDValue(Utils.readGUID(inputStream));
                    break;
                }
                case 5: {
                    metadataDescriptor.setWordValue(Utils.readUINT16(inputStream));
                    break;
                }
                case 4: {
                    metadataDescriptor.setQWordValue(Utils.readUINT64(inputStream));
                    break;
                }
                case 3: {
                    metadataDescriptor.setDWordValue(Utils.readUINT32(inputStream));
                    break;
                }
                case 2: {
                    metadataDescriptor.setBooleanValue(this.readBoolean(inputStream, (int)l4));
                    break;
                }
                case 1: {
                    metadataDescriptor.setBinaryValue(Utils.readBinary(inputStream, l4));
                    break;
                }
                case 0: {
                    metadataDescriptor.setStringValue(Utils.readFixedSizeUTF16Str(inputStream, (int)l4));
                }
            }
            metadataContainer.addDescriptor(metadataDescriptor);
            n3 = n10 + 1;
        }
        return metadataContainer;
    }
}

