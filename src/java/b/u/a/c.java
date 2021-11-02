/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.io.File
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package b.u.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import java.io.File;

public interface c {
    public void a(boolean var1);

    public b.u.a.b b();

    public String c();

    public void close();

    public static abstract class a {
        public final int a;

        public a(int n2) {
            this.a = n2;
        }

        private void a(String string) {
            if (!string.equalsIgnoreCase(":memory:")) {
                block8 : {
                    if (string.trim().length() == 0) {
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("deleting the database file: ");
                    stringBuilder.append(string);
                    Log.w((String)"SupportSQLite", (String)stringBuilder.toString());
                    if (Build.VERSION.SDK_INT < 16) break block8;
                    SQLiteDatabase.deleteDatabase((File)new File(string));
                    return;
                }
                try {
                    if (!new File(string).delete()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Could not delete the database file ");
                        stringBuilder.append(string);
                        Log.e((String)"SupportSQLite", (String)stringBuilder.toString());
                        return;
                    }
                }
                catch (Exception exception) {
                    try {
                        Log.e((String)"SupportSQLite", (String)"error while deleting corrupted database file", (Throwable)exception);
                        return;
                    }
                    catch (Exception exception2) {
                        Log.w((String)"SupportSQLite", (String)"delete failed: ", (Throwable)exception2);
                    }
                }
            }
        }

        public void b(b.u.a.b b2) {
        }

        /*
         * Exception decompiling
         */
        public void c(b.u.a.b var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl60.1 : ALOAD : trying to set 1 previously set to 0
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

        public abstract void d(b.u.a.b var1);

        public abstract void e(b.u.a.b var1, int var2, int var3);

        public void f(b.u.a.b b2) {
        }

        public abstract void g(b.u.a.b var1, int var2, int var3);
    }

    public static class b {
        public final Context a;
        public final String b;
        public final b.u.a.c$a c;

        b(Context context, String string, b.u.a.c$a a2) {
            this.a = context;
            this.b = string;
            this.c = a2;
        }

        public static a a(Context context) {
            return new a(context);
        }

        public static class a {
            Context a;
            String b;
            b.u.a.c$a c;

            a(Context context) {
                this.a = context;
            }

            public b a() {
                b.u.a.c$a a2 = this.c;
                if (a2 != null) {
                    Context context = this.a;
                    if (context != null) {
                        return new b(context, this.b, a2);
                    }
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            public a b(b.u.a.c$a a2) {
                this.c = a2;
                return this;
            }

            public a c(String string) {
                this.b = string;
                return this;
            }
        }

    }

    public static interface c {
        public c a(b var1);
    }

}

