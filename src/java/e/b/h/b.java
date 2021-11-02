/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.LinkageError
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.ThreadDeath
 *  java.lang.Throwable
 *  java.lang.VirtualMachineError
 */
package e.b.h;

public final class b {
    public static RuntimeException a(Throwable throwable) {
        throw e.b.j.h.b.a(throwable);
    }

    public static void b(Throwable throwable) {
        if (!(throwable instanceof VirtualMachineError)) {
            if (!(throwable instanceof ThreadDeath)) {
                if (!(throwable instanceof LinkageError)) {
                    return;
                }
                throw (LinkageError)throwable;
            }
            throw (ThreadDeath)throwable;
        }
        throw (VirtualMachineError)throwable;
    }
}

