/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  androidx.core.app.e
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package b.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import b.c.b.e;
import java.util.ArrayList;

public final class c {
    public final Intent a;
    public final Bundle b;

    c(Intent intent, Bundle bundle) {
        this.a = intent;
        this.b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.a.setData(uri);
        b.i.h.a.h(context, this.a, this.b);
    }

    public static final class a {
        private final Intent a;
        private ArrayList<Bundle> b;
        private Bundle c;
        private ArrayList<Bundle> d;
        private boolean e;

        public a() {
            this(null);
        }

        public a(e e2) {
            Intent intent;
            this.a = intent = new Intent("android.intent.action.VIEW");
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = true;
            if (e2 != null) {
                intent.setPackage(e2.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            IBinder iBinder = e2 == null ? null : e2.a();
            androidx.core.app.e.b((Bundle)bundle, (String)"android.support.customtabs.extra.SESSION", (IBinder)iBinder);
            intent.putExtras(bundle);
        }

        public c a() {
            ArrayList<Bundle> arrayList;
            ArrayList<Bundle> arrayList2 = this.b;
            if (arrayList2 != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList2);
            }
            if ((arrayList = this.d) != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList);
            }
            this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.e);
            return new c(this.a, this.c);
        }
    }

}

