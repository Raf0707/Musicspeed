/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.PathMeasure
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.Shader
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.VectorDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  androidx.core.graphics.drawable.a
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package b.x.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import b.i.i.c;
import b.x.a.a.i;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i
extends b.x.a.a.h {
    static final PorterDuff.Mode g = PorterDuff.Mode.SRC_IN;
    private h h;
    private PorterDuffColorFilter i;
    private ColorFilter j;
    private boolean k;
    private boolean l = true;
    private Drawable.ConstantState m;
    private final float[] n = new float[9];
    private final Matrix o = new Matrix();
    private final Rect p = new Rect();

    i() {
        this.h = new Drawable.ConstantState(){
            int a;
            g b;
            ColorStateList c = null;
            PorterDuff.Mode d = i.g;
            boolean e;
            Bitmap f;
            ColorStateList g;
            PorterDuff.Mode h;
            int i;
            boolean j;
            boolean k;
            Paint l;
            {
                this.b = new Object(){
                    private static final Matrix a = new Matrix();
                    private final Path b;
                    private final Path c;
                    private final Matrix d = new Matrix();
                    Paint e;
                    Paint f;
                    private PathMeasure g;
                    private int h;
                    final d i;
                    float j = 0.0f;
                    float k = 0.0f;
                    float l = 0.0f;
                    float m = 0.0f;
                    int n = 255;
                    String o = null;
                    Boolean p = null;
                    final b.e.a<String, Object> q;
                    {
                        this.q = new b.e.a();
                        this.i = new e(){
                            final Matrix a = new Matrix();
                            final ArrayList<e> b = new ArrayList();
                            float c = 0.0f;
                            private float d = 0.0f;
                            private float e = 0.0f;
                            private float f = 1.0f;
                            private float g = 1.0f;
                            private float h = 0.0f;
                            private float i = 0.0f;
                            final Matrix j;
                            int k;
                            private int[] l;
                            private String m;
                            {
                                this.j = new Matrix();
                                this.m = null;
                            }
                            {
                                String string;
                                Matrix matrix;
                                super();
                                this.j = matrix = new Matrix();
                                this.m = null;
                                this.c = d2.c;
                                this.d = d2.d;
                                this.e = d2.e;
                                this.f = d2.f;
                                this.g = d2.g;
                                this.h = d2.h;
                                this.i = d2.i;
                                this.l = d2.l;
                                this.m = string = d2.m;
                                this.k = d2.k;
                                if (string != null) {
                                    a2.put(string, this);
                                }
                                matrix.set(d2.j);
                                ArrayList<e> arrayList = d2.b;
                                for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                                    block8 : {
                                        f f2;
                                        block7 : {
                                            Object object;
                                            block6 : {
                                                object = arrayList.get(i2);
                                                if (object instanceof d) {
                                                    d d3 = object;
                                                    this.b.add((Object)new /* invalid duplicate definition of identical inner class */);
                                                    continue;
                                                }
                                                if (!(object instanceof c)) break block6;
                                                f2 = new c((c)object);
                                                break block7;
                                            }
                                            if (!(object instanceof b)) break block8;
                                            f2 = new b((b)object);
                                        }
                                        this.b.add((Object)f2);
                                        String string2 = f2.b;
                                        if (string2 == null) continue;
                                        a2.put(string2, f2);
                                        continue;
                                    }
                                    throw new IllegalStateException("Unknown object in the tree!");
                                }
                            }

                            private void d() {
                                this.j.reset();
                                this.j.postTranslate(-this.d, -this.e);
                                this.j.postScale(this.f, this.g);
                                this.j.postRotate(this.c, 0.0f, 0.0f);
                                this.j.postTranslate(this.h + this.d, this.i + this.e);
                            }

                            private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
                                this.l = null;
                                this.c = b.i.h.d.g.j(typedArray, xmlPullParser, "rotation", 5, this.c);
                                this.d = typedArray.getFloat(1, this.d);
                                this.e = typedArray.getFloat(2, this.e);
                                this.f = b.i.h.d.g.j(typedArray, xmlPullParser, "scaleX", 3, this.f);
                                this.g = b.i.h.d.g.j(typedArray, xmlPullParser, "scaleY", 4, this.g);
                                this.h = b.i.h.d.g.j(typedArray, xmlPullParser, "translateX", 6, this.h);
                                this.i = b.i.h.d.g.j(typedArray, xmlPullParser, "translateY", 7, this.i);
                                String string = typedArray.getString(0);
                                if (string != null) {
                                    this.m = string;
                                }
                                this.d();
                            }

                            @Override
                            public boolean a() {
                                for (int i2 = 0; i2 < this.b.size(); ++i2) {
                                    if (!(this.b.get(i2)).a()) continue;
                                    return true;
                                }
                                return false;
                            }

                            @Override
                            public boolean b(int[] arrn) {
                                boolean bl = false;
                                for (int i2 = 0; i2 < this.b.size(); ++i2) {
                                    bl |= (this.b.get(i2)).b(arrn);
                                }
                                return bl;
                            }

                            public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
                                TypedArray typedArray = b.i.h.d.g.s(resources, theme, attributeSet, b.x.a.a.a.b);
                                this.e(typedArray, xmlPullParser);
                                typedArray.recycle();
                            }

                            public String getGroupName() {
                                return this.m;
                            }

                            public Matrix getLocalMatrix() {
                                return this.j;
                            }

                            public float getPivotX() {
                                return this.d;
                            }

                            public float getPivotY() {
                                return this.e;
                            }

                            public float getRotation() {
                                return this.c;
                            }

                            public float getScaleX() {
                                return this.f;
                            }

                            public float getScaleY() {
                                return this.g;
                            }

                            public float getTranslateX() {
                                return this.h;
                            }

                            public float getTranslateY() {
                                return this.i;
                            }

                            public void setPivotX(float f2) {
                                if (f2 != this.d) {
                                    this.d = f2;
                                    this.d();
                                }
                            }

                            public void setPivotY(float f2) {
                                if (f2 != this.e) {
                                    this.e = f2;
                                    this.d();
                                }
                            }

                            public void setRotation(float f2) {
                                if (f2 != this.c) {
                                    this.c = f2;
                                    this.d();
                                }
                            }

                            public void setScaleX(float f2) {
                                if (f2 != this.f) {
                                    this.f = f2;
                                    this.d();
                                }
                            }

                            public void setScaleY(float f2) {
                                if (f2 != this.g) {
                                    this.g = f2;
                                    this.d();
                                }
                            }

                            public void setTranslateX(float f2) {
                                if (f2 != this.h) {
                                    this.h = f2;
                                    this.d();
                                }
                            }

                            public void setTranslateY(float f2) {
                                if (f2 != this.i) {
                                    this.i = f2;
                                    this.d();
                                }
                            }
                        };
                        this.b = new Path();
                        this.c = new Path();
                    }
                    {
                        b.e.a<String, Object> a2 = new b.e.a<String, Object>();
                        this.q = a2;
                        this.i = new /* invalid duplicate definition of identical inner class */;
                        this.b = new Path(g2.b);
                        this.c = new Path(g2.c);
                        this.j = g2.j;
                        this.k = g2.k;
                        this.l = g2.l;
                        this.m = g2.m;
                        this.h = g2.h;
                        this.n = g2.n;
                        this.o = g2.o;
                        String string = g2.o;
                        if (string != null) {
                            a2.put(string, this);
                        }
                        this.p = g2.p;
                    }

                    private static float a(float f2, float f3, float f4, float f5) {
                        return f2 * f5 - f3 * f4;
                    }

                    private void c(d d2, Matrix matrix, Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
                        d2.a.set(matrix);
                        d2.a.preConcat(d2.j);
                        canvas.save();
                        for (int i2 = 0; i2 < d2.b.size(); ++i2) {
                            e e2 = d2.b.get(i2);
                            if (e2 instanceof d) {
                                this.c(e2, d2.a, canvas, n2, n3, colorFilter);
                                continue;
                            }
                            if (!(e2 instanceof f)) continue;
                            this.d(d2, e2, canvas, n2, n3, colorFilter);
                        }
                        canvas.restore();
                    }

                    private void d(d d2, f f2, Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
                        float f3 = (float)n2 / this.l;
                        float f4 = (float)n3 / this.m;
                        float f5 = Math.min((float)f3, (float)f4);
                        Matrix matrix = d2.a;
                        this.d.set(matrix);
                        this.d.postScale(f3, f4);
                        float f6 = this.e(matrix);
                        if (f6 == 0.0f) {
                            return;
                        }
                        f2.d(this.b);
                        Path path = this.b;
                        this.c.reset();
                        if (f2.c()) {
                            Path path2 = this.c;
                            Path.FillType fillType = f2.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                            path2.setFillType(fillType);
                            this.c.addPath(path, this.d);
                            canvas.clipPath(this.c);
                            return;
                        }
                        c c2 = (c)f2;
                        float f7 = c2.k;
                        if (f7 != 0.0f || c2.l != 1.0f) {
                            float f8 = c2.m;
                            float f9 = (f7 + f8) % 1.0f;
                            float f10 = (f8 + c2.l) % 1.0f;
                            if (this.g == null) {
                                this.g = new PathMeasure();
                            }
                            this.g.setPath(this.b, false);
                            float f11 = this.g.getLength();
                            float f12 = f9 * f11;
                            float f13 = f10 * f11;
                            path.reset();
                            if (f12 > f13) {
                                this.g.getSegment(f12, f11, path, true);
                                this.g.getSegment(0.0f, f13, path, true);
                            } else {
                                this.g.getSegment(f12, f13, path, true);
                            }
                            path.rLineTo(0.0f, 0.0f);
                        }
                        this.c.addPath(path, this.d);
                        if (c2.h.l()) {
                            b.i.h.d.b b2 = c2.h;
                            if (this.f == null) {
                                Paint paint;
                                this.f = paint = new Paint(1);
                                paint.setStyle(Paint.Style.FILL);
                            }
                            Paint paint = this.f;
                            if (b2.h()) {
                                Shader shader = b2.f();
                                shader.setLocalMatrix(this.d);
                                paint.setShader(shader);
                                paint.setAlpha(Math.round((float)(255.0f * c2.j)));
                            } else {
                                paint.setShader(null);
                                paint.setAlpha(255);
                                paint.setColor(i.a(b2.e(), c2.j));
                            }
                            paint.setColorFilter(colorFilter);
                            Path path3 = this.c;
                            Path.FillType fillType = c2.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                            path3.setFillType(fillType);
                            canvas.drawPath(this.c, paint);
                        }
                        if (c2.f.l()) {
                            Paint.Cap cap;
                            b.i.h.d.b b3 = c2.f;
                            if (this.e == null) {
                                Paint paint;
                                this.e = paint = new Paint(1);
                                paint.setStyle(Paint.Style.STROKE);
                            }
                            Paint paint = this.e;
                            Paint.Join join = c2.o;
                            if (join != null) {
                                paint.setStrokeJoin(join);
                            }
                            if ((cap = c2.n) != null) {
                                paint.setStrokeCap(cap);
                            }
                            paint.setStrokeMiter(c2.p);
                            if (b3.h()) {
                                Shader shader = b3.f();
                                shader.setLocalMatrix(this.d);
                                paint.setShader(shader);
                                paint.setAlpha(Math.round((float)(255.0f * c2.i)));
                            } else {
                                paint.setShader(null);
                                paint.setAlpha(255);
                                paint.setColor(i.a(b3.e(), c2.i));
                            }
                            paint.setColorFilter(colorFilter);
                            paint.setStrokeWidth(f5 * f6 * c2.g);
                            canvas.drawPath(this.c, paint);
                        }
                    }

                    private float e(Matrix matrix) {
                        float[] arrf = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
                        matrix.mapVectors(arrf);
                        float f2 = (float)Math.hypot((double)arrf[0], (double)arrf[1]);
                        float f3 = (float)Math.hypot((double)arrf[2], (double)arrf[3]);
                        float f4 = g.a(arrf[0], arrf[1], arrf[2], arrf[3]);
                        float f5 = Math.max((float)f2, (float)f3);
                        float f6 = f5 FCMPL 0.0f;
                        float f7 = 0.0f;
                        if (f6 > 0) {
                            f7 = Math.abs((float)f4) / f5;
                        }
                        return f7;
                    }

                    public void b(Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
                        this.c(this.i, a, canvas, n2, n3, colorFilter);
                    }

                    public boolean f() {
                        if (this.p == null) {
                            this.p = this.i.a();
                        }
                        return this.p;
                    }

                    public boolean g(int[] arrn) {
                        return this.i.b(arrn);
                    }

                    public float getAlpha() {
                        return (float)this.getRootAlpha() / 255.0f;
                    }

                    public int getRootAlpha() {
                        return this.n;
                    }

                    public void setAlpha(float f2) {
                        this.setRootAlpha((int)(f2 * 255.0f));
                    }

                    public void setRootAlpha(int n2) {
                        this.n = n2;
                    }
                };
            }
            {
                if (h2 != null) {
                    this.a = h2.a;
                    Object object = new /* invalid duplicate definition of identical inner class */;
                    this.b = object;
                    if (h2.b.f != null) {
                        object.f = new Paint(h2.b.f);
                    }
                    if (h2.b.e != null) {
                        this.b.e = new Paint(h2.b.e);
                    }
                    this.c = h2.c;
                    this.d = h2.d;
                    this.e = h2.e;
                }
            }

            public boolean a(int n2, int n3) {
                return n2 == this.f.getWidth() && n3 == this.f.getHeight();
            }

            public boolean b() {
                return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
            }

            public void c(int n2, int n3) {
                if (this.f == null || !this.a(n2, n3)) {
                    this.f = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                    this.k = true;
                }
            }

            public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
                Paint paint = this.e(colorFilter);
                canvas.drawBitmap(this.f, null, rect, paint);
            }

            public Paint e(ColorFilter colorFilter) {
                if (!this.f() && colorFilter == null) {
                    return null;
                }
                if (this.l == null) {
                    Paint paint;
                    this.l = paint = new Paint();
                    paint.setFilterBitmap(true);
                }
                this.l.setAlpha(this.b.getRootAlpha());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }

            public boolean f() {
                return this.b.getRootAlpha() < 255;
            }

            public boolean g() {
                return this.b.f();
            }

            public int getChangingConfigurations() {
                return this.a;
            }

            public boolean h(int[] arrn) {
                boolean bl = this.b.g(arrn);
                this.k = bl | this.k;
                return bl;
            }

            public void i() {
                this.g = this.c;
                this.h = this.d;
                this.i = this.b.getRootAlpha();
                this.j = this.e;
                this.k = false;
            }

            public void j(int n2, int n3) {
                this.f.eraseColor(0);
                Canvas canvas = new Canvas(this.f);
                this.b.b(canvas, n2, n3, null);
            }

            public Drawable newDrawable() {
                return new i(this);
            }

            public Drawable newDrawable(Resources resources) {
                return new i(this);
            }
        };
    }

    i(h h2) {
        this.h = h2;
        this.i = this.j(this.i, h2.c, h2.d);
    }

    static int a(int n2, float f2) {
        int n3 = Color.alpha((int)n2);
        return n2 & 16777215 | (int)(f2 * (float)n3) << 24;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static i b(Resources resources, int n2, Resources.Theme theme) {
        int n3;
        if (Build.VERSION.SDK_INT >= 24) {
            i i2 = new i();
            i2.f = b.i.h.d.f.b(resources, n2, theme);
            i2.m = new Drawable.ConstantState(i2.f.getConstantState()){
                private final Drawable.ConstantState a;
                {
                    this.a = constantState;
                }

                public boolean canApplyTheme() {
                    return this.a.canApplyTheme();
                }

                public int getChangingConfigurations() {
                    return this.a.getChangingConfigurations();
                }

                public Drawable newDrawable() {
                    i i2 = new i();
                    i2.f = (VectorDrawable)this.a.newDrawable();
                    return i2;
                }

                public Drawable newDrawable(Resources resources) {
                    i i2 = new i();
                    i2.f = (VectorDrawable)this.a.newDrawable(resources);
                    return i2;
                }

                public Drawable newDrawable(Resources resources, Resources.Theme theme) {
                    i i2 = new i();
                    i2.f = (VectorDrawable)this.a.newDrawable(resources, theme);
                    return i2;
                }
            };
            return i2;
        }
        XmlResourceParser xmlResourceParser = resources.getXml(n2);
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
        while ((n3 = xmlResourceParser.next()) != 2 && n3 != 1) {
        }
        if (n3 != 2) throw new XmlPullParserException("No start tag found");
        try {
            return i.c(resources, (XmlPullParser)xmlResourceParser, attributeSet, theme);
        }
        catch (IOException iOException) {
            Log.e((String)"VectorDrawableCompat", (String)"parser error", (Throwable)iOException);
            return null;
        }
        catch (XmlPullParserException xmlPullParserException) {
            Log.e((String)"VectorDrawableCompat", (String)"parser error", (Throwable)xmlPullParserException);
        }
        return null;
    }

    public static i c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i i2 = new i();
        i2.inflate(resources, xmlPullParser, attributeSet, theme);
        return i2;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h h2 = this.h;
        g g2 = h2.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push((Object)g2.i);
        int n2 = xmlPullParser.getEventType();
        int n3 = 1 + xmlPullParser.getDepth();
        boolean bl = true;
        while (n2 != 1 && (xmlPullParser.getDepth() >= n3 || n2 != 3)) {
            if (n2 == 2) {
                String string = xmlPullParser.getName();
                d d2 = arrayDeque.peek();
                if ("path".equals((Object)string)) {
                    c c2 = new c();
                    c2.g(resources, attributeSet, theme, xmlPullParser);
                    d2.b.add((Object)c2);
                    if (c2.getPathName() != null) {
                        g2.q.put(c2.getPathName(), c2);
                    }
                    h2.a |= c2.d;
                    bl = false;
                } else if ("clip-path".equals((Object)string)) {
                    b b2 = new b();
                    b2.e(resources, attributeSet, theme, xmlPullParser);
                    d2.b.add((Object)b2);
                    if (b2.getPathName() != null) {
                        g2.q.put(b2.getPathName(), b2);
                    }
                    h2.a |= b2.d;
                } else if ("group".equals((Object)string)) {
                    e e2 = new /* invalid duplicate definition of identical inner class */;
                    e2.c(resources, attributeSet, theme, xmlPullParser);
                    d2.b.add((Object)e2);
                    arrayDeque.push((Object)e2);
                    if (e2.getGroupName() != null) {
                        g2.q.put(e2.getGroupName(), e2);
                    }
                    h2.a |= e2.k;
                }
            } else if (n2 == 3 && "group".equals((Object)xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            n2 = xmlPullParser.next();
        }
        if (!bl) {
            return;
        }
        throw new XmlPullParserException("no path defined");
    }

    private boolean f() {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = false;
        if (n2 >= 17) {
            boolean bl2 = this.isAutoMirrored();
            bl = false;
            if (bl2) {
                int n3 = androidx.core.graphics.drawable.a.f((Drawable)this);
                bl = false;
                if (n3 == 1) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    private static PorterDuff.Mode g(int n2, PorterDuff.Mode mode) {
        if (n2 != 3) {
            if (n2 != 5) {
                if (n2 != 9) {
                    switch (n2) {
                        default: {
                            return mode;
                        }
                        case 16: {
                            return PorterDuff.Mode.ADD;
                        }
                        case 15: {
                            return PorterDuff.Mode.SCREEN;
                        }
                        case 14: 
                    }
                    return PorterDuff.Mode.MULTIPLY;
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        float f2;
        h h2 = this.h;
        g g2 = h2.b;
        h2.d = i.g(b.i.h.d.g.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = b.i.h.d.g.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateList != null) {
            h2.c = colorStateList;
        }
        h2.e = b.i.h.d.g.e(typedArray, xmlPullParser, "autoMirrored", 5, h2.e);
        g2.l = b.i.h.d.g.j(typedArray, xmlPullParser, "viewportWidth", 7, g2.l);
        g2.m = f2 = b.i.h.d.g.j(typedArray, xmlPullParser, "viewportHeight", 8, g2.m);
        if (!(g2.l <= 0.0f)) {
            if (!(f2 <= 0.0f)) {
                float f3;
                g2.j = typedArray.getDimension(3, g2.j);
                g2.k = f3 = typedArray.getDimension(2, g2.k);
                if (!(g2.j <= 0.0f)) {
                    if (!(f3 <= 0.0f)) {
                        g2.setAlpha(b.i.h.d.g.j(typedArray, xmlPullParser, "alpha", 4, g2.getAlpha()));
                        String string = typedArray.getString(0);
                        if (string != null) {
                            g2.o = string;
                            g2.q.put(string, g2);
                        }
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(typedArray.getPositionDescription());
                    stringBuilder.append("<vector> tag requires height > 0");
                    throw new XmlPullParserException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(typedArray.getPositionDescription());
            stringBuilder.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(typedArray.getPositionDescription());
        stringBuilder.append("<vector> tag requires viewportWidth > 0");
        throw new XmlPullParserException(stringBuilder.toString());
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b((Drawable)drawable);
        }
        return false;
    }

    Object d(String string) {
        return this.h.b.q.get(string);
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.copyBounds(this.p);
        if (this.p.width() > 0) {
            if (this.p.height() <= 0) {
                return;
            }
            ColorFilter colorFilter = this.j;
            if (colorFilter == null) {
                colorFilter = this.i;
            }
            canvas.getMatrix(this.o);
            this.o.getValues(this.n);
            float f2 = Math.abs((float)this.n[0]);
            float f3 = Math.abs((float)this.n[4]);
            float f4 = Math.abs((float)this.n[1]);
            float f5 = Math.abs((float)this.n[3]);
            if (f4 != 0.0f || f5 != 0.0f) {
                f2 = 1.0f;
                f3 = 1.0f;
            }
            int n2 = (int)(f2 * (float)this.p.width());
            int n3 = (int)(f3 * (float)this.p.height());
            int n4 = Math.min((int)2048, (int)n2);
            int n5 = Math.min((int)2048, (int)n3);
            if (n4 > 0) {
                if (n5 <= 0) {
                    return;
                }
                int n6 = canvas.save();
                Rect rect = this.p;
                canvas.translate((float)rect.left, (float)rect.top);
                if (this.f()) {
                    canvas.translate((float)this.p.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.p.offsetTo(0, 0);
                this.h.c(n4, n5);
                if (!this.l) {
                    this.h.j(n4, n5);
                } else if (!this.h.b()) {
                    this.h.j(n4, n5);
                    this.h.i();
                }
                this.h.d(canvas, colorFilter, this.p);
                canvas.restoreToCount(n6);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d((Drawable)drawable);
        }
        return this.h.b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return Drawable.super.getChangingConfigurations() | this.h.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e((Drawable)drawable);
        }
        return this.j;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f != null && Build.VERSION.SDK_INT >= 24) {
            return new /* invalid duplicate definition of identical inner class */;
        }
        this.h.a = this.getChangingConfigurations();
        return this.h;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int)this.h.b.k;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int)this.h.b.j;
    }

    public int getOpacity() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    void h(boolean bl) {
        this.l = bl;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
            return;
        }
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g((Drawable)drawable, (Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme);
            return;
        }
        h h2 = this.h;
        h2.b = new /* invalid duplicate definition of identical inner class */;
        TypedArray typedArray = b.i.h.d.g.s(resources, theme, attributeSet, b.x.a.a.a.a);
        this.i(typedArray, xmlPullParser, theme);
        typedArray.recycle();
        h2.a = this.getChangingConfigurations();
        h2.k = true;
        this.e(resources, xmlPullParser, attributeSet, theme);
        this.i = this.j(this.i, h2.c, h2.d);
    }

    public void invalidateSelf() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.invalidateSelf();
            return;
        }
        Drawable.super.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h((Drawable)drawable);
        }
        return this.h.e;
    }

    public boolean isStateful() {
        h h2;
        ColorStateList colorStateList;
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return Drawable.super.isStateful() || (h2 = this.h) != null && (h2.g() || (colorStateList = this.h.c) != null && colorStateList.isStateful());
        {
        }
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
        }
        return null;
    }

    public Drawable mutate() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.k && Drawable.super.mutate() == this) {
            this.h = new /* invalid duplicate definition of identical inner class */;
            this.k = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] arrn) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setState(arrn);
        }
        h h2 = this.h;
        ColorStateList colorStateList = h2.c;
        boolean bl = false;
        if (colorStateList != null) {
            PorterDuff.Mode mode = h2.d;
            bl = false;
            if (mode != null) {
                this.i = this.j(this.i, colorStateList, mode);
                this.invalidateSelf();
                bl = true;
            }
        }
        if (h2.g() && h2.h(arrn)) {
            this.invalidateSelf();
            return true;
        }
        return bl;
    }

    public void scheduleSelf(Runnable runnable, long l2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, l2);
            return;
        }
        Drawable.super.scheduleSelf(runnable, l2);
    }

    public void setAlpha(int n2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setAlpha(n2);
            return;
        }
        if (this.h.b.getRootAlpha() != n2) {
            this.h.b.setRootAlpha(n2);
            this.invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean bl) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j((Drawable)drawable, (boolean)bl);
            return;
        }
        this.h.e = bl;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.j = colorFilter;
        this.invalidateSelf();
    }

    public void setTint(int n2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n((Drawable)drawable, (int)n2);
            return;
        }
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o((Drawable)drawable, (ColorStateList)colorStateList);
            return;
        }
        h h2 = this.h;
        if (h2.c != colorStateList) {
            h2.c = colorStateList;
            this.i = this.j(this.i, colorStateList, h2.d);
            this.invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p((Drawable)drawable, (PorterDuff.Mode)mode);
            return;
        }
        h h2 = this.h;
        if (h2.d != mode) {
            h2.d = mode;
            this.i = this.j(this.i, h2.c, mode);
            this.invalidateSelf();
        }
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setVisible(bl, bl2);
        }
        return Drawable.super.setVisible(bl, bl2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
            return;
        }
        Drawable.super.unscheduleSelf(runnable);
    }

    private static class b
    extends f {
        b() {
        }

        b(b b2) {
            super(b2);
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string;
            String string2 = typedArray.getString(0);
            if (string2 != null) {
                this.b = string2;
            }
            if ((string = typedArray.getString(1)) != null) {
                this.a = b.i.i.c.d(string);
            }
            this.c = b.i.h.d.g.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (!b.i.h.d.g.r(xmlPullParser, "pathData")) {
                return;
            }
            TypedArray typedArray = b.i.h.d.g.s(resources, theme, attributeSet, b.x.a.a.a.d);
            this.f(typedArray, xmlPullParser);
            typedArray.recycle();
        }
    }

    private static class c
    extends f {
        private int[] e;
        b.i.h.d.b f;
        float g = 0.0f;
        b.i.h.d.b h;
        float i = 1.0f;
        float j = 1.0f;
        float k = 0.0f;
        float l = 1.0f;
        float m = 0.0f;
        Paint.Cap n = Paint.Cap.BUTT;
        Paint.Join o = Paint.Join.MITER;
        float p = 4.0f;

        c() {
        }

        c(c c2) {
            super(c2);
            this.e = c2.e;
            this.f = c2.f;
            this.g = c2.g;
            this.i = c2.i;
            this.h = c2.h;
            this.c = c2.c;
            this.j = c2.j;
            this.k = c2.k;
            this.l = c2.l;
            this.m = c2.m;
            this.n = c2.n;
            this.o = c2.o;
            this.p = c2.p;
        }

        private Paint.Cap e(int n2, Paint.Cap cap) {
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        return cap;
                    }
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join f(int n2, Paint.Join join) {
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        return join;
                    }
                    return Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            String string;
            this.e = null;
            if (!b.i.h.d.g.r(xmlPullParser, "pathData")) {
                return;
            }
            String string2 = typedArray.getString(0);
            if (string2 != null) {
                this.b = string2;
            }
            if ((string = typedArray.getString(2)) != null) {
                this.a = b.i.i.c.d(string);
            }
            this.h = b.i.h.d.g.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
            this.j = b.i.h.d.g.j(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
            this.n = this.e(b.i.h.d.g.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
            this.o = this.f(b.i.h.d.g.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
            this.p = b.i.h.d.g.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
            this.f = b.i.h.d.g.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
            this.i = b.i.h.d.g.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.i);
            this.g = b.i.h.d.g.j(typedArray, xmlPullParser, "strokeWidth", 4, this.g);
            this.l = b.i.h.d.g.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
            this.m = b.i.h.d.g.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
            this.k = b.i.h.d.g.j(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
            this.c = b.i.h.d.g.k(typedArray, xmlPullParser, "fillType", 13, this.c);
        }

        @Override
        public boolean a() {
            return this.h.i() || this.f.i();
            {
            }
        }

        @Override
        public boolean b(int[] arrn) {
            return this.h.j(arrn) | this.f.j(arrn);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArray = b.i.h.d.g.s(resources, theme, attributeSet, b.x.a.a.a.c);
            this.h(typedArray, xmlPullParser, theme);
            typedArray.recycle();
        }

        float getFillAlpha() {
            return this.j;
        }

        int getFillColor() {
            return this.h.e();
        }

        float getStrokeAlpha() {
            return this.i;
        }

        int getStrokeColor() {
            return this.f.e();
        }

        float getStrokeWidth() {
            return this.g;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.k;
        }

        void setFillAlpha(float f2) {
            this.j = f2;
        }

        void setFillColor(int n2) {
            this.h.k(n2);
        }

        void setStrokeAlpha(float f2) {
            this.i = f2;
        }

        void setStrokeColor(int n2) {
            this.f.k(n2);
        }

        void setStrokeWidth(float f2) {
            this.g = f2;
        }

        void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        void setTrimPathStart(float f2) {
            this.k = f2;
        }
    }

}

