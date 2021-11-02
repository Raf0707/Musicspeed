/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.serializers.BeanSerializer$CachedProperty
 *  com.esotericsoftware.minlog.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.BeanSerializer;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.InvocationTargetException;

public class BeanSerializer<T>
extends Serializer<T> {
    static final Object[] noArgs = new Object[0];
    Object access;
    private CachedProperty[] properties;

    /*
     * Exception decompiling
     */
    public BeanSerializer(Kryo var1, Class var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl149.1 : RETURN : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public T copy(Kryo kryo, T t2) {
        Object object = kryo.newInstance(t2.getClass());
        for (CachedProperty cachedProperty : this.properties) {
            try {
                cachedProperty.set(object, cachedProperty.get(t2));
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error copying bean property: ");
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(object.getClass().getName());
                stringBuilder.append(")");
                throw new KryoException(stringBuilder.toString(), (Throwable)exception);
            }
            catch (RuntimeException runtimeException) {
                KryoException kryoException = new KryoException((Throwable)runtimeException);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(object.getClass().getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
            catch (KryoException kryoException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(object.getClass().getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
        }
        return (T)object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public T read(Kryo kryo, Input input, Class<T> class_) {
        Object object = kryo.newInstance(class_);
        kryo.reference(object);
        int n2 = this.properties.length;
        int n3 = 0;
        while (n3 < n2) {
            CachedProperty cachedProperty = this.properties[n3];
            try {
                Serializer serializer;
                if (Log.TRACE) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Read property: ");
                    stringBuilder.append((Object)cachedProperty);
                    stringBuilder.append(" (");
                    stringBuilder.append((Object)object.getClass());
                    stringBuilder.append(")");
                    Log.trace((String)"kryo", (String)stringBuilder.toString());
                }
                Object object2 = (serializer = cachedProperty.serializer) != null ? kryo.readObjectOrNull(input, cachedProperty.setMethodType, serializer) : kryo.readClassAndObject(input);
                cachedProperty.set(object, object2);
                ++n3;
            }
            catch (RuntimeException runtimeException) {
                KryoException kryoException = new KryoException((Throwable)runtimeException);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(object.getClass().getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
            catch (KryoException kryoException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(object.getClass().getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
            catch (InvocationTargetException invocationTargetException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error invoking setter method: ");
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(object.getClass().getName());
                stringBuilder.append(")");
                throw new KryoException(stringBuilder.toString(), (Throwable)invocationTargetException);
            }
            catch (IllegalAccessException illegalAccessException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error accessing setter method: ");
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(object.getClass().getName());
                stringBuilder.append(")");
                throw new KryoException(stringBuilder.toString(), (Throwable)illegalAccessException);
            }
        }
        return (T)object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(Kryo kryo, Output output, T t2) {
        Class class_ = t2.getClass();
        int n2 = this.properties.length;
        int n3 = 0;
        while (n3 < n2) {
            CachedProperty cachedProperty = this.properties[n3];
            try {
                if (Log.TRACE) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Write property: ");
                    stringBuilder.append((Object)cachedProperty);
                    stringBuilder.append(" (");
                    stringBuilder.append(class_.getName());
                    stringBuilder.append(")");
                    Log.trace((String)"kryo", (String)stringBuilder.toString());
                }
                Object object = cachedProperty.get(t2);
                Serializer serializer = cachedProperty.serializer;
                if (serializer != null) {
                    kryo.writeObjectOrNull(output, object, serializer);
                } else {
                    kryo.writeClassAndObject(output, object);
                }
                ++n3;
            }
            catch (RuntimeException runtimeException) {
                KryoException kryoException = new KryoException((Throwable)runtimeException);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(class_.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
            catch (KryoException kryoException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(class_.getName());
                stringBuilder.append(")");
                kryoException.addTrace(stringBuilder.toString());
                throw kryoException;
            }
            catch (InvocationTargetException invocationTargetException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error invoking getter method: ");
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(class_.getName());
                stringBuilder.append(")");
                throw new KryoException(stringBuilder.toString(), (Throwable)invocationTargetException);
            }
            catch (IllegalAccessException illegalAccessException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error accessing getter method: ");
                stringBuilder.append((Object)cachedProperty);
                stringBuilder.append(" (");
                stringBuilder.append(class_.getName());
                stringBuilder.append(")");
                throw new KryoException(stringBuilder.toString(), (Throwable)illegalAccessException);
            }
        }
        return;
    }
}

