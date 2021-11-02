/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.NotNull
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedFieldFactory
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedFieldNameStrategy
 *  com.esotericsoftware.kryo.serializers.FieldSerializerAnnotationsUtil
 *  com.esotericsoftware.kryo.serializers.FieldSerializerConfig
 *  com.esotericsoftware.kryo.serializers.FieldSerializerGenericsUtil
 *  com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil
 *  com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil$Factory
 *  com.esotericsoftware.kryo.serializers.Generics
 *  com.esotericsoftware.kryo.serializers.GenericsResolver
 *  com.esotericsoftware.kryo.util.IntArray
 *  com.esotericsoftware.kryo.util.ObjectMap
 *  com.esotericsoftware.minlog.Log
 *  com.esotericsoftware.reflectasm.FieldAccess
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.HashSet
 *  java.util.List
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.NotNull;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.AsmCachedFieldFactory;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializerAnnotationsUtil;
import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import com.esotericsoftware.kryo.serializers.FieldSerializerGenericsUtil;
import com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil;
import com.esotericsoftware.kryo.serializers.Generics;
import com.esotericsoftware.kryo.serializers.GenericsResolver;
import com.esotericsoftware.kryo.serializers.ObjectCachedFieldFactory;
import com.esotericsoftware.kryo.serializers.ObjectField;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.FieldAccess;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class FieldSerializer<T>
extends Serializer<T>
implements Comparator<CachedField> {
    static CachedFieldFactory asmFieldFactory;
    static CachedFieldFactory objectFieldFactory;
    static Method sortFieldsByOffsetMethod;
    static boolean unsafeAvailable;
    static CachedFieldFactory unsafeFieldFactory;
    static Class<?> unsafeUtilClass;
    Object access;
    private FieldSerializerAnnotationsUtil annotationsUtil;
    final Class componentType;
    protected final FieldSerializerConfig config;
    private CachedField[] fields = new CachedField[0];
    private Class[] generics;
    private Generics genericsScope;
    private FieldSerializerGenericsUtil genericsUtil;
    private boolean hasObjectFields = false;
    final Kryo kryo;
    protected HashSet<CachedField> removedFields = new HashSet();
    private CachedField[] transientFields = new CachedField[0];
    final Class type;
    final TypeVariable[] typeParameters;
    private FieldSerializerUnsafeUtil unsafeUtil;
    private boolean useMemRegions = false;
    private boolean varIntsEnabled = true;

    /*
     * Exception decompiling
     */
    static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl38 : RETURN : trying to set 1 previously set to 0
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

    public FieldSerializer(Kryo kryo, Class class_) {
        this(kryo, class_, null);
    }

    public FieldSerializer(Kryo kryo, Class class_, Class[] arrclass) {
        this(kryo, class_, arrclass, kryo.getFieldSerializerConfig().clone());
    }

    protected FieldSerializer(Kryo kryo, Class class_, Class[] arrclass, FieldSerializerConfig fieldSerializerConfig) {
        if (Log.TRACE) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Optimize ints: ");
            stringBuilder.append(this.varIntsEnabled);
            Log.trace((String)"kryo", (String)stringBuilder.toString());
        }
        this.config = fieldSerializerConfig;
        this.kryo = kryo;
        this.type = class_;
        this.generics = arrclass;
        TypeVariable[] arrtypeVariable = class_.getTypeParameters();
        this.typeParameters = arrtypeVariable;
        this.componentType = arrtypeVariable != null && arrtypeVariable.length != 0 ? null : class_.getComponentType();
        this.genericsUtil = new FieldSerializerGenericsUtil(this);
        this.unsafeUtil = FieldSerializerUnsafeUtil.Factory.getInstance((FieldSerializer)this);
        this.annotationsUtil = new FieldSerializerAnnotationsUtil(this);
        this.rebuildCachedFields();
    }

    /*
     * Exception decompiling
     */
    private List<Field> buildValidFields(boolean var1, List<Field> var2, ObjectMap var3, IntArray var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    private List<Field> buildValidFieldsFromCachedFields(CachedField[] arrcachedField, IntArray intArray) {
        ArrayList arrayList = new ArrayList(arrcachedField.length);
        for (CachedField cachedField : arrcachedField) {
            arrayList.add((Object)cachedField.field);
            int n2 = cachedField.accessIndex > -1 ? 1 : 0;
            intArray.add(n2);
        }
        return arrayList;
    }

    private void createCachedFields(IntArray intArray, List<Field> list, List<CachedField> list2, int n2) {
        if (!this.config.isUseAsm() && this.useMemRegions) {
            this.unsafeUtil.createUnsafeCacheFieldsAndRegions(list, list2, n2, intArray);
            return;
        }
        int n3 = list.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            Field field = (Field)list.get(i2);
            int n4 = -1;
            if (this.access != null && intArray.get(n2 + i2) == 1) {
                n4 = ((FieldAccess)this.access).getIndex(field.getName());
            }
            list2.add((Object)this.newCachedField(field, list2.size(), n4));
        }
    }

    private CachedFieldFactory getAsmFieldFactory() {
        if (asmFieldFactory == null) {
            asmFieldFactory = new AsmCachedFieldFactory();
        }
        return asmFieldFactory;
    }

    private CachedFieldFactory getObjectFieldFactory() {
        if (objectFieldFactory == null) {
            objectFieldFactory = new ObjectCachedFieldFactory();
        }
        return objectFieldFactory;
    }

    private CachedFieldFactory getUnsafeFieldFactory() {
        if (unsafeFieldFactory == null) {
            try {
                unsafeFieldFactory = this.getClass().getClassLoader().loadClass("com.esotericsoftware.kryo.serializers.UnsafeCachedFieldFactory").newInstance();
            }
            catch (Exception exception) {
                throw new RuntimeException("Cannot create UnsafeFieldFactory", (Throwable)exception);
            }
        }
        return unsafeFieldFactory;
    }

    public int compare(CachedField cachedField, CachedField cachedField2) {
        return this.getCachedFieldName(cachedField).compareTo(this.getCachedFieldName(cachedField2));
    }

    public T copy(Kryo kryo, T t2) {
        T t3 = this.createCopy(kryo, t2);
        kryo.reference(t3);
        boolean bl = this.config.isCopyTransient();
        int n2 = 0;
        if (bl) {
            int n3 = this.transientFields.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                this.transientFields[i2].copy(t2, t3);
            }
        }
        int n4 = this.fields.length;
        while (n2 < n4) {
            this.fields[n2].copy(t2, t3);
            ++n2;
        }
        return t3;
    }

    protected T create(Kryo kryo, Input input, Class<T> class_) {
        return (T)kryo.newInstance(class_);
    }

    protected T createCopy(Kryo kryo, T t2) {
        return (T)kryo.newInstance(t2.getClass());
    }

    protected String getCachedFieldName(CachedField cachedField) {
        return this.config.getCachedFieldNameStrategy().getName(cachedField);
    }

    public boolean getCopyTransient() {
        return this.config.isCopyTransient();
    }

    public CachedField getField(String string) {
        for (CachedField cachedField : this.fields) {
            if (!this.getCachedFieldName(cachedField).equals((Object)string)) continue;
            return cachedField;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field \"");
        stringBuilder.append(string);
        stringBuilder.append("\" not found on class: ");
        stringBuilder.append(this.type.getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public CachedField[] getFields() {
        return this.fields;
    }

    public Class[] getGenerics() {
        return this.generics;
    }

    final Generics getGenericsScope() {
        return this.genericsScope;
    }

    public Kryo getKryo() {
        return this.kryo;
    }

    public boolean getSerializeTransient() {
        return this.config.isSerializeTransient();
    }

    public CachedField[] getTransientFields() {
        return this.transientFields;
    }

    public Class getType() {
        return this.type;
    }

    public boolean getUseAsmEnabled() {
        return this.config.isUseAsm();
    }

    public boolean getUseMemRegions() {
        return this.useMemRegions;
    }

    protected void initializeCachedFields() {
    }

    CachedField newCachedField(Field field, int n2, int n3) {
        CachedField cachedField;
        int n4 = 1;
        Class[] arrclass = new Class[n4];
        arrclass[0] = field.getType();
        Type type = this.config.isOptimizedGenerics() ? field.getGenericType() : null;
        Type type2 = type;
        if (this.config.isOptimizedGenerics() && type2 != arrclass[0]) {
            cachedField = this.genericsUtil.newCachedFieldOfGenericType(field, n3, arrclass, type2);
        } else {
            if (Log.TRACE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Field ");
                stringBuilder.append(field.getName());
                stringBuilder.append(": ");
                stringBuilder.append((Object)arrclass[0]);
                Log.trace((String)"kryo", (String)stringBuilder.toString());
            }
            cachedField = this.newMatchingCachedField(field, n3, arrclass[0], type2, null);
        }
        if (cachedField instanceof ObjectField) {
            this.hasObjectFields = n4;
        }
        cachedField.field = field;
        cachedField.varIntsEnabled = this.varIntsEnabled;
        if (!this.config.isUseAsm()) {
            cachedField.offset = this.unsafeUtil.getObjectFieldOffset(field);
        }
        cachedField.access = (FieldAccess)this.access;
        cachedField.accessIndex = n3;
        if (!this.config.isFieldsCanBeNull() || arrclass[0].isPrimitive() || field.isAnnotationPresent(NotNull.class)) {
            n4 = 0;
        }
        cachedField.canBeNull = n4;
        if (this.kryo.isFinal(arrclass[0]) || this.config.isFixedFieldTypes()) {
            cachedField.valueClass = arrclass[0];
        }
        return cachedField;
    }

    CachedField newMatchingCachedField(Field field, int n2, Class class_, Type type, Class[] arrclass) {
        if (n2 != -1) {
            return this.getAsmFieldFactory().createCachedField(class_, field, this);
        }
        if (!this.config.isUseAsm()) {
            return this.getUnsafeFieldFactory().createCachedField(class_, field, this);
        }
        CachedField cachedField = this.getObjectFieldFactory().createCachedField(class_, field, this);
        if (this.config.isOptimizedGenerics()) {
            if (arrclass != null) {
                ((ObjectField)cachedField).generics = arrclass;
                return cachedField;
            }
            if (type != null) {
                Object[] arrobject = FieldSerializerGenericsUtil.getGenerics((Type)type, (Kryo)this.kryo);
                ((ObjectField)cachedField).generics = arrobject;
                if (Log.TRACE) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Field generics: ");
                    stringBuilder.append(Arrays.toString((Object[])arrobject));
                    Log.trace((String)"kryo", (String)stringBuilder.toString());
                }
            }
        }
        return cachedField;
    }

    public T read(Kryo kryo, Input input, Class<T> class_) {
        T t2;
        block12 : {
            int n2;
            if (this.config.isOptimizedGenerics()) {
                if (this.typeParameters != null && this.generics != null) {
                    this.rebuildCachedFields();
                }
                if (this.genericsScope != null) {
                    kryo.getGenericsResolver().pushScope(class_, this.genericsScope);
                }
            }
            t2 = this.create(kryo, input, class_);
            kryo.reference(t2);
            CachedField[] arrcachedField = this.fields;
            int n3 = arrcachedField.length;
            int n4 = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                arrcachedField[i2].read(input, t2);
            }
            try {
                if (!this.config.isSerializeTransient()) break block12;
                n2 = this.transientFields.length;
            }
            catch (Throwable throwable) {
                if (this.config.isOptimizedGenerics() && this.genericsScope != null && kryo.getGenericsResolver() != null) {
                    kryo.getGenericsResolver().popScope();
                }
                throw throwable;
            }
            while (n4 < n2) {
                this.transientFields[n4].read(input, t2);
                ++n4;
            }
        }
        if (this.config.isOptimizedGenerics() && this.genericsScope != null && kryo.getGenericsResolver() != null) {
            kryo.getGenericsResolver().popScope();
        }
        return t2;
    }

    protected void rebuildCachedFields() {
        this.rebuildCachedFields(false);
    }

    /*
     * Exception decompiling
     */
    protected void rebuildCachedFields(boolean var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl191 : NEW : trying to set 1 previously set to 0
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

    public void removeField(CachedField cachedField) {
        CachedField[] arrcachedField;
        CachedField[] arrcachedField2;
        for (int i2 = 0; i2 < (arrcachedField = this.fields).length; ++i2) {
            CachedField cachedField2 = arrcachedField[i2];
            if (cachedField2 != cachedField) continue;
            int n2 = -1 + arrcachedField.length;
            CachedField[] arrcachedField3 = new CachedField[n2];
            System.arraycopy((Object)arrcachedField, (int)0, (Object)arrcachedField3, (int)0, (int)i2);
            System.arraycopy((Object)this.fields, (int)(i2 + 1), (Object)arrcachedField3, (int)i2, (int)(n2 - i2));
            this.fields = arrcachedField3;
            this.removedFields.add((Object)cachedField2);
            return;
        }
        for (int i3 = 0; i3 < (arrcachedField2 = this.transientFields).length; ++i3) {
            CachedField cachedField3 = arrcachedField2[i3];
            if (cachedField3 != cachedField) continue;
            int n3 = -1 + arrcachedField2.length;
            CachedField[] arrcachedField4 = new CachedField[n3];
            System.arraycopy((Object)arrcachedField2, (int)0, (Object)arrcachedField4, (int)0, (int)i3);
            System.arraycopy((Object)this.transientFields, (int)(i3 + 1), (Object)arrcachedField4, (int)i3, (int)(n3 - i3));
            this.transientFields = arrcachedField4;
            this.removedFields.add((Object)cachedField3);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field \"");
        stringBuilder.append((Object)cachedField);
        stringBuilder.append("\" not found on class: ");
        stringBuilder.append(this.type.getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void removeField(String string) {
        CachedField[] arrcachedField;
        CachedField[] arrcachedField2;
        for (int i2 = 0; i2 < (arrcachedField = this.fields).length; ++i2) {
            CachedField cachedField = arrcachedField[i2];
            if (!this.getCachedFieldName(cachedField).equals((Object)string)) continue;
            CachedField[] arrcachedField3 = this.fields;
            int n2 = -1 + arrcachedField3.length;
            CachedField[] arrcachedField4 = new CachedField[n2];
            System.arraycopy((Object)arrcachedField3, (int)0, (Object)arrcachedField4, (int)0, (int)i2);
            System.arraycopy((Object)this.fields, (int)(i2 + 1), (Object)arrcachedField4, (int)i2, (int)(n2 - i2));
            this.fields = arrcachedField4;
            this.removedFields.add((Object)cachedField);
            return;
        }
        for (int i3 = 0; i3 < (arrcachedField2 = this.transientFields).length; ++i3) {
            CachedField cachedField = arrcachedField2[i3];
            if (!this.getCachedFieldName(cachedField).equals((Object)string)) continue;
            CachedField[] arrcachedField5 = this.transientFields;
            int n3 = -1 + arrcachedField5.length;
            CachedField[] arrcachedField6 = new CachedField[n3];
            System.arraycopy((Object)arrcachedField5, (int)0, (Object)arrcachedField6, (int)0, (int)i3);
            System.arraycopy((Object)this.transientFields, (int)(i3 + 1), (Object)arrcachedField6, (int)i3, (int)(n3 - i3));
            this.transientFields = arrcachedField6;
            this.removedFields.add((Object)cachedField);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field \"");
        stringBuilder.append(string);
        stringBuilder.append("\" not found on class: ");
        stringBuilder.append(this.type.getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setCopyTransient(boolean bl) {
        this.config.setCopyTransient(bl);
    }

    public void setFieldsAsAccessible(boolean bl) {
        this.config.setFieldsAsAccessible(bl);
        this.rebuildCachedFields();
    }

    public void setFieldsCanBeNull(boolean bl) {
        this.config.setFieldsCanBeNull(bl);
        this.rebuildCachedFields();
    }

    public void setFixedFieldTypes(boolean bl) {
        this.config.setFixedFieldTypes(bl);
        this.rebuildCachedFields();
    }

    public void setGenerics(Kryo kryo, Class[] arrclass) {
        if (!this.config.isOptimizedGenerics()) {
            return;
        }
        this.generics = arrclass;
        TypeVariable[] arrtypeVariable = this.typeParameters;
        if (arrtypeVariable != null && arrtypeVariable.length > 0) {
            this.rebuildCachedFields(true);
        }
    }

    public void setIgnoreSyntheticFields(boolean bl) {
        this.config.setIgnoreSyntheticFields(bl);
        this.rebuildCachedFields();
    }

    public void setOptimizedGenerics(boolean bl) {
        this.config.setOptimizedGenerics(bl);
        this.rebuildCachedFields();
    }

    public void setSerializeTransient(boolean bl) {
        this.config.setSerializeTransient(bl);
    }

    public void setUseAsm(boolean bl) {
        this.config.setUseAsm(bl);
        this.rebuildCachedFields();
    }

    public void write(Kryo kryo, Output output, T t2) {
        if (Log.TRACE) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FieldSerializer.write fields of class: ");
            stringBuilder.append(t2.getClass().getName());
            Log.trace((String)"kryo", (String)stringBuilder.toString());
        }
        if (this.config.isOptimizedGenerics()) {
            if (this.typeParameters != null && this.generics != null) {
                this.rebuildCachedFields();
            }
            if (this.genericsScope != null) {
                kryo.getGenericsResolver().pushScope(this.type, this.genericsScope);
            }
        }
        CachedField[] arrcachedField = this.fields;
        int n2 = arrcachedField.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrcachedField[i2].write(output, t2);
        }
        if (this.config.isSerializeTransient()) {
            int n4 = this.transientFields.length;
            while (n3 < n4) {
                this.transientFields[n3].write(output, t2);
                ++n3;
            }
        }
        if (this.config.isOptimizedGenerics() && this.genericsScope != null) {
            kryo.getGenericsResolver().popScope();
        }
    }
}

