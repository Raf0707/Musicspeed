/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.RandomAccessFile
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 */
package org.jaudiotagger.audio.asf.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jaudiotagger.audio.asf.data.AsfHeader;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.ChunkContainer;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.AsfExtHeaderReader;
import org.jaudiotagger.audio.asf.io.ChunkContainerReader;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.io.ContentBrandingReader;
import org.jaudiotagger.audio.asf.io.ContentDescriptionReader;
import org.jaudiotagger.audio.asf.io.EncodingChunkReader;
import org.jaudiotagger.audio.asf.io.EncryptionChunkReader;
import org.jaudiotagger.audio.asf.io.FileHeaderReader;
import org.jaudiotagger.audio.asf.io.FullRequestInputStream;
import org.jaudiotagger.audio.asf.io.LanguageListReader;
import org.jaudiotagger.audio.asf.io.MetadataReader;
import org.jaudiotagger.audio.asf.io.RandomAccessFileInputstream;
import org.jaudiotagger.audio.asf.io.StreamBitratePropertiesReader;
import org.jaudiotagger.audio.asf.io.StreamChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

public class AsfHeaderReader
extends ChunkContainerReader<AsfHeader> {
    private static final GUID[] APPLYING;
    private static final AsfHeaderReader FULL_READER;
    private static final AsfHeaderReader INFO_READER;
    private static final AsfHeaderReader TAG_READER;

    static {
        AsfHeaderReader asfHeaderReader;
        AsfHeaderReader asfHeaderReader2;
        GUID[] arrgUID = new GUID[]{GUID.GUID_HEADER};
        APPLYING = arrgUID;
        ArrayList arrayList = new ArrayList();
        arrayList.add(FileHeaderReader.class);
        arrayList.add(StreamChunkReader.class);
        INFO_READER = new AsfHeaderReader((List<Class<? extends ChunkReader>>)arrayList, true);
        arrayList.clear();
        arrayList.add(ContentDescriptionReader.class);
        arrayList.add(ContentBrandingReader.class);
        arrayList.add(LanguageListReader.class);
        arrayList.add(MetadataReader.class);
        AsfExtHeaderReader asfExtHeaderReader = new AsfExtHeaderReader((List<Class<? extends ChunkReader>>)arrayList, true);
        AsfExtHeaderReader asfExtHeaderReader2 = new AsfExtHeaderReader((List<Class<? extends ChunkReader>>)arrayList, true);
        TAG_READER = asfHeaderReader2 = new AsfHeaderReader((List<Class<? extends ChunkReader>>)arrayList, true);
        asfHeaderReader2.setExtendedHeaderReader(asfExtHeaderReader);
        arrayList.add(FileHeaderReader.class);
        arrayList.add(StreamChunkReader.class);
        arrayList.add(EncodingChunkReader.class);
        arrayList.add(EncryptionChunkReader.class);
        arrayList.add(StreamBitratePropertiesReader.class);
        FULL_READER = asfHeaderReader = new AsfHeaderReader((List<Class<? extends ChunkReader>>)arrayList, false);
        asfHeaderReader.setExtendedHeaderReader(asfExtHeaderReader2);
    }

    public AsfHeaderReader(List<Class<? extends ChunkReader>> list, boolean bl) {
        super(list, bl);
    }

    private static InputStream createStream(RandomAccessFile randomAccessFile) {
        return new FullRequestInputStream((InputStream)new BufferedInputStream((InputStream)new RandomAccessFileInputstream(randomAccessFile)));
    }

    public static AsfHeader readHeader(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        AsfHeader asfHeader = (AsfHeader)FULL_READER.read(Utils.readGUID((InputStream)fileInputStream), (InputStream)fileInputStream, 0L);
        fileInputStream.close();
        return asfHeader;
    }

    public static AsfHeader readHeader(RandomAccessFile randomAccessFile) throws IOException {
        InputStream inputStream = AsfHeaderReader.createStream(randomAccessFile);
        return (AsfHeader)FULL_READER.read(Utils.readGUID(inputStream), inputStream, 0L);
    }

    public static AsfHeader readInfoHeader(RandomAccessFile randomAccessFile) throws IOException {
        InputStream inputStream = AsfHeaderReader.createStream(randomAccessFile);
        return (AsfHeader)INFO_READER.read(Utils.readGUID(inputStream), inputStream, 0L);
    }

    public static AsfHeader readTagHeader(RandomAccessFile randomAccessFile) throws IOException {
        InputStream inputStream = AsfHeaderReader.createStream(randomAccessFile);
        return (AsfHeader)TAG_READER.read(Utils.readGUID(inputStream), inputStream, 0L);
    }

    @Override
    public boolean canFail() {
        return false;
    }

    @Override
    protected AsfHeader createContainer(long l2, BigInteger bigInteger, InputStream inputStream) throws IOException {
        long l3 = Utils.readUINT32(inputStream);
        if (inputStream.read() == 1) {
            if (inputStream.read() == 2) {
                AsfHeader asfHeader = new AsfHeader(l2, bigInteger, l3);
                return asfHeader;
            }
            throw new IOException("No ASF");
        }
        throw new IOException("No ASF");
    }

    @Override
    public GUID[] getApplyingIds() {
        return (GUID[])APPLYING.clone();
    }

    public void setExtendedHeaderReader(AsfExtHeaderReader asfExtHeaderReader) {
        for (GUID gUID : asfExtHeaderReader.getApplyingIds()) {
            this.readerMap.put((Object)gUID, (Object)asfExtHeaderReader);
        }
    }
}

