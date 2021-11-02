/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.EventObject
 */
package org.jaudiotagger.utils.tree;

import java.util.EventObject;
import org.jaudiotagger.utils.tree.TreePath;

public class TreeModelEvent
extends EventObject {
    protected int[] childIndices;
    protected Object[] children;
    protected TreePath path;

    public TreeModelEvent(Object object, TreePath treePath) {
        super(object);
        this.path = treePath;
        this.childIndices = new int[0];
    }

    public TreeModelEvent(Object object, TreePath treePath, int[] arrn, Object[] arrobject) {
        super(object);
        this.path = treePath;
        this.childIndices = arrn;
        this.children = arrobject;
    }

    public TreeModelEvent(Object object, Object[] arrobject) {
        this(object, new TreePath(arrobject));
    }

    public TreeModelEvent(Object object, Object[] arrobject, int[] arrn, Object[] arrobject2) {
        this(object, new TreePath(arrobject), arrn, arrobject2);
    }

    public int[] getChildIndices() {
        int[] arrn = this.childIndices;
        if (arrn != null) {
            int n2 = arrn.length;
            int[] arrn2 = new int[n2];
            System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)n2);
            return arrn2;
        }
        return null;
    }

    public Object[] getChildren() {
        Object[] arrobject = this.children;
        if (arrobject != null) {
            int n2 = arrobject.length;
            Object[] arrobject2 = new Object[n2];
            System.arraycopy((Object)arrobject, (int)0, (Object)arrobject2, (int)0, (int)n2);
            return arrobject2;
        }
        return null;
    }

    public Object[] getPath() {
        TreePath treePath = this.path;
        if (treePath != null) {
            return treePath.getPath();
        }
        return null;
    }

    public TreePath getTreePath() {
        return this.path;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append(" ");
        stringBuilder.append(Integer.toString((int)this.hashCode()));
        stringBuffer.append(stringBuilder.toString());
        if (this.path != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" path ");
            stringBuilder2.append((Object)this.path);
            stringBuffer.append(stringBuilder2.toString());
        }
        int[] arrn = this.childIndices;
        int n2 = 0;
        if (arrn != null) {
            stringBuffer.append(" indices [ ");
            for (int i2 = 0; i2 < this.childIndices.length; ++i2) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(Integer.toString((int)this.childIndices[i2]));
                stringBuilder3.append(" ");
                stringBuffer.append(stringBuilder3.toString());
            }
            stringBuffer.append("]");
        }
        if (this.children != null) {
            stringBuffer.append(" children [ ");
            while (n2 < this.children.length) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(this.children[n2]);
                stringBuilder4.append(" ");
                stringBuffer.append(stringBuilder4.toString());
                ++n2;
            }
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }
}

