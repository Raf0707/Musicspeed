/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Enumeration
 */
package org.jaudiotagger.utils.tree;

import java.util.Enumeration;

public interface TreeNode {
    public Enumeration children();

    public boolean getAllowsChildren();

    public TreeNode getChildAt(int var1);

    public int getChildCount();

    public int getIndex(TreeNode var1);

    public TreeNode getParent();

    public boolean isLeaf();
}

