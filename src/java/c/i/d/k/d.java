/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.i.d.k;

import android.widget.TextView;

public class d {
    private CharSequence a;
    private int b = -1;

    public d(int n2) {
        this.b = n2;
    }

    public static void b(d d2, TextView textView) {
        if (d2 != null && textView != null) {
            d2.a(textView);
        }
    }

    public static boolean d(d d2, TextView textView) {
        if (d2 != null && textView != null) {
            return d2.c(textView);
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
        return false;
    }

    public void a(TextView textView) {
        CharSequence charSequence = this.a;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        int n2 = this.b;
        if (n2 != -1) {
            textView.setText(n2);
            return;
        }
        textView.setText((CharSequence)"");
    }

    public boolean c(TextView textView) {
        CharSequence charSequence = this.a;
        if (charSequence != null) {
            textView.setText(charSequence);
            textView.setVisibility(0);
            return true;
        }
        int n2 = this.b;
        if (n2 != -1) {
            textView.setText(n2);
            textView.setVisibility(0);
            return true;
        }
        textView.setVisibility(8);
        return false;
    }

    public String toString() {
        CharSequence charSequence = this.a;
        if (charSequence != null) {
            return charSequence.toString();
        }
        if (this.b != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("StringRes:");
            stringBuilder.append(this.b);
            return stringBuilder.toString();
        }
        return "";
    }
}

