/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.util.ObjectMap
 *  java.io.Externalizable
 *  java.io.IOException
 *  java.io.ObjectInput
 *  java.io.ObjectOutput
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.KryoObjectInput;
import com.esotericsoftware.kryo.io.KryoObjectOutput;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.esotericsoftware.kryo.util.ObjectMap;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableSerializer
extends Serializer {
    private ObjectMap<Class, JavaSerializer> javaSerializerByType;
    private KryoObjectInput objectInput = null;
    private KryoObjectOutput objectOutput = null;

    private JavaSerializer getCachedSerializer(Class class_) {
        ObjectMap<Class, JavaSerializer> objectMap = this.javaSerializerByType;
        if (objectMap == null) {
            this.javaSerializerByType = new ObjectMap();
            return null;
        }
        return (JavaSerializer)((Object)objectMap.get((Object)class_));
    }

    private JavaSerializer getJavaSerializerIfRequired(Class class_) {
        JavaSerializer javaSerializer = this.getCachedSerializer(class_);
        if (javaSerializer == null && this.isJavaSerializerRequired(class_)) {
            javaSerializer = new JavaSerializer();
        }
        return javaSerializer;
    }

    private ObjectInput getObjectInput(Kryo kryo, Input input) {
        KryoObjectInput kryoObjectInput = this.objectInput;
        if (kryoObjectInput == null) {
            this.objectInput = new KryoObjectInput(kryo, input);
        } else {
            kryoObjectInput.setInput(input);
        }
        return this.objectInput;
    }

    private ObjectOutput getObjectOutput(Kryo kryo, Output output) {
        KryoObjectOutput kryoObjectOutput = this.objectOutput;
        if (kryoObjectOutput == null) {
            this.objectOutput = new KryoObjectOutput(kryo, output);
        } else {
            kryoObjectOutput.setOutput(output);
        }
        return this.objectOutput;
    }

    /*
     * Exception decompiling
     */
    private static boolean hasInheritableReplaceMethod(Class var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl1 : ALOAD_0 : trying to set 1 previously set to 0
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

    private boolean isJavaSerializerRequired(Class class_) {
        return ExternalizableSerializer.hasInheritableReplaceMethod(class_, "writeReplace") || ExternalizableSerializer.hasInheritableReplaceMethod(class_, "readResolve");
        {
        }
    }

    private Object readExternal(Kryo kryo, Input input, Class class_) {
        try {
            Externalizable externalizable = (Externalizable)kryo.newInstance(class_);
            externalizable.readExternal(this.getObjectInput(kryo, input));
            return externalizable;
        }
        catch (IOException iOException) {
            throw new KryoException((Throwable)iOException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new KryoException((Throwable)classNotFoundException);
        }
        catch (ClassCastException classCastException) {
            throw new KryoException((Throwable)classCastException);
        }
    }

    private void writeExternal(Kryo kryo, Output output, Object object) {
        try {
            ((Externalizable)object).writeExternal(this.getObjectOutput(kryo, output));
            return;
        }
        catch (IOException iOException) {
            throw new KryoException((Throwable)iOException);
        }
        catch (ClassCastException classCastException) {
            throw new KryoException((Throwable)classCastException);
        }
    }

    public Object read(Kryo kryo, Input input, Class class_) {
        JavaSerializer javaSerializer = this.getJavaSerializerIfRequired(class_);
        if (javaSerializer == null) {
            return this.readExternal(kryo, input, class_);
        }
        return javaSerializer.read(kryo, input, class_);
    }

    public void write(Kryo kryo, Output output, Object object) {
        JavaSerializer javaSerializer = this.getJavaSerializerIfRequired(object.getClass());
        if (javaSerializer == null) {
            this.writeExternal(kryo, output, object);
            return;
        }
        javaSerializer.write(kryo, output, object);
    }
}

