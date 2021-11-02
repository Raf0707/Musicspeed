/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.c.l
 *  f.z.d.k
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 */
package f.g0;

import f.z.d.k;

class l {
    public static <T> void a(Appendable appendable, T t2, f.z.c.l<? super T, ? extends CharSequence> l2) {
        k.g((Object)appendable, (String)"$this$appendElement");
        if (l2 != null) {
            appendable.append((CharSequence)l2.g(t2));
            return;
        }
        boolean bl = t2 != null ? t2 instanceof CharSequence : true;
        if (bl) {
            appendable.append((CharSequence)t2);
            return;
        }
        if (t2 instanceof Character) {
            appendable.append(((Character)t2).charValue());
            return;
        }
        appendable.append((CharSequence)String.valueOf(t2));
    }
}

