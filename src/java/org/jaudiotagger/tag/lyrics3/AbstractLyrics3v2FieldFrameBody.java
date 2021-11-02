/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.ListIterator
 */
package org.jaudiotagger.tag.lyrics3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.ListIterator;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public abstract class AbstractLyrics3v2FieldFrameBody
extends AbstractTagFrameBody {
    public AbstractLyrics3v2FieldFrameBody() {
    }

    public AbstractLyrics3v2FieldFrameBody(AbstractLyrics3v2FieldFrameBody abstractLyrics3v2FieldFrameBody) {
        super(abstractLyrics3v2FieldFrameBody);
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidTagException {
        int n2 = this.getSize();
        byte[] arrby = new byte[n2];
        byteBuffer.get(arrby);
        ListIterator listIterator = this.objectList.listIterator();
        int n3 = 0;
        while (listIterator.hasNext()) {
            if (n3 <= n2 - 1) {
                AbstractDataType abstractDataType = (AbstractDataType)listIterator.next();
                abstractDataType.readByteArray(arrby, n3);
                n3 += abstractDataType.getSize();
                continue;
            }
            throw new InvalidTagException("Invalid size for Frame Body");
        }
    }

    protected int readHeader(RandomAccessFile randomAccessFile) throws InvalidTagException, IOException {
        byte[] arrby = new byte[5];
        randomAccessFile.read(arrby, 0, 5);
        int n2 = Integer.parseInt((String)new String(arrby, 0, 5));
        if (n2 == 0) {
            if (TagOptionSingleton.getInstance().isLyrics3KeepEmptyFieldIfRead()) {
                return n2;
            }
            throw new InvalidTagException("Lyircs3v2 Field has size of zero.");
        }
        return n2;
    }

    public void write(RandomAccessFile randomAccessFile) throws IOException {
        ListIterator listIterator = this.objectList.listIterator();
        while (listIterator.hasNext()) {
            randomAccessFile.write(((AbstractDataType)listIterator.next()).writeByteArray());
        }
    }

    protected void writeHeader(RandomAccessFile randomAccessFile, int n2) throws IOException {
        byte[] arrby = new byte[5];
        String string2 = Integer.toString((int)this.getSize());
        int n3 = 0;
        for (int i2 = 0; i2 < 5 - string2.length(); ++i2) {
            arrby[i2] = 48;
        }
        int n4 = 0 + (5 - string2.length());
        while (n3 < string2.length()) {
            arrby[n3 + n4] = (byte)string2.charAt(n3);
            ++n3;
        }
        randomAccessFile.write(arrby);
    }
}

