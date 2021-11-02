/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Set
 */
package org.jaudiotagger.tag.lyrics3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagNotFoundException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.jaudiotagger.tag.lyrics3.AbstractLyrics3;
import org.jaudiotagger.tag.lyrics3.AbstractLyrics3v2FieldFrameBody;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyIND;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyLYR;
import org.jaudiotagger.tag.lyrics3.Lyrics3v2Field;

public class Lyrics3v2
extends AbstractLyrics3 {
    private HashMap<String, Lyrics3v2Field> fieldMap;

    public Lyrics3v2() {
        this.fieldMap = new HashMap();
    }

    public Lyrics3v2(ByteBuffer byteBuffer) throws TagNotFoundException, IOException {
        this.fieldMap = new HashMap();
        try {
            this.read(byteBuffer);
            return;
        }
        catch (TagException tagException) {
            tagException.printStackTrace();
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public Lyrics3v2(AbstractTag var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl40 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public Lyrics3v2(Lyrics3v2 lyrics3v2) {
        super(lyrics3v2);
        this.fieldMap = new HashMap();
        for (String string2 : lyrics3v2.fieldMap.keySet()) {
            Lyrics3v2Field lyrics3v2Field = new Lyrics3v2Field((Lyrics3v2Field)lyrics3v2.fieldMap.get((Object)string2));
            this.fieldMap.put((Object)string2, (Object)lyrics3v2Field);
        }
    }

    private int seekSize(ByteBuffer byteBuffer) {
        return -1;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Lyrics3v2)) {
            return false;
        }
        Lyrics3v2 lyrics3v2 = (Lyrics3v2)object;
        boolean bl = this.fieldMap.equals(lyrics3v2.fieldMap);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = AbstractTag.super.equals(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public Lyrics3v2Field getField(String string2) {
        return (Lyrics3v2Field)this.fieldMap.get((Object)string2);
    }

    public int getFieldCount() {
        return this.fieldMap.size();
    }

    @Override
    public String getIdentifier() {
        return "Lyrics3v2.00";
    }

    @Override
    public int getSize() {
        Iterator iterator = this.fieldMap.values().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += ((Lyrics3v2Field)iterator.next()).getSize();
        }
        return n2 + 11;
    }

    public boolean hasField(String string2) {
        return this.fieldMap.containsKey((Object)string2);
    }

    public Iterator<Lyrics3v2Field> iterator() {
        return this.fieldMap.values().iterator();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void read(ByteBuffer var1) throws TagException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl21 : ALOAD_1 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public void removeField(String string2) {
        this.fieldMap.remove((Object)string2);
    }

    public boolean seek(RandomAccessFile randomAccessFile) throws IOException {
        block4 : {
            byte[] arrby;
            long l2;
            block3 : {
                block2 : {
                    arrby = new byte[11];
                    randomAccessFile.seek(randomAccessFile.length() - 128L - 9L);
                    randomAccessFile.read(arrby, 0, 9);
                    if (!new String(arrby, 0, 9).equals((Object)"LYRICS200")) break block2;
                    l2 = randomAccessFile.getFilePointer();
                    break block3;
                }
                randomAccessFile.seek(randomAccessFile.length() - 9L);
                randomAccessFile.read(arrby, 0, 9);
                if (!new String(arrby, 0, 9).equals((Object)"LYRICS200")) break block4;
                l2 = randomAccessFile.getFilePointer();
            }
            long l3 = l2 - 15L;
            randomAccessFile.seek(l3);
            randomAccessFile.read(arrby, 0, 6);
            randomAccessFile.seek(l3 - (long)Integer.parseInt((String)new String(arrby, 0, 6)));
            randomAccessFile.read(arrby, 0, 11);
            return new String(arrby, 0, 11).equals((Object)"LYRICSBEGIN");
        }
        return false;
    }

    @Override
    public boolean seek(ByteBuffer byteBuffer) {
        return false;
    }

    public void setField(Lyrics3v2Field lyrics3v2Field) {
        this.fieldMap.put((Object)lyrics3v2Field.getIdentifier(), (Object)lyrics3v2Field);
    }

    public String toString() {
        Iterator iterator = this.fieldMap.values().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getIdentifier());
        stringBuilder.append(" ");
        stringBuilder.append(this.getSize());
        stringBuilder.append("\n");
        String string2 = stringBuilder.toString();
        while (iterator.hasNext()) {
            Lyrics3v2Field lyrics3v2Field = (Lyrics3v2Field)iterator.next();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(lyrics3v2Field.toString());
            stringBuilder2.append("\n");
            string2 = stringBuilder2.toString();
        }
        return string2;
    }

    public void updateField(String string2) {
        if (string2.equals((Object)"IND")) {
            boolean bl = this.fieldMap.containsKey((Object)"LYR");
            boolean bl2 = false;
            if (bl) {
                bl2 = ((FieldFrameBodyLYR)((Lyrics3v2Field)this.fieldMap.get((Object)"LYR")).getBody()).hasTimeStamp();
            }
            this.setField(new Lyrics3v2Field(new FieldFrameBodyIND(bl, bl2)));
        }
    }

    @Override
    public void write(RandomAccessFile randomAccessFile) throws IOException {
        byte[] arrby = new byte[15];
        new ID3v1Tag();
        this.delete(randomAccessFile);
        randomAccessFile.seek(randomAccessFile.length());
        long l2 = randomAccessFile.getFilePointer();
        for (int i2 = 0; i2 < 11; ++i2) {
            arrby[i2] = (byte)"LYRICSBEGIN".charAt(i2);
        }
        randomAccessFile.write(arrby, 0, 11);
        this.updateField("IND");
        ((Lyrics3v2Field)this.fieldMap.get((Object)"IND")).write(randomAccessFile);
        for (Lyrics3v2Field lyrics3v2Field : this.fieldMap.values()) {
            String string2 = lyrics3v2Field.getIdentifier();
            boolean bl = TagOptionSingleton.getInstance().getLyrics3SaveField(string2);
            if (string2.equals((Object)"IND") || !bl) continue;
            lyrics3v2Field.write(randomAccessFile);
        }
        long l3 = randomAccessFile.getFilePointer() - l2;
        this.getSize();
        String string3 = Long.toString((long)l3);
        for (int i3 = 0; i3 < 6 - string3.length(); ++i3) {
            arrby[i3] = 48;
        }
        int n2 = 0 + (6 - string3.length());
        for (int i4 = 0; i4 < string3.length(); ++i4) {
            arrby[i4 + n2] = (byte)string3.charAt(i4);
        }
        int n3 = n2 + string3.length();
        for (int i5 = 0; i5 < 9; ++i5) {
            arrby[i5 + n3] = (byte)"LYRICS200".charAt(i5);
        }
        randomAccessFile.write(arrby, 0, n3 + 9);
    }
}

