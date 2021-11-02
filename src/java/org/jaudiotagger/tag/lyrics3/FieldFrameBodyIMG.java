/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package org.jaudiotagger.tag.lyrics3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.datatype.Lyrics3Image;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.lyrics3.AbstractLyrics3v2FieldFrameBody;
import org.jaudiotagger.tag.lyrics3.Lyrics3v2Fields;

public class FieldFrameBodyIMG
extends AbstractLyrics3v2FieldFrameBody {
    private ArrayList<Lyrics3Image> images;

    public FieldFrameBodyIMG() {
        this.images = new ArrayList();
    }

    public FieldFrameBodyIMG(String string2) {
        this.images = new ArrayList();
        this.readString(string2);
    }

    public FieldFrameBodyIMG(ByteBuffer byteBuffer) throws InvalidTagException {
        this.images = new ArrayList();
        this.read(byteBuffer);
    }

    public FieldFrameBodyIMG(Lyrics3Image lyrics3Image) {
        ArrayList arrayList;
        this.images = arrayList = new ArrayList();
        arrayList.add((Object)lyrics3Image);
    }

    public FieldFrameBodyIMG(FieldFrameBodyIMG fieldFrameBodyIMG) {
        super(fieldFrameBodyIMG);
        this.images = new ArrayList();
        for (int i2 = 0; i2 < fieldFrameBodyIMG.images.size(); ++i2) {
            Lyrics3Image lyrics3Image = (Lyrics3Image)fieldFrameBodyIMG.images.get(i2);
            this.images.add((Object)new Lyrics3Image(lyrics3Image));
        }
    }

    private void readString(String string2) {
        int n2 = string2.indexOf(Lyrics3v2Fields.CRLF);
        this.images = new ArrayList();
        int n3 = 0;
        while (n2 >= 0) {
            String string3 = string2.substring(n3, n2);
            Lyrics3Image lyrics3Image = new Lyrics3Image("Image", this);
            lyrics3Image.setFilename(string3);
            this.images.add((Object)lyrics3Image);
            String string4 = Lyrics3v2Fields.CRLF;
            int n4 = n2 + string4.length();
            int n5 = string2.indexOf(string4, n4);
            n3 = n4;
            n2 = n5;
        }
        if (n3 < string2.length()) {
            String string5 = string2.substring(n3);
            Lyrics3Image lyrics3Image = new Lyrics3Image("Image", this);
            lyrics3Image.setFilename(string5);
            this.images.add((Object)lyrics3Image);
        }
    }

    private String writeString() {
        Iterator iterator = this.images.iterator();
        String string2 = "";
        while (iterator.hasNext()) {
            Lyrics3Image lyrics3Image = (Lyrics3Image)iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(lyrics3Image.writeString());
            stringBuilder.append(Lyrics3v2Fields.CRLF);
            string2 = stringBuilder.toString();
        }
        if (string2.length() > 2) {
            return string2.substring(0, string2.length() - 2);
        }
        return string2;
    }

    public void addImage(Lyrics3Image lyrics3Image) {
        this.images.add((Object)lyrics3Image);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FieldFrameBodyIMG)) {
            return false;
        }
        FieldFrameBodyIMG fieldFrameBodyIMG = (FieldFrameBodyIMG)object;
        boolean bl = this.images.equals(fieldFrameBodyIMG.images);
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
        return "IMG";
    }

    @Override
    public int getSize() {
        Iterator iterator = this.images.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += 2 + ((Lyrics3Image)iterator.next()).getSize();
        }
        return n2 - 2;
    }

    public String getValue() {
        return this.writeString();
    }

    @Override
    public boolean isSubsetOf(Object object) {
        if (!(object instanceof FieldFrameBodyIMG)) {
            return false;
        }
        ArrayList<Lyrics3Image> arrayList = ((FieldFrameBodyIMG)object).images;
        Iterator iterator = this.images.iterator();
        while (iterator.hasNext()) {
            if (arrayList.contains(iterator.next())) continue;
            return false;
        }
        return AbstractTagFrameBody.super.isSubsetOf(object);
    }

    public Iterator<Lyrics3Image> iterator() {
        return this.images.iterator();
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidTagException {
        byte[] arrby = new byte[5];
        byteBuffer.get(arrby, 0, 5);
        int n2 = Integer.parseInt((String)new String(arrby, 0, 5));
        if (n2 == 0 && !TagOptionSingleton.getInstance().isLyrics3KeepEmptyFieldIfRead()) {
            throw new InvalidTagException("Lyircs3v2 Field has size of zero.");
        }
        byte[] arrby2 = new byte[n2];
        byteBuffer.get(arrby2);
        this.readString(new String(arrby2));
    }

    public void setValue(String string2) {
        this.readString(string2);
    }

    @Override
    protected void setupObjectList() {
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getIdentifier());
        stringBuilder.append(" : ");
        String string2 = stringBuilder.toString();
        for (Object object : this.images) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(object.toString());
            stringBuilder2.append(" ; ");
            string2 = stringBuilder2.toString();
        }
        return string2;
    }

    @Override
    public void write(RandomAccessFile randomAccessFile) throws IOException {
        byte[] arrby = new byte[5];
        int n2 = this.getSize();
        String string2 = Integer.toString((int)n2);
        int n3 = 0;
        for (int i2 = 0; i2 < 5 - string2.length(); ++i2) {
            arrby[i2] = 48;
        }
        int n4 = 0 + (5 - string2.length());
        for (int i3 = 0; i3 < string2.length(); ++i3) {
            arrby[i3 + n4] = (byte)string2.charAt(i3);
        }
        string2.length();
        randomAccessFile.write(arrby, 0, 5);
        if (n2 > 0) {
            String string3 = this.writeString();
            byte[] arrby2 = new byte[string3.length()];
            while (n3 < string3.length()) {
                arrby2[n3] = (byte)string3.charAt(n3);
                ++n3;
            }
            randomAccessFile.write(arrby2);
        }
    }
}

