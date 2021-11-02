/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.view.WindowInsets
 *  b.i.q.e0$c
 *  b.i.q.e0$d
 *  b.i.q.e0$e
 *  b.i.q.e0$g
 *  b.i.q.e0$h
 *  b.i.q.e0$i
 *  b.i.q.e0$j
 *  b.i.q.e0$k
 *  b.i.q.w
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.ReflectiveOperationException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 */
package b.i.q;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import b.i.q.e0;
import b.i.q.w;
import java.lang.reflect.Field;

/*
 * Exception performing whole class analysis.
 */
public class e0 {
    public static final e0 a;
    private final l b;

    static {
        a = Build.VERSION.SDK_INT >= 30 ? k.r : l.a;
    }

    private e0(WindowInsets windowInsets) {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 30) {
            this.b = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        if (n2 >= 29) {
            this.b = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        if (n2 >= 28) {
            this.b = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        if (n2 >= 21) {
            this.b = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        if (n2 >= 20) {
            this.b = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        this.b = new l(this);
    }

    public e0(e0 e02) {
        if (e02 != null) {
            l l2 = e02.b;
            int n2 = Build.VERSION.SDK_INT;
            this.b = n2 >= 30 && l2 instanceof k ? new /* Unavailable Anonymous Inner Class!! */ : (n2 >= 29 && l2 instanceof j ? new /* Unavailable Anonymous Inner Class!! */ : (n2 >= 28 && l2 instanceof i ? new /* Unavailable Anonymous Inner Class!! */ : (n2 >= 21 && l2 instanceof h ? new /* Unavailable Anonymous Inner Class!! */ : (n2 >= 20 && l2 instanceof g ? new /* Unavailable Anonymous Inner Class!! */ : new l(this)))));
            l2.e(this);
            return;
        }
        this.b = new l(this);
    }

    static b.i.i.b k(b.i.i.b b2, int n2, int n3, int n4, int n5) {
        int n6 = Math.max((int)0, (int)(b2.b - n2));
        int n7 = Math.max((int)0, (int)(b2.c - n3));
        int n8 = Math.max((int)0, (int)(b2.d - n4));
        int n9 = Math.max((int)0, (int)(b2.e - n5));
        if (n6 == n2 && n7 == n3 && n8 == n4 && n9 == n5) {
            return b2;
        }
        return b.i.i.b.b(n6, n7, n8, n9);
    }

    public static e0 s(WindowInsets windowInsets) {
        return e0.t(windowInsets, null);
    }

    public static e0 t(WindowInsets windowInsets, View view) {
        e0 e02 = new e0(b.i.p.h.d(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            e02.p(w.K((View)view));
            e02.d(view.getRootView());
        }
        return e02;
    }

    @Deprecated
    public e0 a() {
        return this.b.a();
    }

    @Deprecated
    public e0 b() {
        return this.b.b();
    }

    @Deprecated
    public e0 c() {
        return this.b.c();
    }

    void d(View view) {
        this.b.d(view);
    }

    @Deprecated
    public b.i.i.b e() {
        return this.b.g();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof e0)) {
            return false;
        }
        e0 e02 = (e0)object;
        return b.i.p.c.a(this.b, e02.b);
    }

    @Deprecated
    public int f() {
        return this.b.i().e;
    }

    @Deprecated
    public int g() {
        return this.b.i().b;
    }

    @Deprecated
    public int h() {
        return this.b.i().d;
    }

    public int hashCode() {
        l l2 = this.b;
        if (l2 == null) {
            return 0;
        }
        return l2.hashCode();
    }

    @Deprecated
    public int i() {
        return this.b.i().c;
    }

    public e0 j(int n2, int n3, int n4, int n5) {
        return this.b.j(n2, n3, n4, n5);
    }

    public boolean l() {
        return this.b.k();
    }

    @Deprecated
    public e0 m(int n2, int n3, int n4, int n5) {
        return new b(this).c(b.i.i.b.b(n2, n3, n4, n5)).a();
    }

    void n(b.i.i.b[] arrb) {
        this.b.m(arrb);
    }

    void o(b.i.i.b b2) {
        this.b.n(b2);
    }

    void p(e0 e02) {
        this.b.o(e02);
    }

    void q(b.i.i.b b2) {
        this.b.p(b2);
    }

    public WindowInsets r() {
        l l2 = this.b;
        if (l2 instanceof g) {
            return (l2).i;
        }
        return null;
    }

    static class a {
        private static Field a;
        private static Field b;
        private static Field c;
        private static boolean d;

        static {
            try {
                Field field;
                Field field2;
                Field field3;
                a = field = View.class.getDeclaredField("mAttachInfo");
                field.setAccessible(true);
                Class class_ = Class.forName((String)"android.view.View$AttachInfo");
                b = field2 = class_.getDeclaredField("mStableInsets");
                field2.setAccessible(true);
                c = field3 = class_.getDeclaredField("mContentInsets");
                field3.setAccessible(true);
                d = true;
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to get visible insets from AttachInfo ");
                stringBuilder.append(reflectiveOperationException.getMessage());
                Log.w((String)"WindowInsetsCompat", (String)stringBuilder.toString(), (Throwable)reflectiveOperationException);
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public static e0 a(View view) {
            if (!d) return null;
            if (!view.isAttachedToWindow()) {
                return null;
            }
            View view2 = view.getRootView();
            Object object = a.get((Object)view2);
            if (object == null) return null;
            Rect rect = (Rect)b.get(object);
            Rect rect2 = (Rect)c.get(object);
            if (rect == null || rect2 == null) return null;
            try {
                e0 e02 = new b().b(b.i.i.b.c(rect)).c(b.i.i.b.c(rect2)).a();
                e02.p(e02);
                e02.d(view.getRootView());
                return e02;
            }
            catch (IllegalAccessException illegalAccessException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to get insets from AttachInfo. ");
                stringBuilder.append(illegalAccessException.getMessage());
                Log.w((String)"WindowInsetsCompat", (String)stringBuilder.toString(), (Throwable)illegalAccessException);
            }
            return null;
        }
    }

    /*
     * Exception performing whole class analysis.
     */
    public static final class b {
        private final f a;

        public b() {
            int n2 = Build.VERSION.SDK_INT;
            if (n2 >= 30) {
                this.a = new /* Unavailable Anonymous Inner Class!! */;
                return;
            }
            if (n2 >= 29) {
                this.a = new /* Unavailable Anonymous Inner Class!! */;
                return;
            }
            if (n2 >= 20) {
                this.a = new /* Unavailable Anonymous Inner Class!! */;
                return;
            }
            this.a = new f();
        }

        public b(e0 e02) {
            int n2 = Build.VERSION.SDK_INT;
            if (n2 >= 30) {
                this.a = new /* Unavailable Anonymous Inner Class!! */;
                return;
            }
            if (n2 >= 29) {
                this.a = new /* Unavailable Anonymous Inner Class!! */;
                return;
            }
            if (n2 >= 20) {
                this.a = new /* Unavailable Anonymous Inner Class!! */;
                return;
            }
            this.a = new f(e02);
        }

        public e0 a() {
            return this.a.b();
        }

        @Deprecated
        public b b(b.i.i.b b2) {
            this.a.d(b2);
            return this;
        }

        @Deprecated
        public b c(b.i.i.b b2) {
            this.a.f(b2);
            return this;
        }
    }

    private static class f {
        private final e0 a;
        b.i.i.b[] b;

        f() {
            this(new e0(null));
        }

        f(e0 e02) {
            this.a = e02;
        }

        protected final void a() {
            b.i.i.b[] arrb = this.b;
            if (arrb != null) {
                b.i.i.b b2;
                b.i.i.b b3;
                b.i.i.b b4 = arrb[m.a(1)];
                b.i.i.b b5 = this.b[m.a(2)];
                if (b4 != null && b5 != null) {
                    this.f(b.i.i.b.a(b4, b5));
                } else if (b4 != null) {
                    this.f(b4);
                } else if (b5 != null) {
                    this.f(b5);
                }
                b.i.i.b b6 = this.b[m.a(16)];
                if (b6 != null) {
                    this.e(b6);
                }
                if ((b2 = this.b[m.a(32)]) != null) {
                    this.c(b2);
                }
                if ((b3 = this.b[m.a(64)]) != null) {
                    this.g(b3);
                }
            }
        }

        e0 b() {
            this.a();
            return this.a;
        }

        void c(b.i.i.b b2) {
        }

        void d(b.i.i.b b2) {
        }

        void e(b.i.i.b b2) {
        }

        void f(b.i.i.b b2) {
        }

        void g(b.i.i.b b2) {
        }
    }

    private static class l {
        static final e0 a = new b().a().a().b().c();
        final e0 b;

        l(e0 e02) {
            this.b = e02;
        }

        e0 a() {
            return this.b;
        }

        e0 b() {
            return this.b;
        }

        e0 c() {
            return this.b;
        }

        void d(View view) {
        }

        void e(e0 e02) {
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof l)) {
                return false;
            }
            l l2 = (l)object;
            return this.l() == l2.l() && this.k() == l2.k() && b.i.p.c.a(this.i(), l2.i()) && b.i.p.c.a(this.h(), l2.h()) && b.i.p.c.a(this.f(), l2.f());
        }

        b.i.q.c f() {
            return null;
        }

        b.i.i.b g() {
            return this.i();
        }

        b.i.i.b h() {
            return b.i.i.b.a;
        }

        public int hashCode() {
            Object[] arrobject = new Object[]{this.l(), this.k(), this.i(), this.h(), this.f()};
            return b.i.p.c.b(arrobject);
        }

        b.i.i.b i() {
            return b.i.i.b.a;
        }

        e0 j(int n2, int n3, int n4, int n5) {
            return a;
        }

        boolean k() {
            return false;
        }

        boolean l() {
            return false;
        }

        public void m(b.i.i.b[] arrb) {
        }

        void n(b.i.i.b b2) {
        }

        void o(e0 e02) {
        }

        public void p(b.i.i.b b2) {
        }
    }

    public static final class m {
        static int a(int n2) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 4) {
                        if (n2 != 8) {
                            if (n2 != 16) {
                                if (n2 != 32) {
                                    if (n2 != 64) {
                                        if (n2 != 128) {
                                            if (n2 == 256) {
                                                return 8;
                                            }
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("type needs to be >= FIRST and <= LAST, type=");
                                            stringBuilder.append(n2);
                                            throw new IllegalArgumentException(stringBuilder.toString());
                                        }
                                        return 7;
                                    }
                                    return 6;
                                }
                                return 5;
                            }
                            return 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 1;
            }
            return 0;
        }
    }

}

