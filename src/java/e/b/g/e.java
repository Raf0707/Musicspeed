/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package e.b.g;

import e.b.g.d;

final class e
extends d<Runnable> {
    e(Runnable runnable) {
        super(runnable);
    }

    protected void d(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunnableDisposable(disposed=");
        stringBuilder.append(this.b());
        stringBuilder.append(", ");
        stringBuilder.append(this.get());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

