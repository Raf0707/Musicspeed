/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.math.BigInteger
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  org.jaudiotagger.audio.asf.data.AsfHeader
 */
package org.jaudiotagger.audio.asf.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.GregorianCalendar;
import org.jaudiotagger.audio.asf.data.AsfHeader;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.logging.ErrorMessage;

public class Utils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final long DIFF_BETWEEN_ASF_DATE_AND_JAVA_DATE = 11644470000000L;
    public static final String LINE_SEPARATOR = System.getProperty((String)"line.separator");
    private static final int MAXIMUM_STRING_LENGTH_ALLOWED = 32766;

    public static void checkStringLengthNullSafe(String string2) throws IllegalArgumentException {
        if (string2 != null) {
            if (string2.length() <= 32766) {
                return;
            }
            ErrorMessage errorMessage = ErrorMessage.WMA_LENGTH_OF_STRING_IS_TOO_LARGE;
            Object[] arrobject = new Object[]{2 * string2.length()};
            throw new IllegalArgumentException(errorMessage.getMsg(arrobject));
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, long l2) throws IOException {
        int n2;
        byte[] arrby = new byte[8192];
        for (long i2 = 0L; i2 < l2; i2 += (long)n2) {
            long l3 = l2 - i2;
            int n3 = l3 < 8192L ? (int)l3 : 8192;
            n2 = inputStream.read(arrby, 0, n3);
            if (n2 != -1) {
                outputStream.write(arrby, 0, n2);
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Inputstream has to continue for another ");
            stringBuilder.append(l3);
            stringBuilder.append(" bytes.");
            throw new IOException(stringBuilder.toString());
        }
    }

    public static void flush(InputStream inputStream, OutputStream outputStream) throws IOException {
        int n2;
        byte[] arrby = new byte[8192];
        while ((n2 = inputStream.read(arrby)) != -1) {
            outputStream.write(arrby, 0, n2);
        }
    }

    public static byte[] getBytes(long l2, int n2) {
        byte[] arrby = new byte[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            arrby[i2] = (byte)(255L & l2 >>> i2 * 8);
        }
        return arrby;
    }

    public static byte[] getBytes(String string2, Charset charset) {
        ByteBuffer byteBuffer = charset.encode(string2);
        byte[] arrby = new byte[byteBuffer.limit()];
        byteBuffer.rewind();
        byteBuffer.get(arrby);
        return arrby;
    }

    public static GregorianCalendar getDateOf(BigInteger bigInteger) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date(bigInteger.divide(new BigInteger("10")).longValue() - 11644470000000L));
        return gregorianCalendar;
    }

    public static boolean isBlank(String string2) {
        if (string2 == null) {
            return true;
        }
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            if (Character.isWhitespace((char)string2.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public static boolean isStringLengthValidNullSafe(String string2) {
        return string2 == null || string2.length() <= 32766;
    }

    public static BigInteger readBig64(InputStream inputStream) throws IOException {
        byte[] arrby = new byte[8];
        byte[] arrby2 = new byte[8];
        if (inputStream.read(arrby) == 8) {
            for (int i2 = 0; i2 < 8; ++i2) {
                arrby2[7 - i2] = arrby[i2];
            }
            return new BigInteger(arrby2);
        }
        throw new EOFException();
    }

    public static byte[] readBinary(InputStream inputStream, long l2) throws IOException {
        byte[] arrby = new byte[(int)l2];
        inputStream.read(arrby);
        return arrby;
    }

    public static String readCharacterSizedString(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = Utils.readUINT16(inputStream);
        int n3 = inputStream.read() | inputStream.read() << 8;
        do {
            if (n3 == 0) continue;
            stringBuilder.append((char)n3);
            n3 = inputStream.read() | inputStream.read() << 8;
        } while (n3 != 0 || 1 + stringBuilder.length() > n2);
        if (n2 == 1 + stringBuilder.length()) {
            return stringBuilder.toString();
        }
        throw new IllegalStateException("Invalid Data for current interpretation");
    }

    public static String readFixedSizeUTF16Str(InputStream inputStream, int n2) throws IOException {
        byte[] arrby = new byte[n2];
        if (inputStream.read(arrby) == n2) {
            int n3;
            if (n2 >= 2 && arrby[n2 - 1] == 0 && arrby[n3 = n2 - 2] == 0) {
                byte[] arrby2 = new byte[n3];
                System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)n3);
                arrby = arrby2;
            }
            return new String(arrby, "UTF-16LE");
        }
        throw new IllegalStateException("Couldn't read the necessary amount of bytes.");
    }

    public static GUID readGUID(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            int[] arrn = new int[16];
            for (int i2 = 0; i2 < 16; ++i2) {
                arrn[i2] = inputStream.read();
            }
            return new GUID(arrn);
        }
        throw new IllegalArgumentException("Argument must not be null");
    }

    public static int readUINT16(InputStream inputStream) throws IOException {
        return inputStream.read() | inputStream.read() << 8;
    }

    public static long readUINT32(InputStream inputStream) throws IOException {
        long l2 = 0L;
        for (int i2 = 0; i2 <= 24; i2 += 8) {
            l2 |= (long)inputStream.read() << i2;
        }
        return l2;
    }

    public static long readUINT64(InputStream inputStream) throws IOException {
        long l2 = 0L;
        for (int i2 = 0; i2 <= 56; i2 += 8) {
            l2 |= (long)inputStream.read() << i2;
        }
        return l2;
    }

    public static String readUTF16LEStr(InputStream inputStream) throws IOException {
        int n2;
        int n3 = Utils.readUINT16(inputStream);
        byte[] arrby = new byte[n3];
        int n4 = inputStream.read(arrby);
        if (n4 != n3 && (n3 != 0 || n4 != -1)) {
            throw new IllegalStateException("Invalid Data for current interpretation");
        }
        if (n3 >= 2 && arrby[n3 - 1] == 0 && arrby[n2 = n3 - 2] == 0) {
            byte[] arrby2 = new byte[n2];
            System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)n2);
            arrby = arrby2;
        }
        return new String(arrby, AsfHeader.ASF_CHARSET.name());
    }

    public static void writeUINT16(int n2, OutputStream outputStream) throws IOException {
        if (n2 >= 0) {
            byte[] arrby = new byte[2];
            for (int i2 = 0; i2 <= 8; i2 += 8) {
                arrby[i2 / 8] = (byte)(255 & n2 >> i2);
            }
            outputStream.write(arrby);
            return;
        }
        throw new IllegalArgumentException("positive value expected.");
    }

    public static void writeUINT32(long l2, OutputStream outputStream) throws IOException {
        if (l2 >= 0L) {
            byte[] arrby = new byte[4];
            for (int i2 = 0; i2 <= 24; i2 += 8) {
                arrby[i2 / 8] = (byte)(255L & l2 >> i2);
            }
            outputStream.write(arrby);
            return;
        }
        throw new IllegalArgumentException("positive value expected.");
    }

    public static void writeUINT64(long l2, OutputStream outputStream) throws IOException {
        if (l2 >= 0L) {
            byte[] arrby = new byte[8];
            for (int i2 = 0; i2 <= 56; i2 += 8) {
                arrby[i2 / 8] = (byte)(255L & l2 >> i2);
            }
            outputStream.write(arrby);
            return;
        }
        throw new IllegalArgumentException("positive value expected.");
    }
}

