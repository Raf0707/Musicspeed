/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 */
package c.i.c.r;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.i.c.j;

public class e
extends RecyclerView.c0 {
    protected TextView A;
    protected View x;
    protected ImageView y;
    protected TextView z;

    public e(View view) {
        super(view);
        this.x = view;
        this.y = (ImageView)view.findViewById(j.e);
        this.z = (TextView)view.findViewById(j.k);
        this.A = (TextView)view.findViewById(j.c);
    }
}

