/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.Typeface
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.text.PrecomputedText
 *  android.text.PrecomputedText$Params
 *  android.text.PrecomputedText$Params$Builder
 *  android.text.Spannable
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.style.MetricAffectingSpan
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package b.i.o;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import b.i.p.c;
import java.util.Locale;

public class d
implements Spannable {
    private static final Object f = new Object();
    private final Spannable g;
    private final a h;
    private final PrecomputedText i;

    public a a() {
        return this.h;
    }

    public PrecomputedText b() {
        Spannable spannable = this.g;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText)spannable;
        }
        return null;
    }

    public char charAt(int n2) {
        return this.g.charAt(n2);
    }

    public int getSpanEnd(Object object) {
        return this.g.getSpanEnd(object);
    }

    public int getSpanFlags(Object object) {
        return this.g.getSpanFlags(object);
    }

    public int getSpanStart(Object object) {
        return this.g.getSpanStart(object);
    }

    @SuppressLint(value={"NewApi"})
    public <T> T[] getSpans(int n2, int n3, Class<T> class_) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.i.getSpans(n2, n3, class_);
        }
        return this.g.getSpans(n2, n3, class_);
    }

    public int length() {
        return this.g.length();
    }

    public int nextSpanTransition(int n2, int n3, Class class_) {
        return this.g.nextSpanTransition(n2, n3, class_);
    }

    @SuppressLint(value={"NewApi"})
    public void removeSpan(Object object) {
        if (!(object instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.i.removeSpan(object);
                return;
            }
            this.g.removeSpan(object);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @SuppressLint(value={"NewApi"})
    public void setSpan(Object object, int n2, int n3, int n4) {
        if (!(object instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.i.setSpan(object, n2, n3, n4);
                return;
            }
            this.g.setSpan(object, n2, n3, n4);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public CharSequence subSequence(int n2, int n3) {
        return this.g.subSequence(n2, n3);
    }

    public String toString() {
        return this.g.toString();
    }

    public static final class b.i.o.d$a {
        private final TextPaint a;
        private final TextDirectionHeuristic b;
        private final int c;
        private final int d;
        final PrecomputedText.Params e;

        public b.i.o.d$a(PrecomputedText.Params params) {
            this.a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            if (Build.VERSION.SDK_INT < 29) {
                params = null;
            }
            this.e = params;
        }

        @SuppressLint(value={"NewApi"})
        b.i.o.d$a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int n2, int n3) {
            this.e = Build.VERSION.SDK_INT >= 29 ? new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(n2).setHyphenationFrequency(n3).setTextDirection(textDirectionHeuristic).build() : null;
            this.a = textPaint;
            this.b = textDirectionHeuristic;
            this.c = n2;
            this.d = n3;
        }

        public boolean a(b.i.o.d$a a2) {
            int n2 = Build.VERSION.SDK_INT;
            if (n2 >= 23) {
                if (this.c != a2.b()) {
                    return false;
                }
                if (this.d != a2.c()) {
                    return false;
                }
            }
            if (this.a.getTextSize() != a2.e().getTextSize()) {
                return false;
            }
            if (this.a.getTextScaleX() != a2.e().getTextScaleX()) {
                return false;
            }
            if (this.a.getTextSkewX() != a2.e().getTextSkewX()) {
                return false;
            }
            if (n2 >= 21) {
                if (this.a.getLetterSpacing() != a2.e().getLetterSpacing()) {
                    return false;
                }
                if (!TextUtils.equals((CharSequence)this.a.getFontFeatureSettings(), (CharSequence)a2.e().getFontFeatureSettings())) {
                    return false;
                }
            }
            if (this.a.getFlags() != a2.e().getFlags()) {
                return false;
            }
            if (n2 >= 24 ? !this.a.getTextLocales().equals((Object)a2.e().getTextLocales()) : n2 >= 17 && !this.a.getTextLocale().equals((Object)a2.e().getTextLocale())) {
                return false;
            }
            return !(this.a.getTypeface() == null ? a2.e().getTypeface() != null : !this.a.getTypeface().equals((Object)a2.e().getTypeface()));
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public TextDirectionHeuristic d() {
            return this.b;
        }

        public TextPaint e() {
            return this.a;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof b.i.o.d$a)) {
                return false;
            }
            b.i.o.d$a a2 = (b.i.o.d$a)object;
            if (!this.a(a2)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.b == a2.d();
        }

        public int hashCode() {
            int n2 = Build.VERSION.SDK_INT;
            if (n2 >= 24) {
                Object[] arrobject = new Object[]{Float.valueOf((float)this.a.getTextSize()), Float.valueOf((float)this.a.getTextScaleX()), Float.valueOf((float)this.a.getTextSkewX()), Float.valueOf((float)this.a.getLetterSpacing()), this.a.getFlags(), this.a.getTextLocales(), this.a.getTypeface(), this.a.isElegantTextHeight(), this.b, this.c, this.d};
                return c.b(arrobject);
            }
            if (n2 >= 21) {
                Object[] arrobject = new Object[]{Float.valueOf((float)this.a.getTextSize()), Float.valueOf((float)this.a.getTextScaleX()), Float.valueOf((float)this.a.getTextSkewX()), Float.valueOf((float)this.a.getLetterSpacing()), this.a.getFlags(), this.a.getTextLocale(), this.a.getTypeface(), this.a.isElegantTextHeight(), this.b, this.c, this.d};
                return c.b(arrobject);
            }
            if (n2 >= 18) {
                Object[] arrobject = new Object[]{Float.valueOf((float)this.a.getTextSize()), Float.valueOf((float)this.a.getTextScaleX()), Float.valueOf((float)this.a.getTextSkewX()), this.a.getFlags(), this.a.getTextLocale(), this.a.getTypeface(), this.b, this.c, this.d};
                return c.b(arrobject);
            }
            if (n2 >= 17) {
                Object[] arrobject = new Object[]{Float.valueOf((float)this.a.getTextSize()), Float.valueOf((float)this.a.getTextScaleX()), Float.valueOf((float)this.a.getTextSkewX()), this.a.getFlags(), this.a.getTextLocale(), this.a.getTypeface(), this.b, this.c, this.d};
                return c.b(arrobject);
            }
            Object[] arrobject = new Object[]{Float.valueOf((float)this.a.getTextSize()), Float.valueOf((float)this.a.getTextScaleX()), Float.valueOf((float)this.a.getTextSkewX()), this.a.getFlags(), this.a.getTypeface(), this.b, this.c, this.d};
            return c.b(arrobject);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("textSize=");
            stringBuilder2.append(this.a.getTextSize());
            stringBuilder.append(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(", textScaleX=");
            stringBuilder3.append(this.a.getTextScaleX());
            stringBuilder.append(stringBuilder3.toString());
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(", textSkewX=");
            stringBuilder4.append(this.a.getTextSkewX());
            stringBuilder.append(stringBuilder4.toString());
            int n2 = Build.VERSION.SDK_INT;
            if (n2 >= 21) {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(", letterSpacing=");
                stringBuilder5.append(this.a.getLetterSpacing());
                stringBuilder.append(stringBuilder5.toString());
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append(", elegantTextHeight=");
                stringBuilder6.append(this.a.isElegantTextHeight());
                stringBuilder.append(stringBuilder6.toString());
            }
            if (n2 >= 24) {
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append(", textLocale=");
                stringBuilder7.append((Object)this.a.getTextLocales());
                stringBuilder.append(stringBuilder7.toString());
            } else if (n2 >= 17) {
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append(", textLocale=");
                stringBuilder8.append((Object)this.a.getTextLocale());
                stringBuilder.append(stringBuilder8.toString());
            }
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append(", typeface=");
            stringBuilder9.append((Object)this.a.getTypeface());
            stringBuilder.append(stringBuilder9.toString());
            if (n2 >= 26) {
                StringBuilder stringBuilder10 = new StringBuilder();
                stringBuilder10.append(", variationSettings=");
                stringBuilder10.append(this.a.getFontVariationSettings());
                stringBuilder.append(stringBuilder10.toString());
            }
            StringBuilder stringBuilder11 = new StringBuilder();
            stringBuilder11.append(", textDir=");
            stringBuilder11.append((Object)this.b);
            stringBuilder.append(stringBuilder11.toString());
            StringBuilder stringBuilder12 = new StringBuilder();
            stringBuilder12.append(", breakStrategy=");
            stringBuilder12.append(this.c);
            stringBuilder.append(stringBuilder12.toString());
            StringBuilder stringBuilder13 = new StringBuilder();
            stringBuilder13.append(", hyphenationFrequency=");
            stringBuilder13.append(this.d);
            stringBuilder.append(stringBuilder13.toString());
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public static class a {
            private final TextPaint a;
            private TextDirectionHeuristic b;
            private int c;
            private int d;

            public a(TextPaint textPaint) {
                this.a = textPaint;
                int n2 = Build.VERSION.SDK_INT;
                if (n2 >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                if (n2 >= 18) {
                    this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    return;
                }
                this.b = null;
            }

            public b.i.o.d$a a() {
                return new b.i.o.d$a(this.a, this.b, this.c, this.d);
            }

            public a b(int n2) {
                this.c = n2;
                return this;
            }

            public a c(int n2) {
                this.d = n2;
                return this;
            }

            public a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.b = textDirectionHeuristic;
                return this;
            }
        }

    }

}

