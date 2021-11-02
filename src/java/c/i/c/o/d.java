/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.widget.ImageView
 */
package c.i.c.o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import c.i.b.b.a;
import c.i.d.k.c;

public class d
extends c {
    private a e;

    public d(int n2) {
        super(n2);
    }

    public d(a a2) {
        super(null);
        this.e = a2;
    }

    public static void f(d d2, ImageView imageView, int n2, boolean bl, int n3) {
        if (d2 != null && imageView != null) {
            Drawable drawable = d.h(d2, imageView.getContext(), n2, bl, n3);
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                return;
            }
            if (d2.b() != null) {
                imageView.setImageBitmap(d2.b());
                imageView.setVisibility(0);
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public static Drawable h(d d2, Context context, int n2, boolean bl, int n3) {
        if (d2 == null) {
            return null;
        }
        return d2.g(context, n2, bl, n3);
    }

    /*
     * Exception decompiling
     */
    public Drawable g(Context var1, int var2, boolean var3, int var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl45.1 : ALOAD : trying to set 1 previously set to 0
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
}

