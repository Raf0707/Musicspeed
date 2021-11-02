/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  com.afollestad.materialdialogs.internal.MDRootLayout
 *  java.lang.Deprecated
 *  java.lang.IllegalAccessError
 *  java.lang.String
 */
package c.a.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.afollestad.materialdialogs.internal.MDRootLayout;

class c
extends Dialog
implements DialogInterface.OnShowListener {
    protected MDRootLayout f;
    private DialogInterface.OnShowListener g;

    c(Context context, int n2) {
        super(context, n2);
    }

    final void b() {
        super.setOnShowListener((DialogInterface.OnShowListener)this);
    }

    final void c(View view) {
        super.setContentView(view);
    }

    public View findViewById(int n2) {
        return this.f.findViewById(n2);
    }

    public void onShow(DialogInterface dialogInterface) {
        DialogInterface.OnShowListener onShowListener = this.g;
        if (onShowListener != null) {
            onShowListener.onShow(dialogInterface);
        }
    }

    @Deprecated
    public void setContentView(int n2) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    @Deprecated
    public void setContentView(View view) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    @Deprecated
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.g = onShowListener;
    }
}

