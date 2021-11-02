/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package b.i.n;

import android.util.Base64;
import b.i.p.h;
import java.util.List;

public final class d {
    private final String a;
    private final String b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e;
    private final String f;

    public d(String string, String string2, String string3, List<List<byte[]>> list) {
        this.a = h.d(string);
        this.b = h.d(string2);
        this.c = h.d(string3);
        this.d = h.d(list);
        this.e = 0;
        this.f = this.a(string, string2, string3);
    }

    private String a(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.append("-");
        stringBuilder.append(string2);
        stringBuilder.append("-");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public List<List<byte[]>> b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    String d() {
        return this.f;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("FontRequest {mProviderAuthority: ");
        stringBuilder2.append(this.a);
        stringBuilder2.append(", mProviderPackage: ");
        stringBuilder2.append(this.b);
        stringBuilder2.append(", mQuery: ");
        stringBuilder2.append(this.c);
        stringBuilder2.append(", mCertificates:");
        stringBuilder.append(stringBuilder2.toString());
        for (int i2 = 0; i2 < this.d.size(); ++i2) {
            stringBuilder.append(" [");
            List list = (List)this.d.get(i2);
            for (int i3 = 0; i3 < list.size(); ++i3) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[])((byte[])list.get(i3)), (int)0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("mCertificatesArray: ");
        stringBuilder3.append(this.e);
        stringBuilder.append(stringBuilder3.toString());
        return stringBuilder.toString();
    }
}

