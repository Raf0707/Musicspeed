/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URL
 */
package c.g.a.a.a.e;

import c.g.a.a.a.j.e;
import java.net.URL;

public final class k {
    private final String a;
    private final URL b;
    private final String c;

    private k(String string, URL uRL, String string2) {
        this.a = string;
        this.b = uRL;
        this.c = string2;
    }

    public static k a(String string, URL uRL, String string2) {
        e.f(string, "VendorKey is null or empty");
        e.d((Object)uRL, "ResourceURL is null");
        e.f(string2, "VerificationParameters is null or empty");
        return new k(string, uRL, string2);
    }

    public static k b(URL uRL) {
        e.d((Object)uRL, "ResourceURL is null");
        return new k(null, uRL, null);
    }

    public URL c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.c;
    }
}

