/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.telephony.TelephonyManager
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.TimeZone
 */
package com.michaelflisar.gdprdialog.m;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import com.michaelflisar.gdprdialog.GDPRNetwork;
import com.michaelflisar.gdprdialog.GDPRSubNetwork;
import com.michaelflisar.gdprdialog.c;
import com.michaelflisar.gdprdialog.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

public class i {
    public static int a(Context context) {
        try {
            int n2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode;
            return n2;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return -1;
        }
    }

    public static String b(Context context, Collection<String> collection) {
        String string = context.getString(l.w);
        String string2 = context.getString(l.v);
        Iterator iterator = collection.iterator();
        String string3 = "";
        int n2 = 0;
        while (iterator.hasNext()) {
            String string4 = (String)iterator.next();
            if (n2 == 0) {
                string3 = string4;
            } else {
                String string5 = n2 == -1 + collection.size() ? string2 : string;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(string5);
                stringBuilder.append(string4);
                string3 = stringBuilder.toString();
            }
            ++n2;
        }
        return string3;
    }

    public static String c(GDPRNetwork[] arrgDPRNetwork, Context context, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder("");
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < arrgDPRNetwork.length; ++i2) {
            boolean bl2 = arrgDPRNetwork[i2].n().size() == 0;
            String string = bl ? arrgDPRNetwork[i2].l(context, bl2, true) : arrgDPRNetwork[i2].m();
            if (!hashSet.add((Object)string)) continue;
            if (stringBuilder.length() > 0) {
                stringBuilder.append("<br>");
            }
            stringBuilder.append("&#8226;&nbsp;");
            String string2 = bl ? arrgDPRNetwork[i2].l(context, bl2, false) : arrgDPRNetwork[i2].m();
            stringBuilder.append(string2);
            for (GDPRSubNetwork gDPRSubNetwork : arrgDPRNetwork[i2].n()) {
                stringBuilder.append("<br>");
                stringBuilder.append("&nbsp;&nbsp;&#9702;&nbsp;");
                String string3 = bl ? gDPRSubNetwork.l() : gDPRSubNetwork.m();
                stringBuilder.append(string3);
            }
        }
        return stringBuilder.toString();
    }

    public static Boolean d() {
        boolean bl;
        try {
            if (a.a(Locale.getDefault().getCountry())) {
                Boolean bl2 = Boolean.TRUE;
                return bl2;
            }
            bl = false;
        }
        catch (Exception exception) {
            c.e().f().b("GDPRUtils", "Could not get location from Locale", exception);
            bl = true;
        }
        if (bl) {
            return null;
        }
        return Boolean.FALSE;
    }

    public static Boolean e(Context context) {
        boolean bl;
        boolean bl2;
        block8 : {
            String string;
            block7 : {
                bl = true;
                String string2 = ((TelephonyManager)context.getSystemService("phone")).getSimCountryIso();
                if (string2 == null) break block7;
                try {
                    if (string2.length() != 2 || !a.a(string2.toUpperCase())) break block7;
                    Boolean bl3 = Boolean.TRUE;
                    return bl3;
                }
                catch (Exception exception) {
                    c.e().f().b("GDPRUtils", "Could not get location from telephony manager via SimCountry", exception);
                    bl2 = true;
                }
            }
            bl2 = false;
            TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
            if (telephonyManager.getPhoneType() == 2 || telephonyManager.getPhoneType() == 0 || (string = telephonyManager.getNetworkCountryIso()) == null) break block8;
            try {
                if (string.length() != 2 || !a.a(string.toUpperCase())) break block8;
                Boolean bl4 = Boolean.TRUE;
                return bl4;
            }
            catch (Exception exception) {
                c.e().f().b("GDPRUtils", "Could not load location from network via NetworkCountry", exception);
            }
        }
        bl = bl2;
        if (bl) {
            return null;
        }
        return Boolean.FALSE;
    }

    public static Boolean f() {
        boolean bl = true;
        try {
            String string = TimeZone.getDefault().getID().toLowerCase();
            if (string.length() >= 10) {
                if (string.contains((CharSequence)"euro")) {
                    Boolean bl2 = Boolean.TRUE;
                    return bl2;
                }
                bl = false;
            }
        }
        catch (Exception exception) {
            c.e().f().b("GDPRUtils", "Could not get location from TimeZone", exception);
        }
        if (bl) {
            return null;
        }
        return Boolean.FALSE;
    }

    private static final class a
    extends Enum<a> {
        public static final /* enum */ a A;
        public static final /* enum */ a B;
        public static final /* enum */ a C;
        public static final /* enum */ a D;
        public static final /* enum */ a E;
        public static final /* enum */ a F;
        public static final /* enum */ a G;
        public static final /* enum */ a H;
        public static final /* enum */ a I;
        public static final /* enum */ a J;
        public static final /* enum */ a K;
        public static final /* enum */ a L;
        public static final /* enum */ a M;
        public static final /* enum */ a N;
        public static final /* enum */ a O;
        public static final /* enum */ a P;
        public static final /* enum */ a Q;
        public static final /* enum */ a R;
        public static final /* enum */ a S;
        public static final /* enum */ a T;
        public static final /* enum */ a U;
        public static final /* enum */ a V;
        public static final /* enum */ a W;
        private static final /* synthetic */ a[] X;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        public static final /* enum */ a k;
        public static final /* enum */ a l;
        public static final /* enum */ a m;
        public static final /* enum */ a n;
        public static final /* enum */ a o;
        public static final /* enum */ a p;
        public static final /* enum */ a q;
        public static final /* enum */ a r;
        public static final /* enum */ a s;
        public static final /* enum */ a t;
        public static final /* enum */ a u;
        public static final /* enum */ a v;
        public static final /* enum */ a w;
        public static final /* enum */ a x;
        public static final /* enum */ a y;
        public static final /* enum */ a z;

        static {
            a a2;
            a a3;
            a a4;
            a a5;
            a a6;
            a a7;
            a a8;
            a a9;
            a a10;
            a a11;
            a a12;
            a a13;
            a a14;
            a a15;
            a a16;
            a a17;
            a a18;
            a a19;
            a a20;
            a a21;
            a a22;
            a a23;
            a a24;
            a a25;
            a a26;
            a a27;
            a a28;
            a a29;
            a a30;
            a a31;
            a a32;
            a a33;
            a a34;
            a a35;
            a a36;
            a a37;
            a a38;
            a a39;
            a a40;
            a a41;
            a a42;
            a a43;
            a a44;
            a a45;
            f = a17 = new a();
            g = a20 = new a();
            h = a36 = new a();
            i = a40 = new a();
            j = a23 = new a();
            k = a31 = new a();
            l = a38 = new a();
            m = a2 = new a();
            n = a39 = new a();
            o = a32 = new a();
            p = a22 = new a();
            q = a42 = new a();
            r = a16 = new a();
            s = a37 = new a();
            t = a4 = new a();
            u = a19 = new a();
            v = a45 = new a();
            w = a18 = new a();
            x = a26 = new a();
            y = a6 = new a();
            z = a21 = new a();
            A = a28 = new a();
            B = a7 = new a();
            C = a12 = new a();
            D = a29 = new a();
            E = a25 = new a();
            F = a41 = new a();
            G = a11 = new a();
            H = a9 = new a();
            I = a30 = new a();
            J = a15 = new a();
            K = a8 = new a();
            L = a34 = new a();
            M = a14 = new a();
            N = a44 = new a();
            O = a27 = new a();
            P = a5 = new a();
            Q = a35 = new a();
            R = a13 = new a();
            S = a43 = new a();
            T = a10 = new a();
            U = a33 = new a();
            V = a3 = new a();
            W = a24 = new a();
            X = new a[]{a17, a20, a36, a40, a23, a31, a38, a2, a39, a32, a22, a42, a16, a37, a4, a19, a45, a18, a26, a6, a21, a28, a7, a12, a29, a25, a41, a11, a9, a30, a15, a8, a34, a14, a44, a27, a5, a35, a13, a43, a10, a33, a3, a24};
        }

        public static boolean a(String string) {
            a[] arra = a.values();
            int n2 = arra.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!arra[i2].name().equalsIgnoreCase(string)) continue;
                return true;
            }
            return false;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])X.clone();
        }
    }

}

