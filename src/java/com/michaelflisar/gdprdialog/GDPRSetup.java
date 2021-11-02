/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 */
package com.michaelflisar.gdprdialog;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.michaelflisar.gdprdialog.GDPRCustomTexts;
import com.michaelflisar.gdprdialog.GDPRNetwork;
import com.michaelflisar.gdprdialog.m.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GDPRSetup
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        public GDPRSetup a(Parcel parcel) {
            return new GDPRSetup(parcel);
        }

        public GDPRSetup[] b(int n2) {
            return new GDPRSetup[n2];
        }
    };
    private String f = null;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private GDPRNetwork[] j;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private com.michaelflisar.gdprdialog.i[] n;
    private boolean o = false;
    private boolean p = false;
    private int q = 0;
    private boolean r = false;
    private ArrayList<String> s = new ArrayList();
    private boolean t = true;
    private GDPRCustomTexts u = new GDPRCustomTexts();
    private int v = 3000;
    private int w = 5000;

    public GDPRSetup(Parcel parcel) {
        this.f = parcel.readString();
        boolean bl = parcel.readByte() == 1;
        this.g = bl;
        boolean bl2 = parcel.readByte() == 1;
        this.h = bl2;
        boolean bl3 = parcel.readByte() == 1;
        this.i = bl3;
        Parcelable[] arrparcelable = parcel.readParcelableArray(GDPRNetwork.class.getClassLoader());
        this.j = new GDPRNetwork[arrparcelable.length];
        for (int i2 = 0; i2 < arrparcelable.length; ++i2) {
            this.j[i2] = (GDPRNetwork)arrparcelable[i2];
        }
        boolean bl4 = parcel.readByte() == 1;
        this.k = bl4;
        boolean bl5 = parcel.readByte() == 1;
        this.l = bl5;
        boolean bl6 = parcel.readByte() == 1;
        this.m = bl6;
        int n2 = parcel.readInt();
        this.n = new com.michaelflisar.gdprdialog.i[n2];
        int[] arrn = new int[n2];
        if (n2 > 0) {
            parcel.readIntArray(arrn);
        }
        for (int i3 = 0; i3 < n2; ++i3) {
            this.n[i3] = com.michaelflisar.gdprdialog.i.values()[arrn[i3]];
        }
        boolean bl7 = parcel.readByte() == 1;
        this.o = bl7;
        boolean bl8 = parcel.readByte() == 1;
        this.p = bl8;
        this.q = parcel.readInt();
        boolean bl9 = parcel.readByte() == 1;
        this.r = bl9;
        parcel.readStringList(this.s);
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        byte by = parcel.readByte();
        boolean bl10 = false;
        if (by == 1) {
            bl10 = true;
        }
        this.t = bl10;
        this.u = (GDPRCustomTexts)parcel.readParcelable(GDPRCustomTexts.class.getClassLoader());
    }

    public /* varargs */ GDPRSetup(GDPRNetwork ... arrgDPRNetwork) {
        if (arrgDPRNetwork != null && arrgDPRNetwork.length != 0) {
            this.j = arrgDPRNetwork;
            this.n = new com.michaelflisar.gdprdialog.i[0];
            return;
        }
        throw new RuntimeException("At least one ad network must be provided, otherwise this setup does not make any sense.");
    }

    public final boolean A() {
        return this.n.length > 0 || this.s.size() > 0;
        {
        }
    }

    public final GDPRNetwork[] B() {
        return this.j;
    }

    public final boolean C() {
        return this.m;
    }

    public final String D() {
        return this.f;
    }

    public final com.michaelflisar.gdprdialog.i[] E() {
        return this.n;
    }

    public boolean F() {
        return this.r;
    }

    public boolean G() {
        return this.t;
    }

    public final boolean H() {
        return this.o;
    }

    public GDPRSetup I(boolean bl) {
        this.i = bl;
        return this;
    }

    public GDPRSetup J(boolean bl) {
        this.o = bl;
        return this;
    }

    public /* varargs */ GDPRSetup K(com.michaelflisar.gdprdialog.i ... arri) {
        if (arri == null) {
            arri = new com.michaelflisar.gdprdialog.i[]{};
        }
        this.n = arri;
        return this;
    }

    public GDPRSetup L(int n2) {
        this.q = n2;
        return this;
    }

    public GDPRSetup M(boolean bl) {
        this.k = bl;
        return this;
    }

    public GDPRSetup N(boolean bl) {
        this.l = bl;
        return this;
    }

    public GDPRSetup O(boolean bl) {
        this.p = bl;
        return this;
    }

    public GDPRSetup P(boolean bl) {
        this.m = bl;
        return this;
    }

    public GDPRSetup Q(String string) {
        if (!string.startsWith("https://") && !string.startsWith("http://")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(string);
            string = stringBuilder.toString();
        }
        this.f = string;
        return this;
    }

    public GDPRSetup R(boolean bl) {
        this.r = bl;
        return this;
    }

    public GDPRSetup S(boolean bl) {
        this.t = bl;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public final boolean l() {
        return this.i || this.h;
        {
        }
    }

    public final boolean m() {
        return this.h;
    }

    public int n() {
        return this.w;
    }

    public int o() {
        return this.v;
    }

    public final boolean p() {
        GDPRNetwork[] arrgDPRNetwork = this.j;
        int n2 = arrgDPRNetwork.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!arrgDPRNetwork[i2].p()) continue;
            return true;
        }
        return false;
    }

    public int q() {
        return this.q;
    }

    public final boolean r() {
        return this.k;
    }

    public final boolean s() {
        return this.l;
    }

    public final boolean t() {
        return this.p;
    }

    public GDPRCustomTexts u() {
        return this.u;
    }

    public HashSet<String> v() {
        HashSet hashSet = new HashSet();
        GDPRNetwork[] arrgDPRNetwork = this.j;
        int n2 = arrgDPRNetwork.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            hashSet.add((Object)arrgDPRNetwork[i2].o());
        }
        return hashSet;
    }

    public String w(Context context) {
        return i.b(context, this.v());
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.f);
        parcel.writeInt((int)this.g);
        parcel.writeInt((int)this.h);
        parcel.writeInt((int)this.i);
        parcel.writeParcelableArray((Parcelable[])this.j, 0);
        parcel.writeByte((byte)this.k);
        parcel.writeByte((byte)this.l);
        parcel.writeByte((byte)this.m);
        parcel.writeInt(this.n.length);
        com.michaelflisar.gdprdialog.i[] arri = this.n;
        if (arri.length > 0) {
            com.michaelflisar.gdprdialog.i[] arri2;
            int[] arrn = new int[arri.length];
            for (int i2 = 0; i2 < (arri2 = this.n).length; ++i2) {
                arrn[i2] = arri2[i2].ordinal();
            }
            parcel.writeIntArray(arrn);
        }
        parcel.writeByte((byte)this.o);
        parcel.writeByte((byte)this.p);
        parcel.writeInt(this.q);
        parcel.writeByte((byte)this.r);
        parcel.writeStringList(this.s);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeByte((byte)this.t);
        parcel.writeParcelable((Parcelable)this.u, 0);
    }

    public final String x(Context context, boolean bl) {
        return i.c(this.j, context, bl);
    }

    public final ArrayList<String> y() {
        return this.s;
    }

    public final boolean z() {
        return this.g;
    }

}

