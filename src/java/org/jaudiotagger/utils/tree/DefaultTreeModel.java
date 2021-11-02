/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EventListener
 *  java.util.Vector
 */
package org.jaudiotagger.utils.tree;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EventListener;
import java.util.Vector;
import org.jaudiotagger.utils.tree.EventListenerList;
import org.jaudiotagger.utils.tree.MutableTreeNode;
import org.jaudiotagger.utils.tree.TreeModel;
import org.jaudiotagger.utils.tree.TreeModelEvent;
import org.jaudiotagger.utils.tree.TreeModelListener;
import org.jaudiotagger.utils.tree.TreeNode;
import org.jaudiotagger.utils.tree.TreePath;

public class DefaultTreeModel
implements Serializable,
TreeModel {
    protected boolean asksAllowsChildren;
    protected EventListenerList listenerList = new EventListenerList();
    protected TreeNode root;

    public DefaultTreeModel(TreeNode treeNode) {
        this(treeNode, false);
    }

    public DefaultTreeModel(TreeNode treeNode, boolean bl) {
        this.root = treeNode;
        this.asksAllowsChildren = bl;
    }

    private void fireTreeStructureChanged(Object object, TreePath treePath) {
        Object[] arrobject = this.listenerList.getListenerList();
        TreeModelEvent treeModelEvent = null;
        for (int i2 = -2 + arrobject.length; i2 >= 0; i2 -= 2) {
            if (arrobject[i2] != TreeModelListener.class) continue;
            if (treeModelEvent == null) {
                treeModelEvent = new TreeModelEvent(object, treePath);
            }
            ((TreeModelListener)arrobject[i2 + 1]).treeStructureChanged(treeModelEvent);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Vector vector = (Vector)objectInputStream.readObject();
        if (vector.size() > 0 && vector.elementAt(0).equals((Object)"root")) {
            this.root = (TreeNode)vector.elementAt(1);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Vector vector = new Vector();
        objectOutputStream.defaultWriteObject();
        TreeNode treeNode = this.root;
        if (treeNode != null && treeNode instanceof Serializable) {
            vector.addElement((Object)"root");
            vector.addElement((Object)this.root);
        }
        objectOutputStream.writeObject((Object)vector);
    }

    @Override
    public void addTreeModelListener(TreeModelListener treeModelListener) {
        this.listenerList.add(TreeModelListener.class, treeModelListener);
    }

    public boolean asksAllowsChildren() {
        return this.asksAllowsChildren;
    }

    protected void fireTreeNodesChanged(Object object, Object[] arrobject, int[] arrn, Object[] arrobject2) {
        Object[] arrobject3 = this.listenerList.getListenerList();
        TreeModelEvent treeModelEvent = null;
        for (int i2 = -2 + arrobject3.length; i2 >= 0; i2 -= 2) {
            if (arrobject3[i2] != TreeModelListener.class) continue;
            if (treeModelEvent == null) {
                treeModelEvent = new TreeModelEvent(object, arrobject, arrn, arrobject2);
            }
            ((TreeModelListener)arrobject3[i2 + 1]).treeNodesChanged(treeModelEvent);
        }
    }

    protected void fireTreeNodesInserted(Object object, Object[] arrobject, int[] arrn, Object[] arrobject2) {
        Object[] arrobject3 = this.listenerList.getListenerList();
        TreeModelEvent treeModelEvent = null;
        for (int i2 = -2 + arrobject3.length; i2 >= 0; i2 -= 2) {
            if (arrobject3[i2] != TreeModelListener.class) continue;
            if (treeModelEvent == null) {
                treeModelEvent = new TreeModelEvent(object, arrobject, arrn, arrobject2);
            }
            ((TreeModelListener)arrobject3[i2 + 1]).treeNodesInserted(treeModelEvent);
        }
    }

    protected void fireTreeNodesRemoved(Object object, Object[] arrobject, int[] arrn, Object[] arrobject2) {
        Object[] arrobject3 = this.listenerList.getListenerList();
        TreeModelEvent treeModelEvent = null;
        for (int i2 = -2 + arrobject3.length; i2 >= 0; i2 -= 2) {
            if (arrobject3[i2] != TreeModelListener.class) continue;
            if (treeModelEvent == null) {
                treeModelEvent = new TreeModelEvent(object, arrobject, arrn, arrobject2);
            }
            ((TreeModelListener)arrobject3[i2 + 1]).treeNodesRemoved(treeModelEvent);
        }
    }

    protected void fireTreeStructureChanged(Object object, Object[] arrobject, int[] arrn, Object[] arrobject2) {
        Object[] arrobject3 = this.listenerList.getListenerList();
        TreeModelEvent treeModelEvent = null;
        for (int i2 = -2 + arrobject3.length; i2 >= 0; i2 -= 2) {
            if (arrobject3[i2] != TreeModelListener.class) continue;
            if (treeModelEvent == null) {
                treeModelEvent = new TreeModelEvent(object, arrobject, arrn, arrobject2);
            }
            ((TreeModelListener)arrobject3[i2 + 1]).treeStructureChanged(treeModelEvent);
        }
    }

    @Override
    public Object getChild(Object object, int n2) {
        return ((TreeNode)object).getChildAt(n2);
    }

    @Override
    public int getChildCount(Object object) {
        return ((TreeNode)object).getChildCount();
    }

    @Override
    public int getIndexOfChild(Object object, Object object2) {
        if (object != null && object2 != null) {
            return ((TreeNode)object).getIndex((TreeNode)object2);
        }
        return -1;
    }

    public <T extends EventListener> T[] getListeners(Class<T> class_) {
        return this.listenerList.getListeners(class_);
    }

    public TreeNode[] getPathToRoot(TreeNode treeNode) {
        return this.getPathToRoot(treeNode, 0);
    }

    protected TreeNode[] getPathToRoot(TreeNode treeNode, int n2) {
        if (treeNode == null) {
            if (n2 == 0) {
                return null;
            }
            return new TreeNode[n2];
        }
        int n3 = n2 + 1;
        TreeNode[] arrtreeNode = treeNode == this.root ? new TreeNode[n3] : this.getPathToRoot(treeNode.getParent(), n3);
        arrtreeNode[arrtreeNode.length - n3] = treeNode;
        return arrtreeNode;
    }

    @Override
    public Object getRoot() {
        return this.root;
    }

    public TreeModelListener[] getTreeModelListeners() {
        return (TreeModelListener[])this.listenerList.getListeners(TreeModelListener.class);
    }

    public void insertNodeInto(MutableTreeNode mutableTreeNode, MutableTreeNode mutableTreeNode2, int n2) {
        mutableTreeNode2.insert(mutableTreeNode, n2);
        this.nodesWereInserted(mutableTreeNode2, new int[]{n2});
    }

    @Override
    public boolean isLeaf(Object object) {
        if (this.asksAllowsChildren) {
            return true ^ ((TreeNode)object).getAllowsChildren();
        }
        return ((TreeNode)object).isLeaf();
    }

    public void nodeChanged(TreeNode treeNode) {
        if (this.listenerList != null && treeNode != null) {
            TreeNode treeNode2 = treeNode.getParent();
            if (treeNode2 != null) {
                int n2 = treeNode2.getIndex(treeNode);
                if (n2 != -1) {
                    this.nodesChanged(treeNode2, new int[]{n2});
                    return;
                }
            } else if (treeNode == this.getRoot()) {
                this.nodesChanged(treeNode, null);
            }
        }
    }

    public void nodeStructureChanged(TreeNode treeNode) {
        if (treeNode != null) {
            this.fireTreeStructureChanged(this, this.getPathToRoot(treeNode), null, null);
        }
    }

    public void nodesChanged(TreeNode treeNode, int[] arrn) {
        if (treeNode != null) {
            if (arrn != null) {
                int n2 = arrn.length;
                if (n2 > 0) {
                    Object[] arrobject = new Object[n2];
                    for (int i2 = 0; i2 < n2; ++i2) {
                        arrobject[i2] = treeNode.getChildAt(arrn[i2]);
                    }
                    this.fireTreeNodesChanged(this, this.getPathToRoot(treeNode), arrn, arrobject);
                    return;
                }
            } else if (treeNode == this.getRoot()) {
                this.fireTreeNodesChanged(this, this.getPathToRoot(treeNode), null, null);
            }
        }
    }

    public void nodesWereInserted(TreeNode treeNode, int[] arrn) {
        if (this.listenerList != null && treeNode != null && arrn != null && arrn.length > 0) {
            int n2 = arrn.length;
            Object[] arrobject = new Object[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                arrobject[i2] = treeNode.getChildAt(arrn[i2]);
            }
            this.fireTreeNodesInserted(this, this.getPathToRoot(treeNode), arrn, arrobject);
        }
    }

    public void nodesWereRemoved(TreeNode treeNode, int[] arrn, Object[] arrobject) {
        if (treeNode != null && arrn != null) {
            this.fireTreeNodesRemoved(this, this.getPathToRoot(treeNode), arrn, arrobject);
        }
    }

    public void reload() {
        this.reload(this.root);
    }

    public void reload(TreeNode treeNode) {
        if (treeNode != null) {
            this.fireTreeStructureChanged(this, this.getPathToRoot(treeNode), null, null);
        }
    }

    public void removeNodeFromParent(MutableTreeNode mutableTreeNode) {
        MutableTreeNode mutableTreeNode2 = (MutableTreeNode)mutableTreeNode.getParent();
        if (mutableTreeNode2 != null) {
            int[] arrn = new int[1];
            Object[] arrobject = new Object[1];
            arrn[0] = mutableTreeNode2.getIndex(mutableTreeNode);
            mutableTreeNode2.remove(arrn[0]);
            arrobject[0] = mutableTreeNode;
            this.nodesWereRemoved(mutableTreeNode2, arrn, arrobject);
            return;
        }
        throw new IllegalArgumentException("node does not have a parent.");
    }

    @Override
    public void removeTreeModelListener(TreeModelListener treeModelListener) {
        this.listenerList.remove(TreeModelListener.class, treeModelListener);
    }

    public void setAsksAllowsChildren(boolean bl) {
        this.asksAllowsChildren = bl;
    }

    public void setRoot(TreeNode treeNode) {
        TreeNode treeNode2 = this.root;
        this.root = treeNode;
        if (treeNode == null && treeNode2 != null) {
            this.fireTreeStructureChanged(this, null);
            return;
        }
        this.nodeStructureChanged(treeNode);
    }

    @Override
    public void valueForPathChanged(TreePath treePath, Object object) {
        MutableTreeNode mutableTreeNode = (MutableTreeNode)treePath.getLastPathComponent();
        mutableTreeNode.setUserObject(object);
        this.nodeChanged(mutableTreeNode);
    }
}

