/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.WindowManager
 *  android.view.WindowManager$BadTokenException
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.RadioButton
 *  android.widget.TextView
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$o
 *  com.afollestad.materialdialogs.internal.MDButton
 *  com.afollestad.materialdialogs.internal.MDRootLayout
 *  com.afollestad.materialdialogs.internal.c
 *  com.afollestad.materialdialogs.internal.d
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.IllegalAccessError
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.NumberFormat
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.Locale
 */
package c.a.b;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.b.a;
import c.a.b.f;
import c.a.b.o;
import c.a.b.p;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class f
extends c.a.b.c
implements View.OnClickListener,
a.c {
    protected final d h;
    private final Handler i = new Handler();
    protected ImageView j;
    protected TextView k;
    protected TextView l;
    EditText m;
    RecyclerView n;
    View o;
    FrameLayout p;
    ProgressBar q;
    TextView r;
    TextView s;
    TextView t;
    CheckBox u;
    MDButton v;
    MDButton w;
    MDButton x;
    l y;
    List<Integer> z;

    @SuppressLint(value={"InflateParams"})
    protected f(d d2) {
        super(d2.a, c.a.b.d.c(d2));
        this.h = d2;
        this.f = (MDRootLayout)LayoutInflater.from((Context)d2.a).inflate(c.a.b.d.b(d2), null);
        c.a.b.d.d(this);
    }

    private boolean m() {
        if (this.h.H == null) {
            return false;
        }
        Collections.sort(this.z);
        ArrayList arrayList = new ArrayList();
        for (Integer n2 : this.z) {
            if (n2 < 0 || n2 > -1 + this.h.l.size()) continue;
            arrayList.add(this.h.l.get(n2.intValue()));
        }
        i i2 = this.h.H;
        List<Integer> list = this.z;
        return i2.a(this, (Integer[])list.toArray((Object[])new Integer[list.size()]), (CharSequence[])arrayList.toArray((Object[])new CharSequence[arrayList.size()]));
    }

    private boolean n(View view) {
        d d2 = this.h;
        if (d2.G == null) {
            return false;
        }
        int n2 = d2.O;
        CharSequence charSequence = null;
        if (n2 >= 0) {
            int n3 = d2.l.size();
            charSequence = null;
            if (n2 < n3) {
                d d3 = this.h;
                charSequence = (CharSequence)d3.l.get(d3.O);
            }
        }
        d d4 = this.h;
        return d4.G.a(this, view, d4.O, charSequence);
    }

    @Override
    public boolean a(f f2, View view, int n2, CharSequence charSequence, boolean bl) {
        if (!view.isEnabled()) {
            return false;
        }
        l l2 = this.y;
        if (l2 != null && l2 != l.f) {
            if (l2 == l.h) {
                CheckBox checkBox = (CheckBox)view.findViewById(c.a.b.k.f);
                if (!checkBox.isEnabled()) {
                    return false;
                }
                if (true ^ this.z.contains((Object)n2)) {
                    this.z.add((Object)n2);
                    if (this.h.I) {
                        if (this.m()) {
                            checkBox.setChecked(true);
                            return true;
                        }
                        this.z.remove((Object)n2);
                        return true;
                    }
                    checkBox.setChecked(true);
                    return true;
                }
                this.z.remove((Object)n2);
                if (this.h.I) {
                    if (this.m()) {
                        checkBox.setChecked(false);
                        return true;
                    }
                    this.z.add((Object)n2);
                    return true;
                }
                checkBox.setChecked(false);
                return true;
            }
            if (l2 == l.g) {
                boolean bl2;
                RadioButton radioButton = (RadioButton)view.findViewById(c.a.b.k.f);
                if (!radioButton.isEnabled()) {
                    return false;
                }
                d d2 = this.h;
                int n3 = d2.O;
                if (d2.R && d2.m == null) {
                    this.dismiss();
                    this.h.O = n2;
                    this.n(view);
                    bl2 = false;
                } else if (d2.J) {
                    d2.O = n2;
                    bl2 = this.n(view);
                    this.h.O = n3;
                } else {
                    bl2 = true;
                }
                if (bl2) {
                    this.h.O = n2;
                    radioButton.setChecked(true);
                    this.h.X.notifyItemChanged(n3);
                    this.h.X.notifyItemChanged(n2);
                    return true;
                }
            }
        } else {
            if (this.h.R) {
                this.dismiss();
            }
            if (!bl) {
                d d3 = this.h;
                h h2 = d3.E;
                if (h2 != null) {
                    h2.a(this, view, n2, (CharSequence)d3.l.get(n2));
                }
            }
            if (bl) {
                d d4 = this.h;
                k k2 = d4.F;
                if (k2 != null) {
                    return k2.a(this, view, n2, (CharSequence)d4.l.get(n2));
                }
            }
        }
        return true;
    }

    final void d() {
        RecyclerView recyclerView = this.n;
        if (recyclerView == null) {
            return;
        }
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this){
            final /* synthetic */ f f;
            {
                this.f = f2;
            }

            public void onGlobalLayout() {
                block8 : {
                    int n2;
                    block10 : {
                        f f2;
                        block9 : {
                            if (Build.VERSION.SDK_INT < 16) {
                                this.f.n.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                            } else {
                                this.f.n.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                            }
                            f2 = this.f;
                            l l2 = f2.y;
                            l l3 = l.g;
                            if (l2 != l3 && l2 != l.h) break block8;
                            if (l2 != l3) break block9;
                            n2 = f2.h.O;
                            if (n2 < 0) {
                                return;
                            }
                            break block10;
                        }
                        List<Integer> list = f2.z;
                        if (list == null) break block8;
                        if (list.size() == 0) {
                            return;
                        }
                        Collections.sort(this.f.z);
                        n2 = (Integer)this.f.z.get(0);
                    }
                    this.f.n.post(new java.lang.Runnable(this, n2){
                        final /* synthetic */ int f;
                        final /* synthetic */ a g;
                        {
                            this.g = a2;
                            this.f = n2;
                        }

                        public void run() {
                            this.g.f.n.requestFocus();
                            this.g.f.h.Y.y1(this.f);
                        }
                    });
                }
            }
        });
    }

    public void dismiss() {
        if (this.m != null) {
            c.a.b.q.a.f((DialogInterface)this, this.h);
        }
        Dialog.super.dismiss();
    }

    public final MDButton e(c.a.b.b b2) {
        int n2 = c.a[b2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                return this.v;
            }
            return this.x;
        }
        return this.w;
    }

    public final d f() {
        return this.h;
    }

    Drawable g(c.a.b.b b2, boolean bl) {
        if (bl) {
            d d2 = this.h;
            if (d2.L0 != 0) {
                return b.i.h.d.f.b(d2.a.getResources(), this.h.L0, null);
            }
            Context context = d2.a;
            int n2 = c.a.b.g.j;
            Drawable drawable = c.a.b.q.a.p(context, n2);
            if (drawable != null) {
                return drawable;
            }
            return c.a.b.q.a.p(this.getContext(), n2);
        }
        int n3 = c.a[b2.ordinal()];
        if (n3 != 1) {
            if (n3 != 2) {
                d d3 = this.h;
                if (d3.M0 != 0) {
                    return b.i.h.d.f.b(d3.a.getResources(), this.h.M0, null);
                }
                Context context = d3.a;
                int n4 = c.a.b.g.h;
                Drawable drawable = c.a.b.q.a.p(context, n4);
                if (drawable != null) {
                    return drawable;
                }
                Drawable drawable2 = c.a.b.q.a.p(this.getContext(), n4);
                if (Build.VERSION.SDK_INT >= 21) {
                    c.a.b.q.b.a(drawable2, this.h.h);
                }
                return drawable2;
            }
            d d4 = this.h;
            if (d4.O0 != 0) {
                return b.i.h.d.f.b(d4.a.getResources(), this.h.O0, null);
            }
            Context context = d4.a;
            int n5 = c.a.b.g.f;
            Drawable drawable = c.a.b.q.a.p(context, n5);
            if (drawable != null) {
                return drawable;
            }
            Drawable drawable3 = c.a.b.q.a.p(this.getContext(), n5);
            if (Build.VERSION.SDK_INT >= 21) {
                c.a.b.q.b.a(drawable3, this.h.h);
            }
            return drawable3;
        }
        d d5 = this.h;
        if (d5.N0 != 0) {
            return b.i.h.d.f.b(d5.a.getResources(), this.h.N0, null);
        }
        Context context = d5.a;
        int n6 = c.a.b.g.g;
        Drawable drawable = c.a.b.q.a.p(context, n6);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable4 = c.a.b.q.a.p(this.getContext(), n6);
        if (Build.VERSION.SDK_INT >= 21) {
            c.a.b.q.b.a(drawable4, this.h.h);
        }
        return drawable4;
    }

    public final EditText h() {
        return this.m;
    }

    final Drawable i() {
        d d2 = this.h;
        if (d2.K0 != 0) {
            return b.i.h.d.f.b(d2.a.getResources(), this.h.K0, null);
        }
        Context context = d2.a;
        int n2 = c.a.b.g.x;
        Drawable drawable = c.a.b.q.a.p(context, n2);
        if (drawable != null) {
            return drawable;
        }
        return c.a.b.q.a.p(this.getContext(), n2);
    }

    public final View j() {
        return this.f;
    }

    void k(int n2, boolean bl) {
        block6 : {
            boolean bl2;
            block8 : {
                block7 : {
                    TextView textView = this.t;
                    if (textView == null) break block6;
                    if (this.h.t0 > 0) {
                        Locale locale = Locale.getDefault();
                        Object[] arrobject = new Object[]{n2, this.h.t0};
                        textView.setText((CharSequence)String.format((Locale)locale, (String)"%d/%d", (Object[])arrobject));
                        this.t.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    if (bl && n2 == 0) break block7;
                    d d2 = this.h;
                    int n3 = d2.t0;
                    if (n3 > 0 && n2 > n3) break block7;
                    int n4 = d2.s0;
                    bl2 = false;
                    if (n2 >= n4) break block8;
                }
                bl2 = true;
            }
            d d3 = this.h;
            int n5 = bl2 ? d3.u0 : d3.j;
            d d4 = this.h;
            int n6 = bl2 ? d4.u0 : d4.t;
            if (this.h.t0 > 0) {
                this.t.setTextColor(n5);
            }
            com.afollestad.materialdialogs.internal.c.e((EditText)this.m, (int)n6);
            this.e(c.a.b.b.f).setEnabled(bl2 ^ true);
        }
    }

    final void l() {
        if (this.n == null) {
            return;
        }
        ArrayList<CharSequence> arrayList = this.h.l;
        if ((arrayList == null || arrayList.size() == 0) && this.h.X == null) {
            return;
        }
        d d2 = this.h;
        if (d2.Y == null) {
            d2.Y = new LinearLayoutManager(this.getContext());
        }
        if (this.n.getLayoutManager() == null) {
            this.n.setLayoutManager(this.h.Y);
        }
        this.n.setAdapter(this.h.X);
        if (this.y != null) {
            ((c.a.b.a)this.h.X).t(this);
        }
    }

    void o() {
        EditText editText = this.m;
        if (editText == null) {
            return;
        }
        editText.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ f f;
            {
                this.f = f2;
            }

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                int n5 = charSequence.toString().length();
                f f2 = this.f;
                boolean bl = f2.h.p0;
                boolean bl2 = false;
                if (!bl) {
                    bl2 = false;
                    if (n5 == 0) {
                        bl2 = true;
                    }
                    f2.e(c.a.b.b.f).setEnabled(bl2 ^ true);
                }
                this.f.k(n5, bl2);
                f f3 = this.f;
                d d2 = f3.h;
                if (d2.r0) {
                    d2.o0.a(f3, charSequence);
                }
            }
        });
    }

    public final void onClick(View view) {
        block19 : {
            c.a.b.b b2;
            block16 : {
                block14 : {
                    block18 : {
                        block15 : {
                            block17 : {
                                EditText editText;
                                b2 = (c.a.b.b)((Object)view.getTag());
                                int n2 = c.a[b2.ordinal()];
                                if (n2 == 1) break block14;
                                if (n2 == 2) break block15;
                                if (n2 != 3) break block16;
                                d d2 = this.h;
                                if (d2.z != null) break block17;
                                m m2 = d2.A;
                                if (m2 != null) {
                                    m2.a(this, b2);
                                }
                                if (!this.h.J) {
                                    this.n(view);
                                }
                                if (!this.h.I) {
                                    this.m();
                                }
                                d d3 = this.h;
                                g g2 = d3.o0;
                                if (g2 != null && (editText = this.m) != null && !d3.r0) {
                                    g2.a(this, (CharSequence)editText.getText());
                                }
                                if (this.h.R) {
                                    this.dismiss();
                                }
                                break block16;
                            }
                            throw null;
                        }
                        d d4 = this.h;
                        if (d4.z != null) break block18;
                        m m3 = d4.B;
                        if (m3 != null) {
                            m3.a(this, b2);
                        }
                        if (this.h.R) {
                            this.cancel();
                        }
                        break block16;
                    }
                    throw null;
                }
                d d5 = this.h;
                if (d5.z != null) break block19;
                m m4 = d5.C;
                if (m4 != null) {
                    m4.a(this, b2);
                }
                if (this.h.R) {
                    this.dismiss();
                }
            }
            m m5 = this.h.D;
            if (m5 != null) {
                m5.a(this, b2);
            }
            return;
        }
        throw null;
    }

    @Override
    public final void onShow(DialogInterface dialogInterface) {
        if (this.m != null) {
            c.a.b.q.a.u((DialogInterface)this, this.h);
            if (this.m.getText().length() > 0) {
                EditText editText = this.m;
                editText.setSelection(editText.getText().length());
            }
        }
        super.onShow(dialogInterface);
    }

    public final void p(TextView textView, Typeface typeface) {
        if (typeface == null) {
            return;
        }
        textView.setPaintFlags(128 | textView.getPaintFlags());
        textView.setTypeface(typeface);
    }

    public final void setTitle(int n2) {
        this.setTitle(this.h.a.getString(n2));
    }

    public final void setTitle(CharSequence charSequence) {
        this.k.setText(charSequence);
    }

    public void show() {
        try {
            Dialog.super.show();
            return;
        }
        catch (WindowManager.BadTokenException badTokenException) {
            throw new WindowManager.BadTokenException("Bad window token, you cannot show a dialog before an Activity is created or after it's hidden."){};
        }
    }

}

