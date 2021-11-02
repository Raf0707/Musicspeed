/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.Matrix
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 */
package b.w;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import b.w.j;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class i0 {
    private static Method a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    i0() {
    }

    @SuppressLint(value={"PrivateApi"})
    private void b() {
        if (!b) {
            try {
                Method method;
                Class class_ = Integer.TYPE;
                Class[] arrclass = new Class[]{class_, class_, class_, class_};
                a = method = View.class.getDeclaredMethod("setFrame", arrclass);
                method.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)"ViewUtilsBase", (String)"Failed to retrieve setFrame method", (Throwable)noSuchMethodException);
            }
            b = true;
        }
    }

    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(j.a, null);
        }
    }

    public float c(View view) {
        Float f2 = (Float)view.getTag(j.a);
        if (f2 != null) {
            return view.getAlpha() / f2.floatValue();
        }
        return view.getAlpha();
    }

    public void d(View view) {
        int n2 = j.a;
        if (view.getTag(n2) == null) {
            view.setTag(n2, (Object)Float.valueOf((float)view.getAlpha()));
        }
    }

    /*
     * Exception decompiling
     */
    public void e(View var1, int var2, int var3, int var4, int var5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl43.1 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public void f(View view, float f2) {
        Float f3 = (Float)view.getTag(j.a);
        if (f3 != null) {
            view.setAlpha(f2 * f3.floatValue());
            return;
        }
        view.setAlpha(f2);
    }

    /*
     * Exception decompiling
     */
    public void g(View var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public void h(View view, Matrix matrix) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            View view2 = (View)viewParent;
            this.h(view2, matrix);
            matrix.preTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void i(View view, Matrix matrix) {
        Matrix matrix2;
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            View view2 = (View)viewParent;
            this.i(view2, matrix);
            matrix.postTranslate((float)view2.getScrollX(), (float)view2.getScrollY());
        }
        matrix.postTranslate((float)(-view.getLeft()), (float)(-view.getTop()));
        Matrix matrix3 = view.getMatrix();
        if (!matrix3.isIdentity() && matrix3.invert(matrix2 = new Matrix())) {
            matrix.postConcat(matrix2);
        }
    }
}

