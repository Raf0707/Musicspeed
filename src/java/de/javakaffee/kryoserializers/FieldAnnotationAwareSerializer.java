/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.Serializer
 *  com.esotericsoftware.kryo.factories.SerializerFactory
 *  com.esotericsoftware.kryo.serializers.FieldSerializer
 *  com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
 *  com.esotericsoftware.minlog.Log
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 */
package de.javakaffee.kryoserializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.factories.SerializerFactory;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.minlog.Log;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FieldAnnotationAwareSerializer<T>
extends FieldSerializer<T> {
    private final boolean disregarding;
    private final Set<Class<? extends Annotation>> marked;

    public FieldAnnotationAwareSerializer(Kryo kryo, Class<?> class_, Collection<Class<? extends Annotation>> collection, boolean bl) {
        super(kryo, class_);
        this.disregarding = bl;
        this.marked = new HashSet(collection);
        this.rebuildCachedFields();
    }

    private boolean isMarked(Field field) {
        Annotation[] arrannotation = field.getAnnotations();
        int n2 = arrannotation.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Class class_ = arrannotation[i2].annotationType();
            if (!this.marked.contains((Object)class_)) continue;
            return true;
        }
        return false;
    }

    private boolean isRemove(Field field) {
        return true ^ this.isMarked(field) ^ this.disregarding;
    }

    private void removeFields() {
        for (FieldSerializer.CachedField cachedField : this.getFields()) {
            Field field = cachedField.getField();
            if (!this.isRemove(field)) continue;
            if (Log.TRACE) {
                Object[] arrobject = new Object[2];
                String string = this.disregarding ? "without" : "with";
                arrobject[0] = string;
                arrobject[1] = cachedField;
                Log.trace((String)"kryo", (String)String.format((String)"Ignoring field %s tag: %s", (Object[])arrobject));
            }
            super.removeField(field.getName());
        }
    }

    public boolean addAnnotation(Class<? extends Annotation> class_) {
        if (this.disregarding && this.marked.add(class_)) {
            this.initializeCachedFields();
            return true;
        }
        return false;
    }

    protected void rebuildCachedFields() {
        if (this.marked == null) {
            return;
        }
        super.rebuildCachedFields();
        this.removeFields();
    }

    public boolean removeAnnotation(Class<? extends Annotation> class_) {
        if (!this.disregarding && this.marked.remove(class_)) {
            this.initializeCachedFields();
            return true;
        }
        return false;
    }

}

