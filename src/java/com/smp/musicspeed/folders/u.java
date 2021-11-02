/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.webkit.MimeTypeMap
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  java.io.File
 *  java.io.FileFilter
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URI
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.LinkedList
 *  java.util.List
 */
package com.smp.musicspeed.folders;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.webkit.MimeTypeMap;
import com.smp.musicspeed.dbrecord.MediaTrack;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class u {
    public static boolean a(File file, String string, MimeTypeMap mimeTypeMap) {
        if (string != null) {
            if (string.equals((Object)"*/*")) {
                return true;
            }
            String string2 = file.toURI().toString();
            int n2 = string2.lastIndexOf(46);
            if (n2 == -1) {
                return false;
            }
            String string3 = mimeTypeMap.getMimeTypeFromExtension(string2.substring(n2 + 1).toLowerCase());
            if (string3 == null) {
                return false;
            }
            if (string3.equals((Object)string)) {
                return true;
            }
            int n3 = string.lastIndexOf(47);
            if (n3 == -1) {
                return false;
            }
            String string4 = string.substring(0, n3);
            if (!string.substring(n3 + 1).equals((Object)"*")) {
                return false;
            }
            int n4 = string3.lastIndexOf(47);
            if (n4 == -1) {
                return false;
            }
            return string3.substring(0, n4).equals((Object)string4);
        }
        return true;
    }

    @TargetApi(value=19)
    public static String[] b(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)Environment.getExternalStorageDirectory().getAbsolutePath());
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : context.getExternalFilesDirs("external")) {
                String string;
                int n2;
                if (file == null || file.equals((Object)context.getExternalFilesDir("external")) || (n2 = file.getAbsolutePath().lastIndexOf("/Android/data")) < 0) continue;
                string = file.getAbsolutePath().substring(0, n2);
                try {
                    string = new File(string).getCanonicalPath();
                }
                catch (IOException iOException) {}
                arrayList.add((Object)string);
            }
        }
        return (String[])arrayList.toArray((Object[])new String[0]);
    }

    public static boolean c(MediaTrack mediaTrack) {
        String string = u.h(Environment.getExternalStorageDirectory());
        String string2 = u.h(new File(mediaTrack.getLocation()));
        return string2 != null && string2.contains((CharSequence)string);
    }

    public static boolean d(File file) {
        String string = u.h(Environment.getExternalStorageDirectory());
        String string2 = u.h(file);
        return string2 != null && string2.contains((CharSequence)string);
    }

    public static List<File> e(File file, FileFilter fileFilter) {
        LinkedList linkedList = new LinkedList();
        Object[] arrobject = file.listFiles(fileFilter);
        if (arrobject != null) {
            Collections.addAll((Collection)linkedList, (Object[])arrobject);
        }
        return linkedList;
    }

    public static String f(int n2) {
        int n3;
        int n4 = n2 * 2;
        StringBuilder stringBuilder = new StringBuilder(n4 - n3);
        stringBuilder.append("?");
        for (n3 = 1; n3 < n2; ++n3) {
            stringBuilder.append(",?");
        }
        return stringBuilder.toString();
    }

    public static File g(File file) {
        try {
            File file2 = file.getCanonicalFile();
            return file2;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return file.getAbsoluteFile();
        }
    }

    public static String h(File file) {
        try {
            String string = file.getCanonicalPath();
            return string;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return file.getAbsolutePath();
        }
    }

    public static String[] i(List<File> list) {
        if (list != null) {
            String[] arrstring = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); ++i2) {
                arrstring[i2] = u.h((File)list.get(i2));
            }
            return arrstring;
        }
        return new String[0];
    }
}

