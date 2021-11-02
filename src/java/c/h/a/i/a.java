/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileFilter
 *  java.lang.Object
 */
package c.h.a.i;

import java.io.File;
import java.io.FileFilter;

public class a
implements FileFilter {
    public boolean accept(File file) {
        return file.isDirectory();
    }
}

