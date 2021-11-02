/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.MappedByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.channels.FileChannel$MapMode
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.flac.FlacTagCreator
 *  org.jaudiotagger.tag.flac.FlacTag
 *  org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag
 */
package org.jaudiotagger.audio.flac;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.flac.FlacStreamReader;
import org.jaudiotagger.audio.flac.FlacTagCreator;
import org.jaudiotagger.audio.flac.metadatablock.BlockType;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlock;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockData;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockHeader;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.flac.FlacTag;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;
import org.jaudiotagger.utils.DirectByteBufferUtils;
import org.jaudiotagger.utils.PrimitiveUtils;

public class FlacTagWriter {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.flac");
    private FlacTagCreator tc = new FlacTagCreator();

    private int computeAvailableRoom(MetadataBlockInfo metadataBlockInfo) {
        Iterator iterator = metadataBlockInfo.metadataBlockApplication.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += ((MetadataBlock)iterator.next()).getLength();
        }
        Iterator iterator2 = metadataBlockInfo.metadataBlockSeekTable.iterator();
        while (iterator2.hasNext()) {
            n2 += ((MetadataBlock)iterator2.next()).getLength();
        }
        Iterator iterator3 = metadataBlockInfo.metadataBlockCueSheet.iterator();
        while (iterator3.hasNext()) {
            n2 += ((MetadataBlock)iterator3.next()).getLength();
        }
        Iterator iterator4 = metadataBlockInfo.metadataBlockPadding.iterator();
        while (iterator4.hasNext()) {
            n2 += ((MetadataBlock)iterator4.next()).getLength();
        }
        return n2;
    }

    private int computeNeededRoom(MetadataBlockInfo metadataBlockInfo) {
        Iterator iterator = metadataBlockInfo.metadataBlockApplication.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += ((MetadataBlock)iterator.next()).getLength();
        }
        Iterator iterator2 = metadataBlockInfo.metadataBlockSeekTable.iterator();
        while (iterator2.hasNext()) {
            n2 += ((MetadataBlock)iterator2.next()).getLength();
        }
        Iterator iterator3 = metadataBlockInfo.metadataBlockCueSheet.iterator();
        while (iterator3.hasNext()) {
            n2 += ((MetadataBlock)iterator3.next()).getLength();
        }
        return n2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void insertTagAndShift(File file, Tag tag, FileChannel fileChannel, MetadataBlockInfo metadataBlockInfo, FlacStreamReader flacStreamReader, int n2, int n3) throws IOException, UnsupportedEncodingException {
        MappedByteBuffer mappedByteBuffer;
        void var14_15;
        block5 : {
            int n4 = 34 + (4 + (4 + flacStreamReader.getStartOfFlacInFile()));
            long l2 = 4000 + (n4 + n2);
            long l3 = l2 + (fileChannel.size() - (long)(n4 + n3));
            mappedByteBuffer = null;
            MappedByteBuffer mappedByteBuffer2 = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, l3);
            try {
                this.insertTagAndShiftViaMappedByteBuffer(tag, mappedByteBuffer2, fileChannel, l2, l3, metadataBlockInfo, flacStreamReader, n2, n3);
                return;
            }
            catch (IOException iOException) {
                mappedByteBuffer = mappedByteBuffer2;
            }
            break block5;
            catch (IOException iOException) {
                // empty catch block
            }
        }
        if (mappedByteBuffer == null) {
            this.insertUsingChunks(file, tag, fileChannel, metadataBlockInfo, flacStreamReader, n2 + 4000, n3);
            return;
        }
        logger.log(Level.SEVERE, var14_15.getMessage(), (Throwable)var14_15);
        throw var14_15;
    }

    private void insertTagAndShiftViaMappedByteBuffer(Tag tag, MappedByteBuffer mappedByteBuffer, FileChannel fileChannel, long l2, long l3, MetadataBlockInfo metadataBlockInfo, FlacStreamReader flacStreamReader, int n2, int n3) throws IOException, UnsupportedEncodingException {
        int n4;
        int n5 = PrimitiveUtils.safeLongToInt(fileChannel.size());
        int n6 = PrimitiveUtils.safeLongToInt(l2 - 4000L - (long)n2 + (long)n3);
        int n7 = PrimitiveUtils.safeLongToInt(l3 - (long)n5);
        int n8 = PrimitiveUtils.safeLongToInt(TagOptionSingleton.getInstance().getWriteChunkSize());
        byte[] arrby = new byte[n8];
        for (n4 = n5 - n8; n4 >= n6; n4 -= n8) {
            mappedByteBuffer.position(n4);
            mappedByteBuffer.get(arrby, 0, n8);
            mappedByteBuffer.position(n4 + n7);
            mappedByteBuffer.put(arrby, 0, n8);
        }
        int n9 = n4 + n8 - n6;
        if (n9 > 0) {
            mappedByteBuffer.position(n6);
            mappedByteBuffer.get(arrby, 0, n9);
            mappedByteBuffer.position(n6 + n7);
            mappedByteBuffer.put(arrby, 0, n9);
        }
        DirectByteBufferUtils.release((Buffer)mappedByteBuffer);
        this.writeTags(tag, fileChannel, metadataBlockInfo, flacStreamReader);
    }

    private void insertUsingChunks(File file, Tag tag, FileChannel fileChannel, MetadataBlockInfo metadataBlockInfo, FlacStreamReader flacStreamReader, int n2, int n3) throws IOException, UnsupportedEncodingException {
        long l2 = fileChannel.size();
        long l3 = n3 + (34 + (4 + (4 + flacStreamReader.getStartOfFlacInFile())));
        int n4 = n2 - n3;
        Logger logger = FlacTagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)file);
        stringBuilder.append(" Audio needs shifting:");
        stringBuilder.append(n4);
        logger.config(stringBuilder.toString());
        int n5 = (int)TagOptionSingleton.getInstance().getWriteChunkSize();
        if (n5 >= n4) {
            n4 = n5;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        fileChannel.position(l3);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)n4);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        linkedBlockingQueue.add((Object)byteBuffer);
        long l4 = fileChannel.position();
        fileChannel.position((long)(4 + flacStreamReader.getStartOfFlacInFile()));
        this.writeOtherMetadataBlocks(fileChannel, metadataBlockInfo);
        fileChannel.write(this.tc.convert(tag, 4000));
        long l5 = fileChannel.position();
        fileChannel.position(l4);
        while (fileChannel.position() < l2) {
            ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect((int)n4);
            fileChannel.read(byteBuffer2);
            long l6 = fileChannel.position();
            byteBuffer2.flip();
            linkedBlockingQueue.add((Object)byteBuffer2);
            fileChannel.position(l5);
            fileChannel.write((ByteBuffer)linkedBlockingQueue.remove());
            l5 = fileChannel.position();
            fileChannel.position(l6);
        }
        fileChannel.position(l5);
        fileChannel.write((ByteBuffer)linkedBlockingQueue.remove());
    }

    private void insertUsingDirectBuffer(File file, Tag tag, FileChannel fileChannel, MetadataBlockInfo metadataBlockInfo, FlacStreamReader flacStreamReader, int n2) throws IOException {
        fileChannel.position((long)(n2 + (34 + (4 + (4 + flacStreamReader.getStartOfFlacInFile())))));
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)((int)(fileChannel.size() - fileChannel.position())));
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        fileChannel.position((long)(4 + flacStreamReader.getStartOfFlacInFile()));
        this.writeOtherMetadataBlocks(fileChannel, metadataBlockInfo);
        fileChannel.write(this.tc.convert(tag, 4000));
        fileChannel.write(byteBuffer);
    }

    private void writeOtherMetadataBlocks(FileChannel fileChannel, MetadataBlockInfo metadataBlockInfo) throws IOException {
        fileChannel.write(ByteBuffer.wrap((byte[])metadataBlockInfo.streamInfoBlock.getHeader().getBytesWithoutIsLastBlockFlag()));
        fileChannel.write(metadataBlockInfo.streamInfoBlock.getData().getBytes());
        for (MetadataBlock metadataBlock : metadataBlockInfo.metadataBlockApplication) {
            fileChannel.write(ByteBuffer.wrap((byte[])metadataBlock.getHeader().getBytesWithoutIsLastBlockFlag()));
            fileChannel.write(metadataBlock.getData().getBytes());
        }
        for (MetadataBlock metadataBlock : metadataBlockInfo.metadataBlockSeekTable) {
            fileChannel.write(ByteBuffer.wrap((byte[])metadataBlock.getHeader().getBytesWithoutIsLastBlockFlag()));
            fileChannel.write(metadataBlock.getData().getBytes());
        }
        for (MetadataBlock metadataBlock : metadataBlockInfo.metadataBlockCueSheet) {
            fileChannel.write(ByteBuffer.wrap((byte[])metadataBlock.getHeader().getBytesWithoutIsLastBlockFlag()));
            fileChannel.write(metadataBlock.getData().getBytes());
        }
    }

    private void writeTags(Tag tag, FileChannel fileChannel, MetadataBlockInfo metadataBlockInfo, FlacStreamReader flacStreamReader) throws IOException, UnsupportedEncodingException {
        fileChannel.position((long)(4 + flacStreamReader.getStartOfFlacInFile()));
        this.writeOtherMetadataBlocks(fileChannel, metadataBlockInfo);
        fileChannel.write(this.tc.convert(tag, 4000));
    }

    public void delete(Tag tag, File file) throws CannotWriteException {
        this.write((Tag)new FlacTag(null, (List)new ArrayList()), file);
    }

    /*
     * Exception decompiling
     */
    public void write(Tag var1_1, File var2_2) throws CannotWriteException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 14[CATCHBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    private static class MetadataBlockInfo {
        private List<MetadataBlock> metadataBlockApplication = new ArrayList(1);
        private List<MetadataBlock> metadataBlockCueSheet = new ArrayList(1);
        private List<MetadataBlock> metadataBlockPadding = new ArrayList(1);
        private List<MetadataBlock> metadataBlockSeekTable = new ArrayList(1);
        private MetadataBlock streamInfoBlock;

        private MetadataBlockInfo() {
        }

        static /* synthetic */ MetadataBlock access$102(MetadataBlockInfo metadataBlockInfo, MetadataBlock metadataBlock) {
            metadataBlockInfo.streamInfoBlock = metadataBlock;
            return metadataBlock;
        }
    }

}

