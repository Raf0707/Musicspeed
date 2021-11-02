/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 *  org.jaudiotagger.tag.id3.ID3v11Tag
 *  org.jaudiotagger.tag.id3.ID3v1Tag
 *  org.jaudiotagger.tag.id3.ID3v22Tag
 *  org.jaudiotagger.tag.id3.ID3v23Tag
 *  org.jaudiotagger.tag.id3.ID3v24Tag
 */
package org.jaudiotagger.audio.mp3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.NoWritePermissionsException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.exceptions.UnableToModifyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MPEGFrameHeader;
import org.jaudiotagger.logging.AbstractTagDisplayFormatter;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.logging.Hex;
import org.jaudiotagger.logging.PlainTextTagDisplayFormatter;
import org.jaudiotagger.logging.XMLTagDisplayFormatter;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagNotFoundException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.ID3v11Tag;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.lyrics3.AbstractLyrics3;
import org.jaudiotagger.tag.reference.ID3V2Version;

public class MP3File
extends AudioFile {
    public static final int LOAD_ALL = 14;
    public static final int LOAD_IDV1TAG = 2;
    public static final int LOAD_IDV2TAG = 4;
    public static final int LOAD_LYRICS3 = 8;
    private static final int MINIMUM_FILESIZE = 150;
    protected static AbstractTagDisplayFormatter tagFormatter;
    private ID3v1Tag id3v1tag;
    private ID3v24Tag id3v2Asv24tag;
    private AbstractID3v2Tag id3v2tag;
    private AbstractLyrics3 lyrics3tag;

    public MP3File() {
        this.id3v2tag = null;
        this.id3v2Asv24tag = null;
        this.lyrics3tag = null;
        this.id3v1tag = null;
    }

    public MP3File(File file) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        this(file, 14);
    }

    public MP3File(File file, int n2) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        this(file, n2, false);
    }

    public MP3File(File file, int n2, boolean bl) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        RandomAccessFile randomAccessFile;
        block7 : {
            randomAccessFile = null;
            this.id3v2tag = null;
            this.id3v2Asv24tag = null;
            this.lyrics3tag = null;
            this.id3v1tag = null;
            this.file = file;
            randomAccessFile = this.checkFilePermissions(file, bl);
            long l2 = AbstractID3v2Tag.getV2TagSizeIfExists((File)file);
            Logger logger = AudioFile.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TagHeaderSize:");
            stringBuilder.append(Hex.asHex(l2));
            logger.config(stringBuilder.toString());
            MP3AudioHeader mP3AudioHeader = new MP3AudioHeader(file, l2);
            this.audioHeader = mP3AudioHeader;
            if (l2 != mP3AudioHeader.getMp3StartByte()) {
                Logger logger2 = AudioFile.logger;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("First header found after tag:");
                stringBuilder2.append((Object)this.audioHeader);
                logger2.config(stringBuilder2.toString());
                this.audioHeader = this.checkAudioStart(l2, (MP3AudioHeader)this.audioHeader);
            }
            this.readV1Tag(file, randomAccessFile, n2);
            this.readV2Tag(file, n2, (int)((MP3AudioHeader)this.audioHeader).getMp3StartByte());
            if (this.getID3v2Tag() != null) {
                this.tag = this.getID3v2Tag();
                break block7;
            }
            ID3v1Tag iD3v1Tag = this.id3v1tag;
            if (iD3v1Tag == null) break block7;
            this.tag = iD3v1Tag;
        }
        return;
        finally {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    public MP3File(String string2) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        this(new File(string2));
    }

    private MP3AudioHeader checkAudioStart(long l2, MP3AudioHeader mP3AudioHeader) throws IOException, InvalidAudioFrameException {
        Logger logger = AudioFile.logger;
        ErrorMessage errorMessage = ErrorMessage.MP3_ID3TAG_LENGTH_INCORRECT;
        Object[] arrobject = new Object[]{this.file.getPath(), Hex.asHex(l2), Hex.asHex(mP3AudioHeader.getMp3StartByte())};
        logger.warning(errorMessage.getMsg(arrobject));
        MP3AudioHeader mP3AudioHeader2 = new MP3AudioHeader(this.file, 0L);
        Logger logger2 = AudioFile.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Checking from start:");
        stringBuilder.append((Object)mP3AudioHeader2);
        logger2.config(stringBuilder.toString());
        if (mP3AudioHeader.getMp3StartByte() == mP3AudioHeader2.getMp3StartByte()) {
            Logger logger3 = AudioFile.logger;
            ErrorMessage errorMessage2 = ErrorMessage.MP3_START_OF_AUDIO_CONFIRMED;
            Object[] arrobject2 = new Object[]{this.file.getPath(), Hex.asHex(mP3AudioHeader2.getMp3StartByte())};
            logger3.config(errorMessage2.getMsg(arrobject2));
            return mP3AudioHeader;
        }
        Logger logger4 = AudioFile.logger;
        ErrorMessage errorMessage3 = ErrorMessage.MP3_RECALCULATED_POSSIBLE_START_OF_MP3_AUDIO;
        Object[] arrobject3 = new Object[]{this.file.getPath(), Hex.asHex(mP3AudioHeader2.getMp3StartByte())};
        logger4.config(errorMessage3.getMsg(arrobject3));
        if (mP3AudioHeader.getNumberOfFrames() == mP3AudioHeader2.getNumberOfFrames()) {
            Logger logger5 = AudioFile.logger;
            ErrorMessage errorMessage4 = ErrorMessage.MP3_RECALCULATED_START_OF_MP3_AUDIO;
            Object[] arrobject4 = new Object[]{this.file.getPath(), Hex.asHex(mP3AudioHeader2.getMp3StartByte())};
            logger5.warning(errorMessage4.getMsg(arrobject4));
            return mP3AudioHeader2;
        }
        if (this.isFilePortionNull((int)l2, (int)mP3AudioHeader.getMp3StartByte())) {
            return mP3AudioHeader;
        }
        MP3AudioHeader mP3AudioHeader3 = new MP3AudioHeader(this.file, mP3AudioHeader2.getMp3StartByte() + (long)mP3AudioHeader2.mp3FrameHeader.getFrameLength());
        if (mP3AudioHeader3.getMp3StartByte() == mP3AudioHeader.getMp3StartByte()) {
            Logger logger6 = AudioFile.logger;
            ErrorMessage errorMessage5 = ErrorMessage.MP3_START_OF_AUDIO_CONFIRMED;
            Object[] arrobject5 = new Object[]{this.file.getPath(), Hex.asHex(mP3AudioHeader.getMp3StartByte())};
            logger6.warning(errorMessage5.getMsg(arrobject5));
            return mP3AudioHeader;
        }
        if (mP3AudioHeader3.getNumberOfFrames() == mP3AudioHeader2.getNumberOfFrames()) {
            Logger logger7 = AudioFile.logger;
            ErrorMessage errorMessage6 = ErrorMessage.MP3_RECALCULATED_START_OF_MP3_AUDIO;
            Object[] arrobject6 = new Object[]{this.file.getPath(), Hex.asHex(mP3AudioHeader2.getMp3StartByte())};
            logger7.warning(errorMessage6.getMsg(arrobject6));
            return mP3AudioHeader2;
        }
        Logger logger8 = AudioFile.logger;
        ErrorMessage errorMessage7 = ErrorMessage.MP3_RECALCULATED_START_OF_MP3_AUDIO;
        Object[] arrobject7 = new Object[]{this.file.getPath(), Hex.asHex(mP3AudioHeader.getMp3StartByte())};
        logger8.warning(errorMessage7.getMsg(arrobject7));
        return mP3AudioHeader;
    }

    private static void createPlainTextStructureFormatter() {
        tagFormatter = new PlainTextTagDisplayFormatter();
    }

    private static void createXMLStructureFormatter() {
        tagFormatter = new XMLTagDisplayFormatter();
    }

    public static AbstractTagDisplayFormatter getStructureFormatter() {
        return tagFormatter;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private boolean isFilePortionNull(int n2, int n3) throws IOException {
        void var11_11;
        FileChannel fileChannel;
        FileInputStream fileInputStream;
        block6 : {
            Logger logger = AudioFile.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Checking file portion:");
            stringBuilder.append(Hex.asHex(n2));
            stringBuilder.append(":");
            stringBuilder.append(Hex.asHex(n3));
            logger.config(stringBuilder.toString());
            fileChannel = null;
            fileInputStream = new FileInputStream(this.file);
            try {
                fileChannel = fileInputStream.getChannel();
                fileChannel.position((long)n2);
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)(n3 - n2));
                fileChannel.read(byteBuffer);
                while (byteBuffer.hasRemaining()) {
                    byte by = byteBuffer.get();
                    if (by == 0) continue;
                }
            }
            catch (Throwable throwable) {}
            {
                fileChannel.close();
                fileInputStream.close();
                return false;
            }
            fileChannel.close();
            fileInputStream.close();
            return true;
            break block6;
            catch (Throwable throwable) {
                fileInputStream = null;
            }
        }
        if (fileChannel != null) {
            fileChannel.close();
        }
        if (fileInputStream == null) throw var11_11;
        fileInputStream.close();
        throw var11_11;
    }

    private void readLyrics3Tag(File file, RandomAccessFile randomAccessFile, int n2) throws IOException {
    }

    /*
     * Exception decompiling
     */
    private void readV1Tag(File var1, RandomAccessFile var2, int var3) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl35 : RETURN : trying to set 1 previously set to 0
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
     * Exception decompiling
     */
    private void readV2Tag(File var1, int var2, int var3) throws IOException, TagException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl75 : ICONST_1 : trying to set 1 previously set to 0
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

    @Override
    public void commit() throws CannotWriteException {
        try {
            this.save();
            return;
        }
        catch (TagException tagException) {
            throw new CannotWriteException((Throwable)tagException);
        }
        catch (IOException iOException) {
            throw new CannotWriteException(iOException);
        }
        catch (UnableToModifyFileException unableToModifyFileException) {
            throw new NoWritePermissionsException((Throwable)unableToModifyFileException);
        }
    }

    @Override
    public Tag createDefaultTag() {
        if (TagOptionSingleton.getInstance().getID3V2Version() == ID3V2Version.ID3_V24) {
            return new ID3v24Tag();
        }
        if (TagOptionSingleton.getInstance().getID3V2Version() == ID3V2Version.ID3_V23) {
            return new ID3v23Tag();
        }
        if (TagOptionSingleton.getInstance().getID3V2Version() == ID3V2Version.ID3_V22) {
            return new ID3v22Tag();
        }
        return new ID3v24Tag();
    }

    public void delete(AbstractTag abstractTag) throws FileNotFoundException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, "rw");
        abstractTag.delete(randomAccessFile);
        randomAccessFile.close();
        if (abstractTag instanceof ID3v1Tag) {
            this.id3v1tag = null;
        }
        if (abstractTag instanceof AbstractID3v2Tag) {
            this.id3v2tag = null;
        }
    }

    @Override
    public String displayStructureAsPlainText() {
        MP3File.createPlainTextStructureFormatter();
        tagFormatter.openHeadingElement("file", this.getFile().getAbsolutePath());
        if (this.getID3v1Tag() != null) {
            this.getID3v1Tag().createStructure();
        }
        if (this.getID3v2Tag() != null) {
            this.getID3v2Tag().createStructure();
        }
        tagFormatter.closeHeadingElement("file");
        return tagFormatter.toString();
    }

    @Override
    public String displayStructureAsXML() {
        MP3File.createXMLStructureFormatter();
        tagFormatter.openHeadingElement("file", this.getFile().getAbsolutePath());
        if (this.getID3v1Tag() != null) {
            this.getID3v1Tag().createStructure();
        }
        if (this.getID3v2Tag() != null) {
            this.getID3v2Tag().createStructure();
        }
        tagFormatter.closeHeadingElement("file");
        return tagFormatter.toString();
    }

    public File extractID3v2TagDataIntoFile(File file) throws TagNotFoundException, IOException {
        int n2 = (int)((MP3AudioHeader)this.audioHeader).getMp3StartByte();
        if (n2 >= 0) {
            FileInputStream fileInputStream = new FileInputStream(this.file);
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)n2);
            fileChannel.read(byteBuffer);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteBuffer.array());
            fileOutputStream.close();
            fileChannel.close();
            fileInputStream.close();
            return file;
        }
        throw new TagNotFoundException("There is no ID3v2Tag data in this file");
    }

    public byte[] getHash() throws NoSuchAlgorithmException, InvalidAudioFrameException, IOException {
        return this.getHash("MD5", 32768);
    }

    public byte[] getHash(int n2) throws NoSuchAlgorithmException, InvalidAudioFrameException, IOException {
        return this.getHash("MD5", n2);
    }

    public byte[] getHash(String string2) throws NoSuchAlgorithmException, InvalidAudioFrameException, IOException {
        return this.getHash(string2, 32768);
    }

    public byte[] getHash(String string2, int n2) throws InvalidAudioFrameException, IOException, NoSuchAlgorithmException {
        File file = this.getFile();
        long l2 = this.getMP3StartByte(file);
        int n3 = this.hasID3v1Tag() ? this.getID3v1Tag().getSize() : 0;
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] arrby = new byte[n2];
        MessageDigest messageDigest = MessageDigest.getInstance((String)string2);
        fileInputStream.skip(l2);
        long l3 = file.length() - l2 - (long)n3;
        int n4 = n2;
        while ((long)n4 <= l3) {
            messageDigest.update(arrby, 0, fileInputStream.read(arrby));
            n4 += n2;
        }
        messageDigest.update(arrby, 0, fileInputStream.read(arrby, 0, n2 + ((int)l3 - n4)));
        byte[] arrby2 = messageDigest.digest();
        fileInputStream.close();
        return arrby2;
    }

    public ID3v1Tag getID3v1Tag() {
        return this.id3v1tag;
    }

    public AbstractID3v2Tag getID3v2Tag() {
        return this.id3v2tag;
    }

    public ID3v24Tag getID3v2TagAsv24() {
        return this.id3v2Asv24tag;
    }

    public MP3AudioHeader getMP3AudioHeader() {
        return (MP3AudioHeader)this.getAudioHeader();
    }

    public long getMP3StartByte(File file) throws InvalidAudioFrameException, IOException {
        try {
            long l2 = AbstractID3v2Tag.getV2TagSizeIfExists((File)file);
            MP3AudioHeader mP3AudioHeader = new MP3AudioHeader(file, l2);
            if (l2 != mP3AudioHeader.getMp3StartByte()) {
                Logger logger = AudioFile.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("First header found after tag:");
                stringBuilder.append((Object)mP3AudioHeader);
                logger.config(stringBuilder.toString());
                mP3AudioHeader = this.checkAudioStart(l2, mP3AudioHeader);
            }
            long l3 = mP3AudioHeader.getMp3StartByte();
            return l3;
        }
        catch (IOException iOException) {
            throw iOException;
        }
        catch (InvalidAudioFrameException invalidAudioFrameException) {
            throw invalidAudioFrameException;
        }
    }

    @Override
    public Tag getTagAndConvertOrCreateAndSetDefault() {
        Tag tag = this.getTagOrCreateDefault();
        AbstractID3v2Tag abstractID3v2Tag = this.convertID3Tag((AbstractID3v2Tag)tag, TagOptionSingleton.getInstance().getID3V2Version());
        if (abstractID3v2Tag != null) {
            this.setTag((Tag)abstractID3v2Tag);
        } else {
            this.setTag(tag);
        }
        return this.getTag();
    }

    @Override
    public Tag getTagOrCreateDefault() {
        Object object = this.getID3v2Tag();
        if (object == null) {
            object = this.createDefaultTag();
        }
        return object;
    }

    public boolean hasID3v1Tag() {
        return this.id3v1tag != null;
    }

    public boolean hasID3v2Tag() {
        return this.id3v2tag != null;
    }

    public void precheck(File file) throws IOException {
        if (file.exists()) {
            if (TagOptionSingleton.getInstance().isCheckIsWritable() && !file.canWrite()) {
                Logger logger = AudioFile.logger;
                ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED;
                Object[] arrobject = new Object[]{file.getName()};
                logger.severe(errorMessage.getMsg(arrobject));
                Object[] arrobject2 = new Object[]{file.getName()};
                throw new IOException(errorMessage.getMsg(arrobject2));
            }
            if (file.length() > 150L) {
                return;
            }
            Logger logger = AudioFile.logger;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_BECAUSE_FILE_IS_TOO_SMALL;
            Object[] arrobject = new Object[]{file.getName()};
            logger.severe(errorMessage.getMsg(arrobject));
            Object[] arrobject3 = new Object[]{file.getName()};
            throw new IOException(errorMessage.getMsg(arrobject3));
        }
        Logger logger = AudioFile.logger;
        ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_BECAUSE_FILE_NOT_FOUND;
        Object[] arrobject = new Object[]{file.getName()};
        logger.severe(errorMessage.getMsg(arrobject));
        Object[] arrobject4 = new Object[]{file.getName()};
        throw new IOException(errorMessage.getMsg(arrobject4));
    }

    public void save() throws IOException, TagException {
        this.save(this.file);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void save(File var1_1) throws IOException {
        block20 : {
            block21 : {
                block19 : {
                    block18 : {
                        block17 : {
                            var2_2 = var1_1.getAbsoluteFile();
                            var3_3 = AudioFile.logger;
                            var4_4 = new StringBuilder();
                            var4_4.append("Saving  : ");
                            var4_4.append(var2_2.getPath());
                            var3_3.config(var4_4.toString());
                            this.precheck(var2_2);
                            var7_5 = null;
                            var27_6 = TagOptionSingleton.getInstance().isId3v2Save();
                            var7_5 = null;
                            if (!var27_6) ** GOTO lbl48
                            var29_7 = this.id3v2tag;
                            var7_5 = null;
                            if (var29_7 != null) break block17;
                            var15_8 = new RandomAccessFile(var2_2, "rw");
                            new ID3v24Tag().delete(var15_8);
                            new ID3v23Tag().delete(var15_8);
                            new ID3v22Tag().delete(var15_8);
                            var30_10 = AudioFile.logger;
                            var31_11 = new StringBuilder();
                            var31_11.append("Deleting ID3v2 tag:");
                            var31_11.append(var2_2.getName());
                            var30_10.config(var31_11.toString());
                            var15_8.close();
                            var7_5 = var15_8;
                            ** GOTO lbl48
                        }
                        var34_12 = AudioFile.logger;
                        var35_13 = new StringBuilder();
                        var35_13.append("Writing ID3v2 tag:");
                        var35_13.append(var2_2.getName());
                        var34_12.config(var35_13.toString());
                        var38_14 = (MP3AudioHeader)this.getAudioHeader();
                        var39_15 = var38_14.getMp3StartByte();
                        var41_16 = this.id3v2tag.write(var2_2, var39_15);
                        var43_17 = var39_15 LCMP var41_16;
                        var7_5 = null;
                        if (var43_17 != false) {
                            var44_18 = AudioFile.logger;
                            var45_19 = new StringBuilder();
                            var45_19.append("New mp3 start byte: ");
                            var45_19.append(var41_16);
                            var44_18.config(var45_19.toString());
                            var38_14.setMp3StartByte(var41_16);
                        }
lbl48: // 5 sources:
                        var15_8 = new RandomAccessFile(var2_2, "rw");
                        try {
                            if (TagOptionSingleton.getInstance().isLyrics3Save() && (var28_20 = this.lyrics3tag) != null) {
                                var28_20.write(var15_8);
                            }
                            if (!TagOptionSingleton.getInstance().isId3v1Save()) break block18;
                            AudioFile.logger.config("Processing ID3v1");
                            if (this.id3v1tag == null) {
                                AudioFile.logger.config("Deleting ID3v1");
                                new ID3v1Tag().delete(var15_8);
                                break block18;
                            }
                            AudioFile.logger.config("Saving ID3v1");
                            this.id3v1tag.write(var15_8);
                        }
                        catch (RuntimeException var22_21) {
                            break block19;
                        }
                        catch (IOException var16_23) {
                            break block20;
                        }
                        catch (FileNotFoundException var8_25) {
                            var7_5 = var15_8;
                            ** GOTO lbl-1000
                        }
                    }
                    var15_8.close();
                    return;
                    catch (Throwable var13_28) {
                        break block21;
                    }
                    catch (RuntimeException var21_31) {
                        var15_8 = var7_5;
                        var22_22 = var21_31;
                    }
                }
                try {
                    var23_32 = AudioFile.logger;
                    var24_33 = Level.SEVERE;
                    var25_34 = ErrorMessage.GENERAL_WRITE_FAILED_BECAUSE;
                    var26_35 = new Object[]{var2_2.getName(), var22_22.getMessage()};
                    var23_32.log(var24_33, var25_34.getMsg(var26_35), (Throwable)var22_22);
                    throw var22_22;
                }
                catch (Throwable var13_29) {
                    var7_5 = var15_8;
                }
                break block21;
                catch (FileNotFoundException var8_26) {
                    // empty catch block
                }
lbl-1000: // 2 sources:
                {
                    var9_40 = AudioFile.logger;
                    var10_41 = Level.SEVERE;
                    var11_42 = ErrorMessage.GENERAL_WRITE_FAILED_BECAUSE_FILE_NOT_FOUND;
                    var12_43 = new Object[]{var2_2.getName()};
                    var9_40.log(var10_41, var11_42.getMsg(var12_43), (Throwable)var8_27);
                    throw var8_27;
                }
            }
            if (var7_5 == null) throw var13_30;
            var7_5.close();
            throw var13_30;
            catch (IOException var14_44) {
                var15_9 = var7_5;
                var16_24 = var14_44;
            }
        }
        var17_36 = AudioFile.logger;
        var18_37 = Level.SEVERE;
        var19_38 = ErrorMessage.GENERAL_WRITE_FAILED_BECAUSE;
        var20_39 = new Object[]{var2_2.getName(), var16_24.getMessage()};
        var17_36.log(var18_37, var19_38.getMsg(var20_39), (Throwable)var16_24);
        throw var16_24;
    }

    public void setID3v1Tag(Tag tag) {
        AudioFile.logger.config("setting tagv1:v1 tag");
        this.id3v1tag = (ID3v1Tag)tag;
    }

    public void setID3v1Tag(AbstractTag abstractTag) {
        AudioFile.logger.config("setting tagv1:abstract");
        this.id3v1tag = new ID3v11Tag(abstractTag);
    }

    public void setID3v1Tag(ID3v1Tag iD3v1Tag) {
        AudioFile.logger.config("setting tagv1:v1 tag");
        this.id3v1tag = iD3v1Tag;
    }

    public void setID3v2Tag(AbstractID3v2Tag abstractID3v2Tag) {
        this.id3v2tag = abstractID3v2Tag;
        if (abstractID3v2Tag instanceof ID3v24Tag) {
            this.id3v2Asv24tag = (ID3v24Tag)abstractID3v2Tag;
            return;
        }
        this.id3v2Asv24tag = new ID3v24Tag((AbstractTag)abstractID3v2Tag);
    }

    public void setID3v2Tag(AbstractTag abstractTag) {
        this.id3v2tag = new ID3v24Tag(abstractTag);
    }

    public void setID3v2TagOnly(AbstractID3v2Tag abstractID3v2Tag) {
        this.id3v2tag = abstractID3v2Tag;
        this.id3v2Asv24tag = null;
    }

    @Override
    public void setTag(Tag tag) {
        this.tag = tag;
        if (tag instanceof ID3v1Tag) {
            this.setID3v1Tag((ID3v1Tag)tag);
            return;
        }
        this.setID3v2Tag((AbstractID3v2Tag)tag);
    }
}

