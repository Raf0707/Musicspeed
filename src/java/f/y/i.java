/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.f
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.util.Arrays
 */
package f.y;

import f.g0.c;
import f.u.f;
import f.y.a;
import f.y.b;
import f.y.d;
import f.y.h;
import f.z.d.k;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

class i
extends h {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static byte[] a(File var0) {
        k.g((Object)var0, "$this$readBytes");
        var1_1 = new FileInputStream(var0);
        try {
            block10 : {
                block9 : {
                    var4_2 = var0.length();
                    if (var4_2 <= (long)Integer.MAX_VALUE) {
                        var12_3 = (int)var4_2;
                        var13_4 = new byte[var12_3];
                        var15_6 = 0;
                    } else {
                        var6_14 = new StringBuilder();
                        var6_14.append("File ");
                        var6_14.append((Object)var0);
                        var6_14.append(" is too big (");
                        var6_14.append(var4_2);
                        var6_14.append(" bytes) to fit in memory.");
                        throw new OutOfMemoryError(var6_14.toString());
                    }
                    for (var14_5 = var12_3; var14_5 > 0 && (var16_7 = var1_1.read(var13_4, var15_6, var14_5)) >= 0; var14_5 -= var16_7, var15_6 += var16_7) {
                    }
                    if (var14_5 <= 0) ** GOTO lbl24
                    var13_4 = Arrays.copyOf((byte[])var13_4, (int)var15_6);
                    k.f(var13_4, "java.util.Arrays.copyOf(this, newSize)");
                    break block9;
lbl24: // 1 sources:
                    var17_8 = var1_1.read();
                    if (var17_8 == -1) break block9;
                    var18_9 = new d(8193);
                    var18_9.write(var17_8);
                    a.b((InputStream)var1_1, (OutputStream)var18_9, 0, 2, null);
                    var21_10 = var12_3 + var18_9.size();
                    if (var21_10 < 0) break block10;
                    var22_11 = var18_9.a();
                    var23_12 = Arrays.copyOf((byte[])var13_4, (int)var21_10);
                    k.f(var23_12, "java.util.Arrays.copyOf(this, newSize)");
                    var13_4 = f.b((byte[])var22_11, (byte[])var23_12, (int)var12_3, (int)0, (int)var18_9.size());
                }
                b.a((Closeable)var1_1, null);
                return var13_4;
            }
            var24_13 = new StringBuilder();
            var24_13.append("File ");
            var24_13.append((Object)var0);
            var24_13.append(" is too big to fit in memory.");
            throw new OutOfMemoryError(var24_13.toString());
        }
        catch (Throwable var2_15) {
            try {
                throw var2_15;
            }
            catch (Throwable var3_16) {
                b.a((Closeable)var1_1, var2_15);
                throw var3_16;
            }
        }
    }

    public static final void b(File file, byte[] arrby) {
        k.g((Object)file, "$this$writeBytes");
        k.g(arrby, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(arrby);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                b.a((Closeable)fileOutputStream, throwable);
                throw throwable2;
            }
        }
        b.a((Closeable)fileOutputStream, null);
    }

    public static final void c(File file, String string2, Charset charset) {
        k.g((Object)file, "$this$writeText");
        k.g(string2, "text");
        k.g((Object)charset, "charset");
        byte[] arrby = string2.getBytes(charset);
        k.f(arrby, "(this as java.lang.String).getBytes(charset)");
        i.b(file, arrby);
    }

    public static /* synthetic */ void d(File file, String string2, Charset charset, int n2, Object object) {
        if ((n2 & 2) != 0) {
            charset = c.a;
        }
        i.c(file, string2, charset);
    }
}

