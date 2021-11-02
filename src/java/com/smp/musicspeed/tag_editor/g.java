/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.e0
 *  androidx.lifecycle.w
 *  com.smp.musicspeed.tag_editor.g$a
 *  f.u.g0
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileDescriptor
 *  java.io.FileOutputStream
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  kotlinx.coroutines.a1
 *  kotlinx.coroutines.b3.e
 *  kotlinx.coroutines.b3.j
 *  kotlinx.coroutines.b3.m
 *  kotlinx.coroutines.b3.u
 *  kotlinx.coroutines.b3.y
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 *  kotlinx.coroutines.q2
 *  kotlinx.coroutines.w
 */
package com.smp.musicspeed.tag_editor;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import com.smp.musicspeed.tag_editor.g;
import com.smp.musicspeed.tag_editor.i;
import com.smp.musicspeed.tag_editor.j;
import com.smp.musicspeed.tag_editor.n;
import f.t;
import f.u.g0;
import f.w.d;
import f.y.b;
import f.z.c.p;
import f.z.d.k;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.b3.e;
import kotlinx.coroutines.b3.m;
import kotlinx.coroutines.b3.u;
import kotlinx.coroutines.b3.y;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.w;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public abstract class g
extends e0 {
    private final Context c;
    private final w d;
    private final k0 e;
    private volatile Uri f;
    private volatile boolean g;
    private final kotlinx.coroutines.b3.j<Integer> h;
    private final androidx.lifecycle.w<Boolean> i;
    private final y<j> j;

    public g(Context context) {
        k0 k02;
        w w2;
        k.g((Object)context, "context");
        this.c = context;
        this.d = w2 = q2.b(null, (int)1, null);
        this.e = k02 = l0.a((f.w.g)a1.b().plus((f.w.g)w2));
        this.h = m.b((int)0, null, null, (int)6, null);
        this.i = new androidx.lifecycle.w((Object)Boolean.FALSE);
        this.j = e.b((k0)k02, null, (int)0, null, null, (p)new a(this, null), (int)15, null);
    }

    public static final /* synthetic */ void f(g g2, Uri uri) {
        g2.h(uri);
    }

    private final void h(Uri uri) {
        this.g = true;
        this.f = uri;
    }

    public final void A() {
        this.j.offer((Object)new n());
    }

    protected void d() {
        super.d();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected final void g(File var1_1, InputStream var2_2) {
        k.g((Object)var1_1, "<this>");
        var3_3 = new FileOutputStream(var1_1);
        if (var2_2 == null) ** GOTO lbl6
        try {
            f.y.a.b(var2_2, (OutputStream)var3_3, 0, 2, null);
lbl6: // 2 sources:
            var3_3.getFD().sync();
        }
        catch (Throwable var4_4) {
            try {
                throw var4_4;
            }
            catch (Throwable var5_5) {
                b.a((Closeable)var3_3, var4_4);
                throw var5_5;
            }
        }
        b.a((Closeable)var3_3, null);
    }

    protected abstract Uri i();

    public abstract List<Uri> j();

    protected final y<j> k() {
        return this.j;
    }

    public final Context l() {
        return this.c;
    }

    public final u<Integer> m() {
        return this.h;
    }

    public final Uri n() {
        return this.f;
    }

    public final boolean o() {
        return this.g;
    }

    public abstract Map<FieldKey, String> p();

    public final LiveData<Boolean> q() {
        return this.i;
    }

    public final Map<FieldKey, String> r() {
        g g2 = this;
        synchronized (g2) {
            Map map = g0.p(this.u());
            return map;
        }
    }

    protected final kotlinx.coroutines.b3.j<Integer> s() {
        return this.h;
    }

    protected final androidx.lifecycle.w<Boolean> t() {
        return this.i;
    }

    protected abstract Map<FieldKey, String> u();

    protected final void v(Tag tag) {
        g g2 = this;
        synchronized (g2) {
            k.g(tag, "tag");
            for (Map.Entry entry : this.u().entrySet()) {
                FieldKey fieldKey = (FieldKey)((Object)entry.getKey());
                String string = (String)entry.getValue();
                if (string == null) continue;
                tag.setField(fieldKey, string);
            }
            return;
        }
    }

    public final void w(Uri uri) {
        this.f = uri;
    }

    public final void x(Uri uri) {
        this.j.offer((Object)new i(uri));
    }

    public final void y(FieldKey fieldKey, String string) {
        g g2 = this;
        synchronized (g2) {
            k.g((Object)((Object)fieldKey), "key");
            k.g(string, "value");
            this.u().put((Object)((Object)fieldKey), (Object)string);
            return;
        }
    }

    protected abstract Object z(d<? super t> var1);
}

