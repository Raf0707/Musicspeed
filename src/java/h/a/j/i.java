/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.a.e
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package h.a.j;

import h.a.b;
import h.a.c;
import h.a.e;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class i {
    static Pattern a = Pattern.compile((String)"(....|\\.\\.)(\\[(.*)\\])?");

    private static <T extends b> List<T> a(Object object, String string2, boolean bl) {
        if (!string2.startsWith("/")) {
            String string3;
            if (string2.length() == 0) {
                if (object instanceof e) {
                    return Collections.singletonList((Object)((b)object));
                }
                throw new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
            }
            boolean bl2 = string2.contains((CharSequence)"/");
            int n2 = 0;
            if (bl2) {
                string3 = string2.substring(1 + string2.indexOf(47));
                string2 = string2.substring(0, string2.indexOf(47));
            } else {
                string3 = "";
            }
            Matcher matcher = a.matcher((CharSequence)string2);
            if (matcher.matches()) {
                String string4 = matcher.group(1);
                if (!"..".equals((Object)string4)) {
                    if (object instanceof c) {
                        int n3 = matcher.group(2) != null ? Integer.parseInt((String)matcher.group(3)) : -1;
                        LinkedList linkedList = new LinkedList();
                        Iterator iterator = ((c)object).i().iterator();
                        do {
                            if (!iterator.hasNext()) {
                                return linkedList;
                            }
                            b b2 = (b)iterator.next();
                            if (!b2.getType().matches(string4)) continue;
                            if (n3 == -1 || n3 == n2) {
                                linkedList.addAll(i.a(b2, string3, bl));
                            }
                            ++n2;
                        } while (!bl && n3 < 0 || linkedList.isEmpty());
                        return linkedList;
                    }
                    return Collections.emptyList();
                }
                throw new RuntimeException(".. notation no longer allowed");
            }
            StringBuilder stringBuilder = new StringBuilder(String.valueOf((Object)string2));
            stringBuilder.append(" is invalid path.");
            throw new RuntimeException(stringBuilder.toString());
        }
        throw new RuntimeException("Cannot start at / - only relative path expression into the structure are allowed");
    }

    public static <T extends b> List<T> b(b b2, String string2) {
        return i.a(b2, string2, false);
    }
}

