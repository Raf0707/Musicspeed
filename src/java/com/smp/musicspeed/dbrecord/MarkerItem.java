/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.mopub.mobileads.d0
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.dbrecord;

import android.os.Parcel;
import android.os.Parcelable;
import com.mopub.mobileads.d0;
import f.z.d.g;
import f.z.d.k;

public final class MarkerItem
implements Parcelable {
    public static final Parcelable.Creator<MarkerItem> CREATOR = new Creator();
    private final long MarkerItemId;
    private final long durationUs;
    private final String file;
    private final boolean isA;
    private final boolean isB;
    private final String name;
    private final float position;

    public MarkerItem(long l2, float f2, boolean bl, boolean bl2, String string, long l3, String string2) {
        k.g((Object)string, (String)"file");
        k.g((Object)string2, (String)"name");
        this.MarkerItemId = l2;
        this.position = f2;
        this.isA = bl;
        this.isB = bl2;
        this.file = string;
        this.durationUs = l3;
        this.name = string2;
    }

    public /* synthetic */ MarkerItem(long l2, float f2, boolean bl, boolean bl2, String string, long l3, String string2, int n2, g g2) {
        long l4 = (n2 & 1) != 0 ? 0L : l2;
        String string3 = (n2 & 16) != 0 ? "" : string;
        long l5 = (n2 & 32) != 0 ? 0L : l3;
        String string4 = (n2 & 64) != 0 ? "" : string2;
        this(l4, f2, bl, bl2, string3, l5, string4);
    }

    public static /* synthetic */ MarkerItem copy$default(MarkerItem markerItem, long l2, float f2, boolean bl, boolean bl2, String string, long l3, String string2, int n2, Object object) {
        long l4 = (n2 & 1) != 0 ? markerItem.MarkerItemId : l2;
        float f3 = (n2 & 2) != 0 ? markerItem.position : f2;
        boolean bl3 = (n2 & 4) != 0 ? markerItem.isA : bl;
        boolean bl4 = (n2 & 8) != 0 ? markerItem.isB : bl2;
        String string3 = (n2 & 16) != 0 ? markerItem.file : string;
        long l5 = (n2 & 32) != 0 ? markerItem.durationUs : l3;
        String string4 = (n2 & 64) != 0 ? markerItem.name : string2;
        return markerItem.copy(l4, f3, bl3, bl4, string3, l5, string4);
    }

    public final long component1() {
        return this.MarkerItemId;
    }

    public final float component2() {
        return this.position;
    }

    public final boolean component3() {
        return this.isA;
    }

    public final boolean component4() {
        return this.isB;
    }

    public final String component5() {
        return this.file;
    }

    public final long component6() {
        return this.durationUs;
    }

    public final String component7() {
        return this.name;
    }

    public final MarkerItem copy(long l2, float f2, boolean bl, boolean bl2, String string, long l3, String string2) {
        k.g((Object)string, (String)"file");
        k.g((Object)string2, (String)"name");
        MarkerItem markerItem = new MarkerItem(l2, f2, bl, bl2, string, l3, string2);
        return markerItem;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MarkerItem)) {
            return false;
        }
        MarkerItem markerItem = (MarkerItem)object;
        if (this.MarkerItemId != markerItem.MarkerItemId) {
            return false;
        }
        if (!k.c((Object)Float.valueOf((float)this.position), (Object)Float.valueOf((float)markerItem.position))) {
            return false;
        }
        if (this.isA != markerItem.isA) {
            return false;
        }
        if (this.isB != markerItem.isB) {
            return false;
        }
        if (!k.c((Object)this.file, (Object)markerItem.file)) {
            return false;
        }
        if (this.durationUs != markerItem.durationUs) {
            return false;
        }
        return k.c((Object)this.name, (Object)markerItem.name);
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final String getFile() {
        return this.file;
    }

    public final long getMarkerItemId() {
        return this.MarkerItemId;
    }

    public final String getName() {
        return this.name;
    }

    public final float getPosition() {
        return this.position;
    }

    public int hashCode() {
        int n2 = 31 * (31 * d0.a((long)this.MarkerItemId) + Float.floatToIntBits((float)this.position));
        int n3 = this.isA;
        int n4 = 1;
        if (n3 != 0) {
            n3 = 1;
        }
        int n5 = 31 * (n2 + n3);
        int n6 = this.isB;
        if (n6 == 0) {
            n4 = n6;
        }
        return 31 * (31 * (31 * (n5 + n4) + this.file.hashCode()) + d0.a((long)this.durationUs)) + this.name.hashCode();
    }

    public final boolean isA() {
        return this.isA;
    }

    public final boolean isB() {
        return this.isB;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MarkerItem(MarkerItemId=");
        stringBuilder.append(this.MarkerItemId);
        stringBuilder.append(", position=");
        stringBuilder.append(this.position);
        stringBuilder.append(", isA=");
        stringBuilder.append(this.isA);
        stringBuilder.append(", isB=");
        stringBuilder.append(this.isB);
        stringBuilder.append(", file=");
        stringBuilder.append(this.file);
        stringBuilder.append(", durationUs=");
        stringBuilder.append(this.durationUs);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        k.g((Object)parcel, (String)"out");
        parcel.writeLong(this.MarkerItemId);
        parcel.writeFloat(this.position);
        parcel.writeInt((int)this.isA);
        parcel.writeInt((int)this.isB);
        parcel.writeString(this.file);
        parcel.writeLong(this.durationUs);
        parcel.writeString(this.name);
    }

    public static final class Creator
    implements Parcelable.Creator<MarkerItem> {
        public final MarkerItem createFromParcel(Parcel parcel) {
            k.g((Object)parcel, (String)"parcel");
            long l2 = parcel.readLong();
            float f2 = parcel.readFloat();
            boolean bl = parcel.readInt() != 0;
            int n2 = parcel.readInt();
            boolean bl2 = false;
            if (n2 != 0) {
                bl2 = true;
            }
            String string = parcel.readString();
            long l3 = parcel.readLong();
            String string2 = parcel.readString();
            MarkerItem markerItem = new MarkerItem(l2, f2, bl, bl2, string, l3, string2);
            return markerItem;
        }

        public final MarkerItem[] newArray(int n2) {
            return new MarkerItem[n2];
        }
    }

}

