/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.style.ClickableSpan
 *  android.view.View
 *  java.lang.String
 */
package b.i.q.f0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import b.i.q.f0.c;

public final class a
extends ClickableSpan {
    private final int f;
    private final c g;
    private final int h;

    public a(int n2, c c2, int n3) {
        this.f = n2;
        this.g = c2;
        this.h = n3;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f);
        this.g.R(this.h, bundle);
    }
}

