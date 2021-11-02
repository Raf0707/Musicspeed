/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 *  java.nio.channels.FileLock
 *  java.nio.channels.WritableByteChannel
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.mp3.MP3File
 */
package org.jaudiotagger.audio.generic;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.ModifyVetoException;
import org.jaudiotagger.audio.generic.AudioFileModificationListener;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagOptionSingleton;

public abstract class AudioFileWriter {
    private static final String FILE_NAME_TOO_LONG = "File name too long";
    private static final String FILE_NAME_TOO_LONG2 = "The filename, directory name, or volume label syntax is incorrect";
    private static final int FILE_NAME_TOO_LONG_SAFE_LIMIT = 50;
    protected static final int MINIMUM_FILESIZE = 100;
    private static final String TEMP_FILENAME_SUFFIX = ".tmp";
    private static final String WRITE_MODE = "rw";
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.generic");
    private AudioFileModificationListener modificationListener = null;

    private void precheckWrite(AudioFile audioFile) throws CannotWriteException {
        block4 : {
            try {
                if (!audioFile.getTag().isEmpty()) break block4;
                this.delete(audioFile);
                return;
            }
            catch (CannotReadException cannotReadException) {
                ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED;
                Object[] arrobject = new Object[]{audioFile.getFile().getPath()};
                throw new CannotWriteException(errorMessage.getMsg(arrobject));
            }
        }
        File file = audioFile.getFile();
        if (TagOptionSingleton.getInstance().isCheckIsWritable() && !file.canWrite()) {
            Logger logger = AudioFileWriter.logger;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED;
            Object[] arrobject = new Object[]{audioFile.getFile().getPath()};
            logger.severe(errorMessage.getMsg(arrobject));
            ErrorMessage errorMessage2 = ErrorMessage.GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING;
            Object[] arrobject2 = new Object[]{file.getPath()};
            throw new CannotWriteException(errorMessage2.getMsg(arrobject2));
        }
        if (audioFile.getFile().length() > 100L) {
            return;
        }
        Logger logger = AudioFileWriter.logger;
        ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_BECAUSE_FILE_IS_TOO_SMALL;
        Object[] arrobject = new Object[]{file.getPath()};
        logger.severe(errorMessage.getMsg(arrobject));
        Object[] arrobject3 = new Object[]{file.getPath()};
        throw new CannotWriteException(errorMessage.getMsg(arrobject3));
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void transferNewFileContentToOriginalFile(File var1_1, File var2_2) throws CannotWriteException {
        block23 : {
            block21 : {
                var3_3 = null;
                var4_4 = new RandomAccessFile(var2_2, "rw");
                var16_5 = var4_4.getChannel();
                try {
                    var3_3 = var16_5.tryLock();
                    if (var3_3 != null) {
                        this.transferNewFileContentToOriginalFile(var1_1, var2_2, var4_4, var16_5);
                        break block21;
                    }
                    var28_6 = AudioFileWriter.logger;
                    var29_7 = ErrorMessage.GENERAL_WRITE_FAILED_FILE_LOCKED;
                    var30_8 = new Object[]{var2_2.getPath()};
                    var28_6.warning(var29_7.getMsg(var30_8));
                    var31_9 = new Object[]{var2_2.getPath()};
                    throw new CannotWriteException(var29_7.getMsg(var31_9));
                }
                catch (Throwable var22_10) {
                    break block23;
                }
                catch (Exception var23_11) {
                    var24_12 = AudioFileWriter.logger;
                    var25_13 = ErrorMessage.GENERAL_WRITE_FAILED_FILE_LOCKED;
                    var26_14 = new Object[]{var2_2.getPath()};
                    var24_12.warning(var25_13.getMsg(var26_14));
                    var27_15 = new Object[]{var2_2.getPath()};
                    throw new CannotWriteException(var25_13.getMsg(var27_15), var23_11);
                }
                catch (IOException var17_16) {
                    var18_17 = AudioFileWriter.logger;
                    var19_18 = ErrorMessage.GENERAL_WRITE_FAILED_FILE_LOCKED;
                    var20_19 = new Object[]{var2_2.getPath()};
                    var18_17.warning(var19_18.getMsg(var20_19));
                    if (!"Operation not supported".equals((Object)var17_16.getMessage())) ** GOTO lbl-1000
                    this.transferNewFileContentToOriginalFile(var1_1, var2_2, var4_4, var16_5);
                    if (var3_3 != null) ** continue;
                }
            }
            do {
                try {
                    var3_3.release();
                }
                catch (Throwable var10_21) {}
                break;
            } while (true);
            AudioFileIO.closeQuietly(new Closeable[]{var4_4});
            return;
lbl-1000: // 1 sources:
            {
                var21_20 = new Object[]{var2_2.getPath()};
                throw new CannotWriteException(var19_18.getMsg(var21_20), var17_16);
            }
        }
        if (var3_3 == null) throw var22_10;
        ** try [egrp 7[TRYBLOCK] [23, 22, 21 : 303->310)] { 
lbl49: // 1 sources:
        var3_3.release();
        throw var22_10;
lbl51: // 3 sources:
        catch (Exception var11_24) {}
lbl52: // 3 sources:
        catch (FileNotFoundException var5_27) {}
lbl53: // 1 sources:
        finally {
            var3_3 = var4_4;
            ** GOTO lbl66
        }
        catch (Throwable var10_22) {
            ** GOTO lbl66
        }
        catch (Exception var11_25) {
            // empty catch block
        }
        {
            var12_30 = AudioFileWriter.logger;
            var13_31 = ErrorMessage.GENERAL_WRITE_FAILED;
            var14_32 = new Object[]{var2_2.getAbsolutePath()};
            var12_30.warning(var13_31.getMsg(var14_32));
            var15_33 = new Object[]{var2_2.getPath()};
            throw new CannotWriteException(var13_31.getMsg(var15_33), (Throwable)var11_26);
lbl66: // 2 sources:
            AudioFileIO.closeQuietly(new Closeable[]{var3_3});
            throw var10_23;
            catch (FileNotFoundException var5_29) {
                var3_3 = null;
            }
            var6_34 = AudioFileWriter.logger;
            var7_35 = ErrorMessage.GENERAL_WRITE_FAILED_BECAUSE_FILE_NOT_FOUND;
            var8_36 = new Object[]{var2_2.getAbsolutePath()};
            var6_34.warning(var7_35.getMsg(var8_36));
            var9_37 = new Object[]{var2_2.getPath()};
            throw new CannotWriteException(var7_35.getMsg(var9_37), (Throwable)var5_28);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void transferNewFileContentToOriginalFile(File file, File file2, RandomAccessFile randomAccessFile, FileChannel fileChannel) throws CannotWriteException {
        void var12_15;
        FileInputStream fileInputStream;
        block10 : {
            void var7_21;
            block12 : {
                block11 : {
                    fileInputStream = null;
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        FileChannel fileChannel2 = fileInputStream2.getChannel();
                        long l2 = fileChannel2.size();
                        for (long i2 = 0L; i2 < l2; i2 += fileChannel2.transferTo((long)i2, (long)0x100000L, (WritableByteChannel)fileChannel)) {
                        }
                        randomAccessFile.setLength(l2);
                    }
                    catch (Throwable throwable) {
                        fileInputStream = fileInputStream2;
                        break block10;
                    }
                    catch (IOException iOException) {
                        fileInputStream = fileInputStream2;
                        break block11;
                    }
                    catch (FileNotFoundException fileNotFoundException) {
                        fileInputStream = fileInputStream2;
                        break block12;
                    }
                    AudioFileIO.closeQuietly(new Closeable[]{fileInputStream2});
                    if (!file.exists()) return;
                    if (file.delete()) return;
                    Logger logger = AudioFileWriter.logger;
                    ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE;
                    Object[] arrobject = new Object[]{file.getPath()};
                    logger.warning(errorMessage.getMsg(arrobject));
                    return;
                    catch (IOException iOException) {
                        fileInputStream = null;
                    }
                    catch (FileNotFoundException fileNotFoundException) {
                        fileInputStream = null;
                        break block12;
                    }
                }
                try {
                    void var13_18;
                    Logger logger = AudioFileWriter.logger;
                    ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_RENAME_TO_ORIGINAL_FILE;
                    Object[] arrobject = new Object[]{file2.getAbsolutePath(), file.getName()};
                    logger.warning(errorMessage.getMsg(arrobject));
                    Object[] arrobject2 = new Object[]{file2.getAbsolutePath(), file.getName()};
                    throw new CannotWriteException(errorMessage.getMsg(arrobject2), (Throwable)var13_18);
                }
                catch (Throwable throwable) {}
                break block10;
            }
            Logger logger = AudioFileWriter.logger;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_NEW_FILE_DOESNT_EXIST;
            Object[] arrobject = new Object[]{file.getAbsolutePath()};
            logger.warning(errorMessage.getMsg(arrobject));
            Object[] arrobject3 = new Object[]{file.getName()};
            throw new CannotWriteException(errorMessage.getMsg(arrobject3), (Throwable)var7_21);
        }
        AudioFileIO.closeQuietly(new Closeable[]{fileInputStream});
        throw var12_15;
    }

    private void transferNewFileToNewOriginalFile(File file, File file2) throws CannotWriteException {
        String string2 = file2.getAbsoluteFile().getParentFile().getPath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AudioFile.getBaseFilename(file2));
        stringBuilder.append(".old");
        File file3 = new File(string2, stringBuilder.toString());
        int n2 = 1;
        while (file3.exists()) {
            String string3 = file2.getAbsoluteFile().getParentFile().getPath();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(AudioFile.getBaseFilename(file2));
            stringBuilder2.append(".old");
            stringBuilder2.append(n2);
            file3 = new File(string3, stringBuilder2.toString());
            ++n2;
        }
        if (!Utils.rename(file2, file3)) {
            Logger logger = AudioFileWriter.logger;
            Level level = Level.SEVERE;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_RENAME_ORIGINAL_FILE_TO_BACKUP;
            Object[] arrobject = new Object[]{file2.getAbsolutePath(), file3.getName()};
            logger.log(level, errorMessage.getMsg(arrobject));
            if (file != null) {
                file.delete();
            }
            Object[] arrobject2 = new Object[]{file2.getPath(), file3.getName()};
            throw new CannotWriteException(errorMessage.getMsg(arrobject2));
        }
        if (!Utils.rename(file, file2)) {
            if (!file.exists()) {
                Logger logger = AudioFileWriter.logger;
                ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_NEW_FILE_DOESNT_EXIST;
                Object[] arrobject = new Object[]{file.getAbsolutePath()};
                logger.warning(errorMessage.getMsg(arrobject));
            }
            if (!file3.renameTo(file2)) {
                Logger logger = AudioFileWriter.logger;
                ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_RENAME_ORIGINAL_BACKUP_TO_ORIGINAL;
                Object[] arrobject = new Object[]{file3.getAbsolutePath(), file2.getName()};
                logger.warning(errorMessage.getMsg(arrobject));
            }
            Logger logger = AudioFileWriter.logger;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_RENAME_TO_ORIGINAL_FILE;
            Object[] arrobject = new Object[]{file2.getAbsolutePath(), file.getName()};
            logger.warning(errorMessage.getMsg(arrobject));
            Object[] arrobject3 = new Object[]{file2.getAbsolutePath(), file.getName()};
            throw new CannotWriteException(errorMessage.getMsg(arrobject3));
        }
        if (!file3.delete()) {
            Logger logger = AudioFileWriter.logger;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_WARNING_UNABLE_TO_DELETE_BACKUP_FILE;
            Object[] arrobject = new Object[]{file3.getAbsolutePath()};
            logger.warning(errorMessage.getMsg(arrobject));
        }
        if (file.exists() && !file.delete()) {
            Logger logger = AudioFileWriter.logger;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE;
            Object[] arrobject = new Object[]{file.getPath()};
            logger.warning(errorMessage.getMsg(arrobject));
        }
    }

    private void transferNewFileToOriginalFile(File file, File file2, boolean bl) throws CannotWriteException {
        if (bl) {
            this.transferNewFileContentToOriginalFile(file, file2);
            return;
        }
        this.transferNewFileToNewOriginalFile(file, file2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public void delete(AudioFile var1_1) throws CannotReadException, CannotWriteException {
        block46 : {
            block45 : {
                block44 : {
                    block47 : {
                        block43 : {
                            block42 : {
                                block39 : {
                                    block41 : {
                                        block40 : {
                                            block38 : {
                                                block37 : {
                                                    var2_2 = var1_1.getFile();
                                                    if (TagOptionSingleton.getInstance().isCheckIsWritable() && !var2_2.canWrite()) {
                                                        var77_3 = ErrorMessage.GENERAL_DELETE_FAILED;
                                                        var78_4 = new Object[]{var2_2.getPath()};
                                                        throw new CannotWriteException(var77_3.getMsg(var78_4));
                                                    }
                                                    if (var1_1.getFile().length() <= 100L) break block46;
                                                    var5_5 = null;
                                                    var7_6 = File.createTempFile((String)var1_1.getFile().getName().replace('.', '_'), (String)".tmp", (File)var1_1.getFile().getParentFile());
                                                    var8_7 = new RandomAccessFile(var7_6, "rw");
                                                    var44_8 = new RandomAccessFile(var1_1.getFile(), "rw");
                                                    var44_8.seek(0L);
                                                    var8_7.seek(0L);
                                                    var47_9 = this.modificationListener;
                                                    if (var47_9 != null) {
                                                        var47_9.fileWillBeModified(var1_1, true);
                                                    }
                                                    this.deleteTag(var1_1.getTag(), var44_8, var8_7);
                                                    var48_10 = this.modificationListener;
                                                    if (var48_10 == null) break block37;
                                                    var48_10.fileModified(var1_1, var7_6);
                                                }
                                                var49_11 = var1_1.getFile();
                                                var44_8.close();
                                                var8_7.close();
                                                if (var7_6.length() <= 0L) ** GOTO lbl58
                                                if (!var1_1.getFile().delete()) ** GOTO lbl52
                                                var67_12 = var7_6.renameTo(var1_1.getFile());
                                                if (!var67_12) break block38;
                                                try {
                                                    if (var7_6.exists() && !var7_6.delete()) {
                                                        var72_13 = AudioFileWriter.logger;
                                                        var73_14 = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE;
                                                        var74_15 = new Object[]{var7_6.getPath()};
                                                        var72_13.warning(var73_14.getMsg(var74_15));
                                                    }
                                                    break block39;
                                                }
                                                catch (Exception var50_16) {
                                                    var49_11 = var7_6;
                                                    break block40;
                                                }
                                            }
                                            try {
                                                var68_19 = AudioFileWriter.logger;
                                                var69_20 = ErrorMessage.GENERAL_WRITE_FAILED_TO_RENAME_TO_ORIGINAL_FILE;
                                                var70_21 = new Object[]{var1_1.getFile().getPath(), var7_6.getPath()};
                                                var68_19.warning(var69_20.getMsg(var70_21));
                                                var71_22 = new Object[]{var1_1.getFile().getPath(), var7_6.getPath()};
                                                throw new CannotWriteException(var69_20.getMsg(var71_22));
lbl52: // 1 sources:
                                                var63_23 = AudioFileWriter.logger;
                                                var64_24 = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_ORIGINAL_FILE;
                                                var65_25 = new Object[]{var1_1.getFile().getPath(), var7_6.getPath()};
                                                var63_23.warning(var64_24.getMsg(var65_25));
                                                var66_26 = new Object[]{var1_1.getFile().getPath(), var7_6.getPath()};
                                                throw new CannotWriteException(var64_24.getMsg(var66_26));
lbl58: // 1 sources:
                                                if (!var7_6.delete()) {
                                                    var60_27 = AudioFileWriter.logger;
                                                    var61_28 = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE;
                                                    var62_29 = new Object[]{var7_6.getPath()};
                                                    var60_27.warning(var61_28.getMsg(var62_29));
                                                }
                                                break block41;
                                            }
                                            catch (Exception var50_17) {
                                                // empty catch block
                                            }
                                        }
                                        var51_30 = AudioFileWriter.logger;
                                        var52_31 = new StringBuilder();
                                        var52_31.append("AudioFileWriter exception cleaning up delete:");
                                        var52_31.append(var1_1.getFile().getPath());
                                        var52_31.append(" or");
                                        var52_31.append(var7_6.getAbsolutePath());
                                        var52_31.append(":");
                                        var52_31.append((Object)var50_18);
                                        var51_30.severe(var52_31.toString());
                                    }
                                    var7_6 = var49_11;
                                }
                                if ((var59_32 = this.modificationListener) != null) {
                                    var59_32.fileOperationFinished(var7_6);
                                }
                                return;
                                {
                                    catch (ModifyVetoException var46_33) {
                                        try {
                                            throw new CannotWriteException((Throwable)var46_33);
                                        }
                                        catch (Throwable var45_34) {
                                            var11_35 = var45_34;
                                            var5_5 = var44_8;
                                            break block42;
                                        }
                                        catch (Exception var6_36) {
                                            var5_5 = var44_8;
                                            break block43;
                                        }
                                    }
                                }
                                catch (Throwable var75_41) {
                                    var11_35 = var75_41;
                                    var5_5 = null;
                                    break block42;
                                }
                                catch (Exception var6_37) {
                                    var5_5 = null;
                                    break block43;
                                }
                                catch (Throwable var76_42) {
                                    var11_35 = var76_42;
                                    var5_5 = null;
                                    var8_7 = null;
                                    break block42;
                                }
                                catch (Exception var6_38) {
                                    var5_5 = null;
                                    var8_7 = null;
                                    break block43;
                                }
                                catch (Throwable var43_43) {
                                    var11_35 = var43_43;
                                    var7_6 = null;
                                    var8_7 = null;
                                }
                            }
                            var12_44 = false;
                            break block47;
                            catch (Exception var6_39) {
                                var7_6 = null;
                                var8_7 = null;
                            }
                        }
                        try {
                            var9_45 = new StringBuilder();
                            var9_45.append("\"");
                            var9_45.append(var1_1.getFile().getAbsolutePath());
                            var9_45.append("\" :");
                            var9_45.append((Object)var6_40);
                            throw new CannotWriteException(var9_45.toString(), (Throwable)var6_40);
                        }
                        catch (Throwable var10_46) {
                            var11_35 = var10_46;
                            var12_44 = true;
                        }
                    }
                    var13_47 = var1_1.getFile();
                    if (var5_5 == null) ** GOTO lbl134
                    try {
                        var5_5.close();
lbl134: // 2 sources:
                        if (var8_7 != null) {
                            var8_7.close();
                        }
                        if (var7_6.length() <= 0L || var12_44) ** GOTO lbl166
                        if (!var1_1.getFile().delete()) ** GOTO lbl160
                        var28_48 = var7_6.renameTo(var1_1.getFile());
                        if (!var28_48) break block44;
                    }
                    catch (Exception var18_54) {
                        ** continue;
                    }
                    try {
                        if (var7_6.exists() && !var7_6.delete()) {
                            var33_49 = AudioFileWriter.logger;
                            var34_50 = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE;
                            var35_51 = new Object[]{var7_6.getPath()};
                            var33_49.warning(var34_50.getMsg(var35_51));
                        }
                        ** GOTO lbl184
                    }
                    catch (Exception var18_52) {
                        var13_47 = var7_6;
                        break block45;
                    }
                }
                var29_55 = AudioFileWriter.logger;
                var30_56 = ErrorMessage.GENERAL_WRITE_FAILED_TO_RENAME_TO_ORIGINAL_FILE;
                var31_57 = new Object[]{var1_1.getFile().getPath(), var7_6.getPath()};
                var29_55.warning(var30_56.getMsg(var31_57));
                var32_58 = new Object[]{var1_1.getFile().getPath(), var7_6.getPath()};
                throw new CannotWriteException(var30_56.getMsg(var32_58));
lbl160: // 1 sources:
                var14_59 = AudioFileWriter.logger;
                var15_60 = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_ORIGINAL_FILE;
                var16_61 = new Object[]{var1_1.getFile().getPath(), var7_6.getPath()};
                var14_59.warning(var15_60.getMsg(var16_61));
                var17_62 = new Object[]{var1_1.getFile().getPath(), var7_6.getPath()};
                throw new CannotWriteException(var15_60.getMsg(var17_62));
lbl166: // 1 sources:
                if (!var7_6.delete()) {
                    var36_63 = AudioFileWriter.logger;
                    var37_64 = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE;
                    var38_65 = new Object[]{var7_6.getPath()};
                    var36_63.warning(var37_64.getMsg(var38_65));
                }
                ** GOTO lbl183
            }
lbl173: // 2 sources:
            do {
                var19_66 = AudioFileWriter.logger;
                var20_67 = new StringBuilder();
                var20_67.append("AudioFileWriter exception cleaning up delete:");
                var20_67.append(var1_1.getFile().getPath());
                var20_67.append(" or");
                var20_67.append(var7_6.getAbsolutePath());
                var20_67.append(":");
                var20_67.append((Object)var18_53);
                var19_66.severe(var20_67.toString());
lbl183: // 2 sources:
                var7_6 = var13_47;
lbl184: // 2 sources:
                if ((var27_68 = this.modificationListener) != null) {
                    var27_68.fileOperationFinished(var7_6);
                }
                throw var11_35;
                break;
            } while (true);
        }
        var3_69 = ErrorMessage.GENERAL_DELETE_FAILED_BECAUSE_FILE_IS_TOO_SMALL;
        var4_70 = new Object[]{var2_2.getPath()};
        throw new CannotWriteException(var3_69.getMsg(var4_70));
    }

    public void delete(Tag tag, RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2) throws CannotReadException, CannotWriteException, IOException {
        randomAccessFile.seek(0L);
        randomAccessFile2.seek(0L);
        this.deleteTag(tag, randomAccessFile, randomAccessFile2);
    }

    protected abstract void deleteTag(Tag var1, RandomAccessFile var2, RandomAccessFile var3) throws CannotReadException, CannotWriteException, IOException;

    public void setAudioFileModificationListener(AudioFileModificationListener audioFileModificationListener) {
        this.modificationListener = audioFileModificationListener;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public void write(AudioFile audioFile) throws CannotWriteException {
        IOException iOException2;
        block32 : {
            File file;
            void var56_45;
            RandomAccessFile randomAccessFile;
            block34 : {
                Throwable throwable2;
                RandomAccessFile randomAccessFile2;
                RandomAccessFile randomAccessFile3;
                block33 : {
                    Logger logger = AudioFileWriter.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Started writing tag data for file:");
                    stringBuilder.append(audioFile.getFile().getName());
                    logger.config(stringBuilder.toString());
                    this.precheckWrite(audioFile);
                    if (audioFile instanceof MP3File) {
                        audioFile.commit();
                        return;
                    }
                    randomAccessFile = null;
                    try {
                        file = File.createTempFile((String)audioFile.getFile().getName().replace('.', '_'), (String)".tmp", (File)audioFile.getFile().getParentFile());
                    }
                    catch (IOException iOException2) {
                        if (!iOException2.getMessage().equals((Object)"File name too long") || audioFile.getFile().getName().length() <= 50) break block32;
                        file = File.createTempFile((String)audioFile.getFile().getName().substring(0, 50).replace('.', '_'), (String)".tmp", (File)audioFile.getFile().getParentFile());
                    }
                    randomAccessFile3 = new RandomAccessFile(file, "rw");
                    try {
                        randomAccessFile2 = new RandomAccessFile(audioFile.getFile(), "rw");
                    }
                    catch (IOException iOException3) {
                        randomAccessFile = randomAccessFile3;
                        break block34;
                    }
                    randomAccessFile2.seek(0L);
                    randomAccessFile3.seek(0L);
                    AudioFileModificationListener audioFileModificationListener = this.modificationListener;
                    if (audioFileModificationListener != null) {
                        audioFileModificationListener.fileWillBeModified(audioFile, false);
                    }
                    this.writeTag(audioFile, audioFile.getTag(), randomAccessFile2, randomAccessFile3);
                    AudioFileModificationListener audioFileModificationListener2 = this.modificationListener;
                    if (audioFileModificationListener2 == null) break block33;
                    audioFileModificationListener2.fileModified(audioFile, file);
                }
                try {
                    randomAccessFile2.close();
                    randomAccessFile3.close();
                }
                catch (IOException iOException4) {
                    Logger logger = AudioFileWriter.logger;
                    Level level = Level.WARNING;
                    ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_PROBLEM_CLOSING_FILE_HANDLE;
                    Object[] arrobject = new Object[]{audioFile.getFile().getAbsolutePath(), iOException4.getMessage()};
                    logger.log(level, errorMessage.getMsg(arrobject), (Throwable)iOException4);
                }
                File file2 = audioFile.getFile();
                if (file.length() > 0L) {
                    this.transferNewFileToOriginalFile(file, audioFile.getFile(), TagOptionSingleton.getInstance().isPreserveFileIdentity());
                } else if (!file.delete()) {
                    Logger logger = AudioFileWriter.logger;
                    ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE;
                    Object[] arrobject = new Object[]{file.getPath()};
                    logger.warning(errorMessage.getMsg(arrobject));
                }
                AudioFileModificationListener audioFileModificationListener = this.modificationListener;
                if (audioFileModificationListener != null) {
                    audioFileModificationListener.fileOperationFinished(file2);
                }
                return;
                {
                    catch (ModifyVetoException modifyVetoException) {
                        try {
                            throw new CannotWriteException((Throwable)modifyVetoException);
                        }
                        catch (Exception exception) {
                            Logger logger = AudioFileWriter.logger;
                            Level level = Level.SEVERE;
                            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_BECAUSE;
                            Object[] arrobject = new Object[]{audioFile.getFile(), exception.getMessage()};
                            logger.log(level, errorMessage.getMsg(arrobject), (Throwable)exception);
                            try {
                                randomAccessFile2.close();
                                randomAccessFile3.close();
                            }
                            catch (IOException iOException5) {
                                Logger logger2 = AudioFileWriter.logger;
                                Level level2 = Level.WARNING;
                                ErrorMessage errorMessage2 = ErrorMessage.GENERAL_WRITE_PROBLEM_CLOSING_FILE_HANDLE;
                                Object[] arrobject2 = new Object[]{audioFile.getFile().getAbsolutePath(), iOException5.getMessage()};
                                logger2.log(level2, errorMessage2.getMsg(arrobject2), (Throwable)iOException5);
                            }
                            if (!file.delete()) {
                                Logger logger3 = AudioFileWriter.logger;
                                ErrorMessage errorMessage3 = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE;
                                Object[] arrobject3 = new Object[]{file.getAbsolutePath()};
                                logger3.warning(errorMessage3.getMsg(arrobject3));
                            }
                            ErrorMessage errorMessage4 = ErrorMessage.GENERAL_WRITE_FAILED_BECAUSE;
                            Object[] arrobject4 = new Object[]{audioFile.getFile(), exception.getMessage()};
                            throw new CannotWriteException(errorMessage4.getMsg(arrobject4));
                        }
                        catch (Throwable throwable2) {}
                        {
                        }
                    }
                }
                try {
                    randomAccessFile2.close();
                    randomAccessFile3.close();
                }
                catch (IOException iOException6) {
                    Logger logger = AudioFileWriter.logger;
                    Level level = Level.WARNING;
                    ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_PROBLEM_CLOSING_FILE_HANDLE;
                    Object[] arrobject = new Object[]{audioFile.getFile().getAbsolutePath(), iOException6.getMessage()};
                    logger.log(level, errorMessage.getMsg(arrobject), (Throwable)iOException6);
                }
                throw throwable2;
                catch (IOException iOException7) {
                    // empty catch block
                }
            }
            Logger logger = AudioFileWriter.logger;
            Level level = Level.SEVERE;
            ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING;
            Object[] arrobject = new Object[]{audioFile.getFile().getAbsolutePath()};
            logger.log(level, errorMessage.getMsg(arrobject), (Throwable)var56_45);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                }
                catch (IOException iOException8) {
                    Logger logger4 = AudioFileWriter.logger;
                    Level level3 = Level.WARNING;
                    ErrorMessage errorMessage5 = ErrorMessage.GENERAL_WRITE_PROBLEM_CLOSING_FILE_HANDLE;
                    Object[] arrobject5 = new Object[]{audioFile.getFile(), var56_45.getMessage()};
                    logger4.log(level3, errorMessage5.getMsg(arrobject5), (Throwable)iOException8);
                }
            }
            if (!file.delete()) {
                Logger logger5 = AudioFileWriter.logger;
                ErrorMessage errorMessage6 = ErrorMessage.GENERAL_WRITE_FAILED_TO_DELETE_TEMPORARY_FILE;
                Object[] arrobject6 = new Object[]{file.getAbsolutePath()};
                logger5.warning(errorMessage6.getMsg(arrobject6));
            }
            ErrorMessage errorMessage7 = ErrorMessage.GENERAL_WRITE_FAILED_TO_OPEN_FILE_FOR_EDITING;
            Object[] arrobject7 = new Object[]{audioFile.getFile().getAbsolutePath()};
            throw new CannotWriteException(errorMessage7.getMsg(arrobject7));
            {
                catch (IOException iOException9) {
                    Logger logger6 = AudioFileWriter.logger;
                    Level level4 = Level.SEVERE;
                    ErrorMessage errorMessage8 = ErrorMessage.GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER;
                    Object[] arrobject8 = new Object[]{audioFile.getFile().getName(), audioFile.getFile().getParentFile().getAbsolutePath()};
                    logger6.log(level4, errorMessage8.getMsg(arrobject8), (Throwable)iOException9);
                    Object[] arrobject9 = new Object[]{audioFile.getFile().getName(), audioFile.getFile().getParentFile().getAbsolutePath()};
                    throw new CannotWriteException(errorMessage8.getMsg(arrobject9));
                }
            }
        }
        Logger logger = AudioFileWriter.logger;
        Level level = Level.SEVERE;
        ErrorMessage errorMessage = ErrorMessage.GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER;
        Object[] arrobject = new Object[]{audioFile.getFile().getName(), audioFile.getFile().getParentFile().getAbsolutePath()};
        logger.log(level, errorMessage.getMsg(arrobject), (Throwable)iOException2);
        Object[] arrobject10 = new Object[]{audioFile.getFile().getName(), audioFile.getFile().getParentFile().getAbsolutePath()};
        throw new CannotWriteException(errorMessage.getMsg(arrobject10));
    }

    protected abstract void writeTag(AudioFile var1, Tag var2, RandomAccessFile var3, RandomAccessFile var4) throws CannotReadException, CannotWriteException, IOException;
}

