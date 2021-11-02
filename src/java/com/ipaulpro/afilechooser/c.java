/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.FileObserver
 *  b.o.b.a
 *  b.o.b.b
 *  java.io.File
 *  java.io.FileFilter
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.List
 */
package com.ipaulpro.afilechooser;

import android.content.Context;
import android.os.FileObserver;
import b.o.b.b;
import com.ipaulpro.afilechooser.c;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class c
extends b.o.b.a<List<File>> {
    private FileObserver p;
    private List<File> q;
    private String r;

    public c(Context context, String string) {
        super(context);
        this.r = string;
    }

    public void H(List<File> list) {
        if (this.k()) {
            this.K(list);
            return;
        }
        List<File> list2 = this.q;
        this.q = list;
        if (this.l()) {
            b.super.f(list);
        }
        if (list2 != null && list2 != list) {
            this.K(list2);
        }
    }

    public List<File> I() {
        Object[] arrobject;
        ArrayList arrayList = new ArrayList();
        File file = new File(this.r);
        Object[] arrobject2 = file.listFiles(com.ipaulpro.afilechooser.g.a.c);
        int n2 = 0;
        if (arrobject2 != null) {
            Arrays.sort((Object[])arrobject2, com.ipaulpro.afilechooser.g.a.a);
            int n3 = arrobject2.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                arrayList.add(arrobject2[i2]);
            }
        }
        if ((arrobject = file.listFiles(com.ipaulpro.afilechooser.g.a.b)) != null) {
            Arrays.sort((Object[])arrobject, com.ipaulpro.afilechooser.g.a.a);
            int n4 = arrobject.length;
            while (n2 < n4) {
                arrayList.add(arrobject[n2]);
                ++n2;
            }
        }
        return arrayList;
    }

    public void J(List<File> list) {
        super.F(list);
        this.K(list);
    }

    protected void K(List<File> list) {
        FileObserver fileObserver = this.p;
        if (fileObserver != null) {
            fileObserver.stopWatching();
            this.p = null;
        }
    }

    protected void q() {
        this.s();
        List<File> list = this.q;
        if (list != null) {
            this.K(list);
            this.q = null;
        }
    }

    protected void r() {
        List<File> list = this.q;
        if (list != null) {
            this.H(list);
        }
        if (this.p == null) {
            this.p = new FileObserver(this, this.r, 4034){
                final /* synthetic */ c a;
                {
                    this.a = c2;
                    super(string, n2);
                }

                public void onEvent(int n2, String string) {
                    this.a.o();
                }
            };
        }
        this.p.startWatching();
        if (this.y() || this.q == null) {
            this.h();
        }
    }

    protected void s() {
        this.b();
    }
}

