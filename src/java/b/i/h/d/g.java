/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  org.xmlpull.v1.XmlPullParser
 */
package b.i.h.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import b.i.h.d.a;
import b.i.h.d.b;
import org.xmlpull.v1.XmlPullParser;

public class g {
    public static int a(Context context, int n2, int n3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(n2, typedValue, true);
        if (typedValue.resourceId != 0) {
            return n2;
        }
        return n3;
    }

    public static boolean b(TypedArray typedArray, int n2, int n3, boolean bl) {
        return typedArray.getBoolean(n2, typedArray.getBoolean(n3, bl));
    }

    public static Drawable c(TypedArray typedArray, int n2, int n3) {
        Drawable drawable = typedArray.getDrawable(n2);
        if (drawable == null) {
            drawable = typedArray.getDrawable(n3);
        }
        return drawable;
    }

    public static int d(TypedArray typedArray, int n2, int n3, int n4) {
        return typedArray.getInt(n2, typedArray.getInt(n3, n4));
    }

    public static boolean e(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2, boolean bl) {
        if (!g.r(xmlPullParser, string)) {
            return bl;
        }
        return typedArray.getBoolean(n2, bl);
    }

    public static int f(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2, int n3) {
        if (!g.r(xmlPullParser, string)) {
            return n3;
        }
        return typedArray.getColor(n2, n3);
    }

    public static ColorStateList g(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String string, int n2) {
        if (g.r(xmlPullParser, string)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(n2, typedValue);
            int n3 = typedValue.type;
            if (n3 != 2) {
                if (n3 >= 28 && n3 <= 31) {
                    return g.h(typedValue);
                }
                return a.c(typedArray.getResources(), typedArray.getResourceId(n2, 0), theme);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to resolve attribute at index ");
            stringBuilder.append(n2);
            stringBuilder.append(": ");
            stringBuilder.append((Object)typedValue);
            throw new UnsupportedOperationException(stringBuilder.toString());
        }
        return null;
    }

    private static ColorStateList h(TypedValue typedValue) {
        return ColorStateList.valueOf((int)typedValue.data);
    }

    public static b i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String string, int n2, int n3) {
        if (g.r(xmlPullParser, string)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(n2, typedValue);
            int n4 = typedValue.type;
            if (n4 >= 28 && n4 <= 31) {
                return b.b(typedValue.data);
            }
            b b2 = b.g(typedArray.getResources(), typedArray.getResourceId(n2, 0), theme);
            if (b2 != null) {
                return b2;
            }
        }
        return b.b(n3);
    }

    public static float j(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2, float f2) {
        if (!g.r(xmlPullParser, string)) {
            return f2;
        }
        return typedArray.getFloat(n2, f2);
    }

    public static int k(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2, int n3) {
        if (!g.r(xmlPullParser, string)) {
            return n3;
        }
        return typedArray.getInt(n2, n3);
    }

    public static int l(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2, int n3) {
        if (!g.r(xmlPullParser, string)) {
            return n3;
        }
        return typedArray.getResourceId(n2, n3);
    }

    public static String m(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2) {
        if (!g.r(xmlPullParser, string)) {
            return null;
        }
        return typedArray.getString(n2);
    }

    public static int n(TypedArray typedArray, int n2, int n3, int n4) {
        return typedArray.getResourceId(n2, typedArray.getResourceId(n3, n4));
    }

    public static String o(TypedArray typedArray, int n2, int n3) {
        String string = typedArray.getString(n2);
        if (string == null) {
            string = typedArray.getString(n3);
        }
        return string;
    }

    public static CharSequence p(TypedArray typedArray, int n2, int n3) {
        CharSequence charSequence = typedArray.getText(n2);
        if (charSequence == null) {
            charSequence = typedArray.getText(n3);
        }
        return charSequence;
    }

    public static CharSequence[] q(TypedArray typedArray, int n2, int n3) {
        CharSequence[] arrcharSequence = typedArray.getTextArray(n2);
        if (arrcharSequence == null) {
            arrcharSequence = typedArray.getTextArray(n3);
        }
        return arrcharSequence;
    }

    public static boolean r(XmlPullParser xmlPullParser, String string) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", string) != null;
    }

    public static TypedArray s(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] arrn) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, arrn);
        }
        return theme.obtainStyledAttributes(attributeSet, arrn, 0, 0);
    }

    public static TypedValue t(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2) {
        if (!g.r(xmlPullParser, string)) {
            return null;
        }
        return typedArray.peekValue(n2);
    }
}

