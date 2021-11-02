/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.serializers.MapSerializer
 *  java.lang.Object
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CopyForIterateMapSerializer
extends MapSerializer {
    public void write(Kryo kryo, Output output, Map map) {
        Object object = map instanceof LinkedHashMap ? new LinkedHashMap(map) : new HashMap(map);
        super.write(kryo, output, (Map)object);
    }
}

