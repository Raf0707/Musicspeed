/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Base64
 *  android.util.TypedValue
 *  android.util.Xml
 *  b.i.h.d.c$b
 *  b.i.h.d.c$d
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package b.i.h.d;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import b.i.g;
import b.i.h.d.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/*
 * Exception performing whole class analysis.
 */
public class c {
    private static int a(TypedArray typedArray, int n2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(n2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(n2, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int n2;
        while ((n2 = xmlPullParser.next()) != 2 && n2 != 1) {
        }
        if (n2 == 2) {
            return c.d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static List<List<byte[]>> c(Resources var0, int var1_1) {
        block10 : {
            block9 : {
                if (var1_1 == 0) {
                    return Collections.emptyList();
                }
                var2_2 = var0.obtainTypedArray(var1_1);
                try {
                    if (var2_2.length() != 0) break block9;
                    var9_3 = Collections.emptyList();
                }
                catch (Throwable var3_7) {
                    var2_2.recycle();
                    throw var3_7;
                }
                var2_2.recycle();
                return var9_3;
            }
            var4_4 = new ArrayList();
            if (c.a(var2_2, 0) == 1) {
                var5_5 = 0;
                break block10;
            }
            var4_4.add(c.h(var0.getStringArray(var1_1)));
            ** GOTO lbl-1000
        }
        do {
            if (var5_5 < var2_2.length()) {
                var6_6 = var2_2.getResourceId(var5_5, 0);
                if (var6_6 != 0) {
                    var4_4.add(c.h(var0.getStringArray(var6_6)));
                }
            } else lbl-1000: // 2 sources:
            {
                var2_2.recycle();
                return var4_4;
            }
            ++var5_5;
        } while (true);
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals((Object)"font-family")) {
            return c.e(xmlPullParser, resources);
        }
        c.g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArray = resources.obtainAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), g.e);
        String string = typedArray.getString(g.f);
        String string2 = typedArray.getString(g.j);
        String string3 = typedArray.getString(g.k);
        int n2 = typedArray.getResourceId(g.g, 0);
        int n3 = typedArray.getInteger(g.h, 1);
        int n4 = typedArray.getInteger(g.i, 500);
        String string4 = typedArray.getString(g.l);
        typedArray.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                c.g(xmlPullParser);
            }
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() != 2) continue;
            if (xmlPullParser.getName().equals((Object)"font")) {
                arrayList.add((Object)c.f(xmlPullParser, resources));
                continue;
            }
            c.g(xmlPullParser);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    private static c f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int n2;
        TypedArray typedArray = resources.obtainAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), g.m);
        if (!typedArray.hasValue(n2 = g.v)) {
            n2 = g.o;
        }
        int n3 = typedArray.getInt(n2, 400);
        int n4 = g.t;
        if (!typedArray.hasValue(n4)) {
            n4 = g.p;
        }
        boolean bl = 1 == typedArray.getInt(n4, 0);
        int n5 = g.w;
        if (!typedArray.hasValue(n5)) {
            n5 = g.q;
        }
        int n6 = g.u;
        if (!typedArray.hasValue(n6)) {
            n6 = g.r;
        }
        String string = typedArray.getString(n6);
        int n7 = typedArray.getInt(n5, 0);
        int n8 = g.s;
        if (!typedArray.hasValue(n8)) {
            n8 = g.n;
        }
        int n9 = typedArray.getResourceId(n8, 0);
        String string2 = typedArray.getString(n8);
        typedArray.recycle();
        while (xmlPullParser.next() != 3) {
            c.g(xmlPullParser);
        }
        c c2 = new c(string2, n3, bl, string, n7, n9);
        return c2;
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int n2 = 1;
        while (n2 > 0) {
            int n3 = xmlPullParser.next();
            if (n3 != 2) {
                if (n3 != 3) continue;
                --n2;
                continue;
            }
            ++n2;
        }
    }

    private static List<byte[]> h(String[] arrstring) {
        ArrayList arrayList = new ArrayList();
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add((Object)Base64.decode((String)arrstring[i2], (int)0));
        }
        return arrayList;
    }

    public static interface a {
    }

    public static final class c {
        private final String a;
        private int b;
        private boolean c;
        private String d;
        private int e;
        private int f;

        public c(String string, int n2, boolean bl, String string2, int n3, int n4) {
            this.a = string;
            this.b = n2;
            this.c = bl;
            this.d = string2;
            this.e = n3;
            this.f = n4;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.e;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.b;
        }

        public boolean f() {
            return this.c;
        }
    }

}

