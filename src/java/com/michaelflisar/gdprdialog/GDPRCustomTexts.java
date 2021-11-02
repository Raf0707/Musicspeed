/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 */
package com.michaelflisar.gdprdialog;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class GDPRCustomTexts
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        public GDPRCustomTexts a(Parcel parcel) {
            return new GDPRCustomTexts(parcel);
        }

        public GDPRCustomTexts[] b(int n2) {
            return new GDPRCustomTexts[n2];
        }
    };
    private int f = -1;
    private String g = null;
    private int h = -1;
    private String i = null;
    private int j = -1;
    private String k = null;
    private int l = -1;
    private String m = null;
    private int n = -1;
    private String o = null;

    public GDPRCustomTexts() {
    }

    public GDPRCustomTexts(Parcel parcel) {
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public final String l(Context context) {
        int n2 = this.n;
        if (n2 != -1) {
            return context.getString(n2);
        }
        return this.o;
    }

    public final String m(Context context) {
        int n2 = this.j;
        if (n2 != -1) {
            return context.getString(n2);
        }
        return this.k;
    }

    public final String n(Context context) {
        int n2 = this.h;
        if (n2 != -1) {
            return context.getString(n2);
        }
        return this.i;
    }

    public final String o(Context context) {
        int n2 = this.f;
        if (n2 != -1) {
            return context.getString(n2);
        }
        return this.g;
    }

    public final String p(Context context) {
        int n2 = this.l;
        if (n2 != -1) {
            return context.getString(n2);
        }
        return this.m;
    }

    public final boolean q() {
        return this.n != -1 || this.o != null;
        {
        }
    }

    public final boolean r() {
        return this.j != -1 || this.k != null;
        {
        }
    }

    public final boolean s() {
        return this.h != -1 || this.i != null;
        {
        }
    }

    public final boolean t() {
        return this.f != -1 || this.g != null;
        {
        }
    }

    public final boolean u() {
        return this.l != -1 || this.m != null;
        {
        }
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeString(this.o);
    }

}

