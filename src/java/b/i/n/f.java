/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.Handler
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package b.i.n;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import b.i.n.d;
import b.i.n.e;
import b.i.p.h;

public class f {
    public static Typeface a(Context context, d d2, int n2, boolean bl, int n3, Handler handler, c c2) {
        b.i.n.a a2 = new b.i.n.a(c2, handler);
        if (bl) {
            return e.e(context, d2, a2, n2, n3);
        }
        return e.d(context, d2, n2, null, a2);
    }

    public static class a {
        private final int a;
        private final b[] b;

        @Deprecated
        public a(int n2, b[] arrb) {
            this.a = n2;
            this.b = arrb;
        }

        static a a(int n2, b[] arrb) {
            return new a(n2, arrb);
        }

        public b[] b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }
    }

    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        @Deprecated
        public b(Uri uri, int n2, int n3, boolean bl, int n4) {
            this.a = h.d(uri);
            this.b = n2;
            this.c = n3;
            this.d = bl;
            this.e = n4;
        }

        static b a(Uri uri, int n2, int n3, boolean bl, int n4) {
            b b2 = new b(uri, n2, n3, bl, n4);
            return b2;
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.b;
        }

        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }
    }

    public static class c {
        public void a(int n2) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

}

