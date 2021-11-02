/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.util.Arrays
 *  java.util.logging.Logger
 *  java.util.regex.Pattern
 */
package org.jaudiotagger.tag.id3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.jaudiotagger.tag.id3.AbstractID3Tag;

public abstract class AbstractID3v1Tag
extends AbstractID3Tag {
    protected static final byte END_OF_FIELD = 0;
    protected static final int FIELD_ALBUM_LENGTH = 30;
    protected static final int FIELD_ALBUM_POS = 63;
    protected static final int FIELD_ARTIST_LENGTH = 30;
    protected static final int FIELD_ARTIST_POS = 33;
    protected static final int FIELD_GENRE_LENGTH = 1;
    protected static final int FIELD_GENRE_POS = 127;
    protected static final int FIELD_TAGID_LENGTH = 3;
    protected static final int FIELD_TAGID_POS = 0;
    protected static final int FIELD_TITLE_LENGTH = 30;
    protected static final int FIELD_TITLE_POS = 3;
    protected static final int FIELD_YEAR_LENGTH = 4;
    protected static final int FIELD_YEAR_POS = 93;
    public static final String TAG = "TAG";
    protected static final int TAG_DATA_LENGTH = 125;
    protected static final byte[] TAG_ID;
    protected static final int TAG_LENGTH = 128;
    protected static final String TYPE_ALBUM = "album";
    protected static final String TYPE_ARTIST = "artist";
    protected static final String TYPE_GENRE = "genre";
    protected static final String TYPE_TITLE = "title";
    protected static final String TYPE_YEAR = "year";
    protected static Pattern endofStringPattern;
    public static Logger logger;

    static {
        logger = Logger.getLogger((String)"org.jaudiotagger.tag.id3");
        endofStringPattern = Pattern.compile((String)"\\x00");
        TAG_ID = new byte[]{84, 65, 71};
    }

    public AbstractID3v1Tag() {
    }

    public AbstractID3v1Tag(AbstractID3v1Tag abstractID3v1Tag) {
        super(abstractID3v1Tag);
    }

    public static boolean seekForV1OrV11Tag(ByteBuffer byteBuffer) {
        byte[] arrby = new byte[3];
        byteBuffer.get(arrby, 0, 3);
        return Arrays.equals((byte[])arrby, (byte[])TAG_ID);
    }

    @Override
    public void delete(RandomAccessFile randomAccessFile) throws IOException {
        logger.config("Deleting ID3v1 from file if exists");
        FileChannel fileChannel = randomAccessFile.getChannel();
        if (randomAccessFile.length() >= 128L) {
            fileChannel.position(randomAccessFile.length() - 128L);
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)128);
            fileChannel.read(byteBuffer);
            byteBuffer.rewind();
            if (AbstractID3v1Tag.seekForV1OrV11Tag(byteBuffer)) {
                try {
                    logger.config("Deleted ID3v1 tag");
                    randomAccessFile.setLength(randomAccessFile.length() - 128L);
                    return;
                }
                catch (IOException iOException) {
                    Logger logger = AbstractID3v1Tag.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to delete existing ID3v1 Tag:");
                    stringBuilder.append(iOException.getMessage());
                    logger.severe(stringBuilder.toString());
                    return;
                }
            }
            logger.config("Unable to find ID3v1 tag to deleteField");
            return;
        }
        throw new IOException("File not not appear large enough to contain a tag");
    }

    @Override
    public int getSize() {
        return 128;
    }
}

