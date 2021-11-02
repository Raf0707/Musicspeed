/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package f.y;

import f.y.c;
import f.z.d.k;
import java.io.File;
import java.io.IOException;

public class f
extends IOException {
    private final File f;
    private final File g;
    private final String h;

    public f(File file, File file2, String string2) {
        k.g((Object)file, "file");
        super(c.a(file, file2, string2));
        this.f = file;
        this.g = file2;
        this.h = string2;
    }
}

