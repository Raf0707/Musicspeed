/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.c0.b
 *  f.u.f
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package f.x;

import f.c0.b;
import f.c0.c;
import f.u.f;
import f.z.d.k;
import java.lang.reflect.Method;

public class a {
    public void a(Throwable throwable, Throwable throwable2) {
        k.g((Object)throwable, "cause");
        k.g((Object)throwable2, "exception");
        Method method = a.a;
        if (method != null) {
            method.invoke((Object)throwable, new Object[]{throwable2});
        }
    }

    public c b() {
        return new b();
    }

    private static final class a {
        public static final Method a;
        public static final Method b;
        public static final a c;

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        static {
            block6 : {
                a.c = new a();
                var0 = Throwable.class.getMethods();
                k.f(var0, "throwableMethods");
                var1_1 = var0.length;
                var2_2 = 0;
                for (var3_3 = 0; var3_3 < var1_1; ++var3_3) {
                    var4_4 = var0[var3_3];
                    k.f((Object)var4_4, "it");
                    if (!k.c(var4_4.getName(), "addSuppressed")) ** GOTO lbl-1000
                    var9_6 = var4_4.getParameterTypes();
                    k.f(var9_6, "it.parameterTypes");
                    if (k.c((Object)((Class)f.n((Object[])var9_6)), Throwable.class)) {
                        var8_5 = true;
                    } else lbl-1000: // 2 sources:
                    {
                        var8_5 = false;
                    }
                    if (!var8_5) {
                        continue;
                    }
                    break block6;
                }
                var4_4 = null;
            }
            a.a = var4_4;
            var5_7 = var0.length;
            do {
                var6_8 = null;
                if (var2_2 >= var5_7) break;
                var7_9 = var0[var2_2];
                k.f((Object)var7_9, "it");
                if (k.c(var7_9.getName(), "getSuppressed")) {
                    var6_8 = var7_9;
                    break;
                }
                ++var2_2;
            } while (true);
            a.b = var6_8;
        }

        private a() {
        }
    }

}

