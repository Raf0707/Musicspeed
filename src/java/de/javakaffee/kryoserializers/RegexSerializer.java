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
 *  java.util.regex.Pattern
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.regex.Pattern;

public class RegexSerializer
extends Serializer<Pattern> {
    public RegexSerializer() {
        this.setImmutable(true);
    }

    public Pattern read(Kryo kryo, Input input, Class<Pattern> class_) {
        return Pattern.compile((String)input.readString(), (int)input.readInt(true));
    }

    public void write(Kryo kryo, Output output, Pattern pattern) {
        output.writeString(pattern.pattern());
        output.writeInt(pattern.flags(), true);
    }
}

