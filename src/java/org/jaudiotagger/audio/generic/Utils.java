/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.DataInput
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.nio.channels.WritableByteChannel
 *  java.nio.charset.Charset
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.generic;

import java.io.Closeable;
import java.io.DataInput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.utils.FileTypeUtil;

public class Utils {
    public static int BITS_IN_BYTE_MULTIPLIER = 8;
    public static int KILOBYTE_MULTIPLIER = 1000;
    private static final int MAX_BASE_TEMP_FILENAME_LENGTH = 20;
    private static final Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.generic.utils");

    public static boolean copy(File file, File file2) {
        try {
            Utils.copyThrowsOnException(file, file2);
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void copyThrowsOnException(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileOutputStream fileOutputStream;
        long l2;
        FileInputStream fileInputStream2;
        long l3;
        block7 : {
            void var5_12;
            FileInputStream fileInputStream;
            block9 : {
                block8 : {
                    fileInputStream = null;
                    fileInputStream2 = new FileInputStream(file);
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        fileChannel = fileInputStream2.getChannel();
                        fileChannel2 = fileOutputStream.getChannel();
                        l2 = fileChannel.size();
                        break block7;
                    }
                    catch (Throwable throwable) {
                        break block8;
                    }
                    catch (Throwable throwable) {
                        fileOutputStream = null;
                    }
                }
                fileInputStream = fileInputStream2;
                break block9;
                catch (Throwable throwable) {
                    fileOutputStream = null;
                }
            }
            AudioFileIO.closeQuietly(new Closeable[]{fileInputStream, fileOutputStream});
            throw var5_12;
        }
        for (long i2 = 0L; i2 < l2; i2 += l3) {
            l3 = fileChannel.transferTo(i2, 0x100000L, (WritableByteChannel)fileChannel2);
        }
        AudioFileIO.closeQuietly(new Closeable[]{fileInputStream2, fileOutputStream});
    }

    public static String getBaseFilenameForTempFile(File file) {
        String string2 = Utils.getMinBaseFilenameAllowedForTempFile(file);
        if (string2.length() <= 20) {
            return string2;
        }
        return string2.substring(0, 20);
    }

    public static String getExtension(File file) {
        String string2 = file.getName().toLowerCase();
        int n2 = string2.lastIndexOf(".");
        if (n2 == -1) {
            return "";
        }
        return string2.substring(n2 + 1);
    }

    public static int getIntBE(ByteBuffer byteBuffer, int n2, int n3) {
        return (int)Utils.getLongBE(byteBuffer, n2, n3);
    }

    public static int getIntLE(byte[] arrby) {
        return (int)Utils.getLongLE(ByteBuffer.wrap((byte[])arrby), 0, -1 + arrby.length);
    }

    public static int getIntLE(byte[] arrby, int n2, int n3) {
        return (int)Utils.getLongLE(ByteBuffer.wrap((byte[])arrby), n2, n3);
    }

    public static long getLongBE(ByteBuffer byteBuffer, int n2, int n3) {
        long l2 = 0L;
        for (int i2 = 0; i2 < 1 + (n3 - n2); ++i2) {
            l2 += (long)(255 & byteBuffer.get(n3 - i2)) << i2 * 8;
        }
        return l2;
    }

    public static long getLongLE(ByteBuffer byteBuffer, int n2, int n3) {
        long l2 = 0L;
        for (int i2 = 0; i2 < 1 + (n3 - n2); ++i2) {
            l2 += (long)((255 & byteBuffer.get(n2 + i2)) << i2 * 8);
        }
        return l2;
    }

    public static String getMagicExtension(File file) throws IOException {
        return FileTypeUtil.getMagicExt(FileTypeUtil.getMagicFileType(file));
    }

    public static String getMinBaseFilenameAllowedForTempFile(File file) {
        String string2 = AudioFile.getBaseFilename(file);
        if (string2.length() >= 3) {
            return string2;
        }
        if (string2.length() == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("000");
            return stringBuilder.toString();
        }
        if (string2.length() == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("00");
            return stringBuilder.toString();
        }
        if (string2.length() == 2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("0");
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static short getShortBE(ByteBuffer byteBuffer, int n2, int n3) {
        return (short)Utils.getIntBE(byteBuffer, n2, n3);
    }

    public static byte[] getSizeBEInt16(short s2) {
        byte[] arrby = new byte[]{(byte)(255 & s2 >> 8), (byte)(s2 & 255)};
        return arrby;
    }

    public static byte[] getSizeBEInt32(int n2) {
        byte[] arrby = new byte[]{(byte)(255 & n2 >> 24), (byte)(255 & n2 >> 16), (byte)(255 & n2 >> 8), (byte)(n2 & 255)};
        return arrby;
    }

    public static byte[] getSizeLEInt32(int n2) {
        byte[] arrby = new byte[]{(byte)(n2 & 255), (byte)(255L & (long)(n2 >>> 8)), (byte)(255L & (long)(n2 >>> 16)), (byte)(255L & (long)(n2 >>> 24))};
        return arrby;
    }

    public static String getString(ByteBuffer byteBuffer, int n2, int n3, Charset charset) {
        byte[] arrby = new byte[n3];
        byteBuffer.position(n2 + byteBuffer.position());
        byteBuffer.get(arrby);
        return new String(arrby, 0, n3, charset);
    }

    public static String getString(ByteBuffer byteBuffer, Charset charset) {
        int n2 = byteBuffer.remaining();
        byte[] arrby = new byte[n2];
        byteBuffer.get(arrby);
        return new String(arrby, 0, n2, charset);
    }

    public static boolean isOddLength(long l2) {
        return (l2 & 1L) != 0L;
    }

    public static ByteBuffer readFileDataIntoBufferBE(FileChannel fileChannel, int n2) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)n2);
        fileChannel.read(byteBuffer);
        byteBuffer.position(0);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        return byteBuffer;
    }

    public static ByteBuffer readFileDataIntoBufferLE(FileChannel fileChannel, int n2) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)n2);
        fileChannel.read(byteBuffer);
        byteBuffer.position(0);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer;
    }

    public static String readFourBytesAsChars(ByteBuffer byteBuffer) {
        byte[] arrby = new byte[4];
        byteBuffer.get(arrby);
        return new String(arrby, StandardCharsets.ISO_8859_1);
    }

    public static String readPascalString(ByteBuffer byteBuffer) throws IOException {
        int n2 = Utils.u(byteBuffer.get());
        byte[] arrby = new byte[n2];
        byteBuffer.get(arrby);
        return new String(arrby, 0, n2, StandardCharsets.ISO_8859_1);
    }

    public static String readString(DataInput dataInput, int n2) throws IOException {
        byte[] arrby = new byte[n2];
        dataInput.readFully(arrby);
        return new String(arrby, StandardCharsets.US_ASCII);
    }

    public static String readThreeBytesAsChars(ByteBuffer byteBuffer) {
        byte[] arrby = new byte[3];
        byteBuffer.get(arrby);
        return new String(arrby, StandardCharsets.ISO_8859_1);
    }

    public static int readUint16(DataInput dataInput) throws IOException {
        byte[] arrby = new byte[]{0, 0, 0, 0};
        dataInput.readFully(arrby, 2, 2);
        return ByteBuffer.wrap((byte[])arrby).getInt();
    }

    public static long readUint32(DataInput dataInput) throws IOException {
        byte[] arrby = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
        dataInput.readFully(arrby, 4, 4);
        return ByteBuffer.wrap((byte[])arrby).getLong();
    }

    public static boolean rename(File file, File file2) {
        Logger logger = Utils.logger;
        Level level = Level.CONFIG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Renaming From:");
        stringBuilder.append(file.getAbsolutePath());
        stringBuilder.append(" to ");
        stringBuilder.append(file2.getAbsolutePath());
        logger.log(level, stringBuilder.toString());
        if (file2.exists()) {
            Level level2 = Level.SEVERE;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Destination File:");
            stringBuilder2.append((Object)file2);
            stringBuilder2.append(" already exists");
            logger.log(level2, stringBuilder2.toString());
            return false;
        }
        if (!file.renameTo(file2)) {
            if (Utils.copy(file, file2)) {
                if (!file.delete()) {
                    Level level3 = Level.SEVERE;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Unable to delete File:");
                    stringBuilder3.append((Object)file);
                    logger.log(level3, stringBuilder3.toString());
                    file2.delete();
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public static int u(byte by) {
        return by & 255;
    }

    public static int u(short s2) {
        return s2 & 65535;
    }

    public static long u(int n2) {
        return 0xFFFFFFFFL & (long)n2;
    }
}

