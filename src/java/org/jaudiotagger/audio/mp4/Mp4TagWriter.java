/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.channels.ReadableByteChannel
 *  java.util.Iterator
 *  java.util.List
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.mp4.atom.Mp4FreeBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4HdlrBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4MetaBox
 *  org.jaudiotagger.audio.mp4.atom.Mp4StcoBox
 *  org.jaudiotagger.tag.mp4.Mp4Tag
 *  org.jaudiotagger.tag.mp4.Mp4TagCreator
 *  org.jaudiotagger.utils.tree.DefaultMutableTreeNode
 */
package org.jaudiotagger.audio.mp4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.mp4.Mp4AtomIdentifier;
import org.jaudiotagger.audio.mp4.Mp4AtomTree;
import org.jaudiotagger.audio.mp4.atom.Mp4BoxHeader;
import org.jaudiotagger.audio.mp4.atom.Mp4FreeBox;
import org.jaudiotagger.audio.mp4.atom.Mp4HdlrBox;
import org.jaudiotagger.audio.mp4.atom.Mp4MetaBox;
import org.jaudiotagger.audio.mp4.atom.Mp4StcoBox;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.mp4.Mp4Tag;
import org.jaudiotagger.tag.mp4.Mp4TagCreator;
import org.jaudiotagger.utils.tree.DefaultMutableTreeNode;
import org.jaudiotagger.utils.tree.TreeNode;

public class Mp4TagWriter {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.tag.mp4");
    private Mp4TagCreator tc = new Mp4TagCreator();

    private void adjustFreeAtom(FileChannel fileChannel, FileChannel fileChannel2, int n2, int n3) throws IOException, CannotWriteException {
        int n4 = n2 - 8;
        if (n4 >= n3) {
            logger.config("Writing:Option 6;Larger Size can use top free atom");
            Mp4FreeBox mp4FreeBox = new Mp4FreeBox(n4 - n3);
            fileChannel2.write(mp4FreeBox.getHeader().getHeaderData());
            fileChannel2.write(mp4FreeBox.getData());
            fileChannel.position(fileChannel.position() + (long)n2);
            return;
        }
        if (n2 == n3) {
            logger.config("Writing:Option 7;Larger Size uses top free atom including header");
            fileChannel.position(fileChannel.position() + (long)n2);
        }
    }

    private void adjustSizeOfMoovHeader(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer, int n2, Mp4BoxHeader mp4BoxHeader2, Mp4BoxHeader mp4BoxHeader3) throws IOException {
        mp4BoxHeader.setLength(n2 + mp4BoxHeader.getLength());
        if (mp4BoxHeader2 != null) {
            mp4BoxHeader2.setLength(n2 + mp4BoxHeader2.getLength());
            byteBuffer.position((int)(mp4BoxHeader2.getFilePos() - mp4BoxHeader.getFilePos() - 8L));
            byteBuffer.put(mp4BoxHeader2.getHeaderData());
        }
        if (mp4BoxHeader3 != null) {
            mp4BoxHeader3.setLength(n2 + mp4BoxHeader3.getLength());
            byteBuffer.position((int)(mp4BoxHeader3.getFilePos() - mp4BoxHeader.getFilePos() - 8L));
            byteBuffer.put(mp4BoxHeader3.getHeaderData());
        }
    }

    private boolean adjustStcosIfNoSuitableTopLevelAtom(int n2, boolean bl, int n3, List<Mp4StcoBox> list, Mp4BoxHeader mp4BoxHeader, Mp4BoxHeader mp4BoxHeader2) {
        if (mp4BoxHeader2.getFilePos() > mp4BoxHeader.getFilePos() && (!bl || n2 - 8 < n3 && n2 != n3)) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((Mp4StcoBox)iterator.next()).adjustOffsets(n3);
            }
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void checkFileWrittenCorrectly(RandomAccessFile randomAccessFile, Mp4BoxHeader mp4BoxHeader, FileChannel fileChannel, List<Mp4StcoBox> list) throws CannotWriteException, IOException {
        int n2;
        Mp4BoxHeader mp4BoxHeader2;
        int n3;
        List<Mp4StcoBox> list2;
        block14 : {
            logger.config("Checking file has been written correctly");
            try {
                Mp4AtomTree mp4AtomTree = new Mp4AtomTree(randomAccessFile, false);
                mp4BoxHeader2 = mp4AtomTree.getBoxHeader(mp4AtomTree.getMdatNode());
                if (mp4BoxHeader2 == null) throw new CannotWriteException(ErrorMessage.MP4_CHANGES_TO_FILE_FAILED_NO_DATA.getMsg());
                if (mp4BoxHeader2.getLength() != mp4BoxHeader.getLength()) throw new CannotWriteException(ErrorMessage.MP4_CHANGES_TO_FILE_FAILED_DATA_CORRUPT.getMsg());
                if (mp4AtomTree.getBoxHeader(mp4AtomTree.getUdtaNode()) == null) throw new CannotWriteException(ErrorMessage.MP4_CHANGES_TO_FILE_FAILED_NO_TAG_DATA.getMsg());
                if (mp4AtomTree.getBoxHeader(mp4AtomTree.getMetaNode()) == null) throw new CannotWriteException(ErrorMessage.MP4_CHANGES_TO_FILE_FAILED_NO_TAG_DATA.getMsg());
                list2 = mp4AtomTree.getStcos();
                if (list2.size() == list.size()) {
                    n3 = 0;
                    n2 = 0;
                    break block14;
                }
                ErrorMessage errorMessage = ErrorMessage.MP4_CHANGES_TO_FILE_FAILED_INCORRECT_NUMBER_OF_TRACKS;
                Object[] arrobject = new Object[]{list.size(), list2.size()};
                throw new CannotWriteException(errorMessage.getMsg(arrobject));
            }
            catch (Throwable throwable) {
            }
            catch (Exception exception) {
                if (exception instanceof CannotWriteException) {
                    throw (CannotWriteException)exception;
                }
                exception.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(ErrorMessage.MP4_CHANGES_TO_FILE_FAILED.getMsg());
                stringBuilder.append(":");
                stringBuilder.append(exception.getMessage());
                throw new CannotWriteException(stringBuilder.toString());
            }
            randomAccessFile.close();
            fileChannel.close();
            throw throwable;
        }
        do {
            if (n3 < list2.size()) {
                Mp4StcoBox mp4StcoBox = (Mp4StcoBox)list2.get(n3);
                Mp4StcoBox mp4StcoBox2 = (Mp4StcoBox)list.get(n3);
                Logger logger = Mp4TagWriter.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("stco:Original First Offset");
                stringBuilder.append(mp4StcoBox2.getFirstOffSet());
                logger.finer(stringBuilder.toString());
                Logger logger2 = Mp4TagWriter.logger;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("stco:Original Diff");
                stringBuilder2.append((int)((long)mp4StcoBox2.getFirstOffSet() - mp4BoxHeader.getFilePos()));
                logger2.finer(stringBuilder2.toString());
                Logger logger3 = Mp4TagWriter.logger;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("stco:Original Mdat Pos");
                stringBuilder3.append(mp4BoxHeader.getFilePos());
                logger3.finer(stringBuilder3.toString());
                Logger logger4 = Mp4TagWriter.logger;
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("stco:New First Offset");
                stringBuilder4.append(mp4StcoBox.getFirstOffSet());
                logger4.finer(stringBuilder4.toString());
                Logger logger5 = Mp4TagWriter.logger;
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append("stco:New Diff");
                stringBuilder5.append((int)((long)mp4StcoBox.getFirstOffSet() - mp4BoxHeader2.getFilePos()));
                logger5.finer(stringBuilder5.toString());
                Logger logger6 = Mp4TagWriter.logger;
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append("stco:New Mdat Pos");
                stringBuilder6.append(mp4BoxHeader2.getFilePos());
                logger6.finer(stringBuilder6.toString());
                if (n3 == 0) {
                    long l2;
                    int n4 = (int)((long)mp4StcoBox2.getFirstOffSet() - mp4BoxHeader.getFilePos());
                    long l3 = (long)mp4StcoBox.getFirstOffSet() - mp4BoxHeader2.getFilePos();
                    if (l3 != (l2 = (long)n4)) {
                        int n5 = (int)((long)mp4StcoBox.getFirstOffSet() - mp4BoxHeader2.getFilePos() - l2);
                        ErrorMessage errorMessage = ErrorMessage.MP4_CHANGES_TO_FILE_FAILED_INCORRECT_OFFSETS;
                        Object[] arrobject = new Object[]{n5};
                        throw new CannotWriteException(errorMessage.getMsg(arrobject));
                    }
                    n2 = mp4StcoBox2.getFirstOffSet() - mp4StcoBox.getFirstOffSet();
                } else if (n2 != mp4StcoBox2.getFirstOffSet() - mp4StcoBox.getFirstOffSet()) {
                    ErrorMessage errorMessage = ErrorMessage.MP4_CHANGES_TO_FILE_FAILED_INCORRECT_OFFSETS;
                    Object[] arrobject = new Object[]{n2};
                    throw new CannotWriteException(errorMessage.getMsg(arrobject));
                }
            } else {
                randomAccessFile.close();
                fileChannel.close();
                logger.config("File has been written correctly");
                return;
            }
            ++n3;
        } while (true);
    }

    private void convertandWriteTagsAtomToFreeAtom(FileChannel fileChannel, Mp4BoxHeader mp4BoxHeader) throws IOException {
        Mp4FreeBox mp4FreeBox = new Mp4FreeBox(mp4BoxHeader.getDataLength());
        fileChannel.write(mp4FreeBox.getHeader().getHeaderData());
        fileChannel.write(mp4FreeBox.getData());
    }

    private void createMetadataAtoms(Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer, int n2, Mp4BoxHeader mp4BoxHeader2, Mp4BoxHeader mp4BoxHeader3) throws IOException {
        mp4BoxHeader.setLength(n2 + mp4BoxHeader.getLength());
    }

    private int getMetaLevelFreeAtomSize(Mp4AtomTree mp4AtomTree) {
        for (DefaultMutableTreeNode defaultMutableTreeNode : mp4AtomTree.getFreeNodes()) {
            DefaultMutableTreeNode defaultMutableTreeNode2 = (DefaultMutableTreeNode)defaultMutableTreeNode.getParent();
            DefaultMutableTreeNode defaultMutableTreeNode3 = defaultMutableTreeNode.getPreviousSibling();
            if (defaultMutableTreeNode2.isRoot()) continue;
            Mp4BoxHeader mp4BoxHeader = (Mp4BoxHeader)defaultMutableTreeNode2.getUserObject();
            Mp4BoxHeader mp4BoxHeader2 = (Mp4BoxHeader)defaultMutableTreeNode.getUserObject();
            if (defaultMutableTreeNode3 == null) continue;
            Mp4BoxHeader mp4BoxHeader3 = (Mp4BoxHeader)defaultMutableTreeNode3.getUserObject();
            if (!mp4BoxHeader.getId().equals((Object)Mp4AtomIdentifier.META.getFieldName()) || !mp4BoxHeader3.getId().equals((Object)Mp4AtomIdentifier.ILST.getFieldName())) continue;
            return mp4BoxHeader2.getLength();
        }
        return 0;
    }

    private void writeDataAfterIlst(FileChannel fileChannel, FileChannel fileChannel2, Mp4BoxHeader mp4BoxHeader) throws IOException, CannotWriteException {
        if (mp4BoxHeader != null) {
            this.writeNeroData(fileChannel, fileChannel2, mp4BoxHeader);
            return;
        }
        this.writeDataInChunks(fileChannel, fileChannel2);
    }

    private void writeDataInChunks(FileChannel fileChannel, FileChannel fileChannel2) throws IOException, CannotWriteException {
        long l2 = fileChannel.size() - fileChannel.position();
        long l3 = TagOptionSingleton.getInstance().getWriteChunkSize();
        long l4 = l2 / l3;
        long l5 = l2 % l3;
        int n2 = 0;
        long l6 = 0L;
        while ((long)n2 < l4) {
            l6 += fileChannel2.transferFrom((ReadableByteChannel)fileChannel, fileChannel2.position(), l3);
            fileChannel2.position(l3 + fileChannel2.position());
            ++n2;
        }
        if (l5 > 0L) {
            long l7 = l6 + fileChannel2.transferFrom((ReadableByteChannel)fileChannel, fileChannel2.position(), l5);
            if (l7 == l2) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Was meant to write ");
            stringBuilder.append(l2);
            stringBuilder.append(" bytes but only written ");
            stringBuilder.append(l7);
            stringBuilder.append(" bytes");
            throw new CannotWriteException(stringBuilder.toString());
        }
    }

    private void writeDataUptoIncludingIlst(FileChannel fileChannel, FileChannel fileChannel2, Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer) throws IOException {
        fileChannel.position(0L);
        fileChannel2.transferFrom((ReadableByteChannel)fileChannel, 0L, mp4BoxHeader.getFilePos());
        fileChannel2.position(mp4BoxHeader.getFilePos());
        fileChannel2.write(byteBuffer);
        fileChannel.position(mp4BoxHeader.getFileEndPos());
    }

    private void writeFromEndOfIlstToNeroTagsAndMakeNeroFree(long l2, FileChannel fileChannel, FileChannel fileChannel2, Mp4BoxHeader mp4BoxHeader) throws IOException {
        long l3 = mp4BoxHeader.getFilePos() - fileChannel.position();
        fileChannel2.transferFrom((ReadableByteChannel)fileChannel, fileChannel2.position(), l3);
        fileChannel2.position(l3 + fileChannel2.position());
        this.convertandWriteTagsAtomToFreeAtom(fileChannel2, mp4BoxHeader);
        fileChannel.position(mp4BoxHeader.getFileEndPos());
        long l4 = l2 - fileChannel.position();
        fileChannel2.transferFrom((ReadableByteChannel)fileChannel, fileChannel2.position(), l4);
    }

    private void writeHaveExistingMetadata(Mp4BoxHeader mp4BoxHeader, Mp4BoxHeader mp4BoxHeader2, FileChannel fileChannel, FileChannel fileChannel2, int n2, Mp4BoxHeader mp4BoxHeader3, ByteBuffer byteBuffer, Mp4BoxHeader mp4BoxHeader4, List<Mp4StcoBox> list, int n3, int n4, boolean bl, ByteBuffer byteBuffer2, Mp4BoxHeader mp4BoxHeader5, int n5, int n6, int n7) throws IOException, CannotWriteException {
        logger.config("Writing:Option 5.3;udta and meta atom exists");
        boolean bl2 = this.adjustStcosIfNoSuitableTopLevelAtom(n4, bl, n3, list, mp4BoxHeader3, mp4BoxHeader4);
        long l2 = mp4BoxHeader3.getFileEndPos();
        this.adjustSizeOfMoovHeader(mp4BoxHeader3, byteBuffer, n3, mp4BoxHeader, mp4BoxHeader2);
        fileChannel2.write(mp4BoxHeader3.getHeaderData());
        byteBuffer.rewind();
        byteBuffer.limit(n2);
        fileChannel2.write(byteBuffer);
        fileChannel2.write(byteBuffer2);
        if (mp4BoxHeader5 != null) {
            fileChannel.position((long)(n5 + (n6 + n7)));
            this.writeFromEndOfIlstToNeroTagsAndMakeNeroFree(l2, fileChannel, fileChannel2, mp4BoxHeader5);
        } else {
            byteBuffer.limit(byteBuffer.capacity());
            byteBuffer.position(n5 + (n2 + n7));
            fileChannel2.write(byteBuffer);
            fileChannel.position(mp4BoxHeader3.getFileEndPos() - (long)n3);
        }
        if (!bl2) {
            this.adjustFreeAtom(fileChannel, fileChannel2, n4, n3);
        } else {
            logger.config("Writing:Option 9;Top Level Free comes after Mdat or before Metadata or not large enough");
        }
        this.writeDataInChunks(fileChannel, fileChannel2);
    }

    private void writeMetadataSameSize(FileChannel fileChannel, FileChannel fileChannel2, Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer, Mp4BoxHeader mp4BoxHeader2) throws CannotWriteException, IOException {
        logger.config("Writing:Option 1:Same Size");
        fileChannel.position(0L);
        fileChannel2.transferFrom((ReadableByteChannel)fileChannel, 0L, mp4BoxHeader.getFilePos());
        fileChannel2.position(mp4BoxHeader.getFilePos());
        fileChannel2.write(byteBuffer);
        fileChannel.position(mp4BoxHeader.getFileEndPos());
        this.writeDataAfterIlst(fileChannel, fileChannel2, mp4BoxHeader2);
    }

    private void writeNeroData(FileChannel fileChannel, FileChannel fileChannel2, Mp4BoxHeader mp4BoxHeader) throws IOException, CannotWriteException {
        long l2 = mp4BoxHeader.getFilePos() - fileChannel.position();
        fileChannel2.transferFrom((ReadableByteChannel)fileChannel, fileChannel2.position(), l2);
        fileChannel2.position(l2 + fileChannel2.position());
        this.convertandWriteTagsAtomToFreeAtom(fileChannel2, mp4BoxHeader);
        fileChannel.position(mp4BoxHeader.getFileEndPos());
        this.writeDataInChunks(fileChannel, fileChannel2);
    }

    private void writeNewMetadataLargerButCanUseFreeAtom(FileChannel fileChannel, FileChannel fileChannel2, Mp4BoxHeader mp4BoxHeader, Mp4BoxHeader mp4BoxHeader2, int n2, ByteBuffer byteBuffer, int n3) throws IOException, CannotWriteException {
        int n4 = n2 - n3;
        Logger logger = Mp4TagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Writing:Option 5;Larger Size can use meta free atom need extra:");
        stringBuilder.append(n4);
        stringBuilder.append("bytes");
        logger.config(stringBuilder.toString());
        this.writeDataUptoIncludingIlst(fileChannel, fileChannel2, mp4BoxHeader, byteBuffer);
        Mp4FreeBox mp4FreeBox = new Mp4FreeBox(n4 - 8);
        fileChannel2.write(mp4FreeBox.getHeader().getHeaderData());
        fileChannel2.write(mp4FreeBox.getData());
        fileChannel.position(fileChannel.position() + (long)n2);
        this.writeDataAfterIlst(fileChannel, fileChannel2, mp4BoxHeader2);
    }

    private void writeNoExistingMetaAtom(Mp4BoxHeader mp4BoxHeader, FileChannel fileChannel, FileChannel fileChannel2, ByteBuffer byteBuffer, Mp4BoxHeader mp4BoxHeader2, ByteBuffer byteBuffer2, Mp4BoxHeader mp4BoxHeader3, List<Mp4StcoBox> list, int n2, boolean bl, Mp4BoxHeader mp4BoxHeader4, int n3, int n4, int n5, int n6, int n7) throws IOException, CannotWriteException {
        logger.severe("Writing:Option 5.2;No meta atom");
        long l2 = mp4BoxHeader2.getFileEndPos();
        int n8 = byteBuffer.limit();
        int n9 = mp4BoxHeader2.getDataLength();
        int n10 = mp4BoxHeader.getLength();
        int n11 = mp4BoxHeader.getDataLength();
        Mp4HdlrBox mp4HdlrBox = Mp4HdlrBox.createiTunesStyleHdlrBox();
        Mp4MetaBox mp4MetaBox = Mp4MetaBox.createiTunesStyleMetaBox((int)(n8 + mp4HdlrBox.getHeader().getLength()));
        Mp4BoxHeader mp4BoxHeader5 = new Mp4BoxHeader(Mp4AtomIdentifier.UDTA.getFieldName());
        mp4BoxHeader5.setLength(n11 + (8 + mp4MetaBox.getHeader().getLength()));
        int n12 = mp4BoxHeader5.getDataLength() - n11;
        boolean bl2 = this.adjustStcosIfNoSuitableTopLevelAtom(n2, bl, n12, list, mp4BoxHeader2, mp4BoxHeader3);
        mp4BoxHeader2.setLength(n12 + mp4BoxHeader2.getLength());
        fileChannel2.write(mp4BoxHeader2.getHeaderData());
        byteBuffer2.rewind();
        byteBuffer2.limit(n9 - n10);
        fileChannel2.write(byteBuffer2);
        fileChannel2.write(mp4BoxHeader5.getHeaderData());
        if (8 + byteBuffer2.position() < byteBuffer2.capacity()) {
            byteBuffer2.limit(byteBuffer2.capacity());
            byteBuffer2.position(8 + byteBuffer2.position());
            fileChannel2.write(byteBuffer2);
        }
        fileChannel2.write(mp4MetaBox.getHeader().getHeaderData());
        fileChannel2.write(mp4MetaBox.getData());
        fileChannel2.write(mp4HdlrBox.getHeader().getHeaderData());
        fileChannel2.write(mp4HdlrBox.getData());
        fileChannel2.write(byteBuffer);
        fileChannel.position((long)(n3 + (n4 + n5)));
        if (mp4BoxHeader4 != null) {
            this.writeFromEndOfIlstToNeroTagsAndMakeNeroFree(l2, fileChannel, fileChannel2, mp4BoxHeader4);
        } else {
            long l3 = l2 - fileChannel.position();
            fileChannel2.transferFrom((ReadableByteChannel)fileChannel, fileChannel2.position(), l3);
            fileChannel2.position(l3 + fileChannel2.position());
        }
        if (!bl2) {
            this.adjustFreeAtom(fileChannel, fileChannel2, n6, n7);
        } else {
            logger.config("Writing:Option 9;Top Level Free comes after Mdat or before Metadata or not large enough");
        }
        this.writeDataInChunks(fileChannel, fileChannel2);
    }

    private void writeNoExistingUdtaAtom(FileChannel fileChannel, FileChannel fileChannel2, ByteBuffer byteBuffer, Mp4BoxHeader mp4BoxHeader, ByteBuffer byteBuffer2, Mp4BoxHeader mp4BoxHeader2, List<Mp4StcoBox> list, int n2, boolean bl, Mp4BoxHeader mp4BoxHeader3, int n3, int n4, int n5, int n6, int n7) throws IOException, CannotWriteException {
        logger.severe("Writing:Option 5.1;No udta atom");
        long l2 = mp4BoxHeader.getFileEndPos();
        Mp4HdlrBox mp4HdlrBox = Mp4HdlrBox.createiTunesStyleHdlrBox();
        Mp4MetaBox mp4MetaBox = Mp4MetaBox.createiTunesStyleMetaBox((int)(mp4HdlrBox.getHeader().getLength() + byteBuffer.limit()));
        Mp4BoxHeader mp4BoxHeader4 = new Mp4BoxHeader(Mp4AtomIdentifier.UDTA.getFieldName());
        mp4BoxHeader4.setLength(8 + mp4MetaBox.getHeader().getLength());
        boolean bl2 = this.adjustStcosIfNoSuitableTopLevelAtom(n2, bl, mp4BoxHeader4.getLength(), list, mp4BoxHeader, mp4BoxHeader2);
        mp4BoxHeader.setLength(mp4BoxHeader.getLength() + mp4BoxHeader4.getLength());
        fileChannel2.write(mp4BoxHeader.getHeaderData());
        byteBuffer2.rewind();
        fileChannel2.write(byteBuffer2);
        fileChannel2.write(mp4BoxHeader4.getHeaderData());
        fileChannel2.write(mp4MetaBox.getHeader().getHeaderData());
        fileChannel2.write(mp4MetaBox.getData());
        fileChannel2.write(mp4HdlrBox.getHeader().getHeaderData());
        fileChannel2.write(mp4HdlrBox.getData());
        fileChannel2.write(byteBuffer);
        fileChannel.position((long)(n3 + (n4 + n5)));
        if (mp4BoxHeader3 != null) {
            this.writeFromEndOfIlstToNeroTagsAndMakeNeroFree(l2, fileChannel, fileChannel2, mp4BoxHeader3);
        } else {
            long l3 = l2 - fileChannel.position();
            fileChannel2.transferFrom((ReadableByteChannel)fileChannel, fileChannel2.position(), l3);
            fileChannel2.position(l3 + fileChannel2.position());
        }
        if (!bl2) {
            this.adjustFreeAtom(fileChannel, fileChannel2, n6, n7);
        } else {
            logger.config("Writing:Option 9;Top Level Free comes after Mdat or before Metadata or not large enough");
        }
        this.writeDataInChunks(fileChannel, fileChannel2);
    }

    private void writeOldMetadataLargerThanNewMetadata(FileChannel fileChannel, FileChannel fileChannel2, Mp4BoxHeader mp4BoxHeader, Mp4BoxHeader mp4BoxHeader2, Mp4BoxHeader mp4BoxHeader3, Mp4BoxHeader mp4BoxHeader4, Mp4BoxHeader mp4BoxHeader5, Mp4BoxHeader mp4BoxHeader6, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, List<Mp4StcoBox> list, int n2) throws IOException, CannotWriteException {
        logger.config("Writing:Option 1:Smaller Size");
        int n3 = (int)(mp4BoxHeader4.getFilePos() - (8L + mp4BoxHeader.getFilePos()));
        int n4 = byteBuffer2.limit();
        if (n2 > 0) {
            Logger logger = Mp4TagWriter.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Writing:Option 2:Smaller Size have free atom:");
            stringBuilder.append(mp4BoxHeader4.getLength());
            stringBuilder.append(":");
            stringBuilder.append(n4);
            logger.config(stringBuilder.toString());
            this.writeDataUptoIncludingIlst(fileChannel, fileChannel2, mp4BoxHeader4, byteBuffer2);
            Mp4FreeBox mp4FreeBox = new Mp4FreeBox(-8 + (n2 + (mp4BoxHeader4.getLength() - n4)));
            fileChannel2.write(mp4FreeBox.getHeader().getHeaderData());
            fileChannel2.write(mp4FreeBox.getData());
            fileChannel.position(fileChannel.position() + (long)n2);
            this.writeDataAfterIlst(fileChannel, fileChannel2, mp4BoxHeader6);
            return;
        }
        int n5 = -8 + (mp4BoxHeader4.getLength() - n4);
        if (n5 > 0) {
            logger.config("Writing:Option 3:Smaller Size can create free atom");
            this.writeDataUptoIncludingIlst(fileChannel, fileChannel2, mp4BoxHeader4, byteBuffer2);
            Mp4FreeBox mp4FreeBox = new Mp4FreeBox(n5);
            fileChannel2.write(mp4FreeBox.getHeader().getHeaderData());
            fileChannel2.write(mp4FreeBox.getData());
            this.writeDataAfterIlst(fileChannel, fileChannel2, mp4BoxHeader6);
            return;
        }
        logger.config("Writing:Option 4:Smaller Size <=8 cannot create free atoms");
        int n6 = mp4BoxHeader4.getLength() - n4;
        fileChannel.position(0L);
        fileChannel2.transferFrom((ReadableByteChannel)fileChannel, 0L, mp4BoxHeader.getFilePos());
        fileChannel2.position(mp4BoxHeader.getFilePos());
        if (mp4BoxHeader5.getFilePos() > mp4BoxHeader.getFilePos()) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((Mp4StcoBox)iterator.next()).adjustOffsets(-n6);
            }
        }
        this.adjustSizeOfMoovHeader(mp4BoxHeader, byteBuffer, -n6, mp4BoxHeader2, mp4BoxHeader3);
        fileChannel2.write(mp4BoxHeader.getHeaderData());
        byteBuffer.rewind();
        byteBuffer.limit(n3);
        fileChannel2.write(byteBuffer);
        fileChannel2.write(byteBuffer2);
        byteBuffer.limit(byteBuffer.capacity());
        byteBuffer.position(n3 + mp4BoxHeader4.getLength());
        fileChannel2.write(byteBuffer);
        fileChannel.position(mp4BoxHeader.getFileEndPos() + (long)n6);
        this.writeDataAfterIlst(fileChannel, fileChannel2, mp4BoxHeader6);
    }

    private void writeUpToMoovHeader(FileChannel fileChannel, FileChannel fileChannel2, Mp4BoxHeader mp4BoxHeader) throws IOException, CannotWriteException {
        fileChannel.position(0L);
        fileChannel2.transferFrom((ReadableByteChannel)fileChannel, 0L, mp4BoxHeader.getFilePos());
        fileChannel2.position(mp4BoxHeader.getFilePos());
    }

    public void delete(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws IOException {
        Mp4Tag mp4Tag = new Mp4Tag();
        try {
            this.write((Tag)mp4Tag, randomAccessFile, randomAccessFile2);
            return;
        }
        catch (CannotWriteException cannotWriteException) {
            throw new IOException(cannotWriteException.getMessage());
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void write(Tag var1_1, RandomAccessFile var2_2, RandomAccessFile var3_3) throws CannotWriteException, IOException {
        block24 : {
            block23 : {
                block17 : {
                    block21 : {
                        block22 : {
                            block18 : {
                                block19 : {
                                    block20 : {
                                        Mp4TagWriter.logger.config("Started writing tag data");
                                        var4_4 = var2_2.getChannel();
                                        var5_5 = var3_3.getChannel();
                                        try {
                                            var6_6 = new Mp4AtomTree(var2_2, false);
                                        }
                                        catch (CannotReadException var64_60) {
                                            throw new CannotWriteException(var64_60.getMessage());
                                        }
                                        var7_7 = var6_6.getBoxHeader(var6_6.getMdatNode());
                                        if (var7_7 == null) throw new CannotWriteException(ErrorMessage.MP4_CHANGES_TO_FILE_FAILED_CANNOT_FIND_AUDIO.getMsg());
                                        var8_8 = this.tc.convert(var1_1);
                                        var8_8.rewind();
                                        var10_9 = var8_8.limit();
                                        var11_10 = var6_6.getBoxHeader(var6_6.getMoovNode());
                                        var12_11 = var6_6.getStcos();
                                        var13_12 = var6_6.getBoxHeader(var6_6.getIlstNode());
                                        var14_13 = var6_6.getBoxHeader(var6_6.getUdtaNode());
                                        var15_14 = var6_6.getBoxHeader(var6_6.getMetaNode());
                                        var16_15 = var6_6.getBoxHeader(var6_6.getHdlrWithinMetaNode());
                                        var17_16 = var6_6.getBoxHeader(var6_6.getTagsNode());
                                        var18_17 = var6_6.getTrakNodes();
                                        var19_18 = var6_6.getTrakNodes().size();
                                        var20_19 = true;
                                        var21_20 = var6_6.getBoxHeader((DefaultMutableTreeNode)var18_17.get(var19_18 - 1));
                                        var22_21 = var6_6.getMoovBuffer();
                                        if (var14_13 == null) break block18;
                                        if (var15_14 == null) break block19;
                                        if (var13_12 == null) break block20;
                                        var62_22 = var13_12.getLength();
                                        var23_23 = var10_9;
                                        var63_24 = (int)var13_12.getFilePos();
                                        var24_25 = var22_21;
                                        var27_26 = (int)((long)var63_24 - (8L + var11_10.getFilePos()));
                                        var28_27 = var63_24;
                                        var29_28 = var62_22;
                                        break block21;
                                    }
                                    var23_23 = var10_9;
                                    var24_25 = var22_21;
                                    if (var16_15 != null) {
                                        var25_29 = (int)var16_15.getFileEndPos();
                                        var56_30 = var25_29;
                                        var58_31 = var11_10.getFilePos();
                                    } else {
                                        var25_29 = 4 + (8 + (int)var15_14.getFilePos());
                                        var56_30 = var25_29;
                                        var58_31 = var11_10.getFilePos();
                                    }
                                    ** GOTO lbl61
                                }
                                var23_23 = var10_9;
                                var24_25 = var22_21;
                                var60_32 = -8 + var11_10.getLength();
                                var61_33 = (int)var11_10.getFileEndPos();
                                var27_26 = var60_32;
                                var28_27 = var61_33;
                                break block22;
                            }
                            var23_23 = var10_9;
                            var24_25 = var22_21;
                            if (var15_14 != null) {
                                var25_29 = (int)var21_20.getFileEndPos();
                                var56_30 = var25_29;
                                var58_31 = var11_10.getFilePos();
lbl61: // 3 sources:
                                var26_34 = (int)(var56_30 - (var58_31 + 8L));
                            } else {
                                var25_29 = (int)var11_10.getFileEndPos();
                                var26_34 = -8 + var11_10.getLength();
                            }
                            var27_26 = var26_34;
                            var28_27 = var25_29;
                        }
                        var29_28 = 0;
                    }
                    var30_35 = this.getMetaLevelFreeAtomSize(var6_6);
                    for (DefaultMutableTreeNode var53_37 : var6_6.getFreeNodes()) {
                        if (!((DefaultMutableTreeNode)var53_37.getParent()).isRoot()) continue;
                        var54_38 = (Mp4BoxHeader)var53_37.getUserObject();
                        var55_39 = var54_38.getLength();
                        var32_40 = (int)var54_38.getFilePos();
                        var33_41 = var55_39;
                        break block17;
                    }
                    var32_40 = 0;
                    var33_41 = 0;
                }
                if (var33_41 > 0) {
                    var51_42 = var32_40;
                    if (var51_42 > var7_7.getFilePos() || var51_42 < var11_10.getFilePos()) {
                        var34_43 = var32_40;
                        var20_19 = false;
                    } else {
                        var34_43 = var32_40;
                    }
                } else {
                    var34_43 = (int)var7_7.getFilePos();
                }
                Mp4TagWriter.logger.config("Read header successfully ready for writing");
                var35_44 = var23_23;
                if (var29_28 != var35_44) break block23;
                this.writeMetadataSameSize(var4_4, var5_5, var13_12, var8_8, var17_16);
                var36_45 = var12_11;
                var37_46 = var7_7;
                ** GOTO lbl110
            }
            if (var29_28 <= var35_44) break block24;
            var50_48 = var24_25;
            var36_45 = var12_11;
            var37_46 = var7_7;
            this.writeOldMetadataLargerThanNewMetadata(var4_4, var5_5, var11_10, var14_13, var15_14, var13_12, var7_7, var17_16, var50_48, var8_8, var36_45, var30_35);
            ** GOTO lbl110
        }
        var36_45 = var12_11;
        var37_46 = var7_7;
        var38_49 = var35_44 - var29_28;
        if (var38_49 <= var30_35 - 8) {
            this.writeNewMetadataLargerButCanUseFreeAtom(var4_4, var5_5, var13_12, var17_16, var30_35, var8_8, var38_49);
lbl110: // 3 sources:
            var41_47 = var5_5;
        } else {
            var39_50 = var38_49 - var30_35;
            this.writeUpToMoovHeader(var4_4, var5_5, var11_10);
            if (var14_13 == null) {
                var43_51 = var24_25;
                var44_52 = var37_46;
                var45_53 = var36_45;
                var46_54 = var33_41;
                var47_55 = var29_28;
                var48_56 = var20_19;
                var49_57 = var28_27;
                var41_47 = var5_5;
                this.writeNoExistingUdtaAtom(var4_4, var5_5, var8_8, var11_10, var43_51, var44_52, var45_53, var46_54, var48_56, var17_16, var30_35, var49_57, var47_55, var34_43, var39_50);
            } else {
                var40_58 = var29_28;
                var41_47 = var5_5;
                if (var15_14 == null) {
                    this.writeNoExistingMetaAtom(var14_13, var4_4, var41_47, var8_8, var11_10, var24_25, var37_46, var36_45, var33_41, var20_19, var17_16, var30_35, var28_27, var40_58, var34_43, var39_50);
                } else {
                    this.writeHaveExistingMetadata(var14_13, var15_14, var4_4, var41_47, var27_26, var11_10, var24_25, var37_46, var36_45, var39_50, var33_41, var20_19, var8_8, var17_16, var30_35, var28_27, var40_58);
                }
            }
        }
        var4_4.close();
        var2_2.close();
        var42_59 = var36_45;
        this.checkFileWrittenCorrectly(var3_3, var37_46, var41_47, var42_59);
        return;
    }
}

