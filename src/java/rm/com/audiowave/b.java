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

public final class b
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AudioWaveView a;

    public /* synthetic */ b(AudioWaveView audioWaveView) {
        this.a = audioWaveView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AudioWaveView.y(this.a, valueAnimator);
    }
}

