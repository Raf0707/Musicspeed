/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.Throwable
 */
package h.a.f.a;

public class b
extends RuntimeException {
    Throwable f;

    public b(String string2, Throwable throwable) {
        if (throwable != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Exception while initializing ");
            stringBuffer.append(string2);
            stringBuffer.append(": ");
            stringBuffer.append((Object)throwable);
            string2 = stringBuffer.toString();
        }
        super(string2);
        this.f = throwable;
    }

    public Throwable getCause() {
        return this.f;
    }
}

