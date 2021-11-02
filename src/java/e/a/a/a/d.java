/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.String
 */
package e.a.a.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import e.a.a.a.a;
import e.a.a.a.b;

public abstract class d
extends a {
    public d(b b2) {
        super(b2);
        if (b2.d == null) {
            if (!b2.j) {
                if (b2.e == null) {
                    if (!b2.k) {
                        if (b2.f == null) {
                            if (!b2.l) {
                                return;
                            }
                            throw new IllegalArgumentException("Stateless section shouldn't have emptyViewWillBeProvided set");
                        }
                        throw new IllegalArgumentException("Stateless section shouldn't have an empty state resource");
                    }
                    throw new IllegalArgumentException("Stateless section shouldn't have failedViewWillBeProvided set");
                }
                throw new IllegalArgumentException("Stateless section shouldn't have a failed state resource");
            }
            throw new IllegalArgumentException("Stateless section shouldn't have loadingViewWillBeProvided set");
        }
        throw new IllegalArgumentException("Stateless section shouldn't have a loading state resource");
    }

    @Override
    public final void F(RecyclerView.c0 c02) {
        super.F(c02);
    }

    @Override
    public final void G(RecyclerView.c0 c02) {
        super.G(c02);
    }

    @Override
    public final void K(RecyclerView.c0 c02) {
        super.K(c02);
    }

    @Override
    public final RecyclerView.c0 d(View view) {
        return super.d(view);
    }

    @Override
    public final RecyclerView.c0 g(View view) {
        return super.g(view);
    }

    @Override
    public final RecyclerView.c0 s(View view) {
        return super.s(view);
    }
}

