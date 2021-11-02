/*
 * Decompiled with CFR 0.0.
 */
package me.zhanghai.android.materialprogressbar;

import me.zhanghai.android.materialprogressbar.BasePaintDrawable;
import me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable;

abstract class BaseProgressDrawable
extends BasePaintDrawable
implements IntrinsicPaddingDrawable {
    protected boolean mUseIntrinsicPadding = true;

    BaseProgressDrawable() {
    }

    @Override
    public boolean getUseIntrinsicPadding() {
        return this.mUseIntrinsicPadding;
    }

    @Override
    public void setUseIntrinsicPadding(boolean bl) {
        if (this.mUseIntrinsicPadding != bl) {
            this.mUseIntrinsicPadding = bl;
            this.invalidateSelf();
        }
    }
}

