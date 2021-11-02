/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteProgram
 *  android.database.sqlite.SQLiteStatement
 */
package b.u.a.g;

import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteStatement;
import b.u.a.f;
import b.u.a.g.d;

class e
extends d
implements f {
    private final SQLiteStatement g;

    e(SQLiteStatement sQLiteStatement) {
        super((SQLiteProgram)sQLiteStatement);
        this.g = sQLiteStatement;
    }

    @Override
    public long Y() {
        return this.g.executeInsert();
    }

    @Override
    public int l() {
        return this.g.executeUpdateDelete();
    }
}

