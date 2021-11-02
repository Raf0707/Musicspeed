/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.annotation.Keep
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.masterswitchpreference;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import f.z.d.g;
import f.z.d.k;

@Keep
public final class MasterSwitchPreferenceAttrs
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    private final boolean defaultValue;
    private final Integer excludedPrefScreen;
    private final Integer explanationIcon;
    private final boolean hideExplanation;
    private final Integer includedPrefScreen;
    private final String key;
    private final boolean showStatus;
    private final int switchOffBackgroundColor;
    private final String switchOffExplanationText;
    private final String switchOffText;
    private final int switchOnBackgroundColor;
    private final String switchOnExplanationText;
    private final String switchOnText;
    private final int switchTextColor;
    private final int switchThumbColor;
    private final int switchTrackColor;

    public MasterSwitchPreferenceAttrs() {
        this(0, 0, 0, 0, 0, null, null, null, null, null, null, false, null, false, null, false, 65535, null);
    }

    public MasterSwitchPreferenceAttrs(int n2, int n3, int n4, int n5, int n6, String string, String string2, Integer n7, Integer n8, String string3, String string4, boolean bl, String string5, boolean bl2, Integer n9, boolean bl3) {
        k.h((Object)string, (String)"switchOffExplanationText");
        k.h((Object)string2, (String)"switchOnExplanationText");
        k.h((Object)string3, (String)"switchOnText");
        k.h((Object)string4, (String)"switchOffText");
        k.h((Object)string5, (String)"key");
        this.switchThumbColor = n2;
        this.switchTrackColor = n3;
        this.switchOnBackgroundColor = n4;
        this.switchOffBackgroundColor = n5;
        this.switchTextColor = n6;
        this.switchOffExplanationText = string;
        this.switchOnExplanationText = string2;
        this.includedPrefScreen = n7;
        this.excludedPrefScreen = n8;
        this.switchOnText = string3;
        this.switchOffText = string4;
        this.hideExplanation = bl;
        this.key = string5;
        this.defaultValue = bl2;
        this.explanationIcon = n9;
        this.showStatus = bl3;
    }

    public /* synthetic */ MasterSwitchPreferenceAttrs(int n2, int n3, int n4, int n5, int n6, String string, String string2, Integer n7, Integer n8, String string3, String string4, boolean bl, String string5, boolean bl2, Integer n9, boolean bl3, int n10, g g2) {
        int n11 = (n10 & 1) != 0 ? -1 : n2;
        int n12 = (n10 & 2) != 0 ? (int)-2415919105L : n3;
        int n13 = (n10 & 4) != 0 ? -65536 : n4;
        int n14 = (n10 & 8) != 0 ? -3355444 : n5;
        int n15 = (n10 & 16) != 0 ? -16777216 : n6;
        int n16 = n10 & 32;
        String string6 = "";
        String string7 = n16 != 0 ? string6 : string;
        if ((n10 & 64) == 0) {
            string6 = string2;
        }
        Integer n17 = (n10 & 128) != 0 ? null : n7;
        Integer n18 = (n10 & 256) != 0 ? null : n8;
        String string8 = (n10 & 512) != 0 ? "On" : string3;
        String string9 = (n10 & 1024) != 0 ? "Off" : string4;
        boolean bl4 = (n10 & 2048) != 0 ? true : bl;
        String string10 = (n10 & 4096) != 0 ? "master_switch_key" : string5;
        boolean bl5 = (n10 & 8192) != 0 ? false : bl2;
        Integer n19 = (n10 & 16384) != 0 ? null : n9;
        boolean bl6 = (n10 & 32768) != 0 ? false : bl3;
        this(n11, n12, n13, n14, n15, string7, string6, n17, n18, string8, string9, bl4, string10, bl5, n19, bl6);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final Integer getExcludedPrefScreen() {
        return this.excludedPrefScreen;
    }

    public final Integer getExplanationIcon() {
        return this.explanationIcon;
    }

    public final boolean getHideExplanation() {
        return this.hideExplanation;
    }

    public final Integer getIncludedPrefScreen() {
        return this.includedPrefScreen;
    }

    public final String getKey() {
        return this.key;
    }

    public final boolean getShowStatus() {
        return this.showStatus;
    }

    public final int getSwitchOffBackgroundColor() {
        return this.switchOffBackgroundColor;
    }

    public final String getSwitchOffExplanationText() {
        return this.switchOffExplanationText;
    }

    public final String getSwitchOffText() {
        return this.switchOffText;
    }

    public final int getSwitchOnBackgroundColor() {
        return this.switchOnBackgroundColor;
    }

    public final String getSwitchOnExplanationText() {
        return this.switchOnExplanationText;
    }

    public final String getSwitchOnText() {
        return this.switchOnText;
    }

    public final int getSwitchTextColor() {
        return this.switchTextColor;
    }

    public final int getSwitchThumbColor() {
        return this.switchThumbColor;
    }

    public final int getSwitchTrackColor() {
        return this.switchTrackColor;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        k.h((Object)parcel, (String)"parcel");
        parcel.writeInt(this.switchThumbColor);
        parcel.writeInt(this.switchTrackColor);
        parcel.writeInt(this.switchOnBackgroundColor);
        parcel.writeInt(this.switchOffBackgroundColor);
        parcel.writeInt(this.switchTextColor);
        parcel.writeString(this.switchOffExplanationText);
        parcel.writeString(this.switchOnExplanationText);
        Integer n3 = this.includedPrefScreen;
        if (n3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(n3.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer n4 = this.excludedPrefScreen;
        if (n4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(n4.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.switchOnText);
        parcel.writeString(this.switchOffText);
        parcel.writeInt((int)this.hideExplanation);
        parcel.writeString(this.key);
        parcel.writeInt((int)this.defaultValue);
        Integer n5 = this.explanationIcon;
        if (n5 != null) {
            parcel.writeInt(1);
            parcel.writeInt(n5.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt((int)this.showStatus);
    }

    public static final class a
    implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.h((Object)parcel, (String)"in");
            int n2 = parcel.readInt();
            int n3 = parcel.readInt();
            int n4 = parcel.readInt();
            int n5 = parcel.readInt();
            int n6 = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            Integer n7 = parcel.readInt() != 0 ? Integer.valueOf((int)parcel.readInt()) : null;
            Integer n8 = parcel.readInt() != 0 ? Integer.valueOf((int)parcel.readInt()) : null;
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            boolean bl = parcel.readInt() != 0;
            String string5 = parcel.readString();
            boolean bl2 = parcel.readInt() != 0;
            int n9 = parcel.readInt();
            Integer n10 = null;
            if (n9 != 0) {
                n10 = parcel.readInt();
            }
            Integer n11 = n10;
            boolean bl3 = parcel.readInt() != 0;
            MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs = new MasterSwitchPreferenceAttrs(n2, n3, n4, n5, n6, string, string2, n7, n8, string3, string4, bl, string5, bl2, n11, bl3);
            return masterSwitchPreferenceAttrs;
        }

        public final Object[] newArray(int n2) {
            return new MasterSwitchPreferenceAttrs[n2];
        }
    }

}

