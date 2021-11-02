/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package e.b.h;

public final class c
extends RuntimeException {
    public c(String string2, Throwable throwable) {
        if (throwable == null) {
            throwable = new NullPointerException();
        }
        super(string2, throwable);
    }

    public c(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | ");
        stringBuilder.append((Object)throwable);
        this(stringBuilder.toString(), throwable);
    }
}

