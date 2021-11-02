/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.util.ArrayList
 *  java.util.Enumeration
 *  java.util.List
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.mp4.atom.Mp4StcoBox
 *  org.jaudiotagger.audio.mp4.atom.NullPadding
 *  org.jaudiotagger.utils.tree.DefaultMutableTreeNode
 *  org.jaudiotagger.utils.tree.DefaultTreeModel
 *  org.jaudiotagger.utils.tree.MutableTreeNode
 */
package org.jaudiotagger.audio.mp4;

import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.NullBoxIdException;
import org.jaudiotagger.audio.mp4.Mp4AtomIdentifier;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.audio.mp4.atom.Mp4StcoBox;
import org.jaudiotagger.audio.mp4.atom.NullPadding;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.utils.tree.DefaultMutableTreeNode;
import org.jaudiotagger.utils.tree.DefaultTreeModel;
import org.jaudiotagger.utils.tree.MutableTreeNode;
import org.jaudiotagger.utils.tree.TreeNode;

public class Mp4AtomTree {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.mp4");
    private DefaultTreeModel dataTree;
    private List<DefaultMutableTreeNode> freeNodes = new ArrayList();
    private DefaultMutableTreeNode hdlrWithinMdiaNode;
    private DefaultMutableTreeNode hdlrWithinMetaNode;
    private DefaultMutableTreeNode ilstNode;
    private DefaultMutableTreeNode mdatNode;
    private List<DefaultMutableTreeNode> mdatNodes = new ArrayList();
    private DefaultMutableTreeNode metaNode;
    private ByteBuffer moovBuffer;
    private Mp4BoxHeader moovHeader;
    private DefaultMutableTreeNode moovNode;
    private DefaultMutableTreeNode rootNode;
    private List<DefaultMutableTreeNode> stcoNodes = new ArrayList();
    private List<Mp4StcoBox> stcos = new ArrayList();
    private DefaultMutableTreeNode tagsNode;
    private List<DefaultMutableTreeNode> trakNodes = new ArrayList();
    private DefaultMutableTreeNode udtaNode;

    public Mp4AtomTree(RandomAccessFile randomAccessFile) throws IOException, CannotReadException {
        this.buildTree(randomAccessFile, true);
    }

    public Mp4AtomTree(RandomAccessFile randomAccessFile, boolean bl) throws IOException, CannotReadException {
        this.buildTree(randomAccessFile, bl);
    }

    /*
     * Exception decompiling
     */
    public void buildChildrenOfNode(ByteBuffer var1, DefaultMutableTreeNode var2) throws IOException, CannotReadException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl25 : ALOAD_1 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public DefaultTreeModel buildTree(RandomAccessFile randomAccessFile, boolean bl) throws IOException, CannotReadException {
        block24 : {
            block23 : {
                block22 : {
                    block20 : {
                        block27 : {
                            block25 : {
                                block26 : {
                                    fileChannel = randomAccessFile.getChannel();
                                    try {
                                        fileChannel.position(0L);
                                        this.rootNode = defaultMutableTreeNode = new DefaultMutableTreeNode();
                                        this.dataTree = new DefaultTreeModel((TreeNode)defaultMutableTreeNode);
                                        byteBuffer = ByteBuffer.allocate((int)8);
                                        block6 : while (fileChannel.position() < fileChannel.size()) {
                                            block21 : {
                                                mp4BoxHeader = new Mp4BoxHeader();
                                                byteBuffer.clear();
                                                fileChannel.read(byteBuffer);
                                                byteBuffer.rewind();
                                                try {
                                                    mp4BoxHeader.update(byteBuffer);
                                                }
                                                catch (NullBoxIdException nullBoxIdException) {
                                                    if (this.moovNode == null) break block23;
                                                    bl2 = true;
lbl56: // 2 sources:
                                                    while (this.mdatNode != null) {
                                                        bl3 = true;
lbl58: // 2 sources:
                                                        do {
                                                            if (bl2 & bl3) {
                                                                nullPadding = new NullPadding(fileChannel.position() - 8L, fileChannel.size());
                                                                defaultMutableTreeNode2 = new DefaultMutableTreeNode((Object)nullPadding);
                                                                this.rootNode.add((MutableTreeNode)defaultMutableTreeNode2);
                                                                logger = Mp4AtomTree.logger;
                                                                errorMessage = ErrorMessage.NULL_PADDING_FOUND_AT_END_OF_MP4;
                                                                arrobject = new Object[]{nullPadding.getFilePos()};
                                                                logger.warning(errorMessage.getMsg(arrobject));
                                                                break block6;
                                                            }
                                                            throw nullBoxIdException;
                                                            break;
                                                        } while (true);
                                                    }
                                                    break block24;
                                                }
                                                mp4BoxHeader.setFilePos(fileChannel.position() - 8L);
                                                defaultMutableTreeNode3 = new DefaultMutableTreeNode((Object)mp4BoxHeader);
                                                if (mp4BoxHeader.getId().equals((Object)Mp4AtomIdentifier.MOOV.getFieldName())) {
                                                    if (this.moovNode == null) break block20;
                                                    bl5 = true;
lbl20: // 2 sources:
                                                    while (this.mdatNode != null) {
                                                        bl4 = true;
lbl22: // 2 sources:
                                                        do {
                                                            if (bl5 & bl4) {
                                                                logger = Mp4AtomTree.logger;
                                                                errorMessage = ErrorMessage.ADDITIONAL_MOOV_ATOM_AT_END_OF_MP4;
                                                                arrobject = new Object[]{fileChannel.position() - 8L};
                                                                logger.warning(errorMessage.getMsg(arrobject));
                                                                break block6;
                                                            }
                                                            this.moovNode = defaultMutableTreeNode3;
                                                            this.moovHeader = mp4BoxHeader;
                                                            l2 = fileChannel.position();
                                                            this.moovBuffer = byteBuffer2 = ByteBuffer.allocate((int)mp4BoxHeader.getDataLength());
                                                            n2 = fileChannel.read(byteBuffer2);
                                                            if (n2 >= mp4BoxHeader.getDataLength()) {
                                                                this.moovBuffer.rewind();
                                                                this.buildChildrenOfNode(this.moovBuffer, defaultMutableTreeNode3);
                                                                fileChannel.position(l2);
                                                                break block21;
                                                            }
                                                            errorMessage = ErrorMessage.ATOM_LENGTH_LARGER_THAN_DATA;
                                                            arrobject = new Object[]{mp4BoxHeader.getId(), mp4BoxHeader.getDataLength(), n2};
                                                            throw new CannotReadException(errorMessage.getMsg(arrobject));
                                                            break;
                                                        } while (true);
                                                    }
                                                    break block22;
                                                }
                                                if (mp4BoxHeader.getId().equals((Object)Mp4AtomIdentifier.FREE.getFieldName())) {
                                                    this.freeNodes.add((Object)defaultMutableTreeNode3);
                                                } else if (mp4BoxHeader.getId().equals((Object)Mp4AtomIdentifier.MDAT.getFieldName())) {
                                                    this.mdatNode = defaultMutableTreeNode3;
                                                    this.mdatNodes.add((Object)defaultMutableTreeNode3);
                                                }
                                            }
                                            this.rootNode.add((MutableTreeNode)defaultMutableTreeNode3);
                                            fileChannel.position(fileChannel.position() + (long)mp4BoxHeader.getDataLength());
                                        }
                                        defaultTreeModel = this.dataTree;
                                        if (this.mdatNode == null) break block25;
                                        if (!bl) break block26;
                                    }
                                    catch (Throwable throwable) {}
                                    fileChannel.close();
                                }
                                return defaultTreeModel;
                            }
                            throw new CannotReadException(ErrorMessage.MP4_CANNOT_FIND_AUDIO.getMsg());
                            break block27;
                            catch (Throwable throwable) {
                                fileChannel = null;
                            }
                        }
                        if (this.mdatNode != null) {
                            if (bl) {
                                fileChannel.close();
                            }
                            throw var3_29;
                        }
                        throw new CannotReadException(ErrorMessage.MP4_CANNOT_FIND_AUDIO.getMsg());
                    }
                    bl5 = false;
                    ** GOTO lbl20
                }
                bl4 = false;
                ** while (true)
            }
            bl2 = false;
            ** GOTO lbl56
        }
        bl3 = false;
        ** while (true)
    }

    public Mp4BoxHeader getBoxHeader(DefaultMutableTreeNode defaultMutableTreeNode) {
        if (defaultMutableTreeNode == null) {
            return null;
        }
        return (Mp4BoxHeader)defaultMutableTreeNode.getUserObject();
    }

    public DefaultTreeModel getDataTree() {
        return this.dataTree;
    }

    public List<DefaultMutableTreeNode> getFreeNodes() {
        return this.freeNodes;
    }

    public DefaultMutableTreeNode getHdlrWithinMdiaNode() {
        return this.hdlrWithinMdiaNode;
    }

    public DefaultMutableTreeNode getHdlrWithinMetaNode() {
        return this.hdlrWithinMetaNode;
    }

    public DefaultMutableTreeNode getIlstNode() {
        return this.ilstNode;
    }

    public DefaultMutableTreeNode getMdatNode() {
        return this.mdatNode;
    }

    public DefaultMutableTreeNode getMetaNode() {
        return this.metaNode;
    }

    public ByteBuffer getMoovBuffer() {
        return this.moovBuffer;
    }

    public Mp4BoxHeader getMoovHeader() {
        return this.moovHeader;
    }

    public DefaultMutableTreeNode getMoovNode() {
        return this.moovNode;
    }

    public List<DefaultMutableTreeNode> getStcoNodes() {
        return this.stcoNodes;
    }

    public List<Mp4StcoBox> getStcos() {
        return this.stcos;
    }

    public DefaultMutableTreeNode getTagsNode() {
        return this.tagsNode;
    }

    public List<DefaultMutableTreeNode> getTrakNodes() {
        return this.trakNodes;
    }

    public DefaultMutableTreeNode getUdtaNode() {
        return this.udtaNode;
    }

    public void printAtomTree() {
        Enumeration enumeration = this.rootNode.preorderEnumeration();
        while (enumeration.hasMoreElements()) {
            DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)enumeration.nextElement();
            Mp4BoxHeader mp4BoxHeader = (Mp4BoxHeader)defaultMutableTreeNode.getUserObject();
            if (mp4BoxHeader == null) continue;
            String string2 = "";
            for (int i2 = 1; i2 < defaultMutableTreeNode.getLevel(); ++i2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append("\t");
                string2 = stringBuilder.toString();
            }
            if (mp4BoxHeader instanceof NullPadding) {
                PrintStream printStream = System.out;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append("Null pad  @ ");
                stringBuilder.append(mp4BoxHeader.getFilePos());
                stringBuilder.append(" of size:");
                stringBuilder.append(mp4BoxHeader.getLength());
                stringBuilder.append(" ,ends @ ");
                stringBuilder.append(mp4BoxHeader.getFilePos() + (long)mp4BoxHeader.getLength());
                printStream.println(stringBuilder.toString());
                continue;
            }
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("Atom ");
            stringBuilder.append(mp4BoxHeader.getId());
            stringBuilder.append(" @ ");
            stringBuilder.append(mp4BoxHeader.getFilePos());
            stringBuilder.append(" of size:");
            stringBuilder.append(mp4BoxHeader.getLength());
            stringBuilder.append(" ,ends @ ");
            stringBuilder.append(mp4BoxHeader.getFilePos() + (long)mp4BoxHeader.getLength());
            printStream.println(stringBuilder.toString());
        }
    }
}

