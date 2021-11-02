/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.View
 *  c.d.a.a.j
 *  com.github.stkent.amplify.prompt.DefaultLayoutPromptViewConfig
 *  com.github.stkent.amplify.prompt.i.b
 *  java.lang.String
 */
package com.github.stkent.amplify.prompt;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import c.d.a.a.j;
import com.github.stkent.amplify.prompt.DefaultLayoutPromptViewConfig;
import com.github.stkent.amplify.prompt.a;
import com.github.stkent.amplify.prompt.d;
import com.github.stkent.amplify.prompt.e;
import com.github.stkent.amplify.prompt.i.b;

public final class DefaultLayoutPromptView
extends a<d, e>
implements b {
    private DefaultLayoutPromptViewConfig l;

    public DefaultLayoutPromptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultLayoutPromptView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.s(attributeSet);
    }

    private void s(AttributeSet attributeSet) {
        TypedArray typedArray = this.getContext().getTheme().obtainStyledAttributes(attributeSet, j.L, 0, 0);
        this.l = new DefaultLayoutPromptViewConfig(typedArray);
        typedArray.recycle();
    }

    @Override
    protected d getQuestionView() {
        return new d(this.getContext(), this.l);
    }

    @Override
    protected e getThanksView() {
        return new e(this.getContext(), this.l);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle)parcelable;
        if (bundle != null) {
            Parcelable parcelable2 = bundle.getParcelable("SUPER_STATE_KEY");
            super.onRestoreInstanceState(parcelable2);
            DefaultLayoutPromptViewConfig defaultLayoutPromptViewConfig = (DefaultLayoutPromptViewConfig)bundle.getParcelable("DEFAULT_LAYOUT_PROMPT_VIEW_CONFIG_KEY");
            if (defaultLayoutPromptViewConfig != null) {
                this.l = defaultLayoutPromptViewConfig;
            }
            this.r(parcelable2);
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER_STATE_KEY", parcelable);
        bundle.putParcelable("DEFAULT_LAYOUT_PROMPT_VIEW_CONFIG_KEY", (Parcelable)this.l);
        return bundle;
    }

    @Override
    protected boolean p() {
        return true;
    }
}

