/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 */
package c.g.a.a.a.l;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;
import c.g.a.a.a.l.a;

public class b
extends a {
    @SuppressLint(value={"SetJavaScriptEnabled"})
    public b(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        this.c(webView);
    }
}

