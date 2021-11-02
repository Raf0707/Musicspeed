/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.flac;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;
import org.jaudiotagger.audio.flac.metadatablock.BlockType;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPadding;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockHeader;
import org.jaudiotagger.audio.generic.AbstractTagCreator;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.flac.FlacTag;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentCreator;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;

public class FlacTagCreator
extends AbstractTagCreator {
    public static final int DEFAULT_PADDING = 4000;
    private static final VorbisCommentCreator creator;
    public static Logger logger;

    static {
        logger = Logger.getLogger((String)"org.jaudiotagger.audio.flac");
        creator = new VorbisCommentCreator();
    }

    @Override
    public ByteBuffer convert(Tag tag, int n2) throws UnsupportedEncodingException {
        int n3;
        ByteBuffer byteBuffer;
        Logger logger = FlacTagCreator.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Convert flac tag:padding:");
        stringBuilder.append(n2);
        logger.config(stringBuilder.toString());
        FlacTag flacTag = (FlacTag)tag;
        if (flacTag.getVorbisCommentTag() != null) {
            byteBuffer = creator.convert(flacTag.getVorbisCommentTag());
            n3 = 4 + byteBuffer.capacity();
        } else {
            byteBuffer = null;
            n3 = 0;
        }
        Iterator iterator = flacTag.getImages().iterator();
        while (iterator.hasNext()) {
            n3 += 4 + ((MetadataBlockDataPicture)iterator.next()).getBytes().limit();
        }
        Logger logger2 = FlacTagCreator.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Convert flac tag:taglength:");
        stringBuilder2.append(n3);
        logger2.config(stringBuilder2.toString());
        ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)(n3 + n2));
        if (flacTag.getVorbisCommentTag() != null) {
            MetadataBlockHeader metadataBlockHeader = n2 <= 0 && flacTag.getImages().size() <= 0 ? new MetadataBlockHeader(true, BlockType.VORBIS_COMMENT, byteBuffer.capacity()) : new MetadataBlockHeader(false, BlockType.VORBIS_COMMENT, byteBuffer.capacity());
            byteBuffer2.put(metadataBlockHeader.getBytes());
            byteBuffer2.put(byteBuffer);
        }
        ListIterator listIterator = flacTag.getImages().listIterator();
        while (listIterator.hasNext()) {
            MetadataBlockDataPicture metadataBlockDataPicture = (MetadataBlockDataPicture)listIterator.next();
            MetadataBlockHeader metadataBlockHeader = n2 <= 0 && !listIterator.hasNext() ? new MetadataBlockHeader(true, BlockType.PICTURE, metadataBlockDataPicture.getLength()) : new MetadataBlockHeader(false, BlockType.PICTURE, metadataBlockDataPicture.getLength());
            byteBuffer2.put(metadataBlockHeader.getBytes());
            byteBuffer2.put(metadataBlockDataPicture.getBytes());
        }
        Logger logger3 = FlacTagCreator.logger;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Convert flac tag at");
        stringBuilder3.append(byteBuffer2.position());
        logger3.config(stringBuilder3.toString());
        if (n2 > 0) {
            int n4 = n2 - 4;
            MetadataBlockHeader metadataBlockHeader = new MetadataBlockHeader(true, BlockType.PADDING, n4);
            MetadataBlockDataPadding metadataBlockDataPadding = new MetadataBlockDataPadding(n4);
            byteBuffer2.put(metadataBlockHeader.getBytes());
            byteBuffer2.put(metadataBlockDataPadding.getBytes());
        }
        byteBuffer2.rewind();
        return byteBuffer2;
    }
}

