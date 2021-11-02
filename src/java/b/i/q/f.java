/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActionBar
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.KeyEvent
 *  android.view.KeyEvent$Callback
 *  android.view.KeyEvent$DispatcherState
 *  android.view.View
 *  android.view.Window
 *  android.view.Window$Callback
 *  b.i.q.w
 *  java.lang.Object
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 */
package b.i.q;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import b.i.q.w;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class f {
    private static boolean a;
    private static Method b;
    private static boolean c;
    private static Field d;

    /*
     * Exception decompiling
     */
    private static boolean a(ActionBar var0, KeyEvent var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl36.1 : ICONST_0 : trying to set 0 previously set to 1
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

    private static boolean b(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && f.a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View view = window.getDecorView();
        if (w.i((View)view, (KeyEvent)keyEvent)) {
            return true;
        }
        KeyEvent.DispatcherState dispatcherState = view != null ? view.getKeyDispatcherState() : null;
        return keyEvent.dispatch((KeyEvent.Callback)activity, dispatcherState, (Object)activity);
    }

    private static boolean c(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener = f.f(dialog);
        if (onKeyListener != null && onKeyListener.onKey((DialogInterface)dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View view = window.getDecorView();
        if (w.i((View)view, (KeyEvent)keyEvent)) {
            return true;
        }
        KeyEvent.DispatcherState dispatcherState = view != null ? view.getKeyDispatcherState() : null;
        return keyEvent.dispatch((KeyEvent.Callback)dialog, dispatcherState, (Object)dialog);
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        return w.j((View)view, (KeyEvent)keyEvent);
    }

    public static boolean e(a a2, View view, Window.Callback callback, KeyEvent keyEvent) {
        boolean bl;
        block8 : {
            block7 : {
                if (a2 == null) {
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    return a2.y(keyEvent);
                }
                if (callback instanceof Activity) {
                    return f.b((Activity)callback, keyEvent);
                }
                if (callback instanceof Dialog) {
                    return f.c((Dialog)callback, keyEvent);
                }
                if (view != null && w.i((View)view, (KeyEvent)keyEvent)) break block7;
                boolean bl2 = a2.y(keyEvent);
                bl = false;
                if (!bl2) break block8;
            }
            bl = true;
        }
        return bl;
    }

    /*
     * Exception decompiling
     */
    private static DialogInterface.OnKeyListener f(Dialog var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl27.1 : ACONST_NULL : trying to set 0 previously set to 1
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

    public static interface a {
        public boolean y(KeyEvent var1);
    }

}

