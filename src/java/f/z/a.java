/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.e0.b
 *  f.z.d.d
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.Void
 *  java.util.Objects
 */
package f.z;

import f.e0.b;
import f.z.d.d;
import f.z.d.k;
import f.z.d.z;
import java.util.Objects;

public final class a {
    public static final <T> Class<T> a(b<T> b2) {
        k.g(b2, "$this$java");
        Class class_ = ((d)b2).b();
        Objects.requireNonNull((Object)class_, (String)"null cannot be cast to non-null type java.lang.Class<T>");
        return class_;
    }

    public static final <T> Class<T> b(b<T> b2) {
        k.g(b2, "$this$javaObjectType");
        Class<Double> class_ = ((d)b2).b();
        if (!class_.isPrimitive()) {
            return class_;
        }
        String string2 = class_.getName();
        switch (string2.hashCode()) {
            default: {
                return class_;
            }
            case 109413500: {
                if (!string2.equals((Object)"short")) break;
                return Short.class;
            }
            case 97526364: {
                if (!string2.equals((Object)"float")) break;
                return Float.class;
            }
            case 64711720: {
                if (!string2.equals((Object)"boolean")) break;
                return Boolean.class;
            }
            case 3625364: {
                if (!string2.equals((Object)"void")) break;
                return Void.class;
            }
            case 3327612: {
                if (!string2.equals((Object)"long")) break;
                return Long.class;
            }
            case 3052374: {
                if (!string2.equals((Object)"char")) break;
                return Character.class;
            }
            case 3039496: {
                if (!string2.equals((Object)"byte")) break;
                return Byte.class;
            }
            case 104431: {
                if (!string2.equals((Object)"int")) break;
                return Integer.class;
            }
            case -1325958191: {
                if (!string2.equals((Object)"double")) break;
                class_ = Double.class;
            }
        }
        return class_;
    }

    public static final <T> b<T> c(Class<T> class_) {
        k.g(class_, "$this$kotlin");
        return z.b(class_);
    }
}

