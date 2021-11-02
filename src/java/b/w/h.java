/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.graphics.PointF
 *  android.util.Property
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
package b.w;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class h<T>
extends Property<T, Float> {
    private final Property<T, PointF> a;
    private final PathMeasure b;
    private final float c;
    private final float[] d = new float[2];
    private final PointF e = new PointF();
    private float f;

    h(Property<T, PointF> property, Path path) {
        PathMeasure pathMeasure;
        super(Float.class, property.getName());
        this.a = property;
        this.b = pathMeasure = new PathMeasure(path, false);
        this.c = pathMeasure.getLength();
    }

    public Float a(T t2) {
        return Float.valueOf((float)this.f);
    }

    public void b(T t2, Float f2) {
        this.f = f2.floatValue();
        this.b.getPosTan(this.c * f2.floatValue(), this.d, null);
        PointF pointF = this.e;
        float[] arrf = this.d;
        pointF.x = arrf[0];
        pointF.y = arrf[1];
        this.a.set(t2, (Object)pointF);
    }
}

