/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.webkit.MimeTypeMap
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.smp.musicspeed.importfile;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.smp.musicspeed.utils.g;
import java.util.List;

public class FileInfo
implements Parcelable {
    public static final Parcelable.Creator<FileInfo> CREATOR = new Parcelable.Creator<FileInfo>(){

        public FileInfo a(Parcel parcel) {
            return new FileInfo(parcel);
        }

        public FileInfo[] b(int n2) {
            return new FileInfo[n2];
        }
    };
    private Uri f;
    private String g;
    private String h;
    private long i;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public FileInfo(Context var1_1, Uri var2_2) {
        super();
        this.f = var2_2;
        if (var2_2 == null) ** GOTO lbl-1000
        try {
            if ("content".equals((Object)var2_2.getScheme())) {
                var5_3 = var1_1.getContentResolver().query(var2_2, null, null, null, null);
                var6_4 = var5_3.getColumnIndex("_display_name");
                var7_5 = var5_3.getColumnIndex("_size");
                var5_3.moveToFirst();
                this.g = var9_6 = var5_3.getString(var6_4);
                if (g.h(var9_6) < 0 && (var10_7 = var1_1.getContentResolver().getType(var2_2)) != null) {
                    var11_8 = MimeTypeMap.getSingleton().getExtensionFromMimeType(var10_7);
                    if (var11_8 != null) {
                        var12_9 = new StringBuilder();
                        var12_9.append(this.g);
                        var12_9.append(".");
                        var12_9.append(var11_8);
                        this.g = var12_9.toString();
                    } else {
                        var16_10 = new StringBuilder();
                        var16_10.append(this.g);
                        var16_10.append(".mp3");
                        this.g = var16_10.toString();
                    }
                }
                this.i = var5_3.getLong(var7_5);
                var5_3.close();
            } else lbl-1000: // 2 sources:
            {
                var4_11 = var2_2.getPathSegments();
                this.g = (String)var4_11.get(-1 + var4_11.size());
            }
        }
        catch (Exception var3_12) {
            var3_12.printStackTrace();
        }
        if (this.g != null) return;
        this.g = "Unknown";
    }

    private FileInfo(Parcel parcel) {
        this.f = (Uri)parcel.readParcelable(null);
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public String l() {
        return this.g;
    }

    public String m() {
        return this.h;
    }

    public long n() {
        return this.i;
    }

    public void o(String string2) {
        this.h = string2;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.f, 0);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeLong(this.i);
    }

}

