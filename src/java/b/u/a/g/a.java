/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteCursor
 *  android.database.sqlite.SQLiteCursorDriver
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteProgram
 *  android.database.sqlite.SQLiteQuery
 *  android.database.sqlite.SQLiteStatement
 *  android.os.CancellationSignal
 *  android.util.Pair
 *  b.u.a.g.e
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package b.u.a.g;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import android.util.Pair;
import b.u.a.d;
import b.u.a.e;
import b.u.a.f;
import java.io.IOException;
import java.util.List;

class a
implements b.u.a.b {
    private static final String[] f = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] g = new String[0];
    private final SQLiteDatabase h;

    a(SQLiteDatabase sQLiteDatabase) {
        this.h = sQLiteDatabase;
    }

    @Override
    public Cursor G(String string) {
        return this.N(new b.u.a.a(string));
    }

    @Override
    public void I() {
        this.h.endTransaction();
    }

    @Override
    public Cursor N(final e e2) {
        return this.h.rawQueryWithFactory(new SQLiteDatabase.CursorFactory(){

            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string, SQLiteQuery sQLiteQuery) {
                e2.b(new b.u.a.g.d((SQLiteProgram)sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, string, sQLiteQuery);
            }
        }, e2.a(), g, null);
    }

    @Override
    public String R() {
        return this.h.getPath();
    }

    @Override
    public boolean S() {
        return this.h.inTransaction();
    }

    boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.h == sQLiteDatabase;
    }

    @Override
    public void c() {
        this.h.beginTransaction();
    }

    public void close() throws IOException {
        this.h.close();
    }

    @Override
    public boolean g() {
        return this.h.isOpen();
    }

    @Override
    public List<Pair<String, String>> h() {
        return this.h.getAttachedDbs();
    }

    @Override
    public void j(String string) throws SQLException {
        this.h.execSQL(string);
    }

    @Override
    public f m(String string) {
        return new b.u.a.g.e(this.h.compileStatement(string));
    }

    @Override
    public Cursor r(final e e2, CancellationSignal cancellationSignal) {
        return this.h.rawQueryWithFactory(new SQLiteDatabase.CursorFactory(){

            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string, SQLiteQuery sQLiteQuery) {
                e2.b(new b.u.a.g.d((SQLiteProgram)sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, string, sQLiteQuery);
            }
        }, e2.a(), g, null, cancellationSignal);
    }

    @Override
    public void z() {
        this.h.setTransactionSuccessful();
    }

}

