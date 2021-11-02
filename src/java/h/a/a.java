/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.channels.WritableByteChannel
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package h.a;

import h.a.b;
import h.a.c;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class a
implements c {
    private List<b> f = new ArrayList();

    @Override
    public List<b> i() {
        return this.f;
    }

    @Override
    public final void o(WritableByteChannel writableByteChannel) throws IOException {
        Iterator iterator = this.i().iterator();
        while (iterator.hasNext()) {
            ((b)iterator.next()).b(writableByteChannel);
        }
        return;
    }

    public void p(b b2) {
        if (b2 != null) {
            ArrayList arrayList;
            this.f = arrayList = new ArrayList(this.i());
            arrayList.add((Object)b2);
        }
    }

    protected long t() {
        long l2 = 0L;
        int n2 = 0;
        while (n2 < this.i().size()) {
            l2 += ((b)this.f.get(n2)).a();
            ++n2;
        }
        return l2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("[");
        int n2 = 0;
        do {
            if (n2 >= this.f.size()) {
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            if (n2 > 0) {
                stringBuilder.append(";");
            }
            stringBuilder.append(((b)this.f.get(n2)).toString());
            ++n2;
        } while (true);
    }

    public void u(List<? extends b> list) {
        this.f = new ArrayList(list);
    }
}

