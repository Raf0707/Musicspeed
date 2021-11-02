/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
 *  com.esotericsoftware.kryo.util.ObjectMap
 *  com.esotericsoftware.minlog.Log
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.InputChunked;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.minlog.Log;
import java.io.InputStream;
import java.io.OutputStream;

public class CompatibleFieldSerializer<T>
extends FieldSerializer<T> {
    private static final int THRESHOLD_BINARY_SEARCH = 32;

    public CompatibleFieldSerializer(Kryo kryo, Class class_) {
        super(kryo, class_);
    }

    @Override
    public T read(Kryo kryo, Input input, Class<T> class_) {
        T t2 = this.create(kryo, input, class_);
        kryo.reference(t2);
        ObjectMap objectMap = kryo.getGraphContext();
        FieldSerializer.CachedField[] arrcachedField = (FieldSerializer.CachedField[])objectMap.get((Object)this);
        if (arrcachedField == null) {
            int n2 = input.readVarInt(true);
            if (Log.TRACE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Read ");
                stringBuilder.append(n2);
                stringBuilder.append(" field names.");
                Log.trace((String)"kryo", (String)stringBuilder.toString());
            }
            String[] arrstring = new String[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                arrstring[i2] = input.readString();
            }
            FieldSerializer.CachedField[] arrcachedField2 = new FieldSerializer.CachedField[n2];
            FieldSerializer.CachedField[] arrcachedField3 = this.getFields();
            if (n2 < 32) {
                block1 : for (int i3 = 0; i3 < n2; ++i3) {
                    String string = arrstring[i3];
                    int n3 = arrcachedField3.length;
                    for (int i4 = 0; i4 < n3; ++i4) {
                        if (!this.getCachedFieldName(arrcachedField3[i4]).equals((Object)string)) continue;
                        arrcachedField2[i3] = arrcachedField3[i4];
                        continue block1;
                    }
                    if (!Log.TRACE) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Ignore obsolete field: ");
                    stringBuilder.append(string);
                    Log.trace((String)"kryo", (String)stringBuilder.toString());
                }
            } else {
                int n4 = arrcachedField3.length > n2 ? arrcachedField3.length : n2;
                block3 : for (int i5 = 0; i5 < n2; ++i5) {
                    String string = arrstring[i5];
                    int n5 = n4 - 1;
                    int n6 = 0;
                    while (n6 <= n5) {
                        int n7 = n6 + n5 >>> 1;
                        int n8 = string.compareTo(this.getCachedFieldName(arrcachedField3[n7]));
                        if (n8 < 0) {
                            n5 = n7 - 1;
                            continue;
                        }
                        if (n8 > 0) {
                            n6 = n7 + 1;
                            continue;
                        }
                        arrcachedField2[i5] = arrcachedField3[n7];
                        continue block3;
                    }
                    if (!Log.TRACE) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Ignore obsolete field: ");
                    stringBuilder.append(string);
                    Log.trace((String)"kryo", (String)stringBuilder.toString());
                }
            }
            objectMap.put((Object)this, (Object)arrcachedField2);
            arrcachedField = arrcachedField2;
        }
        InputChunked inputChunked = new InputChunked((InputStream)input, 1024);
        boolean bl = this.getGenerics() != null;
        for (FieldSerializer.CachedField cachedField : arrcachedField) {
            if (cachedField != null && bl) {
                cachedField = this.getField(this.getCachedFieldName(cachedField));
            }
            if (cachedField == null) {
                if (Log.TRACE) {
                    Log.trace((String)"kryo", (String)"Skip obsolete field.");
                }
                inputChunked.nextChunks();
                continue;
            }
            cachedField.read((Input)inputChunked, t2);
            inputChunked.nextChunks();
        }
        return t2;
    }

    @Override
    public void write(Kryo kryo, Output output, T t2) {
        FieldSerializer.CachedField[] arrcachedField = this.getFields();
        ObjectMap objectMap = kryo.getGraphContext();
        boolean bl = objectMap.containsKey((Object)this);
        int n2 = 0;
        if (!bl) {
            objectMap.put((Object)this, null);
            if (Log.TRACE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Write ");
                stringBuilder.append(arrcachedField.length);
                stringBuilder.append(" field names.");
                Log.trace((String)"kryo", (String)stringBuilder.toString());
            }
            output.writeVarInt(arrcachedField.length, true);
            int n3 = arrcachedField.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                output.writeString(this.getCachedFieldName(arrcachedField[i2]));
            }
        }
        OutputChunked outputChunked = new OutputChunked((OutputStream)output, 1024);
        int n4 = arrcachedField.length;
        while (n2 < n4) {
            arrcachedField[n2].write((Output)outputChunked, t2);
            outputChunked.endChunks();
            ++n2;
        }
    }
}

