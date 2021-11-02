/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.ClassLoader
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 */
package com.michaelflisar.gdprdialog;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.michaelflisar.gdprdialog.GDPRSubNetwork;
import com.michaelflisar.gdprdialog.l;
import com.michaelflisar.gdprdialog.m.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GDPRNetwork
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        public GDPRNetwork a(Parcel parcel) {
            return new GDPRNetwork(parcel);
        }

        public GDPRNetwork[] b(int n2) {
            return new GDPRNetwork[n2];
        }
    };
    private String f;
    private String g;
    private String h;
    private boolean i;
    private boolean j;
    private ArrayList<GDPRSubNetwork> k;
    private String l;

    public GDPRNetwork(Context context, String string, String string2, int n2, boolean bl) {
        this.f = string;
        this.g = string2;
        this.h = context.getString(n2);
        this.i = false;
        this.l = null;
        this.j = bl;
        this.k = new ArrayList();
    }

    public GDPRNetwork(Parcel parcel) {
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        boolean bl = parcel.readByte() == 1;
        this.i = bl;
        byte by = parcel.readByte();
        boolean bl2 = false;
        if (by == 1) {
            bl2 = true;
        }
        this.j = bl2;
        this.k = new ArrayList();
        for (int i2 = parcel.readInt(); i2 > 0; --i2) {
            this.k.add((Object)((GDPRSubNetwork)parcel.readParcelable(GDPRSubNetwork.class.getClassLoader())));
        }
        this.l = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String l(Context context, boolean bl, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<a href=\"");
        stringBuilder.append(this.g);
        stringBuilder.append("\">");
        stringBuilder.append(this.f);
        stringBuilder.append("</a>");
        String string = stringBuilder.toString();
        if (bl && this.i && this.l != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(" (<a href=\"");
            stringBuilder2.append(this.l);
            stringBuilder2.append("\">");
            stringBuilder2.append(context.getString(l.C));
            stringBuilder2.append("</a>)");
            string = stringBuilder2.toString();
        }
        if (bl2 && this.k.size() > 0) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string);
            stringBuilder3.append(" (");
            String string2 = stringBuilder3.toString();
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.k.iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)((GDPRSubNetwork)iterator.next()).l());
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string2);
            stringBuilder4.append(i.b(context, (Collection<String>)arrayList));
            String string3 = stringBuilder4.toString();
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(string3);
            stringBuilder5.append(")");
            string = stringBuilder5.toString();
        }
        return string;
    }

    public String m() {
        return this.f;
    }

    public ArrayList<GDPRSubNetwork> n() {
        return this.k;
    }

    public String o() {
        return this.h;
    }

    public boolean p() {
        return this.j;
    }

    public GDPRNetwork q(String string) {
        this.i = true;
        this.l = string;
        return this;
    }

    public String toString() {
        String string = this.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" [");
        String string2 = stringBuilder.toString();
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.k.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((GDPRSubNetwork)iterator.next()).m());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append(TextUtils.join((CharSequence)",", (Iterable)arrayList));
        String string3 = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string3);
        stringBuilder3.append("]");
        return stringBuilder3.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeByte((byte)this.i);
        parcel.writeByte((byte)this.j);
        parcel.writeInt(this.k.size());
        Iterator iterator = this.k.iterator();
        while (iterator.hasNext()) {
            parcel.writeParcelable((Parcelable)((GDPRSubNetwork)iterator.next()), 0);
        }
        parcel.writeString(this.l);
    }

}

