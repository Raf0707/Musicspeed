/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentUris
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.DocumentsContract
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Audio
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video
 *  android.provider.MediaStore$Video$Media
 *  java.io.File
 *  java.io.FileFilter
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Comparator
 *  java.util.Locale
 */
package com.ipaulpro.afilechooser.g;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.Locale;

public class a {
    public static Comparator<File> a = new Comparator<File>(){

        public int a(File file, File file2) {
            return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
        }
    };
    public static FileFilter b = new FileFilter(){

        public boolean accept(File file) {
            String string = file.getName();
            boolean bl = file.isFile() && !string.startsWith(".");
            if (!bl) {
                return bl;
            }
            String[] arrstring = string.split("\\.");
            return a.d(arrstring[arrstring.length - 1].toLowerCase(Locale.getDefault()));
        }
    };
    public static FileFilter c = new FileFilter(){

        public boolean accept(File file) {
            String string = file.getName();
            return file.isDirectory() && !string.startsWith(".");
        }
    };

    /*
     * Exception decompiling
     */
    public static String a(Context var0, Uri var1_1, String var2_2, String[] var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[SIMPLE_IF_TAKEN]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    public static String b(Context context, Uri uri) {
        boolean bl = Build.VERSION.SDK_INT >= 19;
        if (bl && DocumentsContract.isDocumentUri((Context)context, (Uri)uri)) {
            if (a.i(uri)) {
                return DocumentsContract.getDocumentId((Uri)uri);
            }
            if (a.g(uri)) {
                String string = DocumentsContract.getDocumentId((Uri)uri);
                String[] arrstring = string.split(":");
                if ("primary".equalsIgnoreCase(arrstring[0])) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((Object)Environment.getExternalStorageDirectory());
                    stringBuilder.append("/");
                    stringBuilder.append(arrstring[1]);
                    return stringBuilder.toString();
                }
                int n2 = string.indexOf(58, 1);
                String string2 = string.substring(0, n2);
                String string3 = string.substring(n2 + 1);
                String string4 = a.c(context, string2);
                if (string4 != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string4);
                    stringBuilder.append("/");
                    stringBuilder.append(string3);
                    String string5 = stringBuilder.toString();
                    File file = new File(string5);
                    if (file.exists() && file.canRead()) {
                        return string5;
                    }
                }
            } else {
                if (a.f(uri)) {
                    String string = DocumentsContract.getDocumentId((Uri)uri);
                    if (string != null && !string.equals((Object)"") && string.startsWith("raw:")) {
                        return string.substring(4, string.length());
                    }
                    return a.a(context, ContentUris.withAppendedId((Uri)Uri.parse((String)"content://downloads/public_downloads"), (long)Long.valueOf((String)string)), null, null);
                }
                if (a.j(uri)) {
                    String[] arrstring = DocumentsContract.getDocumentId((Uri)uri).split(":");
                    String string = arrstring[0];
                    Object object = "image".equals((Object)string) ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : ("video".equals((Object)string) ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : ("audio".equals((Object)string) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null));
                    String[] arrstring2 = new String[]{arrstring[1]};
                    if (object == null) {
                        return null;
                    }
                    return a.a(context, object, "_id=?", arrstring2);
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (a.h(uri)) {
                    return uri.getLastPathSegment();
                }
                return a.a(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static String c(Context context, String string) {
        File[] arrfile = context.getExternalCacheDirs();
        if (arrfile != null) {
            for (File file : arrfile) {
                String string2;
                int n2;
                if (file == null || (string2 = file.getAbsolutePath()) == null || (n2 = string2.indexOf(string)) == -1) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2.substring(0, n2));
                stringBuilder.append(string);
                return stringBuilder.toString();
            }
        }
        return null;
    }

    public static boolean d(String string) {
        String string2 = string.toLowerCase();
        return string2.equals((Object)"ogg") || string2.equals((Object)"mp3") || string2.equals((Object)"aac") || string2.equals((Object)"flac") || string2.equals((Object)"wav") || string2.equals((Object)"m4a") || string2.equals((Object)"wma") || string2.equals((Object)"asf") || string2.equals((Object)"alac") || string2.equals((Object)"opus") || string2.equals((Object)"wv") || string2.equals((Object)"aiff") || string2.equals((Object)"mp4") || string2.equals((Object)"3gp") || string2.equals((Object)"amr");
        {
        }
    }

    public static boolean e(String string) {
        String string2 = string.toLowerCase();
        return string2.equals((Object)"ogg") || string2.equals((Object)"mp3") || string2.equals((Object)"aac") || string2.equals((Object)"flac") || string2.equals((Object)"m4a") || string2.equals((Object)"wma") || string2.equals((Object)"asf") || string2.equals((Object)"alac") || string2.equals((Object)"opus") || string2.equals((Object)"wv") || string2.equals((Object)"aiff") || string2.equals((Object)"amr");
        {
        }
    }

    public static boolean f(Uri uri) {
        return "com.android.providers.downloads.documents".equals((Object)uri.getAuthority());
    }

    public static boolean g(Uri uri) {
        return "com.android.externalstorage.documents".equals((Object)uri.getAuthority());
    }

    public static boolean h(Uri uri) {
        return "com.google.android.apps.photos.content".equals((Object)uri.getAuthority());
    }

    public static boolean i(Uri uri) {
        return "com.smp.musicspeed.local.documents".equals((Object)uri.getAuthority());
    }

    public static boolean j(Uri uri) {
        return "com.android.providers.media.documents".equals((Object)uri.getAuthority());
    }

}

