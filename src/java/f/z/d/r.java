/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.z.d;

import f.z.d.d;
import f.z.d.k;

public final class r
implements d {
    private final Class<?> a;
    private final String b;

    public r(Class<?> class_, String string) {
        k.g(class_, "jClass");
        k.g(string, "moduleName");
        this.a = class_;
        this.b = string;
    }

    @Override
    public Class<?> b() {
        return this.a;
    }

    public boolean equals(Object object) {
        return object instanceof r && k.c(this.b(), ((r)object).b());
    }

    public int hashCode() {
        return this.b().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b().toString());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }
}

