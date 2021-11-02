/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.app.Notification
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Process
 *  java.io.BufferedInputStream
 *  java.io.File
 *  java.io.FileDescriptor
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 */
package com.smp.musicspeed.importfile;

import android.app.IntentService;
import android.app.Notification;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.smp.musicspeed.importfile.FileInfo;
import com.smp.musicspeed.utils.g;
import com.smp.musicspeed.utils.j;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class HardPathService
extends IntentService {
    public HardPathService() {
        super("com.smp.RemoteCopyService");
    }

    /*
     * Exception decompiling
     */
    private String b(Uri var1) {
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

    private List<String> c(ClipData clipData) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < clipData.getItemCount(); ++i2) {
            arrayList.add((Object)this.b(clipData.getItemAt(i2).getUri()));
        }
        return arrayList;
    }

    private void d(String string2) {
        Intent intent = new Intent();
        intent.setAction("com.smp.HardPathService.ACTION_SEND_FILE_NAMES").addCategory("android.intent.category.DEFAULT");
        intent.putStringArrayListExtra("com.smp.HardPathService.INTENT_FILENAMES", new ArrayList((Collection)Arrays.asList((Object[])new String[]{string2})));
        this.sendBroadcast(intent);
    }

    private void e(List<String> list) {
        Intent intent = new Intent();
        intent.setAction("com.smp.HardPathService.ACTION_SEND_FILE_NAMES").addCategory("android.intent.category.DEFAULT");
        intent.putStringArrayListExtra("com.smp.HardPathService.INTENT_FILENAMES", (ArrayList)list);
        this.sendBroadcast(intent);
    }

    private String f(Uri uri) throws IOException {
        if (uri != null) {
            FileInfo fileInfo;
            String string2 = this.getString(2131820798);
            File file = g.f(this.getApplicationContext(), string2);
            File file2 = new File(file, (fileInfo = new FileInfo((Context)this, uri)).l());
            if (file2.createNewFile() || file2.length() != fileInfo.n()) {
                this.a(new BufferedInputStream(this.getContentResolver().openInputStream(uri)), new FileOutputStream(file2), fileInfo);
            }
            file2.setLastModified(System.currentTimeMillis());
            fileInfo.o(file2.getAbsolutePath());
            return fileInfo.m();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(BufferedInputStream bufferedInputStream, FileOutputStream fileOutputStream, FileInfo fileInfo) throws IOException {
        byte[] arrby = new byte[65536];
        try {
            int n2;
            while ((n2 = bufferedInputStream.read(arrby)) != -1) {
                fileOutputStream.write(arrby, 0, n2);
            }
        }
        catch (Throwable throwable) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (fileOutputStream == null) throw throwable;
            try {
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            throw throwable;
        }
        try {
            bufferedInputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        if (fileOutputStream == null) return;
        try {
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.startForeground(682, j.f((Context)this));
        }
    }

    public void onDestroy() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.stopForeground(true);
        }
        super.onDestroy();
    }

    protected void onHandleIntent(Intent intent) {
        try {
            Process.setThreadPriority((int)10);
            if (intent.getClipData() != null) {
                this.e(this.c(intent.getClipData()));
                return;
            }
            this.d(this.b(intent.getData()));
            return;
        }
        catch (Exception exception) {
            this.e((List<String>)new ArrayList());
            return;
        }
    }
}

