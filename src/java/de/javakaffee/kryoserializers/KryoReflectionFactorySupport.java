/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.serializers.FieldSerializer
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 *  sun.reflect.ReflectionFactory
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sun.reflect.ReflectionFactory;

public class KryoReflectionFactorySupport
extends Kryo {
    private static final Object[] INITARGS;
    private static final ReflectionFactory REFLECTION_FACTORY;
    private static final Map<Class<?>, Constructor<?>> _constructors;

    static {
        REFLECTION_FACTORY = ReflectionFactory.getReflectionFactory();
        INITARGS = new Object[0];
        _constructors = new ConcurrentHashMap();
    }

    private static Constructor<?> getNoArgsConstructor(Class<?> class_) {
        for (Constructor constructor : class_.getConstructors()) {
            if (constructor.getParameterTypes().length != 0) continue;
            constructor.setAccessible(true);
            return constructor;
        }
        return null;
    }

    private static <T> Constructor<?> newConstructorForSerialization(Class<T> class_) {
        try {
            Constructor constructor = REFLECTION_FACTORY.newConstructorForSerialization(class_, Object.class.getDeclaredConstructor(new Class[0]));
            constructor.setAccessible(true);
            return constructor;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
    }

    private static Object newInstanceFrom(Constructor<?> constructor) {
        try {
            Object object = constructor.newInstance(INITARGS);
            return object;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
    }

    public static <T> T newInstanceFromReflectionFactory(Class<T> class_) {
        Map<Class<?>, Constructor<?>> map = _constructors;
        Constructor<?> constructor = (Constructor<?>)map.get(class_);
        if (constructor == null) {
            constructor = KryoReflectionFactorySupport.newConstructorForSerialization(class_);
            map.put(class_, constructor);
        }
        return (T)KryoReflectionFactorySupport.newInstanceFrom(constructor);
    }

    public Serializer<?> getDefaultSerializer(Class class_) {
        Serializer serializer = super.getDefaultSerializer(class_);
        if (serializer instanceof FieldSerializer) {
            ((FieldSerializer)serializer).setIgnoreSyntheticFields(false);
        }
        return serializer;
    }

    public <T> T newInstance(Class<T> class_) {
        if (class_ != null) {
            Map<Class<?>, Constructor<?>> map = _constructors;
            Constructor<?> constructor = (Constructor<?>)map.get(class_);
            if (constructor == null) {
                constructor = KryoReflectionFactorySupport.getNoArgsConstructor(class_);
                if (constructor == null) {
                    constructor = KryoReflectionFactorySupport.newConstructorForSerialization(class_);
                }
                map.put(class_, constructor);
            }
            return (T)KryoReflectionFactorySupport.newInstanceFrom(constructor);
        }
        throw new IllegalArgumentException("type cannot be null.");
    }
}

