/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.RandomAccessFile
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.Channels
 *  java.nio.channels.FileChannel
 *  java.nio.channels.FileLock
 *  java.nio.channels.ReadableByteChannel
 *  java.nio.channels.WritableByteChannel
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.Map
 *  java.util.NoSuchElementException
 *  java.util.Set
 *  java.util.TreeSet
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.UnableToCreateFileException;
import org.jaudiotagger.audio.exceptions.UnableToModifyFileException;
import org.jaudiotagger.audio.exceptions.UnableToRenameFileException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.logging.FileSystemMessage;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.datatype.Pair;
import org.jaudiotagger.tag.datatype.PairedTextEncodedStringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractID3Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.AggregatedFrame;
import org.jaudiotagger.tag.id3.ID3Frames;
import org.jaudiotagger.tag.id3.ID3SyncSafeInteger;
import org.jaudiotagger.tag.id3.ID3v22Frames;
import org.jaudiotagger.tag.id3.ID3v23Frames;
import org.jaudiotagger.tag.id3.ID3v24Frames;
import org.jaudiotagger.tag.id3.TyerTdatAggregatedFrame;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyNumberTotal;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyPairs;
import org.jaudiotagger.tag.id3.framebody.AbstractFrameBodyTextInfo;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyCOMM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyEncrypted;
import org.jaudiotagger.tag.id3.framebody.FrameBodyIPLS;
import org.jaudiotagger.tag.id3.framebody.FrameBodyPIC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyPOPM;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIPL;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTMCL;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTXXX;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUFID;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUSLT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUnsupported;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWOAR;
import org.jaudiotagger.tag.id3.framebody.FrameBodyWXXX;
import org.jaudiotagger.tag.id3.valuepair.ID3NumberTotalFields;
import org.jaudiotagger.tag.id3.valuepair.StandardIPLSKey;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.reference.PictureTypes;

public abstract class AbstractID3v2Tag
extends AbstractID3Tag
implements Tag {
    public static final int FIELD_TAGID_LENGTH = 3;
    protected static final int FIELD_TAGID_POS = 0;
    public static final int FIELD_TAG_FLAG_LENGTH = 1;
    protected static final int FIELD_TAG_FLAG_POS = 5;
    public static final int FIELD_TAG_MAJOR_VERSION_LENGTH = 1;
    public static final int FIELD_TAG_MAJOR_VERSION_POS = 3;
    public static final int FIELD_TAG_MINOR_VERSION_LENGTH = 1;
    protected static final int FIELD_TAG_MINOR_VERSION_POS = 4;
    public static final int FIELD_TAG_SIZE_LENGTH = 4;
    protected static final int FIELD_TAG_SIZE_POS = 6;
    private static final long MAXIMUM_WRITABLE_CHUNK_SIZE = 10000000L;
    public static final String TAGID = "ID3";
    public static final int TAG_HEADER_LENGTH = 10;
    public static final byte[] TAG_ID = new byte[]{73, 68, 51};
    protected static final int TAG_SIZE_INCREMENT = 100;
    protected static final String TYPE_BODY = "body";
    protected static final String TYPE_DUPLICATEBYTES = "duplicateBytes";
    protected static final String TYPE_DUPLICATEFRAMEID = "duplicateFrameId";
    protected static final String TYPE_EMPTYFRAMEBYTES = "emptyFrameBytes";
    protected static final String TYPE_FILEREADSIZE = "fileReadSize";
    protected static final String TYPE_HEADER = "header";
    protected static final String TYPE_INVALIDFRAMES = "invalidFrames";
    protected int duplicateBytes = 0;
    protected String duplicateFrameId = "";
    protected int emptyFrameBytes = 0;
    public HashMap<String, Object> encryptedFrameMap = null;
    private Long endLocationInFile = null;
    protected int fileReadSize = 0;
    public HashMap<String, Object> frameMap = null;
    protected int invalidFrames = 0;
    private Long startLocationInFile = null;

    public AbstractID3v2Tag() {
    }

    protected AbstractID3v2Tag(AbstractID3v2Tag abstractID3v2Tag) {
    }

    private void addNewFrameOrAddField(List<TagField> list, HashMap hashMap, AbstractID3v2Frame abstractID3v2Frame, AbstractID3v2Frame abstractID3v2Frame2) {
        ArrayList arrayList = new ArrayList();
        if (abstractID3v2Frame != null) {
            arrayList.add((Object)abstractID3v2Frame);
        } else {
            arrayList.addAll(list);
        }
        boolean bl = abstractID3v2Frame2.getBody() instanceof FrameBodyTXXX;
        boolean bl2 = true;
        if (bl) {
            block16 : {
                FrameBodyTXXX frameBodyTXXX = (FrameBodyTXXX)abstractID3v2Frame2.getBody();
                ListIterator listIterator = arrayList.listIterator();
                while (listIterator.hasNext()) {
                    FrameBodyTXXX frameBodyTXXX2 = (FrameBodyTXXX)((AbstractID3v2Frame)listIterator.next()).getBody();
                    if (!frameBodyTXXX.getDescription().equals((Object)frameBodyTXXX2.getDescription())) continue;
                    frameBodyTXXX2.addTextValue(frameBodyTXXX.getText());
                    break block16;
                }
                bl2 = false;
            }
            if (!bl2) {
                this.addNewFrameToMap(list, hashMap, abstractID3v2Frame, abstractID3v2Frame2);
                return;
            }
        } else if (abstractID3v2Frame2.getBody() instanceof FrameBodyWXXX) {
            block17 : {
                FrameBodyWXXX frameBodyWXXX = (FrameBodyWXXX)abstractID3v2Frame2.getBody();
                ListIterator listIterator = arrayList.listIterator();
                while (listIterator.hasNext()) {
                    FrameBodyWXXX frameBodyWXXX2 = (FrameBodyWXXX)((AbstractID3v2Frame)listIterator.next()).getBody();
                    if (!frameBodyWXXX.getDescription().equals((Object)frameBodyWXXX2.getDescription())) continue;
                    frameBodyWXXX2.addUrlLink(frameBodyWXXX.getUrlLink());
                    break block17;
                }
                bl2 = false;
            }
            if (!bl2) {
                this.addNewFrameToMap(list, hashMap, abstractID3v2Frame, abstractID3v2Frame2);
                return;
            }
        } else {
            if (abstractID3v2Frame2.getBody() instanceof AbstractFrameBodyTextInfo) {
                AbstractFrameBodyTextInfo abstractFrameBodyTextInfo = (AbstractFrameBodyTextInfo)abstractID3v2Frame2.getBody();
                ((AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody()).addTextValue(abstractFrameBodyTextInfo.getText());
                return;
            }
            if (abstractID3v2Frame2.getBody() instanceof AbstractFrameBodyPairs) {
                AbstractFrameBodyPairs abstractFrameBodyPairs = (AbstractFrameBodyPairs)abstractID3v2Frame2.getBody();
                ((AbstractFrameBodyPairs)abstractID3v2Frame.getBody()).addPair(abstractFrameBodyPairs.getText());
                return;
            }
            if (abstractID3v2Frame2.getBody() instanceof AbstractFrameBodyNumberTotal) {
                AbstractFrameBodyNumberTotal abstractFrameBodyNumberTotal = (AbstractFrameBodyNumberTotal)abstractID3v2Frame2.getBody();
                AbstractFrameBodyNumberTotal abstractFrameBodyNumberTotal2 = (AbstractFrameBodyNumberTotal)abstractID3v2Frame.getBody();
                if (abstractFrameBodyNumberTotal.getNumber() != null && abstractFrameBodyNumberTotal.getNumber() > 0) {
                    abstractFrameBodyNumberTotal2.setNumber(abstractFrameBodyNumberTotal.getNumberAsText());
                }
                if (abstractFrameBodyNumberTotal.getTotal() != null && abstractFrameBodyNumberTotal.getTotal() > 0) {
                    abstractFrameBodyNumberTotal2.setTotal(abstractFrameBodyNumberTotal.getTotalAsText());
                    return;
                }
            } else {
                this.addNewFrameToMap(list, hashMap, abstractID3v2Frame, abstractID3v2Frame2);
            }
        }
    }

    private void addNewFrameToMap(List<TagField> list, HashMap hashMap, AbstractID3v2Frame abstractID3v2Frame, AbstractID3v2Frame abstractID3v2Frame2) {
        if (list.size() == 0) {
            list.add((Object)abstractID3v2Frame);
            list.add((Object)abstractID3v2Frame2);
            hashMap.put((Object)abstractID3v2Frame2.getId(), list);
            return;
        }
        list.add((Object)abstractID3v2Frame2);
    }

    private void deleteNumberTotalFrame(FrameAndSubId frameAndSubId, FieldKey fieldKey, FieldKey fieldKey2, boolean bl) {
        Integer n2 = 0;
        if (bl) {
            if (this.getFirst(fieldKey2).length() == 0) {
                this.doDeleteTagField(frameAndSubId);
                return;
            }
            ((AbstractFrameBodyNumberTotal)((AbstractID3v2Frame)this.getFrame(frameAndSubId.getFrameId())).getBody()).setNumber(n2);
            return;
        }
        if (this.getFirst(fieldKey).length() == 0) {
            this.doDeleteTagField(frameAndSubId);
            return;
        }
        ((AbstractFrameBodyNumberTotal)((AbstractID3v2Frame)this.getFrame(frameAndSubId.getFrameId())).getBody()).setTotal(n2);
    }

    private String getTextValueForFrame(AbstractID3v2Frame abstractID3v2Frame) {
        return abstractID3v2Frame.getBody().getUserFriendlyValue();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static long getV2TagSizeIfExists(File file) throws IOException {
        FileChannel fileChannel;
        FileInputStream fileInputStream;
        void var3_9;
        block8 : {
            ByteBuffer byteBuffer;
            block7 : {
                fileChannel = null;
                fileInputStream = new FileInputStream(file);
                try {
                    fileChannel = fileInputStream.getChannel();
                    byteBuffer = ByteBuffer.allocate((int)10);
                    fileChannel.read(byteBuffer);
                    byteBuffer.flip();
                    int n2 = byteBuffer.limit();
                    if (n2 >= 10) break block7;
                }
                catch (Throwable throwable) {}
                fileChannel.close();
                fileInputStream.close();
                return 0L;
            }
            fileChannel.close();
            fileInputStream.close();
            byte[] arrby = new byte[3];
            byteBuffer.get(arrby, 0, 3);
            if (!Arrays.equals((byte[])arrby, (byte[])TAG_ID)) {
                return 0L;
            }
            byte by = byteBuffer.get();
            if (by != 2 && by != 3 && by != 4) {
                return 0L;
            }
            byteBuffer.get();
            byteBuffer.get();
            return 10 + ID3SyncSafeInteger.bufferToValue(byteBuffer);
            break block8;
            catch (Throwable throwable) {
                fileInputStream = null;
            }
        }
        if (fileChannel != null) {
            fileChannel.close();
        }
        if (fileInputStream == null) throw var3_9;
        fileInputStream.close();
        throw var3_9;
    }

    private static boolean isID3V2Header(RandomAccessFile randomAccessFile) throws IOException {
        long l2 = randomAccessFile.getFilePointer();
        byte[] arrby = new byte[3];
        randomAccessFile.read(arrby);
        randomAccessFile.seek(l2);
        return Arrays.equals((byte[])arrby, (byte[])TAG_ID);
    }

    private static boolean isID3V2Header(FileChannel fileChannel) throws IOException {
        long l2 = fileChannel.position();
        ByteBuffer byteBuffer = Utils.readFileDataIntoBufferBE(fileChannel, 3);
        fileChannel.position(l2);
        return Utils.readThreeBytesAsChars(byteBuffer).equals((Object)TAGID);
    }

    public static boolean isId3Tag(RandomAccessFile randomAccessFile) throws IOException {
        if (!AbstractID3v2Tag.isID3V2Header(randomAccessFile)) {
            return false;
        }
        byte[] arrby = new byte[4];
        randomAccessFile.seek(1L + (1L + (1L + (3L + randomAccessFile.getFilePointer()))));
        randomAccessFile.read(arrby);
        randomAccessFile.seek((long)(10 + ID3SyncSafeInteger.bufferToValue(ByteBuffer.wrap((byte[])arrby))));
        return true;
    }

    public static boolean isId3Tag(FileChannel fileChannel) throws IOException {
        if (!AbstractID3v2Tag.isID3V2Header(fileChannel)) {
            return false;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)4);
        fileChannel.position(1L + (1L + (1L + (3L + fileChannel.position()))));
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        fileChannel.position((long)(10 + ID3SyncSafeInteger.bufferToValue(byteBuffer)));
        return true;
    }

    private void replaceFile(File file, File file2) throws IOException {
        String string2 = file.getAbsoluteFile().getParentFile().getPath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AudioFile.getBaseFilename(file));
        stringBuilder.append(".old");
        File file3 = new File(string2, stringBuilder.toString());
        int n2 = 1;
        while (file3.exists()) {
            String string3 = file.getAbsoluteFile().getParentFile().getPath();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(AudioFile.getBaseFilename(file));
            stringBuilder2.append(".old");
            stringBuilder2.append(n2);
            file3 = new File(string3, stringBuilder2.toString());
            ++n2;
        }
        if (file.renameTo(file3)) {
            if (!file2.renameTo(file)) {
                if (!file2.exists()) {
                    Logger logger = AbstractID3Tag.logger;
                    ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_NEW_FILE_DOESNT_EXIST;
                    Object[] arrobject = new Object[]{file2.getAbsolutePath()};
                    logger.warning(errorMessage.getMsg(arrobject));
                }
                if (!file3.renameTo(file)) {
                    Logger logger = AbstractID3Tag.logger;
                    ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_RENAME_ORIGINAL_BACKUP_TO_ORIGINAL;
                    Object[] arrobject = new Object[]{file3.getAbsolutePath(), file.getName()};
                    logger.warning(errorMessage.getMsg(arrobject));
                }
                Logger logger = AbstractID3Tag.logger;
                ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_RENAME_TO_ORIGINAL_FILE;
                Object[] arrobject = new Object[]{file.getAbsolutePath(), file2.getName()};
                logger.warning(errorMessage.getMsg(arrobject));
                file2.delete();
                Object[] arrobject2 = new Object[]{file.getAbsolutePath(), file2.getName()};
                throw new UnableToRenameFileException(errorMessage.getMsg(arrobject2));
            }
            if (!file3.delete()) {
                Logger logger = AbstractID3Tag.logger;
                ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_WARNING_UNABLE_TO_DELETE_BACKUP_FILE;
                Object[] arrobject = new Object[]{file3.getAbsolutePath()};
                logger.warning(errorMessage.getMsg(arrobject));
            }
            return;
        }
        Logger logger = AbstractID3Tag.logger;
        ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_RENAME_ORIGINAL_FILE_TO_BACKUP;
        Object[] arrobject = new Object[]{file.getAbsolutePath(), file3.getName()};
        logger.warning(errorMessage.getMsg(arrobject));
        file2.delete();
        Object[] arrobject3 = new Object[]{file.getAbsolutePath(), file3.getName()};
        throw new UnableToRenameFileException(errorMessage.getMsg(arrobject3));
    }

    private void writeFramesToBufferStream(Map map, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        TreeSet treeSet = new TreeSet(this.getPreferredFrameOrderComparator());
        treeSet.addAll((Collection)map.keySet());
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Object object = map.get((Object)((String)iterator.next()));
            if (object instanceof AbstractID3v2Frame) {
                AbstractID3v2Frame abstractID3v2Frame = (AbstractID3v2Frame)object;
                abstractID3v2Frame.setLoggingFilename(this.getLoggingFilename());
                abstractID3v2Frame.write(byteArrayOutputStream);
                continue;
            }
            if (object instanceof AggregatedFrame) {
                for (AbstractID3v2Frame abstractID3v2Frame : ((AggregatedFrame)object).getFrames()) {
                    abstractID3v2Frame.setLoggingFilename(this.getLoggingFilename());
                    abstractID3v2Frame.write(byteArrayOutputStream);
                }
                continue;
            }
            for (AbstractID3v2Frame abstractID3v2Frame : (List)object) {
                abstractID3v2Frame.setLoggingFilename(this.getLoggingFilename());
                abstractID3v2Frame.write(byteArrayOutputStream);
            }
        }
    }

    @Override
    public /* varargs */ void addField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        this.addField(this.createField(fieldKey, arrstring));
    }

    @Override
    public void addField(TagField tagField) throws FieldDataInvalidException {
        if (tagField == null) {
            return;
        }
        boolean bl = tagField instanceof AbstractID3v2Frame;
        if (!bl && !(tagField instanceof AggregatedFrame)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field ");
            stringBuilder.append((Object)tagField);
            stringBuilder.append(" is not of type AbstractID3v2Frame or AggregatedFrame");
            throw new FieldDataInvalidException(stringBuilder.toString());
        }
        if (bl) {
            AbstractID3v2Frame abstractID3v2Frame = (AbstractID3v2Frame)tagField;
            Object object = this.frameMap.get((Object)tagField.getId());
            if (object == null) {
                this.frameMap.put((Object)tagField.getId(), (Object)tagField);
                return;
            }
            if (object instanceof List) {
                this.addNewFrameOrAddField((List<TagField>)((List)object), this.frameMap, null, abstractID3v2Frame);
                return;
            }
            AbstractID3v2Frame abstractID3v2Frame2 = (AbstractID3v2Frame)object;
            this.addNewFrameOrAddField((List<TagField>)new ArrayList(), this.frameMap, abstractID3v2Frame2, abstractID3v2Frame);
            return;
        }
        this.frameMap.put((Object)tagField.getId(), (Object)tagField);
    }

    @Override
    public void addField(Artwork artwork) throws FieldDataInvalidException {
        this.addField(this.createField(artwork));
    }

    protected abstract void addFrame(AbstractID3v2Frame var1);

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void adjustPadding(File var1_1, int var2_2, long var3_3) throws FileNotFoundException, IOException {
        AbstractID3Tag.logger.finer("Need to move audio file to accommodate tag");
        var5_4 = ByteBuffer.wrap((byte[])new byte[var2_2]);
        var15_5 = File.createTempFile((String)Utils.getBaseFilenameForTempFile(var1_1), (String)".new", (File)var1_1.getParentFile());
        var16_6 = AbstractID3Tag.logger;
        var17_7 = new StringBuilder();
        var17_7.append("Created temp file:");
        var17_7.append(var15_5.getName());
        var17_7.append(" for ");
        var17_7.append(var1_1.getName());
        var16_6.finest(var17_7.toString());
        {
            catch (IOException var6_71) {
                AbstractID3Tag.logger.log(Level.SEVERE, var6_71.getMessage(), (Throwable)var6_71);
                if (var6_71.getMessage().equals((Object)FileSystemMessage.ACCESS_IS_DENIED.getMsg())) {
                    var11_72 = AbstractID3Tag.logger;
                    var12_73 = ErrorMessage.GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER;
                    var13_74 = new Object[]{var1_1.getName(), var1_1.getParentFile().getPath()};
                    var11_72.severe(var12_73.getMsg(var13_74));
                    var14_75 = new Object[]{var1_1.getName(), var1_1.getParentFile().getPath()};
                    throw new UnableToCreateFileException(var12_73.getMsg(var14_75));
                }
                var7_76 = AbstractID3Tag.logger;
                var8_77 = ErrorMessage.GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER;
                var9_78 = new Object[]{var1_1.getName(), var1_1.getParentFile().getPath()};
                var7_76.severe(var8_77.getMsg(var9_78));
                var10_79 = new Object[]{var1_1.getName(), var1_1.getParentFile().getPath()};
                throw new UnableToCreateFileException(var8_77.getMsg(var10_79));
            }
        }
        var27_8 = new FileOutputStream(var15_5).getChannel();
        var28_9 = null;
        {
            catch (FileNotFoundException var22_66) {
                AbstractID3Tag.logger.log(Level.SEVERE, var22_66.getMessage(), (Throwable)var22_66);
                var23_67 = AbstractID3Tag.logger;
                var24_68 = ErrorMessage.GENERAL_WRITE_FAILED_TO_MODIFY_TEMPORARY_FILE_IN_FOLDER;
                var25_69 = new Object[]{var1_1.getName(), var1_1.getParentFile().getPath()};
                var23_67.severe(var24_68.getMsg(var25_69));
                var26_70 = new Object[]{var1_1.getName(), var1_1.getParentFile().getPath()};
                throw new UnableToModifyFileException(var24_68.getMsg(var26_70));
            }
        }
        var40_10 = new FileInputStream(var1_1).getChannel();
        var43_11 = var27_8.write(var5_4);
        var45_12 = AbstractID3Tag.logger;
        var46_13 = new StringBuilder();
        var46_13.append("Copying:");
        var46_13.append(var1_1.length() - var3_3);
        var46_13.append("bytes");
        var45_12.finer(var46_13.toString());
        var50_14 = var1_1.length();
        var52_15 = var50_14 - var3_3;
        if (var52_15 > 10000000L) ** GOTO lbl71
        var40_10.position(var3_3);
        var95_16 = var2_2;
        var54_17 = var15_5;
        var30_18 = var27_8;
        var41_19 = var40_10;
        var97_20 = var27_8.transferFrom((ReadableByteChannel)var40_10, var95_16, var52_15);
        var99_21 = AbstractID3Tag.logger;
        var100_22 = new StringBuilder();
        var100_22.append("Written padding:");
        var100_22.append(var43_11);
        var100_22.append(" Data:");
        var100_22.append(var97_20);
        var99_21.finer(var100_22.toString());
        if (var97_20 != var52_15) {
            var105_23 = ErrorMessage.MP3_UNABLE_TO_ADJUST_PADDING;
            var106_24 = new Object[]{var52_15, var97_20};
            throw new RuntimeException(var105_23.getMsg(var106_24));
        }
        ** GOTO lbl124
lbl71: // 1 sources:
        var54_17 = var15_5;
        var30_18 = var27_8;
        var41_19 = var40_10;
        var55_25 = var52_15 / 10000000L;
        var57_26 = var52_15 % 10000000L;
        var59_27 = 0L;
        var61_28 = 0;
        ** GOTO lbl101
        catch (Throwable var42_50) {
            var30_18 = var27_8;
            var41_19 = var40_10;
            ** GOTO lbl155
        }
        catch (UnableToRenameFileException var29_54) {
            var30_18 = var27_8;
            var41_19 = var40_10;
            ** GOTO lbl159
        }
        catch (Throwable var31_59) {
            block40 : {
                block36 : {
                    block38 : {
                        block37 : {
                            block39 : {
                                var30_18 = var27_8;
                                break block40;
                                catch (UnableToRenameFileException var29_56) {
                                    var30_18 = var27_8;
                                    break block36;
                                }
                                catch (Throwable var42_51) {
                                    var30_18 = var27_8;
                                    var41_19 = var40_10;
                                    break block37;
                                }
                                catch (UnableToRenameFileException var29_57) {
                                    var30_18 = var27_8;
                                    var41_19 = var40_10;
                                    break block38;
                                }
lbl101: // 2 sources:
                                while ((var62_33 = (long)var61_28) < var55_25) {
                                    var88_29 = var3_3 + var62_33 * 10000000L;
                                    var90_30 = var41_19;
                                    var91_31 = var61_28;
                                    var92_32 = var90_30.transferTo(var88_29, 10000000L, (WritableByteChannel)var30_18);
                                    var59_27 += var92_32;
                                    var61_28 = var91_31 + 1;
                                }
                                Long.signum((long)var55_25);
                                var65_34 = var3_3 + var55_25 * 10000000L;
                                var67_35 = var41_19;
                                var68_36 = var30_18;
                                var69_37 = var59_27 + var67_35.transferTo(var65_34, var57_26, (WritableByteChannel)var68_36);
                                var71_38 = AbstractID3Tag.logger;
                                var72_39 = new StringBuilder();
                                var72_39.append("Written padding:");
                                var72_39.append(var43_11);
                                var72_39.append(" Data:");
                                var72_39.append(var69_37);
                                var71_38.finer(var72_39.toString());
                                if (var69_37 != var52_15) break block39;
lbl124: // 2 sources:
                                var79_40 = var1_1.lastModified();
                                if (var41_19 != null && var41_19.isOpen()) {
                                    var41_19.close();
                                }
                                if (var30_18.isOpen()) {
                                    var30_18.close();
                                }
                                var15_5 = var54_17;
                                this.replaceFile(var1_1, var15_5);
                                var15_5.setLastModified(var79_40);
                                if (var41_19 == null) ** GOTO lbl137
                                if (var41_19.isOpen()) {
                                    var41_19.close();
                                }
lbl137: // 4 sources:
                                if (var30_18.isOpen() == false) return;
                                var30_18.close();
                                return;
                            }
                            var15_5 = var54_17;
                            try {
                                var77_45 = ErrorMessage.MP3_UNABLE_TO_ADJUST_PADDING;
                                var78_46 = new Object[]{var52_15, var69_37};
                                throw new RuntimeException(var77_45.getMsg(var78_46));
                            }
                            catch (Throwable var42_47) {}
                            catch (UnableToRenameFileException var29_52) {}
                            finally {
                                break block37;
                            }
                            catch (Throwable var42_48) {
                                break block37;
                            }
                            catch (UnableToRenameFileException var29_53) {
                                var15_5 = var54_17;
                                break block38;
                            }
                        }
                        var32_58 = var42_49;
                        var28_9 = var41_19;
                    }
                    var28_9 = var41_19;
                }
                try {
                    var15_5.delete();
                    throw var29_55;
                }
                catch (Throwable var31_61) {}
            }
            var32_58 = var31_60;
        }
        if (var28_9 == null) ** GOTO lbl172
        try {
            if (var28_9.isOpen()) {
                var28_9.close();
            }
lbl172: // 4 sources:
            if (var30_18 == null) throw var32_58;
            if (var30_18.isOpen() == false) throw var32_58;
            var30_18.close();
            throw var32_58;
        }
        catch (Exception var33_62) {}
        catch (Exception var82_41) {}
        var83_42 = AbstractID3Tag.logger;
        var84_43 = Level.WARNING;
        var85_44 = new StringBuilder();
        var85_44.append("Problem closing channels and locks:");
        var85_44.append(var82_41.getMessage());
        var83_42.log(var84_43, var85_44.toString(), (Throwable)var82_41);
        return;
        var34_63 = AbstractID3Tag.logger;
        var35_64 = Level.WARNING;
        var36_65 = new StringBuilder();
        var36_65.append("Problem closing channels and locks:");
        var36_65.append(var33_62.getMessage());
        var34_63.log(var35_64, var36_65.toString(), (Throwable)var33_62);
        throw var32_58;
    }

    protected int calculateTagSize(int n2, int n3) {
        if (n2 <= n3) {
            return n3;
        }
        return n2 + 100;
    }

    protected abstract List<AbstractID3v2Frame> convertFrame(AbstractID3v2Frame var1) throws InvalidFrameException;

    protected final void copyFrameIntoMap(String string2, AbstractID3v2Frame abstractID3v2Frame) {
        if (this.frameMap.containsKey((Object)abstractID3v2Frame.getIdentifier())) {
            Object object = this.frameMap.get((Object)abstractID3v2Frame.getIdentifier());
            if (object instanceof AbstractID3v2Frame) {
                this.processDuplicateFrame(abstractID3v2Frame, (AbstractID3v2Frame)object);
                return;
            }
            if (object instanceof AggregatedFrame) {
                Logger logger = AbstractID3Tag.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Duplicated Aggregate Frame, ignoring:");
                stringBuilder.append(string2);
                logger.severe(stringBuilder.toString());
                return;
            }
            if (object instanceof List) {
                ((List)object).add((Object)abstractID3v2Frame);
                return;
            }
            Logger logger = AbstractID3Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown frame class:discarding:");
            stringBuilder.append((Object)object.getClass());
            logger.severe(stringBuilder.toString());
            return;
        }
        this.frameMap.put((Object)abstractID3v2Frame.getIdentifier(), (Object)abstractID3v2Frame);
    }

    protected void copyFrames(AbstractID3v2Tag abstractID3v2Tag) {
        this.frameMap = new LinkedHashMap();
        this.encryptedFrameMap = new LinkedHashMap();
        for (String string2 : abstractID3v2Tag.frameMap.keySet()) {
            Object object = abstractID3v2Tag.frameMap.get((Object)string2);
            if (object instanceof AbstractID3v2Frame) {
                this.addFrame((AbstractID3v2Frame)object);
                continue;
            }
            if (object instanceof TyerTdatAggregatedFrame) {
                Iterator iterator = ((TyerTdatAggregatedFrame)object).getFrames().iterator();
                while (iterator.hasNext()) {
                    this.addFrame((AbstractID3v2Frame)iterator.next());
                }
                continue;
            }
            if (!(object instanceof ArrayList)) continue;
            Iterator iterator = ((ArrayList)object).iterator();
            while (iterator.hasNext()) {
                this.addFrame((AbstractID3v2Frame)iterator.next());
            }
        }
    }

    protected void copyPrimitives(AbstractID3v2Tag abstractID3v2Tag) {
        AbstractID3Tag.logger.config("Copying Primitives");
        this.duplicateFrameId = abstractID3v2Tag.duplicateFrameId;
        this.duplicateBytes = abstractID3v2Tag.duplicateBytes;
        this.emptyFrameBytes = abstractID3v2Tag.emptyFrameBytes;
        this.fileReadSize = abstractID3v2Tag.fileReadSize;
        this.invalidFrames = abstractID3v2Tag.invalidFrames;
    }

    @Override
    public TagField createCompilationField(boolean bl) throws KeyNotFoundException, FieldDataInvalidException {
        if (bl) {
            return this.createField(FieldKey.IS_COMPILATION, "1");
        }
        return this.createField(FieldKey.IS_COMPILATION, "0");
    }

    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (fieldKey != null) {
            if (arrstring != null && arrstring[0] != null) {
                String string2 = arrstring[0];
                FrameAndSubId frameAndSubId = this.getFrameAndSubIdFromGenericKey(fieldKey);
                if (ID3NumberTotalFields.isNumber(fieldKey)) {
                    AbstractID3v2Frame abstractID3v2Frame = this.createFrame(frameAndSubId.getFrameId());
                    ((AbstractFrameBodyNumberTotal)abstractID3v2Frame.getBody()).setNumber(string2);
                    return abstractID3v2Frame;
                }
                if (ID3NumberTotalFields.isTotal(fieldKey)) {
                    AbstractID3v2Frame abstractID3v2Frame = this.createFrame(frameAndSubId.getFrameId());
                    ((AbstractFrameBodyNumberTotal)abstractID3v2Frame.getBody()).setTotal(string2);
                    return abstractID3v2Frame;
                }
                return this.doCreateTagField(frameAndSubId, arrstring);
            }
            throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
        }
        throw new KeyNotFoundException();
    }

    public abstract AbstractID3v2Frame createFrame(String var1);

    public TagField createLinkedArtworkField(String string2) {
        AbstractID3v2Frame abstractID3v2Frame = this.createFrame(this.getFrameAndSubIdFromGenericKey(FieldKey.COVER_ART).getFrameId());
        if (abstractID3v2Frame.getBody() instanceof FrameBodyAPIC) {
            FrameBodyAPIC frameBodyAPIC = (FrameBodyAPIC)abstractID3v2Frame.getBody();
            frameBodyAPIC.setObjectValue("PictureData", string2.getBytes(StandardCharsets.ISO_8859_1));
            frameBodyAPIC.setObjectValue("PictureType", (Object)PictureTypes.DEFAULT_ID);
            frameBodyAPIC.setObjectValue("MIMEType", "-->");
            frameBodyAPIC.setObjectValue("Description", "");
            return abstractID3v2Frame;
        }
        if (abstractID3v2Frame.getBody() instanceof FrameBodyPIC) {
            FrameBodyPIC frameBodyPIC = (FrameBodyPIC)abstractID3v2Frame.getBody();
            frameBodyPIC.setObjectValue("PictureData", string2.getBytes(StandardCharsets.ISO_8859_1));
            frameBodyPIC.setObjectValue("PictureType", (Object)PictureTypes.DEFAULT_ID);
            frameBodyPIC.setObjectValue("ImageType", "-->");
            frameBodyPIC.setObjectValue("Description", "");
        }
        return abstractID3v2Frame;
    }

    public void createStructure() {
        this.createStructureHeader();
        this.createStructureBody();
    }

    public void createStructureBody() {
        MP3File.getStructureFormatter().openHeadingElement("body", "");
        for (Object object : this.frameMap.values()) {
            if (object instanceof AbstractID3v2Frame) {
                ((AbstractID3v2Frame)object).createStructure();
                continue;
            }
            ListIterator listIterator = ((ArrayList)object).listIterator();
            while (listIterator.hasNext()) {
                ((AbstractID3v2Frame)listIterator.next()).createStructure();
            }
        }
        MP3File.getStructureFormatter().closeHeadingElement("body");
    }

    public void createStructureHeader() {
        MP3File.getStructureFormatter().addElement("duplicateBytes", this.duplicateBytes);
        MP3File.getStructureFormatter().addElement("duplicateFrameId", this.duplicateFrameId);
        MP3File.getStructureFormatter().addElement("emptyFrameBytes", this.emptyFrameBytes);
        MP3File.getStructureFormatter().addElement("fileReadSize", this.fileReadSize);
        MP3File.getStructureFormatter().addElement("invalidFrames", this.invalidFrames);
    }

    @Override
    public void delete(RandomAccessFile randomAccessFile) throws IOException {
        byte[] arrby = new byte[3];
        FileChannel fileChannel = randomAccessFile.getChannel();
        fileChannel.position();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)10);
        fileChannel.read(byteBuffer, 0L);
        byteBuffer.flip();
        if (this.seek(byteBuffer)) {
            randomAccessFile.seek(0L);
            randomAccessFile.write(arrby);
        }
    }

    @Override
    public void deleteArtworkField() throws KeyNotFoundException {
        this.deleteField(FieldKey.COVER_ART);
    }

    @Override
    public void deleteField(FieldKey fieldKey) throws KeyNotFoundException {
        FrameAndSubId frameAndSubId = this.getFrameAndSubIdFromGenericKey(fieldKey);
        if (fieldKey != null) {
            switch (2.$SwitchMap$org$jaudiotagger$tag$FieldKey[fieldKey.ordinal()]) {
                default: {
                    this.doDeleteTagField(frameAndSubId);
                    return;
                }
                case 6: {
                    this.deleteNumberTotalFrame(frameAndSubId, FieldKey.MOVEMENT_NO, FieldKey.MOVEMENT_TOTAL, false);
                    return;
                }
                case 5: {
                    this.deleteNumberTotalFrame(frameAndSubId, FieldKey.MOVEMENT_NO, FieldKey.MOVEMENT_TOTAL, true);
                    return;
                }
                case 4: {
                    this.deleteNumberTotalFrame(frameAndSubId, FieldKey.DISC_NO, FieldKey.DISC_TOTAL, false);
                    return;
                }
                case 3: {
                    this.deleteNumberTotalFrame(frameAndSubId, FieldKey.DISC_NO, FieldKey.DISC_TOTAL, true);
                    return;
                }
                case 2: {
                    this.deleteNumberTotalFrame(frameAndSubId, FieldKey.TRACK, FieldKey.TRACK_TOTAL, false);
                    return;
                }
                case 1: 
            }
            this.deleteNumberTotalFrame(frameAndSubId, FieldKey.TRACK, FieldKey.TRACK_TOTAL, true);
            return;
        }
        throw new KeyNotFoundException();
    }

    protected /* varargs */ TagField doCreateTagField(FrameAndSubId frameAndSubId, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        String string2 = arrstring[0];
        AbstractID3v2Frame abstractID3v2Frame = this.createFrame(frameAndSubId.getFrameId());
        if (abstractID3v2Frame.getBody() instanceof FrameBodyUFID) {
            ((FrameBodyUFID)abstractID3v2Frame.getBody()).setOwner(frameAndSubId.getSubId());
            try {
                ((FrameBodyUFID)abstractID3v2Frame.getBody()).setUniqueIdentifier(string2.getBytes("ISO-8859-1"));
                return abstractID3v2Frame;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new RuntimeException("When encoding UFID charset ISO-8859-1 was deemed unsupported");
            }
        }
        if (abstractID3v2Frame.getBody() instanceof FrameBodyTXXX) {
            ((FrameBodyTXXX)abstractID3v2Frame.getBody()).setDescription(frameAndSubId.getSubId());
            ((FrameBodyTXXX)abstractID3v2Frame.getBody()).setText(string2);
            return abstractID3v2Frame;
        }
        if (abstractID3v2Frame.getBody() instanceof FrameBodyWXXX) {
            ((FrameBodyWXXX)abstractID3v2Frame.getBody()).setDescription(frameAndSubId.getSubId());
            ((FrameBodyWXXX)abstractID3v2Frame.getBody()).setUrlLink(string2);
            return abstractID3v2Frame;
        }
        if (abstractID3v2Frame.getBody() instanceof FrameBodyCOMM) {
            if (frameAndSubId.getSubId() != null) {
                ((FrameBodyCOMM)abstractID3v2Frame.getBody()).setDescription(frameAndSubId.getSubId());
                if (((FrameBodyCOMM)abstractID3v2Frame.getBody()).isMediaMonkeyFrame()) {
                    ((FrameBodyCOMM)abstractID3v2Frame.getBody()).setLanguage("XXX");
                }
            }
            ((FrameBodyCOMM)abstractID3v2Frame.getBody()).setText(string2);
            return abstractID3v2Frame;
        }
        if (abstractID3v2Frame.getBody() instanceof FrameBodyUSLT) {
            ((FrameBodyUSLT)abstractID3v2Frame.getBody()).setDescription("");
            ((FrameBodyUSLT)abstractID3v2Frame.getBody()).setLyric(string2);
            return abstractID3v2Frame;
        }
        if (abstractID3v2Frame.getBody() instanceof FrameBodyWOAR) {
            ((FrameBodyWOAR)abstractID3v2Frame.getBody()).setUrlLink(string2);
            return abstractID3v2Frame;
        }
        if (abstractID3v2Frame.getBody() instanceof AbstractFrameBodyTextInfo) {
            ((AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody()).setText(string2);
            return abstractID3v2Frame;
        }
        if (abstractID3v2Frame.getBody() instanceof FrameBodyPOPM) {
            ((FrameBodyPOPM)abstractID3v2Frame.getBody()).parseString(string2);
            return abstractID3v2Frame;
        }
        if (abstractID3v2Frame.getBody() instanceof FrameBodyIPLS) {
            if (frameAndSubId.getSubId() != null) {
                ((FrameBodyIPLS)abstractID3v2Frame.getBody()).addPair(frameAndSubId.getSubId(), string2);
                return abstractID3v2Frame;
            }
            if (arrstring.length >= 2) {
                ((FrameBodyIPLS)abstractID3v2Frame.getBody()).addPair(arrstring[0], arrstring[1]);
                return abstractID3v2Frame;
            }
            ((FrameBodyIPLS)abstractID3v2Frame.getBody()).addPair(arrstring[0]);
            return abstractID3v2Frame;
        }
        if (abstractID3v2Frame.getBody() instanceof FrameBodyTIPL) {
            ((FrameBodyTIPL)abstractID3v2Frame.getBody()).addPair(frameAndSubId.getSubId(), string2);
            return abstractID3v2Frame;
        }
        if (abstractID3v2Frame.getBody() instanceof FrameBodyTMCL) {
            if (arrstring.length >= 2) {
                ((FrameBodyTMCL)abstractID3v2Frame.getBody()).addPair(arrstring[0], arrstring[1]);
                return abstractID3v2Frame;
            }
            ((FrameBodyTMCL)abstractID3v2Frame.getBody()).addPair(arrstring[0]);
            return abstractID3v2Frame;
        }
        if (!(abstractID3v2Frame.getBody() instanceof FrameBodyAPIC) && !(abstractID3v2Frame.getBody() instanceof FrameBodyPIC)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field with key of:");
            stringBuilder.append(frameAndSubId.getFrameId());
            stringBuilder.append(":does not accept cannot parse data:");
            stringBuilder.append(string2);
            throw new FieldDataInvalidException(stringBuilder.toString());
        }
        throw new UnsupportedOperationException(ErrorMessage.ARTWORK_CANNOT_BE_CREATED_WITH_THIS_METHOD.getMsg());
    }

    protected void doDeleteTagField(FrameAndSubId frameAndSubId) throws KeyNotFoundException {
        if (frameAndSubId.getSubId() != null) {
            List<TagField> list = this.getFields(frameAndSubId.getFrameId());
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                AbstractTagFrameBody abstractTagFrameBody = ((AbstractID3v2Frame)listIterator.next()).getBody();
                if (abstractTagFrameBody instanceof FrameBodyTXXX) {
                    if (!((FrameBodyTXXX)abstractTagFrameBody).getDescription().equals((Object)frameAndSubId.getSubId())) continue;
                    if (list.size() == 1) {
                        this.removeFrame(frameAndSubId.getFrameId());
                        continue;
                    }
                    listIterator.remove();
                    continue;
                }
                if (abstractTagFrameBody instanceof FrameBodyCOMM) {
                    if (!((FrameBodyCOMM)abstractTagFrameBody).getDescription().equals((Object)frameAndSubId.getSubId())) continue;
                    if (list.size() == 1) {
                        this.removeFrame(frameAndSubId.getFrameId());
                        continue;
                    }
                    listIterator.remove();
                    continue;
                }
                if (abstractTagFrameBody instanceof FrameBodyWXXX) {
                    if (!((FrameBodyWXXX)abstractTagFrameBody).getDescription().equals((Object)frameAndSubId.getSubId())) continue;
                    if (list.size() == 1) {
                        this.removeFrame(frameAndSubId.getFrameId());
                        continue;
                    }
                    listIterator.remove();
                    continue;
                }
                if (abstractTagFrameBody instanceof FrameBodyUFID) {
                    if (!((FrameBodyUFID)abstractTagFrameBody).getOwner().equals((Object)frameAndSubId.getSubId())) continue;
                    if (list.size() == 1) {
                        this.removeFrame(frameAndSubId.getFrameId());
                        continue;
                    }
                    listIterator.remove();
                    continue;
                }
                if (abstractTagFrameBody instanceof FrameBodyTIPL) {
                    PairedTextEncodedStringNullTerminated.ValuePairs valuePairs = ((FrameBodyTIPL)abstractTagFrameBody).getPairing();
                    ListIterator listIterator2 = valuePairs.getMapping().listIterator();
                    while (listIterator2.hasNext()) {
                        if (!((Pair)listIterator2.next()).getKey().equals((Object)frameAndSubId.getSubId())) continue;
                        listIterator2.remove();
                    }
                    if (valuePairs.getMapping().size() != 0) continue;
                    this.removeFrame(frameAndSubId.getFrameId());
                    continue;
                }
                if (abstractTagFrameBody instanceof FrameBodyIPLS) {
                    PairedTextEncodedStringNullTerminated.ValuePairs valuePairs = ((FrameBodyIPLS)abstractTagFrameBody).getPairing();
                    ListIterator listIterator3 = valuePairs.getMapping().listIterator();
                    while (listIterator3.hasNext()) {
                        if (!((Pair)listIterator3.next()).getKey().equals((Object)frameAndSubId.getSubId())) continue;
                        listIterator3.remove();
                    }
                    if (valuePairs.getMapping().size() != 0) continue;
                    this.removeFrame(frameAndSubId.getFrameId());
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Need to implement getFields(FieldKey genericKey) for:");
                stringBuilder.append((Object)abstractTagFrameBody.getClass());
                throw new RuntimeException(stringBuilder.toString());
            }
        } else if (frameAndSubId.getGenericKey() != null && (frameAndSubId.getGenericKey() == FieldKey.PERFORMER || frameAndSubId.getGenericKey() == FieldKey.INVOLVED_PERSON)) {
            ListIterator listIterator = this.getFields(frameAndSubId.getFrameId()).listIterator();
            while (listIterator.hasNext()) {
                AbstractTagFrameBody abstractTagFrameBody = ((AbstractID3v2Frame)listIterator.next()).getBody();
                if (!(abstractTagFrameBody instanceof AbstractFrameBodyPairs)) continue;
                PairedTextEncodedStringNullTerminated.ValuePairs valuePairs = ((AbstractFrameBodyPairs)abstractTagFrameBody).getPairing();
                ListIterator listIterator4 = valuePairs.getMapping().listIterator();
                while (listIterator4.hasNext()) {
                    if (StandardIPLSKey.isKey(((Pair)listIterator4.next()).getKey())) continue;
                    listIterator4.remove();
                }
                if (valuePairs.getMapping().size() != 0) continue;
                this.removeFrame(frameAndSubId.getFrameId());
            }
        } else if (frameAndSubId.getSubId() == null) {
            this.removeFrame(frameAndSubId.getFrameId());
        }
    }

    protected String doGetValueAtIndex(FrameAndSubId frameAndSubId, int n2) throws KeyNotFoundException {
        List<String> list = this.doGetValues(frameAndSubId);
        if (list.size() > n2) {
            return (String)list.get(n2);
        }
        return "";
    }

    protected List<String> doGetValues(FrameAndSubId frameAndSubId) throws KeyNotFoundException {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (frameAndSubId.getSubId() != null) {
            ListIterator listIterator = this.getFields(frameAndSubId.getFrameId()).listIterator();
            while (listIterator.hasNext()) {
                AbstractTagFrameBody abstractTagFrameBody = ((AbstractID3v2Frame)listIterator.next()).getBody();
                if (abstractTagFrameBody instanceof FrameBodyTXXX) {
                    FrameBodyTXXX frameBodyTXXX = (FrameBodyTXXX)abstractTagFrameBody;
                    if (!frameBodyTXXX.getDescription().equals((Object)frameAndSubId.getSubId())) continue;
                    arrayList.addAll(frameBodyTXXX.getValues());
                    continue;
                }
                if (abstractTagFrameBody instanceof FrameBodyWXXX) {
                    FrameBodyWXXX frameBodyWXXX = (FrameBodyWXXX)abstractTagFrameBody;
                    if (!frameBodyWXXX.getDescription().equals((Object)frameAndSubId.getSubId())) continue;
                    arrayList.addAll(frameBodyWXXX.getUrlLinks());
                    continue;
                }
                if (abstractTagFrameBody instanceof FrameBodyCOMM) {
                    FrameBodyCOMM frameBodyCOMM = (FrameBodyCOMM)abstractTagFrameBody;
                    if (!frameBodyCOMM.getDescription().equals((Object)frameAndSubId.getSubId())) continue;
                    arrayList.addAll(frameBodyCOMM.getValues());
                    continue;
                }
                if (abstractTagFrameBody instanceof FrameBodyUFID) {
                    FrameBodyUFID frameBodyUFID = (FrameBodyUFID)abstractTagFrameBody;
                    if (!frameBodyUFID.getOwner().equals((Object)frameAndSubId.getSubId()) || frameBodyUFID.getUniqueIdentifier() == null) continue;
                    arrayList.add((Object)new String(frameBodyUFID.getUniqueIdentifier()));
                    continue;
                }
                if (abstractTagFrameBody instanceof AbstractFrameBodyPairs) {
                    for (Pair pair : ((AbstractFrameBodyPairs)abstractTagFrameBody).getPairing().getMapping()) {
                        if (!pair.getKey().equals((Object)frameAndSubId.getSubId()) || pair.getValue() == null) continue;
                        arrayList.add((Object)pair.getValue());
                    }
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Need to implement getFields(FieldKey genericKey) for:");
                stringBuilder.append((Object)abstractTagFrameBody.getClass());
                throw new RuntimeException(stringBuilder.toString());
            }
        } else if (frameAndSubId.getGenericKey() != null && (frameAndSubId.getGenericKey() == FieldKey.PERFORMER || frameAndSubId.getGenericKey() == FieldKey.INVOLVED_PERSON)) {
            ListIterator listIterator = this.getFields(frameAndSubId.getFrameId()).listIterator();
            while (listIterator.hasNext()) {
                AbstractTagFrameBody abstractTagFrameBody = ((AbstractID3v2Frame)listIterator.next()).getBody();
                if (!(abstractTagFrameBody instanceof AbstractFrameBodyPairs)) continue;
                for (Pair pair : ((AbstractFrameBodyPairs)abstractTagFrameBody).getPairing().getMapping()) {
                    if (StandardIPLSKey.isKey(pair.getKey()) || pair.getValue().isEmpty()) continue;
                    if (!pair.getKey().isEmpty()) {
                        arrayList.add((Object)pair.getPairValue());
                        continue;
                    }
                    arrayList.add((Object)pair.getValue());
                }
            }
        } else {
            Iterator iterator = this.getFields(frameAndSubId.getFrameId()).iterator();
            while (iterator.hasNext()) {
                AbstractID3v2Frame abstractID3v2Frame = (AbstractID3v2Frame)((TagField)iterator.next());
                if (abstractID3v2Frame == null) continue;
                if (abstractID3v2Frame.getBody() instanceof AbstractFrameBodyTextInfo) {
                    arrayList.addAll(((AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody()).getValues());
                    continue;
                }
                arrayList.add((Object)this.getTextValueForFrame(abstractID3v2Frame));
            }
        }
        return arrayList;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AbstractID3v2Tag)) {
            return false;
        }
        AbstractID3v2Tag abstractID3v2Tag = (AbstractID3v2Tag)object;
        boolean bl = this.frameMap.equals(abstractID3v2Tag.frameMap);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = AbstractTag.super.equals(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        ArrayList arrayList = new ArrayList();
        List<TagField> list = this.getFields(fieldKey);
        if (ID3NumberTotalFields.isNumber(fieldKey)) {
            if (list != null && list.size() > 0) {
                arrayList.add((Object)((AbstractFrameBodyNumberTotal)((AbstractID3v2Frame)list.get(0)).getBody()).getNumberAsText());
            }
            return arrayList;
        }
        if (ID3NumberTotalFields.isTotal(fieldKey)) {
            if (list != null && list.size() > 0) {
                arrayList.add((Object)((AbstractFrameBodyNumberTotal)((AbstractID3v2Frame)list.get(0)).getBody()).getTotalAsText());
            }
            return arrayList;
        }
        if (fieldKey == FieldKey.RATING) {
            if (list != null && list.size() > 0) {
                arrayList.add((Object)String.valueOf((long)((FrameBodyPOPM)((AbstractID3v2Frame)list.get(0)).getBody()).getRating()));
            }
            return arrayList;
        }
        return this.doGetValues(this.getFrameAndSubIdFromGenericKey(fieldKey));
    }

    public int getDuplicateBytes() {
        return this.duplicateBytes;
    }

    public String getDuplicateFrameId() {
        return this.duplicateFrameId;
    }

    public int getEmptyFrameBytes() {
        return this.emptyFrameBytes;
    }

    public Object getEncryptedFrame(String string2) {
        return this.encryptedFrameMap.get((Object)string2);
    }

    public Long getEndLocationInFile() {
        return this.endLocationInFile;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public int getFieldCount() {
        Iterator<TagField> iterator = this.getFields();
        int n2 = 0;
        try {
            do {
                (TagField)iterator.next();
                ++n2;
            } while (true);
        }
        catch (NoSuchElementException noSuchElementException) {
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public int getFieldCountIncludingSubValues() {
        Iterator<TagField> iterator = this.getFields();
        int n2 = 0;
        try {
            do {
                TagField tagField;
                AbstractID3v2Frame abstractID3v2Frame;
                if ((tagField = (TagField)iterator.next()) instanceof AbstractID3v2Frame && (abstractID3v2Frame = (AbstractID3v2Frame)tagField).getBody() instanceof AbstractFrameBodyTextInfo && !(abstractID3v2Frame.getBody() instanceof FrameBodyTXXX)) {
                    int n3 = ((AbstractFrameBodyTextInfo)abstractID3v2Frame.getBody()).getNumberOfValues();
                    n2 += n3;
                    continue;
                }
                ++n2;
            } while (true);
        }
        catch (NoSuchElementException noSuchElementException) {
            return n2;
        }
    }

    @Override
    public Iterator<TagField> getFields() {
        return new Iterator<TagField>(this, this.frameMap.entrySet().iterator(), this.frameMap.entrySet().iterator()){
            private Iterator<TagField> fieldsIt;
            java.util.Map$Entry<String, Object> latestEntry;
            final /* synthetic */ AbstractID3v2Tag this$0;
            final /* synthetic */ Iterator val$it;
            final /* synthetic */ Iterator val$itHasNext;
            {
                this.this$0 = abstractID3v2Tag;
                this.val$it = iterator;
                this.val$itHasNext = iterator2;
                this.latestEntry = null;
            }

            private void changeIt() {
                if (!this.val$it.hasNext()) {
                    return;
                }
                while (this.val$it.hasNext()) {
                    java.util.Map$Entry entry = (java.util.Map$Entry)this.val$it.next();
                    this.latestEntry = (java.util.Map$Entry)this.val$itHasNext.next();
                    if (entry.getValue() instanceof List) {
                        List list = (List)entry.getValue();
                        if (list.size() == 0) continue;
                        this.fieldsIt = list.iterator();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add((Object)((TagField)entry.getValue()));
                    this.fieldsIt = arrayList.iterator();
                    break;
                }
            }

            public boolean hasNext() {
                Iterator<TagField> iterator = this.fieldsIt;
                if (iterator != null && iterator.hasNext()) {
                    return true;
                }
                if (!this.val$itHasNext.hasNext()) {
                    return false;
                }
                return this.val$itHasNext.hasNext();
            }

            public TagField next() {
                Iterator<TagField> iterator;
                Iterator<TagField> iterator2;
                if (this.fieldsIt == null) {
                    this.changeIt();
                }
                if ((iterator = this.fieldsIt) != null && !iterator.hasNext()) {
                    this.changeIt();
                }
                if ((iterator2 = this.fieldsIt) != null) {
                    return (TagField)iterator2.next();
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                this.fieldsIt.remove();
            }
        };
    }

    @Override
    public List<TagField> getFields(String string2) throws KeyNotFoundException {
        Object object = this.getFrame(string2);
        if (object == null) {
            return new ArrayList();
        }
        if (object instanceof List) {
            return (List)object;
        }
        if (object instanceof AbstractID3v2Frame) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)((TagField)object));
            return arrayList;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Found entry in frameMap that was not a frame or a list:");
        stringBuilder.append(object);
        throw new RuntimeException(stringBuilder.toString());
    }

    @Override
    public List<TagField> getFields(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey != null) {
            FrameAndSubId frameAndSubId = this.getFrameAndSubIdFromGenericKey(fieldKey);
            List<TagField> list = this.getFields(frameAndSubId.getFrameId());
            ArrayList arrayList = new ArrayList();
            if (frameAndSubId.getSubId() != null) {
                for (TagField tagField : list) {
                    AbstractTagFrameBody abstractTagFrameBody = ((AbstractID3v2Frame)tagField).getBody();
                    if (abstractTagFrameBody instanceof FrameBodyTXXX) {
                        if (!((FrameBodyTXXX)abstractTagFrameBody).getDescription().equals((Object)frameAndSubId.getSubId())) continue;
                        arrayList.add((Object)tagField);
                        continue;
                    }
                    if (abstractTagFrameBody instanceof FrameBodyWXXX) {
                        if (!((FrameBodyWXXX)abstractTagFrameBody).getDescription().equals((Object)frameAndSubId.getSubId())) continue;
                        arrayList.add((Object)tagField);
                        continue;
                    }
                    if (abstractTagFrameBody instanceof FrameBodyCOMM) {
                        if (!((FrameBodyCOMM)abstractTagFrameBody).getDescription().equals((Object)frameAndSubId.getSubId())) continue;
                        arrayList.add((Object)tagField);
                        continue;
                    }
                    if (abstractTagFrameBody instanceof FrameBodyUFID) {
                        if (!((FrameBodyUFID)abstractTagFrameBody).getOwner().equals((Object)frameAndSubId.getSubId())) continue;
                        arrayList.add((Object)tagField);
                        continue;
                    }
                    if (abstractTagFrameBody instanceof FrameBodyIPLS) {
                        Iterator iterator = ((FrameBodyIPLS)abstractTagFrameBody).getPairing().getMapping().iterator();
                        while (iterator.hasNext()) {
                            if (!((Pair)iterator.next()).getKey().equals((Object)frameAndSubId.getSubId())) continue;
                            arrayList.add((Object)tagField);
                        }
                        continue;
                    }
                    if (abstractTagFrameBody instanceof FrameBodyTIPL) {
                        Iterator iterator = ((FrameBodyTIPL)abstractTagFrameBody).getPairing().getMapping().iterator();
                        while (iterator.hasNext()) {
                            if (!((Pair)iterator.next()).getKey().equals((Object)frameAndSubId.getSubId())) continue;
                            arrayList.add((Object)tagField);
                        }
                        continue;
                    }
                    if (abstractTagFrameBody instanceof FrameBodyUnsupported) {
                        return list;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Need to implement getFields(FieldKey genericKey) for:");
                    stringBuilder.append((Object)abstractTagFrameBody.getClass());
                    throw new RuntimeException(stringBuilder.toString());
                }
                return arrayList;
            }
            if (ID3NumberTotalFields.isNumber(fieldKey)) {
                for (TagField tagField : list) {
                    AbstractTagFrameBody abstractTagFrameBody = ((AbstractID3v2Frame)tagField).getBody();
                    if (!(abstractTagFrameBody instanceof AbstractFrameBodyNumberTotal) || ((AbstractFrameBodyNumberTotal)abstractTagFrameBody).getNumber() == null) continue;
                    arrayList.add((Object)tagField);
                }
                return arrayList;
            }
            if (ID3NumberTotalFields.isTotal(fieldKey)) {
                for (TagField tagField : list) {
                    AbstractTagFrameBody abstractTagFrameBody = ((AbstractID3v2Frame)tagField).getBody();
                    if (!(abstractTagFrameBody instanceof AbstractFrameBodyNumberTotal) || ((AbstractFrameBodyNumberTotal)abstractTagFrameBody).getTotal() == null) continue;
                    arrayList.add((Object)tagField);
                }
                return arrayList;
            }
            return list;
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    protected FileLock getFileLockForWriting(FileChannel fileChannel, String string2) throws IOException {
        block2 : {
            Logger logger = AbstractID3Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("locking fileChannel for ");
            stringBuilder.append(string2);
            logger.finest(stringBuilder.toString());
            try {
                FileLock fileLock = fileChannel.tryLock();
                if (fileLock == null) break block2;
                return fileLock;
            }
            catch (IOException | Error throwable) {
                return null;
            }
        }
        throw new IOException(ErrorMessage.GENERAL_WRITE_FAILED_FILE_LOCKED.getMsg(string2));
    }

    public int getFileReadBytes() {
        return this.fileReadSize;
    }

    @Override
    public String getFirst(String string2) {
        TagField tagField = this.getFirstField(string2);
        if (tagField == null) {
            return "";
        }
        return this.getTextValueForFrame((AbstractID3v2Frame)tagField);
    }

    @Override
    public String getFirst(FieldKey fieldKey) throws KeyNotFoundException {
        return this.getValue(fieldKey, 0);
    }

    @Override
    public Artwork getFirstArtwork() {
        List<Artwork> list = this.getArtworkList();
        if (list.size() > 0) {
            return (Artwork)list.get(0);
        }
        return null;
    }

    @Override
    public TagField getFirstField(FieldKey fieldKey) throws KeyNotFoundException {
        List<TagField> list = this.getFields(fieldKey);
        if (list.size() > 0) {
            return (TagField)list.get(0);
        }
        return null;
    }

    @Override
    public AbstractID3v2Frame getFirstField(String string2) {
        Object object = this.getFrame(string2);
        if (object == null) {
            return null;
        }
        if (object instanceof List) {
            return (AbstractID3v2Frame)((List)object).get(0);
        }
        return (AbstractID3v2Frame)object;
    }

    public Object getFrame(String string2) {
        return this.frameMap.get((Object)string2);
    }

    protected abstract FrameAndSubId getFrameAndSubIdFromGenericKey(FieldKey var1);

    public Iterator getFrameOfType(String string2) {
        Iterator iterator = this.frameMap.keySet().iterator();
        HashSet hashSet = new HashSet();
        while (iterator.hasNext()) {
            String string3 = (String)iterator.next();
            if (!string3.startsWith(string2)) continue;
            Object object = this.frameMap.get((Object)string3);
            if (object instanceof List) {
                Iterator iterator2 = ((List)object).iterator();
                while (iterator2.hasNext()) {
                    hashSet.add(iterator2.next());
                }
                continue;
            }
            hashSet.add(object);
        }
        return hashSet.iterator();
    }

    protected abstract ID3Frames getID3Frames();

    public int getInvalidFrames() {
        return this.invalidFrames;
    }

    public abstract Comparator getPreferredFrameOrderComparator();

    @Override
    public int getSize() {
        Iterator iterator = this.frameMap.values().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object instanceof AbstractID3v2Frame) {
                n2 += ((AbstractID3v2Frame)object).getSize();
                continue;
            }
            if (object instanceof AggregatedFrame) {
                Iterator iterator2 = ((AggregatedFrame)object).frames.iterator();
                while (iterator2.hasNext()) {
                    n2 += ((AbstractID3v2Frame)iterator2.next()).getSize();
                }
                continue;
            }
            if (!(object instanceof List)) continue;
            ListIterator listIterator = ((ArrayList)object).listIterator();
            while (listIterator.hasNext()) {
                n2 += ((AbstractID3v2Frame)listIterator.next()).getSize();
            }
        }
        return n2;
    }

    public Long getStartLocationInFile() {
        return this.startLocationInFile;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public String getValue(FieldKey fieldKey, int n2) throws KeyNotFoundException {
        if (fieldKey == null) throw new KeyNotFoundException();
        if (!ID3NumberTotalFields.isNumber(fieldKey) && !ID3NumberTotalFields.isTotal(fieldKey)) {
            if (fieldKey != FieldKey.RATING) return this.doGetValueAtIndex(this.getFrameAndSubIdFromGenericKey(fieldKey), n2);
            List<TagField> list = this.getFields(fieldKey);
            if (list == null || list.size() <= n2) return "";
            return String.valueOf((long)((FrameBodyPOPM)((AbstractID3v2Frame)list.get(n2)).getBody()).getRating());
        }
        List<TagField> list = this.getFields(fieldKey);
        if (list == null || list.size() <= 0) return "";
        AbstractID3v2Frame abstractID3v2Frame = (AbstractID3v2Frame)list.get(0);
        if (ID3NumberTotalFields.isNumber(fieldKey)) {
            return ((AbstractFrameBodyNumberTotal)abstractID3v2Frame.getBody()).getNumberAsText();
        }
        if (!ID3NumberTotalFields.isTotal(fieldKey)) return this.doGetValueAtIndex(this.getFrameAndSubIdFromGenericKey(fieldKey), n2);
        return ((AbstractFrameBodyNumberTotal)abstractID3v2Frame.getBody()).getTotalAsText();
    }

    @Override
    public boolean hasCommonFields() {
        return true;
    }

    @Override
    public boolean hasField(String string2) {
        return this.hasFrame(string2);
    }

    @Override
    public boolean hasField(FieldKey fieldKey) {
        if (fieldKey != null) {
            try {
                TagField tagField = this.getFirstField(fieldKey);
                boolean bl = false;
                if (tagField != null) {
                    bl = true;
                }
                return bl;
            }
            catch (KeyNotFoundException keyNotFoundException) {
                AbstractID3Tag.logger.log(Level.SEVERE, keyNotFoundException.getMessage(), (Throwable)keyNotFoundException);
                return false;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    public boolean hasFrame(String string2) {
        return this.frameMap.containsKey((Object)string2);
    }

    public boolean hasFrameAndBody(String string2) {
        if (this.hasFrame(string2)) {
            Object object = this.getFrame(string2);
            if (object instanceof AbstractID3v2Frame) {
                return true ^ ((AbstractID3v2Frame)object).getBody() instanceof FrameBodyUnsupported;
            }
            return true;
        }
        return false;
    }

    public boolean hasFrameOfType(String string2) {
        Iterator iterator = this.frameMap.keySet().iterator();
        boolean bl = false;
        while (iterator.hasNext() && !bl) {
            if (!((String)iterator.next()).startsWith(string2)) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean isEmpty() {
        return this.frameMap.size() == 0;
    }

    @Override
    public Iterator iterator() {
        return this.frameMap.values().iterator();
    }

    protected void loadFrameIntoMap(String string2, AbstractID3v2Frame abstractID3v2Frame) {
        if (abstractID3v2Frame.getBody() instanceof FrameBodyEncrypted) {
            this.loadFrameIntoSpecifiedMap(this.encryptedFrameMap, string2, abstractID3v2Frame);
            return;
        }
        this.loadFrameIntoSpecifiedMap(this.frameMap, string2, abstractID3v2Frame);
    }

    protected void loadFrameIntoSpecifiedMap(HashMap hashMap, String string2, AbstractID3v2Frame abstractID3v2Frame) {
        if (!(ID3v24Frames.getInstanceOf().isMultipleAllowed(string2) || ID3v23Frames.getInstanceOf().isMultipleAllowed(string2) || ID3v22Frames.getInstanceOf().isMultipleAllowed(string2))) {
            if (hashMap.containsKey((Object)string2)) {
                Logger logger = AbstractID3Tag.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Ignoring Duplicate Frame:");
                stringBuilder.append(string2);
                logger.warning(stringBuilder.toString());
                if (this.duplicateFrameId.length() > 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(this.duplicateFrameId);
                    stringBuilder2.append(";");
                    this.duplicateFrameId = stringBuilder2.toString();
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(this.duplicateFrameId);
                stringBuilder3.append(string2);
                this.duplicateFrameId = stringBuilder3.toString();
                this.duplicateBytes += ((AbstractID3v2Frame)this.frameMap.get((Object)string2)).getSize();
                return;
            }
            Logger logger = AbstractID3Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Adding Frame");
            stringBuilder.append(string2);
            logger.finer(stringBuilder.toString());
            hashMap.put((Object)string2, (Object)abstractID3v2Frame);
            return;
        }
        if (hashMap.containsKey((Object)string2)) {
            Object object = hashMap.get((Object)string2);
            if (object instanceof ArrayList) {
                ((ArrayList)object).add((Object)abstractID3v2Frame);
                Logger logger = AbstractID3Tag.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Adding Multi Frame(1)");
                stringBuilder.append(string2);
                logger.finer(stringBuilder.toString());
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)((AbstractID3v2Frame)object));
            arrayList.add((Object)abstractID3v2Frame);
            hashMap.put((Object)string2, (Object)arrayList);
            Logger logger = AbstractID3Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Adding Multi Frame(2)");
            stringBuilder.append(string2);
            logger.finer(stringBuilder.toString());
            return;
        }
        Logger logger = AbstractID3Tag.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Adding Multi FrameList(3)");
        stringBuilder.append(string2);
        logger.finer(stringBuilder.toString());
        hashMap.put((Object)string2, (Object)abstractID3v2Frame);
    }

    public void mergeDuplicateFrames(AbstractID3v2Frame abstractID3v2Frame, List<AbstractID3v2Frame> list) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            AbstractID3v2Frame abstractID3v2Frame2 = (AbstractID3v2Frame)listIterator.next();
            if (abstractID3v2Frame.getBody() instanceof FrameBodyTXXX) {
                if (!((FrameBodyTXXX)abstractID3v2Frame.getBody()).getDescription().equals((Object)((FrameBodyTXXX)abstractID3v2Frame2.getBody()).getDescription())) continue;
                listIterator.set((Object)abstractID3v2Frame);
                this.frameMap.put((Object)abstractID3v2Frame.getId(), list);
                return;
            }
            if (abstractID3v2Frame.getBody() instanceof FrameBodyWXXX) {
                if (!((FrameBodyWXXX)abstractID3v2Frame.getBody()).getDescription().equals((Object)((FrameBodyWXXX)abstractID3v2Frame2.getBody()).getDescription())) continue;
                listIterator.set((Object)abstractID3v2Frame);
                this.frameMap.put((Object)abstractID3v2Frame.getId(), list);
                return;
            }
            if (abstractID3v2Frame.getBody() instanceof FrameBodyCOMM) {
                if (!((FrameBodyCOMM)abstractID3v2Frame.getBody()).getDescription().equals((Object)((FrameBodyCOMM)abstractID3v2Frame2.getBody()).getDescription())) continue;
                listIterator.set((Object)abstractID3v2Frame);
                this.frameMap.put((Object)abstractID3v2Frame.getId(), list);
                return;
            }
            if (abstractID3v2Frame.getBody() instanceof FrameBodyUFID) {
                if (!((FrameBodyUFID)abstractID3v2Frame.getBody()).getOwner().equals((Object)((FrameBodyUFID)abstractID3v2Frame2.getBody()).getOwner())) continue;
                listIterator.set((Object)abstractID3v2Frame);
                this.frameMap.put((Object)abstractID3v2Frame.getId(), list);
                return;
            }
            if (abstractID3v2Frame.getBody() instanceof FrameBodyUSLT) {
                if (!((FrameBodyUSLT)abstractID3v2Frame.getBody()).getDescription().equals((Object)((FrameBodyUSLT)abstractID3v2Frame2.getBody()).getDescription())) continue;
                listIterator.set((Object)abstractID3v2Frame);
                this.frameMap.put((Object)abstractID3v2Frame.getId(), list);
                return;
            }
            if (abstractID3v2Frame.getBody() instanceof FrameBodyPOPM) {
                if (!((FrameBodyPOPM)abstractID3v2Frame.getBody()).getEmailToUser().equals((Object)((FrameBodyPOPM)abstractID3v2Frame2.getBody()).getEmailToUser())) continue;
                listIterator.set((Object)abstractID3v2Frame);
                this.frameMap.put((Object)abstractID3v2Frame.getId(), list);
                return;
            }
            if (abstractID3v2Frame.getBody() instanceof AbstractFrameBodyNumberTotal) {
                this.mergeNumberTotalFrames(abstractID3v2Frame, abstractID3v2Frame2);
                return;
            }
            if (!(abstractID3v2Frame.getBody() instanceof AbstractFrameBodyPairs)) continue;
            AbstractFrameBodyPairs abstractFrameBodyPairs = (AbstractFrameBodyPairs)abstractID3v2Frame.getBody();
            ((AbstractFrameBodyPairs)abstractID3v2Frame2.getBody()).addPair(abstractFrameBodyPairs.getText());
            return;
        }
        if (!this.getID3Frames().isMultipleAllowed(abstractID3v2Frame.getId())) {
            this.frameMap.put((Object)abstractID3v2Frame.getId(), (Object)abstractID3v2Frame);
            return;
        }
        list.add((Object)abstractID3v2Frame);
        this.frameMap.put((Object)abstractID3v2Frame.getId(), list);
    }

    public void mergeNumberTotalFrames(AbstractID3v2Frame abstractID3v2Frame, AbstractID3v2Frame abstractID3v2Frame2) {
        AbstractFrameBodyNumberTotal abstractFrameBodyNumberTotal = (AbstractFrameBodyNumberTotal)abstractID3v2Frame.getBody();
        AbstractFrameBodyNumberTotal abstractFrameBodyNumberTotal2 = (AbstractFrameBodyNumberTotal)abstractID3v2Frame2.getBody();
        if (abstractFrameBodyNumberTotal.getNumber() != null && abstractFrameBodyNumberTotal.getNumber() > 0) {
            abstractFrameBodyNumberTotal2.setNumber(abstractFrameBodyNumberTotal.getNumberAsText());
        }
        if (abstractFrameBodyNumberTotal.getTotal() != null && abstractFrameBodyNumberTotal.getTotal() > 0) {
            abstractFrameBodyNumberTotal2.setTotal(abstractFrameBodyNumberTotal.getTotalAsText());
        }
    }

    protected void processDuplicateFrame(AbstractID3v2Frame abstractID3v2Frame, AbstractID3v2Frame abstractID3v2Frame2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)abstractID3v2Frame2);
        arrayList.add((Object)abstractID3v2Frame);
        this.frameMap.put((Object)abstractID3v2Frame.getIdentifier(), (Object)arrayList);
    }

    public void removeFrame(String string2) {
        Logger logger = AbstractID3Tag.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Removing frame with identifier:");
        stringBuilder.append(string2);
        logger.finest(stringBuilder.toString());
        this.frameMap.remove((Object)string2);
    }

    public void removeFrameOfType(String string2) {
        HashSet hashSet = new HashSet();
        for (String string3 : this.frameMap.keySet()) {
            if (!string3.startsWith(string2)) continue;
            hashSet.add((Object)string3);
        }
        for (String string4 : hashSet) {
            Logger logger = AbstractID3Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Removing frame with identifier:");
            stringBuilder.append(string4);
            stringBuilder.append("because starts with:");
            stringBuilder.append(string2);
            logger.finest(stringBuilder.toString());
            this.frameMap.remove((Object)string4);
        }
    }

    public void removeUnsupportedFrames() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            AbstractID3v2Frame abstractID3v2Frame;
            Object object = iterator.next();
            if (!(object instanceof AbstractID3v2Frame) || !((abstractID3v2Frame = (AbstractID3v2Frame)object).getBody() instanceof FrameBodyUnsupported)) continue;
            Logger logger = AbstractID3Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Removing frame");
            stringBuilder.append(abstractID3v2Frame.getIdentifier());
            logger.finest(stringBuilder.toString());
            iterator.remove();
        }
    }

    @Override
    public boolean seek(ByteBuffer byteBuffer) {
        byteBuffer.rewind();
        Logger logger = AbstractID3Tag.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ByteBuffer pos:");
        stringBuilder.append(byteBuffer.position());
        stringBuilder.append(":limit");
        stringBuilder.append(byteBuffer.limit());
        stringBuilder.append(":cap");
        stringBuilder.append(byteBuffer.capacity());
        logger.config(stringBuilder.toString());
        byte[] arrby = new byte[3];
        byteBuffer.get(arrby, 0, 3);
        if (!Arrays.equals((byte[])arrby, (byte[])TAG_ID)) {
            return false;
        }
        if (byteBuffer.get() != this.getMajorVersion()) {
            return false;
        }
        byte by = byteBuffer.get();
        byte by2 = this.getRevision();
        boolean bl = false;
        if (by == by2) {
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean setEncoding(Charset charset) throws FieldDataInvalidException {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    public void setEndLocationInFile(long l2) {
        this.endLocationInFile = l2;
    }

    @Override
    public /* varargs */ void setField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        this.setField(this.createField(fieldKey, arrstring));
    }

    @Override
    public void setField(TagField tagField) throws FieldDataInvalidException {
        boolean bl = tagField instanceof AbstractID3v2Frame;
        if (!bl && !(tagField instanceof AggregatedFrame)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field ");
            stringBuilder.append((Object)tagField);
            stringBuilder.append(" is not of type AbstractID3v2Frame nor AggregatedFrame");
            throw new FieldDataInvalidException(stringBuilder.toString());
        }
        if (bl) {
            AbstractID3v2Frame abstractID3v2Frame = (AbstractID3v2Frame)tagField;
            Object object = this.frameMap.get((Object)tagField.getId());
            if (object == null) {
                this.frameMap.put((Object)tagField.getId(), (Object)tagField);
                return;
            }
            if (object instanceof AbstractID3v2Frame) {
                ArrayList arrayList = new ArrayList();
                arrayList.add((Object)((AbstractID3v2Frame)object));
                this.mergeDuplicateFrames(abstractID3v2Frame, (List<AbstractID3v2Frame>)arrayList);
                return;
            }
            if (object instanceof List) {
                this.mergeDuplicateFrames(abstractID3v2Frame, (List<AbstractID3v2Frame>)((List)object));
                return;
            }
        } else {
            this.frameMap.put((Object)tagField.getId(), (Object)tagField);
        }
    }

    @Override
    public void setField(Artwork artwork) throws FieldDataInvalidException {
        this.setField(this.createField(artwork));
    }

    public void setFrame(String string2, List<AbstractID3v2Frame> list) {
        Logger logger = AbstractID3Tag.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Adding ");
        stringBuilder.append(list.size());
        stringBuilder.append(" frames for ");
        stringBuilder.append(string2);
        logger.finest(stringBuilder.toString());
        this.frameMap.put((Object)string2, list);
    }

    public void setFrame(AbstractID3v2Frame abstractID3v2Frame) {
        this.frameMap.put((Object)abstractID3v2Frame.getIdentifier(), (Object)abstractID3v2Frame);
    }

    public void setStartLocationInFile(long l2) {
        this.startLocationInFile = l2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tag content:\n");
        Iterator<TagField> iterator = this.getFields();
        while (iterator.hasNext()) {
            TagField tagField = (TagField)iterator.next();
            stringBuilder.append("\t");
            stringBuilder.append(tagField.getId());
            stringBuilder.append(":");
            stringBuilder.append(tagField.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public abstract long write(File var1, long var2) throws IOException;

    public void write(OutputStream outputStream) throws IOException {
        this.write(Channels.newChannel((OutputStream)outputStream), 0);
    }

    public void write(OutputStream outputStream, int n2) throws IOException {
        this.write(Channels.newChannel((OutputStream)outputStream), n2);
    }

    @Override
    public void write(RandomAccessFile randomAccessFile) throws IOException {
    }

    public void write(WritableByteChannel writableByteChannel, int n2) throws IOException {
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected void writeBufferToFile(File file, ByteBuffer byteBuffer, byte[] arrby, int n2, int n3, long l2) throws IOException {
        void var9_20;
        block17 : {
            FileLock fileLock;
            void var11_12;
            FileLock fileLock2;
            block15 : {
                block16 : {
                    FileChannel fileChannel;
                    block14 : {
                        if ((long)n3 > l2) {
                            AbstractID3Tag.logger.finest("Adjusting Padding");
                            this.adjustPadding(file, n3, l2);
                        }
                        fileLock2 = null;
                        fileChannel = new RandomAccessFile(file, "rw").getChannel();
                        try {
                            fileLock2 = this.getFileLockForWriting(fileChannel, file.getPath());
                            fileChannel.write(byteBuffer);
                            fileChannel.write(ByteBuffer.wrap((byte[])arrby));
                            fileChannel.write(ByteBuffer.wrap((byte[])new byte[n2]));
                            if (fileLock2 == null) break block14;
                        }
                        catch (Throwable throwable) {
                            fileLock = fileLock2;
                            fileLock2 = fileChannel;
                            break block15;
                        }
                        catch (IOException iOException) {
                            fileLock = fileLock2;
                            fileLock2 = fileChannel;
                            break block16;
                        }
                        catch (FileNotFoundException fileNotFoundException) {
                            FileLock fileLock3 = fileLock2;
                            fileLock2 = fileChannel;
                            break block17;
                        }
                        fileLock2.release();
                    }
                    fileChannel.close();
                    return;
                    catch (Throwable throwable) {
                        fileLock = null;
                        fileLock2 = null;
                        break block15;
                    }
                    catch (IOException iOException) {
                        fileLock = null;
                    }
                }
                try {
                    void var25_18;
                    Logger logger = AbstractID3Tag.logger;
                    Level level = Level.SEVERE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.getLoggingFilename());
                    stringBuilder.append(var25_18.getMessage());
                    logger.log(level, stringBuilder.toString(), (Throwable)var25_18);
                    if (var25_18.getMessage().equals((Object)FileSystemMessage.ACCESS_IS_DENIED.getMsg())) {
                        Logger logger2 = AbstractID3Tag.logger;
                        ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING;
                        Object[] arrobject = new Object[]{file.getParentFile().getPath()};
                        logger2.severe(errorMessage.getMsg(arrobject));
                        Object[] arrobject2 = new Object[]{file.getParentFile().getPath()};
                        throw new UnableToModifyFileException(errorMessage.getMsg(arrobject2));
                    }
                    Logger logger3 = AbstractID3Tag.logger;
                    ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING;
                    Object[] arrobject = new Object[]{file.getParentFile().getPath()};
                    logger3.severe(errorMessage.getMsg(arrobject));
                    Object[] arrobject3 = new Object[]{file.getParentFile().getPath()};
                    throw new UnableToCreateFileException(errorMessage.getMsg(arrobject3));
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (fileLock2 == null) throw var11_12;
            if (fileLock != null) {
                fileLock.release();
            }
            fileLock2.close();
            throw var11_12;
            catch (FileNotFoundException fileNotFoundException) {
                Object var10_15 = null;
                fileLock2 = null;
            }
        }
        Logger logger = AbstractID3Tag.logger;
        Level level = Level.SEVERE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLoggingFilename());
        stringBuilder.append(var9_20.getMessage());
        logger.log(level, stringBuilder.toString(), (Throwable)var9_20);
        if (!var9_20.getMessage().contains((CharSequence)FileSystemMessage.ACCESS_IS_DENIED.getMsg()) && !var9_20.getMessage().contains((CharSequence)FileSystemMessage.PERMISSION_DENIED.getMsg())) {
            Logger logger4 = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING;
            Object[] arrobject = new Object[]{file.getPath()};
            logger4.severe(errorMessage.getMsg(arrobject));
            Object[] arrobject4 = new Object[]{file.getPath()};
            throw new UnableToCreateFileException(errorMessage.getMsg(arrobject4));
        }
        Logger logger5 = AbstractID3Tag.logger;
        ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING;
        Object[] arrobject = new Object[]{file.getPath()};
        logger5.severe(errorMessage.getMsg(arrobject));
        Object[] arrobject5 = new Object[]{file.getPath()};
        throw new UnableToModifyFileException(errorMessage.getMsg(arrobject5));
    }

    protected ByteArrayOutputStream writeFramesToBuffer() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.writeFramesToBufferStream((Map)this.frameMap, byteArrayOutputStream);
        this.writeFramesToBufferStream((Map)this.encryptedFrameMap, byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    protected void writePadding(WritableByteChannel writableByteChannel, int n2) throws IOException {
        if (n2 > 0) {
            writableByteChannel.write(ByteBuffer.wrap((byte[])new byte[n2]));
        }
    }

}

