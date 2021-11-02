/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package de.psdev.licensesdialog.model;

import android.os.Parcel;
import android.os.Parcelable;
import de.psdev.licensesdialog.model.Notice;
import java.util.ArrayList;
import java.util.List;

public class Notices
implements Parcelable {
    public static Parcelable.Creator<Notices> f = new Parcelable.Creator<Notices>(){

        public Notices a(Parcel parcel) {
            return new Notices(parcel);
        }

        public Notices[] b(int n2) {
            return new Notices[n2];
        }
    };
    private final List<Notice> g;

    public Notices() {
        this.g = new ArrayList();
    }

    protected Notices(Parcel parcel) {
        ArrayList arrayList;
        this.g = arrayList = new ArrayList();
        parcel.readList((List)arrayList, Notice.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void l(Notice notice) {
        this.g.add((Object)notice);
    }

    public List<Notice> m() {
        return this.g;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeList(this.g);
    }

}

