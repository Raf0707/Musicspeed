/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.zip.Deflater
 *  java.util.zip.DeflaterOutputStream
 *  java.util.zip.Inflater
 *  java.util.zip.InflaterInputStream
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.InputChunked;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class DeflateSerializer
extends Serializer {
    private int compressionLevel = 4;
    private boolean noHeaders = true;
    private final Serializer serializer;

    public DeflateSerializer(Serializer serializer) {
        this.serializer = serializer;
    }

    public Object copy(Kryo kryo, Object object) {
        return this.serializer.copy(kryo, object);
    }

    public Object read(Kryo kryo, Input input, Class class_) {
        Inflater inflater = new Inflater(this.noHeaders);
        try {
            InflaterInputStream inflaterInputStream = new InflaterInputStream((InputStream)new InputChunked((InputStream)input, 256), inflater);
            Object object = this.serializer.read(kryo, new Input((InputStream)inflaterInputStream, 256), class_);
            return object;
        }
        finally {
            inflater.end();
        }
    }

    public void setCompressionLevel(int n2) {
        this.compressionLevel = n2;
    }

    public void setNoHeaders(boolean bl) {
        this.noHeaders = bl;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void write(Kryo kryo, Output output, Object object) {
        Throwable throwable2222;
        OutputChunked outputChunked = new OutputChunked((OutputStream)output, 256);
        Deflater deflater = new Deflater(this.compressionLevel, this.noHeaders);
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream((OutputStream)outputChunked, deflater);
        Output output2 = new Output((OutputStream)deflaterOutputStream, 256);
        this.serializer.write(kryo, output2, object);
        output2.flush();
        deflaterOutputStream.finish();
        deflater.end();
        outputChunked.endChunks();
        return;
        {
            catch (Throwable throwable2222) {
            }
            catch (IOException iOException) {}
            {
                throw new KryoException((Throwable)iOException);
            }
        }
        deflater.end();
        throw throwable2222;
    }
}

