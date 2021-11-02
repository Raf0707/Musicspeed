/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.nio.charset.Charset
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.mp4.atom;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.exceptions.InvalidBoxHeaderException;
import org.jaudiotagger.audio.exceptions.NullBoxIdException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.logging.ErrorMessage;

public class Mp4BoxHeader {
    public static final String CHARSET_UTF_8 = "UTF-8";
    public static final int HEADER_LENGTH = 8;
    public static final int IDENTIFIER_LENGTH = 4;
    public static final int IDENTIFIER_POS = 4;
    public static final int OFFSET_LENGTH = 4;
    public static final int OFFSET_POS;
    public static Logger logger;
    protected ByteBuffer dataBuffer;
    private long filePos;
    private String id;
    protected int length;

    static {
        logger = Logger.getLogger((String)"org.jaudiotagger.audio.mp4.atom");
    }

    public Mp4BoxHeader() {
    }

    public Mp4BoxHeader(String string2) {
        if (string2.length() == 4) {
            ByteBuffer byteBuffer;
            this.dataBuffer = byteBuffer = ByteBuffer.allocate((int)8);
            try {
                this.id = string2;
                byteBuffer.put(4, string2.getBytes("ISO-8859-1")[0]);
                this.dataBuffer.put(5, string2.getBytes("ISO-8859-1")[1]);
                this.dataBuffer.put(6, string2.getBytes("ISO-8859-1")[2]);
                this.dataBuffer.put(7, string2.getBytes("ISO-8859-1")[3]);
                return;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new RuntimeException((Throwable)unsupportedEncodingException);
            }
        }
        throw new RuntimeException("Invalid length:atom idenifier should always be 4 characters long");
    }

    public Mp4BoxHeader(ByteBuffer byteBuffer) {
        this.update(byteBuffer);
    }

    public static Mp4BoxHeader seekWithinLevel(ByteBuffer byteBuffer, String string2) throws IOException {
        Logger logger = Mp4BoxHeader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Started searching for:");
        stringBuilder.append(string2);
        stringBuilder.append(" in bytebuffer at");
        stringBuilder.append(byteBuffer.position());
        logger.finer(stringBuilder.toString());
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader();
        if (byteBuffer.remaining() >= 8) {
            mp4BoxHeader.update(byteBuffer);
            while (!mp4BoxHeader.getId().equals((Object)string2)) {
                Logger logger2 = Mp4BoxHeader.logger;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Found:");
                stringBuilder2.append(mp4BoxHeader.getId());
                stringBuilder2.append(" Still searching for:");
                stringBuilder2.append(string2);
                stringBuilder2.append(" in bytebuffer at");
                stringBuilder2.append(byteBuffer.position());
                logger2.finer(stringBuilder2.toString());
                if (mp4BoxHeader.getLength() < 8) {
                    return null;
                }
                if (byteBuffer.remaining() < mp4BoxHeader.getLength() - 8) {
                    return null;
                }
                byteBuffer.position(byteBuffer.position() + (mp4BoxHeader.getLength() - 8));
                if (byteBuffer.remaining() >= 8) {
                    mp4BoxHeader.update(byteBuffer);
                    continue;
                }
                return null;
            }
            Logger logger3 = Mp4BoxHeader.logger;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Found:");
            stringBuilder3.append(string2);
            stringBuilder3.append(" in bytebuffer at");
            stringBuilder3.append(byteBuffer.position());
            logger3.finer(stringBuilder3.toString());
            return mp4BoxHeader;
        }
        return null;
    }

    public static Mp4BoxHeader seekWithinLevel(FileChannel fileChannel, String string2) throws IOException {
        Logger logger = Mp4BoxHeader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Started searching for:");
        stringBuilder.append(string2);
        stringBuilder.append(" in file at:");
        stringBuilder.append(fileChannel.position());
        logger.finer(stringBuilder.toString());
        Mp4BoxHeader mp4BoxHeader = new Mp4BoxHeader();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)8);
        if (fileChannel.read(byteBuffer) != 8) {
            return null;
        }
        byteBuffer.rewind();
        mp4BoxHeader.update(byteBuffer);
        while (!mp4BoxHeader.getId().equals((Object)string2)) {
            Logger logger2 = Mp4BoxHeader.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Found:");
            stringBuilder2.append(mp4BoxHeader.getId());
            stringBuilder2.append(" Still searching for:");
            stringBuilder2.append(string2);
            stringBuilder2.append(" in file at:");
            stringBuilder2.append(fileChannel.position());
            logger2.finer(stringBuilder2.toString());
            if (mp4BoxHeader.getLength() < 8) {
                return null;
            }
            fileChannel.position(fileChannel.position() + (long)mp4BoxHeader.getDataLength());
            if (fileChannel.position() > fileChannel.size()) {
                return null;
            }
            byteBuffer.rewind();
            int n2 = fileChannel.read(byteBuffer);
            Logger logger3 = Mp4BoxHeader.logger;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Header Bytes Read:");
            stringBuilder3.append(n2);
            logger3.finer(stringBuilder3.toString());
            byteBuffer.rewind();
            if (n2 == 8) {
                mp4BoxHeader.update(byteBuffer);
                continue;
            }
            return null;
        }
        return mp4BoxHeader;
    }

    public int getDataLength() {
        return -8 + this.length;
    }

    public Charset getEncoding() {
        return StandardCharsets.UTF_8;
    }

    public long getFileEndPos() {
        return this.filePos + (long)this.length;
    }

    public long getFilePos() {
        return this.filePos;
    }

    public ByteBuffer getHeaderData() {
        this.dataBuffer.rewind();
        return this.dataBuffer;
    }

    public String getId() {
        return this.id;
    }

    public int getLength() {
        return this.length;
    }

    public void setFilePos(long l2) {
        this.filePos = l2;
    }

    public void setId(int n2) {
        byte[] arrby = Utils.getSizeBEInt32(n2);
        this.dataBuffer.put(5, arrby[0]);
        this.dataBuffer.put(6, arrby[1]);
        this.dataBuffer.put(7, arrby[2]);
        this.dataBuffer.put(8, arrby[3]);
        this.length = n2;
    }

    public void setLength(int n2) {
        byte[] arrby = Utils.getSizeBEInt32(n2);
        this.dataBuffer.put(0, arrby[0]);
        this.dataBuffer.put(1, arrby[1]);
        this.dataBuffer.put(2, arrby[2]);
        this.dataBuffer.put(3, arrby[3]);
        this.length = n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Box ");
        stringBuilder.append(this.id);
        stringBuilder.append(":length");
        stringBuilder.append(this.length);
        stringBuilder.append(":filepos:");
        stringBuilder.append(this.filePos);
        return stringBuilder.toString();
    }

    public void update(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        byte[] arrby = new byte[8];
        byteBuffer.get(arrby);
        this.dataBuffer = byteBuffer2 = ByteBuffer.wrap((byte[])arrby);
        byteBuffer2.order(ByteOrder.BIG_ENDIAN);
        this.length = this.dataBuffer.getInt();
        this.id = Utils.readFourBytesAsChars(this.dataBuffer);
        Logger logger = Mp4BoxHeader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mp4BoxHeader id:");
        stringBuilder.append(this.id);
        stringBuilder.append(":length:");
        stringBuilder.append(this.length);
        logger.finest(stringBuilder.toString());
        if (!this.id.equals((Object)"\u0000\u0000\u0000\u0000")) {
            if (this.length >= 8) {
                return;
            }
            ErrorMessage errorMessage = ErrorMessage.MP4_UNABLE_TO_FIND_NEXT_ATOM_BECAUSE_IDENTIFIER_IS_INVALID;
            Object[] arrobject = new Object[]{this.id, this.length};
            throw new InvalidBoxHeaderException(errorMessage.getMsg(arrobject));
        }
        ErrorMessage errorMessage = ErrorMessage.MP4_UNABLE_TO_FIND_NEXT_ATOM_BECAUSE_IDENTIFIER_IS_INVALID;
        Object[] arrobject = new Object[]{this.id};
        throw new NullBoxIdException(errorMessage.getMsg(arrobject));
    }
}

