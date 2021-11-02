/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  com.bumptech.glide.c
 *  com.bumptech.glide.j
 *  com.bumptech.glide.l
 *  com.bumptech.glide.load.o.j
 *  com.bumptech.glide.load.q.f.c
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.e
 *  com.bumptech.glide.r.j.j
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package c.k.a;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import c.k.a.b;
import c.k.a.c;
import c.k.a.d;
import c.k.a.e;
import c.k.a.f;
import com.bumptech.glide.l;
import com.bumptech.glide.load.o.j;
import f.z.d.k;

public final class b
extends Fragment {
    private Uri f;

    public static final /* synthetic */ void t(b b2, Uri uri) {
        b2.v(uri);
    }

    public static /* synthetic */ void u(b b2, View view) {
        b.y(b2, view);
    }

    private final void v(Uri uri) {
        this.f = uri;
        androidx.fragment.app.d d2 = this.getActivity();
        if (d2 instanceof c) {
            ((c)d2).g(uri);
        }
    }

    private final void x() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(e.a);
        ((ImageView)view2).setOnClickListener((View.OnClickListener)new c.k.a.a(this));
    }

    private static final void y(b b2, View view) {
        k.g((Object)b2, "this$0");
        b2.z();
    }

    private final void z() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType("image/*");
        intent.addCategory("android.intent.category.OPENABLE");
        this.startActivityForResult(intent, 1234);
    }

    public void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n2 == 1234 && intent != null && intent.getData() != null) {
            this.w(intent.getData());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.g((Object)layoutInflater, "inflater");
        return layoutInflater.inflate(f.a, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle) {
        k.g((Object)bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("uri", (Parcelable)this.f);
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.g((Object)view, "view");
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.w((Uri)bundle.getParcelable("uri"));
        } else {
            this.w((Uri)this.requireArguments().getParcelable("initialImage"));
        }
        this.x();
    }

    public final void w(Uri uri) {
        com.bumptech.glide.j j2;
        if (uri == null) {
            View view = this.getView();
            View view2 = view == null ? null : view.findViewById(e.a);
            j2 = com.bumptech.glide.c.v((View)view2).r(Integer.valueOf((int)d.a));
        } else {
            View view = this.getView();
            View view3 = view == null ? null : view.findViewById(e.a);
            j2 = com.bumptech.glide.c.v((View)view3).q(uri);
        }
        k.f((Object)j2, "if (imagePath == null) {\n            Glide.with(image_current).load(R.drawable.ic_baseline_album_24_white)\n        } else {\n            Glide.with(image_current).load(imagePath)\n        }");
        com.bumptech.glide.j j3 = ((com.bumptech.glide.j)((com.bumptech.glide.j)((com.bumptech.glide.j)j2.A0((l)com.bumptech.glide.load.q.f.c.h()).Z(true)).e(j.b)).g(d.a)).s0((com.bumptech.glide.r.e)new com.bumptech.glide.r.e<Drawable>(this, uri){
            final /* synthetic */ b a;
            final /* synthetic */ Uri b;
            {
                this.a = b2;
                this.b = uri;
            }

            public boolean a(com.bumptech.glide.load.o.q q2, Object object, com.bumptech.glide.r.j.i<Drawable> i2, boolean bl) {
                b.t(this.a, null);
                return false;
            }

            public boolean c(Drawable drawable, Object object, com.bumptech.glide.r.j.i<Drawable> i2, com.bumptech.glide.load.a a2, boolean bl) {
                b.t(this.a, this.b);
                return false;
            }
        });
        View view = this.getView();
        View view4 = view == null ? null : view.findViewById(e.a);
        j3.q0((ImageView)view4);
    }
}

