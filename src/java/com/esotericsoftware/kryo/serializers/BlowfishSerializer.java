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
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.Key
 *  javax.crypto.Cipher
 *  javax.crypto.CipherInputStream
 *  javax.crypto.CipherOutputStream
 *  javax.crypto.spec.SecretKeySpec
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class BlowfishSerializer
extends Serializer {
    private static SecretKeySpec keySpec;
    private final Serializer serializer;

    public BlowfishSerializer(Serializer serializer, byte[] arrby) {
        this.serializer = serializer;
        keySpec = new SecretKeySpec(arrby, "Blowfish");
    }

    private static Cipher getCipher(int n2) {
        try {
            Cipher cipher = Cipher.getInstance((String)"Blowfish");
            cipher.init(n2, (Key)keySpec);
            return cipher;
        }
        catch (Exception exception) {
            throw new KryoException((Throwable)exception);
        }
    }

    public Object copy(Kryo kryo, Object object) {
        return this.serializer.copy(kryo, object);
    }

    public Object read(Kryo kryo, Input input, Class class_) {
        CipherInputStream cipherInputStream = new CipherInputStream((InputStream)input, BlowfishSerializer.getCipher(2));
        return this.serializer.read(kryo, new Input((InputStream)cipherInputStream, 256), class_);
    }

    public void write(Kryo kryo, Output output, Object object) {
        CipherOutputStream cipherOutputStream = new CipherOutputStream((OutputStream)output, BlowfishSerializer.getCipher(1));
        Output output2 = new Output((OutputStream)cipherOutputStream, 256){

            public void close() throws KryoException {
            }
        };
        this.serializer.write(kryo, output2, object);
        output2.flush();
        try {
            cipherOutputStream.close();
            return;
        }
        catch (IOException iOException) {
            throw new KryoException((Throwable)iOException);
        }
    }

}

