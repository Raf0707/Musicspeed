/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  com.smp.musicspeed.i0.m
 *  java.lang.Object
 */
package com.smp.musicspeed.i0;

import android.view.KeyEvent;
import android.widget.TextView;
import com.smp.musicspeed.i0.m;

public final class i
implements TextView.OnEditorActionListener {
    public final /* synthetic */ m a;

    public /* synthetic */ i(m m2) {
        this.a = m2;
    }

    public final boolean onEditorAction(TextView textView, int n2, KeyEvent keyEvent) {
        return m.t0((m)this.a, (TextView)textView, (int)n2, (KeyEvent)keyEvent);
    }
}

