/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Environment
 *  android.preference.PreferenceManager
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.widget.Toast
 *  androidx.appcompat.app.a
 *  androidx.appcompat.app.e
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManager$k
 *  androidx.fragment.app.FragmentManager$n
 *  androidx.fragment.app.d
 *  androidx.fragment.app.s
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Stack
 */
package com.ipaulpro.afilechooser;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.d;
import androidx.fragment.app.s;
import com.ipaulpro.afilechooser.FileChooserActivity;
import com.ipaulpro.afilechooser.b;
import com.ipaulpro.afilechooser.f;
import java.io.File;
import java.util.Stack;

public class FileChooserActivity
extends e
implements FragmentManager.n,
b.a {
    public static String x = "/";
    private static final boolean y;
    private BroadcastReceiver A = new BroadcastReceiver(this){
        final /* synthetic */ FileChooserActivity a;
        {
            this.a = fileChooserActivity;
        }

        public void onReceive(Context context, Intent intent) {
            Toast.makeText((Context)context, (int)f.b, (int)1).show();
            FileChooserActivity.l0(this.a, null);
        }
    };
    private String B;
    private FragmentManager z;

    static {
        boolean bl = Build.VERSION.SDK_INT >= 11;
        y = bl;
    }

    static /* synthetic */ void l0(FileChooserActivity fileChooserActivity, File file) {
        fileChooserActivity.n0(file);
    }

    private void m0() {
        b b2 = b.A(this.B);
        this.z.n().b(16908290, (Fragment)b2).i();
    }

    private void n0(File file) {
        if (file != null) {
            Uri uri = Uri.fromFile((File)file);
            this.setResult(-1, new Intent().setData(uri));
            this.r0(file);
            this.finish();
            return;
        }
        this.setResult(0);
        this.finish();
    }

    private void o0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        this.registerReceiver(this.A, intentFilter);
    }

    private void p0(File file) {
        String string;
        this.B = string = file.getAbsolutePath();
        b b2 = b.A(string);
        this.z.n().q(16908290, (Fragment)b2).w(4097).g(this.B).i();
    }

    private File q0() {
        File file = new File(PreferenceManager.getDefaultSharedPreferences((Context)this.getApplicationContext()).getString("com.smp.FILE_PATH_CHOOSER", x));
        if (file.isDirectory() && file.canRead()) {
            return file;
        }
        return new File(x);
    }

    private void r0(File file) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences((Context)this.getApplicationContext()).edit();
        editor.putString("com.smp.FILE_PATH_CHOOSER", file.getParentFile().getAbsolutePath());
        editor.apply();
    }

    private void s0() {
        this.unregisterReceiver(this.A);
    }

    public void B() {
        int n2 = this.z.o0();
        this.B = n2 > 0 ? this.z.n0(n2 - 1).getName() : x;
        this.setTitle((CharSequence)this.B);
        if (y) {
            this.invalidateOptionsMenu();
        }
    }

    @Override
    public void b(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                this.p0(file);
                return;
            }
            this.n0(file);
            return;
        }
        Toast.makeText((Context)this, (int)f.a, (int)0).show();
    }

    protected void onCreate(Bundle bundle) {
        FragmentManager fragmentManager;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 24) {
            x = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        this.z = fragmentManager = this.R();
        fragmentManager.i((FragmentManager.n)this);
        if (bundle == null) {
            this.B = x;
            this.m0();
            Stack stack = new Stack();
            for (File file = this.q0(); file != null && !file.equals((Object)new File(x)); file = file.getParentFile()) {
                stack.push((Object)file);
            }
            while (!stack.empty()) {
                this.p0((File)stack.pop());
            }
        } else {
            this.B = bundle.getString("path");
        }
        this.setTitle((CharSequence)this.B);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (y) {
            boolean bl = this.z.o0() > 0;
            androidx.appcompat.app.a a2 = this.b0();
            a2.r(bl);
            a2.v(bl);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return Activity.super.onOptionsItemSelected(menuItem);
        }
        this.z.Y0();
        return true;
    }

    protected void onPause() {
        d.super.onPause();
        this.s0();
    }

    protected void onResume() {
        d.super.onResume();
        this.o0();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("path", this.B);
    }
}

