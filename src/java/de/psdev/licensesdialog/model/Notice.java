/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package de.psdev.licensesdialog.model;

import android.os.Parcel;
import android.os.Parcelable;
import d.a.a.g.l;
import java.io.Serializable;

public class Notice
implements Parcelable {
    public static Parcelable.Creator<Notice> f = new Parcelable.Creator<Notice>(){

        public Notice a(Parcel parcel) {
            return new Notice(parcel);
        }

        public Notice[] b(int n2) {
            return new Notice[n2];
        }
    };
    private String g;
    private String h;
    private String i;
    private l j;

    public Notice() {
    }

    private Notice(Parcel parcel) {
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = (l)parcel.readSerializable();
    }

    public Notice(String string2, String string3, String string4, l l2) {
        this.g = string2;
        this.h = string3;
        this.i = string4;
        this.j = l2;
    }

    public int describeContents() {
        return 0;
    }

    public String l() {
        return this.i;
    }

    public l m() {
        return this.j;
    }

    public String n() {
        return this.g;
    }

    public String o() {
        return this.h;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeSerializable((Serializable)this.j);
    }

}

