/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.e.b$a
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.reflect.Array
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Set
 */
package b.e;

import b.e.b;
import b.e.c;
import b.e.f;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class b<E>
implements Collection<E>,
Set<E> {
    private static final int[] f = new int[0];
    private static final Object[] g = new Object[0];
    private static Object[] h;
    private static int i;
    private static Object[] j;
    private static int k;
    private int[] l;
    Object[] m;
    int n;
    private f<E, E> o;

    public b() {
        this(0);
    }

    public b(int n2) {
        if (n2 == 0) {
            this.l = f;
            this.m = g;
        } else {
            this.a(n2);
        }
        this.n = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(int n2) {
        if (n2 == 8) {
            Class<b> class_ = b.class;
            // MONITORENTER : b.e.b.class
            Object[] arrobject = j;
            if (arrobject != null) {
                this.m = arrobject;
                j = (Object[])arrobject[0];
                this.l = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                --k;
                // MONITOREXIT : class_
                return;
            }
            // MONITOREXIT : class_
        } else if (n2 == 4) {
            Class<b> class_ = b.class;
            // MONITORENTER : b.e.b.class
            Object[] arrobject = h;
            if (arrobject != null) {
                this.m = arrobject;
                h = (Object[])arrobject[0];
                this.l = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                --i;
                // MONITOREXIT : class_
                return;
            }
            // MONITOREXIT : class_
        }
        this.l = new int[n2];
        this.m = new Object[n2];
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void c(int[] arrn, Object[] arrobject, int n2) {
        if (arrn.length == 8) {
            Class<b> class_ = b.class;
            synchronized (b.class) {
                if (k < 10) {
                    arrobject[0] = j;
                    arrobject[1] = arrn;
                    for (int i2 = n2 - 1; i2 >= 2; --i2) {
                        arrobject[i2] = null;
                    }
                    j = arrobject;
                    k = 1 + k;
                }
                // ** MonitorExit[var7_3] (shouldn't be in output)
                return;
            }
        }
        if (arrn.length != 4) {
            return;
        }
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (i < 10) {
                arrobject[0] = h;
                arrobject[1] = arrn;
                for (int i3 = n2 - 1; i3 >= 2; --i3) {
                    arrobject[i3] = null;
                }
                h = arrobject;
                i = 1 + i;
            }
            // ** MonitorExit[var7_4] (shouldn't be in output)
            return;
        }
    }

    private f<E, E> d() {
        if (this.o == null) {
            this.o = new a(this);
        }
        return this.o;
    }

    private int e(Object object, int n2) {
        int n3;
        int n4 = this.n;
        if (n4 == 0) {
            return -1;
        }
        int n5 = c.a(this.l, n4, n2);
        if (n5 < 0) {
            return n5;
        }
        if (object.equals(this.m[n5])) {
            return n5;
        }
        for (n3 = n5 + 1; n3 < n4 && this.l[n3] == n2; ++n3) {
            if (!object.equals(this.m[n3])) continue;
            return n3;
        }
        for (int i2 = n5 - 1; i2 >= 0 && this.l[i2] == n2; --i2) {
            if (!object.equals(this.m[i2])) continue;
            return i2;
        }
        return n3;
    }

    private int f() {
        int n2;
        int n3 = this.n;
        if (n3 == 0) {
            return -1;
        }
        int n4 = c.a(this.l, n3, 0);
        if (n4 < 0) {
            return n4;
        }
        if (this.m[n4] == null) {
            return n4;
        }
        for (n2 = n4 + 1; n2 < n3 && this.l[n2] == 0; ++n2) {
            if (this.m[n2] != null) continue;
            return n2;
        }
        for (int i2 = n4 - 1; i2 >= 0 && this.l[i2] == 0; --i2) {
            if (this.m[i2] != null) continue;
            return i2;
        }
        return n2;
    }

    public boolean add(E e2) {
        int n2;
        int n3;
        int n4;
        if (e2 == null) {
            n2 = this.f();
            n4 = 0;
        } else {
            int n5 = e2.hashCode();
            int n6 = this.e(e2, n5);
            n4 = n5;
            n2 = n6;
        }
        if (n2 >= 0) {
            return false;
        }
        int n7 = n2;
        int n8 = this.n;
        int[] arrn = this.l;
        if (n8 >= arrn.length) {
            int n9 = 4;
            if (n8 >= 8) {
                n9 = n8 + (n8 >> 1);
            } else if (n8 >= n9) {
                n9 = 8;
            }
            Object[] arrobject = this.m;
            this.a(n9);
            int[] arrn2 = this.l;
            if (arrn2.length > 0) {
                System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)arrn.length);
                System.arraycopy((Object)arrobject, (int)0, (Object)this.m, (int)0, (int)arrobject.length);
            }
            b.c(arrn, arrobject, this.n);
        }
        if (n7 < (n3 = this.n)) {
            int[] arrn3 = this.l;
            int n10 = n7 + 1;
            System.arraycopy((Object)arrn3, (int)n7, (Object)arrn3, (int)n10, (int)(n3 - n7));
            Object[] arrobject = this.m;
            System.arraycopy((Object)arrobject, (int)n7, (Object)arrobject, (int)n10, (int)(this.n - n7));
        }
        this.l[n7] = n4;
        this.m[n7] = e2;
        this.n = 1 + this.n;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        this.b(this.n + collection.size());
        Iterator iterator = collection.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            bl |= this.add(iterator.next());
        }
        return bl;
    }

    public void b(int n2) {
        int[] arrn = this.l;
        if (arrn.length < n2) {
            Object[] arrobject = this.m;
            this.a(n2);
            int n3 = this.n;
            if (n3 > 0) {
                System.arraycopy((Object)arrn, (int)0, (Object)this.l, (int)0, (int)n3);
                System.arraycopy((Object)arrobject, (int)0, (Object)this.m, (int)0, (int)this.n);
            }
            b.c(arrn, arrobject, this.n);
        }
    }

    public void clear() {
        int n2 = this.n;
        if (n2 != 0) {
            b.c(this.l, this.m, n2);
            this.l = f;
            this.m = g;
            this.n = 0;
        }
    }

    public boolean contains(Object object) {
        return this.indexOf(object) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.contains(iterator.next())) continue;
            return false;
        }
        return true;
    }

    /*
     * Exception decompiling
     */
    public boolean equals(Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl39.1 : ICONST_0 : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public E g(int n2) {
        Object[] arrobject = this.m;
        Object object = arrobject[n2];
        int n3 = this.n;
        if (n3 <= 1) {
            b.c(this.l, arrobject, n3);
            this.l = f;
            this.m = g;
            this.n = 0;
            return (E)object;
        }
        int[] arrn = this.l;
        int n4 = arrn.length;
        int n5 = 8;
        if (n4 > n5 && n3 < arrn.length / 3) {
            int n6;
            if (n3 > n5) {
                n5 = n3 + (n3 >> 1);
            }
            this.a(n5);
            --this.n;
            if (n2 > 0) {
                System.arraycopy((Object)arrn, (int)0, (Object)this.l, (int)0, (int)n2);
                System.arraycopy((Object)arrobject, (int)0, (Object)this.m, (int)0, (int)n2);
            }
            if (n2 < (n6 = this.n)) {
                int n7 = n2 + 1;
                System.arraycopy((Object)arrn, (int)n7, (Object)this.l, (int)n2, (int)(n6 - n2));
                System.arraycopy((Object)arrobject, (int)n7, (Object)this.m, (int)n2, (int)(this.n - n2));
                return (E)object;
            }
        } else {
            int n8;
            this.n = n8 = n3 - 1;
            if (n2 < n8) {
                int n9 = n2 + 1;
                System.arraycopy((Object)arrn, (int)n9, (Object)arrn, (int)n2, (int)(n8 - n2));
                Object[] arrobject2 = this.m;
                System.arraycopy((Object)arrobject2, (int)n9, (Object)arrobject2, (int)n2, (int)(this.n - n2));
            }
            this.m[this.n] = null;
        }
        return (E)object;
    }

    public E h(int n2) {
        return (E)this.m[n2];
    }

    public int hashCode() {
        int[] arrn = this.l;
        int n2 = this.n;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 += arrn[i2];
        }
        return n3;
    }

    public int indexOf(Object object) {
        if (object == null) {
            return this.f();
        }
        return this.e(object, object.hashCode());
    }

    public boolean isEmpty() {
        return this.n <= 0;
    }

    public Iterator<E> iterator() {
        return this.d().m().iterator();
    }

    public boolean remove(Object object) {
        int n2 = this.indexOf(object);
        if (n2 >= 0) {
            this.g(n2);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection<?> collection) {
        Iterator iterator = collection.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            bl |= this.remove(iterator.next());
        }
        return bl;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean bl = false;
        for (int i2 = this.n - 1; i2 >= 0; --i2) {
            if (collection.contains(this.m[i2])) continue;
            this.g(i2);
            bl = true;
        }
        return bl;
    }

    public int size() {
        return this.n;
    }

    public Object[] toArray() {
        int n2 = this.n;
        Object[] arrobject = new Object[n2];
        System.arraycopy((Object)this.m, (int)0, (Object)arrobject, (int)0, (int)n2);
        return arrobject;
    }

    public <T> T[] toArray(T[] arrobject) {
        if (arrobject.length < this.n) {
            arrobject = (Object[])Array.newInstance((Class)arrobject.getClass().getComponentType(), (int)this.n);
        }
        System.arraycopy((Object)this.m, (int)0, arrobject, (int)0, (int)this.n);
        int n2 = arrobject.length;
        int n3 = this.n;
        if (n2 > n3) {
            arrobject[n3] = null;
        }
        return arrobject;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(14 * this.n);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.n; ++i2) {
            E e2;
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if ((e2 = this.h(i2)) != this) {
                stringBuilder.append(e2);
                continue;
            }
            stringBuilder.append("(this Set)");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

