/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.Arrays
 */
package org.jaudiotagger.tag.lyrics3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.lyrics3.AbstractLyrics3v2FieldFrameBody;

public class FieldFrameBodyUnsupported
extends AbstractLyrics3v2FieldFrameBody {
    private byte[] value = null;

    public FieldFrameBodyUnsupported() {
    }

    public FieldFrameBodyUnsupported(ByteBuffer byteBuffer) throws InvalidTagException {
        this.read(byteBuffer);
    }

    public FieldFrameBodyUnsupported(FieldFrameBodyUnsupported fieldFrameBodyUnsupported) {
        super(fieldFrameBodyUnsupported);
        this.value = (byte[])fieldFrameBodyUnsupported.value.clone();
    }

    public FieldFrameBodyUnsupported(byte[] arrby) {
        this.value = arrby;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FieldFrameBodyUnsupported)) {
            return false;
        }
        FieldFrameBodyUnsupported fieldFrameBodyUnsupported = (FieldFrameBodyUnsupported)object;
        boolean bl = Arrays.equals((byte[])this.value, (byte[])fieldFrameBodyUnsupported.value);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = AbstractTagFrameBody.super.equals(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public String getIdentifier() {
        return "ZZZ";
    }

    @Override
    public boolean isSubsetOf(Object object) {
        if (!(object instanceof FieldFrameBodyUnsupported)) {
            return false;
        }
        FieldFrameBodyUnsupported fieldFrameBodyUnsupported = (FieldFrameBodyUnsupported)object;
        String string2 = new String(this.value);
        boolean bl = new String(fieldFrameBodyUnsupported.value).contains((CharSequence)string2);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = AbstractTagFrameBody.super.isSubsetOf(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidTagException {
        byte[] arrby = new byte[5];
        byteBuffer.get(arrby, 0, 5);
        byte[] arrby2 = new byte[Integer.parseInt((String)new String(arrby, 0, 5))];
        this.value = arrby2;
        byteBuffer.get(arrby2);
    }

    @Override
    protected void setupObjectList() {
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getIdentifier());
        stringBuilder.append(" : ");
        stringBuilder.append(new String(this.value));
        return stringBuilder.toString();
    }

    @Override
    public void write(RandomAccessFile randomAccessFile) throws IOException {
        byte[] arrby = new byte[5];
        String string2 = Integer.toString((int)this.value.length);
        int n2 = 0;
        for (int i2 = 0; i2 < 5 - string2.length(); ++i2) {
            arrby[i2] = 48;
        }
        int n3 = 0 + (5 - string2.length());
        while (n2 < string2.length()) {
            arrby[n2 + n3] = (byte)string2.charAt(n2);
            ++n2;
        }
        randomAccessFile.write(arrby);
        randomAccessFile.write(this.value);
    }
}

