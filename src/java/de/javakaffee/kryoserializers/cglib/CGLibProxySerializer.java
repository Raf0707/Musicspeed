/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Registration
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  net.sf.cglib.proxy.Callback
 *  net.sf.cglib.proxy.Enhancer
 *  net.sf.cglib.proxy.Factory
 */
package de.javakaffee.kryoserializers.cglib;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;

public class CGLibProxySerializer
extends Serializer<Object> {
    public static final String DEFAULT_NAMING_MARKER = "$$EnhancerByCGLIB$$";

    public static boolean canSerialize(Class<?> class_) {
        return Enhancer.isEnhanced(class_) && class_.getName().indexOf(DEFAULT_NAMING_MARKER) > 0;
    }

    private Object createProxy(Class<?> class_, Class<?>[] arrclass, Callback[] arrcallback) {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(arrclass);
        enhancer.setSuperclass(class_);
        enhancer.setCallbacks(arrcallback);
        return enhancer.create();
    }

    public Object read(Kryo kryo, Input input, Class<Object> class_) {
        return this.createProxy(kryo.readClass(input).getType(), (Class[])kryo.readObject(input, Class[].class), (Callback[])kryo.readObject(input, Callback[].class));
    }

    public void write(Kryo kryo, Output output, Object object) {
        kryo.writeClass(output, object.getClass().getSuperclass());
        kryo.writeObject(output, (Object)object.getClass().getInterfaces());
        kryo.writeObject(output, (Object)((Factory)object).getCallbacks());
    }

}

