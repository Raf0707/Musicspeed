/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.jaudiotagger.utils.tree;

import org.jaudiotagger.utils.tree.TreeNode;

public interface MutableTreeNode
extends TreeNode {
    public void insert(MutableTreeNode var1, int var2);

    public void remove(int var1);

    public void remove(MutableTreeNode var1);

    public void removeFromParent();

    public void setParent(MutableTreeNode var1);

    public void setUserObject(Object var1);
}

