/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Color
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.StateSet
 *  android.util.Xml
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package b.i.h.d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import b.i.g;
import b.i.h.d.e;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {
    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n2;
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        while ((n2 = xmlPullParser.next()) != 2 && n2 != 1) {
        }
        if (n2 == 2) {
            return a.b(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String string = xmlPullParser.getName();
        if (string.equals((Object)"selector")) {
            return a.d(resources, xmlPullParser, attributeSet, theme);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": invalid color state list tag ");
        stringBuilder.append(string);
        throw new XmlPullParserException(stringBuilder.toString());
    }

    public static ColorStateList c(Resources resources, int n2, Resources.Theme theme) {
        try {
            ColorStateList colorStateList = a.a(resources, (XmlPullParser)resources.getXml(n2), theme);
            return colorStateList;
        }
        catch (Exception exception) {
            Log.e((String)"CSLCompat", (String)"Failed to inflate ColorStateList.", (Throwable)exception);
            return null;
        }
    }

    private static ColorStateList d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n2;
        int n3;
        int n4 = xmlPullParser.getDepth();
        int n5 = 1;
        int n6 = n4 + n5;
        int[][] arrarrn = new int[20][];
        int[] arrn = new int[20];
        int n7 = 0;
        while ((n3 = xmlPullParser.next()) != n5 && ((n2 = xmlPullParser.getDepth()) >= n6 || n3 != 3)) {
            if (n3 == 2 && n2 <= n6 && xmlPullParser.getName().equals((Object)"item")) {
                TypedArray typedArray = a.f(resources, theme, attributeSet, g.a);
                int n8 = typedArray.getColor(g.b, -65281);
                float f2 = 1.0f;
                int n9 = g.c;
                if (typedArray.hasValue(n9)) {
                    f2 = typedArray.getFloat(n9, f2);
                } else {
                    int n10 = g.d;
                    if (typedArray.hasValue(n10)) {
                        f2 = typedArray.getFloat(n10, f2);
                    }
                }
                typedArray.recycle();
                int n11 = attributeSet.getAttributeCount();
                int[] arrn2 = new int[n11];
                int n12 = 0;
                for (int i2 = 0; i2 < n11; ++i2) {
                    int n13 = attributeSet.getAttributeNameResource(i2);
                    if (n13 == 16843173 || n13 == 16843551 || n13 == b.i.a.a) continue;
                    int n14 = n12 + 1;
                    if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                        n13 = -n13;
                    }
                    arrn2[n12] = n13;
                    n12 = n14;
                }
                int[] arrn3 = StateSet.trimStateSet((int[])arrn2, (int)n12);
                arrn = e.a(arrn, n7, a.e(n8, f2));
                arrarrn = e.b(arrarrn, n7, arrn3);
                ++n7;
            }
            n5 = 1;
        }
        int[] arrn4 = new int[n7];
        int[][] arrarrn2 = new int[n7][];
        System.arraycopy((Object)arrn, (int)0, (Object)arrn4, (int)0, (int)n7);
        System.arraycopy((Object)arrarrn, (int)0, (Object)arrarrn2, (int)0, (int)n7);
        return new ColorStateList((int[][])arrarrn2, arrn4);
    }

    private static int e(int n2, float f2) {
        int n3 = Math.round((float)(f2 * (float)Color.alpha((int)n2)));
        return n2 & 16777215 | n3 << 24;
    }

    private static TypedArray f(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] arrn) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, arrn);
        }
        return theme.obtainStyledAttributes(attributeSet, arrn, 0, 0);
    }
}

