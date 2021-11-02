/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Typeface
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.Html
 *  android.text.SpannableString
 *  android.text.SpannableStringBuilder
 *  android.text.Spanned
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.text.style.ClickableSpan
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.RelativeSizeSpan
 *  android.text.style.StyleSpan
 *  android.text.style.URLSpan
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.appcompat.widget.Toolbar
 *  com.google.android.material.snackbar.Snackbar
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.ClassLoader
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 */
package com.michaelflisar.gdprdialog.m;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.snackbar.Snackbar;
import com.michaelflisar.gdprdialog.GDPRCustomTexts;
import com.michaelflisar.gdprdialog.GDPRNetwork;
import com.michaelflisar.gdprdialog.GDPRSetup;
import com.michaelflisar.gdprdialog.c;
import com.michaelflisar.gdprdialog.d;
import com.michaelflisar.gdprdialog.e;
import com.michaelflisar.gdprdialog.h;
import com.michaelflisar.gdprdialog.l;
import com.michaelflisar.gdprdialog.m.f;
import com.michaelflisar.gdprdialog.m.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class j {
    public static String a = "ARG_SETUP";
    public static String b = "ARG_LOCATION";
    private static String c = "KEY_STEP";
    private static String d = "KEY_AGE_CONFIRMED";
    private static String e = "KEY_SELECTED_CONSENT";
    private static String f = "KEY_EXPLICITLY_CONFIRMED_SERVICES";
    private GDPRSetup g;
    private h h;
    private c.c i = null;
    private int j = 0;
    private d k = null;
    private boolean l = false;
    private ArrayList<Integer> m = new ArrayList();
    private Snackbar n = null;
    private final List<LinearLayout> o = new ArrayList();

    public j(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(GDPRSetup.class.getClassLoader());
        this.g = (GDPRSetup)bundle.getParcelable(a);
        this.h = h.values()[bundle.getInt(b)];
        if (bundle2 != null) {
            this.j = bundle2.getInt(c);
            if (bundle2.containsKey(e)) {
                this.k = d.values()[bundle2.getInt(e)];
            }
            this.l = bundle2.getBoolean(d);
            this.m = bundle2.getIntegerArrayList(f);
            return;
        }
        this.m.clear();
        for (int i2 = 0; i2 < this.g.B().length; ++i2) {
            this.m.add((Object)0);
        }
    }

    private void A(Context context, b b2) {
        d d2 = this.k;
        if (d2 != null) {
            e e2 = new e(context, d2, this.h);
            c.e().i(e2);
            c.c c2 = this.i;
            if (c2 != null) {
                c2.h(e2, true);
            }
        }
        b2.a();
    }

    private void G(int n2, View view) {
        Snackbar snackbar;
        if (this.g.H()) {
            Toast.makeText((Context)view.getContext(), (int)n2, (int)1).show();
            return;
        }
        this.n = snackbar = Snackbar.b0((View)view, (int)n2, (int)0);
        snackbar.R();
    }

    private void H() {
        for (int i2 = 0; i2 < this.o.size(); ++i2) {
            LinearLayout linearLayout = (LinearLayout)this.o.get(i2);
            int n2 = i2 == this.j ? 0 : 8;
            linearLayout.setVisibility(n2);
        }
        Snackbar snackbar = this.n;
        if (snackbar != null && snackbar.I()) {
            this.n.v();
            this.n = null;
        }
    }

    public static Bundle a(GDPRSetup gDPRSetup, h h2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(a, (Parcelable)gDPRSetup);
        bundle.putInt(b, h2.ordinal());
        return bundle;
    }

    private void f(Activity activity, Button button, Button button2, Button button3) {
        if (this.g.z()) {
            if (!this.g.m()) {
                button2.setText(l.c);
            } else {
                button3.setText(l.c);
            }
        }
        boolean bl = true ^ this.g.p();
        if (this.g.z() && !this.g.m()) {
            button2.setText(l.c);
            bl = true;
        }
        if (!bl) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(activity.getString(l.e).toUpperCase());
            stringBuilder.append("\n");
            String string = stringBuilder.toString();
            String string2 = activity.getString(l.d);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(string2);
            SpannableString spannableString = new SpannableString((CharSequence)stringBuilder2.toString());
            spannableString.setSpan((Object)new StyleSpan(1), 0, string.length(), 0);
            spannableString.setSpan((Object)new RelativeSizeSpan(0.8f), string.length(), spannableString.length(), 0);
            spannableString.setSpan((Object)new ForegroundColorSpan(button2.getTextColors().getDefaultColor()), string.length(), spannableString.length(), 0);
            button2.setAllCaps(false);
            button2.setTypeface(Typeface.DEFAULT);
            button2.setText((CharSequence)spannableString);
        }
    }

    private void g(Activity activity, TextView textView, TextView textView2, TextView textView3, TextView textView4, CheckBox checkBox) {
        boolean bl = this.g.u().s();
        int n2 = 0;
        if (bl) {
            textView.setText((CharSequence)this.g.u().n((Context)activity));
        } else {
            int n3 = l.f;
            Object[] arrobject = new Object[1];
            String string = this.g.p() && !this.g.F() ? activity.getString(l.g) : "";
            arrobject[0] = string;
            textView.setText((CharSequence)Html.fromHtml((String)activity.getString(n3, arrobject)));
        }
        if (this.g.u().u()) {
            textView2.setText((CharSequence)Html.fromHtml((String)this.g.u().p((Context)activity)));
        } else {
            int n4 = this.g.z() ? l.b : l.p;
            String string = activity.getString(n4);
            String string2 = activity.getString(l.h);
            if (this.g.G()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(" ");
                stringBuilder.append(activity.getString(l.i, new Object[]{string}));
                string2 = stringBuilder.toString();
            }
            textView2.setText((CharSequence)Html.fromHtml((String)string2));
        }
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        if (this.g.u().r()) {
            textView3.setText((CharSequence)Html.fromHtml((String)this.g.u().m((Context)activity)));
        } else {
            int n5 = this.g.v().size();
            String string = this.g.w((Context)activity);
            String string3 = n5 == 1 ? activity.getString(l.k, new Object[]{string}) : activity.getString(l.j, new Object[]{string});
            Spanned spanned = Html.fromHtml((String)string3);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)spanned);
            URLSpan[] arruRLSpan = (URLSpan[])spannableStringBuilder.getSpans(0, spanned.length(), URLSpan.class);
            int n6 = arruRLSpan.length;
            while (n2 < n6) {
                this.z(spannableStringBuilder, arruRLSpan[n2], new com.michaelflisar.gdprdialog.m.e(this));
                ++n2;
            }
            textView3.setText((CharSequence)spannableStringBuilder);
        }
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        if (this.g.u().q()) {
            textView4.setText((CharSequence)this.g.u().l((Context)activity));
        } else {
            textView4.setText((CharSequence)Html.fromHtml((String)activity.getString(l.l)));
        }
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
        if (!this.g.r()) {
            checkBox.setVisibility(8);
        } else {
            textView4.setVisibility(8);
            checkBox.setChecked(this.l);
            checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new f(this));
        }
        this.k(textView3);
    }

    private void h(Activity activity, TextView textView, TextView textView2, TextView textView3) {
        String string;
        textView2.setText((CharSequence)Html.fromHtml((String)this.g.x((Context)activity, true)));
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        if (this.g.D() == null) {
            string = "";
        } else {
            int n2 = l.n;
            Object[] arrobject = new Object[]{this.g.D()};
            string = activity.getString(n2, arrobject);
        }
        textView3.setText((CharSequence)Html.fromHtml((String)activity.getString(l.m, new Object[]{string})));
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private boolean i(View view, boolean bl) {
        if (this.g.r() && bl && !this.l) {
            this.G(l.a, view);
            return false;
        }
        return true;
    }

    private boolean j(View view, boolean bl) {
        return true;
    }

    private void k(TextView textView) {
    }

    private /* synthetic */ void l(View view, Activity activity, b b2, View view2) {
        if (this.i(view, true)) {
            if (!this.j(view, true)) {
                return;
            }
            this.k = d.i;
            this.A((Context)activity, b2);
        }
    }

    private /* synthetic */ void n(View view, Activity activity, b b2, View view2) {
        if (this.i(view, false)) {
            if (!this.j(view, false)) {
                return;
            }
            if (this.g.z()) {
                if (this.g.m()) {
                    if (this.g.s()) {
                        this.j = 2;
                        this.H();
                        return;
                    }
                    this.k = d.h;
                    this.A((Context)activity, b2);
                    return;
                }
                this.k = d.g;
                this.A((Context)activity, b2);
                return;
            }
            if (this.g.s()) {
                this.j = 2;
                this.H();
                return;
            }
            this.k = d.h;
            this.A((Context)activity, b2);
        }
    }

    private /* synthetic */ void p(Activity activity, b b2, View view) {
        this.k = d.g;
        this.A((Context)activity, b2);
    }

    private /* synthetic */ void r(View view) {
        this.j = 0;
        this.H();
    }

    private /* synthetic */ void t(Activity activity, b b2, View view) {
        this.k = d.h;
        this.A((Context)activity, b2);
    }

    private /* synthetic */ void v() {
        this.j = 1;
        this.H();
    }

    private /* synthetic */ void x(CompoundButton compoundButton, boolean bl) {
        this.l = bl;
    }

    private void z(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan, final Runnable runnable) {
        int n2 = spannableStringBuilder.getSpanStart((Object)uRLSpan);
        int n3 = spannableStringBuilder.getSpanEnd((Object)uRLSpan);
        int n4 = spannableStringBuilder.getSpanFlags((Object)uRLSpan);
        spannableStringBuilder.setSpan((Object)new ClickableSpan(){

            public void onClick(View view) {
                runnable.run();
            }
        }, n2, n3, n4);
        spannableStringBuilder.removeSpan((Object)uRLSpan);
    }

    public void B() {
        c.e().a();
        this.i = null;
        this.o.clear();
    }

    public void C(Bundle bundle) {
        bundle.putInt(c, this.j);
        d d2 = this.k;
        if (d2 != null) {
            bundle.putInt(e, d2.ordinal());
        }
        bundle.putBoolean(d, this.l);
        bundle.putIntegerArrayList(f, this.m);
    }

    public void D(Object object, boolean bl) {
        try {
            this.i = (c.c)object;
            return;
        }
        catch (ClassCastException classCastException) {
            if (!bl) {
                c.e().f().a("GDPRViewManager", "Activity is not implementing callback, but this is explicitly demanded by the user");
                return;
            }
            throw new ClassCastException("Parent activity must implement GDPR.IGDPRCallback interface!");
        }
    }

    public boolean E() {
        return this.k == null;
    }

    public boolean F() {
        return this.g.H();
    }

    public int b() {
        return this.j;
    }

    public GDPRSetup c() {
        return this.g;
    }

    public boolean d() {
        if (this.j > 0) {
            this.j = 0;
            this.H();
            return true;
        }
        return false;
    }

    public void e(Activity activity, View view, b b2) {
        Toolbar toolbar = (Toolbar)view.findViewById(com.michaelflisar.gdprdialog.j.k);
        int n2 = !this.F() && !this.g.C() ? 8 : 0;
        toolbar.setVisibility(n2);
        if (this.g.u().t()) {
            toolbar.setTitle((CharSequence)this.g.u().o(view.getContext()));
        } else {
            toolbar.setTitle(l.o);
        }
        this.o.add((Object)((LinearLayout)view.findViewById(com.michaelflisar.gdprdialog.j.h)));
        this.o.add((Object)((LinearLayout)view.findViewById(com.michaelflisar.gdprdialog.j.i)));
        this.o.add((Object)((LinearLayout)view.findViewById(com.michaelflisar.gdprdialog.j.j)));
        Button button = (Button)view.findViewById(com.michaelflisar.gdprdialog.j.a);
        Button button2 = (Button)view.findViewById(com.michaelflisar.gdprdialog.j.d);
        Button button3 = (Button)view.findViewById(com.michaelflisar.gdprdialog.j.e);
        this.g(activity, (TextView)view.findViewById(com.michaelflisar.gdprdialog.j.l), (TextView)view.findViewById(com.michaelflisar.gdprdialog.j.p), (TextView)view.findViewById(com.michaelflisar.gdprdialog.j.q), (TextView)view.findViewById(com.michaelflisar.gdprdialog.j.r), (CheckBox)view.findViewById(com.michaelflisar.gdprdialog.j.f));
        this.f(activity, button, button2, button3);
        this.h(activity, (TextView)view.findViewById(com.michaelflisar.gdprdialog.j.m), (TextView)view.findViewById(com.michaelflisar.gdprdialog.j.n), (TextView)view.findViewById(com.michaelflisar.gdprdialog.j.o));
        this.H();
        button.setOnClickListener((View.OnClickListener)new com.michaelflisar.gdprdialog.m.a(this, view, activity, b2));
        button2.setOnClickListener((View.OnClickListener)new com.michaelflisar.gdprdialog.m.d(this, view, activity, b2));
        if (!this.g.l()) {
            button3.setVisibility(8);
        } else {
            button3.setOnClickListener((View.OnClickListener)new com.michaelflisar.gdprdialog.m.b(this, activity, b2));
        }
        view.findViewById(com.michaelflisar.gdprdialog.j.c).setOnClickListener((View.OnClickListener)new com.michaelflisar.gdprdialog.m.c(this));
        view.findViewById(com.michaelflisar.gdprdialog.j.b).setOnClickListener((View.OnClickListener)new g(this, activity, b2));
    }

    public /* synthetic */ void m(View view, Activity activity, b b2, View view2) {
        this.l(view, activity, b2, view2);
    }

    public /* synthetic */ void o(View view, Activity activity, b b2, View view2) {
        this.n(view, activity, b2, view2);
    }

    public /* synthetic */ void q(Activity activity, b b2, View view) {
        this.p(activity, b2, view);
    }

    public /* synthetic */ void s(View view) {
        this.r(view);
    }

    public /* synthetic */ void u(Activity activity, b b2, View view) {
        this.t(activity, b2, view);
    }

    public /* synthetic */ void w() {
        this.v();
    }

    public /* synthetic */ void y(CompoundButton compoundButton, boolean bl) {
        this.x(compoundButton, bl);
    }

    public static interface b {
        public void a();
    }

}

