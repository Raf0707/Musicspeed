/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  de.javakaffee.kryoserializers.SubListSerializers$ArrayListSubListSerializer
 *  de.javakaffee.kryoserializers.SubListSerializers$JavaUtilSubListSerializer
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import de.javakaffee.kryoserializers.SubListSerializers;
import java.util.List;

/*
 * Exception performing whole class analysis.
 * Exception performing whole class analysis ignored.
 */
public class SubListSerializers {
    private static final Object FAKE_REFERENCE;

    static {
        FAKE_REFERENCE = new Object();
    }

    public SubListSerializers() {
    }

    static /* synthetic */ Object access$000() {
        return FAKE_REFERENCE;
    }

    public static Kryo addDefaultSerializers(Kryo kryo) {
        ArrayListSubListSerializer.addDefaultSerializer((Kryo)kryo);
        JavaUtilSubListSerializer.addDefaultSerializer((Kryo)kryo);
        return kryo;
    }

    public static Serializer<List<?>> createFor(Class class_) {
        if (ArrayListSubListSerializer.canSerialize((Class)class_)) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        if (JavaUtilSubListSerializer.canSerialize((Class)class_)) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        return null;
    }

    static Class<?> getClass(String string2) {
        try {
            Class class_ = Class.forName((String)string2);
            return class_;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
    }

    static Class<?> getClassOrNull(String string2) {
        try {
            Class class_ = Class.forName((String)string2);
            return class_;
        }
        catch (Exception exception) {
            return null;
        }
    }
}

