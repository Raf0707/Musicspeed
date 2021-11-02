/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.os.AsyncTask
 *  b.i.p.d
 *  c.a.b.b
 *  c.a.b.f
 *  c.a.b.f$d
 *  c.a.b.f$m
 *  java.io.File
 *  java.io.FileFilter
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.LinkedList
 *  java.util.List
 */
package com.smp.musicspeed.folders;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import b.i.p.d;
import c.a.b.b;
import c.a.b.f;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.folders.n;
import com.smp.musicspeed.folders.o;
import com.smp.musicspeed.folders.p;
import com.smp.musicspeed.folders.r;
import com.smp.musicspeed.folders.x;
import com.smp.musicspeed.k0.m0.f;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class w
extends r<a, Void, d<List<MediaTrack>, List<File>>> {
    private Context e;
    private x f;

    public w(Context context, x x2) {
        super(context, 500);
        this.e = context.getApplicationContext();
        this.f = x2;
    }

    private void h(Collection<File> collection, File file, FileFilter fileFilter) {
        File[] arrfile = file.listFiles(fileFilter);
        if (arrfile != null) {
            for (File file2 : arrfile) {
                if (file2.isDirectory() && !this.isCancelled()) {
                    this.h(collection, file2, fileFilter);
                    continue;
                }
                collection.add((Object)file2);
            }
        }
    }

    private /* synthetic */ void i(DialogInterface dialogInterface) {
        this.cancel(false);
    }

    private /* synthetic */ void k(DialogInterface dialogInterface) {
        this.cancel(false);
    }

    private /* synthetic */ void m(c.a.b.f f3, b b2) {
        this.cancel(false);
    }

    private List<File> o(Collection<File> collection, FileFilter fileFilter) {
        LinkedList linkedList = new LinkedList();
        for (File file : collection) {
            if (file.isDirectory() && !this.isCancelled()) {
                this.h((Collection<File>)linkedList, file, fileFilter);
                continue;
            }
            if (fileFilter != null && !fileFilter.accept(file)) continue;
            linkedList.add((Object)file);
        }
        return linkedList;
    }

    @Override
    protected Dialog a(Context context) {
        return new f.d(context).l(2131820783).i(true, 0).j(true).b((DialogInterface.OnCancelListener)new p(this)).d((DialogInterface.OnDismissListener)new o(this)).f(17039360).h((f.m)new n(this)).k();
    }

    protected /* varargs */ d<List<MediaTrack>, List<File>> g(a ... arra) {
        a a2;
        List<File> list;
        block4 : {
            a2 = arra[0];
            list = this.o((Collection<File>)a2.c, a2.b);
            if (!this.isCancelled()) break block4;
            return null;
        }
        try {
            Collections.sort(list, a2.a);
            ArrayList arrayList = new ArrayList(f.B(this.e, list).values());
            while (arrayList.remove(null)) {
            }
            d d2 = new d((Object)arrayList, list);
            return d2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.cancel(false);
            return null;
        }
    }

    public /* synthetic */ void j(DialogInterface dialogInterface) {
        this.i(dialogInterface);
    }

    public /* synthetic */ void l(DialogInterface dialogInterface) {
        this.k(dialogInterface);
    }

    public /* synthetic */ void n(c.a.b.f f3, b b2) {
        this.m(f3, b2);
    }

    protected void onCancelled() {
        AsyncTask.super.onCancelled();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected void p(d<List<MediaTrack>, List<File>> d2) {
        super.onPostExecute(d2);
        if (this.isCancelled()) {
            return;
        }
        this.f.a((List<MediaTrack>)((List)d2.a), (List<File>)((List)d2.b));
    }

}

