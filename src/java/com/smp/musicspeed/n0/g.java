/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  f.g0.k
 *  f.u.l
 *  f.z.d.g
 *  f.z.d.k
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.smp.musicspeed.n0;

import android.content.Context;
import android.text.TextUtils;
import f.g0.k;
import f.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f.z.d.g g2) {
            this();
        }

        /*
         * Exception decompiling
         */
        private final List<String> b(Context var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl33 : ILOAD : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        public final String a(Context context, String string2) {
            Object object;
            block1 : {
                Object object2;
                f.z.d.k.g((Object)context, (String)"context");
                f.z.d.k.g((Object)string2, (String)"path");
                Iterator iterator = this.b(context).iterator();
                do {
                    boolean bl = iterator.hasNext();
                    object = null;
                    if (!bl) break block1;
                } while (!k.o((String)string2, (String)((String)(object2 = iterator.next())), (boolean)false, (int)2, null));
                object = object2;
            }
            return (String)object;
        }

        public final l<String, String> c(String string2) {
            f.z.d.k.g((Object)string2, (String)"path");
            List<String> list = this.f(string2);
            if (list.size() < 2) {
                return new l<String, Object>(File.separator, list.get(list.size() - 1));
            }
            String string3 = File.separator;
            return new l<String, Object>(f.z.d.k.m((String)string3, (Object)TextUtils.join((CharSequence)string3, (Iterable)f.u.l.u(list, (int)1))), list.get(list.size() - 1));
        }

        public final String d(String string2, String string3) {
            f.z.d.k.g((Object)string2, (String)"storagePath");
            f.z.d.k.g((Object)string3, (String)"path");
            if (string3.length() > string2.length()) {
                String string4 = string3.substring(string2.length());
                f.z.d.k.f((Object)string4, (String)"(this as java.lang.String).substring(startIndex)");
                return string4;
            }
            return "";
        }

        public final String e(String string2) {
            f.z.d.k.g((Object)string2, (String)"path");
            String string3 = new File(string2).getAbsolutePath();
            f.z.d.k.f((Object)string3, (String)"File(path).absolutePath");
            return string3;
        }

        public final List<String> f(String string2) {
            f.z.d.k.g((Object)string2, (String)"path");
            String[] arrstring = new String[1];
            String string3 = File.separator;
            f.z.d.k.f((Object)string3, (String)"separator");
            arrstring[0] = string3;
            List list = k.N((CharSequence)string2, (String[])arrstring, (boolean)false, (int)0, (int)6, null);
            ArrayList arrayList = new ArrayList();
            for (Object object : list) {
                if (!(true ^ TextUtils.isEmpty((CharSequence)((String)object)))) continue;
                arrayList.add(object);
            }
            return arrayList;
        }
    }

}

