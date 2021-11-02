/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 */
package c.f.a.a.a.e;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import c.f.a.a.a.c.j;

public abstract class b
extends RecyclerView.c0
implements j {
    private boolean A = true;
    private float B;
    private float C;
    private float D = -65536.0f;
    private float E = -65537.0f;
    private float F = 65536.0f;
    private float G = 65537.0f;
    private int x;
    private int y = 0;
    private int z = 0;

    public b(View view) {
        super(view);
    }

    @Override
    public float a() {
        return this.E;
    }

    @Override
    public float b() {
        return this.B;
    }

    @Override
    public void c(float f2) {
        this.C = f2;
    }

    @Override
    public float d() {
        return this.F;
    }

    @Override
    public void e(int n2) {
        this.x = n2;
    }

    @Override
    public boolean h() {
        return this.A;
    }

    @Override
    public void i(int n2) {
        this.y = n2;
    }

    @Override
    public void k(boolean bl) {
        this.A = bl;
    }

    @Override
    public float m() {
        return this.D;
    }

    @Override
    public void n(int n2) {
        this.z = n2;
    }

    @Override
    public void o(float f2) {
        this.B = f2;
    }

    @Override
    public void p(float f2, float f3, boolean bl) {
    }

    @Override
    public int q() {
        return this.x;
    }

    @Override
    public float s() {
        return this.C;
    }

    @Override
    public float t() {
        return this.G;
    }
}

