/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.webkit.WebView
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package c.g.a.a.a.f;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import c.g.a.a.a.j.c;
import org.json.JSONObject;

public class e {
    private static e a = new e();

    private e() {
    }

    public static final e a() {
        return a;
    }

    public void b(WebView webView) {
        this.g(webView, "finishSession", new Object[0]);
    }

    public void c(WebView webView, float f2) {
        Object[] arrobject = new Object[]{Float.valueOf((float)f2)};
        this.g(webView, "setDeviceVolume", arrobject);
    }

    public void d(WebView webView, String string, String string2) {
        if (string != null && !TextUtils.isEmpty((CharSequence)string2)) {
            this.k(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace((CharSequence)"%SCRIPT_SRC%", (CharSequence)string).replace((CharSequence)"%INJECTION_ID%", (CharSequence)string2));
        }
    }

    public void e(WebView webView, String string, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.g(webView, "publishMediaEvent", new Object[]{string, jSONObject});
            return;
        }
        this.g(webView, "publishMediaEvent", string);
    }

    public void f(WebView webView, String string, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.g(webView, "startSession", new Object[]{string, jSONObject, jSONObject2, jSONObject3});
    }

    /* varargs */ void g(WebView webView, String string, Object ... arrobject) {
        if (webView != null) {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            stringBuilder.append(string);
            stringBuilder.append("(");
            this.j(stringBuilder, arrobject);
            stringBuilder.append(")}");
            this.h(webView, stringBuilder);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The WebView is null for ");
        stringBuilder.append(string);
        c.a(stringBuilder.toString());
    }

    void h(final WebView webView, StringBuilder stringBuilder) {
        final String string = stringBuilder.toString();
        Handler handler = webView.getHandler();
        if (handler != null && Looper.myLooper() != handler.getLooper()) {
            handler.post(new Runnable(){

                public void run() {
                    webView.loadUrl(string);
                }
            });
            return;
        }
        webView.loadUrl(string);
    }

    public void i(WebView webView, JSONObject jSONObject) {
        this.g(webView, "init", new Object[]{jSONObject});
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void j(StringBuilder var1_1, Object[] var2_2) {
        if (var2_2 == null) return;
        if (var2_2.length <= 0) return;
        var3_3 = var2_2.length;
        var4_4 = 0;
        do {
            block6 : {
                if (var4_4 >= var3_3) {
                    var1_1.setLength(-1 + var1_1.length());
                    return;
                }
                var5_5 = var2_2[var4_4];
                if (var5_5 != null) break block6;
                var1_1.append('\"');
                ** GOTO lbl21
            }
            if (var5_5 instanceof String) {
                var8_6 = var5_5.toString();
                if (var8_6.startsWith("{")) {
                    var1_1.append(var8_6);
                } else {
                    var1_1.append('\"');
                    var1_1.append(var8_6);
lbl21: // 2 sources:
                    var1_1.append('\"');
                }
            } else {
                var1_1.append(var5_5);
            }
            var1_1.append(",");
            ++var4_4;
        } while (true);
    }

    public boolean k(WebView webView, String string) {
        if (webView != null && !TextUtils.isEmpty((CharSequence)string)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("javascript: ");
            stringBuilder.append(string);
            webView.loadUrl(stringBuilder.toString());
            return true;
        }
        return false;
    }

    public void l(WebView webView) {
        this.g(webView, "publishImpressionEvent", new Object[0]);
    }

    public void m(WebView webView, String string) {
        this.g(webView, "setNativeViewHierarchy", string);
    }

    public void n(WebView webView, JSONObject jSONObject) {
        this.g(webView, "publishLoadedEvent", new Object[]{jSONObject});
    }

    public void o(WebView webView) {
        this.g(webView, "publishLoadedEvent", new Object[0]);
    }

    public void p(WebView webView, String string) {
        this.g(webView, "setState", string);
    }

}

