/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.SQLException
 *  android.os.CancellationSignal
 *  android.util.Pair
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package b.u.a;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import b.u.a.e;
import b.u.a.f;
import java.io.Closeable;
import java.util.List;

public interface b
extends Closeable {
    public Cursor G(String var1);

    public void I();

    public Cursor N(e var1);

    public String R();

    public boolean S();

    public void c();

    public boolean g();

    public List<Pair<String, String>> h();

    public void j(String var1) throws SQLException;

    public f m(String var1);

    public Cursor r(e var1, CancellationSignal var2);

    public void z();
}

