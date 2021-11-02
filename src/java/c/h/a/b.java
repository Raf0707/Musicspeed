/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.os.Environment
 *  android.os.FileObserver
 *  android.os.Handler
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ImageButton
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.core.graphics.drawable.a
 *  b.i.h.a
 *  java.io.File
 *  java.io.FileFilter
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 */
package c.h.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import c.h.a.e;
import c.h.a.f;
import c.h.a.g;
import c.h.a.h;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

abstract class b {
    private static final String a = "b";
    private final Handler b = new Handler();
    private final d c;
    private ImageButton d;
    private ImageButton e;
    private TextView f;
    private ListView g;
    private View h;
    private View i;
    private c.h.a.d j;
    private final ArrayList<File> k = new ArrayList();
    private File l;
    private FileObserver m;
    private final AdapterView.OnItemClickListener n = new AdapterView.OnItemClickListener(){

        public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
            b b2 = b.this;
            b2.i((File)b2.j.getItem(n2));
        }
    };
    private final View.OnClickListener o = new View.OnClickListener(){

        public void onClick(View view) {
            if (view.getId() == f.b) {
                b.this.j();
                return;
            }
            if (view.getId() == f.a) {
                b.this.c.b();
            }
        }
    };

    protected b(d d2) {
        this.c = d2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void h() {
        var1_1 = this.m().getTheme();
        if (var1_1 == null) ** GOTO lbl-1000
        var15_2 = var1_1.obtainStyledAttributes(new int[]{16842801});
        if (var15_2 != null) {
            var2_3 = var15_2.getColor(0, 16777215);
            var15_2.recycle();
        } else lbl-1000: // 2 sources:
        {
            var2_3 = 16777215;
        }
        if (this.d.getContext() == null) return;
        if (var2_3 != 16777215 && 0.21 * (double)Color.red((int)var2_3) + 0.71 * (double)Color.green((int)var2_3) + 0.07 * (double)Color.blue((int)var2_3) < 128.0) {
            var9_4 = this.d.getDrawable();
            var10_5 = this.d.getContext();
            var11_6 = e.d;
            androidx.core.graphics.drawable.a.n((Drawable)var9_4, (int)b.i.h.a.c((Context)var10_5, (int)var11_6));
            androidx.core.graphics.drawable.a.n((Drawable)this.e.getDrawable(), (int)b.i.h.a.c((Context)this.d.getContext(), (int)var11_6));
            var12_7 = this.h;
            var13_8 = this.d.getContext();
            var14_9 = e.a;
            var12_7.setBackgroundColor(b.i.h.a.c((Context)var13_8, (int)var14_9));
            this.i.setBackgroundColor(b.i.h.a.c((Context)this.d.getContext(), (int)var14_9));
            return;
        }
        var3_10 = this.d.getDrawable();
        var4_11 = this.d.getContext();
        var5_12 = e.c;
        androidx.core.graphics.drawable.a.n((Drawable)var3_10, (int)b.i.h.a.c((Context)var4_11, (int)var5_12));
        androidx.core.graphics.drawable.a.n((Drawable)this.e.getDrawable(), (int)b.i.h.a.c((Context)this.d.getContext(), (int)var5_12));
        var6_13 = this.h;
        var7_14 = this.d.getContext();
        var8_15 = e.b;
        var6_13.setBackgroundColor(b.i.h.a.c((Context)var7_14, (int)var8_15));
        this.i.setBackgroundColor(b.i.h.a.c((Context)this.d.getContext(), (int)var8_15));
    }

    private void i(File file) {
        if (file != null) {
            FileObserver fileObserver;
            FileObserver fileObserver2;
            if (!file.isDirectory()) {
                return;
            }
            Object[] arrobject = file.listFiles((FileFilter)new c.h.a.i.a());
            Object object = arrobject != null ? Arrays.asList((Object[])arrobject) : new ArrayList();
            this.k.clear();
            this.k.addAll((Collection)object);
            Collections.sort(this.k);
            c.h.a.d d2 = this.j;
            if (d2 != null) {
                d2.notifyDataSetChanged();
            }
            this.l = file;
            TextView textView = this.f;
            if (textView != null) {
                textView.setText((CharSequence)file.getAbsolutePath());
            }
            if ((fileObserver = this.m) != null) {
                fileObserver.stopWatching();
            }
            this.m = fileObserver2 = this.k(file.getAbsolutePath());
            fileObserver2.startWatching();
            String string = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Changed directory to ");
            stringBuilder.append(file.getAbsolutePath());
            Log.d((String)string, (String)stringBuilder.toString());
        }
    }

    private void j() {
        File file;
        File file2 = this.l;
        if (file2 != null && (file = file2.getParentFile()) != null) {
            try {
                if (b.r(Environment.getExternalStorageDirectory(), file)) {
                    this.i(file);
                    return;
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private FileObserver k(String string) {
        return new FileObserver(string, 4032){

            public void onEvent(int n2, String string) {
                String string2 = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("FileObserver received event ");
                stringBuilder.append(n2);
                Log.d((String)string2, (String)stringBuilder.toString());
                if ((n2 & 256) == 0 && (n2 & 512) == 0 && (n2 & 64) == 0 && (n2 & 128) == 0) {
                    if ((n2 & 1024) != 0 || (n2 & 2048) != 0) {
                        b.this.b.post(new Runnable(){

                            public void run() {
                                b.this.j();
                            }
                        });
                        return;
                    }
                } else {
                    b.this.b.post(new Runnable(){

                        public void run() {
                            b.this.u();
                        }
                    });
                }
            }

        };
    }

    public static boolean r(File file, File file2) throws IOException {
        File file3 = file.getCanonicalFile();
        for (File file4 = file2.getCanonicalFile(); file4 != null; file4 = file4.getParentFile()) {
            if (!file3.equals((Object)file4)) continue;
            return true;
        }
        return false;
    }

    private void u() {
        File file = this.l;
        if (file != null) {
            this.i(file);
        }
    }

    private void w(int n2) {
        Toast.makeText((Context)this.m(), (int)n2, (int)1).show();
    }

    protected boolean l(String string) {
        File file = this.l;
        if (file == null) {
            this.w(h.e);
            return false;
        }
        if (!file.canWrite()) {
            this.c.a();
            return false;
        }
        File file2 = new File(this.l, string);
        if (file2.exists()) {
            this.w(h.d);
            return false;
        }
        if (!file2.mkdir()) {
            this.w(h.b);
            return false;
        }
        this.i(new File(this.l, string));
        return true;
    }

    protected abstract Context m();

    protected abstract File n();

    protected File o() {
        return this.l;
    }

    protected int p() {
        return g.a;
    }

    protected void q(View view) {
        c.h.a.d d2;
        this.d = (ImageButton)view.findViewById(f.b);
        this.e = (ImageButton)view.findViewById(f.a);
        this.f = (TextView)view.findViewById(f.h);
        this.g = (ListView)view.findViewById(f.f);
        this.h = view.findViewById(f.d);
        this.i = view.findViewById(f.c);
        this.g.setEmptyView(view.findViewById(f.g));
        this.g.setOnItemClickListener(this.n);
        this.d.setOnClickListener(this.o);
        this.e.setOnClickListener(this.o);
        this.g.setDivider(null);
        this.h();
        this.j = d2 = new c.h.a.d(this.m(), (List<File>)this.k);
        this.g.setAdapter((ListAdapter)d2);
        this.i(this.n());
    }

    protected void s() {
        FileObserver fileObserver = this.m;
        if (fileObserver != null) {
            fileObserver.stopWatching();
        }
    }

    protected void t() {
        FileObserver fileObserver = this.m;
        if (fileObserver != null) {
            fileObserver.startWatching();
        }
    }

    protected void v(String string) {
        this.i(new File(string));
    }

    public static interface d {
        public void a();

        public void b();
    }

}

