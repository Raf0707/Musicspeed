/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.database.DataSetObserver
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.Filter
 *  android.widget.Filterable
 *  b.j.a.a$a
 *  b.j.a.a$b
 *  b.j.a.b
 *  b.j.a.b$a
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.j.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import b.j.a.a;
import b.j.a.b;

/*
 * Exception performing whole class analysis.
 */
public abstract class a
extends BaseAdapter
implements Filterable,
b.a {
    protected boolean f;
    protected boolean g;
    protected Cursor h;
    protected Context i;
    protected int j;
    protected a k;
    protected DataSetObserver l;
    protected b.j.a.b m;

    public a(Context context, Cursor cursor, boolean bl) {
        int n2 = bl ? 1 : 2;
        this.f(context, cursor, n2);
    }

    public void a(Cursor cursor) {
        Cursor cursor2 = this.j(cursor);
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public Cursor b() {
        return this.h;
    }

    public abstract CharSequence c(Cursor var1);

    public abstract void e(View var1, Context var2, Cursor var3);

    void f(Context context, Cursor cursor, int n2) {
        if ((n2 & 1) == 1) {
            n2 |= 2;
            this.g = true;
        } else {
            this.g = false;
        }
        boolean bl = false;
        if (cursor != null) {
            bl = true;
        }
        this.h = cursor;
        this.f = bl;
        this.i = context;
        int n3 = bl ? cursor.getColumnIndexOrThrow("_id") : -1;
        this.j = n3;
        if ((n2 & 2) == 2) {
            this.k = new /* Unavailable Anonymous Inner Class!! */;
            this.l = new /* Unavailable Anonymous Inner Class!! */;
        } else {
            this.k = null;
            this.l = null;
        }
        if (bl) {
            DataSetObserver dataSetObserver;
            a a2 = this.k;
            if (a2 != null) {
                cursor.registerContentObserver((ContentObserver)a2);
            }
            if ((dataSetObserver = this.l) != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context var1, Cursor var2, ViewGroup var3);

    public int getCount() {
        Cursor cursor;
        if (this.f && (cursor = this.h) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    public View getDropDownView(int n2, View view, ViewGroup viewGroup) {
        if (this.f) {
            this.h.moveToPosition(n2);
            if (view == null) {
                view = this.g(this.i, this.h, viewGroup);
            }
            this.e(view, this.i, this.h);
            return view;
        }
        return null;
    }

    public Filter getFilter() {
        if (this.m == null) {
            this.m = new b.j.a.b((b.a)this);
        }
        return this.m;
    }

    public Object getItem(int n2) {
        Cursor cursor;
        if (this.f && (cursor = this.h) != null) {
            cursor.moveToPosition(n2);
            return this.h;
        }
        return null;
    }

    public long getItemId(int n2) {
        Cursor cursor;
        if (this.f && (cursor = this.h) != null && cursor.moveToPosition(n2)) {
            return this.h.getLong(this.j);
        }
        return 0L;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        if (this.f) {
            if (this.h.moveToPosition(n2)) {
                if (view == null) {
                    view = this.h(this.i, this.h, viewGroup);
                }
                this.e(view, this.i, this.h);
                return view;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("couldn't move cursor to position ");
            stringBuilder.append(n2);
            throw new IllegalStateException(stringBuilder.toString());
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public abstract View h(Context var1, Cursor var2, ViewGroup var3);

    protected void i() {
        Cursor cursor;
        if (this.g && (cursor = this.h) != null && !cursor.isClosed()) {
            this.f = this.h.requery();
        }
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.h;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            DataSetObserver dataSetObserver;
            a a2 = this.k;
            if (a2 != null) {
                cursor2.unregisterContentObserver((ContentObserver)a2);
            }
            if ((dataSetObserver = this.l) != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.h = cursor;
        if (cursor != null) {
            DataSetObserver dataSetObserver;
            a a3 = this.k;
            if (a3 != null) {
                cursor.registerContentObserver((ContentObserver)a3);
            }
            if ((dataSetObserver = this.l) != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
            this.j = cursor.getColumnIndexOrThrow("_id");
            this.f = true;
            this.notifyDataSetChanged();
            return cursor2;
        }
        this.j = -1;
        this.f = false;
        this.notifyDataSetInvalidated();
        return cursor2;
    }
}

