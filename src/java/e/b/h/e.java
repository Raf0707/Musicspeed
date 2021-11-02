/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package e.b.h;

public final class e
extends IllegalStateException {
    public e(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | ");
        stringBuilder.append((Object)throwable);
        super(stringBuilder.toString(), throwable);
    }
}

