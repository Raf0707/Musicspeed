/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package d.a.a;

import android.content.Context;
import android.content.res.Resources;
import d.a.a.f;
import d.a.a.g.l;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c {
    private final Context a;
    private final Map<l, String> b = new HashMap();
    private Notices c;
    private Notice d;
    private String e;
    private boolean f;

    private c(Context context) {
        this.a = context;
        this.e = context.getResources().getString(f.b);
        this.f = false;
    }

    private void a(StringBuilder stringBuilder, Notice notice) {
        stringBuilder.append("<ul><li>");
        stringBuilder.append(notice.n());
        String string2 = notice.o();
        if (string2 != null && string2.length() > 0) {
            stringBuilder.append(" (<a href=\"");
            stringBuilder.append(string2);
            stringBuilder.append("\" target=\"_blank\">");
            stringBuilder.append(string2);
            stringBuilder.append("</a>)");
        }
        stringBuilder.append("</li></ul>");
        stringBuilder.append("<pre>");
        String string3 = notice.l();
        if (string3 != null) {
            stringBuilder.append(string3);
            stringBuilder.append("<br/><br/>");
        }
        stringBuilder.append(this.f(notice.m()));
        stringBuilder.append("</pre>");
    }

    private void b(StringBuilder stringBuilder) {
        stringBuilder.append("</body></html>");
    }

    private void c(StringBuilder stringBuilder) {
        stringBuilder.append("<!DOCTYPE html><html><head>");
        stringBuilder.append("<style type=\"text/css\">");
        stringBuilder.append(this.e);
        stringBuilder.append("</style>");
        stringBuilder.append("</head><body>");
    }

    public static c e(Context context) {
        return new c(context);
    }

    private String f(l l2) {
        if (l2 != null) {
            if (!this.b.containsKey((Object)l2)) {
                Map<l, String> map = this.b;
                String string2 = this.f ? l2.b(this.a) : l2.d(this.a);
                map.put((Object)l2, (Object)string2);
            }
            return (String)this.b.get((Object)l2);
        }
        return "";
    }

    public String d() {
        block4 : {
            StringBuilder stringBuilder;
            block3 : {
                block2 : {
                    stringBuilder = new StringBuilder(500);
                    this.c(stringBuilder);
                    Notice notice = this.d;
                    if (notice == null) break block2;
                    this.a(stringBuilder, notice);
                    break block3;
                }
                Notices notices = this.c;
                if (notices != null) {
                    Iterator iterator = notices.m().iterator();
                    while (iterator.hasNext()) {
                        this.a(stringBuilder, (Notice)iterator.next());
                    }
                }
                break block4;
            }
            this.b(stringBuilder);
            return stringBuilder.toString();
        }
        throw new IllegalStateException("no notice(s) set");
    }

    public c g(Notices notices) {
        this.c = notices;
        this.d = null;
        return this;
    }

    public c h(boolean bl) {
        this.f = bl;
        return this;
    }

    public c i(String string2) {
        this.e = string2;
        return this;
    }
}

