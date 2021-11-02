/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.g0.k
 *  f.u.g0
 *  f.u.l
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package f.z.d;

import f.c;
import f.e0.b;
import f.l;
import f.p;
import f.u.g0;
import f.z.c.f;
import f.z.c.h;
import f.z.c.i;
import f.z.c.j;
import f.z.c.m;
import f.z.c.n;
import f.z.c.o;
import f.z.c.q;
import f.z.c.r;
import f.z.c.s;
import f.z.c.t;
import f.z.c.u;
import f.z.c.v;
import f.z.c.w;
import f.z.d.d;
import f.z.d.g;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class e
implements b<Object>,
d {
    private static final Map<Class<? extends c<?>>, Integer> a;
    private static final HashMap<String, String> b;
    private static final HashMap<String, String> c;
    private static final HashMap<String, String> d;
    private static final Map<String, String> e;
    public static final a f;
    private final Class<?> g;

    static {
        f = new Object(null){
            {
                this();
            }

            public final String a(Class<?> class_) {
                k.g(class_, "jClass");
                if (class_.isAnonymousClass()) {
                    return null;
                }
                if (class_.isLocalClass()) {
                    return null;
                }
                if (class_.isArray()) {
                    Class class_2 = class_.getComponentType();
                    k.f((Object)class_2, "componentType");
                    boolean bl = class_2.isPrimitive();
                    String string = null;
                    if (bl) {
                        String string2 = (String)d.get((Object)class_2.getName());
                        string = null;
                        if (string2 != null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(string2);
                            stringBuilder.append("Array");
                            string = stringBuilder.toString();
                        }
                    }
                    if (string != null) {
                        return string;
                    }
                    return "kotlin.Array";
                }
                String string = (String)d.get((Object)class_.getName());
                if (string != null) {
                    return string;
                }
                return class_.getCanonicalName();
            }
        };
        Object[] arrobject = new Class[23];
        int n2 = 0;
        arrobject[0] = f.z.c.a.class;
        arrobject[1] = f.z.c.l.class;
        arrobject[2] = f.z.c.p.class;
        arrobject[3] = q.class;
        arrobject[4] = r.class;
        arrobject[5] = s.class;
        arrobject[6] = t.class;
        arrobject[7] = u.class;
        arrobject[8] = v.class;
        arrobject[9] = w.class;
        arrobject[10] = f.z.c.b.class;
        arrobject[11] = f.z.c.c.class;
        arrobject[12] = f.z.c.d.class;
        arrobject[13] = f.z.c.e.class;
        arrobject[14] = f.class;
        arrobject[15] = f.z.c.g.class;
        arrobject[16] = h.class;
        arrobject[17] = i.class;
        arrobject[18] = j.class;
        arrobject[19] = f.z.c.k.class;
        arrobject[20] = m.class;
        arrobject[21] = n.class;
        arrobject[22] = o.class;
        List list = f.u.l.g((Object[])arrobject);
        ArrayList arrayList = new ArrayList(f.u.l.j((Iterable)list, (int)10));
        for (Object object : list) {
            int n3 = n2 + 1;
            if (n2 < 0) {
                f.u.l.i();
            }
            arrayList.add(p.a((Class)object, n2));
            n2 = n3;
        }
        a = g0.n((Iterable)arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"boolean", (Object)"kotlin.Boolean");
        hashMap.put((Object)"char", (Object)"kotlin.Char");
        hashMap.put((Object)"byte", (Object)"kotlin.Byte");
        hashMap.put((Object)"short", (Object)"kotlin.Short");
        hashMap.put((Object)"int", (Object)"kotlin.Int");
        hashMap.put((Object)"float", (Object)"kotlin.Float");
        hashMap.put((Object)"long", (Object)"kotlin.Long");
        hashMap.put((Object)"double", (Object)"kotlin.Double");
        b = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"java.lang.Boolean", (Object)"kotlin.Boolean");
        hashMap2.put((Object)"java.lang.Character", (Object)"kotlin.Char");
        hashMap2.put((Object)"java.lang.Byte", (Object)"kotlin.Byte");
        hashMap2.put((Object)"java.lang.Short", (Object)"kotlin.Short");
        hashMap2.put((Object)"java.lang.Integer", (Object)"kotlin.Int");
        hashMap2.put((Object)"java.lang.Float", (Object)"kotlin.Float");
        hashMap2.put((Object)"java.lang.Long", (Object)"kotlin.Long");
        hashMap2.put((Object)"java.lang.Double", (Object)"kotlin.Double");
        c = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put((Object)"java.lang.Object", (Object)"kotlin.Any");
        hashMap3.put((Object)"java.lang.String", (Object)"kotlin.String");
        hashMap3.put((Object)"java.lang.CharSequence", (Object)"kotlin.CharSequence");
        hashMap3.put((Object)"java.lang.Throwable", (Object)"kotlin.Throwable");
        hashMap3.put((Object)"java.lang.Cloneable", (Object)"kotlin.Cloneable");
        hashMap3.put((Object)"java.lang.Number", (Object)"kotlin.Number");
        hashMap3.put((Object)"java.lang.Comparable", (Object)"kotlin.Comparable");
        hashMap3.put((Object)"java.lang.Enum", (Object)"kotlin.Enum");
        hashMap3.put((Object)"java.lang.annotation.Annotation", (Object)"kotlin.Annotation");
        hashMap3.put((Object)"java.lang.Iterable", (Object)"kotlin.collections.Iterable");
        hashMap3.put((Object)"java.util.Iterator", (Object)"kotlin.collections.Iterator");
        hashMap3.put((Object)"java.util.Collection", (Object)"kotlin.collections.Collection");
        hashMap3.put((Object)"java.util.List", (Object)"kotlin.collections.List");
        hashMap3.put((Object)"java.util.Set", (Object)"kotlin.collections.Set");
        hashMap3.put((Object)"java.util.ListIterator", (Object)"kotlin.collections.ListIterator");
        hashMap3.put((Object)"java.util.Map", (Object)"kotlin.collections.Map");
        hashMap3.put((Object)"java.util.Map$Entry", (Object)"kotlin.collections.Map.Entry");
        hashMap3.put((Object)"kotlin.jvm.internal.StringCompanionObject", (Object)"kotlin.String.Companion");
        hashMap3.put((Object)"kotlin.jvm.internal.EnumCompanionObject", (Object)"kotlin.Enum.Companion");
        hashMap3.putAll((Map)hashMap);
        hashMap3.putAll((Map)hashMap2);
        Collection collection = hashMap.values();
        k.f((Object)collection, "primitiveFqNames.values");
        for (String string : collection) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.jvm.internal.");
            k.f(string, "kotlinName");
            stringBuilder.append(f.g0.k.U((String)string, (char)'.', null, (int)2, null));
            stringBuilder.append("CompanionObject");
            String string2 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(".Companion");
            l<String, String> l2 = p.a(string2, stringBuilder2.toString());
            hashMap3.put((Object)l2.c(), (Object)l2.d());
        }
        for (Map.Entry entry : a.entrySet()) {
            Class class_ = (Class)entry.getKey();
            int n4 = ((Number)entry.getValue()).intValue();
            String string = class_.getName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.Function");
            stringBuilder.append(n4);
            hashMap3.put((Object)string, (Object)stringBuilder.toString());
        }
        d = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.d((int)hashMap3.size()));
        for (Map.Entry entry : hashMap3.entrySet()) {
            linkedHashMap.put(entry.getKey(), (Object)f.g0.k.U((String)((String)entry.getValue()), (char)'.', null, (int)2, null));
        }
        e = linkedHashMap;
    }

    public e(Class<?> class_) {
        k.g(class_, "jClass");
        this.g = class_;
    }

    @Override
    public String a() {
        return f.a(this.b());
    }

    @Override
    public Class<?> b() {
        return this.g;
    }

    public boolean equals(Object object) {
        return object instanceof e && k.c(f.z.a.b(this), f.z.a.b((b)object));
    }

    public int hashCode() {
        return f.z.a.b(this).hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b().toString());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }

}

