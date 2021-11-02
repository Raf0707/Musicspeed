/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.UriPermission
 *  android.net.Uri
 *  android.provider.DocumentsContract
 *  f.g0.k
 *  f.u.l
 *  f.z.d.k
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Comparator
 *  java.util.List
 */
package com.smp.musicspeed.n0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriPermission;
import android.net.Uri;
import android.provider.DocumentsContract;
import com.smp.musicspeed.n0.a;
import com.smp.musicspeed.n0.g;
import f.g0.k;
import f.l;
import java.io.File;
import java.util.Comparator;
import java.util.List;

public final class c {
    private UriPermission a;
    private String b;

    public c(Context context, String string2) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"path");
        for (UriPermission uriPermission : this.c(context)) {
            g.a a2 = g.a;
            String string3 = a2.a(context, string2);
            if (string3 == null) continue;
            l<String, String> l2 = this.e(uriPermission);
            String string4 = l2.a();
            String string5 = l2.b();
            l<String, String> l3 = this.f(string3, string2);
            String string6 = l3.a();
            String string7 = l3.b();
            int n2 = string7.length();
            boolean bl = true;
            boolean bl2 = n2 == 0;
            if (bl2) {
                string7 = File.separator;
                f.z.d.k.f((Object)string7, (String)"separator");
            }
            if (string4.length() != 0) {
                bl = false;
            }
            if (bl || !f.z.d.k.c((Object)string4, (Object)string6) || !k.o((String)string7, (String)string5, (boolean)false, (int)2, null)) continue;
            this.a = uriPermission;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)string3);
            stringBuilder.append((Object)File.separator);
            stringBuilder.append(string5);
            this.b = a2.e(stringBuilder.toString());
            break;
        }
    }

    private final List<UriPermission> c(Context context) {
        List list = context.getContentResolver().getPersistedUriPermissions();
        f.z.d.k.f((Object)list, (String)"context.contentResolver.persistedUriPermissions");
        return f.u.l.J((Iterable)list, (Comparator)a.f);
    }

    private static final int d(UriPermission uriPermission, UriPermission uriPermission2) {
        return f.z.d.k.i((int)uriPermission.getUri().toString().length(), (int)uriPermission2.getUri().toString().length());
    }

    private final l<String, String> e(UriPermission uriPermission) {
        String string2 = DocumentsContract.getTreeDocumentId((Uri)uriPermission.getUri());
        f.z.d.k.f((Object)string2, (String)"getTreeDocumentId(permission.uri)");
        List list = k.N((CharSequence)string2, (String[])new String[]{":"}, (boolean)false, (int)0, (int)6, null);
        return new l<Object, String>(list.get(0), f.z.d.k.m((String)File.separator, (Object)list.get(1)));
    }

    private final l<String, String> f(String string2, String string3) {
        g.a a2 = g.a;
        List<String> list = a2.f(string2);
        if (list.isEmpty()) {
            return new l<String, String>("", "");
        }
        return new l<Object, String>(list.get(-1 + list.size()), a2.d(string2, string3));
    }

    public static /* synthetic */ int g(UriPermission uriPermission, UriPermission uriPermission2) {
        return c.d(uriPermission, uriPermission2);
    }

    public final String a() {
        return this.b;
    }

    public final UriPermission b() {
        return this.a;
    }
}

