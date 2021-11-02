/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.Serializable
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.ClassNotFoundException
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Error
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.EmptyStackException
 *  java.util.Enumeration
 *  java.util.NoSuchElementException
 *  java.util.Stack
 *  java.util.Vector
 */
package org.jaudiotagger.utils.tree;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Vector;
import org.jaudiotagger.utils.tree.DefaultMutableTreeNode;
import org.jaudiotagger.utils.tree.MutableTreeNode;
import org.jaudiotagger.utils.tree.TreeNode;

public class DefaultMutableTreeNode
implements Cloneable,
MutableTreeNode,
Serializable {
    public static final Enumeration<TreeNode> EMPTY_ENUMERATION = new Enumeration<TreeNode>(){

        public boolean hasMoreElements() {
            return false;
        }

        public TreeNode nextElement() {
            throw new NoSuchElementException("No more elements");
        }
    };
    protected boolean allowsChildren;
    protected Vector children;
    protected MutableTreeNode parent = null;
    protected transient Object userObject;

    public DefaultMutableTreeNode() {
        this(null);
    }

    public DefaultMutableTreeNode(Object object) {
        this(object, true);
    }

    public DefaultMutableTreeNode(Object object, boolean bl) {
        this.allowsChildren = bl;
        this.userObject = object;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object[] arrobject = (Object[])objectInputStream.readObject();
        if (arrobject.length > 0 && arrobject[0].equals((Object)"userObject")) {
            this.userObject = arrobject[1];
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Object object = this.userObject;
        Object[] arrobject = object != null && object instanceof Serializable ? new Object[]{"userObject", object} : new Object[]{};
        objectOutputStream.writeObject((Object)arrobject);
    }

    public void add(MutableTreeNode mutableTreeNode) {
        if (mutableTreeNode != null && mutableTreeNode.getParent() == this) {
            this.insert(mutableTreeNode, -1 + this.getChildCount());
            return;
        }
        this.insert(mutableTreeNode, this.getChildCount());
    }

    public Enumeration breadthFirstEnumeration() {
        return new Enumeration<TreeNode>((TreeNode)this){
            protected Queue queue;
            {
                Queue queue;
                Vector vector = new Vector(1);
                vector.addElement((Object)treeNode);
                this.queue = queue = new Queue();
                queue.enqueue((Object)vector.elements());
            }

            public boolean hasMoreElements() {
                return !this.queue.isEmpty() && ((Enumeration)this.queue.firstObject()).hasMoreElements();
            }

            public TreeNode nextElement() {
                Enumeration enumeration = (Enumeration)this.queue.firstObject();
                TreeNode treeNode = (TreeNode)enumeration.nextElement();
                Enumeration enumeration2 = treeNode.children();
                if (!enumeration.hasMoreElements()) {
                    this.queue.dequeue();
                }
                if (enumeration2.hasMoreElements()) {
                    this.queue.enqueue((Object)enumeration2);
                }
                return treeNode;
            }

            final class Queue {
                Queue$QNode head;
                Queue$QNode tail;

                Queue() {
                }

                public Object dequeue() {
                    Queue$QNode queue$QNode = this.head;
                    if (queue$QNode != null) {
                        Queue$QNode queue$QNode2;
                        Object object = queue$QNode.object;
                        this.head = queue$QNode2 = queue$QNode.next;
                        if (queue$QNode2 == null) {
                            this.tail = null;
                            return object;
                        }
                        queue$QNode.next = null;
                        return object;
                    }
                    throw new NoSuchElementException("No more elements");
                }

                public void enqueue(Object object) {
                    if (this.head == null) {
                        Queue$QNode queue$QNode;
                        this.tail = queue$QNode = new Queue$QNode(object, null);
                        this.head = queue$QNode;
                        return;
                    }
                    this.tail = this.tail.next = new Queue$QNode(object, null);
                }

                public Object firstObject() {
                    Queue$QNode queue$QNode = this.head;
                    if (queue$QNode != null) {
                        return queue$QNode.object;
                    }
                    throw new NoSuchElementException("No more elements");
                }

                public boolean isEmpty() {
                    return this.head == null;
                }
            }

            final class Queue$QNode {
                public Queue$QNode next;
                public Object object;

                public Queue$QNode(Object object, Queue$QNode queue$QNode) {
                    this.object = object;
                    this.next = queue$QNode;
                }
            }

        };
    }

    @Override
    public Enumeration children() {
        Vector vector = this.children;
        if (vector == null) {
            return EMPTY_ENUMERATION;
        }
        return vector.elements();
    }

    public Object clone() {
        try {
            DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)super.clone();
            defaultMutableTreeNode.children = null;
            defaultMutableTreeNode.parent = null;
            return defaultMutableTreeNode;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new Error(cloneNotSupportedException.toString());
        }
    }

    public Enumeration depthFirstEnumeration() {
        return this.postorderEnumeration();
    }

    @Override
    public boolean getAllowsChildren() {
        return this.allowsChildren;
    }

    public TreeNode getChildAfter(TreeNode treeNode) {
        if (treeNode != null) {
            int n2 = this.getIndex(treeNode);
            if (n2 != -1) {
                if (n2 < -1 + this.getChildCount()) {
                    return this.getChildAt(n2 + 1);
                }
                return null;
            }
            throw new IllegalArgumentException("node is not a child");
        }
        throw new IllegalArgumentException("argument is null");
    }

    @Override
    public TreeNode getChildAt(int n2) {
        Vector vector = this.children;
        if (vector != null) {
            return (TreeNode)vector.elementAt(n2);
        }
        throw new ArrayIndexOutOfBoundsException("node has no children");
    }

    public TreeNode getChildBefore(TreeNode treeNode) {
        if (treeNode != null) {
            int n2 = this.getIndex(treeNode);
            if (n2 != -1) {
                if (n2 > 0) {
                    return this.getChildAt(n2 - 1);
                }
                return null;
            }
            throw new IllegalArgumentException("argument is not a child");
        }
        throw new IllegalArgumentException("argument is null");
    }

    @Override
    public int getChildCount() {
        Vector vector = this.children;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public int getDepth() {
        Enumeration enumeration = this.breadthFirstEnumeration();
        Object object = null;
        while (enumeration.hasMoreElements()) {
            object = enumeration.nextElement();
        }
        if (object != null) {
            return ((DefaultMutableTreeNode)object).getLevel() - this.getLevel();
        }
        throw new Error("nodes should be null");
    }

    public TreeNode getFirstChild() {
        if (this.getChildCount() != 0) {
            return this.getChildAt(0);
        }
        throw new NoSuchElementException("node has no children");
    }

    public DefaultMutableTreeNode getFirstLeaf() {
        DefaultMutableTreeNode defaultMutableTreeNode = this;
        while (!defaultMutableTreeNode.isLeaf()) {
            defaultMutableTreeNode = (DefaultMutableTreeNode)defaultMutableTreeNode.getFirstChild();
        }
        return defaultMutableTreeNode;
    }

    @Override
    public int getIndex(TreeNode treeNode) {
        if (treeNode != null) {
            if (!this.isNodeChild(treeNode)) {
                return -1;
            }
            return this.children.indexOf((Object)treeNode);
        }
        throw new IllegalArgumentException("argument is null");
    }

    public TreeNode getLastChild() {
        if (this.getChildCount() != 0) {
            return this.getChildAt(-1 + this.getChildCount());
        }
        throw new NoSuchElementException("node has no children");
    }

    public DefaultMutableTreeNode getLastLeaf() {
        DefaultMutableTreeNode defaultMutableTreeNode = this;
        while (!defaultMutableTreeNode.isLeaf()) {
            defaultMutableTreeNode = (DefaultMutableTreeNode)defaultMutableTreeNode.getLastChild();
        }
        return defaultMutableTreeNode;
    }

    public int getLeafCount() {
        Enumeration enumeration = this.breadthFirstEnumeration();
        int n2 = 0;
        while (enumeration.hasMoreElements()) {
            if (!((TreeNode)enumeration.nextElement()).isLeaf()) continue;
            ++n2;
        }
        if (n2 >= 1) {
            return n2;
        }
        throw new Error("tree has zero leaves");
    }

    public int getLevel() {
        int n2 = 0;
        TreeNode treeNode = this;
        while ((treeNode = treeNode.getParent()) != null) {
            ++n2;
        }
        return n2;
    }

    public DefaultMutableTreeNode getNextLeaf() {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)this.getParent();
        if (defaultMutableTreeNode == null) {
            return null;
        }
        DefaultMutableTreeNode defaultMutableTreeNode2 = this.getNextSibling();
        if (defaultMutableTreeNode2 != null) {
            return defaultMutableTreeNode2.getFirstLeaf();
        }
        return defaultMutableTreeNode.getNextLeaf();
    }

    public DefaultMutableTreeNode getNextNode() {
        if (this.getChildCount() == 0) {
            DefaultMutableTreeNode defaultMutableTreeNode = this.getNextSibling();
            if (defaultMutableTreeNode == null) {
                DefaultMutableTreeNode defaultMutableTreeNode2 = (DefaultMutableTreeNode)this.getParent();
                do {
                    if (defaultMutableTreeNode2 == null) {
                        return null;
                    }
                    DefaultMutableTreeNode defaultMutableTreeNode3 = defaultMutableTreeNode2.getNextSibling();
                    if (defaultMutableTreeNode3 != null) {
                        return defaultMutableTreeNode3;
                    }
                    defaultMutableTreeNode2 = (DefaultMutableTreeNode)defaultMutableTreeNode2.getParent();
                } while (true);
            }
            return defaultMutableTreeNode;
        }
        return (DefaultMutableTreeNode)this.getChildAt(0);
    }

    public DefaultMutableTreeNode getNextSibling() {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)this.getParent();
        DefaultMutableTreeNode defaultMutableTreeNode2 = defaultMutableTreeNode == null ? null : (DefaultMutableTreeNode)defaultMutableTreeNode.getChildAfter(this);
        if (defaultMutableTreeNode2 != null) {
            if (this.isNodeSibling(defaultMutableTreeNode2)) {
                return defaultMutableTreeNode2;
            }
            throw new Error("child of parent is not a sibling");
        }
        return defaultMutableTreeNode2;
    }

    @Override
    public TreeNode getParent() {
        return this.parent;
    }

    public TreeNode[] getPath() {
        return this.getPathToRoot(this, 0);
    }

    protected TreeNode[] getPathToRoot(TreeNode treeNode, int n2) {
        if (treeNode == null) {
            if (n2 == 0) {
                return null;
            }
            return new TreeNode[n2];
        }
        int n3 = n2 + 1;
        TreeNode[] arrtreeNode = this.getPathToRoot(treeNode.getParent(), n3);
        arrtreeNode[arrtreeNode.length - n3] = treeNode;
        return arrtreeNode;
    }

    public DefaultMutableTreeNode getPreviousLeaf() {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)this.getParent();
        if (defaultMutableTreeNode == null) {
            return null;
        }
        DefaultMutableTreeNode defaultMutableTreeNode2 = this.getPreviousSibling();
        if (defaultMutableTreeNode2 != null) {
            return defaultMutableTreeNode2.getLastLeaf();
        }
        return defaultMutableTreeNode.getPreviousLeaf();
    }

    public DefaultMutableTreeNode getPreviousNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)this.getParent();
        if (defaultMutableTreeNode == null) {
            return null;
        }
        DefaultMutableTreeNode defaultMutableTreeNode2 = this.getPreviousSibling();
        if (defaultMutableTreeNode2 != null) {
            if (defaultMutableTreeNode2.getChildCount() == 0) {
                return defaultMutableTreeNode2;
            }
            defaultMutableTreeNode = defaultMutableTreeNode2.getLastLeaf();
        }
        return defaultMutableTreeNode;
    }

    public DefaultMutableTreeNode getPreviousSibling() {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)this.getParent();
        DefaultMutableTreeNode defaultMutableTreeNode2 = defaultMutableTreeNode == null ? null : (DefaultMutableTreeNode)defaultMutableTreeNode.getChildBefore(this);
        if (defaultMutableTreeNode2 != null) {
            if (this.isNodeSibling(defaultMutableTreeNode2)) {
                return defaultMutableTreeNode2;
            }
            throw new Error("child of parent is not a sibling");
        }
        return defaultMutableTreeNode2;
    }

    public TreeNode getRoot() {
        TreeNode treeNode = this;
        TreeNode treeNode2;
        while ((treeNode2 = treeNode.getParent()) != null) {
            treeNode = treeNode2;
        }
        return treeNode;
    }

    public TreeNode getSharedAncestor(DefaultMutableTreeNode treeNode) {
        TreeNode treeNode2;
        int n2;
        if (treeNode == this) {
            return this;
        }
        if (treeNode == null) {
            return null;
        }
        int n3 = this.getLevel();
        int n4 = ((DefaultMutableTreeNode)treeNode).getLevel();
        if (n4 > n3) {
            n2 = n4 - n3;
            treeNode2 = this;
        } else {
            n2 = n3 - n4;
            treeNode2 = treeNode;
            treeNode = this;
        }
        while (n2 > 0) {
            treeNode = treeNode.getParent();
            --n2;
        }
        do {
            if (treeNode == treeNode2) {
                return treeNode;
            }
            treeNode = treeNode.getParent();
            treeNode2 = treeNode2.getParent();
        } while (treeNode != null);
        if (treeNode == null && treeNode2 == null) {
            return null;
        }
        throw new Error("nodes should be null");
    }

    public int getSiblingCount() {
        TreeNode treeNode = this.getParent();
        if (treeNode == null) {
            return 1;
        }
        return treeNode.getChildCount();
    }

    public Object getUserObject() {
        return this.userObject;
    }

    public Object[] getUserObjectPath() {
        TreeNode[] arrtreeNode = this.getPath();
        Object[] arrobject = new Object[arrtreeNode.length];
        for (int i2 = 0; i2 < arrtreeNode.length; ++i2) {
            arrobject[i2] = ((DefaultMutableTreeNode)arrtreeNode[i2]).getUserObject();
        }
        return arrobject;
    }

    @Override
    public void insert(MutableTreeNode mutableTreeNode, int n2) {
        if (this.allowsChildren) {
            if (mutableTreeNode != null) {
                if (!this.isNodeAncestor(mutableTreeNode)) {
                    MutableTreeNode mutableTreeNode2 = (MutableTreeNode)mutableTreeNode.getParent();
                    if (mutableTreeNode2 != null) {
                        mutableTreeNode2.remove(mutableTreeNode);
                    }
                    mutableTreeNode.setParent(this);
                    if (this.children == null) {
                        this.children = new Vector();
                    }
                    this.children.insertElementAt((Object)mutableTreeNode, n2);
                    return;
                }
                throw new IllegalArgumentException("new child is an ancestor");
            }
            throw new IllegalArgumentException("new child is null");
        }
        throw new IllegalStateException("node does not allow children");
    }

    @Override
    public boolean isLeaf() {
        return this.getChildCount() == 0;
    }

    public boolean isNodeAncestor(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        TreeNode treeNode2 = this;
        do {
            if (treeNode2 != treeNode) continue;
            return true;
        } while ((treeNode2 = treeNode2.getParent()) != null);
        return false;
    }

    public boolean isNodeChild(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        if (this.getChildCount() == 0) {
            return false;
        }
        TreeNode treeNode2 = treeNode.getParent();
        boolean bl = false;
        if (treeNode2 == this) {
            bl = true;
        }
        return bl;
    }

    public boolean isNodeDescendant(DefaultMutableTreeNode defaultMutableTreeNode) {
        if (defaultMutableTreeNode == null) {
            return false;
        }
        return defaultMutableTreeNode.isNodeAncestor(this);
    }

    public boolean isNodeRelated(DefaultMutableTreeNode defaultMutableTreeNode) {
        return defaultMutableTreeNode != null && this.getRoot() == defaultMutableTreeNode.getRoot();
    }

    public boolean isNodeSibling(TreeNode treeNode) {
        boolean bl = true;
        if (treeNode == null) {
            return false;
        }
        if (treeNode == this) {
            return bl;
        }
        TreeNode treeNode2 = this.getParent();
        if (treeNode2 == null || treeNode2 != treeNode.getParent()) {
            bl = false;
        }
        if (bl) {
            if (((DefaultMutableTreeNode)this.getParent()).isNodeChild(treeNode)) {
                return bl;
            }
            throw new Error("sibling has different parent");
        }
        return bl;
    }

    public boolean isRoot() {
        return this.getParent() == null;
    }

    public Enumeration pathFromAncestorEnumeration(TreeNode treeNode) {
        return new Enumeration<TreeNode>(treeNode, (TreeNode)this){
            protected Stack<TreeNode> stack;
            {
                if (treeNode != null && treeNode2 != null) {
                    Stack stack;
                    this.stack = stack = new Stack();
                    stack.push((Object)treeNode2);
                    TreeNode treeNode3 = treeNode2;
                    while (treeNode3 != treeNode) {
                        if ((treeNode3 = treeNode3.getParent()) == null && treeNode2 != treeNode) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("node ");
                            stringBuilder.append((Object)treeNode);
                            stringBuilder.append(" is not an ancestor of ");
                            stringBuilder.append((Object)treeNode2);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        this.stack.push((Object)treeNode3);
                    }
                    return;
                }
                throw new IllegalArgumentException("argument is null");
            }

            public boolean hasMoreElements() {
                return this.stack.size() > 0;
            }

            public TreeNode nextElement() {
                try {
                    TreeNode treeNode = (TreeNode)this.stack.pop();
                    return treeNode;
                }
                catch (EmptyStackException emptyStackException) {
                    throw new NoSuchElementException("No more elements");
                }
            }
        };
    }

    public Enumeration postorderEnumeration() {
        return new Enumeration<TreeNode>((TreeNode)this){
            protected Enumeration<TreeNode> children;
            protected TreeNode root;
            protected Enumeration<TreeNode> subtree;
            {
                this.root = treeNode;
                this.children = treeNode.children();
                this.subtree = DefaultMutableTreeNode.EMPTY_ENUMERATION;
            }

            public boolean hasMoreElements() {
                return this.root != null;
            }

            public TreeNode nextElement() {
                if (this.subtree.hasMoreElements()) {
                    return (TreeNode)this.subtree.nextElement();
                }
                if (this.children.hasMoreElements()) {
                    Enumeration<TreeNode> enumeration;
                    this.subtree = enumeration = new /* invalid duplicate definition of identical inner class */;
                    return (TreeNode)enumeration.nextElement();
                }
                TreeNode treeNode = this.root;
                this.root = null;
                return treeNode;
            }
        };
    }

    public Enumeration preorderEnumeration() {
        return new Enumeration<TreeNode>((TreeNode)this){
            protected Stack stack;
            {
                Stack stack;
                Vector vector = new Vector(1);
                vector.addElement((Object)treeNode);
                this.stack = stack = new Stack();
                stack.push((Object)vector.elements());
            }

            public boolean hasMoreElements() {
                return !this.stack.empty() && ((Enumeration)this.stack.peek()).hasMoreElements();
            }

            public TreeNode nextElement() {
                Enumeration enumeration = (Enumeration)this.stack.peek();
                TreeNode treeNode = (TreeNode)enumeration.nextElement();
                Enumeration enumeration2 = treeNode.children();
                if (!enumeration.hasMoreElements()) {
                    this.stack.pop();
                }
                if (enumeration2.hasMoreElements()) {
                    this.stack.push((Object)enumeration2);
                }
                return treeNode;
            }
        };
    }

    @Override
    public void remove(int n2) {
        MutableTreeNode mutableTreeNode = (MutableTreeNode)this.getChildAt(n2);
        this.children.removeElementAt(n2);
        mutableTreeNode.setParent(null);
    }

    @Override
    public void remove(MutableTreeNode mutableTreeNode) {
        if (mutableTreeNode != null) {
            if (this.isNodeChild(mutableTreeNode)) {
                this.remove(this.getIndex(mutableTreeNode));
                return;
            }
            throw new IllegalArgumentException("argument is not a child");
        }
        throw new IllegalArgumentException("argument is null");
    }

    public void removeAllChildren() {
        for (int i2 = -1 + this.getChildCount(); i2 >= 0; --i2) {
            this.remove(i2);
        }
    }

    @Override
    public void removeFromParent() {
        MutableTreeNode mutableTreeNode = (MutableTreeNode)this.getParent();
        if (mutableTreeNode != null) {
            mutableTreeNode.remove(this);
        }
    }

    public void setAllowsChildren(boolean bl) {
        if (bl != this.allowsChildren) {
            this.allowsChildren = bl;
            if (!bl) {
                this.removeAllChildren();
            }
        }
    }

    @Override
    public void setParent(MutableTreeNode mutableTreeNode) {
        this.parent = mutableTreeNode;
    }

    @Override
    public void setUserObject(Object object) {
        this.userObject = object;
    }

    public String toString() {
        Object object = this.userObject;
        if (object == null) {
            return null;
        }
        return object.toString();
    }

}

