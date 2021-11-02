/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ConcurrentModificationException
 */
package b.e;

import b.e.c;
import java.util.ConcurrentModificationException;

public class g<K, V> {
    static Object[] f;
    static int g;
    static Object[] h;
    static int i;
    int[] j;
    Object[] k;
    int l;

    public g() {
        this.j = c.a;
        this.k = c.c;
        this.l = 0;
    }

    public g(int n2) {
        if (n2 == 0) {
            this.j = c.a;
            this.k = c.c;
        } else {
            this.b(n2);
        }
        this.l = 0;
    }

    public g(g<K, V> g2) {
        this();
        if (g2 != null) {
            this.k(g2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void b(int n2) {
        if (n2 == 8) {
            Class<g> class_ = g.class;
            // MONITORENTER : b.e.g.class
            Object[] arrobject = h;
            if (arrobject != null) {
                this.k = arrobject;
                h = (Object[])arrobject[0];
                this.j = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                --i;
                // MONITOREXIT : class_
                return;
            }
            // MONITOREXIT : class_
        } else if (n2 == 4) {
            Class<g> class_ = g.class;
            // MONITORENTER : b.e.g.class
            Object[] arrobject = f;
            if (arrobject != null) {
                this.k = arrobject;
                f = (Object[])arrobject[0];
                this.j = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                --g;
                // MONITOREXIT : class_
                return;
            }
            // MONITOREXIT : class_
        }
        this.j = new int[n2];
        this.k = new Object[n2 << 1];
    }

    private static int c(int[] arrn, int n2, int n3) {
        try {
            int n4 = c.a(arrn, n2, n3);
            return n4;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new ConcurrentModificationException();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void e(int[] arrn, Object[] arrobject, int n2) {
        if (arrn.length == 8) {
            Class<g> class_ = g.class;
            synchronized (g.class) {
                if (i < 10) {
                    arrobject[0] = h;
                    arrobject[1] = arrn;
                    for (int i2 = (n2 << 1) - 1; i2 >= 2; --i2) {
                        arrobject[i2] = null;
                    }
                    h = arrobject;
                    i = 1 + i;
                }
                // ** MonitorExit[var7_3] (shouldn't be in output)
                return;
            }
        }
        if (arrn.length != 4) {
            return;
        }
        Class<g> class_ = g.class;
        synchronized (g.class) {
            if (g < 10) {
                arrobject[0] = f;
                arrobject[1] = arrn;
                for (int i3 = (n2 << 1) - 1; i3 >= 2; --i3) {
                    arrobject[i3] = null;
                }
                f = arrobject;
                g = 1 + g;
            }
            // ** MonitorExit[var7_4] (shouldn't be in output)
            return;
        }
    }

    public void clear() {
        int n2 = this.l;
        if (n2 > 0) {
            int[] arrn = this.j;
            Object[] arrobject = this.k;
            this.j = c.a;
            this.k = c.c;
            this.l = 0;
            g.e(arrn, arrobject, n2);
        }
        if (this.l <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(Object object) {
        return this.g(object) >= 0;
    }

    public boolean containsValue(Object object) {
        return this.i(object) >= 0;
    }

    public void d(int n2) {
        int n3 = this.l;
        int[] arrn = this.j;
        if (arrn.length < n2) {
            Object[] arrobject = this.k;
            this.b(n2);
            if (this.l > 0) {
                System.arraycopy((Object)arrn, (int)0, (Object)this.j, (int)0, (int)n3);
                System.arraycopy((Object)arrobject, (int)0, (Object)this.k, (int)0, (int)(n3 << 1));
            }
            g.e(arrn, arrobject, n3);
        }
        if (this.l == n3) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    /*
     * Exception decompiling
     */
    public boolean equals(Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl114.1 : ICONST_0 : trying to set 0 previously set to 1
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

    int f(Object object, int n2) {
        int n3;
        int n4 = this.l;
        if (n4 == 0) {
            return -1;
        }
        int n5 = g.c(this.j, n4, n2);
        if (n5 < 0) {
            return n5;
        }
        if (object.equals(this.k[n5 << 1])) {
            return n5;
        }
        for (n3 = n5 + 1; n3 < n4 && this.j[n3] == n2; ++n3) {
            if (!object.equals(this.k[n3 << 1])) continue;
            return n3;
        }
        for (int i2 = n5 - 1; i2 >= 0 && this.j[i2] == n2; --i2) {
            if (!object.equals(this.k[i2 << 1])) continue;
            return i2;
        }
        return n3;
    }

    public int g(Object object) {
        if (object == null) {
            return this.h();
        }
        return this.f(object, object.hashCode());
    }

    public V get(Object object) {
        return this.getOrDefault(object, null);
    }

    public V getOrDefault(Object object, V object2) {
        int n2 = this.g(object);
        if (n2 >= 0) {
            object2 = this.k[1 + (n2 << 1)];
        }
        return object2;
    }

    int h() {
        int n2;
        int n3 = this.l;
        if (n3 == 0) {
            return -1;
        }
        int n4 = g.c(this.j, n3, 0);
        if (n4 < 0) {
            return n4;
        }
        if (this.k[n4 << 1] == null) {
            return n4;
        }
        for (n2 = n4 + 1; n2 < n3 && this.j[n2] == 0; ++n2) {
            if (this.k[n2 << 1] != null) continue;
            return n2;
        }
        for (int i2 = n4 - 1; i2 >= 0 && this.j[i2] == 0; --i2) {
            if (this.k[i2 << 1] != null) continue;
            return i2;
        }
        return n2;
    }

    public int hashCode() {
        int[] arrn = this.j;
        Object[] arrobject = this.k;
        int n2 = this.l;
        int n3 = 1;
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            Object object = arrobject[n3];
            int n6 = arrn[n4];
            int n7 = object == null ? 0 : object.hashCode();
            n5 += n7 ^ n6;
            ++n4;
            n3 += 2;
        }
        return n5;
    }

    int i(Object object) {
        int n2 = 2 * this.l;
        Object[] arrobject = this.k;
        if (object == null) {
            for (int i2 = 1; i2 < n2; i2 += 2) {
                if (arrobject[i2] != null) continue;
                return i2 >> 1;
            }
        } else {
            for (int i3 = 1; i3 < n2; i3 += 2) {
                if (!object.equals(arrobject[i3])) continue;
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.l <= 0;
    }

    public K j(int n2) {
        return (K)this.k[n2 << 1];
    }

    public void k(g<? extends K, ? extends V> g2) {
        int n2 = g2.l;
        this.d(n2 + this.l);
        int n3 = this.l;
        if (n3 == 0) {
            if (n2 > 0) {
                System.arraycopy((Object)g2.j, (int)0, (Object)this.j, (int)0, (int)n2);
                System.arraycopy((Object)g2.k, (int)0, (Object)this.k, (int)0, (int)(n2 << 1));
                this.l = n2;
                return;
            }
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.put(g2.j(i2), g2.n(i2));
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public V l(int n2) {
        int n3;
        Object[] arrobject = this.k;
        int n4 = n2 << 1;
        Object object = arrobject[n4 + 1];
        int n5 = this.l;
        if (n5 <= 1) {
            g.e(this.j, arrobject, n5);
            this.j = c.a;
            this.k = c.c;
            n3 = 0;
        } else {
            int n6 = n5 - 1;
            int[] arrn = this.j;
            int n7 = arrn.length;
            int n8 = 8;
            if (n7 > n8 && n5 < arrn.length / 3) {
                if (n5 > n8) {
                    n8 = n5 + (n5 >> 1);
                }
                this.b(n8);
                if (n5 != this.l) throw new ConcurrentModificationException();
                if (n2 > 0) {
                    System.arraycopy((Object)arrn, (int)0, (Object)this.j, (int)0, (int)n2);
                    System.arraycopy((Object)arrobject, (int)0, (Object)this.k, (int)0, (int)n4);
                }
                if (n2 < n6) {
                    int n9 = n2 + 1;
                    int[] arrn2 = this.j;
                    int n10 = n6 - n2;
                    System.arraycopy((Object)arrn, (int)n9, (Object)arrn2, (int)n2, (int)n10);
                    System.arraycopy((Object)arrobject, (int)(n9 << 1), (Object)this.k, (int)n4, (int)(n10 << 1));
                }
            } else {
                if (n2 < n6) {
                    int n11 = n2 + 1;
                    int n12 = n6 - n2;
                    System.arraycopy((Object)arrn, (int)n11, (Object)arrn, (int)n2, (int)n12);
                    Object[] arrobject2 = this.k;
                    System.arraycopy((Object)arrobject2, (int)(n11 << 1), (Object)arrobject2, (int)n4, (int)(n12 << 1));
                }
                Object[] arrobject3 = this.k;
                int n13 = n6 << 1;
                arrobject3[n13] = null;
                arrobject3[n13 + 1] = null;
            }
            n3 = n6;
        }
        if (n5 != this.l) throw new ConcurrentModificationException();
        this.l = n3;
        return (V)object;
    }

    public V m(int n2, V v2) {
        int n3 = 1 + (n2 << 1);
        Object[] arrobject = this.k;
        Object object = arrobject[n3];
        arrobject[n3] = v2;
        return (V)object;
    }

    public V n(int n2) {
        return (V)this.k[1 + (n2 << 1)];
    }

    public V put(K k2, V v2) {
        int n2;
        int[] arrn;
        int n3;
        int n4;
        int n5 = this.l;
        if (k2 == null) {
            n3 = this.h();
            n2 = 0;
        } else {
            int n6 = k2.hashCode();
            int n7 = this.f(k2, n6);
            n2 = n6;
            n3 = n7;
        }
        if (n3 >= 0) {
            int n8 = 1 + (n3 << 1);
            Object[] arrobject = this.k;
            Object object = arrobject[n8];
            arrobject[n8] = v2;
            return (V)object;
        }
        int n9 = n3;
        int[] arrn2 = this.j;
        if (n5 >= arrn2.length) {
            int n10 = 4;
            if (n5 >= 8) {
                n10 = n5 + (n5 >> 1);
            } else if (n5 >= n10) {
                n10 = 8;
            }
            Object[] arrobject = this.k;
            this.b(n10);
            if (n5 == this.l) {
                int[] arrn3 = this.j;
                if (arrn3.length > 0) {
                    System.arraycopy((Object)arrn2, (int)0, (Object)arrn3, (int)0, (int)arrn2.length);
                    System.arraycopy((Object)arrobject, (int)0, (Object)this.k, (int)0, (int)arrobject.length);
                }
                g.e(arrn2, arrobject, n5);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (n9 < n5) {
            int[] arrn4 = this.j;
            int n11 = n9 + 1;
            System.arraycopy((Object)arrn4, (int)n9, (Object)arrn4, (int)n11, (int)(n5 - n9));
            Object[] arrobject = this.k;
            System.arraycopy((Object)arrobject, (int)(n9 << 1), (Object)arrobject, (int)(n11 << 1), (int)(this.l - n9 << 1));
        }
        if (n5 == (n4 = this.l) && n9 < (arrn = this.j).length) {
            arrn[n9] = n2;
            Object[] arrobject = this.k;
            int n12 = n9 << 1;
            arrobject[n12] = k2;
            arrobject[n12 + 1] = v2;
            this.l = n4 + 1;
            return null;
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v2) {
        V v3 = this.get(k2);
        if (v3 == null) {
            v3 = this.put(k2, v2);
        }
        return v3;
    }

    public V remove(Object object) {
        int n2 = this.g(object);
        if (n2 >= 0) {
            return this.l(n2);
        }
        return null;
    }

    public boolean remove(Object object, Object object2) {
        V v2;
        int n2 = this.g(object);
        if (n2 >= 0 && (object2 == (v2 = this.n(n2)) || object2 != null && object2.equals(v2))) {
            this.l(n2);
            return true;
        }
        return false;
    }

    public V replace(K k2, V v2) {
        int n2 = this.g(k2);
        if (n2 >= 0) {
            return this.m(n2, v2);
        }
        return null;
    }

    public boolean replace(K k2, V v2, V v3) {
        V v4;
        int n2 = this.g(k2);
        if (n2 >= 0 && ((v4 = this.n(n2)) == v2 || v2 != null && v2.equals(v4))) {
            this.m(n2, v3);
            return true;
        }
        return false;
    }

    public int size() {
        return this.l;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(28 * this.l);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.l; ++i2) {
            K k2;
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if ((k2 = this.j(i2)) != this) {
                stringBuilder.append(k2);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            V v2 = this.n(i2);
            if (v2 != this) {
                stringBuilder.append(v2);
                continue;
            }
            stringBuilder.append("(this Map)");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

