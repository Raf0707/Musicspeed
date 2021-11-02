/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.e;

import c.g.a.a.a.j.e;

public class j {
    private final String a;
    private final String b;

    private j(String string, String string2) {
        this.a = string;
        this.b = string2;
    }

    public static j a(String string, String string2) {
        e.f(string, "Name is null or empty");
        e.f(string2, "Version is null or empty");
        return new j(string, string2);
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }
}

