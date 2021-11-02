/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.DatabaseErrorHandler
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  java.lang.Object
 *  java.lang.String
 */
package b.u.a.g;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import b.u.a.c;

class b
implements c {
    private final a a;

    b(Context context, String string, c.a a2) {
        this.a = this.d(context, string, a2);
    }

    private a d(Context context, String string, c.a a2) {
        return new a(context, string, new b.u.a.g.a[1], a2);
    }

    @Override
    public void a(boolean bl) {
        this.a.setWriteAheadLoggingEnabled(bl);
    }

    @Override
    public b.u.a.b b() {
        return this.a.i();
    }

    @Override
    public String c() {
        return this.a.getDatabaseName();
    }

    @Override
    public void close() {
        this.a.close();
    }

    static class b.u.a.g.b$a
    extends SQLiteOpenHelper {
        final b.u.a.g.a[] f;
        final c.a g;
        private boolean h;

        b.u.a.g.b$a(Context context, String string, final b.u.a.g.a[] arra, c.a a2) {
            super(context, string, null, a2.a, new DatabaseErrorHandler(){

                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    a.this.c(b.u.a.g.b$a.b(arra, sQLiteDatabase));
                }
            });
            this.g = a2;
            this.f = arra;
        }

        static b.u.a.g.a b(b.u.a.g.a[] arra, SQLiteDatabase sQLiteDatabase) {
            b.u.a.g.a a2 = arra[0];
            if (a2 == null || !a2.a(sQLiteDatabase)) {
                arra[0] = new b.u.a.g.a(sQLiteDatabase);
            }
            return arra[0];
        }

        b.u.a.g.a a(SQLiteDatabase sQLiteDatabase) {
            return b.u.a.g.b$a.b(this.f, sQLiteDatabase);
        }

        public void close() {
            b.u.a.g.b$a a2 = this;
            synchronized (a2) {
                super.close();
                this.f[0] = null;
                return;
            }
        }

        b.u.a.b i() {
            b.u.a.g.b$a a2 = this;
            synchronized (a2) {
                SQLiteDatabase sQLiteDatabase;
                block4 : {
                    this.h = false;
                    sQLiteDatabase = super.getWritableDatabase();
                    if (!this.h) break block4;
                    this.close();
                    b.u.a.b b2 = this.i();
                    return b2;
                }
                b.u.a.g.a a3 = this.a(sQLiteDatabase);
                return a3;
            }
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.g.b(this.a(sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.g.d(this.a(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
            this.h = true;
            this.g.e(this.a(sQLiteDatabase), n2, n3);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.h) {
                this.g.f(this.a(sQLiteDatabase));
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
            this.h = true;
            this.g.g(this.a(sQLiteDatabase), n2, n3);
        }

    }

}

