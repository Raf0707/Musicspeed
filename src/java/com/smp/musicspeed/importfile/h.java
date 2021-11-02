/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.BroadcastReceiver
 *  android.content.ClipData
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.smp.musicspeed.importfile;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.folders.u;
import com.smp.musicspeed.importfile.HardPathService;
import com.smp.musicspeed.importfile.d;
import com.smp.musicspeed.importfile.e;
import com.smp.musicspeed.importfile.f;
import com.smp.musicspeed.importfile.h;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class h
extends androidx.fragment.app.c {
    private int v;
    private Intent w;
    private c x;
    private b y;
    private IntentFilter z;

    private /* synthetic */ void P(DialogInterface dialogInterface, int n2) {
        t.K(this.requireContext());
        this.x.G();
    }

    public static h R(int n2, Intent intent) {
        h h2 = new h();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.smp.musicspeed.importkey2", (Parcelable)intent);
        bundle.putInt("com.smp.musicspeed.requestcodekey", n2);
        h2.setArguments(bundle);
        return h2;
    }

    public Dialog B(Bundle bundle) {
        d.a a2 = new d.a((Context)this.getActivity(), o.d(this.requireContext()));
        a2.u(this.getActivity().getLayoutInflater().inflate(2131492936, null));
        Intent intent = this.w;
        if (intent != null && intent.getClipData() != null) {
            a2.g(2131820781);
        } else {
            a2.g(2131820780);
        }
        a2.j(17039360, (DialogInterface.OnClickListener)new f(this));
        return a2.a();
    }

    public /* synthetic */ void Q(DialogInterface dialogInterface, int n2) {
        this.P(dialogInterface, n2);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.x = context;
    }

    public void onCreate(Bundle bundle) {
        IntentFilter intentFilter;
        super.onCreate(bundle);
        this.w = (Intent)this.getArguments().getParcelable("com.smp.musicspeed.importkey2");
        this.v = this.getArguments().getInt("com.smp.musicspeed.requestcodekey");
        this.y = new BroadcastReceiver(){

            private void a(Context context, List<String> list) {
                Map map = Collections.synchronizedMap((Map)new LinkedHashMap());
                for (String string : list) {
                    if (string == null) continue;
                    map.put((Object)u.h(new File(string)), null);
                }
                List list2 = Collections.synchronizedList((List)new ArrayList());
                if (map.size() == 0) {
                    h.this.x.j(h.this.v, (List<MediaTrack>)new ArrayList(map.values()));
                    h.this.w();
                }
                try {
                    MediaScannerConnection.scanFile((Context)context, (String[])((String[])map.keySet().toArray((Object[])new String[0])), null, (MediaScannerConnection.OnScanCompletedListener)new d(this, list2, context, map));
                }
                catch (Exception exception) {}
            }

            static /* synthetic */ int b(MediaTrack mediaTrack, MediaTrack mediaTrack2) {
                return mediaTrack.getLocation().compareTo(mediaTrack2.getLocation());
            }

            private /* synthetic */ void c(List list, Context context, Map map, String string, Uri uri) {
                list.add(new Object());
                String string2 = u.h(new File(string));
                List<MediaTrack> list2 = com.smp.musicspeed.k0.m0.f.C(context, string2);
                if (list2.size() > 0) {
                    MediaTrack mediaTrack = (MediaTrack)list2.get(0);
                    map.put((Object)u.h(new File(string2)), (Object)mediaTrack);
                }
                if (list.size() == map.size()) {
                    ArrayList arrayList = new ArrayList(map.values());
                    while (arrayList.remove(null)) {
                    }
                    Collections.sort((List)arrayList, (Comparator)e.f);
                    try {
                        h.this.x.j(h.this.v, (List<MediaTrack>)arrayList);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    h.this.w();
                }
            }

            public /* synthetic */ void d(List list, Context context, Map map, String string, Uri uri) {
                this.c(list, context, map, string, uri);
            }

            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals((Object)"com.smp.HardPathService.ACTION_SEND_FILE_NAMES")) {
                    this.a(context, (List<String>)intent.getStringArrayListExtra("com.smp.HardPathService.INTENT_FILENAMES"));
                }
            }
        };
        this.z = intentFilter = new IntentFilter("com.smp.HardPathService.ACTION_SEND_FILE_NAMES");
        intentFilter.addCategory("android.intent.category.DEFAULT");
        this.H(false);
    }

    public void onDestroy() {
        Fragment.super.onDestroy();
    }

    public void onPause() {
        Fragment.super.onPause();
        this.getActivity().unregisterReceiver((BroadcastReceiver)this.y);
    }

    public void onResume() {
        Fragment.super.onResume();
        this.getActivity().registerReceiver((BroadcastReceiver)this.y, this.z);
        if (!t.C((Context)this.getActivity(), HardPathService.class)) {
            Intent intent = new Intent((Context)this.getActivity(), HardPathService.class);
            intent.setData(this.w.getData());
            intent.setClipData(this.w.getClipData());
            this.getActivity().startService(intent);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Fragment.super.onViewCreated(view, bundle);
    }

}

