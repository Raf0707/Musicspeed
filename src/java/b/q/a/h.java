/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.AnimatorSet$Builder
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.IBinder
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityManager
 *  android.view.animation.LinearInterpolator
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.BaseAdapter
 *  android.widget.ImageButton
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.TextView
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.media2.common.MediaItem
 *  androidx.media2.common.MediaMetadata
 *  androidx.media2.common.SessionPlayer
 *  androidx.media2.common.SessionPlayer$TrackInfo
 *  androidx.media2.common.UriMediaItem
 *  androidx.media2.common.VideoSize
 *  androidx.media2.session.MediaController
 *  androidx.media2.session.SessionCommandGroup
 *  b.i.q.w
 *  b.q.a.a
 *  b.q.a.h$a
 *  b.q.a.h$a0
 *  b.q.a.h$b
 *  b.q.a.h$b0
 *  b.q.a.h$c
 *  b.q.a.h$c0
 *  b.q.a.h$d
 *  b.q.a.h$d0
 *  b.q.a.h$e
 *  b.q.a.h$e0
 *  b.q.a.h$f
 *  b.q.a.h$f0
 *  b.q.a.h$g
 *  b.q.a.h$g0$a
 *  b.q.a.h$h
 *  b.q.a.h$h0
 *  b.q.a.h$i
 *  b.q.a.h$i0
 *  b.q.a.h$j
 *  b.q.a.h$k
 *  b.q.a.h$l
 *  b.q.a.h$m
 *  b.q.a.h$n
 *  b.q.a.h$o
 *  b.q.a.h$p
 *  b.q.a.h$q
 *  b.q.a.h$r
 *  b.q.a.h$s
 *  b.q.a.h$t
 *  b.q.a.h$u
 *  b.q.a.h$v
 *  b.q.a.h$w
 *  b.q.a.h$x
 *  b.q.a.h$y
 *  b.q.a.h$z
 *  b.q.a.j
 *  b.q.a.l
 *  b.q.a.l$b
 *  b.q.a.m
 *  b.q.a.o
 *  b.q.a.p
 *  b.q.a.q
 *  b.q.a.r
 *  b.q.a.s
 *  b.q.a.y
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Formatter
 *  java.util.List
 *  java.util.Locale
 *  java.util.Objects
 *  java.util.concurrent.Executor
 */
package b.q.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.UriMediaItem;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.SessionCommandGroup;
import b.q.a.h;
import b.q.a.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis.
 */
public class h
extends b.q.a.j {
    static final boolean g;
    boolean A;
    int A0;
    boolean B;
    AnimatorSet B0;
    boolean C;
    AnimatorSet C0;
    boolean D;
    AnimatorSet D0;
    boolean E;
    AnimatorSet E0;
    boolean F;
    AnimatorSet F0;
    boolean G;
    ValueAnimator G0;
    boolean H;
    ValueAnimator H0;
    boolean I;
    final Runnable I0;
    private SparseArray<View> J;
    final Runnable J0;
    private View K;
    private final Runnable K0;
    private TextView L;
    Runnable L0;
    private View M;
    final Runnable M0;
    ViewGroup N;
    private final SeekBar.OnSeekBarChangeListener N0;
    private View O;
    private final View.OnClickListener O0;
    private View P;
    private final View.OnClickListener P0;
    private View Q;
    private final View.OnClickListener Q0;
    ViewGroup R;
    private final View.OnClickListener R0;
    ImageButton S;
    private final View.OnClickListener S0;
    private ViewGroup T;
    private final View.OnClickListener T0;
    SeekBar U;
    private final View.OnClickListener U0;
    private View V;
    private final View.OnClickListener V0;
    private ViewGroup W;
    private final View.OnClickListener W0;
    private final View.OnClickListener X0;
    private final AdapterView.OnItemClickListener Y0;
    private PopupWindow.OnDismissListener Z0;
    private View a0;
    private ViewGroup b0;
    private TextView c0;
    TextView d0;
    private TextView e0;
    private StringBuilder f0;
    private Formatter g0;
    private boolean h;
    ViewGroup h0;
    Resources i;
    ViewGroup i0;
    b.q.a.l j;
    ImageButton j0;
    f0 k;
    ImageButton k0;
    private AccessibilityManager l;
    private TextView l0;
    private int m;
    private ListView m0;
    private int n;
    private PopupWindow n0;
    private int o;
    h0 o0;
    private int p;
    i0 p0;
    int q;
    private List<String> q0;
    int r;
    List<String> r0;
    int s;
    private List<Integer> s0;
    int t;
    List<String> t0;
    int u;
    int u0;
    int v;
    List<SessionPlayer.TrackInfo> v0;
    long w;
    List<SessionPlayer.TrackInfo> w0;
    long x;
    List<String> x0;
    long y;
    List<String> y0;
    long z;
    List<Integer> z0;

    static {
        g = Log.isLoggable((String)"MediaControlView", (int)3);
    }

    public h(Context context) {
        this(context, null);
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.h = false;
        this.u = -1;
        this.J = new SparseArray();
        this.v0 = new ArrayList();
        this.w0 = new ArrayList();
        this.I0 = new e(this);
        this.J0 = new f(this);
        this.K0 = new g(this);
        this.L0 = new h(this);
        this.M0 = new i(this);
        this.N0 = new j(this);
        this.O0 = new l(this);
        this.P0 = new m(this);
        this.Q0 = new n(this);
        this.R0 = new o(this);
        this.S0 = new p(this);
        this.T0 = new q(this);
        this.U0 = new r(this);
        this.V0 = new s(this);
        this.W0 = new t(this);
        this.X0 = new u(this);
        this.Y0 = new w(this);
        this.Z0 = new x(this);
        this.i = context.getResources();
        ViewGroup.inflate((Context)context, (int)b.q.a.r.a, (ViewGroup)this);
        this.l();
        this.x = 2000L;
        this.l = (AccessibilityManager)context.getSystemService("accessibility");
    }

    private void B(int n2) {
        if (n2 != 0 && n2 != 1) {
            if (n2 == 2) {
                this.U.getThumb().setLevel(0);
            }
        } else {
            this.U.getThumb().setLevel(10000);
        }
        this.E(this.C);
    }

    private boolean i() {
        if (this.u0 > 0) {
            return true;
        }
        VideoSize videoSize = this.j.x();
        if (videoSize.e() > 0 && videoSize.f() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("video track count is zero, but it renders video. size: ");
            stringBuilder.append((Object)videoSize);
            Log.w((String)"MediaControlView", (String)stringBuilder.toString());
            return true;
        }
        return false;
    }

    private void j() {
        if (!this.w()) {
            if (this.v == 3) {
                return;
            }
            this.removeCallbacks(this.L0);
            this.removeCallbacks(this.M0);
            this.post(this.K0);
        }
    }

    static View k(Context context, int n2) {
        return ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(n2, null);
    }

    private void l() {
        AnimatorSet animatorSet;
        ValueAnimator valueAnimator;
        ImageButton imageButton;
        SeekBar seekBar;
        AnimatorSet animatorSet2;
        ValueAnimator valueAnimator2;
        ImageButton imageButton2;
        ImageButton imageButton3;
        AnimatorSet animatorSet3;
        PopupWindow popupWindow;
        AnimatorSet animatorSet4;
        AnimatorSet animatorSet5;
        this.K = this.findViewById(b.q.a.q.L);
        this.L = (TextView)this.findViewById(b.q.a.q.M);
        this.M = this.findViewById(b.q.a.q.a);
        this.N = (ViewGroup)this.findViewById(b.q.a.q.i);
        this.O = this.findViewById(b.q.a.q.j);
        this.P = this.m(b.q.a.q.l);
        this.Q = this.m(b.q.a.q.u);
        this.R = (ViewGroup)this.findViewById(b.q.a.q.t);
        this.S = imageButton3 = (ImageButton)this.findViewById(b.q.a.q.s);
        imageButton3.setOnClickListener(this.U0);
        this.T = (ViewGroup)this.findViewById(b.q.a.q.B);
        this.U = seekBar = (SeekBar)this.findViewById(b.q.a.q.A);
        seekBar.setOnSeekBarChangeListener(this.N0);
        this.U.setMax(1000);
        this.y = -1L;
        this.z = -1L;
        this.V = this.findViewById(b.q.a.q.g);
        this.W = (ViewGroup)this.findViewById(b.q.a.q.h);
        this.a0 = this.m(b.q.a.q.o);
        this.b0 = (ViewGroup)this.findViewById(b.q.a.q.H);
        this.c0 = (TextView)this.findViewById(b.q.a.q.J);
        this.d0 = (TextView)this.findViewById(b.q.a.q.I);
        this.e0 = (TextView)this.findViewById(b.q.a.q.c);
        this.f0 = new StringBuilder();
        this.g0 = new Formatter((Appendable)this.f0, Locale.getDefault());
        this.h0 = (ViewGroup)this.findViewById(b.q.a.q.f);
        this.i0 = (ViewGroup)this.findViewById(b.q.a.q.m);
        this.j0 = imageButton = (ImageButton)this.findViewById(b.q.a.q.F);
        imageButton.setOnClickListener(this.T0);
        this.k0 = imageButton2 = (ImageButton)this.findViewById(b.q.a.q.p);
        imageButton2.setOnClickListener(this.U0);
        ((ImageButton)this.findViewById(b.q.a.q.x)).setOnClickListener(this.V0);
        ((ImageButton)this.findViewById(b.q.a.q.w)).setOnClickListener(this.W0);
        ((ImageButton)this.findViewById(b.q.a.q.D)).setOnClickListener(this.X0);
        this.l0 = (TextView)this.findViewById(b.q.a.q.b);
        this.n();
        this.m0 = (ListView)h.k(this.getContext(), b.q.a.r.e);
        this.o0 = new /* Unavailable Anonymous Inner Class!! */;
        this.p0 = new /* Unavailable Anonymous Inner Class!! */;
        this.m0.setAdapter((ListAdapter)this.o0);
        this.m0.setChoiceMode(1);
        this.m0.setOnItemClickListener(this.Y0);
        this.J.append(0, (Object)this.P);
        this.J.append(1, (Object)this.a0);
        this.J.append(2, (Object)this.Q);
        this.m = this.i.getDimensionPixelSize(b.q.a.o.d);
        this.n = this.i.getDimensionPixelSize(b.q.a.o.e);
        this.o = this.i.getDimensionPixelSize(b.q.a.o.f);
        this.p = this.i.getDimensionPixelSize(b.q.a.o.g);
        this.n0 = popupWindow = new PopupWindow((View)this.m0, this.m, -2, true);
        popupWindow.setBackgroundDrawable((Drawable)new ColorDrawable());
        this.n0.setOnDismissListener(this.Z0);
        float f2 = this.i.getDimension(b.q.a.o.l);
        float f3 = this.i.getDimension(b.q.a.o.c);
        float f4 = this.i.getDimension(b.q.a.o.a);
        View[] arrview = new View[]{this.V, this.W, this.b0, this.h0, this.i0, this.T};
        ValueAnimator valueAnimator3 = ValueAnimator.ofFloat((float[])new float[]{1.0f, 0.0f});
        valueAnimator3.setInterpolator((TimeInterpolator)new LinearInterpolator());
        valueAnimator3.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new k(this));
        valueAnimator3.addListener((Animator.AnimatorListener)new v(this));
        ValueAnimator valueAnimator4 = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        valueAnimator4.setInterpolator((TimeInterpolator)new LinearInterpolator());
        valueAnimator4.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new y(this));
        valueAnimator4.addListener((Animator.AnimatorListener)new z(this));
        this.B0 = animatorSet = new AnimatorSet();
        AnimatorSet.Builder builder = animatorSet.play((Animator)valueAnimator3);
        float f5 = -f2;
        builder.with((Animator)b.q.a.a.a((float)0.0f, (float)f5, (View)this.K)).with((Animator)b.q.a.a.b((float)0.0f, (float)f4, (View[])arrview));
        this.B0.setDuration(250L);
        this.B0.addListener((Animator.AnimatorListener)new a0(this));
        float f6 = f3 + f4;
        this.C0 = animatorSet4 = b.q.a.a.b((float)f4, (float)f6, (View[])arrview);
        animatorSet4.setDuration(250L);
        this.C0.addListener((Animator.AnimatorListener)new b0(this));
        this.D0 = animatorSet2 = new AnimatorSet();
        animatorSet2.play((Animator)valueAnimator3).with((Animator)b.q.a.a.a((float)0.0f, (float)f5, (View)this.K)).with((Animator)b.q.a.a.b((float)0.0f, (float)f6, (View[])arrview));
        this.D0.setDuration(250L);
        this.D0.addListener((Animator.AnimatorListener)new c0(this));
        this.E0 = animatorSet5 = new AnimatorSet();
        animatorSet5.play((Animator)valueAnimator4).with((Animator)b.q.a.a.a((float)f5, (float)0.0f, (View)this.K)).with((Animator)b.q.a.a.b((float)f4, (float)0.0f, (View[])arrview));
        this.E0.setDuration(250L);
        this.E0.addListener((Animator.AnimatorListener)new d0(this));
        this.F0 = animatorSet3 = new AnimatorSet();
        animatorSet3.play((Animator)valueAnimator4).with((Animator)b.q.a.a.a((float)f5, (float)0.0f, (View)this.K)).with((Animator)b.q.a.a.b((float)f6, (float)0.0f, (View[])arrview));
        this.F0.setDuration(250L);
        this.F0.addListener((Animator.AnimatorListener)new e0(this));
        this.G0 = valueAnimator = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        valueAnimator.setDuration(250L);
        this.G0.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
        this.G0.addListener((Animator.AnimatorListener)new b(this));
        this.H0 = valueAnimator2 = ValueAnimator.ofFloat((float[])new float[]{1.0f, 0.0f});
        valueAnimator2.setDuration(250L);
        this.H0.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        this.H0.addListener((Animator.AnimatorListener)new d(this));
    }

    private View m(int n2) {
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        ImageButton imageButton4;
        View view = this.findViewById(n2);
        ImageButton imageButton5 = (ImageButton)view.findViewById(b.q.a.q.y);
        if (imageButton5 != null) {
            imageButton5.setOnClickListener(this.O0);
        }
        if ((imageButton3 = (ImageButton)view.findViewById(b.q.a.q.n)) != null) {
            imageButton3.setOnClickListener(this.Q0);
        }
        if ((imageButton2 = (ImageButton)view.findViewById(b.q.a.q.C)) != null) {
            imageButton2.setOnClickListener(this.P0);
        }
        if ((imageButton = (ImageButton)view.findViewById(b.q.a.q.v)) != null) {
            imageButton.setOnClickListener(this.R0);
        }
        if ((imageButton4 = (ImageButton)view.findViewById(b.q.a.q.z)) != null) {
            imageButton4.setOnClickListener(this.S0);
        }
        return view;
    }

    private void n() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        this.q0 = arrayList4 = new ArrayList();
        arrayList4.add((Object)this.i.getString(b.q.a.s.e));
        this.q0.add((Object)this.i.getString(b.q.a.s.h));
        this.r0 = arrayList3 = new ArrayList();
        Resources resources = this.i;
        int n2 = b.q.a.s.c;
        arrayList3.add((Object)resources.getString(n2));
        String string = this.i.getString(b.q.a.s.g);
        this.r0.add((Object)string);
        this.r0.add((Object)"");
        this.s0 = arrayList5 = new ArrayList();
        arrayList5.add((Object)b.q.a.p.a);
        this.s0.add((Object)b.q.a.p.h);
        this.x0 = arrayList = new ArrayList();
        arrayList.add((Object)this.i.getString(n2));
        this.y0 = arrayList2 = new ArrayList((Collection)Arrays.asList((Object[])this.i.getStringArray(b.q.a.m.a)));
        arrayList2.add(3, (Object)string);
        this.t = 3;
        this.z0 = new ArrayList();
        int[] arrn = this.i.getIntArray(b.q.a.m.b);
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            this.z0.add((Object)arrn[i2]);
        }
        this.A0 = -1;
    }

    private boolean o() {
        return !this.i() && this.v0.size() > 0;
    }

    private void q(View view, int n2, int n3) {
        view.layout(n2, n3, n2 + view.getMeasuredWidth(), n3 + view.getMeasuredHeight());
    }

    private void x() {
        if (this.v == 3) {
            return;
        }
        this.removeCallbacks(this.L0);
        this.removeCallbacks(this.M0);
        this.post(this.J0);
    }

    void A() {
        this.f();
        boolean bl = this.j.b();
        boolean bl2 = this.j.c();
        boolean bl3 = this.j.d();
        boolean bl4 = this.j.h();
        boolean bl5 = this.j.g();
        boolean bl6 = this.j.e();
        int n2 = this.J.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ImageButton imageButton;
            ImageButton imageButton2;
            ImageButton imageButton3;
            ImageButton imageButton4;
            int n3 = this.J.keyAt(i2);
            ImageButton imageButton5 = this.g(n3, b.q.a.q.y);
            int n4 = 8;
            if (imageButton5 != null) {
                int n5 = bl ? 0 : 8;
                imageButton5.setVisibility(n5);
            }
            if ((imageButton4 = this.g(n3, b.q.a.q.C)) != null) {
                int n6 = bl2 ? 0 : 8;
                imageButton4.setVisibility(n6);
            }
            if ((imageButton2 = this.g(n3, b.q.a.q.n)) != null) {
                int n7 = bl3 ? 0 : 8;
                imageButton2.setVisibility(n7);
            }
            if ((imageButton3 = this.g(n3, b.q.a.q.z)) != null) {
                int n8 = bl4 ? 0 : 8;
                imageButton3.setVisibility(n8);
            }
            if ((imageButton = this.g(n3, b.q.a.q.v)) == null) continue;
            if (bl5) {
                n4 = 0;
            }
            imageButton.setVisibility(n4);
        }
        this.E = bl6;
        this.U.setEnabled(bl6);
        this.G();
    }

    void C(int n2) {
        block7 : {
            ImageButton imageButton;
            Drawable drawable;
            String string;
            block5 : {
                block6 : {
                    block4 : {
                        imageButton = this.g(this.u, b.q.a.q.y);
                        if (imageButton == null) {
                            return;
                        }
                        if (n2 != 0) break block4;
                        drawable = b.i.h.a.e(this.getContext(), b.q.a.p.e);
                        string = this.i.getString(b.q.a.s.s);
                        break block5;
                    }
                    if (n2 != 1) break block6;
                    drawable = b.i.h.a.e(this.getContext(), b.q.a.p.f);
                    string = this.i.getString(b.q.a.s.t);
                    break block5;
                }
                if (n2 != 2) break block7;
                drawable = b.i.h.a.e(this.getContext(), b.q.a.p.g);
                string = this.i.getString(b.q.a.s.v);
            }
            imageButton.setImageDrawable(drawable);
            imageButton.setContentDescription((CharSequence)string);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unknown type ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    void D(int n2, int n3) {
        int n4 = this.J.size();
        for (int i2 = 0; i2 < n4; ++i2) {
            ImageButton imageButton;
            int n5 = this.J.keyAt(i2);
            ImageButton imageButton2 = this.g(n5, b.q.a.q.z);
            if (imageButton2 != null) {
                if (n2 > -1) {
                    imageButton2.setAlpha(1.0f);
                    imageButton2.setEnabled(true);
                } else {
                    imageButton2.setAlpha(0.5f);
                    imageButton2.setEnabled(false);
                }
            }
            if ((imageButton = this.g(n5, b.q.a.q.v)) == null) continue;
            if (n3 > -1) {
                imageButton.setAlpha(1.0f);
                imageButton.setEnabled(true);
                continue;
            }
            imageButton.setAlpha(0.5f);
            imageButton.setEnabled(false);
        }
    }

    void E(boolean bl) {
        ImageButton imageButton = this.g(this.u, b.q.a.q.n);
        if (bl) {
            this.C = true;
            this.C(2);
            if (imageButton != null) {
                imageButton.setAlpha(0.5f);
                imageButton.setEnabled(false);
                return;
            }
        } else {
            this.C = false;
            b.q.a.l l2 = this.j;
            if (l2 != null && l2.z()) {
                this.C(0);
            } else {
                this.C(1);
            }
            if (imageButton != null) {
                imageButton.setAlpha(1.0f);
                imageButton.setEnabled(true);
            }
        }
    }

    void F(int n2, String string) {
        this.t = n2;
        this.r0.set(1, (Object)string);
        this.p0.c(this.y0);
        this.p0.b(this.t);
    }

    void G() {
        if (!(!this.j.f() || this.u0 == 0 && this.v0.isEmpty() && this.w0.isEmpty())) {
            if (this.w0.isEmpty()) {
                if (this.o()) {
                    this.j0.setVisibility(8);
                    this.j0.setEnabled(false);
                    return;
                }
                this.j0.setVisibility(0);
                this.j0.setAlpha(0.5f);
                this.j0.setEnabled(false);
                return;
            }
            this.j0.setVisibility(0);
            this.j0.setAlpha(1.0f);
            this.j0.setEnabled(true);
            return;
        }
        this.j0.setVisibility(8);
        this.j0.setEnabled(false);
    }

    void H(MediaItem mediaItem) {
        if (mediaItem == null) {
            this.U.setProgress(0);
            TextView textView = this.d0;
            Resources resources = this.i;
            int n2 = b.q.a.s.l;
            textView.setText((CharSequence)resources.getString(n2));
            this.c0.setText((CharSequence)this.i.getString(n2));
            return;
        }
        this.f();
        long l2 = this.j.p();
        if (l2 > 0L) {
            this.w = l2;
            this.v();
        }
    }

    void I(MediaItem mediaItem) {
        CharSequence charSequence;
        if (mediaItem == null) {
            this.L.setText(null);
            return;
        }
        if (!this.o()) {
            CharSequence charSequence2 = this.j.v();
            if (charSequence2 == null) {
                charSequence2 = this.i.getString(b.q.a.s.r);
            }
            this.L.setText((CharSequence)charSequence2.toString());
            return;
        }
        CharSequence charSequence3 = this.j.v();
        if (charSequence3 == null) {
            charSequence3 = this.i.getString(b.q.a.s.q);
        }
        if ((charSequence = this.j.l()) == null) {
            charSequence = this.i.getString(b.q.a.s.p);
        }
        TextView textView = this.L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charSequence3.toString());
        stringBuilder.append(" - ");
        stringBuilder.append(charSequence.toString());
        textView.setText((CharSequence)stringBuilder.toString());
    }

    void J(b.q.a.l l2, List<SessionPlayer.TrackInfo> list) {
        this.u0 = 0;
        this.v0 = new ArrayList();
        this.w0 = new ArrayList();
        this.s = 0;
        this.r = -1;
        SessionPlayer.TrackInfo trackInfo = l2.u(2);
        SessionPlayer.TrackInfo trackInfo2 = l2.u(4);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            int n2 = ((SessionPlayer.TrackInfo)list.get(i2)).k();
            if (n2 == 1) {
                this.u0 = 1 + this.u0;
                continue;
            }
            if (n2 == 2) {
                if (((SessionPlayer.TrackInfo)list.get(i2)).equals((Object)trackInfo)) {
                    this.s = this.v0.size();
                }
                this.v0.add((Object)((SessionPlayer.TrackInfo)list.get(i2)));
                continue;
            }
            if (n2 != 4) continue;
            if (((SessionPlayer.TrackInfo)list.get(i2)).equals((Object)trackInfo2)) {
                this.r = this.w0.size();
            }
            this.w0.add((Object)((SessionPlayer.TrackInfo)list.get(i2)));
        }
        this.x0 = new ArrayList();
        if (this.v0.isEmpty()) {
            this.x0.add((Object)this.i.getString(b.q.a.s.c));
        } else {
            int n3 = 0;
            while (n3 < this.v0.size()) {
                List<String> list2 = this.x0;
                Resources resources = this.i;
                int n4 = b.q.a.s.d;
                Object[] arrobject = new Object[]{++n3};
                list2.add((Object)resources.getString(n4, arrobject));
            }
        }
        this.r0.set(0, (Object)((String)this.x0.get(this.s)));
        this.t0 = new ArrayList();
        if (!this.w0.isEmpty()) {
            this.t0.add((Object)this.i.getString(b.q.a.s.i));
            for (int i3 = 0; i3 < this.w0.size(); ++i3) {
                String string;
                String string2 = ((SessionPlayer.TrackInfo)this.w0.get(i3)).j().getISO3Language();
                if (string2.equals((Object)"und")) {
                    Resources resources = this.i;
                    int n5 = b.q.a.s.k;
                    Object[] arrobject = new Object[]{i3 + 1};
                    string = resources.getString(n5, arrobject);
                } else {
                    Resources resources = this.i;
                    int n6 = b.q.a.s.j;
                    Object[] arrobject = new Object[]{i3 + 1, string2};
                    string = resources.getString(n6, arrobject);
                }
                this.t0.add((Object)string);
            }
        }
        this.G();
    }

    void b(boolean bl) {
        super.b(bl);
        if (this.j == null) {
            return;
        }
        if (bl) {
            this.removeCallbacks(this.I0);
            this.post(this.I0);
            return;
        }
        this.removeCallbacks(this.I0);
    }

    void c(float f2) {
        int n2 = -1 * (int)(f2 * (float)this.i0.getWidth());
        this.i0.setTranslationX((float)n2);
        ViewGroup viewGroup = this.b0;
        float f3 = 1.0f - f2;
        viewGroup.setAlpha(f3);
        this.h0.setAlpha(f3);
        int n3 = -1 * (int)(f2 * (float)this.h(b.q.a.q.y).getLeft());
        this.a0.setTranslationX((float)n3);
        this.h(b.q.a.q.n).setAlpha(f3);
    }

    void d() {
        this.G = true;
        this.n0.dismiss();
    }

    void e(BaseAdapter baseAdapter) {
        this.m0.setAdapter((ListAdapter)baseAdapter);
        int n2 = this.u == 0 ? this.m : this.n;
        this.n0.setWidth(n2);
        int n3 = this.getHeight() - 2 * this.p;
        int n4 = baseAdapter.getCount() * this.o;
        if (n4 < n3) {
            n3 = n4;
        }
        this.n0.setHeight(n3);
        this.G = false;
        this.n0.dismiss();
        if (n3 > 0) {
            int n5 = this.getWidth() - this.n0.getWidth() - this.p;
            int n6 = -this.n0.getHeight() - this.p;
            this.n0.showAsDropDown((View)this, n5, n6);
            this.G = true;
        }
    }

    void f() {
        if (this.j != null) {
            return;
        }
        throw new IllegalStateException("mPlayer must not be null");
    }

    ImageButton g(int n2, int n3) {
        View view = (View)this.J.get(n2);
        if (view == null) {
            return null;
        }
        return (ImageButton)view.findViewById(n3);
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.media2.widget.MediaControlView";
    }

    long getLatestSeekPosition() {
        this.f();
        long l2 = this.z;
        if (l2 != -1L) {
            return l2;
        }
        long l3 = this.y;
        if (l3 != -1L) {
            return l3;
        }
        return this.j.o();
    }

    ImageButton h(int n2) {
        ImageButton imageButton = this.g(1, n2);
        if (imageButton != null) {
            return imageButton;
        }
        throw new IllegalArgumentException("Couldn't find a view that has the given id");
    }

    protected void onAttachedToWindow() {
        ViewGroup.super.onAttachedToWindow();
        b.q.a.l l2 = this.j;
        if (l2 != null) {
            l2.a();
        }
    }

    protected void onDetachedFromWindow() {
        ViewGroup.super.onDetachedFromWindow();
        b.q.a.l l2 = this.j;
        if (l2 != null) {
            l2.j();
        }
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        int n6 = n4 - n2 - this.getPaddingLeft() - this.getPaddingRight();
        int n7 = n5 - n3 - this.getPaddingTop() - this.getPaddingBottom();
        int n8 = this.W.getMeasuredWidth() + this.b0.getMeasuredWidth() + this.h0.getMeasuredWidth();
        int n9 = this.K.getMeasuredHeight() + this.T.getMeasuredHeight() + this.V.getMeasuredHeight();
        int n10 = this.b0.getMeasuredWidth() + this.h0.getMeasuredWidth();
        int n11 = this.K.getMeasuredHeight() + this.P.getMeasuredHeight() + this.T.getMeasuredHeight() + this.V.getMeasuredHeight();
        int n12 = !(this.F || n8 <= n6 && n9 <= n7) ? (n10 <= n6 && n11 <= n7 ? 0 : 2) : 1;
        if (this.u != n12) {
            this.u = n12;
            this.B(n12);
        }
        View view = this.K;
        int n13 = n12 != 2 ? 0 : 4;
        view.setVisibility(n13);
        View view2 = this.O;
        int n14 = n12 != 1 ? 0 : 4;
        view2.setVisibility(n14);
        View view3 = this.P;
        int n15 = n12 == 0 ? 0 : 4;
        view3.setVisibility(n15);
        View view4 = this.Q;
        int n16 = n12 == 2 ? 0 : 4;
        view4.setVisibility(n16);
        View view5 = this.V;
        int n17 = n12 != 2 ? 0 : 4;
        view5.setVisibility(n17);
        ViewGroup viewGroup = this.W;
        int n18 = n12 == 1 ? 0 : 4;
        viewGroup.setVisibility(n18);
        ViewGroup viewGroup2 = this.b0;
        int n19 = n12 != 2 ? 0 : 4;
        viewGroup2.setVisibility(n19);
        ViewGroup viewGroup3 = this.h0;
        int n20 = n12 != 2 ? 0 : 4;
        viewGroup3.setVisibility(n20);
        ImageButton imageButton = this.S;
        int n21 = n12 == 2 ? 0 : 4;
        imageButton.setVisibility(n21);
        int n22 = this.getPaddingLeft();
        int n23 = n6 + n22;
        int n24 = this.getPaddingTop();
        int n25 = n7 + n24;
        this.q(this.K, n22, n24);
        this.q((View)this.N, n22, n24);
        View view6 = this.V;
        this.q(view6, n22, n25 - view6.getMeasuredHeight());
        ViewGroup viewGroup4 = this.W;
        this.q((View)viewGroup4, n22, n25 - viewGroup4.getMeasuredHeight());
        ViewGroup viewGroup5 = this.b0;
        int n26 = n12 == 1 ? n23 - this.h0.getMeasuredWidth() - this.b0.getMeasuredWidth() : n22;
        this.q((View)viewGroup5, n26, n25 - this.b0.getMeasuredHeight());
        ViewGroup viewGroup6 = this.h0;
        this.q((View)viewGroup6, n23 - viewGroup6.getMeasuredWidth(), n25 - this.h0.getMeasuredHeight());
        ViewGroup viewGroup7 = this.i0;
        this.q((View)viewGroup7, n23, n25 - viewGroup7.getMeasuredHeight());
        ViewGroup viewGroup8 = this.T;
        int n27 = n12 == 2 ? n25 - viewGroup8.getMeasuredHeight() : n25 - viewGroup8.getMeasuredHeight() - this.i.getDimensionPixelSize(b.q.a.o.b);
        this.q((View)viewGroup8, n22, n27);
        ViewGroup viewGroup9 = this.R;
        this.q((View)viewGroup9, n22, n25 - viewGroup9.getMeasuredHeight());
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5;
        int n6 = ViewGroup.resolveSize((int)this.getSuggestedMinimumWidth(), (int)n2);
        int n7 = ViewGroup.resolveSize((int)this.getSuggestedMinimumHeight(), (int)n3);
        int n8 = n6 - this.getPaddingLeft() - this.getPaddingRight();
        int n9 = n7 - this.getPaddingTop() - this.getPaddingBottom();
        if (n8 < 0) {
            n5 = 16777216;
            n4 = 0;
        } else {
            n4 = n8;
            n5 = 0;
        }
        if (n9 < 0) {
            n5 |= 256;
            n9 = 0;
        }
        int n10 = this.getChildCount();
        for (int i2 = 0; i2 < n10; ++i2) {
            View view = this.getChildAt(i2);
            if (view.getVisibility() == 8) continue;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int n11 = layoutParams.width;
            int n12 = n11 == -1 ? View.MeasureSpec.makeMeasureSpec((int)n4, (int)1073741824) : (n11 == -2 ? View.MeasureSpec.makeMeasureSpec((int)n4, (int)0) : View.MeasureSpec.makeMeasureSpec((int)n11, (int)1073741824));
            int n13 = layoutParams.height;
            int n14 = n13 == -1 ? View.MeasureSpec.makeMeasureSpec((int)n9, (int)1073741824) : (n13 == -2 ? View.MeasureSpec.makeMeasureSpec((int)n9, (int)0) : View.MeasureSpec.makeMeasureSpec((int)n13, (int)1073741824));
            view.measure(n12, n14);
            n5 |= view.getMeasuredState();
        }
        this.setMeasuredDimension(ViewGroup.resolveSizeAndState((int)n6, (int)n2, (int)n5), ViewGroup.resolveSizeAndState((int)n7, (int)n3, (int)(n5 << 16)));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j == null) {
            return ViewGroup.super.onTouchEvent(motionEvent);
        }
        if (!(motionEvent.getAction() != 1 || this.o() && this.u == 1)) {
            if (this.v == 0) {
                this.j();
                return true;
            }
            this.x();
        }
        return true;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.j == null) {
            return ViewGroup.super.onTrackballEvent(motionEvent);
        }
        if (!(motionEvent.getAction() != 1 || this.o() && this.u == 1)) {
            if (this.v == 0) {
                this.j();
                return true;
            }
            this.x();
        }
        return true;
    }

    boolean p() {
        this.f();
        MediaItem mediaItem = this.j.n();
        if (!(mediaItem instanceof UriMediaItem)) {
            return false;
        }
        return b.q.a.y.a((Uri)((UriMediaItem)mediaItem).l());
    }

    void r(Runnable runnable, long l2) {
        if (l2 != -1L) {
            this.postDelayed(runnable, l2);
        }
    }

    void s() {
        this.z0.remove(this.A0);
        this.y0.remove(this.A0);
        this.A0 = -1;
    }

    void setAttachedToVideoView(boolean bl) {
        this.h = bl;
    }

    void setDelayedAnimationInterval(long l2) {
        this.x = l2;
    }

    public void setMediaController(MediaController mediaController) {
        Objects.requireNonNull((Object)mediaController, (String)"controller must not be null");
        if (!this.h) {
            this.setMediaControllerInternal(mediaController);
            return;
        }
        throw new IllegalStateException("It's attached to VideoView. Use VideoView's method.");
    }

    void setMediaControllerInternal(MediaController mediaController) {
        b.q.a.l l2 = this.j;
        if (l2 != null) {
            l2.j();
        }
        this.j = new b.q.a.l(mediaController, b.i.h.a.f(this.getContext()), (l.b)new g0());
        if (b.i.q.w.V((View)this)) {
            this.j.a();
        }
    }

    public void setOnFullScreenListener(f0 f02) {
        if (f02 == null) {
            this.k = null;
            this.k0.setVisibility(8);
            return;
        }
        this.k = f02;
        this.k0.setVisibility(0);
    }

    public void setPlayer(SessionPlayer sessionPlayer) {
        Objects.requireNonNull((Object)sessionPlayer, (String)"player must not be null");
        if (!this.h) {
            this.setPlayerInternal(sessionPlayer);
            return;
        }
        throw new IllegalStateException("It's attached to VideoView. Use VideoView's method.");
    }

    void setPlayerInternal(SessionPlayer sessionPlayer) {
        b.q.a.l l2 = this.j;
        if (l2 != null) {
            l2.j();
        }
        this.j = new b.q.a.l(sessionPlayer, b.i.h.a.f(this.getContext()), (l.b)new g0());
        if (b.i.q.w.V((View)this)) {
            this.j.a();
        }
    }

    void t() {
        this.removeCallbacks(this.L0);
        this.removeCallbacks(this.M0);
        this.r(this.L0, this.x);
    }

    void u(long l2, boolean bl) {
        this.f();
        long l3 = this.w;
        int n2 = l3 <= 0L ? 0 : (int)(1000L * l2 / l3);
        this.U.setProgress(n2);
        this.d0.setText((CharSequence)this.y(l2));
        if (this.y == -1L) {
            this.y = l2;
            if (bl) {
                this.j.D(l2);
                return;
            }
        } else {
            this.z = l2;
        }
    }

    long v() {
        TextView textView;
        TextView textView2;
        long l2;
        this.f();
        long l3 = this.j.o();
        long l4 = this.w;
        if (l3 > l4) {
            l3 = l4;
        }
        int n2 = l4 > (l2 = 0L) ? (int)(l3 * 1000L / l4) : 0;
        SeekBar seekBar = this.U;
        if (seekBar != null && l3 != l4) {
            seekBar.setProgress(n2);
            if (this.j.m() < l2) {
                this.U.setSecondaryProgress(1000);
            } else {
                this.U.setSecondaryProgress(10 * (int)this.j.m());
            }
        }
        if ((textView = this.c0) != null) {
            textView.setText((CharSequence)this.y(this.w));
        }
        if ((textView2 = this.d0) != null) {
            textView2.setText((CharSequence)this.y(l3));
        }
        if (this.F) {
            TextView textView3 = this.e0;
            if (textView3 != null) {
                if (l3 <= 5000L) {
                    if (textView3.getVisibility() == 8) {
                        this.e0.setVisibility(0);
                    }
                    Resources resources = this.i;
                    int n3 = b.q.a.s.b;
                    Object[] arrobject = new Object[]{1L + (5000L - l3) / 1000L};
                    String string = resources.getString(n3, arrobject);
                    this.e0.setText((CharSequence)string);
                } else if (textView3.getVisibility() == 0) {
                    this.e0.setVisibility(8);
                    int n4 = b.q.a.q.v;
                    this.h(n4).setEnabled(true);
                    this.h(n4).clearColorFilter();
                }
            }
            if (this.l0 != null) {
                long l5 = this.w;
                if (l5 - l3 >= l2) {
                    l2 = l5 - l3;
                }
                Resources resources = this.i;
                int n5 = b.q.a.s.a;
                Object[] arrobject = new Object[]{this.y(l2)};
                String string = resources.getString(n5, arrobject);
                this.l0.setText((CharSequence)string);
            }
        }
        return l3;
    }

    boolean w() {
        boolean bl = this.o();
        int n2 = 1;
        if (!(bl && this.u == n2 || this.l.isTouchExplorationEnabled() || this.j.s() == 3)) {
            if (this.j.s() == 0) {
                return n2;
            }
            n2 = 0;
        }
        return n2;
    }

    String y(long l2) {
        long l3 = l2 / 1000L;
        long l4 = l3 % 60L;
        long l5 = l3 / 60L % 60L;
        long l6 = l3 / 3600L;
        this.f0.setLength(0);
        if (l6 > 0L) {
            Formatter formatter = this.g0;
            Object[] arrobject = new Object[]{l6, l5, l4};
            return formatter.format("%d:%02d:%02d", arrobject).toString();
        }
        Formatter formatter = this.g0;
        Object[] arrobject = new Object[]{l5, l4};
        return formatter.format("%02d:%02d", arrobject).toString();
    }

    void z() {
        this.f();
        if (this.j.z()) {
            this.j.B();
            this.C(1);
            return;
        }
        if (this.C) {
            this.j.D(0L);
        }
        this.j.C();
        this.C(0);
    }

    class g0
    extends l.b {
        g0() {
        }

        public void a(b.q.a.l l2, SessionCommandGroup sessionCommandGroup) {
            h h2 = h.this;
            if (l2 != h2.j) {
                return;
            }
            h2.A();
        }

        public void b(b.q.a.l l2, MediaItem mediaItem) {
            if (l2 != h.this.j) {
                return;
            }
            if (h.g) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onCurrentMediaItemChanged(): ");
                stringBuilder.append((Object)mediaItem);
                Log.d((String)"MediaControlView", (String)stringBuilder.toString());
            }
            h.this.H(mediaItem);
            h.this.I(mediaItem);
            h.this.D(l2.t(), l2.q());
        }

        public void c(b.q.a.l l2) {
            if (l2 != h.this.j) {
                return;
            }
            if (h.g) {
                Log.d((String)"MediaControlView", (String)"onPlaybackCompleted()");
            }
            h.this.E(true);
            h.this.U.setProgress(1000);
            h h2 = h.this;
            h2.d0.setText((CharSequence)h2.y(h2.w));
        }

        public void d(b.q.a.l l2, float f2) {
            int n2;
            if (l2 != h.this.j) {
                return;
            }
            int n3 = Math.round((float)(f2 * 100.0f));
            h h2 = h.this;
            if (h2.A0 != -1) {
                h2.s();
            }
            boolean bl = h.this.z0.contains((Object)n3);
            if (bl) {
                for (n2 = 0; n2 < h.this.z0.size(); ++n2) {
                    if (n3 != (Integer)h.this.z0.get(n2)) continue;
                    h h3 = h.this;
                    h3.F(n2, (String)h3.y0.get(n2));
                    return;
                }
            } else {
                Resources resources = h.this.i;
                int n4 = b.q.a.s.f;
                Object[] arrobject = new Object[]{Float.valueOf((float)((float)n3 / 100.0f))};
                String string = resources.getString(n4, arrobject);
                while (n2 < h.this.z0.size()) {
                    if (n3 < (Integer)h.this.z0.get(n2)) {
                        h.this.z0.add(n2, (Object)n3);
                        h.this.y0.add(n2, (Object)string);
                        h.this.F(n2, string);
                        break;
                    }
                    if (n2 == h.this.z0.size() - 1 && n3 > (Integer)h.this.z0.get(n2)) {
                        h.this.z0.add((Object)n3);
                        h.this.y0.add((Object)string);
                        h.this.F(n2 + 1, string);
                    }
                    ++n2;
                }
                h h4 = h.this;
                h4.A0 = h4.t;
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public void e(b.q.a.l l2, int n2) {
            if (l2 != h.this.j) {
                return;
            }
            if (h.g) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onPlayerStateChanged(state: ");
                stringBuilder.append(n2);
                stringBuilder.append(")");
                Log.d((String)"MediaControlView", (String)stringBuilder.toString());
            }
            h.this.H(l2.n());
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return;
                    }
                    h.this.C(1);
                    h h2 = h.this;
                    h2.removeCallbacks(h2.I0);
                    if (h.this.getWindowToken() == null) return;
                    new d.a(h.this.getContext()).g(b.q.a.s.u).o(b.q.a.s.o, (DialogInterface.OnClickListener)new a(this)).d(true).v();
                    return;
                }
                h h3 = h.this;
                h3.removeCallbacks(h3.I0);
                h h4 = h.this;
                h4.post(h4.I0);
                h.this.t();
                h.this.E(false);
                return;
            }
            h.this.C(1);
            h h5 = h.this;
            h5.removeCallbacks(h5.I0);
            h h6 = h.this;
            h6.removeCallbacks(h6.L0);
            h h7 = h.this;
            h7.removeCallbacks(h7.M0);
            h h8 = h.this;
            h8.post(h8.J0);
        }

        void f(b.q.a.l l2, List<MediaItem> list, MediaMetadata mediaMetadata) {
            if (l2 != h.this.j) {
                return;
            }
            if (h.g) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onPlaylistChanged(): list: ");
                stringBuilder.append(list);
                stringBuilder.append(", metadata: ");
                stringBuilder.append((Object)mediaMetadata);
                Log.d((String)"MediaControlView", (String)stringBuilder.toString());
            }
            h.this.D(l2.t(), l2.q());
        }

        public void g(b.q.a.l l2, long l3) {
            if (l2 != h.this.j) {
                return;
            }
            if (h.g) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onSeekCompleted(): ");
                stringBuilder.append(l3);
                Log.d((String)"MediaControlView", (String)stringBuilder.toString());
            }
            h h2 = h.this;
            long l4 = h2.w;
            int n2 = l4 <= 0L ? 0 : (int)(1000L * l3 / l4);
            h2.U.setProgress(n2);
            h h3 = h.this;
            h3.d0.setText((CharSequence)h3.y(l3));
            h h4 = h.this;
            long l5 = h4.z;
            if (l5 != -1L) {
                h4.y = l5;
                l2.D(l5);
                h.this.z = -1L;
                return;
            }
            h4.y = -1L;
            if (!h4.A) {
                h4.removeCallbacks(h4.I0);
                h h5 = h.this;
                h5.removeCallbacks(h5.L0);
                h h6 = h.this;
                h6.post(h6.I0);
                h h7 = h.this;
                h7.r(h7.L0, h7.x);
            }
        }

        void i(b.q.a.l l2, SessionPlayer.TrackInfo trackInfo) {
            if (l2 != h.this.j) {
                return;
            }
            if (h.g) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onTrackDeselected(): ");
                stringBuilder.append((Object)trackInfo);
                Log.d((String)"MediaControlView", (String)stringBuilder.toString());
            }
            if (trackInfo.k() == 4) {
                for (int i2 = 0; i2 < h.this.w0.size(); ++i2) {
                    if (!((SessionPlayer.TrackInfo)h.this.w0.get(i2)).equals((Object)trackInfo)) continue;
                    h h2 = h.this;
                    h2.r = -1;
                    if (h2.q == 2) {
                        h2.p0.b(-1 + 1);
                    }
                    h h3 = h.this;
                    h3.j0.setImageDrawable(b.i.h.a.e(h3.getContext(), b.q.a.p.i));
                    h h4 = h.this;
                    h4.j0.setContentDescription((CharSequence)h4.i.getString(b.q.a.s.m));
                    return;
                }
            }
        }

        void j(b.q.a.l l2, SessionPlayer.TrackInfo trackInfo) {
            block6 : {
                block5 : {
                    if (l2 != h.this.j) {
                        return;
                    }
                    if (h.g) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("onTrackSelected(): ");
                        stringBuilder.append((Object)trackInfo);
                        Log.d((String)"MediaControlView", (String)stringBuilder.toString());
                    }
                    int n2 = trackInfo.k();
                    if (n2 != 4) break block5;
                    for (int i2 = 0; i2 < h.this.w0.size(); ++i2) {
                        if (!((SessionPlayer.TrackInfo)h.this.w0.get(i2)).equals((Object)trackInfo)) continue;
                        h h2 = h.this;
                        h2.r = i2;
                        if (h2.q == 2) {
                            h2.p0.b(i2 + 1);
                        }
                        h h3 = h.this;
                        h3.j0.setImageDrawable(b.i.h.a.e(h3.getContext(), b.q.a.p.j));
                        h h4 = h.this;
                        h4.j0.setContentDescription((CharSequence)h4.i.getString(b.q.a.s.n));
                        return;
                    }
                    break block6;
                }
                if (trackInfo.k() != 2) break block6;
                for (int i3 = 0; i3 < h.this.v0.size(); ++i3) {
                    if (!((SessionPlayer.TrackInfo)h.this.v0.get(i3)).equals((Object)trackInfo)) continue;
                    h h5 = h.this;
                    h5.s = i3;
                    h5.r0.set(0, (Object)h5.p0.a(i3));
                    return;
                }
            }
        }

        void k(b.q.a.l l2, List<SessionPlayer.TrackInfo> list) {
            if (l2 != h.this.j) {
                return;
            }
            if (h.g) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onTrackInfoChanged(): ");
                stringBuilder.append(list);
                Log.d((String)"MediaControlView", (String)stringBuilder.toString());
            }
            h.this.J(l2, list);
            h.this.H(l2.n());
            h.this.I(l2.n());
        }

        void l(b.q.a.l l2, VideoSize videoSize) {
            List list;
            if (l2 != h.this.j) {
                return;
            }
            if (h.g) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onVideoSizeChanged(): ");
                stringBuilder.append((Object)videoSize);
                Log.d((String)"MediaControlView", (String)stringBuilder.toString());
            }
            if (h.this.u0 == 0 && videoSize.e() > 0 && videoSize.f() > 0 && (list = l2.w()) != null) {
                h.this.J(l2, (List<SessionPlayer.TrackInfo>)list);
            }
        }
    }

}

