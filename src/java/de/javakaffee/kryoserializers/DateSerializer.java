/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.util.Date
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Constructor;
import java.util.Date;

public class DateSerializer
extends Serializer<Date> {
    private final Constructor<? extends Date> _constructor;

    public DateSerializer(Class<? extends Date> class_) {
        try {
            Class[] arrclass = new Class[]{Long.TYPE};
            this._constructor = class_.getConstructor(arrclass);
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
    }

    public Date copy(Kryo kryo, Date date) {
        return (Date)date.clone();
    }

    public Date read(Kryo kryo, Input input, Class<Date> class_) {
        try {
            Constructor<? extends Date> constructor = this._constructor;
            Object[] arrobject = new Object[]{input.readLong(true)};
            Date date = (Date)constructor.newInstance(arrobject);
            return date;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
    }

    public void write(Kryo kryo, Output output, Date date) {
        output.writeLong(date.getTime(), true);
    }
}

