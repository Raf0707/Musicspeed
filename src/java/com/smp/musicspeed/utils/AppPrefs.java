/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.LiveData
 *  c.c.a.a
 *  c.c.a.d
 *  c.c.a.f
 *  c.c.a.j.a
 *  com.smp.musicspeed.utils.AppPrefs$a
 *  com.smp.musicspeed.utils.AppPrefs$b
 *  com.smp.musicspeed.utils.AppPrefs$c
 *  f.e0.g
 *  f.z.d.o
 *  f.z.d.p
 *  f.z.d.s
 *  f.z.d.t
 *  java.lang.Boolean
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import androidx.lifecycle.LiveData;
import c.c.a.f;
import com.smp.musicspeed.utils.AppPrefs;
import f.b0.d;
import f.e0.i;
import f.z.d.g;
import f.z.d.k;
import f.z.d.o;
import f.z.d.p;
import f.z.d.s;
import f.z.d.t;
import f.z.d.z;
import java.util.Set;

public final class AppPrefs
extends c.c.a.d {
    private static final d A;
    private static final d B;
    private static final d C;
    private static final d D;
    private static final d E;
    private static final d F;
    private static final d G;
    private static final d H;
    private static final d I;
    private static final d J;
    private static final d K;
    private static final d L;
    private static final d M;
    private static final d N;
    private static final d O;
    private static final d P;
    private static final d Q;
    private static final d R;
    private static final d S;
    private static final d T;
    private static final d U;
    private static final f.b0.c V;
    private static final LiveData<Boolean> W;
    public static final AppPrefs k;
    static final /* synthetic */ i<Object>[] l;
    private static final d m;
    private static final d n;
    private static final d o;
    private static final d p;
    private static final d q;
    private static final d r;
    private static final d s;
    private static final d t;
    private static final d u;
    private static final d v;
    private static final d w;
    private static final d x;
    private static final d y;
    private static final d z;

    static {
        AppPrefs appPrefs;
        i[] arri = new i[]{z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "playerControls", "getPlayerControls()I")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiEnabled", "getCustomUiEnabled()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "lastPresetUi", "getLastPresetUi()I")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customEverSelected", "getCustomEverSelected()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiPitchAndTempo", "getCustomUiPitchAndTempo()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiLoop", "getCustomUiLoop()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiMarkers", "getCustomUiMarkers()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiEqualizer", "getCustomUiEqualizer()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiPreamp", "getCustomUiPreamp()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiBalance", "getCustomUiBalance()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiBpm", "getCustomUiBpm()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiKey", "getCustomUiKey()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiReverb", "getCustomUiReverb()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiCompressor", "getCustomUiCompressor()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiVocal", "getCustomUiVocal()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiEcho", "getCustomUiEcho()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiMono", "getCustomUiMono()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiLimiter", "getCustomUiLimiter()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "customUiFlanger", "getCustomUiFlanger()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "uiWaveform", "getUiWaveform()Ljava/lang/String;")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "uiLink", "getUiLink()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "uiPlusMinus", "getUiPlusMinus()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "useNativeLibrary", "getUseNativeLibrary()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "beatSyncingLoopMarkers", "getBeatSyncingLoopMarkers()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "beatSyncingEffects", "getBeatSyncingEffects()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "boughtNoAds", "getBoughtNoAds()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "lastRewardedRemovedAdsTime", "getLastRewardedRemovedAdsTime()J")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "showRemoveAdsAutomatically", "getShowRemoveAdsAutomatically()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "removeAdsDialogOpenedOnce", "getRemoveAdsDialogOpenedOnce()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "appRunFirstTime", "getAppRunFirstTime()J")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "userWatchedOneRewardedAd", "getUserWatchedOneRewardedAd()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "markerSeekToastCount", "getMarkerSeekToastCount()I")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "delayPlayback", "getDelayPlayback()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "firstSlide", "getFirstSlide()Z")), z.e((o)new p((f.e0.c)z.b(AppPrefs.class), "stretchQuality", "getStretchQuality()Ljava/lang/String;")), z.f((s)new t((f.e0.c)z.b(AppPrefs.class), "importedPlaylists", "getImportedPlaylists()Ljava/util/Set;"))};
        l = arri;
        k = appPrefs = new AppPrefs();
        m = c.c.a.d.r((c.c.a.d)appPrefs, (int)0, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[0]);
        n = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[1]);
        o = c.c.a.d.r((c.c.a.d)appPrefs, (int)0, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[2]);
        p = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[3]);
        q = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)true, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[4]);
        r = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)true, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[5]);
        s = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[6]);
        t = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[7]);
        u = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[8]);
        v = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[9]);
        w = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[10]);
        x = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[11]);
        y = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[12]);
        z = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[13]);
        A = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[14]);
        B = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[15]);
        C = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[16]);
        D = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[17]);
        E = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[18]);
        F = c.c.a.d.v((c.c.a.d)appPrefs, (String)"0", null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[19]);
        G = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[20]);
        H = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[21]);
        I = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)true, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[22]);
        J = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[23]);
        K = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[24]);
        L = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[25]);
        M = c.c.a.d.t((c.c.a.d)appPrefs, (long)0L, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[26]);
        N = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)true, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[27]);
        O = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[28]);
        P = c.c.a.d.t((c.c.a.d)appPrefs, (long)-1L, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[29]);
        Q = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[30]);
        R = c.c.a.d.r((c.c.a.d)appPrefs, (int)0, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[31]);
        S = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[32]);
        T = c.c.a.d.c((c.c.a.d)appPrefs, (boolean)true, null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[33]);
        U = c.c.a.d.v((c.c.a.d)appPrefs, (String)"Medium", null, (boolean)false, (int)6, null).g((c.c.a.d)appPrefs, arri[34]);
        V = c.c.a.d.y((c.c.a.d)appPrefs, null, null, (boolean)false, (int)7, null).e((c.c.a.d)appPrefs, arri[35]);
        W = c.c.a.j.a.a((c.c.a.d)appPrefs, (f.e0.g)new a((Object)appPrefs));
    }

    private AppPrefs() {
        super(null, null, 3, null);
    }

    public final boolean A() {
        return (Boolean)K.a(this, l[24]);
    }

    public final void A0(boolean bl) {
        s.b(this, l[6], bl);
    }

    public final boolean B() {
        return (Boolean)J.a(this, l[23]);
    }

    public final void B0(boolean bl) {
        C.b(this, l[16], bl);
    }

    public final String C() {
        String string = this.o((i)new b((Object)this));
        k.e(string);
        return string;
    }

    public final void C0(boolean bl) {
        q.b(this, l[4], bl);
    }

    public final boolean D() {
        return (Boolean)L.a(this, l[25]);
    }

    public final void D0(boolean bl) {
        u.b(this, l[8], bl);
    }

    public final LiveData<Boolean> E() {
        return W;
    }

    public final void E0(boolean bl) {
        y.b(this, l[12], bl);
    }

    public final boolean F() {
        return (Boolean)p.a(this, l[3]);
    }

    public final void F0(boolean bl) {
        A.b(this, l[14], bl);
    }

    public final boolean G() {
        return (Boolean)v.a(this, l[9]);
    }

    public final void G0(boolean bl) {
        S.b(this, l[32], bl);
    }

    public final boolean H() {
        return (Boolean)w.a(this, l[10]);
    }

    public final void H0(int n2) {
        o.b(this, l[2], n2);
    }

    public final boolean I() {
        return (Boolean)z.a(this, l[13]);
    }

    public final void I0(long l2) {
        M.b(this, l[26], l2);
    }

    public final boolean J() {
        return (Boolean)B.a(this, l[15]);
    }

    public final void J0(int n2) {
        R.b(this, l[31], n2);
    }

    public final boolean K() {
        return (Boolean)n.a(this, l[1]);
    }

    public final void K0(int n2) {
        m.b(this, l[0], n2);
    }

    public final boolean L() {
        return (Boolean)t.a(this, l[7]);
    }

    public final void L0(boolean bl) {
        O.b(this, l[28], bl);
    }

    public final boolean M() {
        return (Boolean)E.a(this, l[18]);
    }

    public final void M0(boolean bl) {
        N.b(this, l[27], bl);
    }

    public final boolean N() {
        return (Boolean)x.a(this, l[11]);
    }

    public final void N0(String string) {
        k.g(string, "<set-?>");
        U.b(this, l[34], string);
    }

    public final boolean O() {
        return (Boolean)D.a(this, l[17]);
    }

    public final void O0(boolean bl) {
        G.b(this, l[20], bl);
    }

    public final boolean P() {
        return (Boolean)r.a(this, l[5]);
    }

    public final void P0(boolean bl) {
        H.b(this, l[21], bl);
    }

    public final boolean Q() {
        return (Boolean)s.a(this, l[6]);
    }

    public final void Q0(String string) {
        k.g(string, "<set-?>");
        F.b(this, l[19], string);
    }

    public final boolean R() {
        return (Boolean)C.a(this, l[16]);
    }

    public final void R0(boolean bl) {
        I.b(this, l[22], bl);
    }

    public final boolean S() {
        return (Boolean)q.a(this, l[4]);
    }

    public final void S0(boolean bl) {
        Q.b(this, l[30], bl);
    }

    public final boolean T() {
        return (Boolean)u.a(this, l[8]);
    }

    public final boolean U() {
        return (Boolean)y.a(this, l[12]);
    }

    public final boolean V() {
        return (Boolean)A.a(this, l[14]);
    }

    public final boolean W() {
        return (Boolean)S.a(this, l[32]);
    }

    public final Set<String> X() {
        return (Set)V.a(this, l[35]);
    }

    public final int Y() {
        return ((Number)o.a(this, l[2])).intValue();
    }

    public final long Z() {
        return ((Number)M.a(this, l[26])).longValue();
    }

    public final int a0() {
        return ((Number)R.a(this, l[31])).intValue();
    }

    public final int b0() {
        return ((Number)m.a(this, l[0])).intValue();
    }

    public final boolean c0() {
        return (Boolean)O.a(this, l[28]);
    }

    public final boolean d0() {
        return (Boolean)N.a(this, l[27]);
    }

    public final String e0() {
        return (String)U.a(this, l[34]);
    }

    public final int f0() {
        block10 : {
            block9 : {
                String string;
                block8 : {
                    string = this.e0();
                    int n2 = string.hashCode();
                    if (n2 == -1994163307) break block8;
                    if (n2 != 76596) {
                        if (n2 == 2249154 && string.equals((Object)"High")) {
                            return 0;
                        }
                    } else if (string.equals((Object)"Low")) {
                        return 2;
                    }
                    break block9;
                }
                if (string.equals((Object)"Medium")) break block10;
            }
            return 3;
        }
        return 1;
    }

    public final boolean g0() {
        return (Boolean)G.a(this, l[20]);
    }

    public final boolean h0() {
        return (Boolean)H.a(this, l[21]);
    }

    public final String i0() {
        return (String)F.a(this, l[19]);
    }

    public final boolean j0() {
        return (Boolean)I.a(this, l[22]);
    }

    public String k() {
        return k.m(this.g().getPackageName(), "_preferences");
    }

    public final String k0() {
        String string = this.o((i)new c((Object)this));
        k.e(string);
        return string;
    }

    public final boolean l0() {
        return (Boolean)Q.a(this, l[30]);
    }

    public final void m0(long l2) {
        P.b(this, l[29], l2);
    }

    public final void n0(boolean bl) {
        J.b(this, l[23], bl);
    }

    public final void o0(boolean bl) {
        L.b(this, l[25], bl);
    }

    public final void p0(boolean bl) {
        p.b(this, l[3], bl);
    }

    public final void q0(boolean bl) {
        v.b(this, l[9], bl);
    }

    public final void r0(boolean bl) {
        w.b(this, l[10], bl);
    }

    public final void s0(boolean bl) {
        z.b(this, l[13], bl);
    }

    public final void t0(boolean bl) {
        B.b(this, l[15], bl);
    }

    public final void u0(boolean bl) {
        n.b(this, l[1], bl);
    }

    public final void v0(boolean bl) {
        t.b(this, l[7], bl);
    }

    public final void w0(boolean bl) {
        E.b(this, l[18], bl);
    }

    public final void x0(boolean bl) {
        x.b(this, l[11], bl);
    }

    public final void y0(boolean bl) {
        D.b(this, l[17], bl);
    }

    public final long z() {
        return ((Number)P.a(this, l[29])).longValue();
    }

    public final void z0(boolean bl) {
        r.b(this, l[5], bl);
    }
}

