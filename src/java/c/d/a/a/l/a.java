/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  c.d.a.a.l.b
 *  java.lang.Object
 *  java.lang.String
 */
package c.d.a.a.l;

import android.util.Log;
import c.d.a.a.l.b;

public final class a
implements b {
    private final String a;

    public a() {
        this("Amplify");
    }

    public a(String string) {
        this.a = string;
    }

    public void a(String string) {
        Log.e((String)this.a, (String)string);
    }

    public void b(String string) {
        Log.d((String)this.a, (String)string);
    }
}

