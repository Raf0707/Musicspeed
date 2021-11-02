/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.view.KeyEvent
 *  b.i.h.a
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.smp.musicspeed.player;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import com.smp.musicspeed.player.PlayFileService;
import com.smp.musicspeed.player.a;
import f.z.d.k;

public final class j
extends MediaSessionCompat.Callback {
    private final Context a;
    private final Handler b;
    private int c;
    private final Runnable d;

    public j(Context context) {
        k.g((Object)context, "context");
        Context context2 = context.getApplicationContext();
        k.f((Object)context2, "context.applicationContext");
        this.a = context2;
        this.b = new Handler(Looper.getMainLooper());
        this.d = new a(this);
    }

    public static /* synthetic */ void a(j j2) {
        j.b(j2);
    }

    private static final void b(j j2) {
        k.g((Object)j2, "this$0");
        int n2 = j2.c;
        if (n2 == 1) {
            j2.g();
        } else if (n2 == 2) {
            j2.c();
        } else {
            j2.h();
        }
        j2.c = 0;
    }

    private final void c() {
        Intent intent = new Intent(this.a, PlayFileService.class);
        intent.setAction("com.smp.musicspeed.ACTION.NEXT_TRACK");
        this.i(intent);
    }

    private final void d(int n2) {
        if (n2 == 0) {
            int n3;
            this.c = n3 = 1 + this.c;
            if (n3 == 1) {
                this.b.postDelayed(this.d, 700L);
            }
        }
    }

    private final void e(boolean bl) {
        Intent intent = new Intent(this.a, PlayFileService.class);
        intent.setAction("com.smp.musicspeed.seek_increment");
        intent.putExtra("com.smp.musicspeed.intent_reverse_seek_increment", bl);
        this.i(intent);
    }

    private final void f(long l2) {
        Intent intent = new Intent(this.a, PlayFileService.class);
        intent.setAction("com.smp.musicspeed.intent_seek_to_ms");
        intent.putExtra("com.smp.musicspeed.intent_seek_position", l2);
        this.i(intent);
    }

    private final void g() {
        Intent intent = new Intent(this.a, PlayFileService.class);
        intent.setAction("com.smp.musicspeed.ACTION_PLAY");
        this.i(intent);
    }

    private final void h() {
        Intent intent = new Intent(this.a, PlayFileService.class);
        intent.setAction("com.smp.musicspeed.ACTION.PREVIOUS_TRACK");
        this.i(intent);
    }

    private final void i(Intent intent) {
        b.i.h.a.i((Context)this.a, (Intent)intent);
    }

    private final void j() {
        Intent intent = new Intent(this.a, PlayFileService.class);
        intent.setAction("com.smp.musicspeed.ACTION_STOP");
        this.i(intent);
    }

    public void onFastForward() {
        super.onFastForward();
        this.e(false);
    }

    public boolean onMediaButtonEvent(Intent intent) {
        k.g((Object)intent, "event");
        KeyEvent keyEvent = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            return false;
        }
        int n2 = keyEvent.getKeyCode();
        int n3 = keyEvent.getAction();
        if (n2 == 79) {
            this.d(n3);
            return true;
        }
        if (n2 != 87 && n2 != 272) {
            if (n2 != 88 && n2 != 273) {
                if (n2 == 90) {
                    if (n3 == 1) {
                        this.onFastForward();
                    }
                    return true;
                }
                if (n2 == 89) {
                    if (n3 == 1) {
                        this.onRewind();
                    }
                    return true;
                }
                if (n2 == 85 && Build.VERSION.SDK_INT < 21 && n3 == 1) {
                    this.g();
                    return true;
                }
                return false;
            }
            if (n3 == 1) {
                this.h();
            }
            return true;
        }
        if (n3 == 1) {
            this.c();
        }
        return true;
    }

    public void onPause() {
        super.onPause();
        this.g();
    }

    public void onPlay() {
        super.onPlay();
        this.g();
    }

    public void onRewind() {
        super.onRewind();
        this.e(true);
    }

    public void onSeekTo(long l2) {
        super.onSeekTo(l2);
        this.f(l2);
    }

    public void onSkipToNext() {
        super.onSkipToNext();
        this.c();
    }

    public void onSkipToPrevious() {
        super.onSkipToPrevious();
        this.h();
    }

    public void onStop() {
        super.onStop();
        this.j();
    }
}

