/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.Window
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.GridView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ListAdapter
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.TextView
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.Arrays
 *  java.util.Locale
 */
package com.jaredrummler.android.colorpicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.d;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.ColorPickerView;
import com.jaredrummler.android.colorpicker.b;
import com.jaredrummler.android.colorpicker.c;
import com.jaredrummler.android.colorpicker.f;
import java.util.Arrays;
import java.util.Locale;

public class c
extends androidx.fragment.app.c
implements ColorPickerView.c,
TextWatcher {
    public static final int[] v = new int[]{-769226, -1499549, -54125, -6543440, -10011977, -12627531, -14575885, -16537100, -16728876, -16738680, -11751600, -7617718, -3285959, -5317, -16121, -26624, -8825528, -10453621, -6381922};
    int A;
    int B;
    boolean C;
    int D;
    com.jaredrummler.android.colorpicker.b E;
    LinearLayout F;
    SeekBar G;
    TextView H;
    ColorPickerView I;
    ColorPanelView J;
    EditText K;
    boolean L;
    private int M;
    private boolean N;
    private int O;
    private final View.OnTouchListener P = new View.OnTouchListener(this){
        final /* synthetic */ c f;
        {
            this.f = c2;
        }

        public boolean onTouch(View view, android.view.MotionEvent motionEvent) {
            EditText editText = this.f.K;
            if (view != editText && editText.hasFocus()) {
                this.f.K.clearFocus();
                ((InputMethodManager)this.f.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f.K.getWindowToken(), 0);
                this.f.K.clearFocus();
                return true;
            }
            return false;
        }
    };
    com.jaredrummler.android.colorpicker.d w;
    FrameLayout x;
    int[] y;
    int z;

    static /* synthetic */ void N(c c2, int n2) {
        c2.X(n2);
    }

    static /* synthetic */ int O(c c2) {
        return c2.O;
    }

    static /* synthetic */ int P(c c2) {
        return c2.M;
    }

    private int[] T(int n2) {
        int[] arrn = new int[]{this.e0(n2, 0.9), this.e0(n2, 0.7), this.e0(n2, 0.5), this.e0(n2, 0.333), this.e0(n2, 0.166), this.e0(n2, -0.125), this.e0(n2, -0.25), this.e0(n2, -0.375), this.e0(n2, -0.5), this.e0(n2, -0.675), this.e0(n2, -0.7), this.e0(n2, -0.775)};
        return arrn;
    }

    private int U() {
        int[] arrn;
        for (int i2 = 0; i2 < (arrn = this.y).length; ++i2) {
            if (arrn[i2] != this.z) continue;
            return i2;
        }
        return -1;
    }

    private void V() {
        int[] arrn;
        int[] arrn2;
        int n2 = Color.alpha((int)this.z);
        int[] arrn3 = this.getArguments().getIntArray("presets");
        this.y = arrn3;
        if (arrn3 == null) {
            this.y = v;
        }
        boolean bl = (arrn = this.y) == v;
        this.y = Arrays.copyOf((int[])arrn, (int)arrn.length);
        if (n2 != 255) {
            int[] arrn4;
            for (int i2 = 0; i2 < (arrn4 = this.y).length; ++i2) {
                int n3 = arrn4[i2];
                int n4 = Color.red((int)n3);
                int n5 = Color.green((int)n3);
                int n6 = Color.blue((int)n3);
                this.y[i2] = Color.argb((int)n2, (int)n4, (int)n5, (int)n6);
            }
        }
        this.y = this.f0(this.y, this.z);
        int n7 = this.getArguments().getInt("color");
        if (n7 != this.z) {
            this.y = this.f0(this.y, n7);
        }
        if (bl && (arrn2 = this.y).length == 19) {
            this.y = this.a0(arrn2, Color.argb((int)n2, (int)0, (int)0, (int)0));
        }
    }

    public static k W() {
        return new Object(){
            int a = com.jaredrummler.android.colorpicker.j.b;
            int b = com.jaredrummler.android.colorpicker.j.c;
            int c = com.jaredrummler.android.colorpicker.j.a;
            int d = com.jaredrummler.android.colorpicker.j.d;
            int e = 1;
            int[] f = c.v;
            int g = -16777216;
            int h = 0;
            boolean i = false;
            boolean j = true;
            boolean k = true;
            boolean l = true;
            int m = 1;

            public c a() {
                c c2 = new c();
                Bundle bundle = new Bundle();
                bundle.putInt("id", this.h);
                bundle.putInt("dialogType", this.e);
                bundle.putInt("color", this.g);
                bundle.putIntArray("presets", this.f);
                bundle.putBoolean("alpha", this.i);
                bundle.putBoolean("allowCustom", this.k);
                bundle.putBoolean("allowPresets", this.j);
                bundle.putInt("dialogTitle", this.a);
                bundle.putBoolean("showColorShades", this.l);
                bundle.putInt("colorShape", this.m);
                bundle.putInt("presetsButtonText", this.b);
                bundle.putInt("customButtonText", this.c);
                bundle.putInt("selectedButtonText", this.d);
                c2.setArguments(bundle);
                return c2;
            }

            public k b(boolean bl) {
                this.k = bl;
                return this;
            }

            public k c(boolean bl) {
                this.j = bl;
                return this;
            }

            public k d(int n2) {
                this.g = n2;
                return this;
            }

            public k e(int n2) {
                this.m = n2;
                return this;
            }

            public k f(int n2) {
                this.a = n2;
                return this;
            }

            public k g(int n2) {
                this.e = n2;
                return this;
            }

            public k h(int[] arrn) {
                this.f = arrn;
                return this;
            }

            public k i(boolean bl) {
                this.i = bl;
                return this;
            }

            public k j(boolean bl) {
                this.l = bl;
                return this;
            }
        };
    }

    private void X(int n2) {
        if (this.w != null) {
            Log.w((String)"ColorPickerDialog", (String)"Using deprecated listener which may be remove in future releases");
            this.w.b(this.B, n2);
            return;
        }
        androidx.fragment.app.d d2 = this.getActivity();
        if (d2 instanceof com.jaredrummler.android.colorpicker.d) {
            ((com.jaredrummler.android.colorpicker.d)d2).b(this.B, n2);
            return;
        }
        throw new IllegalStateException("The activity must implement ColorPickerDialogListener");
    }

    private void Y() {
        if (this.w != null) {
            Log.w((String)"ColorPickerDialog", (String)"Using deprecated listener which may be remove in future releases");
            this.w.a(this.B);
            return;
        }
        androidx.fragment.app.d d2 = this.getActivity();
        if (d2 instanceof com.jaredrummler.android.colorpicker.d) {
            ((com.jaredrummler.android.colorpicker.d)d2).a(this.B);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private int Z(String string) throws NumberFormatException {
        int n2;
        int n3;
        int n4;
        int n5;
        block14 : {
            block9 : {
                int n6;
                block11 : {
                    block13 : {
                        block12 : {
                            block10 : {
                                block8 : {
                                    block7 : {
                                        block6 : {
                                            if (string.startsWith("#")) {
                                                string = string.substring(1);
                                            }
                                            int n7 = string.length();
                                            n2 = -1;
                                            n4 = 0;
                                            if (n7 != 0) break block6;
                                            n5 = 0;
                                            break block7;
                                        }
                                        if (string.length() > 2) break block8;
                                        n5 = Integer.parseInt((String)string, (int)16);
                                    }
                                    n3 = 0;
                                    break block9;
                                }
                                if (string.length() != 3) break block10;
                                n6 = Integer.parseInt((String)string.substring(0, 1), (int)16);
                                n3 = Integer.parseInt((String)string.substring(1, 2), (int)16);
                                n5 = Integer.parseInt((String)string.substring(2, 3), (int)16);
                                break block11;
                            }
                            if (string.length() != 4) break block12;
                            int n8 = Integer.parseInt((String)string.substring(0, 2), (int)16);
                            n5 = Integer.parseInt((String)string.substring(2, 4), (int)16);
                            n3 = n8;
                            n4 = 0;
                            break block9;
                        }
                        if (string.length() != 5) break block13;
                        n6 = Integer.parseInt((String)string.substring(0, 1), (int)16);
                        n3 = Integer.parseInt((String)string.substring(1, 3), (int)16);
                        n5 = Integer.parseInt((String)string.substring(3, 5), (int)16);
                        break block11;
                    }
                    if (string.length() != 6) break block14;
                    n6 = Integer.parseInt((String)string.substring(0, 2), (int)16);
                    n3 = Integer.parseInt((String)string.substring(2, 4), (int)16);
                    n5 = Integer.parseInt((String)string.substring(4, 6), (int)16);
                }
                n4 = n6;
            }
            n2 = 255;
            return Color.argb((int)n2, (int)n4, (int)n3, (int)n5);
        }
        if (string.length() == 7) {
            n2 = Integer.parseInt((String)string.substring(0, 1), (int)16);
            int n9 = Integer.parseInt((String)string.substring(1, 3), (int)16);
            int n10 = Integer.parseInt((String)string.substring(3, 5), (int)16);
            n5 = Integer.parseInt((String)string.substring(5, 7), (int)16);
            n4 = n9;
            n3 = n10;
            return Color.argb((int)n2, (int)n4, (int)n3, (int)n5);
        }
        if (string.length() == 8) {
            n2 = Integer.parseInt((String)string.substring(0, 2), (int)16);
            int n11 = Integer.parseInt((String)string.substring(2, 4), (int)16);
            int n12 = Integer.parseInt((String)string.substring(4, 6), (int)16);
            n5 = Integer.parseInt((String)string.substring(6, 8), (int)16);
            n4 = n11;
            n3 = n12;
            return Color.argb((int)n2, (int)n4, (int)n3, (int)n5);
        }
        n5 = -1;
        n3 = -1;
        n4 = -1;
        return Color.argb((int)n2, (int)n4, (int)n3, (int)n5);
    }

    private int[] a0(int[] arrn, int n2) {
        boolean bl;
        block2 : {
            int n3 = arrn.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (arrn[i2] != n2) continue;
                bl = true;
                break block2;
            }
            bl = false;
        }
        if (!bl) {
            int n4 = 1 + arrn.length;
            int[] arrn2 = new int[n4];
            int n5 = n4 - 1;
            arrn2[n5] = n2;
            System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)n5);
            return arrn2;
        }
        return arrn;
    }

    private void c0(int n2) {
        if (this.L) {
            EditText editText = this.K;
            Object[] arrobject = new Object[]{n2};
            editText.setText((CharSequence)String.format((String)"%08X", (Object[])arrobject));
            return;
        }
        EditText editText = this.K;
        Object[] arrobject = new Object[]{n2 & 16777215};
        editText.setText((CharSequence)String.format((String)"%06X", (Object[])arrobject));
    }

    private void d0() {
        int n2 = 255 - Color.alpha((int)this.z);
        this.G.setMax(255);
        this.G.setProgress(n2);
        int n3 = (int)(100.0 * (double)n2 / 255.0);
        TextView textView = this.H;
        Locale locale = Locale.ENGLISH;
        Object[] arrobject = new Object[]{n3};
        textView.setText((CharSequence)String.format((Locale)locale, (String)"%d%%", (Object[])arrobject));
        this.G.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void onProgressChanged(SeekBar seekBar, int n2, boolean bl) {
                com.jaredrummler.android.colorpicker.b b2;
                int n3 = (int)(100.0 * (double)n2 / 255.0);
                TextView textView = this.a.H;
                Locale locale = Locale.ENGLISH;
                Object[] arrobject = new Object[1];
                Integer n4 = n3;
                int n5 = 0;
                arrobject[0] = n4;
                textView.setText((CharSequence)String.format((Locale)locale, (String)"%d%%", (Object[])arrobject));
                int n6 = 255 - n2;
                int n7 = 0;
                do {
                    b2 = this.a.E;
                    int[] arrn = b2.g;
                    if (n7 >= arrn.length) break;
                    int n8 = arrn[n7];
                    int n9 = Color.red((int)n8);
                    int n10 = Color.green((int)n8);
                    int n11 = Color.blue((int)n8);
                    this.a.E.g[n7] = Color.argb((int)n6, (int)n9, (int)n10, (int)n11);
                    ++n7;
                } while (true);
                b2.notifyDataSetChanged();
                while (n5 < this.a.F.getChildCount()) {
                    FrameLayout frameLayout = (FrameLayout)this.a.F.getChildAt(n5);
                    ColorPanelView colorPanelView = (ColorPanelView)frameLayout.findViewById(com.jaredrummler.android.colorpicker.h.e);
                    ImageView imageView = (ImageView)frameLayout.findViewById(com.jaredrummler.android.colorpicker.h.b);
                    if (frameLayout.getTag() == null) {
                        frameLayout.setTag((Object)colorPanelView.getBorderColor());
                    }
                    int n12 = colorPanelView.getColor();
                    int n13 = Color.argb((int)n6, (int)Color.red((int)n12), (int)Color.green((int)n12), (int)Color.blue((int)n12));
                    if (n6 <= 165) {
                        colorPanelView.setBorderColor(n13 | -16777216);
                    } else {
                        colorPanelView.setBorderColor((Integer)frameLayout.getTag());
                    }
                    if (colorPanelView.getTag() != null && ((Boolean)colorPanelView.getTag()).booleanValue()) {
                        if (n6 <= 165) {
                            imageView.setColorFilter(-16777216, android.graphics.PorterDuff$Mode.SRC_IN);
                        } else if (b.i.i.a.d((int)n13) >= 0.65) {
                            imageView.setColorFilter(-16777216, android.graphics.PorterDuff$Mode.SRC_IN);
                        } else {
                            imageView.setColorFilter(-1, android.graphics.PorterDuff$Mode.SRC_IN);
                        }
                    }
                    colorPanelView.setColor(n13);
                    ++n5;
                }
                int n14 = Color.red((int)this.a.z);
                int n15 = Color.green((int)this.a.z);
                int n16 = Color.blue((int)this.a.z);
                this.a.z = Color.argb((int)n6, (int)n14, (int)n15, (int)n16);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private int e0(int n2, double d2) {
        Object[] arrobject = new Object[]{16777215 & n2};
        long l2 = Long.parseLong((String)String.format((String)"#%06X", (Object[])arrobject).substring(1), (int)16);
        double d3 = 0.0;
        double d4 = d2 DCMPG d3;
        if (d4 >= 0) {
            d3 = 255.0;
        }
        if (d4 < 0) {
            d2 *= -1.0;
        }
        long l3 = l2 >> 16;
        long l4 = 255L & l2 >> 8;
        long l5 = l2 & 255L;
        return Color.argb((int)Color.alpha((int)n2), (int)((int)(l3 + Math.round((double)(d2 * (d3 - (double)l3))))), (int)((int)(l4 + Math.round((double)(d2 * (d3 - (double)l4))))), (int)((int)(l5 + Math.round((double)(d2 * (d3 - (double)l5))))));
    }

    private int[] f0(int[] arrn, int n2) {
        boolean bl;
        block2 : {
            int n3 = arrn.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (arrn[i2] != n2) continue;
                bl = true;
                break block2;
            }
            bl = false;
        }
        if (!bl) {
            int n4 = 1 + arrn.length;
            int[] arrn2 = new int[n4];
            arrn2[0] = n2;
            System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)1, (int)(n4 - 1));
            return arrn2;
        }
        return arrn;
    }

    public Dialog B(Bundle bundle) {
        FrameLayout frameLayout;
        int n2;
        this.B = this.getArguments().getInt("id");
        this.L = this.getArguments().getBoolean("alpha");
        this.C = this.getArguments().getBoolean("showColorShades");
        this.D = this.getArguments().getInt("colorShape");
        if (bundle == null) {
            this.z = this.getArguments().getInt("color");
            this.A = this.getArguments().getInt("dialogType");
        } else {
            this.z = bundle.getInt("color");
            this.A = bundle.getInt("dialogType");
        }
        this.x = frameLayout = new FrameLayout((Context)this.requireActivity());
        int n3 = this.A;
        if (n3 == 0) {
            frameLayout.addView(this.R());
        } else if (n3 == 1) {
            frameLayout.addView(this.S());
        }
        int n4 = this.getArguments().getInt("selectedButtonText");
        if (n4 == 0) {
            n4 = com.jaredrummler.android.colorpicker.j.d;
        }
        d.a a2 = new d.a((Context)this.requireActivity()).u((View)this.x).o(n4, new DialogInterface.OnClickListener(this){
            final /* synthetic */ c f;
            {
                this.f = c2;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
                c c2 = this.f;
                c.N(c2, c2.z);
            }
        });
        int n5 = this.getArguments().getInt("dialogTitle");
        if (n5 != 0) {
            a2.s(n5);
        }
        this.M = this.getArguments().getInt("presetsButtonText");
        this.O = this.getArguments().getInt("customButtonText");
        if (this.A == 0 && this.getArguments().getBoolean("allowPresets")) {
            n2 = this.M;
            if (n2 == 0) {
                n2 = com.jaredrummler.android.colorpicker.j.c;
            }
        } else if (this.A == 1 && this.getArguments().getBoolean("allowCustom")) {
            n2 = this.O;
            if (n2 == 0) {
                n2 = com.jaredrummler.android.colorpicker.j.a;
            }
        } else {
            n2 = 0;
        }
        if (n2 != 0) {
            a2.l(n2, null);
        }
        return a2.a();
    }

    void Q(int n2) {
        int n3;
        int[] arrn = this.T(n2);
        int n4 = this.F.getChildCount();
        if (n4 != 0) {
            for (n3 = 0; n3 < this.F.getChildCount(); ++n3) {
                FrameLayout frameLayout = (FrameLayout)this.F.getChildAt(n3);
                ColorPanelView colorPanelView = (ColorPanelView)frameLayout.findViewById(com.jaredrummler.android.colorpicker.h.e);
                ImageView imageView = (ImageView)frameLayout.findViewById(com.jaredrummler.android.colorpicker.h.b);
                colorPanelView.setColor(arrn[n3]);
                colorPanelView.setTag((Object)Boolean.FALSE);
                imageView.setImageDrawable(null);
            }
            return;
        }
        int n5 = this.getResources().getDimensionPixelSize(f.a);
        int n6 = arrn.length;
        while (n3 < n6) {
            int n7 = arrn[n3];
            int n8 = this.D == 0 ? com.jaredrummler.android.colorpicker.i.b : com.jaredrummler.android.colorpicker.i.a;
            View view = View.inflate((Context)this.getActivity(), (int)n8, null);
            ColorPanelView colorPanelView = (ColorPanelView)view.findViewById(com.jaredrummler.android.colorpicker.h.e);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)colorPanelView.getLayoutParams();
            marginLayoutParams.rightMargin = n5;
            marginLayoutParams.leftMargin = n5;
            colorPanelView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
            colorPanelView.setColor(n7);
            this.F.addView(view);
            colorPanelView.post(new Runnable(this, colorPanelView, n7){
                final /* synthetic */ ColorPanelView f;
                final /* synthetic */ int g;
                final /* synthetic */ c h;
                {
                    this.h = c2;
                    this.f = colorPanelView;
                    this.g = n2;
                }

                public void run() {
                    this.f.setColor(this.g);
                }
            });
            colorPanelView.setOnClickListener(new View.OnClickListener(this, colorPanelView){
                final /* synthetic */ ColorPanelView f;
                final /* synthetic */ c g;
                {
                    this.g = c2;
                    this.f = colorPanelView;
                }

                public void onClick(View view) {
                    if (view.getTag() instanceof Boolean && ((Boolean)view.getTag()).booleanValue()) {
                        c c2 = this.g;
                        c.N(c2, c2.z);
                        this.g.w();
                        return;
                    }
                    this.g.z = this.f.getColor();
                    this.g.E.a();
                    for (int i2 = 0; i2 < this.g.F.getChildCount(); ++i2) {
                        FrameLayout frameLayout = (FrameLayout)this.g.F.getChildAt(i2);
                        ColorPanelView colorPanelView = (ColorPanelView)frameLayout.findViewById(com.jaredrummler.android.colorpicker.h.e);
                        ImageView imageView = (ImageView)frameLayout.findViewById(com.jaredrummler.android.colorpicker.h.b);
                        int n2 = colorPanelView == view ? com.jaredrummler.android.colorpicker.g.b : 0;
                        imageView.setImageResource(n2);
                        if (colorPanelView == view && b.i.i.a.d((int)colorPanelView.getColor()) >= 0.65 || Color.alpha((int)colorPanelView.getColor()) <= 165) {
                            imageView.setColorFilter(-16777216, android.graphics.PorterDuff$Mode.SRC_IN);
                        } else {
                            imageView.setColorFilter(null);
                        }
                        boolean bl = colorPanelView == view;
                        colorPanelView.setTag((Object)bl);
                    }
                }
            });
            colorPanelView.setOnLongClickListener(new View.OnLongClickListener(this, colorPanelView){
                final /* synthetic */ ColorPanelView f;
                final /* synthetic */ c g;
                {
                    this.g = c2;
                    this.f = colorPanelView;
                }

                public boolean onLongClick(View view) {
                    this.f.d();
                    return true;
                }
            });
            ++n3;
        }
    }

    /*
     * Exception decompiling
     */
    View R() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl62.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    View S() {
        com.jaredrummler.android.colorpicker.b b2;
        View view = View.inflate((Context)this.getActivity(), (int)com.jaredrummler.android.colorpicker.i.d, null);
        this.F = (LinearLayout)view.findViewById(com.jaredrummler.android.colorpicker.h.k);
        this.G = (SeekBar)view.findViewById(com.jaredrummler.android.colorpicker.h.m);
        this.H = (TextView)view.findViewById(com.jaredrummler.android.colorpicker.h.n);
        GridView gridView = (GridView)view.findViewById(com.jaredrummler.android.colorpicker.h.i);
        this.V();
        if (this.C) {
            this.Q(this.z);
        } else {
            this.F.setVisibility(8);
            view.findViewById(com.jaredrummler.android.colorpicker.h.j).setVisibility(8);
        }
        this.E = b2 = new com.jaredrummler.android.colorpicker.b(new b.a(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public void a(int n2) {
                c c2 = this.a;
                int n3 = c2.z;
                if (n3 == n2) {
                    c.N(c2, n3);
                    this.a.w();
                    return;
                }
                c2.z = n2;
                if (c2.C) {
                    c2.Q(n2);
                }
            }
        }, this.y, this.U(), this.D);
        gridView.setAdapter((ListAdapter)b2);
        if (this.L) {
            this.d0();
            return view;
        }
        view.findViewById(com.jaredrummler.android.colorpicker.h.l).setVisibility(8);
        view.findViewById(com.jaredrummler.android.colorpicker.h.o).setVisibility(8);
        return view;
    }

    public void afterTextChanged(Editable editable) {
        int n2;
        if (this.K.isFocused() && (n2 = this.Z(editable.toString())) != this.I.getColor()) {
            this.N = true;
            this.I.n(n2, true);
        }
    }

    public void b0(com.jaredrummler.android.colorpicker.d d2) {
        this.w = d2;
    }

    public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
    }

    @Override
    public void n(int n2) {
        this.z = n2;
        ColorPanelView colorPanelView = this.J;
        if (colorPanelView != null) {
            colorPanelView.setColor(n2);
        }
        if (!this.N && this.K != null) {
            this.c0(n2);
            if (this.K.hasFocus()) {
                ((InputMethodManager)this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.K.getWindowToken(), 0);
                this.K.clearFocus();
            }
        }
        this.N = false;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.Y();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("color", this.z);
        bundle.putInt("dialogType", this.A);
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        androidx.appcompat.app.d d2 = (androidx.appcompat.app.d)this.z();
        d2.getWindow().clearFlags(131080);
        d2.getWindow().setSoftInputMode(4);
        Button button = d2.e(-3);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener(this){
                final /* synthetic */ c f;
                {
                    this.f = c2;
                }

                public void onClick(View view) {
                    this.f.x.removeAllViews();
                    c c2 = this.f;
                    int n2 = c2.A;
                    if (n2 != 0) {
                        if (n2 != 1) {
                            return;
                        }
                        c2.A = 0;
                        Button button = (Button)view;
                        int n3 = c.P(c2) != 0 ? c.P(this.f) : com.jaredrummler.android.colorpicker.j.c;
                        button.setText(n3);
                        c c3 = this.f;
                        c3.x.addView(c3.R());
                        return;
                    }
                    c2.A = 1;
                    Button button = (Button)view;
                    int n4 = c.O(c2) != 0 ? c.O(this.f) : com.jaredrummler.android.colorpicker.j.a;
                    button.setText(n4);
                    c c4 = this.f;
                    c4.x.addView(c4.S());
                }
            });
        }
    }

    public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
    }

}

