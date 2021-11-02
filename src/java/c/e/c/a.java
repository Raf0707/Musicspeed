/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.c.v
 *  com.google.gson.internal.bind.d.a
 *  com.google.gson.internal.d
 *  com.google.gson.internal.i
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.sql.Date
 *  java.sql.Timestamp
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.ParsePosition
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 */
package c.e.c;

import c.e.c.t;
import c.e.c.v;
import c.e.c.z.b;
import c.e.c.z.c;
import com.google.gson.internal.d;
import com.google.gson.internal.i;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

final class a
extends v<java.util.Date> {
    private final Class<? extends java.util.Date> a;
    private final List<DateFormat> b;

    public a(Class<? extends java.util.Date> class_, int n2, int n3) {
        ArrayList arrayList;
        this.b = arrayList = new ArrayList();
        this.a = a.c(class_);
        Locale locale = Locale.US;
        arrayList.add((Object)DateFormat.getDateTimeInstance((int)n2, (int)n3, (Locale)locale));
        if (!Locale.getDefault().equals((Object)locale)) {
            arrayList.add((Object)DateFormat.getDateTimeInstance((int)n2, (int)n3));
        }
        if (d.e()) {
            arrayList.add((Object)i.c((int)n2, (int)n3));
        }
    }

    a(Class<? extends java.util.Date> class_, String string) {
        ArrayList arrayList;
        this.b = arrayList = new ArrayList();
        this.a = a.c(class_);
        Locale locale = Locale.US;
        arrayList.add((Object)new SimpleDateFormat(string, locale));
        if (!Locale.getDefault().equals((Object)locale)) {
            arrayList.add((Object)new SimpleDateFormat(string));
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private java.util.Date a(String string) {
        List<DateFormat> list;
        List<DateFormat> list2 = list = this.b;
        synchronized (list2) {
            Iterator iterator = this.b.iterator();
            if (iterator.hasNext()) {
                DateFormat dateFormat = (DateFormat)iterator.next();
                return dateFormat.parse(string);
            }
            try {
                return com.google.gson.internal.bind.d.a.c((String)string, (ParsePosition)new ParsePosition(0));
            }
            catch (ParseException parseException) {
                throw new t(string, parseException);
            }
        }
    }

    private static Class<? extends java.util.Date> c(Class<? extends java.util.Date> class_) {
        if (class_ != java.util.Date.class && class_ != Date.class) {
            if (class_ == Timestamp.class) {
                return class_;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Date type must be one of ");
            stringBuilder.append(java.util.Date.class);
            stringBuilder.append(", ");
            stringBuilder.append(Timestamp.class);
            stringBuilder.append(", or ");
            stringBuilder.append(Date.class);
            stringBuilder.append(" but was ");
            stringBuilder.append(class_);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return class_;
    }

    public java.util.Date b(c.e.c.z.a a2) throws IOException {
        if (a2.g0() == b.n) {
            a2.c0();
            return null;
        }
        java.util.Date date = this.a(a2.e0());
        Class<? extends java.util.Date> class_ = this.a;
        if (class_ == java.util.Date.class) {
            return date;
        }
        if (class_ == Timestamp.class) {
            return new Timestamp(date.getTime());
        }
        if (class_ == Date.class) {
            return new Date(date.getTime());
        }
        throw new AssertionError();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(c c2, java.util.Date date) throws IOException {
        List<DateFormat> list;
        if (date == null) {
            c2.P();
            return;
        }
        List<DateFormat> list2 = list = this.b;
        synchronized (list2) {
            c2.j0(((DateFormat)this.b.get(0)).format(date));
            return;
        }
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat)this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DefaultDateTypeAdapter(");
            stringBuilder.append(((SimpleDateFormat)dateFormat).toPattern());
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DefaultDateTypeAdapter(");
        stringBuilder.append(dateFormat.getClass().getSimpleName());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

