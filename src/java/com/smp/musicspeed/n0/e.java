/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.UriPermission
 *  android.net.Uri
 *  android.util.Log
 *  android.webkit.MimeTypeMap
 *  b.l.a.a
 *  f.g0.k
 *  f.z.d.g
 *  f.z.d.k
 *  java.io.FileNotFoundException
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.List
 */
package com.smp.musicspeed.n0;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.UriPermission;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import b.l.a.a;
import com.smp.musicspeed.n0.c;
import com.smp.musicspeed.n0.f;
import com.smp.musicspeed.n0.g;
import f.g0.k;
import f.l;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.List;

public final class e {
    private final Context a;
    private final String b;
    private final int c;
    private UriPermission d;
    private String e;

    public e(Context context, String string2, int n2) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"basePath");
        this.a = context;
        this.b = string2;
        this.c = n2;
        Log.d((String)"SafHelper", (String)"New instance");
        this.e();
    }

    public /* synthetic */ e(Context context, String string2, int n2, int n3, f.z.d.g g2) {
        if ((n3 & 4) != 0) {
            n2 = 10001;
        }
        this(context, string2, n2);
    }

    private final void e() {
        Log.d((String)"SafHelper", (String)f.z.d.k.m((String)"Is SAF available: ", (Object)f.a()));
        if (f.a()) {
            String string2;
            c c2 = new c(this.a, g.a.e(this.b));
            this.e = string2 = c2.a();
            Log.d((String)"SafHelper", (String)f.z.d.k.m((String)"Base permitted path: ", (Object)string2));
            this.d = c2.b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Permission: ");
            UriPermission uriPermission = this.d;
            Uri uri = uriPermission == null ? null : uriPermission.getUri();
            stringBuilder.append((Object)uri);
            stringBuilder.append(" (");
            UriPermission uriPermission2 = this.d;
            Boolean bl = uriPermission2 == null ? null : Boolean.valueOf((boolean)uriPermission2.isWritePermission());
            stringBuilder.append((Object)bl);
            stringBuilder.append(')');
            Log.d((String)"SafHelper", (String)stringBuilder.toString());
        }
    }

    private final boolean g(String string2) {
        String string3 = this.e;
        f.z.d.k.e((Object)string3);
        return k.o((String)string2, (String)string3, (boolean)false, (int)2, null);
    }

    public final String a(String string2) {
        f.z.d.k.g((Object)string2, (String)"path");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("checkAndGetRelativePath(");
        stringBuilder.append(string2);
        stringBuilder.append(')');
        Log.d((String)"SafHelper", (String)stringBuilder.toString());
        if (this.f()) {
            g.a a2 = g.a;
            String string3 = a2.e(string2);
            Log.d((String)"SafHelper", (String)f.z.d.k.m((String)"checkAndGetRelativePath: normalized path = ", (Object)string3));
            if (this.g(string3)) {
                String string4 = this.e;
                f.z.d.k.e((Object)string4);
                String string5 = a2.d(string4, string3);
                Log.d((String)"SafHelper", (String)f.z.d.k.m((String)"checkAndGetRelativePath: relative path = ", (Object)string5));
                return string5;
            }
            throw new UnsupportedOperationException(f.z.d.k.m((String)"Path is outside the managed storage. Path should starts with ", (Object)this.e));
        }
        throw new UnsupportedOperationException("Can be done with SAF. You should check path with isApplicable() before call it");
    }

    /*
     * Enabled aggressive block sorting
     */
    @TargetApi(value=21)
    public final OutputStream b(String string2) {
        void var15_15;
        void var15_12;
        f.z.d.k.g((Object)string2, (String)"filePath");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createFile(");
        stringBuilder.append(string2);
        stringBuilder.append(')');
        Log.d((String)"SafHelper", (String)stringBuilder.toString());
        String string3 = this.a(string2);
        boolean bl = string3.length() == 0;
        if (bl) {
            throw new UnsupportedOperationException("File name is not specified");
        }
        l<String, String> l2 = g.a.c(string3);
        String string4 = l2.a();
        String string5 = l2.b();
        a a2 = this.c(string4);
        a a3 = a2.d(string5);
        if (a3 != null && a3.c()) {
            if (!a3.h()) {
                throw new UnsupportedOperationException(f.z.d.k.m((String)string5, (Object)" already exists and not a file (cannot override it)"));
            }
            Log.d((String)"SafHelper", (String)"createFile: file already exists");
            Uri uri = a3.g();
        } else {
            Object var15_10 = null;
        }
        if (var15_12 == null) {
            String string6 = this.d(string2);
            Log.d((String)"SafHelper", (String)"createFile: file not exists, create new");
            a a4 = a2.a(string6, string5);
            if (a4 == null) {
                Object var15_13 = null;
            } else {
                Uri uri = a4.g();
            }
        }
        Log.d((String)"SafHelper", (String)"createFile: Write data");
        if (var15_15 == null) {
            return null;
        }
        return this.a.getContentResolver().openOutputStream((Uri)var15_15);
    }

    public final a c(String string2) {
        f.z.d.k.g((Object)string2, (String)"relativePath");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getDocumentFileFromPath(");
        stringBuilder.append(string2);
        stringBuilder.append(')');
        Log.d((String)"SafHelper", (String)stringBuilder.toString());
        List<String> list = g.a.f(string2);
        Log.d((String)"SafHelper", (String)f.z.d.k.m((String)"getDocumentFileFromPath: parts=", list));
        UriPermission uriPermission = this.d;
        if (uriPermission != null) {
            Object object = a.e((Context)this.a, (Uri)uriPermission.getUri());
            for (String string3 : list) {
                if ((object = object == null ? null : object.d(string3)) != null) continue;
                throw new FileNotFoundException(f.z.d.k.m((String)string3, (Object)" doesn't exists"));
            }
            Log.d((String)"SafHelper", (String)"getDocumentFileFromPath: success");
            if (object != null) {
                return object;
            }
            throw new FileNotFoundException("doesn't exists");
        }
        throw new IllegalStateException("doesnt have permission");
    }

    public final String d(String string2) {
        f.z.d.k.g((Object)string2, (String)"url");
        String string3 = MimeTypeMap.getFileExtensionFromUrl((String)string2);
        String string4 = string3 != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(string3) : null;
        if (string4 == null) {
            string4 = "application/octet-stream";
        }
        return string4;
    }

    public final boolean f() {
        return f.a() && g.a.a(this.a, this.b) != null;
    }

    public final boolean h() {
        UriPermission uriPermission;
        if (f.a() && (uriPermission = this.d) != null) {
            f.z.d.k.e((Object)uriPermission);
            if (uriPermission.isWritePermission()) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(Activity activity, int n2, int n3, Intent intent) {
        f.z.d.k.g((Object)activity, (String)"activity");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityResult(");
        stringBuilder.append(n2);
        stringBuilder.append(',');
        stringBuilder.append(n3);
        stringBuilder.append(')');
        Log.d((String)"SafHelper", (String)stringBuilder.toString());
        if (n2 == this.c) {
            if (n3 == -1 && f.a()) {
                Uri uri = intent == null ? null : intent.getData();
                Log.d((String)"SafHelper", (String)f.z.d.k.m((String)"onActivityResult: ", (Object)uri));
                activity.grantUriPermission(activity.getPackageName(), uri, 3);
                ContentResolver contentResolver = activity.getContentResolver();
                f.z.d.k.e((Object)uri);
                contentResolver.takePersistableUriPermission(uri, 3);
                this.e();
            }
            return true;
        }
        return false;
    }

    public final void j(Activity activity) {
        f.z.d.k.g((Object)activity, (String)"activity");
        Log.d((String)"SafHelper", (String)"requestPermissions");
        if (f.a()) {
            activity.startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), this.c);
        }
    }
}

