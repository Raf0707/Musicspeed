/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package h.e.f;

import h.e.b;
import h.e.f.d;

public abstract class a
extends d
implements b {
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append("(");
        stringBuilder.append(this.getName());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

