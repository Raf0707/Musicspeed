/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.Message
 *  android.view.ContextThemeWrapper
 *  android.view.View
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebView$HitTestResult
 *  d.a.a.g.a
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 */
package d.a.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Message;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import d.a.a.f;
import d.a.a.g.l;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;
import java.io.InputStream;
import java.util.List;

public class b {
    public static final Notice a = new Notice("LicensesDialog", "http://psdev.de/LicensesDialog", "Copyright 2013-2016 Philip Schiffer", (l)new d.a.a.g.a());
    private final Context b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final int g;
    private DialogInterface.OnDismissListener h;

    private b(Context context, String string2, String string3, String string4, int n2, int n3) {
        this.b = context;
        this.c = string3;
        this.d = string2;
        this.e = string4;
        this.f = n2;
        this.g = n3;
    }

    private static WebView g(final Context context) {
        WebView webView = new WebView(context);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.setWebChromeClient(new WebChromeClient(){

            public boolean onCreateWindow(WebView webView, boolean bl, boolean bl2, Message message) {
                String string2 = webView.getHitTestResult().getExtra();
                if (string2 != null) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
                    context.startActivity(intent);
                }
                return false;
            }
        });
        return webView;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String h(Context context, Notices notices, boolean bl, boolean bl2, String string2) {
        if (!bl2) return d.a.a.c.e(context).h(bl).g(notices).i(string2).d();
        try {
            notices.m().add((Object)a);
            return d.a.a.c.e(context).h(bl).g(notices).i(string2).d();
        }
        catch (Exception exception) {
            throw new IllegalStateException((Throwable)exception);
        }
    }

    private static Notices i(Context context, int n2) {
        try {
            Resources resources = context.getResources();
            if ("raw".equals((Object)resources.getResourceTypeName(n2))) {
                return d.a.a.d.a(resources.openRawResource(n2));
            }
            throw new IllegalStateException("not a raw resource");
        }
        catch (Exception exception) {
            throw new IllegalStateException((Throwable)exception);
        }
    }

    public Dialog f() {
        WebView webView = b.g(this.b);
        webView.loadDataWithBaseURL(null, this.d, "text/html", "utf-8", null);
        AlertDialog.Builder builder = this.f != 0 ? new AlertDialog.Builder((Context)new ContextThemeWrapper(this.b, this.f)) : new AlertDialog.Builder(this.b);
        builder.setTitle((CharSequence)this.c).setView((View)webView).setPositiveButton((CharSequence)this.e, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener(){

            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.h != null) {
                    b.this.h.onDismiss(dialogInterface);
                }
            }
        });
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener(){

            public void onShow(DialogInterface dialogInterface) {
                int n2;
                View view;
                if (b.this.g != 0 && (view = alertDialog.findViewById(n2 = b.this.b.getResources().getIdentifier("titleDivider", "id", "android"))) != null) {
                    view.setBackgroundColor(b.this.g);
                }
            }
        });
        return alertDialog;
    }

    public Dialog j() {
        Dialog dialog = this.f();
        dialog.show();
        return dialog;
    }

    public static final class e {
        private final Context a;
        private String b;
        private String c;
        private Integer d;
        private Notices e;
        private String f;
        private String g;
        private boolean h;
        private boolean i;
        private int j;
        private int k;

        public e(Context context) {
            this.a = context;
            this.b = context.getString(f.c);
            this.c = context.getString(f.a);
            this.g = context.getString(f.b);
            this.h = false;
            this.i = false;
            this.j = 0;
            this.k = 0;
        }

        /*
         * Enabled aggressive block sorting
         */
        public b a() {
            String string2;
            Notices notices = this.e;
            if (notices != null) {
                string2 = b.h(this.a, notices, this.h, this.i, this.g);
            } else {
                Integer n2 = this.d;
                if (n2 != null) {
                    Context context = this.a;
                    string2 = b.h(context, b.i(context, n2), this.h, this.i, this.g);
                } else {
                    string2 = this.f;
                    if (string2 == null) {
                        throw new IllegalStateException("Notices have to be provided, see setNotices");
                    }
                }
            }
            String string3 = string2;
            return new b(this.a, string3, this.b, this.c, this.j, this.k);
        }

        public e b(boolean bl) {
            this.i = bl;
            return this;
        }

        public e c(int n2) {
            this.d = n2;
            this.e = null;
            return this;
        }
    }

}

