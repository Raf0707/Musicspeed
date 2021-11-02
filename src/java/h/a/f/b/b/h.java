/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.reflect.Modifier
 */
package h.a.f.b.b;

import java.lang.reflect.Modifier;

class h {
    static h a;
    static h b;
    static h c;
    boolean d = true;
    boolean e = true;
    boolean f = false;
    boolean g = false;
    boolean h = false;
    boolean i = true;
    boolean j = true;
    boolean k = true;
    int l;

    static {
        h h2;
        h h3;
        h h4;
        a = h3 = new h();
        h3.d = true;
        h3.e = false;
        h3.f = false;
        h3.g = false;
        h3.h = true;
        h3.i = false;
        h3.j = false;
        h3.l = 0;
        b = h2 = new h();
        h2.d = true;
        h2.e = true;
        h2.f = false;
        h2.g = false;
        h2.h = false;
        h.a.l = 1;
        c = h4 = new h();
        h4.d = false;
        h4.e = true;
        h4.f = false;
        h4.g = true;
        h4.h = false;
        h4.k = false;
        h4.l = 2;
    }

    h() {
    }

    public void a(StringBuffer stringBuffer, Class[] arrclass) {
        if (arrclass == null) {
            return;
        }
        if (!this.e) {
            if (arrclass.length == 0) {
                stringBuffer.append("()");
                return;
            }
            stringBuffer.append("(..)");
            return;
        }
        stringBuffer.append("(");
        this.c(stringBuffer, arrclass);
        stringBuffer.append(")");
    }

    public void b(StringBuffer stringBuffer, Class[] arrclass) {
        if (this.f && arrclass != null) {
            if (arrclass.length == 0) {
                return;
            }
            stringBuffer.append(" throws ");
            this.c(stringBuffer, arrclass);
        }
    }

    public void c(StringBuffer stringBuffer, Class[] arrclass) {
        for (int i2 = 0; i2 < arrclass.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.g(arrclass[i2]));
        }
    }

    String d(String string2) {
        int n2 = string2.lastIndexOf(45);
        if (n2 == -1) {
            return string2;
        }
        return string2.substring(n2 + 1);
    }

    String e(int n2) {
        if (!this.g) {
            return "";
        }
        String string2 = Modifier.toString((int)n2);
        if (string2.length() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string2);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    public String f(Class class_, String string2) {
        return this.h(class_, string2, this.h);
    }

    public String g(Class class_) {
        return this.h(class_, class_.getName(), this.d);
    }

    String h(Class class_, String string2, boolean bl) {
        if (class_ == null) {
            return "ANONYMOUS";
        }
        if (class_.isArray()) {
            Class class_2 = class_.getComponentType();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.h(class_2, class_2.getName(), bl));
            stringBuffer.append("[]");
            return stringBuffer.toString();
        }
        if (bl) {
            return this.i(string2).replace('$', '.');
        }
        return string2.replace('$', '.');
    }

    String i(String string2) {
        int n2 = string2.lastIndexOf(46);
        if (n2 == -1) {
            return string2;
        }
        return string2.substring(n2 + 1);
    }
}

