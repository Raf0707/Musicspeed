/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.AttributeSet
 *  android.widget.TextView
 *  androidx.appcompat.widget.Toolbar
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 */
package com.smp.musicspeed.misc;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.lang.reflect.Field;

public class MarqueeToolbar
extends Toolbar {
    TextView U;
    boolean V = false;

    public MarqueeToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean P() {
        try {
            TextView textView;
            Field field = Toolbar.class.getDeclaredField("g");
            field.setAccessible(true);
            this.U = textView = (TextView)field.get((Object)this);
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            this.U.setMarqueeRepeatLimit(-1);
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public void Q() {
        TextView textView = this.U;
        if (textView != null) {
            textView.setSelected(true);
        }
    }

    public void setTitle(int n2) {
        if (!this.V) {
            this.V = this.P();
        }
        super.setTitle(n2);
        this.Q();
    }

    public void setTitle(CharSequence charSequence) {
        if (!this.V) {
            this.V = this.P();
        }
        super.setTitle(charSequence);
        this.Q();
    }
}

