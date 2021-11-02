/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package e.a.a.a;

public final class b {
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;

    private b(b b2) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        Integer n2;
        Integer n3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        Integer n4;
        Integer n5;
        Integer n6;
        Integer n7;
        this.a = n5 = b2.a;
        this.b = n3 = b2.b;
        this.c = n6 = b2.c;
        this.d = n4 = b2.d;
        this.e = n2 = b2.e;
        this.f = n7 = b2.f;
        this.g = bl3 = b2.g;
        this.h = bl6 = b2.h;
        this.i = bl2 = b2.i;
        this.j = bl5 = b2.j;
        this.k = bl = b2.k;
        this.l = bl4 = b2.l;
        if (n5 != null && bl3) {
            throw new IllegalArgumentException("itemResourceId and itemViewWillBeProvided cannot both be set");
        }
        if (n5 == null && !bl3) {
            throw new IllegalArgumentException("Either itemResourceId or itemViewWillBeProvided must be set");
        }
        if (n3 != null && bl6) {
            throw new IllegalArgumentException("headerResourceId and headerViewWillBeProvided cannot both be set");
        }
        if (n6 != null && bl2) {
            throw new IllegalArgumentException("footerResourceId and footerViewWillBeProvided cannot both be set");
        }
        if (n4 != null && bl5) {
            throw new IllegalArgumentException("loadingResourceId and loadingViewWillBeProvided cannot both be set");
        }
        if (n2 != null && bl) {
            throw new IllegalArgumentException("failedResourceId and failedViewWillBeProvided cannot both be set");
        }
        if (n7 != null) {
            if (!bl4) {
                return;
            }
            throw new IllegalArgumentException("emptyResourceId and emptyViewWillBeProvided cannot both be set");
        }
    }

    public static b a() {
        return new b();
    }

    public static class b {
        private Integer a;
        private Integer b;
        private Integer c;
        private Integer d;
        private Integer e;
        private Integer f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;

        private b() {
        }

        public b m() {
            return new b(this);
        }

        public b n(int n2) {
            this.b = n2;
            return this;
        }

        public b o(int n2) {
            this.a = n2;
            return this;
        }
    }

}

