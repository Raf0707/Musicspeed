/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.c.l
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.Future
 */
package rm.com.audiowave;

import f.t;
import f.x.c;
import f.z.c.l;
import f.z.d.k;
import java.util.concurrent.Future;
import rm.com.audiowave.e;
import rm.com.audiowave.f;
import rm.com.audiowave.n;

public final class m {
    public static final m a = new m();

    private m() {
    }

    private static final void c(byte[] arrby, int n2, l l2) {
        k.g(arrby, "$data");
        k.g((Object)l2, "$answer");
        byte[] arrby2 = a.a(arrby, n2);
        n.b().post((Runnable)new e(l2, arrby2));
    }

    private static final void d(l l2, byte[] arrby) {
        k.g((Object)l2, "$answer");
        k.g(arrby, "$scaled");
        l2.g((Object)arrby);
    }

    public static /* synthetic */ void e(l l2, byte[] arrby) {
        m.d(l2, arrby);
    }

    public static /* synthetic */ void f(byte[] arrby, int n2, l l2) {
        m.c(arrby, n2, l2);
    }

    public final byte[] a(byte[] arrby, int n2) {
        k.g(arrby, "data");
        byte[] arrby2 = new byte[n2];
        int n3 = (int)Math.max((double)Math.floor((double)((double)(arrby.length / n2) / 10.0)), (double)1.0);
        if (n2 >= arrby.length) {
            return n.d(arrby2, arrby);
        }
        int n4 = arrby.length;
        if (n3 > 0) {
            int n5 = 0;
            int n6 = c.b(0, n4, n3);
            if (n6 >= 0) {
                int n7 = 0;
                float f2 = 0.0f;
                float f3 = 0.0f;
                do {
                    int n8 = n5 + n3;
                    int n9 = (int)((long)n2 * (long)n5 / (long)arrby.length);
                    if (n7 == n9) {
                        f3 += (float)true;
                        f2 += (float)n.a(arrby[n5]);
                    } else {
                        arrby2[n7] = (byte)(f2 / f3);
                        n7 = n9;
                        f2 = 0.0f;
                        f3 = 0.0f;
                    }
                    if (n5 == n6) {
                        return arrby2;
                    }
                    n5 = n8;
                } while (true);
            }
            return arrby2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Step must be positive, was: ");
        stringBuilder.append(n3);
        stringBuilder.append('.');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final void b(byte[] arrby, int n2, l<? super byte[], t> l2) {
        k.g(arrby, "data");
        k.g(l2, "answer");
        n.c().submit((Runnable)new f(arrby, n2, l2));
    }
}

