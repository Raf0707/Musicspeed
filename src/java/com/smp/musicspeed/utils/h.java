/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.Spanned
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.utils;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;

public class h
implements InputFilter {
    private boolean a(char c2) {
        return Character.isLetterOrDigit((char)c2) || Character.isSpaceChar((char)c2) || c2 == '_' || c2 == '-' || c2 == '(' || c2 == ')';
        {
        }
    }

    public CharSequence filter(CharSequence charSequence, int n2, int n3, Spanned spanned, int n4, int n5) {
        StringBuilder stringBuilder = new StringBuilder(n3 - n2);
        boolean bl = true;
        for (int i2 = n2; i2 < n3; ++i2) {
            char c2 = charSequence.charAt(i2);
            if (this.a(c2)) {
                stringBuilder.append(c2);
                continue;
            }
            bl = false;
        }
        if (bl) {
            return null;
        }
        if (charSequence instanceof Spanned) {
            SpannableString spannableString = new SpannableString((CharSequence)stringBuilder);
            TextUtils.copySpansFrom((Spanned)((Spanned)charSequence), (int)n2, (int)stringBuilder.length(), null, (Spannable)spannableString, (int)0);
            return spannableString;
        }
        return stringBuilder;
    }
}

