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
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.Pair;
import org.jaudiotagger.tag.datatype.TextEncodedStringNullTerminated;
import org.jaudiotagger.tag.datatype.TextEncodedStringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.utils.EqualsUtil;

public class PairedTextEncodedStringNullTerminated
extends AbstractDataType {
    public PairedTextEncodedStringNullTerminated(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
        this.value = new Object(){
            private List<Pair> mapping = new ArrayList();

            public void add(String string2, String string3) {
                this.mapping.add((Object)new Pair(string2, string3));
            }

            public void add(Pair pair) {
                this.mapping.add((Object)pair);
            }

            public boolean equals(Object object) {
                if (object == this) {
                    return true;
                }
                if (!(object instanceof ValuePairs)) {
                    return false;
                }
                ValuePairs valuePairs = object;
                return EqualsUtil.areEqual(this.getNumberOfValues(), valuePairs.getNumberOfValues());
            }

            public List<Pair> getMapping() {
                return this.mapping;
            }

            public int getNumberOfPairs() {
                return this.mapping.size();
            }

            public int getNumberOfValues() {
                return this.mapping.size();
            }

            public String toString() {
                StringBuffer stringBuffer = new StringBuffer();
                for (Pair pair : this.mapping) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(pair.getKey());
                    stringBuilder.append(':');
                    stringBuilder.append(pair.getValue());
                    stringBuilder.append(',');
                    stringBuffer.append(stringBuilder.toString());
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.setLength(-1 + stringBuffer.length());
                }
                return stringBuffer.toString();
            }
        };
    }

    public PairedTextEncodedStringNullTerminated(PairedTextEncodedStringNullTerminated pairedTextEncodedStringNullTerminated) {
        super(pairedTextEncodedStringNullTerminated);
    }

    public PairedTextEncodedStringNullTerminated(TextEncodedStringSizeTerminated textEncodedStringSizeTerminated) {
        super(textEncodedStringSizeTerminated);
        this.value = new /* invalid duplicate definition of identical inner class */;
    }

    public boolean canBeEncoded() {
        for (Pair pair : (this.value).mapping) {
            if (new TextEncodedStringNullTerminated(this.identifier, this.frameBody, pair.getValue()).canBeEncoded()) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PairedTextEncodedStringNullTerminated)) {
            return false;
        }
        PairedTextEncodedStringNullTerminated pairedTextEncodedStringNullTerminated = (PairedTextEncodedStringNullTerminated)object;
        return EqualsUtil.areEqual(this.value, pairedTextEncodedStringNullTerminated.value);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public ValuePairs getValue() {
        return this.value;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void readByteArray(byte[] var1, int var2) throws InvalidDataTypeException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public String toString() {
        return this.value.toString();
    }

    @Override
    public byte[] writeByteArray() {
        int n2;
        Iterator iterator;
        AbstractDataType.logger.finer("Writing PairTextEncodedStringNullTerminated");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            iterator = (this.value).mapping.iterator();
            n2 = 0;
        }
        catch (IOException iOException) {
            AbstractDataType.logger.log(Level.SEVERE, "IOException in MultipleTextEncodedStringNullTerminated when writing byte array", (Throwable)iOException);
            throw new RuntimeException((Throwable)iOException);
        }
        do {
            if (!iterator.hasNext()) break;
            Pair pair = (Pair)iterator.next();
            TextEncodedStringNullTerminated textEncodedStringNullTerminated = new TextEncodedStringNullTerminated(this.identifier, this.frameBody, pair.getKey());
            byteArrayOutputStream.write(textEncodedStringNullTerminated.writeByteArray());
            int n3 = n2 + textEncodedStringNullTerminated.getSize();
            TextEncodedStringNullTerminated textEncodedStringNullTerminated2 = new TextEncodedStringNullTerminated(this.identifier, this.frameBody, pair.getValue());
            byteArrayOutputStream.write(textEncodedStringNullTerminated2.writeByteArray());
            int n4 = textEncodedStringNullTerminated2.getSize();
            n2 = n3 + n4;
        } while (true);
        this.size = n2;
        AbstractDataType.logger.finer("Written PairTextEncodedStringNullTerminated");
        return byteArrayOutputStream.toByteArray();
    }

}

