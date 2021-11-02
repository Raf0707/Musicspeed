/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.widget.TextView
 *  c.d.a.a.i
 *  com.github.stkent.amplify.prompt.DefaultLayoutPromptViewConfig
 *  com.github.stkent.amplify.prompt.i.f
 */
package com.github.stkent.amplify.prompt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;
import c.d.a.a.i;
import com.github.stkent.amplify.prompt.DefaultLayoutPromptViewConfig;
import com.github.stkent.amplify.prompt.c;
import com.github.stkent.amplify.prompt.i.f;

@SuppressLint(value={"ViewConstructor"})
public final class e
extends c {
    public e(Context context, DefaultLayoutPromptViewConfig defaultLayoutPromptViewConfig) {
        super(context, i.b);
        this.setBackgroundColor(defaultLayoutPromptViewConfig.q());
        this.getTitleTextView().setTextColor(defaultLayoutPromptViewConfig.z());
        if (this.getSubtitleTextView() != null) {
            this.getSubtitleTextView().setTextColor(defaultLayoutPromptViewConfig.y());
        }
    }
}

