/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  com.esotericsoftware.kryo.Serializer
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 */
package io.paperdb;

import android.annotation.SuppressLint;
import android.content.Context;
import com.esotericsoftware.kryo.Serializer;
import io.paperdb.Book;
import io.paperdb.PaperDbException;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Paper {
    static final String DEFAULT_DB_NAME = "io.paperdb";
    static final String TAG = "paperdb";
    private static final ConcurrentHashMap<String, Book> mBookMap = new ConcurrentHashMap();
    @SuppressLint(value={"StaticFieldLeak"})
    private static Context mContext;
    private static final HashMap<Class, Serializer> mCustomSerializers;

    static {
        mCustomSerializers = new HashMap();
    }

    public static <T> void addSerializer(Class<T> class_, Serializer<T> serializer) {
        HashMap<Class, Serializer> hashMap = mCustomSerializers;
        if (!hashMap.containsKey(class_)) {
            hashMap.put(class_, serializer);
        }
    }

    public static Book book() {
        return Paper.getBook(null, DEFAULT_DB_NAME);
    }

    public static Book book(String string2) {
        if (!string2.equals((Object)DEFAULT_DB_NAME)) {
            return Paper.getBook(null, string2);
        }
        throw new PaperDbException("io.paperdb name is reserved for default library name");
    }

    public static Book bookOn(String string2) {
        return Paper.bookOn(string2, DEFAULT_DB_NAME);
    }

    public static Book bookOn(String string2, String string3) {
        return Paper.getBook(Paper.removeLastFileSeparatorIfExists(string2), string3);
    }

    public static void clear(Context context) {
        Paper.init(context);
        Paper.book().destroy();
    }

    public static void delete(String string2) {
        Paper.book().delete(string2);
    }

    public static boolean exist(String string2) {
        return Paper.book().contains(string2);
    }

    public static <T> T get(String string2) {
        return Paper.book().read(string2);
    }

    public static <T> T get(String string2, T t2) {
        return Paper.book().read(string2, t2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Book getBook(String string2, String string3) {
        ConcurrentHashMap<String, Book> concurrentHashMap;
        if (mContext == null) {
            throw new PaperDbException("Paper.init is not called");
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = string2 == null ? "" : string2;
        stringBuilder.append(string4);
        stringBuilder.append(string3);
        String string5 = stringBuilder.toString();
        ConcurrentHashMap<String, Book> concurrentHashMap2 = concurrentHashMap = mBookMap;
        synchronized (concurrentHashMap2) {
            Book book = (Book)concurrentHashMap.get((Object)string5);
            if (book == null) {
                book = string2 == null ? new Book(mContext, string3, mCustomSerializers) : new Book(string2, string3, mCustomSerializers);
                concurrentHashMap.put((Object)string5, (Object)book);
            }
            return book;
        }
    }

    public static void init(Context context) {
        mContext = context.getApplicationContext();
    }

    public static <T> Book put(String string2, T t2) {
        return Paper.book().write(string2, t2);
    }

    private static String removeLastFileSeparatorIfExists(String string2) {
        if (string2.endsWith(File.separator)) {
            string2 = string2.substring(0, -1 + string2.length());
        }
        return string2;
    }

    public static void setLogLevel(int n2) {
        Iterator iterator = mBookMap.entrySet().iterator();
        while (iterator.hasNext()) {
            ((Book)((Map.Entry)iterator.next()).getValue()).setLogLevel(n2);
        }
    }
}

