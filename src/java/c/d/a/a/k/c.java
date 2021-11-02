/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.d
 *  c.d.a.a.e
 *  c.d.a.a.f
 *  c.d.a.a.g
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package c.d.a.a.k;

import c.d.a.a.d;
import c.d.a.a.e;
import c.d.a.a.f;
import c.d.a.a.g;
import c.d.a.a.k.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class c
extends b {
    public /* varargs */ c(String ... arrstring) {
        super(arrstring);
    }

    private String f(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone((String)"UTC"));
        return simpleDateFormat.format(date);
    }

    @Override
    protected String b(d d2, f f2, e e2) {
        Object[] arrobject = new Object[]{f2.b(), f2.c()};
        String string = String.format((String)"%s (%s)", (Object[])arrobject);
        Object[] arrobject2 = new Object[]{d2.b(), d2.d()};
        String string2 = String.format((String)"%s (%s)", (Object[])arrobject2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Time Stamp: ");
        stringBuilder.append(this.f(new Date()));
        stringBuilder.append("\nApp Version: ");
        stringBuilder.append(string2);
        stringBuilder.append("\nInstall Source: ");
        stringBuilder.append((Object)d2.c());
        stringBuilder.append("\nAndroid Version: ");
        stringBuilder.append(string);
        stringBuilder.append("\nDevice Manufacturer: ");
        stringBuilder.append(e2.a());
        stringBuilder.append("\nDevice Model: ");
        stringBuilder.append(e2.b());
        stringBuilder.append("\nDisplay Resolution: ");
        stringBuilder.append(e2.d());
        stringBuilder.append("\nDisplay Density (Actual): ");
        stringBuilder.append(e2.c());
        stringBuilder.append("\nDisplay Density (Bucket) ");
        stringBuilder.append(e2.e());
        stringBuilder.append("\n---------------------\n\n");
        return stringBuilder.toString();
    }

    @Override
    protected String d(d d2, f f2, e e2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d2.getName());
        stringBuilder.append(" Android App Feedback");
        return stringBuilder.toString();
    }
}

