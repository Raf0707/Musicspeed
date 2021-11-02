/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.h.a$c
 *  e.b.h.a$d
 *  java.io.PrintStream
 *  java.io.PrintWriter
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 */
package e.b.h;

import e.b.h.a;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public final class a
extends RuntimeException {
    private final List<Throwable> f;
    private final String g;
    private Throwable h;

    public a(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable throwable : iterable) {
                if (throwable instanceof a) {
                    linkedHashSet.addAll(((a)throwable).b());
                    continue;
                }
                if (throwable != null) {
                    linkedHashSet.add((Object)throwable);
                    continue;
                }
                linkedHashSet.add((Object)new NullPointerException("Throwable was null!"));
            }
        } else {
            linkedHashSet.add((Object)new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            List list;
            arrayList.addAll((Collection)linkedHashSet);
            this.f = list = Collections.unmodifiableList((List)arrayList);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(list.size());
            stringBuilder.append(" exceptions occurred. ");
            this.g = stringBuilder.toString();
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    private void a(StringBuilder stringBuilder, Throwable throwable, String string2) {
        stringBuilder.append(string2);
        stringBuilder.append((Object)throwable);
        stringBuilder.append('\n');
        for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            stringBuilder.append("\t\tat ");
            stringBuilder.append((Object)stackTraceElement);
            stringBuilder.append('\n');
        }
        if (throwable.getCause() != null) {
            stringBuilder.append("\tCaused by: ");
            this.a(stringBuilder, throwable.getCause(), "");
        }
    }

    private List<Throwable> c(Throwable throwable) {
        ArrayList arrayList = new ArrayList();
        Throwable throwable2 = throwable.getCause();
        if (throwable2 != null) {
            if (throwable2 == throwable) {
                return arrayList;
            }
            do {
                arrayList.add((Object)throwable2);
                Throwable throwable3 = throwable2.getCause();
                if (throwable3 == null) break;
                if (throwable3 == throwable2) {
                    return arrayList;
                }
                throwable2 = throwable3;
            } while (true);
        }
        return arrayList;
    }

    private void e(b b2) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append((Object)this);
        stringBuilder.append('\n');
        for (StackTraceElement stackTraceElement : this.getStackTrace()) {
            stringBuilder.append("\tat ");
            stringBuilder.append((Object)stackTraceElement);
            stringBuilder.append('\n');
        }
        Iterator iterator = this.f.iterator();
        int n2 = 1;
        while (iterator.hasNext()) {
            Throwable throwable = (Throwable)iterator.next();
            stringBuilder.append("  ComposedException ");
            stringBuilder.append(n2);
            stringBuilder.append(" :\n");
            this.a(stringBuilder, throwable, "\t");
            ++n2;
        }
        b2.a(stringBuilder.toString());
    }

    public List<Throwable> b() {
        return this.f;
    }

    Throwable d(Throwable throwable) {
        Throwable throwable2 = throwable.getCause();
        if (throwable2 != null) {
            Throwable throwable3;
            if (throwable == throwable2) {
                return throwable;
            }
            while ((throwable3 = throwable2.getCause()) != null) {
                if (throwable3 == throwable2) {
                    return throwable2;
                }
                throwable2 = throwable3;
            }
            return throwable2;
        }
        return throwable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Throwable getCause() {
        a a2 = this;
        synchronized (a2) {
            if (this.h != null) return this.h;
            a a3 = new a();
            HashSet hashSet = new HashSet();
            Iterator iterator = this.f.iterator();
            a a4 = a3;
            do {
                Iterator iterator2;
                Throwable throwable;
                if (iterator.hasNext()) {
                    throwable = (Throwable)iterator.next();
                    if (hashSet.contains((Object)throwable)) continue;
                    hashSet.add((Object)throwable);
                    iterator2 = this.c(throwable).iterator();
                } else {
                    this.h = a3;
                    return this.h;
                }
                while (iterator2.hasNext()) {
                    Throwable throwable2 = (Throwable)iterator2.next();
                    if (hashSet.contains((Object)throwable2)) {
                        throwable = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        continue;
                    }
                    hashSet.add((Object)throwable2);
                }
                try {
                    a4.initCause(throwable);
                }
                catch (Throwable throwable3) {}
                a4 = this.d((Throwable)a4);
            } while (true);
        }
    }

    public String getMessage() {
        return this.g;
    }

    public void printStackTrace() {
        this.printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        this.e((b)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void printStackTrace(PrintWriter printWriter) {
        this.e((b)new /* Unavailable Anonymous Inner Class!! */);
    }

    static final class a
    extends RuntimeException {
        a() {
        }

        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    static abstract class b {
        b() {
        }

        abstract void a(Object var1);
    }

}

