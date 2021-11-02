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
 *  java.util.BitSet
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.BitSet;

public class BitSetSerializer
extends Serializer<BitSet> {
    public BitSet copy(Kryo kryo, BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        int n2 = bitSet.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            bitSet2.set(i2, bitSet.get(i2));
        }
        return bitSet2;
    }

    public BitSet read(Kryo kryo, Input input, Class<BitSet> class_) {
        int n2 = input.readInt(true);
        BitSet bitSet = new BitSet(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            bitSet.set(i2, input.readBoolean());
        }
        return bitSet;
    }

    public void write(Kryo kryo, Output output, BitSet bitSet) {
        int n2 = bitSet.length();
        output.writeInt(n2, true);
        for (int i2 = 0; i2 < n2; ++i2) {
            output.writeBoolean(bitSet.get(i2));
        }
    }
}

