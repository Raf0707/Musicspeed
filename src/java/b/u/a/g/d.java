/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteProgram
 *  java.lang.Object
 *  java.lang.String
 */
package b.u.a.g;

import android.database.sqlite.SQLiteProgram;

class d
implements b.u.a.d {
    private final SQLiteProgram f;

    d(SQLiteProgram sQLiteProgram) {
        this.f = sQLiteProgram;
    }

    @Override
    public void C(int n2, byte[] arrby) {
        this.f.bindBlob(n2, arrby);
    }

    @Override
    public void O(int n2) {
        this.f.bindNull(n2);
    }

    public void close() {
        this.f.close();
    }

    @Override
    public void k(int n2, String string) {
        this.f.bindString(n2, string);
    }

    @Override
    public void q(int n2, double d2) {
        this.f.bindDouble(n2, d2);
    }

    @Override
    public void y(int n2, long l2) {
        this.f.bindLong(n2, l2);
    }
}

