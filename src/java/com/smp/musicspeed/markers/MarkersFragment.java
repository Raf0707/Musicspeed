/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.LayoutTransition
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  androidx.cardview.widget.CardView
 *  androidx.core.widget.ContentLoadingProgressBar
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  androidx.fragment.app.x
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.h0
 *  androidx.lifecycle.h0$b
 *  androidx.lifecycle.i0
 *  androidx.lifecycle.p
 *  androidx.lifecycle.x
 *  com.smp.musicspeed.markers.e0
 *  f.u.l
 *  java.lang.Boolean
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ListIterator
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 *  kotlinx.coroutines.w0
 */
package com.smp.musicspeed.markers;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.d0;
import com.smp.musicspeed.dbrecord.MarkerItem;
import com.smp.musicspeed.markers.MarkersFragment;
import com.smp.musicspeed.markers.e0;
import com.smp.musicspeed.markers.f;
import com.smp.musicspeed.markers.g;
import com.smp.musicspeed.markers.g0;
import com.smp.musicspeed.markers.h;
import com.smp.musicspeed.markers.i;
import com.smp.musicspeed.markers.j;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.r;
import f.n;
import f.t;
import f.z.d.k;
import f.z.d.l;
import f.z.d.z;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

/*
 * Exception performing whole class analysis.
 */
public final class MarkersFragment
extends Fragment
implements k0 {
    private final /* synthetic */ k0 f;
    private final f.f g;

    public MarkersFragment() {
        this.f = l0.b();
        this.g = androidx.fragment.app.x.a((Fragment)this, (f.e0.b)z.b(g0.class), (f.z.c.a)new f.z.c.a<i0>(){

            public final i0 a() {
                androidx.fragment.app.d d2 = this.requireActivity();
                k.f((Object)d2, "requireActivity()");
                i0 i02 = d2.getViewModelStore();
                k.f((Object)i02, "requireActivity().viewModelStore");
                return i02;
            }
        }, (f.z.c.a)new f.z.c.a<h0.b>(){

            public final h0.b a() {
                androidx.fragment.app.d d2 = this.requireActivity();
                k.f((Object)d2, "requireActivity()");
                return d2.getDefaultViewModelProviderFactory();
            }
        });
    }

    public static /* synthetic */ void A(MarkersFragment markersFragment, List list) {
        MarkersFragment.M(markersFragment, list);
    }

    public static /* synthetic */ void B(MarkersFragment markersFragment, Boolean bl) {
        MarkersFragment.N(markersFragment, bl);
    }

    private final void C() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.t);
        ((ImageButton)view2).setOnClickListener((View.OnClickListener)new g(this));
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.v);
        ((ImageButton)view4).setOnClickListener((View.OnClickListener)new com.smp.musicspeed.markers.e(this));
        View view5 = this.getView();
        View view6 = view5 == null ? null : view5.findViewById(d0.w);
        ((ImageButton)view6).setOnClickListener((View.OnClickListener)new h(this));
        View view7 = this.getView();
        View view8 = view7 == null ? null : view7.findViewById(d0.u);
        ((ImageButton)view8).setOnClickListener((View.OnClickListener)new com.smp.musicspeed.markers.d(this));
    }

    private static final void D(MarkersFragment markersFragment, View view) {
        k.g((Object)markersFragment, "this$0");
        if (MainActivity.J) {
            float f2 = markersFragment.t().b4();
            markersFragment.u().f(f2);
        }
    }

    private static final void F(MarkersFragment markersFragment, View view) {
        k.g((Object)markersFragment, "this$0");
        MarkersFragment.J(markersFragment, false);
    }

    private static final void G(MarkersFragment markersFragment, View view) {
        k.g((Object)markersFragment, "this$0");
        MarkersFragment.J(markersFragment, true);
    }

    private static final void H(MarkersFragment markersFragment, View view) {
        k.g((Object)markersFragment, "this$0");
        new e0().M(markersFragment.requireActivity().R(), "MarkersListFragment");
        view.setEnabled(false);
        kotlinx.coroutines.e.d((k0)markersFragment, null, null, (f.z.c.p)new f.z.c.p<k0, f.w.d<? super t>, Object>(view, null){
            int j;
            final /* synthetic */ View k;
            {
                this.k = view;
                super(2, d2);
            }

            @Override
            public final f.w.d<t> a(Object object, f.w.d<?> d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public final Object q(Object object) {
                Object object2 = f.w.j.b.c();
                int n2 = this.j;
                if (n2 != 0) {
                    if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    n.b(object);
                } else {
                    n.b(object);
                    this.j = 1;
                    if (w0.a((long)750L, (f.w.d)this) == object2) {
                        return object2;
                    }
                }
                this.k.setEnabled(true);
                return t.a;
            }

            public final Object t(k0 k02, f.w.d<? super t> d2) {
                return (this.a((Object)k02, d2)).q(t.a);
            }
        }, (int)3, null);
    }

    private static final void J(MarkersFragment markersFragment, boolean bl) {
        if (MainActivity.J) {
            List list = (List)markersFragment.u().h().f();
            boolean bl2 = list == null || list.isEmpty();
            if (!bl2) {
                Object object;
                float f2 = markersFragment.t().q2();
                long l2 = markersFragment.t().m2();
                double d2 = f2;
                double d3 = l2;
                long l3 = (long)(d2 * d3);
                if (bl) {
                    Object object2;
                    block7 : {
                        List list2 = f.u.l.J((Iterable)list, }
                }
            }
        }
    }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    