/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.esotericsoftware.kryo.Serializer
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.List
 */
package io.paperdb;

import android.content.Context;
import com.esotericsoftware.kryo.Serializer;
import io.paperdb.DbStoragePlainFile;
import io.paperdb.PaperDbException;
import java.util.HashMap;
import java.util.List;

public class Book {
    private final DbStoragePlainFile mStorage;

    protected Book(Context context, String string2, HashMap<Class, Serializer> hashMap) {
        this.mStorage = new DbStoragePlainFile(context.getApplicationContext(), string2, hashMap);
    }

    protected Book(String string2, String string3, HashMap<Class, Serializer> hashMap) {
        this.mStorage = new DbStoragePlainFile(string2, string3, hashMap);
    }

    public boolean contains(String string2) {
        return this.mStorage.exists(string2);
    }

    public void delete(String string2) {
        this.mStorage.deleteIfExists(string2);
    }

    public void destroy() {
        this.mStorage.destroy();
    }

    public boolean exist(String string2) {
        return this.mStorage.exists(string2);
    }

    public List<String> getAllKeys() {
        return this.mStorage.getAllKeys();
    }

    public String getPath() {
        return this.mStorage.getRootFolderPath();
    }

    public String getPath(String string2) {
        return this.mStorage.getOriginalFilePath(string2);
    }

    public long lastModified(String string2) {
        return this.mStorage.lastModified(string2);
    }

    public <T> T read(String string2) {
        return this.read(string2, null);
    }

    public <T> T read(String string2, T t2) {
        Object e2 = this.mStorage.select(string2);
        if (e2 == null) {
            return t2;
        }
        return (T)e2;
    }

    public void setLogLevel(int n2) {
        this.mStorage.setLogLevel(n2);
    }

    public <T> Book write(String string2, T t2) {
        if (t2 != null) {
            this.mStorage.insert(string2, t2);
            return this;
        }
        throw new PaperDbException("Paper doesn't support writing null root values");
    }
}

