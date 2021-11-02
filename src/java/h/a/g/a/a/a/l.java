/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.a.g.a.a.a.a
 *  h.a.g.a.a.a.e
 *  h.a.g.a.a.a.f
 *  h.a.g.a.a.a.h
 *  h.a.g.a.a.a.i
 *  h.a.g.a.a.a.j
 *  h.a.g.a.a.a.k
 *  h.a.g.a.a.a.m
 *  h.a.g.a.a.a.n
 *  h.a.g.a.a.a.o
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Modifier
 *  java.nio.ByteBuffer
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 */
package h.a.g.a.a.a;

import h.a.g.a.a.a.a;
import h.a.g.a.a.a.b;
import h.a.g.a.a.a.e;
import h.a.g.a.a.a.f;
import h.a.g.a.a.a.g;
import h.a.g.a.a.a.h;
import h.a.g.a.a.a.i;
import h.a.g.a.a.a.j;
import h.a.g.a.a.a.k;
import h.a.g.a.a.a.m;
import h.a.g.a.a.a.n;
import h.a.g.a.a.a.o;
import h.a.j.d;
import h.e.c;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class l {
    protected static h.e.b a = c.i(l.class);
    protected static Map<Integer, Map<Integer, Class<? extends b>>> b = new HashMap();

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(f.class);
        hashSet.add(n.class);
        hashSet.add(b.class);
        hashSet.add(i.class);
        hashSet.add(k.class);
        hashSet.add(m.class);
        hashSet.add(a.class);
        hashSet.add(j.class);
        hashSet.add(h.class);
        hashSet.add(e.class);
        Iterator iterator = hashSet.iterator();
        block0 : while (iterator.hasNext()) {
            Class class_ = (Class)iterator.next();
            g g2 = (g)class_.getAnnotation(g.class);
            int[] arrn = g2.tags();
            int n2 = g2.objectTypeIndication();
            Map map = (Map)b.get((Object)n2);
            if (map == null) {
                map = new HashMap();
            }
            int n3 = arrn.length;
            int n4 = 0;
            do {
                if (n4 >= n3) {
                    b.put((Object)n2, (Object)map);
                    continue block0;
                }
                map.put((Object)arrn[n4], (Object)class_);
                ++n4;
            } while (true);
            break;
        }
        return;
    }

    public static b a(int n2, ByteBuffer byteBuffer) throws IOException {
        Class class_;
        Object object;
        int n3 = d.m(byteBuffer);
        Map map = (Map)b.get((Object)n2);
        if (map == null) {
            map = (Map)b.get((Object)-1);
        }
        if ((class_ = (Class)map.get((Object)n3)) != null && !class_.isInterface() && !Modifier.isAbstract((int)class_.getModifiers())) {
            try {
                object = (b)class_.newInstance();
            }
            catch (Exception exception) {
                h.e.b b2 = a;
                StringBuilder stringBuilder = new StringBuilder("Couldn't instantiate BaseDescriptor class ");
                stringBuilder.append((Object)class_);
                stringBuilder.append(" for objectTypeIndication ");
                stringBuilder.append(n2);
                stringBuilder.append(" and tag ");
                stringBuilder.append(n3);
                b2.b(stringBuilder.toString(), exception);
                throw new RuntimeException((Throwable)exception);
            }
        } else {
            if (a.a()) {
                h.e.b b3 = a;
                Object[] arrobject = new Object[]{Integer.toHexString((int)n2), Integer.toHexString((int)n3), class_};
                b3.c("No ObjectDescriptor found for objectTypeIndication {} and tag {} found: {}", arrobject);
            }
            object = new o();
        }
        object.d(n3, byteBuffer);
        return object;
    }
}

