/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.util.Random
 */
package f.c0;

import f.c0.c;
import f.c0.d;
import java.util.Random;

public abstract class a
extends c {
    @Override
    public int b(int n2) {
        return d.e(this.e().nextInt(), n2);
    }

    @Override
    public int c() {
        return this.e().nextInt();
    }

    public abstract Random e();
}

