/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.reflect.Array
 *  java.util.EventListener
 */
package org.jaudiotagger.utils.tree;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.EventListener;

public class EventListenerList
implements Serializable {
    private static final Object[] NULL_ARRAY = new Object[0];
    protected transient Object[] listenerList = NULL_ARRAY;

    private int getListenerCount(Object[] arrobject, Class class_) {
        int n2 = 0;
        for (int i2 = 0; i2 < arrobject.length; i2 += 2) {
            if (class_ != (Class)arrobject[i2]) continue;
            ++n2;
        }
        return n2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object object;
        this.listenerList = NULL_ARRAY;
        objectInputStream.defaultReadObject();
        while ((object = objectInputStream.readObject()) != null) {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            EventListener eventListener = (EventListener)objectInputStream.readObject();
            this.add((Class<T>)Class.forName((String)((String)object), (boolean)true, (ClassLoader)classLoader), (T)eventListener);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object[] arrobject = this.listenerList;
        objectOutputStream.defaultWriteObject();
        for (int i2 = 0; i2 < arrobject.length; i2 += 2) {
            Class class_ = (Class)arrobject[i2];
            EventListener eventListener = (EventListener)arrobject[i2 + 1];
            if (eventListener == null || !(eventListener instanceof Serializable)) continue;
            objectOutputStream.writeObject((Object)class_.getName());
            objectOutputStream.writeObject((Object)eventListener);
        }
        objectOutputStream.writeObject(null);
    }

    public <T extends EventListener> void add(Class<T> class_, T t2) {
        EventListenerList eventListenerList = this;
        synchronized (eventListenerList) {
            if (t2 == null) {
                return;
            }
            if (class_.isInstance(t2)) {
                Object[] arrobject = this.listenerList;
                if (arrobject == NULL_ARRAY) {
                    this.listenerList = new Object[]{class_, t2};
                } else {
                    int n2 = arrobject.length;
                    Object[] arrobject2 = new Object[n2 + 2];
                    System.arraycopy((Object)arrobject, (int)0, (Object)arrobject2, (int)0, (int)n2);
                    arrobject2[n2] = class_;
                    arrobject2[n2 + 1] = t2;
                    this.listenerList = arrobject2;
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Listener ");
            stringBuilder.append(t2);
            stringBuilder.append(" is not of type ");
            stringBuilder.append(class_);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public int getListenerCount() {
        return this.listenerList.length / 2;
    }

    public int getListenerCount(Class<?> class_) {
        return this.getListenerCount(this.listenerList, class_);
    }

    public Object[] getListenerList() {
        return this.listenerList;
    }

    public <T extends EventListener> T[] getListeners(Class<T> class_) {
        Object[] arrobject = this.listenerList;
        EventListener[] arreventListener = (EventListener[])Array.newInstance(class_, (int)this.getListenerCount(arrobject, class_));
        int n2 = 0;
        for (int i2 = -2 + arrobject.length; i2 >= 0; i2 -= 2) {
            if (arrobject[i2] != class_) continue;
            int n3 = n2 + 1;
            arreventListener[n2] = (EventListener)arrobject[i2 + 1];
            n2 = n3;
        }
        return arreventListener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T extends EventListener> void remove(Class<T> class_, T t2) {
        EventListenerList eventListenerList = this;
        synchronized (eventListenerList) {
            int n2;
            block8 : {
                if (t2 == null) {
                    return;
                }
                if (!class_.isInstance(t2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Listener ");
                    stringBuilder.append(t2);
                    stringBuilder.append(" is not of type ");
                    stringBuilder.append(class_);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                n2 = -2 + this.listenerList.length;
                while (n2 >= 0) {
                    Object[] arrobject = this.listenerList;
                    if (arrobject[n2] != class_ || !arrobject[n2 + 1].equals(t2)) {
                        n2 -= 2;
                        continue;
                    }
                    break block8;
                }
                return;
            }
            if (n2 == -1) return;
            Object[] arrobject = this.listenerList;
            int n3 = -2 + arrobject.length;
            Object[] arrobject2 = new Object[n3];
            System.arraycopy((Object)arrobject, (int)0, (Object)arrobject2, (int)0, (int)n2);
            if (n2 < n3) {
                System.arraycopy((Object)this.listenerList, (int)(n2 + 2), (Object)arrobject2, (int)n2, (int)(n3 - n2));
            }
            if (n3 == 0) {
                arrobject2 = NULL_ARRAY;
            }
            this.listenerList = arrobject2;
            return;
        }
    }

    public String toString() {
        Object[] arrobject = this.listenerList;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EventListenerList: ");
        stringBuilder.append(arrobject.length / 2);
        stringBuilder.append(" listeners: ");
        String string2 = stringBuilder.toString();
        for (int i2 = 0; i2 <= -2 + arrobject.length; i2 += 2) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(" type ");
            stringBuilder2.append(((Class)arrobject[i2]).getName());
            String string3 = stringBuilder2.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string3);
            stringBuilder3.append(" listener ");
            stringBuilder3.append(arrobject[i2 + 1]);
            string2 = stringBuilder3.toString();
        }
        return string2;
    }
}

