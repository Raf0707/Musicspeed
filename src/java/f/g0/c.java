/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package f.g0;

import f.z.d.k;
import java.nio.charset.Charset;

public final class c {
    public static final Charset a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    public static final c g;

    static {
        g = new c();
        Charset charset = Charset.forName((String)"UTF-8");
        k.f((Object)charset, (String)"Charset.forName(\"UTF-8\")");
        a = charset;
        Charset charset2 = Charset.forName((String)"UTF-16");
        k.f((Object)charset2, (String)"Charset.forName(\"UTF-16\")");
        b = charset2;
        Charset charset3 = Charset.forName((String)"UTF-16BE");
        k.f((Object)charset3, (String)"Charset.forName(\"UTF-16BE\")");
        c = charset3;
        Charset charset4 = Charset.forName((String)"UTF-16LE");
        k.f((Object)charset4, (String)"Charset.forName(\"UTF-16LE\")");
        d = charset4;
        Charset charset5 = Charset.forName((String)"US-ASCII");
        k.f((Object)charset5, (String)"Charset.forName(\"US-ASCII\")");
        e = charset5;
        Charset charset6 = Charset.forName((String)"ISO-8859-1");
        k.f((Object)charset6, (String)"Charset.forName(\"ISO-8859-1\")");
        f = charset6;
    }

    private c() {
    }
}

