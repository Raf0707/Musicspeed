/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  c.d.a.a.m.f.j
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package c.d.a.a.m;

import android.content.SharedPreferences;
import c.d.a.a.m.f.j;
import java.util.Map;
import java.util.Set;

public final class e<T>
implements j<T> {
    private final SharedPreferences a;

    public e(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public T a(String string) {
        for (Map.Entry entry : this.a.getAll().entrySet()) {
            if (!((String)entry.getKey()).equals((Object)string)) continue;
            return (T)entry.getValue();
        }
        return null;
    }

    public void b(String string, T t2) {
        block7 : {
            SharedPreferences.Editor editor;
            block3 : {
                block6 : {
                    block5 : {
                        block4 : {
                            block2 : {
                                editor = this.a.edit();
                                if (!t2.getClass().equals(String.class)) break block2;
                                editor.putString(string, (String)t2);
                                break block3;
                            }
                            if (!t2.getClass().equals(Boolean.class)) break block4;
                            editor.putBoolean(string, ((Boolean)t2).booleanValue());
                            break block3;
                        }
                        if (!t2.getClass().equals(Long.class)) break block5;
                        editor.putLong(string, ((Long)t2).longValue());
                        break block3;
                    }
                    if (!t2.getClass().equals(Integer.class)) break block6;
                    editor.putInt(string, ((Integer)t2).intValue());
                    break block3;
                }
                if (!t2.getClass().equals(Float.class)) break block7;
                editor.putLong(string, ((Long)t2).longValue());
            }
            editor.apply();
            return;
        }
        throw new IllegalArgumentException("Event value must be one of String, Boolean, Long, Integer or Float");
    }
}

