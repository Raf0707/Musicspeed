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
 *  java.lang.String
 *  java.net.URI
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.net.URI;

public class URISerializer
extends Serializer<URI> {
    public URISerializer() {
        this.setImmutable(true);
    }

    public URI read(Kryo kryo, Input input, Class<URI> class_) {
        return URI.create((String)input.readString());
    }

    public void write(Kryo kryo, Output output, URI uRI) {
        output.writeString(uRI.toString());
    }
}

