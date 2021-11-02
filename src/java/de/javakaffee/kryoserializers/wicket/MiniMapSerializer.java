/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.minlog.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.apache.wicket.util.collections.MiniMap
 */
package de.javakaffee.kryoserializers.wicket;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import org.apache.wicket.util.collections.MiniMap;

public class MiniMapSerializer
extends Serializer<MiniMap<Object, Object>> {
    private static final Field KEYS_FIELD;

    static {
        try {
            Field field;
            KEYS_FIELD = field = MiniMap.class.getDeclaredField("keys");
            field.setAccessible(true);
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException("The MiniMap seems to have changed, could not access expected field.", (Throwable)exception);
        }
    }

    private int getMaxEntries(MiniMap<?, ?> miniMap) {
        try {
            int n2 = ((Object[])KEYS_FIELD.get(miniMap)).length;
            return n2;
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not access keys field.", (Throwable)exception);
        }
    }

    public MiniMap<Object, Object> read(Kryo kryo, Input input, Class<MiniMap<Object, Object>> class_) {
        MiniMap miniMap = new MiniMap(input.readInt(true));
        int n2 = input.readInt(true);
        for (int i2 = 0; i2 < n2; ++i2) {
            miniMap.put(kryo.readClassAndObject(input), kryo.readClassAndObject(input));
        }
        return miniMap;
    }

    public void write(Kryo kryo, Output output, MiniMap<Object, Object> miniMap) {
        output.writeInt(this.getMaxEntries(miniMap), true);
        output.writeInt(miniMap.size(), true);
        for (Map.Entry entry : miniMap.entrySet()) {
            kryo.writeClassAndObject(output, entry.getKey());
            kryo.writeClassAndObject(output, entry.getValue());
        }
        if (Log.TRACE) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Wrote map: ");
            stringBuilder.append(miniMap);
            Log.trace((String)"kryo", (String)stringBuilder.toString());
        }
    }
}

