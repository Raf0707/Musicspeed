/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.paperdb.Book
 *  io.paperdb.Paper
 *  java.io.File
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.bpmkey;

import com.smp.musicspeed.bpmkey.d;
import com.smp.musicspeed.bpmkey.e;
import com.smp.musicspeed.dbrecord.BeatStartRecord;
import com.smp.musicspeed.dbrecord.BpmKeyRecord;
import com.smp.musicspeed.dbrecord.DbLockKt;
import io.paperdb.Book;
import io.paperdb.Paper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.c;

public class BpmKeyService {
    private static BeatStartRecord a(String string, long l2, List<BeatStartRecord> list) {
        for (BeatStartRecord beatStartRecord : list) {
            if (!beatStartRecord.filename.equals((Object)string) || l2 != beatStartRecord.size) continue;
            return beatStartRecord;
        }
        return null;
    }

    private static BpmKeyRecord b(String string, long l2, List<BpmKeyRecord> list) {
        for (BpmKeyRecord bpmKeyRecord : list) {
            if (!bpmKeyRecord.filename.equals((Object)string) || l2 != bpmKeyRecord.size) continue;
            return bpmKeyRecord;
        }
        return null;
    }

    private static long c(String string) {
        File file = new File(string);
        try {
            long l2 = file.length();
            return l2;
        }
        catch (SecurityException securityException) {
            return 0L;
        }
    }

    public static native void cancelAnalyze();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static BeatStartRecord d(String string) {
        Object object;
        Object object2 = object = DbLockKt.getDbLock();
        // MONITORENTER : object2
        Book book = Paper.book();
        List list = (List)book.read("bpmkey");
        List list2 = (List)book.read("beatstartkey");
        // MONITOREXIT : object2
        if (list == null) {
            list = new ArrayList();
        }
        if (list2 == null) {
            list2 = new ArrayList();
        }
        c.d().m((Object)new e());
        long l2 = BpmKeyService.c(string);
        BeatStartRecord beatStartRecord = BpmKeyService.a(string, l2, (List<BeatStartRecord>)list2);
        if (beatStartRecord == null) {
            Object object3;
            BpmKeyRecord bpmKeyRecord = BpmKeyService.b(string, l2, (List<BpmKeyRecord>)list);
            BeatStartRecord beatStartRecord2 = new BeatStartRecord(string, l2);
            if (!BpmKeyService.doBeatStartNative(string, beatStartRecord2)) {
                return null;
            }
            if (bpmKeyRecord != null) {
                beatStartRecord2.keycurrent = bpmKeyRecord.keycurrent;
                beatStartRecord2.bpmcurrent = bpmKeyRecord.bpmcurrent;
            } else {
                beatStartRecord2.keycurrent = beatStartRecord2.keyoriginal;
                beatStartRecord2.bpmcurrent = beatStartRecord2.bpmoriginal;
            }
            list2.add((Object)beatStartRecord2);
            Object object4 = object3 = DbLockKt.getDbLock();
            // MONITORENTER : object4
            book.write("beatstartkey", (Object)list2);
            // MONITOREXIT : object4
            beatStartRecord = beatStartRecord2;
        }
        c.d().m((Object)new d(beatStartRecord));
        return beatStartRecord;
    }

    private static native boolean doBeatStartNative(String var0, BeatStartRecord var1);

    /*
     * Exception decompiling
     */
    public static void e(String var0, float var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl80 : IINC : trying to set 1 previously set to 0
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
}

