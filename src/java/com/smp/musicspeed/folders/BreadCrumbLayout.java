/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.smp.musicspeed.utils.t
 *  java.io.File
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package com.smp.musicspeed.folders;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smp.musicspeed.folders.u;
import com.smp.musicspeed.utils.t;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BreadCrumbLayout
extends HorizontalScrollView
implements View.OnClickListener {
    private static final File f = Environment.getExternalStorageDirectory();
    private int g;
    private int h;
    private List<Crumb> i;
    private List<Crumb> j;
    private List<Crumb> k;
    private LinearLayout l;
    private int m;
    private a n;

    public BreadCrumbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g();
    }

    private void g() {
        LinearLayout linearLayout;
        this.g = t.e((Context)this.getContext());
        this.h = t.f((Context)this.getContext());
        this.setMinimumHeight((int)this.getResources().getDimension(2131165792));
        this.setClipToPadding(false);
        this.setHorizontalScrollBarEnabled(false);
        this.i = new ArrayList();
        this.k = new ArrayList();
        this.l = linearLayout = new LinearLayout(this.getContext());
        this.addView((View)linearLayout, new ViewGroup.LayoutParams(-2, -1));
    }

    private TextView h(View view, boolean bl, boolean bl2, boolean bl3) {
        int n2 = bl ? this.g : this.h;
        LinearLayout linearLayout = (LinearLayout)view;
        TextView textView = (TextView)linearLayout.getChildAt(0);
        textView.setTextColor(n2);
        ImageView imageView = (ImageView)linearLayout.getChildAt(1);
        imageView.setColorFilter(n2, PorterDuff.Mode.SRC_IN);
        if (bl2 && this.getChildCount() == 1) {
            imageView.setVisibility(8);
            return textView;
        }
        if (bl3) {
            imageView.setVisibility(0);
            return textView;
        }
        imageView.setVisibility(8);
        return textView;
    }

    private boolean m(Crumb crumb) {
        this.m = this.i.indexOf((Object)crumb);
        this.i();
        boolean bl = this.m > -1;
        if (bl) {
            this.requestLayout();
        }
        return bl;
    }

    private List<File> p() {
        ArrayList arrayList = new ArrayList();
        if (this.getContext() != null) {
            Iterator iterator = Arrays.asList((Object[])u.b(this.getContext())).iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)new File((String)iterator.next()));
            }
            arrayList.add((Object)f);
        }
        return arrayList;
    }

    public void c(Crumb crumb, boolean bl) {
        LinearLayout linearLayout = (LinearLayout)LayoutInflater.from((Context)this.getContext()).inflate(2131492904, (ViewGroup)this, false);
        linearLayout.setTag((Object)this.i.size());
        linearLayout.setOnClickListener((View.OnClickListener)this);
        ImageView imageView = (ImageView)linearLayout.getChildAt(1);
        if (Build.VERSION.SDK_INT >= 19 && imageView.getDrawable() != null) {
            imageView.getDrawable().setAutoMirrored(true);
        }
        imageView.setVisibility(8);
        this.l.addView((View)linearLayout, new ViewGroup.LayoutParams(-2, -2));
        this.i.add((Object)crumb);
        if (bl) {
            this.m = this.i.size() - 1;
            this.requestLayout();
        }
        this.i();
    }

    public void d(Crumb crumb) {
        this.k.add((Object)crumb);
    }

    public void e() {
        try {
            this.j = new ArrayList(this.i);
            this.i.clear();
            this.l.removeAllViews();
            return;
        }
        catch (IllegalStateException illegalStateException) {
            illegalStateException.printStackTrace();
            return;
        }
    }

    public Crumb f(int n2) {
        return (Crumb)this.i.get(n2);
    }

    public int getActiveIndex() {
        return this.m;
    }

    public SavedStateWrapper getStateWrapper() {
        return new SavedStateWrapper(this);
    }

    void i() {
        for (int i2 = 0; i2 < this.i.size(); ++i2) {
            Crumb crumb = (Crumb)this.i.get(i2);
            View view = this.l.getChildAt(i2);
            int n2 = this.m;
            int n3 = this.i.indexOf((Object)crumb);
            boolean bl = true;
            boolean bl2 = n2 == n3;
            if (i2 >= this.i.size() - bl) {
                bl = false;
            }
            this.h(view, bl2, false, bl).setText((CharSequence)crumb.n());
        }
    }

    public Crumb j() {
        if (this.k.size() == 0) {
            return null;
        }
        List<Crumb> list = this.k;
        return (Crumb)list.get(-1 + list.size());
    }

    public boolean k() {
        if (this.k.size() == 0) {
            return false;
        }
        List<Crumb> list = this.k;
        list.remove(list.size() - 1);
        int n2 = this.k.size();
        boolean bl = false;
        if (n2 != 0) {
            bl = true;
        }
        return bl;
    }

    public void l(SavedStateWrapper savedStateWrapper) {
        if (savedStateWrapper != null) {
            this.m = savedStateWrapper.f;
            Iterator iterator = savedStateWrapper.g.iterator();
            while (iterator.hasNext()) {
                this.c((Crumb)iterator.next(), false);
            }
            this.requestLayout();
            this.setVisibility(savedStateWrapper.h);
        }
    }

    public void n(Crumb crumb, boolean bl) {
        if (bl || !this.m(crumb)) {
            this.e();
            ArrayList arrayList = new ArrayList();
            File file = crumb.l();
            int n2 = 0;
            arrayList.add(0, (Object)file);
            File file2 = crumb.l();
            List<File> list = this.p();
            while (file2 != null && !list.contains((Object)file2) && (file2 = file2.getParentFile()) != null) {
                arrayList.add(0, (Object)file2);
            }
            Context context = this.getContext();
            while (n2 < arrayList.size()) {
                List<Crumb> list2;
                File file3 = (File)arrayList.get(n2);
                Crumb crumb2 = new Crumb(file3);
                if (list.contains((Object)file3) && context != null) {
                    if (file3.equals((Object)f)) {
                        crumb2.p(context.getString(2131820630));
                    } else {
                        crumb2.p(context.getString(2131820650));
                    }
                }
                if ((list2 = this.j) != null) {
                    Iterator iterator = list2.iterator();
                    while (iterator.hasNext()) {
                        Crumb crumb3 = (Crumb)iterator.next();
                        if (!crumb3.equals(crumb2)) continue;
                        crumb2.o(crumb3.m());
                        iterator.remove();
                        break;
                    }
                }
                this.c(crumb2, true);
                ++n2;
            }
            this.j = null;
        }
    }

    public int o() {
        return this.i.size();
    }

    public void onClick(View view) {
        if (this.n != null) {
            int n2 = (Integer)view.getTag();
            this.n.g((Crumb)this.i.get(n2), n2);
        }
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        View view = this.l.getChildAt(this.m);
        if (view != null) {
            this.smoothScrollTo(view.getLeft(), 0);
        }
    }

    public void setCallback(a a2) {
        this.n = a2;
    }

    public static class Crumb
    implements Parcelable {
        public static final Parcelable.Creator<Crumb> CREATOR = new Parcelable.Creator<Crumb>(){

            public Crumb a(Parcel parcel) {
                return new Crumb(parcel);
            }

            public Crumb[] b(int n2) {
                return new Crumb[n2];
            }
        };
        private final File f;
        private int g;
        private String h;

        protected Crumb(Parcel parcel) {
            this.f = (File)parcel.readSerializable();
            this.g = parcel.readInt();
            this.h = parcel.readString();
        }

        public Crumb(File file) {
            this.f = file;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object object) {
            Crumb crumb;
            return object instanceof Crumb && (crumb = (Crumb)object).l() != null && crumb.l().equals((Object)this.l());
        }

        public File l() {
            return this.f;
        }

        public int m() {
            return this.g;
        }

        public String n() {
            String string = this.h;
            if (string != null) {
                return string;
            }
            if (this.f.getPath().equals((Object)"/")) {
                return "root";
            }
            return this.f.getName();
        }

        public void o(int n2) {
            this.g = n2;
        }

        public void p(String string) {
            this.h = string;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Crumb{file=");
            stringBuilder.append((Object)this.f);
            stringBuilder.append(", scrollPos=");
            stringBuilder.append(this.g);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int n2) {
            parcel.writeSerializable((Serializable)this.f);
            parcel.writeInt(this.g);
            parcel.writeString(this.h);
        }

    }

    public static class SavedStateWrapper
    implements Parcelable {
        public static final Parcelable.Creator<SavedStateWrapper> CREATOR = new Parcelable.Creator<SavedStateWrapper>(){

            public SavedStateWrapper a(Parcel parcel) {
                return new SavedStateWrapper(parcel);
            }

            public SavedStateWrapper[] b(int n2) {
                return new SavedStateWrapper[n2];
            }
        };
        public final int f;
        public final List<Crumb> g;
        public final int h;

        protected SavedStateWrapper(Parcel parcel) {
            this.f = parcel.readInt();
            this.g = parcel.createTypedArrayList(Crumb.CREATOR);
            this.h = parcel.readInt();
        }

        public SavedStateWrapper(BreadCrumbLayout breadCrumbLayout) {
            this.f = breadCrumbLayout.m;
            this.g = breadCrumbLayout.i;
            this.h = breadCrumbLayout.getVisibility();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            parcel.writeInt(this.f);
            parcel.writeTypedList(this.g);
            parcel.writeInt(this.h);
        }

    }

    public static interface a {
        public void g(Crumb var1, int var2);
    }

}

