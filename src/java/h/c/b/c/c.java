/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.DataOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.NotSerializableException
 *  java.io.ObjectInputStream
 *  java.io.ObjectStreamClass
 *  java.io.OutputStream
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 */
package h.c.b.c;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;

public class c<T>
implements h.c.b.a<T> {
    private ObjectInputStream a;

    public c(Class<T> class_) {
        if (Serializable.class.isAssignableFrom(class_)) {
            try {
                this.a = new ObjectInputStream(new InputStream(class_){
                    private static final int[] f = new int[]{1, 2, 2};
                    private static byte[] g;
                    private static byte[] h;
                    private int i = 0;
                    private byte[] j = g;
                    private int k = 0;
                    private byte[][] l;
                    private final byte[] m;

                    static {
                        a.b();
                    }
                    {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        DataOutputStream dataOutputStream = new DataOutputStream((OutputStream)byteArrayOutputStream);
                        try {
                            dataOutputStream.writeByte(115);
                            dataOutputStream.writeByte(114);
                            dataOutputStream.writeUTF(class_.getName());
                            dataOutputStream.writeLong(ObjectStreamClass.lookup(class_).getSerialVersionUID());
                            dataOutputStream.writeByte(2);
                            dataOutputStream.writeShort(0);
                            dataOutputStream.writeByte(120);
                            dataOutputStream.writeByte(112);
                        }
                        catch (IOException iOException) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("IOException: ");
                            stringBuilder.append(iOException.getMessage());
                            throw new Error(stringBuilder.toString());
                        }
                        byte[] arrby = byteArrayOutputStream.toByteArray();
                        this.m = arrby;
                        byte[][] arrarrby = new byte[][]{g, arrby, h};
                        this.l = arrarrby;
                    }

                    private void a() {
                        int n2;
                        this.i = 0;
                        this.k = n2 = f[this.k];
                        this.j = this.l[n2];
                    }

                    private static void b() {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DataOutputStream dataOutputStream = new DataOutputStream((OutputStream)byteArrayOutputStream);
                            dataOutputStream.writeShort(-21267);
                            dataOutputStream.writeShort(5);
                            g = byteArrayOutputStream.toByteArray();
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            DataOutputStream dataOutputStream2 = new DataOutputStream((OutputStream)byteArrayOutputStream2);
                            dataOutputStream2.writeByte(115);
                            dataOutputStream2.writeByte(113);
                            dataOutputStream2.writeInt(8257536);
                            h = byteArrayOutputStream2.toByteArray();
                            return;
                        }
                        catch (IOException iOException) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("IOException: ");
                            stringBuilder.append(iOException.getMessage());
                            throw new Error(stringBuilder.toString());
                        }
                    }

                    public int available() throws IOException {
                        return Integer.MAX_VALUE;
                    }

                    public int read() throws IOException {
                        int n2;
                        byte[] arrby = this.j;
                        int n3 = this.i;
                        this.i = n2 = n3 + 1;
                        byte by = arrby[n3];
                        if (n2 >= arrby.length) {
                            this.a();
                        }
                        return by;
                    }

                    public int read(byte[] arrby, int n2, int n3) throws IOException {
                        int n4;
                        int n5 = this.j.length - this.i;
                        for (n4 = n3; n5 <= n4; n4 -= n5) {
                            System.arraycopy((Object)this.j, (int)this.i, (Object)arrby, (int)n2, (int)n5);
                            n2 += n5;
                            this.a();
                            n5 = this.j.length - this.i;
                        }
                        if (n4 > 0) {
                            System.arraycopy((Object)this.j, (int)this.i, (Object)arrby, (int)n2, (int)n4);
                            this.i = n4 + this.i;
                        }
                        return n3;
                    }
                });
                return;
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("IOException: ");
                stringBuilder.append(iOException.getMessage());
                throw new Error(stringBuilder.toString());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(class_);
        stringBuilder.append(" not serializable");
        throw new h.c.a((Throwable)new NotSerializableException(stringBuilder.toString()));
    }

    @Override
    public T newInstance() {
        Object object;
        try {
            object = this.a.readObject();
        }
        catch (Exception exception) {
            throw new h.c.a(exception);
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ClassNotFoundException: ");
            stringBuilder.append(classNotFoundException.getMessage());
            throw new Error(stringBuilder.toString());
        }
        return (T)object;
    }

}

