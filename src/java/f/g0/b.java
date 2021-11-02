/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 */
package f.g0;

import f.g0.a;

class b
extends a {
    public static final boolean d(char c2, char c3, boolean bl) {
        char c4;
        boolean bl2 = true;
        if (c2 == c3) {
            return bl2;
        }
        if (!bl) {
            return false;
        }
        char c5 = Character.toUpperCase((char)c2);
        if (c5 != (c4 = Character.toUpperCase((char)c3))) {
            if (Character.toLowerCase((char)c5) == Character.toLowerCase((char)c4)) {
                return bl2;
            }
            bl2 = false;
        }
        return bl2;
    }
}

