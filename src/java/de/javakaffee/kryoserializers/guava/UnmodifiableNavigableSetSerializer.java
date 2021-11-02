/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.google.common.annotations.VisibleForTesting
 *  com.google.common.collect.Sets
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.NavigableSet
 *  java.util.TreeSet
 */
package de.javakaffee.kryoserializers.guava;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Sets;
import java.lang.reflect.Field;
import java.util.NavigableSet;
import java.util.TreeSet;

public class UnmodifiableNavigableSetSerializer
extends Serializer<NavigableSet<?>> {
    Field delegate;

    public UnmodifiableNavigableSetSerializer() {
        super(false);
        try {
            Field field;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Sets.class.getCanonicalName());
            stringBuilder.append("$UnmodifiableNavigableSet");
            this.delegate = field = Class.forName((String)stringBuilder.toString()).getDeclaredField("delegate");
            field.setAccessible(true);
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new RuntimeException("Issues reflectively writing UnmodifiableNavigableSet", (Throwable)noSuchFieldException);
        }
        catch (SecurityException securityException) {
            throw new RuntimeException("Issues reflectively writing UnmodifiableNavigableSet", (Throwable)securityException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("Issues reflectively writing UnmodifiableNavigableSet", (Throwable)classNotFoundException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new RuntimeException("Issues reflectively writing UnmodifiableNavigableSet", (Throwable)illegalArgumentException);
        }
    }

    public static void registerSerializers(Kryo kryo) {
        UnmodifiableNavigableSetSerializer unmodifiableNavigableSetSerializer = new UnmodifiableNavigableSetSerializer();
        kryo.register(Sets.unmodifiableNavigableSet((NavigableSet)new TreeSet()).getClass(), (Serializer)unmodifiableNavigableSetSerializer);
    }

    public NavigableSet<?> copy(Kryo kryo, NavigableSet<?> navigableSet) {
        return Sets.unmodifiableNavigableSet((NavigableSet)((NavigableSet)kryo.copy(this.getDelegateFromUnmodifiableNavigableSet(navigableSet))));
    }

    @VisibleForTesting
    protected Object getDelegateFromUnmodifiableNavigableSet(NavigableSet<?> navigableSet) {
        try {
            Object object = this.delegate.get(navigableSet);
            return object;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("Issues reflectively writing UnmodifiableNavigableSet", (Throwable)illegalAccessException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new RuntimeException("Issues reflectively writing UnmodifiableNavigableSet", (Throwable)illegalArgumentException);
        }
    }

    public NavigableSet<?> read(Kryo kryo, Input input, Class<NavigableSet<?>> class_) {
        return Sets.unmodifiableNavigableSet((NavigableSet)((NavigableSet)kryo.readClassAndObject(input)));
    }

    public void write(Kryo kryo, Output output, NavigableSet<?> navigableSet) {
        kryo.writeClassAndObject(output, this.getDelegateFromUnmodifiableNavigableSet(navigableSet));
    }
}

