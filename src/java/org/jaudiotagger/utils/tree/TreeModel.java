/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.jaudiotagger.utils.tree;

import org.jaudiotagger.utils.tree.TreeModelListener;
import org.jaudiotagger.utils.tree.TreePath;

public interface TreeModel {
    public void addTreeModelListener(TreeModelListener var1);

    public Object getChild(Object var1, int var2);

    public int getChildCount(Object var1);

    public int getIndexOfChild(Object var1, Object var2);

    public Object getRoot();

    public boolean isLeaf(Object var1);

    public void removeTreeModelListener(TreeModelListener var1);

    public void valueForPathChanged(TreePath var1, Object var2);
}

