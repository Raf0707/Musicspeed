/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.ArrayList
 *  java.util.List
 */
package org.jaudiotagger.audio.mp4.atom;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.mp4.atom.AbstractMp4Box;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;

public class Mp4FtypBox
extends AbstractMp4Box {
    private static final int COMPATIBLE_BRAND_LENGTH = 4;
    private static final int MAJOR_BRAND_LENGTH = 4;
    private static final int MAJOR_BRAND_POS = 0;
    private static final int MAJOR_BRAND_VERSION_LENGTH = 4;
    private static final int MAJOR_BRAND_VERSION_POS = 4;
    private List<String> compatibleBrands = new ArrayList();
    private String majorBrand;
    private int majorBrandVersion;

    public Mp4FtypBox(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) {
        this.header = mp4BoxHeader;
        this.dataBuffer = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public List<String> getCompatibleBrands() {
        return this.compatibleBrands;
    }

    public String getMajorBrand() {
        return this.majorBrand;
    }

    public int getMajorBrandVersion() {
        return this.majorBrandVersion;
    }

    /*
     * Exception decompiling
     */
    public void processData() throws CannotReadException {
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Major Brand:");
        stringBuilder.append(this.majorBrand);
        stringBuilder.append("Version:");
        stringBuilder.append(this.majorBrandVersion);
        String string2 = stringBuilder.toString();
        if (this.compatibleBrands.size() > 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append("Compatible:");
            String string3 = stringBuilder2.toString();
            for (String string4 : this.compatibleBrands) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string3);
                stringBuilder3.append(string4);
                String string5 = stringBuilder3.toString();
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string5);
                stringBuilder4.append(",");
                string3 = stringBuilder4.toString();
            }
            string2 = string3.substring(0, -1 + string3.length());
        }
        return string2;
    }

}

