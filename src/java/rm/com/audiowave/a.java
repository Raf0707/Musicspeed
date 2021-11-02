/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  java.lang.Object
 */
package rm.com.audiowave;

import android.animation.ValueAnimator;
import rm.com.audiowave.AudioWaveView;

public final class a
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AudioWaveView a;

    public /* synthetic */ a(AudioWaveView audioWaveView) {
        this.a = audioWaveView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AudioWaveView.x(this.a, valueAnimator);
    }
}

