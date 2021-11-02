/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.Serializable
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.util.Objects
 *  java.util.Vector
 */
package org.jaudiotagger.utils.tree;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public class TreePath
implements Serializable {
    private transient Object lastPathComponent;
    private TreePath parentPath;

    protected TreePath() {
    }

    public TreePath(Object object) {
        if (object != null) {
            this.lastPathComponent = object;
            this.parentPath = null;
            return;
        }
        throw new IllegalArgumentException("path in TreePath must be non null.");
    }

    protected TreePath(TreePath treePath, Object object) {
        if (object != null) {
            this.parentPath = treePath;
            this.lastPathComponent = object;
            return;
        }
        throw new IllegalArgumentException("path in TreePath must be non null.");
    }

    public TreePath(Object[] arrobject) {
        if (arrobject != null && arrobject.length != 0) {
            this.lastPathComponent = arrobject[arrobject.length - 1];
            if (arrobject.length > 1) {
                this.parentPath = new TreePath(arrobject, arrobject.length - 1);
            }
            return;
        }
        throw new IllegalArgumentException("path in TreePath must be non null and not empty.");
    }

    protected TreePath(Object[] arrobject, int n2) {
        int n3 = n2 - 1;
        this.lastPathComponent = arrobject[n3];
        if (n2 > 1) {
            this.parentPath = new TreePath(arrobject, n3);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Vector vector = (Vector)objectInputStream.readObject();
        if (vector.size() > 0 && vector.elementAt(0).equals((Object)"lastPathComponent")) {
            this.lastPathComponent = vector.elementAt(1);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Vector vector = new Vector();
        Object object = this.lastPathComponent;
        if (object != null && object instanceof Serializable) {
            vector.addElement((Object)"lastPathComponent");
            vector.addElement(this.lastPathComponent);
        }
        objectOutputStream.writeObject((Object)vector);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof TreePath) {
            TreePath treePath = (TreePath)object;
            if (this.getPathCount() != treePath.getPathCount()) {
                return false;
            }
            TreePath treePath2 = this;
            while (treePath2 != null) {
                if (!treePath2.lastPathComponent.equals(treePath.lastPathComponent)) {
                    return false;
                }
                treePath = treePath.parentPath;
                treePath2 = treePath2.parentPath;
            }
            return true;
        }
        return false;
    }

    public Object getLastPathComponent() {
        return this.lastPathComponent;
    }

    public TreePath getParentPath() {
        return this.parentPath;
    }

    public Object[] getPath() {
        int n2 = this.getPathCount();
        int n3 = n2 - 1;
        Object[] arrobject = new Object[n2];
        TreePath treePath = this;
        while (treePath != null) {
            int n4 = n3 - 1;
            arrobject[n3] = treePath.lastPathComponent;
            treePath = treePath.parentPath;
            n3 = n4;
        }
        return arrobject;
    }

    public Object getPathComponent(int n2) {
        int n3 = this.getPathCount();
        if (n2 >= 0 && n2 < n3) {
            TreePath treePath = this;
            for (int i2 = n3 - 1; i2 != n2; --i2) {
                treePath = treePath.parentPath;
            }
            return treePath.lastPathComponent;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index ");
        stringBuilder.append(n2);
        stringBuilder.append(" is out of the specified range");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public int getPathCount() {
        int n2 = 0;
        TreePath treePath = this;
        while (treePath != null) {
            ++n2;
            treePath = treePath.parentPath;
        }
        return n2;
    }

    public int hashCode() {
        return this.lastPathComponent.hashCode();
    }

    public boolean isDescendant(TreePath treePath) {
        if (treePath == this) {
            return true;
        }
        if (treePath != null) {
            int n2 = this.getPathCount();
            int n3 = treePath.getPathCount();
            if (n3 < n2) {
                return false;
            }
            do {
                int n4 = n3 - 1;
                if (n3 <= n2) break;
                treePath = treePath.getParentPath();
                n3 = n4;
            } while (true);
            return this.equals(treePath);
        }
        return false;
    }

    public TreePath pathByAddingChild(Object object) {
        Objects.requireNonNull((Object)object, (String)"Null child not allowed");
        return new TreePath(this, object);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        int n2 = this.getPathCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.getPathComponent(i2));
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

