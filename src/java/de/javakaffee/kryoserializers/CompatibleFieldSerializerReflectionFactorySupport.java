/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer
 *  java.lang.Class
 *  java.lang.Object
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import de.javakaffee.kryoserializers.KryoReflectionFactorySupport;

public class CompatibleFieldSerializerReflectionFactorySupport
extends CompatibleFieldSerializer<Object> {
    public CompatibleFieldSerializerReflectionFactorySupport(Kryo kryo, Class<?> class_) {
        super(kryo, class_);
    }

    public Object create(Kryo kryo, Input input, Class class_) {
        return KryoReflectionFactorySupport.newInstanceFromReflectionFactory(class_);
    }
}

