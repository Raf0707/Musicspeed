/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package h.a.g.a.d;

import h.a.g.d.a;
import java.nio.ByteBuffer;

public class d
extends a {
    @Override
    public ByteBuffer a() {
        return ByteBuffer.allocate((int)0);
    }

    @Override
    public String b() {
        return "tsas";
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return object != null && d.class == object.getClass();
        {
        }
    }

    public int hashCode() {
        return 41;
    }
}

