/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.pm.Signature
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 */
package b.i.n;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import b.i.n.d;
import b.i.n.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class c {
    private static final Comparator<byte[]> a = new Comparator<byte[]>(){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int a(byte[] arrby, byte[] arrby2) {
            int n2;
            int n3;
            if (arrby.length != arrby2.length) {
                n2 = arrby.length;
                n3 = arrby2.length;
                do {
                    return n2 - n3;
                    break;
                } while (true);
            }
            for (int i2 = 0; i2 < arrby.length; ++i2) {
                if (arrby[i2] == arrby2[i2]) continue;
                n2 = arrby[i2];
                n3 = arrby2[i2];
                return n2 - n3;
            }
            return 0;
        }
    };

    private static List<byte[]> a(Signature[] arrsignature) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < arrsignature.length; ++i2) {
            arrayList.add((Object)arrsignature[i2].toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (Arrays.equals((byte[])((byte[])list.get(i2)), (byte[])((byte[])list2.get(i2)))) continue;
            return false;
        }
        return true;
    }

    private static List<List<byte[]>> c(d d2, Resources resources) {
        if (d2.b() != null) {
            return d2.b();
        }
        return b.i.h.d.c.c(resources, d2.c());
    }

    static f.a d(Context context, d d2, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfo = c.e(context.getPackageManager(), d2, context.getResources());
        if (providerInfo == null) {
            return f.a.a(1, null);
        }
        return f.a.a(0, c.f(context, d2, providerInfo.authority, cancellationSignal));
    }

    static ProviderInfo e(PackageManager packageManager, d d2, Resources resources) throws PackageManager.NameNotFoundException {
        String string = d2.e();
        ProviderInfo providerInfo = packageManager.resolveContentProvider(string, 0);
        if (providerInfo != null) {
            if (providerInfo.packageName.equals((Object)d2.f())) {
                List<byte[]> list = c.a(packageManager.getPackageInfo((String)providerInfo.packageName, (int)64).signatures);
                Collections.sort(list, a);
                List<List<byte[]>> list2 = c.c(d2, resources);
                for (int i2 = 0; i2 < list2.size(); ++i2) {
                    ArrayList arrayList = new ArrayList((Collection)list2.get(i2));
                    Collections.sort((List)arrayList, a);
                    if (!c.b(list, (List<byte[]>)arrayList)) continue;
                    return providerInfo;
                }
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Found content provider ");
            stringBuilder.append(string);
            stringBuilder.append(", but package was not ");
            stringBuilder.append(d2.f());
            throw new PackageManager.NameNotFoundException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No package found for authority: ");
        stringBuilder.append(string);
        throw new PackageManager.NameNotFoundException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static f.b[] f(Context context, d d2, String string, CancellationSignal cancellationSignal) {
        ArrayList arrayList;
        block9 : {
            arrayList = new ArrayList();
            Uri uri = new Uri.Builder().scheme("content").authority(string).build();
            Uri uri2 = new Uri.Builder().scheme("content").authority(string).appendPath("file").build();
            Cursor cursor = null;
            try {
                String[] arrstring = new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                int n2 = Build.VERSION.SDK_INT;
                cursor = null;
                if (n2 > 16) {
                    ContentResolver contentResolver = context.getContentResolver();
                    String[] arrstring2 = new String[]{d2.g()};
                    cursor = contentResolver.query(uri, arrstring, "query = ?", arrstring2, null, cancellationSignal);
                } else {
                    ContentResolver contentResolver = context.getContentResolver();
                    String[] arrstring3 = new String[]{d2.g()};
                    cursor = contentResolver.query(uri, arrstring, "query = ?", arrstring3, null);
                }
                if (cursor != null && cursor.getCount() > 0) {
                    int n3 = cursor.getColumnIndex("result_code");
                    ArrayList arrayList2 = new ArrayList();
                    int n4 = cursor.getColumnIndex("_id");
                    int n5 = cursor.getColumnIndex("file_id");
                    int n6 = cursor.getColumnIndex("font_ttc_index");
                    int n7 = cursor.getColumnIndex("font_weight");
                    int n8 = cursor.getColumnIndex("font_italic");
                    while (cursor.moveToNext()) {
                        int n9;
                        Uri uri3;
                        int n10 = n3 != -1 ? cursor.getInt(n3) : 0;
                        int n11 = n6 != -1 ? cursor.getInt(n6) : 0;
                        if (n5 == -1) {
                            n9 = n10;
                            uri3 = ContentUris.withAppendedId((Uri)uri, (long)cursor.getLong(n4));
                        } else {
                            n9 = n10;
                            uri3 = ContentUris.withAppendedId((Uri)uri2, (long)cursor.getLong(n5));
                        }
                        int n12 = n7 != -1 ? cursor.getInt(n7) : 400;
                        boolean bl = n8 != -1 && cursor.getInt(n8) == 1;
                        arrayList2.add((Object)f.b.a(uri3, n11, n12, bl, n9));
                    }
                    arrayList = arrayList2;
                }
                if (cursor == null) break block9;
            }
            catch (Throwable throwable) {
                if (cursor != null) {
                    cursor.close();
                }
                throw throwable;
            }
            cursor.close();
        }
        return (f.b[])arrayList.toArray((Object[])new f.b[0]);
    }

}

