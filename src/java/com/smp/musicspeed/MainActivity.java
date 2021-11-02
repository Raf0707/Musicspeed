/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.LayoutTransition
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Typeface
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.TransitionDrawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Process
 *  android.os.SystemClock
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewPropertyAnimator
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.view.Window
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.ScrollView
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.TextView
 *  android.widget.Toast
 *  android.widget.ViewFlipper
 *  androidx.activity.ComponentActivity
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.appcompat.app.e
 *  androidx.appcompat.widget.AppCompatSeekBar
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.Toolbar$f
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.core.widget.ContentLoadingProgressBar
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  androidx.fragment.app.s
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.e0
 *  androidx.lifecycle.h0
 *  androidx.lifecycle.j0
 *  androidx.lifecycle.p
 *  androidx.lifecycle.w
 *  androidx.lifecycle.x
 *  androidx.preference.j
 *  b.i.h.a
 *  b.i.h.d.f
 *  b.i.q.i
 *  b.o.a.a
 *  b.o.a.a$a
 *  b.o.b.b
 *  c.d.a.a.m.a
 *  c.d.a.a.m.d
 *  c.d.a.a.m.f.d
 *  c.d.a.a.m.f.f
 *  com.github.stkent.amplify.prompt.BasePromptViewConfig
 *  com.github.stkent.amplify.prompt.BasePromptViewConfig$b
 *  com.github.stkent.amplify.prompt.DefaultLayoutPromptView
 *  com.github.stkent.amplify.prompt.i.b
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$f
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  com.google.android.material.snackbar.Snackbar
 *  com.smp.musicspeed.i0.m
 *  com.smp.musicspeed.k0.h0.j
 *  com.smp.musicspeed.k0.h0.k
 *  com.smp.musicspeed.k0.p0.i
 *  com.smp.musicspeed.recorder.t
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.m
 */
package com.smp.musicspeed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import b.o.a.a;
import com.github.stkent.amplify.prompt.BasePromptViewConfig;
import com.github.stkent.amplify.prompt.DefaultLayoutPromptView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.michaelflisar.gdprdialog.GDPRNetwork;
import com.michaelflisar.gdprdialog.GDPRSetup;
import com.michaelflisar.gdprdialog.c;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.about.AboutActivity;
import com.smp.musicspeed.about.HelpActivity;
import com.smp.musicspeed.ads.AdsProvider;
import com.smp.musicspeed.ads.u;
import com.smp.musicspeed.b0;
import com.smp.musicspeed.bpmkey.c;
import com.smp.musicspeed.bpmkey.f;
import com.smp.musicspeed.dbrecord.BeatStartRecord;
import com.smp.musicspeed.dbrecord.MarkerItem;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.dbrecord.WaveformRecord;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.equalizer.EqualizerFragment;
import com.smp.musicspeed.equalizer.EqualizerModel;
import com.smp.musicspeed.filewriter.FileWriterService;
import com.smp.musicspeed.filewriter.i;
import com.smp.musicspeed.i0.l;
import com.smp.musicspeed.i0.m;
import com.smp.musicspeed.importfile.g;
import com.smp.musicspeed.importfile.h;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.k0.e0;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.h0.j;
import com.smp.musicspeed.k0.h0.k;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.p0.i;
import com.smp.musicspeed.library.album.Album;
import com.smp.musicspeed.library.playlists.Playlist;
import com.smp.musicspeed.markers.g0;
import com.smp.musicspeed.markers.h0;
import com.smp.musicspeed.markers.k0;
import com.smp.musicspeed.player.PlayFileService;
import com.smp.musicspeed.playingqueue.PlayingQueue;
import com.smp.musicspeed.playingqueue.a0;
import com.smp.musicspeed.recorder.t;
import com.smp.musicspeed.reverse.ReverseService;
import com.smp.musicspeed.reverse.b;
import com.smp.musicspeed.settings.SettingsActivity;
import com.smp.musicspeed.sleep_timer.SleepTimerActivity;
import com.smp.musicspeed.test.TestService;
import com.smp.musicspeed.u;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.CustomTypefaceSpan;
import com.smp.musicspeed.v;
import com.smp.musicspeed.w;
import com.smp.musicspeed.waveform.MscHorizontalScrollView;
import com.smp.musicspeed.waveform.WaveformLoader;
import com.smp.musicspeed.x;
import com.smp.musicspeed.y;
import com.smp.musicspeed.z;
import com.wnafee.vector.compat.AnimatedVectorDrawable;
import j.a.a.a.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.greenrobot.eventbus.ThreadMode;
import rm.com.audiowave.AudioWaveView;

public class MainActivity
extends androidx.appcompat.app.e
implements l.b,
b.c,
h.c,
i.a,
SharedPreferences.OnSharedPreferenceChangeListener,
m.a,
c.d,
f.d,
a.a<WaveformRecord>,
c.c {
    private static float A = 0.25f;
    private static float B = 1.0f;
    private static float C = 1.0f;
    private static float D = 0.0f;
    private static boolean E = false;
    public static boolean F = false;
    private static int G = 333;
    private static int H = 999;
    public static com.michaelflisar.gdprdialog.i[] I;
    public static boolean J = false;
    private static float x = 12.0f;
    private static float y = -12.0f;
    private static float z = 0.75f;
    private View A0;
    Handler A1 = new Handler();
    private ImageButton B0;
    private Runnable B1 = new Runnable(this){
        final /* synthetic */ MainActivity f;
        {
            this.f = mainActivity;
        }

        public void run() {
            try {
                MainActivity mainActivity = this.f;
                mainActivity.unbindService(MainActivity.p1(mainActivity));
                MainActivity.J = false;
            }
            catch (Exception exception) {}
        }
    };
    private ViewGroup C0;
    private s C1 = new Runnable(){
        private int f;
        private List<MediaTrack> g;
        private boolean h;

        public void a(List<MediaTrack> list, int n2, boolean bl) {
            this.g = list;
            this.f = n2;
            this.h = bl;
        }

        public void run() {
            if (MainActivity.this.h0 == null) {
                return;
            }
            boolean bl = true ^ MainActivity.this.h0.F();
            if (MainActivity.this.f4(((MediaTrack)this.g.get(this.f)).getLocation())) {
                PlayingQueue.getDefault().newQueueFromMediaTrackList((Context)MainActivity.this, this.g, this.f);
                MainActivity.this.R1();
                MainActivity.this.V3();
                MainActivity.this.h0.j0();
                if (this.h) {
                    MainActivity.this.h0.Y();
                }
                MainActivity.this.O3();
                MainActivity.this.Y3();
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.Q3(mainActivity.getResources().getString(2131821317));
            MainActivity.this.Y3();
            if (bl) {
                MainActivity.this.onPlay(null);
                MainActivity.this.v2();
            }
        }
    };
    private ViewGroup D0;
    public com.smp.musicspeed.n0.e D1;
    private ViewGroup E0;
    private Snackbar E1;
    private ViewGroup F0;
    private Runnable F1 = new Runnable(this){
        final /* synthetic */ MainActivity f;
        {
            this.f = mainActivity;
        }

        public void run() {
            MainActivity.E0(this.f, false);
        }
    };
    private TextView G0;
    private long G1;
    private TextView H0;
    private TextView I0;
    private TextView J0;
    private int K;
    private TextView K0;
    private volatile boolean L = false;
    private TextView L0;
    private int M;
    private TextView M0;
    private int N;
    private TextView N0;
    private int O;
    private AudioWaveView O0;
    private ImageButton P;
    private Drawable P0;
    private ImageButton Q;
    private Drawable Q0;
    private ImageButton R;
    private View R0;
    private ImageButton S;
    private View S0;
    private Toolbar T;
    private View T0;
    private View U;
    private ViewFlipper U0;
    private ConstraintLayout V;
    private BottomSheetBehavior V0;
    private AppCompatSeekBar W;
    private MscHorizontalScrollView W0;
    private AppCompatSeekBar X;
    private ViewTreeObserver.OnScrollChangedListener X0;
    private AppCompatSeekBar Y;
    private int Y0;
    private AppCompatSeekBar Z;
    private ContentLoadingProgressBar Z0;
    private TextView a0;
    private ContentLoadingProgressBar a1;
    private TextView b0;
    private ContentLoadingProgressBar b1;
    private TextView c0;
    private ContentLoadingProgressBar c1;
    private TextView d0;
    private ContentLoadingProgressBar d1;
    private TextView e0;
    private ViewGroup e1;
    private TextView f0;
    private final int f1 = 750;
    private View g0;
    private g0 g1;
    private PlayFileService h0;
    private ScrollView h1;
    private t i0;
    private View i1;
    private ImageButton j0;
    private TextView j1;
    private FloatingActionButton k0;
    private com.smp.musicspeed.ads.p k1;
    private ImageButton l0;
    private boolean l1 = true;
    private ImageButton m0;
    j.a.a.a.f m1;
    private ImageButton n0;
    j.a.a.a.f n1;
    private ImageButton o0;
    private boolean o1 = false;
    private ImageButton p0;
    private Runnable p1 = new Runnable(this){
        final /* synthetic */ MainActivity f;
        {
            this.f = mainActivity;
        }

        public void run() {
            if (MainActivity.p0(this.f) || MainActivity.r0(this.f)) {
                if (MainActivity.t0(this.f) != MainActivity.w0()) {
                    MainActivity mainActivity = this.f;
                    mainActivity.r1 = 1.33 * mainActivity.r1;
                }
                MainActivity mainActivity = this.f;
                MainActivity.x0(mainActivity, mainActivity.r1, MainActivity.r0(mainActivity));
                MainActivity.z0(this.f).postDelayed(MainActivity.y0(this.f), (long)MainActivity.t0(this.f));
                if (MainActivity.t0(this.f) > MainActivity.w0()) {
                    MainActivity.v0(this.f, 333);
                }
            }
        }
    };
    private ImageButton q0;
    private int q1;
    private ImageButton r0;
    double r1;
    private ImageButton s0;
    private boolean s1;
    private ImageButton t0;
    private boolean t1;
    private ImageButton u0;
    View.OnTouchListener u1 = new View.OnTouchListener(this){
        final /* synthetic */ MainActivity f;
        {
            this.f = mainActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean bl = view == MainActivity.A0(this.f);
            int n2 = motionEvent.getAction();
            if (n2 != 0) {
                if (n2 != 1 && n2 != 3) {
                    return false;
                }
                MainActivity.D0(this.f).removeCallbacks(MainActivity.y0(this.f));
                MainActivity.D0(this.f).postDelayed(MainActivity.C0(this.f), 750L);
                if (bl) {
                    MainActivity.s0(this.f, false);
                    return false;
                }
                MainActivity.q0(this.f, false);
                return false;
            }
            MainActivity.D0(this.f).removeCallbacks(MainActivity.C0(this.f));
            MainActivity.E0(this.f, true);
            MainActivity mainActivity = this.f;
            mainActivity.r1 = 3.0;
            MainActivity.u0(mainActivity, MainActivity.F0());
            if (bl) {
                MainActivity.s0(this.f, true);
            } else {
                MainActivity.q0(this.f, true);
            }
            MainActivity mainActivity2 = this.f;
            MainActivity.x0(mainActivity2, com.smp.musicspeed.utils.t.s((Context)mainActivity2), bl);
            MainActivity.D0(this.f).postDelayed(MainActivity.y0(this.f), (long)MainActivity.t0(this.f));
            return false;
        }
    };
    private LinearLayout v0;
    private GDPRSetup v1;
    private com.smp.musicspeed.ads.l w0;
    private Runnable w1 = new com.smp.musicspeed.m(this);
    private Intent x0;
    private Runnable x1 = new Runnable(this){
        final /* synthetic */ MainActivity f;
        {
            this.f = mainActivity;
        }

        public void run() {
            if (!com.smp.musicspeed.utils.k.D((Context)this.f) || MainActivity.T0(this.f).Y() == 4) {
                org.greenrobot.eventbus.c.d().m((Object)new a0());
            }
        }
    };
    private View y0;
    private ServiceConnection y1 = new ServiceConnection(this){
        final /* synthetic */ MainActivity a;
        {
            this.a = mainActivity;
        }

        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            MainActivity.J = true;
            com.smp.musicspeed.player.PlayFileService$e e2 = iBinder;
            MainActivity.J0(this.a, e2.a());
            e2.b(new com.smp.musicspeed.player.l(this){
                final /* synthetic */ o a;
                {
                    this.a = o2;
                }

                private /* synthetic */ void g() {
                    MainActivity.d1(this.a.a);
                }

                private /* synthetic */ void i() {
                    MainActivity.e1(this.a.a);
                }

                public void a(double d2, long l2) {
                    if (MainActivity.U0(this.a.a)) {
                        return;
                    }
                    MainActivity.V0(this.a.a, d2, l2);
                }

                public void b(double d2, long l2) {
                    MainActivity.D0(this.a.a).removeCallbacks(MainActivity.C0(this.a.a));
                    MainActivity.E0(this.a.a, false);
                    this.a(d2, l2);
                    MainActivity.E0(this.a.a, true);
                    MainActivity.D0(this.a.a).postDelayed(MainActivity.C0(this.a.a), 750L);
                }

                public void c() {
                    MainActivity.d1(this.a.a);
                    MainActivity.e1(this.a.a);
                }

                public void d() {
                    MainActivity.f1(this.a.a);
                }

                public void e() {
                    MainActivity.D0(this.a.a).post((Runnable)new com.smp.musicspeed.d(this));
                    MainActivity.W0(this.a.a).post((Runnable)new com.smp.musicspeed.c(this));
                }

                public void f() {
                    if (MainActivity.X0(this.a.a).e()) {
                        this.a.a.K1();
                    }
                    MainActivity.Y0(this.a.a);
                    MainActivity.Z0(this.a.a);
                    if (MainActivity.X0(this.a.a).getVisibility() == 0) {
                        MainActivity.a1(this.a.a);
                    }
                    MainActivity.b1(this.a.a);
                    MainActivity mainActivity = this.a.a;
                    mainActivity.A1.removeCallbacks(MainActivity.c1(mainActivity));
                    MainActivity mainActivity2 = this.a.a;
                    mainActivity2.A1.postDelayed(MainActivity.c1(mainActivity2), 500L);
                }

                public /* synthetic */ void h() {
                    this.g();
                }

                public /* synthetic */ void j() {
                    this.i();
                }
            });
            MainActivity.g1(this.a);
            if (this.a.getIntent() != null && MainActivity.i1() && !com.smp.musicspeed.utils.t.C((Context)this.a, com.smp.musicspeed.importfile.HardPathService.class)) {
                if (this.a.getIntent().getAction() != "android.intent.action.VIEW" && this.a.getIntent().getAction() != "android.intent.action.SEND") {
                    if (this.a.getIntent().getAction() == "com.smp.musicpseed.add_to_playingqueue_action") {
                        MainActivity mainActivity = this.a;
                        b0.e(mainActivity, mainActivity.getIntent());
                    }
                } else {
                    MainActivity mainActivity = this.a;
                    b0.f(mainActivity, mainActivity.getIntent());
                }
                MainActivity.j1(false);
            }
            MainActivity.k1(this.a);
        }

        public void onServiceDisconnected(android.content.ComponentName componentName) {
            try {
                throw new IllegalStateException("Service disconnected");
            }
            catch (IllegalStateException illegalStateException) {
                return;
            }
        }
    };
    private View z0;
    private Runnable z1 = new Runnable(this){
        final /* synthetic */ MainActivity f;
        {
            this.f = mainActivity;
        }

        public void run() {
            MainActivity.o1((MainActivity)this.f).getLayoutParams().width = 0;
        }
    };

    static {
        D = 1.0f + 1.0f;
        com.michaelflisar.gdprdialog.i[] arri = new com.michaelflisar.gdprdialog.i[]{com.michaelflisar.gdprdialog.i.g, com.michaelflisar.gdprdialog.i.i};
        I = arri;
    }

    static /* synthetic */ ImageButton A0(MainActivity mainActivity) {
        return mainActivity.Q;
    }

    private void A1(View view, float f2) {
        view.setRotation(f2 * 180.0f);
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    private void A2() {
        Menu menu = this.T.getMenu();
        if (com.smp.musicspeed.utils.k.E((Context)this)) {
            menu.findItem(2131296355).setVisible(true);
            if (com.smp.musicspeed.utils.k.D((Context)this)) {
                menu.setGroupVisible(2131296994, false);
                menu.setGroupVisible(2131296995, false);
                menu.setGroupVisible(2131296996, false);
                menu.setGroupVisible(2131296997, true);
                menu.setGroupVisible(2131296998, true);
            } else {
                menu.setGroupVisible(2131296994, true);
                menu.setGroupVisible(2131296995, true);
                menu.setGroupVisible(2131296996, true);
                menu.setGroupVisible(2131296997, true);
                menu.setGroupVisible(2131296998, false);
                this.P3();
            }
            menu.setGroupVisible(2131296583, false);
            return;
        }
        menu.findItem(2131296355).setVisible(false);
        menu.setGroupVisible(2131296994, false);
        menu.setGroupVisible(2131296995, false);
        menu.setGroupVisible(2131296996, false);
        menu.setGroupVisible(2131296997, false);
        menu.setGroupVisible(2131296998, false);
        menu.setGroupVisible(2131296583, true);
    }

    private /* synthetic */ void A3(Boolean bl) {
        this.K2();
    }

    @SuppressLint(value={"SetTextI18n"})
    private void A4(BeatStartRecord beatStartRecord) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null && beatStartRecord != null) {
            String string = com.smp.musicspeed.bpmkey.g.a(beatStartRecord.keycurrent, playFileService.w());
            int n2 = string.indexOf("\u266d");
            if (n2 >= 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)string);
                spannableStringBuilder.setSpan((Object)new CustomTypefaceSpan("", com.smp.musicspeed.utils.q.a((Context)this)), n2, n2 + 1, 34);
                this.J0.setText((CharSequence)spannableStringBuilder);
                this.N0.setText((CharSequence)spannableStringBuilder);
                return;
            }
            this.J0.setText((CharSequence)string);
            this.N0.setText((CharSequence)string);
        }
    }

    private void A5(double d2) {
        double d3 = 0.0;
        if (d2 < d3) {
            d2 = d3;
        }
        if (d2 > 1.0) {
            d2 = 1.0;
        }
        if (Double.isNaN((double)d2)) {
            d2 = d3;
        }
        if (!Double.isInfinite((double)d2)) {
            d3 = d2;
        }
        this.O0.setProgress((float)(100.0 * d3));
        int n2 = (int)(d3 * (double)this.O0.getWidth());
        this.W0.smoothScrollTo(n2, 0);
    }

    static /* synthetic */ void B0(MainActivity mainActivity) {
        mainActivity.c4();
    }

    private void B1() {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener(){
            private boolean a;
            private int b;

            private void c(boolean bl) {
                this.a = bl;
            }

            boolean b() {
                return this.a;
            }

            public void d(float f2) {
                this.c(false);
                MainActivity.this.W.removeCallbacks(MainActivity.this.F1);
                MainActivity.this.L = true;
                if (MainActivity.this.h0 != null) {
                    MainActivity.this.h0.l0(f2);
                }
                MainActivity.this.W.postDelayed(MainActivity.this.F1, 750L);
            }

            public void onProgressChanged(SeekBar seekBar, int n2, boolean bl) {
                if (seekBar == MainActivity.this.X && bl) {
                    float f2 = MainActivity.this.C1(n2);
                    if (com.smp.musicspeed.utils.t.H((Context)MainActivity.this)) {
                        f2 = Math.round((float)f2);
                    }
                    if (MainActivity.this.h0 != null) {
                        MainActivity.this.h0.r0(f2);
                        MainActivity.this.E4(f2);
                        return;
                    }
                } else if (seekBar == MainActivity.this.Y && bl) {
                    float f3 = MainActivity.this.H1(n2);
                    if (com.smp.musicspeed.utils.t.I((Context)MainActivity.this)) {
                        f3 = (float)Math.round((double)(20.0 * (double)f3)) / 20.0f;
                    }
                    if (MainActivity.this.h0 != null) {
                        MainActivity.this.h0.u0(f3);
                        MainActivity.this.N4(f3);
                        return;
                    }
                } else if (seekBar == MainActivity.this.Z && bl) {
                    float f4 = MainActivity.this.G1(n2);
                    if (com.smp.musicspeed.utils.t.I((Context)MainActivity.this)) {
                        f4 = (float)Math.round((double)(20.0 * (double)f4)) / 20.0f;
                    }
                    if (MainActivity.this.h0 != null) {
                        MainActivity.this.h0.s0(f4);
                        MainActivity.this.J4(f4);
                        return;
                    }
                } else if (seekBar == MainActivity.this.W && bl) {
                    this.b = n2;
                    double d2 = (float)n2 / (float)MainActivity.this.W.getMax();
                    long l2 = (long)(d2 * (double)MainActivity.this.h0.s());
                    MainActivity.this.H4(l2);
                    MainActivity.this.A5(d2);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                if (seekBar == MainActivity.this.W) {
                    this.c(true);
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar == MainActivity.this.W) {
                    this.d((float)this.b / (float)MainActivity.this.W.getMax());
                }
            }
        };
        this.i0 = onSeekBarChangeListener;
        this.W.setOnSeekBarChangeListener(onSeekBarChangeListener);
        this.Y.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this.i0);
        this.X.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this.i0);
        this.Z.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this.i0);
        this.W0.setOnScrollStoppedListener(new u(this));
        this.X0 = new com.smp.musicspeed.j(this);
        if (this.W0.getViewTreeObserver().isAlive()) {
            this.W0.getViewTreeObserver().addOnScrollChangedListener(this.X0);
        }
    }

    private void B2(boolean bl) {
        this.U0.setDisplayedChild((int)bl);
        this.V0.h0(bl);
    }

    @SuppressLint(value={"SetTextI18n"})
    private void B4(BeatStartRecord beatStartRecord) {
        if (beatStartRecord != null) {
            this.G0.setText((CharSequence)com.smp.musicspeed.utils.n.c(Math.round((float)beatStartRecord.bpmcurrent)));
            this.K0.setText((CharSequence)com.smp.musicspeed.utils.n.c(Math.round((float)beatStartRecord.bpmcurrent)));
        }
    }

    private void B5() {
        SharedPreferences.Editor editor = androidx.preference.j.b((Context)this.getApplicationContext()).edit();
        editor.putString("com.smp.musicspeed.prefs.VERSION", "10.3.4-pl");
        editor.apply();
    }

    private float C1(int n2) {
        return (float)(n2 - this.M) / 100.0f;
    }

    private void C2() {
        this.R().n().e((Fragment)new com.smp.musicspeed.playingqueue.r(), "data provider").i();
        this.R().n().c(2131296592, (Fragment)new com.smp.musicspeed.playingqueue.s(), "list view").i();
    }

    private /* synthetic */ void C3(BeatStartRecord beatStartRecord) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null && beatStartRecord != null && playFileService.t() != null && this.h0.t().equals((Object)beatStartRecord.filename)) {
            this.q4(beatStartRecord);
        }
    }

    @SuppressLint(value={"SetTextI18n"})
    private void C4(BeatStartRecord beatStartRecord) {
        if (beatStartRecord != null) {
            String string = com.smp.musicspeed.bpmkey.g.b(beatStartRecord.keycurrent);
            int n2 = string.indexOf("\u266d");
            if (n2 >= 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)string);
                spannableStringBuilder.setSpan((Object)new CustomTypefaceSpan("", com.smp.musicspeed.utils.q.a((Context)this)), n2, n2 + 1, 34);
                this.I0.setText((CharSequence)spannableStringBuilder);
                this.M0.setText((CharSequence)spannableStringBuilder);
                return;
            }
            this.I0.setText((CharSequence)string);
            this.M0.setText((CharSequence)string);
        }
    }

    private void C5() {
        AudioWaveView audioWaveView = this.O0;
        audioWaveView.setScaledData(new byte[100 + (int)com.smp.musicspeed.utils.t.M((Context)this, audioWaveView.getWidth()) / this.O0.getChunkWidth()]);
    }

    private int D1(double d2) {
        return (int)Math.round((double)(d2 * 100.0 + (double)this.M));
    }

    private void D2(boolean bl) {
        if (com.smp.musicspeed.utils.k.D((Context)this) && com.smp.musicspeed.utils.k.E((Context)this)) {
            MainActivity.g2(this.T0, bl, 200);
            com.smp.musicspeed.utils.t.d0((Context)this, 2131230994, this.T.getMenu().findItem(2131296355), com.smp.musicspeed.utils.t.c((Context)this));
            return;
        }
        this.A1.postDelayed(this.x1, 200L);
        MainActivity.h2(this.T0, bl, 100);
        com.smp.musicspeed.utils.t.d0((Context)this, 2131230994, this.T.getMenu().findItem(2131296355), this.Y0);
    }

    private void D4(float f2) {
        int n2 = this.D1(f2);
        this.X.setProgress(n2);
    }

    private int E1(double d2) {
        return this.F1(d2);
    }

    private void E2() {
        if (AppPrefs.k.h0()) {
            this.findViewById(2131296502).setVisibility(0);
            this.findViewById(2131296510).setVisibility(0);
            this.findViewById(2131296504).setVisibility(0);
            this.findViewById(2131296512).setVisibility(0);
            this.findViewById(2131296503).setVisibility(0);
            this.findViewById(2131296511).setVisibility(0);
            return;
        }
        this.findViewById(2131296502).setVisibility(8);
        this.findViewById(2131296510).setVisibility(8);
        this.findViewById(2131296504).setVisibility(8);
        this.findViewById(2131296512).setVisibility(8);
        this.findViewById(2131296503).setVisibility(8);
        this.findViewById(2131296511).setVisibility(8);
    }

    private /* synthetic */ void E3(List list, Boolean bl) {
        if (bl.booleanValue() && AppPrefs.k.B()) {
            this.v0.setVisibility(4);
            this.Z0.c();
        } else {
            this.Z0.a();
            this.v0.setVisibility(0);
        }
        if (bl.booleanValue()) {
            this.a1.c();
            this.b1.c();
            this.c1.c();
            this.d1.c();
        } else {
            this.a1.a();
            this.b1.a();
            this.c1.a();
            this.d1.a();
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((View)iterator.next()).setVisibility(this.u5(true ^ bl));
        }
    }

    private void E4(float f2) {
        this.a0.setText((CharSequence)com.smp.musicspeed.utils.n.e(f2));
        BeatStartRecord beatStartRecord = (BeatStartRecord)com.smp.musicspeed.bpmkey.a.f.d().f();
        this.C4(beatStartRecord);
        this.A4(beatStartRecord);
    }

    static /* synthetic */ int F0() {
        return H;
    }

    private int F1(double d2) {
        long l2;
        float f2 = C;
        if (d2 >= (double)f2) {
            double d3 = (d2 - (double)f2) / (double)B;
            int n2 = this.N;
            l2 = Math.round((double)(d3 * (double)n2 + (double)n2));
        } else {
            l2 = Math.round((double)((d2 - (double)A) / (double)z * (double)this.N));
        }
        return (int)l2;
    }

    private DefaultLayoutPromptView F2() {
        DefaultLayoutPromptView defaultLayoutPromptView = (DefaultLayoutPromptView)this.findViewById(2131297049);
        defaultLayoutPromptView.j((c.d.a.a.m.f.f)new com.smp.musicspeed.l(this));
        return defaultLayoutPromptView;
    }

    private void F4(long l2) {
        int n2 = this.W.getMax();
        long l3 = this.h0.s();
        double d2 = l2 == 0L ? 0.0 : (double)l2 / (double)l3;
        int n3 = (int)Math.round((double)(d2 * (double)n2));
        if (l2 == Long.MIN_VALUE) {
            n3 = 0;
        }
        this.W.setProgress(n3);
    }

    private float G1(int n2) {
        return this.H1(n2);
    }

    private void G2() {
        if (com.smp.musicspeed.utils.k.d()) {
            this.C0.setVisibility(0);
            this.E0.setVisibility(0);
        } else {
            this.C0.setVisibility(8);
            this.E0.setVisibility(8);
        }
        if (com.smp.musicspeed.utils.k.j()) {
            this.D0.setVisibility(0);
            this.F0.setVisibility(0);
            return;
        }
        this.D0.setVisibility(8);
        this.F0.setVisibility(8);
    }

    private /* synthetic */ void G3(Integer n2) {
        if (n2 > 0) {
            this.i1.setVisibility(0);
            this.j1.setVisibility(0);
            this.j1.setText((CharSequence)String.valueOf((Object)n2));
            return;
        }
        this.i1.setVisibility(8);
        this.j1.setVisibility(8);
    }

    private void G4(int n2) {
        int n3 = n2 != 0 ? (n2 != 1 ? (n2 != 2 ? (n2 != 3 ? 0 : 2131231000) : 2131231001) : 2131230928) : 2131231018;
        this.q0.setImageResource(n3);
    }

    private float H1(int n2) {
        int n3 = this.N;
        int n4 = n2 >= n3 ? Math.round((float)(100.0f * ((float)(n2 - n3) / (float)n3 * B + C))) : Math.round((float)(100.0f * ((float)n2 / (float)n3 * z + A)));
        return (float)n4 / 100.0f;
    }

    private void H2() {
        if (AppPrefs.k.g0()) {
            this.t0.setVisibility(0);
            this.u0.setVisibility(0);
            return;
        }
        this.t0.setVisibility(8);
        this.u0.setVisibility(8);
    }

    private void H4(long l2) {
        com.smp.musicspeed.utils.p p2;
        if (l2 < 0L) {
            this.e0.setText((CharSequence)"--:--");
            return;
        }
        String string = this.e0.getText().toString();
        com.smp.musicspeed.utils.p p3 = new com.smp.musicspeed.utils.p(l2);
        if (string.length() != p3.toString().length()) {
            this.c5(true);
        }
        if (p3.compareTo(p2 = new com.smp.musicspeed.utils.p(this.h0.s())) > 0) {
            p3 = p2;
        }
        if (!string.equals((Object)p3.toString())) {
            this.e0.postOnAnimation(new Runnable(this, p3){
                final /* synthetic */ com.smp.musicspeed.utils.p f;
                final /* synthetic */ MainActivity g;
                {
                    this.g = mainActivity;
                    this.f = p2;
                }

                public void run() {
                    MainActivity.u1(this.g).setText((CharSequence)this.f.toString());
                }
            });
        }
    }

    private void I1() {
        SharedPreferences.Editor editor = androidx.preference.j.b((Context)this.getApplicationContext()).edit();
        editor.putBoolean("com.smp.PREF_FROM_OTHER_APP", false);
        editor.apply();
    }

    private /* synthetic */ void I3(boolean bl) {
        if (this.W0.getVisibility() == 0) {
            this.U.setVisibility(4);
        } else {
            this.U.setVisibility(0);
        }
        TransitionDrawable transitionDrawable = (TransitionDrawable)this.U.getBackground();
        PlayFileService playFileService = this.h0;
        if (playFileService != null && playFileService.E()) {
            int n2 = this.W.getWidth() - this.W.getPaddingLeft() - this.W.getPaddingRight();
            double d2 = (double)this.h0.v() / (double)this.h0.s();
            double d3 = n2;
            int n3 = (int)Math.round((double)(d2 * d3));
            com.smp.musicspeed.utils.s.i(this.U, n3 + this.W.getPaddingLeft(), 0, 0, 0);
            int n4 = (int)Math.round((double)(d3 * ((double)(this.h0.u() - this.h0.v()) / (double)this.h0.s())));
            this.A1.removeCallbacks(this.z1);
            ViewGroup.LayoutParams layoutParams = this.U.getLayoutParams();
            if (n4 <= 2) {
                n4 = 2;
            }
            layoutParams.width = n4;
            if (!bl) {
                transitionDrawable.resetTransition();
                transitionDrawable.startTransition(500);
                return;
            }
            transitionDrawable.resetTransition();
            transitionDrawable.startTransition(0);
            return;
        }
        if (!bl) {
            if (this.U.getLayoutParams().width > 0) {
                transitionDrawable.resetTransition();
                transitionDrawable.reverseTransition(500);
                this.A1.postDelayed(this.z1, 500L);
                return;
            }
        } else {
            this.A1.removeCallbacks(this.z1);
            this.U.getLayoutParams().width = 0;
            transitionDrawable.resetTransition();
        }
    }

    private void I4(float f2) {
        int n2 = this.E1(f2);
        this.Z.setProgress(n2);
    }

    static /* synthetic */ PlayFileService J0(MainActivity mainActivity, PlayFileService playFileService) {
        mainActivity.h0 = playFileService;
        return playFileService;
    }

    private void J1() {
        this.S1();
        com.michaelflisar.gdprdialog.c.e().a();
        com.michaelflisar.gdprdialog.c.e().i(new com.michaelflisar.gdprdialog.e((Context)this, com.michaelflisar.gdprdialog.d.j, com.michaelflisar.gdprdialog.h.f));
        Fragment fragment = this.R().j0(com.michaelflisar.gdprdialog.g.class.getName());
        if (fragment != null) {
            ((androidx.fragment.app.c)fragment).w();
        }
    }

    private void J2() {
        if (com.smp.musicspeed.utils.t.w((Context)this) && com.smp.musicspeed.utils.k.C((Context)this) && com.smp.musicspeed.k0.z.c()) {
            com.smp.musicspeed.utils.k.G((Context)this, com.smp.musicspeed.utils.k.l((Context)this));
        }
        com.smp.musicspeed.utils.k.H((Context)this, false);
        int n2 = b.i.h.a.c((Context)this, (int)2131099733);
        if (com.smp.musicspeed.utils.k.l((Context)this) == -9447681) {
            com.smp.musicspeed.utils.k.J((Context)this, n2);
        }
        if (com.smp.musicspeed.utils.k.f((Context)this) == -9447681) {
            com.smp.musicspeed.utils.k.G((Context)this, n2);
        }
    }

    private void J4(float f2) {
        this.c0.setText((CharSequence)com.smp.musicspeed.utils.n.f(f2));
        BeatStartRecord beatStartRecord = (BeatStartRecord)com.smp.musicspeed.bpmkey.a.f.d().f();
        this.B4(beatStartRecord);
        this.y4(beatStartRecord);
        this.C4(beatStartRecord);
        this.A4(beatStartRecord);
    }

    private void K2() {
        if (this.h0 != null) {
            this.S4();
            this.z2();
            this.t2(true);
        }
    }

    private /* synthetic */ void K3() {
        this.o1 = false;
    }

    private void K4() {
        float f2;
        float f3;
        float f4;
        int n2 = com.smp.musicspeed.utils.t.m((Context)this);
        this.M = n2 / 2;
        x = f3 = (float)n2 / 100.0f / 2.0f;
        y = -f3;
        this.X.setMax(n2);
        float f5 = com.smp.musicspeed.utils.t.h((Context)this);
        float f6 = com.smp.musicspeed.utils.t.g((Context)this);
        A = f5;
        z = 1.0f - f5;
        B = f6;
        D = f6 + C;
        boolean bl = com.smp.musicspeed.utils.t.A((Context)this);
        PlayFileService playFileService = this.h0;
        if (playFileService != null && playFileService.G()) {
            float f7;
            float f8;
            float f9;
            float f10;
            if (!bl && (f8 = this.h0.w()) > (f9 = x)) {
                this.h0.r0(f9);
            } else if (!bl && (f7 = this.h0.w()) < (f10 = y)) {
                this.h0.r0(f10);
            }
            float f11 = this.h0.z();
            float f12 = D;
            if (f11 > f12) {
                if (bl) {
                    this.h0.s0(f12);
                } else {
                    this.h0.u0(f12);
                }
            } else {
                float f13;
                float f14 = this.h0.z();
                if (f14 < (f13 = A)) {
                    if (bl) {
                        this.h0.s0(f13);
                    } else {
                        this.h0.u0(f13);
                    }
                }
            }
            this.D4(this.h0.w());
            this.M4(this.h0.z());
            this.I4(this.h0.y());
            this.E4(this.h0.w());
            this.N4(this.h0.z());
            this.J4(this.h0.y());
            return;
        }
        SharedPreferences sharedPreferences = com.smp.musicspeed.utils.t.o((Context)this);
        SharedPreferences.Editor editor = com.smp.musicspeed.utils.t.p((Context)this);
        float f15 = sharedPreferences.getFloat("com.smp.PREF_PITCH", 0.0f);
        float f16 = sharedPreferences.getFloat("com.smp.PREF_TEMPO", 1.0f);
        if (!bl && f15 > (f4 = x)) {
            editor.putFloat("com.smp.PREF_PITCH", f4);
        } else if (!bl && f15 < (f2 = y)) {
            editor.putFloat("com.smp.PREF_PITCH", f2);
        }
        float f17 = D;
        if (f16 > f17) {
            if (bl) {
                editor.putFloat("com.smp.PREF_RATE", f17);
                editor.putFloat("com.smp.PREF_TEMPO", D);
            } else {
                editor.putFloat("com.smp.PREF_TEMPO", f17);
            }
        } else {
            float f18 = A;
            if (f16 < f18) {
                if (bl) {
                    editor.putFloat("com.smp.PREF_RATE", f18);
                    editor.putFloat("com.smp.PREF_TEMPO", A);
                } else {
                    editor.putFloat("com.smp.PREF_TEMPO", f17);
                }
            }
        }
        editor.apply();
    }

    private void L1() {
        if (AppPrefs.k.D()) {
            this.L2();
            this.Z();
            return;
        }
        this.Q4();
    }

    private void L2() {
        this.A1.removeCallbacks(this.w1);
        com.smp.musicspeed.ads.p p2 = this.k1;
        if (p2 != null) {
            p2.c();
            this.k1 = null;
        }
    }

    private void L4(boolean bl) {
        if (!bl) {
            this.B0.setImageResource(2131231153);
            return;
        }
        this.B0.setImageResource(2131231013);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void M1() {
        AppPrefs appPrefs = AppPrefs.k;
        if (appPrefs.z() == -1L) {
            appPrefs.m0(System.currentTimeMillis());
        }
        boolean bl = appPrefs.d0();
        boolean bl2 = false;
        boolean bl3 = true;
        if (bl && !this.O2() && (appPrefs.l0() || !appPrefs.c0() && System.currentTimeMillis() - appPrefs.z() > 345600000L)) {
            bl2 = true;
        } else {
            bl3 = false;
        }
        if (bl2) {
            this.f5(bl3);
        }
    }

    private void M2() {
        this.k1 = AdsProvider.a.b((Activity)this);
    }

    private void M3() {
        this.w0 = AdsProvider.a.a(this.getApplicationContext());
    }

    private void M4(float f2) {
        int n2 = this.F1(f2);
        this.Y.setProgress(n2);
    }

    private void N1() {
        GDPRNetwork[] arrgDPRNetwork = new GDPRNetwork[]{com.michaelflisar.gdprdialog.f.a, com.michaelflisar.gdprdialog.f.d};
        GDPRSetup gDPRSetup = new GDPRSetup(arrgDPRNetwork).Q("https://www.iubenda.com/privacy-policy/7966386").I(false).M(false).N(false).K(I).J(true).O(true);
        int n2 = com.smp.musicspeed.utils.t.w((Context)this) ? 2131886365 : 2131886366;
        this.v1 = gDPRSetup.L(n2).R(true).P(false).S(false);
        com.michaelflisar.gdprdialog.c.e().b(this, this.v1);
    }

    private int N2(float f2, int n2, int n3) {
        int n4 = 255 & n2 >> 24;
        int n5 = 255 & n2 >> 16;
        int n6 = 255 & n2 >> 8;
        int n7 = n2 & 255;
        int n8 = 255 & n3 >> 24;
        int n9 = 255 & n3 >> 16;
        int n10 = 255 & n3 >> 8;
        int n11 = n3 & 255;
        return n4 + (int)(f2 * (float)(n8 - n4)) << 24 | n5 + (int)(f2 * (float)(n9 - n5)) << 16 | n6 + (int)(f2 * (float)(n10 - n6)) << 8 | n7 + (int)(f2 * (float)(n11 - n7));
    }

    private void N3() {
        if (!PlayingQueue.hasLoaded) {
            PlayingQueue.loadAsync((Context)this);
            return;
        }
        this.l1 = false;
    }

    private void N4(float f2) {
        this.b0.setText((CharSequence)com.smp.musicspeed.utils.n.g(f2));
        BeatStartRecord beatStartRecord = (BeatStartRecord)com.smp.musicspeed.bpmkey.a.f.d().f();
        this.B4(beatStartRecord);
        this.y4(beatStartRecord);
    }

    private boolean O1() {
        boolean bl = com.smp.musicspeed.utils.k.E((Context)this);
        if (bl) {
            this.V0.r0(4);
        }
        return bl;
    }

    private boolean O2() {
        return this.R().j0("RemoveAdsDialogFragment") != null;
    }

    private void O3() {
        j.a.a.a.f f2;
        if (com.smp.musicspeed.utils.k.E((Context)this)) {
            return;
        }
        String string = this.getString(2131820884);
        String string2 = this.getString(2131820885);
        this.n1 = f2 = new f.d((Activity)this).f(this.T.getChildAt(1)).e(string).c(string2).b().d(400).g("keyLibrary").a();
        f2.v((Activity)this);
    }

    private void O4() {
        double d2 = (double)this.h0.x() / (double)this.h0.s();
        if (d2 <= 1.0 && d2 >= 0.0) {
            this.A5(d2);
        }
    }

    private boolean P1() {
        return com.smp.musicspeed.utils.t.M((Context)this, this.W0.getHeight()) >= 40.0f;
    }

    private boolean P2() {
        return androidx.preference.j.b((Context)this.getApplicationContext()).getBoolean("com.smp.PREF_FROM_OTHER_APP", false);
    }

    private void P3() {
        j.a.a.a.f f2;
        String string = this.getString(2131820884);
        String string2 = this.getString(2131820887);
        this.m1 = f2 = new f.d((Activity)this).f((View)this.a0).e(string).c(string2).b().d(400).g("keyHelp").a();
        f2.v((Activity)this);
    }

    private void P4() {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            long l2 = playFileService.v();
            long l3 = this.h0.u();
            Float f2 = l2 == Long.MIN_VALUE ? null : Float.valueOf((float)this.v5(l2));
            Float f3 = l3 == Long.MIN_VALUE ? null : Float.valueOf((float)this.v5(l3));
            this.g1.q(f2, f3);
        }
    }

    private void Q1(int n2, String string, File file) {
        new Thread((Runnable)new com.smp.musicspeed.e(this, string, n2, file)).start();
    }

    private void Q3(String string) {
        Toast.makeText((Context)this, (CharSequence)string, (int)0).show();
    }

    private void Q4() {
        com.smp.musicspeed.e0.a.f.h(this.getApplicationContext());
        AppPrefs.k.E().i((androidx.lifecycle.p)this, (androidx.lifecycle.x)new com.smp.musicspeed.q(this));
    }

    private void R1() {
        PlayFileService playFileService = this.h0;
        if (playFileService != null && playFileService.t() != null) {
            this.Q1(0, ReverseService.a((Context)this), new File(this.h0.t()));
        }
    }

    private /* synthetic */ void R2(int n2) {
        this.i0.d(this.z5(n2));
    }

    private void R3() {
        SharedPreferences sharedPreferences = androidx.preference.j.b((Context)this.getApplicationContext());
        androidx.preference.j.n((Context)this, (int)2132017159, (boolean)true);
        androidx.preference.j.n((Context)this, (int)2132017158, (boolean)true);
        androidx.preference.j.n((Context)this, (int)2132017156, (boolean)true);
        com.smp.musicspeed.utils.t.O(this.getApplicationContext(), this);
        if (sharedPreferences.getBoolean("preferences_screen_on", false)) {
            this.getWindow().addFlags(128);
        }
        this.u2();
    }

    private void R4() {
        this.k0.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ MainActivity f;
            {
                this.f = mainActivity;
            }

            public void onClick(View view) {
                MainActivity mainActivity = this.f;
                mainActivity.onPlay((View)MainActivity.o0(mainActivity));
            }
        });
    }

    private void S1() {
        MenuItem menuItem;
        Menu menu = this.T.getMenu();
        this.A2();
        b.i.q.i.a((Menu)menu, (boolean)true);
        PlayingQueue playingQueue = PlayingQueue.getDefault();
        if (playingQueue.getCurrentlyPlaying() >= 0 && playingQueue.getCurrentlyPlaying() <= playingQueue.getLength() - 1) {
            MediaTrack mediaTrack = playingQueue.getItemAt(playingQueue.getCurrentlyPlaying());
            if (mediaTrack.getMediaType() != I.a) {
                menu.findItem(2131296339).setEnabled(false);
                menu.findItem(2131296340).setEnabled(false);
            } else {
                menu.findItem(2131296339).setEnabled(true);
                menu.findItem(2131296340).setEnabled(true);
            }
            if (!com.smp.musicspeed.tag_editor.m.c(new File(mediaTrack.getLocation()))) {
                menu.findItem(2131296376).setEnabled(false);
            } else {
                menu.findItem(2131296376).setEnabled(true);
            }
        }
        boolean bl = com.smp.musicspeed.utils.t.o((Context)this).getBoolean("preferences_link", false);
        MenuItem menuItem2 = menu.findItem(2131296343);
        if (menuItem2 != null) {
            menuItem2.setChecked(bl);
        }
        if ((menuItem = menu.findItem(2131296332)) != null) {
            menuItem.setChecked(AppPrefs.k.W());
        }
        if (AppPrefs.k.D()) {
            menu.findItem(2131296356).setVisible(false);
        } else if (com.smp.musicspeed.utils.k.E((Context)this)) {
            menu.findItem(2131296356).setVisible(true);
        }
        com.smp.musicspeed.utils.k.F(menu);
        this.v2();
        if (com.smp.musicspeed.utils.k.E((Context)this)) {
            ((ViewGroup)this.T.getChildAt(0)).getChildAt(1).setOnTouchListener((View.OnTouchListener)new com.smp.musicspeed.h(this));
        }
        this.T.setOnMenuItemClickListener((Toolbar.f)new com.smp.musicspeed.g(this));
    }

    private void S3(WaveformRecord waveformRecord) {
        if (waveformRecord != null && waveformRecord.waveForm != null) {
            this.C5();
            this.O0.setRawData(waveformRecord.waveForm);
            return;
        }
        try {
            throw new RuntimeException("waveform data was null, in newDataWaveformView");
        }
        catch (RuntimeException runtimeException) {
            return;
        }
    }

    private void S4() {
        if (com.smp.musicspeed.utils.t.f0()) {
            this.W0.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.S0.getLayoutParams();
            layoutParams.width = com.smp.musicspeed.utils.t.S((Activity)this) / 2;
            this.S0.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.R0.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            int n2 = Integer.parseInt((String)AppPrefs.k.i0());
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        return;
                    }
                    this.y5(142);
                    return;
                }
                this.y5(64);
                return;
            }
            this.x5();
            return;
        }
        this.W0.setVisibility(8);
    }

    static /* synthetic */ BottomSheetBehavior T0(MainActivity mainActivity) {
        return mainActivity.V0;
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    private void T1() {
        this.V.setOnTouchListener((View.OnTouchListener)new com.smp.musicspeed.t(this));
    }

    private /* synthetic */ void T2() {
        if (this.W0.e()) {
            this.i0.c(true);
            double d2 = this.z5(this.W0.getScrollX());
            this.H4((long)(d2 * (double)this.h0.s()));
            AppCompatSeekBar appCompatSeekBar = this.W;
            appCompatSeekBar.setProgress((int)(d2 * (double)appCompatSeekBar.getMax()));
            this.O0.setProgress((float)(d2 * 100.0));
        }
    }

    private void T3() {
        if (this.h0.t() != null) {
            this.g1.r(new k0(this.h0.t(), this.h0.s()));
        }
    }

    private void T4() {
        this.T.x(2131558426);
        this.T.setClickable(true);
        Toolbar toolbar = this.T;
        toolbar.setOverflowIcon(toolbar.getOverflowIcon().mutate());
        this.S1();
        this.T.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.r(this));
        com.smp.musicspeed.utils.t.e0((Context)this, 2131230955, this.T, this.Y0);
        View view = MainActivity.r2(this.T);
        if (com.smp.musicspeed.utils.k.E((Context)this)) {
            this.V0.r0(3);
            this.A1(view, 1.0f);
        } else {
            this.V0.r0(4);
            this.A1(view, 0.0f);
        }
        this.V0.M(new BottomSheetBehavior.f(this, view){
            int a;
            int b;
            final /* synthetic */ View c;
            final /* synthetic */ MainActivity d;
            {
                this.d = mainActivity;
                this.c = view;
                this.a = com.smp.musicspeed.utils.t.Q((Context)mainActivity, 2130968792, 0);
                this.b = b.i.h.a.c((Context)mainActivity, (int)2131099924);
            }

            private int c(float f2) {
                float f3 = f2 >= 0.5f ? 2.0f * (f2 - 0.5f) : 2.0f * (0.5f - f2);
                return (int)(f3 * 255.0f);
            }

            private void d(float f2) {
                if (f2 >= 0.5f) {
                    com.smp.musicspeed.utils.k.M((Context)this.d, true);
                } else {
                    com.smp.musicspeed.utils.k.M((Context)this.d, false);
                }
                MainActivity.l0(this.d);
                Drawable drawable = MainActivity.W0(this.d).getOverflowIcon();
                int n2 = 0;
                if (drawable != null) {
                    drawable.setAlpha(this.c(f2));
                }
                while (n2 < MainActivity.W0(this.d).getMenu().size()) {
                    Drawable drawable2 = MainActivity.W0(this.d).getMenu().getItem(n2).getIcon();
                    if (drawable2 != null) {
                        drawable2.setAlpha(this.c(f2));
                    }
                    ++n2;
                }
            }

            private void e(float f2) {
                if (this.d.getResources().getConfiguration().orientation != 2 && Build.VERSION.SDK_INT >= 21) {
                    this.d.getWindow().setNavigationBarColor(MainActivity.n0(this.d, f2, this.b, this.a));
                }
            }

            public void a(View view, float f2) {
                MainActivity.w1(this.d, this.c, f2);
                this.e(f2);
                this.d(f2);
                if (com.smp.musicspeed.utils.k.D((Context)this.d)) {
                    MainActivity.x1(this.d).setAlpha(f2);
                }
            }

            public void b(View view, int n2) {
                if (n2 != 1) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            return;
                        }
                        com.smp.musicspeed.utils.k.L((Context)this.d, false);
                        MainActivity mainActivity = this.d;
                        com.smp.musicspeed.utils.t.d0((Context)mainActivity, 2131230994, MainActivity.W0(mainActivity).getMenu().findItem(2131296355), MainActivity.h1(this.d));
                        MainActivity.s1(this.d, true);
                        com.smp.musicspeed.utils.k.M((Context)this.d, false);
                        MainActivity.l0(this.d);
                        MainActivity mainActivity2 = this.d;
                        mainActivity2.A1.removeCallbacks(MainActivity.v1(mainActivity2));
                        return;
                    }
                    com.smp.musicspeed.utils.k.M((Context)this.d, true);
                    MainActivity.l0(this.d);
                    if (MainActivity.m0(this.d) != null) {
                        MainActivity.B0(this.d);
                        return;
                    }
                } else {
                    com.smp.musicspeed.utils.t.u((Activity)this.d);
                    org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.player.m());
                }
            }
        });
    }

    static /* synthetic */ boolean U0(MainActivity mainActivity) {
        return mainActivity.o1;
    }

    public static float U1(float f2, Context context) {
        return f2 * ((float)context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    private boolean U3(String string, boolean bl) {
        long l2;
        float f2;
        boolean bl2;
        float f3;
        double d2;
        boolean bl3;
        boolean bl4;
        long l3;
        float f4;
        block12 : {
            void var14_17;
            if (this.h0 == null) {
                return false;
            }
            if (bl) {
                boolean bl5 = androidx.preference.j.b((Context)this.getApplicationContext()).getBoolean("preferences_link", false);
                float f5 = this.h0.y();
                f4 = this.h0.w();
                f2 = this.h0.z();
                bl4 = this.h0.E();
                l3 = this.h0.v();
                l2 = this.h0.u();
                d2 = 1.0 - (double)this.h0.x() / (double)this.h0.s();
                f3 = f5;
                bl2 = bl5;
            } else {
                l2 = l3 = 0L;
                bl2 = false;
                f3 = 0.0f;
                f4 = 0.0f;
                d2 = 0.0;
                f2 = 0.0f;
                bl4 = false;
            }
            try {
                this.h0.C(string);
                bl3 = true;
                break block12;
            }
            catch (IllegalStateException illegalStateException) {
            }
            catch (IllegalArgumentException illegalArgumentException) {
            }
            catch (IOException iOException) {
                // empty catch block
            }
            var14_17.printStackTrace();
            this.Q3(this.getResources().getString(2131821317));
            bl3 = false;
        }
        if (bl && bl3) {
            if (bl2) {
                this.h0.s0(f3);
            } else {
                this.h0.r0(f4);
                this.h0.u0(f2);
            }
            if (d2 < 1.0 && d2 > 0.0) {
                this.h0.l0((float)d2);
                this.A5(d2);
            }
            if (bl4) {
                this.w4(this.h0.s() - l2, false);
                this.u4(this.h0.s() - l3, false);
            }
            this.h0.x0();
            this.H4(this.h0.x());
            this.F4(this.h0.x());
            this.y2();
            this.v2();
            this.t2(true);
            this.i5(this.h0.t());
            this.W.removeCallbacks(this.F1);
            this.L = true;
            this.W.postDelayed(this.F1, 750L);
            return bl3;
        }
        this.h0.x0();
        this.d4();
        return bl3;
    }

    private void U4() {
        ((ViewGroup)this.findViewById(2131297303)).getLayoutTransition().enableTransitionType(4);
        this.e1.getLayoutTransition().enableTransitionType(4);
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimateParentHierarchy(false);
        ((RelativeLayout)this.findViewById(2131296782)).setLayoutTransition(layoutTransition);
        Object[] arrobject = new ViewGroup[]{(ViewGroup)this.C0.findViewById(2131296777), (ViewGroup)this.D0.findViewById(2131296777), (ViewGroup)this.E0.findViewById(2131296777), (ViewGroup)this.F0.findViewById(2131296777)};
        for (ViewGroup viewGroup : Arrays.asList((Object[])arrobject)) {
            LayoutTransition layoutTransition2 = new LayoutTransition();
            layoutTransition.setAnimateParentHierarchy(false);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
        ViewGroup viewGroup = (ViewGroup)this.findViewById(2131297025);
        if (viewGroup != null) {
            LayoutTransition layoutTransition3 = new LayoutTransition();
            layoutTransition3.setAnimateParentHierarchy(false);
            layoutTransition3.enableTransitionType(4);
            viewGroup.setLayoutTransition(layoutTransition3);
        }
    }

    static /* synthetic */ void V0(MainActivity mainActivity, double d2, long l2) {
        mainActivity.c2(d2, l2);
    }

    private Intent V1() {
        int n2 = Build.VERSION.SDK_INT;
        Intent intent = n2 >= 19 ? new Intent("android.intent.action.OPEN_DOCUMENT") : new Intent("android.intent.action.GET_CONTENT");
        intent.setType("audio/*");
        if (n2 >= 19) {
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/flac", "application/x-flac", "application/ogg", "video/mp4", "video/3gpp", "audio/*"});
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        intent.addCategory("android.intent.category.OPENABLE");
        return intent;
    }

    private /* synthetic */ void V2(String string, int n2, File file) {
        Process.setThreadPriority((int)10);
        com.smp.musicspeed.utils.g.b(this.getApplicationContext(), com.smp.musicspeed.utils.g.e(this.getApplicationContext(), string), n2, file);
    }

    private void V3() {
        if (this.h0 == null) {
            return;
        }
        this.m4();
        this.C5();
        this.S().a(4324);
        this.S().g(4324, null, (a.a)this);
    }

    private void V4() {
        g0 g02;
        com.smp.musicspeed.utils.c.a.b().i((androidx.lifecycle.p)this, (androidx.lifecycle.x)new com.smp.musicspeed.k(this));
        this.g1 = g02 = (g0)new androidx.lifecycle.h0((j0)this).a(g0.class);
        g02.h().i((androidx.lifecycle.p)this, (androidx.lifecycle.x)new com.smp.musicspeed.b(this));
        Iterator iterator = ((com.smp.musicspeed.effects.v)new androidx.lifecycle.h0((j0)this).a(com.smp.musicspeed.effects.v.class)).i().iterator();
        while (iterator.hasNext()) {
            ((LiveData)iterator.next()).i((androidx.lifecycle.p)this, (androidx.lifecycle.x)new com.smp.musicspeed.f(this));
        }
        EqualizerModel.k.A().i((androidx.lifecycle.p)this, (androidx.lifecycle.x)new x(this));
        com.smp.musicspeed.bpmkey.a a2 = com.smp.musicspeed.bpmkey.a.f;
        a2.d().i((androidx.lifecycle.p)this, (androidx.lifecycle.x)new com.smp.musicspeed.s(this));
        Object[] arrobject = new View[]{this.C0.findViewById(2131296776), this.D0.findViewById(2131296776), this.E0.findViewById(2131296776), this.F0.findViewById(2131296776)};
        List list = Arrays.asList((Object[])arrobject);
        a2.g().i((androidx.lifecycle.p)this, (androidx.lifecycle.x)new w(this, list));
        com.smp.musicspeed.g0.a.f.b().i((androidx.lifecycle.p)this, (androidx.lifecycle.x)new y(this));
    }

    static /* synthetic */ Toolbar W0(MainActivity mainActivity) {
        return mainActivity.T;
    }

    private void W4() {
        boolean bl = com.smp.musicspeed.utils.t.f0();
        PlayFileService playFileService = this.h0;
        if (playFileService != null && playFileService.t() != null) {
            if (bl) {
                this.m4();
                WaveformLoader waveformLoader = (WaveformLoader)this.S().d(4324);
                if (waveformLoader != null && !this.h0.t().equals((Object)waveformLoader.H())) {
                    this.V3();
                    return;
                }
                if (this.h0.t() != this.O0.getTag()) {
                    WaveformLoader waveformLoader2 = (WaveformLoader)this.S().e(4324, null, (a.a)this);
                    if (!this.h0.t().equals(this.O0.getTag())) {
                        waveformLoader2.h();
                    }
                }
            }
            return;
        }
        if (PlayingQueue.getDefault().getLength() == 0) {
            this.W0.setVisibility(8);
        }
    }

    static /* synthetic */ MscHorizontalScrollView X0(MainActivity mainActivity) {
        return mainActivity.W0;
    }

    private void X1(MediaTrack mediaTrack) {
        Snackbar snackbar;
        String string = this.getString(2131821295);
        int n2 = b.i.h.a.c((Context)this, (int)2131100320);
        this.E1 = snackbar = Snackbar.c0((View)this.findViewById(2131296589), (CharSequence)this.getString(2131821297), (int)0);
        ((TextView)snackbar.E().findViewById(2131297133)).setTextColor(n2);
        this.E1.e0((CharSequence)string, new View.OnClickListener(this){
            final /* synthetic */ MainActivity f;
            {
                this.f = mainActivity;
            }

            public void onClick(View view) {
                org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.playingqueue.b0());
            }
        });
        this.E1.R();
    }

    private /* synthetic */ boolean X2(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.k5();
        }
        return false;
    }

    private void X3() {
        this.d4();
    }

    static /* synthetic */ void Y0(MainActivity mainActivity) {
        mainActivity.d4();
    }

    private long Y1() {
        if ((this.W0.e() || this.L) && this.W0.getVisibility() == 0) {
            return (long)(this.z5(this.W0.getScrollX()) * (float)this.h0.s());
        }
        return this.h0.x();
    }

    private void Y3() {
        this.j4();
        this.E4(this.h0.w());
        this.N4(this.h0.z());
        this.J4(this.h0.y());
        this.D4(this.h0.w());
        this.M4(this.h0.z());
        this.I4(this.h0.y());
        this.F4(this.h0.x());
        this.r4(this.h0.s());
        this.H4(this.h0.x());
        String string = this.h0.t();
        this.i5(string);
        boolean bl = string != null;
        this.r5(bl);
        this.y2();
        this.v2();
        this.S4();
        this.W4();
        this.t2(true);
        this.H2();
        this.G2();
        this.z2();
        this.E2();
        this.o5();
        this.B1();
        this.A1.removeCallbacks(this.x1);
        this.A1.postDelayed(this.x1, 200L);
    }

    private void Y4(int n2) {
        if (F && SystemClock.elapsedRealtime() - this.G1 > 1000L) {
            this.G1 = SystemClock.elapsedRealtime();
            com.smp.musicspeed.i0.l l2 = new com.smp.musicspeed.i0.l();
            Bundle bundle = new Bundle();
            bundle.putInt("com.smp.musicspeed.BUNDLE_ADJUSTMENT", n2);
            l2.setArguments(bundle);
            l2.M(this.R(), "Adjustment Fragment");
        }
    }

    private void Z1() {
        androidx.fragment.app.c c2 = (androidx.fragment.app.c)this.R().j0("BpmDialogFragment");
        androidx.fragment.app.c c3 = (androidx.fragment.app.c)this.R().j0("KeyDialogFragment");
        if (c2 != null) {
            c2.x();
        }
        if (c3 != null) {
            c3.x();
        }
    }

    private /* synthetic */ boolean Z2(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131296352) {
            this.v2();
            this.onPlay(menuItem.getActionView());
            this.v2();
            return true;
        }
        if (menuItem.getItemId() == 2131296355) {
            this.b2();
            return true;
        }
        switch (menuItem.getItemId()) {
            default: {
                return true;
            }
            case 2131296369: {
                this.h5();
                return true;
            }
            case 2131296362: {
                f0.n((Context)this, menuItem.getItemId(), PlayingQueue.getDefault().getCurrentList(), true);
                return true;
            }
            case 2131296361: {
                b0.g(this);
                return true;
            }
            case 2131296360: {
                this.l5();
                return true;
            }
            case 2131296356: {
                this.f5(false);
                return true;
            }
            case 2131296343: {
                this.onLinkClicked((View)this.t0);
                return true;
            }
            case 2131296332: {
                AppPrefs appPrefs = AppPrefs.k;
                appPrefs.G0(true ^ appPrefs.W());
                this.S1();
                return true;
            }
            case 2131296326: 
            case 2131296327: 
            case 2131296328: 
            case 2131296329: 
            case 2131296330: 
            case 2131296331: {
                AppPrefs appPrefs;
                com.smp.musicspeed.utils.k.B(menuItem.getItemId(), this.T.getMenu());
                if (menuItem.getItemId() != 2131296327 || (appPrefs = AppPrefs.k).F()) break;
                appPrefs.p0(true);
                this.g5(true);
                return true;
            }
            case 2131296323: {
                this.g5(true);
                return true;
            }
            case 2131296322: {
                f0.n((Context)this, menuItem.getItemId(), (List<? extends com.smp.musicspeed.k0.m0.e>)new ArrayList(), true);
                PlayFileService playFileService = this.h0;
                if (playFileService != null) {
                    playFileService.y0();
                }
                com.smp.musicspeed.utils.t.h0(this.getApplicationContext());
                this.d4();
                return true;
            }
            case 2131296310: 
            case 2131296335: 
            case 2131296339: 
            case 2131296340: 
            case 2131296367: 
            case 2131296376: {
                PlayingQueue playingQueue = PlayingQueue.getDefault();
                int n2 = playingQueue.getCurrentlyPlaying();
                if (n2 < 0) break;
                if (n2 > playingQueue.getLength() - 1) {
                    return true;
                }
                Object[] arrobject = new MediaTrack[]{playingQueue.getItemAt(n2)};
                List list = Arrays.asList((Object[])arrobject);
                f0.n((Context)this, menuItem.getItemId(), (List<? extends com.smp.musicspeed.k0.m0.e>)list, true);
            }
        }
        return true;
    }

    private void Z4(List<MediaTrack> list) {
        com.smp.musicspeed.importfile.g.v.a(list).M(this.R(), "DocumentChoiceDialogFormat");
    }

    static /* synthetic */ void b1(MainActivity mainActivity) {
        mainActivity.Z1();
    }

    private void b2() {
        com.smp.musicspeed.utils.k.L((Context)this, true ^ com.smp.musicspeed.utils.k.D((Context)this));
        this.S1();
        this.D2(false);
    }

    private /* synthetic */ boolean b3(View view, MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return true;
                }
            } else {
                this.V0.h0(false);
                return true;
            }
        }
        this.V0.h0(true);
        return true;
    }

    private void b5(int n2, Intent intent) {
        if (F) {
            intent.putExtra("com.smp.musicspeed.INTENT_IMPORT_REQUEST_CODE", n2);
            com.smp.musicspeed.importfile.h.R(n2, intent).M(this.R(), "ImportDialogFragment");
            return;
        }
        this.Q3(this.getResources().getString(2131821320));
    }

    static /* synthetic */ Runnable c1(MainActivity mainActivity) {
        return mainActivity.x1;
    }

    private void c2(double d2, long l2) {
        if (!this.i0.b() && !this.L && F) {
            if (d2 < 0.0) {
                d2 = 0.0;
            }
            if (l2 < 0L) {
                l2 = 0L;
            }
            int n2 = (int)Math.floor((double)(d2 * (double)this.W.getMax()));
            this.H4(l2);
            this.A5(d2);
            this.W.setProgress(n2);
        }
    }

    private void c4() {
        this.A1.removeCallbacks(this.w1);
        if (this.V0.Y() == 4) {
            return;
        }
        this.A1.postDelayed(this.w1, 90000L);
    }

    private void c5(boolean bl) {
        this.W.post((Runnable)new com.smp.musicspeed.a(this, bl));
    }

    static /* synthetic */ void d1(MainActivity mainActivity) {
        mainActivity.y2();
    }

    private void d2(double d2, boolean bl) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null && playFileService.G()) {
            long l2;
            long l3 = (long)(d2 * (double)1000000L);
            long l4 = this.h0.s();
            long l5 = this.h0.x();
            long l6 = l5 + (l2 = bl ? -l3 : l3);
            if (l6 < 0L) {
                l6 = 0L;
            }
            if (l6 > l4) {
                return;
            }
            long l7 = l4 - l3;
            if (l6 > l7) {
                l6 = l7;
            }
            double d3 = (double)l6 / (double)l4;
            this.h0.l0((float)d3);
            this.H4(l6);
            this.F4(l6);
            this.A5(d3);
        }
    }

    private /* synthetic */ void d3(Boolean bl) {
        if (AppPrefs.k.D()) {
            return;
        }
        if (bl.booleanValue()) {
            this.L2();
        } else {
            if (this.k1 == null) {
                this.M2();
                this.A1.postDelayed((Runnable)new v(this), 5000L);
                this.Q3(this.getString(2131821343));
            } else {
                this.i4();
            }
            this.M1();
            this.M3();
        }
        this.w2();
    }

    private void d4() {
        String string = this.h0.t();
        this.l4();
        this.r5(this.h0.G());
        this.i5(string);
    }

    private void d5(int n2, i.a.b b2) {
        if (F) {
            new d.a((Context)this).o(2131820678, new DialogInterface.OnClickListener(this, b2){
                final /* synthetic */ i.a.b f;
                final /* synthetic */ MainActivity g;
                {
                    this.g = mainActivity;
                    this.f = b2;
                }

                public void onClick(DialogInterface dialogInterface, int n2) {
                    this.f.b();
                }
            }).j(2131820679, new DialogInterface.OnClickListener(this, b2){
                final /* synthetic */ i.a.b f;
                final /* synthetic */ MainActivity g;
                {
                    this.g = mainActivity;
                    this.f = b2;
                }

                public void onClick(DialogInterface dialogInterface, int n2) {
                    this.f.cancel();
                }
            }).d(false).g(n2).v();
        }
    }

    private void e2() {
        AdsProvider.a.e().i((androidx.lifecycle.p)this, (androidx.lifecycle.x)new com.smp.musicspeed.p(this));
    }

    static /* synthetic */ void f1(MainActivity mainActivity) {
        mainActivity.X3();
    }

    private /* synthetic */ void f3(Boolean bl) {
        if (bl.booleanValue() && !AppPrefs.k.D()) {
            com.smp.musicspeed.ads.x.f.b().i((androidx.lifecycle.p)this, (androidx.lifecycle.x)new com.smp.musicspeed.o(this));
        }
    }

    private boolean f4(String string) {
        if (string != null && !com.smp.musicspeed.utils.g.d(string).toLowerCase().equals((Object)".m4p")) {
            return this.U3(string, false);
        }
        this.Q3(this.getResources().getString(2131821317));
        return false;
    }

    static /* synthetic */ void g1(MainActivity mainActivity) {
        mainActivity.N3();
    }

    public static void g2(View view, boolean bl, int n2) {
        view.setVisibility(0);
        if (!bl) {
            view.setAlpha(0.01f);
            view.animate().alpha(1.0f).setDuration((long)n2).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(view){
                final /* synthetic */ View a;
                {
                    this.a = view;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    this.a.setVisibility(0);
                }
            });
        }
    }

    static /* synthetic */ int h1(MainActivity mainActivity) {
        return mainActivity.Y0;
    }

    public static void h2(View view, boolean bl, int n2) {
        if (bl) {
            view.setVisibility(4);
            return;
        }
        view.animate().alpha(0.0f).setDuration((long)n2).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(view){
            final /* synthetic */ View a;
            {
                this.a = view;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.a.setVisibility(4);
            }
        });
    }

    private /* synthetic */ void h3(c.d.a.a.m.f.d d2) {
        if (d2 == c.d.a.a.m.d.h) {
            this.S4();
            this.z2();
            this.t2(true);
        }
    }

    private void h4() {
        SharedPreferences sharedPreferences = androidx.preference.j.b((Context)this.getApplicationContext());
        boolean bl = sharedPreferences.getBoolean("preferences_link", false);
        int n2 = sharedPreferences.getInt("com.smp.PREF_PLAY_MODE", 1);
        boolean bl2 = sharedPreferences.getBoolean("preferences_shuffle", false);
        this.G4(n2);
        this.s4(bl);
        this.L4(bl2);
        this.x2(com.smp.musicspeed.utils.k.s(), bl);
    }

    private void h5() {
        this.startActivity(new Intent((Context)this, SleepTimerActivity.class));
    }

    static /* synthetic */ boolean i1() {
        return E;
    }

    private void i2() {
        TypedArray typedArray;
        int[] arrn = new int[]{2130969435};
        if (com.smp.musicspeed.utils.t.w((Context)this)) {
            typedArray = this.obtainStyledAttributes(2131886111, arrn);
            this.K = Color.parseColor((String)typedArray.getString(0));
        } else {
            typedArray = this.obtainStyledAttributes(2131886112, arrn);
            this.K = Color.parseColor((String)typedArray.getString(0));
        }
        typedArray.recycle();
    }

    private void i4() {
        com.smp.musicspeed.ads.p p2 = this.k1;
        if (p2 != null) {
            p2.d();
            this.c4();
        }
    }

    private void i5(String string) {
        boolean bl = true;
        if (string != null && this.h0 != null) {
            this.T3();
            String string2 = this.h0.A();
            this.T.setTitle((CharSequence)string2);
            this.B2(bl);
            bl = false;
        }
        if (bl) {
            this.V0.r0(4);
            this.B2(false);
        }
    }

    static /* synthetic */ boolean j1(boolean bl) {
        E = bl;
        return bl;
    }

    private void j2() {
        TypedArray typedArray;
        int[] arrn = new int[]{2130969695};
        if (com.smp.musicspeed.utils.t.w((Context)this)) {
            typedArray = this.obtainStyledAttributes(2131886111, arrn);
            this.Y0 = Color.parseColor((String)typedArray.getString(0));
        } else {
            typedArray = this.obtainStyledAttributes(2131886112, arrn);
            this.Y0 = Color.parseColor((String)typedArray.getString(0));
        }
        typedArray.recycle();
    }

    public static /* synthetic */ void j3(MainActivity mainActivity) {
        mainActivity.i4();
    }

    private boolean j4() {
        if (this.h0.t() == null) {
            this.h0.d0();
            return true;
        }
        return false;
    }

    private /* synthetic */ void k3() {
        this.i4();
    }

    private void k4() {
        this.Z.setOnSeekBarChangeListener(null);
        this.Y.setOnSeekBarChangeListener(null);
        this.X.setOnSeekBarChangeListener(null);
        if (this.W0.getViewTreeObserver().isAlive()) {
            this.W0.getViewTreeObserver().removeOnScrollChangedListener(this.X0);
        }
    }

    private void k5() {
        this.o1 = this.A1.postDelayed((Runnable)new z(this), 400L);
    }

    static /* synthetic */ void l0(MainActivity mainActivity) {
        mainActivity.S1();
    }

    static /* synthetic */ void l1(MainActivity mainActivity) {
        mainActivity.O4();
    }

    private void l4() {
        this.W.post((Runnable)new com.smp.musicspeed.n(this));
    }

    private void l5() {
        if (!F) {
            return;
        }
        PlayFileService playFileService = this.h0;
        if (playFileService != null && playFileService.t() != null) {
            com.smp.musicspeed.reverse.b.N(this.h0.t(), "com.smp.musicspeed.action.REVERSE").M(this.R(), "ReverseDialogFragment");
            return;
        }
        this.Q3(this.getResources().getString(2131821351));
    }

    static /* synthetic */ com.smp.musicspeed.ads.p m0(MainActivity mainActivity) {
        return mainActivity.k1;
    }

    static /* synthetic */ boolean m1(MainActivity mainActivity) {
        return mainActivity.P1();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void m3(List var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:885)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    private void m4() {
        double d2 = 5.0 * ((double)this.h0.s() / 1000000.0);
        if (d2 > 2000.0) {
            d2 = 2000.0;
        }
        ViewGroup.LayoutParams layoutParams = this.O0.getLayoutParams();
        layoutParams.width = Math.min((int)((int)com.smp.musicspeed.utils.t.b((Context)this, (float)d2)), (int)MainActivity.p2());
        this.O0.setLayoutParams(layoutParams);
        this.P4();
    }

    static /* synthetic */ int n0(MainActivity mainActivity, float f2, int n2, int n3) {
        return mainActivity.N2(f2, n2, n3);
    }

    static /* synthetic */ void n1(MainActivity mainActivity) {
        mainActivity.w5();
    }

    private void n4() {
        if (!com.smp.musicspeed.utils.t.o((Context)this).getBoolean("com.smp.has_tested_pvdr", false)) {
            TestService.a(this.getApplicationContext());
            com.smp.musicspeed.utils.t.p((Context)this).putBoolean("com.smp.has_tested_pvdr", true).apply();
        }
    }

    private void n5() {
        this.h0.p();
    }

    static /* synthetic */ FloatingActionButton o0(MainActivity mainActivity) {
        return mainActivity.k0;
    }

    static /* synthetic */ View o1(MainActivity mainActivity) {
        return mainActivity.U;
    }

    private /* synthetic */ void o3() {
        if (this.h0 != null) {
            this.t2(true);
            this.F4(this.h0.x());
            this.O4();
            this.D4(this.h0.w());
            this.M4(this.h0.z());
            this.I4(this.h0.y());
            this.N4(this.h0.z());
            this.E4(this.h0.w());
            this.J4(this.h0.y());
            this.y2();
            this.v2();
            this.r4(this.h0.s());
            this.H4(this.h0.x());
            this.W.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this.i0);
            this.S1();
            this.D2(true);
        }
    }

    private void o4() {
        if (this.V0.Y() == 4) {
            com.smp.musicspeed.utils.k.M((Context)this, false);
            com.smp.musicspeed.utils.k.L((Context)this, false);
            this.D2(true);
        }
    }

    private void o5() {
        this.h0.stopForeground(true);
        com.smp.musicspeed.utils.j.a((Context)this, 6675451);
        this.h0.C0(true);
    }

    static /* synthetic */ boolean p0(MainActivity mainActivity) {
        return mainActivity.s1;
    }

    static /* synthetic */ ServiceConnection p1(MainActivity mainActivity) {
        return mainActivity.y1;
    }

    public static int p2() {
        EGL10 eGL10 = (EGL10)EGLContext.getEGL();
        EGLDisplay eGLDisplay = eGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        eGL10.eglInitialize(eGLDisplay, new int[2]);
        int[] arrn = new int[1];
        eGL10.eglGetConfigs(eGLDisplay, null, 0, arrn);
        EGLConfig[] arreGLConfig = new EGLConfig[arrn[0]];
        eGL10.eglGetConfigs(eGLDisplay, arreGLConfig, arrn[0], arrn);
        int[] arrn2 = new int[1];
        int n2 = 0;
        for (int i2 = 0; i2 < arrn[0]; ++i2) {
            eGL10.eglGetConfigAttrib(eGLDisplay, arreGLConfig[i2], 12332, arrn2);
            if (n2 >= arrn2[0]) continue;
            n2 = arrn2[0];
        }
        eGL10.eglTerminate(eGLDisplay);
        return Math.max((int)n2, (int)2048);
    }

    private void p5(int n2) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null && !playFileService.D0(n2)) {
            this.d4();
        }
    }

    static /* synthetic */ boolean q0(MainActivity mainActivity, boolean bl) {
        mainActivity.s1 = bl;
        return bl;
    }

    private /* synthetic */ void q3(Boolean bl) {
        if (bl.booleanValue()) {
            this.w2();
            this.L2();
            this.J1();
            return;
        }
        this.N1();
        if (((Boolean)com.smp.musicspeed.ads.x.f.b().f()).booleanValue()) {
            this.w2();
            this.L2();
        }
    }

    private void q4(BeatStartRecord beatStartRecord) {
        this.B4(beatStartRecord);
        this.y4(beatStartRecord);
        this.C4(beatStartRecord);
        this.A4(beatStartRecord);
    }

    /*
     * Exception decompiling
     */
    private boolean q5() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl15 : ICONST_3 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    static /* synthetic */ boolean r0(MainActivity mainActivity) {
        return mainActivity.t1;
    }

    public static View r2(Toolbar toolbar) {
        boolean bl = true ^ TextUtils.isEmpty((CharSequence)toolbar.getNavigationContentDescription());
        String string = bl ? toolbar.getNavigationContentDescription().toString() : "navigationIcon";
        toolbar.setNavigationContentDescription((CharSequence)string);
        ArrayList arrayList = new ArrayList();
        toolbar.findViewsWithText(arrayList, (CharSequence)string, 2);
        View view = arrayList.size() > 0 ? (View)arrayList.get(0) : null;
        if (!bl) {
            toolbar.setNavigationContentDescription(null);
        }
        return view;
    }

    private void r4(long l2) {
        if (l2 < 0L) {
            this.f0.setText((CharSequence)"--:--");
            return;
        }
        com.smp.musicspeed.utils.p p2 = new com.smp.musicspeed.utils.p(l2);
        this.f0.setText((CharSequence)p2.toString());
    }

    private void r5(boolean bl) {
        this.W.setEnabled(bl);
        this.X.setEnabled(bl);
        this.Y.setEnabled(bl);
        this.Z.setEnabled(bl);
        this.W0.setOnTouchListener(new View.OnTouchListener(this){
            final /* synthetic */ MainActivity f;
            {
                this.f = mainActivity;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true ^ MainActivity.D0(this.f).isEnabled();
            }
        });
    }

    static /* synthetic */ boolean s0(MainActivity mainActivity, boolean bl) {
        mainActivity.t1 = bl;
        return bl;
    }

    static /* synthetic */ void s1(MainActivity mainActivity, boolean bl) {
        mainActivity.D2(bl);
    }

    private void s2() {
        this.C2();
        this.I2();
    }

    private /* synthetic */ void s3(View view) {
        this.Z3();
    }

    private void s4(boolean bl) {
        if (!bl) {
            com.smp.musicspeed.utils.t.c0((Context)this, 2131230952, (ImageView)this.t0, this.K);
            com.smp.musicspeed.utils.t.c0((Context)this, 2131230952, (ImageView)this.u0, this.K);
            return;
        }
        com.smp.musicspeed.utils.t.c0((Context)this, 2131230952, (ImageView)this.t0, com.smp.musicspeed.utils.t.c((Context)this));
        com.smp.musicspeed.utils.t.c0((Context)this, 2131230952, (ImageView)this.u0, com.smp.musicspeed.utils.t.c((Context)this));
    }

    private List<Uri> s5(Intent intent) {
        ArrayList arrayList = new ArrayList();
        ClipData clipData = intent.getClipData();
        if (clipData != null) {
            for (int i2 = 0; i2 < clipData.getItemCount(); ++i2) {
                arrayList.add((Object)clipData.getItemAt(i2).getUri());
            }
        } else if (intent.getData() != null) {
            arrayList.add((Object)intent.getData());
        }
        return arrayList;
    }

    static /* synthetic */ int t0(MainActivity mainActivity) {
        return mainActivity.q1;
    }

    private void t2(boolean bl) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            if (playFileService.v() != Long.MIN_VALUE) {
                this.r0.setImageResource(2131231116);
            } else {
                this.r0.setImageResource(2131231117);
            }
            if (this.h0.u() != Long.MIN_VALUE) {
                this.s0.setImageResource(2131231118);
            } else {
                this.s0.setImageResource(2131231119);
            }
            if (this.h0.E()) {
                if (this.m0.getVisibility() == 4) {
                    this.m0.setVisibility(0);
                }
            } else if (this.m0.getVisibility() == 0) {
                this.m0.setVisibility(4);
            }
        } else {
            com.smp.musicspeed.utils.t.c0((Context)this, 2131230889, (ImageView)this.r0, this.K);
            com.smp.musicspeed.utils.t.c0((Context)this, 2131230901, (ImageView)this.s0, this.K);
        }
        this.P4();
        this.c5(bl);
    }

    private void t4(boolean bl) {
        if (bl) {
            this.z0.setVisibility(8);
            this.y0.setVisibility(8);
            this.A0.setVisibility(0);
        } else {
            this.z0.setVisibility(0);
            this.y0.setVisibility(0);
            this.A0.setVisibility(8);
        }
        this.K4();
    }

    private int t5(boolean bl) {
        if (bl) {
            return 0;
        }
        return 8;
    }

    static /* synthetic */ int u0(MainActivity mainActivity, int n2) {
        mainActivity.q1 = n2;
        return n2;
    }

    static /* synthetic */ TextView u1(MainActivity mainActivity) {
        return mainActivity.e0;
    }

    /*
     * Exception decompiling
     */
    private void u2() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl26.1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    private /* synthetic */ void u3(com.smp.musicspeed.utils.r r2) {
        PlayFileService playFileService;
        boolean bl = com.smp.musicspeed.utils.t.o((Context)this).getBoolean("preferences_link", false);
        this.g0.setVisibility(this.t5(r2.i()));
        this.x2(r2.l(), bl);
        this.G2();
        Menu menu = this.T.getMenu();
        if (menu != null) {
            com.smp.musicspeed.utils.k.F(menu);
        }
        if ((r2.b() || r2.g()) && (playFileService = this.h0) != null && playFileService.t() != null) {
            com.smp.musicspeed.bpmkey.a.f.h(this.h0.t());
        }
        this.K2();
    }

    private int u5(boolean bl) {
        if (bl) {
            return 0;
        }
        return 4;
    }

    static /* synthetic */ int v0(MainActivity mainActivity, int n2) {
        int n3;
        mainActivity.q1 = n3 = mainActivity.q1 - n2;
        return n3;
    }

    static /* synthetic */ Runnable v1(MainActivity mainActivity) {
        return mainActivity.w1;
    }

    private void v2() {
        MenuItem menuItem = this.T.getMenu().findItem(2131296352);
        if (PlayFileService.g) {
            menuItem.setIcon(2131230977);
            return;
        }
        menuItem.setIcon(2131230982);
    }

    private float v5(long l2) {
        long l3 = this.h0.s();
        if (l2 == Long.MIN_VALUE) {
            return -1.0f;
        }
        if (l2 >= l3) {
            return 1.0f;
        }
        return (float)((double)l2 / (double)l3);
    }

    static /* synthetic */ int w0() {
        return G;
    }

    static /* synthetic */ void w1(MainActivity mainActivity, View view, float f2) {
        mainActivity.A1(view, f2);
    }

    private void w2() {
        if (Build.VERSION.SDK_INT >= 21) {
            int n2 = com.smp.musicspeed.utils.k.E((Context)this) && this.getResources().getConfiguration().orientation != 2 ? com.smp.musicspeed.utils.t.Q((Context)this, 2130968792, 0) : b.i.h.a.c((Context)this, (int)2131099924);
            this.getWindow().setNavigationBarColor(n2);
        }
    }

    private /* synthetic */ void w3(List list) {
        List<AudioWaveView.a> list2 = h0.a(this.O0, (List<MarkerItem>)list);
        this.O0.setMarkers(list2);
    }

    private void w5() {
        this.W0.setVisibility(8);
        this.z2();
        this.t2(true);
    }

    static /* synthetic */ void x0(MainActivity mainActivity, double d2, boolean bl) {
        mainActivity.d2(d2, bl);
    }

    static /* synthetic */ View x1(MainActivity mainActivity) {
        return mainActivity.T0;
    }

    private void x2(boolean bl, boolean bl2) {
        if (!bl) {
            this.A0.setVisibility(8);
            this.z0.setVisibility(8);
            this.y0.setVisibility(8);
            return;
        }
        if (bl2) {
            this.A0.setVisibility(0);
            this.z0.setVisibility(8);
            this.y0.setVisibility(8);
            return;
        }
        this.z0.setVisibility(0);
        this.y0.setVisibility(0);
        this.A0.setVisibility(8);
    }

    private void x5() {
        ScrollView scrollView = this.h1;
        scrollView.setPadding(scrollView.getPaddingLeft(), this.h1.getPaddingTop(), this.h1.getPaddingRight(), 0);
        this.U.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.W0.getLayoutParams();
        layoutParams.height = 0;
        this.W0.setLayoutParams(layoutParams);
        this.O0.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this){
            final /* synthetic */ MainActivity f;
            {
                this.f = mainActivity;
            }

            public void onLayoutChange(View view, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
                if (!MainActivity.m1(this.f)) {
                    MainActivity.n1(this.f);
                    return;
                }
                MainActivity.l1(this.f);
                view.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
            }
        });
    }

    static /* synthetic */ Runnable y0(MainActivity mainActivity) {
        return mainActivity.p1;
    }

    private void y1(Fragment fragment, boolean bl) {
        com.smp.musicspeed.utils.t.u((Activity)this);
        int n2 = this.o2();
        if (n2 > 0) {
            Fragment fragment2 = this.n2(n2 - 1);
            if (fragment2 == null) {
                return;
            }
            if (fragment.getClass().equals((Object)fragment2.getClass()) && !bl) {
                return;
            }
        }
        this.R().n().g(null).w(4097).r(2131296591, fragment, Integer.toString((int)this.o2())).i();
        if (bl) {
            this.z1(1 + this.o2());
        }
    }

    private void y2() {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            if (playFileService.F()) {
                this.k0.setImageDrawable(AnimatedVectorDrawable.getDrawable((Context)this, 2131230985).mutate());
                return;
            }
            this.k0.setImageDrawable(AnimatedVectorDrawable.getDrawable((Context)this, 2131230975).mutate());
        }
    }

    private /* synthetic */ void y3(Boolean bl) {
        this.K2();
    }

    @SuppressLint(value={"SetTextI18n"})
    private void y4(BeatStartRecord beatStartRecord) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null && beatStartRecord != null) {
            this.H0.setText((CharSequence)com.smp.musicspeed.utils.n.c(Math.round((float)(beatStartRecord.bpmcurrent * playFileService.z()))));
            this.L0.setText((CharSequence)com.smp.musicspeed.utils.n.c(Math.round((float)(beatStartRecord.bpmcurrent * this.h0.z()))));
        }
    }

    private void y5(int n2) {
        ScrollView scrollView = this.h1;
        int n3 = scrollView.getPaddingLeft();
        int n4 = this.h1.getPaddingTop();
        int n5 = this.h1.getPaddingRight();
        float f2 = n2;
        scrollView.setPadding(n3, n4, n5, (int)com.smp.musicspeed.utils.t.b((Context)this, f2));
        this.U.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.W0.getLayoutParams();
        layoutParams.height = (int)com.smp.musicspeed.utils.t.b((Context)this, f2);
        this.W0.setLayoutParams(layoutParams);
        this.O0.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this){
            final /* synthetic */ MainActivity f;
            {
                this.f = mainActivity;
            }

            public void onLayoutChange(View view, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
                MainActivity.l1(this.f);
                view.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
            }
        });
    }

    static /* synthetic */ ImageButton z0(MainActivity mainActivity) {
        return mainActivity.P;
    }

    private void z1(int n2) {
        this.R().n().g(null).c(2131296591, (Fragment)new e0(), Integer.toString((int)n2)).i();
    }

    private void z2() {
        if (this.W0.getVisibility() == 0) {
            if (Build.VERSION.SDK_INT <= 22) {
                this.W.getProgressDrawable().setColorFilter((ColorFilter)new PorterDuffColorFilter(b.i.h.d.f.a((Resources)this.getResources(), (int)17170445, null), PorterDuff.Mode.SRC_IN));
                this.W.setThumb(b.i.h.d.f.b((Resources)this.getResources(), (int)2131231149, null));
                this.W.getThumb().setColorFilter((ColorFilter)new PorterDuffColorFilter(b.i.h.d.f.a((Resources)this.getResources(), (int)2131100033, null), PorterDuff.Mode.SRC_IN));
                return;
            }
            this.W.setThumb(this.P0);
            this.W.setProgressDrawable(this.Q0);
            return;
        }
        this.W.setThumb(b.i.h.d.f.b((Resources)this.getResources(), (int)2131231149, null));
        this.W.setProgressDrawable((Drawable)new ColorDrawable(b.i.h.d.f.a((Resources)this.getResources(), (int)17170445, null)));
    }

    private void z4(int n2, Intent intent) {
        this.x0 = this.getIntent();
        E = true;
        if (n2 == 7654) {
            intent.setAction("com.smp.musicpseed.add_to_playingqueue_action");
        }
        this.setIntent(intent);
    }

    private float z5(int n2) {
        float f2 = (float)n2 / (float)this.O0.getWidth();
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        return f2;
    }

    public /* synthetic */ void B3(Boolean bl) {
        this.A3(bl);
    }

    @Override
    public long C() {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            return playFileService.u();
        }
        return Long.MIN_VALUE;
    }

    @Override
    public void D(int n2) {
        com.smp.musicspeed.bpmkey.a a2 = com.smp.musicspeed.bpmkey.a.f;
        BeatStartRecord beatStartRecord = (BeatStartRecord)a2.d().f();
        beatStartRecord.keycurrent = n2;
        if (this.h0 != null) {
            a2.i(beatStartRecord.filename, beatStartRecord.bpmcurrent, n2);
            this.C4(beatStartRecord);
            this.A4(beatStartRecord);
        }
    }

    public /* synthetic */ void D3(BeatStartRecord beatStartRecord) {
        this.C3(beatStartRecord);
    }

    public /* synthetic */ void F3(List list, Boolean bl) {
        this.E3(list, bl);
    }

    @Override
    public void G() {
        this.setIntent(this.x0);
    }

    @Override
    public void H(float f2) {
        com.smp.musicspeed.bpmkey.a a2 = com.smp.musicspeed.bpmkey.a.f;
        BeatStartRecord beatStartRecord = (BeatStartRecord)a2.d().f();
        beatStartRecord.bpmcurrent = f2;
        if (this.h0 != null) {
            a2.i(beatStartRecord.filename, f2, beatStartRecord.keycurrent);
            this.B4(beatStartRecord);
            this.y4(beatStartRecord);
        }
    }

    public /* synthetic */ void H3(Integer n2) {
        this.G3(n2);
    }

    public void I(b.o.b.b<WaveformRecord> b2) {
    }

    public void I2() {
        Fragment fragment;
        com.smp.musicspeed.utils.t.u((Activity)this);
        FragmentManager fragmentManager = this.R();
        if (com.smp.musicspeed.utils.k.y((Context)this) != 0 && this.Q2()) {
            if (com.smp.musicspeed.utils.k.y((Context)this) == 3) {
                if (fragmentManager.j0("fragment_library") instanceof com.smp.musicspeed.f0.a) {
                    return;
                }
                fragment = new com.smp.musicspeed.f0.a();
            } else if (com.smp.musicspeed.utils.k.y((Context)this) == 1) {
                com.smp.musicspeed.k0.m0.g.a.a(this);
                if (fragmentManager.j0("fragment_library") instanceof com.smp.musicspeed.folders.v) {
                    return;
                }
                fragment = com.smp.musicspeed.folders.v.d0((Context)this);
            } else {
                if (fragmentManager.j0("fragment_library") instanceof com.smp.musicspeed.recorder.x) {
                    return;
                }
                fragment = com.smp.musicspeed.recorder.x.T();
            }
        } else {
            if (fragmentManager.j0("fragment_library") instanceof com.smp.musicspeed.k0.x) {
                return;
            }
            fragment = new com.smp.musicspeed.k0.x();
        }
        for (int i2 = 0; i2 < fragmentManager.o0(); ++i2) {
            fragmentManager.Y0();
        }
        fragmentManager.n().r(2131296590, fragment, "fragment_library").i();
    }

    @Override
    public void J() {
        if (this.w0 != null && !AppPrefs.k.D() && !((Boolean)com.smp.musicspeed.ads.x.f.b().f()).booleanValue()) {
            this.w0.a((Activity)this);
        }
    }

    public /* synthetic */ void J3(boolean bl) {
        this.I3(bl);
    }

    public void K1() {
        this.i0.c(false);
        this.W0.c();
    }

    public /* synthetic */ void L3() {
        this.K3();
    }

    public boolean Q2() {
        return b.i.h.a.a((Context)this, (String)"android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public /* synthetic */ void S2(int n2) {
        this.R2(n2);
    }

    public /* synthetic */ void U2() {
        this.T2();
    }

    public void W1() {
        Intent intent = this.V1();
        Intent intent2 = Intent.createChooser((Intent)intent, (CharSequence)this.getString(2131820775));
        if (intent.getAction().equals((Object)"android.intent.action.OPEN_DOCUMENT")) {
            try {
                this.startActivityForResult(intent, 7654);
                return;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                Intent intent3 = this.V1();
                intent3.setAction("android.intent.action.GET_CONTENT");
                this.startActivityForResult(Intent.createChooser((Intent)intent3, (CharSequence)this.getString(2131820775)), 7654);
                return;
            }
        }
        this.startActivityForResult(intent2, 7654);
    }

    public /* synthetic */ void W2(String string, int n2, File file) {
        this.V2(string, n2, file);
    }

    public void W3(b.o.b.b<WaveformRecord> b2, WaveformRecord waveformRecord) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            this.O0.setTag((Object)playFileService.t());
        }
        this.S3(waveformRecord);
    }

    public void X4() {
        this.startActivity(new Intent((Context)this, AboutActivity.class));
    }

    public /* synthetic */ boolean Y2(View view, MotionEvent motionEvent) {
        return this.X2(view, motionEvent);
    }

    public void Z3() {
        if (this.V0.Y() == 3) {
            this.V0.r0(4);
            return;
        }
        this.V0.r0(3);
    }

    public void a2() {
        Snackbar snackbar = this.E1;
        if (snackbar != null && snackbar.I()) {
            this.E1.v();
        }
    }

    public /* synthetic */ boolean a3(MenuItem menuItem) {
        return this.Z2(menuItem);
    }

    void a4() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts((String)"package", (String)this.getPackageName(), null));
        intent.addFlags(268435456);
        this.startActivity(intent);
    }

    public void a5() {
        this.startActivity(new Intent((Context)this, HelpActivity.class));
    }

    public float b4() {
        long l2 = this.Y1();
        if (AppPrefs.k.B()) {
            l2 = this.j5(l2);
        }
        return this.v5(l2);
    }

    @Override
    public void c(float f2) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            playFileService.v0(f2);
        }
    }

    public /* synthetic */ boolean c3(View view, MotionEvent motionEvent) {
        return this.b3(view, motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        if (this.l1) {
            return true;
        }
        return Activity.super.dispatchTouchEvent(motionEvent);
    }

    public /* synthetic */ void e3(Boolean bl) {
        this.d3(bl);
    }

    /*
     * Exception decompiling
     */
    public void e4(Intent var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl61.1 : ICONST_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    void e5(i.a.b b2) {
        this.d5(2131821183, b2);
    }

    @Override
    public long f() {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            return playFileService.v();
        }
        return Long.MIN_VALUE;
    }

    public void f2() {
        SharedPreferences sharedPreferences = com.smp.musicspeed.utils.t.o((Context)this);
        String string = sharedPreferences.getString("preferences_store_path", "XxXXXFAKE");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (string.equals((Object)"XxXXXFAKE")) {
            editor.putString("preferences_store_path", com.smp.musicspeed.utils.g.g(com.smp.musicspeed.utils.t.i((Context)this)).getAbsolutePath());
        }
        editor.apply();
    }

    public void f5(boolean bl) {
        if (!AppPrefs.k.D()) {
            if (!F) {
                return;
            }
            com.smp.musicspeed.ads.u.w.a(bl).M(this.R(), "RemoveAdsDialogFragment");
        }
    }

    public /* synthetic */ void g3(Boolean bl) {
        this.f3(bl);
    }

    /*
     * Exception decompiling
     */
    public void g4(Intent var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl26.1 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public void g5(boolean bl) {
        this.f2();
        Intent intent = new Intent((Context)this, SettingsActivity.class);
        if (bl) {
            intent.putExtra("showCustom", true);
        }
        this.startActivity(intent);
    }

    @Override
    public long getDuration() {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            return playFileService.s();
        }
        return Long.MIN_VALUE;
    }

    @Override
    public String getFileName() {
        PlayFileService playFileService;
        if (J && (playFileService = this.h0) != null) {
            return playFileService.t();
        }
        return null;
    }

    @Override
    public void h(com.michaelflisar.gdprdialog.e e2, boolean bl) {
        this.e2();
    }

    @Override
    public void i() {
        this.Q3(this.getString(2131821340));
    }

    public /* synthetic */ void i3(c.d.a.a.m.f.d d2) {
        this.h3(d2);
    }

    @Override
    public void j(int n2, List<MediaTrack> list) {
        this.A1.post((Runnable)new com.smp.musicspeed.i(this, list, n2));
    }

    public long j5(long l2) {
        PlayFileService playFileService;
        BeatStartRecord beatStartRecord = (BeatStartRecord)com.smp.musicspeed.bpmkey.a.f.d().f();
        if (beatStartRecord != null && (playFileService = this.h0) != null && playFileService.t() != null) {
            if (!this.h0.t().equals((Object)beatStartRecord.filename)) {
                return l2;
            }
            float f2 = beatStartRecord.bpmoriginal;
            if (f2 > 0.0f) {
                long l3;
                double d2 = 6.0E7 / (double)f2;
                long l4 = l2 < (l3 = (long)(1000.0f * beatStartRecord.beatstartms)) ? 0L : Math.round((double)((double)(l2 - l3) / d2));
                long l5 = l3 + Math.round((double)(d2 * (double)l4));
                if (l5 > this.h0.s() && l4 > 0L) {
                    l5 -= Math.round((double)d2);
                }
                return l5;
            }
        }
        return l2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void k(double d2, int n2, int n3, boolean bl) {
        if (!bl) {
            this.Q3(this.getResources().getString(2131821319));
            return;
        }
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            if (n2 != 100) {
                                return;
                            }
                            if (d2 < -15.0) {
                                d2 = -15.0;
                            } else if (d2 > 15.0) {
                                d2 = 15.0;
                            }
                            ((EqualizerFragment)this.R().i0(2131296713)).j0(n3, (float)d2);
                            return;
                        }
                        if (d2 < -15.0) {
                            d2 = -15.0;
                        } else if (d2 > 15.0) {
                            d2 = 15.0;
                        }
                        ((EqualizerFragment)this.R().i0(2131296713)).f0((float)d2);
                        return;
                    }
                    if (d2 < -15.0) {
                        d2 = -15.0;
                    } else if (d2 > 15.0) {
                        d2 = 15.0;
                    }
                    ((EqualizerFragment)this.R().i0(2131296713)).l0((float)d2);
                    return;
                }
                double d3 = d2 / 100.0;
                float f2 = A;
                if (d3 < (double)f2 || d3 > (double)(f2 = D)) {
                    d3 = f2;
                }
                int n4 = this.E1(d3);
                this.Z.setProgress(n4);
                float f3 = (float)d3;
                this.h0.s0(f3);
                this.J4(f3);
                return;
            }
            double d4 = d2 / 100.0;
            float f4 = A;
            if (d4 < (double)f4 || d4 > (double)(f4 = D)) {
                d4 = f4;
            }
            int n5 = this.F1(d4);
            this.Y.setProgress(n5);
            float f5 = (float)d4;
            this.h0.u0(f5);
            this.N4(f5);
            return;
        }
        float f6 = y;
        if (d2 < (double)f6 || d2 > (double)(f6 = x)) {
            d2 = f6;
        }
        int n6 = this.D1(d2);
        this.X.setProgress(n6);
        float f7 = (float)d2;
        this.h0.r0(f7);
        this.E4(f7);
    }

    public void k2() {
        int n2 = this.getResources().getConfiguration().screenWidthDp;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.v0.getLayoutParams();
        if (n2 < 360) {
            layoutParams.addRule(17, 2131297214);
            ((RelativeLayout.LayoutParams)((LinearLayout)this.findViewById(2131296828)).getLayoutParams()).addRule(17, 2131297215);
            if (this.getResources().getString(2131820801).length() > 7 || this.getString(2131820802).length() > 7) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)this.r0.getLayoutParams();
                layoutParams2.width = (int)MainActivity.U1(48.0f, (Context)this);
                this.r0.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams)this.s0.getLayoutParams();
                layoutParams3.width = (int)MainActivity.U1(48.0f, (Context)this);
                this.s0.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
                ImageButton imageButton = (ImageButton)this.findViewById(2131296497);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams)imageButton.getLayoutParams();
                layoutParams4.width = (int)MainActivity.U1(48.0f, (Context)this);
                imageButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
                return;
            }
        } else {
            layoutParams.addRule(14);
        }
    }

    public com.smp.musicspeed.playingqueue.h l2() {
        return ((com.smp.musicspeed.playingqueue.r)this.R().j0("data provider")).t();
    }

    public /* synthetic */ void l3() {
        this.k3();
    }

    public long m2() {
        return this.h0.s() / 1000L;
    }

    public void m5() {
        if (!F) {
            return;
        }
        this.f2();
        String string = this.getResources().getString(2131821352);
        String string2 = this.getResources().getString(2131821351);
        if (this.h0.t() != null) {
            if (!com.smp.musicspeed.utils.t.C((Context)this, FileWriterService.class)) {
                com.smp.musicspeed.filewriter.i.U(this.h0.t(), this.h0.A(), this.h0.z(), this.h0.w(), this.h0.y(), com.smp.musicspeed.utils.t.A((Context)this), com.smp.musicspeed.utils.t.B((Context)this), this.h0.v(), this.h0.u()).M(this.R(), "RenameDialogFormat");
                return;
            }
            this.Q3(string);
            return;
        }
        this.Q3(string2);
    }

    public Fragment n2(int n2) {
        if (this.o2() > 0) {
            return this.R().j0(Integer.toString((int)n2));
        }
        return null;
    }

    public /* synthetic */ void n3(List list, int n2) {
        this.m3(list, n2);
    }

    @Override
    public void o() {
        this.Q3(this.getResources().getString(2131821319));
    }

    public int o2() {
        return this.R().o0();
    }

    /*
     * Exception decompiling
     */
    protected void onActivityResult(int var1, int var2, Intent var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public void onBackPressed() {
        j.a.a.a.f f2;
        if (!F) {
            return;
        }
        j.a.a.a.f f3 = this.m1;
        if (f3 != null && f3.isShown()) {
            this.m1.p();
        }
        if ((f2 = this.n1) != null && f2.isShown()) {
            this.n1.p();
        }
        this.o4();
        int n2 = this.o2();
        if (com.smp.musicspeed.utils.k.D((Context)this)) {
            this.b2();
            return;
        }
        if (com.smp.musicspeed.utils.k.E((Context)this)) {
            this.V0.r0(4);
            return;
        }
        int n3 = 1;
        if (n2 == 0) {
            Fragment fragment = this.R().j0("fragment_library");
            if (fragment instanceof com.smp.musicspeed.folders.v) {
                n3 ^= ((com.smp.musicspeed.folders.v)fragment).G();
            }
            if (n3 != 0) {
                ComponentActivity.super.onBackPressed();
                return;
            }
        } else {
            if (this.n2(n2 - n3) instanceof e0) {
                this.R().Y0();
                this.R().Y0();
                this.V0.r0(3);
                return;
            }
            com.smp.musicspeed.utils.t.u((Activity)this);
            this.R().Y0();
        }
    }

    public void onBalanceKeys(View view) {
        this.Y4(5);
    }

    protected void onCreate(Bundle bundle) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        ViewGroup viewGroup4;
        this.J2();
        this.setTheme(com.smp.musicspeed.utils.o.c((Context)this));
        super.onCreate(bundle);
        this.setContentView(2131492896);
        DefaultLayoutPromptView defaultLayoutPromptView = this.F2();
        if (bundle == null) {
            this.s2();
            BasePromptViewConfig.b b2 = new BasePromptViewConfig.b().l(this.getString(2131821383)).k(this.getString(2131821382)).j(this.getString(2131821381)).f(this.getString(2131821187)).e(this.getString(2131821186)).d(this.getString(2131821138)).c(this.getString(2131821137)).b(this.getString(2131821136)).i(this.getString(2131820829)).h(20000);
            b2.g(this.getString(2131821190));
            defaultLayoutPromptView.k(b2.a());
            c.d.a.a.m.a.k().o((com.github.stkent.amplify.prompt.i.b)defaultLayoutPromptView);
        }
        this.N = this.getResources().getInteger(2131361803);
        this.O = this.getResources().getInteger(2131361802);
        this.V = (ConstraintLayout)this.findViewById(2131297026);
        this.W = (AppCompatSeekBar)this.findViewById(2131297103);
        this.Y = (AppCompatSeekBar)this.findViewById(2131297106);
        this.X = (AppCompatSeekBar)this.findViewById(2131297102);
        this.Z = (AppCompatSeekBar)this.findViewById(2131297105);
        this.P0 = this.W.getThumb();
        this.Q0 = this.W.getProgressDrawable();
        this.a0 = (TextView)this.findViewById(2131297023);
        this.b0 = (TextView)this.findViewById(2131297185);
        this.c0 = (TextView)this.findViewById(2131297053);
        this.d0 = (TextView)this.findViewById(16908310);
        this.e0 = (TextView)this.findViewById(2131297222);
        this.f0 = (TextView)this.findViewById(2131297206);
        this.k0 = (FloatingActionButton)this.findViewById(2131296508);
        this.j0 = (ImageButton)this.findViewById(2131296494);
        this.l0 = (ImageButton)this.findViewById(2131296489);
        this.r0 = (ImageButton)this.findViewById(2131296496);
        this.s0 = (ImageButton)this.findViewById(2131296495);
        this.m0 = (ImageButton)this.findViewById(2131296488);
        this.o0 = (ImageButton)this.findViewById(2131296527);
        this.n0 = (ImageButton)this.findViewById(2131296530);
        this.p0 = (ImageButton)this.findViewById(2131296529);
        this.q0 = (ImageButton)this.findViewById(2131296523);
        this.t0 = (ImageButton)this.findViewById(2131296492);
        this.u0 = (ImageButton)this.findViewById(2131296493);
        this.B0 = (ImageButton)this.findViewById(2131296531);
        this.y0 = this.findViewById(2131296555);
        this.z0 = this.findViewById(2131296547);
        this.A0 = this.findViewById(2131296549);
        this.g0 = this.findViewById(2131296544);
        this.C0 = viewGroup2 = (ViewGroup)this.findViewById(2131296554);
        this.G0 = (TextView)viewGroup2.findViewById(2131297218);
        this.H0 = (TextView)this.C0.findViewById(2131297217);
        this.a1 = (ContentLoadingProgressBar)this.C0.findViewById(2131297045);
        ((TextView)this.C0.findViewById(2131297213)).setText(2131820902);
        this.D0 = viewGroup = (ViewGroup)this.findViewById(2131296551);
        this.I0 = (TextView)viewGroup.findViewById(2131297218);
        this.J0 = (TextView)this.D0.findViewById(2131297217);
        this.b1 = (ContentLoadingProgressBar)this.D0.findViewById(2131297045);
        ((TextView)this.D0.findViewById(2131297213)).setText(2131820939);
        this.E0 = viewGroup3 = (ViewGroup)this.findViewById(2131296552);
        this.K0 = (TextView)viewGroup3.findViewById(2131297218);
        this.L0 = (TextView)this.E0.findViewById(2131297217);
        this.c1 = (ContentLoadingProgressBar)this.E0.findViewById(2131297045);
        ((TextView)this.E0.findViewById(2131297213)).setText(2131820902);
        this.F0 = viewGroup4 = (ViewGroup)this.findViewById(2131296553);
        this.M0 = (TextView)viewGroup4.findViewById(2131297218);
        this.N0 = (TextView)this.F0.findViewById(2131297217);
        this.d1 = (ContentLoadingProgressBar)this.F0.findViewById(2131297045);
        ((TextView)this.F0.findViewById(2131297213)).setText(2131820939);
        this.P = (ImageButton)this.findViewById(2131296485);
        this.Q = (ImageButton)this.findViewById(2131296486);
        this.R = (ImageButton)this.findViewById(2131296506);
        this.S = (ImageButton)this.findViewById(2131296518);
        this.P.setOnTouchListener(this.u1);
        this.Q.setOnTouchListener(this.u1);
        this.v0 = (LinearLayout)this.findViewById(2131296816);
        this.V0 = BottomSheetBehavior.W((View)this.findViewById(2131296456));
        this.U = this.findViewById(2131296820);
        if (com.smp.musicspeed.utils.t.w((Context)this)) {
            this.U.setBackgroundResource(2131231029);
        } else {
            this.U.setBackgroundResource(2131231030);
        }
        this.e1 = (ViewGroup)this.findViewById(2131297022);
        LayoutTransition layoutTransition = new LayoutTransition();
        this.e1.setLayoutTransition(layoutTransition);
        this.T = (Toolbar)this.findViewById(2131297243);
        this.O0 = (AudioWaveView)this.findViewById(2131297301);
        this.W0 = (MscHorizontalScrollView)this.findViewById(2131297303);
        this.h1 = (ScrollView)this.findViewById(2131296826);
        this.S0 = this.findViewById(2131296703);
        this.R0 = this.findViewById(2131296704);
        this.T0 = this.findViewById(2131296589);
        this.U0 = (ViewFlipper)this.findViewById(2131297296);
        this.Z0 = (ContentLoadingProgressBar)this.findViewById(2131297046);
        this.i1 = this.findViewById(2131296778);
        this.j1 = (TextView)this.findViewById(2131297204);
        this.M2();
        this.i2();
        this.j2();
        this.R4();
        this.T4();
        this.D2(true);
        this.k2();
        this.h4();
        this.K4();
        if (this.P2()) {
            E = true;
            this.I1();
        }
        this.R3();
        this.L1();
        this.w2();
        this.n4();
        com.smp.musicspeed.utils.f.a((Context)this);
        this.U4();
        this.V4();
        this.T1();
        try {
            com.smp.musicspeed.a0.a((Activity)this);
        }
        catch (Exception exception) {}
    }

    protected void onDestroy() {
        this.A1.removeCallbacks(this.B1);
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            playFileService.g0();
        }
        this.h0 = null;
        this.A1.removeCallbacks(this.w1);
        com.smp.musicspeed.ads.p p2 = this.k1;
        if (p2 != null) {
            p2.a();
            this.k1 = null;
        }
        com.smp.musicspeed.utils.t.g0((Context)this, this);
        super.onDestroy();
    }

    public void onEditOriginal(View view) {
        PlayFileService playFileService;
        BeatStartRecord beatStartRecord = (BeatStartRecord)com.smp.musicspeed.bpmkey.a.f.d().f();
        if (SystemClock.elapsedRealtime() - this.G1 > 1000L && (playFileService = this.h0) != null && beatStartRecord != null && playFileService.t().equals((Object)beatStartRecord.filename)) {
            this.G1 = SystemClock.elapsedRealtime();
            if (!view.equals((Object)this.G0) && !view.equals((Object)this.K0)) {
                com.smp.musicspeed.bpmkey.f.S(beatStartRecord).M(this.R(), "KeyDialogFragment");
                return;
            }
            com.smp.musicspeed.bpmkey.c.T(beatStartRecord).M(this.R(), "BpmDialogFragment");
        }
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(c0 c02) {
        this.k5();
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.k0.l0.a a2) {
        boolean bl = this.O1();
        this.y1((Fragment)com.smp.musicspeed.k0.h0.j.r.a(a2.a()), bl);
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.k0.l0.b b2) {
        boolean bl = this.O1();
        this.y1((Fragment)com.smp.musicspeed.k0.h0.k.r.a(b2.a()), bl);
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.k0.l0.c c2) {
        this.a2();
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.k0.l0.d d2) {
        this.y1(new com.smp.musicspeed.k0.q0.p(), false);
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.k0.l0.g g2) {
        this.y1((Fragment)com.smp.musicspeed.k0.p0.i.r.a(g2.a()), false);
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.k0.l0.h h2) {
        List<MediaTrack> list = h2.c();
        int n2 = h2.b();
        if (n2 >= 0) {
            if (n2 > -1 + list.size()) {
                return;
            }
            if (h2.d() && !com.smp.musicspeed.utils.t.o((Context)this).getBoolean("preferences_shuffle", false)) {
                this.onShuffleClicked(null);
            }
            this.A1.removeCallbacks((Runnable)this.C1);
            this.C1.a(list, n2, h2.a());
            this.A1.postDelayed((Runnable)this.C1, 125L);
            E = false;
        }
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.playingqueue.w w2) {
        this.a2();
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.playingqueue.x x2) {
        if (x2.a == PlayingQueue.getDefault().getCurrentlyPlaying()) {
            this.p5(x2.a);
        }
        this.a2();
        if (!x2.c) {
            this.X1(x2.b);
        }
    }

    @org.greenrobot.eventbus.m(sticky=true, threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.playingqueue.y y2) {
        org.greenrobot.eventbus.c.d().t((Object)y2);
        this.l1 = false;
        this.S1();
        this.D2(true);
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.recorder.r r2) {
        this.y1((Fragment)com.smp.musicspeed.recorder.t.r.a(), false);
    }

    public void onLinkClicked(View view) {
        SharedPreferences sharedPreferences = androidx.preference.j.b((Context)this.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean bl = true ^ sharedPreferences.getBoolean("preferences_link", false);
        editor.putBoolean("preferences_link", bl);
        editor.apply();
        this.S4();
        this.z2();
        this.t2(true);
        this.s4(bl);
        if (com.smp.musicspeed.utils.k.s()) {
            this.t4(bl);
        }
        this.S1();
    }

    public void onLoopClear(View view) {
        if (this.h0.t() == null) {
            this.Q3(this.getResources().getString(2131821351));
        } else {
            this.h0.m();
            if (com.smp.musicspeed.utils.t.V((Context)this)) {
                this.Q3(this.getResources().getString(2131821321));
            }
        }
        this.t2(false);
    }

    public void onLoopEndButton(View view) {
        if (this.h0.t() == null) {
            this.Q3(this.getResources().getString(2131821351));
            return;
        }
        long l2 = this.Y1();
        if (AppPrefs.k.B()) {
            l2 = this.j5(l2);
        }
        if (this.u4(l2, true)) {
            if (com.smp.musicspeed.utils.t.W((Context)this)) {
                this.Q3(this.getResources().getString(2131821322));
            }
        } else {
            this.Q3(this.getResources().getString(2131821318));
        }
        this.t2(false);
    }

    public void onLoopKeys(View view) {
        if (F && SystemClock.elapsedRealtime() - this.G1 > 1000L) {
            this.G1 = SystemClock.elapsedRealtime();
            new com.smp.musicspeed.i0.m().M(this.R(), "Loop Fragment");
        }
    }

    public void onLoopStartButton(View view) {
        if (this.h0.t() == null) {
            this.Q3(this.getResources().getString(2131821351));
            return;
        }
        long l2 = this.Y1();
        if (AppPrefs.k.B()) {
            l2 = this.j5(l2);
        }
        if (this.w4(l2, true)) {
            if (com.smp.musicspeed.utils.t.X((Context)this)) {
                this.Q3(this.getResources().getString(2131821323));
            }
        } else {
            this.Q3(this.getResources().getString(2131821318));
        }
        this.t2(false);
    }

    public boolean onMenuOpened(int n2, Menu menu) {
        this.k5();
        return false;
    }

    protected void onNewIntent(Intent intent) {
        androidx.fragment.app.d.super.onNewIntent(intent);
        E = true;
        this.setIntent(intent);
        if (this.P2()) {
            this.I1();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131296356) {
            return false;
        }
        this.f5(false);
        return true;
    }

    /*
     * Exception decompiling
     */
    protected void onPause() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl53 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public void onPitchKeys(View view) {
        this.Y4(1);
    }

    public void onPlay(View view) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null && playFileService.t() != null) {
            boolean bl = this.h0.F();
            this.y2();
            this.v2();
            this.h0.Y();
            if (!bl || !this.h0.F()) {
                ((Animatable)this.k0.getDrawable()).start();
            }
        }
    }

    public void onPlayModeClicked(View view) {
        SharedPreferences sharedPreferences = androidx.preference.j.b((Context)this.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int n2 = 1;
        int n3 = n2 + sharedPreferences.getInt("com.smp.PREF_PLAY_MODE", n2);
        if (n3 > 3) {
            n3 = 0;
        }
        editor.putInt("com.smp.PREF_PLAY_MODE", n3);
        editor.apply();
        this.G4(n3);
        if (com.smp.musicspeed.utils.t.Z((Context)this)) {
            if (n3 != 0) {
                if (n3 != n2) {
                    if (n3 != 2) {
                        if (n3 == 3) {
                            this.Q3(this.getString(2131821331));
                        }
                    } else {
                        this.Q3(this.getString(2131821330));
                    }
                } else {
                    this.Q3(this.getString(2131821329));
                }
            } else {
                this.Q3(this.getString(2131821332));
            }
        }
        PlayFileService playFileService = this.h0;
        if (n3 != 3) {
            n2 = 0;
        }
        playFileService.t0((boolean)n2);
    }

    public void onPlusMinusClicked(View view) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            if (playFileService.t() == null) {
                return;
            }
            boolean bl = com.smp.musicspeed.utils.t.H((Context)this);
            boolean bl2 = com.smp.musicspeed.utils.t.I((Context)this);
            float f2 = this.h0.w();
            float f3 = 100.0f * this.h0.z();
            if (view == this.findViewById(2131296510)) {
                float f4 = bl ? f2 + 1.0f : f2 + 0.1f;
                this.k(f4, 1, 0, true);
                return;
            }
            if (view == this.findViewById(2131296502)) {
                float f5 = bl ? f2 - 1.0f : f2 - 0.1f;
                this.k(f5, 1, 0, true);
                return;
            }
            if (view == this.findViewById(2131296512)) {
                float f6 = bl2 ? f3 + 5.0f : f3 + 1.0f;
                this.k(f6, 2, 0, true);
                return;
            }
            if (view == this.findViewById(2131296504)) {
                float f7 = bl2 ? f3 - 5.0f : f3 - 1.0f;
                this.k(f7, 2, 0, true);
                return;
            }
            if (view == this.findViewById(2131296511)) {
                float f8 = bl2 ? f3 + 5.0f : f3 + 1.0f;
                this.k(f8, 3, 0, true);
                return;
            }
            if (view == this.findViewById(2131296503)) {
                float f9 = bl2 ? f3 - 5.0f : f3 - 1.0f;
                this.k(f9, 3, 0, true);
            }
        }
    }

    public void onPreampKeys(View view) {
        this.Y4(4);
    }

    public void onRateKeys(View view) {
        this.Y4(3);
    }

    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        androidx.fragment.app.d.super.onRequestPermissionsResult(n2, arrstring, arrn);
        b0.d(this, n2, arrn);
    }

    public void onResetClicked(View view) {
        String string;
        Resources resources = this.getResources();
        if (view == this.o0) {
            AppCompatSeekBar appCompatSeekBar = this.X;
            appCompatSeekBar.setProgress(appCompatSeekBar.getMax() / 2);
            PlayFileService playFileService = this.h0;
            if (playFileService != null) {
                playFileService.r0(0.0f);
            }
            this.E4(0.0f);
            string = resources.getString(2131821344);
        } else if (view == this.n0) {
            AppCompatSeekBar appCompatSeekBar = this.Y;
            appCompatSeekBar.setProgress(appCompatSeekBar.getMax() / 2);
            PlayFileService playFileService = this.h0;
            if (playFileService != null) {
                playFileService.u0(1.0f);
            }
            this.N4(1.0f);
            string = resources.getString(2131821346);
        } else if (view == this.p0) {
            AppCompatSeekBar appCompatSeekBar = this.Z;
            appCompatSeekBar.setProgress(appCompatSeekBar.getMax() / 2);
            PlayFileService playFileService = this.h0;
            if (playFileService != null) {
                playFileService.s0(1.0f);
            }
            this.J4(1.0f);
            string = resources.getString(2131821345);
        } else {
            string = null;
        }
        if (com.smp.musicspeed.utils.t.Y((Context)this)) {
            this.Q3(string);
        }
    }

    protected void onResume() {
        PlayFileService playFileService;
        androidx.fragment.app.d.super.onResume();
        this.o1 = false;
        F = true;
        org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.player.m());
        org.greenrobot.eventbus.c.d().r((Object)this);
        if (this.k1 != null) {
            this.c4();
        }
        if ((playFileService = this.h0) != null) {
            playFileService.k();
            this.o5();
            this.y2();
            this.v2();
        }
        this.A1.removeCallbacks(this.B1);
        if (!this.q5()) {
            this.finish();
        }
        com.smp.musicspeed.library.playlists.k.a((Context)this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String string) {
        if (string.equals((Object)"preferences_screen_on")) {
            if (com.smp.musicspeed.utils.t.F((Context)this)) {
                this.getWindow().addFlags(128);
                return;
            }
            this.getWindow().clearFlags(128);
            return;
        }
        if (!(string.equals((Object)"preferences_pitch_range") || string.equals((Object)"preferences_minimum_speed") || string.equals((Object)"preferences_maximum_speed"))) {
            if (string.equals((Object)"preferences_link")) {
                PlayFileService playFileService;
                this.h4();
                if (com.smp.musicspeed.utils.t.A((Context)this) && (playFileService = this.h0) != null) {
                    playFileService.s0(playFileService.z());
                }
                this.K4();
                return;
            }
            if (string.equals((Object)"preferences_theme") || string.equals((Object)"preferences_accent_color") || string.equals((Object)"preferences_accent_color_dark")) {
                this.finish();
                return;
            }
        } else {
            this.K4();
        }
    }

    public void onShuffleClicked(View view) {
        SharedPreferences sharedPreferences = androidx.preference.j.b((Context)this.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean bl = true ^ sharedPreferences.getBoolean("preferences_shuffle", false);
        editor.putBoolean("preferences_shuffle", bl);
        editor.apply();
        if (com.smp.musicspeed.utils.t.a0((Context)this)) {
            if (bl) {
                this.Q3(this.getString(2131821355));
            } else {
                this.Q3(this.getString(2131821354));
            }
        }
        this.L4(bl);
        PlayingQueue.getDefault().setShuffle(bl);
        org.greenrobot.eventbus.c.d().m((Object)new a0());
    }

    public void onSkipNextClicked(View view) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            playFileService.T(false, true ^ playFileService.F());
        }
    }

    public void onSkipPrevClicked(View view) {
        PlayFileService playFileService = this.h0;
        if (playFileService != null) {
            if ((double)playFileService.x() / 1000000.0 > 3.0) {
                this.p4(0.0f);
                return;
            }
            PlayFileService playFileService2 = this.h0;
            playFileService2.T(true, true ^ playFileService2.F());
        }
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    public void onTempoKeys(View view) {
        this.Y4(2);
    }

    public /* synthetic */ void p3() {
        this.o3();
    }

    public void p4(float f2) {
        if (this.h0 != null) {
            this.W.removeCallbacks(this.F1);
            this.L = true;
            this.W.postDelayed(this.F1, 750L);
            this.h0.l0(f2);
            double d2 = f2;
            this.A5(d2);
            long l2 = (long)(d2 * (double)this.h0.s());
            this.F4(l2);
            this.H4(l2);
        }
    }

    public float q2() {
        return this.v5(this.Y1());
    }

    public /* synthetic */ void r3(Boolean bl) {
        this.q3(bl);
    }

    public b.o.b.b<WaveformRecord> s(int n2, Bundle bundle) {
        return new WaveformLoader(this.getApplicationContext(), this.h0.t());
    }

    @Override
    public void t(com.michaelflisar.gdprdialog.m.h h2) {
        if (h2.c()) {
            this.e2();
            return;
        }
        com.michaelflisar.gdprdialog.c.e().j(this, this.v1, h2.a());
    }

    public /* synthetic */ void t3(View view) {
        this.s3(view);
    }

    @Override
    public void u(String string, boolean bl) {
        this.U3(string, bl);
        this.V3();
    }

    public boolean u4(long l2, boolean bl) {
        boolean bl2 = this.h0.m0(l2, bl);
        if (bl2) {
            float f2 = this.v5(this.h0.u());
            this.g1.p(Float.valueOf((float)f2));
        }
        return bl2;
    }

    @Override
    public boolean v(long l2) {
        boolean bl = this.w4(l2, false);
        if (bl) {
            this.c5(true);
        }
        return bl;
    }

    public /* synthetic */ void v3(com.smp.musicspeed.utils.r r2) {
        this.u3(r2);
    }

    public boolean v4(float f2, boolean bl) {
        long l2 = (long)((double)f2 * (double)this.h0.s());
        boolean bl2 = this.h0.m0(l2, bl);
        if (bl2) {
            this.t2(true);
            return bl2;
        }
        this.Q3(this.getResources().getString(2131821318));
        return bl2;
    }

    public boolean w4(long l2, boolean bl) {
        boolean bl2 = this.h0.n0(l2, bl);
        if (bl2) {
            float f2 = this.v5(this.h0.v());
            this.g1.o(Float.valueOf((float)f2));
        }
        return bl2;
    }

    @Override
    public boolean x(long l2) {
        boolean bl = this.u4(l2, false);
        if (bl) {
            this.c5(true);
        }
        return bl;
    }

    public /* synthetic */ void x3(List list) {
        this.w3(list);
    }

    public boolean x4(float f2, boolean bl) {
        long l2 = (long)((double)f2 * (double)this.h0.s());
        boolean bl2 = this.h0.n0(l2, bl);
        if (bl2) {
            this.t2(true);
            return bl2;
        }
        this.Q3(this.getResources().getString(2131821318));
        return bl2;
    }

    public /* synthetic */ void z3(Boolean bl) {
        this.y3(bl);
    }

}

