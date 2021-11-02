/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.a.i.a
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package h.a.i;

import h.a.f.a.b;
import h.a.i.a;

public class e {
    private static /* synthetic */ Throwable a;
    public static /* synthetic */ e b;

    static {
        try {
            e.a();
        }
        catch (Throwable throwable) {
            a = throwable;
        }
    }

    private static /* synthetic */ void a() {
        b = new e();
    }

    public static e b() {
        e e2 = b;
        if (e2 != null) {
            return e2;
        }
        throw new b("org.mp4parser.support.RequiresParseDetailAspect", a);
    }

    public void c(h.a.f.a.a a2) {
        if (a2.a() instanceof a) {
            if (!((a)a2.a()).h()) {
                ((a)a2.a()).j();
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Only methods in subclasses of ");
        stringBuilder.append(a.class.getName());
        stringBuilder.append(" can  be annotated with ParseDetail");
        throw new RuntimeException(stringBuilder.toString());
    }
}

