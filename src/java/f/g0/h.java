/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.g0.h$a
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.MatchResult
 *  java.util.regex.Matcher
 */
package f.g0;

import f.g0.f;
import f.g0.g;
import f.g0.h;
import f.z.d.k;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

final class h
implements g {
    private final f a;
    private final Matcher b;
    private final CharSequence c;

    public h(Matcher matcher, CharSequence charSequence) {
        k.g((Object)matcher, "matcher");
        k.g((Object)charSequence, "input");
        this.b = matcher;
        this.c = charSequence;
        this.a = new a(this);
    }

    public static final /* synthetic */ MatchResult a(h h2) {
        return h2.b();
    }

    private final MatchResult b() {
        return this.b;
    }

    @Override
    public String getValue() {
        String string2 = this.b().group();
        k.f(string2, "matchResult.group()");
        return string2;
    }
}

