/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.SystemClock
 *  c.c.a.e
 *  c.c.a.e$a
 *  c.c.a.h
 *  f.u.l
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 */
package c.c.a.k;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.SystemClock;
import c.c.a.d;
import c.c.a.e;
import c.c.a.h;
import c.c.a.k.b;
import f.u.l;
import f.z.d.f;
import f.z.d.k;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@TargetApi(value=11)
public final class i
extends b {
    private Set<String> b;
    private long c;
    private final f.z.c.a<Set<String>> d;
    private final String e;
    private final boolean f;

    public i(f.z.c.a<? extends Set<String>> a2, String string, boolean bl) {
        k.g(a2, "default");
        this.d = a2;
        this.e = string;
        this.f = bl;
    }

    @Override
    public String d() {
        return this.e;
    }

    public Set<String> g(d d2, f.e0.i<?> i2) {
        k.g(d2, "thisRef");
        k.g(i2, "property");
        if (this.b != null && this.c >= d2.n()) {
            Set<String> set = this.b;
            k.e(set);
            return set;
        }
        Set set = d2.l().getStringSet(this.c(), null);
        HashSet hashSet = null;
        if (set != null) {
            hashSet = new HashSet((Collection)set);
        }
        if (hashSet == null) {
            hashSet = l.P((Iterable)((Iterable)this.d.invoke()));
        }
        this.b = new a(d2, (Set<String>)hashSet, this.c());
        this.c = SystemClock.uptimeMillis();
        Set<String> set2 = this.b;
        k.e(set2);
        return set2;
    }

    public final class c.c.a.k.i$a
    implements Set<String> {
        private Set<String> f;
        private final d g;
        private final Set<String> h;
        private final String i;

        public c.c.a.k.i$a(d d2, Set<String> set, String string) {
            k.g(d2, "kotprefModel");
            k.g(set, "set");
            k.g(string, "key");
            this.g = d2;
            this.h = set;
            this.i = string;
            this.addAll((Collection<? extends String>)set);
        }

        private final Set<String> h() {
            Set set = this.f;
            if (set == null) {
                set = l.P(this.h);
            }
            this.f = set;
            return set;
        }

        @SuppressLint(value={"CommitPrefEdits"})
        public boolean addAll(Collection<? extends String> collection) {
            k.g(collection, "elements");
            if (this.g.i()) {
                Set<String> set = this.h();
                k.e(set);
                boolean bl = set.addAll(collection);
                e.a a2 = this.g.h();
                k.e((Object)a2);
                a2.b(this.i, this);
                return bl;
            }
            boolean bl = this.h.addAll(collection);
            SharedPreferences.Editor editor = this.g.l().edit().putStringSet(this.i, this.h);
            k.f((Object)editor, "kotprefModel.kotprefPref\u2026().putStringSet(key, set)");
            h.a((SharedPreferences.Editor)editor, (boolean)i.this.f);
            return bl;
        }

        @SuppressLint(value={"CommitPrefEdits"})
        public boolean b(String string) {
            k.g(string, "element");
            if (this.g.i()) {
                Set<String> set = this.h();
                k.e(set);
                boolean bl = set.add((Object)string);
                e.a a2 = this.g.h();
                k.e((Object)a2);
                a2.b(this.i, this);
                return bl;
            }
            boolean bl = this.h.add((Object)string);
            SharedPreferences.Editor editor = this.g.l().edit().putStringSet(this.i, this.h);
            k.f((Object)editor, "kotprefModel.kotprefPref\u2026().putStringSet(key, set)");
            h.a((SharedPreferences.Editor)editor, (boolean)i.this.f);
            return bl;
        }

        public boolean c(String string) {
            k.g(string, "element");
            if (this.g.i()) {
                Set<String> set = this.h();
                k.e(set);
                return set.contains((Object)string);
            }
            return this.h.contains((Object)string);
        }

        @SuppressLint(value={"CommitPrefEdits"})
        public void clear() {
            if (this.g.i()) {
                Set<String> set = this.h();
                k.e(set);
                set.clear();
                e.a a2 = this.g.h();
                k.e((Object)a2);
                a2.b(this.i, this);
                return;
            }
            this.h.clear();
            SharedPreferences.Editor editor = this.g.l().edit().putStringSet(this.i, this.h);
            k.f((Object)editor, "kotprefModel.kotprefPref\u2026().putStringSet(key, set)");
            h.a((SharedPreferences.Editor)editor, (boolean)i.this.f);
        }

        public boolean containsAll(Collection<? extends Object> collection) {
            k.g(collection, "elements");
            if (this.g.i()) {
                Set<String> set = this.h();
                k.e(set);
                return set.containsAll(collection);
            }
            return this.h.containsAll(collection);
        }

        public final String d() {
            return this.i;
        }

        public final d e() {
            return this.g;
        }

        public final Set<String> f() {
            return this.h;
        }

        public int g() {
            if (this.g.i()) {
                Set<String> set = this.h();
                k.e(set);
                return set.size();
            }
            return this.h.size();
        }

        @SuppressLint(value={"CommitPrefEdits"})
        public boolean i(String string) {
            k.g(string, "element");
            if (this.g.i()) {
                Set<String> set = this.h();
                k.e(set);
                boolean bl = set.remove((Object)string);
                e.a a2 = this.g.h();
                k.e((Object)a2);
                a2.b(this.i, this);
                return bl;
            }
            boolean bl = this.h.remove((Object)string);
            SharedPreferences.Editor editor = this.g.l().edit().putStringSet(this.i, this.h);
            k.f((Object)editor, "kotprefModel.kotprefPref\u2026().putStringSet(key, set)");
            h.a((SharedPreferences.Editor)editor, (boolean)i.this.f);
            return bl;
        }

        public boolean isEmpty() {
            return this.h.isEmpty();
        }

        public Iterator<String> iterator() {
            if (this.g.i()) {
                e.a a2 = this.g.h();
                k.e((Object)a2);
                a2.b(this.i, this);
                Set<String> set = this.h();
                k.e(set);
                return new a((Iterator<String>)set.iterator(), true);
            }
            return new a((Iterator<String>)this.h.iterator(), false);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final void j() {
            c.c.a.k.i$a a2 = this;
            synchronized (a2) {
                Set<String> set = this.h();
                if (set != null) {
                    this.h.clear();
                    this.h.addAll(set);
                    this.f = null;
                }
                return;
            }
        }

        @SuppressLint(value={"CommitPrefEdits"})
        public boolean removeAll(Collection<? extends Object> collection) {
            k.g(collection, "elements");
            if (this.g.i()) {
                Set<String> set = this.h();
                k.e(set);
                boolean bl = set.removeAll(collection);
                e.a a2 = this.g.h();
                k.e((Object)a2);
                a2.b(this.i, this);
                return bl;
            }
            boolean bl = this.h.removeAll(collection);
            SharedPreferences.Editor editor = this.g.l().edit().putStringSet(this.i, this.h);
            k.f((Object)editor, "kotprefModel.kotprefPref\u2026().putStringSet(key, set)");
            h.a((SharedPreferences.Editor)editor, (boolean)i.this.f);
            return bl;
        }

        @SuppressLint(value={"CommitPrefEdits"})
        public boolean retainAll(Collection<? extends Object> collection) {
            k.g(collection, "elements");
            if (this.g.i()) {
                Set<String> set = this.h();
                k.e(set);
                boolean bl = set.retainAll(collection);
                e.a a2 = this.g.h();
                k.e((Object)a2);
                a2.b(this.i, this);
                return bl;
            }
            boolean bl = this.h.retainAll(collection);
            SharedPreferences.Editor editor = this.g.l().edit().putStringSet(this.i, this.h);
            k.f((Object)editor, "kotprefModel.kotprefPref\u2026().putStringSet(key, set)");
            h.a((SharedPreferences.Editor)editor, (boolean)i.this.f);
            return bl;
        }

        public Object[] toArray() {
            return f.a(this);
        }

        public <T> T[] toArray(T[] arrT) {
            return f.b(this, arrT);
        }

        private final class a
        implements Iterator<String> {
            private final Iterator<String> f;
            private final boolean g;

            public a(Iterator<String> iterator, boolean bl) {
                k.g(iterator, "baseIterator");
                this.f = iterator;
                this.g = bl;
            }

            public String b() {
                Object object = this.f.next();
                k.f(object, "next(...)");
                return (String)object;
            }

            public boolean hasNext() {
                return this.f.hasNext();
            }

            @SuppressLint(value={"CommitPrefEdits"})
            public void remove() {
                this.f.remove();
                if (!this.g) {
                    SharedPreferences.Editor editor = a.this.e().l().edit().putStringSet(a.this.d(), a.this.f());
                    k.f((Object)editor, "kotprefModel.kotprefPref\u2026().putStringSet(key, set)");
                    h.a((SharedPreferences.Editor)editor, (boolean)i.this.f);
                }
            }
        }

    }

}

