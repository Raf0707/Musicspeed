/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.serializers.JavaSerializer$ObjectInputStreamWithKryoClassLoader
 *  com.esotericsoftware.kryo.util.ObjectMap
 *  java.io.InputStream
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.esotericsoftware.kryo.util.ObjectMap;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/*
 * Exception performing whole class analysis.
 */
public class JavaSerializer
extends Serializer {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object read(Kryo kryo, Input input, Class class_) {
        ObjectInputStream objectInputStream;
        ObjectMap objectMap;
        try {
            objectMap = kryo.getGraphContext();
            objectInputStream = (ObjectInputStream)objectMap.get((Object)this);
            if (objectInputStream != null) return objectInputStream.readObject();
        }
        catch (Exception exception) {
            throw new KryoException("Error during Java deserialization.", (Throwable)exception);
        }
        objectInputStream = new /* Unavailable Anonymous Inner Class!! */;
        objectMap.put((Object)this, (Object)objectInputStream);
        return objectInputStream.readObject();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(Kryo kryo, Output output, Object object) {
        try {
            ObjectMap objectMap = kryo.getGraphContext();
            ObjectOutputStream objectOutputStream = (ObjectOutputStream)objectMap.get((Object)this);
            if (objectOutputStream == null) {
                objectOutputStream = new ObjectOutputStream((OutputStream)output);
                objectMap.put((Object)this, (Object)objectOutputStream);
            }
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            return;
        }
        catch (Exception exception) {
            throw new KryoException("Error during Java serialization.", (Throwable)exception);
        }
    }
}

