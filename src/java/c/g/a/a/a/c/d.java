/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.media.AudioManager
 *  android.net.Uri
 *  android.os.Handler
 *  android.provider.Settings
 *  android.provider.Settings$System
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import c.g.a.a.a.c.a;
import c.g.a.a.a.c.c;

public final class d
extends ContentObserver {
    private final Context a;
    private final AudioManager b;
    private final a c;
    private final c d;
    private float e;

    public d(Handler handler, Context context, a a2, c c2) {
        super(handler);
        this.a = context;
        this.b = (AudioManager)context.getSystemService("audio");
        this.c = a2;
        this.d = c2;
    }

    private boolean b(float f2) {
        return f2 != this.e;
    }

    private float d() {
        int n2 = this.b.getStreamVolume(3);
        int n3 = this.b.getStreamMaxVolume(3);
        return this.c.a(n2, n3);
    }

    private void e() {
        this.d.a(this.e);
    }

    public void a() {
        this.e = this.d();
        this.e();
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, (ContentObserver)this);
    }

    public void c() {
        this.a.getContentResolver().unregisterContentObserver((ContentObserver)this);
    }

    public void onChange(boolean bl) {
        super.onChange(bl);
        float f2 = this.d();
        if (this.b(f2)) {
            this.e = f2;
            this.e();
        }
    }
}

