/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.d0.g
 *  f.u.l
 *  f.z.d.g
 *  f.z.d.k
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package f.g0;

import f.g0.g;
import f.g0.j;
import f.u.l;
import f.z.d.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
implements Serializable {
    public static final a f = new a(null);
    private final Pattern g;

    public i(String string2) {
        k.g((Object)string2, (String)"pattern");
        Pattern pattern = Pattern.compile((String)string2);
        k.f((Object)pattern, (String)"Pattern.compile(pattern)");
        this(pattern);
    }

    public i(Pattern pattern) {
        k.g((Object)pattern, (String)"nativePattern");
        this.g = pattern;
    }

    public static /* synthetic */ g b(i i2, CharSequence charSequence, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return i2.a(charSequence, n2);
    }

    public final g a(CharSequence charSequence, int n2) {
        k.g((Object)charSequence, (String)"input");
        Matcher matcher = this.g.matcher(charSequence);
        k.f((Object)matcher, (String)"nativePattern.matcher(input)");
        return j.a(matcher, n2, charSequence);
    }

    public final List<String> c(CharSequence charSequence, int n2) {
        k.g((Object)charSequence, (String)"input");
        int n3 = 0;
        boolean bl = n2 >= 0;
        if (bl) {
            Matcher matcher = this.g.matcher(charSequence);
            if (matcher.find() && n2 != 1) {
                int n4 = 10;
                if (n2 > 0) {
                    n4 = f.d0.g.d((int)n2, (int)n4);
                }
                ArrayList arrayList = new ArrayList(n4);
                int n5 = n2 - 1;
                do {
                    arrayList.add((Object)charSequence.subSequence(n3, matcher.start()).toString());
                    n3 = matcher.end();
                } while ((n5 < 0 || arrayList.size() != n5) && matcher.find());
                arrayList.add((Object)charSequence.subSequence(n3, charSequence.length()).toString());
                return arrayList;
            }
            return l.b((Object)charSequence.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Limit must be non-negative, but was ");
        stringBuilder.append(n2);
        stringBuilder.append('.');
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public String toString() {
        String string2 = this.g.toString();
        k.f((Object)string2, (String)"nativePattern.toString()");
        return string2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f.z.d.g g2) {
            this();
        }
    }

}

