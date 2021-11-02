/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.DataInput
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.audio.real;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.Utils;

public class RealChunk {
    protected static final String CONT = "CONT";
    protected static final String DATA = "DATA";
    protected static final String INDX = "INDX";
    protected static final String MDPR = "MDPR";
    protected static final String PROP = "PROP";
    protected static final String RMF = ".RMF";
    private final byte[] bytes;
    private final String id;
    private final int size;

    public RealChunk(String string2, int n2, byte[] arrby) {
        this.id = string2;
        this.size = n2;
        this.bytes = arrby;
    }

    public static RealChunk readChunk(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        String string2 = Utils.readString((DataInput)randomAccessFile, 4);
        int n2 = (int)Utils.readUint32((DataInput)randomAccessFile);
        if (n2 >= 8) {
            if ((long)n2 <= 8L + (randomAccessFile.length() - randomAccessFile.getFilePointer())) {
                byte[] arrby = new byte[n2 - 8];
                randomAccessFile.readFully(arrby);
                return new RealChunk(string2, n2, arrby);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Corrupt file: RealAudio chunk length of ");
            stringBuilder.append(n2);
            stringBuilder.append(" at position ");
            stringBuilder.append(randomAccessFile.getFilePointer() - 4L);
            stringBuilder.append(" extends beyond the end of the file");
            throw new CannotReadException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Corrupt file: RealAudio chunk length at position ");
        stringBuilder.append(randomAccessFile.getFilePointer() - 4L);
        stringBuilder.append(" cannot be less than 8");
        throw new CannotReadException(stringBuilder.toString());
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public DataInputStream getDataInputStream() {
        return new DataInputStream((InputStream)new ByteArrayInputStream(this.getBytes()));
    }

    public String getId() {
        return this.id;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isCONT() {
        return CONT.equals((Object)this.id);
    }

    public boolean isPROP() {
        return PROP.equals((Object)this.id);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.id);
        stringBuilder.append("\t");
        stringBuilder.append(this.size);
        return stringBuilder.toString();
    }
}

