/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.d0.f
 *  f.d0.g
 *  f.g0.h
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.util.regex.MatchResult
 *  java.util.regex.Matcher
 */
package f.g0;

import f.d0.f;
import f.g0.g;
import f.g0.h;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public final class j {
    public static final /* synthetic */ g a(Matcher matcher, int n2, CharSequence charSequence) {
        return j.c(matcher, n2, charSequence);
    }

    public static final /* synthetic */ f b(MatchResult matchResult, int n2) {
        return j.d(matchResult, n2);
    }

    private static final g c(Matcher matcher, int n2, CharSequence charSequence) {
        if (!matcher.find(n2)) {
            return null;
        }
        return new h(matcher, charSequence);
    }

    private static final f d(MatchResult matchResult, int n2) {
        return f.d0.g.i((int)matchResult.start(n2), (int)matchResult.end(n2));
    }
}

