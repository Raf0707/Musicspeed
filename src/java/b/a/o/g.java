/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.InflateException
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  androidx.appcompat.view.menu.i
 *  androidx.appcompat.view.menu.j
 *  androidx.appcompat.widget.p0
 *  androidx.appcompat.widget.x
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Method
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package b.a.o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.p0;
import androidx.appcompat.widget.x;
import b.a.j;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g
extends MenuInflater {
    static final Class<?>[] a;
    static final Class<?>[] b;
    final Object[] c;
    final Object[] d;
    Context e;
    private Object f;

    static {
        Class[] arrclass = new Class[]{Context.class};
        a = arrclass;
        b = arrclass;
    }

    public g(Context context) {
        super(context);
        this.e = context;
        Object[] arrobject = new Object[]{context};
        this.c = arrobject;
        this.d = arrobject;
    }

    private Object a(Object object) {
        if (object instanceof Activity) {
            return object;
        }
        if (object instanceof ContextWrapper) {
            object = this.a((Object)((ContextWrapper)object).getBaseContext());
        }
        return object;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b b2 = new b(menu);
        int n2 = xmlPullParser.getEventType();
        do {
            if (n2 != 2) continue;
            String string = xmlPullParser.getName();
            if (string.equals((Object)"menu")) {
                n2 = xmlPullParser.next();
                break;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expecting menu, got ");
            stringBuilder.append(string);
            throw new RuntimeException(stringBuilder.toString());
        } while ((n2 = xmlPullParser.next()) != 1);
        String string = null;
        boolean bl = false;
        boolean bl2 = false;
        while (!bl) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 == 3) {
                        String string2 = xmlPullParser.getName();
                        if (bl2 && string2.equals(string)) {
                            bl2 = false;
                            string = null;
                        } else if (string2.equals((Object)"group")) {
                            b2.h();
                        } else if (string2.equals((Object)"item")) {
                            if (!b2.d()) {
                                b.i.q.b b3 = b2.A;
                                if (b3 != null && b3.a()) {
                                    b2.b();
                                } else {
                                    b2.a();
                                }
                            }
                        } else if (string2.equals((Object)"menu")) {
                            bl = true;
                        }
                    }
                } else if (!bl2) {
                    String string3 = xmlPullParser.getName();
                    if (string3.equals((Object)"group")) {
                        b2.f(attributeSet);
                    } else if (string3.equals((Object)"item")) {
                        b2.g(attributeSet);
                    } else if (string3.equals((Object)"menu")) {
                        this.c(xmlPullParser, attributeSet, (Menu)b2.b());
                    } else {
                        string = string3;
                        bl2 = true;
                    }
                }
                n2 = xmlPullParser.next();
                continue;
            }
            throw new RuntimeException("Unexpected end of document");
        }
    }

    Object b() {
        if (this.f == null) {
            this.f = this.a((Object)this.e);
        }
        return this.f;
    }

    /*
     * Exception decompiling
     */
    public void inflate(int var1_1, Menu var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 1[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    private static class a
    implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] f = new Class[]{MenuItem.class};
        private Object g;
        private Method h;

        public a(Object object, String string) {
            this.g = object;
            Class class_ = object.getClass();
            try {
                this.h = class_.getMethod(string, f);
                return;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't resolve menu item onClick handler ");
                stringBuilder.append(string);
                stringBuilder.append(" in class ");
                stringBuilder.append(class_.getName());
                InflateException inflateException = new InflateException(stringBuilder.toString());
                inflateException.initCause((Throwable)exception);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.h.getReturnType() == Boolean.TYPE) {
                    return (Boolean)this.h.invoke(this.g, new Object[]{menuItem});
                }
                this.h.invoke(this.g, new Object[]{menuItem});
                return true;
            }
            catch (Exception exception) {
                throw new RuntimeException((Throwable)exception);
            }
        }
    }

    private class b {
        b.i.q.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;
        private Menu a;
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.a = menu;
            this.h();
        }

        private char c(String string) {
            if (string == null) {
                return '\u0000';
            }
            return string.charAt(0);
        }

        private <T> T e(String string, Class<?>[] arrclass, Object[] arrobject) {
            Object object;
            try {
                Constructor constructor = Class.forName((String)string, (boolean)false, (ClassLoader)g.this.e.getClassLoader()).getConstructor(arrclass);
                constructor.setAccessible(true);
                object = constructor.newInstance(arrobject);
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot instantiate class: ");
                stringBuilder.append(string);
                Log.w((String)"SupportMenuInflater", (String)stringBuilder.toString(), (Throwable)exception);
                return null;
            }
            return (T)object;
        }

        private void i(MenuItem menuItem) {
            b.i.q.b b2;
            ColorStateList colorStateList;
            int n2;
            MenuItem menuItem2 = menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u);
            boolean bl = this.r >= 1;
            menuItem2.setCheckable(bl).setTitleCondensed(this.l).setIcon(this.m);
            int n3 = this.v;
            if (n3 >= 0) {
                menuItem.setShowAsAction(n3);
            }
            if (this.z != null) {
                if (!g.this.e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new a(g.this.b(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof i) {
                    ((i)menuItem).t(true);
                } else if (menuItem instanceof androidx.appcompat.view.menu.j) {
                    ((androidx.appcompat.view.menu.j)menuItem).h(true);
                }
            }
            String string = this.x;
            boolean bl2 = false;
            if (string != null) {
                menuItem.setActionView((View)this.e(string, g.a, g.this.c));
                bl2 = true;
            }
            if ((n2 = this.w) > 0) {
                if (!bl2) {
                    menuItem.setActionView(n2);
                } else {
                    Log.w((String)"SupportMenuInflater", (String)"Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if ((b2 = this.A) != null) {
                b.i.q.j.a(menuItem, b2);
            }
            b.i.q.j.c(menuItem, this.B);
            b.i.q.j.g(menuItem, this.C);
            b.i.q.j.b(menuItem, this.n, this.o);
            b.i.q.j.f(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                b.i.q.j.e(menuItem, mode);
            }
            if ((colorStateList = this.D) != null) {
                b.i.q.j.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.h = true;
            this.i(this.a.add(this.b, this.i, this.j, this.k));
        }

        public SubMenu b() {
            this.h = true;
            SubMenu subMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            this.i(subMenu.getItem());
            return subMenu;
        }

        public boolean d() {
            return this.h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArray = g.this.e.obtainStyledAttributes(attributeSet, j.z1);
            this.b = typedArray.getResourceId(j.B1, 0);
            this.c = typedArray.getInt(j.D1, 0);
            this.d = typedArray.getInt(j.E1, 0);
            this.e = typedArray.getInt(j.F1, 0);
            this.f = typedArray.getBoolean(j.C1, true);
            this.g = typedArray.getBoolean(j.A1, true);
            typedArray.recycle();
        }

        public void g(AttributeSet attributeSet) {
            String string;
            p0 p02 = p0.u((Context)g.this.e, (AttributeSet)attributeSet, (int[])j.G1);
            this.i = p02.n(j.J1, 0);
            int n2 = p02.k(j.M1, this.c);
            int n3 = p02.k(j.N1, this.d);
            this.j = n2 & -65536 | n3 & 65535;
            this.k = p02.p(j.O1);
            this.l = p02.p(j.P1);
            this.m = p02.n(j.H1, 0);
            this.n = this.c(p02.o(j.Q1));
            this.o = p02.k(j.X1, 4096);
            this.p = this.c(p02.o(j.R1));
            this.q = p02.k(j.b2, 4096);
            int n4 = j.S1;
            this.r = p02.s(n4) ? (int)(p02.a(n4, false) ? 1 : 0) : this.e;
            this.s = p02.a(j.K1, false);
            this.t = p02.a(j.L1, this.f);
            this.u = p02.a(j.I1, this.g);
            this.v = p02.k(j.c2, -1);
            this.z = p02.o(j.T1);
            this.w = p02.n(j.U1, 0);
            this.x = p02.o(j.W1);
            this.y = string = p02.o(j.V1);
            boolean bl = string != null;
            if (bl && this.w == 0 && this.x == null) {
                this.A = (b.i.q.b)this.e(string, g.b, g.this.d);
            } else {
                if (bl) {
                    Log.w((String)"SupportMenuInflater", (String)"Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = p02.p(j.Y1);
            this.C = p02.p(j.d2);
            int n5 = j.a2;
            this.E = p02.s(n5) ? x.e((int)p02.k(n5, -1), (PorterDuff.Mode)this.E) : null;
            int n6 = j.Z1;
            this.D = p02.s(n6) ? p02.c(n6) : null;
            p02.w();
            this.h = false;
        }

        public void h() {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }
    }

}

