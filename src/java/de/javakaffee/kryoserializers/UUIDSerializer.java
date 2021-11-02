/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.UUID
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.UUID;

public class UUIDSerializer
extends Serializer<UUID> {
    public UUIDSerializer() {
        this.setImmutable(true);
    }

    public UUID read(Kryo kryo, Input input, Class<UUID> class_) {
        return new UUID(input.readLong(), input.readLong());
    }

    public void write(Kryo kryo, Output output, UUID uUID) {
        output.writeLong(uUID.getMostSignificantBits());
        output.writeLong(uUID.getLeastSignificantBits());
    }
}

