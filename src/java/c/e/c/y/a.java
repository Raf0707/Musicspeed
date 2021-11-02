/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.a
 *  com.google.gson.internal.b
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 */
package c.e.c.y;

import com.google.gson.internal.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class a<T> {
    final Class<? super T> a;
    final Type b;
    final int c;

    protected a() {
        Type type;
        this.b = type = a.d(a.class);
        this.a = b.k((Type)type);
        this.c = type.hashCode();
    }

    a(Type type) {
        Type type2;
        this.b = type2 = b.b((Type)((Type)com.google.gson.internal.a.b((Object)type)));
        this.a = b.k((Type)type2);
        this.c = type2.hashCode();
    }

    public static <T> a<T> a(Class<T> class_) {
        return new a<T>((Type)class_);
    }

    public static a<?> b(Type type) {
        return new a<T>(type);
    }

    static Type d(Class<?> class_) {
        Type type = class_.getGenericSuperclass();
        if (!(type instanceof Class)) {
            return b.b((Type)((ParameterizedType)type).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> c() {
        return this.a;
    }

    public final Type e() {
        return this.b;
    }

    public final boolean equals(Object object) {
        return object instanceof a && b.f((Type)this.b, (Type)((a)object).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return b.u((Type)this.b);
    }
}

