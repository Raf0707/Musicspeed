/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Environment
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Audio
 *  android.provider.MediaStore$Audio$Media
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  com.smp.musicspeed.recorder.q$a
 *  f.g
 *  f.g0.k
 *  f.u.l
 *  f.y.b
 *  f.z.c.a
 *  f.z.d.k
 *  java.io.Closeable
 *  java.io.File
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 */
package com.smp.musicspeed.recorder;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.m0.f;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.recorder.b0;
import com.smp.musicspeed.recorder.q;
import com.smp.musicspeed.utils.t;
import f.g0.g;
import f.g0.i;
import f.g0.k;
import f.u.l;
import f.y.b;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class q {
    private static final f.f a = f.g.a((f.z.c.a)a.g);

    /*
     * Exception decompiling
     */
    public static final boolean a(Context var0, String var1) {
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

    public static final String b() {
        return (String)a.getValue();
    }

    public static final File c(Context context, String string2) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"name");
        return new File(com.smp.musicspeed.utils.g.f(context, context.getString(2131820800)), f.z.d.k.m((String)string2, (Object)q.b()));
    }

    public static final List<MediaTrack> d(Context context, String string2) {
        List<MediaTrack> list;
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"name");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_data LIKE '");
        stringBuilder.append((Object)q.c(context, string2).getAbsolutePath());
        stringBuilder.append("%'");
        String string3 = stringBuilder.toString();
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, f.A(), string3, null, null);
        if (cursor == null) {
            return l.d();
        }
        try {
            MediaTrack.Companion companion = MediaTrack.Companion;
            Resources resources = context.getResources();
            f.z.d.k.f((Object)resources, (String)"context.resources");
            list = companion.buildAudioList(context, cursor, resources);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                b.a((Closeable)cursor, (Throwable)throwable);
                throw throwable2;
            }
        }
        b.a((Closeable)cursor, null);
        return list;
    }

    public static final String e(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        String string2 = context.getString(2131820832);
        f.z.d.k.f((Object)string2, (String)"context.getString(R.string.file_name_my_recording)");
        List<MediaTrack> list = q.g(context, string2);
        i i2 = new i("\\d+.m4a\\z");
        ArrayList arrayList = new ArrayList(l.j(list, (int)10));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string3;
            String string4;
            g g2 = i.b(i2, ((MediaTrack)iterator.next()).getLocation(), 0, 2, null);
            int n2 = g2 == null ? 0 : ((string3 = g2.getValue()) == null ? 0 : ((string4 = k.Y((String)string3, (String)".", null, (int)2, null)) == null ? 0 : Integer.parseInt((String)string4)));
            arrayList.add((Object)n2);
        }
        Integer n3 = (Integer)l.F((Iterable)arrayList);
        int n4 = n3 == null ? 0 : n3;
        int n5 = n4 + 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(' ');
        Object[] arrobject = new Object[]{n5};
        String string5 = String.format((String)"%d", (Object[])Arrays.copyOf((Object[])arrobject, (int)1));
        f.z.d.k.f((Object)string5, (String)"java.lang.String.format(format, *args)");
        stringBuilder.append(string5);
        return stringBuilder.toString();
    }

    public static final List<MediaTrack> f(Context context) {
        List<MediaTrack> list;
        f.z.d.k.g((Object)context, (String)"context");
        File file = com.smp.musicspeed.utils.g.f(context, context.getString(2131820800));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_data LIKE '");
        stringBuilder.append((Object)file.getAbsolutePath());
        stringBuilder.append("%'");
        String string2 = stringBuilder.toString();
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, f.A(), string2, null, "date_modified DESC");
        if (cursor == null) {
            return l.d();
        }
        try {
            MediaTrack.Companion companion = MediaTrack.Companion;
            Resources resources = context.getResources();
            f.z.d.k.f((Object)resources, (String)"context.resources");
            list = companion.buildAudioList(context, cursor, resources);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                b.a((Closeable)cursor, (Throwable)throwable);
                throw throwable2;
            }
        }
        b.a((Closeable)cursor, null);
        return list;
    }

    public static final List<MediaTrack> g(Context context, String string2) {
        List<MediaTrack> list;
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"base");
        String string3 = new File(com.smp.musicspeed.utils.g.f(context, context.getString(2131820800)), string2).getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_data LIKE '");
        stringBuilder.append((Object)string3);
        stringBuilder.append("%'");
        String string4 = stringBuilder.toString();
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, f.A(), string4, null, null);
        if (cursor == null) {
            return l.d();
        }
        try {
            MediaTrack.Companion companion = MediaTrack.Companion;
            Resources resources = context.getResources();
            f.z.d.k.f((Object)resources, (String)"context.resources");
            list = companion.buildAudioList(context, cursor, resources);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                b.a((Closeable)cursor, (Throwable)throwable);
                throw throwable2;
            }
        }
        b.a((Closeable)cursor, null);
        return list;
    }

    public static final b0 h(Context context, String string2) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"name");
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = q.i(contentResolver, context, string2);
        int n2 = 1;
        String string3 = string2;
        do {
            int n3;
            block6 : {
                block5 : {
                    n3 = n2 + 1;
                    if (uri != null) break block5;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(" (");
                    stringBuilder.append(n2);
                    stringBuilder.append(')');
                    string3 = stringBuilder.toString();
                    uri = q.i(contentResolver, context, string3);
                    if (n3 < 3000) break block6;
                }
                if (uri != null) {
                    Context context2 = context.getApplicationContext();
                    f.z.d.k.f((Object)context2, (String)"context.applicationContext");
                    return new b0(context2, uri, string3);
                }
                return null;
            }
            n2 = n3;
        } while (true);
    }

    private static final Uri i(ContentResolver contentResolver, Context context, String string2) {
        ContentValues contentValues = new ContentValues();
        if (!z.d()) {
            contentValues.put("_data", q.c(context, string2).getAbsolutePath());
        } else {
            String string3 = context.getString(2131820800);
            f.z.d.k.f((Object)string3, (String)"context.getString(R.string.dir_name_recordings)");
            String string4 = t.i(context);
            String string5 = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_MUSIC).getName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)string5);
            String string6 = File.separator;
            stringBuilder.append((Object)string6);
            stringBuilder.append((Object)string4);
            stringBuilder.append((Object)string6);
            stringBuilder.append(string3);
            contentValues.put("relative_path", stringBuilder.toString());
        }
        contentValues.put("_display_name", f.z.d.k.m((String)string2, (Object)".m4a"));
        contentValues.put("title", string2);
        contentValues.put("artist", context.getString(2131820673));
        contentValues.put("is_music", "0");
        contentValues.put("mime_type", "audio/m4a");
        if (z.d()) {
            contentValues.put("is_pending", Integer.valueOf((int)1));
        }
        return contentResolver.insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public static final byte j(int n2) {
        return (byte)((double)n2 / (double)32767 * (double)127);
    }
}

