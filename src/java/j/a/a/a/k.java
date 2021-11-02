/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package j.a.a.a;

public class k {

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        private static final /* synthetic */ a[] j;

        static {
            a a2;
            a a3;
            a a4;
            a a5;
            f = a5 = new a();
            g = a4 = new a();
            h = a2 = new a();
            i = a3 = new a();
            j = new a[]{a5, a4, a2, a3};
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])j.clone();
        }
    }

}

