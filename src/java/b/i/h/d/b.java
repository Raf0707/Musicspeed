/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.Shader
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package b.i.h.d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import b.i.h.d.a;
import b.i.h.d.d;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class b {
    private final Shader a;
    private final ColorStateList b;
    private int c;

    private b(Shader shader, ColorStateList colorStateList, int n2) {
        this.a = shader;
        this.b = colorStateList;
        this.c = n2;
    }

    private static b a(Resources resources, int n2, Resources.Theme theme) throws IOException, XmlPullParserException {
        int n3;
        XmlResourceParser xmlResourceParser = resources.getXml(n2);
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
        while ((n3 = xmlResourceParser.next()) != 2 && n3 != 1) {
        }
        if (n3 == 2) {
            String string = xmlResourceParser.getName();
            string.hashCode();
            if (!string.equals((Object)"gradient")) {
                if (string.equals((Object)"selector")) {
                    return b.c(a.b(resources, (XmlPullParser)xmlResourceParser, attributeSet, theme));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(xmlResourceParser.getPositionDescription());
                stringBuilder.append(": unsupported complex color tag ");
                stringBuilder.append(string);
                throw new XmlPullParserException(stringBuilder.toString());
            }
            return b.d(d.b(resources, (XmlPullParser)xmlResourceParser, attributeSet, theme));
        }
        throw new XmlPullParserException("No start tag found");
    }

    static b b(int n2) {
        return new b(null, null, n2);
    }

    static b c(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    static b d(Shader shader) {
        return new b(shader, null, 0);
    }

    public static b g(Resources resources, int n2, Resources.Theme theme) {
        try {
            b b2 = b.a(resources, n2, theme);
            return b2;
        }
        catch (Exception exception) {
            Log.e((String)"ComplexColorCompat", (String)"Failed to inflate ComplexColor.", (Throwable)exception);
            return null;
        }
    }

    public int e() {
        return this.c;
    }

    public Shader f() {
        return this.a;
    }

    public boolean h() {
        return this.a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.a == null && (colorStateList = this.b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] arrn) {
        int n2;
        ColorStateList colorStateList;
        if (this.i() && (n2 = (colorStateList = this.b).getColorForState(arrn, colorStateList.getDefaultColor())) != this.c) {
            this.c = n2;
            return true;
        }
        return false;
    }

    public void k(int n2) {
        this.c = n2;
    }

    public boolean l() {
        return this.h() || this.c != 0;
        {
        }
    }
}

