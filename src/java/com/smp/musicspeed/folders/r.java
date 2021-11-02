/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.os.Handler
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.ref.WeakReference
 */
package com.smp.musicspeed.folders;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import com.smp.musicspeed.folders.a;
import java.lang.ref.WeakReference;

public abstract class r<Params, Progress, Result>
extends AsyncTask<Params, Progress, Result> {
    private final int a;
    private WeakReference<Dialog> b;
    private Context c;
    private boolean d;

    public r(Context context, int n2) {
        this.c = context;
        this.a = n2;
        this.b = new WeakReference(null);
    }

    private void c() {
        Context context;
        if (!this.d && (context = this.c) != null) {
            Dialog dialog = this.a(context);
            this.b = new WeakReference((Object)dialog);
            dialog.show();
        }
    }

    public static /* synthetic */ void d(r r2) {
        r2.c();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void f() {
        this.d = true;
        Dialog dialog = this.b();
        if (dialog == null) return;
        try {
            dialog.dismiss();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected abstract Dialog a(Context var1);

    protected Dialog b() {
        return (Dialog)this.b.get();
    }

    protected /* varargs */ void e(Dialog dialog, Progress ... arrProgress) {
    }

    protected void onCancelled(Result Result) {
        super.onCancelled(Result);
        this.f();
    }

    protected void onPostExecute(Result Result) {
        super.onPostExecute(Result);
        this.f();
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (this.a > 0) {
            new Handler().postDelayed((Runnable)new a(this), (long)this.a);
            return;
        }
        this.c();
    }

    protected /* varargs */ void onProgressUpdate(Progress ... arrProgress) {
        super.onProgressUpdate((Object[])arrProgress);
        Dialog dialog = this.b();
        if (dialog != null) {
            this.e(dialog, arrProgress);
        }
    }
}

