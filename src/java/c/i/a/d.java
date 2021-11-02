/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.View
 *  c.i.a.b
 *  c.i.a.l
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package c.i.a;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import c.i.a.b;
import c.i.a.l;
import java.util.List;

public interface d<Item extends l> {
    public void a(int var1, int var2);

    public boolean b(View var1, int var2, b<Item> var3, Item var4);

    public void c(int var1, int var2);

    public boolean d(View var1, MotionEvent var2, int var3, b<Item> var4, Item var5);

    public boolean e(View var1, int var2, b<Item> var3, Item var4);

    public d<Item> f(b<Item> var1);

    public void g(List<Item> var1, boolean var2);

    public void h(Bundle var1, String var2);

    public void i(CharSequence var1);

    public void j();

    public void k(int var1, int var2, Object var3);
}

