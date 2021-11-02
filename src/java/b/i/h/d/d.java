/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.LinearGradient
 *  android.graphics.RadialGradient
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.SweepGradient
 *  android.util.AttributeSet
 *  java.io.IOException
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package b.i.h.d;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import b.i.h.d.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class d {
    private static a a(a a2, int n2, int n3, boolean bl, int n4) {
        if (a2 != null) {
            return a2;
        }
        if (bl) {
            return new a(n2, n4, n3);
        }
        return new a(n2, n3);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String string = xmlPullParser.getName();
        if (string.equals((Object)"gradient")) {
            TypedArray typedArray = g.s(resources, theme, attributeSet, b.i.g.x);
            float f2 = g.j(typedArray, xmlPullParser, "startX", b.i.g.G, 0.0f);
            float f3 = g.j(typedArray, xmlPullParser, "startY", b.i.g.H, 0.0f);
            float f4 = g.j(typedArray, xmlPullParser, "endX", b.i.g.I, 0.0f);
            float f5 = g.j(typedArray, xmlPullParser, "endY", b.i.g.J, 0.0f);
            float f6 = g.j(typedArray, xmlPullParser, "centerX", b.i.g.B, 0.0f);
            float f7 = g.j(typedArray, xmlPullParser, "centerY", b.i.g.C, 0.0f);
            int n2 = g.k(typedArray, xmlPullParser, "type", b.i.g.A, 0);
            int n3 = g.f(typedArray, xmlPullParser, "startColor", b.i.g.y, 0);
            boolean bl = g.r(xmlPullParser, "centerColor");
            int n4 = g.f(typedArray, xmlPullParser, "centerColor", b.i.g.F, 0);
            int n5 = g.f(typedArray, xmlPullParser, "endColor", b.i.g.z, 0);
            int n6 = g.k(typedArray, xmlPullParser, "tileMode", b.i.g.E, 0);
            float f8 = g.j(typedArray, xmlPullParser, "gradientRadius", b.i.g.D, 0.0f);
            typedArray.recycle();
            a a2 = d.a(d.c(resources, xmlPullParser, attributeSet, theme), n3, n5, bl, n4);
            if (n2 != 1) {
                if (n2 != 2) {
                    LinearGradient linearGradient = new LinearGradient(f2, f3, f4, f5, a2.a, a2.b, d.d(n6));
                    return linearGradient;
                }
                return new SweepGradient(f6, f7, a2.a, a2.b);
            }
            if (!(f8 <= 0.0f)) {
                RadialGradient radialGradient = new RadialGradient(f6, f7, f8, a2.a, a2.b, d.d(n6));
                return radialGradient;
            }
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": invalid gradient color tag ");
        stringBuilder.append(string);
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n2;
        int n3;
        int n4 = 1 + xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while ((n2 = xmlPullParser.next()) != 1 && ((n3 = xmlPullParser.getDepth()) >= n4 || n2 != 3)) {
            if (n2 != 2 || n3 > n4 || !xmlPullParser.getName().equals((Object)"item")) continue;
            TypedArray typedArray = g.s(resources, theme, attributeSet, b.i.g.K);
            int n5 = b.i.g.L;
            boolean bl = typedArray.hasValue(n5);
            int n6 = b.i.g.M;
            boolean bl2 = typedArray.hasValue(n6);
            if (bl && bl2) {
                int n7 = typedArray.getColor(n5, 0);
                float f2 = typedArray.getFloat(n6, 0.0f);
                typedArray.recycle();
                arrayList2.add((Object)n7);
                arrayList.add((Object)Float.valueOf((float)f2));
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(xmlPullParser.getPositionDescription());
            stringBuilder.append(": <item> tag requires a 'color' attribute and a 'offset' attribute!");
            throw new XmlPullParserException(stringBuilder.toString());
        }
        if (arrayList2.size() > 0) {
            return new a((List<Integer>)arrayList2, (List<Float>)arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int n2) {
        if (n2 != 1) {
            if (n2 != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    static final class a {
        final int[] a;
        final float[] b;

        a(int n2, int n3) {
            this.a = new int[]{n2, n3};
            this.b = new float[]{0.0f, 1.0f};
        }

        a(int n2, int n3, int n4) {
            this.a = new int[]{n2, n3, n4};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List<Integer> list, List<Float> list2) {
            int n2 = list.size();
            this.a = new int[n2];
            this.b = new float[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                this.a[i2] = (Integer)list.get(i2);
                this.b[i2] = ((Float)list2.get(i2)).floatValue();
            }
        }
    }

}

