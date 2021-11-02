/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.net.Uri
 *  f.y.b
 *  f.y.g
 *  f.z.d.k
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileDescriptor
 *  java.io.FileOutputStream
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Objects
 */
package com.smp.musicspeed.tag_editor;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import com.smp.musicspeed.k0.z;
import f.y.b;
import f.y.g;
import f.z.d.k;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Objects;

public final class m {
    public static final void a(Context context, long l2) {
        k.g((Object)context, (String)"context");
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://media/external/audio/albumart");
        contentResolver.delete(ContentUris.withAppendedId((Uri)uri, (long)l2), null, null);
        contentResolver.notifyChange(uri, null);
    }

    public static final void b(Context context, long l2, String string2) {
        k.g((Object)context, (String)"context");
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse((String)"content://media/external/audio/albumart");
        contentResolver.delete(ContentUris.withAppendedId((Uri)uri, (long)l2), null, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("album_id", Long.valueOf((long)l2));
        contentValues.put("_data", string2);
        contentResolver.insert(uri, contentValues);
        contentResolver.notifyChange(uri, null);
    }

    public static final boolean c(File file) {
        k.g((Object)file, (String)"file");
        if (!z.b()) {
            return false;
        }
        String string2 = g.g((File)file);
        Objects.requireNonNull((Object)string2, (String)"null cannot be cast to non-null type java.lang.String");
        String string3 = string2.toLowerCase();
        k.f((Object)string3, (String)"(this as java.lang.String).toLowerCase()");
        switch (string3.hashCode()) {
            default: {
                return false;
            }
            case 3145576: {
                if (string3.equals((Object)"flac")) break;
                return false;
            }
            case 117835: {
                if (string3.equals((Object)"wma")) break;
                return false;
            }
            case 109967: {
                if (string3.equals((Object)"ogg")) break;
                return false;
            }
            case 108272: {
                if (string3.equals((Object)"mp3")) break;
                return false;
            }
            case 106458: {
                if (string3.equals((Object)"m4a")) break;
                return false;
            }
        }
        return true;
    }

    public static final void d(File file, byte[] arrby) {
        k.g((Object)file, (String)"<this>");
        k.g((Object)arrby, (String)"array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(arrby);
            fileOutputStream.getFD().sync();
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                b.a((Closeable)fileOutputStream, (Throwable)throwable);
                throw throwable2;
            }
        }
        b.a((Closeable)fileOutputStream, null);
    }
}

