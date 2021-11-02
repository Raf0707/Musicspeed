/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.michaelflisar.gdprdialog;

import android.os.Parcel;
import android.os.Parcelable;

public class GDPRSubNetwork
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        public GDPRSubNetwork a(Parcel parcel) {
            return new GDPRSubNetwork(parcel);
        }

        public GDPRSubNetwork[] b(int n2) {
            return new GDPRSubNetwork[n2];
        }
    };
    private String f;
    private String g;

    public GDPRSubNetwork(Parcel parcel) {
        this.f = parcel.readString();
        this.g = parcel.readString();
    }

    public GDPRSubNetwork(String string, String string2) {
        this.f = string;
        this.g = string2;
    }

    public int describeContents() {
        return 0;
    }

    public String l() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<a href=\"");
        stringBuilder.append(this.g);
        stringBuilder.append("\">");
        stringBuilder.append(this.f);
        stringBuilder.append("</a>");
        return stringBuilder.toString();
    }

    public String m() {
        return this.f;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.f);
        parcel.writeString(this.g);
    }

}

