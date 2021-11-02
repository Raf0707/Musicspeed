/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.y;

import f.z.d.k;
import java.io.File;

public final class c {
    public static final /* synthetic */ String a(File file, File file2, String string2) {
        return c.b(file, file2, string2);
    }

    private static final String b(File file, File file2, String string2) {
        StringBuilder stringBuilder = new StringBuilder(file.toString());
        if (file2 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" -> ");
            stringBuilder2.append((Object)file2);
            stringBuilder.append(stringBuilder2.toString());
        }
        if (string2 != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(": ");
            stringBuilder3.append(string2);
            stringBuilder.append(stringBuilder3.toString());
        }
        String string3 = stringBuilder.toString();
        k.f(string3, "sb.toString()");
        return string3;
    }
}

