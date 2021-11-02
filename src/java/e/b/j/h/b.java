/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Error
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package e.b.j.h;

public final class b {
    public static final Throwable a = new a();

    public static RuntimeException a(Throwable throwable) {
        if (!(throwable instanceof Error)) {
            if (throwable instanceof RuntimeException) {
                return (RuntimeException)throwable;
            }
            return new RuntimeException(throwable);
        }
        throw (Error)throwable;
    }

    static final class a
    extends Throwable {
        a() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

}

