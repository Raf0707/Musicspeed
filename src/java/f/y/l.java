/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package f.y;

import f.y.f;
import f.z.d.g;
import f.z.d.k;
import java.io.File;

public final class l
extends f {
    public l(File file, File file2, String string2) {
        k.g((Object)file, "file");
        super(file, file2, string2);
    }

    public /* synthetic */ l(File file, File file2, String string2, int n2, g g2) {
        if ((n2 & 2) != 0) {
            file2 = null;
        }
        if ((n2 & 4) != 0) {
            string2 = null;
        }
        this(file, file2, string2);
    }
}

