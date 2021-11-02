/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.TextEncodedStringNullTerminated;
import org.jaudiotagger.tag.datatype.TextEncodedStringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public class MultipleTextEncodedStringNullTerminated
extends AbstractDataType {
    public MultipleTextEncodedStringNullTerminated(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
        this.value = new Object(){
            private List<String> valueList = new ArrayList();

            public void add(String string2) {
                this.valueList.add((Object)string2);
            }

            public List<String> getList() {
                return this.valueList;
            }

            public int getNumberOfValues() {
                return this.valueList.size();
            }

            public String toString() {
                StringBuffer stringBuffer = new StringBuffer();
                ListIterator listIterator = this.valueList.listIterator();
                while (listIterator.hasNext()) {
                    stringBuffer.append((String)listIterator.next());
                    if (!listIterator.hasNext()) continue;
                    stringBuffer.append(",");
                }
                return stringBuffer.toString();
            }
        };
    }

    public MultipleTextEncodedStringNullTerminated(MultipleTextEncodedStringNullTerminated multipleTextEncodedStringNullTerminated) {
        super(multipleTextEncodedStringNullTerminated);
    }

    public MultipleTextEncodedStringNullTerminated(TextEncodedStringSizeTerminated textEncodedStringSizeTerminated) {
        super(textEncodedStringSizeTerminated);
        this.value = new /* invalid duplicate definition of identical inner class */;
    }

    public boolean canBeEncoded() {
        ListIterator listIterator = (this.value).getList().listIterator();
        while (listIterator.hasNext()) {
            if (new TextEncodedStringNullTerminated(this.identifier, this.frameBody, (String)listIterator.next()).canBeEncoded()) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof MultipleTextEncodedStringNullTerminated && super.equals(object);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void readByteArray(byte[] var1, int var2) throws InvalidDataTypeException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl68.1 : GETSTATIC : trying to set 1 previously set to 0
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

    @Override
    public byte[] writeByteArray() {
        int n2;
        ListIterator listIterator;
        AbstractDataType.logger.finer("Writing MultipleTextEncodedStringNullTerminated");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            listIterator = (this.value).getList().listIterator();
            n2 = 0;
        }
        catch (IOException iOException) {
            AbstractDataType.logger.log(Level.SEVERE, "IOException in MultipleTextEncodedStringNullTerminated when writing byte array", (Throwable)iOException);
            throw new RuntimeException((Throwable)iOException);
        }
        do {
            if (!listIterator.hasNext()) break;
            TextEncodedStringNullTerminated textEncodedStringNullTerminated = new TextEncodedStringNullTerminated(this.identifier, this.frameBody, (String)listIterator.next());
            byteArrayOutputStream.write(textEncodedStringNullTerminated.writeByteArray());
            int n3 = textEncodedStringNullTerminated.getSize();
            n2 += n3;
        } while (true);
        this.size = n2;
        AbstractDataType.logger.finer("Written MultipleTextEncodedStringNullTerminated");
        return byteArrayOutputStream.toByteArray();
    }

}

