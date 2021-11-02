/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package org.jaudiotagger.audio.asf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.asf.data.AsfExtendedHeader;
import org.jaudiotagger.audio.asf.data.AsfHeader;
import org.jaudiotagger.audio.asf.data.ChunkContainer;
import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.MetadataContainer;
import org.jaudiotagger.audio.asf.io.AsfExtHeaderModifier;
import org.jaudiotagger.audio.asf.io.AsfHeaderReader;
import org.jaudiotagger.audio.asf.io.AsfStreamer;
import org.jaudiotagger.audio.asf.io.ChunkModifier;
import org.jaudiotagger.audio.asf.io.RandomAccessFileInputstream;
import org.jaudiotagger.audio.asf.io.RandomAccessFileOutputStream;
import org.jaudiotagger.audio.asf.io.WriteableChunk;
import org.jaudiotagger.audio.asf.io.WriteableChunkModifer;
import org.jaudiotagger.audio.asf.util.TagConverter;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.AudioFileWriter;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.asf.AsfTag;

public class AsfFileWriter
extends AudioFileWriter {
    static final /* synthetic */ boolean $assertionsDisabled;

    private boolean[] searchExistence(ChunkContainer chunkContainer, MetadataContainer[] arrmetadataContainer) {
        int n2 = arrmetadataContainer.length;
        boolean[] arrbl = new boolean[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            arrbl[i2] = chunkContainer.hasChunkByGUID(arrmetadataContainer[i2].getContainerType().getContainerGUID());
        }
        return arrbl;
    }

    @Override
    protected void deleteTag(Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotWriteException, IOException {
        this.writeTag(null, new AsfTag(true), randomAccessFile, randomAccessFile2);
    }

    @Override
    protected void writeTag(AudioFile audioFile, Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotWriteException, IOException {
        AsfHeader asfHeader = AsfHeaderReader.readTagHeader(randomAccessFile);
        randomAccessFile.seek(0L);
        MetadataContainer[] arrmetadataContainer = TagConverter.distributeMetadata(new AsfTag(tag, true));
        boolean[] arrbl = this.searchExistence(asfHeader, arrmetadataContainer);
        boolean[] arrbl2 = this.searchExistence(asfHeader.getExtendedHeader(), arrmetadataContainer);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrmetadataContainer.length; ++i2) {
            WriteableChunkModifer writeableChunkModifer = new WriteableChunkModifer(arrmetadataContainer[i2]);
            if (arrbl[i2]) {
                arrayList.add((Object)writeableChunkModifer);
                continue;
            }
            if (arrbl2[i2]) {
                arrayList2.add((Object)writeableChunkModifer);
                continue;
            }
            if (i2 != 0 && i2 != 2 && i2 != 1) {
                arrayList2.add((Object)writeableChunkModifer);
                continue;
            }
            arrayList.add((Object)writeableChunkModifer);
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add((Object)new AsfExtHeaderModifier((List<ChunkModifier>)arrayList2));
        }
        new AsfStreamer().createModifiedCopy(new RandomAccessFileInputstream(randomAccessFile), new RandomAccessFileOutputStream(randomAccessFile2), (List<ChunkModifier>)arrayList);
    }
}

