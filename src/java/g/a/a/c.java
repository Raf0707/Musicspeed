/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package g.a.a;

import android.content.Intent;
import android.view.View;

public class c {
    private String a;
    private Integer b;
    private Integer c;
    private Integer d;
    private String e;
    private Intent f;
    private Integer g;
    private Boolean h = Boolean.TRUE;
    private View.OnClickListener i;

    public Boolean a() {
        return this.h;
    }

    public Integer b() {
        return this.g;
    }

    public Integer c() {
        return this.b;
    }

    public Integer d() {
        return this.d;
    }

    public Integer e() {
        return this.c;
    }

    public Intent f() {
        return this.f;
    }

    public View.OnClickListener g() {
        return this.i;
    }

    public String h() {
        return this.a;
    }

    public c i(Integer n2) {
        this.b = n2;
        return this;
    }

    public c j(Integer n2) {
        this.d = n2;
        return this;
    }

    public c k(Integer n2) {
        this.c = n2;
        return this;
    }

    public c l(Intent intent) {
        this.f = intent;
        return this;
    }

    public c m(View.OnClickListener onClickListener) {
        this.i = onClickListener;
        return this;
    }

    public c n(String string2) {
        this.a = string2;
        return this;
    }

    public c o(String string2) {
        this.e = string2;
        return this;
    }
}

