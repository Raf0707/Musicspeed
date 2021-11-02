/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 *  org.jaudiotagger.tag.id3.ID3v22Tag
 *  org.jaudiotagger.tag.id3.ID3v23Tag
 *  org.jaudiotagger.tag.id3.ID3v24Tag
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.aiff.AiffTag;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;

public class ID3Chunk
extends Chunk {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.aiff.chunk");
    private AiffTag aiffTag;

    public ID3Chunk(ChunkHeader chunkHeader, ByteBuffer byteBuffer, AiffTag aiffTag) {
        super(byteBuffer, chunkHeader);
        this.aiffTag = aiffTag;
    }

    private boolean isId3v2Tag(ByteBuffer byteBuffer) throws IOException {
        for (int i2 = 0; i2 < 3; ++i2) {
            if (byteBuffer.get() == AbstractID3v2Tag.TAG_ID[i2]) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean readChunk() throws IOException {
        ID3v22Tag iD3v22Tag;
        AudioFile.logger.severe("Reading chunk");
        if (!this.isId3v2Tag(this.chunkData)) {
            logger.severe("Invalid ID3 header for ID3 chunk");
            return false;
        }
        byte by = this.chunkData.get();
        if (by != 2) {
            if (by != 3) {
                if (by != 4) {
                    return false;
                }
                iD3v22Tag = new ID3v24Tag();
                AudioFile.logger.severe("Reading ID3V2.4 tag");
            } else {
                iD3v22Tag = new ID3v23Tag();
                AudioFile.logger.severe("Reading ID3V2.3 tag");
            }
        } else {
            iD3v22Tag = new ID3v22Tag();
            AudioFile.logger.severe("Reading ID3V2.2 tag");
        }
        this.aiffTag.setID3Tag((AbstractID3v2Tag)iD3v22Tag);
        this.chunkData.position(0);
        try {
            iD3v22Tag.read(this.chunkData);
            return true;
        }
        catch (TagException tagException) {
            Logger logger = AudioFile.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception reading ID3 tag: ");
            stringBuilder.append(tagException.getClass().getName());
            stringBuilder.append(": ");
            stringBuilder.append(tagException.getMessage());
            logger.info(stringBuilder.toString());
            return false;
        }
    }
}

