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
package org.jaudiotagger.audio.wav.chunk;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.wav.WavTag;

public class WavId3Chunk
extends Chunk {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.wav.chunk");
    private WavTag wavTag;

    public WavId3Chunk(ByteBuffer byteBuffer, ChunkHeader chunkHeader, WavTag wavTag) {
        super(byteBuffer, chunkHeader);
        this.wavTag = wavTag;
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
                AudioFile.logger.finest("Reading ID3V2.4 tag");
            } else {
                iD3v22Tag = new ID3v23Tag();
                AudioFile.logger.finest("Reading ID3V2.3 tag");
            }
        } else {
            iD3v22Tag = new ID3v22Tag();
            AudioFile.logger.finest("Reading ID3V2.2 tag");
        }
        iD3v22Tag.setStartLocationInFile(8L + this.chunkHeader.getStartLocationInFile());
        iD3v22Tag.setEndLocationInFile(8L + this.chunkHeader.getStartLocationInFile() + this.chunkHeader.getSize());
        this.wavTag.setExistingId3Tag(true);
        this.wavTag.setID3Tag((AbstractID3v2Tag)iD3v22Tag);
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

