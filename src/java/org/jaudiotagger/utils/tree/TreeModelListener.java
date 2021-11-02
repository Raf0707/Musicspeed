/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.EventListener
 */
package org.jaudiotagger.utils.tree;

import java.util.EventListener;
import org.jaudiotagger.utils.tree.TreeModelEvent;

public interface TreeModelListener
extends EventListener {
    public void treeNodesChanged(TreeModelEvent var1);

    public void treeNodesInserted(TreeModelEvent var1);

    public void treeNodesRemoved(TreeModelEvent var1);

    public void treeStructureChanged(TreeModelEvent var1);
}

