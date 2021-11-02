/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  f.z.d.k
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.dbrecord;

import android.os.Parcel;
import android.os.Parcelable;
import f.z.d.k;

public final class PresetItem
implements Parcelable {
    public static final Parcelable.Creator<PresetItem> CREATOR = new Creator();
    private final int controlId;
    private final int effectId;
    private final String presetName;
    private final float value;

    public PresetItem(String string, int n2, int n3, float f2) {
        k.g((Object)string, (String)"presetName");
        this.presetName = string;
        this.effectId = n2;
        this.controlId = n3;
        this.value = f2;
    }

    public static /* synthetic */ PresetItem copy$default(PresetItem presetItem, String string, int n2, int n3, float f2, int n4, Object object) {
        if ((n4 & 1) != 0) {
            string = presetItem.presetName;
        }
        if ((n4 & 2) != 0) {
            n2 = presetItem.effectId;
        }
        if ((n4 & 4) != 0) {
            n3 = presetItem.controlId;
        }
        if ((n4 & 8) != 0) {
            f2 = presetItem.value;
        }
        return presetItem.copy(string, n2, n3, f2);
    }

    public final String component1() {
        return this.presetName;
    }

    public final int component2() {
        return this.effectId;
    }

    public final int component3() {
        return this.controlId;
    }

    public final float component4() {
        return this.value;
    }

    public final PresetItem copy(String string, int n2, int n3, float f2) {
        k.g((Object)string, (String)"presetName");
        return new PresetItem(string, n2, n3, f2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PresetItem)) {
            return false;
        }
        PresetItem presetItem = (PresetItem)object;
        if (!k.c((Object)this.presetName, (Object)presetItem.presetName)) {
            return false;
        }
        if (this.effectId != presetItem.effectId) {
            return false;
        }
        if (this.controlId != presetItem.controlId) {
            return false;
        }
        return k.c((Object)Float.valueOf((float)this.value), (Object)Float.valueOf((float)presetItem.value));
    }

    public final int getControlId() {
        return this.controlId;
    }

    public final int getEffectId() {
        return this.effectId;
    }

    public final String getPresetName() {
        return this.presetName;
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return 31 * (31 * (31 * this.presetName.hashCode() + this.effectId) + this.controlId) + Float.floatToIntBits((float)this.value);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PresetItem(presetName=");
        stringBuilder.append(this.presetName);
        stringBuilder.append(", effectId=");
        stringBuilder.append(this.effectId);
        stringBuilder.append(", controlId=");
        stringBuilder.append(this.controlId);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        k.g((Object)parcel, (String)"out");
        parcel.writeString(this.presetName);
        parcel.writeInt(this.effectId);
        parcel.writeInt(this.controlId);
        parcel.writeFloat(this.value);
    }

    public static final class Creator
    implements Parcelable.Creator<PresetItem> {
        public final PresetItem createFromParcel(Parcel parcel) {
            k.g((Object)parcel, (String)"parcel");
            return new PresetItem(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readFloat());
        }

        public final PresetItem[] newArray(int n2) {
            return new PresetItem[n2];
        }
    }

}

